package dc;

import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.event.BrowserOpenDPEvent;
import com.wear.bean.socketio.display.ControlModelToyStatusBean;
import com.wear.bean.socketio.display.DisplayPannelIfoBean;
import com.wear.bean.socketio.display.RemoteQueryControlStatusBean;
import com.wear.bean.socketio.display.ScanModelControlQrCodeRequestBean;
import com.wear.bean.socketio.display.ShakeControlModelBean;
import com.wear.bean.socketio.display.ToyInfoBean;
import com.wear.main.longDistance.DisplayPannelAcriviry;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: DisplayPannelManagerImpl.java */
/* loaded from: classes3.dex */
public class pb2 extends rz1 implements tf2, tz1, yc1 {
    public static volatile pb2 n = null;
    public static final String o = "pb2";
    public static final Object p = new Object();
    public static int q = 0;
    public static String r = "apps.lovense.com";
    public MyApplication a;
    public ToyInfoBean b;
    public f c;
    public DisplayPannelIfoBean d;
    public boolean e;
    public Timer f;
    public pc1 h;
    public int i;
    public int k;
    public long g = 3000;
    public Timer j = null;
    public Handler l = new Handler(Looper.getMainLooper());
    public Handler m = new Handler(Looper.getMainLooper());

    /* compiled from: DisplayPannelManagerImpl.java */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws Throwable {
            try {
                String strB = sf3.b(1, 1, pb2.r);
                if (!TextUtils.isEmpty(strB) && Double.parseDouble(strB) <= 250.0d) {
                    pb2.this.z(false);
                } else {
                    pb2.this.z(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: DisplayPannelManagerImpl.java */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (pb2.p) {
                if (pb2.this.d.isReady()) {
                    pb2 pb2Var = pb2.this;
                    int i = pb2Var.i + 1;
                    pb2Var.i = i;
                    int readyTime = i - pb2Var.d.getReadyTime();
                    if (readyTime <= 0) {
                        if (pb2.this.c != null) {
                            String str = (-readyTime) + "s";
                            String str2 = String.format(ah4.e(R.string.display_panel_wait_panel), str);
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                            int iIndexOf = str2.indexOf(str);
                            if (iIndexOf != -1 && str.length() + iIndexOf <= spannableStringBuilder.length()) {
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(pb2.this.a, R.color.color_accent)), iIndexOf, str.length() + iIndexOf, 34);
                            }
                            pb2.this.c.a4(spannableStringBuilder);
                        }
                    } else if (readyTime >= 4) {
                        pb2.this.z(true);
                    }
                } else if (pb2.this.d.isStart()) {
                    pb2 pb2Var2 = pb2.this;
                    int i2 = pb2Var2.k + 1;
                    pb2Var2.k = i2;
                    if (i2 > pb2Var2.d.getControlTime()) {
                        pb2.this.k();
                        f fVar = pb2.this.c;
                        if (fVar != null) {
                            fVar.g1();
                        }
                        sg3.k(pb2.this.a, ah4.e(R.string.display_panel_sync_over));
                    } else if (pb2.this.c != null) {
                        String str3 = pb2.this.k + "s";
                        String str4 = str3 + "/" + pb2.this.d.getControlTime() + "s";
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str4);
                        int iIndexOf2 = str4.indexOf(str3);
                        if (iIndexOf2 != -1 && str3.length() + iIndexOf2 <= spannableStringBuilder2.length()) {
                            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(pb2.this.a, R.color.color_accent)), iIndexOf2, str3.length() + iIndexOf2, 34);
                        }
                        pb2 pb2Var3 = pb2.this;
                        pb2Var3.c.t0(pb2Var3.k, pb2Var3.d.getControlTime(), spannableStringBuilder2);
                    }
                }
            }
        }
    }

    /* compiled from: DisplayPannelManagerImpl.java */
    public class c implements zn2<String> {
        public final /* synthetic */ List a;
        public final /* synthetic */ qb2 b;

        public c(List list, qb2 qb2Var) {
            this.a = list;
            this.b = qb2Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            pb2.this.t(pb2.o, str);
            BaseResponseBean baseResponseBean = (BaseResponseBean) JSON.parseObject(str, BaseResponseBean.class);
            if (baseResponseBean.isResult()) {
                pb2.this.b = (ToyInfoBean) this.a.get(0);
                qb2 qb2Var = this.b;
                if (qb2Var != null) {
                    qb2Var.q1(true);
                }
                sg3.l(ah4.e(R.string.qrcode_upload_toy_successfully));
                return;
            }
            if ("998".equals(baseResponseBean.getCode())) {
                sg3.l(ah4.e(R.string.qrcode_scan_with_another_account));
            } else {
                sg3.l(String.format(ah4.e(R.string.qrcode_server_error), baseResponseBean.getCode() + ""));
            }
            qb2 qb2Var2 = this.b;
            if (qb2Var2 != null) {
                qb2Var2.Q0();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.l(String.format(ah4.e(R.string.qrcode_server_error), netException.getCode()));
            qb2 qb2Var = this.b;
            if (qb2Var != null) {
                qb2Var.Q0();
            }
        }
    }

    /* compiled from: DisplayPannelManagerImpl.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pb2.this.l.removeCallbacksAndMessages(null);
            pb2.this.h.u0();
        }
    }

    /* compiled from: DisplayPannelManagerImpl.java */
    public class e implements Runnable {
        public final /* synthetic */ Toy a;

        public e(Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            pb2.this.m.removeCallbacksAndMessages(null);
            ControlModelToyStatusBean controlModelToyStatusBean = new ControlModelToyStatusBean();
            ArrayList arrayList = new ArrayList();
            pb2.this.b.setStatus(this.a.isConnected() ? 1 : 0);
            arrayList.add(pb2.this.b);
            controlModelToyStatusBean.toyInfoList = arrayList;
            pb2.this.x(controlModelToyStatusBean);
            pb2 pb2Var = pb2.this;
            f fVar = pb2Var.c;
            if (fVar == null || pb2Var.d == null) {
                return;
            }
            fVar.c4(pb2Var.b, pb2.this.d);
        }
    }

    /* compiled from: DisplayPannelManagerImpl.java */
    public interface f {
        void E1(DisplayPannelIfoBean displayPannelIfoBean, ToyInfoBean toyInfoBean);

        void a4(CharSequence charSequence);

        void b4(boolean z);

        void c4(ToyInfoBean toyInfoBean, DisplayPannelIfoBean displayPannelIfoBean);

        void d3(ToyInfoBean toyInfoBean);

        void g1();

        void i2(DisplayPannelIfoBean displayPannelIfoBean);

        void q2();

        void q3(String str);

        void t0(int i, int i2, CharSequence charSequence);
    }

    public pb2() {
        this.h = null;
        MyApplication myApplication = WearUtils.x;
        this.a = myApplication;
        this.h = myApplication.G();
    }

    public static pb2 m() {
        if (n == null) {
            synchronized (pb2.class) {
                if (n == null) {
                    n = new pb2();
                    EventBus.getDefault().register(n);
                    pc1.a.t(n);
                }
            }
        }
        return n;
    }

    public void A(String str) {
        ToyInfoBean toyInfoBean;
        if (str == null || !str.contains("singleWay")) {
            synchronized (p) {
                DisplayPannelIfoBean displayPannelIfoBean = this.d;
                if (displayPannelIfoBean != null) {
                    displayPannelIfoBean.setControlType("twoWay");
                    if (!this.d.isStart()) {
                        return;
                    }
                }
                f fVar = this.c;
                if (fVar != null && (toyInfoBean = this.b) != null) {
                    fVar.d3(toyInfoBean);
                }
                Toy toyL = l(this.b.getId());
                if (toyL != null) {
                    this.h.s0(toyL);
                    return;
                }
                return;
            }
        }
        synchronized (p) {
            DisplayPannelIfoBean displayPannelIfoBean2 = this.d;
            if (displayPannelIfoBean2 != null) {
                displayPannelIfoBean2.setControlType("singleWay");
                if (!this.d.isStart()) {
                    return;
                }
            }
            Toy toyL2 = l(this.b.getId());
            f fVar2 = this.c;
            if (fVar2 != null && this.b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(TextUtils.isEmpty(this.b.getVersion()) ? "" : this.b.getVersion());
                fVar2.q3(sb.toString());
                sg3.h(R.string.display_panel_mouse_control_toast);
                H();
            }
            if (toyL2 != null) {
                this.h.E(toyL2);
            }
        }
    }

    public void B() {
        k();
        f fVar = this.c;
        if (fVar != null) {
            fVar.g1();
        }
    }

    public void C() {
        synchronized (p) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.q2();
                sg3.l(ah4.e(R.string.display_panel_end_of_queue));
            }
            k();
        }
    }

    public void D(String str) {
        synchronized (p) {
            if (MyApplication.H() instanceof DisplayPannelAcriviry) {
                EventBus.getDefault().post(new BrowserOpenDPEvent());
            }
            DisplayPannelIfoBean displayPannelIfoBean = (DisplayPannelIfoBean) JSON.parseObject(str, DisplayPannelIfoBean.class);
            this.d = displayPannelIfoBean;
            if (displayPannelIfoBean != null && !WearUtils.e1(displayPannelIfoBean.getPcOrMobile())) {
                if (this.d.getPcOrMobile().equals("mobile")) {
                    q = 1;
                } else {
                    q = 0;
                }
            }
            if (this.d.isReady() || this.d.isStart()) {
                if (this.b == null) {
                    if (TextUtils.isEmpty(this.d.getCsToyInfo())) {
                        if (this.c != null) {
                            k();
                            this.c.g1();
                        }
                        return;
                    } else {
                        List array = JSON.parseArray(this.d.getCsToyInfo(), ToyInfoBean.class);
                        if (array.size() == 0) {
                            if (this.c != null) {
                                k();
                                this.c.g1();
                            }
                            return;
                        }
                        this.b = (ToyInfoBean) array.get(0);
                    }
                }
                if (this.d.isStart() && this.d.getExpire() <= 0) {
                    if (this.c != null) {
                        k();
                        this.c.g1();
                    }
                    return;
                }
                Toy toyL = l(this.b.getId());
                if (toyL == null || !toyL.isConnected()) {
                    this.b.setStatus(0);
                    ControlModelToyStatusBean controlModelToyStatusBean = new ControlModelToyStatusBean();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.b);
                    controlModelToyStatusBean.toyInfoList = arrayList;
                    x(controlModelToyStatusBean);
                } else if (!this.b.isConnect()) {
                    this.b.setStatus(1);
                    ControlModelToyStatusBean controlModelToyStatusBean2 = new ControlModelToyStatusBean();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(this.b);
                    controlModelToyStatusBean2.toyInfoList = arrayList2;
                    x(controlModelToyStatusBean2);
                }
                F();
                E();
            }
        }
    }

    public final void E() {
        if (!this.e) {
            this.e = true;
            sz1.d().q(1024);
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH != null) {
                pj3.f(fragmentActivityH, DisplayPannelAcriviry.class);
                EventBus.getDefault().post(new BrowserOpenDPEvent());
            }
        }
        if (this.d.isReady()) {
            this.i = 0;
            v(true);
        } else {
            v(false);
        }
        if (this.d.isStart()) {
            this.k = this.d.getControlTime() - this.d.getExpire();
        }
        o();
    }

    public void F() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
        Timer timer2 = new Timer();
        this.f = timer2;
        timer2.schedule(new b(), 1000L, 1000L);
    }

    public void G(Toy toy, String str, int i, qb2 qb2Var) {
        q = i;
        ScanModelControlQrCodeRequestBean scanModelControlQrCodeRequestBean = new ScanModelControlQrCodeRequestBean();
        scanModelControlQrCodeRequestBean.setRoomKey(str);
        scanModelControlQrCodeRequestBean.setPcOrMobile(i == 0 ? "pc" : "mobile");
        List<ToyInfoBean> listI = I(toy);
        scanModelControlQrCodeRequestBean.setToyInfoList(listI);
        xe3.a(o, WearUtils.A.toJson(scanModelControlQrCodeRequestBean));
        if (qb2Var != null) {
            qb2Var.x0();
        }
        tn2.x(this.a).m("/api/remote/scanModelControlQrCode", WearUtils.A.toJson(scanModelControlQrCodeRequestBean), new c(listI, qb2Var));
    }

    public final void H() {
        this.l.postDelayed(new d(), 1000L);
    }

    public final List<ToyInfoBean> I(Toy toy) {
        ArrayList arrayList = new ArrayList();
        ToyInfoBean toyInfoBean = new ToyInfoBean();
        toyInfoBean.setId(toy.getAndUpdateDeviceId());
        toyInfoBean.setName(toy.getType().toLowerCase());
        toyInfoBean.setVersion(toy.getGenerationVersion());
        toyInfoBean.setNickName(toy.getDefineRename());
        toyInfoBean.setfVersion(toy.getToyVersion() + "");
        toyInfoBean.setStatus(toy.isConnected() ? 1 : 0);
        arrayList.add(toyInfoBean);
        return arrayList;
    }

    @Override // dc.tf2
    public void connectSuc() {
        x(new RemoteQueryControlStatusBean());
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    @Override // dc.tz1
    public int getPriority() {
        return 1024;
    }

    public boolean i() {
        return this.e;
    }

    @Override // dc.yc1
    public void j(String str, List<Integer> list, List<Integer> list2) {
        DisplayPannelIfoBean displayPannelIfoBean;
        ToyInfoBean toyInfoBean;
        t(o, str + "  " + list);
        Toy toyQ = this.h.Q(str);
        if (toyQ != null && this.e && (displayPannelIfoBean = this.d) != null && displayPannelIfoBean.isStart() && this.d.isTwoWay() && (toyInfoBean = this.b) != null && toyInfoBean.getId().equals(toyQ.getAndUpdateDeviceId()) && this.d.getModToyId() != null) {
            int iIntValue = list.size() > 0 ? list.get(0).intValue() : 0;
            int iIntValue2 = list2.size() > 0 ? list2.get(0).intValue() : 0;
            for (String str2 : this.d.getModToyId().split(",")) {
                ShakeControlModelBean shakeControlModelBean = new ShakeControlModelBean();
                ShakeControlModelBean.ToyCmd.Data data = new ShakeControlModelBean.ToyCmd.Data();
                ShakeControlModelBean.ToyCmd.Data.Id id = new ShakeControlModelBean.ToyCmd.Data.Id();
                id.p = Math.min(iIntValue2, 3);
                id.v = iIntValue2;
                id.r = iIntValue2;
                data.id.put(str2, id);
                shakeControlModelBean.toyCmd.data = JSON.toJSONString(data);
                x(shakeControlModelBean);
            }
            if (!mp1.h()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(pc1.a.P());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Toy toy = (Toy) it.next();
                    if (!toy.isThridPartToy() || !toy.getAddress().equals(str)) {
                        rq1.d.m(toy.getAddress(), iIntValue);
                    }
                }
                return;
            }
            HashMap map = new HashMap();
            map.put(PSOProgramService.VS_Key, Integer.valueOf(iIntValue));
            map.put("v1", Integer.valueOf(iIntValue));
            map.put("v2", Integer.valueOf(iIntValue));
            map.put("v3", Integer.valueOf(iIntValue));
            map.put(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(iIntValue));
            map.put("t", Integer.valueOf(iIntValue));
            map.put("s", Integer.valueOf(iIntValue));
            map.put("f", Integer.valueOf(iIntValue));
            map.put("p", Integer.valueOf(Math.min(iIntValue2, 3)));
            rq1.d.l(map);
        }
    }

    public void k() {
        Toy toyL;
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
        v(false);
        sz1.d().b(1024);
        this.e = false;
        ToyInfoBean toyInfoBean = this.b;
        if (toyInfoBean != null && (toyL = l(toyInfoBean.getId())) != null) {
            this.h.E(toyL);
        }
        H();
    }

    public final Toy l(String str) {
        ArrayList<Toy> arrayList = new ArrayList();
        arrayList.addAll(this.a.G().o());
        for (Toy toy : arrayList) {
            if (toy.getAndUpdateDeviceId().equals(str)) {
                return toy;
            }
        }
        return null;
    }

    public void o() {
        synchronized (p) {
            ToyInfoBean toyInfoBean = this.b;
            if (toyInfoBean == null) {
                t(o, "init  toyInfo ==null");
                return;
            }
            if (this.d == null) {
                return;
            }
            Toy toyL = l(toyInfoBean.getId());
            if (toyL != null) {
                String str = o;
                t(str, "init  toy !=null");
                if (this.d.isStart()) {
                    t(str, "init  info==" + this.d.isTwoWay());
                    if (this.d.isTwoWay()) {
                        this.h.s0(toyL);
                    } else {
                        this.h.E(toyL);
                    }
                }
            }
            f fVar = this.c;
            if (fVar != null) {
                fVar.a4(ah4.e(R.string.display_panel_sync_on));
                if (this.d.isStart()) {
                    this.c.i2(this.d);
                    if (this.d.isTwoWay()) {
                        ToyInfoBean toyInfoBean2 = this.b;
                        if (toyInfoBean2 != null) {
                            this.c.c4(toyInfoBean2, this.d);
                            this.c.d3(this.b);
                        }
                    } else if (this.b != null) {
                        f fVar2 = this.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.b.getName());
                        sb.append(TextUtils.isEmpty(this.b.getVersion()) ? "" : this.b.getVersion());
                        fVar2.q3(sb.toString());
                    }
                } else if (this.d.isReady()) {
                    this.c.E1(this.d, this.b);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        ToyInfoBean toyInfoBean;
        Toy toyL;
        if (!this.e || TextUtils.isEmpty(xc1Var.a()) || (toyInfoBean = this.b) == null || (toyL = l(toyInfoBean.getId())) == null || !toyL.getAddress().equals(xc1Var.a())) {
            return;
        }
        synchronized (p) {
            if (this.c != null && this.d != null) {
                if (toyL.isConnected()) {
                    this.m.removeCallbacksAndMessages(null);
                    ControlModelToyStatusBean controlModelToyStatusBean = new ControlModelToyStatusBean();
                    ArrayList arrayList = new ArrayList();
                    this.b.setStatus(1);
                    arrayList.add(this.b);
                    controlModelToyStatusBean.toyInfoList = arrayList;
                    this.c.c4(this.b, this.d);
                    if (this.d.isTwoWay()) {
                        this.h.s0(toyL);
                    } else {
                        this.h.E(toyL);
                    }
                    x(controlModelToyStatusBean);
                } else {
                    this.m.postDelayed(new e(toyL), this.g);
                }
            }
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public void r() {
        this.e = false;
        this.b = null;
        this.d = null;
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public boolean s() {
        DisplayPannelIfoBean displayPannelIfoBean;
        return (!this.e || (displayPannelIfoBean = this.d) == null || displayPannelIfoBean.isTwoWay()) ? false : true;
    }

    @Override // dc.tz1
    public void stop(int i) {
    }

    public final void t(String str, String str2) {
        xe3.a(str, str2);
    }

    public boolean u(String str, String str2) {
        return false;
    }

    public final void v(boolean z) {
        try {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
            if (z) {
                Timer timer2 = new Timer();
                this.j = timer2;
                timer2.schedule(new a(), 0L, 3000L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void w(f fVar) {
        if (this.c == fVar) {
            this.c = null;
        }
    }

    public void x(pf2 pf2Var) {
        t(o, pf2Var.getAction() + " " + JSON.toJSONString(pf2Var));
        uf2.v().E(pf2Var);
    }

    public void y(f fVar) {
        this.c = fVar;
    }

    public final void z(boolean z) {
        f fVar;
        synchronized (p) {
            DisplayPannelIfoBean displayPannelIfoBean = this.d;
            if (displayPannelIfoBean != null && displayPannelIfoBean.isReady() && this.e && (fVar = this.c) != null) {
                fVar.b4(z);
            }
        }
    }
}
