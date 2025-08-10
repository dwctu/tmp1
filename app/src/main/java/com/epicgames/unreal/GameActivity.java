package com.epicgames.unreal;

import android.R;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NativeActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.SuggestionSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import com.broadcom.bt.util.io.FilenameUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.epicgames.unreal.Logger;
import com.epicgames.unreal.psoservices.PSOProgramServiceAccessor;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.material.datepicker.UtcDates;
import com.google.android.vending.expansion.downloader.Constants;
import io.agora.rtc2.internal.RtcEngineEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class GameActivity extends NativeActivity implements SurfaceHolder.Callback2, SensorEventListener, Logger.ILoggerCallback, ComponentCallbacks2 {
    private static final int ANDROID_CPU_FAMILY_ARM = 1;
    private static final int ANDROID_CPU_FAMILY_ARM64 = 4;
    private static final int ANDROID_CPU_FAMILY_MIPS = 3;
    private static final int ANDROID_CPU_FAMILY_MIPS64 = 6;
    private static final int ANDROID_CPU_FAMILY_UNKNOWN = 0;
    private static final int ANDROID_CPU_FAMILY_X86 = 2;
    private static final int ANDROID_CPU_FAMILY_X86_64 = 5;
    private static final int CONFIGRULES_STATE_EXECFALSE = 3;
    private static final int CONFIGRULES_STATE_EXECTRUE = 1;
    private static final int CONFIGRULES_STATE_FINDELSE = 2;
    private static final int CONFIGRULES_STATE_FINDEND = 4;
    private static final int CONFIGRULES_STATE_RUN = 0;
    private static final int CONNECTION_TYPE_AIRPLANEMODE = 1;
    private static final int CONNECTION_TYPE_BLUETOOTH = 6;
    private static final int CONNECTION_TYPE_CELL = 3;
    private static final int CONNECTION_TYPE_ETHERNET = 2;
    private static final int CONNECTION_TYPE_NONE = 0;
    private static final int CONNECTION_TYPE_WIFI = 4;
    private static final int CONNECTION_TYPE_WIMAX = 5;
    private static final String DIALOG_ERROR = "dialog_error";
    public static final int DOWNLOAD_ACTIVITY_ID = 80001;
    public static final int DOWNLOAD_COMPLETED_OK = 2;
    public static final int DOWNLOAD_FAILED = 4;
    public static final int DOWNLOAD_FILES_PRESENT = 1;
    public static final int DOWNLOAD_INVALID = 5;
    public static final int DOWNLOAD_NO_PLAY_KEY = 6;
    public static final int DOWNLOAD_NO_RETURN_CODE = 0;
    public static final String DOWNLOAD_RETURN_NAME = "Result";
    public static final int DOWNLOAD_USER_QUIT = 3;
    private static final int GOOGLE_SERVICES_REQUEST_RESOLVE_ERROR = 1001;
    private static final int PLAY_SERVICES_DIALOG_ID = 1;
    public static final float SampleDecayRate = 0.85f;
    public static Bundle _bundle = null;
    public static Bundle _extrasBundle = null;
    public static final int checkLastVirtualKeyboardCommandDelay = 500;
    private static ClipboardManager clipboardManager = null;
    public static final int lastVirtualKeyboardCommandDelay = 200;
    private AssetManager AssetManagerReference;
    private String[] CachedQueryProductIDs;
    public String ExternalFilesDir;
    private StoreHelper IapStoreHelper;
    public String InternalFilesDir;
    private SurfaceView MySurfaceView;
    public int UsedMemory;
    private Sensor accelerometer;
    public LinearLayout activityLayout;
    private boolean bKeyboardShowing;
    public AlertDialog consoleAlert;
    public LinearLayout consoleAlertLayout;
    public ConsoleCmdReceiver consoleCmdReceiver;
    public ConsoleKeyboardInput consoleInputBox;
    public Spinner consoleSpinner;
    private FrameLayout containerFrameLayout;
    private Sensor gyroscope;
    public ProgressDialog mProgressDialog;
    public Dialog mSplashDialog;
    private Sensor magnetometer;
    private View mainDecorView;
    private Rect mainDecorViewRect;
    private View mainView;
    private Handler memoryHandler;
    private HandlerThread memoryHandlerThread;
    private Runnable memoryRunnable;
    public VirtualKeyboardInput newVirtualKeyboardInput;
    private SensorManager sensorManager;
    public AlertDialog virtualKeyboardAlert;
    private Handler virtualKeyboardHandler;
    public EditText virtualKeyboardInputBox;
    public String virtualKeyboardInputContent;
    public int virtualKeyboardInputType;
    private LinearLayout virtualKeyboardLayout;
    public String virtualKeyboardPreviousContents;
    public static final boolean bSamsungDevice = Build.MANUFACTURER.equals("samsung");
    public static final int ANDROID_BUILD_VERSION = Build.VERSION.SDK_INT;
    private static final String[] CONSOLE_SPINNER_ITEMS = {"Common Console Commands", "stat FPS", "stat Anim", "stat OpenGLRHI", "stat VulkanRHI", "stat DumpEvents", "stat DumpFrame", "stat DumpHitches", "stat Engine", "stat Game", "stat Grouped", "stat Hitches", "stat InitViews", "stat LightRendering", "stat Memory", "stat Particles", "stat SceneRendering", "stat SceneUpdate", "stat ShadowRendering", "stat Slow", "stat Streaming", "stat StreamingDetails", "stat Unit", "stat UnitGraph", "stat StartFile", "stat StopFile", "GameVer", "show PostProcessing", "stat AndroidCPU"};
    private static final AtomicBoolean bIsActivityPaused = new AtomicBoolean(true);
    private static final DeviceInfoData[] DeviceInfoList = {new DeviceInfoData(1256, 40960, "Samsung Game Pad EI-GP20"), new DeviceInfoData(2389, 29187, "NVIDIA Corporation NVIDIA Controller v01.01"), new DeviceInfoData(2389, 29200, "NVIDIA Corporation NVIDIA Controller v01.03"), new DeviceInfoData(6473, AnalyticsListener.EVENT_VIDEO_SIZE_CHANGED, "Amazon Fire TV Remote"), new DeviceInfoData(6473, 1030, "Amazon Fire Game Controller"), new DeviceInfoData(1848, 21091, "Mad Catz C.T.R.L.R (Smart)"), new DeviceInfoData(1848, 21094, "Mad Catz C.T.R.L.R"), new DeviceInfoData(RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STATE_CHANGED, 654, "Xbox Wired Controller"), new DeviceInfoData(RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STATE_CHANGED, 736, "Xbox Wireless Controller"), new DeviceInfoData(RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STATE_CHANGED, 2821, "Xbox Elite Wireless Controller"), new DeviceInfoData(AudioAttributesCompat.FLAG_ALL_PUBLIC, 5145, "SteelSeries Stratus XL"), new DeviceInfoData(1356, 1476, "PS4 Wireless Controller"), new DeviceInfoData(1356, 2508, "PS4 Wireless Controller (v2)"), new DeviceInfoData(1356, 3302, "PS5 Wireless Controller"), new DeviceInfoData(1452, 1386, "glap QXPGP001"), new DeviceInfoData(1155, 22352, "STMicroelectronics Lenovo GamePad"), new DeviceInfoData(5426, 1797, "Razer Razer Claire T1 Wired")};
    public static Logger Log = new Logger("UE", "GameActivity");
    public static VirtualKeyboardCommand lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
    public static boolean bSupportedDevice = true;
    public static boolean first_acceleration_sample = true;
    public static float[] current_accelerometer = {0.0f, 0.0f, 0.0f};
    public static float[] current_gyroscope = {0.0f, 0.0f, 0.0f};
    public static float[] current_magnetometer = {0.0f, 0.0f, 0.0f};
    public static float[] filtered_gravity = {0.0f, 0.0f, 0.0f};
    public static float[] last_gravity = {0.0f, 0.0f, 0.0f};
    public static float[] last_tilt = {0.0f, 0.0f, 0.0f};
    public static float[] current_rotation_rate = {0.0f, 0.0f, 0.0f};
    public static float[] current_gravity = {0.0f, 0.0f, 0.0f};
    public static float[] current_acceleration = {0.0f, 0.0f, 0.0f};
    public static GameActivity _activity = null;
    private static int PackageDataInsideApkValue = -1;
    private static int HasOBBFiles = -1;
    private static String appPackageName = "";
    private final float[] rotationMatrix = new float[9];
    private final float[] orientationAngles = new float[3];
    public int VersionCode = 0;
    public String VersionName = "Unknown";
    public int targetSdkVersion = 0;
    public String CommandLineFull = "";
    public ArrayList<String> CommandLineArguments = new ArrayList<>();
    public HashMap<String, String> CommandLineFlags = new HashMap<>();
    public boolean VerifyOBBOnStartUp = false;
    public String OpenGLVendor = "";
    public String OpenGLDevice = "";
    public String OpenGLVersion = "";
    public String OpenGLDriver = "";
    public String TextureFormats = "ETC1";
    public boolean bSupportsFloatingPointRenderTargets = false;
    public boolean bSensorDataUpdated = false;
    public float[] current_tilt = {0.0f, 0.0f, 0.0f};
    public String EngineBranch = "UE5";
    public String ProjectVersion = "1.0.0";
    public int DepthBufferPreference = 0;
    public int PropagateAlpha = 0;
    private boolean bAllowIMU = true;
    private Rect safezone = new Rect(0, 0, 0, 0);
    private RectF safezoneF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private int noActionAnimID = -1;
    private boolean bHaveParsedCommandline = false;
    private boolean bKeepScreenOn = false;
    private int NumTimesScreenCaptureDisabled = 0;
    private boolean HasAllFiles = false;
    private boolean UseExternalFilesDir = false;
    private boolean PublicLogFiles = false;
    private boolean InitCompletedOK = false;
    private boolean bConfigRulesError = false;
    private String ConfigRulesStatus = "UNSET";
    private AlertDialog ForceGameDialog = null;
    private boolean bForceGameEndWithError = false;
    private boolean bForceGameEndWithWarning = false;
    private String ForceExitCaption = "";
    private String ForceExitMessage = "";
    private String ForceExitQuitButtonText = "";
    private String ForceExitHelpButtonText = "";
    private String ForceExitContinueButtonText = "";
    private String ForceExitUpdateButtonText = "";
    private String ForceExitLink = "";
    private boolean SplashScreenLaunch = false;
    private boolean UseDisplayCutout = false;
    private boolean ShouldHideUI = false;
    private boolean IsForDistribution = false;
    private String BuildConfiguration = "";
    private boolean IsInVRMode = false;
    private boolean bUsesVrKeyboard = false;
    private boolean bUseSurfaceView = false;
    private int DesiredHolderWidth = 0;
    private int DesiredHolderHeight = 0;
    private int VulkanVersion = 0;
    private int VulkanLevel = 0;
    private String VulkanVersionString = "0.0.0";
    private boolean bSupportsVulkan = false;
    private String EGLErrorStatus = "UNSET";
    private PSOProgramServiceAccessor mPSOProgramServiceAccessor = new PSOProgramServiceAccessor();
    private boolean localNotificationAppLaunched = false;
    private String localNotificationLaunchActivationEvent = "";
    private int localNotificationLaunchFireDate = 0;
    private EAlertDialogType CurrentDialogType = EAlertDialogType.None;
    private Handler mRestoreImmersiveModeHandler = new Handler();
    private Runnable restoreImmersiveModeRunnable = new Runnable() { // from class: com.epicgames.unreal.GameActivity.1
        @Override // java.lang.Runnable
        public void run() {
            GameActivity.this.restoreTransparentBars();
        }
    };

    /* renamed from: com.epicgames.unreal.GameActivity$43, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass43 {
        public static final /* synthetic */ int[] $SwitchMap$com$epicgames$unreal$GameActivity$EAlertDialogType;
        public static final /* synthetic */ int[] $SwitchMap$com$epicgames$unreal$GameActivity$VirtualKeyboardCommand;

        static {
            int[] iArr = new int[VirtualKeyboardCommand.values().length];
            $SwitchMap$com$epicgames$unreal$GameActivity$VirtualKeyboardCommand = iArr;
            try {
                iArr[VirtualKeyboardCommand.VK_CMD_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$epicgames$unreal$GameActivity$VirtualKeyboardCommand[VirtualKeyboardCommand.VK_CMD_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EAlertDialogType.values().length];
            $SwitchMap$com$epicgames$unreal$GameActivity$EAlertDialogType = iArr2;
            try {
                iArr2[EAlertDialogType.Keyboard.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$epicgames$unreal$GameActivity$EAlertDialogType[EAlertDialogType.Console.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class DeviceInfoData {
        public final String name;
        public final int productId;
        public final int vendorId;

        public DeviceInfoData(int i, int i2, String str) {
            this.vendorId = i;
            this.productId = i2;
            this.name = str;
        }

        public boolean IsMatch(int i, int i2) {
            return this.vendorId == i && this.productId == i2;
        }
    }

    public enum EAlertDialogType {
        None,
        Console,
        Keyboard
    }

    public class InputDeviceInfo {
        public int controllerId;
        public String descriptor;
        public int deviceId;
        public String name;
        public int productId;
        public int vendorId;

        public InputDeviceInfo(int i, int i2, int i3, int i4, String str, String str2) {
            this.deviceId = i;
            this.vendorId = i2;
            this.productId = i3;
            this.controllerId = i4;
            this.name = str;
            this.descriptor = str2;
        }
    }

    public class LaunchNotification {
        public String event;
        public int fireDate;
        public boolean used;

        public LaunchNotification(boolean z, String str, int i) {
            this.used = z;
            this.event = str;
            this.fireDate = i;
        }
    }

    public class VibrateRunnable implements Runnable {
        private int duration;
        private Vibrator vibrator;

        public VibrateRunnable(int i, Vibrator vibrator) {
            this.duration = i;
            this.vibrator = vibrator;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.duration;
            if (i < 1) {
                this.vibrator.cancel();
            } else {
                this.vibrator.vibrate(i);
            }
        }
    }

    public enum VirtualKeyboardCommand {
        VK_CMD_NONE,
        VK_CMD_SHOW,
        VK_CMD_HIDE
    }

    static {
        System.loadLibrary("Unreal");
    }

    public static String AndroidThunkJava_GetFontDirectory() {
        String str;
        String[] strArr = {"/system/fonts", "/system/font", "/data/fonts"};
        int i = 0;
        while (true) {
            if (i >= 3) {
                str = null;
                break;
            }
            str = strArr[i];
            if (new File(str).exists()) {
                break;
            }
            i++;
        }
        return str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AndroidThunkJava_isIntentActionAvailable(String str) {
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(new Intent(str, (Uri) null), 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    private void CheckKeyboardDisplayed() {
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.unreal.GameActivity.29
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (GameActivity.this.bKeyboardShowing && GameActivity.this.newVirtualKeyboardInput.getY() < 0.0f) {
                        GameActivity.this.mainView.requestLayout();
                    }
                }
            }
        }, 500L);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean EvaluateConditions(java.util.Map<java.lang.String, java.lang.String> r11, java.util.ArrayList<java.lang.String> r12, java.lang.String r13) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.EvaluateConditions(java.util.Map, java.util.ArrayList, java.lang.String):boolean");
    }

    private String ExpandVariables(Map<String, String> map, String str) {
        int i;
        int iIndexOf;
        int iIndexOf2 = str.indexOf("$(");
        while (iIndexOf2 != -1 && (iIndexOf = str.indexOf(41, (i = iIndexOf2 + 2))) != -1) {
            String strSubstring = str.substring(i, iIndexOf);
            if (map.containsKey(strSubstring)) {
                str = str.substring(0, iIndexOf2) + map.get(strSubstring) + str.substring(iIndexOf + 1);
            } else {
                iIndexOf2 = iIndexOf + 1;
            }
            iIndexOf2 = str.indexOf("$(", iIndexOf2);
        }
        return str;
    }

    public static GameActivity Get() {
        return _activity;
    }

    public static boolean IsActivityPaused() {
        return bIsActivityPaused.get();
    }

    private void LocalNotificationCheckAppOpen() {
        this.localNotificationAppLaunched = false;
        this.localNotificationLaunchActivationEvent = "";
        this.localNotificationLaunchFireDate = 0;
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            boolean booleanExtra = intent.getBooleanExtra("localNotificationAppLaunched", false);
            this.localNotificationAppLaunched = booleanExtra;
            if (booleanExtra) {
                String string = extras.getString("localNotificationLaunchActivationEvent");
                this.localNotificationLaunchActivationEvent = string;
                if (string != null) {
                    LocalNotificationRemoveID(this, extras.getInt("localNotificationID"));
                    this.localNotificationLaunchFireDate = 0;
                } else {
                    this.localNotificationAppLaunched = false;
                    this.localNotificationLaunchActivationEvent = "";
                }
            }
        }
    }

    public static int LocalNotificationGetID(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        int i = 1;
        if (string.length() == 0) {
            editorEdit.putString("notificationIDs", Integer.toString(1));
        } else {
            String[] strArrSplit = string.split(Constants.FILENAME_SEQUENCE_SEPARATOR);
            ArrayList arrayList = new ArrayList();
            for (String str : strArrSplit) {
                if (str.length() > 0) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            while (arrayList.contains(Integer.valueOf(i))) {
                i++;
            }
            editorEdit.putString("notificationIDs", string + Constants.FILENAME_SEQUENCE_SEPARATOR + i);
        }
        editorEdit.commit();
        return i;
    }

    private ArrayList<Integer> LocalNotificationGetIDList() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
        sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : string.split(Constants.FILENAME_SEQUENCE_SEPARATOR)) {
            if (str.length() > 0) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return arrayList;
    }

    private boolean LocalNotificationIDExists(int i) {
        if (i == -1) {
            return false;
        }
        Iterator<Integer> it = LocalNotificationGetIDList().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i) {
                return true;
            }
        }
        return false;
    }

    public static void LocalNotificationRemoveDetails(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("notificationDetails", MessageFormatter.DELIM_STR));
            jSONObject.remove(String.valueOf(i));
            editorEdit.putString("notificationDetails", jSONObject.toString());
            editorEdit.commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void LocalNotificationRemoveID(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String str = "";
        String string = sharedPreferences.getString("notificationIDs", "");
        ArrayList arrayList = new ArrayList();
        if (string.length() == 0) {
            return;
        }
        for (String str2 : string.split(Constants.FILENAME_SEQUENCE_SEPARATOR)) {
            if (str2.length() > 0) {
                arrayList.add(str2);
            }
        }
        arrayList.remove(Integer.toString(i));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str.length() != 0) {
                str3 = str + Constants.FILENAME_SEQUENCE_SEPARATOR + str3;
            }
            str = str3;
        }
        editorEdit.putString("notificationIDs", str);
        editorEdit.commit();
    }

    public static boolean LocalNotificationScheduleAtTime(Context context, int i, String str, boolean z, String str2, String str3, String str4, String str5) throws ParseException {
        Intent intent = new Intent(context, (Class<?>) LocalNotificationReceiver.class);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ID, i);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_TITLE, str2);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_BODY, str3);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION, str4);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION_EVENT, str5);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 201326592);
        TimeZone timeZone = TimeZone.getTimeZone(UtcDates.UTC);
        if (z) {
            timeZone = TimeZone.getDefault();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);
        new Date();
        try {
            Date date = simpleDateFormat.parse(str);
            long time = date.getTime() - new Date().getTime();
            if (time < 0) {
                LocalNotificationRemoveID(context, i);
                return false;
            }
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(2, SystemClock.elapsedRealtime() + time, broadcast);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            LocalNotificationRemoveID(context, i);
            return false;
        }
    }

    private ArrayList<String> ParseSegments(String str, String str2, String str3, String str4) {
        int iIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < length) {
            int i4 = i + 1;
            String strSubstring = str.substring(i, i4);
            if (strSubstring.equals(str2) && arrayList2.size() == 0) {
                arrayList.add(str.substring(i2, i).trim());
                i = i4;
                i2 = i;
            } else if (strSubstring.equals("\\")) {
                i = i4 + 1;
            } else if (arrayList2.size() <= 0 || str4.indexOf(strSubstring) != i3) {
                iIndexOf = str3.indexOf(strSubstring);
                if (iIndexOf >= 0) {
                    arrayList2.add(Integer.valueOf(iIndexOf));
                    i3 = iIndexOf;
                }
                i = i4;
            } else {
                int size = arrayList2.size() - 1;
                arrayList2.remove(size);
                if (size > 0) {
                    iIndexOf = ((Integer) arrayList2.get(size - 1)).intValue();
                    i3 = iIndexOf;
                    i = i4;
                } else {
                    i3 = -1;
                    i = i4;
                }
            }
        }
        if (i2 < length) {
            arrayList.add(str.substring(i2).trim());
        }
        return arrayList;
    }

    private String RemoveSurrounds(String str, String str2, String str3) {
        int length = str2.length();
        int length2 = str3.length();
        int length3 = str.length();
        if (length3 >= 2 && length > 0 && length == length2) {
            int i = 0;
            String strSubstring = str.substring(0, 1);
            int i2 = length3 - 1;
            String strSubstring2 = str.substring(i2);
            while (i < length) {
                int i3 = i + 1;
                if (str2.substring(i, i3).equals(strSubstring) && str3.substring(i, i3).equals(strSubstring2)) {
                    return str.substring(1, i2);
                }
                i = i3;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RestartApplication(String str) {
        Context applicationContext = getApplicationContext();
        Intent launchIntentForPackage = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
        launchIntentForPackage.addFlags(335577088);
        launchIntentForPackage.putExtra("RestartExtra", str);
        applicationContext.startActivity(launchIntentForPackage);
        Runtime.getRuntime().exit(0);
    }

    private void SetDisableScreenCaptureInternal(boolean z) {
        if (z) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.22
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_DisableScreenCapture(true) - Disabled screen captures");
                    GameActivity._activity.getWindow().addFlags(8192);
                }
            });
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.23
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_DisableScreenCapture(false) - Enabled screen captures");
                    GameActivity._activity.getWindow().clearFlags(8192);
                }
            });
        }
    }

    private BufferedReader TryOpenFileReader(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return new BufferedReader(new FileReader(file));
        } catch (IOException unused) {
            return null;
        }
    }

    private void createVirtualKeyboardInput() {
        getWindow().setSoftInputMode(16);
        VirtualKeyboardInput virtualKeyboardInput = new VirtualKeyboardInput(this);
        this.newVirtualKeyboardInput = virtualKeyboardInput;
        virtualKeyboardInput.setSingleLine(false);
        this.newVirtualKeyboardInput.setBackgroundColor(-1);
        this.newVirtualKeyboardInput.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.newVirtualKeyboardInput.setVisibility(8);
        if (ANDROID_BUILD_VERSION < 11) {
            this.newVirtualKeyboardInput.setImeOptions(268435456);
        } else {
            this.newVirtualKeyboardInput.setImeOptions(301989888);
        }
        this.newVirtualKeyboardInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.epicgames.unreal.GameActivity.40
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return false;
                }
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(66);
                return true;
            }
        });
        this.newVirtualKeyboardInput.addTextChangedListener(new TextWatcher() { // from class: com.epicgames.unreal.GameActivity.41
            private void downgradeEasyCorrectionSpans() {
                Editable text = GameActivity.this.newVirtualKeyboardInput.getText();
                if (Build.VERSION.SDK_INT < 14 || !(text instanceof Spannable)) {
                    return;
                }
                SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) text.getSpans(0, text.length(), SuggestionSpan.class);
                for (int i = 0; i < suggestionSpanArr.length; i++) {
                    int flags = suggestionSpanArr[i].getFlags();
                    if ((flags & 1) != 0 && (flags & 2) == 0) {
                        suggestionSpanArr[i].setFlags(flags & (-2));
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (GameActivity.this.newVirtualKeyboardInput.getY() > 0.0f || GameActivity.this.bUsesVrKeyboard) {
                    if (charSequence.length() == 0) {
                        GameActivity.this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.unreal.GameActivity.41.1
                            @Override // java.lang.Runnable
                            public void run() {
                                GameActivity.this.nativeVirtualKeyboardChanged(GameActivity.this.newVirtualKeyboardInput.getText().toString());
                            }
                        }, 100L);
                    } else {
                        GameActivity.this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.unreal.GameActivity.41.2
                            @Override // java.lang.Runnable
                            public void run() {
                                String string = GameActivity.this.newVirtualKeyboardInput.getText().toString();
                                if (GameActivity.this.newVirtualKeyboardInput.getMaxLines() == 1 && string.contains(IOUtils.LINE_SEPARATOR_UNIX)) {
                                    string = string.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ");
                                    GameActivity.this.newVirtualKeyboardInput.setText(string);
                                }
                                GameActivity.this.nativeVirtualKeyboardChanged(string);
                            }
                        }, 100L);
                    }
                }
                downgradeEasyCorrectionSpans();
            }
        });
        this.virtualKeyboardLayout.addView(this.newVirtualKeyboardInput);
        this.virtualKeyboardHandler = new Handler(Looper.getMainLooper());
    }

    private SecretKey generateAESKey(String str) {
        byte[] bArr = {35, 113, -45, -93, 48, 113, 99, -29};
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 128)).getEncoded(), "AES");
        } catch (Exception unused) {
            return new SecretKeySpec(bArr, "AES");
        }
    }

    public static String getAppPackageName() {
        return appPackageName;
    }

    private byte[] getByteArrayFromAssets(String str) throws IOException {
        try {
            InputStream inputStreamOpen = this.AssetManagerReference.open(str);
            try {
                byte[] byteArrayFromInputStream = getByteArrayFromInputStream(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return byteArrayFromInputStream;
            } finally {
            }
        } catch (Exception e) {
            Log.debug("failed to get bytes from asset " + e.toString());
            return null;
        }
    }

    public static byte[] getByteArrayFromFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] byteArrayFromInputStream = getByteArrayFromInputStream(fileInputStream);
                fileInputStream.close();
                return byteArrayFromInputStream;
            } finally {
            }
        } catch (Exception e) {
            Log.debug("failed to get bytes from file " + e.toString());
            return null;
        }
    }

    private static byte[] getByteArrayFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    private InputStream getConfigRulesDecompressed(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, DataFormatException, InvalidKeyException {
        int length;
        if (bArr == null || (length = bArr.length - 10) < 0) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.getShort() != 14808) {
            Log.debug("failed sig ");
            return null;
        }
        byteBufferWrap.getInt();
        int i = byteBufferWrap.getInt();
        byte[] bArr2 = new byte[i];
        try {
            String str = (String) getClass().getDeclaredField("CONFIGRULES_KEY").get(this);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, generateAESKey(str));
            byte[] bArrDoFinal = cipher.doFinal(bArr, 10, length);
            length = bArrDoFinal.length;
            Inflater inflater = new Inflater();
            inflater.setInput(bArrDoFinal, 0, length);
            int iInflate = inflater.inflate(bArr2);
            inflater.end();
            if (iInflate != i) {
                Log.debug("1 unexpected size (" + iInflate + ", " + i + ")");
                return null;
            }
        } catch (Exception e) {
            Log.debug("failed " + e.toString());
            try {
                Inflater inflater2 = new Inflater();
                inflater2.setInput(bArr, 10, length);
                int iInflate2 = inflater2.inflate(bArr2);
                inflater2.end();
                if (iInflate2 != i) {
                    Log.debug("2 unexpected size (" + iInflate2 + ", " + i + ")");
                    return null;
                }
            } catch (Exception e2) {
                Log.debug("failed " + e2.toString());
                return null;
            }
        }
        try {
            return new ByteArrayInputStream(bArr2);
        } catch (Exception e3) {
            Log.debug("failed " + e3.toString());
            return null;
        }
    }

    private InputStream getConfigRulesStream(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, DataFormatException, IOException, InvalidKeyException {
        InputStream configRulesDecompressed;
        this.ConfigRulesStatus = "";
        byte[] byteArrayFromAssets = getByteArrayFromAssets("configrules.bin.png");
        byte[] byteArrayFromFile = getByteArrayFromFile(this.InternalFilesDir + "configrules.bin.png");
        byte[] byteArrayFromFile2 = getByteArrayFromFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/UnrealGame/" + str + "/configrules.bin.png");
        if (byteArrayFromFile != null) {
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayFromFile);
            Log.debug(String.format("CRC32: %08X", Long.valueOf(crc32.getValue())));
        }
        int configRulesVersion = getConfigRulesVersion(byteArrayFromAssets);
        int configRulesVersion2 = getConfigRulesVersion(byteArrayFromFile);
        int configRulesVersion3 = getConfigRulesVersion(byteArrayFromFile2);
        if (configRulesVersion == -1 && configRulesVersion2 == -1 && configRulesVersion3 == -1) {
            this.ConfigRulesStatus = "Not found. ";
            return null;
        }
        if (this.CommandLineFlags.containsKey("noconfigrulesdownload")) {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
        } else if (configRulesVersion >= configRulesVersion2 && configRulesVersion >= configRulesVersion3) {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
        } else if (configRulesVersion2 < configRulesVersion || configRulesVersion2 < configRulesVersion3) {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromFile2);
            if (configRulesDecompressed == null && configRulesVersion2 != -1) {
                configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromFile);
            }
            if (configRulesDecompressed == null && configRulesVersion != -1) {
                configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
            }
        } else {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromFile);
            if (configRulesDecompressed == null && configRulesVersion != -1) {
                Log.debug("using assets rule: ");
                new File(this.InternalFilesDir + "configrules.bin.png").delete();
                configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
            }
        }
        if (configRulesDecompressed == null) {
            this.ConfigRulesStatus = "failed to find config rules. ";
            this.bConfigRulesError = true;
        }
        return configRulesDecompressed;
    }

    private int getConfigRulesVersion(byte[] bArr) {
        if (bArr == null) {
            Log.debug("configrulesversion: no data");
            return -1;
        }
        if (bArr.length - 10 < 0) {
            Log.debug("configrulesversion: size (" + bArr.length + ", 10)");
            return -1;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        short s = byteBufferWrap.getShort();
        if (s == 14808) {
            return byteBufferWrap.getInt();
        }
        Log.debug("configrulesversion: token (" + ((int) s) + ")");
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.String> getCpuInfo() throws java.io.IOException, java.lang.NumberFormatException {
        /*
            r11 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 == 0) goto Lb4
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.io.IOException -> L96
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.io.IOException -> L96
            r4.<init>(r1)     // Catch: java.io.IOException -> L96
            r3.<init>(r4)     // Catch: java.io.IOException -> L96
            r1 = -1
            r2 = 0
            r4 = 0
        L20:
            r5 = -1
        L21:
            java.lang.String r6 = r3.readLine()     // Catch: java.io.IOException -> L93
            r7 = 1
            if (r6 == 0) goto L88
            int r8 = r6.length()     // Catch: java.io.IOException -> L93
            if (r8 <= r7) goto L20
            java.lang.String r8 = ": "
            java.lang.String[] r6 = r6.split(r8)     // Catch: java.io.IOException -> L93
            int r8 = r6.length     // Catch: java.io.IOException -> L93
            if (r8 <= r7) goto L21
            r8 = r6[r2]     // Catch: java.io.IOException -> L93
            java.lang.String r8 = r8.trim()     // Catch: java.io.IOException -> L93
            r6[r2] = r8     // Catch: java.io.IOException -> L93
            r8 = r6[r7]     // Catch: java.io.IOException -> L93
            java.lang.String r8 = r8.trim()     // Catch: java.io.IOException -> L93
            r6[r7] = r8     // Catch: java.io.IOException -> L93
            r8 = r6[r2]     // Catch: java.io.IOException -> L93
            java.lang.String r9 = "processor"
            boolean r8 = r8.equals(r9)     // Catch: java.io.IOException -> L93
            if (r8 == 0) goto L5b
            r5 = r6[r7]     // Catch: java.lang.NumberFormatException -> L20 java.io.IOException -> L93
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L20 java.io.IOException -> L93
            if (r5 <= r4) goto L21
            r4 = r5
            goto L21
        L5b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L93
            r8.<init>()     // Catch: java.io.IOException -> L93
            if (r5 != r1) goto L65
            java.lang.String r9 = ""
            goto L76
        L65:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L93
            r9.<init>()     // Catch: java.io.IOException -> L93
            r9.append(r5)     // Catch: java.io.IOException -> L93
            java.lang.String r10 = ":"
            r9.append(r10)     // Catch: java.io.IOException -> L93
            java.lang.String r9 = r9.toString()     // Catch: java.io.IOException -> L93
        L76:
            r8.append(r9)     // Catch: java.io.IOException -> L93
            r9 = r6[r2]     // Catch: java.io.IOException -> L93
            r8.append(r9)     // Catch: java.io.IOException -> L93
            java.lang.String r8 = r8.toString()     // Catch: java.io.IOException -> L93
            r6 = r6[r7]     // Catch: java.io.IOException -> L93
            r0.put(r8, r6)     // Catch: java.io.IOException -> L93
            goto L21
        L88:
            int r4 = r4 + r7
            java.lang.String r1 = "processorCount"
            java.lang.String r2 = java.lang.Integer.toString(r4)     // Catch: java.io.IOException -> L93
            r0.put(r1, r2)     // Catch: java.io.IOException -> L93
            goto Lae
        L93:
            r1 = move-exception
            r2 = r3
            goto L97
        L96:
            r1 = move-exception
        L97:
            com.epicgames.unreal.Logger r3 = com.epicgames.unreal.GameActivity.Log
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "failed to read /proc/cpuinfo: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.debug(r1)
            r3 = r2
        Lae:
            if (r3 == 0) goto Lbb
            r3.close()     // Catch: java.io.IOException -> Lbb
            goto Lbb
        Lb4:
            com.epicgames.unreal.Logger r1 = com.epicgames.unreal.GameActivity.Log
            java.lang.String r2 = "failed to open /proc/cpuinfo!"
            r1.debug(r2)
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.getCpuInfo():java.util.Map");
    }

    private void getGraphicsInformation() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            str = "";
        } else {
            str = "InitialEGLError = " + iEglGetError + " ";
        }
        this.EGLErrorStatus = str;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        StringBuilder sb = new StringBuilder();
        sb.append(this.EGLErrorStatus);
        if (eGLDisplayEglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            str2 = "";
        } else {
            str2 = "eglGetDisplay = " + EGL14.eglGetError() + " ";
        }
        sb.append(str2);
        this.EGLErrorStatus = sb.toString();
        int[] iArr = new int[2];
        boolean z = true;
        boolean zEglInitialize = EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.EGLErrorStatus);
        if (zEglInitialize) {
            str3 = "";
        } else {
            str3 = "eglInitialize = " + EGL14.eglGetError() + " ";
        }
        sb2.append(str3);
        this.EGLErrorStatus = sb2.toString();
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            this.EGLErrorStatus += "eglChooseConfig = " + EGL14.eglGetError() + " ";
            Log.debug("Did not find an EGL config");
            return;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 8, 12374, 8, 12344}, 0);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.EGLErrorStatus);
        if (eGLSurfaceEglCreatePbufferSurface != EGL14.EGL_NO_SURFACE) {
            str4 = "";
        } else {
            str4 = "eglCreatePbufferSurface = " + EGL14.eglGetError() + " ";
        }
        sb3.append(str4);
        this.EGLErrorStatus = sb3.toString();
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.EGLErrorStatus);
        if (eGLContextEglCreateContext != EGL14.EGL_NO_CONTEXT) {
            str5 = "";
        } else {
            str5 = "eglCreateContext = " + EGL14.eglGetError() + " ";
        }
        sb4.append(str5);
        this.EGLErrorStatus = sb4.toString();
        boolean zEglMakeCurrent = EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.EGLErrorStatus);
        if (zEglMakeCurrent) {
            str6 = "";
        } else {
            str6 = "eglMakeCurrent = " + EGL14.eglGetError() + " ";
        }
        sb5.append(str6);
        this.EGLErrorStatus = sb5.toString();
        String strGlGetString = GLES20.glGetString(7939);
        this.OpenGLVendor = GLES20.glGetString(7936);
        this.OpenGLDevice = GLES20.glGetString(7937);
        String strGlGetString2 = GLES20.glGetString(7938);
        this.OpenGLDriver = strGlGetString2;
        boolean zContains = strGlGetString2.contains("OpenGL ES 3.");
        int iGlGetError = GLES20.glGetError();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.EGLErrorStatus);
        if (iGlGetError == 0) {
            str7 = "getGraphicsInformation completed. ";
        } else {
            str7 = "gl error = " + iGlGetError;
        }
        sb6.append(str7);
        this.EGLErrorStatus = sb6.toString();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
        EGL14.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        EGL14.eglTerminate(eGLDisplayEglGetDisplay);
        this.OpenGLDevice.contains("NVIDIA");
        this.OpenGLDevice.contains("PowerVR");
        this.OpenGLDevice.contains("Adreno");
        this.OpenGLDevice.contains("Mali");
        this.OpenGLDevice.contains("VideoCore");
        this.OpenGLVersion = "";
        int iIndexOf = this.OpenGLDriver.indexOf("OpenGL ES ");
        if (iIndexOf >= 0) {
            String strSubstring = this.OpenGLDriver.substring(iIndexOf + 10);
            this.OpenGLVersion = strSubstring;
            int iIndexOf2 = strSubstring.indexOf(" ");
            if (iIndexOf2 > 0) {
                this.OpenGLVersion = this.OpenGLVersion.substring(0, iIndexOf2);
            }
        }
        if (!strGlGetString.contains("GL_EXT_color_buffer_half_float") && (!zContains || !strGlGetString.contains("GL_EXT_color_buffer_float"))) {
            z = false;
        }
        this.bSupportsFloatingPointRenderTargets = z;
        this.TextureFormats = "";
        if (strGlGetString.contains("GL_KHR_texture_compression_astc_ldr")) {
            this.TextureFormats += "ASTC,";
        }
        if (strGlGetString.contains("GL_IMG_texture_compression_pvrtc")) {
            this.TextureFormats += "PVRTC,";
        }
        if (strGlGetString.contains("GL_NV_texture_compression_s3tc") || strGlGetString.contains("GL_EXT_texture_compression_s3tc")) {
            this.TextureFormats += "DXT,";
        }
        if (strGlGetString.contains("GL_ATI_texture_compression_atitc") || strGlGetString.contains("GL_AMD_compressed_ATC_texture")) {
            this.TextureFormats += "ATC,";
        }
        if (this.OpenGLVersion.charAt(0) >= '3') {
            this.TextureFormats += "ETC2,";
        }
        this.TextureFormats += "ETC1";
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> getInstalledPackages(android.content.Context r5) throws java.lang.InterruptedException, java.io.IOException {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            r1 = 0
            java.util.List r5 = r5.getInstalledPackages(r1)     // Catch: java.lang.Exception -> L25
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L25
        L12:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L24
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Exception -> L25
            android.content.pm.PackageInfo r1 = (android.content.pm.PackageInfo) r1     // Catch: java.lang.Exception -> L25
            java.lang.String r1 = r1.packageName     // Catch: java.lang.Exception -> L25
            r0.add(r1)     // Catch: java.lang.Exception -> L25
            goto L12
        L24:
            return r0
        L25:
            r5 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = "pm list packages"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Exception -> L5d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L5d
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L5d
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Exception -> L5d
            r3.<init>(r4)     // Catch: java.lang.Exception -> L5d
            r2.<init>(r3)     // Catch: java.lang.Exception -> L5d
        L3e:
            java.lang.String r5 = r2.readLine()     // Catch: java.lang.Exception -> L5b
            if (r5 == 0) goto L54
            r3 = 58
            int r3 = r5.indexOf(r3)     // Catch: java.lang.Exception -> L5b
            int r3 = r3 + 1
            java.lang.String r5 = r5.substring(r3)     // Catch: java.lang.Exception -> L5b
            r0.add(r5)     // Catch: java.lang.Exception -> L5b
            goto L3e
        L54:
            r2.close()     // Catch: java.lang.Exception -> L5b
            r1.waitFor()     // Catch: java.lang.Exception -> L5b
            goto L63
        L5b:
            r5 = move-exception
            goto L60
        L5d:
            r1 = move-exception
            r2 = r5
            r5 = r1
        L60:
            r5.printStackTrace()
        L63:
            if (r2 == 0) goto L68
            r2.close()     // Catch: java.lang.Exception -> L68
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.getInstalledPackages(android.content.Context):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getProp(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ""
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = "android.os.SystemProperties"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L25
            java.lang.String r5 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L25
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r2] = r7     // Catch: java.lang.Exception -> L25
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.Exception -> L25
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L25
            r5[r2] = r10     // Catch: java.lang.Exception -> L25
            java.lang.Object r4 = r4.invoke(r1, r5)     // Catch: java.lang.Exception -> L25
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L25
            if (r4 == 0) goto L24
            return r4
        L24:
            return r0
        L25:
            java.lang.ProcessBuilder r4 = new java.lang.ProcessBuilder     // Catch: java.lang.Exception -> L5f
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L5f
            r4.<init>(r5)     // Catch: java.lang.Exception -> L5f
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Exception -> L5f
            java.lang.String r6 = "/system/bin/getprop"
            r5[r2] = r6     // Catch: java.lang.Exception -> L5f
            r5[r3] = r10     // Catch: java.lang.Exception -> L5f
            java.lang.ProcessBuilder r10 = r4.command(r5)     // Catch: java.lang.Exception -> L5f
            java.lang.ProcessBuilder r10 = r10.redirectErrorStream(r3)     // Catch: java.lang.Exception -> L5f
            java.lang.Process r10 = r10.start()     // Catch: java.lang.Exception -> L5f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L5a
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L5a
            java.io.InputStream r4 = r10.getInputStream()     // Catch: java.lang.Exception -> L5a
            r3.<init>(r4)     // Catch: java.lang.Exception -> L5a
            r2.<init>(r3)     // Catch: java.lang.Exception -> L5a
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L58
            if (r1 != 0) goto L56
            goto L79
        L56:
            r0 = r1
            goto L79
        L58:
            r1 = move-exception
            goto L63
        L5a:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L63
        L5f:
            r10 = move-exception
            r2 = r1
            r1 = r10
            r10 = r2
        L63:
            com.epicgames.unreal.Logger r3 = com.epicgames.unreal.GameActivity.Log
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unable to use getprop: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.debug(r1)
        L79:
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L7f
            goto L80
        L7f:
        L80:
            if (r10 == 0) goto L85
            r10.destroy()
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.getProp(java.lang.String):java.lang.String");
    }

    private int getResourceId(String str, String str2, String str3) {
        try {
            return getResources().getIdentifier(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private String getResourceStringOrDefault(String str, String str2, String str3) {
        int resourceId = getResourceId(str2, TypedValues.Custom.S_STRING, str);
        return resourceId < 1 ? str3 : getString(resourceId);
    }

    @TargetApi(17)
    public static boolean isAirplaneModeOn(Context context) {
        return Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 : Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean isOBBInAPK() {
        Logger logger = Log;
        StringBuilder sb = new StringBuilder();
        sb.append("Asking if osOBBInAPK? ");
        sb.append(PackageDataInsideApkValue == 1);
        logger.debug(sb.toString());
        return PackageDataInsideApkValue == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResumeBody() {
        if (this.bAllowIMU) {
            Log.debug("Registering sensor listeners");
            Sensor sensor = this.accelerometer;
            if (sensor != null) {
                this.sensorManager.registerListener(this, sensor, 1);
            }
            Sensor sensor2 = this.magnetometer;
            if (sensor2 != null) {
                this.sensorManager.registerListener(this, sensor2, 1);
            }
            Sensor sensor3 = this.gyroscope;
            if (sensor3 != null) {
                this.sensorManager.registerListener(this, sensor3, 1);
            }
        }
        nativeSetWindowInfo(getResources().getConfiguration().orientation == 1, this.DepthBufferPreference, this.PropagateAlpha);
        if (this.ShouldHideUI) {
            restoreTransparentBars();
            View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.epicgames.unreal.GameActivity.12
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
            decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.epicgames.unreal.GameActivity.13
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
        }
        if (this.UseDisplayCutout) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (attributes.layoutInDisplayCutoutMode != 1) {
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
        if (this.HasAllFiles) {
            Log.debug("==============> Resuming main init");
            nativeResumeMainInit();
            this.InitCompletedOK = true;
        } else {
            nativeOnInitialDownloadStarted();
            Log.debug("==============> Posting request for downloader activity");
            new Handler().post(new Runnable() { // from class: com.epicgames.unreal.GameActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.Log.debug("==============> Starting activity to check files and download if required");
                    Intent intent = new Intent(GameActivity._activity, DownloadShim.GetDownloaderType());
                    intent.addFlags(65536);
                    GameActivity.this.startActivityForResult(intent, GameActivity.DOWNLOAD_ACTIVITY_ID);
                    if (GameActivity.this.noActionAnimID != -1) {
                        GameActivity gameActivity = GameActivity.this;
                        gameActivity.overridePendingTransition(gameActivity.noActionAnimID, GameActivity.this.noActionAnimID);
                    }
                }
            });
        }
        LocalNotificationCheckAppOpen();
        this.bKeyboardShowing = false;
        Log.debug("==============> GameActive.onResume complete!");
    }

    private void parseCommandLineParams(String str) {
        Log.debug("Parsing commandline: " + str);
        Iterator<String> it = ParseSegments(str, " ", "\"", "\"").iterator();
        while (it.hasNext()) {
            String strTrim = it.next().trim();
            if (strTrim.startsWith(Constants.FILENAME_SEQUENCE_SEPARATOR)) {
                String strSubstring = strTrim.substring(1);
                ArrayList<String> arrayListParseSegments = ParseSegments(strSubstring, "=", "\"", "\"");
                if (arrayListParseSegments.size() == 2) {
                    this.CommandLineFlags.put(arrayListParseSegments.get(0).toLowerCase(), RemoveSurrounds(arrayListParseSegments.get(1), "\"", "\""));
                } else {
                    this.CommandLineFlags.put(strSubstring.toLowerCase(), "");
                }
            } else {
                this.CommandLineArguments.add(RemoveSurrounds(strTrim, "\"", "\""));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:327:0x098b, code lost:
    
        r32.ForceExitMessage = getResourceStringOrDefault(r10, r3.get("error"), "This device cannot run this game.");
        r32.bForceGameEndWithError = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:230:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07ef A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0809 A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x085c A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x08b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x08c7 A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08dc A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x08fe A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x091a A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0936 A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0952 A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0964  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0975 A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x09a0 A[Catch: IOException -> 0x0a12, TryCatch #7 {IOException -> 0x0a12, blocks: (B:280:0x07e7, B:282:0x07ef, B:283:0x0801, B:285:0x0809, B:286:0x081d, B:288:0x0823, B:289:0x0854, B:291:0x085c, B:292:0x0871, B:294:0x0877, B:295:0x08a8, B:328:0x09a0, B:300:0x08bd, B:302:0x08c7, B:303:0x08d1, B:305:0x08dc, B:307:0x08f2, B:309:0x08fe, B:310:0x090e, B:312:0x091a, B:313:0x092a, B:315:0x0936, B:316:0x0946, B:318:0x0952, B:321:0x0966, B:323:0x096c, B:325:0x0975, B:327:0x098b, B:266:0x077b, B:268:0x079c, B:270:0x07a7, B:271:0x07bc, B:272:0x07c0, B:274:0x07c6, B:275:0x07cb, B:277:0x07d1, B:333:0x09ad, B:335:0x09cf), top: B:393:0x07e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0a72  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0ae7  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0af6  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0b30  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0b8a A[LOOP:5: B:374:0x0b84->B:376:0x0b8a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0ac5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x098b A[EDGE_INSN: B:415:0x098b->B:327:0x098b BREAK  A[LOOP:1: B:105:0x0365->B:434:0x0365], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:416:0x09a8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processSystemInfo(java.lang.String r33, java.lang.String r34) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.util.zip.DataFormatException, java.io.IOException, java.lang.NumberFormatException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 2989
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.processSystemInfo(java.lang.String, java.lang.String):boolean");
    }

    public static boolean writeFile(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(new File(str));
            fileWriter.write(str2);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            Log.debug("Exception: " + e);
            return false;
        }
    }

    public void AndroidThunkJava_ClipboardCopy(String str) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Copied Text", str));
    }

    public String AndroidThunkJava_ClipboardPaste() {
        return clipboardManager.hasPrimaryClip() ? clipboardManager.getPrimaryClip().getItemAt(0).getText().toString() : "";
    }

    public String AndroidThunkJava_CookieManager_GetCookies(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.createInstance(getApplicationContext()).sync();
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager == null) {
            return null;
        }
        cookieManager.setAcceptCookie(true);
        return cookieManager.getCookie(str);
    }

    public boolean AndroidThunkJava_CookieManager_RemoveCookies(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager == null) {
                return false;
            }
            cookieManager.setAcceptCookie(true);
            if (cookieManager.getCookie(str) == null) {
                return false;
            }
            cookieManager.setCookie(str, "expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            cookieManager.flush();
            return true;
        }
        CookieSyncManager cookieSyncManagerCreateInstance = CookieSyncManager.createInstance(getApplicationContext());
        cookieSyncManagerCreateInstance.sync();
        CookieManager cookieManager2 = CookieManager.getInstance();
        if (cookieManager2 == null) {
            return false;
        }
        cookieManager2.setAcceptCookie(true);
        if (cookieManager2.getCookie(str) == null) {
            return false;
        }
        cookieManager2.setCookie(str, "expires=Sat, 1 Jan 2000 00:00:01 UTC;");
        cookieManager2.removeExpiredCookie();
        cookieSyncManagerCreateInstance.sync();
        return true;
    }

    public boolean AndroidThunkJava_CookieManager_SetCookie(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager == null) {
                return false;
            }
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(str, str2);
            cookieManager.flush();
            return true;
        }
        CookieSyncManager cookieSyncManagerCreateInstance = CookieSyncManager.createInstance(getApplicationContext());
        cookieSyncManagerCreateInstance.sync();
        CookieManager cookieManager2 = CookieManager.getInstance();
        if (cookieManager2 == null) {
            return false;
        }
        cookieManager2.setAcceptCookie(true);
        cookieManager2.setCookie(str, str2);
        cookieSyncManagerCreateInstance.sync();
        return true;
    }

    public void AndroidThunkJava_DisableScreenCapture(boolean z) {
        boolean zAndroidThunkJava_IsScreenCaptureDisabled = AndroidThunkJava_IsScreenCaptureDisabled();
        this.NumTimesScreenCaptureDisabled += z ? 1 : -1;
        if (AndroidThunkJava_IsScreenCaptureDisabled() != zAndroidThunkJava_IsScreenCaptureDisabled) {
            SetDisableScreenCaptureInternal(!zAndroidThunkJava_IsScreenCaptureDisabled);
        }
    }

    public void AndroidThunkJava_DismissSplashScreen() {
        Dialog dialog = this.mSplashDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mSplashDialog = null;
        }
    }

    public void AndroidThunkJava_EnableMotion(boolean z) {
        if (this.bAllowIMU != z) {
            this.bAllowIMU = z;
            if (!z) {
                this.sensorManager.unregisterListener(this);
                return;
            }
            Sensor sensor = this.accelerometer;
            if (sensor != null) {
                this.sensorManager.registerListener(this, sensor, 1);
            }
            Sensor sensor2 = this.magnetometer;
            if (sensor2 != null) {
                this.sensorManager.registerListener(this, sensor2, 1);
            }
            Sensor sensor3 = this.gyroscope;
            if (sensor3 != null) {
                this.sensorManager.registerListener(this, sensor3, 1);
            }
        }
    }

    public void AndroidThunkJava_ForceQuit() {
        finish();
    }

    public String AndroidThunkJava_GetAndroidId() {
        try {
            return Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        } catch (Exception e) {
            Log.debug("GetAndroidId failed: " + e.getMessage());
            return null;
        }
    }

    public AssetManager AndroidThunkJava_GetAssetManager() {
        if (this.AssetManagerReference == null) {
            Log.debug("No reference to asset manager found!");
        }
        return this.AssetManagerReference;
    }

    public String AndroidThunkJava_GetCommandLine() {
        return "";
    }

    public int AndroidThunkJava_GetDeviceOrientation() {
        return getWindowManager().getDefaultDisplay().getRotation();
    }

    public String AndroidThunkJava_GetFunnelId() {
        return "";
    }

    public InputDeviceInfo AndroidThunkJava_GetInputDeviceInfo(int i) {
        int vendorId;
        int productId;
        int controllerNumber;
        for (int i2 : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i2);
            if (device != null && device.getId() == i) {
                int i3 = ANDROID_BUILD_VERSION;
                String descriptor = i3 >= 16 ? device.getDescriptor() : Integer.toString(i);
                if (i3 >= 19) {
                    vendorId = device.getVendorId();
                    productId = device.getProductId();
                    controllerNumber = device.getControllerNumber();
                    for (DeviceInfoData deviceInfoData : DeviceInfoList) {
                        if (deviceInfoData.IsMatch(vendorId, productId)) {
                            return new InputDeviceInfo(i, vendorId, productId, controllerNumber, deviceInfoData.name, descriptor);
                        }
                    }
                } else {
                    vendorId = 0;
                    productId = 0;
                    controllerNumber = 0;
                }
                return new InputDeviceInfo(i, vendorId, productId, controllerNumber, device.getName(), descriptor);
            }
        }
        return new InputDeviceInfo(i, 0, 0, -1, "Unknown", "Unknown");
    }

    public boolean AndroidThunkJava_GetIntentExtrasBoolean(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle == null || str == null) {
            return false;
        }
        return bundle.getBoolean(str);
    }

    public int AndroidThunkJava_GetIntentExtrasInt(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle == null || str == null) {
            return 0;
        }
        return bundle.getInt(str);
    }

    public String AndroidThunkJava_GetIntentExtrasString(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle == null || str == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public String AndroidThunkJava_GetLoginId() throws IOException {
        File file = new File(this.InternalFilesDir + "login-identifier.txt");
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } catch (IOException e) {
                Log.debug("failed to read login-identifier.txt: " + e);
            }
        }
        File file2 = new File(this.ExternalFilesDir + "login-identifier.txt");
        if (file2.exists()) {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                String line2 = bufferedReader2.readLine();
                bufferedReader2.close();
                writeLoginId(this.InternalFilesDir, line2);
                return line2;
            } catch (IOException e2) {
                Log.debug("failed to read login-identifier.txt: " + e2);
            }
        }
        String string = UUID.randomUUID().toString();
        writeLoginId(this.InternalFilesDir, string);
        return string;
    }

    public boolean AndroidThunkJava_GetMetaDataBoolean(String str) {
        Bundle bundle = _bundle;
        if (bundle == null || str == null) {
            return false;
        }
        return bundle.getBoolean(str);
    }

    public float AndroidThunkJava_GetMetaDataFloat(String str) {
        if (!str.equals("unreal.display.getRefreshRate")) {
            return 0.0f;
        }
        float refreshRate = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRefreshRate();
        if (refreshRate < 15.0f) {
            return 60.0f;
        }
        return refreshRate;
    }

    public int AndroidThunkJava_GetMetaDataInt(String str) {
        int i;
        int i2;
        if (str.equals("unreal.http.proxy.proxyPort")) {
            if (ANDROID_BUILD_VERSION < 14) {
                return Proxy.getPort(getApplicationContext());
            }
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                return -1;
            }
            return Integer.parseInt(property);
        }
        if (str.equals("android.hardware.vulkan.version")) {
            return this.VulkanVersion;
        }
        if (str.equals("android.hardware.vulkan.level")) {
            return this.VulkanLevel;
        }
        if (str.equals("unreal.getUsedMemory")) {
            synchronized (_activity) {
                i2 = _activity.UsedMemory;
            }
            return i2;
        }
        if (str.equals("audiomanager.framesPerBuffer")) {
            String property2 = ((AudioManager) getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            i = property2 != null ? Integer.parseInt(property2) : 0;
            if (i == 0) {
                i = 256;
            }
            Log.debug("[JAVA] audiomanager.framesPerBuffer = " + i);
            return i;
        }
        if (!str.equals("audiomanager.optimalSampleRate")) {
            Bundle bundle = _bundle;
            if (bundle == null || str == null) {
                return 0;
            }
            return bundle.getInt(str);
        }
        String property3 = ((AudioManager) getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        i = property3 != null ? Integer.parseInt(property3) : 0;
        if (i == 0) {
            i = 44100;
        }
        Log.debug("[JAVA] audiomanager.optimalSampleRate = " + i);
        return i;
    }

    public long AndroidThunkJava_GetMetaDataLong(String str) {
        if (str.equals("unreal.display.PresentationDeadlineNanos")) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((WindowManager) getSystemService("window")).getDefaultDisplay().getPresentationDeadlineNanos();
            }
            return -1L;
        }
        if (!str.equals("unreal.display.AppVsyncOffsetNanos")) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowManager) getSystemService("window")).getDefaultDisplay().getAppVsyncOffsetNanos();
        }
        return -1L;
    }

    public String AndroidThunkJava_GetMetaDataString(String str) {
        if (str.startsWith("getprop:")) {
            return getProp(str.substring(8));
        }
        if (str.equals("unreal.http.proxy.proxyHost")) {
            return ANDROID_BUILD_VERSION >= 14 ? System.getProperty("http.proxyHost") : Proxy.getHost(getApplicationContext());
        }
        if (!str.equals("unreal.displaymetrics.dpi")) {
            Bundle bundle = _bundle;
            if (bundle == null || str == null) {
                return null;
            }
            return bundle.getString(str);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(FilenameUtils.EXTENSION_SEPARATOR);
        DecimalFormat decimalFormat = new DecimalFormat("###.##", decimalFormatSymbols);
        return decimalFormat.format(displayMetrics.xdpi) + "," + decimalFormat.format(displayMetrics.ydpi) + "," + decimalFormat.format(displayMetrics.densityDpi);
    }

    public int AndroidThunkJava_GetNativeDisplayRefreshRate() {
        if (ANDROID_BUILD_VERSION >= 24) {
            return (int) getWindowManager().getDefaultDisplay().getMode().getRefreshRate();
        }
        return 60;
    }

    public int AndroidThunkJava_GetNetworkConnectionType() {
        boolean zIsAirplaneModeOn = isAirplaneModeOn(getApplicationContext());
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (!(activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting())) {
            return zIsAirplaneModeOn ? 1 : 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 4;
        }
        if (type != 9) {
            return type != 6 ? type != 7 ? zIsAirplaneModeOn ? 1 : 3 : zIsAirplaneModeOn ? 1 : 6 : zIsAirplaneModeOn ? 1 : 5;
        }
        return 2;
    }

    public int[] AndroidThunkJava_GetSupportedNativeDisplayRefreshRates() {
        if (ANDROID_BUILD_VERSION < 24) {
            return new int[]{60};
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Display.Mode mode = defaultDisplay.getMode();
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < supportedModes.length; i++) {
            if (supportedModes[i].getPhysicalHeight() == mode.getPhysicalHeight() && supportedModes[i].getPhysicalWidth() == mode.getPhysicalWidth()) {
                arrayList.add(Integer.valueOf((int) supportedModes[i].getRefreshRate()));
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(60);
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    public boolean AndroidThunkJava_GooglePAD_Available() {
        return false;
    }

    public boolean AndroidThunkJava_HasIntentExtrasKey(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle == null || str == null) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public boolean AndroidThunkJava_HasMetaDataKey(String str) {
        Bundle bundle = _bundle;
        if (bundle == null || str == null) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public void AndroidThunkJava_HideVirtualKeyboardInput() {
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_HIDE;
        this.virtualKeyboardHandler.removeCallbacksAndMessages(null);
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.unreal.GameActivity.27
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_HIDE) {
                    GameActivity.this.processLastVirtualKeyboardCommand();
                }
            }
        }, 200L);
    }

    public void AndroidThunkJava_HideVirtualKeyboardInputDialog() {
        if (this.virtualKeyboardAlert.isShowing()) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.25
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity.this.virtualKeyboardAlert.isShowing()) {
                        GameActivity.Log.debug("Virtual keyboard hiding");
                        GameActivity.this.virtualKeyboardInputBox.setText(" ");
                        GameActivity.this.virtualKeyboardAlert.dismiss();
                        GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                    }
                }
            });
        } else {
            Log.debug("Virtual keyboard already hidden.");
        }
    }

    public boolean AndroidThunkJava_IapConsumePurchase(String str) {
        Log.debug("[JAVA] - AndroidThunkJava_IapConsumePurchase " + str);
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            storeHelper.ConsumePurchase(str);
            return true;
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapIsAllowedToMakePurchases() {
        Log.debug("[JAVA] - AndroidThunkJava_IapIsAllowedToMakePurchases");
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            return storeHelper.IsAllowedToMakePurchases();
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapQueryExistingPurchases() {
        Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases");
        if (this.IapStoreHelper != null) {
            Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases - Kick off logic here!");
            return this.IapStoreHelper.QueryExistingPurchases();
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapQueryInAppPurchases(String[] strArr) {
        Log.debug("[JAVA] - AndroidThunkJava_IapQueryInAppPurchases");
        this.CachedQueryProductIDs = strArr;
        if (this.IapStoreHelper != null) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.32
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.IapStoreHelper.QueryInAppPurchases(GameActivity.this.CachedQueryProductIDs);
                }
            });
            return true;
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public void AndroidThunkJava_IapSetupService(String str) {
    }

    public void AndroidThunkJava_InitHMDs() {
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.31
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.nativeInitHMDs();
            }
        });
    }

    public boolean AndroidThunkJava_IsAllowedRemoteNotifications() {
        return false;
    }

    public boolean AndroidThunkJava_IsGamepadAttached() {
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if ((device.getSources() & 1025) == 1025 || (device.getSources() & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232) {
                return true;
            }
        }
        return false;
    }

    public boolean AndroidThunkJava_IsMusicActive() {
        return ((AudioManager) getSystemService("audio")).isMusicActive();
    }

    public boolean AndroidThunkJava_IsPackageInstalled(String str) {
        return getInstalledPackages(getApplicationContext()).contains(str);
    }

    public boolean AndroidThunkJava_IsScreenCaptureDisabled() {
        return this.NumTimesScreenCaptureDisabled != 0;
    }

    public boolean AndroidThunkJava_IsScreensaverEnabled() {
        return !this.bKeepScreenOn;
    }

    public void AndroidThunkJava_KeepScreenOn(boolean z) {
        this.bKeepScreenOn = z;
        if (z) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.20
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_KeepScreenOn(true) - Disabled screen saver");
                    GameActivity._activity.getWindow().addFlags(128);
                }
            });
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_KeepScreenOn(false) - Enabled screen saver");
                    GameActivity._activity.getWindow().clearFlags(128);
                }
            });
        }
    }

    public boolean AndroidThunkJava_LaunchPackage(String str, String str2, String str3) {
        String strSubstring;
        String strSubstring2;
        Intent intent;
        int iIndexOf = str.indexOf(SignatureImpl.INNER_SEP);
        if (iIndexOf >= 0) {
            strSubstring2 = str.substring(iIndexOf + 1);
            str = str.substring(0, iIndexOf);
            int iIndexOf2 = strSubstring2.indexOf(SignatureImpl.INNER_SEP);
            if (iIndexOf2 >= 0) {
                strSubstring = strSubstring2.substring(iIndexOf2 + 1);
                strSubstring2 = strSubstring2.substring(0, iIndexOf2);
            } else {
                strSubstring = "";
            }
        } else {
            strSubstring = "";
            strSubstring2 = strSubstring;
        }
        if (!AndroidThunkJava_IsPackageInstalled(str)) {
            return false;
        }
        if (strSubstring2.equals("")) {
            intent = getPackageManager().getLaunchIntentForPackage(str);
            if (intent == null) {
                return false;
            }
        } else {
            intent = new Intent(strSubstring2);
            intent.setPackage(str);
            intent.setFlags(268435456);
        }
        if (!str2.equals("")) {
            intent.putExtra(str2, str3);
        }
        if (!strSubstring.equals("")) {
            intent.setComponent(new ComponentName(str, strSubstring));
        }
        if (intent.resolveActivity(getPackageManager()) == null) {
            return false;
        }
        startActivity(intent);
        AndroidThunkJava_ForceQuit();
        return true;
    }

    public void AndroidThunkJava_LaunchURL(String str) {
        Log.debug("[JAVA} AndroidThunkJava_LaunchURL: URL = " + str);
        if (!str.contains("://") && str.indexOf(SignatureImpl.INNER_SEP) < 1) {
            str = "http://" + str;
            Log.debug("[JAVA} AndroidThunkJava_LaunchURL: corrected URL = " + str);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.addFlags(1074266112);
            intent.addFlags(402653184);
            if (intent.resolveActivity(getPackageManager()) == null) {
                Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Could not find an application to receive the URL intent");
            } else {
                Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Starting activity");
                startActivity(intent);
            }
        } catch (Exception e) {
            Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Failed with exception " + e.getMessage());
        }
    }

    public void AndroidThunkJava_LocalNotificationClearAll() {
        Iterator<Integer> it = LocalNotificationGetIDList().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(this, iIntValue, new Intent(this, (Class<?>) LocalNotificationReceiver.class), 201326592);
            broadcast.cancel();
            alarmManager.cancel(broadcast);
        }
        SharedPreferences.Editor editorEdit = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0).edit();
        editorEdit.putString("notificationIDs", "");
        editorEdit.putString("notificationDetails", MessageFormatter.DELIM_STR);
        editorEdit.commit();
    }

    public boolean AndroidThunkJava_LocalNotificationDestroyIfExists(int i) {
        if (!AndroidThunkJava_LocalNotificationExists(i)) {
            return false;
        }
        LocalNotificationRemoveID(this, i);
        LocalNotificationRemoveDetails(this, i);
        AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, i, new Intent(this, (Class<?>) LocalNotificationReceiver.class), 201326592);
        broadcast.cancel();
        alarmManager.cancel(broadcast);
        ((NotificationManager) getSystemService("notification")).cancel(i);
        return true;
    }

    public boolean AndroidThunkJava_LocalNotificationExists(int i) {
        return LocalNotificationIDExists(i);
    }

    public LaunchNotification AndroidThunkJava_LocalNotificationGetLaunchNotification() {
        return new LaunchNotification(this.localNotificationAppLaunched, this.localNotificationLaunchActivationEvent, this.localNotificationLaunchFireDate);
    }

    public int AndroidThunkJava_LocalNotificationScheduleAtTime(String str, boolean z, String str2, String str3, String str4, String str5) throws JSONException {
        JSONObject jSONObject;
        int iLocalNotificationGetID = LocalNotificationGetID(this);
        if (!LocalNotificationScheduleAtTime(this, iLocalNotificationGetID, str, z, str2, str3, str4, str5)) {
            return -1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        try {
            jSONObject = new JSONObject(sharedPreferences.getString("notificationDetails", MessageFormatter.DELIM_STR));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("local-notification-targetDateTime", str);
            jSONObject2.put("local-notification-localTime", z);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_TITLE, str2);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_BODY, str3);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION, str4);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION_EVENT, str5);
            jSONObject.put(String.valueOf(iLocalNotificationGetID), jSONObject2);
            editorEdit.putString("notificationDetails", jSONObject.toString());
            editorEdit.commit();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return iLocalNotificationGetID;
    }

    public void AndroidThunkJava_Minimize() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void AndroidThunkJava_OpenIntentAction(String str) {
        Intent intent = new Intent(str, (Uri) null);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public void AndroidThunkJava_PushSensorEvents() {
        if (this.bAllowIMU) {
            synchronized (this) {
                if (this.bSensorDataUpdated) {
                    nativeHandleSensorEvents(this.current_tilt, current_rotation_rate, current_gravity, current_acceleration);
                    this.bSensorDataUpdated = false;
                }
            }
        }
    }

    public void AndroidThunkJava_ResetAchievements() {
        Log.debug("AndroidThunkJava_ResetAchievements: disabled");
    }

    public void AndroidThunkJava_ResizeKeyboard(boolean z, Rect rect, Rect rect2) {
    }

    public void AndroidThunkJava_RestartApplication(final String str) throws InterruptedException {
        Runnable runnable = new Runnable() { // from class: com.epicgames.unreal.GameActivity.42
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.RestartApplication(str);
            }
        };
        Log.debug("app restart : " + str);
        runOnUiThread(runnable);
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean AndroidThunkJava_SendBroadcast(String str, String str2, String str3, boolean z) {
        String strSubstring;
        String strSubstring2;
        Intent intent;
        int iIndexOf = str.indexOf(SignatureImpl.INNER_SEP);
        if (iIndexOf >= 0) {
            strSubstring2 = str.substring(iIndexOf + 1);
            str = str.substring(0, iIndexOf);
            int iIndexOf2 = strSubstring2.indexOf(SignatureImpl.INNER_SEP);
            if (iIndexOf2 >= 0) {
                strSubstring = strSubstring2.substring(iIndexOf2 + 1);
                strSubstring2 = strSubstring2.substring(0, iIndexOf2);
            } else {
                strSubstring = "";
            }
        } else {
            strSubstring = "";
            strSubstring2 = strSubstring;
        }
        if (!AndroidThunkJava_IsPackageInstalled(str)) {
            return false;
        }
        if (strSubstring2.equals("")) {
            intent = getPackageManager().getLaunchIntentForPackage(str);
            if (intent == null) {
                return false;
            }
        } else {
            intent = new Intent(strSubstring2);
            intent.setPackage(str);
            intent.setFlags(268435456);
        }
        if (!str2.equals("")) {
            intent.putExtra(str2, str3);
        }
        if (!strSubstring.equals("")) {
            intent.setComponent(new ComponentName(str, strSubstring));
        }
        getApplicationContext().sendBroadcast(intent);
        if (!z) {
            return true;
        }
        AndroidThunkJava_ForceQuit();
        return true;
    }

    public void AndroidThunkJava_SetDesiredViewSize(int i, int i2) {
        if (i == this.DesiredHolderWidth && i2 == this.DesiredHolderHeight) {
            return;
        }
        Log.debug("[JAVA] - SetDesiredViewSize width=" + i + " and height=" + i2);
        this.DesiredHolderWidth = i;
        this.DesiredHolderHeight = i2;
        if (!this.bUseSurfaceView || this.MySurfaceView == null) {
            return;
        }
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.36
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.MySurfaceView.getHolder().setFixedSize(GameActivity.this.DesiredHolderWidth, GameActivity.this.DesiredHolderHeight);
            }
        });
    }

    public boolean AndroidThunkJava_SetNativeDisplayRefreshRate(final int i) {
        int i2 = ANDROID_BUILD_VERSION;
        if (i2 >= 30) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.37
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GameActivity.this.MySurfaceView.getHolder().getSurface().setFrameRate(i, 1);
                    } catch (Exception e) {
                        GameActivity.Log.debug("setFrameRate failed. " + e.getMessage());
                    }
                }
            });
            Log.debug("SetNativeDisplayRefreshRate - setFrameRate " + i);
            return true;
        }
        if (i2 < 24) {
            return i == 60;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Display.Mode mode = defaultDisplay.getMode();
        int modeId = mode.getModeId();
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        for (int i3 = 0; i3 < supportedModes.length; i3++) {
            if (supportedModes[i3].getPhysicalHeight() == mode.getPhysicalHeight() && supportedModes[i3].getPhysicalWidth() == mode.getPhysicalWidth() && ((int) supportedModes[i3].getRefreshRate()) == i) {
                final int modeId2 = supportedModes[i3].getModeId();
                if (modeId != modeId2) {
                    _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.38
                        @Override // java.lang.Runnable
                        public void run() {
                            Window window = GameActivity.this.getWindow();
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            attributes.preferredDisplayModeId = modeId2;
                            window.setAttributes(attributes);
                        }
                    });
                    Log.debug("Found mode " + modeId2 + " for native refresh rate " + i);
                }
                return true;
            }
        }
        return false;
    }

    public void AndroidThunkJava_SetOrientation(final int i) {
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.30
            @Override // java.lang.Runnable
            public void run() {
                GameActivity._activity.setRequestedOrientation(i);
            }
        });
    }

    public void AndroidThunkJava_SetSustainedPerformanceMode(final boolean z) {
        if (ANDROID_BUILD_VERSION < 24) {
            Log.debug("==================================> API<24, cannot use SetSustainedPerformanceMode");
            return;
        }
        Log.debug("==================================> SetSustainedPerformanceMode:" + z);
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.39
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                try {
                    Window.class.getMethod("setSustainedPerformanceMode", Boolean.TYPE).invoke(GameActivity._activity.getWindow(), Boolean.valueOf(z));
                } catch (Exception e) {
                    GameActivity.Log.debug("SetSustainedPerformanceMode: failed " + e.getMessage());
                }
            }
        });
    }

    public void AndroidThunkJava_ShareURL(String str, String str2, String str3, int i, int i2) {
        Log.debug("[JAVA} AndroidThunkJava_ShareURL: URL = " + str);
        File file = new File(str);
        boolean zExists = file.exists();
        if (!zExists && !str.contains("://")) {
            str = "http://" + str;
            Log.debug("[JAVA} AndroidThunkJava_ShareURL: corrected URL = " + str);
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            if (zExists) {
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileprovider", file));
                intent.setType(URLConnection.guessContentTypeFromName(str));
                intent.putExtra("android.intent.extra.TEXT", str2);
            } else {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", str2);
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            Log.debug("[JAVA} AndroidThunkJava_ShareURL: Sharing URL");
            startActivity(Intent.createChooser(intent, str3));
        } catch (Exception e) {
            Log.debug("[JAVA} AndroidThunkJava_ShareURL: Failed with exception " + e.getMessage());
        }
    }

    public void AndroidThunkJava_ShowConsoleWindow(String str) {
        if (this.consoleAlert.isShowing()) {
            Log.debug("Console already showing.");
            return;
        }
        this.consoleInputBox.setHistoryEnd();
        this.consoleAlert.setMessage("[Available texture formats: " + str + "]");
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.24
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.this.consoleAlert.isShowing()) {
                    return;
                }
                GameActivity.Log.debug("Console not showing yet");
                GameActivity.this.consoleAlert.show();
                GameActivity.this.CurrentDialogType = EAlertDialogType.Console;
            }
        });
    }

    public void AndroidThunkJava_ShowHiddenAlertDialog() {
        if (this.CurrentDialogType != EAlertDialogType.None) {
            Log.debug("==============> [JAVA] AndroidThunkJava_ShowHiddenAlertDialog() - Showing " + this.CurrentDialogType);
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.19
                @Override // java.lang.Runnable
                public void run() {
                    int i = AnonymousClass43.$SwitchMap$com$epicgames$unreal$GameActivity$EAlertDialogType[GameActivity.this.CurrentDialogType.ordinal()];
                    if (i == 1) {
                        GameActivity.this.virtualKeyboardAlert.show();
                    } else if (i != 2) {
                        GameActivity.Log.debug("ERROR: Unknown EAlertDialogType!");
                    } else {
                        GameActivity.this.consoleAlert.show();
                    }
                }
            });
        }
    }

    public void AndroidThunkJava_ShowProgressDialog(final boolean z, final String str, final boolean z2, final int i) {
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.33
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    GameActivity.this.mProgressDialog.dismiss();
                    GameActivity.this.mProgressDialog = null;
                    return;
                }
                GameActivity.this.mProgressDialog = new ProgressDialog(GameActivity._activity);
                GameActivity.this.mProgressDialog.setMessage(str);
                GameActivity.this.mProgressDialog.setProgress(0);
                GameActivity.this.mProgressDialog.setMax(i);
                GameActivity.this.mProgressDialog.setProgressStyle(z2 ? 1 : 0);
                GameActivity.this.mProgressDialog.getWindow().setFlags(8, 8);
                GameActivity.this.mProgressDialog.show();
            }
        });
    }

    public void AndroidThunkJava_ShowVirtualKeyboardInput(int i, String str, String str2) {
        this.virtualKeyboardInputContent = str2;
        this.virtualKeyboardInputType = i;
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_SHOW;
        this.virtualKeyboardHandler.removeCallbacksAndMessages(null);
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.unreal.GameActivity.28
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_SHOW) {
                    GameActivity.this.processLastVirtualKeyboardCommand();
                }
            }
        }, 200L);
    }

    public void AndroidThunkJava_ShowVirtualKeyboardInputDialog(final int i, final String str, final String str2) {
        if (this.virtualKeyboardAlert.isShowing()) {
            Log.debug("Virtual keyboard already showing.");
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.26
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.virtualKeyboardAlert.setTitle(str);
                    GameActivity.this.virtualKeyboardInputBox.setRawInputType(i);
                    GameActivity.this.virtualKeyboardInputBox.setTransformationMethod((i & 128) == 0 ? null : PasswordTransformationMethod.getInstance());
                    GameActivity.this.virtualKeyboardInputBox.setText("");
                    GameActivity.this.virtualKeyboardInputBox.append(str2);
                    GameActivity gameActivity = GameActivity.this;
                    gameActivity.virtualKeyboardPreviousContents = str2;
                    if (gameActivity.virtualKeyboardAlert.isShowing()) {
                        return;
                    }
                    GameActivity.Log.debug("Virtual keyboard not showing yet");
                    GameActivity.this.virtualKeyboardAlert.show();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.Keyboard;
                }
            });
        }
    }

    public void AndroidThunkJava_UpdateProgressDialog(final int i) {
        if (this.mProgressDialog == null) {
            return;
        }
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.34
            @Override // java.lang.Runnable
            public void run() {
                ProgressDialog progressDialog = GameActivity.this.mProgressDialog;
                if (progressDialog != null) {
                    progressDialog.setProgress(i);
                }
            }
        });
    }

    public void AndroidThunkJava_UseSurfaceViewWorkaround() {
        if (this.bUseSurfaceView) {
            return;
        }
        this.bUseSurfaceView = true;
        Log.debug("[JAVA] Using SurfaceView sizing workaround for this device");
        if (this.DesiredHolderWidth <= 0 || this.DesiredHolderHeight <= 0 || this.MySurfaceView == null) {
            return;
        }
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.35
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.MySurfaceView.getHolder().setFixedSize(GameActivity.this.DesiredHolderWidth, GameActivity.this.DesiredHolderHeight);
            }
        });
    }

    public void AndroidThunkJava_Vibrate(int i) {
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null) {
            _activity.runOnUiThread(new VibrateRunnable(i, vibrator));
        }
    }

    public boolean AndroidThunkJava_VirtualInputIgnoreClick(int i, int i2) {
        View currentFocus = getCurrentFocus();
        if (currentFocus == this.newVirtualKeyboardInput) {
            Rect rect = new Rect();
            currentFocus.getGlobalVisibleRect(rect);
            if (rect.contains(i, i2) || this.newVirtualKeyboardInput.getY() < 0.0f) {
                return true;
            }
        } else {
            List<View> listGetExtraIgnoreViews = GetExtraIgnoreViews();
            if (listGetExtraIgnoreViews != null) {
                for (int i3 = 0; i3 < listGetExtraIgnoreViews.size(); i3++) {
                    Rect rect2 = new Rect();
                    listGetExtraIgnoreViews.get(i3).getGlobalVisibleRect(rect2);
                    if (rect2.contains(i, i2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String[] FindLineFromFile(String str, String[] strArr) throws IOException {
        String[] strArr2 = new String[strArr.length];
        File file = new File(str);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        for (int i = 0; i < strArr.length; i++) {
                            if (line.startsWith(strArr[i])) {
                                strArr2[i] = line;
                            }
                        }
                    } finally {
                    }
                }
                bufferedReader.close();
            } catch (IOException e) {
                Log.debug("failed to read status: " + e);
            }
        }
        return strArr2;
    }

    public FrameLayout GetContainerFrameLayout() {
        return this.containerFrameLayout;
    }

    public List<View> GetExtraIgnoreViews() {
        return null;
    }

    public View GetMainView() {
        return this.mainView;
    }

    public Rect GetSafezone() {
        return this.safezone;
    }

    public boolean IsInVRMode() {
        return this.IsInVRMode;
    }

    @Override // com.epicgames.unreal.Logger.ILoggerCallback
    public void LoggerCallback(String str, String str2, String str3) {
    }

    public void ParseCommandline(String str, boolean z) throws IOException {
        if (this.bHaveParsedCommandline) {
            return;
        }
        this.bHaveParsedCommandline = true;
        String strAndroidThunkJava_GetCommandLine = AndroidThunkJava_GetCommandLine();
        if (!TextUtils.isEmpty(strAndroidThunkJava_GetCommandLine)) {
            Log.debug("Using alternative commandline source");
            this.CommandLineFull = strAndroidThunkJava_GetCommandLine;
            parseCommandLineParams(strAndroidThunkJava_GetCommandLine);
            return;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (z) {
            absolutePath = getExternalFilesDir(null).getAbsolutePath();
            if (nativeIsShippingBuild()) {
                absolutePath = getFilesDir().getAbsolutePath();
            }
        }
        String str2 = absolutePath + "/UnrealGame/" + str + "/src/main/assets/UECommandLine.txt";
        BufferedReader bufferedReaderTryOpenFileReader = TryOpenFileReader(str2);
        if (bufferedReaderTryOpenFileReader == null) {
            str2 = absolutePath + "/UnrealGame/" + str + "/uecommandline.txt";
            bufferedReaderTryOpenFileReader = TryOpenFileReader(str2);
        }
        if (bufferedReaderTryOpenFileReader == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.AssetManagerReference.open("src/main/assets/UECommandLine.txt")));
                try {
                    Log.debug("Using APK commandline");
                } catch (FileNotFoundException | IOException unused) {
                }
                bufferedReaderTryOpenFileReader = bufferedReader;
            } catch (FileNotFoundException | IOException unused2) {
            }
        } else {
            Log.debug("Using commandline from: " + str2);
        }
        if (bufferedReaderTryOpenFileReader != null) {
            try {
                String line = bufferedReaderTryOpenFileReader.readLine();
                if (line != null) {
                    String strTrim = line.trim();
                    if (strTrim.length() > 0) {
                        this.CommandLineFull = strTrim;
                        parseCommandLineParams(strTrim);
                    }
                }
            } catch (IOException e) {
                Log.debug("failed to read commandline: " + e);
            }
            if (bufferedReaderTryOpenFileReader != null) {
                try {
                    bufferedReaderTryOpenFileReader.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    public void SetCrashContextData(String str, String str2) {
        nativeCrashContextSetStringKey(str, str2);
    }

    public String getConnectionType() {
        boolean zIsAirplaneModeOn = isAirplaneModeOn(getApplicationContext());
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (!(activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting())) {
            return zIsAirplaneModeOn ? "AirplaneMode" : "None";
        }
        int type = activeNetworkInfo.getType();
        return type != 1 ? type != 9 ? type != 6 ? type != 7 ? zIsAirplaneModeOn ? "AirplaneMode" : "Cell" : zIsAirplaneModeOn ? "AirplaneMode" : "Bluetooth" : zIsAirplaneModeOn ? "AirplaneMode" : "WiMAX" : "Ethernet" : "WiFi";
    }

    public int getCurrentDeviceRotationDegree() {
        int iAndroidThunkJava_GetDeviceOrientation = AndroidThunkJava_GetDeviceOrientation();
        if (iAndroidThunkJava_GetDeviceOrientation == 1) {
            return 90;
        }
        if (iAndroidThunkJava_GetDeviceOrientation == 2) {
            return 180;
        }
        if (iAndroidThunkJava_GetDeviceOrientation != 3) {
            return 0;
        }
        return io.agora.rtc2.Constants.VIDEO_ORIENTATION_270;
    }

    public int getDeviceDefaultOrientation() {
        WindowManager windowManager = getWindowManager();
        Configuration configuration = getResources().getConfiguration();
        int rotation = windowManager.getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    public native void nativeConsoleCommand(String str);

    public native void nativeCrashContextSetBooleanKey(String str, boolean z);

    public native void nativeCrashContextSetDoubleKey(String str, double d);

    public native void nativeCrashContextSetFloatKey(String str, float f);

    public native void nativeCrashContextSetIntegerKey(String str, int i);

    public native void nativeCrashContextSetStringKey(String str, String str2);

    public native int nativeGetCPUFamily();

    public native void nativeGoogleClientConnectCompleted(boolean z, String str);

    public native void nativeHandleSensorEvents(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    public native void nativeInitHMDs();

    public native boolean nativeIsShippingBuild();

    public native void nativeOnActivityResult(GameActivity gameActivity, int i, int i2, Intent intent);

    public native void nativeOnConfigurationChanged(boolean z);

    public native void nativeOnInitialDownloadCompleted();

    public native void nativeOnInitialDownloadStarted();

    public native void nativeOnThermalStatusChangedListener(int i);

    public native void nativeOnTrimMemory(int i);

    public native void nativeResumeMainInit();

    public native void nativeSetAffinityInfo(boolean z, int i, int i2);

    public native void nativeSetAndroidStartupState(boolean z);

    public native void nativeSetAndroidVersionInformation(String str, int i, String str2, String str3, String str4, String str5);

    public native void nativeSetConfigRulesVariables(String[] strArr);

    public native void nativeSetGlobalActivity(boolean z, boolean z2, String str, String str2, boolean z3, String str3);

    public native void nativeSetObbFilePaths(String str, String str2, String str3, String str4);

    public native void nativeSetObbInfo(String str, String str2, int i, int i2, String str3);

    public native void nativeSetSafezoneInfo(boolean z, float f, float f2, float f3, float f4);

    public native void nativeSetSurfaceViewInfo(int i, int i2);

    public native void nativeSetWindowInfo(boolean z, int i, int i2);

    public native boolean nativeSupportsNEON();

    public native void nativeVirtualKeyboardChanged(String str);

    public native void nativeVirtualKeyboardResult(boolean z, String str);

    public native void nativeVirtualKeyboardSendKey(int i);

    public native void nativeVirtualKeyboardSendSelection(int i, int i2);

    public native void nativeVirtualKeyboardSendTextSelection(String str, int i, int i2);

    public native void nativeVirtualKeyboardShown(int i, int i2, int i3, int i4);

    public native void nativeVirtualKeyboardVisible(boolean z);

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        int intExtra;
        String str;
        if (i == 80001) {
            if (i2 == -1) {
                intExtra = intent.getIntExtra(DOWNLOAD_RETURN_NAME, 0);
                switch (intExtra) {
                    case 0:
                        str = "DownloadActivity Returned with Download No Return Code";
                        break;
                    case 1:
                        str = "DownloadActivity Returned with Download Files Present";
                        break;
                    case 2:
                        str = "DownloadActivity Returned with Download Completed OK";
                        break;
                    case 3:
                        str = "DownloadActivity Returned with Download User Quit";
                        break;
                    case 4:
                        str = "DownloadActivity Returned with Download Failed";
                        break;
                    case 5:
                        str = "DownloadActivity Returned with Download Invalid";
                        break;
                    case 6:
                        str = "DownloadActivity Returned with Download No Play Key";
                        break;
                    default:
                        str = "DownloadActivity Returned with Unknown message!";
                        break;
                }
                Log.debug(str);
            } else {
                Log.debug("Download activity cancelled by user.");
                intExtra = 3;
            }
            nativeOnInitialDownloadCompleted();
            this.HasAllFiles = intExtra == 1 || intExtra == 2;
            if (intExtra == 0 || intExtra == 3 || intExtra == 4 || intExtra == 5 || intExtra == 6) {
                finish();
                return;
            }
        } else {
            super.onActivityResult(i, i2, intent);
        }
        if (this.InitCompletedOK) {
            nativeOnActivityResult(this, i, i2, intent);
        }
    }

    @Override // android.app.NativeActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        nativeOnConfigurationChanged(configuration.orientation == 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x0706 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0368  */
    @Override // android.app.NativeActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r17) throws android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 2570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onDestroy() {
        synchronized (this) {
            if (this.memoryHandler != null) {
                Log.debug("onDestroy: destroy memoryHandler");
                this.memoryHandler.removeCallbacks(this.memoryRunnable);
                this.memoryHandler = null;
            }
            if (this.memoryHandlerThread != null) {
                Log.debug("onDestroy: destroy memoryHandlerThread");
                this.memoryHandlerThread.quit();
                this.memoryHandlerThread = null;
            }
        }
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            storeHelper.onDestroy();
        }
        super.onDestroy();
        Log.debug("==============> GameActive.onDestroy complete!");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 4 || i == 25 || i == 24) && this.ShouldHideUI) {
            Log.debug("=== Restoring Transparent Bars due to KeyCode ===");
            restoreTranslucentBarsDelayed();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onPause() {
        bIsActivityPaused.set(true);
        synchronized (this) {
            if (this.memoryHandler != null) {
                Log.debug("onPause: stop memory reporter runnable");
                this.memoryHandler.removeCallbacks(this.memoryRunnable);
                this.memoryHandler = null;
            }
        }
        if (this.bAllowIMU) {
            Log.debug("Unregistering sensor listeners");
            this.sensorManager.unregisterListener(this);
        }
        if (this.bKeyboardShowing) {
            AndroidThunkJava_HideVirtualKeyboardInput();
        }
        if (this.CurrentDialogType != EAlertDialogType.None) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.18
                @Override // java.lang.Runnable
                public void run() {
                    int i = AnonymousClass43.$SwitchMap$com$epicgames$unreal$GameActivity$EAlertDialogType[GameActivity.this.CurrentDialogType.ordinal()];
                    if (i == 1) {
                        GameActivity.this.virtualKeyboardAlert.hide();
                    } else if (i != 2) {
                        GameActivity.Log.debug("ERROR: Unknown EAlertDialogType!");
                    } else {
                        GameActivity.this.consoleAlert.hide();
                    }
                }
            });
        }
        super.onPause();
        Log.debug("==============> GameActive.onPause complete!");
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bIsActivityPaused.set(false);
        synchronized (this) {
            if (this.memoryHandler == null && this.memoryRunnable != null) {
                Log.debug("onResume: start memory reporter runnable");
                Handler handler = new Handler(this.memoryHandlerThread.getLooper());
                this.memoryHandler = handler;
                handler.postDelayed(this.memoryRunnable, 1000L);
            }
        }
        if (this.ShouldHideUI) {
            restoreTransparentBars();
            View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.epicgames.unreal.GameActivity.15
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
            decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.epicgames.unreal.GameActivity.16
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
        }
        if (this.UseDisplayCutout) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (attributes.layoutInDisplayCutoutMode != 1) {
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
        AndroidThunkJava_KeepScreenOn(this.bKeepScreenOn);
        SetDisableScreenCaptureInternal(AndroidThunkJava_IsScreenCaptureDisabled());
        if (this.bForceGameEndWithError || this.bForceGameEndWithWarning) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.GameActivity.17
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity.this.ForceGameDialog != null) {
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity._activity);
                    builder.setCancelable(false);
                    builder.setTitle(GameActivity.this.ForceExitCaption);
                    builder.setMessage(GameActivity.this.ForceExitMessage);
                    if (!GameActivity.this.ForceExitLink.equals("")) {
                        builder.setNeutralButton(GameActivity.this.ForceExitHelpButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.GameActivity.17.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GameActivity gameActivity = GameActivity.this;
                                gameActivity.AndroidThunkJava_LaunchURL(gameActivity.ForceExitLink);
                                GameActivity.this.AndroidThunkJava_ForceQuit();
                            }
                        });
                    }
                    if (GameActivity.this.bForceGameEndWithWarning) {
                        builder.setNegativeButton(GameActivity.this.ForceExitContinueButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.GameActivity.17.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GameActivity.this.ForceGameDialog = null;
                                GameActivity.this.bForceGameEndWithWarning = false;
                                GameActivity.this.onResumeBody();
                            }
                        });
                    }
                    if (GameActivity.this.ForceExitUpdateButtonText.equals("")) {
                        builder.setPositiveButton(GameActivity.this.ForceExitQuitButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.GameActivity.17.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GameActivity.this.AndroidThunkJava_ForceQuit();
                            }
                        });
                    } else {
                        builder.setPositiveButton(GameActivity.this.ForceExitUpdateButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.GameActivity.17.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                int i2 = GameActivity.ANDROID_BUILD_VERSION;
                                if ((i2 < 16 || i2 >= 19) && GameActivity.this.AndroidThunkJava_isIntentActionAvailable("android.settings.SYSTEM_UPDATE_SETTINGS")) {
                                    GameActivity.this.AndroidThunkJava_OpenIntentAction("android.settings.SYSTEM_UPDATE_SETTINGS");
                                } else {
                                    GameActivity.this.AndroidThunkJava_OpenIntentAction("android.settings.SETTINGS");
                                }
                                GameActivity.this.AndroidThunkJava_ForceQuit();
                            }
                        });
                    }
                    GameActivity.this.ForceGameDialog = builder.create();
                    GameActivity.this.ForceGameDialog.show();
                }
            });
        } else {
            onResumeBody();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r10) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.GameActivity.onSensorChanged(android.hardware.SensorEvent):void");
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.BuildConfiguration.equals("Shipping")) {
            Log.debug("Creating console command broadcast listener");
            ConsoleCmdReceiver consoleCmdReceiver = new ConsoleCmdReceiver(this);
            this.consoleCmdReceiver = consoleCmdReceiver;
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver(consoleCmdReceiver, new IntentFilter("android.intent.action.RUN"), 2);
            } else {
                registerReceiver(consoleCmdReceiver, new IntentFilter("android.intent.action.RUN"));
            }
        }
        Log.debug("==================================> Inside onStart function in GameActivity");
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onStop() {
        ConsoleCmdReceiver consoleCmdReceiver = this.consoleCmdReceiver;
        if (consoleCmdReceiver != null) {
            unregisterReceiver(consoleCmdReceiver);
        }
        super.onStop();
        Log.debug("==============> GameActive.onStop complete!");
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 5) {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_MODERATE) called!");
        } else if (i == 10) {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_LOW) called!");
        } else if (i == 15) {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_CRITICAL) called!");
        } else if (i == 20) {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_UI_HIDDEN) called!");
        } else if (i == 40) {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_BACKGROUND) called!");
        } else if (i == 60) {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_MODERATE) called!");
        } else if (i != 80) {
            Log.debug("==============> GameActive.onTrimMemory(" + i + ") called!");
        } else {
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_COMPLETE) called!");
        }
        nativeOnTrimMemory(i);
    }

    public void processLastVirtualKeyboardCommand() {
        int i;
        Log.debug("VK: process last command " + lastVirtualKeyboardCommand);
        synchronized (this) {
            int i2 = AnonymousClass43.$SwitchMap$com$epicgames$unreal$GameActivity$VirtualKeyboardCommand[lastVirtualKeyboardCommand.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (this.bKeyboardShowing || this.newVirtualKeyboardInput.getVisibility() != 8)) {
                    if (this.newVirtualKeyboardInput.hasFocus()) {
                        try {
                            this.newVirtualKeyboardInput.clearFocus();
                        } catch (Exception unused) {
                            Log.warn("Unable to clear focus from virtualKeyboardInput");
                        }
                    }
                    this.newVirtualKeyboardInput.setY(-1000.0f);
                    this.newVirtualKeyboardInput.setVisibility(8);
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.newVirtualKeyboardInput.getWindowToken(), 0);
                    nativeVirtualKeyboardVisible(false);
                    this.bKeyboardShowing = false;
                }
            }
            this.newVirtualKeyboardInput.setVisibility(0);
            this.newVirtualKeyboardInput.setY(-1000.0f);
            this.newVirtualKeyboardInput.setText(this.virtualKeyboardInputContent);
            int i3 = this.virtualKeyboardInputType | 524288;
            this.newVirtualKeyboardInput.setInputType(i3);
            this.newVirtualKeyboardInput.setRawInputType(i3);
            int i4 = ANDROID_BUILD_VERSION >= 11 ? 301989888 : 268435456;
            if ((this.virtualKeyboardInputType & 131072) != 0) {
                this.newVirtualKeyboardInput.setSingleLine(false);
                this.newVirtualKeyboardInput.setMaxLines(5);
                i = (i4 | 1073741824) & (-7);
            } else {
                this.newVirtualKeyboardInput.setSingleLine(true);
                this.newVirtualKeyboardInput.setMaxLines(1);
                i = (i4 & (-1073741825)) | 6;
            }
            this.newVirtualKeyboardInput.setImeOptions(i);
            this.newVirtualKeyboardInput.setTransformationMethod((this.virtualKeyboardInputType & 128) == 0 ? null : PasswordTransformationMethod.getInstance());
            VirtualKeyboardInput virtualKeyboardInput = this.newVirtualKeyboardInput;
            virtualKeyboardInput.setSelection(virtualKeyboardInput.getText().length());
            if (this.newVirtualKeyboardInput.requestFocus()) {
                ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.newVirtualKeyboardInput, 0);
                nativeVirtualKeyboardVisible(true);
                this.bKeyboardShowing = true;
                CheckKeyboardDisplayed();
            }
        }
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
    }

    public void restoreTranslucentBarsDelayed() {
        restoreTransparentBars();
        this.mRestoreImmersiveModeHandler.postDelayed(this.restoreImmersiveModeRunnable, 500L);
    }

    public void restoreTransparentBars() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                View decorView = getWindow().getDecorView();
                Log.debug("=== Restoring Transparent Bars ===");
                decorView.setSystemUiVisibility(1798);
                decorView.setSystemUiVisibility(5894);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.NativeActivity, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!this.bUseSurfaceView) {
            super.surfaceChanged(surfaceHolder, i, i2, i3);
            return;
        }
        int i4 = this.DesiredHolderWidth;
        if (i4 > 0) {
            i2 = i4;
        }
        int i5 = this.DesiredHolderHeight;
        if (i5 > 0) {
            i3 = i5;
        }
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        surfaceHolder.setFixedSize(i2, i3);
        nativeSetSurfaceViewInfo(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
    }

    public void writeLoginId(String str, String str2) {
        if (writeFile(str + "/login-identifier.txt", str2)) {
            return;
        }
        Log.debug("failed to create login-identifier.txt");
    }

    public class ConsoleKeyboardInput extends EditText {
        private ImageButton historyButton;
        private ArrayList<String> historyList;

        public ConsoleKeyboardInput(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ImageButton getButton() {
            return this.historyButton;
        }

        private void init(Context context) {
            this.historyList = new ArrayList<>();
            ImageButton imageButton = new ImageButton(context);
            this.historyButton = imageButton;
            imageButton.setImageResource(R.drawable.ic_menu_revert);
            this.historyButton.setOnClickListener(new View.OnClickListener() { // from class: com.epicgames.unreal.GameActivity.ConsoleKeyboardInput.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ConsoleKeyboardInput.this.historyList.size() > 0) {
                        String[] strArr = (String[]) ConsoleKeyboardInput.this.historyList.toArray(new String[ConsoleKeyboardInput.this.historyList.size()]);
                        AlertDialog.Builder builder = new AlertDialog.Builder(ConsoleKeyboardInput.this.getContext());
                        builder.setTitle("History");
                        builder.setCancelable(true);
                        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.GameActivity.ConsoleKeyboardInput.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String str = (String) ConsoleKeyboardInput.this.historyList.get(i);
                                GameActivity.this.consoleInputBox.removeHistory(str);
                                GameActivity.this.consoleInputBox.addHistory(str);
                                GameActivity.this.consoleInputBox.setText(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.show();
                    }
                }
            });
            this.historyButton.setEnabled(false);
        }

        public void addHistory(String str) {
            this.historyList.add(0, str);
            this.historyButton.setEnabled(this.historyList.size() > 0);
        }

        public void removeHistory(String str) {
            int iIndexOf = this.historyList.indexOf(str);
            if (iIndexOf >= 0) {
                this.historyList.remove(iIndexOf);
            }
            this.historyButton.setEnabled(this.historyList.size() > 0);
        }

        public void setHistoryEnd() {
            this.historyButton.setEnabled(this.historyList.size() > 0);
        }

        public void setHistoryList(ArrayList<String> arrayList) {
            this.historyList = arrayList;
        }

        public ConsoleKeyboardInput(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init(context);
        }

        public ConsoleKeyboardInput(Context context) {
            super(context);
            init(context);
        }
    }

    public class VirtualKeyboardInput extends EditText {
        private EmojiExcludeFilter emojiExcludeFilter;

        public class EmojiExcludeFilter implements InputFilter {
            private EmojiExcludeFilter() {
            }

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }

        public class VirtualKeyboardInputConnection extends InputConnectionWrapper {
            public VirtualKeyboardInput owner;

            public VirtualKeyboardInputConnection(InputConnection inputConnection, boolean z, VirtualKeyboardInput virtualKeyboardInput) {
                super(inputConnection, z);
                this.owner = virtualKeyboardInput;
            }

            private void replaceSubstring(String str) {
                StringBuffer stringBuffer = new StringBuffer(this.owner.getText().toString());
                int selectionStart = this.owner.getSelectionStart();
                int selectionEnd = this.owner.getSelectionEnd();
                int iMin = Math.min(selectionStart, selectionEnd);
                int iMax = Math.max(selectionStart, selectionEnd);
                if (iMin != iMax) {
                    stringBuffer.replace(iMin, iMax, str);
                } else if (str.length() > 0) {
                    stringBuffer.insert(iMin, str);
                } else if (iMin > 0) {
                    BreakIterator characterInstance = BreakIterator.getCharacterInstance();
                    characterInstance.setText(this.owner.getText().toString());
                    int iPreceding = characterInstance.preceding(iMin);
                    iMin = iPreceding == -1 ? 0 : iPreceding;
                    stringBuffer.replace(iMin, iMax, "");
                }
                if (str.length() == 0) {
                    iMin--;
                }
                this.owner.getText().clear();
                this.owner.append(stringBuffer.toString());
                this.owner.setSelection(iMin + 1);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int i, int i2) {
                return (i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean sendKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return true;
                }
                if (keyEvent.getKeyCode() >= 7 && keyEvent.getKeyCode() <= 16) {
                    replaceSubstring(String.valueOf((char) ((keyEvent.getKeyCode() - 7) + 48)));
                    return true;
                }
                if (keyEvent.getKeyCode() >= 144 && keyEvent.getKeyCode() <= 153) {
                    replaceSubstring(String.valueOf((char) ((keyEvent.getKeyCode() - CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA) + 48)));
                    return true;
                }
                if (keyEvent.getKeyCode() == 67) {
                    replaceSubstring("");
                    return true;
                }
                if (keyEvent.getKeyCode() != 66) {
                    return true;
                }
                if ((VirtualKeyboardInput.this.getInputType() & 131072) != 0) {
                    replaceSubstring(IOUtils.LINE_SEPARATOR_UNIX);
                    return true;
                }
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(66);
                return true;
            }
        }

        public VirtualKeyboardInput(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init();
        }

        private void init() {
            if (this.emojiExcludeFilter == null) {
                this.emojiExcludeFilter = new EmojiExcludeFilter();
            }
        }

        @Override // android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return new VirtualKeyboardInputConnection(super.onCreateInputConnection(editorInfo), true, this);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(4);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.widget.TextView
        public void onSelectionChanged(int i, int i2) {
            GameActivity.this.nativeVirtualKeyboardSendSelection(i, i2);
        }

        @Override // android.widget.TextView
        public void setFilters(InputFilter[] inputFilterArr) {
            if (inputFilterArr.length != 0 && this.emojiExcludeFilter != null) {
                int length = inputFilterArr.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (inputFilterArr[i] == this.emojiExcludeFilter) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    inputFilterArr = (InputFilter[]) Arrays.copyOf(inputFilterArr, inputFilterArr.length + 1);
                    inputFilterArr[inputFilterArr.length - 1] = this.emojiExcludeFilter;
                }
            }
            super.setFilters(inputFilterArr);
        }

        public VirtualKeyboardInput(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init();
        }

        public VirtualKeyboardInput(Context context) {
            super(context);
            init();
        }
    }
}
