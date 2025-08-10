package dc;

import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: SelectionManager.java */
/* loaded from: classes4.dex */
public class g93 {
    public static volatile g93 d;
    public int a = 1;
    public ArrayList<String> b = new ArrayList<>();
    public LinkedHashMap<String, MediaFile> c = new LinkedHashMap<>();

    public static g93 c() {
        if (d == null) {
            synchronized (g93.class) {
                if (d == null) {
                    d = new g93();
                }
            }
        }
        return d;
    }

    public static boolean g(String str, String str2) {
        if (!m93.d(str) || m93.d(str2)) {
            return m93.d(str) || !m93.d(str2);
        }
        return false;
    }

    public boolean a(String str) {
        if (this.b.contains(str)) {
            this.c.remove(str);
            return this.b.remove(str);
        }
        if (this.b.size() < this.a) {
            return this.b.add(str);
        }
        return false;
    }

    public boolean b(String str, MediaFile mediaFile) {
        if (this.b.contains(str)) {
            this.c.remove(str);
            return this.b.remove(str);
        }
        if (this.b.size() >= this.a) {
            return false;
        }
        this.c.put(str, mediaFile);
        return this.b.add(str);
    }

    public int d() {
        return this.a;
    }

    public ArrayList<String> e() {
        return this.b;
    }

    public LinkedHashMap<String, MediaFile> f() {
        return this.c;
    }

    public boolean h() {
        return e().size() < this.a;
    }

    public boolean i(String str) {
        return this.b.contains(str);
    }

    public void j() {
        this.b.clear();
        this.c.clear();
    }

    public void k(int i) {
        this.a = i;
    }
}
