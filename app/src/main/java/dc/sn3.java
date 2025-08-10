package dc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.AddFriendActivity;
import com.wear.main.longDistance.CreateChatRoomActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.discover.voicecontrol.VoiceControlActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: MainAddDialogUtil.java */
/* loaded from: classes4.dex */
public class sn3 implements DialogInterface.OnShowListener {
    public Activity a;
    public zn3 b;

    /* compiled from: MainAddDialogUtil.java */
    public class a implements View.OnClickListener {

        /* compiled from: MainAddDialogUtil.java */
        /* renamed from: dc.sn3$a$a, reason: collision with other inner class name */
        public class C0217a extends HashMap<String, String> {
            public C0217a() {
                put("count", "" + ch3.i.size());
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sn3.this.b.dismiss();
            if (MyApplication.Z) {
                sn3.this.d(R.string.offline_add_people);
                return;
            }
            WearUtils.x.q("longDistance_add_friend", new C0217a());
            Intent intent = new Intent(sn3.this.c(), (Class<?>) AddFriendActivity.class);
            pj3.d(intent);
            sn3.this.c().startActivity(intent);
        }
    }

    /* compiled from: MainAddDialogUtil.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sn3.this.b.dismiss();
            pj3.f(sn3.this.c(), ToyActivity.class);
        }
    }

    /* compiled from: MainAddDialogUtil.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sn3.this.b.dismiss();
            pj3.f(sn3.this.c(), VoiceControlActivity.class);
        }
    }

    /* compiled from: MainAddDialogUtil.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sn3.this.b.dismiss();
            if (MyApplication.Z) {
                sn3.this.d(R.string.offline_scan_qr);
            } else if (sn3.this.c() instanceof MainActivity) {
                ((MainActivity) sn3.this.c()).c8();
            }
        }
    }

    /* compiled from: MainAddDialogUtil.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            sn3.this.b.dismiss();
            if (MyApplication.Z) {
                sn3.this.d(R.string.offline_new_group);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("flag", 0);
            eg3.j(sn3.this.c(), "NewGroup", true);
            ye3.i("Long Distance", "new_group_click", "click", "new_group", "button");
            pj3.g(sn3.this.c(), CreateChatRoomActivity.class, bundle);
        }
    }

    /* compiled from: MainAddDialogUtil.java */
    public class f implements kn3.d {
        public f() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.s(sn3.this.c(), LoginActivity.class);
        }
    }

    public sn3(Activity activity) {
        this.a = activity;
    }

    public Activity c() {
        Activity activity = this.a;
        return activity == null ? MyApplication.H() : activity;
    }

    public final void d(int i) {
        kn3 kn3Var = new kn3((Context) c(), ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new f());
        kn3Var.show();
        kn3Var.p();
    }

    public void e(View view) {
        zn3 zn3Var = this.b;
        if (zn3Var != null) {
            if (zn3Var.isShowing()) {
                this.b.dismiss();
            }
            this.b = null;
        }
        zn3 zn3Var2 = new zn3(c(), R.style.MenuDialog, R.layout.select_menu_2_black_item);
        this.b = zn3Var2;
        zn3Var2.setOnShowListener(this);
        this.b.a(view, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 20);
        this.b.findViewById(R.id.action_row_1).setOnClickListener(new a());
        this.b.findViewById(R.id.ll_add_toy).setOnClickListener(new b());
        this.b.findViewById(R.id.action_row_2).setOnClickListener(new c());
        this.b.findViewById(R.id.action_row_3).setOnClickListener(new d());
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.ll_create_group);
        relativeLayout.setOnClickListener(new e());
        boolean z = WearUtils.D;
        String strF = lg3.f(WearUtils.x);
        if (MyApplication.Z) {
            relativeLayout.setVisibility(("zh".equals(strF) || z) ? 8 : 0);
        } else {
            relativeLayout.setVisibility((ch3.n().o().getIsSupportGroup() == 0 || "zh".equals(strF) || z) ? 8 : 0);
        }
        this.b.findViewById(R.id.line_group).setVisibility(relativeLayout.getVisibility());
        this.b.show();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
    }
}
