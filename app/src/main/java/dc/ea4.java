package dc;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: FileUtils.java */
/* loaded from: classes5.dex */
public class ea4 {

    /* compiled from: FileUtils.java */
    public class a implements FilenameFilter {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.a + ".");
        }
    }

    public static void a(byte b, int i, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (da4.a(b, i)) {
            set.add(posixFilePermission);
        }
    }

    public static void b(Path path, byte[] bArr) throws IOException {
        if (bArr[2] == 0 && bArr[3] == 0) {
            return;
        }
        try {
            HashSet hashSet = new HashSet();
            a(bArr[3], 0, hashSet, PosixFilePermission.OWNER_READ);
            a(bArr[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
            a(bArr[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
            a(bArr[2], 5, hashSet, PosixFilePermission.GROUP_READ);
            a(bArr[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
            a(bArr[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
            a(bArr[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
            a(bArr[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
            a(bArr[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions(path, hashSet);
        } catch (IOException unused) {
        }
    }

    public static void c(Path path, byte[] bArr) throws IOException {
        DosFileAttributeView dosFileAttributeView;
        if (bArr[0] == 0 || (dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)) == null) {
            return;
        }
        try {
            dosFileAttributeView.setReadOnly(da4.a(bArr[0], 0));
            dosFileAttributeView.setHidden(da4.a(bArr[0], 1));
            dosFileAttributeView.setSystem(da4.a(bArr[0], 2));
            dosFileAttributeView.setArchive(da4.a(bArr[0], 5));
        } catch (IOException unused) {
        }
    }

    public static File[] d(File file) {
        File[] fileArrListFiles = file.getParentFile().listFiles(new a(f(file.getName())));
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles);
        return fileArrListFiles;
    }

    public static String e(File file) {
        String name = file.getName();
        return !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
    }

    public static String f(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public static boolean g() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean h(File file) {
        return file.getName().endsWith(".zip.001");
    }

    public static boolean i() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    public static boolean j() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static void k(Path path, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (j()) {
            c(path, bArr);
        } else if (g() || i()) {
            b(path, bArr);
        }
    }

    public static void l(Path path, long j) throws IOException {
        if (j <= 0 || !Files.exists(path, new LinkOption[0])) {
            return;
        }
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(ja4.f(j)));
        } catch (Exception unused) {
        }
    }

    public static void m(File file, long j) {
        file.setLastModified(ja4.f(j));
    }
}
