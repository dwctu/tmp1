package dc;

import android.os.Handler;
import android.os.Looper;
import com.component.dxfunctionkits.forbidden.bean.ForbiddenReason;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.event.SetSyncCommonDataEvent;
import com.wear.util.WearUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

/* compiled from: ForbiddenUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/wear/util/ForbiddenUtils;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "runable", "Ljava/lang/Runnable;", "getRunable", "()Ljava/lang/Runnable;", "setRunable", "(Ljava/lang/Runnable;)V", "checkForbidden", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ne3 {

    @NotNull
    public static final ne3 a = new ne3();

    @NotNull
    public static Runnable b = new Runnable() { // from class: dc.pc3
        @Override // java.lang.Runnable
        public final void run() throws Exception {
            ne3.d();
        }
    };

    @NotNull
    public static Handler c = new Handler(Looper.getMainLooper());

    public static final void d() throws Exception {
        zx.s(new by() { // from class: dc.oc3
            @Override // dc.by
            public final void a(boolean z, ForbiddenReason forbiddenReason, boolean z2) {
                ne3.e(z, forbiddenReason, z2);
            }
        });
    }

    public static final void e(boolean z, ForbiddenReason forbiddenReason, boolean z2) {
        String str;
        String str2 = "NetworkReceiver onResult: " + z;
        WearUtils.D = z;
        EventBus.getDefault().post(new SetSyncCommonDataEvent());
        if (forbiddenReason == ForbiddenReason.REMOTE) {
            str = SyncWsProtocol.CONTROL_STARTSYNC_JOIN_TYPE_KEY;
        } else if (forbiddenReason == ForbiddenReason.LANGUAGE) {
            str = SyncWsProtocol.CONTROL_JUMP_TYPE_KEY;
        } else if (forbiddenReason == ForbiddenReason.REGION) {
            str = "102";
        } else if (forbiddenReason == ForbiddenReason.MOBILE_NETWORK) {
            str = SyncWsProtocol.CONTROL_SYNC_TYPE_KEY;
        } else if (!z2) {
            str = SyncWsProtocol.CONTROL_106_TYPE_KEY;
        } else if (Intrinsics.areEqual("zh", lg3.f(WearUtils.x))) {
            z = true;
            str = SyncWsProtocol.CONTROL_TIME_LEFT_TYPE_KEY;
        } else {
            str = "";
        }
        if (z) {
            try {
                HashMap map = new HashMap();
                map.put("type", str);
                ye3.d("W0002", WearUtils.A.toJson(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a() {
        c.removeCallbacks(b);
        c.postDelayed(b, 500L);
    }
}
