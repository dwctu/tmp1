package dc;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlayer;
import com.wear.bean.Group;
import com.wear.dao.DaoUtils;
import com.wear.network.presenter.bean.VibemateBetrayOneselfBean;
import com.wear.util.WearUtils;
import java.util.Iterator;
import java.util.Map;

/* compiled from: VibemateGuideUtils.java */
/* loaded from: classes4.dex */
public class eh3 {
    public static eh3 a;

    /* compiled from: VibemateGuideUtils.java */
    public class a implements Runnable {
        public a(eh3 eh3Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            mk3.a.C();
            DaoUtils.getRemoteGuideVibematedDao().isRemoveDisguise();
        }
    }

    public static synchronized eh3 a() {
        if (a == null) {
            a = new eh3();
        }
        return a;
    }

    public void b(Context context) {
        String strH = eg3.h(context, "vibemate_betray_oneself", "");
        if ((!strH.isEmpty() ? ((VibemateBetrayOneselfBean) WearUtils.A.fromJson(strH, VibemateBetrayOneselfBean.class)).getData().isVibemateBetrayOneself() : false) && d()) {
            new Handler().postDelayed(new a(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public void c() {
        ye3.d("M0057", "");
    }

    public boolean d() {
        return pc1.a.o().size() > 0;
    }

    public boolean e(Context context) {
        boolean z = false;
        boolean zD = eg3.d(context, "open_adv", false);
        if (zD) {
            return zD;
        }
        Map<String, Group> mapL = ch3.n().l();
        double dE = pg3.h().e();
        Iterator<Group> it = mapL.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Group next = it.next();
            if (next.getMembers().size() >= dE && next.getStatus() == 1) {
                z = true;
                break;
            }
        }
        if (!z || !d() || !pg3.h().d()) {
            return zD;
        }
        eg3.i(context, "open_adv", Boolean.TRUE);
        return true;
    }
}
