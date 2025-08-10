package com.google.firebase.database.tubesock;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import androidx.annotation.Nullable;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.logging.LogWrapper;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

/* loaded from: classes2.dex */
public class WebSocket {
    public static final byte OPCODE_BINARY = 2;
    public static final byte OPCODE_CLOSE = 8;
    public static final byte OPCODE_NONE = 0;
    public static final byte OPCODE_PING = 9;
    public static final byte OPCODE_PONG = 10;
    public static final byte OPCODE_TEXT = 1;
    private static final int SSL_HANDSHAKE_TIMEOUT_MS = 60000;
    private static final String THREAD_BASE_NAME = "TubeSock";
    private final int clientId;
    private WebSocketEventHandler eventHandler;
    private final WebSocketHandshake handshake;
    private final Thread innerThread;
    private final LogWrapper logger;
    private final WebSocketReceiver receiver;
    private volatile Socket socket;

    @Nullable
    private final String sslCacheDirectory;
    private volatile State state;
    private final URI url;
    private final WebSocketWriter writer;
    private static final AtomicInteger clientCount = new AtomicInteger(0);
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private static ThreadInitializer intializer = new ThreadInitializer() { // from class: com.google.firebase.database.tubesock.WebSocket.1
        @Override // com.google.firebase.database.tubesock.ThreadInitializer
        public void setName(Thread thread, String str) {
            thread.setName(str);
        }
    };

    /* renamed from: com.google.firebase.database.tubesock.WebSocket$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State = iArr;
            try {
                iArr[State.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum State {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public WebSocket(ConnectionContext connectionContext, URI uri) {
        this(connectionContext, uri, null);
    }

    private synchronized void closeSocket() {
        if (this.state == State.DISCONNECTED) {
            return;
        }
        this.receiver.stopit();
        this.writer.stopIt();
        if (this.socket == null) {
            this.state = State.DISCONNECTED;
            this.eventHandler.onClose();
            return;
        }
        try {
            this.socket.close();
        } catch (Exception e) {
            this.eventHandler.onError(new WebSocketException("Failed to close", e));
        }
        this.state = State.DISCONNECTED;
        this.eventHandler.onClose();
        return;
    }

    private Socket createSocket() {
        String scheme = this.url.getScheme();
        String host = this.url.getHost();
        int port = this.url.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException e) {
                throw new WebSocketException("unknown host: " + host, e);
            } catch (IOException e2) {
                throw new WebSocketException("error while creating socket to " + this.url, e2);
            }
        }
        if (scheme == null || !scheme.equals("wss")) {
            throw new WebSocketException("unsupported protocol: " + scheme);
        }
        if (port == -1) {
            port = 443;
        }
        SSLSessionCache sSLSessionCache = null;
        try {
            if (this.sslCacheDirectory != null) {
                sSLSessionCache = new SSLSessionCache(new File(this.sslCacheDirectory));
            }
        } catch (IOException e3) {
            this.logger.debug("Failed to initialize SSL session cache", e3, new Object[0]);
        }
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(SSL_HANDSHAKE_TIMEOUT_MS, sSLSessionCache).createSocket(host, port);
            if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                return sSLSocket;
            }
            throw new WebSocketException("Error while verifying secure socket to " + this.url);
        } catch (UnknownHostException e4) {
            throw new WebSocketException("unknown host: " + host, e4);
        } catch (IOException e5) {
            throw new WebSocketException("error while creating secure socket to " + this.url, e5);
        }
    }

    public static ThreadInitializer getIntializer() {
        return intializer;
    }

    public static ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runReader() {
        try {
            try {
                Socket socketCreateSocket = createSocket();
                synchronized (this) {
                    this.socket = socketCreateSocket;
                    if (this.state == State.DISCONNECTED) {
                        try {
                            this.socket.close();
                            this.socket = null;
                            return;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    DataInputStream dataInputStream = new DataInputStream(socketCreateSocket.getInputStream());
                    OutputStream outputStream = socketCreateSocket.getOutputStream();
                    outputStream.write(this.handshake.getHandshake());
                    byte[] bArr = new byte[1000];
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    while (true) {
                        int i = 0;
                        while (!z) {
                            int i2 = dataInputStream.read();
                            if (i2 == -1) {
                                throw new WebSocketException("Connection closed before handshake was complete");
                            }
                            bArr[i] = (byte) i2;
                            i++;
                            if (bArr[i - 1] == 10 && bArr[i - 2] == 13) {
                                String str = new String(bArr, UTF8);
                                if (str.trim().equals("")) {
                                    z = true;
                                } else {
                                    arrayList.add(str.trim());
                                }
                                bArr = new byte[1000];
                            } else if (i == 1000) {
                                throw new WebSocketException("Unexpected long line in handshake: " + new String(bArr, UTF8));
                            }
                        }
                        this.handshake.verifyServerStatusLine((String) arrayList.get(0));
                        arrayList.remove(0);
                        HashMap<String, String> map = new HashMap<>();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String[] strArrSplit = ((String) it.next()).split(": ", 2);
                            String str2 = strArrSplit[0];
                            Locale locale = Locale.US;
                            map.put(str2.toLowerCase(locale), strArrSplit[1].toLowerCase(locale));
                        }
                        this.handshake.verifyServerHandshakeHeaders(map);
                        this.writer.setOutput(outputStream);
                        this.receiver.setInput(dataInputStream);
                        this.state = State.CONNECTED;
                        this.writer.getInnerThread().start();
                        this.eventHandler.onOpen();
                        this.receiver.run();
                    }
                }
            } catch (WebSocketException e2) {
                this.eventHandler.onError(e2);
            } catch (Throwable th) {
                this.eventHandler.onError(new WebSocketException("error while connecting: " + th.getMessage(), th));
            }
        } finally {
            close();
        }
    }

    private void sendCloseHandshake() {
        try {
            this.state = State.DISCONNECTING;
            this.writer.stopIt();
            this.writer.send((byte) 8, true, new byte[0]);
        } catch (IOException e) {
            this.eventHandler.onError(new WebSocketException("Failed to send close frame", e));
        }
    }

    public static void setThreadFactory(ThreadFactory threadFactory2, ThreadInitializer threadInitializer) {
        threadFactory = threadFactory2;
        intializer = threadInitializer;
    }

    public void blockClose() throws InterruptedException {
        if (this.writer.getInnerThread().getState() != Thread.State.NEW) {
            this.writer.getInnerThread().join();
        }
        getInnerThread().join();
    }

    public synchronized void close() {
        int i = AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[this.state.ordinal()];
        if (i == 1) {
            this.state = State.DISCONNECTED;
            return;
        }
        if (i == 2) {
            closeSocket();
            return;
        }
        if (i == 3) {
            sendCloseHandshake();
        } else if (i != 4) {
            if (i != 5) {
            }
        }
    }

    public synchronized void connect() {
        if (this.state != State.NONE) {
            this.eventHandler.onError(new WebSocketException("connect() already called"));
            close();
            return;
        }
        getIntializer().setName(getInnerThread(), "TubeSockReader-" + this.clientId);
        this.state = State.CONNECTING;
        getInnerThread().start();
    }

    public WebSocketEventHandler getEventHandler() {
        return this.eventHandler;
    }

    public Thread getInnerThread() {
        return this.innerThread;
    }

    public void handleReceiverError(WebSocketException webSocketException) {
        this.eventHandler.onError(webSocketException);
        if (this.state == State.CONNECTED) {
            close();
        }
        closeSocket();
    }

    public void onCloseOpReceived() {
        closeSocket();
    }

    public synchronized void pong(byte[] bArr) {
        send((byte) 10, bArr);
    }

    public synchronized void send(String str) {
        send((byte) 1, str.getBytes(UTF8));
    }

    public void setEventHandler(WebSocketEventHandler webSocketEventHandler) {
        this.eventHandler = webSocketEventHandler;
    }

    public WebSocket(ConnectionContext connectionContext, URI uri, String str) {
        this(connectionContext, uri, str, null);
    }

    public WebSocket(ConnectionContext connectionContext, URI uri, String str, Map<String, String> map) {
        this.state = State.NONE;
        this.socket = null;
        this.eventHandler = null;
        int iIncrementAndGet = clientCount.incrementAndGet();
        this.clientId = iIncrementAndGet;
        this.innerThread = getThreadFactory().newThread(new Runnable() { // from class: com.google.firebase.database.tubesock.WebSocket.2
            @Override // java.lang.Runnable
            public void run() {
                WebSocket.this.runReader();
            }
        });
        this.url = uri;
        this.sslCacheDirectory = connectionContext.getSslCacheDirectory();
        this.logger = new LogWrapper(connectionContext.getLogger(), "WebSocket", "sk_" + iIncrementAndGet);
        this.handshake = new WebSocketHandshake(uri, str, map);
        this.receiver = new WebSocketReceiver(this);
        this.writer = new WebSocketWriter(this, THREAD_BASE_NAME, iIncrementAndGet);
    }

    public synchronized void send(byte[] bArr) {
        send((byte) 2, bArr);
    }

    private synchronized void send(byte b, byte[] bArr) {
        if (this.state != State.CONNECTED) {
            this.eventHandler.onError(new WebSocketException("error while sending data: not connected"));
        } else {
            try {
                this.writer.send(b, true, bArr);
            } catch (IOException e) {
                this.eventHandler.onError(new WebSocketException("Failed to send frame", e));
                close();
            }
        }
    }
}
