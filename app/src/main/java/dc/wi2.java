package dc;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ToyConnectInfoInstance.java */
/* loaded from: classes3.dex */
public class wi2 {
    public static wi2 d;
    public Handler b = new Handler(Looper.getMainLooper());
    public boolean c = false;
    public pc1 a = pc1.a;

    /* compiled from: ToyConnectInfoInstance.java */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            wi2.this.c = false;
            xe3.a("定时器", "结束延时");
            wi2.this.g(this.a, false);
        }
    }

    /* compiled from: ToyConnectInfoInstance.java */
    public class b implements Runnable {
        public final /* synthetic */ Toy a;

        public b(wi2 wi2Var, Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH == null || fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            sg3.k(fragmentActivityH, String.format(ah4.e(R.string.toy_connected_connected), this.a.getToyUINameSpecialForMiniXMachine(1)));
        }
    }

    /* compiled from: ToyConnectInfoInstance.java */
    public class c implements Runnable {
        public final /* synthetic */ Toy a;

        public c(wi2 wi2Var, Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            iq1.c(this.a.getAddress());
        }
    }

    /* compiled from: ToyConnectInfoInstance.java */
    public class d implements Runnable {
        public final /* synthetic */ Toy a;

        public d(Toy toy) {
            this.a = toy;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wi2.this.a.a(this.a.getAddress())) {
                fq1.b(this.a.getAddress());
                if (this.a.isSupportDepthMode()) {
                    jr1.c(this.a.getAddress());
                    jr1.d(this.a.getAddress());
                    if (ch3.n().u() == null) {
                        return;
                    }
                    if (db2.A().G() || na2.m().i()) {
                        wi2.this.a.G(this.a.getAddress());
                    }
                }
            }
        }
    }

    public static wi2 e() {
        if (d == null) {
            synchronized (wi2.class) {
                if (d == null) {
                    d = new wi2();
                }
            }
        }
        return d;
    }

    public synchronized void a(String str, User user, String str2) {
        Account accountU = ch3.n().u();
        if (accountU == null || !str.equals(accountU.getLiveFriendId())) {
            user.updateSyncLinkToy(str2);
            EventBus.getDefault().post(new UserUpdateEvent(str));
        } else if (ChatLiveControl.q0().r()) {
            xe3.a("定时器", str2);
            if (this.c) {
                user.updateSyncLinkToy(str2);
                return;
            }
            ArrayList<Toy> linkedToys2 = user.getLinkedToys2();
            user.updateSyncLinkToy(str2);
            ArrayList<Toy> linkedToys22 = user.getLinkedToys2();
            if (linkedToys2.size() == 0 || linkedToys2.size() <= linkedToys22.size()) {
                g(str, true);
            } else {
                h(str);
            }
        } else {
            user.updateSyncLinkToy(str2);
            g(str, true);
        }
    }

    public void d(Toy toy) {
        if (toy == null) {
            return;
        }
        sr1.b(toy.getAddress());
        vi2.a.e(toy.getAddress(), true);
        this.b.post(new b(this, toy));
        if (xg3.i().j()) {
            WearUtils.x.l.postDelayed(new c(this, toy), 700L);
        }
        if (toy.getStatus() != 1) {
            WearUtils.x.l.postDelayed(new d(toy), 1000L);
        }
    }

    public void f(String str) {
        ob2.o().G(str);
        hu3.T();
    }

    public final void g(String str, boolean z) {
        xe3.a("定时器", z + " " + str);
        EventBus.getDefault().post(new UserUpdateEvent(str));
    }

    public final void h(String str) {
        if (this.c) {
            return;
        }
        this.c = true;
        xe3.a("定时器", "開始延时");
        new Handler(Looper.getMainLooper()).postDelayed(new a(str), 3000L);
    }
}
