package dc;

import android.content.Intent;

/* compiled from: IntentUtils.java */
/* loaded from: classes.dex */
public final class zd0 {
    public static Intent a(String str) {
        String strU = xe0.u(str);
        if (xe0.K(strU)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, strU);
        return intent.addFlags(268435456);
    }
}
