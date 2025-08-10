package dc;

import com.wear.bean.SwitchBeanFeaturesConfig;
import com.wear.bean.SwitchBeanUserConfig;
import com.wear.util.WearUtils;

/* compiled from: SwitchUtils.java */
/* loaded from: classes4.dex */
public class og3 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(int r4) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.og3.a(int):boolean");
    }

    public static boolean b(int i) {
        SwitchBeanUserConfig switchBeanUserConfig = (SwitchBeanUserConfig) WearUtils.x.T(1);
        if (switchBeanUserConfig == null) {
            switchBeanUserConfig = new SwitchBeanUserConfig();
            switchBeanUserConfig.decode(false);
        }
        SwitchBeanUserConfig.Entity entity = switchBeanUserConfig.getEntity();
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return true;
                    }
                    if (entity != null && entity.getNotificationPreview() > 0) {
                        return true;
                    }
                } else if (entity != null && entity.getNotificationCall() > 0) {
                    return true;
                }
            } else if (entity != null && entity.getNotificationSound() > 0) {
                return true;
            }
        } else if (entity != null && entity.getNotification() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(com.wear.bean.handlerbean.IPeopleInfo r10) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.og3.c(com.wear.bean.handlerbean.IPeopleInfo):java.lang.String");
    }

    public static SwitchBeanFeaturesConfig.VersionEntity d() {
        SwitchBeanFeaturesConfig switchBeanFeaturesConfig = (SwitchBeanFeaturesConfig) WearUtils.x.T(2);
        if (switchBeanFeaturesConfig == null) {
            switchBeanFeaturesConfig = new SwitchBeanFeaturesConfig();
            switchBeanFeaturesConfig.decode(false);
        }
        SwitchBeanFeaturesConfig.Entity entity = switchBeanFeaturesConfig.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.getC0001();
    }

    public static void e(int i, int i2) {
        SwitchBeanUserConfig switchBeanUserConfig = (SwitchBeanUserConfig) WearUtils.x.T(1);
        if (switchBeanUserConfig == null) {
            switchBeanUserConfig = new SwitchBeanUserConfig();
            switchBeanUserConfig.decode(false);
        }
        SwitchBeanUserConfig.Entity entity = switchBeanUserConfig.getEntity();
        if (i == 1) {
            entity.setNotification(i2);
        } else if (i == 2) {
            entity.setNotificationSound(i2);
        } else if (i == 3) {
            entity.setNotificationCall(i2);
        } else if (i == 4) {
            entity.setNotificationPreview(i2);
        }
        switchBeanUserConfig.update2Db();
    }
}
