package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;

/* compiled from: FullscreenPlayPresenter.java */
/* loaded from: classes4.dex */
public class zk3 {
    public View a;
    public WebChromeClient.CustomViewCallback b;
    public PowerManager.WakeLock c;

    public void a(Activity activity, ViewGroup viewGroup) {
        WebChromeClient.CustomViewCallback customViewCallback;
        if (activity == null) {
            return;
        }
        if (this.a == null || (customViewCallback = this.b) == null) {
            WebChromeClient.CustomViewCallback customViewCallback2 = this.b;
            if (customViewCallback2 != null) {
                try {
                    customViewCallback2.onCustomViewHidden();
                } catch (Exception unused) {
                }
                if (this.c.isHeld()) {
                    this.c.release();
                }
                this.a = null;
                this.b = null;
                return;
            }
            return;
        }
        this.a = null;
        try {
            customViewCallback.onCustomViewHidden();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = null;
        gg3.m(activity);
        viewGroup.removeAllViews();
        viewGroup.setVisibility(8);
        d(activity.getWindow());
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public void b(Activity activity, ViewGroup viewGroup, View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (activity == null) {
            return;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(10, "WakeLock");
        this.c = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
        if (this.a != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.a = view;
        this.b = customViewCallback;
        gg3.n(activity);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        viewGroup.setVisibility(0);
        c(activity.getWindow());
    }

    public void c(Window window) {
        window.addFlags(1024);
        window.addFlags(512);
        window.clearFlags(65536);
        window.getDecorView().setSystemUiVisibility(3846);
    }

    public void d(Window window) {
        window.clearFlags(1024);
        window.clearFlags(512);
        window.addFlags(65536);
        window.getDecorView().setSystemUiVisibility(1792);
    }
}
