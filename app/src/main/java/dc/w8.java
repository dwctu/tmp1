package dc;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class w8 extends id<PointF> {

    @Nullable
    public Path q;
    public final id<PointF> r;

    public w8(f7 f7Var, id<PointF> idVar) {
        super(f7Var, idVar.b, idVar.c, idVar.d, idVar.e, idVar.f, idVar.g, idVar.h);
        this.r = idVar;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        T t;
        T t2;
        T t3 = this.c;
        boolean z = (t3 == 0 || (t2 = this.b) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.b;
        if (t4 == 0 || (t = this.c) == 0 || z) {
            return;
        }
        id<PointF> idVar = this.r;
        this.q = hd.d((PointF) t4, (PointF) t, idVar.o, idVar.p);
    }

    @Nullable
    public Path j() {
        return this.q;
    }
}
