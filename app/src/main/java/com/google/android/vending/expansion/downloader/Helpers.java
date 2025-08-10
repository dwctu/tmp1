package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import dc.he;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Helpers {
    public static final int FS_CANNOT_READ = 2;
    public static final int FS_DOES_NOT_EXIST = 1;
    public static final int FS_READABLE = 0;
    public static Random sRandom = new Random(SystemClock.uptimeMillis());
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    private Helpers() {
    }

    public static boolean canWriteOBBFile(Context context) {
        File file = new File(getSaveFilePath(context));
        return file.exists() ? file.isDirectory() && file.canWrite() : file.mkdirs();
    }

    public static void deleteFile(String str) {
        try {
            new File(str).delete();
        } catch (Exception unused) {
            String str2 = "file: '" + str + "' couldn't be deleted";
        }
    }

    public static boolean doesFileExist(Context context, String str, long j, boolean z) {
        return doesFileExistInternal(context, new File(generateSaveFileName(context, str)), j, z);
    }

    public static boolean doesFileExistDev(Context context, String str, long j, boolean z) {
        return doesFileExistInternal(context, new File(generateSaveFileNameDevelopment(context, str)), j, z);
    }

    public static boolean doesFileExistInternal(Context context, File file, long j, boolean z) {
        if (!file.exists()) {
            return false;
        }
        if (j == 0 || file.length() == j) {
            return true;
        }
        if (!z) {
            return false;
        }
        file.delete();
        return false;
    }

    public static String generateSaveFileName(Context context, String str) {
        return getSaveFilePath(context) + File.separator + str;
    }

    public static String generateSaveFileNameDevelopment(Context context, String str) {
        return getSaveFilePathDevelopment(context) + File.separator + str;
    }

    public static long getAvailableBytes(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
    }

    public static String getDownloadProgressPercent(long j, long j2) {
        if (j2 == 0) {
            return "";
        }
        return Long.toString((j * 100) / j2) + "%";
    }

    public static String getDownloadProgressString(long j, long j2) {
        if (j2 == 0) {
            return "";
        }
        return String.format("%.2f", Float.valueOf(j / 1048576.0f)) + "MB /" + String.format("%.2f", Float.valueOf(j2 / 1048576.0f)) + "MB";
    }

    public static String getDownloadProgressStringNotification(long j, long j2) {
        if (j2 == 0) {
            return "";
        }
        return getDownloadProgressString(j, j2) + " (" + getDownloadProgressPercent(j, j2) + ")";
    }

    public static int getDownloaderStringResourceIDFromState(int i) {
        switch (i) {
            case 1:
                return he.state_idle;
            case 2:
                return he.state_fetching_url;
            case 3:
                return he.state_connecting;
            case 4:
                return he.state_downloading;
            case 5:
                return he.state_completed;
            case 6:
                return he.state_paused_network_unavailable;
            case 7:
                return he.state_paused_by_request;
            case 8:
                return he.state_paused_wifi_disabled;
            case 9:
                return he.state_paused_wifi_unavailable;
            case 10:
                return he.state_paused_wifi_disabled;
            case 11:
                return he.state_paused_wifi_unavailable;
            case 12:
                return he.state_paused_roaming;
            case 13:
                return he.state_paused_network_setup_failure;
            case 14:
                return he.state_paused_sdcard_unavailable;
            case 15:
                return he.state_failed_unlicensed;
            case 16:
                return he.state_failed_fetching_url;
            case 17:
                return he.state_failed_sdcard_full;
            case 18:
                return he.state_failed_cancelled;
            default:
                return he.state_unknown;
        }
    }

    public static String getExpansionAPKFileName(Context context, boolean z, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "main." : "patch.");
        sb.append(str);
        sb.append(".");
        sb.append(context.getPackageName());
        sb.append(str2);
        sb.append(".obb");
        return sb.toString();
    }

    public static int getFileStatus(Context context, String str) {
        File file = new File(generateSaveFileName(context, str));
        if (file.exists()) {
            return file.canRead() ? 0 : 2;
        }
        return 1;
    }

    public static File getFilesystemRoot(String str) {
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (str.startsWith(downloadCacheDirectory.getPath())) {
            return downloadCacheDirectory;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith(externalStorageDirectory.getPath())) {
            return externalStorageDirectory;
        }
        throw new IllegalArgumentException("Cannot determine filesystem root for " + str);
    }

    public static String getSaveFilePath(Context context) {
        return Environment.getExternalStorageDirectory().toString() + Constants.EXP_PATH + context.getPackageName();
    }

    public static String getSaveFilePathDevelopment(Context context) {
        return Environment.getExternalStorageDirectory().toString() + Constants.EXP_PATH_DEV + context.getPackageName();
    }

    public static String getSpeedString(float f) {
        return String.format("%.2f", Float.valueOf((f * 1000.0f) / 1024.0f));
    }

    public static String getTimeRemaining(long j) {
        return (j > 3600000 ? new SimpleDateFormat("HH:mm", Locale.getDefault()) : new SimpleDateFormat("mm:ss", Locale.getDefault())).format(new Date(j - TimeZone.getDefault().getRawOffset()));
    }

    public static boolean isExternalMediaMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isFilenameValid(String str) {
        String strReplaceFirst = str.replaceFirst("/+", "/");
        return strReplaceFirst.startsWith(Environment.getDownloadCacheDirectory().toString()) || strReplaceFirst.startsWith(Environment.getExternalStorageDirectory().toString());
    }

    public static String parseContentDisposition(String str) {
        try {
            Matcher matcher = CONTENT_DISPOSITION_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
