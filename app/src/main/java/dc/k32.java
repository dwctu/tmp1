package dc;

/* compiled from: ToySetManagerImpl.java */
/* loaded from: classes3.dex */
public class k32 implements tf2 {
    public static volatile k32 a;

    public static k32 a() {
        if (a == null) {
            synchronized (k32.class) {
                if (a == null) {
                    a = new k32();
                }
            }
        }
        return a;
    }

    public void b(j32 j32Var) {
        String str = "socketIoToySetMsgACK: " + j32Var.toString();
    }

    @Override // dc.tf2
    public void connectSuc() {
    }

    @Override // dc.tf2
    public void disConnect() {
    }
}
