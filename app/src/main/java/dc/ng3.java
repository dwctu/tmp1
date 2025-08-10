package dc;

import android.text.TextUtils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.security.SecureRandom;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: StringUtils.java */
/* loaded from: classes4.dex */
public class ng3 {
    public static String a() {
        byte[] bArr = new byte[4];
        new SecureRandom().nextBytes(bArr);
        return b(bArr, true);
    }

    public static String b(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        String str = z ? "%02X" : "%02x";
        for (byte b : bArr) {
            sb.append(String.format(str, Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strA = uu1.a(str, 1);
        String str3 = strA.substring(0, 1).toUpperCase() + strA.substring(1);
        if (WearUtils.e1(str2) || Integer.parseInt(str2) <= 1) {
            return str3;
        }
        return str3 + " " + str2;
    }

    public static String d(String str, long j, String str2) {
        return str == null ? "" : str.length() < 3 ? str.contains("s") ? XHTMLText.Q : (str.contains("t") || (str.contains(PSOProgramService.VS_Key) && !WearUtils.e1(str2) && str2.toLowerCase().contains(Toy.TOY_FEATURE_XMACHINE.toLowerCase()))) ? "f" : "" : (str.contains(PSOProgramService.VS_Key) && str.contains(StreamManagement.AckRequest.ELEMENT)) ? "a" : (str.contains(PSOProgramService.VS_Key) && str.contains("p")) ? "b" : (str.contains(PSOProgramService.VS_Key) && str.contains("t")) ? "ea" : (str.contains(PSOProgramService.VS_Key) && str.contains("f")) ? "ei" : (str.contains(PSOProgramService.VS_Key) && str.contains(PSOProgramService.VS_Key) && be3.s("2021-8-18 00:00") > j) ? "p" : "";
    }

    public static String e(String str) {
        return str == null ? "" : str;
    }
}
