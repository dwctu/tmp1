package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class zf {
    public ByteBuffer b;
    public yf c;
    public final byte[] a = new byte[256];
    public int d = 0;

    public void a() {
        this.b = null;
        this.c = null;
    }

    public final boolean b() {
        return this.c.b != 0;
    }

    @NonNull
    public yf c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.c;
        }
        k();
        if (!b()) {
            h();
            yf yfVar = this.c;
            if (yfVar.c < 0) {
                yfVar.b = 1;
            }
        }
        return this.c;
    }

    public final int d() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void e() {
        this.c.d.a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int iD = d();
        boolean z = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        xf xfVar = this.c.d;
        xfVar.e = (iD & 64) != 0;
        if (z) {
            xfVar.k = g(iPow);
        } else {
            xfVar.k = null;
        }
        this.c.d.j = this.b.position();
        r();
        if (b()) {
            return;
        }
        yf yfVar = this.c;
        yfVar.c++;
        yfVar.e.add(yfVar.d);
    }

    public final void f() {
        int iD = d();
        this.d = iD;
        if (iD <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.d;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.b.get(this.a, i, i2);
                i += i2;
            } catch (Exception unused) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    String str = "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d;
                }
                this.c.b = 1;
                return;
            }
        }
    }

    @Nullable
    public final int[] g(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = bArr[i3] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                int i8 = i6 + 1;
                int i9 = i2 + 1;
                iArr[i2] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
                i2 = i9;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.c.b = 1;
        }
        return iArr;
    }

    public final void h() {
        i(Integer.MAX_VALUE);
    }

    public final void i(int i) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.c.d = new xf();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                yf yfVar = this.c;
                if (yfVar.d == null) {
                    yfVar.d = new xf();
                }
                e();
            } else if (iD != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    public final void j() {
        d();
        int iD = d();
        xf xfVar = this.c.d;
        int i = (iD & 28) >> 2;
        xfVar.g = i;
        if (i == 0) {
            xfVar.g = 1;
        }
        xfVar.f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        xf xfVar2 = this.c.d;
        xfVar2.i = iN * 10;
        xfVar2.h = d();
        d();
    }

    public final void k() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        l();
        if (!this.c.h || b()) {
            return;
        }
        yf yfVar = this.c;
        yfVar.a = g(yfVar.i);
        yf yfVar2 = this.c;
        yfVar2.l = yfVar2.a[yfVar2.j];
    }

    public final void l() {
        this.c.f = n();
        this.c.g = n();
        int iD = d();
        yf yfVar = this.c;
        yfVar.h = (iD & 128) != 0;
        yfVar.i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.c.j = d();
        this.c.k = d();
    }

    public final void m() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int n() {
        return this.b.getShort();
    }

    public final void o() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new yf();
        this.d = 0;
    }

    public zf p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void q() {
        int iD;
        do {
            iD = d();
            this.b.position(Math.min(this.b.position() + iD, this.b.limit()));
        } while (iD > 0);
    }

    public final void r() {
        d();
        q();
    }
}
