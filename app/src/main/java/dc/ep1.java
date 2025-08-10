package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.data.ChatGPTConfigData;
import com.wear.bean.event.GiftCardEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.controllink.ControlLinkNewActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.me3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* compiled from: LoginManagerImpl.java */
/* loaded from: classes3.dex */
public class ep1 implements bu3 {
    public static ep1 h;
    public hu3 a;
    public Context b;
    public HandlerThread d;
    public int f;
    public b g;
    public Handler c = new Handler(Looper.getMainLooper());
    public LinkedHashMap<Object, List<gp1>> e = new LinkedHashMap<>();

    /* compiled from: LoginManagerImpl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mu3.c = 0;
            hu3.z(ep1.this.b).w(true);
        }
    }

    /* compiled from: LoginManagerImpl.java */
    public interface b {
        void r(int i);
    }

    public ep1() {
        HandlerThread handlerThread = new HandlerThread(FirebaseAnalytics.Event.LOGIN);
        this.d = handlerThread;
        handlerThread.start();
        hu3 hu3VarZ = hu3.z(WearUtils.x);
        this.a = hu3VarZ;
        hu3VarZ.l(this);
        this.b = WearUtils.x;
    }

    public static ep1 b() {
        if (h == null) {
            synchronized (ep1.class) {
                if (h == null) {
                    h = new ep1();
                }
            }
        }
        return h;
    }

    public static /* synthetic */ void d() {
        b().e("主动退出");
        hu3.z(WearUtils.x).w(true);
        b().e("主动退出完毕");
        synchronized (ch3.h) {
            ch3.j.clear();
        }
        if (MusicControl.h0().e != null) {
            MusicControl.h0().e.G();
        }
        WearUtils.y.V(null);
        me3.h(ye3.x());
    }

    @Override // dc.bu3
    public void I1(String str) {
        synchronized (this.e) {
            f("LoginManagerImpl", "开始执行任务");
            int size = 0;
            Iterator<Object> it = this.e.keySet().iterator();
            while (it.hasNext()) {
                List<gp1> list = this.e.get(it.next());
                if (list != null) {
                    size += list.size();
                }
                for (gp1 gp1Var : list) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        gp1Var.run();
                    } else {
                        this.c.post(gp1Var);
                    }
                }
            }
            this.e.clear();
            f("LoginManagerImpl", "任务个数总数：" + size);
        }
    }

    public void a(boolean z) {
        MyApplication.O = false;
        MyApplication.Z = true;
        db2.A().K();
        hu3.R(WearUtils.x);
        WearUtils.x.C0();
        OrgySetting.getInstance().loginOutRemoveData();
        EventBus.getDefault().post(ManagerRDBean.getManager());
        vg3.b().a(new Runnable() { // from class: dc.dp1
            @Override // java.lang.Runnable
            public final void run() {
                ep1.d();
            }
        });
        eg3.m(WearUtils.x, "xmpp_password");
        uf2.v().t();
        db2.A().i = false;
        na2.m().v();
        xe2.L0().v();
        xe2.L0().B();
        hg2.m().k();
        fg2.j().i();
        ig2.n().l(true);
        pb2.m().k();
        uf2.v().t();
        ch3.n().f();
        df3.e().j();
        zt3.k = "";
        vu1.e();
        ff2.d = false;
        ff2.f = false;
        ff2.e = false;
        ff2.n().C();
        ScanQRDataBean scanQRDataBean = MyApplication.G;
        if (scanQRDataBean != null) {
            scanQRDataBean.onCancelReportToService();
        }
        MyApplication.G = null;
        h32.i().D();
        WearUtils.j();
        yf3.i.a().r();
        WearUtils.x.j = -1;
        synchronized (this.e) {
            this.e.clear();
        }
        EventBus.getDefault().post(new LoginOrOfflineEvent(false));
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (!z || fragmentActivityH == null) {
            return;
        }
        fragmentActivityH.finish();
    }

    public int c() {
        return this.f;
    }

    public void e(String str) {
        f("LoginManagerImpl", str);
    }

    public final void f(String str, String str2) {
        xe3.a(str, str2);
    }

    public void g() {
        na2.m().v();
        ob2.o().J();
        if (kd2.r) {
            j(null, 5);
        } else {
            j(null, 0);
        }
    }

    public void h(int i) {
        na2.m().v();
        ob2.o().J();
        j(null, i);
    }

    public void i(Activity activity) {
        na2.m().v();
        ob2.o().J();
        j(activity, 0);
    }

    public final void j(Activity activity, int i) {
        if (MusicControl.h0().O()) {
            MusicControl.h0().S();
        }
        eg3.m(WearUtils.x, "chatGPTConfig");
        EventBus.getDefault().post(new ChatGPTConfigData(false));
        if (MyApplication.H() != null && (MyApplication.H() instanceof ControlLinkNewActivity)) {
            MyApplication.H().finish();
        }
        y12.c.a().t();
        if (c83.R1().r()) {
            c83.R1().I1();
        }
        DaoUtils.getGiftCardDao().clear();
        EventBus.getDefault().post(new GiftCardEvent(0));
        if (PlayService.R) {
            EventBus.getDefault().post(new NotificationCloseEvent());
        }
        WearUtils.x.i.d();
        ye3.d("A0009", "");
        ye3.c("log out", "into page", null);
        a(false);
        me3.c(me3.c.LOGOUT_SUCCESS);
        if (i == 1) {
            return;
        }
        if (i == 5) {
            kd2.C().B(0);
            return;
        }
        if (activity != null) {
            activity.finish();
            return;
        }
        Intent intent = new Intent(WearUtils.x, (Class<?>) LoginActivity.class);
        pj3.d(intent);
        intent.addFlags(268468224);
        WearUtils.x.startActivity(intent);
    }

    public final void k(Object obj, gp1 gp1Var) {
        synchronized (this.e) {
            if (obj == null) {
                return;
            }
            f("LoginManagerImpl", "添加1个任务");
            List<gp1> arrayList = this.e.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.e.put(obj, arrayList);
            }
            if (arrayList.contains(gp1Var)) {
                return;
            }
            arrayList.add(gp1Var);
        }
    }

    public void l() {
        na2.m().v();
        xe2.L0().v();
        xe2.L0().B();
        hg2.m().k();
        fg2.j().i();
        ig2.n().l(true);
        pb2.m().k();
        uf2.v().t();
        ch3.n().f();
        df3.e().j();
        vg3.b().a(new a());
        zt3.k = "";
        ff2.d = false;
        ff2.f = false;
        ff2.e = false;
        ff2.n().C();
        ScanQRDataBean scanQRDataBean = MyApplication.G;
        if (scanQRDataBean != null) {
            scanQRDataBean.onCancelReportToService();
        }
        MyApplication.G = null;
        WearUtils.j();
        EventBus.getDefault().post(new LanApiControlEvent(false));
        synchronized (this.e) {
            this.e.clear();
        }
    }

    @Override // dc.bu3
    public void l3(String str) {
        synchronized (this.e) {
            f("LoginManagerImpl", "登录失败");
            this.e.clear();
        }
    }

    public void m(Object obj) {
        synchronized (this.e) {
            if (obj == null) {
                return;
            }
            List<gp1> listRemove = this.e.remove(obj);
            if (listRemove != null) {
                f("LoginManagerImpl", "移除多个任务：" + listRemove.size());
            }
        }
    }

    public void n(int i) {
        this.f = i;
        b bVar = this.g;
        if (bVar != null) {
            bVar.r(i);
        }
    }

    public void o(b bVar) {
        this.g = bVar;
    }

    public boolean p() {
        return hu3.z(this.b).l0();
    }

    public boolean q(gp1 gp1Var) {
        return r(this, gp1Var);
    }

    public boolean r(Object obj, gp1 gp1Var) {
        if (obj == null) {
            obj = this;
        }
        k(obj, gp1Var);
        if (!p()) {
            return false;
        }
        f("LoginManagerImpl", "正在登录");
        return true;
    }

    @Override // dc.bu3
    public void u1(String str) {
        synchronized (this.e) {
            f("LoginManagerImpl", "连接失败");
            Iterator<Map.Entry<Object, List<gp1>>> it = this.e.entrySet().iterator();
            while (it.hasNext()) {
                List<gp1> value = it.next().getValue();
                ArrayList arrayList = new ArrayList();
                for (gp1 gp1Var : value) {
                    if (!gp1Var.a()) {
                        arrayList.add(gp1Var);
                        ip1 ip1Var = gp1Var.c;
                        if (ip1Var != null) {
                            ip1Var.G();
                        }
                    }
                }
                value.removeAll(arrayList);
                if (value.size() == 0) {
                    it.remove();
                }
            }
        }
    }
}
