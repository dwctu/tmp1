package dc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.broadcom.bt.service.ftp.BluetoothFTP;
import dc.l51;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PermissionChecker.java */
/* loaded from: classes2.dex */
public final class x51 {
    public static boolean a(@Nullable Activity activity, boolean z) {
        if (activity == null) {
            if (z) {
                throw new IllegalArgumentException("The instance of the context must be an activity object");
            }
            return false;
        }
        if (activity.isFinishing()) {
            if (z) {
                throw new IllegalStateException("The activity has been finishing, please manually determine the status of the activity");
            }
            return false;
        }
        if (!n51.g() || !activity.isDestroyed()) {
            return true;
        }
        if (z) {
            throw new IllegalStateException("The activity has been destroyed, please manually determine the status of the activity");
        }
        return false;
    }

    public static void b(@NonNull List<String> list) {
        if (m61.g(list, "android.permission.BODY_SENSORS_BACKGROUND")) {
            if (m61.g(list, "android.permission.BODY_SENSORS_BACKGROUND") && !m61.g(list, "android.permission.BODY_SENSORS")) {
                throw new IllegalArgumentException("Applying for background sensor permissions must contain android.permission.BODY_SENSORS");
            }
            for (String str : list) {
                if (m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_BACKGROUND_LOCATION at the same time is not supported");
                }
                if (m61.h(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_MEDIA_LOCATION at the same time is not supported");
                }
            }
        }
    }

    public static void c(@NonNull List<String> list) {
        if (m61.g(list, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            if (m61.g(list, "android.permission.ACCESS_COARSE_LOCATION") && !m61.g(list, "android.permission.ACCESS_FINE_LOCATION")) {
                throw new IllegalArgumentException("Applying for background positioning permissions must include android.permission.ACCESS_FINE_LOCATION");
            }
            for (String str : list) {
                if (!m61.h(str, "android.permission.ACCESS_FINE_LOCATION") && !m61.h(str, "android.permission.ACCESS_COARSE_LOCATION") && !m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    throw new IllegalArgumentException("Because it includes background location permissions, do not apply for permissions unrelated to location");
                }
            }
        }
    }

    public static void d(@NonNull List<l51.c> list, String str) {
        e(list, str, Integer.MAX_VALUE);
    }

    public static void e(@NonNull List<l51.c> list, String str, int i) {
        l51.c next;
        String str2;
        Iterator<l51.c> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (TextUtils.equals(next.a, str)) {
                    break;
                }
            }
        }
        if (next == null) {
            throw new IllegalStateException("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"" + str + "\" />");
        }
        int i2 = next.b;
        if (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("The AndroidManifest.xml file <uses-permission android:name=\"");
            sb.append(str);
            sb.append("\" android:maxSdkVersion=\"");
            sb.append(i2);
            sb.append("\" /> does not meet the requirements, ");
            if (i != Integer.MAX_VALUE) {
                str2 = "the minimum requirement for maxSdkVersion is " + i;
            } else {
                str2 = "please delete the android:maxSdkVersion=\"" + i2 + "\" attribute";
            }
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void f(@NonNull Context context, @NonNull List<String> list, @Nullable l51 l51Var) {
        int i;
        if (l51Var == null) {
            return;
        }
        List<l51.c> list2 = l51Var.c;
        if (list2.isEmpty()) {
            throw new IllegalStateException("No permissions are registered in the AndroidManifest.xml file");
        }
        if (n51.m()) {
            i = context.getApplicationInfo().minSdkVersion;
        } else {
            l51.e eVar = l51Var.b;
            i = eVar != null ? eVar.a : 23;
        }
        for (String str : list) {
            if (!m61.h(str, "android.permission.NOTIFICATION_SERVICE") && !m61.h(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") && !m61.h(str, "android.permission.BIND_VPN_SERVICE") && !m61.h(str, "android.permission.PICTURE_IN_PICTURE")) {
                d(list2, str);
                if (m61.h(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                    d(list2, "android.permission.BODY_SENSORS");
                } else if (!m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    if (i < 33) {
                        if (m61.h(str, "android.permission.READ_MEDIA_IMAGES") || m61.h(str, "android.permission.READ_MEDIA_VIDEO") || m61.h(str, "android.permission.READ_MEDIA_AUDIO")) {
                            e(list2, "android.permission.READ_EXTERNAL_STORAGE", 32);
                        } else if (m61.h(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                            e(list2, "android.permission.ACCESS_FINE_LOCATION", 32);
                        }
                    }
                    if (i < 31) {
                        if (m61.h(str, "android.permission.BLUETOOTH_SCAN")) {
                            e(list2, BluetoothFTP.BLUETOOTH_ADMIN_PERM, 30);
                            e(list2, "android.permission.ACCESS_FINE_LOCATION", 30);
                        } else if (m61.h(str, "android.permission.BLUETOOTH_CONNECT")) {
                            e(list2, BluetoothFTP.BLUETOOTH_PERM, 30);
                        } else if (m61.h(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                            e(list2, BluetoothFTP.BLUETOOTH_ADMIN_PERM, 30);
                        }
                    }
                    if (i < 30 && m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                        e(list2, "android.permission.READ_EXTERNAL_STORAGE", 29);
                        e(list2, "android.permission.WRITE_EXTERNAL_STORAGE", 29);
                    } else if (i < 26 && m61.h(str, "android.permission.READ_PHONE_NUMBERS")) {
                        e(list2, "android.permission.READ_PHONE_STATE", 25);
                    } else if (m61.h(str, "com.android.permission.GET_INSTALLED_APPS")) {
                        d(list2, "android.permission.QUERY_ALL_PACKAGES");
                    }
                } else if (n51.b(context) >= 31) {
                    e(list2, "android.permission.ACCESS_FINE_LOCATION", 30);
                    d(list2, "android.permission.ACCESS_COARSE_LOCATION");
                } else {
                    d(list2, "android.permission.ACCESS_FINE_LOCATION");
                }
            }
        }
    }

    public static void g(@NonNull Context context, @NonNull List<String> list) {
        if (m61.g(list, "android.permission.ACCESS_MEDIA_LOCATION")) {
            for (String str : list) {
                if (!m61.h(str, "android.permission.ACCESS_MEDIA_LOCATION") && !m61.h(str, "android.permission.READ_MEDIA_IMAGES") && !m61.h(str, "android.permission.READ_EXTERNAL_STORAGE") && !m61.h(str, "android.permission.WRITE_EXTERNAL_STORAGE") && !m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("Because it includes access media location permissions, do not apply for permissions unrelated to access media location");
                }
            }
            if (n51.b(context) >= 33) {
                if (!m61.g(list, "android.permission.READ_MEDIA_IMAGES") && !m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("You must add android.permission.READ_MEDIA_IMAGES or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
                }
            } else if (!m61.g(list, "android.permission.READ_EXTERNAL_STORAGE") && !m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("You must add android.permission.READ_EXTERNAL_STORAGE or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
            }
        }
    }

    public static void h(@NonNull List<String> list, @Nullable l51 l51Var) {
        if ((!m61.g(list, "android.permission.BLUETOOTH_SCAN") && !m61.g(list, "android.permission.NEARBY_WIFI_DEVICES")) || m61.g(list, "android.permission.ACCESS_FINE_LOCATION") || l51Var == null) {
            return;
        }
        for (l51.c cVar : l51Var.c) {
            if (m61.h(cVar.a, "android.permission.BLUETOOTH_SCAN") || m61.h(cVar.a, "android.permission.NEARBY_WIFI_DEVICES")) {
                if (!cVar.a()) {
                    String str = cVar.b != Integer.MAX_VALUE ? "android:maxSdkVersion=\"" + cVar.b + "\" " : "";
                    throw new IllegalArgumentException("If your app doesn't use " + cVar.a + " to get physical location, please change the <uses-permission android:name=\"" + cVar.a + "\" " + str + "/> node in the manifest file to <uses-permission android:name=\"" + cVar.a + "\" android:usesPermissionFlags=\"neverForLocation\" " + str + "/> node, if your app need use " + cVar.a + " to get physical location, also need to add android.permission.ACCESS_FINE_LOCATION permissions");
                }
            }
        }
    }

    public static void i(@NonNull List<String> list, @Nullable l51 l51Var) {
        if (m61.g(list, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") && l51Var != null) {
            List<l51.d> list2 = l51Var.f;
            for (int i = 0; i < list2.size(); i++) {
                if (TextUtils.equals(list2.get(i).b, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
                    return;
                }
            }
            throw new IllegalArgumentException("No service registered permission attribute, please register <service android:permission=\"android.permission.BIND_NOTIFICATION_LISTENER_SERVICE\" > in AndroidManifest.xml");
        }
    }

    public static boolean j(@Nullable List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            if (z) {
                throw new IllegalArgumentException("The requested permission cannot be empty");
            }
            return false;
        }
        if (n51.a() <= 33 && z) {
            ArrayList arrayList = new ArrayList();
            Field[] declaredFields = v51.class.getDeclaredFields();
            if (declaredFields.length == 0) {
                return true;
            }
            for (Field field : declaredFields) {
                if (String.class.equals(field.getType())) {
                    try {
                        arrayList.add((String) field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            for (String str : list) {
                if (!m61.g(arrayList, str)) {
                    throw new IllegalArgumentException("The " + str + " is not a dangerous permission or special permission, please do not request dynamically");
                }
            }
        }
        return true;
    }

    public static void k(@NonNull Activity activity, @NonNull List<String> list, @Nullable l51 l51Var) {
        if (m61.g(list, "android.permission.PICTURE_IN_PICTURE") && l51Var != null) {
            List<l51.a> list2 = l51Var.e;
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).a) {
                    return;
                }
            }
            throw new IllegalArgumentException("No activity registered supportsPictureInPicture attribute, please register \n<activity android:name=\"" + activity.getClass().getName().replace(activity.getPackageName(), "") + "\" android:supportsPictureInPicture=\"true\" > in AndroidManifest.xml");
        }
    }

    public static void l(@NonNull Context context, @NonNull List<String> list, @Nullable l51 l51Var) {
        l51.b bVar;
        if (m61.g(list, "android.permission.READ_MEDIA_IMAGES") || m61.g(list, "android.permission.READ_MEDIA_VIDEO") || m61.g(list, "android.permission.READ_MEDIA_AUDIO") || m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE") || m61.g(list, "android.permission.READ_EXTERNAL_STORAGE") || m61.g(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (n51.b(context) >= 33 && m61.g(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("When targetSdkVersion >= 33 should use android.permission.READ_MEDIA_IMAGES, android.permission.READ_MEDIA_VIDEO, android.permission.READ_MEDIA_AUDIO instead of android.permission.READ_EXTERNAL_STORAGE");
            }
            if (m61.g(list, "android.permission.READ_MEDIA_IMAGES") || m61.g(list, "android.permission.ACCESS_MEDIA_LOCATION") || l51Var == null || (bVar = l51Var.d) == null) {
                return;
            }
            boolean zP = m61.p(context);
            int iB = n51.b(context);
            boolean z = bVar.a;
            if (iB >= 29 && !z && (m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE") || !zP)) {
                throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
            }
            if (iB >= 30 && !m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && !zP) {
                throw new IllegalArgumentException("The storage permission application is abnormal. If you have adapted the scope storage, please register the <meta-data android:name=\"ScopedStorage\" android:value=\"true\" /> attribute in the AndroidManifest.xml file. If there is no adaptation scope storage, please use android.permission.MANAGE_EXTERNAL_STORAGE to apply for permission");
            }
        }
    }

    public static void m(@NonNull Context context, @NonNull List<String> list) {
        int i = (m61.g(list, "android.permission.POST_NOTIFICATIONS") || m61.g(list, "android.permission.NEARBY_WIFI_DEVICES") || m61.g(list, "android.permission.BODY_SENSORS_BACKGROUND") || m61.g(list, "android.permission.READ_MEDIA_IMAGES") || m61.g(list, "android.permission.READ_MEDIA_VIDEO") || m61.g(list, "android.permission.READ_MEDIA_AUDIO")) ? 33 : (m61.g(list, "android.permission.BLUETOOTH_SCAN") || m61.g(list, "android.permission.BLUETOOTH_CONNECT") || m61.g(list, "android.permission.BLUETOOTH_ADVERTISE") || m61.g(list, "android.permission.SCHEDULE_EXACT_ALARM")) ? 31 : m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE") ? 30 : (m61.g(list, "android.permission.ACCESS_BACKGROUND_LOCATION") || m61.g(list, "android.permission.ACTIVITY_RECOGNITION") || m61.g(list, "android.permission.ACCESS_MEDIA_LOCATION")) ? 29 : m61.g(list, "android.permission.ACCEPT_HANDOVER") ? 28 : (m61.g(list, "android.permission.REQUEST_INSTALL_PACKAGES") || m61.g(list, "android.permission.ANSWER_PHONE_CALLS") || m61.g(list, "android.permission.READ_PHONE_NUMBERS") || m61.g(list, "android.permission.PICTURE_IN_PICTURE")) ? 26 : 23;
        if (n51.b(context) >= i) {
            return;
        }
        throw new RuntimeException("The targetSdkVersion SDK must be " + i + " or more, if you do not want to upgrade targetSdkVersion, please apply with the old permissions");
    }

    public static void n(@NonNull List<String> list) {
        if (!n51.f()) {
            if (m61.g(list, "android.permission.POST_NOTIFICATIONS") && !m61.g(list, "android.permission.NOTIFICATION_SERVICE")) {
                list.add("android.permission.NOTIFICATION_SERVICE");
            }
            if (m61.g(list, "android.permission.NEARBY_WIFI_DEVICES") && !m61.g(list, "android.permission.ACCESS_FINE_LOCATION")) {
                list.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if ((m61.g(list, "android.permission.READ_MEDIA_IMAGES") || m61.g(list, "android.permission.READ_MEDIA_VIDEO") || m61.g(list, "android.permission.READ_MEDIA_AUDIO")) && !m61.g(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (!n51.e() && m61.g(list, "android.permission.BLUETOOTH_SCAN") && !m61.g(list, "android.permission.ACCESS_FINE_LOCATION")) {
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (m61.g(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            if (m61.g(list, "android.permission.READ_EXTERNAL_STORAGE") || m61.g(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("If you have applied for MANAGE_EXTERNAL_STORAGE permissions, do not apply for the READ_EXTERNAL_STORAGE and WRITE_EXTERNAL_STORAGE permissions");
            }
            if (!n51.d()) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
                list.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
        if (!n51.c() && m61.g(list, "android.permission.ACTIVITY_RECOGNITION") && !m61.g(list, "android.permission.BODY_SENSORS")) {
            list.add("android.permission.BODY_SENSORS");
        }
        if (n51.n() || !m61.g(list, "android.permission.READ_PHONE_NUMBERS") || m61.g(list, "android.permission.READ_PHONE_STATE")) {
            return;
        }
        list.add("android.permission.READ_PHONE_STATE");
    }
}
