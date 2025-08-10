package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<dc.qf<TranscodeType>>] */
/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class qf<TranscodeType> extends jo<qf<TranscodeType>> implements Cloneable {
    public final Context A;
    public final rf B;
    public final Class<TranscodeType> C;
    public final mf D;

    @NonNull
    public sf<?, ? super TranscodeType> E;

    @Nullable
    public Object F;

    @Nullable
    public List<po<TranscodeType>> G;

    @Nullable
    public qf<TranscodeType> K;

    @Nullable
    public qf<TranscodeType> L;

    @Nullable
    public Float M;
    public boolean N = true;
    public boolean O;
    public boolean P;

    /* compiled from: RequestBuilder.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[of.values().length];
            b = iArr;
            try {
                iArr[of.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[of.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[of.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[of.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        new qo().f(ii.c).Z(of.LOW).h0(true);
    }

    @SuppressLint({"CheckResult"})
    public qf(@NonNull kf kfVar, rf rfVar, Class<TranscodeType> cls, Context context) {
        this.B = rfVar;
        this.C = cls;
        this.A = context;
        this.E = rfVar.o(cls);
        this.D = kfVar.i();
        w0(rfVar.m());
        a(rfVar.n());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.dp<android.widget.ImageView, TranscodeType> A0(@androidx.annotation.NonNull android.widget.ImageView r4) {
        /*
            r3 = this;
            dc.wp.b()
            dc.vp.d(r4)
            boolean r0 = r3.N()
            if (r0 != 0) goto L4c
            boolean r0 = r3.L()
            if (r0 == 0) goto L4c
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L4c
            int[] r0 = dc.qf.a.a
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L43;
                case 2: goto L3a;
                case 3: goto L31;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L4c
        L28:
            dc.jo r0 = r3.clone()
            dc.jo r0 = r0.R()
            goto L4d
        L31:
            dc.jo r0 = r3.clone()
            dc.jo r0 = r0.S()
            goto L4d
        L3a:
            dc.jo r0 = r3.clone()
            dc.jo r0 = r0.R()
            goto L4d
        L43:
            dc.jo r0 = r3.clone()
            dc.jo r0 = r0.Q()
            goto L4d
        L4c:
            r0 = r3
        L4d:
            dc.mf r1 = r3.D
            java.lang.Class<TranscodeType> r2 = r3.C
            dc.dp r4 = r1.a(r4, r2)
            r1 = 0
            java.util.concurrent.Executor r2 = dc.qp.b()
            r3.y0(r4, r1, r0, r2)
            dc.dp r4 = (dc.dp) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.qf.A0(android.widget.ImageView):dc.dp");
    }

    public final boolean B0(jo<?> joVar, mo moVar) {
        return !joVar.G() && moVar.isComplete();
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> C0(@Nullable po<TranscodeType> poVar) {
        this.G = null;
        return p0(poVar);
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> D0(@Nullable Bitmap bitmap) {
        K0(bitmap);
        return a(qo.r0(ii.b));
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> E0(@Nullable Drawable drawable) {
        K0(drawable);
        return a(qo.r0(ii.b));
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> F0(@Nullable Uri uri) {
        K0(uri);
        return this;
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> G0(@Nullable File file) {
        K0(file);
        return this;
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> H0(@Nullable @DrawableRes @RawRes Integer num) {
        K0(num);
        return a(qo.s0(jp.c(this.A)));
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> I0(@Nullable Object obj) {
        K0(obj);
        return this;
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> J0(@Nullable String str) {
        K0(str);
        return this;
    }

    @NonNull
    public final qf<TranscodeType> K0(@Nullable Object obj) {
        this.F = obj;
        this.O = true;
        return this;
    }

    public final mo L0(Object obj, cp<TranscodeType> cpVar, po<TranscodeType> poVar, jo<?> joVar, no noVar, sf<?, ? super TranscodeType> sfVar, of ofVar, int i, int i2, Executor executor) {
        Context context = this.A;
        mf mfVar = this.D;
        return so.w(context, mfVar, obj, this.F, this.C, joVar, i, i2, ofVar, cpVar, poVar, this.G, noVar, mfVar.f(), sfVar.b(), executor);
    }

    @NonNull
    public lo<TranscodeType> M0(int i, int i2) {
        oo ooVar = new oo(i, i2);
        z0(ooVar, ooVar, qp.a());
        return ooVar;
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> N0(@NonNull sf<?, ? super TranscodeType> sfVar) {
        vp.d(sfVar);
        this.E = sfVar;
        this.N = false;
        return this;
    }

    @NonNull
    @CheckResult
    public qf<TranscodeType> p0(@Nullable po<TranscodeType> poVar) {
        if (poVar != null) {
            if (this.G == null) {
                this.G = new ArrayList();
            }
            this.G.add(poVar);
        }
        return this;
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public qf<TranscodeType> a(@NonNull jo<?> joVar) {
        vp.d(joVar);
        return (qf) super.a(joVar);
    }

    public final mo r0(cp<TranscodeType> cpVar, @Nullable po<TranscodeType> poVar, jo<?> joVar, Executor executor) {
        return s0(new Object(), cpVar, poVar, null, this.E, joVar.y(), joVar.v(), joVar.u(), joVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final mo s0(Object obj, cp<TranscodeType> cpVar, @Nullable po<TranscodeType> poVar, @Nullable no noVar, sf<?, ? super TranscodeType> sfVar, of ofVar, int i, int i2, jo<?> joVar, Executor executor) {
        no noVar2;
        no koVar;
        if (this.L != null) {
            koVar = new ko(obj, noVar);
            noVar2 = koVar;
        } else {
            noVar2 = null;
            koVar = noVar;
        }
        mo moVarT0 = t0(obj, cpVar, poVar, koVar, sfVar, ofVar, i, i2, joVar, executor);
        if (noVar2 == null) {
            return moVarT0;
        }
        int iV = this.L.v();
        int iU = this.L.u();
        if (wp.t(i, i2) && !this.L.O()) {
            iV = joVar.v();
            iU = joVar.u();
        }
        qf<TranscodeType> qfVar = this.L;
        ko koVar2 = noVar2;
        koVar2.n(moVarT0, qfVar.s0(obj, cpVar, poVar, koVar2, qfVar.E, qfVar.y(), iV, iU, this.L, executor));
        return koVar2;
    }

    public final mo t0(Object obj, cp<TranscodeType> cpVar, po<TranscodeType> poVar, @Nullable no noVar, sf<?, ? super TranscodeType> sfVar, of ofVar, int i, int i2, jo<?> joVar, Executor executor) {
        qf<TranscodeType> qfVar = this.K;
        if (qfVar == null) {
            if (this.M == null) {
                return L0(obj, cpVar, poVar, joVar, noVar, sfVar, ofVar, i, i2, executor);
            }
            to toVar = new to(obj, noVar);
            toVar.m(L0(obj, cpVar, poVar, joVar, toVar, sfVar, ofVar, i, i2, executor), L0(obj, cpVar, poVar, joVar.clone().g0(this.M.floatValue()), toVar, sfVar, v0(ofVar), i, i2, executor));
            return toVar;
        }
        if (this.P) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        sf<?, ? super TranscodeType> sfVar2 = qfVar.N ? sfVar : qfVar.E;
        of ofVarY = qfVar.H() ? this.K.y() : v0(ofVar);
        int iV = this.K.v();
        int iU = this.K.u();
        if (wp.t(i, i2) && !this.K.O()) {
            iV = joVar.v();
            iU = joVar.u();
        }
        to toVar2 = new to(obj, noVar);
        mo moVarL0 = L0(obj, cpVar, poVar, joVar, toVar2, sfVar, ofVar, i, i2, executor);
        this.P = true;
        qf<TranscodeType> qfVar2 = this.K;
        mo moVarS0 = qfVar2.s0(obj, cpVar, poVar, toVar2, sfVar2, ofVarY, iV, iU, qfVar2, executor);
        this.P = false;
        toVar2.m(moVarL0, moVarS0);
        return toVar2;
    }

    @Override // dc.jo
    @CheckResult
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public qf<TranscodeType> clone() {
        qf<TranscodeType> qfVar = (qf) super.clone();
        qfVar.E = qfVar.E.clone();
        return qfVar;
    }

    @NonNull
    public final of v0(@NonNull of ofVar) {
        int i = a.b[ofVar.ordinal()];
        if (i == 1) {
            return of.NORMAL;
        }
        if (i == 2) {
            return of.HIGH;
        }
        if (i == 3 || i == 4) {
            return of.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + y());
    }

    @SuppressLint({"CheckResult"})
    public final void w0(List<po<Object>> list) {
        Iterator<po<Object>> it = list.iterator();
        while (it.hasNext()) {
            p0((po) it.next());
        }
    }

    @NonNull
    public <Y extends cp<TranscodeType>> Y x0(@NonNull Y y) {
        z0(y, null, qp.b());
        return y;
    }

    public final <Y extends cp<TranscodeType>> Y y0(@NonNull Y y, @Nullable po<TranscodeType> poVar, jo<?> joVar, Executor executor) {
        vp.d(y);
        if (!this.O) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        mo moVarR0 = r0(y, poVar, joVar, executor);
        mo request = y.getRequest();
        if (!moVarR0.g(request) || B0(joVar, request)) {
            this.B.l(y);
            y.g(moVarR0);
            this.B.B(y, moVarR0);
            return y;
        }
        vp.d(request);
        if (!request.isRunning()) {
            request.h();
        }
        return y;
    }

    @NonNull
    public <Y extends cp<TranscodeType>> Y z0(@NonNull Y y, @Nullable po<TranscodeType> poVar, Executor executor) {
        y0(y, poVar, this, executor);
        return y;
    }
}
