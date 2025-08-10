package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lovense.wear.R;
import com.wear.bean.BaseEntity;
import com.wear.bean.DfuBean;
import com.wear.bean.RangeBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.bean.ToyRename;
import com.wear.bean.handlerbean.HandlerToy;
import com.wear.dao.DaoUtils;
import com.wear.util.TextOverlayImageView;
import com.wear.util.WearUtils;
import com.wear.widget.control.TouchControlView;
import com.xtremeprog.sdk.ble.BleService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: OldToyBean.java */
@DatabaseTable(tableName = "tb_toy")
/* loaded from: classes3.dex */
public class ws1 extends BaseEntity implements HandlerToy {
    public static final Map<String, String> b = new j();
    public static final Map<String, Integer> c = new k();
    public static final Map<String, Integer[]> d = new l();
    public static final Map<String, int[][]> e = new m();
    public static final Map<String, Integer> f = new n();
    public static final Map<String, Integer> g = new o();
    public static final Map<String, Integer> h = new p();
    public static final Map<String, Integer> i = new q();
    public static final Map<String, String[]> j = new r();
    public static final Map<String, Integer[]> k = new a();
    public static final Map<String, Integer> l = new b();
    public static final Map<String, Integer> m = new c();
    public static final Map<String, String> n = new d();
    public static final Map<String, String> o = new e();
    public static final List<String> p = new f();
    public static final Map<String, Integer> q = new g();
    public static final Map<String, Integer> r = new h();
    public static final List<String> s = new ArrayList();
    public static List<ToyConfigInfoBean> t = new ArrayList();
    public static int u = 1;
    public static int v = 1;
    public transient long a;

    @DatabaseField
    private String address;
    private String agString;
    private String aiString;
    private String batchId;

    @DatabaseField
    private int connectApp;
    private String defineRename;
    private String deviceId;
    private String deviceName;

    @DatabaseField
    private String deviceType;

    @DatabaseField
    private String email;

    @DatabaseField
    private String formApp;
    private long getCheckBindToyErrorTime;
    private long getDfuErrorTime;
    private boolean isRealDeviceType;

    @DatabaseField
    private Integer isSelect;

    @DatabaseField
    private Integer ledSetting;
    private String logFormApp;
    private String lvsMotorConfig;

    @DatabaseField
    private String name;
    private long powerOffTime;
    private String realType;
    public Long rquestConnectTime;
    private ToyConfigInfoBean toyConfigDataBean;

    @DatabaseField
    private String type;
    private String upCaseName;
    private DfuBean updateDfu;

    @DatabaseField
    private long updateTime;

    @DatabaseField
    private String uuid;

    @DatabaseField
    private Integer version;
    private final List<String> rssiList = new ArrayList();
    private final List<Integer> battayList = new ArrayList();
    private final List<Map<String, Long>> commandList = new ArrayList();
    public Long connectedTime = 0L;
    public boolean f01IsNotice = false;
    public boolean f01IsReady = false;
    public boolean f01IsOff = true;
    public int isLongRange = 0;
    public int requestConnectingIndex = 0;
    public int bindType = 1;
    public int disConnectType = 0;
    private boolean isGenerateType = false;

    @DatabaseField
    private int simpleToy = 0;
    private int status = -1;
    private int led = -1;
    private int aColor = 7;
    private int battery = -1;
    private int rssi = 0;
    private boolean canRssi = false;
    private int missionSolo = 1;
    private int[] missionTchLvl = {3, 8, 13, 18};
    private int isPowerOff = 0;
    private long batteryRequestTime = 0;
    private boolean synControlAnimation = true;
    private String workMode = null;
    private boolean direction = true;
    private int isDfuEnd = 0;
    private boolean isToyListAdd = false;
    private int isCheckBindToy = 0;
    private boolean isTransfer = false;
    private int connectType = -1;
    private int connectTryNumb = 4;
    private long connectScanTime = 0;
    private String pinStatus = "-1";
    private boolean isLanApiUpdateRequest = false;
    private int lanApiUpdateCount = 0;

    /* compiled from: OldToyBean.java */
    public class a extends HashMap<String, Integer[]> {
        public a() {
            put(PSOProgramService.VS_Key, new Integer[]{Integer.valueOf(R.string.toy_control_vibrate), Integer.valueOf(R.drawable.content_button_vibration_blue)});
            put(StreamManagement.AckRequest.ELEMENT, new Integer[]{Integer.valueOf(R.string.toy_control_rotate), Integer.valueOf(R.drawable.content_button_rotation_blue)});
            put("p", new Integer[]{Integer.valueOf(R.string.toy_control_pump), Integer.valueOf(R.drawable.content_button_pump_pink)});
            put("f", new Integer[]{Integer.valueOf(R.string.str_unknown), Integer.valueOf(R.drawable.chat_toolbar_toyfunction_fingering_60)});
        }
    }

    /* compiled from: OldToyBean.java */
    public class b extends HashMap<String, Integer> {
        public b() {
            put(PSOProgramService.VS_Key, Integer.valueOf(R.color.func_v_trans));
            put("v1", Integer.valueOf(R.color.func_v1_trans));
            Integer numValueOf = Integer.valueOf(R.color.func_v2_trans);
            put("v2", numValueOf);
            Integer numValueOf2 = Integer.valueOf(R.color.func_f_trans);
            put("v3", numValueOf2);
            put(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(R.color.func_r_trans));
            put("p", Integer.valueOf(R.color.func_p_trans));
            put("s", Integer.valueOf(R.color.func_s_trans));
            put("w", Integer.valueOf(R.color.func_w_trans));
            put("f", numValueOf2);
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf);
        }
    }

    /* compiled from: OldToyBean.java */
    public class c extends HashMap<String, Integer> {
        public c() {
            put(PSOProgramService.VS_Key, Integer.valueOf(R.color.func_v_trans));
            put("v1", Integer.valueOf(R.color.func_v1_trans));
            put("v2", Integer.valueOf(R.color.func_v2_trans));
            put("v3", Integer.valueOf(R.color.func_v3_trans));
            Integer numValueOf = Integer.valueOf(R.color.func_r_trans);
            put(StreamManagement.AckRequest.ELEMENT, numValueOf);
            put("p", numValueOf);
            put("t", Integer.valueOf(R.color.func_t_trans));
            put("s", Integer.valueOf(R.color.func_s_trans));
            put("w", numValueOf);
            put("f", numValueOf);
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf);
        }
    }

    /* compiled from: OldToyBean.java */
    public class d extends HashMap<String, String> {
        public d() {
            put("vibrationStrength", PSOProgramService.VS_Key);
            put("vibration1Strength", "v1");
            put("vibration2Strength", "v2");
            put("vibration3Strength", "v3");
            put("rotateStrength", StreamManagement.AckRequest.ELEMENT);
            put("airStrength", "p");
            put("suctionStrength", "s");
            put("thrustingStrength", "t");
            put("fingeringStrength", "f");
            put("depthStrength", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
        }
    }

    /* compiled from: OldToyBean.java */
    public class e extends HashMap<String, String> {
        public e() {
            put("Vibrate", PSOProgramService.VS_Key);
            put("Vibrate1", "v1");
            put("Vibrate2", "v2");
            put("Vibrate3", "v3");
            put("Rotate", StreamManagement.AckRequest.ELEMENT);
            put("Air", "p");
            put("Suction", "s");
            put("Thrusting", "t");
            put("Fingering", "f");
            put("Depth", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
            put("Position", "pos");
        }
    }

    /* compiled from: OldToyBean.java */
    public class f extends ArrayList<String> {
        public f() {
            add("Vibrate");
            add("Vibrate1");
            add("Vibrate2");
            add("Vibrate3");
            add("Rotate");
            add("Air");
            add("Suction");
            add("Thrusting");
            add("Fingering");
            add("Depth");
            add("Mply");
            add("Multiply");
            add("Position");
        }
    }

    /* compiled from: OldToyBean.java */
    public class g extends HashMap<String, Integer> {
        public g() {
            Integer numValueOf = Integer.valueOf(R.drawable.selector_icon_fun_v);
            put(PSOProgramService.VS_Key, numValueOf);
            put("v1", numValueOf);
            put("v2", Integer.valueOf(R.drawable.selector_icon_fun_v2));
            put("v3", Integer.valueOf(R.drawable.selector_icon_fun_v3));
            put(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(R.drawable.selector_icon_fun_r));
            put("p", Integer.valueOf(R.drawable.selector_icon_fun_p));
            put("s", Integer.valueOf(R.drawable.selector_icon_fun_s));
            put("f", Integer.valueOf(R.drawable.selector_icon_fun_f));
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, Integer.valueOf(R.drawable.selector_icon_fun_d));
            put("t", Integer.valueOf(R.drawable.selector_icon_fun_t));
        }
    }

    /* compiled from: OldToyBean.java */
    public class h extends HashMap<String, Integer> {
        public h() {
            Integer numValueOf = Integer.valueOf(R.string.toy_control_type1);
            put("vibrationStrength", numValueOf);
            put("vibration1Strength", numValueOf);
            put("vibration2Strength", numValueOf);
            put("vibration3Strength", numValueOf);
            put("rotateStrength", Integer.valueOf(R.string.toy_control_type2));
            put("airStrength", Integer.valueOf(R.string.toy_control_type3));
            put("suctionStrength", Integer.valueOf(R.string.function_suction));
            put("thrustingStrength", Integer.valueOf(R.string.toy_function_thrust_speed));
            put("fingeringStrength", Integer.valueOf(R.string.function_fingering));
            put("depthStrength", Integer.valueOf(R.string.function_depth));
        }
    }

    /* compiled from: OldToyBean.java */
    public class i extends ArrayList<String> {
        public i() {
            add("90");
            add("346797643");
            add("3456990");
            add("34596990");
        }
    }

    /* compiled from: OldToyBean.java */
    public class j extends HashMap<String, String> {
        public j() {
            put(EnvironmentCompat.MEDIA_UNKNOWN, "Unknown");
        }
    }

    /* compiled from: OldToyBean.java */
    public class k extends HashMap<String, Integer> {
        public k() {
            put(EnvironmentCompat.MEDIA_UNKNOWN, Integer.valueOf(R.drawable.nav_unknown_1));
        }
    }

    /* compiled from: OldToyBean.java */
    public class l extends HashMap<String, Integer[]> {
        public l() {
            put(EnvironmentCompat.MEDIA_UNKNOWN, new Integer[]{Integer.valueOf(R.drawable.nav_unknown_1), Integer.valueOf(R.drawable.nav_unknown_2), Integer.valueOf(R.drawable.content_icon_gray)});
        }
    }

    /* compiled from: OldToyBean.java */
    public class m extends HashMap<String, int[][]> {
        public m() {
            put(EnvironmentCompat.MEDIA_UNKNOWN, new int[][]{new int[]{R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_blue, R.drawable.content_button_vibration_blue}});
        }
    }

    /* compiled from: OldToyBean.java */
    public class n extends HashMap<String, Integer> {
        public n() {
            Integer numValueOf = Integer.valueOf(R.drawable.content_button_roundframe_pink);
            put(PSOProgramService.VS_Key, numValueOf);
            put("v1", numValueOf);
            Integer numValueOf2 = Integer.valueOf(R.drawable.content_button_roundframe_blue);
            put("v2", numValueOf2);
            put("v3", numValueOf);
            put(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(R.drawable.content_button_roundframe_rotation_blue));
            put("p", Integer.valueOf(R.drawable.content_button_roundframe_pump_pink));
            put("s", numValueOf);
            put("w", Integer.valueOf(R.drawable.content_button_roundframe_swing_yellow));
            put("f", numValueOf);
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf2);
            put("pos", numValueOf2);
        }
    }

    /* compiled from: OldToyBean.java */
    public class o extends HashMap<String, Integer> {
        public o() {
            put(PSOProgramService.VS_Key, Integer.valueOf(R.color.func_v));
            put("v1", Integer.valueOf(R.color.func_v1));
            put("v2", Integer.valueOf(R.color.func_v2));
            Integer numValueOf = Integer.valueOf(R.color.func_f);
            put("v3", numValueOf);
            Integer numValueOf2 = Integer.valueOf(R.color.func_r);
            put(StreamManagement.AckRequest.ELEMENT, numValueOf2);
            put("p", Integer.valueOf(R.color.func_p));
            put("s", Integer.valueOf(R.color.func_s));
            put("w", Integer.valueOf(R.color.func_w));
            put("t", Integer.valueOf(R.color.func_t));
            put("f", numValueOf);
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf2);
            put("pos", numValueOf2);
        }
    }

    /* compiled from: OldToyBean.java */
    public class p extends HashMap<String, Integer> {
        public p() {
            Integer numValueOf = Integer.valueOf(R.drawable.v_seekbar_thumb_pink);
            put(PSOProgramService.VS_Key, numValueOf);
            put("v1", numValueOf);
            Integer numValueOf2 = Integer.valueOf(R.drawable.v_seekbar_thumb_blue);
            put("v2", numValueOf2);
            Integer numValueOf3 = Integer.valueOf(R.drawable.v_seekbar_thumb_purple);
            put("v3", numValueOf3);
            put(StreamManagement.AckRequest.ELEMENT, numValueOf2);
            put("p", numValueOf3);
            put("s", Integer.valueOf(R.drawable.v_seekbar_thumb_cyan));
            put("w", Integer.valueOf(R.drawable.v_seekbar_thumb_yellow));
            put("f", numValueOf3);
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf2);
            put("pos", numValueOf2);
        }
    }

    /* compiled from: OldToyBean.java */
    public class q extends HashMap<String, Integer> {
        public q() {
            Integer numValueOf = Integer.valueOf(R.drawable.v_seekbar_progress_pink);
            put(PSOProgramService.VS_Key, numValueOf);
            put("v1", numValueOf);
            Integer numValueOf2 = Integer.valueOf(R.drawable.v_seekbar_progress_blue);
            put("v2", numValueOf2);
            Integer numValueOf3 = Integer.valueOf(R.drawable.v_seekbar_progress_yellow);
            put("v3", numValueOf3);
            put(StreamManagement.AckRequest.ELEMENT, numValueOf2);
            put("p", Integer.valueOf(R.drawable.v_seekbar_progress_purple));
            put("s", Integer.valueOf(R.drawable.v_seekbar_progress_cyan));
            put("w", numValueOf3);
            put("f", numValueOf3);
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf2);
            put("pos", numValueOf2);
        }
    }

    /* compiled from: OldToyBean.java */
    public class r extends HashMap<String, String[]> {
        public r() {
            put(PSOProgramService.VS_Key, new String[]{"Vibrate:#;", "20", "2131888507"});
            put("v1", new String[]{"vibrate1:#;", "20", "2131888507"});
            put("v2", new String[]{"vibrate2:#;", "20", "2131888507"});
            put("v3", new String[]{"vibrate3:#;", "20", "2131888507"});
            put(StreamManagement.AckRequest.ELEMENT, new String[]{"Rotate:#;", "20", "2131888500"});
            put("rl", new String[]{"Rotate:True:#;", "20", "2131888500"});
            put("rr", new String[]{"Rotate:False:#;", "20", "2131888500"});
            put("p", new String[]{"Air:Level:#;", ExifInterface.GPS_MEASUREMENT_3D, "2131888499"});
            put("s", new String[]{"vibrate:#;", "20", "2131887243"});
            put("t", new String[]{"Thrusting:#;", "20", "2131888512"});
            put("f", new String[]{"vibrate3:#;", "20", "2131887239"});
            put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, new String[]{"Depth:#;", "20", "2131887238"});
            put("pos", new String[]{"Position:#;", SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY, "2131887238"});
        }
    }

    public static boolean J1(String str) {
        if (WearUtils.e1(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.equals("null") || lowerCase.equals(EnvironmentCompat.MEDIA_UNKNOWN) || lowerCase.startsWith("lvs");
    }

    public static int K0(String str) {
        Integer num = i.get(str);
        return num == null ? R.drawable.v_seekbar_progress_pink : num.intValue();
    }

    public static boolean K1(String str) {
        if (WearUtils.e1(str)) {
            return false;
        }
        return b.containsKey(w(str.split(SignatureImpl.INNER_SEP)[0].toLowerCase()));
    }

    public static int L0(String str) {
        Integer num = h.get(str);
        return num == null ? R.drawable.v_seekbar_thumb_pink : num.intValue();
    }

    public static boolean L1(String str) {
        return str.startsWith("PIN:");
    }

    public static int M(String str) {
        Integer num = g.get(str);
        return num == null ? R.color.func_v : num.intValue();
    }

    public static int N(String str) {
        Integer num = l.get(str);
        return num == null ? R.color.func_v_trans : num.intValue();
    }

    public static int[] Q0(String str, String str2) {
        int[][] iArr = e.get(str);
        if (iArr != null) {
            str2.hashCode();
            switch (str2) {
                case "A":
                    return iArr[1];
                case "p":
                    return iArr[4];
                case "r":
                    return iArr[3];
                case "s":
                    return iArr[5];
                case "v":
                case "v1":
                    return iArr[0];
                case "v2":
                    return iArr[2];
            }
        }
        return null;
    }

    public static int[] R0(String str, int i2, int i3, boolean z) {
        String strS0 = S0(str);
        if (WearUtils.e1(strS0)) {
            return null;
        }
        String[] strArrSplit = strS0.split(",");
        if (strArrSplit.length == 1 || i2 == 2) {
            int[] iArrQ0 = Q0(str, strArrSplit.length == 1 ? strArrSplit[0] : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            if (iArrQ0 == null || iArrQ0.length < 4) {
                return null;
            }
            return new int[]{a0(iArrQ0, i3, z)};
        }
        if (strArrSplit.length != 2 || i2 != 1) {
            return null;
        }
        int[] iArr = new int[2];
        int[] iArrQ02 = Q0(str, strArrSplit[0]);
        if (iArrQ02 != null && iArrQ02.length >= 4) {
            iArr[0] = a0(iArrQ02, i3, z);
        }
        int[] iArrQ03 = Q0(str, strArrSplit[1]);
        if (iArrQ03 == null || iArrQ03.length < 4) {
            return iArr;
        }
        iArr[1] = a0(iArrQ03, i3, z);
        return iArr;
    }

    public static String S0(String str) {
        int[][] iArr = e.get(str);
        String str2 = PSOProgramService.VS_Key;
        String str3 = "";
        if (iArr != null && iArr.length != 1) {
            if (iArr.length >= 8) {
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (iArr[i2].length > 0) {
                        if (i2 == 0) {
                            str3 = PSOProgramService.VS_Key;
                        } else if (i2 == 2) {
                            str3 = "v1,v2";
                        } else if (i2 == 3) {
                            str3 = str3 + ",r";
                        } else if (i2 == 4) {
                            str3 = str3 + ",p";
                        } else if (i2 == 5) {
                            str3 = str3 + ",s";
                        } else if (i2 == 6) {
                            str3 = str3 + ",t";
                        } else if (i2 == 7) {
                            str3 = str3 + ",f";
                        } else if (i2 == 8) {
                            str3 = str3 + ",d";
                        } else if (i2 == 9) {
                            str3 = "v1,v2,v3";
                        } else if (i2 == 10) {
                            str3 = str3 + ",pos";
                        }
                    }
                }
            }
            str2 = str3;
        }
        return str2.startsWith(",") ? str2.substring(1) : str2;
    }

    public static int U0(String str, int i2, boolean z) {
        Integer[] numArr = d.get(str);
        if (numArr == null) {
            return 0;
        }
        if (z) {
            if (numArr.length >= 2) {
                return numArr[i2 % 2].intValue();
            }
            return 0;
        }
        if (numArr.length >= 3) {
            return numArr[2].intValue();
        }
        return 0;
    }

    public static String X0(String str) {
        for (Map.Entry<String, String> entry : b.entrySet()) {
            String strS0 = S0(entry.getKey());
            if (!WearUtils.e1(strS0) && !WearUtils.e1(str) && strS0.equals(str)) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static String Z(String str) {
        List<ToyConfigInfoBean> list = t;
        String showName = "";
        if (list != null) {
            for (ToyConfigInfoBean toyConfigInfoBean : list) {
                if (toyConfigInfoBean.getSymbol().contains(str)) {
                    showName = toyConfigInfoBean.getShowName();
                }
            }
        }
        return showName;
    }

    public static void Z2(String str) {
        List array;
        JSONObject object = JSON.parseObject(str);
        JSONObject jSONObject = object.getJSONObject("data");
        int intValue = object.getIntValue("dv");
        String string = jSONObject.getString("info");
        if (WearUtils.e1(string) || (array = JSON.parseArray(string, ToyConfigInfoBean.class)) == null || array.size() == 0) {
            return;
        }
        t.clear();
        t.addAll(array);
        if (WearUtils.v) {
            if (u < intValue) {
                u = intValue;
            }
        } else if (v < intValue) {
            v = intValue;
        }
        s.clear();
        for (int i2 = 0; i2 < t.size(); i2++) {
            ToyConfigInfoBean toyConfigInfoBean = t.get(i2);
            b.put(toyConfigInfoBean.getType(), toyConfigInfoBean.getShowName());
            Map<String, Integer> map = c;
            if (map.get(toyConfigInfoBean.getType()) == null) {
                map.put(toyConfigInfoBean.getType(), Integer.valueOf(R.drawable.nav_unknown_1));
            }
            Map<String, Integer[]> map2 = d;
            if (map2.get(toyConfigInfoBean.getType()) == null) {
                map2.put(toyConfigInfoBean.getType(), new Integer[]{Integer.valueOf(R.drawable.nav_unknown_1), Integer.valueOf(R.drawable.nav_unknown_2), Integer.valueOf(R.drawable.content_icon_gray)});
            }
            if (toyConfigInfoBean.getFunc() != null) {
                ToyConfigInfoBean.FuncBean func = toyConfigInfoBean.getFunc();
                int length = ToyConfigInfoBean.class.getFields().length;
                int[][] iArr = {new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0]};
                if (func.isV()) {
                    List<String> list = s;
                    if (!list.contains(PSOProgramService.VS_Key)) {
                        list.add(PSOProgramService.VS_Key);
                        list.add("v1");
                        list.add("v2");
                        String str2 = "此处执行==" + list.toString();
                    }
                    iArr[0] = new int[]{R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_blue, R.drawable.content_button_vibration_blue};
                }
                if (toyConfigInfoBean.getType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    iArr[0] = new int[]{R.drawable.chat_toolbar_toyfunction_speed, R.drawable.chat_toolbar_toyfunction_speed, R.drawable.chat_toolbar_toyfunction_speed, R.drawable.chat_toolbar_toyfunction_speed};
                }
                if (func.isV1() && func.isV2() && func.isV3()) {
                    iArr[9] = new int[]{R.drawable.content_button_vibration_purple, R.drawable.content_button_vibration_purple, R.drawable.content_button_vibration_purple, R.drawable.content_button_vibration_purple, 0};
                    List<String> list2 = s;
                    list2.add("v3");
                    String str3 = "此处执行22222==" + list2.toString();
                } else if (func.isV1() && func.isV2()) {
                    if (toyConfigInfoBean.getType().equalsIgnoreCase("qa01")) {
                        iArr[2] = new int[]{R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_pink, R.drawable.accout_delete_confirm_background, R.drawable.content_button_suck_cyan, 1};
                    } else {
                        iArr[2] = new int[]{R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_blue, R.drawable.content_button_vibration_blue, 0};
                    }
                }
                if (func.isR()) {
                    List<String> list3 = s;
                    if (!list3.contains(StreamManagement.AckRequest.ELEMENT)) {
                        list3.add(StreamManagement.AckRequest.ELEMENT);
                    }
                    iArr[3] = new int[]{R.drawable.content_button_rotation_blue, R.drawable.content_button_rotation_blue, R.drawable.content_button_rotation_blue, R.drawable.content_button_rotation_blue};
                }
                if (func.isP()) {
                    List<String> list4 = s;
                    if (!list4.contains("p")) {
                        list4.add("p");
                    }
                    iArr[4] = new int[]{R.drawable.content_button_pump_pink, R.drawable.content_button_pump_pink, R.drawable.content_button_pump_pink, R.drawable.content_button_pump_pink};
                }
                if (func.isS()) {
                    List<String> list5 = s;
                    if (!list5.contains("s")) {
                        list5.add("s");
                    }
                    iArr[5] = new int[]{R.drawable.content_button_suck_cyan, R.drawable.content_button_suck_cyan, R.drawable.content_button_suck_cyan, R.drawable.content_button_suck_cyan};
                }
                if (func.isT()) {
                    List<String> list6 = s;
                    if (!list6.contains("t")) {
                        list6.add("t");
                    }
                    iArr[6] = new int[]{R.drawable.chat_toolbar_toyfunction_speed, R.drawable.chat_toolbar_toyfunction_speed, R.drawable.chat_toolbar_toyfunction_speed, R.drawable.chat_toolbar_toyfunction_speed};
                }
                if (func.isF()) {
                    List<String> list7 = s;
                    if (!list7.contains("f")) {
                        list7.add("f");
                    }
                    iArr[7] = new int[]{R.drawable.chat_toolbar_toyfunction_fingering, R.drawable.chat_toolbar_toyfunction_fingering, R.drawable.chat_toolbar_toyfunction_fingering_60, R.drawable.chat_toolbar_toyfunction_fingering_60};
                }
                if (func.isD()) {
                    List<String> list8 = s;
                    if (!list8.contains(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                        list8.add(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                    }
                    iArr[8] = new int[]{R.drawable.chat_toolbar_toyfunction_fingering, R.drawable.chat_toolbar_toyfunction_fingering, R.drawable.chat_toolbar_toyfunction_fingering_60, R.drawable.chat_toolbar_toyfunction_fingering_60};
                }
                if (func.isPos()) {
                    List<String> list9 = s;
                    if (!list9.contains("pos")) {
                        list9.add("pos");
                    }
                    iArr[10] = new int[]{R.drawable.chat_toolbar_toyfunction_fingering, R.drawable.chat_toolbar_toyfunction_fingering, R.drawable.chat_toolbar_toyfunction_fingering_60, R.drawable.chat_toolbar_toyfunction_fingering_60};
                }
                e.put(toyConfigInfoBean.getType(), iArr);
            } else {
                e.put(toyConfigInfoBean.getType(), new int[][]{new int[]{R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_pink, R.drawable.content_button_vibration_blue, R.drawable.content_button_vibration_blue}});
            }
        }
        String str4 = "setToyConfig: 所有的功能=" + s;
        Iterator<Toy> it = WearUtils.x.G().o().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            String name = next.getName();
            Map<String, String> map3 = b;
            if (!TextUtils.equals(name, map3.get(next.getType()))) {
                next.setName(map3.get(next.getType()));
            }
        }
    }

    public static int a0(int[] iArr, int i2, boolean z) {
        return i2 == 0 ? z ? iArr[1] : iArr[0] : z ? iArr[3] : iArr[2];
    }

    public static boolean c(String str) {
        return str.startsWith("LVS-S") || str.startsWith("LVS_Z") || str.startsWith("LVS-Z") || str.startsWith("LVS-L") || str.startsWith("LVS-B");
    }

    public static int c2(String str, View view) {
        if (str.contains("pos")) {
            if (view != null) {
                view.setVisibility(0);
            }
            return 0;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return 8;
    }

    public static boolean e(String str) {
        return !WearUtils.e1(w(str.split(SignatureImpl.INNER_SEP)[0].toLowerCase()));
    }

    public static final String g(String str, String str2) {
        String str3;
        if (WearUtils.e1(str) || WearUtils.e1(str2)) {
            return "";
        }
        String[] strArrSplit = str.split(TouchControlView.O);
        String[] strArrSplit2 = str2.split(TouchControlView.O);
        if (strArrSplit.length == strArrSplit2.length) {
            str3 = "";
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                String str4 = strArrSplit[i2];
                if (!WearUtils.e1(str4)) {
                    Map<String, String[]> map = j;
                    if (!map.containsKey(str4) || WearUtils.e1(strArrSplit2[i2])) {
                        break;
                    }
                    String[] strArr = map.get(str4);
                    if (!WearUtils.j1(strArr) && strArr.length >= 2) {
                        int i3 = 100 / Integer.parseInt(strArr[1]);
                        if (Integer.parseInt(strArrSplit2[i2]) > 0 && Integer.parseInt(strArrSplit2[i2]) / i3 == 0 && str4.equals("p")) {
                            strArrSplit2[i2] = "" + i3;
                        }
                        str3 = str3 + (Integer.parseInt(strArrSplit2[i2]) / i3) + TouchControlView.O;
                    }
                }
            }
        } else {
            str3 = "";
        }
        if (str3.indexOf(TouchControlView.O) <= 0) {
            return str3;
        }
        String strSubstring = str3.substring(0, str3.length() - 1);
        return strArrSplit.length != strSubstring.split(TouchControlView.O).length ? "" : strSubstring;
    }

    public static final String h(String str, String str2) {
        if (WearUtils.e1(str) || WearUtils.e1(str2) || WearUtils.e1(str)) {
            return "";
        }
        Map<String, String[]> map = j;
        if (!map.containsKey(str) || WearUtils.e1(str2)) {
            return "";
        }
        int i2 = 100 / Integer.parseInt(map.get(str)[1]);
        if (Integer.parseInt(str2) > 0 && Integer.parseInt(str2) / i2 == 0 && str.equals("p")) {
            str2 = "" + i2;
        }
        return "" + (Integer.parseInt(str2) / i2);
    }

    public static boolean h1(String str) {
        return !WearUtils.e1(str) && str.toLowerCase().startsWith("ag:");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String i(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = com.wear.widget.control.TouchControlView.O
            java.lang.String[] r0 = r8.split(r0)
            java.lang.String r1 = com.wear.widget.control.TouchControlView.O
            java.lang.String[] r1 = r9.split(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r8 = " "
            r2.append(r8)
            r2.append(r9)
            java.lang.String r8 = r2.toString()
            java.lang.String r9 = "test"
            dc.xe3.a(r9, r8)
            int r8 = r0.length
            int r9 = r1.length
            java.lang.String r2 = ""
            if (r8 != r9) goto L98
            r8 = 0
            r3 = r2
            r9 = 0
        L2e:
            int r4 = r0.length
            if (r9 >= r4) goto L97
            r4 = r0[r9]
            r5 = r1[r9]
            java.util.Map<java.lang.String, java.lang.String[]> r6 = dc.ws1.j
            java.lang.Object r4 = r6.get(r4)
            java.lang.String[] r4 = (java.lang.String[]) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            int r5 = r5.intValue()
            boolean r6 = com.wear.util.WearUtils.j1(r4)
            if (r6 != 0) goto L69
            int r6 = r4.length
            r7 = 2
            if (r6 < r7) goto L69
            r6 = 1
            r4 = r4[r6]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r4.intValue()
            r6 = 100
            int r4 = r6 / r4
            if (r5 > 0) goto L61
            r5 = 0
        L61:
            int r5 = r5 * r4
            if (r5 <= r6) goto L66
            goto L67
        L66:
            r6 = r5
        L67:
            if (r6 >= 0) goto L6a
        L69:
            r6 = 0
        L6a:
            boolean r4 = com.wear.util.WearUtils.e1(r3)
            if (r4 == 0) goto L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            goto L94
        L80:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = ","
            r4.append(r3)
            r4.append(r6)
            java.lang.String r3 = r4.toString()
        L94:
            int r9 = r9 + 1
            goto L2e
        L97:
            r2 = r3
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ws1.i(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean i1(String str) {
        return !WearUtils.e1(str) && str.toLowerCase().startsWith("ai:");
    }

    public static String j0(String str, String str2) {
        return "xmachine".equalsIgnoreCase(str) ? ah4.e(R.string.toy_function_thrust_speed) : str2;
    }

    public static String l0(String str) {
        int[][] iArr = e.get(str);
        String str2 = PSOProgramService.VS_Key;
        String str3 = "";
        if (iArr != null && iArr.length != 1) {
            if (iArr.length >= 8) {
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (iArr[i2].length > 0) {
                        if (i2 == 0) {
                            str3 = PSOProgramService.VS_Key;
                        } else if (i2 == 2) {
                            str3 = "v1,v2";
                        } else if (i2 == 3) {
                            str3 = str3 + ",r";
                        } else if (i2 == 4) {
                            str3 = str3 + ",p";
                        } else if (i2 == 5) {
                            str3 = str3 + ",s";
                        } else if (i2 == 6) {
                            str3 = str3 + ",t";
                        } else if (i2 == 7) {
                            str3 = str3 + ",f";
                        } else if (i2 == 8) {
                            str3 = str3 + ",d";
                        } else if (i2 == 9) {
                            str3 = "v1,v2,v3";
                        } else if (i2 == 10) {
                            str3 = str3 + ",t";
                        }
                    }
                }
            }
            str2 = str3;
        }
        return str2.startsWith(",") ? str2.substring(1) : str2;
    }

    public static int m(String str, View view) {
        if (str.contains(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
            if (view != null) {
                view.setVisibility(0);
            }
            return 0;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return 8;
    }

    public static int m2(boolean z, boolean z2, int i2) {
        return (i2 < 0 || i2 > 5) ? (i2 < 6 || i2 > 10) ? (i2 < 11 || i2 > 19) ? i2 == 20 ? z ? R.drawable.mytoys_toy_battery_20_red : !z2 ? R.drawable.nav_toy_battery_20_red : R.drawable.nav_toy_battery_transparency_20_red : (i2 < 21 || i2 > 29) ? (i2 < 30 || i2 > 39) ? (i2 < 40 || i2 > 49) ? (i2 < 50 || i2 > 59) ? (i2 < 60 || i2 > 69) ? (i2 < 70 || i2 > 79) ? (i2 < 80 || i2 > 89) ? (i2 < 90 || i2 > 99) ? i2 == 100 ? z ? R.drawable.mytoys_toy_battery_100 : !z2 ? R.drawable.nav_toy_battery_100 : R.drawable.nav_toy_battery_transparency_100 : z ? R.drawable.mytoys_toy_battery_100 : !z2 ? R.drawable.nav_toy_battery_100 : R.drawable.nav_toy_battery_transparency_100 : z ? R.drawable.mytoys_toy_battery_90 : !z2 ? R.drawable.nav_toy_battery_90 : R.drawable.nav_toy_battery_transparency_90 : z ? R.drawable.mytoys_toy_battery_80 : !z2 ? R.drawable.nav_toy_battery_80 : R.drawable.nav_toy_battery_transparency_80 : z ? R.drawable.mytoys_toy_battery_70 : !z2 ? R.drawable.nav_toy_battery_70 : R.drawable.nav_toy_battery_transparency_70 : z ? R.drawable.mytoys_toy_battery_60 : !z2 ? R.drawable.nav_toy_battery_60 : R.drawable.nav_toy_battery_transparency_60 : z ? R.drawable.mytoys_toy_battery_50 : !z2 ? R.drawable.nav_toy_battery_50 : R.drawable.nav_toy_battery_transparency_50 : z ? R.drawable.mytoys_toy_battery_40 : !z2 ? R.drawable.nav_toy_battery_40 : R.drawable.nav_toy_battery_transparency_40 : z ? R.drawable.mytoys_toy_battery_30 : !z2 ? R.drawable.nav_toy_battery_30 : R.drawable.nav_toy_battery_transparency_30 : z ? R.drawable.mytoys_toy_battery_20 : !z2 ? R.drawable.nav_toy_battery_20 : R.drawable.nav_toy_battery_transparency_20 : z ? R.drawable.mytoys_toy_battery_10 : !z2 ? R.drawable.nav_toy_battery_10 : R.drawable.nav_toy_battery_transparency_10 : z ? R.drawable.mytoys_toy_battery_5 : !z2 ? R.drawable.nav_toy_battery_5 : R.drawable.nav_toy_battery_transparency_5 : z ? R.drawable.mytoys_toy_battery_0 : !z2 ? R.drawable.nav_toy_battery_0 : R.drawable.nav_toy_battery_transparency_0;
    }

    public static int n(String str, View view) {
        if (!TextUtils.isEmpty(str) && str != null) {
            if (str.indexOf(",p") != -1) {
                if (view != null) {
                    view.setVisibility(0);
                }
                return 0;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
        return 8;
    }

    public static boolean n1(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit == null || strArrSplit.length <= 0) {
            return false;
        }
        int length = strArrSplit.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (!s.contains(strArrSplit[i2])) {
                z = false;
                break;
            }
            i2++;
        }
        return z;
    }

    public static int o(String str, View view) {
        if (!TextUtils.isEmpty(str) && str != null) {
            if (str.indexOf(",r") != -1 && str.indexOf(",v2") == -1) {
                if (view != null) {
                    view.setVisibility(0);
                }
                return 0;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
        return 8;
    }

    public static boolean o1(String str) {
        String[] strArrSplit;
        if (str.startsWith("autoswith") || str.startsWith("evt:")) {
            return false;
        }
        boolean zFind = Pattern.compile("^\\w+:\\d+:\\w+").matcher(str).find();
        if (zFind && (strArrSplit = str.split(SignatureImpl.INNER_SEP)) != null && strArrSplit.length == 3) {
            String str2 = strArrSplit[2];
            if (WearUtils.e1(str2) || str2.replace(";", "").length() != 12) {
                rp1.n(str);
                return false;
            }
        }
        return zFind;
    }

    public static int p(String str, View view) {
        if (!TextUtils.isEmpty(str) && str != null) {
            if (str.indexOf(",v2") != -1) {
                if (view != null) {
                    view.setVisibility(0);
                }
                return 0;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
        return 8;
    }

    public static int q(String str, View view) {
        if (str.contains("s")) {
            if (view != null) {
                view.setVisibility(0);
            }
            return 0;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return 8;
    }

    public static void q3(ImageView imageView, int i2) {
        String str = "battery22222===" + i2;
        if (imageView == null) {
            return;
        }
        if (i2 == -1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(m2(false, false, i2));
        }
    }

    public static int r(String str, View view) {
        if (!TextUtils.isEmpty(str) && str != null) {
            if (str.contains("s")) {
                if (view != null) {
                    view.setVisibility(0);
                }
                return 0;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
        return 8;
    }

    public static void r3(ImageView imageView, int i2) {
        String str = "battery33333===" + i2;
        if (imageView == null) {
            return;
        }
        if (i2 == -1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(m2(false, true, i2));
        }
    }

    public static int s(String str, View view) {
        if (!TextUtils.isEmpty(str) && str != null) {
            if (str.indexOf(",v3") != -1) {
                if (view != null) {
                    view.setVisibility(0);
                }
                return 0;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
        return 8;
    }

    public static int t(String str, View view) {
        if (str.contains(PSOProgramService.VS_Key)) {
            if (view != null) {
                view.setVisibility(0);
            }
            return 0;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return 8;
    }

    public static int u(String str, View view) {
        if (!TextUtils.isEmpty(str) && str != null) {
            if (str.contains(",f")) {
                if (view != null) {
                    view.setVisibility(0);
                }
                return 0;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
        return 8;
    }

    public static int v(String str, View view) {
        if (str.contains("t")) {
            if (view != null) {
                view.setVisibility(0);
            }
            return 0;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        return 8;
    }

    public static String w(String str) {
        if (WearUtils.e1(str)) {
            return "";
        }
        String lowerCase = str.toLowerCase();
        for (int i2 = 0; i2 < t.size(); i2++) {
            ToyConfigInfoBean toyConfigInfoBean = t.get(i2);
            if (toyConfigInfoBean != null) {
                if (toyConfigInfoBean.getType().equals(lowerCase)) {
                    return toyConfigInfoBean.getType();
                }
                Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
                while (it.hasNext()) {
                    if (it.next().equals(lowerCase)) {
                        return toyConfigInfoBean.getType();
                    }
                }
            }
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static String w0(String str) {
        return StreamManagement.AckRequest.ELEMENT.equals(str) ? ah4.e(R.string.toy_control_rotate) : "p".equals(str) ? ah4.e(R.string.toy_control_pump) : "v1".equals(str) ? ah4.e(R.string.toy_control_vibrate) : "v2".equals(str) ? ah4.e(R.string.toy_control_vibrate) : "v3".equals(str) ? ah4.e(R.string.toy_control_vibrate) : "t".equals(str) ? ah4.e(R.string.toy_function_thrust_speed) : "s".equals(str) ? ah4.e(R.string.function_suction) : "f".equals(str) ? ah4.e(R.string.function_fingering) : GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(str) ? ah4.e(R.string.function_depth) : "pos".equals(str) ? ah4.e(R.string.function_pos) : ah4.e(R.string.toy_control_vibrate);
    }

    public String A() {
        return (WearUtils.e1(this.deviceType) || this.deviceType.split(SignatureImpl.INNER_SEP).length != 3) ? R() : this.deviceType.split(SignatureImpl.INNER_SEP)[2].toLowerCase().replace(";", "");
    }

    public int[] A0() {
        List<ToyConfigInfoBean.ProgramBean> program;
        int[] iArr = {5, 12, 20};
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (program = toyConfigInfoBean.getProgram()) == null || program.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType())) {
            return iArr;
        }
        for (int i2 = 0; i2 < program.size(); i2++) {
            ToyConfigInfoBean.ProgramBean programBean = program.get(i2);
            if (this.version.intValue() <= programBean.getMaxv().intValue() && this.version.intValue() >= programBean.getMinv().intValue() && !WearUtils.e1(programBean.getP())) {
                String[] strArrSplit = programBean.getL().split(",");
                if (strArrSplit.length > 0) {
                    iArr = new int[strArrSplit.length];
                    for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                        iArr[i3] = Integer.parseInt(strArrSplit[i3]);
                    }
                }
                return iArr;
            }
        }
        return iArr;
    }

    public boolean A1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase("ea")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void A2(boolean z) {
        this.f01IsOff = z;
    }

    public String B() {
        return this.batchId;
    }

    public ArrayList<String> B0() {
        List<ToyConfigInfoBean.ProgramBean> program;
        i iVar = new i();
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (program = toyConfigInfoBean.getProgram()) == null || program.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType())) {
            return iVar;
        }
        for (int i2 = 0; i2 < program.size(); i2++) {
            ToyConfigInfoBean.ProgramBean programBean = program.get(i2);
            if (this.version.intValue() <= programBean.getMaxv().intValue() && this.version.intValue() >= programBean.getMinv().intValue() && !WearUtils.e1(programBean.getP())) {
                String[] strArrSplit = programBean.getP().split(",");
                if (strArrSplit.length > 0) {
                    iVar.clear();
                    iVar.addAll(Arrays.asList(strArrSplit));
                }
                return iVar;
            }
        }
        return iVar;
    }

    public boolean B1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(XHTMLText.H)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void B2(long j2) {
        this.a = j2;
    }

    public List<Integer> C() {
        return this.battayList;
    }

    public int C0() {
        List<ToyConfigInfoBean.ProgramBean> program;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (program = toyConfigInfoBean.getProgram()) == null || program.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType())) {
            return 500;
        }
        for (int i2 = 0; i2 < program.size(); i2++) {
            ToyConfigInfoBean.ProgramBean programBean = program.get(i2);
            if (this.version.intValue() <= programBean.getMaxv().intValue() && this.version.intValue() >= programBean.getMinv().intValue()) {
                return programBean.isFast() ? 100 : 500;
            }
        }
        return 500;
    }

    public boolean C1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals("j")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void C2(long j2) {
        this.getCheckBindToyErrorTime = j2;
    }

    public int D() {
        if (isVirtualToy()) {
            return 50;
        }
        return this.battery;
    }

    public String D0() {
        if (WearUtils.e1(this.realType)) {
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean != null) {
                this.realType = toyConfigInfoBean.getRealType();
            } else {
                a3();
            }
        }
        if (WearUtils.e1(this.realType) && !WearUtils.e1(this.type)) {
            this.realType = jf3.b(this.type);
        } else if (WearUtils.e1(this.realType) && WearUtils.e1(this.type)) {
            this.realType = "Unknown";
        }
        return this.realType;
    }

    public boolean D1() {
        return this.isLanApiUpdateRequest;
    }

    public void D2(long j2) {
        this.getDfuErrorTime = j2;
    }

    public long E() {
        return this.batteryRequestTime;
    }

    public boolean E0() {
        return this.connectTryNumb > 15;
    }

    public boolean E1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            for (String str : toyConfigInfoBean.getSymbol()) {
                if (str.equalsIgnoreCase("b") || str.equalsIgnoreCase("toyb")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void E2(int i2) {
        this.isCheckBindToy = i2;
    }

    public int F() {
        return this.bindType;
    }

    public Long F0() {
        return this.rquestConnectTime;
    }

    public boolean F1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals("fs")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void F2(int i2) {
        this.isDfuEnd = i2;
    }

    public List<Map<String, Long>> G() {
        return this.commandList;
    }

    public int G0() {
        return this.rssi;
    }

    public boolean G1() {
        return !TextUtils.isEmpty(v0());
    }

    public void G2(int i2) {
        this.isPowerOff = i2;
    }

    public int H() {
        return this.connectApp;
    }

    public int H0() {
        int i2 = this.rssi;
        return i2 >= -60 ? R.drawable.icon_signal_level4 : i2 >= -70 ? R.drawable.icon_signal_level3 : i2 >= -80 ? R.drawable.icon_signal_level2 : i2 < -80 ? R.drawable.icon_signal_level1 : R.drawable.icon_signal_level4;
    }

    public boolean H1() {
        return TextUtils.equals(this.type, "nora");
    }

    public void H2(Integer num) {
        this.isSelect = num;
    }

    public List<String> I0() {
        return this.rssiList;
    }

    public boolean I1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            for (String str : toyConfigInfoBean.getSymbol()) {
                if (str.equalsIgnoreCase("c") || str.equalsIgnoreCase("a") || str.equalsIgnoreCase("toyc") || str.equalsIgnoreCase("toya")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void I2(int i2) {
        this.lanApiUpdateCount = i2;
    }

    public long J() {
        return this.connectScanTime;
    }

    public int J0() {
        String strD0 = D0();
        return (TextUtils.isEmpty(strD0) || strD0.toLowerCase().contains(EnvironmentCompat.MEDIA_UNKNOWN)) ? R.drawable.toy_icon_unknow : R.drawable.toy_icon_search;
    }

    public void J2(boolean z) {
        this.isLanApiUpdateRequest = z;
    }

    public int K() {
        return this.connectTryNumb;
    }

    public void K2(int i2) {
        this.led = i2;
    }

    public int L() {
        return this.connectType;
    }

    public void L2(Integer num) {
        this.ledSetting = num;
    }

    public String M0() {
        String str;
        int iN3 = n3();
        String fullName = this.name;
        if (this.toyConfigDataBean == null) {
            a3();
        }
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean != null && !WearUtils.e1(toyConfigInfoBean.getFullName())) {
            fullName = this.toyConfigDataBean.getFullName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fullName);
        if (iN3 > 1) {
            str = " " + iN3;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean M1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals(XHTMLText.Q)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void M2(String str) {
        this.logFormApp = str;
    }

    public String N0() {
        String str;
        int iN3 = n3();
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (iN3 > 1) {
            str = " " + iN3;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean N1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals("qa")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N2(String str) {
        this.lvsMotorConfig = str;
    }

    public String O0() {
        String str;
        int iN3 = n3();
        StringBuilder sb = new StringBuilder();
        sb.append(D0());
        if (iN3 > 1) {
            str = " " + iN3;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean O1() {
        return this.isRealDeviceType;
    }

    public void O2(int i2) {
        this.missionSolo = i2;
    }

    public String P() {
        return this.type;
    }

    public ToyConfigInfoBean P0() {
        return this.toyConfigDataBean;
    }

    public boolean P1() {
        Integer num = this.isSelect;
        return num != null && num.intValue() > 0;
    }

    public void P2(int[] iArr) {
        this.missionTchLvl = iArr;
    }

    public String Q() {
        return this.defineRename;
    }

    public boolean Q1() {
        ToyConfigInfoBean.FuncBean func;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (func = toyConfigInfoBean.getFunc()) == null) {
            return false;
        }
        return func.isP();
    }

    public void Q2(String str) {
        this.pinStatus = str;
    }

    public String R() {
        if (this.deviceId == null && !WearUtils.e1(this.deviceType) && this.deviceType.split(SignatureImpl.INNER_SEP).length == 3) {
            this.deviceId = this.deviceType.split(SignatureImpl.INNER_SEP)[2].toLowerCase().replace(";", "");
        }
        return this.deviceId;
    }

    public boolean R1(boolean z) {
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null) {
            return false;
        }
        if (z) {
            if (toyConfigInfoBean.getSupportMotherboradLEDColor() != null && !this.toyConfigDataBean.getSupportMotherboradLEDColor().isEmpty()) {
                for (RangeBean rangeBean : this.toyConfigDataBean.getSupportMotherboradLEDColor()) {
                    if (rangeBean != null && rangeBean.getMinv().intValue() <= a1() && rangeBean.getMaxv().intValue() >= a1()) {
                        return true;
                    }
                }
            }
        } else if (toyConfigInfoBean.getSupportLEDColor() != null && !this.toyConfigDataBean.getSupportLEDColor().isEmpty()) {
            for (RangeBean rangeBean2 : this.toyConfigDataBean.getSupportLEDColor()) {
                if (rangeBean2 != null && rangeBean2.getMinv().intValue() <= a1() && rangeBean2.getMaxv().intValue() >= a1()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void R2(long j2) {
        this.powerOffTime = j2;
    }

    public String S() {
        return this.deviceName;
    }

    public boolean S1() {
        String strR0 = r0();
        if (strR0 == null) {
            return false;
        }
        return strR0.contains("434150");
    }

    public void S2(boolean z) {
        this.isRealDeviceType = z;
    }

    public String T(String str) {
        String[] strArrSplit;
        return (WearUtils.e1(str) || (strArrSplit = str.split(SignatureImpl.INNER_SEP)) == null || strArrSplit.length != 3) ? "" : strArrSplit[2].replace(";", "");
    }

    public int T0() {
        String strD0 = D0();
        return (TextUtils.isEmpty(strD0) || strD0.toLowerCase().contains(EnvironmentCompat.MEDIA_UNKNOWN)) ? R.drawable.toy_icon_unknow : R.drawable.toy_icon_nora;
    }

    public boolean T1() {
        ToyConfigInfoBean.FuncBean func;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (func = toyConfigInfoBean.getFunc()) == null) {
            return false;
        }
        return func.isR();
    }

    public void T2(String str) {
        this.realType = str;
    }

    public int U(boolean z) {
        return (z ? Integer.valueOf(R.drawable.content_icon_gray) : Integer.valueOf(R.drawable.nav_unknown_1)).intValue();
    }

    public boolean U1() {
        ToyConfigInfoBean.FuncBean func;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        return toyConfigInfoBean != null && (func = toyConfigInfoBean.getFunc()) != null && func.isV1() && func.isV2();
    }

    public void U2() {
        if (WearUtils.e1(S()) || S().toLowerCase().startsWith("lvs")) {
            return;
        }
        if (WearUtils.e1(Q()) || !S().equals(Q())) {
            v2(S());
            ToyRename toyRenameFindToyName = DaoUtils.getToyRenameDao().findToyName(WearUtils.y.r(), getAddress());
            if (toyRenameFindToyName != null) {
                toyRenameFindToyName.setName(S());
                DaoUtils.getToyRenameDao().updateOrAdd(toyRenameFindToyName);
                return;
            }
            ToyRename toyRename = new ToyRename();
            toyRename.setEmail(WearUtils.y.r());
            toyRename.setName(S());
            toyRename.setAddress(getAddress());
            DaoUtils.getToyRenameDao().updateOrAdd(toyRename);
        }
    }

    public int V0() {
        int i2 = this.rssi;
        if (i2 < 20 || i2 >= 120) {
            return 0;
        }
        if (i2 < 90) {
            return 3;
        }
        return i2 < 105 ? 2 : 1;
    }

    public boolean V1() {
        ToyConfigInfoBean.FuncBean func;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        return toyConfigInfoBean != null && (func = toyConfigInfoBean.getFunc()) != null && func.isV1() && func.isV2() && func.isF();
    }

    public void V2(Long l2) {
        this.rquestConnectTime = l2;
    }

    public int W() {
        return this.disConnectType;
    }

    public List<String> W0() {
        if (t == null) {
            return null;
        }
        if (this.toyConfigDataBean == null) {
            a3();
        }
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null) {
            return null;
        }
        return toyConfigInfoBean.getSymbol();
    }

    public boolean W1() {
        List<RangeBean> pinCodeSupport;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (pinCodeSupport = toyConfigInfoBean.getPinCodeSupport()) == null || pinCodeSupport.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType()) || e1() == null) {
            return false;
        }
        for (int i2 = 0; i2 < pinCodeSupport.size(); i2++) {
            if (e1().intValue() <= pinCodeSupport.get(i2).getMaxv().intValue() && e1().intValue() >= pinCodeSupport.get(i2).getMinv().intValue()) {
                return true;
            }
        }
        return false;
    }

    public void W2(int i2) {
        this.rssi = i2;
    }

    public long X() {
        return this.a;
    }

    public boolean X1() {
        return this.synControlAnimation;
    }

    public void X2(Integer num) {
        this.simpleToy = num.intValue();
    }

    public String Y() {
        String str = this.name;
        if (this.toyConfigDataBean == null) {
            a3();
        }
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        return (toyConfigInfoBean == null || WearUtils.e1(toyConfigInfoBean.getFullName())) ? str : this.toyConfigDataBean.getFullName();
    }

    public String Y0() {
        String[] strArrSplit;
        return (WearUtils.e1(this.deviceType) || (strArrSplit = this.deviceType.split(SignatureImpl.INNER_SEP)) == null || strArrSplit.length != 3) ? "" : strArrSplit[0].toLowerCase();
    }

    public boolean Y1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals("t")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void Y2(boolean z) {
        this.synControlAnimation = z;
    }

    public String Z0(int i2) {
        if (F1()) {
            if (i2 == 1) {
                return "Mini XMachine";
            }
            if (i2 == 2) {
                return Toy.TOY_XMACHINE;
            }
            if (i2 == 3) {
                return "Mini\nXMachine";
            }
        }
        return this.name;
    }

    public boolean Z1() {
        return this.isToyListAdd;
    }

    public void a() {
        int i2 = this.connectTryNumb;
        if (i2 < 30) {
            this.connectTryNumb = i2 + 1;
        }
    }

    public int a1() {
        String[] strArrSplit;
        int iIntValue = this.version.intValue();
        try {
            return (WearUtils.e1(this.deviceType) || (strArrSplit = this.deviceType.split(SignatureImpl.INNER_SEP)) == null || strArrSplit.length != 3) ? iIntValue : Integer.parseInt(strArrSplit[1]);
        } catch (Exception unused) {
            return iIntValue;
        }
    }

    public boolean a2() {
        return this.isTransfer;
    }

    public void a3() {
        if (WearUtils.e1(this.type)) {
            return;
        }
        String strY0 = this.type;
        if (strY0.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN)) {
            strY0 = Y0();
        }
        for (int i2 = 0; i2 < t.size(); i2++) {
            ToyConfigInfoBean toyConfigInfoBean = t.get(i2);
            if (toyConfigInfoBean.getType().equals(strY0)) {
                this.toyConfigDataBean = toyConfigInfoBean;
                this.realType = toyConfigInfoBean.getRealType();
                this.type = toyConfigInfoBean.getType();
                return;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals(strY0)) {
                    this.toyConfigDataBean = toyConfigInfoBean;
                    this.realType = toyConfigInfoBean.getRealType();
                    this.type = toyConfigInfoBean.getType();
                    return;
                }
            }
        }
    }

    public void b() {
        this.lanApiUpdateCount++;
    }

    public String b0() {
        int iN3 = n3();
        if (iN3 <= 1) {
            return "";
        }
        return iN3 + "";
    }

    public String b1() {
        return WearUtils.e1(Y()) ? "U" : Y().substring(0, 1).toUpperCase();
    }

    public boolean b2() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals(PSOProgramService.VS_Key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b3(ToyConfigInfoBean toyConfigInfoBean) {
        this.toyConfigDataBean = toyConfigInfoBean;
    }

    public long c0() {
        return this.getCheckBindToyErrorTime;
    }

    public DfuBean c1() {
        return this.updateDfu;
    }

    public void c3(boolean z) {
        this.isToyListAdd = z;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean canSetLed() {
        return "lush".equals(getType()) || "hush".equals(getType()) || "edge".equals(getType()) || "diamo".equals(getType()) || "ferri".equals(getType());
    }

    public boolean d(boolean z) {
        int i2 = this.requestConnectingIndex;
        if (i2 > 15) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.requestConnectingIndex = i2 + 1;
        return true;
    }

    public long d0() {
        return this.getDfuErrorTime;
    }

    public String d1() {
        return this.uuid;
    }

    public boolean d2() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next(), "f")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d3(boolean z) {
        this.isTransfer = z;
    }

    public int e0() {
        return this.isCheckBindToy;
    }

    public Integer e1() {
        return this.version;
    }

    public void e2(int i2) {
        synchronized (this.battayList) {
            if (this.battayList.size() < 20) {
                this.battayList.add(Integer.valueOf(i2));
            } else {
                this.battayList.remove(0);
                this.battayList.add(Integer.valueOf(i2));
            }
        }
    }

    public void e3(String str) {
        this.upCaseName = str;
    }

    public boolean f() {
        if (E() == 0) {
            return true;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - E()) / 1000;
        if (D() > 0 || jCurrentTimeMillis <= 3) {
            return D() < 30 ? jCurrentTimeMillis >= 10 : jCurrentTimeMillis >= 30;
        }
        return true;
    }

    public int f0() {
        return this.isDfuEnd;
    }

    public String f1() {
        return this.workMode;
    }

    public void f2(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        synchronized (this.commandList) {
            HashMap map = new HashMap();
            map.put(str, Long.valueOf(be3.I().getTime()));
            if (this.commandList.size() < 10) {
                this.commandList.add(map);
            } else {
                this.commandList.remove(0);
                this.commandList.add(map);
            }
        }
    }

    public void f3(DfuBean dfuBean) {
        this.updateDfu = dfuBean;
    }

    public int g0() {
        return this.isLongRange;
    }

    public boolean g1() {
        ToyConfigInfoBean toyConfigInfoBean;
        List<ToyConfigInfoBean.ProgramBean> program;
        Integer numE1 = e1();
        String type = getType();
        if (numE1 == null || TextUtils.isEmpty(type) || (toyConfigInfoBean = this.toyConfigDataBean) == null || (program = toyConfigInfoBean.getProgram()) == null || program.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType())) {
            return false;
        }
        for (int i2 = 0; i2 < program.size(); i2++) {
            ToyConfigInfoBean.ProgramBean programBean = program.get(i2);
            if (numE1.intValue() <= programBean.getMaxv().intValue() && numE1.intValue() >= programBean.getMinv().intValue()) {
                return true;
            }
        }
        return false;
    }

    public void g2(int i2) {
        this.rssi = i2;
        if (this.canRssi) {
            synchronized (this.rssiList) {
                if (this.rssiList.size() < 20) {
                    this.rssiList.add(i2 + "");
                } else {
                    this.rssiList.remove(0);
                    this.rssiList.add(i2 + "");
                }
                this.canRssi = false;
            }
        }
    }

    public void g3(String str) {
        this.uuid = str;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public String getFormApp() {
        return this.formApp;
    }

    @Override // com.wear.bean.BaseEntity
    public String getId() {
        String strF = nd3.f(super.getId());
        return WearUtils.e1(strF) ? super.getId() : strF;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public int getLdrIcon() {
        return R.drawable.ldr_toy_icon_nomal;
    }

    public String getName() {
        return this.name;
    }

    public String getOldEmail() {
        return this.email;
    }

    public String getOldId() {
        return super.getId();
    }

    public String getShowName() {
        if (this.toyConfigDataBean == null) {
            a3();
        }
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        return toyConfigInfoBean != null ? toyConfigInfoBean.getShowName() : "";
    }

    public int getStatus() {
        if (isVirtualToy()) {
            return 1;
        }
        return this.status;
    }

    public String getType() {
        if (this.isGenerateType) {
            return this.type;
        }
        String strW = w(this.type);
        this.type = strW;
        this.isGenerateType = true;
        return strW;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getaColor() {
        return this.aColor;
    }

    public int h0() {
        return this.isPowerOff;
    }

    public void h2() {
        this.connectTryNumb--;
    }

    public void h3(Integer num) {
        this.version = num;
    }

    public Integer i0() {
        return this.isSelect;
    }

    public void i2(String str) {
        this.agString = str;
    }

    public void i3(String str) {
        this.workMode = str;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isMax() {
        return "max".equals(getType());
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isSupportBt() {
        if (!getType().equals("max") || e1().intValue() < 104) {
            return getType().equals("nora") && e1().intValue() >= 105;
        }
        return true;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isSupportControlPanel() {
        return "max".equals(getType()) || "calor".equals(getType()) || "nora".equals(getType());
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isSupportDepthMode() {
        return "mission".equals(getType()) || "calor".equals(getType());
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isSupportGame() {
        if (getType().equals("max")) {
            return WearUtils.v ? e1().intValue() >= 211 || (e1().intValue() >= 204 && e1().intValue() < 210) : e1().intValue() >= 212 || (e1().intValue() >= 205 && e1().intValue() < 210);
        }
        return false;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isSupportLdr() {
        String lowerCase = getType().toLowerCase();
        return lowerCase.equals("nora".toLowerCase()) || lowerCase.equals("max".toLowerCase()) || lowerCase.equals("mission") || lowerCase.equals("calor") || lowerCase.equalsIgnoreCase(Toy.TOY_XMACHINE) || F1();
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isThridPartToy() {
        if (WearUtils.e1(getType()) || e1() == null) {
            return true;
        }
        return (getType().equalsIgnoreCase("nora") || getType().equalsIgnoreCase("max")) && e1().intValue() < 100;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean isVirtualToy() {
        return this.simpleToy == 1;
    }

    public final synchronized void j() {
        synchronized (this.battayList) {
            this.battayList.clear();
        }
    }

    public boolean j1() {
        return !WearUtils.e1(this.aiString) && i1(this.aiString);
    }

    public void j2(String str, boolean z) {
        this.aiString = str;
        if (WearUtils.e1(str) || !z) {
            return;
        }
        xg3.i().k(this.address, str);
    }

    public boolean j3() {
        List<RangeBean> changeName;
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || (changeName = toyConfigInfoBean.getChangeName()) == null || changeName.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType()) || e1() == null) {
            return false;
        }
        for (int i2 = 0; i2 < changeName.size(); i2++) {
            if (e1().intValue() <= changeName.get(i2).getMaxv().intValue() && e1().intValue() >= changeName.get(i2).getMinv().intValue()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void k() {
        synchronized (this.commandList) {
            this.commandList.clear();
        }
    }

    public int k0() {
        return this.lanApiUpdateCount;
    }

    public boolean k1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals("ba")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void k2(String str) {
        this.batchId = str;
    }

    public void k3() {
        for (Map.Entry<String, String> entry : b.entrySet()) {
            if (entry.getValue() != null && this.name != null && TextUtils.equals(entry.getValue().toLowerCase(), this.name.toLowerCase())) {
                setType(w(entry.getKey()));
                setName(b.get(this.type));
                xe3.a("toyConfig", "同步玩具和玩具配置数据相符，name =" + entry.getValue());
                return;
            }
        }
        xe3.a("toyConfig", "同步玩具和玩具配置数据不符，name =" + this.name + "  重新进行转换");
        setType(w(this.name));
        setName(b.get(this.type));
        xe3.a("toyConfig", "同步玩具和玩具配置数据不符，转换之后的值为 type=" + this.type + "   name=" + this.name);
    }

    public final synchronized void l() {
        synchronized (this.battayList) {
            j();
        }
        synchronized (this.commandList) {
            k();
        }
        this.requestConnectingIndex = 0;
        this.connectTryNumb = 4;
        this.connectScanTime = 0L;
    }

    public boolean l1() {
        return getType().equals("lush") || getType().equals("hush") || getType().equals("edge") || getType().equals("diamo") || getType().equals("ferri");
    }

    public void l2(int i2) {
        this.battery = i2;
        e2(i2);
    }

    public boolean l3() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null || toyConfigInfoBean.getNotSupport() == null) {
                return true;
            }
            for (int i2 = 0; i2 < this.toyConfigDataBean.getNotSupport().size(); i2++) {
                ToyConfigInfoBean.NotSupport notSupport = this.toyConfigDataBean.getNotSupport().get(i2);
                if (notSupport.getAt().equals("remote") && notSupport.getPf().equals(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE)) {
                    int iO0 = WearUtils.O0(notSupport.getMinv());
                    int iO02 = WearUtils.O0(notSupport.getMaxv());
                    int iO03 = WearUtils.O0(ye3.s());
                    if (iO03 >= iO0 && iO03 <= iO02) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int m0() {
        return this.led;
    }

    public boolean m1() {
        return pc1.a.a(this.address);
    }

    public boolean m3() {
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || toyConfigInfoBean.getSupportLanPattern() == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.toyConfigDataBean.getSupportLanPattern().size(); i2++) {
            ToyConfigInfoBean.SupportLanPattern supportLanPattern = this.toyConfigDataBean.getSupportLanPattern().get(i2);
            if (e1().intValue() >= supportLanPattern.getMinv().intValue() && e1().intValue() <= supportLanPattern.getMaxv().intValue()) {
                return true;
            }
        }
        return false;
    }

    public Integer n0() {
        Integer num = this.ledSetting;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    public void n2(long j2) {
        this.batteryRequestTime = j2;
    }

    public int n3() {
        ToyConfigInfoBean toyConfigInfoBean;
        List<ToyConfigInfoBean.TvBean> tv;
        if (WearUtils.e1(this.name) || WearUtils.e1(getType()) || e1() == null || (toyConfigInfoBean = this.toyConfigDataBean) == null || (tv = toyConfigInfoBean.getTv()) == null || tv.size() <= 0 || !getType().equals(this.toyConfigDataBean.getType())) {
            return 1;
        }
        for (int i2 = 0; i2 < tv.size(); i2++) {
            ToyConfigInfoBean.TvBean tvBean = tv.get(i2);
            if (e1().intValue() <= tvBean.getMaxv().intValue() && e1().intValue() >= tvBean.getMinv().intValue()) {
                return Integer.valueOf(tvBean.getV()).intValue();
            }
        }
        return 1;
    }

    public String o0() {
        return this.logFormApp;
    }

    public void o2(int i2) {
        this.bindType = i2;
    }

    public void o3(Context context, TextOverlayImageView textOverlayImageView) {
        if (u1()) {
            textOverlayImageView.setVisibility(8);
            return;
        }
        int iD = D();
        String str = "battery===" + iD;
        if (iD != -1) {
            textOverlayImageView.setVisibility(0);
            textOverlayImageView.setImageResource(m2(true, false, iD));
        } else {
            textOverlayImageView.setVisibility(8);
        }
        textOverlayImageView.setText(iD + "");
        textOverlayImageView.setTextSize(20);
        textOverlayImageView.setTextColor(th4.b(context, R.color.text_color_85));
    }

    public String p0() {
        String str = (WearUtils.e1(getDeviceType()) ? S() : getName()) + "#" + getAddress().toUpperCase().replace(SignatureImpl.INNER_SEP, "");
        if (xb1.b(d1(), getAddress())) {
            return str + "#pin_0";
        }
        return str + "#pin_1";
    }

    public boolean p1() {
        return this.direction;
    }

    public void p2(boolean z) {
        this.canRssi = z;
    }

    public void p3(ImageView imageView) {
        String str = "battery11111===" + this.battery;
        if (u1()) {
            imageView.setVisibility(8);
            return;
        }
        int iD = D();
        if (iD == -1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(m2(false, false, iD));
        }
    }

    public String q0(int i2) {
        String str = (WearUtils.e1(getDeviceType()) ? S() : getName()) + "#" + getAddress().toUpperCase().replace(SignatureImpl.INNER_SEP, "");
        Iterator<String> it = this.rssiList.iterator();
        String strSubstring = "";
        while (it.hasNext()) {
            strSubstring = strSubstring + it.next() + ",";
        }
        if (strSubstring.indexOf(",") > 0) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("#");
        sb.append(i2 != -1 ? Integer.toHexString(i2) : "");
        sb.append("#");
        sb.append(strSubstring);
        sb.append("#");
        sb.append(ze3.f(i2));
        return sb.toString();
    }

    public boolean q1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equals("ea")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void q2(int i2) {
        this.connectApp = i2;
    }

    public String r0() {
        return this.lvsMotorConfig;
    }

    public boolean r1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase("ei")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void r2(long j2) {
        this.connectScanTime = j2;
    }

    public int s0() {
        return this.missionSolo;
    }

    public boolean s1(int i2) {
        if (t == null) {
            return false;
        }
        if (this.toyConfigDataBean == null) {
            a3();
        }
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null) {
            return false;
        }
        Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
        while (it.hasNext()) {
            if (it.next().equals("ei")) {
                return i2 >= 3;
            }
        }
        return false;
    }

    public void s2(int i2) {
        this.connectTryNumb = i2;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setEmail(String str) {
        if (WearUtils.e1(str)) {
            this.email = null;
        } else {
            this.email = nd3.p(str);
        }
    }

    public void setFormApp(String str) {
        this.formApp = str;
    }

    @Override // com.wear.bean.BaseEntity
    public void setId(String str) {
        super.setId(nd3.p(str));
    }

    public void setName(String str) {
        this.name = str;
    }

    public synchronized void setStatus(int i2) {
        this.status = i2;
        if (i2 == 1) {
            xr1.a(getAddress());
            u2(Long.valueOf(be3.I().getTime()));
            l();
            z2(0);
        } else {
            j2(null, false);
            i2(null);
        }
    }

    public void setType(String str) {
        this.isGenerateType = true;
        this.type = str;
    }

    public void setUpdateTime(long j2) {
        this.updateTime = j2;
    }

    public void setaColor(int i2) {
        this.aColor = i2;
    }

    @Override // com.wear.bean.handlerbean.HandlerToy
    public boolean supportCommand(String str) {
        String strS0 = S0(getType());
        char c2 = 2;
        if (str.startsWith("Vibrate:") || str.startsWith("vibrate:")) {
            c2 = 1;
        } else if (!str.startsWith("Vibrate1:") && !str.startsWith("vibrate1:") && !str.startsWith("Vibrate2:") && !str.startsWith("vibrate2:")) {
            c2 = (str.startsWith("Rotate:") || str.startsWith("rotate:")) ? (char) 3 : (str.startsWith("Air:Level:") || str.startsWith("air:level:")) ? (char) 4 : (str.startsWith("Suction:") || str.startsWith("suction:")) ? (char) 5 : (str.startsWith("Thrusting") || str.startsWith("thrusting:")) ? (char) 6 : (str.startsWith("Fingering") || str.startsWith("fingering:") || str.startsWith("vibrate3:")) ? (char) 7 : (str.startsWith("Depth") || str.startsWith("depth:")) ? '\b' : (char) 0;
        }
        switch (c2) {
            case 2:
                return strS0.contains("v1,v2");
            case 3:
                return strS0.contains(StreamManagement.AckRequest.ELEMENT);
            case 4:
                return strS0.contains("p");
            case 5:
                return strS0.contains("s");
            case 6:
                return strS0.contains("t");
            case 7:
                return strS0.contains("f");
            case '\b':
                return strS0.contains(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
            default:
                return true;
        }
    }

    public int[] t0() {
        return this.missionTchLvl;
    }

    public boolean t1() {
        return this.f01IsOff;
    }

    public void t2(int i2) {
        this.connectType = i2;
    }

    public List<List<String>> u0() {
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean != null) {
            return toyConfigInfoBean.getMotors();
        }
        a3();
        return new ArrayList();
    }

    public boolean u1() {
        return d2() || F1();
    }

    public void u2(Long l2) {
        this.connectedTime = l2;
    }

    public String v0() {
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || toyConfigInfoBean.getSupportMultiply() == null || this.toyConfigDataBean.getSupportMultiply().isEmpty()) {
            return null;
        }
        for (ToyConfigInfoBean.SupportMultiply supportMultiply : this.toyConfigDataBean.getSupportMultiply()) {
            if (supportMultiply.getMinv().intValue() <= a1() && supportMultiply.getMaxv().intValue() >= a1()) {
                return supportMultiply.getOrder();
            }
        }
        return null;
    }

    public boolean v1() {
        return w1() == 0;
    }

    public void v2(String str) {
        this.defineRename = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x011e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int w1() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ws1.w1():int");
    }

    public void w2(String str) {
        this.deviceId = str;
    }

    public String x() {
        return this.agString;
    }

    public String x0(BleResultBean bleResultBean) {
        String str;
        HashMap map = new HashMap();
        map.put("fversion", e1() + "");
        map.put(BleService.EXTRA_RSSI, this.rssiList);
        if (bleResultBean != null && bleResultBean.getStatus() != null) {
            map.put("message", ze3.f(bleResultBean.getStatus().intValue()));
            map.put(XHTMLText.CODE, bleResultBean.getStatus() + "");
        }
        String str2 = "-1";
        if (D() <= 0) {
            str = "-1";
        } else {
            str = D() + "";
        }
        map.put("battery", str);
        map.put("mac", T(getDeviceType()).toUpperCase() + "");
        map.put("type", getType().toLowerCase());
        WearUtils.K();
        if (WearUtils.x.a > 0) {
            str2 = WearUtils.x.a + "";
        }
        map.put("s_battery", str2);
        map.put("is_lowpower", WearUtils.l1(WearUtils.x) ? "0" : "1");
        map.put("is_background", WearUtils.x.f0() ? "1" : "0");
        map.put("is_bluetooth_on", WearUtils.x.G().y(WearUtils.x, false) ? "1" : "0");
        map.put("isLongrange", Integer.valueOf(g0() == 1 ? 1 : 0));
        if (h0() != 1 || z0() - System.currentTimeMillis() >= 5000) {
            map.put("is_poweroff", "0");
        } else {
            map.put("is_poweroff", "1");
        }
        G2(0);
        return WearUtils.A.toJson(map);
    }

    public final boolean x1() {
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null || toyConfigInfoBean.getFeedbackModeSupport() == null) {
            return false;
        }
        for (ToyConfigInfoBean.FeedbackModeSupport feedbackModeSupport : this.toyConfigDataBean.getFeedbackModeSupport()) {
            if (feedbackModeSupport.getMinv() <= e1().intValue() && e1().intValue() <= feedbackModeSupport.getMaxv()) {
                return true;
            }
        }
        return false;
    }

    public void x2(String str) {
        this.deviceName = str;
    }

    public String y0() {
        return this.pinStatus;
    }

    public boolean y1() {
        if (t != null) {
            if (this.toyConfigDataBean == null) {
                a3();
            }
            ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
            if (toyConfigInfoBean == null) {
                return false;
            }
            Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void y2(boolean z) {
        this.direction = z;
    }

    public String z() {
        return this.aiString;
    }

    public long z0() {
        return this.powerOffTime;
    }

    public boolean z1(int i2) {
        if (t == null) {
            return false;
        }
        if (this.toyConfigDataBean == null) {
            a3();
        }
        ToyConfigInfoBean toyConfigInfoBean = this.toyConfigDataBean;
        if (toyConfigInfoBean == null) {
            return false;
        }
        Iterator<String> it = toyConfigInfoBean.getSymbol().iterator();
        while (it.hasNext()) {
            if (it.next().equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION)) {
                return i2 >= 3;
            }
        }
        return false;
    }

    public void z2(int i2) {
        this.disConnectType = i2;
    }
}
