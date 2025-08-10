package com.amazonaws.auth;

import android.support.v4.media.session.PlaybackStateCompat;
import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.broadcom.bt.util.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AwsChunkedEncodingInputStream extends SdkInputStream {
    public static final byte[] m = new byte[0];
    public static final Log n = LogFactory.b(AwsChunkedEncodingInputStream.class);
    public InputStream a;
    public final int b;
    public final byte[] c;
    public final String d;
    public final String e;
    public final String f;
    public String g;
    public final AWS4Signer h;
    public ChunkContentIterator i;
    public DecodedStreamBuffer j;
    public boolean k;
    public boolean l;

    public AwsChunkedEncodingInputStream(InputStream inputStream, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this(inputStream, 262144, bArr, str, str2, str3, aWS4Signer);
    }

    public static long m(long j) {
        return Long.toHexString(j).length() + 17 + 64 + 2 + j + 2;
    }

    public static long p(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Nonnegative content length expected.");
        }
        long j2 = j / PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        long j3 = j % PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        return (j2 * m(PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) + (j3 > 0 ? m(j3) : 0L) + m(0L);
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream j() {
        return this.a;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        f();
        if (!this.k) {
            throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
        }
        if (this.a.markSupported()) {
            Log log = n;
            if (log.isDebugEnabled()) {
                log.a("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
            }
            this.a.mark(Integer.MAX_VALUE);
        } else {
            Log log2 = n;
            if (log2.isDebugEnabled()) {
                log2.a("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
            }
            this.j = new DecodedStreamBuffer(this.b);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public final byte[] q(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(bArr.length));
        String strA = BinaryUtils.a(this.h.sign("AWS4-HMAC-SHA256-PAYLOAD\n" + this.d + IOUtils.LINE_SEPARATOR_UNIX + this.e + IOUtils.LINE_SEPARATOR_UNIX + this.g + IOUtils.LINE_SEPARATOR_UNIX + BinaryUtils.a(this.h.hash("")) + IOUtils.LINE_SEPARATOR_UNIX + BinaryUtils.a(this.h.hash(bArr)), this.c, SigningAlgorithm.HmacSHA256));
        this.g = strA;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(";chunk-signature=");
        sb2.append(strA);
        sb.append(sb2.toString());
        sb.append("\r\n");
        try {
            String string = sb.toString();
            Charset charset = StringUtils.a;
            byte[] bytes = string.getBytes(charset);
            byte[] bytes2 = "\r\n".getBytes(charset);
            byte[] bArr2 = new byte[bytes.length + bArr.length + bytes2.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length + bArr.length, bytes2.length);
            return bArr2;
        } catch (Exception e) {
            throw new AmazonClientException("Unable to sign the chunked data. " + e.getMessage(), e);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = read(bArr, 0, 1);
        if (i == -1) {
            return i;
        }
        Log log = n;
        if (log.isDebugEnabled()) {
            log.a("One byte read from the stream.");
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        f();
        this.i = null;
        this.g = this.f;
        if (this.a.markSupported()) {
            Log log = n;
            if (log.isDebugEnabled()) {
                log.a("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
            }
            this.a.reset();
        } else {
            Log log2 = n;
            if (log2.isDebugEnabled()) {
                log2.a("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
            }
            DecodedStreamBuffer decodedStreamBuffer = this.j;
            if (decodedStreamBuffer == null) {
                throw new IOException("Cannot reset the stream because the mark is not set.");
            }
            decodedStreamBuffer.d();
        }
        this.i = null;
        this.k = true;
        this.l = false;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        if (j <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(PlaybackStateCompat.ACTION_SET_REPEAT_MODE, j);
        byte[] bArr = new byte[iMin];
        long j2 = j;
        while (j2 > 0 && (i = read(bArr, 0, iMin)) >= 0) {
            j2 -= i;
        }
        return j - j2;
    }

    public final boolean x() throws IOException {
        byte[] bArr = new byte[131072];
        int i = 0;
        while (i < 131072) {
            DecodedStreamBuffer decodedStreamBuffer = this.j;
            if (decodedStreamBuffer == null || !decodedStreamBuffer.b()) {
                int i2 = this.a.read(bArr, i, 131072 - i);
                if (i2 == -1) {
                    break;
                }
                DecodedStreamBuffer decodedStreamBuffer2 = this.j;
                if (decodedStreamBuffer2 != null) {
                    decodedStreamBuffer2.a(bArr, i, i2);
                }
                i += i2;
            } else {
                bArr[i] = this.j.c();
                i++;
            }
        }
        if (i == 0) {
            this.i = new ChunkContentIterator(q(m));
            return true;
        }
        if (i < 131072) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        this.i = new ChunkContentIterator(q(bArr));
        return false;
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, int i, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this.a = null;
        this.k = true;
        this.l = false;
        if (inputStream instanceof AwsChunkedEncodingInputStream) {
            AwsChunkedEncodingInputStream awsChunkedEncodingInputStream = (AwsChunkedEncodingInputStream) inputStream;
            i = Math.max(awsChunkedEncodingInputStream.b, i);
            this.a = awsChunkedEncodingInputStream.a;
            this.j = awsChunkedEncodingInputStream.j;
        } else {
            this.a = inputStream;
            this.j = null;
        }
        if (i < 131072) {
            throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
        }
        this.b = i;
        this.c = bArr;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str3;
        this.h = aWS4Signer;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        f();
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        ChunkContentIterator chunkContentIterator = this.i;
        if (chunkContentIterator == null || !chunkContentIterator.a()) {
            if (this.l) {
                return -1;
            }
            this.l = x();
        }
        int iB = this.i.b(bArr, i, i2);
        if (iB > 0) {
            this.k = false;
            Log log = n;
            if (log.isDebugEnabled()) {
                log.a(iB + " byte read from the stream.");
            }
        }
        return iB;
    }
}
