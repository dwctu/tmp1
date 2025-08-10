package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.FloatingNewControlView;
import com.wear.widget.dialog.ControlExpandDialog;
import dc.is3;
import dc.jv1;
import dc.na2;
import dc.pd3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: BaseControl.java */
/* loaded from: classes3.dex */
public abstract class ka2<T extends IPeopleInfo, E extends jv1> implements ra2, pd3.b, na2.b {
    public FloatingNewControlView a;
    public Account b;
    public T c;
    public String d;
    public E f;
    public MyApplication g;
    public int i;
    public TextView j;
    public ControlExpandDialog l;
    public Dialog m;
    public boolean e = true;
    public int h = R.drawable.full_control_sync;
    public Handler k = new Handler(Looper.getMainLooper());

    /* compiled from: BaseControl.java */
    public class a implements is3.d {
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            this.a = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ka2.this.Q(this.a);
            ka2.this.E();
        }
    }

    /* compiled from: BaseControl.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ka2.this.R();
        }
    }

    /* compiled from: BaseControl.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatingNewControlView floatingNewControlView = ka2.this.a;
            if (floatingNewControlView != null) {
                floatingNewControlView.b();
            }
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
        }
    }

    /* compiled from: BaseControl.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ka2 ka2Var = ka2.this;
            if (ka2Var.a != null) {
                ka2Var.F();
                ka2.this.a.b();
            }
        }
    }

    /* compiled from: BaseControl.java */
    public class e implements is3.d {
        public final /* synthetic */ Activity a;

        public e(Activity activity) {
            this.a = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ka2.this.Q(this.a);
        }
    }

    /* compiled from: BaseControl.java */
    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ka2.this.l = null;
            ka2.this.j = null;
        }
    }

    /* compiled from: BaseControl.java */
    public class g implements is3.c {
        public g() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            ka2.this.W();
        }
    }

    /* compiled from: BaseControl.java */
    public class h implements ControlExpandDialog.c {
        public h() {
        }

        @Override // com.wear.widget.dialog.ControlExpandDialog.c
        public void end() {
            ka2.this.a();
        }
    }

    /* compiled from: BaseControl.java */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ka2.this.l != null && ka2.this.l.isShowing()) {
                ka2.this.l.dismiss();
            }
            if (ka2.this.m != null && ka2.this.m.isShowing()) {
                ka2.this.m.dismiss();
            }
            ua2.a();
        }
    }

    /* compiled from: BaseControl.java */
    public class j implements DialogInterface.OnDismissListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ka2.this.m = null;
        }
    }

    /* compiled from: BaseControl.java */
    public interface k {
        void a();
    }

    /* compiled from: BaseControl.java */
    public interface l {
        void cancel();
    }

    public static void C(boolean z, List<Toy> list, final k kVar) {
        if (WearUtils.e1(DaoUtils.getTestValueDao().getValue(TestValueDao.SEX_MACHINE_TIP_KEY, TestValueDao.SEX_MACHINE_TIP_TYPE))) {
            boolean z2 = false;
            ArrayList<Toy> arrayList = new ArrayList<>();
            if (z) {
                arrayList = WearUtils.x.G().o();
            } else if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Toy> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().isF01Toy()) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                DaoUtils.getTestValueDao().save(TestValueDao.SEX_MACHINE_TIP_KEY, "1", TestValueDao.SEX_MACHINE_TIP_TYPE);
                FragmentActivity fragmentActivityH = MyApplication.H();
                if (fragmentActivityH == null || fragmentActivityH.isFinishing()) {
                    return;
                }
                cs3.c(fragmentActivityH, ah4.e(R.string.notification_switch_to_traditional), ah4.e(R.string.common_ok), ah4.e(R.string.button_not_now_1), new is3.d() { // from class: dc.o82
                    @Override // dc.is3.d
                    public final void doConfirm() {
                        ka2.N(kVar);
                    }
                }).show();
            }
        }
    }

    public static /* synthetic */ void N(k kVar) {
        if (kVar != null) {
            kVar.a();
        }
    }

    public boolean A() {
        if ((this.c instanceof UserRoulette) && !(I() instanceof NewChatActivity)) {
            return true;
        }
        ControlExpandDialog controlExpandDialog = this.l;
        return (controlExpandDialog != null && controlExpandDialog.isShowing()) || !this.e;
    }

    public abstract void B();

    public boolean D(String str) {
        T t = this.c;
        if (t != null && t.getId().equals(str)) {
            return r();
        }
        return false;
    }

    public void E() {
        U(new i());
    }

    public void F() {
        this.e = true;
        this.a.setVisibility(8);
    }

    public void G() {
        MyApplication.i0 = false;
        this.i = 0;
        U(new d());
    }

    public void H() {
        FragmentActivity fragmentActivityI = I();
        if (fragmentActivityI == null) {
            return;
        }
        if ((fragmentActivityI instanceof ChatRoomActivity) && this.c == ((ChatRoomActivity) fragmentActivityI).C()) {
            Q(fragmentActivityI);
            return;
        }
        if ((fragmentActivityI instanceof ChatActivity) && this.c == ((ChatActivity) fragmentActivityI).C()) {
            Q(fragmentActivityI);
            return;
        }
        if ((fragmentActivityI instanceof ControlLinkChatActivity) && this.c == ((ControlLinkChatActivity) fragmentActivityI).C()) {
            Q(fragmentActivityI);
            return;
        }
        if (this.c instanceof UserRoulette) {
            Q(fragmentActivityI);
            return;
        }
        F();
        is3.b bVar = new is3.b(fragmentActivityI);
        bVar.d(new e(fragmentActivityI));
        ExpandData expandData = new ExpandData();
        expandData.k(this.a.getData().c);
        expandData.p(this.a.getData().a);
        expandData.q(this.a.getData().b);
        expandData.l(this.c.getShowNickName());
        expandData.j(this.h);
        bVar.e(expandData);
        bVar.f(new f());
        bVar.c(new g());
        ControlExpandDialog controlExpandDialog = (ControlExpandDialog) cs3.i(bVar, ControlExpandDialog.class);
        this.l = controlExpandDialog;
        if (controlExpandDialog == null) {
            return;
        }
        controlExpandDialog.p(fragmentActivityI);
        this.l.show();
        this.l.setListener(new h());
        this.j = (TextView) this.l.findViewById(R.id.tv_time);
        this.j.setText(WearUtils.Q(this.i));
    }

    public FragmentActivity I() {
        return MyApplication.H();
    }

    public T J() {
        return this.c;
    }

    public void K(FloatingNewControlView floatingNewControlView, View view) {
        this.a = floatingNewControlView;
        if (floatingNewControlView != null) {
            floatingNewControlView.removeAllViews();
        }
        if (view != null) {
            floatingNewControlView.addView(view);
        }
        floatingNewControlView.setOnClickListener(new b());
        F();
        pd3.j().o(this);
    }

    public void L(T t) {
        this.c = t;
        this.d = t.getId();
        this.b = ch3.n().u();
    }

    public void M(int i2) {
        if (r()) {
            a();
        } else if (z()) {
            B();
        }
    }

    public void O(E e2) {
        this.f = null;
    }

    public abstract void P();

    public abstract void Q(Activity activity);

    public abstract void R();

    public void S() {
    }

    public void T(Runnable runnable) {
        this.k.postDelayed(runnable, 200L);
    }

    public void U(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.k.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void V(String str) {
        Dialog dialog = this.m;
        if (dialog != null && dialog.isShowing()) {
            this.m.dismiss();
            this.m = null;
        }
        FragmentActivity fragmentActivityI = I();
        is3.b bVar = new is3.b(fragmentActivityI);
        bVar.p(str);
        bVar.d(new a(fragmentActivityI));
        bVar.n(ah4.e(R.string.button_not_now));
        bVar.f(new j());
        is3 is3VarH = cs3.h(bVar);
        this.m = is3VarH;
        is3VarH.show();
    }

    public void W() {
        this.e = false;
        this.a.setVisibility(0);
    }

    public void Y() {
        U(new c());
    }

    public JSONObject Z(Toy toy) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.ATTR_ID, (Object) toy.getDeviceId());
        jSONObject.put("name", (Object) toy.getName());
        jSONObject.put("fVersion", (Object) toy.getVersion());
        jSONObject.put("battery", (Object) Integer.valueOf(toy.getBattery()));
        jSONObject.put("isControl", (Object) Boolean.valueOf(toy.isConnected()));
        jSONObject.put("status", (Object) Integer.valueOf(toy.getStatus()));
        jSONObject.put("type", (Object) toy.getType());
        return jSONObject;
    }

    public void b0() {
    }

    @Override // dc.pd3.b
    public void n() {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UserUpdateEvent userUpdateEvent) {
        String str = userUpdateEvent.message;
        if (this.c == null || WearUtils.e1(str) || !str.equals(this.c.getId())) {
            return;
        }
        if (this instanceof ChatLiveControl) {
            S();
        }
        if (this instanceof ChatVideoControl) {
            b0();
        }
        if (r()) {
            if (!this.c.isOnline()) {
                P();
            } else if (this.c.isDateIng() && !MyApplication.P) {
                P();
            }
            T t = this.c;
            if (t instanceof User) {
                User user = (User) t;
                String supportType = user.getSupportType();
                if (TextUtils.isEmpty(supportType) || "openfire#socketio_1".equals(supportType) || !zb2.O().Y()) {
                    return;
                }
                zb2.O().U0(false, user.getId());
            }
        }
    }

    public void p() {
        if (!r() || this.e) {
            return;
        }
        W();
    }

    public void q() {
        if (!r() || this.e) {
            return;
        }
        this.a.setVisibility(8);
    }

    public void w(E e2) {
        this.f = e2;
    }

    public void x(Activity activity) {
        FloatingNewControlView floatingNewControlView = this.a;
        if (floatingNewControlView == null) {
            return;
        }
        floatingNewControlView.setWidthAndHeight(activity, getMinWidth(), getMinHeight());
    }

    public abstract boolean z();
}
