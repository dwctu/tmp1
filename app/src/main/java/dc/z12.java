package dc;

import android.app.Activity;
import com.wear.ext.ActivityKt;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.music.MusicControl;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: ControlMediatorUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/wear/main/control/ControlMediatorUtils;", "", "()V", "isControlling", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class z12 {
    @JvmStatic
    public static final boolean a() {
        LinkedList<Activity> linkedListD = ActivityKt.d();
        boolean z = false;
        if (!(linkedListD instanceof Collection) || !linkedListD.isEmpty()) {
            Iterator<T> it = linkedListD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Activity) it.next()) instanceof RemoteMultiControlActivity) {
                    z = true;
                    break;
                }
            }
        }
        if (y12.c.a().m()) {
            z = true;
        }
        if (na2.m().i()) {
            z = true;
        }
        if (MusicControl.h0().O()) {
            z = true;
        }
        if (mk2.P().h0()) {
            z = true;
        }
        if (ff2.d) {
            return true;
        }
        return z;
    }
}
