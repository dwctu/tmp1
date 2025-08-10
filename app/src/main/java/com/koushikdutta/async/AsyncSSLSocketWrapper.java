package com.koushikdutta.async;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Pair;
import com.broadcom.bt.util.io.IOUtils;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.http.SSLEngineSNIConfigurator;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.async.wrapper.AsyncSocketWrapper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.jivesoftware.smack.util.TLSUtils;

/* loaded from: classes3.dex */
public class AsyncSSLSocketWrapper implements AsyncSocketWrapper, AsyncSSLSocket {
    private static final String LOGTAG = "AsyncSSLSocketWrapper";
    public static SSLContext defaultSSLContext;
    public static TrustManager[] trustAllManagers;
    public static SSLContext trustAllSSLContext;
    public static HostnameVerifier trustAllVerifier;
    public boolean clientMode;
    public final DataCallback dataCallback;
    public SSLEngine engine;
    public boolean finishedHandshake;
    public HandshakeCallback handshakeCallback;
    public HostnameVerifier hostnameVerifier;
    public DataCallback mDataCallback;
    public CompletedCallback mEndCallback;
    public Exception mEndException;
    public boolean mEnded;
    private String mHost;
    private int mPort;
    public BufferedDataSink mSink;
    public AsyncSocket mSocket;
    public boolean mUnwrapping;
    private boolean mWrapping;
    public WritableCallback mWriteableCallback;
    public X509Certificate[] peerCertificates;
    public final ByteBufferList pending = new ByteBufferList();
    public TrustManager[] trustManagers;
    public ByteBufferList writeList;

    /* renamed from: com.koushikdutta.async.AsyncSSLSocketWrapper$10, reason: invalid class name */
    public static class AnonymousClass10 implements ListenCallback {
        public final /* synthetic */ SSLEngineSNIConfigurator val$conf;
        public final /* synthetic */ ListenCallback val$handler;
        public final /* synthetic */ int val$port;
        public final /* synthetic */ SSLContext val$sslContext;

        public AnonymousClass10(int i, SSLEngineSNIConfigurator sSLEngineSNIConfigurator, SSLContext sSLContext, ListenCallback listenCallback) {
            this.val$port = i;
            this.val$conf = sSLEngineSNIConfigurator;
            this.val$sslContext = sSLContext;
            this.val$handler = listenCallback;
        }

        public static /* synthetic */ void a(AsyncSocket asyncSocket, ListenCallback listenCallback, Exception exc, AsyncSSLSocket asyncSSLSocket) {
            if (exc != null) {
                asyncSocket.close();
            } else {
                listenCallback.onAccepted(asyncSSLSocket);
            }
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onAccepted(final AsyncSocket asyncSocket) {
            int i = this.val$port;
            SSLEngine sSLEngineCreateEngine = this.val$conf.createEngine(this.val$sslContext, null, i);
            final ListenCallback listenCallback = this.val$handler;
            AsyncSSLSocketWrapper.handshake(asyncSocket, null, i, sSLEngineCreateEngine, null, null, false, new HandshakeCallback() { // from class: dc.a81
                @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
                public final void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                    AsyncSSLSocketWrapper.AnonymousClass10.a(asyncSocket, listenCallback, exc, asyncSSLSocket);
                }
            });
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            this.val$handler.onCompleted(exc);
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onListening(AsyncServerSocket asyncServerSocket) {
            this.val$handler.onListening(asyncServerSocket);
        }
    }

    public interface HandshakeCallback {
        void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket);
    }

    public static class ObjectHolder<T> {
        public T held;

        private ObjectHolder() {
        }
    }

    static {
        try {
        } catch (Exception e) {
            try {
                defaultSSLContext = SSLContext.getInstance(TLSUtils.TLS);
                defaultSSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.1
                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                        for (X509Certificate x509Certificate : x509CertificateArr) {
                            if (x509Certificate != null && x509Certificate.getCriticalExtensionOIDs() != null) {
                                x509Certificate.getCriticalExtensionOIDs().remove("2.5.29.15");
                            }
                        }
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }}, null);
            } catch (Exception e2) {
                e.printStackTrace();
                e2.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT <= 15) {
            throw new Exception();
        }
        defaultSSLContext = SSLContext.getInstance("Default");
        try {
            trustAllSSLContext = SSLContext.getInstance(TLSUtils.TLS);
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.2
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            trustAllManagers = trustManagerArr;
            trustAllSSLContext.init(null, trustManagerArr, null);
            trustAllVerifier = new HostnameVerifier() { // from class: dc.e81
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return AsyncSSLSocketWrapper.f(str, sSLSession);
                }
            };
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private AsyncSSLSocketWrapper(AsyncSocket asyncSocket, String str, int i, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z) {
        DataCallback dataCallback = new DataCallback() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.6
            public final Allocator allocator = new Allocator().setMinAlloc(8192);
            public final ByteBufferList buffered = new ByteBufferList();

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
                if (asyncSSLSocketWrapper.mUnwrapping) {
                    return;
                }
                try {
                    try {
                        asyncSSLSocketWrapper.mUnwrapping = true;
                        byteBufferList.get(this.buffered);
                        if (this.buffered.hasRemaining()) {
                            this.buffered.add(this.buffered.getAll());
                        }
                        ByteBuffer byteBufferRemove = ByteBufferList.EMPTY_BYTEBUFFER;
                        while (true) {
                            if (byteBufferRemove.remaining() == 0 && this.buffered.size() > 0) {
                                byteBufferRemove = this.buffered.remove();
                            }
                            int iRemaining = byteBufferRemove.remaining();
                            int iRemaining2 = AsyncSSLSocketWrapper.this.pending.remaining();
                            ByteBuffer byteBufferAllocate = this.allocator.allocate();
                            SSLEngineResult sSLEngineResultUnwrap = AsyncSSLSocketWrapper.this.engine.unwrap(byteBufferRemove, byteBufferAllocate);
                            AsyncSSLSocketWrapper asyncSSLSocketWrapper2 = AsyncSSLSocketWrapper.this;
                            asyncSSLSocketWrapper2.addToPending(asyncSSLSocketWrapper2.pending, byteBufferAllocate);
                            this.allocator.track(AsyncSSLSocketWrapper.this.pending.remaining() - iRemaining2);
                            if (sSLEngineResultUnwrap.getStatus() != SSLEngineResult.Status.BUFFER_OVERFLOW) {
                                if (sSLEngineResultUnwrap.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                                    AsyncSSLSocketWrapper.this.handleHandshakeStatus(sSLEngineResultUnwrap.getHandshakeStatus());
                                    if (byteBufferRemove.remaining() != iRemaining && iRemaining2 == AsyncSSLSocketWrapper.this.pending.remaining()) {
                                        this.buffered.addFirst(byteBufferRemove);
                                        break;
                                    }
                                } else {
                                    this.buffered.addFirst(byteBufferRemove);
                                    if (this.buffered.size() <= 1) {
                                        break;
                                    }
                                    this.buffered.addFirst(this.buffered.getAll());
                                    byteBufferRemove = ByteBufferList.EMPTY_BYTEBUFFER;
                                }
                            } else {
                                Allocator allocator = this.allocator;
                                allocator.setMinAlloc(allocator.getMinAlloc() * 2);
                            }
                            iRemaining = -1;
                            AsyncSSLSocketWrapper.this.handleHandshakeStatus(sSLEngineResultUnwrap.getHandshakeStatus());
                            if (byteBufferRemove.remaining() != iRemaining) {
                            }
                        }
                        AsyncSSLSocketWrapper.this.onDataAvailable();
                    } catch (SSLException e) {
                        AsyncSSLSocketWrapper.this.report(e);
                    }
                } finally {
                    AsyncSSLSocketWrapper.this.mUnwrapping = false;
                }
            }
        };
        this.dataCallback = dataCallback;
        this.writeList = new ByteBufferList();
        this.mSocket = asyncSocket;
        this.hostnameVerifier = hostnameVerifier;
        this.clientMode = z;
        this.trustManagers = trustManagerArr;
        this.engine = sSLEngine;
        this.mHost = str;
        this.mPort = i;
        sSLEngine.setUseClientMode(z);
        BufferedDataSink bufferedDataSink = new BufferedDataSink(asyncSocket);
        this.mSink = bufferedDataSink;
        bufferedDataSink.setWriteableCallback(new WritableCallback() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.4
            @Override // com.koushikdutta.async.callback.WritableCallback
            public void onWriteable() {
                WritableCallback writableCallback = AsyncSSLSocketWrapper.this.mWriteableCallback;
                if (writableCallback != null) {
                    writableCallback.onWriteable();
                }
            }
        });
        this.mSocket.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.5
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                CompletedCallback completedCallback;
                AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
                if (asyncSSLSocketWrapper.mEnded) {
                    return;
                }
                asyncSSLSocketWrapper.mEnded = true;
                asyncSSLSocketWrapper.mEndException = exc;
                if (asyncSSLSocketWrapper.pending.hasRemaining() || (completedCallback = AsyncSSLSocketWrapper.this.mEndCallback) == null) {
                    return;
                }
                completedCallback.onCompleted(exc);
            }
        });
        this.mSocket.setDataCallback(dataCallback);
    }

    public static /* synthetic */ void a(final SimpleCancellable simpleCancellable, final ConnectCallback connectCallback, String str, int i, boolean z, Exception exc, AsyncSocket asyncSocket) {
        if (exc == null) {
            handshake(asyncSocket, str, i, (z ? trustAllSSLContext : defaultSSLContext).createSSLEngine(str, i), z ? trustAllManagers : null, z ? trustAllVerifier : null, true, new HandshakeCallback() { // from class: dc.f81
                @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
                public final void onHandshakeCompleted(Exception exc2, AsyncSSLSocket asyncSSLSocket) {
                    AsyncSSLSocketWrapper.e(simpleCancellable, connectCallback, exc2, asyncSSLSocket);
                }
            });
        } else if (simpleCancellable.setComplete()) {
            connectCallback.onConnectCompleted(exc, null);
        }
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [T, com.koushikdutta.async.AsyncSSLServerSocket] */
    public static /* synthetic */ void b(Context context, String str, ObjectHolder objectHolder, AsyncServer asyncServer, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        try {
            Pair<KeyPair, Certificate> pairSelfSignCertificate = selfSignCertificate(context, str);
            KeyPair keyPair = (KeyPair) pairSelfSignCertificate.first;
            objectHolder.held = listenSecure(asyncServer, keyPair.getPrivate(), (Certificate) pairSelfSignCertificate.second, inetAddress, i, listenCallback);
        } catch (Exception e) {
            listenCallback.onCompleted(e);
        }
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [T, com.koushikdutta.async.AsyncSSLServerSocket] */
    public static /* synthetic */ void c(byte[] bArr, byte[] bArr2, ObjectHolder objectHolder, AsyncServer asyncServer, InetAddress inetAddress, int i, ListenCallback listenCallback) throws CertificateException {
        try {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr);
            objectHolder.held = listenSecure(asyncServer, KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpec), CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr2)), inetAddress, i, listenCallback);
        } catch (Exception e) {
            listenCallback.onCompleted(e);
        }
    }

    public static Cancellable connectSocket(AsyncServer asyncServer, String str, int i, ConnectCallback connectCallback) {
        return connectSocket(asyncServer, str, i, false, connectCallback);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [T, com.koushikdutta.async.AsyncSSLSocketWrapper$8] */
    public static /* synthetic */ void d(final PrivateKey privateKey, final Certificate certificate, AsyncServer asyncServer, InetAddress inetAddress, int i, ListenCallback listenCallback, ObjectHolder objectHolder) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setKeyEntry("key", privateKey, null, new Certificate[]{certificate});
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
            keyManagerFactory.init(keyStore, "".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance(TLSUtils.TLS);
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
            final AsyncServerSocket asyncServerSocketListenSecure = listenSecure(asyncServer, sSLContext, inetAddress, i, listenCallback);
            objectHolder.held = new AsyncSSLServerSocket() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.8
                @Override // com.koushikdutta.async.AsyncSSLServerSocket
                public Certificate getCertificate() {
                    return certificate;
                }

                @Override // com.koushikdutta.async.AsyncServerSocket
                public int getLocalPort() {
                    return asyncServerSocketListenSecure.getLocalPort();
                }

                @Override // com.koushikdutta.async.AsyncSSLServerSocket
                public PrivateKey getPrivateKey() {
                    return privateKey;
                }

                @Override // com.koushikdutta.async.AsyncServerSocket
                public void stop() {
                    asyncServerSocketListenSecure.stop();
                }
            };
        } catch (Exception e) {
            listenCallback.onCompleted(e);
        }
    }

    public static /* synthetic */ void e(SimpleCancellable simpleCancellable, ConnectCallback connectCallback, Exception exc, AsyncSSLSocket asyncSSLSocket) {
        if (!simpleCancellable.setComplete()) {
            if (asyncSSLSocket != null) {
                asyncSSLSocket.close();
            }
        } else if (exc != null) {
            connectCallback.onConnectCompleted(exc, null);
        } else {
            connectCallback.onConnectCompleted(null, asyncSSLSocket);
        }
    }

    public static /* synthetic */ boolean f(String str, SSLSession sSLSession) {
        return true;
    }

    public static SSLContext getDefaultSSLContext() {
        return defaultSSLContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHandshakeStatus(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException, AsyncSSLException {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.engine.getDelegatedTask().run();
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            write(this.writeList);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            this.dataCallback.onDataAvailable(this, new ByteBufferList());
        }
        try {
            if (this.finishedHandshake) {
                return;
            }
            if (this.engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                if (this.clientMode) {
                    boolean z = false;
                    try {
                        this.peerCertificates = (X509Certificate[]) this.engine.getSession().getPeerCertificates();
                        String str = this.mHost;
                        if (str != null) {
                            HostnameVerifier hostnameVerifier = this.hostnameVerifier;
                            if (hostnameVerifier == null) {
                                new StrictHostnameVerifier().verify(this.mHost, StrictHostnameVerifier.getCNs(this.peerCertificates[0]), StrictHostnameVerifier.getDNSSubjectAlts(this.peerCertificates[0]));
                            } else if (!hostnameVerifier.verify(str, this.engine.getSession())) {
                                throw new SSLException("hostname <" + this.mHost + "> has been denied");
                            }
                        }
                        e = null;
                        z = true;
                    } catch (SSLException e) {
                        e = e;
                    }
                    this.finishedHandshake = true;
                    if (!z) {
                        AsyncSSLException asyncSSLException = new AsyncSSLException(e);
                        report(asyncSSLException);
                        if (!asyncSSLException.getIgnore()) {
                            throw asyncSSLException;
                        }
                    }
                } else {
                    this.finishedHandshake = true;
                }
                this.handshakeCallback.onHandshakeCompleted(null, this);
                this.handshakeCallback = null;
                this.mSocket.setClosedCallback(null);
                getServer().post(new Runnable() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.7
                    @Override // java.lang.Runnable
                    public void run() {
                        WritableCallback writableCallback = AsyncSSLSocketWrapper.this.mWriteableCallback;
                        if (writableCallback != null) {
                            writableCallback.onWriteable();
                        }
                    }
                });
                onDataAvailable();
            }
        } catch (Exception e2) {
            report(e2);
        }
    }

    public static void handshake(AsyncSocket asyncSocket, String str, int i, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z, final HandshakeCallback handshakeCallback) {
        AsyncSSLSocketWrapper asyncSSLSocketWrapper = new AsyncSSLSocketWrapper(asyncSocket, str, i, sSLEngine, trustManagerArr, hostnameVerifier, z);
        asyncSSLSocketWrapper.handshakeCallback = handshakeCallback;
        asyncSocket.setClosedCallback(new CompletedCallback() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.3
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    handshakeCallback.onHandshakeCompleted(exc, null);
                } else {
                    handshakeCallback.onHandshakeCompleted(new SSLException("socket closed during handshake"), null);
                }
            }
        });
        try {
            asyncSSLSocketWrapper.engine.beginHandshake();
            asyncSSLSocketWrapper.handleHandshakeStatus(asyncSSLSocketWrapper.engine.getHandshakeStatus());
        } catch (SSLException e) {
            asyncSSLSocketWrapper.report(e);
        }
    }

    public static AsyncSSLServerSocket listenSecure(final Context context, final AsyncServer asyncServer, final String str, final InetAddress inetAddress, final int i, final ListenCallback listenCallback) throws InterruptedException {
        final ObjectHolder objectHolder = new ObjectHolder();
        asyncServer.run(new Runnable() { // from class: dc.c81
            @Override // java.lang.Runnable
            public final void run() {
                AsyncSSLSocketWrapper.b(context, str, objectHolder, asyncServer, inetAddress, i, listenCallback);
            }
        });
        return (AsyncSSLServerSocket) objectHolder.held;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(Exception exc) {
        HandshakeCallback handshakeCallback = this.handshakeCallback;
        if (handshakeCallback == null) {
            CompletedCallback endCallback = getEndCallback();
            if (endCallback != null) {
                endCallback.onCompleted(exc);
                return;
            }
            return;
        }
        this.handshakeCallback = null;
        this.mSocket.setDataCallback(new DataCallback.NullDataCallback());
        this.mSocket.end();
        this.mSocket.setClosedCallback(null);
        this.mSocket.close();
        handshakeCallback.onHandshakeCompleted(exc, null);
    }

    private static Certificate selfSign(KeyPair keyPair, String str) throws Exception {
        BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();
        Security.addProvider(bouncyCastleProvider);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Date date = new Date(jCurrentTimeMillis);
        X500Name x500Name = new X500Name("CN=" + str);
        BigInteger bigInteger = new BigInteger(Long.toString(jCurrentTimeMillis));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, 1);
        Date time = calendar.getTime();
        ContentSigner contentSignerBuild = new JcaContentSignerBuilder("SHA256WithRSA").build(keyPair.getPrivate());
        JcaX509v3CertificateBuilder jcaX509v3CertificateBuilder = new JcaX509v3CertificateBuilder(x500Name, bigInteger, date, time, x500Name, keyPair.getPublic());
        jcaX509v3CertificateBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, new BasicConstraints(true));
        return new JcaX509CertificateConverter().setProvider(bouncyCastleProvider).getCertificate(jcaX509v3CertificateBuilder.build(contentSignerBuild));
    }

    public static Pair<KeyPair, Certificate> selfSignCertificate(Context context, String str) throws Exception {
        KeyPair keyPairGenerateKeyPair;
        Certificate certificateSelfSign;
        File fileStreamPath = context.getFileStreamPath(str + "-key.txt");
        try {
            String[] strArrSplit = StreamUtility.readFile(fileStreamPath).split(IOUtils.LINE_SEPARATOR_UNIX);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(strArrSplit[0], 0));
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(strArrSplit[1], 0));
            certificateSelfSign = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(strArrSplit[2], 0)));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            keyPairGenerateKeyPair = new KeyPair(keyFactory.generatePublic(x509EncodedKeySpec), keyFactory.generatePrivate(pKCS8EncodedKeySpec));
        } catch (Exception unused) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            certificateSelfSign = selfSign(keyPairGenerateKeyPair, str);
            StreamUtility.writeFile(fileStreamPath, Base64.encodeToString(keyPairGenerateKeyPair.getPublic().getEncoded(), 2) + IOUtils.LINE_SEPARATOR_UNIX + Base64.encodeToString(keyPairGenerateKeyPair.getPrivate().getEncoded(), 2) + IOUtils.LINE_SEPARATOR_UNIX + Base64.encodeToString(certificateSelfSign.getEncoded(), 2));
        }
        return new Pair<>(keyPairGenerateKeyPair, certificateSelfSign);
    }

    public void addToPending(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        if (byteBuffer.hasRemaining()) {
            byteBufferList.add(byteBuffer);
        } else {
            ByteBufferList.reclaim(byteBuffer);
        }
    }

    public int calculateAlloc(int i) {
        int i2 = (i * 3) / 2;
        if (i2 == 0) {
            return 8192;
        }
        return i2;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.mSocket.close();
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        this.mSocket.end();
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.mSocket.getClosedCallback();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.mDataCallback;
    }

    @Override // com.koushikdutta.async.wrapper.DataEmitterWrapper
    public DataEmitter getDataEmitter() {
        return this.mSocket;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.mEndCallback;
    }

    public String getHost() {
        return this.mHost;
    }

    @Override // com.koushikdutta.async.AsyncSSLSocket
    public X509Certificate[] getPeerCertificates() {
        return this.peerCertificates;
    }

    public int getPort() {
        return this.mPort;
    }

    @Override // com.koushikdutta.async.AsyncSSLSocket
    public SSLEngine getSSLEngine() {
        return this.engine;
    }

    @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mSocket.getServer();
    }

    @Override // com.koushikdutta.async.wrapper.AsyncSocketWrapper
    public AsyncSocket getSocket() {
        return this.mSocket;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.mWriteableCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.mSocket.isChunked();
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.mSocket.isOpen();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.mSocket.isPaused();
    }

    public void onDataAvailable() {
        CompletedCallback completedCallback;
        Util.emitAllData(this, this.pending);
        if (!this.mEnded || this.pending.hasRemaining() || (completedCallback = this.mEndCallback) == null) {
            return;
        }
        completedCallback.onCompleted(this.mEndException);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.mSocket.pause();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.mSocket.resume();
        onDataAvailable();
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.mSocket.setClosedCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.mEndCallback = completedCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.mWriteableCallback = writableCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    @Override // com.koushikdutta.async.DataSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.koushikdutta.async.ByteBufferList r7) throws javax.net.ssl.SSLException {
        /*
            r6 = this;
            boolean r0 = r6.mWrapping
            if (r0 == 0) goto L5
            return
        L5:
            com.koushikdutta.async.BufferedDataSink r0 = r6.mSink
            int r0 = r0.remaining()
            if (r0 <= 0) goto Le
            return
        Le:
            r0 = 1
            r6.mWrapping = r0
            int r0 = r7.remaining()
            int r0 = r6.calculateAlloc(r0)
            java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)
            r1 = 0
            r2 = r1
        L1f:
            boolean r3 = r6.finishedHandshake
            if (r3 == 0) goto L2b
            int r3 = r7.remaining()
            if (r3 != 0) goto L2b
            goto L9a
        L2b:
            int r3 = r7.remaining()
            java.nio.ByteBuffer[] r4 = r7.getAllArray()     // Catch: javax.net.ssl.SSLException -> L7e
            javax.net.ssl.SSLEngine r5 = r6.engine     // Catch: javax.net.ssl.SSLException -> L7e
            javax.net.ssl.SSLEngineResult r2 = r5.wrap(r4, r0)     // Catch: javax.net.ssl.SSLException -> L7e
            r7.addAll(r4)     // Catch: javax.net.ssl.SSLException -> L7e
            r0.flip()     // Catch: javax.net.ssl.SSLException -> L7e
            com.koushikdutta.async.ByteBufferList r4 = r6.writeList     // Catch: javax.net.ssl.SSLException -> L7e
            r4.add(r0)     // Catch: javax.net.ssl.SSLException -> L7e
            com.koushikdutta.async.ByteBufferList r4 = r6.writeList     // Catch: javax.net.ssl.SSLException -> L7e
            int r4 = r4.remaining()     // Catch: javax.net.ssl.SSLException -> L7e
            if (r4 <= 0) goto L53
            com.koushikdutta.async.BufferedDataSink r4 = r6.mSink     // Catch: javax.net.ssl.SSLException -> L7e
            com.koushikdutta.async.ByteBufferList r5 = r6.writeList     // Catch: javax.net.ssl.SSLException -> L7e
            r4.write(r5)     // Catch: javax.net.ssl.SSLException -> L7e
        L53:
            int r0 = r0.capacity()     // Catch: javax.net.ssl.SSLException -> L7e
            javax.net.ssl.SSLEngineResult$Status r4 = r2.getStatus()     // Catch: javax.net.ssl.SSLException -> L7b
            javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch: javax.net.ssl.SSLException -> L7b
            if (r4 != r5) goto L67
            int r0 = r0 * 2
            java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch: javax.net.ssl.SSLException -> L7b
            r3 = -1
            goto L82
        L67:
            int r0 = r7.remaining()     // Catch: javax.net.ssl.SSLException -> L7b
            int r0 = r6.calculateAlloc(r0)     // Catch: javax.net.ssl.SSLException -> L7b
            java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch: javax.net.ssl.SSLException -> L7b
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = r2.getHandshakeStatus()     // Catch: javax.net.ssl.SSLException -> L7e
            r6.handleHandshakeStatus(r4)     // Catch: javax.net.ssl.SSLException -> L7e
            goto L82
        L7b:
            r4 = move-exception
            r0 = r1
            goto L7f
        L7e:
            r4 = move-exception
        L7f:
            r6.report(r4)
        L82:
            int r4 = r7.remaining()
            if (r3 != r4) goto L92
            if (r2 == 0) goto L9a
            javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = r2.getHandshakeStatus()
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP
            if (r3 != r4) goto L9a
        L92:
            com.koushikdutta.async.BufferedDataSink r3 = r6.mSink
            int r3 = r3.remaining()
            if (r3 == 0) goto L1f
        L9a:
            r7 = 0
            r6.mWrapping = r7
            com.koushikdutta.async.ByteBufferList.reclaim(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncSSLSocketWrapper.write(com.koushikdutta.async.ByteBufferList):void");
    }

    public static Cancellable connectSocket(AsyncServer asyncServer, final String str, final int i, final boolean z, final ConnectCallback connectCallback) {
        final SimpleCancellable simpleCancellable = new SimpleCancellable();
        simpleCancellable.setParent(asyncServer.connectSocket(str, i, new ConnectCallback() { // from class: dc.g81
            @Override // com.koushikdutta.async.callback.ConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                AsyncSSLSocketWrapper.a(simpleCancellable, connectCallback, str, i, z, exc, asyncSocket);
            }
        }));
        return simpleCancellable;
    }

    public static AsyncSSLServerSocket listenSecure(AsyncServer asyncServer, String str, String str2, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        return listenSecure(asyncServer, Base64.decode(str, 0), Base64.decode(str2, 0), inetAddress, i, listenCallback);
    }

    public static AsyncSSLServerSocket listenSecure(final AsyncServer asyncServer, final byte[] bArr, final byte[] bArr2, final InetAddress inetAddress, final int i, final ListenCallback listenCallback) throws InterruptedException {
        final ObjectHolder objectHolder = new ObjectHolder();
        asyncServer.run(new Runnable() { // from class: dc.b81
            @Override // java.lang.Runnable
            public final void run() throws CertificateException {
                AsyncSSLSocketWrapper.c(bArr, bArr2, objectHolder, asyncServer, inetAddress, i, listenCallback);
            }
        });
        return (AsyncSSLServerSocket) objectHolder.held;
    }

    public static AsyncSSLServerSocket listenSecure(final AsyncServer asyncServer, final PrivateKey privateKey, final Certificate certificate, final InetAddress inetAddress, final int i, final ListenCallback listenCallback) throws InterruptedException {
        final ObjectHolder objectHolder = new ObjectHolder();
        asyncServer.run(new Runnable() { // from class: dc.d81
            @Override // java.lang.Runnable
            public final void run() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
                AsyncSSLSocketWrapper.d(privateKey, certificate, asyncServer, inetAddress, i, listenCallback, objectHolder);
            }
        });
        return (AsyncSSLServerSocket) objectHolder.held;
    }

    public static AsyncServerSocket listenSecure(AsyncServer asyncServer, SSLContext sSLContext, InetAddress inetAddress, int i, ListenCallback listenCallback) {
        return asyncServer.listen(inetAddress, i, new AnonymousClass10(i, new SSLEngineSNIConfigurator() { // from class: com.koushikdutta.async.AsyncSSLSocketWrapper.9
            @Override // com.koushikdutta.async.http.SSLEngineSNIConfigurator, com.koushikdutta.async.http.AsyncSSLEngineConfigurator
            public SSLEngine createEngine(SSLContext sSLContext2, String str, int i2) {
                SSLEngine sSLEngineCreateEngine = super.createEngine(sSLContext2, str, i2);
                sSLEngineCreateEngine.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"});
                return sSLEngineCreateEngine;
            }
        }, sSLContext, listenCallback));
    }
}
