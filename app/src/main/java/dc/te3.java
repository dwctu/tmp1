package dc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: IntentUtils.java */
/* loaded from: classes4.dex */
public class te3 {
    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }
}
