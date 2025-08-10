package dc;

import com.wear.bean.BackWork;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ReWorkSwitch.java */
/* loaded from: classes3.dex */
public class fp1 {
    public static String a() {
        if (WearUtils.x == null || WearUtils.y.u() == null) {
            return null;
        }
        return WearUtils.y.u().getId();
    }

    public static Map<String, String> b(String str) {
        if (WearUtils.e1(str)) {
            return null;
        }
        return (Map) WearUtils.A.fromJson(str, HashMap.class);
    }

    public static void c() {
        List<BackWork> works;
        String strA = a();
        if (WearUtils.e1(strA) || (works = DaoUtils.getBackWorkDao().getWorks(strA)) == null || works.size() <= 0) {
            return;
        }
        for (BackWork backWork : works) {
            String workId = backWork.getWorkId();
            workId.hashCode();
            switch (workId) {
                case "1":
                    hp1.c(backWork.getStaticParams(), b(backWork.getStatus()), false, backWork.getTargetEmail());
                    break;
                case "2":
                    hp1.a(backWork.getStaticParams(), b(backWork.getStatus()), false, null, backWork.getTargetEmail());
                    break;
                case "3":
                    hp1.b(backWork.getStaticParams(), b(backWork.getStatus()), false, backWork.getTargetEmail());
                    break;
            }
        }
    }

    public static void d(String str) {
        EventBus.getDefault().post(new UserUpdateEvent(str));
    }
}
