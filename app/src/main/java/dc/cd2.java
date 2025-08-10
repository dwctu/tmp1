package dc;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/* compiled from: DxWebSocketServer.java */
/* loaded from: classes3.dex */
public class cd2 extends WebSocketServer {
    public id2 a;
    public a b;

    /* compiled from: DxWebSocketServer.java */
    public interface a {
        void a(WebSocket webSocket, String str);

        void b(WebSocket webSocket, ClientHandshake clientHandshake);

        void c(WebSocket webSocket, int i, String str, boolean z);

        void d(WebSocket webSocket, ByteBuffer byteBuffer);

        void e(WebSocket webSocket, Exception exc);

        void onStart();

        void onWebsocketPong(WebSocket webSocket, Framedata framedata);
    }

    public cd2(id2 id2Var, int i) throws UnknownHostException {
        super(new InetSocketAddress(i));
        String str = "DxWebSocketServer port: " + i;
        this.a = id2Var;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onClose(WebSocket webSocket, int i, String str, boolean z) {
        String str2 = "onClose: " + webSocket.getRemoteSocketAddress() + ", code:" + i + ", reason:" + str + ", remote:" + z;
        this.a.d(webSocket);
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(webSocket, i, str, z);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onError(WebSocket webSocket, Exception exc) {
        String str = "onError: " + exc.getMessage();
        a aVar = this.b;
        if (aVar != null) {
            aVar.e(webSocket, exc);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(webSocket, str);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        String str = "onOpen: " + webSocket.getRemoteSocketAddress();
        this.a.e(webSocket.getRemoteSocketAddress() + "", webSocket);
        a aVar = this.b;
        if (aVar != null) {
            aVar.b(webSocket, clientHandshake);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onStart() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onStart();
        }
    }

    @Override // org.java_websocket.WebSocketAdapter, org.java_websocket.WebSocketListener
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onWebsocketPong(webSocket, framedata);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.d(webSocket, byteBuffer);
        }
    }
}
