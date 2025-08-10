package dc;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* compiled from: LruPoolStrategy.java */
/* loaded from: classes.dex */
public interface jj {
    String a(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    void c(Bitmap bitmap);

    @Nullable
    Bitmap d(int i, int i2, Bitmap.Config config);

    int e(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
