package dc;

import org.greenrobot.eventbus.EventBus;

/* compiled from: JUtils.java */
/* loaded from: classes.dex */
public class ah0 {
    public static boolean a;

    public static void a(int i) {
        EventBus.getDefault().post(new hh0(i));
    }
}
