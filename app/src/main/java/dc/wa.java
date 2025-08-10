package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.ya;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class wa extends va {
    public final List<va> A;
    public final RectF B;
    public final RectF C;
    public Paint D;

    @Nullable
    public p8<Float, Float> z;

    /* compiled from: CompositionLayer.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ya.b.values().length];
            a = iArr;
            try {
                iArr[ya.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ya.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public wa(h7 h7Var, ya yaVar, List<ya> list, f7 f7Var) {
        int i;
        va vaVar;
        super(h7Var, yaVar);
        this.A = new ArrayList();
        this.B = new RectF();
        this.C = new RectF();
        this.D = new Paint();
        r9 r9VarS = yaVar.s();
        if (r9VarS != null) {
            p8<Float, Float> p8VarA = r9VarS.a();
            this.z = p8VarA;
            i(p8VarA);
            this.z.a(this);
        } else {
            this.z = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(f7Var.j().size());
        int size = list.size() - 1;
        va vaVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            ya yaVar2 = list.get(size);
            va vaVarU = va.u(yaVar2, h7Var, f7Var);
            if (vaVarU != null) {
                longSparseArray.put(vaVarU.v().b(), vaVarU);
                if (vaVar2 != null) {
                    vaVar2.E(vaVarU);
                    vaVar2 = null;
                } else {
                    this.A.add(0, vaVarU);
                    int i2 = a.a[yaVar2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        vaVar2 = vaVarU;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            va vaVar3 = (va) longSparseArray.get(longSparseArray.keyAt(i));
            if (vaVar3 != null && (vaVar = (va) longSparseArray.get(vaVar3.v().h())) != null) {
                vaVar3.G(vaVar);
            }
        }
    }

    @Override // dc.va
    public void D(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            this.A.get(i2).d(l9Var, i, list, l9Var2);
        }
    }

    @Override // dc.va
    public void F(boolean z) {
        super.F(z);
        Iterator<va> it = this.A.iterator();
        while (it.hasNext()) {
            it.next().F(z);
        }
    }

    @Override // dc.va
    public void H(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f) {
        super.H(f);
        if (this.z != null) {
            f = ((this.z.h().floatValue() * this.o.a().h()) - this.o.a().o()) / (this.n.q().e() + 0.01f);
        }
        if (this.z == null) {
            f -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).H(f);
        }
    }

    @Override // dc.va, dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        super.c(t, kdVar);
        if (t == m7.C) {
            if (kdVar == null) {
                p8<Float, Float> p8Var = this.z;
                if (p8Var != null) {
                    p8Var.n(null);
                    return;
                }
                return;
            }
            e9 e9Var = new e9(kdVar);
            this.z = e9Var;
            e9Var.a(this);
            i(this.z);
        }
    }

    @Override // dc.va, dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(size).e(this.B, this.m, true);
            rectF.union(this.B);
        }
    }

    @Override // dc.va
    public void t(Canvas canvas, Matrix matrix, int i) {
        e7.a("CompositionLayer#draw");
        this.C.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.C);
        boolean z = this.n.J() && this.A.size() > 1 && i != 255;
        if (z) {
            this.D.setAlpha(i);
            hd.m(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (!this.C.isEmpty() ? canvas.clipRect(this.C) : true) {
                this.A.get(size).g(canvas, matrix, i);
            }
        }
        canvas.restore();
        e7.b("CompositionLayer#draw");
    }
}
