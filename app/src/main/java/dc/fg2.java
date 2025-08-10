package dc;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.VibeWithMeBean;
import com.wear.bean.socketio.starAndvibrate.request.ExitVibrateWithMeRequest;
import com.wear.bean.socketio.starAndvibrate.request.JoinVibrateWithMeRequest;
import com.wear.bean.socketio.starAndvibrate.request.PingRemoteBroadcastRequest;
import com.wear.bean.socketio.starAndvibrate.response.ModelEndBroadcastEventResponse;
import com.wear.bean.socketio.starAndvibrate.response.ReportToyCommandDTOResponse;
import com.wear.bean.socketio.starAndvibrate.response.SyncVibeActivityInfoTcResponse;
import com.wear.main.starAndvibrate.ui.VibeWithMeControlActivity;
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

/* compiled from: RemoteVibrateControl.java */
/* loaded from: classes3.dex */
public class fg2 implements tz1, tf2 {
    public static fg2 l;
    public String d;
    public Timer g;
    public VibeWithMeBean k;
    public Handler b = new Handler(Looper.getMainLooper());
    public final Set<cg2> c = new CopyOnWriteArraySet();
    public boolean e = false;
    public ArrayList<Toy> f = new ArrayList<>();
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public MyApplication a = WearUtils.x;

    /* compiled from: RemoteVibrateControl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = fg2.this.c.iterator();
            while (it.hasNext()) {
                ((cg2) it.next()).D(false);
            }
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class b implements zn2<BaseResponseBeanNew<VibeWithMeBean>> {
        public final /* synthetic */ yc2 a;

        public b(yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<VibeWithMeBean> baseResponseBeanNew) {
            this.a.S3();
            fg2.this.v(baseResponseBeanNew.data, this.a);
        }

        @Override // dc.zn2
        public void onError(NetException netException) throws NumberFormatException {
            this.a.S3();
            this.a.a2();
            try {
                fg2.this.q(Integer.parseInt(netException.getCode()), netException.getMessage());
            } catch (NumberFormatException unused) {
                fg2.this.q(999999, netException.getMessage());
            }
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class c implements is3.c {
        public final /* synthetic */ yc2 a;

        public c(fg2 fg2Var, yc2 yc2Var) {
            this.a = yc2Var;
        }

        @Override // dc.is3.c
        public void doCancel() {
            this.a.a2();
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class d implements is3.d {
        public final /* synthetic */ yc2 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ VibeWithMeBean c;

        /* compiled from: RemoteVibrateControl.java */
        public class a implements mf2 {
            public a() {
            }

            @Override // dc.mf2
            public void Q(String str) {
                d.this.a.S3();
                d dVar = d.this;
                fg2.this.w(str, dVar.a, dVar.c);
            }

            @Override // dc.mf2
            public void a(Throwable th) {
                d.this.a.S3();
                d.this.a.a2();
                sg3.l(fg2.this.a.getString(R.string.vibe_network_error));
            }
        }

        public d(yc2 yc2Var, Activity activity, VibeWithMeBean vibeWithMeBean) {
            this.a = yc2Var;
            this.b = activity;
            this.c = vibeWithMeBean;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (!this.a.x2(this.b.getString(R.string.vibe_no_toy))) {
                this.a.a2();
                return;
            }
            fg2.this.m(pc1.a.p());
            this.a.e0();
            JoinVibrateWithMeRequest joinVibrateWithMeRequest = new JoinVibrateWithMeRequest();
            joinVibrateWithMeRequest.setModelId(this.c.getModelId());
            joinVibrateWithMeRequest.setPf(this.c.getPf());
            joinVibrateWithMeRequest.setModelName(this.c.getModelName());
            joinVibrateWithMeRequest.setcName(this.c.getcName());
            joinVibrateWithMeRequest.setAckId(WearUtils.E());
            fg2.this.g(joinVibrateWithMeRequest, new a());
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class e extends TimerTask {
        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            PingRemoteBroadcastRequest pingRemoteBroadcastRequest = new PingRemoteBroadcastRequest();
            pingRemoteBroadcastRequest.setModelId(fg2.this.d);
            fg2.this.p(pingRemoteBroadcastRequest);
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (fg2.this.f()) {
                fg2.this.h();
            }
            for (cg2 cg2Var : fg2.this.c) {
                cg2Var.end();
                cg2Var.b();
            }
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class g implements Runnable {
        public final /* synthetic */ VibeWithMeBean a;

        public g(VibeWithMeBean vibeWithMeBean) {
            this.a = vibeWithMeBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = fg2.this.c.iterator();
            while (it.hasNext()) {
                ((cg2) it.next()).w1(this.a);
            }
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = fg2.this.c.iterator();
            while (it.hasNext()) {
                ((cg2) it.next()).b();
            }
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class i implements mf2 {
        public i() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse = (SyncVibeActivityInfoTcResponse) JSON.parseObject(str, SyncVibeActivityInfoTcResponse.class);
            if (syncVibeActivityInfoTcResponse == null || syncVibeActivityInfoTcResponse.getCode() != 0) {
                fg2.this.i();
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    /* compiled from: RemoteVibrateControl.java */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = fg2.this.c.iterator();
            while (it.hasNext()) {
                ((cg2) it.next()).D(true);
            }
        }
    }

    public fg2() {
        sz1.d().n(this);
        EventBus.getDefault().register(this);
    }

    public static fg2 j() {
        if (l == null) {
            synchronized (fg2.class) {
                if (l == null) {
                    l = new fg2();
                }
            }
        }
        return l;
    }

    @Override // dc.tf2
    public void connectSuc() {
        if (f() && this.d != null) {
            JoinVibrateWithMeRequest joinVibrateWithMeRequest = new JoinVibrateWithMeRequest();
            joinVibrateWithMeRequest.setModelId(this.d);
            joinVibrateWithMeRequest.setAckId(WearUtils.E());
            g(joinVibrateWithMeRequest, new i());
        }
        o(new j());
    }

    @Override // dc.tf2
    public void disConnect() {
        if (!f() || this.d == null) {
            return;
        }
        o(new a());
    }

    public void e(cg2 cg2Var) {
        this.c.add(cg2Var);
    }

    public boolean f() {
        return this.e;
    }

    public void g(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().r(rf2Var, mf2Var);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 128;
    }

    public void h() {
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
        }
        this.b.removeCallbacksAndMessages(null);
        this.e = false;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        pc1.a.u0();
        sz1.d().b(128);
        o(new h());
    }

    public void i() {
        if (f()) {
            ExitVibrateWithMeRequest exitVibrateWithMeRequest = new ExitVibrateWithMeRequest();
            exitVibrateWithMeRequest.setModelId(this.d);
            p(exitVibrateWithMeRequest);
            h();
        }
    }

    public ArrayList<Toy> k() {
        return this.f;
    }

    public void l(String str, yc2 yc2Var) {
        if (TextUtils.isEmpty(str) || yc2Var == null || !yc2Var.x2(this.a.getString(R.string.vibe_no_toy))) {
            return;
        }
        yc2Var.e0();
        HashMap map = new HashMap();
        map.put("qrData", str);
        tn2.x(WearUtils.x).k("/api/vibrate/scanQrCode", map, new b(yc2Var));
    }

    public void m(ArrayList<Toy> arrayList) {
        this.f.clear();
        if (arrayList != null) {
            this.f.addAll(arrayList);
        }
    }

    public void n(cg2 cg2Var) {
        this.c.remove(cg2Var);
    }

    public final void o(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.b.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (f()) {
            Iterator<cg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
            x(this.h, this.i, this.j);
        }
    }

    public boolean p(pf2 pf2Var) {
        return uf2.v().E(pf2Var);
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    public final void q(int i2, String str) {
        if (i2 == 70091) {
            sg3.h(R.string.vibe_not_start);
            return;
        }
        if (i2 == 70090) {
            sg3.h(R.string.vibe_disable);
            return;
        }
        if (i2 == 70092) {
            sg3.h(R.string.invalid_unique_code);
            return;
        }
        if (i2 == 70093) {
            sg3.h(R.string.invalid_qr_code);
            return;
        }
        if (i2 == 70094) {
            sg3.h(R.string.not_found_model);
            return;
        }
        if (!TextUtils.isEmpty(str) && i2 != 99999) {
            sg3.l(str);
            return;
        }
        sg3.l(this.a.getString(R.string.vibe_network_error) + i2);
    }

    public void r(String str) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s(VibeWithMeBean vibeWithMeBean) {
        if (vibeWithMeBean == null) {
            return;
        }
        this.k = vibeWithMeBean;
        this.d = vibeWithMeBean.getModelId();
        vibeWithMeBean.getModelName();
        o(new g(vibeWithMeBean));
    }

    @Override // dc.tz1
    public void stop(int i2) {
        if (f()) {
            i();
        }
    }

    public void t(ModelEndBroadcastEventResponse modelEndBroadcastEventResponse) {
        if (modelEndBroadcastEventResponse == null || modelEndBroadcastEventResponse.getModelId() == null || !modelEndBroadcastEventResponse.getModelId().equals(this.d)) {
            return;
        }
        o(new f());
    }

    public void u(ReportToyCommandDTOResponse reportToyCommandDTOResponse) {
        if (reportToyCommandDTOResponse == null || reportToyCommandDTOResponse.getModelId() == null || !reportToyCommandDTOResponse.getModelId().equals(this.d) || reportToyCommandDTOResponse.getData() == null) {
            return;
        }
        x(reportToyCommandDTOResponse.getData().getV(), reportToyCommandDTOResponse.getData().getR(), reportToyCommandDTOResponse.getData().getP());
    }

    public final void v(VibeWithMeBean vibeWithMeBean, yc2 yc2Var) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.p(fragmentActivityH.getString(R.string.vibe_join_notification));
        bVar.d(new d(yc2Var, fragmentActivityH, vibeWithMeBean));
        bVar.n(fragmentActivityH.getString(R.string.button_not_now));
        bVar.o(fragmentActivityH.getString(R.string.common_join));
        bVar.c(new c(this, yc2Var));
        cs3.h(bVar).show();
    }

    public final void w(String str, yc2 yc2Var, VibeWithMeBean vibeWithMeBean) {
        SyncVibeActivityInfoTcResponse syncVibeActivityInfoTcResponse = (SyncVibeActivityInfoTcResponse) JSON.parseObject(str, SyncVibeActivityInfoTcResponse.class);
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (syncVibeActivityInfoTcResponse == null || syncVibeActivityInfoTcResponse.getCode() != 0) {
            q(syncVibeActivityInfoTcResponse == null ? 99999 : syncVibeActivityInfoTcResponse.getCode(), null);
            return;
        }
        if (sz1.d().q(128)) {
            this.e = true;
            this.d = vibeWithMeBean.getModelId();
            vibeWithMeBean.getModelName();
            pc1.a.F();
            pj3.f(fragmentActivityH, VibeWithMeControlActivity.class);
            yc2Var.f1();
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.g = timer2;
            timer2.scheduleAtFixedRate(new e(), 10000L, 30000L);
            s(vibeWithMeBean);
        }
    }

    public final void x(int i2, int i3, int i4) {
        if (i2 != -1) {
            this.h = i2;
        }
        if (i3 != -1) {
            this.i = i3;
        }
        if (i4 != -1) {
            this.j = i4;
        }
        vq1.b(i2, i3, i4);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        if (f()) {
            Iterator<cg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i30 i30Var) {
        if (f()) {
            Iterator<cg2> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }
}
