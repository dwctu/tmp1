package dc;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ParseQS.java */
/* loaded from: classes4.dex */
public class ex3 {
    public static Map<String, String> a(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] strArrSplit = str2.split("=");
            map.put(cx3.a(strArrSplit[0]), strArrSplit.length > 1 ? cx3.a(strArrSplit[1]) : "");
        }
        return map;
    }

    public static String b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(cx3.b(entry.getKey()));
            sb.append("=");
            sb.append(cx3.b(entry.getValue()));
        }
        return sb.toString();
    }
}
