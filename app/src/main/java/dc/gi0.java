package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.util.concurrent.Executors;

/* compiled from: HuaweiImpl.java */
/* loaded from: classes.dex */
public class gi0 implements wh0 {
    public final Context a;
    public final Handler b = new Handler(Looper.getMainLooper());

    /* compiled from: HuaweiImpl.java */
    public class a implements Runnable {
        public final /* synthetic */ vh0 a;

        public a(vh0 vh0Var) {
            this.a = vh0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            gi0.this.f(this.a);
        }
    }

    /* compiled from: HuaweiImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ vh0 a;
        public final /* synthetic */ String b;

        public b(gi0 gi0Var, vh0 vh0Var, String str) {
            this.a = vh0Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    /* compiled from: HuaweiImpl.java */
    public class c implements Runnable {
        public final /* synthetic */ vh0 a;
        public final /* synthetic */ OAIDException b;

        public c(gi0 gi0Var, vh0 vh0Var, OAIDException oAIDException) {
            this.a = vh0Var;
            this.b = oAIDException;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    public gi0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
        } catch (Exception e) {
            xh0.a(e);
        }
        if (AdvertisingIdClient.isAdvertisingIdAvailable(context)) {
            return true;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        }
        return true;
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) {
        if (this.a == null || vh0Var == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new a(vh0Var));
    }

    public final void d(vh0 vh0Var, OAIDException oAIDException) {
        this.b.post(new c(this, vh0Var, oAIDException));
    }

    public final void e(vh0 vh0Var, String str) {
        this.b.post(new b(this, vh0Var, str));
    }

    public final void f(vh0 vh0Var) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
            if (advertisingIdInfo == null) {
                d(vh0Var, new OAIDException("Advertising identifier info is null"));
            } else if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                d(vh0Var, new OAIDException("User has disabled advertising identifier"));
            } else {
                e(vh0Var, advertisingIdInfo.getId());
            }
        } catch (IOException e) {
            xh0.a(e);
            d(vh0Var, new OAIDException(e));
        }
    }
}
