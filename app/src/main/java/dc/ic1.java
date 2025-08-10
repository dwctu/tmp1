package dc;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: BtBattery.java */
/* loaded from: classes3.dex */
public class ic1 {
    public final HashMap<String, Integer> a = new HashMap<>();
    public kn3 b = null;

    /* compiled from: BtBattery.java */
    public class a implements Runnable {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ String b;

        /* compiled from: BtBattery.java */
        /* renamed from: dc.ic1$a$a, reason: collision with other inner class name */
        public class C0185a implements kn3.d {
            public C0185a(a aVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        public a(FragmentActivity fragmentActivity, String str) {
            this.a = fragmentActivity;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                kn3 kn3Var = ic1.this.b;
                if (kn3Var != null) {
                    try {
                        kn3Var.dismiss();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    ic1.this.b = null;
                }
                ic1.this.b = new kn3((Context) this.a, this.b, ah4.e(R.string.common_ok), false, false, (kn3.d) new C0185a(this));
                ic1.this.b.show();
                ic1.this.b.o();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ic1() {
        wb0.b(this);
    }

    public final void a(Toy toy, int i) {
        if (!toy.isSelect()) {
            this.a.remove(toy.getAddress());
            return;
        }
        EventBus.getDefault().post(new vc1(toy.getAddress(), i));
        if (!WearUtils.c1(this.a.get(toy.getAddress()))) {
            Integer num = this.a.get(toy.getAddress());
            if (num != null && num.intValue() == 19 && i < 5) {
                e(toy, i);
            }
        } else if (i > 0 && i < 20) {
            e(toy, i);
        }
        if (i >= 23) {
            this.a.remove(toy.getAddress());
        }
    }

    public final void b(Toy toy, int i) {
        WearUtils.x.D0();
        a(toy, i);
        LocalBroadcastManager.getInstance(ve0.a()).sendBroadcast(new Intent("ACTION_TOY_UPDATE"));
    }

    public void c(String str, int i) {
        Toy toy = pc1.a.g().get(str);
        if (toy == null) {
            return;
        }
        toy.setBattery(i);
    }

    public final void d(String str) {
        try {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH == null || fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            fragmentActivityH.runOnUiThread(new a(fragmentActivityH, str));
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public final void e(Toy toy, int i) {
        String str;
        if (i < 5) {
            this.a.put(toy.getAddress(), 4);
            str = String.format(ah4.e(R.string.toy_low_battery_notices), toy.getName(), "5") + "%";
        } else {
            this.a.put(toy.getAddress(), 19);
            str = String.format(ah4.e(R.string.toy_low_battery_notices), toy.getName(), "20") + "%";
        }
        if (WearUtils.e1(str)) {
            return;
        }
        d(str);
    }

    public final void f(String str, int i) {
        Toy toy = pc1.a.g().get(str);
        if (toy == null) {
            return;
        }
        b(toy, i);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(v20 v20Var) {
        f(v20Var.getA(), v20Var.getB());
    }
}
