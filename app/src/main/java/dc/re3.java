package dc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.BindToyResponeItems;
import com.wear.bean.SwitchBeanFeaturesConfig;
import com.wear.bean.SwitchBeanUserConfig;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.ToyRename;
import com.wear.bean.response.BaseResponseStringBean;
import com.wear.dao.DaoUtils;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import dc.kn3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: InitUtils.java */
/* loaded from: classes4.dex */
public class re3 {
    public static kn3 a;
    public static final List<Toy> b = new ArrayList();
    public static int c = 0;
    public static boolean d = false;
    public static int e = 0;
    public static boolean f = false;

    /* compiled from: InitUtils.java */
    public class a implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: InitUtils.java */
    public class b implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe3.a("uploadDeviceToken", str);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: InitUtils.java */
    public class c implements zn2<String> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            SwitchBeanUserConfig switchBeanUserConfig = new SwitchBeanUserConfig();
            if (!WearUtils.e1(str)) {
                BaseResponseStringBean baseResponseStringBean = (BaseResponseStringBean) JSON.parseObject(str, BaseResponseStringBean.class);
                if (baseResponseStringBean.code == 0) {
                    switchBeanUserConfig.setValues((String) baseResponseStringBean.data);
                }
            }
            switchBeanUserConfig.decode(true);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            new SwitchBeanUserConfig().decode(true);
        }
    }

    /* compiled from: InitUtils.java */
    public class d implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            boolean unused = re3.d = false;
            SwitchBeanFeaturesConfig switchBeanFeaturesConfig = new SwitchBeanFeaturesConfig();
            if (!WearUtils.e1(str)) {
                try {
                    re3.c++;
                    NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
                    if (normalResponse.isResult() && normalResponse.getData() != null) {
                        Gson gson = WearUtils.A;
                        if (((SwitchBeanFeaturesConfig.Entity) gson.fromJson(gson.toJson(normalResponse.getData()), SwitchBeanFeaturesConfig.Entity.class)) != null) {
                            switchBeanFeaturesConfig.setValues(WearUtils.A.toJson(normalResponse.getData()));
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            switchBeanFeaturesConfig.decode(true);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            boolean unused = re3.d = false;
            new SwitchBeanFeaturesConfig().decode(true);
        }
    }

    /* compiled from: InitUtils.java */
    public class e implements yn2<BaseResponseBean> {
        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            boolean unused = re3.f = false;
            if (baseResponseBean.isResult()) {
                re3.e++;
                pg3.h().k(baseResponseBean.getData());
                aq2.j().m();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            boolean unused = re3.f = false;
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: InitUtils.java */
    public class f implements Runnable {
        public final /* synthetic */ l a;

        public f(l lVar) {
            this.a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = this.a;
            if (lVar == null) {
                MyApplication.T = true;
            }
            re3.o(lVar);
        }
    }

    /* compiled from: InitUtils.java */
    public class g implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            he3.f(null);
        }
    }

    /* compiled from: InitUtils.java */
    public class h implements zn2<String> {
        public final /* synthetic */ Map a;
        public final /* synthetic */ l b;

        /* compiled from: InitUtils.java */
        public class a implements Runnable {
            public final /* synthetic */ Toy a;

            public a(h hVar, Toy toy) {
                this.a = toy;
            }

            @Override // java.lang.Runnable
            public void run() {
                MyApplication myApplication = WearUtils.x;
                if (myApplication != null) {
                    myApplication.G().a0(this.a.getAddress(), true);
                }
            }
        }

        public h(Map map, l lVar) {
            this.a = map;
            this.b = lVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            List<BindToyResponeItems.DataBean> data;
            if (WearUtils.e1(str)) {
                return;
            }
            BindToyResponeItems bindToyResponeItems = (BindToyResponeItems) new Gson().fromJson(str, BindToyResponeItems.class);
            if (bindToyResponeItems == null) {
                l lVar = this.b;
                if (lVar != null) {
                    lVar.a();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (!bindToyResponeItems.isResult() && bindToyResponeItems.getData() != null && (data = bindToyResponeItems.getData()) != null && data.size() > 0) {
                String str2 = "";
                String str3 = str2;
                int i = 0;
                for (BindToyResponeItems.DataBean dataBean : data) {
                    str3 = str3 + dataBean.getId() + "#";
                    Toy toy = (Toy) this.a.remove(dataBean.getId());
                    if (toy != null) {
                        if (dataBean.getCode().equals("401")) {
                            toy.setBindType(2);
                            toy.setDisConnectType(3);
                            str2 = str2 + String.format(ah4.e(R.string.toys_bind_notice_401), toy.getName(), dataBean.getId());
                            rp1.g(toy);
                            re3.u(toy);
                        } else if (dataBean.getCode().equals("402")) {
                            toy.setBindType(2);
                            toy.setDisConnectType(4);
                            str2 = str2 + String.format(ah4.e(R.string.toys_bind_notice_402), toy.getName(), dataBean.getId());
                            rp1.l(toy);
                            re3.u(toy);
                        } else if (dataBean.getCode().equals("403")) {
                            toy.setBindType(2);
                            toy.setDisConnectType(2);
                            str2 = str2 + String.format(ah4.e(R.string.toys_bind_notice_403), toy.getName(), dataBean.getId());
                            rp1.m(toy);
                            re3.u(toy);
                        }
                        int i2 = i + 1;
                        if (i < data.size() - 1) {
                            str2 = str2 + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        arrayList.add(toy);
                        WearUtils.x.l.postDelayed(new a(this, toy), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                        i = i2;
                    }
                }
                if (!WearUtils.e1(str2)) {
                    re3.n(str2, data.size(), this.b);
                }
            }
            if (!this.a.isEmpty() && !WearUtils.e1(zt3.k)) {
                for (Toy toy2 : this.a.values()) {
                    DaoUtils.getToyDao().update(toy2);
                    arrayList.add(toy2);
                    Toy toyQ = WearUtils.x.G().Q(toy2.getAddress());
                    if (toyQ != null) {
                        toyQ.setIsCheckBindToy(1);
                    }
                }
            }
            if (re3.b != null && re3.b.size() > 0) {
                arrayList.addAll(re3.b);
            }
            if (arrayList.size() > 0) {
                EventBus.getDefault().post(new vc1("", 100));
                ze3.a(arrayList);
                re3.i();
            }
            l lVar2 = this.b;
            if (lVar2 != null) {
                lVar2.a();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: InitUtils.java */
    public class i implements Runnable {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;

        /* compiled from: InitUtils.java */
        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
                try {
                    l lVar = i.this.a;
                    if (lVar != null) {
                        lVar.a();
                    }
                    xg3.i().n(false);
                } catch (Exception unused) {
                }
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                try {
                    l lVar = i.this.a;
                    if (lVar != null) {
                        lVar.a();
                    }
                    xg3.i().n(false);
                } catch (Exception unused) {
                }
            }
        }

        public i(l lVar, String str) {
            this.a = lVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = this.a;
            if (lVar != null) {
                lVar.b();
            }
            re3.j();
            Activity activityK = re3.k();
            if (activityK == null) {
                return;
            }
            xg3.i().n(true);
            kn3 unused = re3.a = new kn3((Context) activityK, this.b, ah4.e(R.string.common_ok), false, false, (kn3.d) new a());
            re3.a.show();
            re3.a.n();
        }
    }

    /* compiled from: InitUtils.java */
    public class j implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            System.out.println(str);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: InitUtils.java */
    public class k implements zn2<String> {
        public final /* synthetic */ Toy a;

        /* compiled from: InitUtils.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WearUtils.x.G().a0(k.this.a.getAddress(), true);
                EventBus.getDefault().post(new xc1(k.this.a.getAddress(), 0));
            }
        }

        public k(Toy toy) {
            this.a = toy;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BindToyResponeItems bindToyResponeItems;
            List<BindToyResponeItems.DataBean> data;
            this.a.setIsCheckBindToy(1);
            if (WearUtils.e1(str)) {
                return;
            }
            try {
                bindToyResponeItems = (BindToyResponeItems) new Gson().fromJson(str, BindToyResponeItems.class);
            } catch (Exception unused) {
                bindToyResponeItems = null;
            }
            if (bindToyResponeItems != null) {
                if (!bindToyResponeItems.isResult() && bindToyResponeItems.getData() != null && (data = bindToyResponeItems.getData()) != null && data.size() > 0) {
                    String string = "";
                    int i = 0;
                    for (BindToyResponeItems.DataBean dataBean : data) {
                        if (this.a != null) {
                            if (dataBean.getCode().equals("401")) {
                                this.a.setBindType(2);
                                this.a.setDisConnectType(3);
                                StringBuilder sb = new StringBuilder();
                                sb.append(string);
                                String strE = ah4.e(R.string.toys_bind_notice_401);
                                Object[] objArr = new Object[2];
                                objArr[0] = this.a.getName();
                                objArr[1] = WearUtils.e1(this.a.getDeviceType()) ? dataBean.getId() : this.a.getDeviceType();
                                sb.append(String.format(strE, objArr));
                                string = sb.toString();
                                rp1.g(this.a);
                                re3.u(this.a);
                            } else if (dataBean.getCode().equals("402")) {
                                this.a.setBindType(2);
                                this.a.setDisConnectType(4);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string);
                                String strE2 = ah4.e(R.string.toys_bind_notice_402);
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = this.a.getName();
                                objArr2[1] = WearUtils.e1(this.a.getDeviceType()) ? dataBean.getId() : this.a.getDeviceType();
                                sb2.append(String.format(strE2, objArr2));
                                string = sb2.toString();
                                rp1.l(this.a);
                                re3.u(this.a);
                            } else if (dataBean.getCode().equals("403")) {
                                this.a.setBindType(2);
                                this.a.setDisConnectType(2);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(string);
                                String strE3 = ah4.e(R.string.toys_bind_notice_403);
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = this.a.getName();
                                objArr3[1] = WearUtils.e1(this.a.getDeviceType()) ? dataBean.getId() : this.a.getDeviceType();
                                sb3.append(String.format(strE3, objArr3));
                                string = sb3.toString();
                                rp1.m(this.a);
                                re3.u(this.a);
                            }
                            int i2 = i + 1;
                            if (i < data.size() - 1) {
                                string = string + IOUtils.LINE_SEPARATOR_UNIX;
                            }
                            WearUtils.x.l.postDelayed(new a(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                            i = i2;
                        }
                    }
                    if (!WearUtils.e1(string)) {
                        re3.n(string, data.size(), null);
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.a);
                EventBus.getDefault().post(new vc1("", 100));
                ze3.a(arrayList);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            this.a.setIsCheckBindToy(0);
            this.a.setGetCheckBindToyErrorTime(System.currentTimeMillis());
        }
    }

    /* compiled from: InitUtils.java */
    public interface l {
        void a();

        void b();
    }

    public static void g(Toy toy) {
        toy.setBindType(3);
        b.add(toy);
    }

    public static void h(Toy toy, String str) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = MyApplication.Q(fragmentActivityH) == null ? "" : MyApplication.Q(fragmentActivityH).versionName;
        }
        String str2 = !WearUtils.e1(zt3.k) ? zt3.k : WearUtils.a;
        HashMap map = new HashMap();
        map.put("deviceType", str);
        map.put(MultipleAddresses.Address.ELEMENT, toy.getAddress());
        map.put("email", str2);
        map.put("proType", "remote");
        map.put("softVersion", WearUtils.q);
        map.put("clientType", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("clientVersion", Build.VERSION.RELEASE);
        map.put("deviceInfo", Build.MODEL);
        map.put("clientMac", tz.i());
        tn2.x(WearUtils.x).l("/toy/bindAddress", map, new j());
    }

    public static void i() {
        b.clear();
    }

    public static void j() {
        try {
            kn3 kn3Var = a;
            if (kn3Var != null) {
                if (kn3Var.isShowing()) {
                    Context baseContext = ((ContextWrapper) a.getContext()).getBaseContext();
                    if (!(baseContext instanceof Activity)) {
                        a.dismiss();
                    } else if (!((Activity) baseContext).isFinishing() && !((Activity) baseContext).isDestroyed()) {
                        a.dismiss();
                    }
                }
                a = null;
            }
        } catch (Exception unused) {
        }
    }

    public static Activity k() {
        Activity activityH = MyApplication.H();
        if (activityH == null) {
            activityH = WearUtils.x.M();
        }
        if (activityH == null || !activityH.isFinishing()) {
            return activityH;
        }
        return null;
    }

    public static void l() {
        List<Toy> listFindAll = DaoUtils.getToyDao().findAll();
        if (WearUtils.g1(listFindAll)) {
            return;
        }
        for (Toy toy : listFindAll) {
            if (Toy.NAME_MAP.containsKey(toy.getType())) {
                ToyRename toyRenameFindToyName = DaoUtils.getToyRenameDao().findToyName(WearUtils.y.r(), toy.getAddress());
                toy.setDefineRename(toyRenameFindToyName == null ? "" : toyRenameFindToyName.getName());
                toy.setRquestConnectTime(Long.valueOf(be3.I().getTime()));
                pc1.a.u(toy);
            }
        }
    }

    public static void m() {
        vg3.b().a(new g());
    }

    public static void n(String str, int i2, l lVar) {
        Activity activityK = k();
        if (activityK == null) {
            return;
        }
        activityK.runOnUiThread(new i(lVar, str));
    }

    public static void o(l lVar) {
        if (MyApplication.H() == null) {
            return;
        }
        if (lVar == null) {
            i();
        }
        List<Toy> listFindAll = DaoUtils.getToyDao().findAll();
        if (WearUtils.g1(listFindAll)) {
            return;
        }
        HashMap map = new HashMap();
        for (Toy toy : listFindAll) {
            if (!toy.isVirtualToy() && toy.getIsCheckBindToy() != 1 && toy.isRealDeviceType()) {
                toy.setBindType(1);
                if (Toy.isDeviceTypeMessage(toy.getDeviceType().toLowerCase())) {
                    map.put(toy.getDeviceType(), toy);
                } else {
                    WearUtils.x.G().a0(toy.getAddress(), true);
                }
            }
        }
        if (!MyApplication.T || map.isEmpty()) {
            return;
        }
        MyApplication.T = false;
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = MyApplication.Q(WearUtils.x) == null ? "" : MyApplication.Q(WearUtils.x).versionName;
        }
        HashMap map2 = new HashMap();
        map2.put("deviceTypes", WearUtils.G1(map.keySet(), "=="));
        map2.put("proType", "remote");
        map2.put("softVersion", WearUtils.q);
        map2.put("clientType", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map2.put("clientVersion", Build.VERSION.RELEASE);
        map2.put("deviceInfo", Build.MODEL);
        map2.put("clientMac", tz.i());
        tn2.x(WearUtils.x).l("/toy/checkAndBindV2", map2, new h(map, lVar));
    }

    public static void p(l lVar) {
        vg3.b().a(new f(lVar));
    }

    public static void q(Toy toy, String str) {
        if (toy == null || WearUtils.e1(str) || toy.isVirtualToy()) {
            return;
        }
        if (!Toy.isDeviceTypeMessage(str.toLowerCase())) {
            WearUtils.x.G().a0(toy.getAddress(), true);
            return;
        }
        if (toy.getIsCheckBindToy() == 1 || toy.getGetCheckBindToyErrorTime() - System.currentTimeMillis() > 600000 || toy.getIsCheckBindToy() == 2) {
            return;
        }
        toy.setBindType(1);
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = MyApplication.Q(WearUtils.x) == null ? "" : MyApplication.Q(WearUtils.x).versionName;
        }
        HashMap map = new HashMap();
        map.put("deviceTypes", str);
        map.put("proType", "remote");
        map.put("softVersion", WearUtils.q);
        map.put("clientType", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("clientVersion", Build.VERSION.RELEASE);
        map.put("deviceInfo", Build.MODEL);
        map.put("clientMac", tz.i());
        toy.setIsCheckBindToy(2);
        tn2.x(WearUtils.x).l("/toy/checkAndBindV2", map, new k(toy));
    }

    public static synchronized void r() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            d = false;
        }
        if (f) {
            return;
        }
        if (e >= 2) {
            return;
        }
        f = true;
        tn2.x(WearUtils.x).d("/api/common_base_data?platform=android&version=" + WearUtils.q, new e());
    }

    public static synchronized void s() {
        try {
        } catch (Exception e2) {
            d = false;
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        if (d) {
            return;
        }
        if (c >= 2) {
            return;
        }
        HashMap map = new HashMap();
        map.put("appType", "remote");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("model", Build.MODEL);
        map.put("version", WearUtils.q);
        map.put("systemVersion", Build.VERSION.RELEASE);
        map.put("remark", "");
        map.put("apv", SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
        d = true;
        tn2.x(WearUtils.x).l("/api/featuresConfig", map, new d());
    }

    public static void t() {
        if (WearUtils.y.u() != null) {
            tn2.x(WearUtils.x).l("/api/user/findUserConfig", new HashMap(), new c());
        }
    }

    public static void u(Toy toy) {
        if (toy == null || WearUtils.e1(toy.getDeviceType())) {
            return;
        }
        tn2.x(WearUtils.x).l("/toy/unbind/" + toy.getDeviceTypeMac(toy.getDeviceType()), new HashMap(), new a());
    }

    public static void v(String str) {
        HashMap map = new HashMap();
        map.put("deviceToken", str);
        HashMap map2 = new HashMap();
        map2.put("config", WearUtils.A.toJson(map));
        tn2.x(WearUtils.x).t("/api/user/updateUserConfig", map2, new b());
    }
}
