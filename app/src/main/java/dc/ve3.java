package dc;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.DfuBean;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.LanApiDfuUpdateBean;
import com.wear.bean.Toy;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.LanApiUpdateToyDailog;
import dc.is3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* compiled from: LanApiUtil.java */
/* loaded from: classes4.dex */
public class ve3 {
    public static LanApiUpdateToyDailog b;
    public static ve3 c;
    public final Object a = new Object();

    /* compiled from: LanApiUtil.java */
    public class a implements zn2<String> {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe3.a("newCommand", "升级数据返回！ response = " + str);
            if (WearUtils.e1(str)) {
                return;
            }
            LanApiDfuUpdateBean lanApiDfuUpdateBean = (LanApiDfuUpdateBean) new Gson().fromJson(str, LanApiDfuUpdateBean.class);
            if (!lanApiDfuUpdateBean.isResult()) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    Toy toy = (Toy) it.next();
                    toy.addLanApiUpdateCount();
                    if (toy.getLanApiUpdateCount() >= 2) {
                        toy.setLanApiUpdateRequest(true);
                    }
                }
                return;
            }
            List<LanApiDfuUpdateBean.DataBean> data = lanApiDfuUpdateBean.getData();
            ArrayList arrayList = new ArrayList();
            if (data != null && data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    for (int i2 = 0; i2 < this.a.size(); i2++) {
                        Toy toy2 = (Toy) this.a.get(i2);
                        String lowerCase = toy2.getDeviceTypeMac(toy2.getDeviceType()).toLowerCase();
                        LanApiDfuUpdateBean.DataBean dataBean = data.get(i);
                        if (lowerCase.equals(dataBean.getMacId().toLowerCase()) && dataBean.isHasUpdate() && ((toy2.getUpdateDfu() == null || toy2.getUpdateDfu().getVersion() <= dataBean.getVersion()) && dataBean.isHasUpdate())) {
                            DfuBean dfuBean = new DfuBean();
                            dfuBean.setHasUpdate(dataBean.isHasUpdate());
                            dfuBean.setMd5(dataBean.getMd5());
                            dfuBean.setUrl(nd3.j(dataBean.getUrl()));
                            dfuBean.setVersion(dataBean.getVersion());
                            dfuBean.setLanApiUpdate(true);
                            toy2.setUpdateDfu(dfuBean);
                            arrayList.add(toy2.getName());
                            EventBus.getDefault().post(new xc1(toy2.getAddress(), 1));
                            MyApplication myApplication = WearUtils.x;
                            if (myApplication != null) {
                                LocalBroadcastManager.getInstance(myApplication).sendBroadcast(new Intent("ACTION_TOY_UPDATE"));
                            }
                        }
                    }
                }
            }
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((Toy) it2.next()).setLanApiUpdateRequest(true);
            }
            if (arrayList.size() > 0) {
                ve3.this.h(arrayList);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: LanApiUtil.java */
    public class b implements Runnable {
        public final /* synthetic */ List a;

        /* compiled from: LanApiUtil.java */
        public class a implements LanApiUpdateToyDailog.b {
            public a(b bVar) {
            }

            @Override // com.wear.widget.dialog.LanApiUpdateToyDailog.b
            public void a() {
                ve3.b.dismiss();
            }
        }

        public b(ve3 ve3Var, List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            xe3.a("newCommand", "显示弹窗！");
            if (ve3.b == null || !ve3.b.isShowing()) {
                is3.b bVar = new is3.b(MyApplication.H());
                bVar.p(ah4.e(R.string.lan_api_need_update_toy));
                bVar.v(R.id.tv_text);
                bVar.n(ah4.e(R.string.common_ok));
                bVar.t(R.id.tv_cancel);
                LanApiUpdateToyDailog unused = ve3.b = (LanApiUpdateToyDailog) cs3.i(bVar, LanApiUpdateToyDailog.class);
                ve3.b.setListener(new a(this));
                ve3.b.show();
                ve3.b.setShowToyName(this.a);
                EventBus.getDefault().post(new LanApiControlEvent(true));
                ff2.n().B();
            }
        }
    }

    public static ve3 d() {
        if (c == null) {
            c = new ve3();
        }
        return c;
    }

    public boolean e() {
        ArrayList<Toy> arrayListP = WearUtils.x.G().P();
        for (int i = 0; i < arrayListP.size(); i++) {
            Toy toy = arrayListP.get(i);
            if (toy.getUpdateDfu() != null && toy.getUpdateDfu().isHasUpdate() && toy.getUpdateDfu().isLanApiUpdate()) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        synchronized (this.a) {
            xe3.a("newCommand", "查询玩具是否需要升级！");
            String deviceType = "";
            HashMap map = new HashMap();
            ArrayList<Toy> arrayListP = WearUtils.x.G().P();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < arrayListP.size(); i++) {
                Toy toy = arrayListP.get(i);
                if (toy.isRealDeviceType() && !toy.toyIsSupportLanApi() && !toy.isLanApiUpdateRequest()) {
                    deviceType = WearUtils.e1(deviceType) ? toy.getDeviceType() : deviceType + toy.getDeviceType();
                    arrayList.add(toy);
                }
            }
            if (arrayList.size() <= 0) {
                EventBus.getDefault().post(new LanApiControlEvent(true));
                return;
            }
            map.put("uid", "");
            map.put(PSOProgramService.VS_Key, deviceType);
            map.put("apiVer", 101);
            xe3.a("newCommand", "玩具需要升级！ v = " + deviceType);
            tn2.x(WearUtils.x).l("/api/toy/checkToyLanCommand", map, new a(arrayList));
        }
    }

    public void g() {
        if (ff2.d) {
            EventBus.getDefault().post(new LanApiControlEvent(true));
        }
    }

    public final void h(List<String> list) {
        if (MyApplication.H() != null) {
            MyApplication.H().runOnUiThread(new b(this, list));
        }
    }

    public synchronized void i(String str) {
        if (ff2.d) {
            Toy toyQ = WearUtils.x.G().Q(str);
            if (toyQ == null) {
                return;
            }
            if (toyQ.isLanApiUpdateRequest()) {
                return;
            }
            if (toyQ.toyIsSupportLanApi()) {
                return;
            }
            if (!MyApplication.Z || MyApplication.O) {
                f();
            }
        }
    }
}
