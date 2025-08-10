package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface lk<Model, Data> {

    /* compiled from: ModelLoader.java */
    public static class a<Data> {
        public final xg a;
        public final List<xg> b;
        public final ih<Data> c;

        public a(@NonNull xg xgVar, @NonNull ih<Data> ihVar) {
            this(xgVar, Collections.emptyList(), ihVar);
        }

        public a(@NonNull xg xgVar, @NonNull List<xg> list, @NonNull ih<Data> ihVar) {
            vp.d(xgVar);
            this.a = xgVar;
            vp.d(list);
            this.b = list;
            vp.d(ihVar);
            this.c = ihVar;
        }
    }

    boolean a(@NonNull Model model);

    @Nullable
    a<Data> b(@NonNull Model model, int i, int i2, @NonNull ah ahVar);
}
