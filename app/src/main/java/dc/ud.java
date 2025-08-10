package dc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.multidex.MultiDexExtractor;
import com.j256.ormlite.stmt.query.SimpleComparison;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* compiled from: ClassUtils.java */
/* loaded from: classes.dex */
public class ud {
    public static final String a = "code_cache" + File.separator + "secondary-dexes";

    /* compiled from: ClassUtils.java */
    public static class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Set c;
        public final /* synthetic */ CountDownLatch d;

        public a(String str, String str2, Set set, CountDownLatch countDownLatch) {
            this.a = str;
            this.b = str2;
            this.c = set;
            this.d = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            DexFile dexFile = null;
            try {
                if (this.a.endsWith(MultiDexExtractor.EXTRACTED_SUFFIX)) {
                    dexFile = DexFile.loadDex(this.a, this.a + ".tmp", 0);
                } else {
                    dexFile = new DexFile(this.a);
                }
                Enumeration<String> enumerationEntries = dexFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    String strNextElement = enumerationEntries.nextElement();
                    if (strNextElement.startsWith(this.b)) {
                        this.c.add(strNextElement);
                    }
                }
            } catch (Throwable unused) {
                if (dexFile != null) {
                }
            }
            if (dexFile != null) {
                try {
                    dexFile.close();
                } catch (Throwable unused2) {
                }
            }
            this.d.countDown();
        }
    }

    public static Set<String> a(Context context, String str) throws InterruptedException, PackageManager.NameNotFoundException, IOException {
        HashSet hashSet = new HashSet();
        List<String> listC = c(context);
        CountDownLatch countDownLatch = new CountDownLatch(listC.size());
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            sd.a().execute(new a(it.next(), str, hashSet, countDownLatch));
        }
        countDownLatch.await();
        String str2 = "Filter " + hashSet.size() + " classes by packageName <" + str + SimpleComparison.GREATER_THAN_OPERATION;
        return hashSet;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static List<String> c(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        if (!d()) {
            int i = b(context).getInt("dex.number", 1);
            File file2 = new File(applicationInfo.dataDir, a);
            for (int i2 = 2; i2 <= i; i2++) {
                File file3 = new File(file2, str + i2 + MultiDexExtractor.EXTRACTED_SUFFIX);
                if (!file3.isFile()) {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
                arrayList.add(file3.getAbsolutePath());
            }
        }
        if (pd.b()) {
            arrayList.addAll(f(applicationInfo));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d A[PHI: r1
  0x001d: PHI (r1v8 java.lang.String) = (r1v6 java.lang.String), (r1v6 java.lang.String), (r1v9 java.lang.String) binds: [B:13:0x004a, B:15:0x004e, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d() throws java.lang.NumberFormatException {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = e()     // Catch: java.lang.Throwable -> L51
            r3 = 1
            if (r2 == 0) goto L1f
            java.lang.String r1 = "'YunOS'"
            java.lang.String r2 = "ro.build.version.sdk"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L51
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L51
            r4 = 21
            if (r2 < r4) goto L52
        L1d:
            r0 = 1
            goto L52
        L1f:
            java.lang.String r1 = "'Android'"
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L52
            java.lang.String r4 = "(\\d+)\\.(\\d+)(\\.\\d+)?"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Throwable -> L51
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch: java.lang.Throwable -> L51
            boolean r4 = r2.matches()     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L52
            java.lang.String r4 = r2.group(r3)     // Catch: java.lang.Throwable -> L51
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L51
            r5 = 2
            java.lang.String r2 = r2.group(r5)     // Catch: java.lang.Throwable -> L51
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L51
            if (r4 > r5) goto L1d
            if (r4 != r5) goto L52
            if (r2 < r3) goto L52
            goto L1d
        L51:
        L52:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "VM with name "
            r2.append(r3)
            r2.append(r1)
            if (r0 == 0) goto L64
            java.lang.String r1 = " has multidex support"
            goto L66
        L64:
            java.lang.String r1 = " does not have multidex support"
        L66:
            r2.append(r1)
            r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ud.d():boolean");
    }

    public static boolean e() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if (property2 == null || !property2.toLowerCase().contains("lemur")) {
                if (property == null) {
                    return false;
                }
                if (property.trim().length() <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> f(ApplicationInfo applicationInfo) {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null) {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", String.class).invoke(null, applicationInfo.packageName));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(MultiDexExtractor.DEX_SUFFIX)) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e) {
                String str = "InstantRun support error, " + e.getMessage();
            }
        } else {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }
}
