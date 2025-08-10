package dc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SkinCompatUserThemeManager.java */
/* loaded from: classes5.dex */
public class vh4 {
    public static vh4 i = new vh4();
    public boolean d;
    public boolean h;
    public final HashMap<String, qh4> a = new HashMap<>();
    public final Object b = new Object();
    public final WeakHashMap<Integer, WeakReference<ColorStateList>> c = new WeakHashMap<>();
    public final HashMap<String, String> e = new HashMap<>();
    public final Object f = new Object();
    public final WeakHashMap<Integer, WeakReference<Drawable>> g = new WeakHashMap<>();

    public vh4() {
        try {
            q();
        } catch (JSONException e) {
            this.a.clear();
            this.e.clear();
            if (pi4.a) {
                pi4.a("SkinCompatUserThemeManager", "startLoadFromSharedPreferences error: " + e);
            }
        }
    }

    public static boolean c(String str) {
        boolean z = !TextUtils.isEmpty(str) && new File(str).exists();
        if (pi4.a && !z) {
            pi4.a("SkinCompatUserThemeManager", "Invalid drawable path : " + str);
        }
        return z;
    }

    public static vh4 g() {
        return i;
    }

    public final void a(int i2, ColorStateList colorStateList) {
        if (colorStateList != null) {
            synchronized (this.b) {
                this.c.put(Integer.valueOf(i2), new WeakReference<>(colorStateList));
            }
        }
    }

    public final void b(int i2, Drawable drawable) {
        if (drawable != null) {
            synchronized (this.f) {
                this.g.put(Integer.valueOf(i2), new WeakReference<>(drawable));
            }
        }
    }

    public void d() {
        e();
        f();
    }

    public final void e() {
        synchronized (this.b) {
            this.c.clear();
        }
    }

    public final void f() {
        synchronized (this.f) {
            this.g.clear();
        }
    }

    public final ColorStateList h(int i2) {
        synchronized (this.b) {
            WeakReference<ColorStateList> weakReference = this.c.get(Integer.valueOf(i2));
            if (weakReference != null) {
                ColorStateList colorStateList = weakReference.get();
                if (colorStateList != null) {
                    return colorStateList;
                }
                this.c.remove(Integer.valueOf(i2));
            }
            return null;
        }
    }

    public final Drawable i(int i2) {
        synchronized (this.f) {
            WeakReference<Drawable> weakReference = this.g.get(Integer.valueOf(i2));
            if (weakReference != null) {
                Drawable drawable = weakReference.get();
                if (drawable != null) {
                    return drawable;
                }
                this.g.remove(Integer.valueOf(i2));
            }
            return null;
        }
    }

    public qh4 j(String str) {
        return this.a.get(str);
    }

    public ColorStateList k(int i2) {
        qh4 qh4Var;
        ColorStateList colorStateListH = h(i2);
        if (colorStateListH == null) {
            String strM = m(i2, "color");
            if (!TextUtils.isEmpty(strM) && (qh4Var = this.a.get(strM)) != null && (colorStateListH = qh4Var.e()) != null) {
                a(i2, colorStateListH);
            }
        }
        return colorStateListH;
    }

    public Drawable l(int i2) {
        Drawable drawableI = i(i2);
        if (drawableI == null) {
            String strM = m(i2, "drawable");
            if (!TextUtils.isEmpty(strM)) {
                String str = this.e.get(strM);
                if (!TextUtils.isEmpty(str)) {
                    String[] strArrSplit = str.split(SignatureImpl.INNER_SEP);
                    String str2 = strArrSplit[0];
                    int iIntValue = strArrSplit.length == 2 ? Integer.valueOf(strArrSplit[1]).intValue() : 0;
                    if (c(str2)) {
                        if (iIntValue == 0) {
                            drawableI = Drawable.createFromPath(str2);
                        } else {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(iIntValue);
                            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str2);
                            drawableI = new BitmapDrawable((Resources) null, Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true));
                        }
                        if (drawableI != null) {
                            b(i2, drawableI);
                        }
                    }
                }
            }
        }
        return drawableI;
    }

    public final String m(int i2, String str) {
        Context contextJ = zg4.m().j();
        if (str.equalsIgnoreCase(contextJ.getResources().getResourceTypeName(i2))) {
            return contextJ.getResources().getResourceEntryName(i2);
        }
        return null;
    }

    public boolean n() {
        return this.d;
    }

    public boolean o() {
        return this.h;
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.remove(str);
        this.d = this.a.isEmpty();
    }

    public final void q() throws JSONException {
        String strC = oi4.b().c();
        if (!TextUtils.isEmpty(strC)) {
            JSONArray jSONArray = new JSONArray(strC);
            if (pi4.a) {
                pi4.a("SkinCompatUserThemeManager", "startLoadFromSharedPreferences: " + jSONArray.toString());
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.has("type")) {
                    String string = jSONObject.getString("type");
                    if ("color".equals(string)) {
                        qh4 qh4VarB = qh4.b(jSONObject);
                        if (qh4VarB != null) {
                            this.a.put(qh4VarB.b, qh4VarB);
                        }
                    } else if ("drawable".equals(string)) {
                        String string2 = jSONObject.getString("drawableName");
                        String string3 = jSONObject.getString("drawablePathAndAngle");
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                            this.e.put(string2, string3);
                        }
                    }
                }
            }
        }
        this.d = this.a.isEmpty();
        this.h = this.e.isEmpty();
    }
}
