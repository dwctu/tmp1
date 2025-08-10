package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* compiled from: ImageRegionDecoder.java */
/* loaded from: classes.dex */
public interface og0 {
    Point a(Context context, Uri uri) throws Exception;

    Bitmap b(Rect rect, int i);

    boolean isReady();

    void recycle();
}
