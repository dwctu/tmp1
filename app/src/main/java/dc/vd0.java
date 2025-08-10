package dc;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: FileUtils.java */
/* loaded from: classes.dex */
public final class vd0 {

    /* compiled from: FileUtils.java */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    static {
        System.getProperty("line.separator");
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(String str) {
        return b(l(str));
    }

    public static boolean d(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? h(file) : i(file);
    }

    public static boolean e(String str) {
        return d(l(str));
    }

    public static boolean f(File file) {
        return j(file, new a());
    }

    public static boolean g(String str) {
        return f(l(str));
    }

    public static boolean h(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !h(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean i(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean j(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !h(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static long k(File file) {
        long jK = 0;
        if (!q(file)) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jK += file2.isDirectory() ? k(file2) : file2.length();
            }
        }
        return jK;
    }

    public static File l(String str) {
        if (xe0.K(str)) {
            return null;
        }
        return new File(str);
    }

    public static long m(File file) {
        if (r(file)) {
            return file.length();
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0046: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:28:0x0046 */
    public static byte[] n(File file) throws Throwable {
        DigestInputStream digestInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (file == null) {
            return null;
        }
        try {
            try {
                digestInputStream = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
            } catch (IOException e) {
                e = e;
                digestInputStream = null;
                e.printStackTrace();
                xe0.d(digestInputStream);
                return null;
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                digestInputStream = null;
                e.printStackTrace();
                xe0.d(digestInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                xe0.d(closeable2);
                throw th;
            }
            try {
                while (digestInputStream.read(new byte[262144]) > 0) {
                }
                byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                xe0.d(digestInputStream);
                return bArrDigest;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                xe0.d(digestInputStream);
                return null;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                e.printStackTrace();
                xe0.d(digestInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            xe0.d(closeable2);
            throw th;
        }
    }

    public static String o(File file) {
        return xe0.c(n(file));
    }

    public static long p(File file) {
        if (file == null) {
            return 0L;
        }
        return file.isDirectory() ? k(file) : m(file);
    }

    public static boolean q(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean r(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean s(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return t(file.getAbsolutePath());
    }

    public static boolean t(String str) {
        File fileL = l(str);
        if (fileL == null) {
            return false;
        }
        if (fileL.exists()) {
            return true;
        }
        return u(str);
    }

    public static boolean u(String str) throws IOException {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = ve0.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), StreamManagement.AckRequest.ELEMENT);
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static List<File> v(File file, FileFilter fileFilter) {
        return w(file, fileFilter, false, null);
    }

    public static List<File> w(File file, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        List<File> listY = y(file, fileFilter, z);
        if (comparator != null) {
            Collections.sort(listY, comparator);
        }
        return listY;
    }

    public static List<File> x(String str, FileFilter fileFilter) {
        return v(l(str), fileFilter);
    }

    public static List<File> y(File file, FileFilter fileFilter, boolean z) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (q(file) && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z && file2.isDirectory()) {
                    arrayList.addAll(y(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }
}
