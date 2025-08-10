package dc;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

/* compiled from: TransformationUtils.java */
/* loaded from: classes4.dex */
public class zg3 extends yo<Bitmap> {
    public ImageView i;

    public zg3(ImageView imageView) {
        super(imageView);
        this.i = imageView;
    }

    @Override // dc.yo
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        ((ImageView) this.b).setImageBitmap(bitmap);
        int height = (int) (bitmap.getHeight() * (((float) (this.i.getWidth() * 0.1d)) / ((float) (bitmap.getWidth() * 0.1d))));
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        layoutParams.height = height;
        this.i.setLayoutParams(layoutParams);
    }
}
