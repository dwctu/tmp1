package dc;

/* compiled from: SelectedUtil.java */
/* loaded from: classes4.dex */
public class n93 {
    public static volatile n93 b;
    public int a;

    public static n93 b() {
        if (b == null) {
            synchronized (n93.class) {
                if (b == null) {
                    b = new n93();
                }
            }
        }
        return b;
    }

    public int a() {
        return this.a;
    }

    public void c(int i) {
        this.a = i;
    }
}
