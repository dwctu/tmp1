package com.koushikdutta.async.http;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.callback.DataCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
public abstract class HybiParser {
    private static final long BASE = 2;
    private static final int BYTE = 255;
    private static final int FIN = 128;
    private static final int LENGTH = 127;
    private static final int MASK = 128;
    private static final int MODE_BINARY = 2;
    private static final int MODE_TEXT = 1;
    private static final int OPCODE = 15;
    private static final int OP_BINARY = 2;
    private static final int OP_CLOSE = 8;
    private static final int OP_CONTINUATION = 0;
    private static final int OP_PING = 9;
    private static final int OP_PONG = 10;
    private static final int OP_TEXT = 1;
    private static final int RSV1 = 64;
    private static final int RSV2 = 32;
    private static final int RSV3 = 16;
    private static final String TAG = "HybiParser";
    private static final long _2_TO_16_ = 65536;
    private static final long _2_TO_24 = 16777216;
    private static final long _2_TO_32_ = 4294967296L;
    private static final long _2_TO_40_ = 1099511627776L;
    private static final long _2_TO_48_ = 281474976710656L;
    private static final long _2_TO_56_ = 72057594037927936L;
    private static final long _2_TO_8_ = 256;
    private boolean mDeflated;
    private boolean mFinal;
    private int mLength;
    private int mLengthSize;
    private boolean mMasked;
    private int mMode;
    private int mOpcode;
    private DataEmitterReader mReader;
    private int mStage;
    private static final List<Integer> OPCODES = Arrays.asList(0, 1, 2, 8, 9, 10);
    private static final List<Integer> FRAGMENTED_OPCODES = Arrays.asList(0, 1, 2);
    private boolean mMasking = true;
    private boolean mDeflate = false;
    private byte[] mMask = new byte[0];
    private byte[] mPayload = new byte[0];
    private boolean mClosed = false;
    private ByteArrayOutputStream mBuffer = new ByteArrayOutputStream();
    private Inflater mInflater = new Inflater(true);
    private byte[] mInflateBuffer = new byte[4096];
    public DataCallback mStage0 = new DataCallback() { // from class: com.koushikdutta.async.http.HybiParser.1
        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            try {
                HybiParser.this.parseOpcode(byteBufferList.get());
            } catch (ProtocolError e) {
                HybiParser.this.report(e);
                e.printStackTrace();
            }
            HybiParser.this.parse();
        }
    };
    public DataCallback mStage1 = new DataCallback() { // from class: com.koushikdutta.async.http.HybiParser.2
        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser.this.parseLength(byteBufferList.get());
            HybiParser.this.parse();
        }
    };
    public DataCallback mStage2 = new DataCallback() { // from class: com.koushikdutta.async.http.HybiParser.3
        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[HybiParser.this.mLengthSize];
            byteBufferList.get(bArr);
            try {
                HybiParser.this.parseExtendedLength(bArr);
            } catch (ProtocolError e) {
                HybiParser.this.report(e);
                e.printStackTrace();
            }
            HybiParser.this.parse();
        }
    };
    public DataCallback mStage3 = new DataCallback() { // from class: com.koushikdutta.async.http.HybiParser.4
        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser.this.mMask = new byte[4];
            byteBufferList.get(HybiParser.this.mMask);
            HybiParser.this.mStage = 4;
            HybiParser.this.parse();
        }
    };
    public DataCallback mStage4 = new DataCallback() { // from class: com.koushikdutta.async.http.HybiParser.5
        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser hybiParser = HybiParser.this;
            hybiParser.mPayload = new byte[hybiParser.mLength];
            byteBufferList.get(HybiParser.this.mPayload);
            try {
                HybiParser.this.emitFrame();
            } catch (IOException e) {
                HybiParser.this.report(e);
                e.printStackTrace();
            }
            HybiParser.this.mStage = 0;
            HybiParser.this.parse();
        }
    };

    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    public HybiParser(DataEmitter dataEmitter) {
        DataEmitterReader dataEmitterReader = new DataEmitterReader();
        this.mReader = dataEmitterReader;
        dataEmitter.setDataCallback(dataEmitterReader);
        parse();
    }

    private static long byteArrayToLong(byte[] bArr, int i, int i2) {
        if (bArr.length < i2) {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j += (bArr[i3 + i] & 255) << (((i2 - 1) - i3) * 8);
        }
        return j;
    }

    private byte[] decode(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitFrame() throws IOException {
        byte[] bArrMask = mask(this.mPayload, this.mMask, 0);
        if (this.mDeflated) {
            try {
                bArrMask = inflate(bArrMask);
            } catch (DataFormatException unused) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i = this.mOpcode;
        if (i == 0) {
            if (this.mMode == 0) {
                throw new ProtocolError("Mode was not set.");
            }
            this.mBuffer.write(bArrMask);
            if (this.mFinal) {
                byte[] byteArray = this.mBuffer.toByteArray();
                if (this.mMode == 1) {
                    onMessage(encode(byteArray));
                } else {
                    onMessage(byteArray);
                }
                reset();
                return;
            }
            return;
        }
        if (i == 1) {
            if (this.mFinal) {
                onMessage(encode(bArrMask));
                return;
            } else {
                this.mMode = 1;
                this.mBuffer.write(bArrMask);
                return;
            }
        }
        if (i == 2) {
            if (this.mFinal) {
                onMessage(bArrMask);
                return;
            } else {
                this.mMode = 2;
                this.mBuffer.write(bArrMask);
                return;
            }
        }
        if (i == 8) {
            onDisconnect(bArrMask.length >= 2 ? (bArrMask[1] & 255) + ((bArrMask[0] & 255) * 256) : 0, bArrMask.length > 2 ? encode(slice(bArrMask, 2)) : null);
            return;
        }
        if (i != 9) {
            if (i == 10) {
                onPong(encode(bArrMask));
            }
        } else {
            if (bArrMask.length > 125) {
                throw new ProtocolError("Ping payload too large");
            }
            String strEncode = encode(bArrMask);
            sendFrame(frame(10, bArrMask, -1));
            onPing(strEncode);
        }
    }

    private String encode(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private int getInteger(byte[] bArr) throws ProtocolError {
        long jByteArrayToLong = byteArrayToLong(bArr, 0, bArr.length);
        if (jByteArrayToLong >= 0 && jByteArrayToLong <= 2147483647L) {
            return (int) jByteArrayToLong;
        }
        throw new ProtocolError("Bad integer: " + jByteArrayToLong);
    }

    private byte[] inflate(byte[] bArr) throws DataFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.mInflater.setInput(bArr);
        while (!this.mInflater.needsInput()) {
            byteArrayOutputStream.write(this.mInflateBuffer, 0, this.mInflater.inflate(this.mInflateBuffer));
        }
        this.mInflater.setInput(new byte[]{0, 0, -1, -1});
        while (!this.mInflater.needsInput()) {
            byteArrayOutputStream.write(this.mInflateBuffer, 0, this.mInflater.inflate(this.mInflateBuffer));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] mask(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i2 = 0; i2 < bArr.length - i; i2++) {
            int i3 = i + i2;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i2 % 4]);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseExtendedLength(byte[] bArr) throws ProtocolError {
        this.mLength = getInteger(bArr);
        this.mStage = this.mMasked ? 3 : 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseLength(byte b) {
        boolean z = (b & 128) == 128;
        this.mMasked = z;
        int i = b & Byte.MAX_VALUE;
        this.mLength = i;
        if (i >= 0 && i <= 125) {
            this.mStage = z ? 3 : 4;
        } else {
            this.mLengthSize = i == 126 ? 2 : 8;
            this.mStage = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseOpcode(byte b) throws ProtocolError {
        boolean z = (b & SignedBytes.MAX_POWER_OF_TWO) == 64;
        boolean z2 = (b & 32) == 32;
        boolean z3 = (b & 16) == 16;
        if ((!this.mDeflate && z) || z2 || z3) {
            throw new ProtocolError("RSV not zero");
        }
        this.mFinal = (b & 128) == 128;
        int i = b & Ascii.SI;
        this.mOpcode = i;
        this.mDeflated = z;
        this.mMask = new byte[0];
        this.mPayload = new byte[0];
        if (!OPCODES.contains(Integer.valueOf(i))) {
            throw new ProtocolError("Bad opcode");
        }
        if (!FRAGMENTED_OPCODES.contains(Integer.valueOf(this.mOpcode)) && !this.mFinal) {
            throw new ProtocolError("Expected non-final packet");
        }
        this.mStage = 1;
    }

    private void reset() {
        this.mMode = 0;
        this.mBuffer.reset();
    }

    private byte[] slice(byte[] bArr, int i) {
        byte[] bArr2 = new byte[bArr.length - i];
        System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
        return bArr2;
    }

    public void close(int i, String str) {
        if (this.mClosed) {
            return;
        }
        sendFrame(frame(8, str, i));
        this.mClosed = true;
    }

    public void finalize() throws Throwable {
        Inflater inflater = this.mInflater;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Exception unused) {
            }
        }
        super.finalize();
    }

    public byte[] frame(String str) {
        return frame(1, str, -1);
    }

    public abstract void onDisconnect(int i, String str);

    public abstract void onMessage(String str);

    public abstract void onMessage(byte[] bArr);

    public abstract void onPing(String str);

    public abstract void onPong(String str);

    public void parse() {
        int i = this.mStage;
        if (i == 0) {
            this.mReader.read(1, this.mStage0);
            return;
        }
        if (i == 1) {
            this.mReader.read(1, this.mStage1);
            return;
        }
        if (i == 2) {
            this.mReader.read(this.mLengthSize, this.mStage2);
        } else if (i == 3) {
            this.mReader.read(4, this.mStage3);
        } else {
            if (i != 4) {
                return;
            }
            this.mReader.read(this.mLength, this.mStage4);
        }
    }

    public byte[] pingFrame(String str) {
        return frame(9, str, -1);
    }

    public byte[] pongFrame(String str) {
        return frame(10, str, -1);
    }

    public abstract void report(Exception exc);

    public abstract void sendFrame(byte[] bArr);

    public void setDeflate(boolean z) {
        this.mDeflate = z;
    }

    public void setMasking(boolean z) {
        this.mMasking = z;
    }

    public byte[] frame(byte[] bArr) {
        return frame(2, bArr, -1);
    }

    public byte[] frame(byte[] bArr, int i, int i2) {
        return frame(2, bArr, -1, i, i2);
    }

    private byte[] frame(int i, byte[] bArr, int i2) {
        return frame(i, bArr, i2, 0, bArr.length);
    }

    private byte[] frame(int i, String str, int i2) {
        return frame(i, decode(str), i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] frame(int r22, byte[] r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HybiParser.frame(int, byte[], int, int, int):byte[]");
    }
}
