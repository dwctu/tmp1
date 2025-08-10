package dc;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;

/* compiled from: SkinCompatImageHelper.java */
/* loaded from: classes5.dex */
public class wi4 extends vi4 {
    public final ImageView a;
    public int b = 0;
    public int c = 0;
    public int d = 0;

    public wi4(ImageView imageView) {
        this.a = imageView;
    }

    public void b() {
        Drawable drawableA;
        int iA = vi4.a(this.c);
        this.c = iA;
        if (iA != 0) {
            Drawable drawableA2 = xh4.a(this.a.getContext(), this.c);
            if (drawableA2 != null) {
                this.a.setImageDrawable(drawableA2);
            }
        } else {
            int iA2 = vi4.a(this.b);
            this.b = iA2;
            if (iA2 != 0 && (drawableA = xh4.a(this.a.getContext(), this.b)) != null) {
                this.a.setImageDrawable(drawableA);
            }
        }
        int iA3 = vi4.a(this.d);
        this.d = iA3;
        if (iA3 != 0) {
            ImageViewCompat.setImageTintList(this.a, th4.c(this.a.getContext(), this.d));
        }
    }

    public void c(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, yg4.SkinCompatImageView, i, 0);
            this.b = typedArrayObtainStyledAttributes.getResourceId(yg4.SkinCompatImageView_android_src, 0);
            this.c = typedArrayObtainStyledAttributes.getResourceId(yg4.SkinCompatImageView_srcCompat, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(yg4.SkinCompatImageView_tint, 0);
            this.d = resourceId;
            if (resourceId == 0) {
                this.d = typedArrayObtainStyledAttributes.getResourceId(yg4.SkinCompatImageView_android_tint, 0);
            }
            b();
        } finally {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public void d(int i) {
        this.b = i;
        this.c = 0;
        b();
    }
}
