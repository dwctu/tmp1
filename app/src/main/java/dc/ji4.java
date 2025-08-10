package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import dc.zg4;

/* compiled from: SkinSDCardLoader.java */
/* loaded from: classes5.dex */
public abstract class ji4 implements zg4.c {
    @Override // dc.zg4.c
    public Drawable a(Context context, String str, int i) {
        return null;
    }

    @Override // dc.zg4.c
    public String b(Context context, String str) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strF = f(context, str);
        if (!ni4.c(strF)) {
            return null;
        }
        String strN = zg4.m().n(strF);
        Resources resourcesO = zg4.m().o(strF);
        if (resourcesO == null || TextUtils.isEmpty(strN)) {
            return null;
        }
        th4.e().s(resourcesO, strN, str, this);
        return str;
    }

    @Override // dc.zg4.c
    public ColorStateList d(Context context, String str, int i) {
        return null;
    }

    @Override // dc.zg4.c
    public ColorStateList e(Context context, String str, int i) {
        return null;
    }

    public abstract String f(Context context, String str);
}
