package dc;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: FileIOUtils.java */
/* loaded from: classes.dex */
public final class ud0 {
    public static int a = 524288;

    /* compiled from: FileIOUtils.java */
    public interface a {
        void a(double d);
    }

    public static byte[] a(File file) {
        return b(file, null);
    }

    public static byte[] b(File file, a aVar) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!xe0.G(file)) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), a);
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    xe0.d(bufferedInputStream);
                    xe0.d(null);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[a];
                    if (aVar != null) {
                        double dAvailable = bufferedInputStream.available();
                        aVar.a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        int i = 0;
                        while (true) {
                            int i2 = bufferedInputStream.read(bArr, 0, a);
                            if (i2 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                            i += i2;
                            aVar.a(i / dAvailable);
                        }
                    } else {
                        while (true) {
                            int i3 = bufferedInputStream.read(bArr, 0, a);
                            if (i3 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i3);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    xe0.d(bufferedInputStream);
                    xe0.d(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    xe0.d(bufferedInputStream);
                    xe0.d(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                xe0.d(bufferedInputStream);
                xe0.d(null);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String c(File file, String str) {
        byte[] bArrA = a(file);
        if (bArrA == null) {
            return null;
        }
        if (xe0.K(str)) {
            return new String(bArrA);
        }
        try {
            return new String(bArrA, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d(String str, String str2) {
        return c(xe0.q(str), str2);
    }

    public static boolean e(File file, String str, boolean z) throws Throwable {
        if (file == null || str == null) {
            return false;
        }
        if (!xe0.f(file)) {
            String str2 = "create file <" + file + "> failed.";
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
                try {
                    bufferedWriter2.write(str);
                    xe0.d(bufferedWriter2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    xe0.d(bufferedWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    xe0.d(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static boolean f(String str, String str2, boolean z) {
        return e(xe0.q(str), str2, z);
    }
}
