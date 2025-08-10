package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.broadcom.bt.util.io.IOUtils;
import com.scottyab.rootbeer.RootBeerNative;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* compiled from: RootBeer.java */
/* loaded from: classes3.dex */
public class id1 {
    public final Context a;
    public boolean b = true;

    public id1(Context context) {
        this.a = context;
    }

    public boolean a() {
        return new RootBeerNative().a();
    }

    public boolean b(String str) {
        boolean z = false;
        for (String str2 : hd1.a()) {
            String str3 = str2 + str;
            if (new File(str2, str).exists()) {
                jd1.f(str3 + " binary detected!");
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        HashMap map = new HashMap();
        map.put("ro.debuggable", "1");
        map.put("ro.secure", "0");
        String[] strArrP = p();
        if (strArrP == null) {
            return false;
        }
        boolean z = false;
        for (String str : strArrP) {
            for (String str2 : map.keySet()) {
                if (str.contains(str2)) {
                    String str3 = "[" + ((String) map.get(str2)) + "]";
                    if (str.contains(str3)) {
                        jd1.f(str2 + " = " + str3 + " detected!");
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean d() {
        return b("magisk");
    }

    public boolean e() {
        String str;
        String strReplace;
        String[] strArr;
        String[] strArrO = o();
        if (strArrO == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        int length = strArrO.length;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            String str2 = strArrO[i2];
            String[] strArrSplit = str2.split(" ");
            int i3 = 23;
            if ((i > 23 || strArrSplit.length >= 4) && (i <= 23 || strArrSplit.length >= 6)) {
                if (i > 23) {
                    str = strArrSplit[2];
                    strReplace = strArrSplit[5];
                } else {
                    str = strArrSplit[1];
                    strReplace = strArrSplit[3];
                }
                String[] strArr2 = hd1.d;
                int length2 = strArr2.length;
                int i4 = 0;
                while (i4 < length2) {
                    String str3 = strArr2[i4];
                    if (str.equalsIgnoreCase(str3)) {
                        if (Build.VERSION.SDK_INT > i3) {
                            strReplace = strReplace.replace("(", "").replace(")", "");
                        }
                        String[] strArrSplit2 = strReplace.split(",");
                        int length3 = strArrSplit2.length;
                        int i5 = 0;
                        while (i5 < length3) {
                            strArr = strArrO;
                            if (strArrSplit2[i5].equalsIgnoreCase("rw")) {
                                jd1.f(str3 + " path is mounted with rw permissions! " + str2);
                                z = true;
                                break;
                            }
                            i5++;
                            strArrO = strArr;
                        }
                        strArr = strArrO;
                    } else {
                        strArr = strArrO;
                    }
                    i4++;
                    strArrO = strArr;
                    i3 = 23;
                }
            } else {
                jd1.b("Error formatting mount line: " + str2);
            }
            i2++;
            strArrO = strArrO;
        }
        return z;
    }

    public boolean f() {
        if (!a()) {
            jd1.b("We could not load the native library to test for root");
            return false;
        }
        String[] strArrA = hd1.a();
        int length = strArrA.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = strArrA[i] + "su";
        }
        RootBeerNative rootBeerNative = new RootBeerNative();
        try {
            rootBeerNative.setLogDebugMessages(this.b);
            return rootBeerNative.checkForRoot(strArr) > 0;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public boolean g() {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"which", "su"});
            boolean z = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null;
            if (processExec != null) {
                processExec.destroy();
            }
            return z;
        } catch (Throwable unused) {
            if (processExec != null) {
                processExec.destroy();
            }
            return false;
        }
    }

    public boolean h() {
        return i(null);
    }

    public boolean i(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(hd1.b));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return m(arrayList);
    }

    public boolean j() {
        return k(null);
    }

    public boolean k(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(hd1.a));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return m(arrayList);
    }

    public boolean l() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public final boolean m(List<String> list) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.a.getPackageManager();
        boolean z = false;
        for (String str : list) {
            try {
                packageManager.getPackageInfo(str, 0);
                jd1.b(str + " ROOT management app detected!");
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z;
    }

    public boolean n() {
        return j() || h() || b("su") || c() || e() || l() || g() || f() || d();
    }

    public final String[] o() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("mount").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split(IOUtils.LINE_SEPARATOR_UNIX);
        } catch (IOException | NoSuchElementException e) {
            jd1.a(e);
            return null;
        }
    }

    public final String[] p() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split(IOUtils.LINE_SEPARATOR_UNIX);
        } catch (IOException | NoSuchElementException e) {
            jd1.a(e);
            return null;
        }
    }
}
