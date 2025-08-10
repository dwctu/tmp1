package dc;

import java.io.IOException;

/* compiled from: IntegerParser.java */
/* loaded from: classes.dex */
public class zb implements uc<Integer> {
    public static final zb a = new zb();

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(xc xcVar, float f) throws IOException {
        return Integer.valueOf(Math.round(ac.g(xcVar) * f));
    }
}
