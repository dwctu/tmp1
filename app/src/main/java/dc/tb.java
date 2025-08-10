package dc;

import java.io.IOException;

/* compiled from: FloatParser.java */
/* loaded from: classes.dex */
public class tb implements uc<Float> {
    public static final tb a = new tb();

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(xc xcVar, float f) throws IOException {
        return Float.valueOf(ac.g(xcVar) * f);
    }
}
