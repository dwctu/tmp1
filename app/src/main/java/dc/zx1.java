package dc;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* compiled from: JsInterface.java */
/* loaded from: classes3.dex */
public class zx1 {
    public Activity a;

    public zx1(Activity activity, WebView webView) {
        this.a = activity;
    }

    @JavascriptInterface
    public void fromLovenseWeb(String str) {
        try {
            String str2 = "lovenseWeb: " + str;
            pj3.w(this.a, str);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
