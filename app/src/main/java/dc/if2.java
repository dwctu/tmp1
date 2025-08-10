package dc;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* compiled from: LocalServer.java */
/* loaded from: classes3.dex */
public abstract class if2<Server> {
    public static final int[] i = {20010, 20011, 20012, 20013, 20014, 20015, 20016, 20017, 20018, 20019};
    public static final int[] j = {30010, 30011, 30012, 30013, 30014, 30015, 30016, 30017, 30018, 30019};
    public int b;
    public int c;
    public String e;
    public Server f;
    public int g;
    public int h;
    public Set<ef2> a = new CopyOnWriteArraySet();
    public final String d = "/log|/game|" + kd2.o + "|/v1|/";

    public void a(ef2 ef2Var) {
        if (this.a.contains(ef2Var)) {
            return;
        }
        this.a.add(ef2Var);
    }

    public void b(ef2 ef2Var, String str, boolean z) {
        if (this.d.contains(str)) {
            return;
        }
        throw new RuntimeException("你的path为：" + str + "不符合正则：" + this.d);
    }
}
