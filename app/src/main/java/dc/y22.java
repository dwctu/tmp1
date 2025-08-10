package dc;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.activity.UIStandard.UIDemoActivity;
import com.wear.bean.Toy;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.component.test.TestDialog;
import com.wear.main.longDistance.TestActivity;
import com.wear.main.toy.AddVirtualToyActivity;
import com.wear.ui.discover.xremote.activity.XRemoteDialogTestActivity;
import com.wear.util.ANRWatchDog;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.FloatNormalView;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;

/* compiled from: MyWindowManager.java */
/* loaded from: classes3.dex */
public class y22 {
    public static y22 b;
    public FloatNormalView a;

    public static y22 c() {
        if (b == null) {
            b = new y22();
        }
        return b;
    }

    public static /* synthetic */ void d(View view) {
        view.setEnabled(false);
        new ANRWatchDog().start();
    }

    public static /* synthetic */ void e(View view) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        pj3.f(fragmentActivityH, XRemoteDialogTestActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view, View view2) {
        a(view);
        se0.g(new Runnable() { // from class: dc.q22
            @Override // java.lang.Runnable
            public final void run() {
                new TestDialog(MyApplication.K).show();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view, View view2) {
        a(view);
    }

    public static /* synthetic */ void k(View view) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        fragmentActivityH.startActivity(new Intent(fragmentActivityH, (Class<?>) TestActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view, View view2) {
        Toy next;
        Iterator<Toy> it = pc1.a.P().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.isBAToy()) {
                    break;
                }
            }
        }
        if (next == null) {
            sg3.l("未连接solacePro玩具");
        } else {
            dk2.a.f(next);
        }
        s(view.getContext());
    }

    public static /* synthetic */ void n(View view) {
        if (uf2.v().q()) {
            sg3.l("socketIo断开啦");
            uf2.v().t();
        }
    }

    public static /* synthetic */ void o(View view) {
        sg3.l("socketIo开始重连");
        uf2.v().H();
    }

    public static /* synthetic */ void p(View view) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        pj3.f(fragmentActivityH, AddVirtualToyActivity.class);
    }

    public static /* synthetic */ void q(View view) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        fragmentActivityH.startActivity(new Intent(fragmentActivityH, (Class<?>) UIDemoActivity.class));
    }

    public static /* synthetic */ void r(View view) {
        if (MyApplication.Q == 1) {
            ep1.b().e("正在重连，不能断开");
            return;
        }
        ep1.b().e("主动退出（会自动重连）");
        hu3.z(WearUtils.x).w(true);
        MyApplication.Q = 2;
        ep1.b().n(1);
        ep1.b().e("主动退出完毕（会自动重连）");
        EventBus.getDefault().post(new LoginStatusActionEvent());
    }

    public final void A(View view) {
        view.findViewById(R.id.btn_toy).setOnClickListener(new View.OnClickListener() { // from class: dc.p22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.p(view2);
            }
        });
    }

    public final void B(View view) {
        view.findViewById(R.id.btn_ui_standard_demo).setOnClickListener(new View.OnClickListener() { // from class: dc.n22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.q(view2);
            }
        });
    }

    public final void C(View view) {
        A(view);
        w(view);
        y(view);
        z(view);
        D(view);
        t(view);
        B(view);
        v(view);
        x(view);
        u(view);
    }

    public final void D(View view) {
        view.findViewById(R.id.btn_xmpp_disconnect).setOnClickListener(new View.OnClickListener() { // from class: dc.t22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.r(view2);
            }
        });
    }

    public final void a(View view) {
        s(view.getContext());
        vd3.d();
        ah4.k();
    }

    public void b(Context context) {
        try {
            if (WearUtils.v) {
                FragmentActivity fragmentActivityH = MyApplication.H();
                if (!od3.c(fragmentActivityH)) {
                    od3.d(fragmentActivityH);
                    return;
                }
                if (this.a == null) {
                    this.a = new FloatNormalView(context);
                }
                C(this.a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void s(Context context) {
        if (this.a != null) {
            ((WindowManager) context.getSystemService("window")).removeView(this.a);
            this.a = null;
        }
    }

    public final void t(View view) {
        view.findViewById(R.id.btn_anr).setOnClickListener(new View.OnClickListener() { // from class: dc.v22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.d(view2);
            }
        });
    }

    public final void u(View view) {
        view.findViewById(R.id.tv_app_gallery_dialog_demo).setOnClickListener(new View.OnClickListener() { // from class: dc.w22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.e(view2);
            }
        });
    }

    public final void v(final View view) {
        view.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: dc.s22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.j(view, view2);
            }
        });
        view.findViewById(R.id.tv_component).setOnClickListener(new View.OnClickListener() { // from class: dc.u22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.h(view, view2);
            }
        });
    }

    public final void w(View view) {
        view.findViewById(R.id.btn_demo_page).setOnClickListener(new View.OnClickListener() { // from class: dc.x22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.k(view2);
            }
        });
    }

    public final void x(final View view) {
        view.findViewById(R.id.btn_ui_getStroke).setOnClickListener(new View.OnClickListener() { // from class: dc.r22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.m(view, view2);
            }
        });
    }

    public final void y(View view) {
        view.findViewById(R.id.btn_socketio_disconnect).setOnClickListener(new View.OnClickListener() { // from class: dc.o22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.n(view2);
            }
        });
    }

    public final void z(View view) {
        view.findViewById(R.id.btn_socketio_reconnect).setOnClickListener(new View.OnClickListener() { // from class: dc.m22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y22.o(view2);
            }
        });
    }
}
