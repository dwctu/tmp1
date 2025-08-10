package dc;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.wf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class ag implements wf {
    public static final String u = "ag";

    @ColorInt
    public int[] a;

    @ColorInt
    public final int[] b;
    public final wf.a c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;

    @ColorInt
    public int[] j;
    public int k;
    public yf l;
    public Bitmap m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;

    @Nullable
    public Boolean s;

    @NonNull
    public Bitmap.Config t;

    public ag(@NonNull wf.a aVar, yf yfVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        p(yfVar, byteBuffer, i);
    }

    @Override // dc.wf
    public void a() {
        this.k = (this.k + 1) % this.l.c;
    }

    @Override // dc.wf
    public int b() {
        return this.l.c;
    }

    @Override // dc.wf
    public void c(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // dc.wf
    public void clear() {
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null) {
            this.c.e(bArr);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.c.a(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.e(bArr2);
        }
    }

    @Override // dc.wf
    public int d() {
        int i;
        if (this.l.c <= 0 || (i = this.k) < 0) {
            return 0;
        }
        return l(i);
    }

    @Override // dc.wf
    public void e() {
        this.k = -1;
    }

    @Override // dc.wf
    public int f() {
        return this.k;
    }

    @Override // dc.wf
    public int g() {
        return this.d.limit() + this.i.length + (this.j.length * 4);
    }

    @Override // dc.wf
    @NonNull
    public ByteBuffer getData() {
        return this.d;
    }

    @Override // dc.wf
    @Nullable
    public synchronized Bitmap getNextFrame() {
        if (this.l.c <= 0 || this.k < 0) {
            if (Log.isLoggable(u, 3)) {
                String str = "Unable to decode frame, frameCount=" + this.l.c + ", framePointer=" + this.k;
            }
            this.o = 1;
        }
        int i = this.o;
        if (i != 1 && i != 2) {
            this.o = 0;
            if (this.e == null) {
                this.e = this.c.b(255);
            }
            xf xfVar = this.l.e.get(this.k);
            int i2 = this.k - 1;
            xf xfVar2 = i2 >= 0 ? this.l.e.get(i2) : null;
            int[] iArr = xfVar.k;
            if (iArr == null) {
                iArr = this.l.a;
            }
            this.a = iArr;
            if (iArr == null) {
                if (Log.isLoggable(u, 3)) {
                    String str2 = "No valid color table found for frame #" + this.k;
                }
                this.o = 1;
                return null;
            }
            if (xfVar.f) {
                System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                int[] iArr2 = this.b;
                this.a = iArr2;
                iArr2[xfVar.h] = 0;
                if (xfVar.g == 2 && this.k == 0) {
                    this.s = Boolean.TRUE;
                }
            }
            return q(xfVar, xfVar2);
        }
        if (Log.isLoggable(u, 3)) {
            String str3 = "Unable to decode frame, status=" + this.o;
        }
        return null;
    }

    @ColorInt
    public final int h(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.p + i; i9++) {
            byte[] bArr = this.i;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.a[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.p + i11; i12++) {
            byte[] bArr2 = this.i;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.a[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    public final void i(xf xfVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.j;
        int i6 = xfVar.d;
        int i7 = this.p;
        int i8 = i6 / i7;
        int i9 = xfVar.b / i7;
        int i10 = xfVar.c / i7;
        int i11 = xfVar.a / i7;
        boolean z = this.k == 0;
        int i12 = this.r;
        int i13 = this.q;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        Boolean bool = this.s;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i15 < i8) {
            Boolean bool2 = bool;
            if (xfVar.e) {
                if (i16 >= i8) {
                    i = i8;
                    int i18 = i17 + 1;
                    if (i18 == 2) {
                        i17 = i18;
                        i16 = 4;
                    } else if (i18 == 3) {
                        i17 = i18;
                        i16 = 2;
                        i14 = 4;
                    } else if (i18 != 4) {
                        i17 = i18;
                    } else {
                        i17 = i18;
                        i16 = 1;
                        i14 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i16 + i14;
            } else {
                i = i8;
                i2 = i16;
                i16 = i15;
            }
            int i19 = i16 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i15 * i7 * xfVar.c;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i9;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i26;
                    }
                } else {
                    i5 = i9;
                    int i28 = ((i22 - i21) * i7) + i24;
                    int i29 = i21;
                    while (true) {
                        i4 = i10;
                        if (i29 < i22) {
                            int iH = h(i24, i28, xfVar.c);
                            if (iH != 0) {
                                iArr[i29] = iH;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i24 += i7;
                            i29++;
                            i10 = i4;
                        }
                    }
                    bool = bool2;
                    i15++;
                    i9 = i5;
                    i10 = i4;
                    i8 = i;
                    i16 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i9;
            i4 = i10;
            bool = bool2;
            i15++;
            i9 = i5;
            i10 = i4;
            i8 = i;
            i16 = i3;
        }
        Boolean bool3 = bool;
        if (this.s == null) {
            this.s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    public final void j(xf xfVar) {
        xf xfVar2 = xfVar;
        int[] iArr = this.j;
        int i = xfVar2.d;
        int i2 = xfVar2.b;
        int i3 = xfVar2.c;
        int i4 = xfVar2.a;
        boolean z = this.k == 0;
        int i5 = this.r;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = xfVar2.c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            xfVar2 = xfVar;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final void k(xf xfVar) {
        int i;
        int i2;
        short s;
        ag agVar = this;
        if (xfVar != null) {
            agVar.d.position(xfVar.j);
        }
        if (xfVar == null) {
            yf yfVar = agVar.l;
            i = yfVar.f;
            i2 = yfVar.g;
        } else {
            i = xfVar.c;
            i2 = xfVar.d;
        }
        int i3 = i * i2;
        byte[] bArr = agVar.i;
        if (bArr == null || bArr.length < i3) {
            agVar.i = agVar.c.b(i3);
        }
        byte[] bArr2 = agVar.i;
        if (agVar.f == null) {
            agVar.f = new short[4096];
        }
        short[] sArr = agVar.f;
        if (agVar.g == null) {
            agVar.g = new byte[4096];
        }
        byte[] bArr3 = agVar.g;
        if (agVar.h == null) {
            agVar.h = new byte[4097];
        }
        byte[] bArr4 = agVar.h;
        int iO = o();
        int i4 = 1 << iO;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iO + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = agVar.e;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int iN = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = -1;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (iN == 0) {
                iN = n();
                if (iN <= 0) {
                    agVar.o = 3;
                    break;
                }
                i14 = 0;
            }
            i16 += (bArr5[i14] & 255) << i15;
            i14++;
            iN--;
            int i21 = i15 + 8;
            int i22 = i12;
            int i23 = i11;
            int i24 = i18;
            int i25 = i7;
            int i26 = i19;
            while (true) {
                if (i21 < i23) {
                    i18 = i24;
                    i12 = i22;
                    i15 = i21;
                    agVar = this;
                    i19 = i26;
                    i7 = i25;
                    i11 = i23;
                    break;
                }
                int i27 = i6;
                int i28 = i16 & i13;
                i16 >>= i23;
                i21 -= i23;
                if (i28 == i4) {
                    i13 = i8;
                    i23 = i25;
                    i22 = i27;
                    i6 = i22;
                    i24 = -1;
                } else {
                    if (i28 == i5) {
                        i15 = i21;
                        i19 = i26;
                        i12 = i22;
                        i7 = i25;
                        i6 = i27;
                        i18 = i24;
                        i11 = i23;
                        agVar = this;
                        break;
                    }
                    if (i24 == -1) {
                        bArr2[i17] = bArr3[i28];
                        i17++;
                        i9++;
                        i24 = i28;
                        i26 = i24;
                        i6 = i27;
                        i21 = i21;
                    } else {
                        if (i28 >= i22) {
                            bArr4[i20] = (byte) i26;
                            i20++;
                            s = i24;
                        } else {
                            s = i28;
                        }
                        while (s >= i4) {
                            bArr4[i20] = bArr3[s];
                            i20++;
                            s = sArr[s];
                        }
                        i26 = bArr3[s] & 255;
                        byte b = (byte) i26;
                        bArr2[i17] = b;
                        while (true) {
                            i17++;
                            i9++;
                            if (i20 <= 0) {
                                break;
                            }
                            i20--;
                            bArr2[i17] = bArr4[i20];
                        }
                        byte[] bArr6 = bArr4;
                        if (i22 < 4096) {
                            sArr[i22] = (short) i24;
                            bArr3[i22] = b;
                            i22++;
                            if ((i22 & i13) == 0 && i22 < 4096) {
                                i23++;
                                i13 += i22;
                            }
                        }
                        i24 = i28;
                        i6 = i27;
                        i21 = i21;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i17, i3, (byte) 0);
    }

    public int l(int i) {
        if (i >= 0) {
            yf yfVar = this.l;
            if (i < yfVar.c) {
                return yfVar.e.get(i).i;
            }
        }
        return -1;
    }

    public final Bitmap m() {
        Boolean bool = this.s;
        Bitmap bitmapC = this.c.c(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapC.setHasAlpha(true);
        return bitmapC;
    }

    public final int n() {
        int iO = o();
        if (iO <= 0) {
            return iO;
        }
        ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(iO, byteBuffer.remaining()));
        return iO;
    }

    public final int o() {
        return this.d.get() & 255;
    }

    public synchronized void p(@NonNull yf yfVar, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int iHighestOneBit = Integer.highestOneBit(i);
        this.o = 0;
        this.l = yfVar;
        this.k = -1;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.d = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.n = false;
        Iterator<xf> it = yfVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.n = true;
                break;
            }
        }
        this.p = iHighestOneBit;
        int i2 = yfVar.f;
        this.r = i2 / iHighestOneBit;
        int i3 = yfVar.g;
        this.q = i3 / iHighestOneBit;
        this.i = this.c.b(i2 * i3);
        this.j = this.c.d(this.r * this.q);
    }

    public final Bitmap q(xf xfVar, xf xfVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.j;
        int i3 = 0;
        if (xfVar2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.c.a(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (xfVar2 != null && xfVar2.g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (xfVar2 != null && (i2 = xfVar2.g) > 0) {
            if (i2 == 2) {
                if (!xfVar.f) {
                    yf yfVar = this.l;
                    int i4 = yfVar.l;
                    if (xfVar.k == null || yfVar.j != xfVar.h) {
                        i3 = i4;
                    }
                }
                int i5 = xfVar2.d;
                int i6 = this.p;
                int i7 = i5 / i6;
                int i8 = xfVar2.b / i6;
                int i9 = xfVar2.c / i6;
                int i10 = xfVar2.a / i6;
                int i11 = this.r;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.r;
                }
            } else if (i2 == 3 && (bitmap = this.m) != null) {
                int i16 = this.r;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.q);
            }
        }
        k(xfVar);
        if (xfVar.e || this.p != 1) {
            i(xfVar);
        } else {
            j(xfVar);
        }
        if (this.n && ((i = xfVar.g) == 0 || i == 1)) {
            if (this.m == null) {
                this.m = m();
            }
            Bitmap bitmap3 = this.m;
            int i17 = this.r;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.q);
        }
        Bitmap bitmapM = m();
        int i18 = this.r;
        bitmapM.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        return bitmapM;
    }

    public ag(@NonNull wf.a aVar) {
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.l = new yf();
    }
}
