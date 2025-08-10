package dc;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.lang.reflect.InvocationTargetException;

/* compiled from: SkinCompatProgressBarHelper.java */
/* loaded from: classes5.dex */
public class xi4 extends vi4 {
    public final ProgressBar a;
    public Bitmap b;
    public int c = 0;
    public int d = 0;
    public int e = 0;

    public xi4(ProgressBar progressBar) {
        this.a = progressBar;
    }

    public void b() {
        int iA = vi4.a(this.c);
        this.c = iA;
        if (iA != 0) {
            Drawable drawableA = xh4.a(this.a.getContext(), this.c);
            drawableA.setBounds(this.a.getIndeterminateDrawable().getBounds());
            this.a.setIndeterminateDrawable(g(drawableA));
        }
        int iC = c(this.d);
        this.d = iC;
        if (iC != 0) {
            this.a.setProgressDrawable(f(xh4.a(this.a.getContext(), this.d), false));
        }
        if (Build.VERSION.SDK_INT > 21) {
            int iA2 = vi4.a(this.e);
            this.e = iA2;
            if (iA2 != 0) {
                ProgressBar progressBar = this.a;
                progressBar.setIndeterminateTintList(th4.c(progressBar.getContext(), this.e));
            }
        }
    }

    public final int c(int i) {
        return vi4.a(i);
    }

    public final Shape d() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public void e(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, lh4.SkinCompatProgressBar, i, 0);
        this.c = typedArrayObtainStyledAttributes.getResourceId(lh4.SkinCompatProgressBar_android_indeterminateDrawable, 0);
        this.d = typedArrayObtainStyledAttributes.getResourceId(lh4.SkinCompatProgressBar_android_progressDrawable, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT > 21) {
            TypedArray typedArrayObtainStyledAttributes2 = this.a.getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.indeterminateTint}, i, 0);
            this.e = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
        }
        b();
    }

    public final Drawable f(Drawable drawable, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (mi4.e(drawable)) {
            Drawable drawableB = mi4.b(drawable);
            if (drawableB != null) {
                mi4.h(drawable, f(drawableB, z));
            }
        } else if (mi4.d(drawable)) {
            Drawable drawableA = mi4.a(drawable);
            if (drawableA != null) {
                mi4.g(drawable, f(drawableA, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = f(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.b == null) {
                    this.b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(d());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public final Drawable g(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableF = f(animationDrawable.getFrame(i), true);
            drawableF.setLevel(10000);
            animationDrawable2.addFrame(drawableF, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }
}
