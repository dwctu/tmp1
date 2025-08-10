package dc;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class vo extends yo<Bitmap> {
    public vo(ImageView imageView) {
        super(imageView);
    }

    @Override // dc.yo
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(Bitmap bitmap) {
        ((ImageView) this.b).setImageBitmap(bitmap);
    }
}
