package dc;

import com.broadcom.bt.util.io.IOUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: ZipUtils.java */
/* loaded from: classes.dex */
public final class ze0 {
    public static boolean a(File file, String str, ZipOutputStream zipOutputStream, String str2) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(xe0.K(str) ? "" : File.separator);
        sb.append(file.getName());
        String string = sb.toString();
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (!a(file2, string, zipOutputStream, str2)) {
                        return false;
                    }
                }
                return true;
            }
            ZipEntry zipEntry = new ZipEntry(string + IOUtils.DIR_SEPARATOR_UNIX);
            zipEntry.setComment(str2);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();
            return true;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                ZipEntry zipEntry2 = new ZipEntry(string);
                zipEntry2.setComment(str2);
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = bufferedInputStream2.read(bArr, 0, 8192);
                    if (i == -1) {
                        zipOutputStream.closeEntry();
                        bufferedInputStream2.close();
                        return true;
                    }
                    zipOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b(Collection<File> collection, File file) throws IOException {
        return c(collection, file, null);
    }

    public static boolean c(Collection<File> collection, File file, String str) throws Throwable {
        ZipOutputStream zipOutputStream;
        if (collection == null || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Iterator<File> it = collection.iterator();
            while (it.hasNext()) {
                if (!a(it.next(), "", zipOutputStream, str)) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    return false;
                }
            }
            zipOutputStream.finish();
            zipOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.finish();
                zipOutputStream2.close();
            }
            throw th;
        }
    }
}
