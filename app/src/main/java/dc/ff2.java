package dc;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.JsonSyntaxException;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.sun.jna.Callback;
import com.wear.bean.CommandFunctionActionBean;
import com.wear.bean.LanApiCommandBean;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.Pattern;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.broadcast.LanApiService;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: LanApiCommandUtil.java */
/* loaded from: classes3.dex */
public class ff2 {
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static ff2 i;
    public final Object a = new Object();
    public Map<String, Disposable> b = new HashMap();
    public String c = "";
    public static Map<Integer, String> g = new a();
    public static ConcurrentHashMap<String, LanApiCommandBean> h = new ConcurrentHashMap<>();
    public static boolean j = true;

    /* compiled from: LanApiCommandUtil.java */
    public class a extends HashMap<Integer, String> {
        public a() {
            put(200, "Ok");
            put(500, "http server not started or disabled");
            put(400, "Invalid Command");
            put(401, "Toy Not Found");
            put(Integer.valueOf(TypedValues.CycleType.TYPE_VISIBILITY), "Toy Not Connect");
            put(403, "Toy Not Support This Command");
            put(404, "Invalid Parameter");
            put(Integer.valueOf(PlaybackException.ERROR_CODE_DECODER_INIT_FAILED), "Vibrate and VibrateX cannot be sent at the same time.");
            put(Integer.valueOf(TypedValues.PositionType.TYPE_SIZE_PERCENT), "Other Errors");
            put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_X), "Server Error Please restart the app");
            put(601, "Failed to parse data.");
            put(Integer.valueOf(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE), "The account does not exist.");
            put(Integer.valueOf(TypedValues.MotionType.TYPE_EASING), "Login interface call failed.");
            put(Integer.valueOf(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO), "Binding interface...");
            put(1000, "Unknown error.");
            put(1001, "The received tip value is null, please check it.");
            put(1002, "The tip can't be converted to value types.");
            put(1003, "The tip exceeds the range of tip amount.");
            put(1004, "Uid is empty.");
            put(1005, "The basic setting is not set.");
            put(1006, "The platform information verification failed.");
            put(1007, "This platform information cannot be found, please try to log in again.");
            put(1008, "The basic setting function is not enabled on the platform.");
            put(1009, "The basic setting function is not enabled on the platform.");
            put(1010, "The current queue does not belong to this platform.");
            put(1011, "Get request is not supported.");
        }
    }

    /* compiled from: LanApiCommandUtil.java */
    public class b extends TimerTask {
        public final /* synthetic */ String a;
        public final /* synthetic */ double b;
        public final /* synthetic */ String c;

        public b(String str, double d, String str2) {
            this.a = str;
            this.b = d;
            this.c = str2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            xe3.a("newCommand", "  commandPreset Preset: 指令时间结束，停止定时器  toyId=" + this.a + "  timeSec=" + this.b + "  name=" + this.c);
            ff2.this.D(null, this.a, true);
        }
    }

    /* compiled from: LanApiCommandUtil.java */
    public class c extends TimerTask {
        public final /* synthetic */ Toy a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Pattern d;

        public c(Toy toy, List list, String str, Pattern pattern) {
            this.a = toy;
            this.b = list;
            this.c = str;
            this.d = pattern;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws NumberFormatException {
            int i;
            if (this.a.isBAToy()) {
                hf2.c(this.a, this.b, false);
                return;
            }
            LanApiCommandBean lanApiCommandBean = ff2.h.get(this.c);
            if (lanApiCommandBean == null || lanApiCommandBean.getCommandType() != 2) {
                return;
            }
            int presetCount = lanApiCommandBean.getPresetCount();
            String[] presetPatterns = lanApiCommandBean.getPresetPatterns();
            List<String> listCreateCommands = this.d.getHead().createCommands(presetCount >= presetPatterns.length ? presetPatterns[presetCount % presetPatterns.length] : presetPatterns[presetCount]);
            String[] allFuncCommandTags = this.d.getHead().getAllFuncCommandTags();
            xe3.a("newCommand", "run: " + presetCount);
            if (listCreateCommands != null) {
                HashMap map = new HashMap();
                int i2 = 0;
                for (String str : listCreateCommands) {
                    if (this.a.supportCommand(str) && (listCreateCommands.size() == 1 || i2 < listCreateCommands.size() - 1)) {
                        String str2 = allFuncCommandTags[i2];
                        try {
                            String[] strArrSplit = str.split(SignatureImpl.INNER_SEP);
                            i = Integer.parseInt(strArrSplit[strArrSplit.length - 1].replace(";", ""));
                        } catch (Exception e) {
                            e.printStackTrace();
                            i = 0;
                        }
                        map.put(str2, Integer.valueOf(i));
                    }
                    i2++;
                }
                ff2.this.u(map, this.a);
            }
            lanApiCommandBean.setPresetCount(presetCount + 1);
        }
    }

    /* compiled from: LanApiCommandUtil.java */
    public class d extends TimerTask {
        public final /* synthetic */ Toy a;

        public d(Toy toy) {
            this.a = toy;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0098, code lost:
        
            r10 = false;
         */
        @Override // java.util.TimerTask, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 338
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.ff2.d.run():void");
        }
    }

    /* compiled from: LanApiCommandUtil.java */
    public class e extends TimerTask {
        public final /* synthetic */ double a;
        public final /* synthetic */ String b;

        public e(double d, String str) {
            this.a = d;
            this.b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            xe3.a("newCommand", " setTimer Pattern: 指令时间结束，停止定时器   timeSec=" + this.a + "  toyAddress=" + this.b);
            ff2.this.D(null, this.b, true);
        }
    }

    /* compiled from: LanApiCommandUtil.java */
    public class f extends TimerTask {
        public final /* synthetic */ Toy a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ List f;

        public f(Toy toy, List list, List list2, int i, String str, List list3) {
            this.a = toy;
            this.b = list;
            this.c = list2;
            this.d = i;
            this.e = str;
            this.f = list3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws NumberFormatException {
            if (this.a.isBAToy() && this.b.contains("t")) {
                hf2.c(this.a, this.c, this.d >= 3);
                return;
            }
            LanApiCommandBean lanApiCommandBean = ff2.h.get(this.e);
            if (lanApiCommandBean == null || lanApiCommandBean.getCommandType() != 0) {
                return;
            }
            xe3.a("newCommand", "setTimer NewCommandBean = " + lanApiCommandBean.toPatternString());
            int count = lanApiCommandBean.getCount();
            xe3.a("newCommand", "Runnable 当前次数: " + count + "   当前循环时间：" + count + "   每次间隔时间：" + lanApiCommandBean.getrTime());
            List<String> pattern = lanApiCommandBean.getPattern();
            lanApiCommandBean.getrControl();
            if (pattern == null || pattern.isEmpty()) {
                return;
            }
            String[] strArrSplit = ((String) this.f.get(count % pattern.size())).split(",");
            HashMap map = new HashMap();
            for (String str : strArrSplit) {
                String[] strArrSplit2 = str.split(SignatureImpl.INNER_SEP);
                if (strArrSplit2.length > 1) {
                    map.put(strArrSplit2[0], Integer.valueOf(Double.valueOf(strArrSplit2[1]).intValue()));
                }
            }
            ff2.this.u(map, this.a);
            lanApiCommandBean.setCount(count + 1);
        }
    }

    /* compiled from: LanApiCommandUtil.java */
    public class g implements Consumer<Long> {
        public final /* synthetic */ String a;
        public final /* synthetic */ StringBuilder b;

        public g(ff2 ff2Var, String str, StringBuilder sb) {
            this.a = str;
            this.b = sb;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            wr1.a(this.a, this.b.toString());
        }
    }

    public static ff2 n() {
        if (i == null) {
            synchronized (ff2.class) {
                if (i == null) {
                    i = new ff2();
                }
            }
        }
        return i;
    }

    public static void v(StringBuilder sb, int i2) {
        switch (i2) {
            case 10:
                sb.append("a");
                break;
            case 11:
                sb.append("b");
                break;
            case 12:
                sb.append("c");
                break;
            case 13:
                sb.append(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                break;
            case 14:
                sb.append("e");
                break;
            case 15:
                sb.append("f");
                break;
            case 16:
                sb.append("g");
                break;
            case 17:
                sb.append(XHTMLText.H);
                break;
            case 18:
                sb.append("i");
                break;
            case 19:
                sb.append("j");
                break;
            case 20:
                sb.append("k");
                break;
            default:
                sb.append(i2);
                break;
        }
    }

    public final void A(int i2, double d2, String[] strArr, List<String> list, Integer num, String str, int i3, boolean z) {
        Timer timer;
        Timer timer2;
        Integer num2;
        Timer timer3;
        int iIntValue = num.intValue();
        Toy toyQ = WearUtils.x.G().Q(str);
        if (toyQ.isEAToy() && z) {
            int i4 = -1;
            int i5 = 0;
            int i6 = -1;
            while (i5 < list.size()) {
                if (TextUtils.equals(list.get(i5), "0") && i6 == i4) {
                    i6 = i5;
                }
                if ((!TextUtils.equals(list.get(i5), "0") || i5 == list.size() - 1) && i6 != i4) {
                    int i7 = !TextUtils.equals(list.get(i5), "0") ? i5 - 1 : i5 == list.size() - 1 ? i5 : 0;
                    for (int i8 = i6; i8 <= i7; i8++) {
                        if ((i8 - i6) * num.intValue() <= 1500) {
                            list.set(i8, "1");
                        }
                    }
                    i6 = -1;
                }
                i5++;
                i4 = -1;
            }
        }
        String toyFunction = Toy.getToyFunction(toyQ.getType());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List listAsList = Arrays.asList(strArr);
        for (List<String> list2 : toyQ.getMotors()) {
            int size = list2.size() - 1;
            while (true) {
                if (size >= 0) {
                    String str2 = list2.get(size);
                    if (toyFunction.contains(str2) && listAsList.contains(str2)) {
                        linkedHashSet.add(str2);
                        break;
                    }
                    size--;
                }
            }
        }
        if (linkedHashSet.isEmpty()) {
            xe3.a("newCommand", "motor list is empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(linkedHashSet);
        y(arrayList2, iIntValue, hf2.d(list, i2 >= 3), arrayList);
        if (!toyQ.toyIsSupportLanApi() || i3 == 1) {
            xe3.a("newCommand", "  pattern: 尝试停止之前的定时器  toyId=" + toyQ.getAddress());
            D(null, toyQ.getAddress(), false);
            if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                Timer timer4 = new Timer();
                timer4.schedule(new e(d2, str), (long) (d2 * 1000.0d));
                timer = timer4;
            } else {
                timer = null;
            }
            xe3.a("newCommand", "  setTimer Pattern 玩具和指令不符合拼接规则，转定时器循环发送  timeSec=" + d2 + " rTime=" + num + "   rControl=" + Arrays.toString(strArr));
            timer2 = new Timer();
            timer2.schedule(new f(toyQ, listAsList, list, i2, str, arrayList), 0L, (long) iIntValue);
            num2 = num;
            timer3 = timer;
        } else {
            Integer numValueOf = Integer.valueOf((num.intValue() == 10000 ? 9990 : num).intValue() / 10);
            StringBuilder sb = new StringBuilder(numValueOf.intValue() < 100 ? "0" + numValueOf : "" + numValueOf);
            if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                int i9 = ((int) (d2 * 1000.0d)) / 10;
                if (i9 < 10) {
                    sb.append("00000");
                } else if (i9 < 100) {
                    sb.append("0000");
                } else if (i9 < 1000) {
                    sb.append("000");
                } else if (i9 < 10000) {
                    sb.append("00");
                } else if (i9 < 100000) {
                    sb.append("0");
                }
                sb.append(i9);
            } else {
                sb.append("000000");
            }
            int i10 = 0;
            while (i10 < arrayList.size()) {
                String str3 = arrayList.get(i10);
                String[] strArrSplit = str3.split(",");
                StringBuilder sb2 = new StringBuilder();
                Integer num3 = numValueOf;
                sb2.append("strings===");
                sb2.append(str3);
                sb2.toString();
                int length = strArrSplit.length;
                int i11 = 0;
                while (i11 < length) {
                    int i12 = length;
                    String[] strArrSplit2 = strArrSplit[i11].split(SignatureImpl.INNER_SEP);
                    String[] strArr2 = strArrSplit;
                    String str4 = strArrSplit2[0];
                    if ("p".equals(str4)) {
                        sb.append("p");
                        sb.append(strArrSplit2[1]);
                    } else if (StreamManagement.AckRequest.ELEMENT.equals(str4) || "f".equals(str4)) {
                        if (StreamManagement.AckRequest.ELEMENT.equals(str4)) {
                            sb.append(StreamManagement.AckRequest.ELEMENT);
                        } else {
                            sb.append("u");
                        }
                        v(sb, Double.valueOf(strArrSplit2[1]).intValue());
                    } else {
                        int iIntValue2 = Double.valueOf(strArrSplit2[1]).intValue();
                        if (iIntValue2 > 20) {
                            iIntValue2 = 20;
                        }
                        v(sb, iIntValue2);
                    }
                    i11++;
                    strArrSplit = strArr2;
                    length = i12;
                }
                i10++;
                numValueOf = num3;
            }
            Integer num4 = numValueOf;
            xe3.a("newCommand", "   pattern: 尝试停止之前的定时器  toyId=" + str);
            D(null, toyQ.getAddress(), false);
            String str5 = "func_toy===" + toyFunction;
            if (!"v1,v2".equals(toyFunction) && !"v,s".equals(toyFunction)) {
                for (String str6 : toyFunction.split(",")) {
                    if (!arrayList2.contains(str6)) {
                        if (PSOProgramService.VS_Key.equals(str6)) {
                            if (mp1.h()) {
                                rq1.d.t(str, 0);
                            } else {
                                WearUtils.x.G().e(str, "Vibrate:0;");
                            }
                        } else if ("p".equals(str6)) {
                            if (mp1.h()) {
                                rq1.d.g(str, 0);
                            } else {
                                WearUtils.x.G().e(str, "Air:Level:0;");
                            }
                        } else if (StreamManagement.AckRequest.ELEMENT.equals(str6)) {
                            if (mp1.h()) {
                                rq1.d.h(str, 0);
                            } else {
                                WearUtils.x.G().e(str, "Rotate:0;");
                            }
                        }
                    }
                }
            }
            xe3.a("newCommand", "setTimer: " + ((Object) sb));
            Disposable disposable = this.b.get(str);
            if (disposable != null && !disposable.isDisposed()) {
                disposable.dispose();
            }
            this.b.put(str, Observable.timer(200L, TimeUnit.MILLISECONDS).subscribe(new g(this, str, sb)));
            num2 = num4;
            timer2 = null;
            timer3 = null;
        }
        h.put(str, new LanApiCommandBean(d2, strArr, arrayList, num2, str, timer2, timer3));
    }

    public void B() {
        if (e) {
            return;
        }
        e = true;
        EventBus.getDefault().post(new LanApiControlEvent(true));
        if (LanApiService.e) {
            return;
        }
        Intent intent = new Intent(WearUtils.x, (Class<?>) LanApiService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            WearUtils.x.startForegroundService(intent);
        } else {
            WearUtils.x.startService(intent);
        }
    }

    public synchronized void C() {
        Iterator<Map.Entry<String, LanApiCommandBean>> it = h.entrySet().iterator();
        System.out.println("使用Iterator遍历,并且不使用泛型");
        while (it.hasNext()) {
            D(null, it.next().getKey(), false);
        }
    }

    public synchronized void D(String str, final String str2, boolean z) {
        xe3.a("newCommand", "stopTimer: " + str + "   " + str2);
        LanApiCommandBean lanApiCommandBean = h.get(str2);
        if (lanApiCommandBean != null) {
            if (lanApiCommandBean.getCommandType() == 0) {
                if (lanApiCommandBean.getPatternTimer() != null) {
                    lanApiCommandBean.getPatternTimer().cancel();
                    lanApiCommandBean.setPatternTimer(null);
                }
                if (lanApiCommandBean.getPatternStopTimer() != null) {
                    lanApiCommandBean.getPatternStopTimer().cancel();
                    lanApiCommandBean.setPatternStopTimer(null);
                }
                h.remove(str2);
            } else if (lanApiCommandBean.getCommandType() == 1) {
                if (lanApiCommandBean.getFunctionTimer() != null) {
                    lanApiCommandBean.getFunctionTimer().cancel();
                    lanApiCommandBean.setFunctionTimer(null);
                }
                h.remove(str2);
            } else if (lanApiCommandBean.getCommandType() == 2) {
                if (lanApiCommandBean.getPresetTimer() != null) {
                    lanApiCommandBean.getPresetTimer().cancel();
                    lanApiCommandBean.setPresetTimer(null);
                }
                if (lanApiCommandBean.getPresetStopTimer() != null) {
                    lanApiCommandBean.getPresetStopTimer().cancel();
                    lanApiCommandBean.setPresetStopTimer(null);
                }
                h.remove(str2);
            }
        }
        if (this.b.containsKey(str2)) {
            this.b.remove(str2);
        }
        ck2.b().e(str2);
        if (z) {
            se0.g(new Runnable() { // from class: dc.ye2
                @Override // java.lang.Runnable
                public final void run() {
                    WearUtils.x.G().v0(str2);
                }
            }, 100L);
        } else {
            WearUtils.x.G().v0(str2);
        }
    }

    public final int E(String str, int i2, int i3) {
        int i4 = i3 / i2;
        if (!TextUtils.equals(str, "p")) {
            if (i4 > 20) {
                return 20;
            }
            return i4;
        }
        if (i4 >= 1 && i4 <= 7) {
            return 1;
        }
        if (i4 > 7 && i4 <= 13) {
            return 2;
        }
        if (i4 > 13) {
            return 3;
        }
        return i4;
    }

    public int b(String str) {
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        if (arrayListO == null || arrayListO.size() == 0) {
            return 401;
        }
        if (WearUtils.e1(str)) {
            return 200;
        }
        Toy toyR = WearUtils.x.G().R(str);
        if (toyR == null) {
            return 401;
        }
        if (WearUtils.x.G().a(toyR.getAddress())) {
            return 200;
        }
        if (WearUtils.c1(Integer.valueOf(toyR.getStatus())) || toyR.getStatus() == -1) {
            return TypedValues.CycleType.TYPE_VISIBILITY;
        }
        return 200;
    }

    public final int c(String str) {
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        if (arrayListO == null || arrayListO.size() == 0) {
            return 401;
        }
        if (WearUtils.e1(str)) {
            return 200;
        }
        if (WearUtils.x.G().R(str) == null) {
            return 401;
        }
        Toy toyR = WearUtils.x.G().R(str);
        if (WearUtils.x.G().a(toyR.getAddress())) {
            return 200;
        }
        if (WearUtils.c1(Integer.valueOf(toyR.getStatus())) || toyR.getStatus() == -1) {
            return TypedValues.CycleType.TYPE_VISIBILITY;
        }
        return 200;
    }

    public final void d(String str, List<CommandFunctionActionBean> list, double d2, double d3, double d4, String str2) {
        Toy toyR = WearUtils.x.G().R(str);
        LanApiCommandBean lanApiCommandBean = h.get(toyR.getAddress());
        if (lanApiCommandBean != null) {
            lanApiCommandBean.setStroke(str2);
            lanApiCommandBean.updateFunctionCommandBean(list, d2, d3, d4);
        } else {
            Timer timer = new Timer();
            h.put(toyR.getAddress(), new LanApiCommandBean(timer, list, str, d2, d3, d4, str2));
            timer.schedule(new d(toyR), 0L, 100L);
        }
    }

    public final void e(double d2, Pattern pattern, Toy toy, String str) {
        Timer timer;
        int splitTime = pattern.getHead() != null ? pattern.getHead().getSplitTime() : 100;
        String address = toy.getAddress();
        Timer timer2 = new Timer();
        if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Timer timer3 = new Timer();
            timer3.schedule(new b(address, d2, str), (long) (1000.0d * d2));
            timer = timer3;
        } else {
            timer = null;
        }
        String[] strArrSplit = pattern.getHead() == null ? pattern.getData().split(",") : pattern.getData().split(";");
        List listAsList = Arrays.asList(strArrSplit);
        xe3.a("newCommand", "  commandPreset Preset 指令发送, 每 " + splitTime + "毫秒发送一个指令， 总执行时间timeSec=" + d2 + " 指令列表=" + Arrays.toString(strArrSplit) + " toyId=" + address);
        timer2.schedule(new c(toy, listAsList, address, pattern), 0L, (long) splitTime);
        h.put(address, new LanApiCommandBean(d2, timer2, toy.getAddress(), strArrSplit, timer));
    }

    public int f(String str, AsyncHttpServerResponse asyncHttpServerResponse, String str2) {
        HashMap map = (HashMap) WearUtils.A.fromJson(str, HashMap.class);
        HashMap<String, Object> map2 = new HashMap<>();
        for (Map.Entry entry : map.entrySet()) {
            map2.put(((String) entry.getKey()).trim().toLowerCase(), entry.getValue());
        }
        return g(asyncHttpServerResponse, str2, map2, (map2.get("command") + "").trim());
    }

    public final int g(AsyncHttpServerResponse asyncHttpServerResponse, String str, HashMap<String, Object> map, String str2) throws NumberFormatException {
        int iL;
        if ("Pattern".equals(str2)) {
            iL = k(asyncHttpServerResponse, str, map);
        } else if ("Function".equalsIgnoreCase(str2)) {
            iL = h(asyncHttpServerResponse, str, map);
        } else if ("Preset".equals(str2) || "preset".equalsIgnoreCase(str2)) {
            iL = l(asyncHttpServerResponse, str, map);
        } else {
            if ("GetToys".equals(str2) || "gettoys".equalsIgnoreCase(str2)) {
                return i(asyncHttpServerResponse, str);
            }
            if ("GetToyName".equalsIgnoreCase(str2)) {
                return j(asyncHttpServerResponse, str);
            }
            iL = "Position".equalsIgnoreCase(str2) ? gf2.f().c(asyncHttpServerResponse, str, map) : "PatternV2".equalsIgnoreCase(str2) ? gf2.f().b(asyncHttpServerResponse, str, map) : 404;
        }
        if (iL == 200) {
            this.c = str2;
        }
        return iL;
    }

    public final int h(AsyncHttpServerResponse asyncHttpServerResponse, String str, HashMap<String, Object> map) throws NumberFormatException {
        double d2;
        double d3;
        String str2;
        double d4;
        String str3;
        double d5;
        int iB;
        if (WearUtils.x.G().P().isEmpty()) {
            return TypedValues.CycleType.TYPE_VISIBILITY;
        }
        String strTrim = (map.get(AMPExtension.Action.ATTRIBUTE_NAME) + "").trim();
        String strTrim2 = (map.get("toy") + "").trim();
        if ("stop".equalsIgnoreCase(strTrim)) {
            if (WearUtils.e1(strTrim2)) {
                Iterator<Toy> it = WearUtils.x.G().P().iterator();
                while (it.hasNext()) {
                    Toy next = it.next();
                    if (!WearUtils.e1(next.getAddress())) {
                        WearUtils.x.G().v0(next.getAddress());
                    }
                }
                xe3.a("newCommand", " Function: stop 指令 停止所有定时器");
                C();
            } else {
                xe3.a("newCommand", " Function: stop 指令 停止所有定时器");
                D(null, WearUtils.x.G().R(strTrim2).getAddress(), false);
            }
            x(asyncHttpServerResponse, true, null, 200, "", str);
            return 200;
        }
        double d6 = ((int) (Double.parseDouble(map.get("timeSec".toLowerCase()) + "") * 100.0d)) / 100.0d;
        String str4 = map.get("loopRunningSec".toLowerCase()) + "";
        if (WearUtils.e1(str4)) {
            d2 = d6;
            d3 = 0.0d;
        } else {
            d3 = Double.parseDouble(str4);
            d2 = d6;
        }
        double d7 = ((int) (d3 * 100.0d)) / 100.0d;
        String str5 = map.get("loopPauseSec".toLowerCase()) + "";
        if (WearUtils.e1(str5)) {
            str2 = "newCommand";
            d4 = 0.0d;
        } else {
            d4 = Double.parseDouble(str5);
            str2 = "newCommand";
        }
        double d8 = ((int) (d4 * 100.0d)) / 100.0d;
        double dDoubleValue = (TextUtils.equals(this.c.toLowerCase(), "function") && map.containsKey("stopPrevious".toLowerCase())) ? ((Double) map.get("stopPrevious".toLowerCase())).doubleValue() : 1.0d;
        if (!WearUtils.e1(strTrim2) && (iB = b(strTrim2)) != 200) {
            return iB;
        }
        if (WearUtils.e1(strTrim) || d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || ((d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d2 < 1.0d) || d7 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || ((d7 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d7 < 1.0d) || d8 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || (d8 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d8 < 1.0d)))) {
            return 404;
        }
        String[] strArrSplit = strTrim.split(",");
        ArrayList arrayList = new ArrayList();
        int length = strArrSplit.length;
        String str6 = "";
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i2 < length) {
            String[] strArr = strArrSplit;
            String[] strArrSplit2 = strArrSplit[i2].split(SignatureImpl.INNER_SEP);
            int i3 = length;
            if ("vibrate".equalsIgnoreCase(strArrSplit2[0])) {
                arrayList.add(new CommandFunctionActionBean(PSOProgramService.VS_Key, Double.valueOf(strArrSplit2[1]).intValue()));
                str3 = str4;
                d5 = dDoubleValue;
                z = true;
            } else {
                if ("vibrate1".equalsIgnoreCase(strArrSplit2[0])) {
                    arrayList.add(new CommandFunctionActionBean("v1", Double.valueOf(strArrSplit2[1]).intValue()));
                } else if ("vibrate2".equalsIgnoreCase(strArrSplit2[0])) {
                    arrayList.add(new CommandFunctionActionBean("v2", Double.valueOf(strArrSplit2[1]).intValue()));
                } else if ("vibrate3".equalsIgnoreCase(strArrSplit2[0])) {
                    arrayList.add(new CommandFunctionActionBean("v3", Double.valueOf(strArrSplit2[1]).intValue()));
                } else {
                    if ("rotate".equalsIgnoreCase(strArrSplit2[0])) {
                        int iIntValue = Double.valueOf(strArrSplit2[1]).intValue();
                        arrayList.add(new CommandFunctionActionBean(iIntValue < 0 ? "rr" : "rl", Math.abs(iIntValue)));
                    } else if ("pump".equalsIgnoreCase(strArrSplit2[0])) {
                        arrayList.add(new CommandFunctionActionBean("p", Double.valueOf(strArrSplit2[1]).intValue()));
                    } else {
                        str3 = str4;
                        if ("thrusting".equalsIgnoreCase(strArrSplit2[0])) {
                            arrayList.add(new CommandFunctionActionBean("t", Double.valueOf(strArrSplit2[1]).intValue()));
                        } else if (Toy.TOY_FEATURE_TENERA.equalsIgnoreCase(strArrSplit2[0])) {
                            arrayList.add(new CommandFunctionActionBean("s", Double.valueOf(strArrSplit2[1]).intValue()));
                        } else if ("fingering".equalsIgnoreCase(strArrSplit2[0])) {
                            arrayList.add(new CommandFunctionActionBean("f", Double.valueOf(strArrSplit2[1]).intValue()));
                        } else if ("depth".equalsIgnoreCase(strArrSplit2[0])) {
                            arrayList.add(new CommandFunctionActionBean(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, Math.min((Double.valueOf(strArrSplit2[1]).intValue() * 33) / 5, 20)));
                        } else if (TtmlNode.COMBINE_ALL.equalsIgnoreCase(strArrSplit2[0])) {
                            List listAsList = Arrays.asList((String[]) new String[]{PSOProgramService.VS_Key, "v1", "v2", "v3", "p", "t", "s", "f", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, StreamManagement.AckRequest.ELEMENT}.clone());
                            ArrayList arrayList2 = new ArrayList();
                            d5 = dDoubleValue;
                            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                arrayList2.add(arrayList.get(i4).getOpertion());
                            }
                            int i5 = 0;
                            for (ArrayList arrayList3 = new ArrayList(od0.a(listAsList, arrayList2)); i5 < arrayList3.size(); arrayList3 = arrayList3) {
                                int iIntValue2 = Double.valueOf(strArrSplit2[1]).intValue();
                                if ("p".equals(arrayList3.get(i5))) {
                                    iIntValue2 = E("p", 1, iIntValue2);
                                }
                                arrayList.add(new CommandFunctionActionBean((String) arrayList3.get(i5), iIntValue2));
                                i5++;
                            }
                        } else {
                            d5 = dDoubleValue;
                            if ("stroke".equalsIgnoreCase(strArrSplit2[0])) {
                                str6 = strArrSplit2[1];
                            }
                        }
                        d5 = dDoubleValue;
                    }
                    str3 = str4;
                    d5 = dDoubleValue;
                }
                str3 = str4;
                d5 = dDoubleValue;
                z2 = true;
            }
            i2++;
            strArrSplit = strArr;
            length = i3;
            str4 = str3;
            dDoubleValue = d5;
        }
        String str7 = str4;
        double d9 = dDoubleValue;
        if (z && z2) {
            return PlaybackException.ERROR_CODE_DECODER_INIT_FAILED;
        }
        x(asyncHttpServerResponse, true, null, 200, "", str);
        xe3.a("newCommandTime", "Function 校验完成 返回 200 ");
        StringBuilder sb = new StringBuilder();
        sb.append(" Function 指令校验无误 开始设置定时器发送 当前玩具列表玩具数量：");
        sb.append(WearUtils.x.G().P().size());
        sb.append("  action=");
        sb.append(strTrim);
        sb.append("  timeSec=");
        double d10 = d2;
        sb.append(d10);
        sb.append("  loopRunningSec=");
        sb.append(str7);
        sb.append("  loopPauseSec=");
        sb.append(str5);
        sb.append("  toyId=");
        sb.append(strTrim2);
        sb.append("  stopPrevious=");
        sb.append(d9);
        String str8 = str2;
        xe3.a(str8, sb.toString());
        if (d9 == 1.0d) {
            if (WearUtils.e1(strTrim2)) {
                xe3.a(str8, "  Function: 尝试停止之前的定时器  toyId=" + strTrim2);
                C();
            } else {
                xe3.a(str8, " Function: 尝试停止之前的定时器  toyId=" + strTrim2);
                D(null, WearUtils.x.G().R(strTrim2).getAddress(), false);
            }
        }
        if (!WearUtils.e1(strTrim2)) {
            d(strTrim2, arrayList, d10, d7, d8, str6);
            return 200;
        }
        Iterator<Toy> it2 = WearUtils.x.G().P().iterator();
        while (it2.hasNext()) {
            d(it2.next().getDeviceId(), arrayList, d10, d7, d8, str6);
            d10 = d10;
        }
        return 200;
    }

    public final int i(AsyncHttpServerResponse asyncHttpServerResponse, String str) {
        if (mp1.h()) {
            x(asyncHttpServerResponse, true, sq1.c(), 200, "", str);
            return 200;
        }
        ArrayList<Toy> arrayListP = WearUtils.x.G().P();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (!arrayListP.isEmpty()) {
            for (Toy toy : arrayListP) {
                HashMap map3 = new HashMap();
                map3.put(TtmlNode.ATTR_ID, toy.getDeviceId());
                map3.put("name", toy.getRealType().toLowerCase());
                map3.put("status", String.valueOf(WearUtils.x.G().a(toy.getAddress()) ? 1 : 0));
                map3.put("battery", Integer.valueOf(toy.getBattery()));
                map3.put("nickName", WearUtils.e1(toy.getDefineRename()) ? "" : toy.getDefineRename());
                map3.put("version", toy.getGenerationVersion());
                if (WearUtils.e1(toy.getName()) || "unknow".equalsIgnoreCase(toy.getName()) || EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(toy.getName()) || WearUtils.e1(toy.getShowName()) || "unknow".equalsIgnoreCase(toy.getShowName()) || EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(toy.getShowName())) {
                    map3.put("shortFunctionNames", new String[]{PSOProgramService.VS_Key});
                    map3.put("fullFunctionNames", new String[]{"Vibrate"});
                } else if (toy.getToyConfigDataBean() != null && toy.getToyConfigDataBean().getFunctionDescription() != null) {
                    for (ToyConfigInfoBean.FunctionDescription functionDescription : toy.getToyConfigDataBean().getFunctionDescription()) {
                        if (functionDescription != null && TextUtils.equals(String.valueOf(toy.typeInt()), functionDescription.getV())) {
                            map3.put("shortFunctionNames", functionDescription.getShortNames());
                            map3.put("fullFunctionNames", functionDescription.getFullNames());
                        }
                    }
                }
                if (!map3.containsKey("shortFunctionNames") || !map3.containsKey("fullFunctionNames")) {
                    map3.put("shortFunctionNames", new String[0]);
                    map3.put("fullFunctionNames", new String[0]);
                }
                map2.put(toy.getDeviceId(), map3);
            }
        }
        map.put("toys", ro2.c(map2));
        map.put("gameAppId", ye3.x().replaceAll(Constants.FILENAME_SEQUENCE_SEPARATOR, ""));
        map.put("appType", "remote");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        x(asyncHttpServerResponse, true, map, 200, "", str);
        return 200;
    }

    public final int j(AsyncHttpServerResponse asyncHttpServerResponse, String str) {
        if (mp1.h()) {
            x(asyncHttpServerResponse, true, sq1.b(), 200, "", str);
            return 200;
        }
        ArrayList<Toy> arrayListP = WearUtils.x.G().P();
        String[] strArr = null;
        if (!arrayListP.isEmpty()) {
            strArr = new String[arrayListP.size()];
            for (int i2 = 0; i2 < arrayListP.size(); i2++) {
                strArr[i2] = arrayListP.get(i2).getName();
            }
        }
        x(asyncHttpServerResponse, true, strArr, 200, "", str);
        return 200;
    }

    public final int k(AsyncHttpServerResponse asyncHttpServerResponse, String str, HashMap<String, Object> map) throws NumberFormatException {
        int iIntValue;
        boolean z;
        int i2;
        String[] strArrSplit;
        int iC;
        ScanQRDataBean scanQRDataBean;
        if (WearUtils.x.G().P().isEmpty()) {
            return TypedValues.CycleType.TYPE_VISIBILITY;
        }
        ArrayList arrayList = new ArrayList();
        String strTrim = (map.get(AMPExtension.Rule.ELEMENT) + "").trim();
        String strTrim2 = (map.get("strength") + "").trim();
        double d2 = ((int) (Double.parseDouble(map.get("timeSec".toLowerCase()) + "") * 100.0d)) / 100.0d;
        String strTrim3 = (map.get("toy") + "").trim();
        if (map.get("exeMode".toLowerCase()) != null) {
            iIntValue = Double.valueOf(map.get("exeMode".toLowerCase()) + "").intValue();
        } else {
            iIntValue = 0;
        }
        if (map.get("expeirenceOptimize".toLowerCase()) != null) {
            z = Boolean.parseBoolean(map.get("expeirenceOptimize".toLowerCase()) + "");
        } else {
            z = false;
        }
        boolean z2 = (z || (scanQRDataBean = MyApplication.G) == null || !TextUtils.equals(scanQRDataBean.getPlatform(), "3DXChat")) ? z : true;
        xe3.a("newCommand", "  Pattern  获取参数  rule=" + strTrim + "  strength=" + strTrim2 + "  timeSec=" + d2 + "  toyId=" + strTrim3 + "  expeirenceOptimize=" + z2);
        if (WearUtils.e1(strTrim) || WearUtils.e1(strTrim2) || d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 404;
        }
        if ((d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d2 < 1.0d) || d2 > 6000.0d) {
            return 404;
        }
        if (iIntValue != 0 && iIntValue != 1) {
            return 404;
        }
        if (!WearUtils.e1(strTrim3) && (iC = c(strTrim3)) != 200) {
            return iC;
        }
        if (map.get("apiver") != null) {
            i2 = (int) Double.parseDouble(map.get("apiver") + "");
        } else {
            i2 = 1;
        }
        String[] strArrSplit2 = strTrim.replace("#", "").split(";");
        int length = strArrSplit2.length;
        String[] strArr = null;
        Integer numValueOf = null;
        int i3 = 0;
        while (i3 < length) {
            String str2 = strArrSplit2[i3];
            String[] strArr2 = strArrSplit2;
            int i4 = length;
            if (str2.startsWith("F")) {
                String[] strArrSplit3 = str2.split(SignatureImpl.INNER_SEP);
                if (strArrSplit3.length <= 1 || strArrSplit3[1].equalsIgnoreCase(TtmlNode.COMBINE_ALL)) {
                    strArrSplit = new String[]{PSOProgramService.VS_Key, "v1", "v2", "v3", "f", "t", "p", StreamManagement.AckRequest.ELEMENT, "s", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG};
                } else {
                    String str3 = strArrSplit3[1];
                    strArrSplit = str3.contains(",") ? str3.split(",") : str3.split("");
                }
                strArr = strArrSplit;
            } else {
                if (str2.startsWith(ExifInterface.LATITUDE_SOUTH)) {
                    String[] strArrSplit4 = str2.split(SignatureImpl.INNER_SEP);
                    if (strArrSplit4.length > 1) {
                        numValueOf = Integer.valueOf(strArrSplit4[1]);
                    }
                }
                i3++;
                strArrSplit2 = strArr2;
                length = i4;
            }
            i3++;
            strArrSplit2 = strArr2;
            length = i4;
        }
        if (strArr == null || WearUtils.c1(numValueOf) || numValueOf.intValue() < 100 || numValueOf.intValue() > 10000 || strTrim2.contains(",")) {
            return 404;
        }
        arrayList.clear();
        arrayList.addAll(Arrays.asList(strTrim2.split(";")));
        if (arrayList.size() <= 0 || arrayList.size() > 100) {
            return 404;
        }
        x(asyncHttpServerResponse, true, null, 200, "", str);
        xe3.a("newCommand", "Pattern 校验完成 返回 200 ");
        xe3.a("newCommand", "   pattern 指令校验无误 开始设置定时器发送 当前玩具列表玩具数量：" + WearUtils.x.G().P().size());
        if (!WearUtils.e1(strTrim3)) {
            A(i2, d2, strArr, arrayList, numValueOf, WearUtils.x.G().R(strTrim3).getAddress(), iIntValue, z2);
            return 200;
        }
        Iterator<Toy> it = WearUtils.x.G().P().iterator();
        while (it.hasNext()) {
            A(i2, d2, strArr, arrayList, numValueOf, it.next().getAddress(), iIntValue, z2);
        }
        return 200;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int l(com.koushikdutta.async.http.server.AsyncHttpServerResponse r16, java.lang.String r17, java.util.HashMap<java.lang.String, java.lang.Object> r18) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ff2.l(com.koushikdutta.async.http.server.AsyncHttpServerResponse, java.lang.String, java.util.HashMap):int");
    }

    public final String m(String str, int i2, int i3) {
        return str + SignatureImpl.INNER_SEP + E(str, i2, i3);
    }

    public void o(boolean z, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        String method = asyncHttpServerRequest.getMethod();
        Multimap query = asyncHttpServerRequest.getQuery();
        String strSubstring = asyncHttpServerRequest.getPath().substring(1);
        String string = "";
        if (!WearUtils.e1(strSubstring)) {
            strSubstring = strSubstring.replace("/", "");
        }
        String string2 = query.getString(Callback.METHOD_NAME);
        asyncHttpServerRequest.getHeaders().get(HttpHeaders.ORIGIN);
        asyncHttpServerResponse.getHeaders().add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        asyncHttpServerResponse.getHeaders().add("Access-Control-Allow-Private-Network", "true");
        String str = asyncHttpServerRequest.getHeaders().get("X-platform");
        h32 h32VarI = h32.i();
        if (asyncHttpServerRequest.getBody() != null && asyncHttpServerRequest.getBody().get() != null) {
            string = asyncHttpServerRequest.getBody().get().toString();
        }
        h32VarI.e("C0016", string, str);
        if (!z) {
            w(asyncHttpServerResponse, 500, string2);
        }
        if ("command".equals(strSubstring)) {
            if (method.contains("GET")) {
                w(asyncHttpServerResponse, 1011, string2);
                return;
            }
            if (method.contains("POST")) {
                try {
                    String string3 = asyncHttpServerRequest.getBody().get().toString();
                    if (WearUtils.e1(string3)) {
                        w(asyncHttpServerResponse, 400, string2);
                        return;
                    }
                    xe3.a("newCommand", "command 收到本地服务指令command 指令" + string3 + "  ip=" + kf2.m().q() + "   port=" + kf2.m().o() + "  sslPort=" + kf2.m().p());
                    int iT = t(string3, asyncHttpServerResponse, string2);
                    if (iT == 200) {
                        return;
                    }
                    xe3.a("newCommand", "command 收到本地服务指令 101 指令错误：code= " + iT + "  msg=" + g.get(Integer.valueOf(iT)));
                    w(asyncHttpServerResponse, iT, string2);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    w(asyncHttpServerResponse, 400, string2);
                    return;
                }
            }
        }
        w(asyncHttpServerResponse, 400, string2);
    }

    public int s(String str, AsyncHttpServerResponse asyncHttpServerResponse, String str2) {
        try {
            if (j) {
                j = false;
                HashMap map = new HashMap();
                map.put("commend", str);
                ScanQRDataBean scanQRDataBean = MyApplication.G;
                map.put("platform", scanQRDataBean != null ? scanQRDataBean.getPlatform() : "");
                ye3.d("X0005", WearUtils.A.toJson(map));
            }
            B();
            return f(str, asyncHttpServerResponse, str2);
        } catch (JsonSyntaxException | NumberFormatException e2) {
            e2.printStackTrace();
            return 404;
        }
    }

    public int t(String str, AsyncHttpServerResponse asyncHttpServerResponse, String str2) {
        synchronized (this.a) {
            if (d && !t32.j().q()) {
                return s(str, asyncHttpServerResponse, str2);
            }
            return 400;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(java.util.Map<java.lang.String, java.lang.Integer> r18, final com.wear.bean.Toy r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ff2.u(java.util.Map, com.wear.bean.Toy):void");
    }

    public void w(AsyncHttpServerResponse asyncHttpServerResponse, int i2, String str) {
        String str2;
        int i3;
        if (i2 == 4001) {
            try {
                str2 = g.get(Integer.valueOf(i2));
                i3 = 400;
            } catch (Exception unused) {
                return;
            }
        } else {
            i3 = i2;
            str2 = "";
        }
        x(asyncHttpServerResponse, false, g.get(Integer.valueOf(i3)), i3, str2, str);
    }

    public void x(AsyncHttpServerResponse asyncHttpServerResponse, boolean z, Object obj, int i2, String str, String str2) {
        HashMap map = new HashMap();
        try {
            map.put("type", "OK");
            if (z && obj != null) {
                if (!obj.toString().equals("" + i2)) {
                    map.put("data", obj);
                }
            }
            map.put(XHTMLText.CODE, Integer.valueOf(i2));
            if (!TextUtils.isEmpty(str)) {
                map.put("message", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (asyncHttpServerResponse != null) {
            try {
                asyncHttpServerResponse.setContentType("application/json");
                if (WearUtils.e1(str2)) {
                    asyncHttpServerResponse.send(WearUtils.A.toJson(map));
                } else {
                    asyncHttpServerResponse.send(str2 + "(" + WearUtils.A.toJson(map) + ")");
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void y(List<String> list, int i2, List<Integer> list2, List<String> list3) {
        int i3 = list.contains("p") ? PlaybackException.ERROR_CODE_DRM_UNSPECIFIED : list.contains(StreamManagement.AckRequest.ELEMENT) ? 1000 : 100;
        int i4 = 0;
        if (i2 >= i3) {
            for (Integer num : list2) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    sb.append(m(it.next(), 1, num.intValue()));
                    sb.append(",");
                }
                list3.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        int i5 = i3 / i2;
        if (list2.size() <= i5) {
            z(list, list2, list3, 0, list2.size(), list2.size());
            return;
        }
        int size = list2.size() / i5;
        if (list2.size() % i5 != 0) {
            size++;
        }
        int i6 = size;
        while (i4 < i6) {
            int i7 = i4 + 1;
            int i8 = i5 * i7;
            int i9 = i5 * i4;
            if (list2.size() > i8) {
                z(list, list2, list3, i9, i8, i5);
            } else {
                z(list, list2, list3, i9, list2.size(), list2.size() - i9);
            }
            i4 = i7;
        }
    }

    public final void z(List<String> list, List<Integer> list2, List<String> list3, int i2, int i3, int i4) {
        int iIntValue = 0;
        if (list.contains("p") || list.contains(StreamManagement.AckRequest.ELEMENT)) {
            for (int i5 = i2; i5 < i3; i5++) {
                iIntValue += list2.get(i5).intValue();
            }
        }
        for (String str : list) {
            if (TextUtils.equals("p", str) || TextUtils.equals(StreamManagement.AckRequest.ELEMENT, str)) {
                if (list.size() == 1) {
                    for (int i6 = i2; i6 < i3; i6++) {
                        list3.add("v:-1");
                    }
                }
                list3.set(i2, m(str, i4, iIntValue) + "," + list3.get(i2));
            } else {
                for (int i7 = i2; i7 < i3; i7++) {
                    list3.add(str + SignatureImpl.INNER_SEP + list2.get(i7));
                }
            }
        }
    }
}
