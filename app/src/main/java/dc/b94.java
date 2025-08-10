package dc;

import java.io.IOException;

/* compiled from: ZipStandardCipherInputStream.java */
/* loaded from: classes5.dex */
public class b94 extends r84<k84> {
    public b94(z84 z84Var, l94 l94Var, char[] cArr, int i, boolean z) throws IOException {
        super(z84Var, l94Var, cArr, i, z);
    }

    public final byte[] q() throws IOException {
        byte[] bArr = new byte[12];
        p(bArr);
        return bArr;
    }

    @Override // dc.r84
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public k84 m(l94 l94Var, char[] cArr, boolean z) throws IOException {
        return new k84(cArr, l94Var.e(), l94Var.k(), q(), z);
    }
}
