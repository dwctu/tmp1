package com.broadcom.bt.util.io;

import com.google.android.vending.expansion.downloader.Constants;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class FileSystemUtils {
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        String property;
        int i = -1;
        try {
            property = System.getProperty("os.name");
        } catch (Exception unused) {
        }
        if (property == null) {
            throw new IOException("os.name not found");
        }
        String lowerCase = property.toLowerCase();
        i = lowerCase.indexOf("windows") != -1 ? 1 : (lowerCase.indexOf("linux") == -1 && lowerCase.indexOf("sun os") == -1 && lowerCase.indexOf("sunos") == -1 && lowerCase.indexOf("solaris") == -1 && lowerCase.indexOf("mpe/ix") == -1 && lowerCase.indexOf("freebsd") == -1 && lowerCase.indexOf("irix") == -1 && lowerCase.indexOf("digital unix") == -1 && lowerCase.indexOf("unix") == -1 && lowerCase.indexOf("mac os x") == -1) ? (lowerCase.indexOf("hp-ux") == -1 && lowerCase.indexOf("aix") == -1) ? 0 : 3 : 2;
        OS = i;
    }

    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false);
    }

    public static long freeSpaceKb(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true);
    }

    public long freeSpaceOS(String str, int i, boolean z) throws Throwable {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        if (i == 0) {
            throw new IllegalStateException("Unsupported operating system");
        }
        if (i == 1) {
            long jFreeSpaceWindows = freeSpaceWindows(str);
            return z ? jFreeSpaceWindows / 1024 : jFreeSpaceWindows;
        }
        if (i == 2) {
            return freeSpaceUnix(str, z, false);
        }
        if (i == 3) {
            return freeSpaceUnix(str, z, true);
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    public long freeSpaceUnix(String str, boolean z, boolean z2) throws Throwable {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String strNormalize = FilenameUtils.normalize(str);
        String str2 = Constants.FILENAME_SEQUENCE_SEPARATOR;
        if (z) {
            str2 = Constants.FILENAME_SEQUENCE_SEPARATOR + "k";
        }
        if (z2) {
            str2 = str2 + "P";
        }
        List listPerformCommand = performCommand(str2.length() > 1 ? new String[]{"df", str2, strNormalize} : new String[]{"df", strNormalize}, 3);
        if (listPerformCommand.size() < 2) {
            throw new IOException("Command line 'df' did not return info as expected for path '" + strNormalize + "'- response was " + listPerformCommand);
        }
        StringTokenizer stringTokenizer = new StringTokenizer((String) listPerformCommand.get(1), " ");
        if (stringTokenizer.countTokens() >= 4) {
            stringTokenizer.nextToken();
        } else {
            if (stringTokenizer.countTokens() != 1 || listPerformCommand.size() < 3) {
                throw new IOException("Command line 'df' did not return data as expected for path '" + strNormalize + "'- check path is valid");
            }
            stringTokenizer = new StringTokenizer((String) listPerformCommand.get(2), " ");
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return parseBytes(stringTokenizer.nextToken(), strNormalize);
    }

    public long freeSpaceWindows(String str) throws Throwable {
        String strNormalize = FilenameUtils.normalize(str);
        if (strNormalize.length() > 2 && strNormalize.charAt(1) == ':') {
            strNormalize = strNormalize.substring(0, 2);
        }
        List listPerformCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /-c " + strNormalize}, Integer.MAX_VALUE);
        for (int size = listPerformCommand.size() - 1; size >= 0; size--) {
            String str2 = (String) listPerformCommand.get(size);
            if (str2.length() > 0) {
                return parseDir(str2, strNormalize);
            }
        }
        throw new IOException("Command line 'dir /-c' did not return any info for path '" + strNormalize + "'");
    }

    public Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }

    public long parseBytes(String str, String str2) throws NumberFormatException, IOException {
        try {
            long j = Long.parseLong(str);
            if (j >= 0) {
                return j;
            }
            throw new IOException("Command line 'df' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException unused) {
            throw new IOException("Command line 'df' did not return numeric data as expected for path '" + str2 + "'- check path is valid");
        }
    }

    public long parseDir(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int length = str.length();
        while (true) {
            length--;
            i = 0;
            if (length < 0) {
                i2 = 0;
                break;
            }
            if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i3 = 0;
                break;
            }
            char cCharAt = str.charAt(length);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != '.') {
                i3 = length + 1;
                break;
            }
            length--;
        }
        if (length < 0) {
            throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(i3, i2));
        while (i < stringBuffer.length()) {
            if (stringBuffer.charAt(i) == ',' || stringBuffer.charAt(i) == '.') {
                stringBuffer.deleteCharAt(i);
                i--;
            }
            i++;
        }
        return parseBytes(stringBuffer.toString(), str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List performCommand(java.lang.String[] r10, int r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.io.FileSystemUtils.performCommand(java.lang.String[], int):java.util.List");
    }
}
