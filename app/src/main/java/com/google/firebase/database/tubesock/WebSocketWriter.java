package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class WebSocketWriter {
    private WritableByteChannel channel;
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private WebSocket websocket;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.getThreadFactory().newThread(new Runnable() { // from class: com.google.firebase.database.tubesock.WebSocketWriter.1
        @Override // java.lang.Runnable
        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });

    public WebSocketWriter(WebSocket webSocket, String str, int i) {
        WebSocket.getIntializer().setName(getInnerThread(), str + "Writer-" + i);
        this.websocket = webSocket;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    private ByteBuffer frameInBuffer(byte b, boolean z, byte[] bArr) throws IOException {
        int i = z ? 6 : 2;
        int length = bArr.length;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + i);
        byteBufferAllocate.put((byte) (b | Byte.MIN_VALUE));
        if (length < 126) {
            if (z) {
                length |= 128;
            }
            byteBufferAllocate.put((byte) length);
        } else if (length <= 65535) {
            byteBufferAllocate.put((byte) (z ? 254 : 126));
            byteBufferAllocate.putShort((short) length);
        } else {
            byteBufferAllocate.put((byte) (z ? 255 : 127));
            byteBufferAllocate.putInt(0);
            byteBufferAllocate.putInt(length);
        }
        if (z) {
            byte[] bArrGenerateMask = generateMask();
            byteBufferAllocate.put(bArrGenerateMask);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byteBufferAllocate.put((byte) (bArr[i2] ^ bArrGenerateMask[i2 % 4]));
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private byte[] generateMask() {
        byte[] bArr = new byte[4];
        this.random.nextBytes(bArr);
        return bArr;
    }

    private void handleError(WebSocketException webSocketException) {
        this.websocket.handleReceiverError(webSocketException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e) {
                handleError(new WebSocketException("IO Exception", e));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i = 0; i < this.pendingBuffers.size(); i++) {
            writeMessage();
        }
    }

    private void writeMessage() throws InterruptedException, IOException {
        this.channel.write(this.pendingBuffers.take());
    }

    public Thread getInnerThread() {
        return this.innerThread;
    }

    public synchronized void send(byte b, boolean z, byte[] bArr) throws IOException {
        ByteBuffer byteBufferFrameInBuffer = frameInBuffer(b, z, bArr);
        if (this.stop && (this.closeSent || b != 8)) {
            throw new WebSocketException("Shouldn't be sending");
        }
        if (b == 8) {
            this.closeSent = true;
        }
        this.pendingBuffers.add(byteBufferFrameInBuffer);
    }

    public void setOutput(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    public void stopIt() {
        this.stop = true;
    }
}
