package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapPool.java */
/* loaded from: classes.dex */
public interface cj {
    void a(int i);

    void b();

    void c(Bitmap bitmap);

    @NonNull
    Bitmap d(int i, int i2, Bitmap.Config config);

    @NonNull
    Bitmap e(int i, int i2, Bitmap.Config config);
}
