package dc;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class s8 extends u8<ga> {
    public final ga i;

    public s8(List<id<ga>> list) {
        super(list);
        ga gaVar = list.get(0).b;
        int iC = gaVar != null ? gaVar.c() : 0;
        this.i = new ga(new float[iC], new int[iC]);
    }

    @Override // dc.p8
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ga i(id<ga> idVar, float f) {
        this.i.d(idVar.b, idVar.c, f);
        return this.i;
    }
}
