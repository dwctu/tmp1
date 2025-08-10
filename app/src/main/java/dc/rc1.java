package dc;

import com.wear.util.WearUtils;
import java.util.ArrayList;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: CommandBean.java */
/* loaded from: classes3.dex */
public class rc1 {
    public String a;
    public String b;
    public int c;
    public boolean d;
    public int e = 0;

    public rc1(String str, String str2, String str3) {
        this.c = 0;
        this.d = false;
        new ArrayList();
        this.b = str;
        this.a = str2;
        System.currentTimeMillis();
        this.c = 0;
        if (str.startsWith("Vibrate:")) {
            if (str.equals("Vibrate:0;")) {
                this.c = 1;
            } else {
                this.c = 10;
            }
        } else if (str.startsWith("Vibrate1:")) {
            if (str.equals("Vibrate1:0;")) {
                this.c = 2;
            } else {
                this.c = 20;
            }
        } else if (str.startsWith("Vibrate2:")) {
            if (str.equals("Vibrate2:0;")) {
                this.c = 3;
            } else {
                this.c = 30;
            }
        } else if (str.startsWith("Rotate:")) {
            if (str.equals("Rotate:0;") || str.startsWith("Rotate:True") || str.startsWith("Rotate:False")) {
                this.c = 4;
            } else {
                this.c = 40;
            }
        } else if (str.startsWith("Air:Level:")) {
            if (str.equals("Air:Level:0")) {
                this.c = 5;
            } else {
                this.c = 50;
            }
        } else if (str.startsWith("Thrusting:")) {
            if (str.equals("Thrusting:0;")) {
                this.c = 6;
            } else {
                this.c = 60;
            }
        } else if (str.startsWith("Battery;")) {
            this.c = 9;
        } else if (str.startsWith("Mply:")) {
            if (str.equals("Mply:0:0:0;")) {
                this.c = 7;
            } else {
                i(str, str3);
            }
        } else if (str.startsWith("Vibrate3:")) {
            if (str.equals("Vibrate3:0;")) {
                this.c = 8;
            } else {
                this.c = 80;
            }
        }
        if (str.equals("DeviceType;") || str.equals("GetLevel;") || str.equals("BM;") || str.equals("SGM;") || str.startsWith("Gsensor:") || str.startsWith("StartMove:") || str.equals("EM;") || str.startsWith("StopMove:") || str.startsWith("aa") || str.startsWith("SetCtlPan")) {
            this.d = true;
        }
    }

    public boolean a(String str) {
        if (this.b.equals(str)) {
            return true;
        }
        return (this.b.equals("BM;") || this.b.equals("SGM;")) && str.equals("EM;");
    }

    public boolean b(int i) {
        int i2 = this.c;
        if (i2 == 0 || i2 == 9) {
            return false;
        }
        if (i2 == i) {
            return true;
        }
        if (i2 < 10 && i2 * 10 == i) {
            return true;
        }
        if (i2 == 1 && (i == 20 || i == 30)) {
            return true;
        }
        if ((i == 2 || i == 3) && i2 == 10) {
            return true;
        }
        return i < 10 && i * 10 == i2;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public boolean g() {
        return this.c == 9;
    }

    public boolean h() {
        return this.d;
    }

    public final void i(String str, String str2) {
        if (WearUtils.e1(str2)) {
            str2 = str;
        }
        String strSubstring = str.substring(0, str.length() - 1);
        String[] strArrSplit = strSubstring.split(SignatureImpl.INNER_SEP);
        String[] strArrSplit2 = str2.substring(0, str2.length() - 1).split(SignatureImpl.INNER_SEP);
        String str3 = "新数据====" + strSubstring + "旧数据" + str2;
        if (strArrSplit.length != strArrSplit2.length) {
            this.c = 0;
            return;
        }
        if (strArrSplit2.length >= 3) {
            int i = 0;
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                if (!strArrSplit[i2].equals(strArrSplit2[i2])) {
                    i++;
                }
            }
            if (i > 1) {
                this.c = 0;
            } else {
                this.c = 70;
            }
        }
    }

    public void j(int i) {
        this.e = i;
    }
}
