package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: DiskCache.java */
/* loaded from: classes.dex */
public interface mj {

    /* compiled from: DiskCache.java */
    public interface a {
        @Nullable
        mj build();
    }

    /* compiled from: DiskCache.java */
    public interface b {
        boolean a(@NonNull File file);
    }

    void a(xg xgVar, b bVar);

    @Nullable
    File b(xg xgVar);
}
