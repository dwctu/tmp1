package dc;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public class x7 {
    public List<o8> a = new ArrayList();

    public void a(o8 o8Var) {
        this.a.add(o8Var);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            hd.b(path, this.a.get(size));
        }
    }
}
