package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.broadcom.bt.util.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class g9 {
    public static final Object e = new Object();
    public final Context a;
    public final String b;

    @Nullable
    public d7 c;
    public final Map<String, i7> d;

    public g9(Drawable.Callback callback, String str, d7 d7Var, Map<String, i7> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.b = str;
        } else {
            this.b = str + IOUtils.DIR_SEPARATOR_UNIX;
        }
        if (callback instanceof View) {
            this.a = ((View) callback).getContext();
            this.d = map;
            d(d7Var);
        } else {
            dd.c("LottieDrawable must be inside of a view for images to work.");
            this.d = new HashMap();
            this.a = null;
        }
    }

    @Nullable
    public Bitmap a(String str) {
        i7 i7Var = this.d.get(str);
        if (i7Var == null) {
            return null;
        }
        Bitmap bitmapA = i7Var.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        d7 d7Var = this.c;
        if (d7Var != null) {
            Bitmap bitmapA2 = d7Var.a(i7Var);
            if (bitmapA2 != null) {
                c(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strB = i7Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                c(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e2) {
                dd.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapL = hd.l(BitmapFactory.decodeStream(this.a.getAssets().open(this.b + strB), null, options), i7Var.e(), i7Var.c());
                c(str, bitmapL);
                return bitmapL;
            } catch (IllegalArgumentException e3) {
                dd.d("Unable to decode image.", e3);
                return null;
            }
        } catch (IOException e4) {
            dd.d("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (e) {
            this.d.get(str).f(bitmap);
        }
        return bitmap;
    }

    public void d(@Nullable d7 d7Var) {
        this.c = d7Var;
    }
}
