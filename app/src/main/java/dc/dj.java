package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class dj implements cj {
    @Override // dc.cj
    public void a(int i) {
    }

    @Override // dc.cj
    public void b() {
    }

    @Override // dc.cj
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // dc.cj
    @NonNull
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // dc.cj
    @NonNull
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }
}
