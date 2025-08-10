package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyTool.java */
/* loaded from: classes4.dex */
public class yg3 {
    public static String[] a(List<Toy> list) {
        int i;
        String[] strArr = {PSOProgramService.VS_Key, StreamManagement.AckRequest.ELEMENT, "p", "t", "s", "f", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "pos"};
        HashMap map = new HashMap();
        if (WearUtils.g1(list)) {
            return new String[]{PSOProgramService.VS_Key};
        }
        Iterator<Toy> it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Toy next = it.next();
            Toy toy = new Toy();
            toy.setName(next.getName());
            toy.synNameToType();
            String strB = b(toy.getType());
            if (strB.contains("pos")) {
                String[] strArrSplit = strB.split(",");
                if (strArrSplit != null && strArrSplit.length > 0) {
                    int length = strArrSplit.length;
                    while (i < length) {
                        map.put(strArrSplit[i], 1);
                        i++;
                    }
                }
            } else {
                while (i < 8) {
                    String str = strArr[i];
                    if (strB.contains(str)) {
                        map.put(str, 1);
                    }
                    i++;
                }
            }
        }
        if (map.size() <= 0) {
            return new String[]{PSOProgramService.VS_Key};
        }
        String[] strArr2 = new String[map.size()];
        int i2 = 0;
        while (i < 8) {
            String str2 = strArr[i];
            if (map.containsKey(str2)) {
                strArr2[i2] = str2;
                i2++;
            }
            i++;
        }
        return strArr2;
    }

    public static String b(String str) {
        int[][] iArr = Toy.ICON_MAP_CONTROL.get(str);
        if (iArr == null || iArr.length == 1 || iArr.length < 5) {
            return PSOProgramService.VS_Key;
        }
        String str2 = PSOProgramService.VS_Key;
        for (int i = 2; i < iArr.length; i++) {
            if (iArr[i].length > 0) {
                if (i == 2) {
                    str2 = PSOProgramService.VS_Key;
                } else if (i == 3) {
                    str2 = str2 + ",r";
                } else if (i == 4) {
                    str2 = str2 + ",p";
                } else if (i == 5) {
                    str2 = str2 + ",s";
                } else if (i == 6) {
                    str2 = str2 + ",t";
                } else if (i == 7) {
                    str2 = str2 + ",f";
                } else if (i == 8) {
                    str2 = str2 + ",d";
                } else if (i == 10) {
                    str2 = str2 + ",pos";
                }
            }
        }
        return str2;
    }
}
