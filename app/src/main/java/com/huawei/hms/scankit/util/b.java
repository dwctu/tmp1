package com.huawei.hms.scankit.util;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public class b {
    private static String a;
    private static String b;

    public static boolean a(int[][] iArr, int i) {
        return i >= 0 && i < iArr.length;
    }

    public static int b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == HmsScanBase.QRCODE_SCAN_TYPE) {
            return 256;
        }
        if (i == HmsScanBase.AZTEC_SCAN_TYPE) {
            return 4096;
        }
        if (i == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
            return 16;
        }
        if (i == HmsScanBase.PDF417_SCAN_TYPE) {
            return 2048;
        }
        if (i == HmsScanBase.CODE39_SCAN_TYPE) {
            return 2;
        }
        if (i == HmsScanBase.CODE93_SCAN_TYPE) {
            return 4;
        }
        if (i == HmsScanBase.CODE128_SCAN_TYPE) {
            return 1;
        }
        if (i == HmsScanBase.EAN13_SCAN_TYPE) {
            return 32;
        }
        if (i == HmsScanBase.EAN8_SCAN_TYPE) {
            return 64;
        }
        if (i == HmsScanBase.ITF14_SCAN_TYPE) {
            return 128;
        }
        if (i == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
            return 512;
        }
        if (i == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return 1024;
        }
        if (i == HmsScanBase.CODABAR_SCAN_TYPE) {
            return 8;
        }
        return i;
    }

    public static boolean c(Context context) {
        if (b(context) && TextUtils.isEmpty(b)) {
            b = context.getSharedPreferences("scanExt", 0).getString("scanExt", "unSet");
        }
        return "forbid".equals(b);
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean e(Context context) {
        try {
            return "CN".equalsIgnoreCase(SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean a(int[] iArr, int i) {
        return i >= 0 && i < iArr.length;
    }

    public static boolean a(byte[] bArr, int i) {
        return i >= 0 && i < bArr.length;
    }

    public static boolean a(byte[][] bArr, int i) {
        return i >= 0 && i < bArr.length;
    }

    public static boolean a(String[] strArr, int i) {
        return i >= 0 && i < strArr.length;
    }

    public static boolean c(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public static boolean a(float[] fArr, int i) {
        return i >= 0 && i < fArr.length;
    }

    public static HmsScan[] a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null && hmsScanArr.length != 0) {
            for (int i = 0; i < hmsScanArr.length; i++) {
                if (hmsScanArr[i] != null) {
                    hmsScanArr[i].scanType = b(hmsScanArr[i].scanType);
                }
            }
        }
        return hmsScanArr;
    }

    public static int a(int i) {
        if (i <= 0 || i >= 8192) {
            return 0;
        }
        if (((i - 1) & i) == 0) {
            return i;
        }
        int i2 = HmsScanBase.AZTEC_SCAN_TYPE;
        int iB = (i & i2) != 0 ? 0 | b(i2) : 0;
        int i3 = HmsScanBase.CODABAR_SCAN_TYPE;
        if ((i & i3) != 0) {
            iB |= b(i3);
        }
        int i4 = HmsScanBase.CODE39_SCAN_TYPE;
        if ((i & i4) != 0) {
            iB |= b(i4);
        }
        int i5 = HmsScanBase.CODE93_SCAN_TYPE;
        if ((i & i5) != 0) {
            iB |= b(i5);
        }
        int i6 = HmsScanBase.CODE128_SCAN_TYPE;
        if ((i & i6) != 0) {
            iB |= b(i6);
        }
        int i7 = HmsScanBase.DATAMATRIX_SCAN_TYPE;
        if ((i & i7) != 0) {
            iB |= b(i7);
        }
        int i8 = HmsScanBase.EAN8_SCAN_TYPE;
        if ((i & i8) != 0) {
            iB |= b(i8);
        }
        int i9 = HmsScanBase.EAN13_SCAN_TYPE;
        if ((i & i9) != 0) {
            iB |= b(i9);
        }
        int i10 = HmsScanBase.QRCODE_SCAN_TYPE;
        if ((i & i10) != 0) {
            iB |= b(i10);
        }
        int i11 = HmsScanBase.ITF14_SCAN_TYPE;
        if ((i & i11) != 0) {
            iB |= b(i11);
        }
        int i12 = HmsScanBase.PDF417_SCAN_TYPE;
        if ((i & i12) != 0) {
            iB |= b(i12);
        }
        int i13 = HmsScanBase.UPCCODE_A_SCAN_TYPE;
        if ((i & i13) != 0) {
            iB |= b(i13);
        }
        int i14 = HmsScanBase.UPCCODE_E_SCAN_TYPE;
        return (i & i14) != 0 ? iB | b(i14) : iB;
    }

    public static boolean b(Activity activity) {
        return a(activity) == 102;
    }

    public static boolean b(Context context) {
        if (TextUtils.isEmpty(a)) {
            try {
                a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("scanExt", "unSet");
            } catch (PackageManager.NameNotFoundException | Exception unused) {
            }
        }
        return "readUri".equals(a);
    }

    private static String b(Context context, Intent intent) {
        Uri data = new Intent(intent).getData();
        if (Build.VERSION.SDK_INT > 19) {
            if (DocumentsContract.isDocumentUri(context, data)) {
                String documentId = DocumentsContract.getDocumentId(data);
                if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                    return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(SignatureImpl.INNER_SEP)[1]);
                }
                if (!"com.android.providers.downloads.documents".equals(data.getAuthority())) {
                    return null;
                }
                try {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), (String) null);
                } catch (NumberFormatException unused) {
                    a.b("ScankitUtils", "NumberFormatException in withAppendedId");
                    return null;
                } catch (Exception unused2) {
                    a.b("ScankitUtils", "Exception in withAppendedId");
                    return null;
                }
            }
            if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(data.getScheme())) {
                return a(context, data, (String) null);
            }
            return null;
        }
        return a(context, data, (String) null);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        return a(bitmap, i / bitmap.getWidth(), i2 / bitmap.getHeight());
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        float f3 = 1.0f / f;
        float f4 = 1.0f / f2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (int) (width * f);
        int i2 = (int) (height * f2);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i * i2];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[(i3 * i) + i4] = iArr[(((int) (i3 * f4)) * width) + ((int) (i4 * f3))];
            }
        }
        String str = "dstPixels:" + i + " x " + i2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
        return bitmapCreateBitmap;
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == -1 ? -1 : 0;
    }

    public static String a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    public static boolean a(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        String str;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class);
            Object[] objArr = new Object[1];
            objArr[0] = "qemu.hw.mainkeys";
            str = (String) method.invoke(cls, objArr);
        } catch (Exception unused) {
            a.c("Uuils", "checkDeviceHasNavigationBar Exception");
        }
        if ("1".equals(str)) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        return z;
    }

    public static ResolveInfo a(Intent intent, String str, Activity activity) {
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.isEmpty()) {
            return null;
        }
        return listQueryIntentActivities.get(0);
    }

    public static int a(Activity activity) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActivityManagerEx");
            Method declaredMethod = cls.getDeclaredMethod("getActivityWindowMode", Activity.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(cls, activity);
            if (objInvoke == null) {
                return -1;
            }
            return Integer.valueOf(String.valueOf(objInvoke)).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NumberFormatException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f, width / 2, height / 2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!bitmapCreateBitmap.equals(bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0) {
            return a(bitmap, 90.0f);
        }
        if (i != 2) {
            return i != 3 ? bitmap : a(bitmap, 180.0f);
        }
        return a(bitmap, 270.0f);
    }

    public static Bitmap a(Context context, Intent intent) {
        Bitmap bitmapA;
        Bitmap bitmapCompressBitmap;
        if (!b(context)) {
            String strB = b(context, intent);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            if (Build.VERSION.SDK_INT > 28 && context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion > 28) {
                a.a("ScanBitmap", "compressBitmap above android 29");
                bitmapCompressBitmap = ScanUtil.compressBitmapForAndroid29(context, strB);
            } else {
                a.a("ScanBitmap", "compressBitmap below android 29");
                bitmapCompressBitmap = ScanUtil.compressBitmap(context, strB);
            }
            if (bitmapCompressBitmap != null) {
                return bitmapCompressBitmap;
            }
            a.a("ScanBitmap", "compressBitmap above android 29");
            return ScanUtil.compressBitmapForAndroid29(context, strB);
        }
        Uri data = intent.getData();
        if (data == null || (bitmapA = a(context, data)) == null) {
            return null;
        }
        return bitmapA;
    }

    private static String a(Context context, Uri uri, String str) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, null, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
                cursorQuery.close();
            }
            return string;
        } catch (IllegalStateException unused) {
            a.b("ScankitUtils", "IllegalStateException in getImagePath");
            return null;
        } catch (Exception unused2) {
            a.b("ScankitUtils", "Exception in getImagePath");
            return null;
        }
    }

    public static Bitmap a(Context context, Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            try {
                inputStreamOpenInputStream = context.getApplicationContext().getContentResolver().openInputStream(uri);
            } catch (IOException unused) {
                inputStreamOpenInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStreamOpenInputStream == null) {
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            return null;
        }
        try {
            byte[] bArrA = a(inputStreamOpenInputStream);
            BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
            a(context, options);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length, options);
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return bitmapDecodeByteArray;
        } catch (IOException unused2) {
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r10, android.graphics.BitmapFactory.Options r11) {
        /*
            java.lang.String r0 = "exception"
            int r1 = r11.outWidth
            int r2 = r11.outHeight
            if (r1 == 0) goto L65
            if (r2 != 0) goto Lb
            goto L65
        Lb:
            if (r1 <= r2) goto Le
            r1 = r2
        Le:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L46
            java.lang.String r2 = "activity"
            java.lang.Object r10 = r10.getSystemService(r2)     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            android.app.ActivityManager r10 = (android.app.ActivityManager) r10     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            r2.<init>()     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            r10.getMemoryInfo(r2)     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            r6 = 4652218415073722368(0x4090000000000000, double:1024.0)
            r8 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r6 = java.lang.Math.pow(r6, r8)     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            long r2 = r2.totalMem     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            double r2 = (double) r2
            double r2 = r2 / r6
            r6 = 4617878467915022336(0x4016000000000000, double:5.5)
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 >= 0) goto L39
            goto L46
        L39:
            r10 = 0
            goto L47
        L3b:
            java.lang.String r10 = "Exception"
            com.huawei.hms.scankit.util.a.b(r0, r10)
            goto L46
        L41:
            java.lang.String r10 = "NullPointerException"
            com.huawei.hms.scankit.util.a.b(r0, r10)
        L46:
            r10 = 1
        L47:
            if (r10 == 0) goto L4c
            r10 = 1200(0x4b0, float:1.682E-42)
            goto L4e
        L4c:
            r10 = 3000(0xbb8, float:4.204E-42)
        L4e:
            if (r1 <= r10) goto L58
            float r0 = (float) r1
            float r10 = (float) r10
            float r0 = r0 / r10
            int r10 = java.lang.Math.round(r0)
            goto L59
        L58:
            r10 = 1
        L59:
            r11.inSampleSize = r10
            r11.inJustDecodeBounds = r4
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            r11.inPreferredConfig = r10
            r11.inPurgeable = r5
            r11.inInputShareable = r5
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.util.b.a(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }
}
