package dc;

import android.graphics.Path;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class a9 extends p8<pa, Path> {
    public final pa i;
    public final Path j;

    public a9(List<id<pa>> list) {
        super(list);
        this.i = new pa();
        this.j = new Path();
    }

    @Override // dc.p8
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(id<pa> idVar, float f) {
        this.i.c(idVar.b, idVar.c, f);
        gd.i(this.i, this.j);
        return this.j;
    }
}
