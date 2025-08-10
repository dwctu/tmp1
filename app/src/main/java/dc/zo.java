package dc;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* compiled from: ImageViewTargetFactory.java */
/* loaded from: classes.dex */
public class zo {
    @NonNull
    public <Z> dp<ImageView, Z> a(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new vo(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new xo(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
