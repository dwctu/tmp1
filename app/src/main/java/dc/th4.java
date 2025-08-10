package dc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import dc.zg4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SkinCompatResources.java */
/* loaded from: classes5.dex */
public class th4 {
    public static volatile th4 g;
    public Resources a;
    public zg4.c d;
    public String b = "";
    public String c = "";
    public boolean e = true;
    public List<yh4> f = new ArrayList();

    public static int b(Context context, int i) {
        return e().f(context, i);
    }

    public static ColorStateList c(Context context, int i) {
        return e().g(context, i);
    }

    public static Drawable d(Context context, int i) {
        return e().h(context, i);
    }

    public static th4 e() {
        if (g == null) {
            synchronized (th4.class) {
                if (g == null) {
                    g = new th4();
                }
            }
        }
        return g;
    }

    public static void n(Context context, int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        e().j(context, i, typedValue, z);
    }

    public static XmlResourceParser o(Context context, int i) {
        return e().k(context, i);
    }

    public void a(yh4 yh4Var) {
        this.f.add(yh4Var);
    }

    public final int f(Context context, int i) {
        int iM;
        ColorStateList colorStateListD;
        ColorStateList colorStateListK;
        if (context == null) {
            context = zg4.m().j();
        }
        if (!vh4.g().n() && (colorStateListK = vh4.g().k(i)) != null) {
            return colorStateListK.getDefaultColor();
        }
        zg4.c cVar = this.d;
        return (cVar == null || (colorStateListD = cVar.d(context, this.c, i)) == null) ? (this.e || (iM = m(context, i)) == 0) ? Build.VERSION.SDK_INT >= 23 ? context.getResources().getColor(i, context.getTheme()) : context.getResources().getColor(i) : this.a.getColor(iM) : colorStateListD.getDefaultColor();
    }

    public final ColorStateList g(Context context, int i) {
        int iM;
        ColorStateList colorStateListE;
        ColorStateList colorStateListK;
        if (!vh4.g().n() && (colorStateListK = vh4.g().k(i)) != null) {
            return colorStateListK;
        }
        zg4.c cVar = this.d;
        return (cVar == null || (colorStateListE = cVar.e(context, this.c, i)) == null) ? (this.e || (iM = m(context, i)) == 0) ? Build.VERSION.SDK_INT >= 23 ? context.getResources().getColorStateList(i, context.getTheme()) : context.getResources().getColorStateList(i) : this.a.getColorStateList(iM) : colorStateListE;
    }

    public final Drawable h(Context context, int i) {
        int iM;
        Drawable drawableA;
        Drawable drawableL;
        ColorStateList colorStateListK;
        if (context == null) {
            context = zg4.m().j();
        }
        if (!vh4.g().n() && (colorStateListK = vh4.g().k(i)) != null) {
            return new ColorDrawable(colorStateListK.getDefaultColor());
        }
        if (!vh4.g().o() && (drawableL = vh4.g().l(i)) != null) {
            return drawableL;
        }
        zg4.c cVar = this.d;
        return (cVar == null || (drawableA = cVar.a(context, this.c, i)) == null) ? (this.e || (iM = m(context, i)) == 0) ? Build.VERSION.SDK_INT >= 21 ? context.getResources().getDrawable(i, context.getTheme()) : context.getResources().getDrawable(i) : this.a.getDrawable(iM) : drawableA;
    }

    public Resources i() {
        return this.a;
    }

    public final void j(Context context, int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int iM;
        if (this.e || (iM = m(context, i)) == 0) {
            context.getResources().getValue(i, typedValue, z);
        } else {
            this.a.getValue(iM, typedValue, z);
        }
    }

    public final XmlResourceParser k(Context context, int i) {
        int iM;
        return (this.e || (iM = m(context, i)) == 0) ? context.getResources().getXml(i) : this.a.getXml(iM);
    }

    public Drawable l(Context context, int i) {
        zg4.c cVar = this.d;
        if (cVar != null) {
            return cVar.a(context, this.c, i);
        }
        return null;
    }

    public int m(Context context, int i) throws Resources.NotFoundException {
        try {
            zg4.c cVar = this.d;
            String strC = cVar != null ? cVar.c(context, this.c, i) : null;
            if (TextUtils.isEmpty(strC)) {
                strC = context.getResources().getResourceEntryName(i);
            }
            return this.a.getIdentifier(strC, context.getResources().getResourceTypeName(i), this.b);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean p() {
        return this.e;
    }

    public void q() {
        r(zg4.m().p().get(-1));
    }

    public void r(zg4.c cVar) {
        this.a = zg4.m().j().getResources();
        this.b = "";
        this.c = "";
        this.d = cVar;
        this.e = true;
        vh4.g().d();
        Iterator<yh4> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public void s(Resources resources, String str, String str2, zg4.c cVar) {
        if (resources == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            r(cVar);
            return;
        }
        this.a = resources;
        this.b = str;
        this.c = str2;
        this.d = cVar;
        this.e = false;
        vh4.g().d();
        Iterator<yh4> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }
}
