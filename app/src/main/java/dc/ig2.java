package dc;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.spotify.sdk.android.player.Config;
import com.wear.bean.Toy;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.starAndvibrate.request.ExitTipperCtrlRequest;
import com.wear.bean.socketio.starAndvibrate.request.JoinTipperCtrlRequest;
import com.wear.bean.socketio.starAndvibrate.response.JoinTipperCtrlResponse;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlChangeStatusRespone;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlCommandRespone;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlExitGameRespone;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlScanResponse;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlUpdateInfoRespone;
import com.wear.main.starAndvibrate.ui.TipperCtrlAppActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: TipperCtrlAppControl.java */
/* loaded from: classes3.dex */
public class ig2 implements tz1, tf2 {
    public static final String l = "ig2";
    public static volatile ig2 m;
    public TipperCtrlScanResponse f;
    public Timer j;
    public Handler a = new Handler(Looper.getMainLooper());
    public Handler b = new Handler(Looper.getMainLooper());
    public final Set<eg2> c = new CopyOnWriteArraySet();
    public boolean d = false;
    public ArrayList<Toy> e = new ArrayList<>();
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int k = 0;

    /* compiled from: TipperCtrlAppControl.java */
    public class a implements zn2<BaseResponseBeanNew<TipperCtrlScanResponse>> {
        public final /* synthetic */ yc2 a;

        public a(yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<TipperCtrlScanResponse> baseResponseBeanNew) {
            this.a.S3();
            ig2.this.S(baseResponseBeanNew.data, this.a);
        }

        @Override // dc.zn2
        public void onError(NetException netException) throws NumberFormatException {
            this.a.S3();
            this.a.a2();
            try {
                ig2.this.K(Integer.parseInt(netException.getCode()), netException.getMessage());
            } catch (NumberFormatException unused) {
                ig2.this.K(999999, netException.getMessage());
            }
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class b implements is3.c {
        public final /* synthetic */ yc2 a;

        public b(ig2 ig2Var, yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.is3.c
        public void doCancel() {
            this.a.a2();
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class c implements is3.d {
        public final /* synthetic */ yc2 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ TipperCtrlScanResponse c;

        /* compiled from: TipperCtrlAppControl.java */
        public class a implements mf2 {
            public a() {
            }

            @Override // dc.mf2
            public void Q(String str) {
                String unused = ig2.l;
                String str2 = "SocketIoClient___createPacketCollectorAndSend____suc: " + str;
                c.this.a.S3();
                c cVar = c.this;
                ig2.this.R(str, cVar.a, cVar.c);
            }

            @Override // dc.mf2
            public void a(Throwable th) {
                String unused = ig2.l;
                if (("SocketIoClient___createPacketCollectorAndSend____fail: " + th) != null) {
                    th.getMessage();
                }
                c.this.a.S3();
                c.this.a.a2();
                sg3.h(R.string.notification_takecontrol_checknetwork);
            }
        }

        public c(yc2 yc2Var, Activity activity, TipperCtrlScanResponse tipperCtrlScanResponse) {
            this.a = yc2Var;
            this.b = activity;
            this.c = tipperCtrlScanResponse;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (!this.a.x2(this.b.getString(R.string.lan_api_connect_toy_first))) {
                this.a.a2();
                return;
            }
            this.a.e0();
            ig2.this.j(ig2.this.s(this.c), new a());
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class d implements Runnable {
        public final /* synthetic */ TipperCtrlExitGameRespone a;

        public d(TipperCtrlExitGameRespone tipperCtrlExitGameRespone) {
            this.a = tipperCtrlExitGameRespone;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = ig2.this.c.iterator();
            while (it.hasNext()) {
                ((eg2) it.next()).e2(this.a.getType().intValue());
            }
            if (ig2.this.i()) {
                ig2.this.k(false);
            }
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class e extends TimerTask {
        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ig2.this.i()) {
                ig2.this.r();
            }
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class f implements mf2 {
        public f() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            JoinTipperCtrlResponse joinTipperCtrlResponse = (JoinTipperCtrlResponse) JSON.parseObject(str, JoinTipperCtrlResponse.class);
            if (joinTipperCtrlResponse == null || joinTipperCtrlResponse.getCode() != 0) {
                ig2.this.l(true);
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = ig2.this.c.iterator();
            while (it.hasNext()) {
                ((eg2) it.next()).D(true);
            }
        }
    }

    /* compiled from: TipperCtrlAppControl.java */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = ig2.this.c.iterator();
            while (it.hasNext()) {
                ((eg2) it.next()).D(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        String str = "delayHandler____postDelayed__controlIng: " + i();
        if (i()) {
            sz1.d().o();
            l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D() {
        Iterator<eg2> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().B(this.k);
        }
    }

    public static ig2 n() {
        if (m == null) {
            synchronized (ig2.class) {
                if (m == null) {
                    m = new ig2();
                }
            }
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        Iterator<eg2> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(TipperCtrlChangeStatusRespone tipperCtrlChangeStatusRespone) {
        Iterator<eg2> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().R0(tipperCtrlChangeStatusRespone);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        Iterator<eg2> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    public void E(ArrayList<Toy> arrayList) {
        this.e.clear();
        if (arrayList != null) {
            this.e.addAll(arrayList);
        }
    }

    public final void F() {
        sz1.d().n(this);
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    public void G(eg2 eg2Var) {
        this.c.remove(eg2Var);
    }

    public final void H(TipperCtrlChangeStatusRespone tipperCtrlChangeStatusRespone) {
        TipperCtrlScanResponse tipperCtrlScanResponseO = o();
        this.f = tipperCtrlScanResponseO;
        tipperCtrlScanResponseO.setModelEmail(tipperCtrlChangeStatusRespone.getModelEmail());
        this.f.setModelName(tipperCtrlChangeStatusRespone.getModelName());
        this.f.setPf(tipperCtrlChangeStatusRespone.getPf());
    }

    public final void I(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public boolean J(pf2 pf2Var) {
        return uf2.v().E(pf2Var);
    }

    public final void K(int i, String str) {
        if (i == 70091) {
            sg3.h(R.string.notification_takecontrol_not_start);
            return;
        }
        if (i == 70090) {
            sg3.h(R.string.takecontrol_disable);
            return;
        }
        if (i == 70092) {
            sg3.h(R.string.invalid_unique_code);
            return;
        }
        if (i == 70093) {
            sg3.h(R.string.invalid_qr_code);
            return;
        }
        if (i == 70094) {
            sg3.h(R.string.not_found_model);
            return;
        }
        if (!TextUtils.isEmpty(str) && i != 99999) {
            sg3.l(str);
            return;
        }
        sg3.l(WearUtils.x.getString(R.string.notification_takecontrol_checknetwork) + i);
    }

    public void L(String str) {
        String str2 = "takcon_ack_app_exit_game_tc__socketio__: " + str;
    }

    public void M(String str) {
        String str2 = "takcon_ack_scan_join_game_tc__socketio__: " + str;
    }

    public void N(final TipperCtrlChangeStatusRespone tipperCtrlChangeStatusRespone) {
        StringBuilder sb = new StringBuilder();
        sb.append("takcon_change_game_status_tc__socketio__: ");
        sb.append(tipperCtrlChangeStatusRespone != null ? WearUtils.A.toJson(tipperCtrlChangeStatusRespone) : null);
        sb.toString();
        if (tipperCtrlChangeStatusRespone == null || TextUtils.isEmpty(tipperCtrlChangeStatusRespone.getModelEmail())) {
            return;
        }
        H(tipperCtrlChangeStatusRespone);
        t(tipperCtrlChangeStatusRespone.getExcessTime());
        I(new Runnable() { // from class: dc.yf2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x(tipperCtrlChangeStatusRespone);
            }
        });
    }

    public void O(TipperCtrlExitGameRespone tipperCtrlExitGameRespone) {
        StringBuilder sb = new StringBuilder();
        sb.append("takcon_exit_game_tc__socketio__: ");
        sb.append(tipperCtrlExitGameRespone != null ? WearUtils.A.toJson(tipperCtrlExitGameRespone) : null);
        sb.toString();
        if (tipperCtrlExitGameRespone == null || tipperCtrlExitGameRespone.getType().intValue() == 0) {
            return;
        }
        I(new d(tipperCtrlExitGameRespone));
    }

    public void P(TipperCtrlCommandRespone tipperCtrlCommandRespone) {
        StringBuilder sb = new StringBuilder();
        sb.append("takcon_toy_command_tc__socketio__: ");
        sb.append(tipperCtrlCommandRespone != null ? WearUtils.A.toJson(tipperCtrlCommandRespone) : null);
        sb.toString();
        if (tipperCtrlCommandRespone == null || tipperCtrlCommandRespone.getModelEmail() == null || !tipperCtrlCommandRespone.getModelEmail().equals(this.f.getModelEmail()) || tipperCtrlCommandRespone.getData() == null) {
            return;
        }
        Y(tipperCtrlCommandRespone.getData().getV(), tipperCtrlCommandRespone.getData().getR(), tipperCtrlCommandRespone.getData().getP());
    }

    public void Q(TipperCtrlUpdateInfoRespone tipperCtrlUpdateInfoRespone) {
        StringBuilder sb = new StringBuilder();
        sb.append("takcon_update_game_info_tc__socketio__: ");
        sb.append(tipperCtrlUpdateInfoRespone != null ? WearUtils.A.toJson(tipperCtrlUpdateInfoRespone) : null);
        sb.toString();
        if (tipperCtrlUpdateInfoRespone == null || !TextUtils.equals(this.f.getModelEmail(), tipperCtrlUpdateInfoRespone.getModelEmail())) {
            return;
        }
        t(tipperCtrlUpdateInfoRespone.getExcessTime());
    }

    public final void R(String str, yc2 yc2Var, TipperCtrlScanResponse tipperCtrlScanResponse) {
        JoinTipperCtrlResponse joinTipperCtrlResponse = (JoinTipperCtrlResponse) JSON.parseObject(str, JoinTipperCtrlResponse.class);
        if (joinTipperCtrlResponse == null || joinTipperCtrlResponse.getCode() != 0) {
            K(joinTipperCtrlResponse == null ? 99999 : joinTipperCtrlResponse.getCode(), joinTipperCtrlResponse.getMessage());
            yc2Var.a2();
            return;
        }
        F();
        if (sz1.d().q(256)) {
            this.d = true;
            this.f = tipperCtrlScanResponse;
            this.k = 0;
            E(pc1.a.p());
            W();
            pj3.f(MyApplication.H(), TipperCtrlAppActivity.class);
            if (joinTipperCtrlResponse.getData() != null) {
                t(joinTipperCtrlResponse.getData().getExcessTime());
            }
            yc2Var.f1();
        }
    }

    public final void S(TipperCtrlScanResponse tipperCtrlScanResponse, yc2 yc2Var) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        is3.b bVar = new is3.b(fragmentActivityH);
        StringBuilder sb = new StringBuilder();
        sb.append("startJoinDialog__socketio__: ");
        sb.append(tipperCtrlScanResponse != null ? WearUtils.A.toJson(tipperCtrlScanResponse) : null);
        sb.toString();
        bVar.p(String.format(fragmentActivityH.getString(R.string.takecontrol_qrconfirm), tipperCtrlScanResponse.getModelName()));
        bVar.d(new c(yc2Var, fragmentActivityH, tipperCtrlScanResponse));
        bVar.n(fragmentActivityH.getString(R.string.common_cancel));
        bVar.o(fragmentActivityH.getString(R.string.common_confirm));
        bVar.c(new b(this, yc2Var));
        cs3.h(bVar).show();
    }

    public final void T() {
        this.b.removeCallbacksAndMessages(null);
        Timer timer = this.j;
        if (timer != null) {
            timer.cancel();
            this.j = null;
        }
        Timer timer2 = new Timer();
        this.j = timer2;
        timer2.schedule(new e(), 1000L, 1000L);
        I(new Runnable() { // from class: dc.bg2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z();
            }
        });
    }

    public final void U() {
        Timer timer = this.j;
        if (timer != null) {
            timer.cancel();
            this.j = null;
        }
    }

    public final void V() {
        sz1.d().s(this);
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        this.f = null;
        this.k = 0;
    }

    public final void W() {
        if (i()) {
            this.b.removeCallbacksAndMessages(null);
            this.b.postDelayed(new Runnable() { // from class: dc.xf2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.B();
                }
            }, 30000L);
        }
    }

    public final void X() {
        I(new Runnable() { // from class: dc.ag2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D();
            }
        });
    }

    public final void Y(int i, int i2, int i3) {
        if (i != -1) {
            this.g = i;
        }
        if (i2 != -1) {
            this.h = i2;
        }
        if (i3 != -1) {
            this.i = i3;
        }
        vq1.b(i, i2, i3);
    }

    @Override // dc.tf2
    public void connectSuc() {
        if (i() && this.f != null) {
            JoinTipperCtrlRequest joinTipperCtrlRequest = new JoinTipperCtrlRequest();
            joinTipperCtrlRequest.setModelEmail(this.f.getModelEmail());
            joinTipperCtrlRequest.setAckId(WearUtils.E());
            j(joinTipperCtrlRequest, new f());
        }
        I(new g());
    }

    @Override // dc.tf2
    public void disConnect() {
        if (!i() || this.f == null) {
            return;
        }
        I(new h());
    }

    @Override // dc.tz1
    public int getPriority() {
        return 256;
    }

    public void h(eg2 eg2Var) {
        this.c.add(eg2Var);
    }

    public boolean i() {
        return this.d;
    }

    public void j(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().s(rf2Var, mf2Var, 25L);
    }

    public void k(boolean z) {
        U();
        this.a.removeCallbacksAndMessages(null);
        this.d = false;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        pc1 pc1Var = pc1.a;
        pc1Var.I();
        pc1Var.u0();
        pc1Var.B();
        sz1.d().b(256);
        V();
        if (z) {
            m();
        }
    }

    public void l(boolean z) {
        if (i()) {
            J(new ExitTipperCtrlRequest());
            k(z);
        } else if (z) {
            m();
        }
    }

    public final void m() {
        I(new Runnable() { // from class: dc.zf2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v();
            }
        });
    }

    public TipperCtrlScanResponse o() {
        TipperCtrlScanResponse tipperCtrlScanResponse = this.f;
        return tipperCtrlScanResponse == null ? new TipperCtrlScanResponse() : tipperCtrlScanResponse;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (i()) {
            Iterator<eg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
            Y(this.g, this.h, this.i);
        }
    }

    public ArrayList<Toy> p() {
        return this.e;
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public void q(String str, yc2 yc2Var) {
        if (TextUtils.isEmpty(str) || yc2Var == null) {
            return;
        }
        yc2Var.e0();
        HashMap map = new HashMap();
        map.put("qrData", str);
        String str2 = "handlerScanData__socketio__: " + WearUtils.A.toJson(map);
        tn2.x(WearUtils.x).k("/api/takecontrol/scanQrCode", map, new a(yc2Var));
    }

    public final void r() {
        if (this.f == null) {
            return;
        }
        int i = this.k;
        if (i > 0) {
            this.k = i - 1;
            X();
        }
        if (this.k == 0) {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
            W();
        }
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public final JoinTipperCtrlRequest s(TipperCtrlScanResponse tipperCtrlScanResponse) {
        String str;
        JoinTipperCtrlRequest joinTipperCtrlRequest = new JoinTipperCtrlRequest();
        joinTipperCtrlRequest.setModelEmail(tipperCtrlScanResponse.getModelEmail());
        joinTipperCtrlRequest.setPf(tipperCtrlScanResponse.getPf());
        joinTipperCtrlRequest.setModelName(tipperCtrlScanResponse.getModelName());
        joinTipperCtrlRequest.setCustomerName(tipperCtrlScanResponse.getCustomerName());
        joinTipperCtrlRequest.setAckId(WearUtils.E());
        ArrayList<Toy> arrayListP = pc1.a.P();
        joinTipperCtrlRequest.setToyNum(arrayListP.size());
        HashSet hashSet = new HashSet();
        Iterator<Toy> it = arrayListP.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            int iTypeInt = next.typeInt();
            StringBuilder sb = new StringBuilder();
            sb.append(next.getType());
            if (iTypeInt > 1) {
                str = Config.IN_FIELD_SEPARATOR + iTypeInt;
            } else {
                str = "";
            }
            sb.append(str);
            hashSet.add(sb.toString());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add((String) it2.next());
        }
        joinTipperCtrlRequest.setToyTypes(arrayList);
        return joinTipperCtrlRequest;
    }

    @Override // dc.tz1
    public void stop(int i) {
        if (i()) {
            l(true);
        }
    }

    public final void t(int i) {
        String str = "initTime___curCountDownTime: " + this.k + ", excessTime: " + i;
        if (i()) {
            if (this.k == 0 && i > 0) {
                T();
            }
            this.k = i;
            X();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        if (i()) {
            Iterator<eg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i30 i30Var) {
        if (i()) {
            Iterator<eg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }
}
