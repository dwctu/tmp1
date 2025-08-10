package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.mlkit.common.ha.HianalyticsLog;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import com.lovense.wear.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: HiAnalyticsThread.java */
/* renamed from: com.huawei.hms.scankit.p.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0378o extends Thread {
    private WeakReference<Context> a;
    public Handler b;

    public C0378o(Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        this.b = new a(this.a);
        Looper.loop();
    }

    /* compiled from: HiAnalyticsThread.java */
    /* renamed from: com.huawei.hms.scankit.p.o$a */
    public static class a extends Handler {
        private WeakReference<Context> b;
        private boolean a = true;
        private HashMap<String, HianalyticsLog> c = new HashMap<>();

        public a(WeakReference<Context> weakReference) {
            this.b = weakReference;
        }

        private HianalyticsLog a(String str) {
            if (HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.b.get())) {
                return null;
            }
            return HianalyticsLogProvider.getInstance().logBegin(this.b.get(), new C0354i(this.b.get()).a()).setModuleName(str).setApiName(str).setApkVersion("1.0.2.300");
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.a) {
                int i = message.what;
                if (i == R.integer.cancel_button_image_alpha) {
                    this.c.put("preview", a((String) message.obj));
                    return;
                }
                if (i == R.integer.config_navAnimTime) {
                    a(this.c.get("preview"));
                    this.c.put("preview", null);
                    return;
                }
                if (i == R.integer.app_bar_elevation_anim_duration) {
                    this.c.put("picture", a((String) message.obj));
                } else if (i == R.integer.bottom_sheet_slide_duration) {
                    a(this.c.get("picture"));
                    this.c.put("picture", null);
                } else if (i == R.integer.animation_default_duration) {
                    this.a = false;
                    Looper.myLooper().quit();
                }
            }
        }

        private static void a(HianalyticsLog hianalyticsLog) {
            if (hianalyticsLog != null) {
                HianalyticsLogProvider.getInstance().logEnd(hianalyticsLog);
            }
        }
    }
}
