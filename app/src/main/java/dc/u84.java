package dc;

import java.io.IOException;

/* compiled from: NoCipherInputStream.java */
/* loaded from: classes5.dex */
public class u84 extends r84<a> {

    /* compiled from: NoCipherInputStream.java */
    public static class a implements f84 {
        @Override // dc.f84
        public int a(byte[] bArr, int i, int i2) {
            return i2;
        }
    }

    public u84(z84 z84Var, l94 l94Var, char[] cArr, int i) throws IOException {
        super(z84Var, l94Var, cArr, i, true);
    }

    @Override // dc.r84
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a m(l94 l94Var, char[] cArr, boolean z) {
        return new a();
    }
}
