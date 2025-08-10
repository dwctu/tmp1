package dc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.lovense.wear.R;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.util.WearUtils;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* compiled from: NetworkUtils.java */
/* loaded from: classes4.dex */
public class hf3 {

    /* compiled from: NetworkUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ Context a;

        /* compiled from: NetworkUtils.java */
        /* renamed from: dc.hf3$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0183a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0183a(a aVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        /* compiled from: NetworkUtils.java */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent;
                if (Build.VERSION.SDK_INT > 10) {
                    intent = new Intent("android.settings.SETTINGS");
                } else {
                    intent = new Intent();
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.SETTINGS"));
                    intent.setAction("android.intent.action.VIEW");
                }
                a.this.a.startActivity(intent);
            }
        }

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new AlertDialog.Builder(this.a).setTitle(ah4.e(R.string.common_netError)).setMessage(ah4.e(R.string.common_settingTip)).setPositiveButton(ah4.e(R.string.common_setting), new b()).setNegativeButton(ah4.e(R.string.common_no), new DialogInterfaceOnClickListenerC0183a(this)).show();
        }
    }

    public static String a() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) WearUtils.x.getSystemService("wifi");
            if (wifiManager.isWifiEnabled() && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String strC = c(connectionInfo.getIpAddress());
                if (g(strC)) {
                    return strC;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static NetworkInfo b() {
        return ((ConnectivityManager) WearUtils.x.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String c(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static boolean d(Context context) {
        if (context == null) {
            context = WearUtils.x;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static void e(Context context) {
        ((Activity) context).runOnUiThread(new a(context));
    }

    public static void f(Context context) {
        EventBus.getDefault().post(new LoginStatusActionEvent());
    }

    public static boolean g(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$").matcher(str).matches();
    }
}
