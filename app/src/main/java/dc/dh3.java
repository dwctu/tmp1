package dc;

import android.text.TextUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.bean.Group;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;

/* compiled from: VersionTool.java */
/* loaded from: classes4.dex */
public class dh3 {
    public static boolean a(User user) {
        if (user == null) {
            return false;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (user.isControlLink()) {
            return true;
        }
        if (WearUtils.e1(remotePlatform)) {
            remotePlatform = user.getDeviceType();
            remoteVersion = user.getDeviceAppVersion();
        }
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return false;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return (remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() > 376) || (remotePlatform.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() > 361);
    }

    public static boolean b(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null) {
            return false;
        }
        if ((iPeopleInfo instanceof Group) || (iPeopleInfo instanceof UserRoulette)) {
            return true;
        }
        if (!(iPeopleInfo instanceof User)) {
            return false;
        }
        User user = (User) iPeopleInfo;
        if (user.isControlLink()) {
            return true;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return false;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return (remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() > 373) || (remotePlatform.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() > 357);
    }

    public static boolean c(User user) {
        boolean z = false;
        if (user == null) {
            return false;
        }
        if (user.isControlLink()) {
            return true;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return false;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        if ((remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() > 365) || (remotePlatform.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() > 352)) {
            z = true;
        }
        if (!remotePlatform.toLowerCase().equals("pc") || Integer.valueOf(strReplace).intValue() <= 100) {
            return z;
        }
        return true;
    }

    public static boolean d(sa2 sa2Var) {
        IPeopleInfo iPeopleInfoC = sa2Var.C();
        if (iPeopleInfoC == null) {
            return false;
        }
        if (iPeopleInfoC instanceof Group) {
            return true;
        }
        User user = (User) sa2Var.C();
        if (user.isControlLink()) {
            return true;
        }
        String deviceType = user.getDeviceType();
        String deviceAppVersion = user.getDeviceAppVersion();
        if (WearUtils.e1(deviceType) || WearUtils.e1(deviceAppVersion)) {
            return false;
        }
        String strReplace = deviceAppVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        if (deviceType.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() < 343) {
            return false;
        }
        if (!deviceType.toLowerCase().equals("ios") || Integer.valueOf(strReplace).intValue() >= 334) {
            return !deviceType.toLowerCase().equals("pc") || Integer.valueOf(strReplace).intValue() >= 130;
        }
        return false;
    }

    public static boolean e(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo instanceof Group) {
            return false;
        }
        User user = (User) iPeopleInfo;
        if (user.isControlLink()) {
            return true;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        try {
            if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
                return false;
            }
            remoteVersion = remoteVersion.replace(".", "");
            if (WearUtils.e1(remoteVersion)) {
                remoteVersion = "0";
            }
            if (remoteVersion.length() > 3) {
                remoteVersion = remoteVersion.substring(0, 3);
            } else if (remoteVersion.length() < 3) {
                int length = remoteVersion.length();
                for (int i = 0; i < 3 - length; i++) {
                    remoteVersion = remoteVersion + "0";
                }
            }
            if ((!remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) || Integer.valueOf(remoteVersion).intValue() <= 305) && (!remotePlatform.toLowerCase().equals("ios") || Integer.valueOf(remoteVersion).intValue() <= 302)) {
                if (!remotePlatform.toLowerCase().equals("pc")) {
                    return false;
                }
                if (Integer.valueOf(remoteVersion).intValue() <= 100) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            ye3.d("S0003", remotePlatform + ";" + remoteVersion + ";" + user.getId());
            FirebaseCrashlytics.getInstance().recordException(e);
            return false;
        }
    }

    public static String f(IPeopleInfo iPeopleInfo) {
        return og3.c(iPeopleInfo);
    }

    public static int g(User user) {
        if (user == null) {
            return 0;
        }
        if (m(user)) {
            return 1;
        }
        if (user.isControlLink()) {
            return 0;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (WearUtils.e1(remotePlatform)) {
            remotePlatform = user.getDeviceType();
            remoteVersion = user.getDeviceAppVersion();
        }
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return 0;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return ((!remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) || Integer.valueOf(strReplace).intValue() >= 546) && (!remotePlatform.toLowerCase().equals("ios") || Integer.valueOf(strReplace).intValue() >= 541)) ? 0 : 2;
    }

    public static boolean h(User user) {
        if (user == null || m(user) || user.isControlLink()) {
            return false;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (WearUtils.e1(remotePlatform)) {
            remotePlatform = user.getDeviceType();
            remoteVersion = user.getDeviceAppVersion();
        }
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return false;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return (remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() > 578) || (remotePlatform.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() > 575);
    }

    public static boolean i(User user) {
        if (user.isControlLink()) {
            return true;
        }
        String deviceType = user.getDeviceType();
        String deviceAppVersion = user.getDeviceAppVersion();
        if (WearUtils.e1(deviceType) || WearUtils.e1(deviceAppVersion)) {
            return false;
        }
        String strReplace = deviceAppVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        boolean z = deviceType.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() < 362;
        String str = "platform==" + deviceType + "version==" + strReplace;
        return z;
    }

    public static boolean j(User user) {
        if (user.isControlLink()) {
            return true;
        }
        String deviceType = user.getDeviceType();
        String deviceAppVersion = user.getDeviceAppVersion();
        if (!WearUtils.e1(deviceType) && !WearUtils.e1(deviceAppVersion)) {
            String strReplace = deviceAppVersion.replace(".", "");
            if (WearUtils.e1(strReplace)) {
                strReplace = "0";
            }
            if (strReplace.length() > 3) {
                strReplace = strReplace.substring(0, 3);
            } else if (strReplace.length() < 3) {
                int length = strReplace.length();
                for (int i = 0; i < 3 - length; i++) {
                    strReplace = strReplace + "0";
                }
            }
            if (deviceType.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() < 350) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(User user) {
        if (user == null) {
            return false;
        }
        if (user.isControlLink()) {
            return true;
        }
        String deviceType = user.getDeviceType();
        String deviceAppVersion = user.getDeviceAppVersion();
        if (WearUtils.e1(deviceType) || WearUtils.e1(deviceAppVersion)) {
            return false;
        }
        String strReplace = deviceAppVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return deviceType.toLowerCase().equals("pc") && Integer.valueOf(strReplace).intValue() < 135;
    }

    public static boolean l(User user) {
        if (user == null) {
            return false;
        }
        if (user.isControlLink()) {
            return true;
        }
        String deviceType = user.getDeviceType();
        String deviceAppVersion = user.getDeviceAppVersion();
        if (WearUtils.e1(deviceType) || WearUtils.e1(deviceAppVersion)) {
            return false;
        }
        String strReplace = deviceAppVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return (deviceType.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() < 351) || (deviceType.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() < 364);
    }

    public static boolean m(User user) {
        if (user == null) {
            return false;
        }
        String remotePlatform = user.getRemotePlatform();
        if ("pc".equals(remotePlatform)) {
            return true;
        }
        if (TextUtils.isEmpty(remotePlatform)) {
            remotePlatform = user.getDeviceType();
        }
        return "pc".equals(remotePlatform);
    }

    public static boolean n(User user) {
        if (m(user) || user == null) {
            return false;
        }
        if (user.isControlLink()) {
            return true;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (WearUtils.e1(remotePlatform)) {
            remotePlatform = user.getDeviceType();
            remoteVersion = user.getDeviceAppVersion();
        }
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return false;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return (remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() > 393) || (remotePlatform.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() > 380);
    }

    public static boolean o(User user) {
        if (m(user) || user == null) {
            return false;
        }
        if (user.isControlLink()) {
            return true;
        }
        String remotePlatform = user.getRemotePlatform();
        String remoteVersion = user.getRemoteVersion();
        if (WearUtils.e1(remotePlatform)) {
            remotePlatform = user.getDeviceType();
            remoteVersion = user.getDeviceAppVersion();
        }
        if (WearUtils.e1(remotePlatform) || WearUtils.e1(remoteVersion)) {
            return false;
        }
        String strReplace = remoteVersion.replace(".", "");
        if (WearUtils.e1(strReplace)) {
            strReplace = "0";
        }
        if (strReplace.length() > 3) {
            strReplace = strReplace.substring(0, 3);
        } else if (strReplace.length() < 3) {
            int length = strReplace.length();
            for (int i = 0; i < 3 - length; i++) {
                strReplace = strReplace + "0";
            }
        }
        return (remotePlatform.toLowerCase().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) && Integer.valueOf(strReplace).intValue() > 379) || (remotePlatform.toLowerCase().equals("ios") && Integer.valueOf(strReplace).intValue() > 365);
    }
}
