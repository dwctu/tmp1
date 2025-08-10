package dc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncNetworkSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;
import com.wear.bean.CheckCertificateRenewal;
import com.wear.bean.response.BaseResponseStringBean;
import com.wear.bean.server.base.MessageType;
import com.wear.bean.server.bean.E010Bean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.BindException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.apache.commons.codec.binary.Base64;
import org.jivesoftware.smack.util.TLSUtils;
import rx.Subscription;

/* compiled from: TWSocketServer.java */
/* loaded from: classes3.dex */
public class kf2 extends if2<AsyncHttpServer> {
    public static String v = "ssl_certificate_pwd";
    public static String w = "ssl_certificate_filename";
    public static kf2 x = null;
    public static String y = "没有证书可以更新";
    public int m;
    public WeakReference<ef2> s;
    public Subscription t;
    public Subscription u;
    public boolean k = true;
    public String l = kf2.class.getSimpleName();
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public Handler r = new Handler(Looper.getMainLooper());

    /* compiled from: TWSocketServer.java */
    public class a implements HttpServerRequestCallback {
        public a(kf2 kf2Var) {
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            asyncHttpServerResponse.getHeaders().add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            asyncHttpServerResponse.getHeaders().add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "X-PINGOTHER, Content-Type");
            asyncHttpServerResponse.getHeaders().add("Access-Control-Allow-Private-Network", "true");
            asyncHttpServerResponse.getHeaders().add("callback-push-version", "1.0.1");
            ff2.n().x(asyncHttpServerResponse, true, null, 200, "", null);
        }
    }

    /* compiled from: TWSocketServer.java */
    public class b implements HttpServerRequestCallback {
        public b() {
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            ff2.n().o(kf2.this.k, asyncHttpServerRequest, asyncHttpServerResponse);
        }
    }

    /* compiled from: TWSocketServer.java */
    public class c implements Runnable {
        public final /* synthetic */ ef2 a;

        public c(ef2 ef2Var) {
            this.a = ef2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            kf2.this.m = 2;
            ef2 ef2Var = this.a;
            kf2 kf2Var = kf2.this;
            ef2Var.c(kf2Var.e, kf2Var.b);
        }
    }

    /* compiled from: TWSocketServer.java */
    public class d implements yn2<String> {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws InterruptedException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
            BaseResponseStringBean baseResponseStringBean;
            if (!WearUtils.e1(str) && (baseResponseStringBean = (BaseResponseStringBean) WearUtils.A.fromJson(str, BaseResponseStringBean.class)) != null) {
                if (baseResponseStringBean.result) {
                    CheckCertificateRenewal checkCertificateRenewal = (CheckCertificateRenewal) WearUtils.A.fromJson(qx.a((String) baseResponseStringBean.data), CheckCertificateRenewal.class);
                    if (checkCertificateRenewal != null) {
                        String certificatePwd = checkCertificateRenewal.getCertificatePwd();
                        if (!TextUtils.isEmpty(certificatePwd)) {
                            kf2.this.j(this.a, checkCertificateRenewal.getDownloadToken(), certificatePwd);
                            return;
                        }
                    }
                } else if (baseResponseStringBean.message.contains(kf2.y)) {
                    File fileZ0 = WearUtils.z0("mybks");
                    if (fileZ0.exists()) {
                        WearUtils.z(fileZ0);
                    }
                    File fileE0 = WearUtils.e0("mybks");
                    if (fileE0.exists()) {
                        WearUtils.z(fileE0);
                    }
                }
            }
            kf2 kf2Var = kf2.this;
            kf2Var.z((AsyncHttpServer) kf2Var.f);
            kf2 kf2Var2 = kf2.this;
            kf2Var2.A((AsyncHttpServer) kf2Var2.f);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) throws InterruptedException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
            kf2 kf2Var = kf2.this;
            kf2Var.z((AsyncHttpServer) kf2Var.f);
            kf2 kf2Var2 = kf2.this;
            kf2Var2.A((AsyncHttpServer) kf2Var2.f);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: TWSocketServer.java */
    public class e implements xn2<byte[]> {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(byte[] bArr) throws InterruptedException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
            try {
                new FileOutputStream(WearUtils.z0("certificate.zip")).write(bArr);
                int i = 0;
                hh3.b(WearUtils.z0("certificate.zip"), WearUtils.z0("mybks"), false);
                File fileZ0 = WearUtils.z0("mybks");
                String name = "";
                if (fileZ0.exists()) {
                    while (true) {
                        File[] fileArrListFiles = fileZ0.listFiles();
                        Objects.requireNonNull(fileArrListFiles);
                        if (i >= fileArrListFiles.length) {
                            break;
                        }
                        File[] fileArrListFiles2 = fileZ0.listFiles();
                        Objects.requireNonNull(fileArrListFiles2);
                        name = fileArrListFiles2[i].getName();
                        if (!TextUtils.isEmpty(name)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                eg3.i(WearUtils.x, kf2.v, qx.b(this.a));
                eg3.i(WearUtils.x, kf2.w, name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            kf2 kf2Var = kf2.this;
            kf2Var.z((AsyncHttpServer) kf2Var.f);
            kf2 kf2Var2 = kf2.this;
            kf2Var2.A((AsyncHttpServer) kf2Var2.f);
        }

        @Override // dc.xn2
        public void onCompleted() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.xn2, dc.zn2
        public void onError(NetException netException) throws InterruptedException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
            kf2 kf2Var = kf2.this;
            kf2Var.z((AsyncHttpServer) kf2Var.f);
            kf2 kf2Var2 = kf2.this;
            kf2Var2.A((AsyncHttpServer) kf2Var2.f);
        }

        @Override // dc.xn2
        public void onStart() {
        }
    }

    public kf2() {
        this.b = 20010;
        this.c = 30010;
        this.e = WearUtils.f0();
        this.m = 0;
    }

    public static kf2 m() {
        if (x == null) {
            synchronized (kf2.class) {
                if (x == null) {
                    x = new kf2();
                }
            }
        }
        return x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(ef2 ef2Var, Exception exc) {
        this.r.removeCallbacksAndMessages(null);
        if (exc instanceof BindException) {
            this.k = false;
            return;
        }
        this.m = 0;
        if (ef2Var != null) {
            ef2Var.b(new Exception(exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.wear.bean.server.bean.E010Bean$E010Data] */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
        if ((webSocket == null || !(webSocket.getSocket() instanceof AsyncNetworkSocket)) && !(webSocket.getSocket() instanceof AsyncSSLSocketWrapper)) {
            return;
        }
        Iterator<ef2> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(webSocket, asyncHttpServerRequest).b) {
                return;
            }
        }
        E010Bean e010Bean = new E010Bean();
        ?? e010Data = new E010Bean.E010Data();
        e010Data.setCode(MessageType.ERROR_KEY_001);
        e010Data.setMessage(MessageType.ERROR_MESSAGE.get(MessageType.ERROR_KEY_001));
        e010Bean.data = e010Data;
        webSocket.send(JSON.toJSONString(e010Bean));
        webSocket.close();
    }

    public final void A(AsyncHttpServer asyncHttpServer) throws InterruptedException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
        this.h = r(10250, 50000);
        if (this.q == 0) {
            this.h = 34568;
        }
        String str = "listenSSLServer sslPortLan: " + this.h;
        this.k = true;
        SSLContext sSLContextU = u();
        if (sSLContextU != null) {
            asyncHttpServer.listenSecure(this.h, sSLContextU);
            WeakReference<ef2> weakReference = this.s;
            if (weakReference != null && weakReference.get() != null) {
                D(this.s.get());
            }
        }
        if (this.k) {
            return;
        }
        int i = this.q + 1;
        this.q = i;
        if (i < 10) {
            A(asyncHttpServer);
        }
    }

    public final void B(AsyncHttpServer asyncHttpServer) {
        if (this.n >= 10) {
            this.n = 0;
        }
        this.b = if2.i[this.n];
        String str = "listenServer: " + this.b;
        this.k = true;
        asyncHttpServer.listen(this.b);
        if (this.k) {
            return;
        }
        int i = this.n;
        this.n = i + 1;
        if (i < 10) {
            B(asyncHttpServer);
        }
    }

    public final void C(AsyncHttpServer asyncHttpServer) {
        this.g = r(10250, 50000);
        if (this.p == 0) {
            this.g = 34567;
        }
        String str = "listenServer portLan: " + this.g;
        this.k = true;
        asyncHttpServer.listen(this.g);
        if (this.k) {
            return;
        }
        int i = this.p + 1;
        this.p = i;
        if (i < 10) {
            C(asyncHttpServer);
        }
    }

    public final void D(ef2 ef2Var) {
        a(ef2Var);
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(new c(ef2Var), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void E() {
        this.m = 0;
        Server server = this.f;
        if (server != 0) {
            ((AsyncHttpServer) server).stop();
            this.f = null;
        }
        F(this.t);
        F(this.u);
        WeakReference<ef2> weakReference = this.s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.s.clear();
        this.s = null;
    }

    public final void F(Subscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return;
        }
        subscription.unsubscribe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [Server, com.koushikdutta.async.http.server.AsyncHttpServer] */
    @Override // dc.if2
    public void b(final ef2 ef2Var, String str, boolean z) {
        try {
            super.b(ef2Var, str, z);
            String strF0 = WearUtils.f0();
            this.e = strF0;
            if (this.m == 2 && z) {
                if (!TextUtils.isEmpty(strF0)) {
                    if (ef2Var != null) {
                        D(ef2Var);
                        return;
                    }
                    return;
                } else {
                    this.m = 0;
                    if (ef2Var != null) {
                        ef2Var.b(new Exception("ip 地址获取失败"));
                        return;
                    }
                    return;
                }
            }
            this.m = 1;
            if (TextUtils.isEmpty(strF0) && z) {
                this.m = 0;
                if (ef2Var != null) {
                    ef2Var.b(new Exception("ip 地址获取失败"));
                    return;
                }
                return;
            }
            ?? asyncHttpServer = new AsyncHttpServer();
            this.f = asyncHttpServer;
            ((AsyncHttpServer) asyncHttpServer).setErrorCallback(new CompletedCallback() { // from class: dc.cf2
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc) {
                    this.a.w(ef2Var, exc);
                }
            });
            String str2 = "createLocalServer:  start port portSSL" + this.b + "   portSSL" + this.c;
            l();
            B((AsyncHttpServer) this.f);
            C((AsyncHttpServer) this.f);
            if (this.k) {
                String str3 = "createLocalServer: port portSSL" + this.b + "   portSSL" + this.c;
                ((AsyncHttpServer) this.f).websocket(this.d, new AsyncHttpServer.WebSocketRequestCallback() { // from class: dc.bf2
                    @Override // com.koushikdutta.async.http.server.AsyncHttpServer.WebSocketRequestCallback
                    public final void onConnected(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
                        this.a.y(webSocket, asyncHttpServerRequest);
                    }
                });
                ((AsyncHttpServer) this.f).addAction("OPTIONS", "/.*", new a(this));
                ((AsyncHttpServer) this.f).post("/.*", new b());
                this.s = new WeakReference<>(ef2Var);
                D(ef2Var);
            }
        } catch (Exception e2) {
            if (ef2Var != null) {
                ef2Var.b(e2);
            }
        }
    }

    public final InputStream h(File file) {
        try {
            return new ByteArrayInputStream(i(new FileInputStream(file.getAbsoluteFile())));
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final byte[] i(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Base64.decodeBase64(qx.a(sb.toString()).getBytes());
    }

    public final void j(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("dtxToken", str);
        map.put("deviceType", 1);
        map.put("downloadToken", str2);
        F(this.u);
        this.u = tn2.x(WearUtils.x).n("/gfw/common/downloadCertificate", WearUtils.A.toJson(map), new e(str3));
    }

    public final String k(InputStream inputStream, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String str = "";
        if (inputStream == null) {
            return "";
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(inputStream, s(z).toCharArray());
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                String strValueOf = String.valueOf(enumerationAliases.nextElement());
                if (keyStore.getCertificate(strValueOf).getType().equals("X.509")) {
                    str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(((X509Certificate) keyStore.getCertificate(strValueOf)).getNotAfter());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l() throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyStoreException, java.security.cert.CertificateException {
        /*
            r7 = this;
            java.lang.String r0 = "mybks"
            com.wear.bean.DtxTokenParameter r1 = new com.wear.bean.DtxTokenParameter
            r1.<init>()
            java.lang.String r2 = "Lovense Remote"
            r1.setAppName(r2)
            java.lang.String r2 = dc.ye3.s()
            r1.setVersion(r2)
            com.google.gson.Gson r2 = com.wear.util.WearUtils.A
            java.lang.String r1 = r2.toJson(r1)
            java.lang.String r1 = dc.qx.b(r1)
            r2 = 0
            r3 = 1
            r4 = 0
            dc.xz r5 = dc.xz.a     // Catch: java.lang.Exception -> L6b
            java.lang.String r5 = dc.xz.e()     // Catch: java.lang.Exception -> L6b
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L6b
            byte[] r5 = dc.sd0.a(r5)     // Catch: java.lang.Exception -> L6b
            r6.<init>(r5)     // Catch: java.lang.Exception -> L6b
            java.io.File r4 = com.wear.util.WearUtils.z0(r0)     // Catch: java.lang.Exception -> L69
            boolean r4 = r4.exists()     // Catch: java.lang.Exception -> L69
            if (r4 == 0) goto L67
            java.io.File r0 = com.wear.util.WearUtils.z0(r0)     // Catch: java.lang.Exception -> L64
            java.lang.String r0 = r0.getPath()     // Catch: java.lang.Exception -> L64
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L64
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L64
            r5.<init>()     // Catch: java.lang.Exception -> L64
            r5.append(r0)     // Catch: java.lang.Exception -> L64
            java.lang.String r0 = "/"
            r5.append(r0)     // Catch: java.lang.Exception -> L64
            java.lang.String r0 = r7.t()     // Catch: java.lang.Exception -> L64
            r5.append(r0)     // Catch: java.lang.Exception -> L64
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L64
            r4.<init>(r0)     // Catch: java.lang.Exception -> L64
            java.io.InputStream r6 = r7.h(r4)     // Catch: java.lang.Exception -> L64
            r0 = 0
            goto L72
        L64:
            r0 = move-exception
            r4 = 0
            goto L6e
        L67:
            r0 = 1
            goto L72
        L69:
            r0 = move-exception
            goto L6d
        L6b:
            r0 = move-exception
            r6 = r4
        L6d:
            r4 = 1
        L6e:
            r0.printStackTrace()
            r0 = r4
        L72:
            java.lang.String r0 = r7.k(r6, r0)
            int r4 = r0.length()
            r5 = 10
            if (r4 <= r5) goto L83
            java.lang.String r0 = r0.substring(r2, r5)
            goto L85
        L83:
            java.lang.String r0 = "1970-01-01"
        L85:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r4 = "dtxToken"
            r2.put(r4, r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "deviceType"
            r2.put(r4, r3)
            java.lang.String r3 = "domainUrl"
            java.lang.String r4 = "lovense.club"
            r2.put(r3, r4)
            java.lang.String r3 = "validityPeriodEnd"
            r2.put(r3, r0)
            rx.Subscription r0 = r7.t
            r7.F(r0)
            com.wear.util.MyApplication r0 = com.wear.util.WearUtils.x
            dc.tn2 r0 = dc.tn2.x(r0)
            com.google.gson.Gson r3 = com.wear.util.WearUtils.A
            java.lang.String r2 = r3.toJson(r2)
            dc.kf2$d r3 = new dc.kf2$d
            r3.<init>(r1)
            java.lang.String r1 = "/gfw/common/checkCertificateRenewal"
            rx.Subscription r0 = r0.m(r1, r2, r3)
            r7.t = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.kf2.l():void");
    }

    public String n() {
        return this.e;
    }

    public int o() {
        return this.b;
    }

    public int p() {
        return this.c;
    }

    public String q() {
        return this.e + "/" + this.b;
    }

    public final int r(int i, int i2) {
        return i + ((int) (Math.random() * (i2 - i)));
    }

    public final String s(boolean z) {
        String strH = eg3.h(WearUtils.x, v, "");
        if (!WearUtils.e1(strH) && !z) {
            return qx.a(strH);
        }
        xz xzVar = xz.a;
        return xz.f();
    }

    public final String t() {
        return eg3.h(WearUtils.x, w, "lovense.club.bks");
    }

    public final SSLContext u() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
        String strS;
        SSLContext sSLContext = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            if (WearUtils.z0("mybks").exists()) {
                strS = s(false);
                InputStream inputStreamH = h(new File(WearUtils.z0("mybks").getPath() + "/" + t()));
                if (inputStreamH != null) {
                    keyStore.load(inputStreamH, strS.toCharArray());
                }
            } else {
                strS = s(true);
                xz xzVar = xz.a;
                keyStore.load(new ByteArrayInputStream(sd0.a(xz.e())), strS.toCharArray());
            }
            KeyManagerFactory.getDefaultAlgorithm();
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
            keyManagerFactory.init(keyStore, strS.toCharArray());
            TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext2 = SSLContext.getInstance(TLSUtils.TLS);
            try {
                sSLContext2.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
                return sSLContext2;
            } catch (Exception e2) {
                e = e2;
                sSLContext = sSLContext2;
                e.printStackTrace();
                return sSLContext;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final void z(AsyncHttpServer asyncHttpServer) throws InterruptedException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
        if (this.o >= 10) {
            this.o = 0;
        }
        this.c = if2.j[this.o];
        String str = "listenSSLServer: " + this.c;
        this.k = true;
        SSLContext sSLContextU = u();
        if (sSLContextU != null) {
            asyncHttpServer.listenSecure(this.c, sSLContextU);
            WeakReference<ef2> weakReference = this.s;
            if (weakReference != null && weakReference.get() != null) {
                D(this.s.get());
            }
        }
        if (this.k) {
            return;
        }
        int i = this.o;
        this.o = i + 1;
        if (i < 10) {
            z(asyncHttpServer);
        }
    }
}
