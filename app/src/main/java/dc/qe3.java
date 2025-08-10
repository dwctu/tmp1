package dc;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.util.WearUtils;
import io.agora.rtc2.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: ImageCompressUtils.java */
/* loaded from: classes4.dex */
public class qe3 {
    public static File a;
    public static File b;

    /* compiled from: ImageCompressUtils.java */
    public static class a {
        public a() {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        }
    }

    public qe3() {
        File fileE0 = WearUtils.e0("camera.jpg");
        a = fileE0;
        Uri.fromFile(fileE0);
        b = WearUtils.e0("temporarydocument");
    }

    public static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 500) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(android.content.Context r8, android.net.Uri r9) throws java.io.IOException {
        /*
            android.content.ContentResolver r0 = r8.getContentResolver()
            java.io.InputStream r0 = r0.openInputStream(r9)
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r2 = 1
            r1.inJustDecodeBounds = r2
            r1.inDither = r2
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            r1.inPreferredConfig = r3
            r3 = 0
            android.graphics.BitmapFactory.decodeStream(r0, r3, r1)
            r0.close()
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            r4 = -1
            if (r0 == r4) goto L64
            if (r1 != r4) goto L27
            goto L64
        L27:
            r4 = 1156579328(0x44f00000, float:1920.0)
            r5 = 1149698048(0x44870000, float:1080.0)
            if (r0 <= r1) goto L35
            float r6 = (float) r0
            int r7 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r7 <= 0) goto L35
            float r6 = r6 / r5
            int r0 = (int) r6
            goto L40
        L35:
            if (r0 >= r1) goto L3f
            float r0 = (float) r1
            int r1 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r1 <= 0) goto L3f
            float r0 = r0 / r4
            int r0 = (int) r0
            goto L40
        L3f:
            r0 = 1
        L40:
            if (r0 > 0) goto L43
            r0 = 1
        L43:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r1.inSampleSize = r0
            r1.inDither = r2
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r1.inPreferredConfig = r0
            android.content.ContentResolver r8 = r8.getContentResolver()
            java.io.InputStream r8 = r8.openInputStream(r9)
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r8, r3, r1)
            r8.close()
            android.graphics.Bitmap r8 = a(r9)
            return r8
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.qe3.b(android.content.Context, android.net.Uri):android.graphics.Bitmap");
    }

    public static String c(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursorQuery;
        String[] strArr2 = {"_data"};
        try {
            cursorQuery = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(strArr2[0]));
                }
                return null;
            } catch (Exception unused) {
                if (cursorQuery == null) {
                    return null;
                }
                cursorQuery.close();
                return null;
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    public static String e(Context context, Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        String authority = uri.getAuthority();
        ?? r1 = 0;
        try {
            if (authority != null) {
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                } catch (FileNotFoundException e) {
                    e = e;
                    inputStreamOpenInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        r1.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
                try {
                    try {
                        String string = r(context, BitmapFactory.decodeStream(inputStreamOpenInputStream)).toString();
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return string;
                    } catch (Exception unused) {
                        String strC = c(context, uri, null, null);
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        return strC;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    e.printStackTrace();
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r1 = authority;
        }
    }

    public static String f(Context context, Uri uri) {
        return Build.VERSION.SDK_INT >= 19 ? h(context, uri) : j(context, uri);
    }

    public static String g(Context context, Uri uri, Bitmap bitmap) throws IOException {
        String strF = f(context, uri);
        if (strF != null) {
            return strF;
        }
        try {
            if (!a.exists()) {
                a.getParentFile().mkdirs();
                a.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(a);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return a.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return strF;
        }
    }

    @SuppressLint({"NewApi"})
    public static String h(Context context, Uri uri) {
        String strC;
        if (l(uri)) {
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(SignatureImpl.INNER_SEP);
            if (!"primary".equalsIgnoreCase(strArrSplit[0])) {
                return null;
            }
            return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (o(uri)) {
                strC = c(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(SignatureImpl.INNER_SEP)[1]});
            } else {
                if (!k(uri)) {
                    return null;
                }
                try {
                    if (documentId.startsWith("raw:")) {
                        documentId.replaceFirst("raw:", "");
                    }
                    strC = c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                } catch (NumberFormatException e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                    return null;
                }
            }
            return strC;
        }
        if (!FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            if ("file".equals(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            xe3.a("ChatActivity", "google相册获取路径异常，开始尝试普通路径获取");
        }
        if (m(uri)) {
            return uri.getLastPathSegment();
        }
        if (n(uri)) {
            return e(context, uri);
        }
        return c(context, uri, null, null);
    }

    public static String i(Context context, Uri uri) {
        String strF = f(context, uri);
        if (strF == null) {
            try {
                if (!b.exists()) {
                    b.getParentFile().mkdirs();
                    b.createNewFile();
                }
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (-1 == i) {
                        FileOutputStream fileOutputStream = new FileOutputStream(b);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        fileOutputStream.write(byteArray, 0, byteArray.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return b.getAbsolutePath();
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strF;
    }

    public static String j(Context context, Uri uri) {
        return c(context, uri, null, null);
    }

    public static boolean k(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean l(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean m(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean n(Uri uri) {
        return "com.google.android.apps.photos.contentprovider".equals(uri.getAuthority());
    }

    public static boolean o(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static int p(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return Constants.VIDEO_ORIENTATION_270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap q(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        System.out.println("angle2=" + i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Uri r(Context context, Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        return Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", (String) null));
    }

    public String d(Context context, Uri uri) {
        if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
            } finally {
                cursorQuery.close();
            }
        }
        return "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : string;
    }
}
