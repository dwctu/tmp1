package dc;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.ScanStarCampaignQrCodeResponse;
import com.wear.bean.socketio.starAndvibrate.request.ExitSyncVibeActivityTsRequest;
import com.wear.bean.socketio.starAndvibrate.request.JoinSyncVibeActivityTsRequest;
import com.wear.bean.socketio.starAndvibrate.request.ScanSyncVibeActivityTsRequest;
import com.wear.bean.socketio.starAndvibrate.response.EndSyncVibeActivityTcResponse;
import com.wear.bean.socketio.starAndvibrate.response.SyncVibeActivityInfoTcResponse;
import com.wear.bean.socketio.starAndvibrate.response.SyncVibeCommandTcResponse;
import com.wear.main.starAndvibrate.ui.StarControlActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: StarControl.java */
/* loaded from: classes3.dex */
public class hg2 implements tz1, tf2 {
    public static hg2 l;
    public Timer g;
    public SyncVibeActivityInfoTcResponse h;
    public String i;
    public int j;
    public Dialog k;
    public Handler a = new Handler(Looper.getMainLooper());
    public Handler b = new Handler(Looper.getMainLooper());
    public final Set<dg2> c = new CopyOnWriteArraySet();
    public ArrayList<Toy> d = new ArrayList<>();
    public boolean f = false;
    public MyApplication e = WearUtils.x;

    /* compiled from: StarControl.java */
    public class a extends TimerTask {

        /* compiled from: StarControl.java */
        /* renamed from: dc.hg2$a$a, reason: collision with other inner class name */
        public class RunnableC0184a implements Runnable {
            public RunnableC0184a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (hg2.this.h()) {
                    hg2.this.p();
                }
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            hg2.this.u(new RunnableC0184a());
        }
    }

    /* compiled from: StarControl.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = hg2.this.c.iterator();
            while (it.hasNext()) {
                ((dg2) it.next()).b();
            }
        }
    }

    /* compiled from: StarControl.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (hg2.this.h()) {
                sz1.d().o();
                hg2.this.k();
            }
        }
    }

    /* compiled from: StarControl.java */
    public class d implements mf2 {
        public d() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse = (SyncVibeActivityInfoTcResponse) JSON.parseObject(str, SyncVibeActivityInfoTcResponse.class);
            if (syncVibeActivityInfoTcResponse == null || syncVibeActivityInfoTcResponse.getCode() != 0) {
                hg2.this.j();
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    /* compiled from: StarControl.java */
    public class e implements zn2<BaseResponseBeanNew<ScanStarCampaignQrCodeResponse>> {
        public final /* synthetic */ yc2 a;

        public e(yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<ScanStarCampaignQrCodeResponse> baseResponseBeanNew) {
            this.a.S3();
            hg2.this.r(baseResponseBeanNew.data.getSyncVibeActivityId(), this.a);
        }

        @Override // dc.zn2
        public void onError(NetException netException) throws NumberFormatException {
            this.a.S3();
            this.a.a2();
            try {
                hg2.this.x(Integer.parseInt(netException.getCode()), netException.getMessage(), this.a);
            } catch (NumberFormatException unused) {
                hg2.this.x(999999, netException.getMessage(), this.a);
            }
        }
    }

    /* compiled from: StarControl.java */
    public class f implements is3.c {
        public final /* synthetic */ yc2 a;

        public f(hg2 hg2Var, yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.is3.c
        public void doCancel() {
            this.a.a2();
        }
    }

    /* compiled from: StarControl.java */
    public class g implements is3.d {
        public final /* synthetic */ yc2 a;
        public final /* synthetic */ String b;

        /* compiled from: StarControl.java */
        public class a implements mf2 {
            public a() {
            }

            @Override // dc.mf2
            public void Q(String str) {
                g.this.a.S3();
                g gVar = g.this;
                hg2.this.C(str, gVar.a);
            }

            @Override // dc.mf2
            public void a(Throwable th) {
                g.this.a.S3();
                hg2.this.x(999999, new NetException(NetException.NET_CONNECT_ERROR, WearUtils.Y1()).getMessage(), g.this.a);
            }
        }

        public g(yc2 yc2Var, String str) {
            this.a = yc2Var;
            this.b = str;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (!this.a.x2(ah4.e(R.string.lush3_campaign_no_toy))) {
                this.a.a2();
                return;
            }
            this.a.e0();
            JoinSyncVibeActivityTsRequest joinSyncVibeActivityTsRequest = new JoinSyncVibeActivityTsRequest();
            joinSyncVibeActivityTsRequest.setId(this.b);
            joinSyncVibeActivityTsRequest.setAckId(WearUtils.E());
            joinSyncVibeActivityTsRequest.setJoinType(0);
            hg2.m().i(joinSyncVibeActivityTsRequest, new a());
        }
    }

    /* compiled from: StarControl.java */
    public class h implements is3.d {
        public final /* synthetic */ yc2 a;

        public h(hg2 hg2Var, yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            this.a.a2();
        }
    }

    public hg2() {
        sz1.d().n(this);
        EventBus.getDefault().register(this);
    }

    public static hg2 m() {
        if (l == null) {
            synchronized (hg2.class) {
                if (l == null) {
                    l = new hg2();
                }
            }
        }
        return l;
    }

    public void A(SyncVibeCommandTcResponse syncVibeCommandTcResponse) {
        if (syncVibeCommandTcResponse == null || !h() || syncVibeCommandTcResponse.getSyncVibeActivityId() == null || !syncVibeCommandTcResponse.getSyncVibeActivityId().equals(this.i)) {
            return;
        }
        int data = syncVibeCommandTcResponse.getData();
        this.j = data;
        if (data > 20) {
            this.j = 20;
        } else if (data < 0) {
            this.j = 0;
        }
        vq1.a(this.j);
    }

    public void B(SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse) {
        syncVibeActivityInfoTcResponse.setEndCountDown(syncVibeActivityInfoTcResponse.getEndCountDown() / 1000);
        syncVibeActivityInfoTcResponse.setBeginCountDown(syncVibeActivityInfoTcResponse.getBeginCountDown() / 1000);
        this.h = syncVibeActivityInfoTcResponse;
        this.i = syncVibeActivityInfoTcResponse.getId();
        this.b.removeCallbacksAndMessages(null);
        this.f = true;
        pc1.a.F();
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
        }
        Timer timer2 = new Timer();
        this.g = timer2;
        timer2.schedule(new a(), 1000L, 1000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(String str, yc2 yc2Var) {
        SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse = (SyncVibeActivityInfoTcResponse) JSON.parseObject(str, SyncVibeActivityInfoTcResponse.class);
        ArrayList<Toy> arrayListP = this.e.G().p();
        if (arrayListP.size() <= 0 || syncVibeActivityInfoTcResponse == null || syncVibeActivityInfoTcResponse.getCode() != 0) {
            if (arrayListP.size() == 0 || syncVibeActivityInfoTcResponse == null) {
                yc2Var.a2();
                return;
            } else {
                x(syncVibeActivityInfoTcResponse.getCode(), "", yc2Var);
                return;
            }
        }
        if (sz1.d().q(64)) {
            m().s(arrayListP);
            m().B(syncVibeActivityInfoTcResponse);
            pj3.f(yc2Var instanceof Activity ? (Activity) yc2Var : MyApplication.H(), StarControlActivity.class);
            yc2Var.f1();
        }
    }

    @Override // dc.tf2
    public void connectSuc() {
        if (h()) {
            JoinSyncVibeActivityTsRequest joinSyncVibeActivityTsRequest = new JoinSyncVibeActivityTsRequest();
            joinSyncVibeActivityTsRequest.setId(this.i);
            joinSyncVibeActivityTsRequest.setAckId(WearUtils.E());
            joinSyncVibeActivityTsRequest.setJoinType(1);
            i(joinSyncVibeActivityTsRequest, new d());
        }
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public void g(dg2 dg2Var) {
        this.c.add(dg2Var);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 64;
    }

    public boolean h() {
        return this.f;
    }

    public void i(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().r(rf2Var, mf2Var);
    }

    public void j() {
        this.a.removeCallbacksAndMessages(null);
        this.b.removeCallbacksAndMessages(null);
        this.f = false;
        pc1 pc1Var = pc1.a;
        pc1Var.I();
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
        }
        pc1Var.u0();
        sz1.d().b(64);
        u(new b());
    }

    public void k() {
        if (h()) {
            ExitSyncVibeActivityTsRequest exitSyncVibeActivityTsRequest = new ExitSyncVibeActivityTsRequest();
            exitSyncVibeActivityTsRequest.setId(this.i);
            v(exitSyncVibeActivityTsRequest);
            j();
        }
    }

    public SyncVibeActivityInfoTcResponse l() {
        return this.h;
    }

    public ArrayList<Toy> n() {
        return this.d;
    }

    public void o(String str, yc2 yc2Var) {
        if (TextUtils.isEmpty(str) || yc2Var == null || !yc2Var.x2(ah4.e(R.string.lush3_campaign_no_toy))) {
            return;
        }
        yc2Var.e0();
        HashMap map = new HashMap();
        map.put("qrData", str);
        tn2.x(WearUtils.x).k("/activity/api/market/scanStarCampaignQrCode", map, new e(yc2Var));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (h()) {
            Iterator<dg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
            vq1.a(this.j);
        }
    }

    public final void p() {
        SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse = this.h;
        if (syncVibeActivityInfoTcResponse == null) {
            return;
        }
        int beginCountDown = syncVibeActivityInfoTcResponse.getBeginCountDown() - 1;
        int endCountDown = this.h.getEndCountDown() - 1;
        if (beginCountDown == 0 && endCountDown > 0) {
            Iterator<dg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }
        if (beginCountDown > 0 || endCountDown > 0) {
            if (beginCountDown > 0) {
                this.h.setBeginCountDown(beginCountDown);
                Iterator<dg2> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    it2.next().B(beginCountDown);
                }
                return;
            }
            this.h.setEndCountDown(endCountDown);
            Iterator<dg2> it3 = this.c.iterator();
            while (it3.hasNext()) {
                it3.next().B(endCountDown);
            }
            return;
        }
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
            Iterator<dg2> it4 = this.c.iterator();
            while (it4.hasNext()) {
                it4.next().end();
            }
        }
        if (h()) {
            this.b.removeCallbacksAndMessages(null);
            this.b.postDelayed(new c(), 30000L);
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public boolean q() {
        SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse = this.h;
        return syncVibeActivityInfoTcResponse != null && syncVibeActivityInfoTcResponse.getBeginCountDown() <= 0;
    }

    public final void r(String str, yc2 yc2Var) {
        Dialog dialog = this.k;
        if (dialog != null && dialog.isShowing()) {
            this.k.dismiss();
        }
        is3.b bVar = new is3.b(MyApplication.H());
        bVar.p(ah4.e(R.string.lush3_campaign_join_notification));
        bVar.d(new g(yc2Var, str));
        bVar.n(ah4.e(R.string.button_not_now));
        bVar.o(ah4.e(R.string.common_join));
        bVar.c(new f(this, yc2Var));
        is3 is3VarH = cs3.h(bVar);
        this.k = is3VarH;
        is3VarH.show();
        ScanSyncVibeActivityTsRequest scanSyncVibeActivityTsRequest = new ScanSyncVibeActivityTsRequest();
        scanSyncVibeActivityTsRequest.setId(str);
        m().v(scanSyncVibeActivityTsRequest);
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s(ArrayList<Toy> arrayList) {
        this.d.clear();
        if (arrayList != null) {
            this.d.addAll(arrayList);
        }
    }

    @Override // dc.tz1
    public void stop(int i) {
        if (h()) {
            k();
        }
    }

    public void t(dg2 dg2Var) {
        this.c.remove(dg2Var);
    }

    public final void u(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public boolean v(pf2 pf2Var) {
        return uf2.v().E(pf2Var);
    }

    public final void w(String str, yc2 yc2Var) {
        is3.b bVar = new is3.b(MyApplication.H());
        bVar.p(str);
        bVar.k(R.layout.dialog_default_ok_new);
        bVar.d(new h(this, yc2Var));
        cs3.h(bVar).show();
    }

    public final void x(int i, String str, yc2 yc2Var) {
        if (i == 70080) {
            sg3.l(ah4.e(R.string.qr_code_expired));
            yc2Var.a2();
            return;
        }
        if (i == 70084) {
            sg3.l(ah4.e(R.string.connect_to_mirror_error) + i);
            yc2Var.a2();
            return;
        }
        if (i == 70085) {
            sg3.l(ah4.e(R.string.connect_to_mirror_error) + i);
            yc2Var.a2();
            return;
        }
        if (i == 70086) {
            w(ah4.e(R.string.lush3_campaign_is_over), yc2Var);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            sg3.l(str);
        }
        yc2Var.a2();
    }

    public void y(EndSyncVibeActivityTcResponse endSyncVibeActivityTcResponse) {
        SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse;
        if (endSyncVibeActivityTcResponse == null || !endSyncVibeActivityTcResponse.getId().equals(this.i) || !h() || (syncVibeActivityInfoTcResponse = this.h) == null) {
            return;
        }
        syncVibeActivityInfoTcResponse.setBeginCountDown(0);
        this.h.setEndCountDown(0);
    }

    public void z(SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse) {
        if (syncVibeActivityInfoTcResponse == null) {
            return;
        }
        if (syncVibeActivityInfoTcResponse.getCode() != 0 && syncVibeActivityInfoTcResponse.getId().equals(this.i) && h()) {
            j();
            return;
        }
        syncVibeActivityInfoTcResponse.setEndCountDown(syncVibeActivityInfoTcResponse.getEndCountDown() / 1000);
        syncVibeActivityInfoTcResponse.setBeginCountDown(syncVibeActivityInfoTcResponse.getBeginCountDown() / 1000);
        this.h = syncVibeActivityInfoTcResponse;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        if (h()) {
            Iterator<dg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i30 i30Var) {
        if (h()) {
            Iterator<dg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }
}
