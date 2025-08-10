package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLSession;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.interfaces.ISSLChannel;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
public class WebSocketImpl implements WebSocket {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_WSS_PORT = 443;
    public static final int RCVBUF = 16384;
    private Object attachment;
    private ByteChannel channel;
    private Integer closecode;
    private Boolean closedremotely;
    private String closemessage;
    private Draft draft;
    private boolean flushandclosestate;
    private ClientHandshake handshakerequest;
    public final BlockingQueue<ByteBuffer> inQueue;
    private SelectionKey key;
    private List<Draft> knownDrafts;
    private long lastPong;
    private final Logger log;
    public final BlockingQueue<ByteBuffer> outQueue;
    private volatile ReadyState readyState;
    private String resourceDescriptor;
    private Role role;
    private final Object synchronizeWriteObject;
    private ByteBuffer tmpHandshakeBytes;
    private WebSocketServer.WebSocketWorker workerThread;
    private final WebSocketListener wsl;

    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list) {
        this(webSocketListener, (Draft) null);
        this.role = Role.SERVER;
        if (list != null && !list.isEmpty()) {
            this.knownDrafts = list;
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.knownDrafts = arrayList;
        arrayList.add(new Draft_6455());
    }

    private void closeConnectionDueToInternalServerError(RuntimeException runtimeException) {
        write(generateHttpResponseDueToError(500));
        flushAndClose(-1, runtimeException.getMessage(), false);
    }

    private void closeConnectionDueToWrongHandshake(InvalidDataException invalidDataException) {
        write(generateHttpResponseDueToError(404));
        flushAndClose(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void decodeFrames(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.translateFrame(byteBuffer)) {
                this.log.trace("matched frame: {}", framedata);
                this.draft.processFrame(this, framedata);
            }
        } catch (LimitExceededException e) {
            if (e.getLimit() == Integer.MAX_VALUE) {
                this.log.error("Closing due to invalid size of frame", (Throwable) e);
                this.wsl.onWebsocketError(this, e);
            }
            close(e);
        } catch (InvalidDataException e2) {
            this.log.error("Closing due to invalid data in frame", (Throwable) e2);
            this.wsl.onWebsocketError(this, e2);
            close(e2);
        }
    }

    private boolean decodeHandshake(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        Role role;
        Handshakedata handshakedataTranslateHandshake;
        if (this.tmpHandshakeBytes.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.tmpHandshakeBytes.remaining() < byteBuffer.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + byteBuffer.remaining());
                this.tmpHandshakeBytes.flip();
                byteBufferAllocate.put(this.tmpHandshakeBytes);
                this.tmpHandshakeBytes = byteBufferAllocate;
            }
            this.tmpHandshakeBytes.put(byteBuffer);
            this.tmpHandshakeBytes.flip();
            byteBuffer2 = this.tmpHandshakeBytes;
        }
        byteBuffer2.mark();
        try {
            try {
                role = this.role;
            } catch (InvalidHandshakeException e) {
                this.log.trace("Closing due to invalid handshake", (Throwable) e);
                close(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.tmpHandshakeBytes.capacity() == 0) {
                byteBuffer2.reset();
                int preferredSize = e2.getPreferredSize();
                if (preferredSize == 0) {
                    preferredSize = byteBuffer2.capacity() + 16;
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(preferredSize);
                this.tmpHandshakeBytes = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.tmpHandshakeBytes;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.tmpHandshakeBytes;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (role != Role.SERVER) {
            if (role == Role.CLIENT) {
                this.draft.setParseMode(role);
                Handshakedata handshakedataTranslateHandshake2 = this.draft.translateHandshake(byteBuffer2);
                if (!(handshakedataTranslateHandshake2 instanceof ServerHandshake)) {
                    this.log.trace("Closing due to protocol error: wrong http function");
                    flushAndClose(1002, "wrong http function", false);
                    return false;
                }
                ServerHandshake serverHandshake = (ServerHandshake) handshakedataTranslateHandshake2;
                if (this.draft.acceptHandshakeAsClient(this.handshakerequest, serverHandshake) == HandshakeState.MATCHED) {
                    try {
                        this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, serverHandshake);
                        open(serverHandshake);
                        return true;
                    } catch (RuntimeException e3) {
                        this.log.error("Closing since client was never connected", (Throwable) e3);
                        this.wsl.onWebsocketError(this, e3);
                        flushAndClose(-1, e3.getMessage(), false);
                        return false;
                    } catch (InvalidDataException e4) {
                        this.log.trace("Closing due to invalid data exception. Possible handshake rejection", (Throwable) e4);
                        flushAndClose(e4.getCloseCode(), e4.getMessage(), false);
                        return false;
                    }
                }
                this.log.trace("Closing due to protocol error: draft {} refuses handshake", this.draft);
                close(1002, "draft " + this.draft + " refuses handshake");
            }
            return false;
        }
        Draft draft = this.draft;
        if (draft != null) {
            Handshakedata handshakedataTranslateHandshake3 = draft.translateHandshake(byteBuffer2);
            if (!(handshakedataTranslateHandshake3 instanceof ClientHandshake)) {
                this.log.trace("Closing due to protocol error: wrong http function");
                flushAndClose(1002, "wrong http function", false);
                return false;
            }
            ClientHandshake clientHandshake = (ClientHandshake) handshakedataTranslateHandshake3;
            if (this.draft.acceptHandshakeAsServer(clientHandshake) == HandshakeState.MATCHED) {
                open(clientHandshake);
                return true;
            }
            this.log.trace("Closing due to protocol error: the handshake did finally not match");
            close(1002, "the handshake did finally not match");
            return false;
        }
        Iterator<Draft> it = this.knownDrafts.iterator();
        while (it.hasNext()) {
            Draft draftCopyInstance = it.next().copyInstance();
            try {
                draftCopyInstance.setParseMode(this.role);
                byteBuffer2.reset();
                handshakedataTranslateHandshake = draftCopyInstance.translateHandshake(byteBuffer2);
            } catch (InvalidHandshakeException unused) {
            }
            if (!(handshakedataTranslateHandshake instanceof ClientHandshake)) {
                this.log.trace("Closing due to wrong handshake");
                closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "wrong http function"));
                return false;
            }
            ClientHandshake clientHandshake2 = (ClientHandshake) handshakedataTranslateHandshake;
            if (draftCopyInstance.acceptHandshakeAsServer(clientHandshake2) == HandshakeState.MATCHED) {
                this.resourceDescriptor = clientHandshake2.getResourceDescriptor();
                try {
                    write(draftCopyInstance.createHandshake(draftCopyInstance.postProcessHandshakeResponseAsServer(clientHandshake2, this.wsl.onWebsocketHandshakeReceivedAsServer(this, draftCopyInstance, clientHandshake2))));
                    this.draft = draftCopyInstance;
                    open(clientHandshake2);
                    return true;
                } catch (RuntimeException e5) {
                    this.log.error("Closing due to internal server error", (Throwable) e5);
                    this.wsl.onWebsocketError(this, e5);
                    closeConnectionDueToInternalServerError(e5);
                    return false;
                } catch (InvalidDataException e6) {
                    this.log.trace("Closing due to wrong handshake. Possible handshake rejection", (Throwable) e6);
                    closeConnectionDueToWrongHandshake(e6);
                    return false;
                }
            }
        }
        if (this.draft == null) {
            this.log.trace("Closing due to protocol error: no draft matches");
            closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "no draft matches"));
        }
        return false;
    }

    private ByteBuffer generateHttpResponseDueToError(int i) {
        String str = i != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(Charsetfunctions.asciiBytes("HTTP/1.1 " + str + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    private void open(Handshakedata handshakedata) {
        this.log.trace("open using draft: {}", this.draft);
        this.readyState = ReadyState.OPEN;
        try {
            this.wsl.onWebsocketOpen(this, handshakedata);
        } catch (RuntimeException e) {
            this.wsl.onWebsocketError(this, e);
        }
    }

    private void write(ByteBuffer byteBuffer) {
        this.log.trace("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.outQueue.add(byteBuffer);
        this.wsl.onWriteDemand(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d A[Catch: InvalidDataException -> 0x004f, all -> 0x0084, TRY_LEAVE, TryCatch #2 {InvalidDataException -> 0x004f, blocks: (B:17:0x002b, B:21:0x0037, B:23:0x003d, B:20:0x0032), top: B:44:0x002b, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void close(int r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            org.java_websocket.enums.ReadyState r0 = r5.readyState     // Catch: java.lang.Throwable -> L84
            org.java_websocket.enums.ReadyState r1 = org.java_websocket.enums.ReadyState.CLOSING     // Catch: java.lang.Throwable -> L84
            if (r0 == r1) goto L82
            org.java_websocket.enums.ReadyState r0 = r5.readyState     // Catch: java.lang.Throwable -> L84
            org.java_websocket.enums.ReadyState r2 = org.java_websocket.enums.ReadyState.CLOSED     // Catch: java.lang.Throwable -> L84
            if (r0 == r2) goto L82
            org.java_websocket.enums.ReadyState r0 = r5.readyState     // Catch: java.lang.Throwable -> L84
            org.java_websocket.enums.ReadyState r2 = org.java_websocket.enums.ReadyState.OPEN     // Catch: java.lang.Throwable -> L84
            r3 = 0
            if (r0 != r2) goto L65
            r0 = 1006(0x3ee, float:1.41E-42)
            if (r6 != r0) goto L1f
            r5.readyState = r1     // Catch: java.lang.Throwable -> L84
            r5.flushAndClose(r6, r7, r3)     // Catch: java.lang.Throwable -> L84
            monitor-exit(r5)
            return
        L1f:
            org.java_websocket.drafts.Draft r1 = r5.draft     // Catch: java.lang.Throwable -> L84
            org.java_websocket.enums.CloseHandshakeType r1 = r1.getCloseHandshakeType()     // Catch: java.lang.Throwable -> L84
            org.java_websocket.enums.CloseHandshakeType r2 = org.java_websocket.enums.CloseHandshakeType.NONE     // Catch: java.lang.Throwable -> L84
            if (r1 == r2) goto L61
            if (r8 != 0) goto L37
            org.java_websocket.WebSocketListener r1 = r5.wsl     // Catch: java.lang.RuntimeException -> L31 org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r1.onWebsocketCloseInitiated(r5, r6, r7)     // Catch: java.lang.RuntimeException -> L31 org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            goto L37
        L31:
            r1 = move-exception
            org.java_websocket.WebSocketListener r2 = r5.wsl     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r2.onWebsocketError(r5, r1)     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
        L37:
            boolean r1 = r5.isOpen()     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            if (r1 == 0) goto L61
            org.java_websocket.framing.CloseFrame r1 = new org.java_websocket.framing.CloseFrame     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r1.<init>()     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r1.setReason(r7)     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r1.setCode(r6)     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r1.isValid()     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            r5.sendFrame(r1)     // Catch: org.java_websocket.exceptions.InvalidDataException -> L4f java.lang.Throwable -> L84
            goto L61
        L4f:
            r1 = move-exception
            org.slf4j.Logger r2 = r5.log     // Catch: java.lang.Throwable -> L84
            java.lang.String r4 = "generated frame is invalid"
            r2.error(r4, r1)     // Catch: java.lang.Throwable -> L84
            org.java_websocket.WebSocketListener r2 = r5.wsl     // Catch: java.lang.Throwable -> L84
            r2.onWebsocketError(r5, r1)     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = "generated frame is invalid"
            r5.flushAndClose(r0, r1, r3)     // Catch: java.lang.Throwable -> L84
        L61:
            r5.flushAndClose(r6, r7, r8)     // Catch: java.lang.Throwable -> L84
            goto L79
        L65:
            r0 = -3
            if (r6 != r0) goto L6d
            r6 = 1
            r5.flushAndClose(r0, r7, r6)     // Catch: java.lang.Throwable -> L84
            goto L79
        L6d:
            r0 = 1002(0x3ea, float:1.404E-42)
            if (r6 != r0) goto L75
            r5.flushAndClose(r6, r7, r8)     // Catch: java.lang.Throwable -> L84
            goto L79
        L75:
            r6 = -1
            r5.flushAndClose(r6, r7, r3)     // Catch: java.lang.Throwable -> L84
        L79:
            org.java_websocket.enums.ReadyState r6 = org.java_websocket.enums.ReadyState.CLOSING     // Catch: java.lang.Throwable -> L84
            r5.readyState = r6     // Catch: java.lang.Throwable -> L84
            r6 = 0
            r5.tmpHandshakeBytes = r6     // Catch: java.lang.Throwable -> L84
            monitor-exit(r5)
            return
        L82:
            monitor-exit(r5)
            return
        L84:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.WebSocketImpl.close(int, java.lang.String, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[Catch: all -> 0x0069, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0009, B:11:0x0013, B:12:0x0017, B:14:0x001b, B:15:0x001e, B:17:0x0022, B:26:0x004d, B:30:0x0059, B:32:0x005d, B:33:0x0060, B:29:0x0054, B:20:0x0027, B:22:0x002d, B:24:0x0039, B:25:0x0041), top: B:43:0x0001, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void closeConnection(int r4, java.lang.String r5, boolean r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            org.java_websocket.enums.ReadyState r0 = r3.readyState     // Catch: java.lang.Throwable -> L69
            org.java_websocket.enums.ReadyState r1 = org.java_websocket.enums.ReadyState.CLOSED     // Catch: java.lang.Throwable -> L69
            if (r0 != r1) goto L9
            monitor-exit(r3)
            return
        L9:
            org.java_websocket.enums.ReadyState r0 = r3.readyState     // Catch: java.lang.Throwable -> L69
            org.java_websocket.enums.ReadyState r1 = org.java_websocket.enums.ReadyState.OPEN     // Catch: java.lang.Throwable -> L69
            if (r0 != r1) goto L17
            r0 = 1006(0x3ee, float:1.41E-42)
            if (r4 != r0) goto L17
            org.java_websocket.enums.ReadyState r0 = org.java_websocket.enums.ReadyState.CLOSING     // Catch: java.lang.Throwable -> L69
            r3.readyState = r0     // Catch: java.lang.Throwable -> L69
        L17:
            java.nio.channels.SelectionKey r0 = r3.key     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L1e
            r0.cancel()     // Catch: java.lang.Throwable -> L69
        L1e:
            java.nio.channels.ByteChannel r0 = r3.channel     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L4d
            r0.close()     // Catch: java.io.IOException -> L26 java.lang.Throwable -> L69
            goto L4d
        L26:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L41
            java.lang.String r1 = r0.getMessage()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "Broken pipe"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L41
            org.slf4j.Logger r1 = r3.log     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "Caught IOException: Broken pipe during closeConnection()"
            r1.trace(r2, r0)     // Catch: java.lang.Throwable -> L69
            goto L4d
        L41:
            org.slf4j.Logger r1 = r3.log     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "Exception during channel.close()"
            r1.error(r2, r0)     // Catch: java.lang.Throwable -> L69
            org.java_websocket.WebSocketListener r1 = r3.wsl     // Catch: java.lang.Throwable -> L69
            r1.onWebsocketError(r3, r0)     // Catch: java.lang.Throwable -> L69
        L4d:
            org.java_websocket.WebSocketListener r0 = r3.wsl     // Catch: java.lang.RuntimeException -> L53 java.lang.Throwable -> L69
            r0.onWebsocketClose(r3, r4, r5, r6)     // Catch: java.lang.RuntimeException -> L53 java.lang.Throwable -> L69
            goto L59
        L53:
            r4 = move-exception
            org.java_websocket.WebSocketListener r5 = r3.wsl     // Catch: java.lang.Throwable -> L69
            r5.onWebsocketError(r3, r4)     // Catch: java.lang.Throwable -> L69
        L59:
            org.java_websocket.drafts.Draft r4 = r3.draft     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L60
            r4.reset()     // Catch: java.lang.Throwable -> L69
        L60:
            r4 = 0
            r3.handshakerequest = r4     // Catch: java.lang.Throwable -> L69
            org.java_websocket.enums.ReadyState r4 = org.java_websocket.enums.ReadyState.CLOSED     // Catch: java.lang.Throwable -> L69
            r3.readyState = r4     // Catch: java.lang.Throwable -> L69
            monitor-exit(r3)
            return
        L69:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.WebSocketImpl.closeConnection(int, java.lang.String, boolean):void");
    }

    public void decode(ByteBuffer byteBuffer) {
        this.log.trace("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.readyState != ReadyState.NOT_YET_CONNECTED) {
            if (this.readyState == ReadyState.OPEN) {
                decodeFrames(byteBuffer);
            }
        } else {
            if (!decodeHandshake(byteBuffer) || isClosing() || isClosed()) {
                return;
            }
            if (byteBuffer.hasRemaining()) {
                decodeFrames(byteBuffer);
            } else if (this.tmpHandshakeBytes.hasRemaining()) {
                decodeFrames(this.tmpHandshakeBytes);
            }
        }
    }

    public void eot() {
        if (this.readyState == ReadyState.NOT_YET_CONNECTED) {
            closeConnection(-1, true);
            return;
        }
        if (this.flushandclosestate) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
            return;
        }
        if (this.draft.getCloseHandshakeType() == CloseHandshakeType.NONE) {
            closeConnection(1000, true);
            return;
        }
        if (this.draft.getCloseHandshakeType() != CloseHandshakeType.ONEWAY) {
            closeConnection(1006, true);
        } else if (this.role == Role.SERVER) {
            closeConnection(1006, true);
        } else {
            closeConnection(1000, true);
        }
    }

    public synchronized void flushAndClose(int i, String str, boolean z) {
        if (this.flushandclosestate) {
            return;
        }
        this.closecode = Integer.valueOf(i);
        this.closemessage = str;
        this.closedremotely = Boolean.valueOf(z);
        this.flushandclosestate = true;
        this.wsl.onWriteDemand(this);
        try {
            this.wsl.onWebsocketClosing(this, i, str, z);
        } catch (RuntimeException e) {
            this.log.error("Exception in onWebsocketClosing", (Throwable) e);
            this.wsl.onWebsocketError(this, e);
        }
        Draft draft = this.draft;
        if (draft != null) {
            draft.reset();
        }
        this.handshakerequest = null;
    }

    @Override // org.java_websocket.WebSocket
    public <T> T getAttachment() {
        return (T) this.attachment;
    }

    public ByteChannel getChannel() {
        return this.channel;
    }

    @Override // org.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    public long getLastPong() {
        return this.lastPong;
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.wsl.getLocalSocketAddress(this);
    }

    @Override // org.java_websocket.WebSocket
    public IProtocol getProtocol() {
        Draft draft = this.draft;
        if (draft == null) {
            return null;
        }
        if (draft instanceof Draft_6455) {
            return ((Draft_6455) draft).getProtocol();
        }
        throw new IllegalArgumentException("This draft does not support Sec-WebSocket-Protocol");
    }

    @Override // org.java_websocket.WebSocket
    public ReadyState getReadyState() {
        return this.readyState;
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.wsl.getRemoteSocketAddress(this);
    }

    @Override // org.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // org.java_websocket.WebSocket
    public SSLSession getSSLSession() {
        if (hasSSLSupport()) {
            return ((ISSLChannel) this.channel).getSSLEngine().getSession();
        }
        throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
    }

    public SelectionKey getSelectionKey() {
        return this.key;
    }

    public WebSocketListener getWebSocketListener() {
        return this.wsl;
    }

    public WebSocketServer.WebSocketWorker getWorkerThread() {
        return this.workerThread;
    }

    @Override // org.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return !this.outQueue.isEmpty();
    }

    @Override // org.java_websocket.WebSocket
    public boolean hasSSLSupport() {
        return this.channel instanceof ISSLChannel;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isClosed() {
        return this.readyState == ReadyState.CLOSED;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isClosing() {
        return this.readyState == ReadyState.CLOSING;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.flushandclosestate;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isOpen() {
        return this.readyState == ReadyState.OPEN;
    }

    @Override // org.java_websocket.WebSocket
    public void send(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(str, this.role == Role.CLIENT));
    }

    @Override // org.java_websocket.WebSocket
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        send(this.draft.continuousFrame(opcode, byteBuffer, z));
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Collection<Framedata> collection) {
        send(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendPing() throws NullPointerException {
        PingFrame pingFrameOnPreparePing = this.wsl.onPreparePing(this);
        Objects.requireNonNull(pingFrameOnPreparePing, "onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        sendFrame(pingFrameOnPreparePing);
    }

    @Override // org.java_websocket.WebSocket
    public <T> void setAttachment(T t) {
        this.attachment = t;
    }

    public void setChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    public void setSelectionKey(SelectionKey selectionKey) {
        this.key = selectionKey;
    }

    public void setWorkerThread(WebSocketServer.WebSocketWorker webSocketWorker) {
        this.workerThread = webSocketWorker;
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        this.resourceDescriptor = clientHandshakeBuilder.getResourceDescriptor();
        try {
            this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
            write(this.draft.createHandshake(this.handshakerequest));
        } catch (RuntimeException e) {
            this.log.error("Exception in startHandshake", (Throwable) e);
            this.wsl.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of " + e);
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    public String toString() {
        return super.toString();
    }

    public void updateLastPong() {
        this.lastPong = System.nanoTime();
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        send(Collections.singletonList(framedata));
    }

    @Override // org.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(byteBuffer, this.role == Role.CLIENT));
    }

    @Override // org.java_websocket.WebSocket
    public void send(byte[] bArr) {
        send(ByteBuffer.wrap(bArr));
    }

    private void send(Collection<Framedata> collection) {
        if (!isOpen()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection != null) {
            ArrayList arrayList = new ArrayList();
            for (Framedata framedata : collection) {
                this.log.trace("send frame: {}", framedata);
                arrayList.add(this.draft.createBinaryFrame(framedata));
            }
            write(arrayList);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.synchronizeWriteObject) {
            Iterator<ByteBuffer> it = list.iterator();
            while (it.hasNext()) {
                write(it.next());
            }
        }
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.log = LoggerFactory.getLogger((Class<?>) WebSocketImpl.class);
        this.flushandclosestate = false;
        this.readyState = ReadyState.NOT_YET_CONNECTED;
        this.draft = null;
        this.tmpHandshakeBytes = ByteBuffer.allocate(0);
        this.handshakerequest = null;
        this.closemessage = null;
        this.closecode = null;
        this.closedremotely = null;
        this.resourceDescriptor = null;
        this.lastPong = System.nanoTime();
        this.synchronizeWriteObject = new Object();
        if (webSocketListener != null && (draft != null || this.role != Role.SERVER)) {
            this.outQueue = new LinkedBlockingQueue();
            this.inQueue = new LinkedBlockingQueue();
            this.wsl = webSocketListener;
            this.role = Role.CLIENT;
            if (draft != null) {
                this.draft = draft.copyInstance();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    public void closeConnection(int i, boolean z) {
        closeConnection(i, "", z);
    }

    public void closeConnection() {
        if (this.closedremotely != null) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
            return;
        }
        throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
    }

    @Override // org.java_websocket.WebSocket
    public void closeConnection(int i, String str) {
        closeConnection(i, str, false);
    }

    @Override // org.java_websocket.WebSocket
    public void close(int i, String str) {
        close(i, str, false);
    }

    @Override // org.java_websocket.WebSocket
    public void close(int i) {
        close(i, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        close(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override // org.java_websocket.WebSocket
    public void close() {
        close(1000);
    }
}
