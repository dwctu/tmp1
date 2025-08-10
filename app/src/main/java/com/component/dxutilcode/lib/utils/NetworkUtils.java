package com.component.dxutilcode.lib.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import dc.pe0;
import dc.ve0;
import dc.xe0;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class NetworkUtils {

    public static final class NetworkChangedReceiver extends BroadcastReceiver {
        public a a;
        public Set<b> b = new HashSet();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
            public void run() {
                a aVarB = NetworkUtils.b();
                if (NetworkChangedReceiver.this.a == aVarB) {
                    return;
                }
                NetworkChangedReceiver.this.a = aVarB;
                if (aVarB == a.NETWORK_NO) {
                    Iterator it = NetworkChangedReceiver.this.b.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).b();
                    }
                } else {
                    Iterator it2 = NetworkChangedReceiver.this.b.iterator();
                    while (it2.hasNext()) {
                        ((b) it2.next()).a(aVarB);
                    }
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                xe0.R(new a(), 1000L);
            }
        }
    }

    public enum a {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public interface b {
        void a(a aVar);

        void b();
    }

    static {
        new CopyOnWriteArraySet();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkInfo a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ve0.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static a b() {
        if (i()) {
            return a.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoA = a();
        if (networkInfoA == null || !networkInfoA.isAvailable()) {
            return a.NETWORK_NO;
        }
        if (networkInfoA.getType() == 1) {
            return a.NETWORK_WIFI;
        }
        if (networkInfoA.getType() != 0) {
            return a.NETWORK_UNKNOWN;
        }
        switch (networkInfoA.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return a.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return a.NETWORK_3G;
            case 13:
            case 18:
                return a.NETWORK_4G;
            case 19:
            default:
                String subtypeName = networkInfoA.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? a.NETWORK_3G : a.NETWORK_UNKNOWN;
            case 20:
                return a.NETWORK_5G;
        }
    }

    public static String c() {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) ve0.a().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return "no_network";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "wifi";
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 == null) {
            return "no_network_default";
        }
        NetworkInfo.State state2 = networkInfo2.getState();
        String subtypeName = networkInfo2.getSubtypeName();
        if (state2 == null) {
            return "no_network_default";
        }
        if (state2 != NetworkInfo.State.CONNECTED && state2 != NetworkInfo.State.CONNECTING) {
            return "no_network_default";
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return "5G_" + subtypeName;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G_" + subtypeName;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G_" + subtypeName;
            case 13:
                return "4G_" + subtypeName;
            default:
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return "3G_" + subtypeName;
                }
                return "UNKNOW_" + subtypeName;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean d() {
        return e() || g(null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean e() {
        return f("");
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.baidu.com";
        }
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "223.5.5.5";
        }
        return pe0.a(String.format("ping -c 1 %s", str), false).a == 0;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean h() {
        NetworkInfo networkInfoA = a();
        return networkInfoA != null && networkInfoA.isConnected();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean i() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) ve0.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean j() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) ve0.a().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }
}
