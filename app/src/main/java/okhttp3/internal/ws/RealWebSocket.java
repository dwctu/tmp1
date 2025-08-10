package okhttp3.internal.ws;

import com.google.common.net.HttpHeaders;
import dc.ac4;
import dc.ad4;
import dc.bc4;
import dc.ed4;
import dc.fd4;
import dc.nc4;
import dc.od4;
import dc.pd4;
import dc.qd4;
import dc.vc4;
import dc.wc4;
import dc.wd4;
import dc.yc4;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.ws.WebSocketReader;

/* loaded from: classes5.dex */
public final class RealWebSocket implements ed4, WebSocketReader.FrameCallback {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<wc4> ONLY_HTTP1 = Collections.singletonList(wc4.HTTP_1_1);
    private boolean awaitingPong;
    private ac4 call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    public final fd4 listener;
    private final yc4 originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<qd4> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    public static final class Close {
        public final long cancelAfterCloseMillis;
        public final int code;
        public final qd4 reason;

        public Close(int i, qd4 qd4Var, long j) {
            this.code = i;
            this.reason = qd4Var;
            this.cancelAfterCloseMillis = j;
        }
    }

    public static final class Message {
        public final qd4 data;
        public final int formatOpcode;

        public Message(int i, qd4 qd4Var) {
            this.formatOpcode = i;
            this.data = qd4Var;
        }
    }

    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            RealWebSocket.this.writePingFrame();
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final od4 sink;
        public final pd4 source;

        public Streams(boolean z, pd4 pd4Var, od4 od4Var) {
            this.client = z;
            this.source = pd4Var;
            this.sink = od4Var;
        }
    }

    public RealWebSocket(yc4 yc4Var, fd4 fd4Var, Random random, long j) {
        if (!"GET".equals(yc4Var.g())) {
            throw new IllegalArgumentException("Request must be GET: " + yc4Var.g());
        }
        this.originalRequest = yc4Var;
        this.listener = fd4Var;
        this.random = random;
        this.pingIntervalMillis = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = qd4.m(bArr).a();
        this.writerRunnable = new Runnable() { // from class: dc.jd4
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.b();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() throws IOException {
        do {
            try {
            } catch (IOException e) {
                failWebSocket(e, null);
                return;
            }
        } while (writeOneFrame());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    public void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(i, timeUnit);
    }

    public void cancel() {
        this.call.cancel();
    }

    public void checkUpgradeSuccess(ad4 ad4Var, Exchange exchange) throws IOException {
        if (ad4Var.f() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + ad4Var.f() + " " + ad4Var.x() + "'");
        }
        String strM = ad4Var.m(HttpHeaders.CONNECTION);
        if (!HttpHeaders.UPGRADE.equalsIgnoreCase(strM)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strM + "'");
        }
        String strM2 = ad4Var.m(HttpHeaders.UPGRADE);
        if (!"websocket".equalsIgnoreCase(strM2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strM2 + "'");
        }
        String strM3 = ad4Var.m("Sec-WebSocket-Accept");
        String strA = qd4.h(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").q().a();
        if (strA.equals(strM3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + strM3 + "'");
    }

    @Override // dc.ed4
    public boolean close(int i, String str) {
        return close(i, str, 60000L);
    }

    public void connect(vc4 vc4Var) {
        vc4.b bVarT = vc4Var.t();
        bVarT.f(nc4.a);
        bVarT.j(ONLY_HTTP1);
        vc4 vc4VarB = bVarT.b();
        yc4.a aVarH = this.originalRequest.h();
        aVarH.e(HttpHeaders.UPGRADE, "websocket");
        aVarH.e(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        aVarH.e("Sec-WebSocket-Key", this.key);
        aVarH.e("Sec-WebSocket-Version", "13");
        final yc4 yc4VarB = aVarH.b();
        ac4 ac4VarNewWebSocketCall = Internal.instance.newWebSocketCall(vc4VarB, yc4VarB);
        this.call = ac4VarNewWebSocketCall;
        ac4VarNewWebSocketCall.j(new bc4() { // from class: okhttp3.internal.ws.RealWebSocket.1
            @Override // dc.bc4
            public void onFailure(ac4 ac4Var, IOException iOException) throws IOException {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // dc.bc4
            public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
                Exchange exchange = Internal.instance.exchange(ad4Var);
                try {
                    RealWebSocket.this.checkUpgradeSuccess(ad4Var, exchange);
                    try {
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + yc4VarB.j().E(), exchange.newWebSocketStreams());
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.listener.f(realWebSocket, ad4Var);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e2, ad4Var);
                    Util.closeQuietly(ad4Var);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, ad4 ad4Var) throws IOException {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.listener.c(this, exc, ad4Var);
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.executor = scheduledThreadPoolExecutor;
            if (this.pingIntervalMillis != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j = this.pingIntervalMillis;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) throws IOException {
        Streams streams;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i;
            this.receivedCloseReason = str;
            streams = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Streams streams2 = this.streams;
                this.streams = null;
                ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.executor.shutdown();
                streams = streams2;
            }
        }
        try {
            this.listener.b(this, i, str);
            if (streams != null) {
                this.listener.a(this, i, str);
            }
        } finally {
            Util.closeQuietly(streams);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.listener.d(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(qd4 qd4Var) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(qd4Var);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(qd4 qd4Var) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public synchronized boolean pong(qd4 qd4Var) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(qd4Var);
            runWriter();
            return true;
        }
        return false;
    }

    public boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public yc4 request() {
        return this.originalRequest;
    }

    @Override // dc.ed4
    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return send(qd4.h(str), 1);
    }

    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public boolean writeOneFrame() throws IOException {
        Streams streams;
        String str;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            qd4 qd4VarPoll = this.pongQueue.poll();
            int i = -1;
            Message message = 0;
            if (qd4VarPoll == null) {
                Object objPoll = this.messageAndCloseQueue.poll();
                if (objPoll instanceof Close) {
                    int i2 = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i2 != -1) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        message = objPoll;
                        i = i2;
                        streams = streams2;
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) objPoll).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                        i = i2;
                        streams = null;
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    streams = null;
                    str = null;
                }
                message = objPoll;
            } else {
                streams = null;
                str = null;
            }
            try {
                if (qd4VarPoll != null) {
                    webSocketWriter.writePong(qd4VarPoll);
                } else if (message instanceof Message) {
                    qd4 qd4Var = message.data;
                    od4 od4VarC = wd4.c(webSocketWriter.newMessageSink(message.formatOpcode, qd4Var.s()));
                    od4VarC.U(qd4Var);
                    od4VarC.close();
                    synchronized (this) {
                        this.queueSize -= qd4Var.s();
                    }
                } else {
                    if (!(message instanceof Close)) {
                        throw new AssertionError();
                    }
                    Close close = (Close) message;
                    webSocketWriter.writeClose(close.code, close.reason);
                    if (streams != null) {
                        this.listener.a(this, i, str);
                    }
                }
                return true;
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void writePingFrame() throws IOException {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i == -1) {
                try {
                    webSocketWriter.writePing(qd4.d);
                    return;
                } catch (IOException e) {
                    failWebSocket(e, null);
                    return;
                }
            }
            failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    public synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.validateCloseCode(i);
        qd4 qd4VarH = null;
        if (str != null) {
            qd4VarH = qd4.h(str);
            if (qd4VarH.s() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(i, qd4VarH, j));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(qd4 qd4Var) throws IOException {
        this.listener.e(this, qd4Var);
    }

    @Override // dc.ed4
    public boolean send(qd4 qd4Var) {
        Objects.requireNonNull(qd4Var, "bytes == null");
        return send(qd4Var, 2);
    }

    private synchronized boolean send(qd4 qd4Var, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + qd4Var.s() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += qd4Var.s();
            this.messageAndCloseQueue.add(new Message(i, qd4Var));
            runWriter();
            return true;
        }
        return false;
    }
}
