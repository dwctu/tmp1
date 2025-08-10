package dc;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class pa {
    public final List<h9> a;
    public PointF b;
    public boolean c;

    public pa(PointF pointF, boolean z, List<h9> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    public List<h9> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(pa paVar, pa paVar2, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = paVar.d() || paVar2.d();
        if (paVar.a().size() != paVar2.a().size()) {
            dd.c("Curves must have the same number of control points. Shape 1: " + paVar.a().size() + "\tShape 2: " + paVar2.a().size());
        }
        int iMin = Math.min(paVar.a().size(), paVar2.a().size());
        if (this.a.size() < iMin) {
            for (int size = this.a.size(); size < iMin; size++) {
                this.a.add(new h9());
            }
        } else if (this.a.size() > iMin) {
            for (int size2 = this.a.size() - 1; size2 >= iMin; size2--) {
                List<h9> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = paVar.b();
        PointF pointFB2 = paVar2.b();
        e(gd.k(pointFB.x, pointFB2.x, f), gd.k(pointFB.y, pointFB2.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            h9 h9Var = paVar.a().get(size3);
            h9 h9Var2 = paVar2.a().get(size3);
            PointF pointFA = h9Var.a();
            PointF pointFB3 = h9Var.b();
            PointF pointFC = h9Var.c();
            PointF pointFA2 = h9Var2.a();
            PointF pointFB4 = h9Var2.b();
            PointF pointFC2 = h9Var2.c();
            this.a.get(size3).d(gd.k(pointFA.x, pointFA2.x, f), gd.k(pointFA.y, pointFA2.y, f));
            this.a.get(size3).e(gd.k(pointFB3.x, pointFB4.x, f), gd.k(pointFB3.y, pointFB4.y, f));
            this.a.get(size3).f(gd.k(pointFC.x, pointFC2.x, f), gd.k(pointFC.y, pointFC2.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public final void e(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + MessageFormatter.DELIM_STOP;
    }

    public pa() {
        this.a = new ArrayList();
    }
}
