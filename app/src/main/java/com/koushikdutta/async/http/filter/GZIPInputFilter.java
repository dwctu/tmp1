package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.PushParser;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.UShort;

/* loaded from: classes3.dex */
public class GZIPInputFilter extends InflaterInputFilter {
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    public CRC32 crc;
    public boolean mNeedsHeader;

    /* renamed from: com.koushikdutta.async.http.filter.GZIPInputFilter$1, reason: invalid class name */
    public class AnonymousClass1 implements PushParser.ParseCallback<byte[]> {
        public int flags;
        public boolean hcrc;
        public final /* synthetic */ DataEmitter val$emitter;
        public final /* synthetic */ PushParser val$parser;

        public AnonymousClass1(DataEmitter dataEmitter, PushParser pushParser) {
            this.val$emitter = dataEmitter;
            this.val$parser = pushParser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void done() {
            if (this.hcrc) {
                this.val$parser.readByteArray(2, new PushParser.ParseCallback<byte[]>() { // from class: com.koushikdutta.async.http.filter.GZIPInputFilter.1.3
                    @Override // com.koushikdutta.async.PushParser.ParseCallback
                    public void parsed(byte[] bArr) {
                        if (((short) GZIPInputFilter.this.crc.getValue()) != GZIPInputFilter.peekShort(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                            GZIPInputFilter.this.report(new IOException("CRC mismatch"));
                            return;
                        }
                        GZIPInputFilter.this.crc.reset();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        GZIPInputFilter gZIPInputFilter = GZIPInputFilter.this;
                        gZIPInputFilter.mNeedsHeader = false;
                        gZIPInputFilter.setDataEmitter(anonymousClass1.val$emitter);
                    }
                });
                return;
            }
            GZIPInputFilter gZIPInputFilter = GZIPInputFilter.this;
            gZIPInputFilter.mNeedsHeader = false;
            gZIPInputFilter.setDataEmitter(this.val$emitter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void next() {
            PushParser pushParser = new PushParser(this.val$emitter);
            DataCallback dataCallback = new DataCallback() { // from class: com.koushikdutta.async.http.filter.GZIPInputFilter.1.2
                @Override // com.koushikdutta.async.callback.DataCallback
                public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                    if (AnonymousClass1.this.hcrc) {
                        while (byteBufferList.size() > 0) {
                            ByteBuffer byteBufferRemove = byteBufferList.remove();
                            GZIPInputFilter.this.crc.update(byteBufferRemove.array(), byteBufferRemove.arrayOffset() + byteBufferRemove.position(), byteBufferRemove.remaining());
                            ByteBufferList.reclaim(byteBufferRemove);
                        }
                    }
                    byteBufferList.recycle();
                    AnonymousClass1.this.done();
                }
            };
            int i = this.flags;
            if ((i & 8) != 0) {
                pushParser.until((byte) 0, dataCallback);
            } else if ((i & 16) != 0) {
                pushParser.until((byte) 0, dataCallback);
            } else {
                done();
            }
        }

        @Override // com.koushikdutta.async.PushParser.ParseCallback
        public void parsed(byte[] bArr) {
            short sPeekShort = GZIPInputFilter.peekShort(bArr, 0, ByteOrder.LITTLE_ENDIAN);
            if (sPeekShort != -29921) {
                GZIPInputFilter.this.report(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", Short.valueOf(sPeekShort))));
                this.val$emitter.setDataCallback(new DataCallback.NullDataCallback());
                return;
            }
            byte b = bArr[3];
            this.flags = b;
            boolean z = (b & 2) != 0;
            this.hcrc = z;
            if (z) {
                GZIPInputFilter.this.crc.update(bArr, 0, bArr.length);
            }
            if ((this.flags & 4) != 0) {
                this.val$parser.readByteArray(2, new PushParser.ParseCallback<byte[]>() { // from class: com.koushikdutta.async.http.filter.GZIPInputFilter.1.1
                    @Override // com.koushikdutta.async.PushParser.ParseCallback
                    public void parsed(byte[] bArr2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (anonymousClass1.hcrc) {
                            GZIPInputFilter.this.crc.update(bArr2, 0, 2);
                        }
                        AnonymousClass1.this.val$parser.readByteArray(GZIPInputFilter.peekShort(bArr2, 0, ByteOrder.LITTLE_ENDIAN) & UShort.MAX_VALUE, new PushParser.ParseCallback<byte[]>() { // from class: com.koushikdutta.async.http.filter.GZIPInputFilter.1.1.1
                            @Override // com.koushikdutta.async.PushParser.ParseCallback
                            public void parsed(byte[] bArr3) {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                if (anonymousClass12.hcrc) {
                                    GZIPInputFilter.this.crc.update(bArr3, 0, bArr3.length);
                                }
                                AnonymousClass1.this.next();
                            }
                        });
                    }
                });
            } else {
                next();
            }
        }
    }

    public GZIPInputFilter() {
        super(new Inflater(true));
        this.mNeedsHeader = true;
        this.crc = new CRC32();
    }

    public static short peekShort(byte[] bArr, int i, ByteOrder byteOrder) {
        int i2;
        byte b;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i2 = bArr[i] << 8;
            b = bArr[i + 1];
        } else {
            i2 = bArr[i + 1] << 8;
            b = bArr[i];
        }
        return (short) ((b & 255) | i2);
    }

    public static int unsignedToBytes(byte b) {
        return b & 255;
    }

    @Override // com.koushikdutta.async.http.filter.InflaterInputFilter, com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) throws DataFormatException {
        if (!this.mNeedsHeader) {
            super.onDataAvailable(dataEmitter, byteBufferList);
        } else {
            PushParser pushParser = new PushParser(dataEmitter);
            pushParser.readByteArray(10, new AnonymousClass1(dataEmitter, pushParser));
        }
    }
}
