package dc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: ZipUtil.java */
/* loaded from: classes4.dex */
public class hh3 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String a(java.lang.String r8) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            r1 = 0
            byte[] r8 = android.util.Base64.decode(r8, r1)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L62
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L62
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L46
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L46
            java.util.zip.ZipInputStream r8 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L41
            r8.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L41
            r8.getNextEntry()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
        L1f:
            int r5 = r8.read(r4)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r6 = -1
            if (r5 == r6) goto L2a
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            goto L1f
        L2a:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r8.close()     // Catch: java.io.IOException -> L31
        L31:
            r3.close()     // Catch: java.io.IOException -> L34
        L34:
            r2.close()     // Catch: java.io.IOException -> L76
            goto L76
        L38:
            r0 = move-exception
            goto L4e
        L3a:
            goto L65
        L3c:
            r8 = move-exception
            r7 = r0
            r0 = r8
            r8 = r7
            goto L4e
        L41:
            r8 = r0
            goto L65
        L43:
            r8 = move-exception
            r3 = r0
            goto L4c
        L46:
            r8 = r0
            r3 = r8
            goto L65
        L49:
            r8 = move-exception
            r2 = r0
            r3 = r2
        L4c:
            r0 = r8
            r8 = r3
        L4e:
            if (r8 == 0) goto L55
            r8.close()     // Catch: java.io.IOException -> L54
            goto L55
        L54:
        L55:
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.io.IOException -> L5b
            goto L5c
        L5b:
        L5c:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L61
        L61:
            throw r0
        L62:
            r8 = r0
            r2 = r8
            r3 = r2
        L65:
            if (r8 == 0) goto L6c
            r8.close()     // Catch: java.io.IOException -> L6b
            goto L6c
        L6b:
        L6c:
            if (r3 == 0) goto L73
            r3.close()     // Catch: java.io.IOException -> L72
            goto L73
        L72:
        L73:
            if (r2 == 0) goto L76
            goto L34
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.hh3.a(java.lang.String):java.lang.String");
    }

    public static void b(File file, File file2, boolean z) throws Exception {
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement.isDirectory()) {
                new File(new String(zipEntryNextElement.getName().getBytes("8859_1"), "GB2312")).mkdir();
            } else {
                InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                File file3 = new File(new String((file2.getAbsolutePath() + File.separator + zipEntryNextElement.getName()).getBytes("8859_1"), "GB2312"));
                if (!file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
                inputStream.close();
                fileOutputStream.close();
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static void c(File file, ZipOutputStream zipOutputStream, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String str2 = new String(sb.toString().getBytes("8859_1"), "GB2312");
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                c(file2, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i == -1) {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, i);
        }
    }

    public static void d(Collection<File> collection, File file) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        Iterator<File> it = collection.iterator();
        while (it.hasNext()) {
            c(it.next(), zipOutputStream, "");
        }
        zipOutputStream.close();
    }
}
