package dc;

/* compiled from: HandlerMessagePoxy.java */
/* loaded from: classes3.dex */
public class l32 implements m32 {
    public m32 a;

    public l32(m32 m32Var) {
        this.a = m32Var;
    }

    @Override // dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
        this.a.handler(str, qf2Var, obj);
    }
}
