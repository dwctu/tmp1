package dc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: AesCipherInputStream.java */
/* loaded from: classes5.dex */
public class q84 extends r84<d84> {
    public byte[] e;
    public byte[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    public q84(z84 z84Var, l94 l94Var, char[] cArr, int i, boolean z) throws IOException {
        super(z84Var, l94Var, cArr, i, z);
        this.e = new byte[1];
        this.f = new byte[16];
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
    }

    public final byte[] A(l94 l94Var) throws IOException {
        if (l94Var.b() == null) {
            throw new IOException("invalid aes extra data record");
        }
        d94 d94VarB = l94Var.b();
        if (d94VarB.b() == null) {
            throw new IOException("Invalid aes key strength in aes extra data record");
        }
        byte[] bArr = new byte[d94VarB.b().getSaltLength()];
        p(bArr);
        return bArr;
    }

    public final void C(int i) {
        int i2 = this.g + i;
        this.g = i2;
        if (i2 >= 15) {
            this.g = 15;
        }
    }

    @Override // dc.r84
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public d84 m(l94 l94Var, char[] cArr, boolean z) throws IOException {
        return new d84(l94Var.b(), cArr, A(l94Var), y(), z);
    }

    public byte[] K(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (ja4.i(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new ZipException("Invalid AES Mac bytes. Could not read sufficient data");
    }

    public final void L(byte[] bArr, int i) throws IOException {
        byte[] bArr2 = new byte[10];
        System.arraycopy(f().b(i), 0, bArr2, 0, 10);
        if (!Arrays.equals(bArr, bArr2)) {
            throw new IOException("Reached end of data for this entry, but aes verification failed");
        }
    }

    @Override // dc.r84
    public void e(InputStream inputStream, int i) throws IOException {
        L(K(inputStream), i);
    }

    public final void q(byte[] bArr, int i) {
        int i2 = this.i;
        int i3 = this.h;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.l = i2;
        System.arraycopy(this.f, this.g, bArr, i, i2);
        C(this.l);
        x(this.l);
        int i4 = this.k;
        int i5 = this.l;
        this.k = i4 + i5;
        this.i -= i5;
        this.j += i5;
    }

    @Override // dc.r84, java.io.InputStream
    public int read() throws IOException {
        if (read(this.e) == -1) {
            return -1;
        }
        return this.e[0];
    }

    public final void x(int i) {
        int i2 = this.h - i;
        this.h = i2;
        if (i2 <= 0) {
            this.h = 0;
        }
    }

    public final byte[] y() throws IOException {
        byte[] bArr = new byte[2];
        p(bArr);
        return bArr;
    }

    @Override // dc.r84, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // dc.r84, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.i = i2;
        this.j = i;
        this.k = 0;
        if (this.h != 0) {
            q(bArr, i);
            int i3 = this.k;
            if (i3 == i2) {
                return i3;
            }
        }
        if (this.i < 16) {
            byte[] bArr2 = this.f;
            int i4 = super.read(bArr2, 0, bArr2.length);
            this.m = i4;
            this.g = 0;
            if (i4 == -1) {
                this.h = 0;
                int i5 = this.k;
                if (i5 > 0) {
                    return i5;
                }
                return -1;
            }
            this.h = i4;
            q(bArr, this.j);
            int i6 = this.k;
            if (i6 == i2) {
                return i6;
            }
        }
        int i7 = this.j;
        int i8 = this.i;
        int i9 = super.read(bArr, i7, i8 - (i8 % 16));
        if (i9 == -1) {
            int i10 = this.k;
            if (i10 > 0) {
                return i10;
            }
            return -1;
        }
        return i9 + this.k;
    }
}
