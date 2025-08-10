package io.agora.rtc2.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.ThreadUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class CommonUtility {
    private static final String LENGTH_SEPARATOR_CHARACTER = "agora_length_&&_";
    private static final String OFFSET_SEPARATOR_CHARACTER = "agora_offset_&&_";
    public static final String PREFIX_ASSETS = "/assets/";
    public static final String PREFIX_URI = "content://";
    private static final String TAG = "CommonUtility";
    public static final int UNKNOWN_BATTERY_PERCENTAGE = 255;
    private static final String URI_PROTOCOL_HEAD = "/proc/";
    private static boolean failedToGetRunningTasks = false;
    private static boolean ignoreMonitor = false;
    private final WeakReference<Context> mContext;
    private String mExtraConnectivityFilterActionForTesting;
    private final Handler mHandler;
    private Listener mListener;
    private long mNativeHandle;
    private final ThreadUtils.ThreadChecker mThreadChecker;
    private ConnectivityManager.NetworkCallback mobileNetworkCallback = null;
    private volatile int mBatteryPercentage = 255;
    private boolean mDisposed = false;
    private AgoraPhoneStateListener mPhoneStateListener = null;
    private ConnectionChangeBroadcastReceiver mConnectionBroadcastReceiver = null;
    private PowerChangeReceiver mPowerChangeReceiver = null;
    private ProcessLifecycleOwner mProcessLifecycleOwner = null;
    private OrientationEventListener mOrientationListener = null;
    private int mLastOrientation = -1;

    public static class AgoraPhoneStateListener extends PhoneStateListener {
        private final WeakReference<CommonUtility> mCommonUtilityRef;
        private final WeakReference<Handler> mHandlerRef;
        private SignalStrength mSignalStrength;
        private volatile boolean phoneStatusNeedResume = false;

        public AgoraPhoneStateListener(CommonUtility commonUtility, Handler handler) {
            this.mCommonUtilityRef = new WeakReference<>(commonUtility);
            this.mHandlerRef = new WeakReference<>(handler);
        }

        private int invokeMethod(String str) {
            try {
                SignalStrength signalStrength = this.mSignalStrength;
                if (signalStrength != null) {
                    return ((Integer) signalStrength.getClass().getDeclaredMethod(str, new Class[0]).invoke(this.mSignalStrength, new Object[0])).intValue();
                }
            } catch (Exception unused) {
            }
            return 0;
        }

        @RequiresApi(26)
        public void fillCellInfoByNetworkType(@NonNull List<CellSignalStrength> list, @NonNull MediaNetworkInfo mediaNetworkInfo) {
            for (CellSignalStrength cellSignalStrength : list) {
                if (cellSignalStrength instanceof CellSignalStrengthLte) {
                    CellSignalStrengthLte cellSignalStrengthLte = (CellSignalStrengthLte) cellSignalStrength;
                    mediaNetworkInfo.rssi = cellSignalStrengthLte.getDbm();
                    mediaNetworkInfo.signalLevel = cellSignalStrengthLte.getLevel();
                    mediaNetworkInfo.snr = cellSignalStrengthLte.getRssnr();
                    return;
                }
                if ((cellSignalStrength instanceof CellSignalStrengthGsm) || (cellSignalStrength instanceof CellSignalStrengthCdma) || (cellSignalStrength instanceof CellSignalStrengthWcdma)) {
                    mediaNetworkInfo.rssi = cellSignalStrength.getDbm();
                    mediaNetworkInfo.signalLevel = cellSignalStrength.getLevel();
                    return;
                }
            }
        }

        @RequiresApi(26)
        public void fillCellInfoHighLevel(@NonNull MediaNetworkInfo mediaNetworkInfo) throws NoSuchMethodException, SecurityException {
            SignalStrength signalStrength = this.mSignalStrength;
            if (signalStrength != null) {
                try {
                    Method declaredMethod = signalStrength.getClass().getDeclaredMethod("getCellSignalStrengths", new Class[0]);
                    if (declaredMethod != null) {
                        fillCellInfoByNetworkType((List) declaredMethod.invoke(this.mSignalStrength, new Object[0]), mediaNetworkInfo);
                    }
                } catch (Exception unused) {
                    Logging.e(CommonUtility.TAG, "fillCellInfoHighLevel getDeclareMethod:getCellSignalStrengths failed! ");
                    fillCellInfoLowLevel(mediaNetworkInfo);
                }
            }
        }

        public void fillCellInfoIfPossible(Context context, MediaNetworkInfo mediaNetworkInfo) throws NoSuchMethodException, SecurityException {
            if (Build.VERSION.SDK_INT <= 28) {
                fillCellInfoLowLevel(mediaNetworkInfo);
            } else {
                fillCellInfoHighLevel(mediaNetworkInfo);
            }
        }

        public void fillCellInfoLowLevel(@NonNull MediaNetworkInfo mediaNetworkInfo) {
            mediaNetworkInfo.rssi = getRssi();
            mediaNetworkInfo.signalLevel = getLevel();
        }

        public int getAsuLevel() {
            return invokeMethod("getAsuLevel");
        }

        public int getLevel() {
            return invokeMethod("getLevel");
        }

        public int getRssi() {
            return invokeMethod("getDbm");
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            final CommonUtility commonUtility = this.mCommonUtilityRef.get();
            Handler handler = this.mHandlerRef.get();
            if (commonUtility == null || handler == null) {
                return;
            }
            if (i == 0) {
                if (this.phoneStatusNeedResume) {
                    this.phoneStatusNeedResume = false;
                    Logging.i(CommonUtility.TAG, "system phone call end delay 1000ms");
                    handler.postDelayed(new Runnable() { // from class: io.agora.rtc2.internal.CommonUtility.AgoraPhoneStateListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            commonUtility.onAudioRoutingPhoneChanged(true, 22, 0);
                        }
                    }, 1000L);
                    return;
                }
                return;
            }
            if (i == 1) {
                Logging.i(CommonUtility.TAG, "system phone call ring");
                this.phoneStatusNeedResume = true;
                commonUtility.onAudioRoutingPhoneChanged(false, 22, 1);
            } else if (i == 2) {
                Logging.i(CommonUtility.TAG, "system phone call start");
                this.phoneStatusNeedResume = true;
                commonUtility.onAudioRoutingPhoneChanged(false, 22, 2);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            this.mSignalStrength = signalStrength;
        }
    }

    public static class AndroidContextInfo {
        public String configDir;
        public String dataDir;
        public String device;
        public String deviceInfo;
        public String manufacturer;
        public String pkgName;
        public String pluginDir;
        public String systemInfo;

        @CalledByNative("AndroidContextInfo")
        public String getConfigDir() {
            return this.configDir;
        }

        @CalledByNative("AndroidContextInfo")
        public String getDataDir() {
            return this.dataDir;
        }

        @CalledByNative("AndroidContextInfo")
        public String getDevice() {
            return this.device;
        }

        @CalledByNative("AndroidContextInfo")
        public String getDeviceInfo() {
            return this.deviceInfo;
        }

        @CalledByNative("AndroidContextInfo")
        public String getManufacturer() {
            return this.manufacturer;
        }

        @CalledByNative("AndroidContextInfo")
        public String getPkgName() {
            return this.pkgName;
        }

        @CalledByNative("AndroidContextInfo")
        public String getPluginDir() {
            return this.pluginDir;
        }

        @CalledByNative("AndroidContextInfo")
        public String getSystemInfo() {
            return this.systemInfo;
        }
    }

    public interface Listener {
        void onAudioRoutingPhoneChanged(boolean z, int i, int i2);

        void onDispose();

        void onForegroundChanged(boolean z);

        void onNetworkChange(MediaNetworkInfo mediaNetworkInfo);
    }

    public static class MediaNetworkInfo {
        public String localIp4 = "";
        public String gatewayIp4 = "";
        public String localIp6 = "";
        public String gatewayIp6 = "";
        public int networkType = -1;
        public int networkSubtype = -1;
        public int signalLevel = 0;
        public int rssi = 0;
        public int snr = -100;
        public ArrayList<String> dnsList = null;
        public int linkspeed = 0;
        public int frequency = 0;
        public ArrayList<String> ifconfigs = null;

        @CalledByNative("MediaNetworkInfo")
        public int getAsu() {
            return this.snr;
        }

        @CalledByNative("MediaNetworkInfo")
        public ArrayList<String> getDnsList() {
            return this.dnsList;
        }

        @CalledByNative("MediaNetworkInfo")
        public int getFrequency() {
            return this.frequency;
        }

        @CalledByNative("MediaNetworkInfo")
        public String getGatewayIp4() {
            return this.gatewayIp4;
        }

        @CalledByNative("MediaNetworkInfo")
        public String getGatewayIp6() {
            return this.gatewayIp6;
        }

        @CalledByNative("MediaNetworkInfo")
        public int getLinkspeed() {
            return this.linkspeed;
        }

        @CalledByNative("MediaNetworkInfo")
        public String getLocalIp4() {
            return this.localIp4;
        }

        @CalledByNative("MediaNetworkInfo")
        public String getLocalIp6() {
            return this.localIp6;
        }

        @CalledByNative("MediaNetworkInfo")
        public int getNetworkSubtype() {
            return this.networkSubtype;
        }

        @CalledByNative("MediaNetworkInfo")
        public int getNetworkType() {
            return this.networkType;
        }

        @CalledByNative("MediaNetworkInfo")
        public int getRssi() {
            return this.rssi;
        }

        @CalledByNative("MediaNetworkInfo")
        public int getSignalLevel() {
            return this.signalLevel;
        }

        @CalledByNative("MediaNetworkInfo")
        public ArrayList<String> getVpnIfconfigs() {
            return this.ifconfigs;
        }
    }

    @CalledByNative
    public CommonUtility(Context context, long j) {
        Logging.d(TAG, "constructor()");
        this.mContext = new WeakReference<>(context);
        this.mNativeHandle = j;
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        HandlerThread handlerThread = new HandlerThread("UtilityThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: io.agora.rtc2.internal.CommonUtility.1
            @Override // java.lang.Runnable
            public void run() {
                CommonUtility.this.startMonitor();
            }
        });
    }

    public static boolean checkAccessNetworkState(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    public static boolean checkAccessWifiState(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0;
    }

    private static void fillWifiInfoIfPossible(Context context, MediaNetworkInfo mediaNetworkInfo) {
        int i;
        InetAddress inetAddressIntToInetAddress;
        if (!checkAccessWifiState(context)) {
            Logging.w(TAG, "fail to fillWifiInfo, permission ACCESS_WIFI_STATE not granted");
            return;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        if (dhcpInfo != null && (inetAddressIntToInetAddress = intToInetAddress(dhcpInfo.gateway)) != null) {
            mediaNetworkInfo.gatewayIp4 = inetAddressIntToInetAddress.getHostAddress();
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            Logging.w(TAG, "fail to fillWifiInfo, wifiInfo null");
            return;
        }
        int rssi = connectionInfo.getRssi();
        mediaNetworkInfo.rssi = rssi;
        mediaNetworkInfo.signalLevel = WifiManager.calculateSignalLevel(rssi, 5);
        mediaNetworkInfo.linkspeed = connectionInfo.getLinkSpeed();
        if (Build.VERSION.SDK_INT >= 21) {
            int frequency = connectionInfo.getFrequency();
            mediaNetworkInfo.frequency = frequency;
            if (frequency >= 5000) {
                i = 101;
            } else if (frequency < 2400) {
                return;
            } else {
                i = 100;
            }
            mediaNetworkInfo.networkSubtype = i;
        }
    }

    @CalledByNative
    public static int getAndroidVersion() {
        return Build.VERSION.SDK_INT;
    }

    private static String getAppPrivateStorageDir(Context context) {
        File externalFilesDir;
        return (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = context.getExternalFilesDir(null)) == null) ? context.getFilesDir().getAbsolutePath() : externalFilesDir.getAbsolutePath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    public static String getAssetsFilePath(Context context, String str) throws Throwable {
        String str2;
        AssetFileDescriptor assetFileDescriptorOpenFd;
        int fd;
        AssetFileDescriptor assetFileDescriptor = 0;
        String str3 = null;
        AssetFileDescriptor assetFileDescriptor2 = null;
        if (context == null || TextUtils.isEmpty(str)) {
            Logging.e("getAssetsFilePath failed for init error");
            return null;
        }
        try {
            try {
                assetFileDescriptorOpenFd = context.getAssets().openFd(str.substring(str.indexOf(PREFIX_ASSETS) + 8));
                try {
                    fd = ParcelFileDescriptor.dup(assetFileDescriptorOpenFd.getFileDescriptor()).getFd();
                } catch (Exception e) {
                    e = e;
                    String str4 = str3;
                    assetFileDescriptor2 = assetFileDescriptorOpenFd;
                    str2 = str4;
                    e.printStackTrace();
                    if (assetFileDescriptor2 != null) {
                        try {
                            assetFileDescriptor2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    assetFileDescriptor = str2;
                    Logging.i("getAssetsFilePath is: " + ((String) assetFileDescriptor));
                    return assetFileDescriptor;
                } catch (Throwable th) {
                    th = th;
                    assetFileDescriptor = assetFileDescriptorOpenFd;
                    if (assetFileDescriptor != 0) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                str2 = null;
            }
            if (fd < 0) {
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return null;
            }
            str3 = PREFIX_ASSETS + fd + OFFSET_SEPARATOR_CHARACTER + assetFileDescriptorOpenFd.getStartOffset() + LENGTH_SEPARATOR_CHARACTER + assetFileDescriptorOpenFd.getDeclaredLength();
            Logging.i("getAssetsFilePath for init offset:" + assetFileDescriptorOpenFd.getStartOffset() + "," + assetFileDescriptorOpenFd.getDeclaredLength());
            assetFileDescriptor = str3;
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                    assetFileDescriptor = str3;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    assetFileDescriptor = str3;
                }
            }
            Logging.i("getAssetsFilePath is: " + ((String) assetFileDescriptor));
            return assetFileDescriptor;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getContentFilePath(android.content.Context r3, android.net.Uri r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 == 0) goto L79
            if (r4 != 0) goto L7
            goto L79
        L7:
            android.content.ContentResolver r3 = r3.getContentResolver()
            r1 = -1
            java.lang.String r2 = "r"
            android.content.res.AssetFileDescriptor r3 = r3.openAssetFileDescriptor(r4, r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            java.io.FileDescriptor r4 = r3.getFileDescriptor()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L6c
            android.os.ParcelFileDescriptor r4 = android.os.ParcelFileDescriptor.dup(r4)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L6c
            int r1 = r4.getFd()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L6c
            if (r3 == 0) goto L37
            r3.close()     // Catch: java.io.IOException -> L24
            goto L37
        L24:
            r3 = move-exception
            r3.printStackTrace()
            goto L37
        L29:
            r4 = move-exception
            goto L2f
        L2b:
            r4 = move-exception
            goto L6e
        L2d:
            r4 = move-exception
            r3 = r0
        L2f:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L37
            r3.close()     // Catch: java.io.IOException -> L24
        L37:
            if (r1 >= 0) goto L3a
            return r0
        L3a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "/proc/"
            r3.append(r4)
            int r4 = android.os.Process.myPid()
            r3.append(r4)
            java.lang.String r4 = "/fd/"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "getContentFilePath is: "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            io.agora.rtc2.internal.Logging.i(r4)
            return r3
        L6c:
            r4 = move-exception
            r0 = r3
        L6e:
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r3 = move-exception
            r3.printStackTrace()
        L78:
            throw r4
        L79:
            java.lang.String r3 = "getContentFilePath failed for init error"
            io.agora.rtc2.internal.Logging.e(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.CommonUtility.getContentFilePath(android.content.Context, android.net.Uri):java.lang.String");
    }

    @CalledByNative
    public static AndroidContextInfo getContextInfo(Context context) {
        if (context == null) {
            Logging.w(TAG, "fail to getContextInfo, context null");
            return null;
        }
        AndroidContextInfo androidContextInfo = new AndroidContextInfo();
        androidContextInfo.device = DeviceUtils.getDeviceId();
        androidContextInfo.configDir = getAppPrivateStorageDir(context);
        androidContextInfo.dataDir = context.getCacheDir().getAbsolutePath();
        androidContextInfo.pluginDir = context.getApplicationInfo().nativeLibraryDir;
        androidContextInfo.deviceInfo = DeviceUtils.getDeviceInfo();
        androidContextInfo.systemInfo = DeviceUtils.getSystemInfo();
        androidContextInfo.manufacturer = DeviceUtils.getManufacturer();
        androidContextInfo.pkgName = context.getPackageName();
        return androidContextInfo;
    }

    @CalledByNative
    public static int getCpuTemperature() {
        return DeviceUtils.getCpuTemperature();
    }

    @CalledByNative
    public static int[] getDisplayMetrics() {
        Display defaultDisplay;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return new int[]{0, 0};
        }
        WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            }
            Logging.i(TAG, "getDisplayMetrics widthPixel: " + displayMetrics.heightPixels + " , heightPixel: " + displayMetrics.widthPixels);
            return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }
        return new int[]{0, 0};
    }

    private static String getIpAddressByType(InetAddress inetAddress, boolean z, StringBuilder sb) {
        if (z && (inetAddress instanceof Inet4Address)) {
            String publicIpAddress = getPublicIpAddress(inetAddress);
            if (!TextUtils.isEmpty(publicIpAddress) && sb.length() == 0) {
                sb.append(publicIpAddress);
            }
            return publicIpAddress;
        }
        if (z || !(inetAddress instanceof Inet6Address)) {
            return null;
        }
        String publicIpAddress2 = getPublicIpAddress(inetAddress);
        if (!TextUtils.isEmpty(publicIpAddress2) && sb.length() == 0) {
            sb.append(publicIpAddress2);
        }
        return publicIpAddress2;
    }

    @CalledByNative
    public static String getLocalHost(boolean z) {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            StringBuilder sb = new StringBuilder();
            for (NetworkInterface networkInterface : list) {
                if (!networkInterface.getName().startsWith("usb")) {
                    Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it.hasNext()) {
                        String ipAddressByType = getIpAddressByType((InetAddress) it.next(), z, sb);
                        if (!TextUtils.isEmpty(ipAddressByType)) {
                            return ipAddressByType;
                        }
                    }
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception e) {
            Logging.w(TAG, "fail to getLocalHost", e);
            return null;
        }
    }

    @CalledByNative
    public static String[] getLocalHostList() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            ArrayList arrayList = new ArrayList();
            for (NetworkInterface networkInterface : list) {
                String name = networkInterface.getName();
                if (!name.startsWith("usb")) {
                    Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it.hasNext()) {
                        String strInetAddressToIpAddress = inetAddressToIpAddress((InetAddress) it.next());
                        if (!TextUtils.isEmpty(strInetAddressToIpAddress)) {
                            arrayList.add(strInetAddressToIpAddress + "+" + name);
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            String[] strArr = new String[arrayList.size()];
            int i = 0;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                strArr[i] = (String) it2.next();
                i++;
            }
            return strArr;
        } catch (Exception e) {
            Logging.w(TAG, "fail to getLocalHostList", e);
            return null;
        }
    }

    private MediaNetworkInfo getNetworkInfo(Context context) throws NoSuchMethodException, SecurityException {
        StringBuilder sb;
        String str;
        MediaNetworkInfo mediaNetworkInfo = new MediaNetworkInfo();
        if (!checkAccessNetworkState(context)) {
            Logging.w(TAG, "fail to getNetworkInfo, permission ACCESS_NETWORK_STATE not granted");
            return mediaNetworkInfo;
        }
        String localHost = getLocalHost(true);
        if (!TextUtils.isEmpty(localHost)) {
            mediaNetworkInfo.localIp4 = localHost;
        }
        String localHost2 = getLocalHost(false);
        if (!TextUtils.isEmpty(localHost2)) {
            mediaNetworkInfo.localIp6 = localHost2;
        }
        NetworkInfo networkInfo = Connectivity.getNetworkInfo(context);
        mediaNetworkInfo.networkType = Connectivity.getNetworkType(networkInfo);
        if (networkInfo != null) {
            mediaNetworkInfo.networkSubtype = networkInfo.getSubtype();
        }
        mediaNetworkInfo.dnsList = Connectivity.getDnsList();
        if (mediaNetworkInfo.networkType != 2) {
            AgoraPhoneStateListener agoraPhoneStateListener = this.mPhoneStateListener;
            if (agoraPhoneStateListener != null) {
                agoraPhoneStateListener.fillCellInfoIfPossible(context, mediaNetworkInfo);
                sb = new StringBuilder();
                str = "networkType from Phone State Listener， rssi = ";
            }
            mediaNetworkInfo.ifconfigs = getVpnIfconfigs();
            return mediaNetworkInfo;
        }
        fillWifiInfoIfPossible(context, mediaNetworkInfo);
        sb = new StringBuilder();
        str = "networkType from WIFI, rssi = ";
        sb.append(str);
        sb.append(mediaNetworkInfo.rssi);
        sb.append(" level = ");
        sb.append(mediaNetworkInfo.signalLevel);
        Logging.d(TAG, sb.toString());
        mediaNetworkInfo.ifconfigs = getVpnIfconfigs();
        return mediaNetworkInfo;
    }

    private static String getPublicIpAddress(InetAddress inetAddress) {
        if (inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress()) {
            return null;
        }
        return inetAddress.getHostAddress();
    }

    private static String getSystemProperty(String str) throws Exception {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    @CalledByNative
    public static Object getSystemService(Context context, String str) {
        return context.getSystemService(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String inetAddressToIpAddress(InetAddress inetAddress) {
        if (inetAddress.isLoopbackAddress()) {
            return null;
        }
        if (inetAddress instanceof Inet4Address) {
            return ((Inet4Address) inetAddress).getHostAddress();
        }
        boolean z = inetAddress instanceof Inet6Address;
        return null;
    }

    private static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @CalledByNative
    public static boolean isAppInForeground() {
        final ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: io.agora.rtc2.internal.CommonUtility.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                } catch (Exception e) {
                    Logging.e(CommonUtility.TAG, "get App InForeground state failed.", e);
                }
                countDownLatch.countDown();
            }
        }).start();
        if (ThreadUtils.awaitUninterruptibly(countDownLatch, 100L)) {
            int i = runningAppProcessInfo.importance;
            return i == 100 || i == 200;
        }
        Logging.e(TAG, "get App InForeground state timeout.");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    @io.agora.base.internal.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSimulator() {
        /*
            java.lang.String r0 = "CommonUtility"
            java.lang.String r1 = ""
            r2 = 0
            r3 = 1
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch: java.lang.Exception -> L2c
            java.lang.String r5 = r4.toLowerCase()     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = "netease"
            boolean r5 = r5.contains(r6)     // Catch: java.lang.Exception -> L2d
            if (r5 == 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2e
            r6.<init>()     // Catch: java.lang.Exception -> L2e
            java.lang.String r7 = "manufacturer = "
            r6.append(r7)     // Catch: java.lang.Exception -> L2e
            r6.append(r4)     // Catch: java.lang.Exception -> L2e
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L2e
            io.agora.rtc2.internal.Logging.i(r0, r6)     // Catch: java.lang.Exception -> L2e
            goto L33
        L2c:
            r4 = r1
        L2d:
            r5 = 0
        L2e:
            java.lang.String r6 = "get manufacturer info fail."
            io.agora.rtc2.internal.Logging.e(r0, r6)
        L33:
            boolean r0 = isSimulatorProperty()
            if (r0 == 0) goto L3b
            int r5 = r5 + 1
        L3b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            java.lang.String r7 = "welldo"
            if (r0 <= r6) goto L6d
            java.lang.String r0 = "nokia"
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L60
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r1 = "Nokia_N1"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L5f
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "N1"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L60
        L5f:
            return r2
        L60:
            if (r5 <= 0) goto L86
            java.lang.String r0 = r4.toLowerCase()
            boolean r0 = r0.contains(r7)
            if (r0 != 0) goto L86
            return r3
        L6d:
            java.lang.String r0 = r1.toLowerCase()
            java.lang.String r1 = "unknown"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7b
            if (r5 <= 0) goto L86
        L7b:
            java.lang.String r0 = r4.toLowerCase()
            boolean r0 = r0.contains(r7)
            if (r0 != 0) goto L86
            return r3
        L86:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.CommonUtility.isSimulator():boolean");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:63|3)|(10:81|5|(0)(1:10)|75|11|(3:73|13|(2:15|(1:17)))(0)|20|(4:(1:27)|69|28|(3:65|30|(5:32|(1:34)|71|37|(3:67|39|(5:41|(1:43)|79|46|(3:77|48|(1:50))(0))(0))(0))(0))(0))(1:53)|54|(1:56)(1:83))|7|75|11|(0)(0)|20|(0)(0)|54|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        r8 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isSimulatorProperty() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.CommonUtility.isSimulatorProperty():boolean");
    }

    @CalledByNative
    public static int isSpeakerphoneEnabled(Context context) {
        if (context != null) {
            return ((AudioManager) context.getSystemService("audio")).isSpeakerphoneOn() ? 1 : 0;
        }
        Logging.w(TAG, "fail to isSpeakerphoneEnabled, context null");
        return -1;
    }

    private native void nativeAudioRoutingPhoneChanged(boolean z, int i, int i2);

    private native void nativeNotifyAddressBound(String str);

    private native void nativeNotifyForegroundChanged(boolean z);

    private native void nativeNotifyGravityOriChange(int i);

    private native void nativeNotifyNetworkChange(MediaNetworkInfo mediaNetworkInfo);

    @CalledByNative
    public static int safeLoadLibrary(String str) {
        if (TextUtils.isEmpty(str)) {
            return -2;
        }
        int i = 0;
        try {
            System.loadLibrary(str);
        } catch (NullPointerException | SecurityException | Exception | UnsatisfiedLinkError unused) {
            i = -1;
        }
        if (i != 0) {
            String str2 = "failed to load library: " + str;
        }
        return i;
    }

    public static void setIgnoreMonitor(boolean z) {
        ignoreMonitor = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMonitor() {
        Logging.d(TAG, "stopMonitor()");
        Context context = this.mContext.get();
        if (context == null) {
            return;
        }
        try {
            if (this.mPhoneStateListener != null) {
                ((TelephonyManager) context.getSystemService("phone")).listen(this.mPhoneStateListener, 0);
                this.mPhoneStateListener = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ConnectionChangeBroadcastReceiver connectionChangeBroadcastReceiver = this.mConnectionBroadcastReceiver;
            if (connectionChangeBroadcastReceiver != null) {
                context.unregisterReceiver(connectionChangeBroadcastReceiver);
                this.mConnectionBroadcastReceiver = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            PowerChangeReceiver powerChangeReceiver = this.mPowerChangeReceiver;
            if (powerChangeReceiver != null) {
                context.unregisterReceiver(powerChangeReceiver);
                this.mPowerChangeReceiver = null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            if (this.mProcessLifecycleOwner != null) {
                ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mProcessLifecycleOwner);
                this.mProcessLifecycleOwner = null;
            }
        } catch (Exception e4) {
            Logging.e(TAG, "unregister ProcessLifecycleOwner failed ", e4);
        }
        closeGravityMonitor();
    }

    @CalledByNative
    public int VPNBehindAddress() {
        Context context = this.mContext.get();
        if (context == null) {
            return 1;
        }
        return Connectivity.VPNBehindAddress(context);
    }

    @CalledByNative
    public void bindSocket2Network(final int i, String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        final ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.get().getSystemService("connectivity");
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).build();
        final String string = str.toString();
        ConnectivityManager.NetworkCallback networkCallback = this.mobileNetworkCallback;
        if (networkCallback != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: io.agora.rtc2.internal.CommonUtility.4
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
                String strInetAddressToIpAddress = CommonUtility.inetAddressToIpAddress(connectivityManager.getLinkProperties(network).getLinkAddresses().get(0).getAddress());
                if (strInetAddressToIpAddress == null || !strInetAddressToIpAddress.equals(string)) {
                    return;
                }
                Logging.d("start bindSocket2Network");
                Logging.d("addressInner" + string);
                FileDescriptor fileDescriptor = new FileDescriptor();
                try {
                    Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                    declaredField.setAccessible(true);
                    declaredField.setInt(fileDescriptor, i);
                    network.bindSocket(fileDescriptor);
                    this.notifyAddressBound(string);
                    Logging.d("bindSocket2Network success: network" + network + "+socketfd" + i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.mobileNetworkCallback = networkCallback2;
        try {
            connectivityManager.requestNetwork(networkRequestBuild, networkCallback2);
        } catch (Exception e) {
            this.mobileNetworkCallback = null;
            Logging.e(TAG, "requestNetwork failed " + e.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0012 A[PHI: r1
  0x0012: PHI (r1v1 int) = (r1v0 int), (r1v2 int), (r1v3 int) binds: [B:10:0x0010, B:24:0x0033, B:17:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int checkOrientation(int r3) {
        /*
            r2 = this;
            r0 = -1
            if (r3 != r0) goto L4
            return r0
        L4:
            r0 = 340(0x154, float:4.76E-43)
            if (r3 > r0) goto Lc
            r0 = 20
            if (r3 >= r0) goto L18
        Lc:
            int r0 = r2.mLastOrientation
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 == r1) goto L18
        L12:
            r2.mLastOrientation = r1
            r2.nativeNotifyGravityOriChange(r1)
            goto L48
        L18:
            r0 = 70
            if (r3 <= r0) goto L27
            r0 = 110(0x6e, float:1.54E-43)
            if (r3 >= r0) goto L27
            int r0 = r2.mLastOrientation
            r1 = 180(0xb4, float:2.52E-43)
            if (r0 == r1) goto L27
            goto L12
        L27:
            r0 = 160(0xa0, float:2.24E-43)
            if (r3 <= r0) goto L36
            r0 = 200(0xc8, float:2.8E-43)
            if (r3 >= r0) goto L36
            int r0 = r2.mLastOrientation
            r1 = 90
            if (r0 == r1) goto L36
            goto L12
        L36:
            r0 = 250(0xfa, float:3.5E-43)
            if (r3 <= r0) goto L48
            r0 = 290(0x122, float:4.06E-43)
            if (r3 >= r0) goto L48
            int r3 = r2.mLastOrientation
            if (r3 == 0) goto L48
            r3 = 0
            r2.mLastOrientation = r3
            r2.nativeNotifyGravityOriChange(r3)
        L48:
            int r3 = r2.mLastOrientation
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.CommonUtility.checkOrientation(int):int");
    }

    @CalledByNative
    public int closeGravityMonitor() {
        OrientationEventListener orientationEventListener;
        if (this.mContext.get() == null) {
            return -1;
        }
        try {
            orientationEventListener = this.mOrientationListener;
        } catch (Exception e) {
            Logging.e(TAG, "Unable to close OrientationEventListener, ", e);
        }
        if (orientationEventListener == null) {
            Logging.e(TAG, "[closeGravityMonitor] mOrientationListener is null!");
            return -1;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        Logging.i(TAG, "[closeGravityMonitor] done!");
        return 0;
    }

    @CalledByNative
    public void dispose() throws InterruptedException {
        this.mThreadChecker.checkIsOnValidThread();
        if (this.mDisposed) {
            return;
        }
        HardwareEarMonitorController.destroy();
        this.mDisposed = true;
        this.mNativeHandle = 0L;
        Logging.d(TAG, "dispose()");
        this.mHandler.post(new Runnable() { // from class: io.agora.rtc2.internal.CommonUtility.2
            @Override // java.lang.Runnable
            public void run() {
                CommonUtility.this.stopMonitor();
            }
        });
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mHandler.post(new Runnable() { // from class: io.agora.rtc2.internal.CommonUtility.3
            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
                CommonUtility.this.mHandler.getLooper().quit();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onDispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2 A[Catch: IOException -> 0x00ce, TRY_LEAVE, TryCatch #5 {IOException -> 0x00ce, blocks: (B:66:0x00ca, B:70:0x00d2), top: B:82:0x00ca }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.FileOutputStream] */
    @io.agora.base.internal.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getAssetsCacheFile(android.content.Context r6, java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.CommonUtility.getAssetsCacheFile(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    @CalledByNative
    public int getBatteryLifePercent() {
        if (this.mContext.get() != null) {
            return this.mBatteryPercentage;
        }
        return 255;
    }

    @VisibleForTesting
    public Handler getHandler() {
        return this.mHandler;
    }

    @CalledByNative
    public long getNativeHandle() {
        this.mThreadChecker.checkIsOnValidThread();
        return this.mNativeHandle;
    }

    @CalledByNative
    public MediaNetworkInfo getNetworkInfo() {
        Context context = this.mContext.get();
        if (context != null) {
            return getNetworkInfo(context);
        }
        return null;
    }

    @CalledByNative
    public int getNetworkType() {
        Context context = this.mContext.get();
        if (context == null) {
            return -1;
        }
        if (checkAccessNetworkState(context)) {
            return Connectivity.getNetworkType(context);
        }
        Logging.w(TAG, "fail to getNetworkType, permission ACCESS_NETWORK_STATE not granted");
        return -1;
    }

    @VisibleForTesting
    public ProcessLifecycleOwner getProcessLifecycleOwner() {
        return this.mProcessLifecycleOwner;
    }

    @CalledByNative
    public String getRealFilePath(Context context, String str) throws Throwable {
        if (context == null || TextUtils.isEmpty(str)) {
            Logging.e("getRealFilePath failed for init error");
            return "";
        }
        String contentFilePath = null;
        if (str.startsWith(PREFIX_ASSETS)) {
            contentFilePath = getAssetsFilePath(context, str);
        } else if (str.startsWith(PREFIX_URI)) {
            contentFilePath = getContentFilePath(context, Uri.parse(str));
        }
        return contentFilePath != null ? contentFilePath : "";
    }

    public ArrayList<String> getVpnIfconfigs() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                String name = ((NetworkInterface) it.next()).getName();
                if (name.contains("tun") || name.contains("ppp") || name.contains("ipsec") || name.contains("tap")) {
                    arrayList.add(name);
                }
            }
        } catch (Exception e) {
            Logging.e(TAG, "Fail to get network interfaces array list. ", e);
        }
        return arrayList;
    }

    public void notifyAddressBound(String str) {
        nativeNotifyAddressBound(str);
    }

    public void onAudioRoutingPhoneChanged(boolean z, int i, int i2) {
        if (this.mDisposed || this.mNativeHandle == 0) {
            return;
        }
        Logging.d(TAG, "onAudioRoutingPhoneChanged() enableAudio:" + z + ", event:" + i + ", arg: " + i2);
        nativeAudioRoutingPhoneChanged(z, i, i2);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onAudioRoutingPhoneChanged(z, i, i2);
        }
    }

    public void onForegroundChanged(boolean z) {
        String str = "onForegroundChanged() " + z;
        if (this.mDisposed) {
            return;
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onForegroundChanged(z);
        }
        if (this.mNativeHandle != 0) {
            nativeNotifyForegroundChanged(z);
        }
    }

    public void onNetworkChange() {
        if (this.mDisposed || this.mNativeHandle == 0) {
            return;
        }
        Logging.d(TAG, "onNetworkChange()");
        MediaNetworkInfo networkInfo = getNetworkInfo(this.mContext.get());
        nativeNotifyNetworkChange(networkInfo);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onNetworkChange(networkInfo);
        }
    }

    public void onPowerChange(int i) {
        Logging.d(TAG, "onPowerChange() " + i);
        this.mBatteryPercentage = i;
    }

    @VisibleForTesting
    public void setExtraConnectionActionForTesting(String str) {
        this.mExtraConnectivityFilterActionForTesting = str;
    }

    @VisibleForTesting
    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    @CalledByNative
    public int setupGravityMonitor() {
        Context context = this.mContext.get();
        if (context == null) {
            return -1;
        }
        try {
            if (this.mOrientationListener == null) {
                this.mOrientationListener = new OrientationEventListener(context, 2) { // from class: io.agora.rtc2.internal.CommonUtility.5
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        if (i == -1) {
                            return;
                        }
                        CommonUtility.this.checkOrientation(i);
                    }
                };
            }
            this.mOrientationListener.enable();
            Logging.i(TAG, "[setupGravityMonitor] done!");
        } catch (Exception e) {
            Logging.e(TAG, "Unable to create OrientationEventListener, ", e);
        }
        return -1;
    }

    public void startMonitor() {
        Logging.d(TAG, "startMonitor()");
        if (ignoreMonitor) {
            Logging.e(TAG, "ignoreMonitor in simulator, just for ut");
            return;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return;
        }
        try {
            this.mPhoneStateListener = new AgoraPhoneStateListener(this, this.mHandler);
            ((TelephonyManager) context.getSystemService("phone")).listen(this.mPhoneStateListener, 288);
        } catch (Exception e) {
            Logging.e(TAG, "Unable to create PhoneStateListener, ", e);
        }
        try {
            ConnectionChangeBroadcastReceiver connectionChangeBroadcastReceiver = new ConnectionChangeBroadcastReceiver(this);
            this.mConnectionBroadcastReceiver = connectionChangeBroadcastReceiver;
            context.registerReceiver(connectionChangeBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            if (!TextUtils.isEmpty(this.mExtraConnectivityFilterActionForTesting)) {
                context.registerReceiver(this.mConnectionBroadcastReceiver, new IntentFilter(this.mExtraConnectivityFilterActionForTesting));
            }
        } catch (Exception e2) {
            Logging.e(TAG, "Unable to create ConnectionChangeBroadcastReceiver, ", e2);
        }
        try {
            this.mPowerChangeReceiver = new PowerChangeReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            context.registerReceiver(this.mPowerChangeReceiver, intentFilter);
        } catch (Exception e3) {
            Logging.e(TAG, "Unable to create PowerChangeReceiver, ", e3);
        }
        try {
            this.mProcessLifecycleOwner = new ProcessLifecycleOwner(isAppInForeground(), this);
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.mProcessLifecycleOwner);
        } catch (Exception e4) {
            Logging.e(TAG, "Unable to registerActivityLifecycleCallbacks, ", e4);
        }
    }
}
