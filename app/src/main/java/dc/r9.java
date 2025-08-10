package dc;

import java.util.List;

/* compiled from: AnimatableFloatValue.java */
/* loaded from: classes.dex */
public class r9 extends da<Float, Float> {
    public r9() {
        super(Float.valueOf(0.0f));
    }

    @Override // dc.ca
    public p8<Float, Float> a() {
        return new r8(this.a);
    }

    public r9(List<id<Float>> list) {
        super((List) list);
    }
}
