package dc;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

/* compiled from: OrgWebsocketClient.java */
/* loaded from: classes3.dex */
public class hd2 extends WebSocketClient {
    public a a;

    /* compiled from: OrgWebsocketClient.java */
    public interface a {
        void a();

        void b(int i, String str, boolean z);

        void c(String str);

        void d(byte[] bArr);

        void onOpen();

        void onWebsocketPong(WebSocket webSocket, Framedata framedata);
    }

    public hd2(String str) throws URISyntaxException {
        super(new URI(str));
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, str, z);
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onError(Exception exc) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(String str) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onOpen();
        }
    }

    @Override // org.java_websocket.WebSocketAdapter, org.java_websocket.WebSocketListener
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onWebsocketPong(webSocket, framedata);
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(ByteBuffer byteBuffer) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.d(byteBuffer.array());
        }
    }
}
