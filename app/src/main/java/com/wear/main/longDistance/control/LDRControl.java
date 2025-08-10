package com.wear.main.longDistance.control;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.LdrToyAdapter;
import com.wear.bean.Account;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.d83;
import dc.dh3;
import dc.mp1;
import dc.ou3;
import dc.pa2;
import dc.pc1;
import dc.rq1;
import dc.sg3;
import dc.ua2;
import dc.vc1;
import dc.xc1;
import dc.xe3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public abstract class LDRControl {
    public static boolean p = false;
    public User c;
    public Toy g;
    public Toy h;

    @BindView(R.id.iv_ldr_control)
    public ImageView ivLdrControl;

    @BindView(R.id.iv_ldr_control_states)
    public ImageView ivLdrControlStates;
    public LdrToyAdapter j;
    public LdrToyAdapter k;
    public String l;

    @BindView(R.id.ldr_sensitivity)
    public SeekBar ldrSensitivity;

    @BindView(R.id.ldr_sensitivity_layout)
    public LinearLayout ldrSensitivityLayout;
    public boolean m;
    public int n;
    public final int[] o;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_self)
    public RecyclerView rvSelf;

    @BindView(R.id.tv_friend_name)
    public TextView tvFriendName;

    @BindView(R.id.tv_ldr_control)
    public TextView tvLdrControl;
    public ArrayList<Toy> a = new ArrayList<>();
    public ArrayList<Toy> b = new ArrayList<>();
    public Account d = ch3.n().u();
    public boolean e = false;
    public Handler f = new Handler(Looper.getMainLooper());
    public pc1 i = null;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LDRControl lDRControl = LDRControl.this;
            Toy toy = lDRControl.h;
            if (toy == null || !lDRControl.b.contains(toy)) {
                for (int i = 0; i < LDRControl.this.b.size(); i++) {
                    if (LDRControl.this.b.get(i).isSupportLdr() || (LDRControl.q(LDRControl.this.b.get(i)) && LDRControl.p)) {
                        LDRControl.this.j.j = i;
                        LDRControl lDRControl2 = LDRControl.this;
                        lDRControl2.h = lDRControl2.b.get(i);
                    }
                }
            } else {
                LdrToyAdapter ldrToyAdapter = LDRControl.this.j;
                LDRControl lDRControl3 = LDRControl.this;
                ldrToyAdapter.j = lDRControl3.b.indexOf(lDRControl3.h);
            }
            LDRControl.this.j.n.clear();
            LDRControl.this.j.notifyDataSetChanged();
            LDRControl.this.O();
        }
    }

    public class b implements LdrToyAdapter.b {
        public b() {
        }

        @Override // com.wear.adapter.longdistance.LdrToyAdapter.b
        public void a(View view) {
            ua2.e(MyApplication.H(), view, LDRControl.this.g);
        }

        @Override // com.wear.adapter.longdistance.LdrToyAdapter.b
        public void b(BaseAdapter.ViewHolder viewHolder, Toy toy, int i) {
            boolean z = toy.isSupportLdr() || (LDRControl.q(toy) && LDRControl.p);
            if (z) {
                LDRControl lDRControl = LDRControl.this;
                if (lDRControl.g != toy && lDRControl.n != 2) {
                    if (!toy.isConnected()) {
                        sg3.l(String.format(ah4.e(R.string.str_select_fail_by_toy_disconnected), toy.getSimpleName()));
                        return;
                    }
                    LDRControl lDRControl2 = LDRControl.this;
                    lDRControl2.X(toy, lDRControl2.n);
                    LDRControl.this.k.j = i;
                    LDRControl.this.b0(true);
                    LDRControl.this.k.notifyDataSetChanged();
                    LDRControl.this.g0(true, toy.getAndUpdateDeviceId());
                }
            }
            if (z || LDRControl.this.n == 2) {
                return;
            }
            sg3.h(R.string.sync_lds_click_unsupported_toy);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LDRControl.this.j.notifyDataSetChanged();
            LDRControl.this.O();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LDRControl.this.b0(true);
            LDRControl.this.d();
        }
    }

    public LDRControl() {
        MyApplication myApplication = WearUtils.x;
        this.m = false;
        this.n = 0;
        this.o = new int[]{R.string.chat_control_ldr_ways, R.string.patterns_in_control, R.string.patterns_begin_control};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        Toy toy = this.g;
        if (toy == null || !this.a.contains(toy)) {
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i).isSupportLdr() || (q(this.a.get(i)) && p)) {
                    this.k.j = i;
                    this.g = this.a.get(i);
                    break;
                }
            }
        } else {
            this.k.j = this.a.indexOf(this.g);
        }
        this.k.n.clear();
        this.k.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(int i, int i2) {
        a0(i);
        C(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(String str, String[] strArr, String[] strArr2) throws NumberFormatException {
        int i = this.n;
        if (i == 2) {
            o0(this.k.n.entrySet().iterator(), str, strArr, strArr2, true);
            o0(this.j.n.entrySet().iterator(), str, strArr, strArr2, false);
        } else if (i == 0) {
            o0(this.k.n.entrySet().iterator(), str, strArr, strArr2, true);
        }
    }

    public static boolean m(ArrayList<Toy> arrayList) {
        Iterator<Toy> it = arrayList.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isSupportLdr()) {
                return true;
            }
            if (q(next) && p) {
                return true;
            }
        }
        return false;
    }

    public static boolean n(ArrayList<Toy> arrayList, boolean z) {
        Iterator<Toy> it = arrayList.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (z) {
                if (next.isSupportLdr() || q(next)) {
                    return true;
                }
            } else if (next.isSupportLdr() || (q(next) && p)) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(Toy toy) {
        return toy.isH01Toy() || toy.isBAToy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        a0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        C(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x() {
        this.tvLdrControl.setText(ah4.e(this.o[this.n]));
        boolean z = this instanceof pa2;
        int i = this.n;
        if (i == 1) {
            this.ivLdrControl.setImageResource(z ? R.drawable.chat_sync_ldr_controlled_black : R.drawable.chat_sync_ldr_controlled);
            this.ivLdrControlStates.setImageResource(R.drawable.chat_sync_direction_controlled);
            this.tvFriendName.setText(ah4.e(R.string.control_link_controllee));
            this.f.postDelayed(new Runnable() { // from class: dc.ca2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t();
                }
            }, 500L);
            Toy toy = this.g;
            if (toy == null || toy.isSupportLdr() || q(this.g)) {
                return;
            }
            sg3.l(ah4.e(R.string.toast_lds_switch_control2));
            return;
        }
        if (i == 2) {
            this.ivLdrControl.setImageResource(z ? R.drawable.chat_sync_ldr_controlling_black : R.drawable.chat_sync_ldr_controlling);
            this.ivLdrControlStates.setImageResource(R.drawable.chat_sync_direction_controlling);
            this.tvFriendName.setText(ah4.e(R.string.group_chat_controller));
            WearUtils.x.l.postDelayed(new Runnable() { // from class: dc.ea2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.v();
                }
            }, 500L);
            sg3.l(ah4.e(R.string.toast_lds_switch_control3));
            return;
        }
        this.ivLdrControl.setImageResource(z ? R.drawable.chat_sync_ldr_interactive_black : R.drawable.chat_sync_ldr_interactive);
        this.ivLdrControlStates.setImageResource(R.drawable.chat_sync_direction_interactive);
        this.tvFriendName.setText(ah4.e(R.string.control_link_controllee));
        if (this.g != null) {
            return;
        }
        sg3.l(ah4.e(R.string.toast_lds_switch_control2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(xc1 xc1Var) {
        xe3.a("send", "玩具重新连接，发送startMoveWaggle指令给玩具");
        Iterator<Toy> it = this.a.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (xc1Var.a().equals(next.getAddress())) {
                Toy toy = this.g;
                if (toy == null || WearUtils.e1(toy.getAddress()) || !next.getAddress().equals(this.g.getAddress())) {
                    if (next.isConnected() && next.isF01Toy()) {
                        e0(next);
                    }
                } else if (!next.isConnected()) {
                    C(0);
                    a0(0);
                } else if (next.isF01Toy() && this.n == 1) {
                    this.i.r0(next);
                } else {
                    e0(next);
                }
            }
        }
    }

    public final void I() {
        this.f.post(new a());
    }

    public final void J() {
        this.f.post(new Runnable() { // from class: dc.aa2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B();
            }
        });
    }

    public void K() {
        Z();
        L();
    }

    public final void L() {
        J();
        I();
    }

    public void M() {
        this.n = 0;
    }

    public abstract void N();

    public void O() {
        int i = this.j.j;
        if (i == -1) {
            this.rvFriend.scrollToPosition(this.b.size() - 1);
        } else if (i < this.b.size() - 1) {
            this.rvFriend.scrollToPosition(i + 1);
        } else {
            this.rvFriend.scrollToPosition(i);
        }
    }

    public abstract void P();

    public abstract void Q(String str);

    public synchronized void R(String str, List<Integer> list, List<Integer> list2) {
        if (!this.e) {
            Toy toyQ = this.i.Q(str);
            if (toyQ != null) {
                g(toyQ);
            }
            return;
        }
        Toy toy = this.g;
        if (toy == null) {
            return;
        }
        if (WearUtils.e1(toy.getAddress())) {
            return;
        }
        if (this.g.getAddress().equals(str)) {
            final int iIntValue = list.size() > 0 ? list.get(0).intValue() : 0;
            int iIntValue2 = list2.size() > 0 ? list2.get(0).intValue() : 0;
            if (iIntValue != 0) {
                ua2.a();
                WearUtils.p2(this.a, str);
                this.k.notifyDataSetChanged();
            }
            int i = this.n;
            if (i == 0) {
                S(str, iIntValue, iIntValue2);
                this.f.post(new Runnable() { // from class: dc.da2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.D(iIntValue);
                    }
                });
            } else if (i == 1) {
                S(str, iIntValue, iIntValue2);
                T(str, iIntValue, iIntValue2);
                this.f.post(new Runnable() { // from class: dc.fa2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.F(iIntValue, iIntValue);
                    }
                });
            }
        }
    }

    public void S(String str, int i, int i2) {
        xe3.a("send", str + " level:" + i + "baseLevel:" + i2);
        ArrayList arrayList = new ArrayList();
        User user = this.c;
        if (user != null) {
            for (Toy toy : user.getCLLinkedToys2()) {
                String toyFunction = toy.isSupportV1V2() ? PSOProgramService.VS_Key : toy.isBAToy() ? "t" : Toy.getToyFunction(toy.getType());
                if (!arrayList.contains(toyFunction)) {
                    arrayList.add(toyFunction);
                }
            }
        }
        String str2 = "";
        String str3 = "";
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            str3 = i3 == 0 ? (String) arrayList.get(i3) : str3 + "," + ((String) arrayList.get(i3));
        }
        String[] strArrSplit = str3.split(",");
        for (String str4 : strArrSplit) {
            if (!WearUtils.e1(str4) && Toy.TOY_OPERATION.containsKey(str4)) {
                str2 = str2 + l(str4, i * 5) + ",";
            }
        }
        if (str2.length() > 0) {
            String strSubstring = str2.substring(0, str2.length() - 1);
            if (strArrSplit.length == strSubstring.split(",").length) {
                ou3.q(this.c, MessageType.sync, str3, strSubstring, false);
            }
        }
    }

    public final void T(String str, int i, int i2) {
        Iterator<Toy> it = this.a.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (!next.isThridPartToy() || !TextUtils.equals(next.getAddress(), str)) {
                if (mp1.h()) {
                    rq1.d.a(next.getAddress(), i, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
                } else {
                    pc1.a.o0(next, i, false, true);
                }
            }
        }
    }

    public void U() {
        if (this.e) {
            rq1.d.q();
            Iterator<Toy> it = this.a.iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getAddress())) {
                    Toy toy = this.g;
                    if (toy != null && !WearUtils.e1(toy.getAddress()) && next.getAddress().equals(this.g.getAddress())) {
                        g(next);
                    } else if (next.isF01Toy()) {
                        g(next);
                    }
                }
            }
            this.e = false;
        }
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final void D(int i) {
        Iterator<Map.Entry<Toy, ImageView>> it = this.j.n.entrySet().iterator();
        while (it.hasNext()) {
            m0(it.next().getValue(), i);
        }
    }

    public void W(int i) {
        f0();
        if (this.g == null) {
            return;
        }
        Iterator<Toy> it = this.a.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (i == 0) {
                if (next.isF01Toy() || TextUtils.equals(next.getAddress(), this.g.getAddress())) {
                    e0(next);
                }
            } else if (i == 1) {
                if (TextUtils.equals(next.getAddress(), this.g.getAddress())) {
                    if (next.isF01Toy()) {
                        this.i.r0(next);
                    } else {
                        e0(next);
                    }
                } else if (next.isF01Toy()) {
                    e0(next);
                }
            } else if (i == 2) {
                if (next.isF01Toy()) {
                    e0(next);
                } else if (TextUtils.equals(next.getAddress(), this.g.getAddress())) {
                    g(next);
                }
            }
        }
    }

    public void X(Toy toy, int i) {
        f0();
        Toy toy2 = this.g;
        if (toy2 != null) {
            if (toy2.isF01Toy()) {
                e0(this.g);
            } else {
                g(this.g);
            }
        }
        if (i == 1 && toy.isF01Toy()) {
            this.i.r0(toy);
        } else {
            e0(toy);
        }
        this.g = toy;
    }

    public void Y() {
        int i = this.n;
        if (i == 0) {
            this.n = 2;
        } else if (i == 2) {
            this.n = 1;
        } else if (i == 1) {
            this.n = 0;
        }
    }

    public final void Z() {
        ArrayList<Toy> arrayListK = k(this.b);
        this.b.clear();
        this.b.addAll(arrayListK);
        ArrayList<Toy> arrayListK2 = k(this.a);
        this.a.clear();
        this.a.addAll(arrayListK2);
        Collections.reverse(this.b);
    }

    public final void a0(int i) {
        Iterator<Map.Entry<Toy, ImageView>> it = this.k.n.entrySet().iterator();
        while (it.hasNext()) {
            m0(it.next().getValue(), i);
        }
    }

    public void b0(boolean z) {
        WearUtils.U0(this.a);
        this.k.notifyDataSetChanged();
    }

    public final void c0() {
        if (m(this.b)) {
            return;
        }
        int i = this.n;
        if (i == 0) {
            if (this.b.isEmpty()) {
                return;
            }
            ArrayList<Toy> arrayList = this.b;
            if (TextUtils.equals(arrayList.get(arrayList.size() - 1).getName(), "touch_icon_flag")) {
                return;
            }
            Toy toy = new Toy();
            toy.setName("touch_icon_flag");
            this.b.add(toy);
            return;
        }
        if (i != 1 || this.b.isEmpty()) {
            return;
        }
        ArrayList<Toy> arrayList2 = this.b;
        Toy toy2 = arrayList2.get(arrayList2.size() - 1);
        if (toy2 == null || !TextUtils.equals(toy2.getName(), "touch_icon_flag")) {
            return;
        }
        this.b.remove(toy2);
    }

    public final void d() {
        rq1.d.q();
        W(this.n);
        if (this.n == 2) {
            this.d.setLiveStatus(2);
            ou3.w(this.c);
            a0(0);
            LdrToyAdapter ldrToyAdapter = this.k;
            ldrToyAdapter.k = false;
            ldrToyAdapter.notifyDataSetChanged();
            this.j.k = true;
            this.d.setLDRMutualControl(false);
        } else {
            LdrToyAdapter ldrToyAdapter2 = this.k;
            ldrToyAdapter2.k = true;
            ldrToyAdapter2.notifyDataSetChanged();
            if (this.n == 1) {
                this.j.k = false;
                this.d.setLiveStatus(1);
                this.d.setLDRMutualControl(false);
            } else {
                this.j.k = this.h != null;
                this.d.setLDRMutualControl(true);
            }
        }
        c0();
        this.j.notifyDataSetChanged();
        O();
        this.f.postDelayed(new Runnable() { // from class: dc.ga2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x();
            }
        }, 500L);
        l0();
    }

    public void d0(boolean z) {
        p = this.c.isSupportSolaceTapButtonControl();
        L();
        if (this.c.isSupportLdrTouchPanel()) {
            if (d83.w().getH() == null || !d83.w().getH().isShowing()) {
                this.n = 0;
            }
        } else if (this.g == null) {
            this.n = 2;
        } else if (this.h == null) {
            this.n = 1;
        } else {
            this.n = 0;
        }
        this.e = true;
        ChatSyncControl.L = true;
        this.ivLdrControlStates.setImageResource(R.drawable.chat_sync_direction_interactive);
        a0(0);
        C(0);
        this.ldrSensitivity.setProgress(j());
        N();
        this.tvLdrControl.setText(ah4.e(this.o[this.n]));
        d();
        if (z) {
            P();
        }
    }

    public boolean e() {
        String remotePlatform = this.c.getRemotePlatform();
        String remoteVersion = this.c.getRemoteVersion();
        if (!WearUtils.e1(remotePlatform) && !WearUtils.e1(remoteVersion)) {
            String strReplace = remoteVersion.replace(".", "");
            if (WearUtils.e1(strReplace)) {
                strReplace = "0";
            }
            if (strReplace.length() > 3) {
                strReplace = strReplace.substring(0, 3);
            } else if (strReplace.length() < 3) {
                int length = strReplace.length();
                for (int i = 0; i < 3 - length; i++) {
                    strReplace = strReplace + "0";
                }
            }
            if (remotePlatform.equalsIgnoreCase("ios") && Integer.valueOf(strReplace).intValue() <= 312) {
                return false;
            }
        }
        return true;
    }

    public final void e0(Toy toy) {
        this.i.s0(toy);
    }

    public void f() {
        U();
        EventBus.getDefault().unregister(this);
        this.g = null;
        this.h = null;
    }

    public final void f0() {
        Toy toy = this.g;
        if (toy != null) {
            S(toy.getDeviceId(), 0, 0);
            T(this.g.getAddress(), 0, 0);
        }
        a0(0);
        C(0);
    }

    public final void g(Toy toy) {
        this.i.E(toy);
    }

    public void g0(boolean z, String str) {
        if (z) {
            Q(str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (str.equalsIgnoreCase(this.b.get(i).getAndUpdateDeviceId())) {
                this.j.j = i;
                this.h = this.b.get(i);
                this.f.post(new c());
                i0(i);
                return;
            }
        }
    }

    public Activity h() {
        return MyApplication.H();
    }

    public boolean h0(boolean z) {
        int i = this.n;
        if (i != 0) {
            if (i == 1) {
                if (this.h == null) {
                    I();
                }
                if (!this.c.isSupportLdrTouchPanel() && this.h == null) {
                    sg3.h(R.string.lvs_partner_dont_support);
                    return false;
                }
                if (z) {
                    this.n = this.h == null ? 0 : 2;
                } else {
                    this.n = 0;
                }
            } else if (i == 2) {
                if (this.g == null) {
                    J();
                }
                if (!this.c.isSupportLdrTouchPanel() && this.g == null) {
                    sg3.h(R.string.lvs_I_dont_support);
                    return false;
                }
                if (z) {
                    this.n = 0;
                } else {
                    this.n = this.g != null ? 1 : 0;
                }
            }
        } else if (z) {
            Toy toy = this.g;
            this.n = toy != null ? 1 : 2;
            if (toy != null) {
                g0(true, toy.getAndUpdateDeviceId());
            }
        } else {
            this.n = this.h == null ? 1 : 2;
        }
        this.f.post(new d());
        return true;
    }

    public int i() {
        return this.n;
    }

    public abstract void i0(int i);

    public abstract int j();

    public void j0(List<Toy> list) {
        if (list == null) {
            rq1.d.q();
            a0(0);
            return;
        }
        if (list.size() == 0) {
            rq1.d.q();
            a0(0);
        } else {
            if (this.h == null) {
                return;
            }
            for (Toy toy : list) {
                if (this.h.getDeviceId().equals(toy.getDeviceId()) && toy.getStatus() != 1) {
                    rq1.d.q();
                    a0(0);
                    return;
                }
            }
        }
    }

    public final ArrayList<Toy> k(ArrayList<Toy> arrayList) {
        ArrayList<Toy> arrayList2 = new ArrayList<>();
        Iterator<Toy> it = arrayList.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isSupportLdr() || (q(next) && p)) {
                arrayList2.add(next);
            }
        }
        Iterator<Toy> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Toy next2 = it2.next();
            if (!next2.isSupportLdr() && (!q(next2) || !p)) {
                arrayList2.add(next2);
            }
        }
        return arrayList2;
    }

    public ToyBean k0(ToyBean toyBean) {
        if (this.e && (this.g != null || this.n != 0)) {
            int iJ = j();
            if (toyBean.getV1() > 0) {
                if (iJ == 0) {
                    toyBean.setV1(0);
                } else {
                    float v1 = (toyBean.getV1() * iJ) / 100.0f;
                    toyBean.setV1((toyBean.getV1() <= 0 || ((int) v1) != 0) ? (int) v1 : 1);
                }
            }
            if (toyBean.getV2() > 0) {
                if (iJ == 0) {
                    toyBean.setV2(0);
                } else {
                    float v2 = (toyBean.getV2() * iJ) / 100.0f;
                    toyBean.setV2((toyBean.getV2() <= 0 || ((int) v2) != 0) ? (int) v2 : 1);
                }
            }
            if (toyBean.getV3() > 0) {
                if (iJ == 0) {
                    toyBean.setV3(0);
                } else {
                    float v3 = (toyBean.getV3() * iJ) / 100.0f;
                    toyBean.setV3((toyBean.getV3() <= 0 || ((int) v3) != 0) ? (int) v3 : 1);
                }
            }
            if (toyBean.getV() > 0) {
                if (iJ == 0) {
                    toyBean.setV(0);
                } else {
                    float v = (toyBean.getV() * iJ) / 100.0f;
                    toyBean.setV((toyBean.getV() <= 0 || ((int) v) != 0) ? (int) v : 1);
                }
            }
            if (toyBean.getR() > 0) {
                if (iJ == 0) {
                    toyBean.setR(0);
                } else {
                    float r = (toyBean.getR() * iJ) / 100.0f;
                    toyBean.setR((toyBean.getR() <= 0 || ((int) r) != 0) ? (int) r : 1);
                }
            }
            if (toyBean.getP() > 0) {
                if (iJ == 0) {
                    toyBean.setP(0);
                } else {
                    float p2 = (toyBean.getP() * iJ) / 100.0f;
                    toyBean.setP((toyBean.getP() <= 0 || ((int) p2) != 0) ? (int) p2 : 1);
                }
            }
            if (toyBean.getT() > 0) {
                if (iJ == 0) {
                    toyBean.setT(0);
                } else {
                    float t = (toyBean.getT() * iJ) / 100.0f;
                    toyBean.setT((toyBean.getT() <= 0 || ((int) t) != 0) ? (int) t : 1);
                }
            }
            if (toyBean.getS() > 0) {
                if (iJ == 0) {
                    toyBean.setS(0);
                } else {
                    float s = (toyBean.getS() * iJ) / 100.0f;
                    toyBean.setS((toyBean.getS() <= 0 || ((int) s) != 0) ? (int) s : 1);
                }
            }
            if (toyBean.getF() > 0) {
                if (iJ == 0) {
                    toyBean.setF(0);
                } else {
                    float f = (toyBean.getF() * iJ) / 100.0f;
                    toyBean.setF((toyBean.getF() <= 0 || ((int) f) != 0) ? (int) f : 1);
                }
            }
            if (toyBean.getD() > 0) {
                if (iJ == 0) {
                    toyBean.setD(0);
                } else {
                    float d2 = (toyBean.getD() * iJ) / 100.0f;
                    toyBean.setD((toyBean.getD() <= 0 || ((int) d2) != 0) ? (int) d2 : 1);
                }
            }
            if (toyBean.getPos() > 0) {
                if (iJ == 0) {
                    toyBean.setPos(0);
                } else {
                    float pos = (toyBean.getPos() * iJ) / 100.0f;
                    toyBean.setPos((toyBean.getPos() <= 0 || ((int) pos) != 0) ? (int) pos : 1);
                }
            }
        }
        return toyBean;
    }

    public final String l(String str, int i) {
        String[] strArr = Toy.TOY_OPERATION.get(str);
        if (WearUtils.j1(strArr) || strArr.length < 2) {
            return "";
        }
        int i2 = 100 / Integer.parseInt(strArr[1]);
        if (i / i2 == 0 && i > 0) {
            i = i2;
        }
        return "" + (i / i2);
    }

    public abstract void l0();

    public void m0(ImageView imageView, int i) {
        if (i <= 0) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level0);
            return;
        }
        if (i < 5) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level1);
            return;
        }
        if (i < 10) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level2);
        } else if (i < 15) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level3);
        } else {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level4);
        }
    }

    public void n0(final String str, final String[] strArr, final String[] strArr2) {
        this.f.post(new Runnable() { // from class: dc.z92
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.a.H(str, strArr, strArr2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void o(com.wear.bean.handlerbean.IPeopleInfo r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.wear.bean.UserRoulette
            if (r0 != 0) goto L15
            java.lang.String r0 = r3.l
            if (r0 == 0) goto L15
            com.wear.bean.ControlIdBean r1 = dc.gu3.j
            java.lang.String r1 = r1.getControlId()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L15
            return
        L15:
            com.wear.util.MyApplication r0 = com.wear.util.WearUtils.x
            com.wear.bean.ControlIdBean r0 = dc.gu3.j
            java.lang.String r0 = r0.getControlId()
            r3.l = r0
            r0 = r4
            com.wear.bean.User r0 = (com.wear.bean.User) r0
            r3.c = r0
            dc.ch3 r1 = dc.ch3.n()
            com.wear.bean.Account r1 = r1.u()
            r3.d = r1
            boolean r0 = r0.isSupportSolaceTapButtonControl()
            com.wear.main.longDistance.control.LDRControl.p = r0
            java.util.ArrayList<com.wear.bean.Toy> r0 = r3.a
            r0.clear()
            java.util.ArrayList<com.wear.bean.Toy> r0 = r3.b
            r0.clear()
            boolean r0 = r4 instanceof com.wear.bean.UserControlLink
            if (r0 == 0) goto L74
            r0 = r4
            com.wear.bean.UserControlLink r0 = (com.wear.bean.UserControlLink) r0
            boolean r1 = r0.isControlLink()
            if (r1 == 0) goto L74
            com.wear.bean.Account r1 = r3.d
            boolean r1 = r1.isControlLinkJoiner()
            if (r1 != 0) goto L5f
            java.util.ArrayList<com.wear.bean.Toy> r1 = r3.a
            com.wear.bean.Account r2 = r3.d
            java.util.ArrayList r2 = r2.getControlLinkToys()
            r1.addAll(r2)
            goto L6a
        L5f:
            java.util.ArrayList<com.wear.bean.Toy> r1 = r3.a
            dc.pc1 r2 = dc.pc1.a
            java.util.ArrayList r2 = r2.P()
            r1.addAll(r2)
        L6a:
            java.util.ArrayList<com.wear.bean.Toy> r1 = r3.b
            java.util.ArrayList r0 = r0.getCLLinkedToys2()
            r1.addAll(r0)
            goto L88
        L74:
            java.util.ArrayList<com.wear.bean.Toy> r0 = r3.a
            dc.pc1 r1 = dc.pc1.a
            java.util.ArrayList r1 = r1.P()
            r0.addAll(r1)
            java.util.ArrayList<com.wear.bean.Toy> r0 = r3.b
            java.util.List r1 = r4.getLinkedToys2()
            r0.addAll(r1)
        L88:
            r3.Z()
            r3.L()
            android.widget.TextView r0 = r3.tvFriendName
            java.lang.String r4 = r4.getShowNickName()
            r0.setText(r4)
            r4 = 0
            r3.m = r4
        L9a:
            java.util.ArrayList<com.wear.bean.Toy> r0 = r3.b
            int r0 = r0.size()
            if (r4 >= r0) goto Lb7
            java.util.ArrayList<com.wear.bean.Toy> r0 = r3.b
            java.lang.Object r0 = r0.get(r4)
            com.wear.bean.Toy r0 = (com.wear.bean.Toy) r0
            boolean r0 = r0.isSupportLdr()
            if (r0 == 0) goto Lb4
            r4 = 1
            r3.m = r4
            goto Lb7
        Lb4:
            int r4 = r4 + 1
            goto L9a
        Lb7:
            org.greenrobot.eventbus.EventBus r4 = org.greenrobot.eventbus.EventBus.getDefault()     // Catch: java.lang.Exception -> Lc9
            boolean r4 = r4.isRegistered(r3)     // Catch: java.lang.Exception -> Lc9
            if (r4 != 0) goto Lcd
            org.greenrobot.eventbus.EventBus r4 = org.greenrobot.eventbus.EventBus.getDefault()     // Catch: java.lang.Exception -> Lc9
            r4.register(r3)     // Catch: java.lang.Exception -> Lc9
            goto Lcd
        Lc9:
            r4 = move-exception
            r4.printStackTrace()
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.control.LDRControl.o(com.wear.bean.handlerbean.IPeopleInfo):void");
    }

    public final void o0(Iterator<Map.Entry<Toy, ImageView>> it, String str, String[] strArr, String[] strArr2, boolean z) throws NumberFormatException {
        while (it.hasNext()) {
            Map.Entry<Toy, ImageView> next = it.next();
            Toy key = next.getKey();
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, key.getAndUpdateDeviceId())) {
                String toyFunction = Toy.getToyFunction(key.getType());
                int i = 0;
                int iMax = 0;
                while (true) {
                    if (i >= strArr.length) {
                        break;
                    }
                    if (this.m) {
                        if (TextUtils.equals(strArr[i], PSOProgramService.VS_Key)) {
                            iMax = Integer.parseInt(strArr2[i]);
                            break;
                        }
                    } else if (toyFunction.contains(strArr[i]) || (key.isBAToy() && strArr[i].equals(PSOProgramService.VS_Key))) {
                        int i2 = Integer.parseInt(strArr2[i]);
                        if ((!key.isQ01Toy() && !key.isF01Toy()) || !TextUtils.equals(strArr[i], PSOProgramService.VS_Key)) {
                            if (key.isMaxToy() && TextUtils.equals("p", strArr[i])) {
                                i2 *= 6;
                            }
                            if (key.isBAToy() && TextUtils.equals("pos", strArr[i])) {
                                i2 /= 5;
                            }
                            iMax = Math.max(iMax, i2);
                        }
                    }
                    i++;
                }
                m0(next.getValue(), iMax);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(final xc1 xc1Var) {
        if (!this.e || TextUtils.isEmpty(xc1Var.a())) {
            return;
        }
        this.f.postDelayed(new Runnable() { // from class: dc.ba2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z(xc1Var);
            }
        }, 1000L);
    }

    public void p(View view) {
        ButterKnife.bind(this, view);
        this.j = new LdrToyAdapter(this.b, R.layout.item_ldr_toy, false);
        this.k = new LdrToyAdapter(this.a, R.layout.item_ldr_toy, true);
        cg3.d(this.rvFriend, this.j);
        cg3.d(this.rvSelf, this.k);
        this.k.C(new b());
    }

    public int r() {
        User user = this.c;
        if (user == null) {
            return 2;
        }
        boolean zC = dh3.c(user);
        boolean zE = dh3.e(this.c);
        if (this.c instanceof UserRoulette) {
            zC = true;
            zE = true;
        }
        if (zC) {
            if (e() && this.a.size() != 0 && this.b.size() != 0 && (m(this.a) || m(this.b))) {
                return 0;
            }
            this.e = false;
            return 2;
        }
        if (!zE) {
            return 1;
        }
        if (this.a.size() == 1 && this.b.size() == 1) {
            String lowerCase = this.a.get(0).getType().toLowerCase();
            if (lowerCase.equals("nora".toLowerCase()) || lowerCase.equals("max".toLowerCase())) {
                String lowerCase2 = this.b.get(0).getType().toLowerCase();
                if (lowerCase2.equals("nora".toLowerCase()) || lowerCase2.equals("max".toLowerCase())) {
                    return 0;
                }
            }
        }
        this.e = false;
        return 2;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        Toy toyQ = this.i.Q(vc1Var.a());
        if (toyQ != null) {
            try {
                ImageView imageView = this.k.o.get(toyQ.getAndUpdateDeviceId());
                if (!toyQ.isF01Toy()) {
                    Toy.updateToyBattery(imageView, vc1Var.b());
                } else if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UserUpdateEvent userUpdateEvent) {
        String str = userUpdateEvent.message;
        if (this.c == null || WearUtils.e1(str) || !str.equals(WearUtils.g0(this.c.getUserJid()))) {
            return;
        }
        j0(this.c.getCLLinkedToys2());
    }
}
