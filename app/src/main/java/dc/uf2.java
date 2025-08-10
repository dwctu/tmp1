package dc;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.activity.orgySetting.OrgyControl;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.bean.socketio.msg.BaseSocketIoRec;
import com.wear.bean.socketio.msg.MsgRecReceipt;
import com.wear.bean.socketio.msg.response.SocketIoBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kw3;
import dc.pw3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SocketIoClient.java */
/* loaded from: classes3.dex */
public class uf2 implements qf2, qw3 {
    public static final String i = "uf2";
    public static final Collection<ac2> j = new ConcurrentLinkedQueue();
    public String a;
    public NtokenResponseBean b;
    public volatile nw3 c;
    public Object d;
    public boolean e;
    public Set<tf2> f;
    public Disposable g;
    public int h;

    /* compiled from: SocketIoClient.java */
    public class a implements Consumer<Long> {
        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            String str = uf2.i;
            xe3.a(str, "setSocketIoConnectTimer");
            if (uf2.this.e) {
                return;
            }
            if (uf2.this.h > 5) {
                xe3.a(str, "refresh nToken count > 5");
                uf2.this.u();
            } else {
                xe3.a(str, "refresh nToken");
                EventBus.getDefault().post(new bx3());
                uf2.k(uf2.this);
            }
        }
    }

    /* compiled from: SocketIoClient.java */
    public class b implements Observer<String> {
        public final /* synthetic */ mf2 a;

        public b(uf2 uf2Var, mf2 mf2Var) {
            this.a = mf2Var;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(String str) {
            try {
                mf2 mf2Var = this.a;
                if (mf2Var != null) {
                    mf2Var.Q(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                mf2 mf2Var = this.a;
                if (mf2Var != null) {
                    mf2Var.a(th);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    /* compiled from: SocketIoClient.java */
    public class c implements ObservableOnSubscribe<String> {
        public final /* synthetic */ rf2 a;

        public c(rf2 rf2Var) {
            this.a = rf2Var;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            if (!uf2.this.E(this.a)) {
                throw new ConnectException();
            }
            Collection<ac2> collection = uf2.j;
            ac2 ac2Var = new ac2(collection, this.a.getBeanAckId());
            collection.add(ac2Var);
            observableEmitter.onNext(ac2Var.b(10000L));
        }
    }

    /* compiled from: SocketIoClient.java */
    public class d implements Observer<String> {
        public final /* synthetic */ mf2 a;

        public d(uf2 uf2Var, mf2 mf2Var) {
            this.a = mf2Var;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(String str) {
            try {
                mf2 mf2Var = this.a;
                if (mf2Var != null) {
                    mf2Var.Q(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                mf2 mf2Var = this.a;
                if (mf2Var != null) {
                    mf2Var.a(th);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    /* compiled from: SocketIoClient.java */
    public class e implements ObservableOnSubscribe<String> {
        public final /* synthetic */ rf2 a;
        public final /* synthetic */ long b;

        public e(rf2 rf2Var, long j) {
            this.a = rf2Var;
            this.b = j;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            if (!uf2.this.E(this.a)) {
                throw new ConnectException();
            }
            Collection<ac2> collection = uf2.j;
            ac2 ac2Var = new ac2(collection, this.a.getBeanAckId());
            collection.add(ac2Var);
            observableEmitter.onNext(ac2Var.b(this.b * 1000));
        }
    }

    /* compiled from: SocketIoClient.java */
    public class f extends nf2 {
        public f() {
        }

        @Override // dc.of2
        public void a(String str) {
            xe3.b(uf2.i, f.class.getSimpleName(), "连上啦");
            ye3.d("E0011", uf2.this.a);
            hu3.r0();
            uf2.this.z();
            uf2.this.h = 0;
            uf2.this.G();
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ f(uf2 uf2Var, a aVar) {
            this();
        }
    }

    /* compiled from: SocketIoClient.java */
    public class g extends nf2 {
        public g() {
        }

        @Override // dc.of2
        public void a(String str) {
            hu3.r0();
            uf2.this.A();
        }

        @Override // dc.of2
        public void b(String str) {
            HashMap map = new HashMap();
            map.put("networkState", se3.a(WearUtils.x) + "");
            map.put("isNetworkAvailable", se3.c(WearUtils.x) + "");
            map.put("trace", Log.getStackTraceString(new Throwable()));
            map.put(NotificationCompat.CATEGORY_MESSAGE, str);
            ye3.d("E0012", WearUtils.A.toJson(map));
            xe3.b(uf2.i, g.class.getSimpleName(), "SocketIO断联了：" + WearUtils.A.toJson(map));
        }

        public /* synthetic */ g(uf2 uf2Var, a aVar) {
            this();
        }
    }

    /* compiled from: SocketIoClient.java */
    public class h extends nf2 {
        public h(uf2 uf2Var) {
        }

        @Override // dc.of2
        public void a(String str) {
            xe3.b(uf2.i, h.class.getSimpleName(), "收到回执" + str);
        }

        @Override // dc.of2
        public void b(String str) {
        }

        public /* synthetic */ h(uf2 uf2Var, a aVar) {
            this(uf2Var);
        }
    }

    /* compiled from: SocketIoClient.java */
    public static class i {
        public static final uf2 a = new uf2(null);
    }

    public /* synthetic */ uf2(a aVar) {
        this();
    }

    public static /* synthetic */ int k(uf2 uf2Var) {
        int i2 = uf2Var.h;
        uf2Var.h = i2 + 1;
        return i2;
    }

    public static uf2 v() {
        return i.a;
    }

    public final void A() {
        this.e = false;
        Iterator<tf2> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().disConnect();
        }
    }

    public synchronized void B() {
        if (q()) {
            return;
        }
        if (this.b != null && MyApplication.Q == 3) {
            xe3.a(i, "socketIo开始重连");
            p(this.b);
        }
    }

    public void C(tf2 tf2Var) {
        this.f.remove(tf2Var);
    }

    public boolean D(String str, Object obj) {
        synchronized (this.d) {
            if (this.c == null || !this.c.A()) {
                if (this.c == null) {
                    xe3.a(i, "mSocket=null");
                } else {
                    xe3.a(i, "连接断开，发送消息失败");
                }
                return false;
            }
            try {
                Object json = JSON.toJSON(obj);
                xe3.a(i, "sendMsg:" + str + "==" + json.toString());
                this.c.a(str, json);
                return true;
            } catch (StackOverflowError e2) {
                e2.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e2);
                FirebaseCrashlytics.getInstance().log("sendMsg:" + str + ", class:" + obj.getClass().getSimpleName() + ", msg" + WearUtils.A.toJson(obj));
                return false;
            }
        }
    }

    public boolean E(pf2 pf2Var) {
        return D(pf2Var.getAction(), pf2Var);
    }

    public boolean F(String str) {
        synchronized (this.d) {
            if (this.c == null || !this.c.A()) {
                if (this.c == null) {
                    xe3.a(i, "mSocket=null");
                } else {
                    xe3.a(i, "连接断开，发送消息失败");
                }
                return false;
            }
            try {
                this.c.a(str, new Object[0]);
                return true;
            } catch (StackOverflowError e2) {
                e2.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e2);
                FirebaseCrashlytics.getInstance().log("sendMsg:" + str);
                return false;
            }
        }
    }

    public final void G() {
        u();
        this.g = Observable.interval(10000L, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public void H() {
        NtokenResponseBean ntokenResponseBean = this.b;
        if (ntokenResponseBean != null) {
            p(ntokenResponseBean);
        }
    }

    @Override // dc.qw3
    public boolean a(String str, String str2) {
        String str3 = i;
        xe3.a(str3, "事件名：" + str + " 数据：" + str2);
        StringBuilder sb = new StringBuilder();
        sb.append("数  据：");
        sb.append(str2);
        xe3.a(str3, sb.toString());
        SocketIoBean socketIoBean = (SocketIoBean) JSON.parseObject(str2, SocketIoBean.class);
        boolean z = false;
        if (socketIoBean == null || TextUtils.isEmpty(socketIoBean.getAckId())) {
            return false;
        }
        Iterator<ac2> it = j.iterator();
        while (it.hasNext()) {
            if (it.next().c(socketIoBean, str2)) {
                z = true;
            }
        }
        return z;
    }

    @Override // dc.qw3
    public boolean b(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj.toString());
        }
        xe3.b(i, str, sb.toString());
        return false;
    }

    @Override // dc.qf2
    public boolean c(String str, Object obj) {
        return true;
    }

    @Override // dc.qw3
    public void d(String str, pw3.a aVar) {
        synchronized (this.d) {
            if (this.c != null && !this.c.b(str) && aVar != null) {
                xe3.a(i, str + " " + aVar.getClass().getSimpleName());
                this.c.f(str, aVar);
            }
        }
    }

    @Override // dc.qw3
    public String e(String str, Object... objArr) {
        if (objArr.length <= 0) {
            return "";
        }
        try {
            BaseSocketIoRec baseSocketIoRec = (BaseSocketIoRec) JSON.parseObject(objArr[0].toString(), BaseSocketIoRec.class);
            if (baseSocketIoRec.requestReceipt && !TextUtils.isEmpty(baseSocketIoRec.requestId)) {
                MsgRecReceipt msgRecReceipt = new MsgRecReceipt();
                msgRecReceipt.processed = true;
                msgRecReceipt.requestType = baseSocketIoRec.requestType;
                msgRecReceipt.receiveId = baseSocketIoRec.requestId;
                msgRecReceipt.serverTime = System.currentTimeMillis();
                E(msgRecReceipt);
            }
            return objArr[0].toString();
        } catch (Exception unused) {
            return objArr[0].toString();
        }
    }

    public void o(tf2 tf2Var) {
        if (this.f.contains(tf2Var)) {
            return;
        }
        this.f.add(tf2Var);
    }

    public void p(NtokenResponseBean ntokenResponseBean) {
        synchronized (this.d) {
            if (ntokenResponseBean != null) {
                if (!TextUtils.isEmpty(ntokenResponseBean.ws_server_url) && !TextUtils.isEmpty(ntokenResponseBean.socketIoPath)) {
                    if (this.c != null && !ntokenResponseBean.ws_server_url.equals(this.a)) {
                        t();
                    }
                    if (this.c == null || !this.c.A()) {
                        t();
                        this.c = w(ntokenResponseBean);
                        xe3.a(i, "socket___connecting");
                        this.b = ntokenResponseBean;
                        this.c.z();
                    } else {
                        xe3.a(i, "socket___connected: " + this.c);
                    }
                }
            }
        }
    }

    public boolean q() {
        synchronized (this.d) {
            if (this.c == null) {
                return false;
            }
            return this.c.A();
        }
    }

    public void r(rf2 rf2Var, mf2 mf2Var) {
        Observable.create(new c(rf2Var)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, mf2Var));
    }

    public void s(rf2 rf2Var, mf2 mf2Var, long j2) {
        Observable.create(new e(rf2Var, j2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, mf2Var));
    }

    public void t() {
        try {
            synchronized (this.d) {
                if (this.c != null) {
                    ob2.o().K();
                    this.c.C();
                    this.c = null;
                }
            }
            ob2.o().K();
            u();
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void u() {
        Disposable disposable = this.g;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.g.dispose();
        this.g = null;
    }

    public final nw3 w(NtokenResponseBean ntokenResponseBean) {
        if (this.c == null) {
            try {
                this.a = ntokenResponseBean.ws_server_url;
                kw3.a aVar = new kw3.a();
                aVar.b = ntokenResponseBean.socketIoPath;
                aVar.t = 5L;
                aVar.u = 20L;
                this.c = kw3.c(new URI(this.a), aVar);
                x();
                xe3.a(i, this.a + " socketIoPath:" + ntokenResponseBean.socketIoPath);
            } catch (URISyntaxException unused) {
            }
        }
        return this.c;
    }

    public final void x() {
        o(pb2.m());
        o(ob2.o());
        o(zb2.O());
        o(vb2.b());
        o(wb2.b());
        o(hg2.m());
        o(fg2.j());
        o(eq2.f());
        o(OrgyControl.getInstance());
        o(nk2.b());
        o(ig2.n());
        o(k32.a());
        o(e42.i());
        ft2 ft2Var = ft2.a;
        o(ft2Var);
        a aVar = null;
        this.c.f("connect", new f(this, aVar));
        this.c.f("disconnect", new g(this, aVar));
        this.c.f("MsgRecReceipt", new h(this, aVar));
        pb2.m().r();
        rw3.c(this, r32.l());
        rw3.e(this, ob2.o());
        rw3.f(this, pb2.m());
        rw3.i(this, zb2.O());
        rw3.g(this, vb2.b());
        rw3.h(this, wb2.b());
        rw3.k(this, hg2.m());
        rw3.j(this, fg2.j());
        rw3.n(this, eq2.f());
        rw3.a(this, OrgyControl.getInstance());
        rw3.m(this, nk2.b());
        rw3.l(this, ig2.n());
        rw3.b(this, k32.a());
        rw3.d(this, e42.i());
        rw3.o(this, ft2Var);
    }

    public boolean y() {
        return this.e;
    }

    public final void z() {
        this.e = true;
        Iterator<tf2> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().connectSuc();
        }
    }

    public uf2() {
        this.d = new Object();
        this.e = false;
        this.f = new CopyOnWriteArraySet();
        this.h = 0;
    }
}
