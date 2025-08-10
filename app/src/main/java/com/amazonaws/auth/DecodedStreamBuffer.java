package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public class DecodedStreamBuffer {
    public static final Log f = LogFactory.b(DecodedStreamBuffer.class);
    public byte[] a;
    public int b;
    public int c;
    public int d = -1;
    public boolean e;

    public DecodedStreamBuffer(int i) {
        this.a = new byte[i];
        this.b = i;
    }

    public void a(byte[] bArr, int i, int i2) {
        this.d = -1;
        int i3 = this.c;
        if (i3 + i2 <= this.b) {
            System.arraycopy(bArr, i, this.a, i3, i2);
            this.c += i2;
            return;
        }
        Log log = f;
        if (log.isDebugEnabled()) {
            log.a("Buffer size " + this.b + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
        }
        this.e = true;
    }

    public boolean b() {
        int i = this.d;
        return i != -1 && i < this.c;
    }

    public byte c() {
        byte[] bArr = this.a;
        int i = this.d;
        this.d = i + 1;
        return bArr[i];
    }

    public void d() {
        if (!this.e) {
            this.d = 0;
            return;
        }
        throw new AmazonClientException("The input stream is not repeatable since the buffer size " + this.b + " has been exceeded.");
    }
}
