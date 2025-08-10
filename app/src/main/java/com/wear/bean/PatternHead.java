package com.wear.bean;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.util.WearUtils;
import com.wear.widget.control.FingImageLayout;
import com.wear.widget.control.TouchControlView;
import dc.de0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class PatternHead implements Serializable {
    public static Map<String, String> COMMAND_ORDER = new HashMap() { // from class: com.wear.bean.PatternHead.1
        {
            put(PSOProgramService.VS_Key, "Vibrate:#;0,20");
            put("v1", "vibrate1:#;0,20");
            put("v2", "vibrate2:#;0,20");
            put("v3", "vibrate3:#;0,20");
            put("s", "Suction:#;0,20");
            put(StreamManagement.AckRequest.ELEMENT, "Rotate:#;0,20");
            put("p", "Air:Level:#;0,3");
            put("t", "Thrusting:#;0,20");
            put("f", "Finger:#;0,20");
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "Depth:#;0,20");
            put("pos", "Position:#;0,20");
            put(String.valueOf(TouchControlView.Q), "RotateChange;");
        }
    };
    public static final int PATTERN_HEAD_VERSION = 100;
    public static final String P_M = "7MoL49w1Yo5HNeH2";
    public static final String P_M_DEF = "$$";
    public String[] allFuncCommandTags;
    public String[] allFuncValues;
    public String function;
    public String head;
    public boolean isAllFunc;
    public String md;
    public int splitTime;
    public String toys;
    public String version;

    public PatternHead(String str) {
        String[] strArrSplit;
        this.splitTime = 100;
        boolean z = false;
        this.isAllFunc = false;
        this.head = str;
        if (WearUtils.e1(str) || (strArrSplit = this.head.split(TouchControlView.P)) == null) {
            return;
        }
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(TouchControlView.N);
            if (strArrSplit2 != null && strArrSplit2.length > 1) {
                map.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
        if (map.get(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) != null) {
            this.version = (String) map.get(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        }
        if (map.get(ExifInterface.GPS_DIRECTION_TRUE) != null) {
            this.toys = (String) map.get(ExifInterface.GPS_DIRECTION_TRUE);
        }
        if (map.get("F") != null) {
            this.function = (String) map.get("F");
        }
        if (map.get(ExifInterface.LATITUDE_SOUTH) != null && WearUtils.q1((String) map.get(ExifInterface.LATITUDE_SOUTH))) {
            this.splitTime = Integer.valueOf((String) map.get(ExifInterface.LATITUDE_SOUTH)).intValue();
        }
        if (map.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) != null) {
            if (!WearUtils.e1((String) map.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) && ((String) map.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)).toLowerCase().equals(FingImageLayout.ObjectAnimatorY)) {
                z = true;
            }
            this.isAllFunc = z;
        }
        if (map.get("M") != null) {
            this.md = (String) map.get("M");
        }
    }

    private void changeAllFuncByVFuncLinkedToys(String[] strArr, String[] strArr2) {
        int iIntValue;
        String[] strArrSplit;
        String[] strArrSplit2;
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                break;
            } else if (PSOProgramService.VS_Key.equals(strArr[i])) {
                iIntValue = WearUtils.q1(strArr2[i]) ? Integer.valueOf(strArr2[i]).intValue() : -1;
            } else {
                i++;
            }
        }
        HashMap map = new HashMap();
        for (Toy toy : WearUtils.x.G().o()) {
            String toyFunction = Toy.getToyFunction(toy.getType());
            if (toyFunction != null && (strArrSplit2 = toyFunction.split(",")) != null) {
                for (String str : strArrSplit2) {
                    if (!toy.isF01Toy() || !TextUtils.equals(PSOProgramService.VS_Key, str)) {
                        map.put(str, str);
                    }
                }
            }
        }
        if (map.size() <= 0 || iIntValue < 0 || iIntValue > 20) {
            return;
        }
        String[] strArr3 = new String[map.size()];
        String[] strArr4 = new String[map.size()];
        int i2 = 0;
        for (String str2 : map.keySet()) {
            strArr3[i2] = str2;
            String[] strArrSplit3 = COMMAND_ORDER.get(str2.toLowerCase()).split(";");
            String str3 = (strArrSplit3 == null || strArrSplit3.length <= 0) ? "" : strArrSplit3[1];
            if (!WearUtils.e1(str3) && (strArrSplit = str3.split(",")) != null && strArrSplit.length == 2) {
                Integer.valueOf(strArrSplit[0]).intValue();
                int iIntValue2 = Integer.valueOf(strArrSplit[1]).intValue();
                if (iIntValue2 > 0) {
                    int i3 = iIntValue * 5;
                    int i4 = 100 / iIntValue2;
                    if (i3 > 0 && i3 / i4 == 0) {
                        i3 = i4;
                    }
                    strArr4[i2] = "" + (i3 / i4);
                }
            }
            i2++;
        }
        this.allFuncCommandTags = strArr3;
        this.allFuncValues = strArr4;
    }

    private int getFirstMotorFunctionIndex(List<List<String>> list, String[] strArr, int i) {
        if (i != -1 || list == null || list.size() <= 0) {
            return i;
        }
        List<String> list2 = list.get(0);
        if (list2 == null || list2.size() <= 0) {
            return i;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (list2.contains(strArr[i2])) {
                return i2;
            }
        }
        return i;
    }

    private static int getOldFunctionVAndV1(String[] strArr, int i) {
        if (i != -1) {
            return i;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (PSOProgramService.VS_Key.equals(strArr[i2]) || "v1".equals(strArr[i2])) {
                return i2;
            }
        }
        return i;
    }

    public synchronized List<String> createCommands(String str) {
        String[] strArrSplit;
        String[] strArrSplit2;
        boolean z;
        String[] strArrSplit3;
        String[] strArr;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String str2 = this.function;
        if (str2 == null || str == null) {
            return copyOnWriteArrayList;
        }
        try {
            strArrSplit = str2.split(TouchControlView.O);
            strArrSplit2 = str.split(TouchControlView.O);
            de0.j("ble_pattern", "before motors: " + this.function + "\n + motorVs: " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (strArrSplit2.length < strArrSplit.length) {
            return copyOnWriteArrayList;
        }
        if (strArrSplit2.length > strArrSplit.length) {
            try {
                String[] strArr2 = new String[strArrSplit.length];
                System.arraycopy(strArrSplit2, 0, strArr2, 0, strArrSplit.length);
                strArrSplit2 = strArr2;
            } catch (Exception unused) {
                return copyOnWriteArrayList;
            }
        }
        int i = 0;
        while (true) {
            if (i >= strArrSplit.length) {
                break;
            }
            if (!StreamManagement.AckRequest.ELEMENT.equals(strArrSplit[i])) {
                i++;
            } else {
                if (!(WearUtils.q1(strArrSplit2[i]) && Integer.valueOf(strArrSplit2[i]).intValue() == TouchControlView.Q) && WearUtils.q1(strArrSplit2[i])) {
                    break;
                }
                z = true;
            }
        }
        z = false;
        if (z) {
            copyOnWriteArrayList.add(COMMAND_ORDER.get(String.valueOf(TouchControlView.Q)));
        } else {
            String str3 = "";
            if (this.isAllFunc) {
                changeAllFuncByVFuncLinkedToys(strArrSplit, strArrSplit2);
                String[] strArr3 = this.allFuncCommandTags;
                if (strArr3 != null && (strArr = this.allFuncValues) != null && strArr3.length == strArr.length) {
                    strArrSplit = strArr3;
                    strArrSplit2 = strArr;
                }
            }
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                String[] strArrSplit4 = COMMAND_ORDER.get(strArrSplit[i2].toLowerCase()).split(";");
                String str4 = "";
                if (strArrSplit4 != null && strArrSplit4.length > 0) {
                    str4 = strArrSplit4[1];
                }
                if (!WearUtils.e1(str4) && (strArrSplit3 = str4.split(",")) != null && strArrSplit3.length == 2) {
                    int iIntValue = Integer.valueOf(strArrSplit3[0]).intValue();
                    int iIntValue2 = Integer.valueOf(strArrSplit3[1]).intValue();
                    if (!WearUtils.q1(strArrSplit2[i2])) {
                        copyOnWriteArrayList.add(strArrSplit4[0].replace("#", "0") + ";");
                        str3 = str3 + ((int) ((Integer.valueOf("0").intValue() * 100.0f) / iIntValue2)) + ",";
                    } else if (Integer.valueOf(strArrSplit2[i2]).intValue() >= iIntValue && Integer.valueOf(strArrSplit2[i2]).intValue() <= iIntValue2) {
                        copyOnWriteArrayList.add(strArrSplit4[0].replace("#", strArrSplit2[i2]) + ";");
                        str3 = str3 + ((int) ((Integer.valueOf(strArrSplit2[i2]).intValue() * 100.0f) / iIntValue2)) + ",";
                    }
                }
            }
            if (str3.indexOf(",") != -1) {
                copyOnWriteArrayList.add(str3.substring(0, str3.length() - 1));
            }
        }
        return copyOnWriteArrayList;
    }

    public String[] getAllFuncCommandTags() {
        return this.allFuncCommandTags;
    }

    public String getFunction() {
        return WearUtils.e1(this.function) ? "" : this.function;
    }

    public String getHead() {
        return this.head;
    }

    public String getMd() {
        return this.md;
    }

    public int getSplitTime() {
        return this.splitTime;
    }

    public String getToys() {
        return WearUtils.e1(this.toys) ? "" : this.toys;
    }

    public String getVersion() {
        return WearUtils.e1(this.version) ? "" : this.version;
    }

    public String getVibrateSplit_0_20_TO_BT_0_9(String str, List<List<String>> list) throws NumberFormatException {
        String[] strArrSplit = this.function.split(TouchControlView.O);
        int firstMotorFunctionIndex = getFirstMotorFunctionIndex(list, strArrSplit, getOldFunctionVAndV1(strArrSplit, -1));
        if (firstMotorFunctionIndex == -1) {
            return null;
        }
        String[] strArrSplit2 = str.split(TouchControlView.P);
        StringBuilder sb = new StringBuilder("");
        for (String str2 : strArrSplit2) {
            if (!WearUtils.e1(str2)) {
                String[] strArrSplit3 = str2.split(TouchControlView.O);
                if (!WearUtils.j1(strArrSplit3) && strArrSplit3.length >= firstMotorFunctionIndex) {
                    float f = Float.parseFloat(strArrSplit3[firstMotorFunctionIndex]);
                    if (f >= 20.0f) {
                        f = 19.0f;
                    }
                    float f2 = f / 2.0f;
                    if (f2 > 0.0f) {
                        int i = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                    }
                    sb.append(((int) f2) + ",");
                }
            }
        }
        String string = sb.toString();
        return string.indexOf(",") != -1 ? string.substring(0, string.length() - 1) : string;
    }

    public boolean isAllFunc() {
        return this.isAllFunc;
    }

    public boolean isMulFunction() {
        return (WearUtils.e1(this.function) || this.function.indexOf(TouchControlView.O) == -1) ? false : true;
    }

    public void setAllFunc(boolean z) {
        this.isAllFunc = z;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public void setHead(String str) {
        this.head = str;
    }

    public void setMd(String str) {
        this.md = str;
    }

    public void setSplitTime(int i) {
        this.splitTime = i;
    }

    public void setToys(String str) {
        this.toys = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
