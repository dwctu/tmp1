package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.broadcom.bt.util.io.IOUtils;
import dc.i9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class cb extends va {
    public final RectF A;
    public final Matrix B;
    public final Paint C;
    public final Paint D;
    public final Map<k9, List<z7>> E;
    public final LongSparseArray<String> F;
    public final c9 G;
    public final h7 H;
    public final f7 I;

    @Nullable
    public p8<Integer, Integer> J;

    @Nullable
    public p8<Integer, Integer> K;

    @Nullable
    public p8<Integer, Integer> L;

    @Nullable
    public p8<Integer, Integer> M;

    @Nullable
    public p8<Float, Float> N;

    @Nullable
    public p8<Float, Float> O;

    @Nullable
    public p8<Float, Float> P;

    @Nullable
    public p8<Float, Float> Q;

    @Nullable
    public p8<Float, Float> R;

    @Nullable
    public p8<Float, Float> S;
    public final StringBuilder z;

    /* compiled from: TextLayer.java */
    public class a extends Paint {
        public a(cb cbVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    public class b extends Paint {
        public b(cb cbVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* compiled from: TextLayer.java */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i9.a.values().length];
            a = iArr;
            try {
                iArr[i9.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i9.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i9.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public cb(h7 h7Var, ya yaVar) {
        r9 r9Var;
        r9 r9Var2;
        q9 q9Var;
        q9 q9Var2;
        super(h7Var, yaVar);
        this.z = new StringBuilder(2);
        this.A = new RectF();
        this.B = new Matrix();
        this.C = new a(this, 1);
        this.D = new b(this, 1);
        this.E = new HashMap();
        this.F = new LongSparseArray<>();
        this.H = h7Var;
        this.I = yaVar.a();
        c9 c9VarA = yaVar.q().a();
        this.G = c9VarA;
        c9VarA.a(this);
        i(c9VarA);
        aa aaVarR = yaVar.r();
        if (aaVarR != null && (q9Var2 = aaVarR.a) != null) {
            p8<Integer, Integer> p8VarA = q9Var2.a();
            this.J = p8VarA;
            p8VarA.a(this);
            i(this.J);
        }
        if (aaVarR != null && (q9Var = aaVarR.b) != null) {
            p8<Integer, Integer> p8VarA2 = q9Var.a();
            this.L = p8VarA2;
            p8VarA2.a(this);
            i(this.L);
        }
        if (aaVarR != null && (r9Var2 = aaVarR.c) != null) {
            p8<Float, Float> p8VarA3 = r9Var2.a();
            this.N = p8VarA3;
            p8VarA3.a(this);
            i(this.N);
        }
        if (aaVarR == null || (r9Var = aaVarR.d) == null) {
            return;
        }
        p8<Float, Float> p8VarA4 = r9Var.a();
        this.P = p8VarA4;
        p8VarA4.a(this);
        i(this.P);
    }

    public final void K(i9.a aVar, Canvas canvas, float f) {
        int i = c.a[aVar.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else {
            if (i != 3) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    public final String L(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!X(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.F.containsKey(j)) {
            return this.F.get(j);
        }
        this.z.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.z.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.z.toString();
        this.F.put(j, string);
        return string;
    }

    public final void M(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void N(k9 k9Var, Matrix matrix, float f, i9 i9Var, Canvas canvas) {
        List<z7> listU = U(k9Var);
        for (int i = 0; i < listU.size(); i++) {
            Path path = listU.get(i).getPath();
            path.computeBounds(this.A, false);
            this.B.set(matrix);
            this.B.preTranslate(0.0f, (-i9Var.g) * hd.e());
            this.B.preScale(f, f);
            path.transform(this.B);
            if (i9Var.k) {
                Q(path, this.C, canvas);
                Q(path, this.D, canvas);
            } else {
                Q(path, this.D, canvas);
                Q(path, this.C, canvas);
            }
        }
    }

    public final void O(String str, i9 i9Var, Canvas canvas) {
        if (i9Var.k) {
            M(str, this.C, canvas);
            M(str, this.D, canvas);
        } else {
            M(str, this.D, canvas);
            M(str, this.C, canvas);
        }
    }

    public final void P(String str, i9 i9Var, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strL = L(str, length);
            length += strL.length();
            O(strL, i9Var, canvas);
            canvas.translate(this.C.measureText(strL) + f, 0.0f);
        }
    }

    public final void Q(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void R(String str, i9 i9Var, Matrix matrix, j9 j9Var, Canvas canvas, float f, float f2) {
        float fFloatValue;
        for (int i = 0; i < str.length(); i++) {
            k9 k9Var = this.I.c().get(k9.c(str.charAt(i), j9Var.a(), j9Var.c()));
            if (k9Var != null) {
                N(k9Var, matrix, f2, i9Var, canvas);
                float fB = ((float) k9Var.b()) * f2 * hd.e() * f;
                float f3 = i9Var.e / 10.0f;
                p8<Float, Float> p8Var = this.Q;
                if (p8Var != null) {
                    fFloatValue = p8Var.h().floatValue();
                } else {
                    p8<Float, Float> p8Var2 = this.P;
                    if (p8Var2 != null) {
                        fFloatValue = p8Var2.h().floatValue();
                    }
                    canvas.translate(fB + (f3 * f), 0.0f);
                }
                f3 += fFloatValue;
                canvas.translate(fB + (f3 * f), 0.0f);
            }
        }
    }

    public final void S(i9 i9Var, Matrix matrix, j9 j9Var, Canvas canvas) {
        float fFloatValue;
        p8<Float, Float> p8Var = this.S;
        if (p8Var != null) {
            fFloatValue = p8Var.h().floatValue();
        } else {
            p8<Float, Float> p8Var2 = this.R;
            fFloatValue = p8Var2 != null ? p8Var2.h().floatValue() : i9Var.c;
        }
        float f = fFloatValue / 100.0f;
        float fG = hd.g(matrix);
        String str = i9Var.a;
        float fE = i9Var.f * hd.e();
        List<String> listW = W(str);
        int size = listW.size();
        for (int i = 0; i < size; i++) {
            String str2 = listW.get(i);
            float fV = V(str2, j9Var, f, fG);
            canvas.save();
            K(i9Var.d, canvas, fV);
            canvas.translate(0.0f, (i * fE) - (((size - 1) * fE) / 2.0f));
            R(str2, i9Var, matrix, j9Var, canvas, fG, f);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[LOOP:0: B:22:0x00a5->B:23:0x00a7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void T(dc.i9 r7, dc.j9 r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            dc.hd.g(r9)
            dc.h7 r9 = r6.H
            java.lang.String r0 = r8.a()
            java.lang.String r8 = r8.c()
            android.graphics.Typeface r8 = r9.H(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.a
            dc.h7 r0 = r6.H
            dc.u7 r0 = r0.G()
            if (r0 != 0) goto Ldf
            android.graphics.Paint r0 = r6.C
            r0.setTypeface(r8)
            dc.p8<java.lang.Float, java.lang.Float> r8 = r6.S
            if (r8 == 0) goto L32
            java.lang.Object r8 = r8.h()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L43
        L32:
            dc.p8<java.lang.Float, java.lang.Float> r8 = r6.R
            if (r8 == 0) goto L41
            java.lang.Object r8 = r8.h()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L43
        L41:
            float r8 = r7.c
        L43:
            android.graphics.Paint r0 = r6.C
            float r1 = dc.hd.e()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.D
            android.graphics.Paint r1 = r6.C
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.D
            android.graphics.Paint r1 = r6.C
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f
            float r1 = dc.hd.e()
            float r0 = r0 * r1
            int r1 = r7.e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            dc.p8<java.lang.Float, java.lang.Float> r2 = r6.Q
            if (r2 == 0) goto L82
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L80:
            float r1 = r1 + r2
            goto L91
        L82:
            dc.p8<java.lang.Float, java.lang.Float> r2 = r6.P
            if (r2 == 0) goto L91
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L80
        L91:
            float r2 = dc.hd.e()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.W(r9)
            int r9 = r8.size()
            r2 = 0
        La5:
            if (r2 >= r9) goto Lde
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.D
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            dc.i9$a r5 = r7.d
            r6.K(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.P(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La5
        Lde:
            return
        Ldf:
            r0.a(r9)
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.cb.T(dc.i9, dc.j9, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    public final List<z7> U(k9 k9Var) {
        if (this.E.containsKey(k9Var)) {
            return this.E.get(k9Var);
        }
        List<ra> listA = k9Var.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new z7(this.H, this, listA.get(i)));
        }
        this.E.put(k9Var, arrayList);
        return arrayList;
    }

    public final float V(String str, j9 j9Var, float f, float f2) {
        float fB = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            k9 k9Var = this.I.c().get(k9.c(str.charAt(i), j9Var.a(), j9Var.c()));
            if (k9Var != null) {
                fB = (float) (fB + (k9Var.b() * f * hd.e() * f2));
            }
        }
        return fB;
    }

    public final List<String> W(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "\r").split("\r"));
    }

    public final boolean X(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // dc.va, dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        super.c(t, kdVar);
        if (t == m7.a) {
            p8<Integer, Integer> p8Var = this.K;
            if (p8Var != null) {
                C(p8Var);
            }
            if (kdVar == null) {
                this.K = null;
                return;
            }
            e9 e9Var = new e9(kdVar);
            this.K = e9Var;
            e9Var.a(this);
            i(this.K);
            return;
        }
        if (t == m7.b) {
            p8<Integer, Integer> p8Var2 = this.M;
            if (p8Var2 != null) {
                C(p8Var2);
            }
            if (kdVar == null) {
                this.M = null;
                return;
            }
            e9 e9Var2 = new e9(kdVar);
            this.M = e9Var2;
            e9Var2.a(this);
            i(this.M);
            return;
        }
        if (t == m7.q) {
            p8<Float, Float> p8Var3 = this.O;
            if (p8Var3 != null) {
                C(p8Var3);
            }
            if (kdVar == null) {
                this.O = null;
                return;
            }
            e9 e9Var3 = new e9(kdVar);
            this.O = e9Var3;
            e9Var3.a(this);
            i(this.O);
            return;
        }
        if (t == m7.r) {
            p8<Float, Float> p8Var4 = this.Q;
            if (p8Var4 != null) {
                C(p8Var4);
            }
            if (kdVar == null) {
                this.Q = null;
                return;
            }
            e9 e9Var4 = new e9(kdVar);
            this.Q = e9Var4;
            e9Var4.a(this);
            i(this.Q);
            return;
        }
        if (t == m7.D) {
            p8<Float, Float> p8Var5 = this.S;
            if (p8Var5 != null) {
                C(p8Var5);
            }
            if (kdVar == null) {
                this.S = null;
                return;
            }
            e9 e9Var5 = new e9(kdVar);
            this.S = e9Var5;
            e9Var5.a(this);
            i(this.S);
        }
    }

    @Override // dc.va, dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.I.b().width(), this.I.b().height());
    }

    @Override // dc.va
    public void t(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.H.p0()) {
            canvas.concat(matrix);
        }
        i9 i9VarH = this.G.h();
        j9 j9Var = this.I.g().get(i9VarH.b);
        if (j9Var == null) {
            canvas.restore();
            return;
        }
        p8<Integer, Integer> p8Var = this.K;
        if (p8Var != null) {
            this.C.setColor(p8Var.h().intValue());
        } else {
            p8<Integer, Integer> p8Var2 = this.J;
            if (p8Var2 != null) {
                this.C.setColor(p8Var2.h().intValue());
            } else {
                this.C.setColor(i9VarH.h);
            }
        }
        p8<Integer, Integer> p8Var3 = this.M;
        if (p8Var3 != null) {
            this.D.setColor(p8Var3.h().intValue());
        } else {
            p8<Integer, Integer> p8Var4 = this.L;
            if (p8Var4 != null) {
                this.D.setColor(p8Var4.h().intValue());
            } else {
                this.D.setColor(i9VarH.i);
            }
        }
        int iIntValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.C.setAlpha(iIntValue);
        this.D.setAlpha(iIntValue);
        p8<Float, Float> p8Var5 = this.O;
        if (p8Var5 != null) {
            this.D.setStrokeWidth(p8Var5.h().floatValue());
        } else {
            p8<Float, Float> p8Var6 = this.N;
            if (p8Var6 != null) {
                this.D.setStrokeWidth(p8Var6.h().floatValue());
            } else {
                this.D.setStrokeWidth(i9VarH.j * hd.e() * hd.g(matrix));
            }
        }
        if (this.H.p0()) {
            S(i9VarH, matrix, j9Var, canvas);
        } else {
            T(i9VarH, j9Var, matrix, canvas);
        }
        canvas.restore();
    }
}
