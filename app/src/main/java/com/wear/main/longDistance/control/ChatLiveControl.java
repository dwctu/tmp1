package com.wear.main.longDistance.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.ControlIdBean;
import com.wear.bean.RateFeature;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.event.ControlLinkChatControlEnd;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.NetworkInfoEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.protocol.EntityLive;
import com.wear.protocol.MessageType;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ah4;
import dc.c83;
import dc.ch3;
import dc.cs3;
import dc.dh3;
import dc.du3;
import dc.gg3;
import dc.gu3;
import dc.is3;
import dc.jp3;
import dc.jv1;
import dc.ka2;
import dc.la2;
import dc.me3;
import dc.mk2;
import dc.ou3;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.rq1;
import dc.sg3;
import dc.sz1;
import dc.va2;
import dc.ye3;
import dc.yf3;
import dc.zb2;
import dc.zc2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class ChatLiveControl extends la2<User, jv1> implements MultiControlPanel.m, MultiControlPanel.r {

    @BindView(R.id.fl_live_layout)
    public LinearLayout flLiveLayout;

    @BindView(R.id.iv_control_close)
    public ImageView ivControlClose;

    @BindView(R.id.ll_live_control_time)
    public LinearLayout llLiveControlTime;

    @BindView(R.id.multipanel_livecontrol)
    public MultiControlPanel multiControlPanel;
    public va2 p;
    public boolean q;
    public jp3 r;
    public View s;
    public LinkedHashMap<String, Toy> t;

    @BindView(R.id.tv_control_time)
    public TextView tvControlTime;

    @BindView(R.id.tv_control_time_center)
    public TextView tvControlTimeCenter;

    @BindView(R.id.tv_live_control_tip)
    public TextView tvLiveControlTip;
    public zc2 u;
    public Dialog v;

    @BindView(R.id.v_be_controled_live)
    public LinearLayout vBeControledLive;

    @BindView(R.id.v_control_live_no_toys)
    public ConstraintLayout vControlLiveNoToys;

    @BindView(R.id.v_live_control_line)
    public View vLiveControlLine;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatLiveControl.this.z0();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatLiveControl.this.a();
            ChatLiveControl chatLiveControl = ChatLiveControl.this;
            T t = chatLiveControl.c;
            if (t == 0 || (t instanceof UserRoulette)) {
                return;
            }
            ye3.c(null, "end control link live control", chatLiveControl.d);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatLiveControl.this.a();
            ChatLiveControl chatLiveControl = ChatLiveControl.this;
            T t = chatLiveControl.c;
            if (t == 0 || (t instanceof UserRoulette)) {
                return;
            }
            ye3.c(null, "end control link live control", chatLiveControl.d);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatLiveControl.this.S0();
            if (ChatLiveControl.this.r != null) {
                ChatLiveControl.this.r.e();
            }
            ChatLiveControl.this.multiControlPanel.U();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ MessageType a;

        public e(MessageType messageType) {
            this.a = messageType;
        }

        public static /* synthetic */ void a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.control.ChatLiveControl.e.run():void");
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ User a;

        public f(User user) {
            this.a = user;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x005a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws android.content.res.Resources.NotFoundException {
            /*
                r4 = this;
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                r1 = 0
                com.wear.main.longDistance.control.ChatLiveControl.i0(r0, r1)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                com.wear.bean.User r2 = r4.a
                r0.y0(r2)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                dc.zc2 r0 = r0.u
                r0.i()
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                dc.zc2 r0 = r0.u
                r0.g(r1)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                com.wear.bean.User r0 = (com.wear.bean.User) r0
                java.util.ArrayList r0 = r0.getLinkedToys2()
                int r0 = r0.size()
                r2 = 1
                if (r0 <= 0) goto L33
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                dc.zc2 r0 = r0.u
                r0.g(r2)
            L33:
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                r0.x0(r2)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                r0.Y()
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                com.wear.bean.User r0 = (com.wear.bean.User) r0
                boolean r0 = r0.isControlLink()
                r2 = 8
                if (r0 != 0) goto L5a
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r3 = r0.c
                boolean r3 = r3 instanceof com.wear.bean.UserRoulette
                if (r3 == 0) goto L54
                goto L5a
            L54:
                android.widget.TextView r0 = r0.tvControlTime
                r0.setVisibility(r1)
                goto L61
            L5a:
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                android.widget.TextView r0 = r0.tvControlTime
                r0.setVisibility(r2)
            L61:
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                com.wear.bean.User r0 = (com.wear.bean.User) r0
                boolean r0 = r0.isDateIng()
                if (r0 == 0) goto L77
                dc.me3$c r0 = dc.me3.c.DATING_LIVE_CONTROL_BEGIN
                java.lang.String r1 = dc.me3.a()
                dc.me3.d(r0, r1)
                goto Le2
            L77:
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                com.wear.bean.User r0 = (com.wear.bean.User) r0
                boolean r0 = r0.isControlLink()
                if (r0 == 0) goto L9d
                dc.me3$a r0 = dc.me3.a.CONTROL_LINK_CHAT_LIVE_CONTROL
                dc.me3.e(r0)
                dc.me3$c r0 = dc.me3.c.CONTROL_LINK_LIVE_CONTROL_BEGIN
                java.lang.String r1 = dc.me3.a()
                dc.me3.d(r0, r1)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                java.lang.String r0 = r0.d
                java.lang.String r1 = "control link chatroom"
                java.lang.String r3 = "begin control link live control"
                dc.ye3.c(r1, r3, r0)
                goto Le2
            L9d:
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                boolean r0 = r0 instanceof com.wear.bean.UserRoulette
                java.lang.String r1 = "begin live control"
                if (r0 == 0) goto Lc5
                dc.me3$a r0 = dc.me3.a.PRIVATE_CHAT_LIVE_CONTROL
                dc.me3.e(r0)
                dc.me3$c r0 = dc.me3.c.PRIVATE_CHAT_LIVE_CONTROL_BEGIN
                java.lang.String r3 = dc.me3.a()
                dc.me3.d(r0, r3)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                com.wear.bean.User r0 = (com.wear.bean.User) r0
                java.lang.String r0 = r0.getUserJid()
                java.lang.String r3 = "control roulette chatroom"
                dc.ye3.c(r3, r1, r0)
                goto Le2
            Lc5:
                dc.me3$a r0 = dc.me3.a.PRIVATE_CHAT_LIVE_CONTROL
                dc.me3.e(r0)
                dc.me3$c r0 = dc.me3.c.PRIVATE_CHAT_LIVE_CONTROL_BEGIN
                java.lang.String r3 = dc.me3.a()
                dc.me3.d(r0, r3)
                com.wear.main.longDistance.control.ChatLiveControl r0 = com.wear.main.longDistance.control.ChatLiveControl.this
                T extends com.wear.bean.handlerbean.IPeopleInfo r0 = r0.c
                com.wear.bean.User r0 = (com.wear.bean.User) r0
                java.lang.String r0 = r0.getUserJid()
                java.lang.String r3 = "friend chatroom"
                dc.ye3.c(r3, r1, r0)
            Le2:
                dc.sz1 r0 = dc.sz1.d()
                r0.r(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.control.ChatLiveControl.f.run():void");
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatLiveControl.this.d1();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = ChatLiveControl.this.v;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            ChatLiveControl.this.v.dismiss();
        }
    }

    public static class i {
        public static final ChatLiveControl a = new ChatLiveControl(null);
    }

    public /* synthetic */ ChatLiveControl(a aVar) {
        this();
    }

    public static /* synthetic */ void B0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0() {
        Dialog dialog = this.v;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.v.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(String str) {
        this.r.m(str);
    }

    public static /* synthetic */ void G0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(MessageType messageType, boolean z) throws Resources.NotFoundException {
        this.q = false;
        this.u.i();
        y0((User) this.c);
        this.b.setCurrentControlType(messageType);
        this.b.setLiveStatus(1);
        this.b.setLiveFriendId(((User) this.c).getId());
        Dialog dialog = this.v;
        if (dialog != null && dialog.isShowing()) {
            this.v.dismiss();
        }
        this.v = null;
        E e2 = this.f;
        if (e2 != 0 && !(this.c instanceof UserRoulette)) {
            e2.addViewToActivity(this.s);
            this.f.l(this.c);
        }
        if (z) {
            if (((User) this.c).getCLLinkedToys2().size() > 0) {
                this.u.g(true);
            }
        } else if (((User) this.c).getLinkedToys2().size() > 0) {
            this.u.g(true);
        }
        x0(true);
        Y();
        d1();
        if (((User) this.c).isControlLink() || (this.c instanceof UserRoulette)) {
            this.tvControlTime.setVisibility(8);
        } else {
            this.tvControlTime.setVisibility(0);
        }
        ka2.C(false, ((User) this.c).getLinkedToys2(), new ka2.k() { // from class: dc.l92
            @Override // dc.ka2.k
            public final void a() {
                ChatLiveControl.G0();
            }
        });
        me3.e(me3.a.CONTROL_LINK_CHAT_LIVE_CONTROL);
        me3.d(me3.c.CONTROL_LINK_LIVE_CONTROL_BEGIN, me3.a());
        ye3.c("control link chatroom", "begin control link live control", this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(ka2.l lVar) {
        if (lVar != null) {
            lVar.cancel();
        }
        B();
        P0(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(DialogInterface dialogInterface) {
        this.v = null;
        this.u.a();
    }

    public static ChatLiveControl q0() {
        return i.a;
    }

    public static ChatLiveControl r0(View view) {
        i.a.A0(view);
        return i.a;
    }

    public final void A0(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.s = view;
        ButterKnife.bind(this, view);
        d0(this.g, R.drawable.full_control_live, "live.json");
        c cVar = new c();
        this.tvControlTime.setOnClickListener(cVar);
        this.llLiveControlTime.setOnClickListener(cVar);
        this.tvControlTimeCenter.setOnClickListener(cVar);
        this.multiControlPanel.X(this);
        this.multiControlPanel.setEndControlListener(this);
    }

    @Override // dc.ka2
    public void B() {
        this.q = true;
        this.u.b();
        T t = this.c;
        if (t != 0 && !((User) t).isControlLink()) {
            EntityLive entityLive = new EntityLive();
            entityLive.setType(EntityLive.LiveOPTType.cancel.toString());
            entityLive.setId(gu3.j.getControlId());
            ou3.m(entityLive, this.c);
        }
        U(new h());
    }

    public void O0(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || this.c == 0) {
            return;
        }
        if (!r()) {
            F();
        } else if (TextUtils.equals(((User) this.c).getId(), iPeopleInfo.getId())) {
            b1();
        } else {
            Z0();
        }
    }

    @Override // dc.ka2
    public void P() {
        if (((User) this.c).getChatType() == Presence.Type.unavailable && !((User) this.c).isControlLink()) {
            if (this.u.c()) {
                sg3.e(this.g, R.string.message_poor_network_webrtc);
                String str = "live5===" + ((User) this.c).getChatType();
                o0(false, true);
                return;
            }
            if (this.u.d()) {
                EntityLive entityLive = new EntityLive();
                entityLive.setType(EntityLive.LiveOPTType.cancel.toString());
                entityLive.setId(gu3.j.getControlId());
                ou3.m(entityLive, this.c);
                Dialog dialog = this.v;
                if (dialog != null && dialog.isShowing()) {
                    this.v.dismiss();
                }
                this.u.b();
                gu3.j.setAvailable(ControlIdBean.Status.cancel);
            }
        }
    }

    public final void P0(boolean z, boolean z2) {
        Q0(z, z2, (User) this.c);
    }

    @Override // dc.ka2
    public void Q(Activity activity) {
        if (((User) this.c).isControlLink()) {
            if (activity instanceof ControlLinkChatActivity) {
                ControlLinkChatActivity controlLinkChatActivity = (ControlLinkChatActivity) activity;
                if (controlLinkChatActivity.C() == this.c) {
                    controlLinkChatActivity.V2();
                    return;
                } else {
                    pj3.j(activity, ControlLinkChatActivity.class, "linkId", this.b.getControlLinkId());
                    return;
                }
            }
            return;
        }
        if (activity instanceof NewChatActivity) {
            ((NewChatActivity) activity).j5();
            return;
        }
        if (activity instanceof ChatActivity) {
            ChatActivity chatActivity = (ChatActivity) activity;
            if (chatActivity.C() == this.c) {
                chatActivity.V2();
                return;
            }
        }
        pj3.j(activity, ChatActivity.class, "userId", ((User) this.c).getId());
    }

    public final void Q0(boolean z, boolean z2, User user) {
        if (user == null || user.isControlLink() || (user instanceof UserRoulette)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oppo_jid", (Object) user.getUserJid());
        new Gson();
        JSONArray jSONArray = new JSONArray();
        ArrayList<Toy> cLLinkedToys2 = user.getCLLinkedToys2();
        if (cLLinkedToys2 != null) {
            Iterator<Toy> it = cLLinkedToys2.iterator();
            while (it.hasNext()) {
                jSONArray.add(Z(it.next()));
            }
        }
        jSONObject.put("oppo_toy", (Object) jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        ArrayList<Toy> arrayListP = pc1.a.P();
        if (arrayListP != null) {
            Iterator<Toy> it2 = arrayListP.iterator();
            while (it2.hasNext()) {
                jSONArray2.add(Z(it2.next()));
            }
        }
        jSONObject.put("toy", (Object) jSONArray2);
        int i2 = 1;
        jSONObject.put("controller_type", (Object) 1);
        jSONObject.put("control_type", (Object) "0");
        if (z2) {
            i2 = 5;
        } else if (this.q) {
            i2 = 4;
        } else if (!z) {
            i2 = 0;
        }
        jSONObject.put("control_end_type", (Object) Integer.valueOf(i2));
        jSONObject.put("control_duration", (Object) Integer.valueOf(WearUtils.C0(p0())));
        jSONObject.put("control_id", (Object) gu3.j.getControlId());
        ye3.d("F0013", jSONObject.toString());
    }

    public void R0(boolean z, boolean z2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Q0(z, z2, ch3.n().v(WearUtils.X(str)));
    }

    @Override // dc.ka2
    public void S() throws Resources.NotFoundException {
        if (r() && dh3.b(this.c)) {
            ArrayList<Toy> linkedToys2 = ((User) this.c).getLinkedToys2();
            LiveControlNin.e().l(linkedToys2.size());
            LinkedHashMap<String, Toy> linkedHashMap = this.t;
            if (linkedHashMap != null && linkedHashMap.size() >= 10 && linkedToys2.size() > 0) {
                this.t.clear();
                Iterator<Toy> it = linkedToys2.iterator();
                while (it.hasNext()) {
                    Toy next = it.next();
                    this.t.put(next.getDeviceId(), next);
                }
                this.multiControlPanel.q0(new ArrayList(this.t.values()));
                return;
            }
            LinkedHashMap<String, Toy> linkedHashMap2 = this.t;
            if ((linkedHashMap2 == null || linkedHashMap2.size() == 0) && linkedToys2.size() > 0) {
                if (this.t == null) {
                    this.t = new LinkedHashMap<>();
                }
                Iterator<Toy> it2 = linkedToys2.iterator();
                while (it2.hasNext()) {
                    Toy next2 = it2.next();
                    this.t.put(next2.getDeviceId(), next2);
                }
                this.b.setLiveStatus(1);
                this.u.g(true);
                x0(false);
                if (A()) {
                    V(String.format(ah4.e(R.string.live_controller_notification), ((User) this.c).getShowNickName()));
                }
                this.multiControlPanel.q0(linkedToys2);
                return;
            }
            LinkedHashMap<String, Toy> linkedHashMap3 = this.t;
            if (linkedHashMap3 == null || linkedHashMap3.size() <= 0) {
                return;
            }
            if (linkedToys2.size() == 0) {
                for (Map.Entry<String, Toy> entry : this.t.entrySet()) {
                    entry.getValue().setStatus(-1);
                    this.multiControlPanel.p0(entry.getKey(), false);
                }
                return;
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (String str : this.t.keySet()) {
                Iterator<Toy> it3 = linkedToys2.iterator();
                boolean z = true;
                while (it3.hasNext()) {
                    Toy next3 = it3.next();
                    String deviceId = next3.getDeviceId();
                    if (deviceId.equals(str)) {
                        z = false;
                    }
                    if (this.t.get(deviceId) == null) {
                        linkedHashMap4.put(deviceId, next3);
                    }
                }
                Toy toy = this.t.get(str);
                if (z) {
                    if (toy != null) {
                        toy.setStatus(-1);
                    }
                    this.multiControlPanel.p0(str, false);
                } else if (toy != null && toy.getStatus() != 1) {
                    toy.setStatus(1);
                    this.multiControlPanel.p0(str, true);
                }
            }
            if (linkedHashMap4.size() > 0) {
                this.t.putAll(linkedHashMap4);
                this.multiControlPanel.q0(new ArrayList(this.t.values()));
            }
        }
    }

    public void S0() {
        zb2.O().R0();
        Account account = this.b;
        if (account != null) {
            account.setLiveStatus(0);
            this.b.setLiveFriendId(null);
        }
        this.u.b();
        ou3.g();
        rq1.d.q();
        qf3.C();
        gu3.j.setAvailable(ControlIdBean.Status.end);
        this.t = null;
        pc1.a.I();
        this.i = 0;
        m0();
        jp3 jp3Var = this.r;
        if (jp3Var != null) {
            jp3Var.i();
        }
        w0();
        E();
        G();
    }

    public void T0(MessageType messageType) {
        U(new Runnable() { // from class: dc.k92
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D0();
            }
        });
    }

    public void U0() {
        e0();
    }

    public final void V0(List<Ball2CurveEventBean> list) throws ConcurrentModificationException {
        jp3 jp3Var = this.r;
        if (jp3Var != null) {
            jp3Var.k(list);
        }
        ArrayList arrayList = new ArrayList();
        for (Ball2CurveEventBean ball2CurveEventBean : list) {
            if (ball2CurveEventBean != null && !arrayList.contains(ball2CurveEventBean.getToyAddress())) {
                arrayList.add(ball2CurveEventBean.getToyAddress());
            }
        }
        ArrayList<Ball2CurveEventBean> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Ball2CurveEventBean ball2CurveEventBean2 = new Ball2CurveEventBean(str);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (Ball2CurveEventBean ball2CurveEventBean3 : new ArrayList(list)) {
                if (ball2CurveEventBean3 != null && TextUtils.equals(ball2CurveEventBean3.getToyAddress(), str)) {
                    sb.append(ball2CurveEventBean3.getFunction());
                    sb.append(",");
                    sb2.append(ball2CurveEventBean3.getGroups());
                    sb2.append(",");
                    if (ball2CurveEventBean3.isRotateChange()) {
                        ball2CurveEventBean2.setRotateChange(ball2CurveEventBean3.isRotateChange());
                    }
                }
            }
            ball2CurveEventBean2.setFunction(sb.substring(0, sb.length() - 1));
            ball2CurveEventBean2.setGroups(sb2.substring(0, sb2.length() - 1));
            arrayList2.add(ball2CurveEventBean2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Ball2CurveEventBean ball2CurveEventBean4 : arrayList2) {
            String strChangeSinglefuncLineToTayValue = Toy.changeSinglefuncLineToTayValue(ball2CurveEventBean4.getFunction(), ball2CurveEventBean4.getGroups());
            if (ou3.b(ball2CurveEventBean4.getToyAddress(), strChangeSinglefuncLineToTayValue, "") || ball2CurveEventBean4.isRotateChange()) {
                Ball2CurveEventBean ball2CurveEventBean5 = new Ball2CurveEventBean(ball2CurveEventBean4.getToyAddress(), ball2CurveEventBean4.getFunction(), strChangeSinglefuncLineToTayValue, ball2CurveEventBean4.isRotateChange());
                ball2CurveEventBean5.setSymbol(ball2CurveEventBean4.getSymbol());
                arrayList3.add(ball2CurveEventBean5);
            }
        }
        if (arrayList2.size() > 0) {
            ou3.r((User) this.c, this.b.getCurrentControlType(), arrayList3);
        }
    }

    public void W0(va2 va2Var) {
        this.p = va2Var;
    }

    public void X0(VelvoPreviewView velvoPreviewView) {
        if (velvoPreviewView == null) {
            return;
        }
        this.r = new jp3(this.multiControlPanel, velvoPreviewView, "CHAT_LIVE_CONTROL");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.i92
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.F0(str);
            }
        });
    }

    public void Y0() {
        W();
    }

    public void Z0() {
        if (this.c instanceof UserRoulette) {
            return;
        }
        if (!this.u.c()) {
            F();
            return;
        }
        W();
        ViewGroup viewGroup = (ViewGroup) this.s.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.s);
        }
    }

    @Override // dc.ra2
    public void a() {
        o0(true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a1(boolean z) {
        if (z) {
            F();
        }
        if (this.u.f()) {
            if (this.u.e()) {
                this.vControlLiveNoToys.setVisibility(8);
                this.vBeControledLive.setVisibility(8);
                this.multiControlPanel.setVisibility(0);
            } else {
                this.vControlLiveNoToys.setVisibility(0);
                this.vBeControledLive.setVisibility(8);
                this.multiControlPanel.setVisibility(8);
            }
        } else if (this.u.e()) {
            this.vControlLiveNoToys.setVisibility(8);
            this.vBeControledLive.setVisibility(8);
            this.multiControlPanel.setVisibility(0);
        } else {
            this.vControlLiveNoToys.setVisibility(8);
            this.vBeControledLive.setVisibility(0);
            this.multiControlPanel.setVisibility(8);
        }
        E e2 = this.f;
        if (e2 != 0) {
            e2.l(this.c);
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
    public void b(String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b1() {
        E e2 = this.f;
        if (e2 != 0 && !(this.c instanceof UserRoulette)) {
            e2.addViewToActivity(this.s);
            this.f.l(this.c);
        }
        F();
    }

    public void c1() {
        LinkedHashMap<String, Toy> linkedHashMap;
        if (r() && this.r != null && (linkedHashMap = this.t) != null && linkedHashMap.size() > 0) {
            this.r.r();
        }
    }

    public final void d1() {
        LiveControlNin.e().f(this.multiControlPanel);
    }

    public void e1(MessageType messageType) {
        U(new e(messageType));
    }

    @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
    public void f(List<Ball2CurveEventBean> list) throws ConcurrentModificationException {
        V0(list);
    }

    public void f0(User user) {
        U(new f(user));
        EventBus.getDefault().post(new NotificationCloseEvent());
        T(new g());
    }

    public void f1(final MessageType messageType, final boolean z) {
        U(new Runnable() { // from class: dc.f92
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.a.I0(messageType, z);
            }
        });
    }

    @Override // dc.na2.b
    public void g() {
        if (r()) {
            int i2 = this.i + 1;
            this.i = i2;
            String strQ = WearUtils.Q(i2);
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(strQ);
            }
            this.tvControlTime.setText(strQ);
            this.multiControlPanel.setControlTimer(strQ);
            this.tvControlTimeCenter.setText(strQ);
        }
    }

    public void g1(String str, final ka2.l lVar) {
        this.u.j();
        is3.b bVar = new is3.b(I());
        bVar.p(str);
        bVar.o(ah4.e(R.string.common_cancel));
        bVar.k(R.layout.dialog_default_ok);
        bVar.d(new is3.d() { // from class: dc.h92
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.K0(lVar);
            }
        });
        bVar.f(new DialogInterface.OnDismissListener() { // from class: dc.g92
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.N0(dialogInterface);
            }
        });
        is3 is3VarI = cs3.i(bVar, is3.class);
        this.v = is3VarI;
        is3VarI.show();
    }

    public final void h1() {
        LiveControlNin.e().d();
    }

    @Override // dc.na2.b
    public void k() {
    }

    public void l0() {
        ka2.C(false, ((User) this.c).getLinkedToys2(), new ka2.k() { // from class: dc.j92
            @Override // dc.ka2.k
            public final void a() {
                ChatLiveControl.B0();
            }
        });
    }

    @Override // com.wear.widget.control.multiToys.MultiControlPanel.m
    public void m() {
        T t = this.c;
        if (t != 0 && !(t instanceof UserRoulette)) {
            ye3.c(null, "end control link live control", this.d);
        }
        o0(true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0() {
        E e2 = this.f;
        if (e2 != 0) {
            e2.y(this.c);
        }
    }

    public void o0(boolean z, boolean z2) {
        String str = "isActive:" + z;
        EntityLive entityLive = new EntityLive();
        entityLive.setType(EntityLive.LiveOPTType.end.toString());
        entityLive.setId(gu3.j.getControlId());
        entityLive.setControlTime(p0());
        if (dh3.h((User) this.c)) {
            du3.e().x(((User) this.c).getLinkedToys2());
            du3.e().u((User) this.c);
        }
        T t = this.c;
        if (t != 0) {
            if (((User) t).isControlLink()) {
                if (z) {
                    EventBus.getDefault().post(new ControlLinkChatControlEnd(this.d, p0(), MessageType.live));
                }
                this.multiControlPanel.d0();
            } else if ((this.c instanceof UserRoulette) && z) {
                this.p.a();
                this.multiControlPanel.d0();
            } else {
                if (gu3.j.isCreate()) {
                    zb2.O().x0(entityLive, (User) this.c, this.b.getUserJid(), ((User) this.c).getUserJid());
                } else {
                    zb2 zb2VarO = zb2.O();
                    T t2 = this.c;
                    zb2VarO.x0(entityLive, (User) t2, ((User) t2).getUserJid(), this.b.getUserJid());
                }
                if (z) {
                    zb2.O().z0(((User) this.c).getUserJid(), entityLive);
                    yf3.b bVar = yf3.i;
                    bVar.a().s(RateFeature.Live, Integer.valueOf(WearUtils.C0(p0())));
                    bVar.a().n();
                }
            }
        }
        U(new d());
        if (z) {
            T t3 = this.c;
            if (t3 != 0 && !((User) t3).isControlLink()) {
                P0(z2, false);
            } else if (!c83.R1().P1()) {
                c83.R1().n2(1, z2 ? 1 : 0, WearUtils.C0(p0()));
            }
        }
        h1();
        if (mk2.P().h0()) {
            mk2.P().n0(false);
        }
        ou3.d();
        me3.e(me3.a.OTHERS);
        T t4 = this.c;
        if (t4 == 0 || !((User) t4).isDateIng()) {
            T t5 = this.c;
            if (t5 == 0 || !((User) t5).isControlLink()) {
                me3.d(me3.c.PRIVATE_CHAT_LIVE_CONTROL_END, String.valueOf(WearUtils.C0(p0())));
            } else {
                me3.d(me3.c.CONTROL_LINK_LIVE_CONTROL_END, String.valueOf(WearUtils.C0(p0())));
            }
        } else {
            me3.d(me3.c.DATING_LIVE_CONTROL_END, String.valueOf(WearUtils.C0(p0())));
        }
        sz1.d().o();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        if (!r() || MyApplication.P) {
            return;
        }
        o0(true, true);
    }

    public String p0() {
        return !WearUtils.e1(this.tvControlTimeCenter.getText().toString()) ? this.tvControlTimeCenter.getText().toString() : "00:00";
    }

    @Override // dc.ra2
    public boolean r() {
        return this.u.c();
    }

    public View s0() {
        return this.s;
    }

    public int t0() {
        T t = this.c;
        if (t == 0 || ((User) t).getLinkedToys2() == null) {
            return 0;
        }
        return ((User) this.c).getLinkedToys2().size();
    }

    public void u0() {
        F();
    }

    public void v0() {
        if (this.r == null || !r()) {
            return;
        }
        this.r.e();
    }

    public final void w0() {
        ViewGroup viewGroup = (ViewGroup) this.s.getParent();
        if (viewGroup == null || (this.c instanceof UserRoulette)) {
            return;
        }
        viewGroup.removeView(this.s);
    }

    public void x0(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.s.setVisibility(0);
        }
        boolean z2 = true;
        this.tvLiveControlTip.setText(String.format(ah4.e(R.string.live_control_panel_partner_no_toy), ((User) this.c).getShowNickName()));
        a1(z);
        if (z) {
            ArrayList<Toy> cLLinkedToys2 = ((User) this.c).isControlLink() ? ((User) this.c).getCLLinkedToys2() : ((User) this.c).getLinkedToys2();
            if (this.t == null) {
                this.t = new LinkedHashMap<>();
            }
            this.t.clear();
            Iterator<Toy> it = cLLinkedToys2.iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                this.t.put(next.getDeviceId(), next);
            }
            double dC = gg3.c(this.s.getContext());
            int i2 = (int) (0.07d * dC);
            MultiControlPanel multiControlPanel = this.multiControlPanel;
            if (!((User) this.c).isControlLink() && !(this.c instanceof UserRoulette)) {
                z2 = false;
            }
            multiControlPanel.setControlLink(z2);
            this.multiControlPanel.O(false, "CHAT_LIVE_CONTROL", cLLinkedToys2, 4, i2);
            int i3 = (int) (dC * 0.456d);
            int dimensionPixelSize = this.s.getContext().getResources().getDimensionPixelSize(R.dimen.mutli_toys_ds_sub_panel_height);
            if (i3 < dimensionPixelSize) {
                i3 = dimensionPixelSize;
            }
            this.multiControlPanel.setPanelHeight(i3, i2, cLLinkedToys2.size());
            if (this.multiControlPanel.getVisibility() == 0) {
                this.multiControlPanel.g0();
            }
            pc1.a.F();
            this.i = 0;
        }
    }

    public void y0(User user) {
        super.L(user);
        this.u.h(dh3.b(user));
    }

    @Override // dc.ka2
    public boolean z() {
        return r() || this.u.d();
    }

    public final void z0() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.view_live_control, (ViewGroup) null);
        this.s = viewInflate;
        ButterKnife.bind(this, viewInflate);
        d0(this.g, R.drawable.full_control_live, "live.json");
        b bVar = new b();
        this.tvControlTime.setOnClickListener(bVar);
        this.llLiveControlTime.setOnClickListener(bVar);
        this.tvControlTimeCenter.setOnClickListener(bVar);
        this.multiControlPanel.X(this);
        this.multiControlPanel.setEndControlListener(this);
    }

    public ChatLiveControl() {
        this.u = new zc2();
        this.b = ch3.n().u();
        this.g = WearUtils.x;
        U(new a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetworkInfoEvent networkInfoEvent) {
        if (!r() || networkInfoEvent.isAvailable) {
            return;
        }
        o0(false, true);
        sg3.h(R.string.message_poor_network_webrtc);
    }
}
