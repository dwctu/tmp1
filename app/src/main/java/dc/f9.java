package dc;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class f9 {
    public final AssetManager d;

    @Nullable
    public c7 e;
    public final p9<String> a = new p9<>();
    public final Map<p9<String>, Typeface> b = new HashMap();
    public final Map<String, Typeface> c = new HashMap();
    public String f = ".ttf";

    public f9(Drawable.Callback callback, @Nullable c7 c7Var) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            dd.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    public final Typeface a(String str) {
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        c7 c7Var = this.e;
        if (c7Var != null) {
            c7Var.a(str);
            throw null;
        }
        if (c7Var != null) {
            c7Var.b(str);
            throw null;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
        this.c.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceD = d(a(str), str2);
        this.b.put(this.a, typefaceD);
        return typefaceD;
    }

    public void c(@Nullable c7 c7Var) {
    }

    public final Typeface d(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
