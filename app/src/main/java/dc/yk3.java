package dc;

import com.broadcom.bt.util.io.IOUtils;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: WebJsInjectManager.java */
/* loaded from: classes4.dex */
public class yk3 {
    public static volatile yk3 b;
    public String a = "";

    public static yk3 c() {
        if (b == null) {
            synchronized (yk3.class) {
                if (b == null) {
                    b = new yk3();
                }
            }
        }
        return b;
    }

    public static File f() {
        return new File(fl3.a, "vibemate_pattern.js");
    }

    public String a(String str, String str2, int i) {
        return "javascript:(function(){       var res = window.changeSTMMediaStatus(\"" + str + "\",\"" + str2 + "\"," + i + ");}())";
    }

    public String b(String str, String str2) {
        return "javascript:(function(){       var res = window.getAsyncSTMMediaInfo(\"" + str + "\",\"" + str2 + "\");}())";
    }

    public String d(String str, String str2) {
        return "javascript:(function(){       var res = window.getMediaPattern(\"" + str + "\",\"" + str2 + "\");\n       window.java_obj.getMediaPatternCallback(JSON.stringify(res));}())";
    }

    public String e(String str, String str2) {
        return "javascript:(function(){       var res = window.getSTMMediaStatus(\"" + str + "\",\"" + str2 + "\");}())";
    }

    public String g() throws IOException {
        if (!WearUtils.e1(this.a)) {
            return this.a;
        }
        File fileF = f();
        if (!fileF.isDirectory()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileF);
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line + IOUtils.LINE_SEPARATOR_UNIX);
                }
                this.a = sb.toString();
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return this.a;
    }

    public String h() {
        return "javascript:(function() {var eleVideo=document.getElementsByTagName('video')[0];eleVideo.loop=false;})()";
    }

    public String i() {
        return "javascript:(function(){  var element = document.getElementsByTagName(\"video\")[0];  var width = element.offsetWidth;  var height = element.offsetHeight;  window.java_obj.getWH(width, height)})()";
    }

    public String j() {
        return "javascript:(function(){" + c().g() + "window.stmJsInject='1' \nwindow.setMediaList(\"11111\",window.location.href," + WearUtils.A.toJson(mk3.a.n()) + ")}())";
    }

    public void k() {
        this.a = "";
    }

    public String l(String str, String str2) {
        Toy toyN = pc1.a.N();
        if (toyN == null) {
            return "javascript:(function(){       var res = window.setSyncBar(\"" + str + "\",\"" + str2 + "\");\nconsole.log(\"gmf\", JSON.stringify(res));}())";
        }
        return "javascript:(function(){       var res = window.setSyncBar(\"" + str + "\",\"" + str2 + "\",\"" + toyN.getName() + "\");\nconsole.log(\"gmf\", JSON.stringify(res));}())";
    }
}
