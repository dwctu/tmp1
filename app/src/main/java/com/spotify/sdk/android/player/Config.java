package com.spotify.sdk.android.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import java.io.File;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class Config {
    private static final int CACHE_AGE_LIMIT_IN_SECONDS = 604800;
    private static final int CACHE_SIZE_LIMIT_IN_MEGABYTES = 1024;
    private static final char CONFIG_STRING_REPLACEMENT_CHAR = '_';
    private static final String FALLBACK_DISPLAY_NAME = Build.MODEL;
    public static final String IN_FIELD_SEPARATOR = "_";
    private static final int MAX_BRAND_NAME_LENGTH = 32;
    private static final int MAX_CLIENT_ID_LENGTH = 32;
    private static final int MAX_DISPLAY_NAME_LENGTH = 64;
    private static final int MAX_MODEL_NAME_LENGTH = 30;
    private static final int MAX_OS_VERSION_LENGTH = 30;
    private static final String TAG = "com.spotify.sdk.android.player.Config";
    public final String brandName;
    public final int cacheAgeLimitInSeconds;
    public final String cachePath;
    public final int cacheSizeLimitInMegabytes;
    public final String clientId;
    private final int deviceTypeIndex;
    public String displayName;
    private boolean mShouldUseCache;
    public final String modelName;
    public final String oauthToken;
    public final String osVersion;
    public final String uniqueId;

    public static abstract class DeviceType {
        public static final DeviceType UNKNOWN = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.1
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 0;
            }
        };
        public static final DeviceType COMPUTER = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.2
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 1;
            }
        };
        public static final DeviceType TABLET = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.3
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 2;
            }
        };
        public static final DeviceType SMARTPHONE = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.4
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 3;
            }
        };
        public static final DeviceType SPEAKER = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.5
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 4;
            }
        };
        public static final DeviceType TV = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.6
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 5;
            }
        };
        public static final DeviceType AVR = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.7
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 6;
            }
        };
        public static final DeviceType STB = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.8
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 7;
            }
        };
        public static final DeviceType DONGLE = new DeviceType() { // from class: com.spotify.sdk.android.player.Config.DeviceType.9
            @Override // com.spotify.sdk.android.player.Config.DeviceType
            public int getTypeIndex() {
                return 8;
            }
        };

        public abstract int getTypeIndex();
    }

    public Config(Context context, String str, String str2) {
        this(context, str, str2, DeviceType.UNKNOWN);
    }

    private String convertConfigString(String str, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length() && i2 < i; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '-' && cCharAt != '_' && cCharAt != '.' && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < '0' || cCharAt > '9')))) {
                cCharAt = CONFIG_STRING_REPLACEMENT_CHAR;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    @TargetApi(21)
    private String createOsVersionString() {
        StringBuilder sb = new StringBuilder(Build.VERSION.RELEASE);
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                sb.append(IN_FIELD_SEPARATOR);
                sb.append(strArr[0]);
            }
        }
        return convertConfigString(sb.toString(), 30).toLowerCase(Locale.US);
    }

    private String getApplicationName(Context context) {
        int i = context.getApplicationInfo().labelRes;
        return i > 0 ? context.getString(i) : FALLBACK_DISPLAY_NAME;
    }

    private String getWritableCacheDirectory(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null || !isExternalStorageWritable()) {
            return null;
        }
        if ((externalFilesDir.isDirectory() && externalFilesDir.canWrite()) || externalFilesDir.mkdirs() || (externalFilesDir.isDirectory() && externalFilesDir.canWrite())) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    private boolean internetPermissionGranted(Context context) {
        return context.getPackageManager().checkPermission("android.permission.INTERNET", context.getPackageName()) == 0;
    }

    private boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private boolean isValidClientId(String str) {
        return str != null && str.matches("^[0-9a-fA-F]+$");
    }

    public boolean shouldUseCache() {
        return this.mShouldUseCache;
    }

    public void useCache(boolean z) {
        this.mShouldUseCache = z;
    }

    public Config(Context context, String str, String str2, DeviceType deviceType) {
        this.cacheSizeLimitInMegabytes = 1024;
        this.cacheAgeLimitInSeconds = CACHE_AGE_LIMIT_IN_SECONDS;
        this.mShouldUseCache = true;
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        if (!isValidClientId(str2)) {
            throw new IllegalArgumentException("Invalid client ID passed to Config object");
        }
        internetPermissionGranted(context);
        this.oauthToken = str;
        this.uniqueId = Settings.Secure.getString(context.getContentResolver(), "android_id");
        this.displayName = convertConfigString(getApplicationName(context), 64);
        String strConvertConfigString = convertConfigString(Build.MANUFACTURER, 32);
        Locale locale = Locale.US;
        this.brandName = strConvertConfigString.toUpperCase(locale);
        this.modelName = convertConfigString(Build.MODEL, 30).toLowerCase(locale);
        this.deviceTypeIndex = deviceType.getTypeIndex();
        this.cachePath = getWritableCacheDirectory(context);
        this.clientId = convertConfigString(str2, 32);
        this.osVersion = createOsVersionString();
    }
}
