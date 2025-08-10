package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.google.android.exoplayer2.PlaybackException;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: ToastImpl.java */
/* loaded from: classes2.dex */
public final class b71 {
    public static final Handler h = new Handler(Looper.getMainLooper());
    public final u61 a;
    public g71 b;
    public final String c;
    public boolean d;
    public boolean e;
    public final Runnable f;
    public final Runnable g;

    /* compiled from: ToastImpl.java */
    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            b71.this.g();
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongConstant"})
        public void run() {
            WindowManager windowManagerA = b71.this.b.a();
            if (windowManagerA == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.flags = CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA;
            layoutParams.packageName = b71.this.c;
            layoutParams.gravity = b71.this.a.d();
            layoutParams.x = b71.this.a.j();
            layoutParams.y = b71.this.a.k();
            layoutParams.verticalMargin = b71.this.a.h();
            layoutParams.horizontalMargin = b71.this.a.e();
            layoutParams.windowAnimations = b71.this.a.b();
            if (b71.this.e) {
                if (Build.VERSION.SDK_INT >= 26) {
                    layoutParams.type = 2038;
                    layoutParams.flags &= -17;
                } else {
                    layoutParams.type = PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE;
                }
            }
            try {
                windowManagerA.addView(b71.this.a.i(), layoutParams);
                b71.h.postDelayed(new Runnable() { // from class: dc.r61
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                }, b71.this.a.c() == 1 ? b71.this.a.f() : b71.this.a.g());
                b71.this.b.b(b71.this);
                b71.this.j(true);
                b71 b71Var = b71.this;
                b71Var.l(b71Var.a.i());
            } catch (WindowManager.BadTokenException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: ToastImpl.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManager windowManagerA;
            try {
                try {
                    windowManagerA = b71.this.b.a();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                if (windowManagerA == null) {
                    return;
                }
                windowManagerA.removeViewImmediate(b71.this.a.i());
            } finally {
                b71.this.b.c();
                b71.this.j(false);
            }
        }
    }

    public b71(Activity activity, u61 u61Var) {
        this((Context) activity, u61Var);
        this.e = false;
        this.b = new g71(activity);
    }

    public void g() {
        if (i()) {
            Handler handler = h;
            handler.removeCallbacks(this.f);
            if (h()) {
                this.g.run();
            } else {
                handler.removeCallbacks(this.g);
                handler.post(this.g);
            }
        }
    }

    public final boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean i() {
        return this.d;
    }

    public void j(boolean z) {
        this.d = z;
    }

    public void k() {
        if (i()) {
            return;
        }
        if (h()) {
            this.f.run();
            return;
        }
        Handler handler = h;
        handler.removeCallbacks(this.f);
        handler.post(this.f);
    }

    public final void l(View view) {
        AccessibilityEvent accessibilityEventObtain;
        Context context = view.getContext();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (Build.VERSION.SDK_INT >= 30) {
                accessibilityEventObtain = new AccessibilityEvent();
                accessibilityEventObtain.setEventType(64);
            } else {
                accessibilityEventObtain = AccessibilityEvent.obtain(64);
            }
            accessibilityEventObtain.setClassName(Toast.class.getName());
            accessibilityEventObtain.setPackageName(context.getPackageName());
            view.dispatchPopulateAccessibilityEvent(accessibilityEventObtain);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    public b71(Application application, u61 u61Var) {
        this((Context) application, u61Var);
        this.e = true;
        this.b = new g71(application);
    }

    public b71(Context context, u61 u61Var) {
        this.f = new a();
        this.g = new b();
        this.a = u61Var;
        this.c = context.getPackageName();
    }
}
