package dc;

import com.github.gzuliyujiang.oaid.OAIDException;

/* compiled from: DefaultImpl.java */
/* loaded from: classes.dex */
public class ci0 implements wh0 {
    @Override // dc.wh0
    public boolean a() {
        return false;
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) {
        if (vh0Var == null) {
            return;
        }
        vh0Var.b(new OAIDException("Unsupported"));
    }
}
