package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;

/* loaded from: classes5.dex */
public class Socks5Client {
    public String digest;
    public Bytestream.StreamHost streamHost;

    public Socks5Client(Bytestream.StreamHost streamHost, String str) {
        this.streamHost = streamHost;
        this.digest = str;
    }

    private byte[] createSocks5ConnectRequest() {
        byte[] bytes = this.digest.getBytes();
        int length = bytes.length + 7;
        byte[] bArr = new byte[length];
        bArr[0] = 5;
        bArr[1] = 1;
        bArr[2] = 0;
        bArr[3] = 3;
        bArr[4] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        bArr[length - 2] = 0;
        bArr[length - 1] = 0;
        return bArr;
    }

    public boolean establish(Socket socket) throws SmackException, IOException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.write(new byte[]{5, 1, 0});
        dataOutputStream.flush();
        byte[] bArr = new byte[2];
        dataInputStream.readFully(bArr);
        if (bArr[0] != 5 || bArr[1] != 0) {
            return false;
        }
        byte[] bArrCreateSocks5ConnectRequest = createSocks5ConnectRequest();
        dataOutputStream.write(bArrCreateSocks5ConnectRequest);
        dataOutputStream.flush();
        byte[] bArrReceiveSocks5Message = Socks5Utils.receiveSocks5Message(dataInputStream);
        bArrCreateSocks5ConnectRequest[1] = 0;
        return Arrays.equals(bArrCreateSocks5ConnectRequest, bArrReceiveSocks5Message);
    }

    public Socket getSocket(int i) throws SmackException, InterruptedException, TimeoutException, IOException, XMPPException {
        FutureTask futureTask = new FutureTask(new Callable<Socket>() { // from class: org.jivesoftware.smackx.bytestreams.socks5.Socks5Client.1
            @Override // java.util.concurrent.Callable
            public Socket call() throws SmackException, IOException {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(Socks5Client.this.streamHost.getAddress(), Socks5Client.this.streamHost.getPort()));
                try {
                    if (Socks5Client.this.establish(socket)) {
                        return socket;
                    }
                    socket.close();
                    throw new SmackException("SOCKS5 negotiation failed");
                } catch (SmackException e) {
                    socket.close();
                    throw e;
                }
            }
        });
        new Thread(futureTask).start();
        try {
            return (Socket) futureTask.get(i, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                }
                if (cause instanceof SmackException) {
                    throw ((SmackException) cause);
                }
            }
            throw new IOException("Error while connection to SOCKS5 proxy");
        }
    }
}
