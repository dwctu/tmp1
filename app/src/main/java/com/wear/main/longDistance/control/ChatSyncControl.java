package com.wear.main.longDistance.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.ControlIdBean;
import com.wear.bean.Pattern;
import com.wear.bean.RateFeature;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.User;
import com.wear.bean.UserControlLink;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.UserRoulette;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.bean.event.ControlLinkChatControlEnd;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.NetworkInfoEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.controlLink.request.ToyCommandBean;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntityToy;
import com.wear.protocol.MessageType;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewLDRPanel;
import com.wear.widget.control.TouchControlView;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ToyControlBuilder;
import dc.ad2;
import dc.ah4;
import dc.c83;
import dc.ce3;
import dc.ch3;
import dc.cs3;
import dc.dq2;
import dc.ff3;
import dc.gk2;
import dc.gu3;
import dc.ip3;
import dc.is3;
import dc.jp3;
import dc.jv1;
import dc.ka2;
import dc.la2;
import dc.me3;
import dc.mk2;
import dc.mp1;
import dc.my2;
import dc.nl1;
import dc.oa2;
import dc.ou3;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.rq1;
import dc.sg3;
import dc.sz1;
import dc.th4;
import dc.ua2;
import dc.va2;
import dc.ve0;
import dc.vg3;
import dc.xe2;
import dc.ye3;
import dc.yf3;
import dc.yg3;
import dc.zb2;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class ChatSyncControl extends la2<User, jv1> {
    public static boolean L = false;
    public List<Ball2CurveEventBean> A;
    public List<List<Ball2CurveEventBean>> B;
    public ArrayList<Toy> C;
    public String D;
    public int E;
    public Handler F;
    public va2 G;
    public jp3 K;

    @BindView(R.id.chat_live_bottom_pattern_layer)
    public LinearLayout chatLiveBottomPatternLayer;

    @BindView(R.id.chat_live_bottom_pattern_list)
    public ListView chatLiveBottomPatternList;

    @BindView(R.id.fl_master_sync_control)
    public FrameLayout flMasterSyncControl;

    @BindView(R.id.iv_control_close)
    public ImageView ivControlTime;

    @BindView(R.id.iv_ldr_control)
    public ImageView ivLdrControl;

    @BindView(R.id.iv_ldr_control_states)
    public ImageView ivLdrControlStates;

    @BindView(R.id.iv_show_or_close_more)
    public ImageView ivShowOrCloseMore;

    @BindView(R.id.iv_pattern_sync)
    public ImageView ivSyncPattern;

    @BindView(R.id.ldr_master_control_layout)
    public LinearLayout ldrMasterControlLayout;

    @BindView(R.id.ldr_panel)
    public NewLDRPanel ldrPanel;

    @BindView(R.id.ldr_sensitivity)
    public SeekBar ldrSensitivity;

    @BindView(R.id.ll_be_controlled_1)
    public LinearLayout llBeControlled1;

    @BindView(R.id.ll_control_layout)
    public LinearLayout llControlLayout;

    @BindView(R.id.ll_control_time)
    public LinearLayout llControlTime;

    @BindView(R.id.ll_control_time_1)
    public LinearLayout llControlTime1;

    @BindView(R.id.ll_controlled)
    public LinearLayout llControlled;

    @BindView(R.id.ll_pattern)
    public LinearLayout llPattern;

    @BindView(R.id.ll_pattern_sync)
    public LinearLayout llSyncPattern;

    @BindView(R.id.multi_control_panel)
    public MultiControlPanel multiControlPanel;
    public oa2 p;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout patternListEmpty;
    public Handler q;
    public int r;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_self)
    public RecyclerView rvSelf;
    public ad2 s;

    @BindView(R.id.sync_ldr_layer)
    public RelativeLayout syncLdrLayer;
    public Dialog t;

    @BindView(R.id.touch_control_horizontal_bottom)
    public LinearLayout touchControlHorizontalBottom;

    @BindView(R.id.tv_control_time)
    public TextView tvControlTime;

    @BindView(R.id.tv_control_time_1)
    public TextView tvControlTime1;

    @BindView(R.id.tv_friend_name)
    public TextView tvFriendName;

    @BindView(R.id.tv_ldr_control)
    public TextView tvLdrControl;

    @BindView(R.id.tv_sync_pattern)
    public TextView tvSyncPattern;

    @BindView(R.id.tv_tochange_control_dlr)
    public TextView tvTochangeControlDlr;

    @BindView(R.id.tv_tochange_control_remote)
    public TextView tvTochangeControlRemote;
    public View u;
    public nl1 v;
    public List<Pattern> w;
    public boolean x;
    public int y;
    public boolean z;

    public class a implements nl1.b {

        /* renamed from: com.wear.main.longDistance.control.ChatSyncControl$a$a, reason: collision with other inner class name */
        public class C0129a extends ff3 {
            public final /* synthetic */ Pattern a;

            public C0129a(Pattern pattern) {
                this.a = pattern;
            }

            public static /* synthetic */ void e(Object obj, String str) {
                if (obj instanceof TextView) {
                    ((TextView) obj).setText(str);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void g() {
                ChatSyncControl.this.v.f();
            }

            @Override // dc.ff3
            public void c(boolean z, Object obj, String str) {
                if (!z || obj == null) {
                    ChatSyncControl.this.S0();
                    ChatSyncControl.this.K1();
                    ChatSyncControl.this.U(new Runnable() { // from class: dc.m92
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.g();
                        }
                    });
                } else {
                    if (TextUtils.equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase(), this.a.getToyFeature())) {
                        str = "t";
                    }
                    ChatSyncControl.this.q1(obj, str);
                }
            }

            @Override // dc.ff3
            public void d(boolean z, final Object obj, String str, final String str2, long j) {
                ChatSyncControl.this.U(new Runnable() { // from class: dc.n92
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatSyncControl.a.C0129a.e(obj, str2);
                    }
                });
            }
        }

        public a() {
        }

        @Override // dc.nl1.b
        public void a(Pattern pattern, boolean z) {
            gk2.e().l(true);
            ChatSyncControl.this.v.notifyDataSetChanged();
            qf3.B(pattern, 2, new C0129a(pattern));
        }

        @Override // dc.nl1.b
        public void b(Pattern pattern) {
            ChatSyncControl.this.S0();
            ChatSyncControl.this.K1();
            String function = pattern.getHead().getFunction();
            if (TextUtils.equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase(), pattern.getToyFeature())) {
                function = "t";
            }
            String[] strArrSplit = function.split(",");
            StringBuilder sb = new StringBuilder();
            for (String str : strArrSplit) {
                sb.append("0,");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            ChatSyncControl.this.q1(sb.toString(), function);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatSyncControl.this.y == 4) {
                return;
            }
            ChatSyncControl.this.A0(4, true);
            if (ChatSyncControl.this.K != null) {
                ChatSyncControl.this.K.h();
            }
        }
    }

    public class c implements is3.d {
        public c(ChatSyncControl chatSyncControl) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatSyncControl.this.K != null) {
                ChatSyncControl.this.K.e();
            }
            ChatSyncControl.this.multiControlPanel.U();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;

        public e(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            qf3.C();
            ua2.a();
            ChatSyncControl.this.y = this.a;
            ChatSyncControl chatSyncControl = ChatSyncControl.this;
            if ((chatSyncControl.c instanceof UserRoulette) && this.b) {
                int i = this.a;
                if (i == 3) {
                    chatSyncControl.G.h(2);
                } else if (i == 4) {
                    chatSyncControl.G.h(3);
                } else if (i == 1) {
                    chatSyncControl.G.h(1);
                }
            }
            ChatSyncControl.this.multiControlPanel.setSelectPanelVisible(this.a == 3 ? 8 : 0);
            if (this.a == 3) {
                ChatSyncControl.this.p.e = true;
                ChatSyncControl.L = true;
            } else {
                ChatSyncControl.L = false;
                ChatSyncControl.this.p.U();
            }
            ChatSyncControl chatSyncControl2 = ChatSyncControl.this;
            if (chatSyncControl2.c == 0) {
                return;
            }
            int i2 = this.a;
            if (i2 == 0) {
                chatSyncControl2.y = chatSyncControl2.b.getLiveStatus();
                ChatSyncControl.this.p.p0(this.b);
                WearUtils.x.q("chat_sync_ldr", null);
                if (((User) ChatSyncControl.this.c).isDateIng()) {
                    me3.d(me3.c.DATING_SYNC_CONTROL_NORMAL_BEGIN, me3.a());
                } else if (((User) ChatSyncControl.this.c).isControlLink()) {
                    me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_NORMAL_BEGIN, me3.a());
                } else {
                    me3.d(me3.c.PRIVATE_CHAT_SYNC_CONTROL_NORMAL_BEGIN, me3.a());
                }
            } else if (i2 == 1) {
                chatSyncControl2.b.setLiveStatus(1);
                ChatSyncControl.this.p.p0(this.b);
                ChatSyncControl.this.E1();
                if (((User) ChatSyncControl.this.c).isDateIng()) {
                    me3.d(me3.c.DATING_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
                } else if (((User) ChatSyncControl.this.c).isControlLink()) {
                    me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
                    ye3.c("control link chatroom", "begin control link sync control", ChatSyncControl.this.d);
                } else {
                    me3.d(me3.c.PRIVATE_CHAT_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
                }
            } else if (i2 == 3) {
                if (chatSyncControl2.p.g == null) {
                    chatSyncControl2.b.setLiveStatus(1);
                }
                if (((User) ChatSyncControl.this.c).isDateIng()) {
                    me3.d(me3.c.DATING_SYNC_CONTROL_SENCE_BEGIN, me3.a());
                } else if (((User) ChatSyncControl.this.c).isControlLink()) {
                    me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_SENCE_BEGIN, me3.a());
                } else {
                    me3.d(me3.c.PRIVATE_CHAT_SYNC_CONTROL_SENCE_BEGIN, me3.a());
                }
            } else if (i2 == 4) {
                chatSyncControl2.b.setLiveStatus(1);
                ChatSyncControl.this.p.p0(this.b);
                ChatSyncControl.this.E1();
                if (((User) ChatSyncControl.this.c).isDateIng()) {
                    me3.d(me3.c.DATING_SYNC_CONTROL_PATTERN_BEGIN, me3.a());
                } else if (((User) ChatSyncControl.this.c).isControlLink()) {
                    me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_PATTERN_BEGIN, me3.a());
                } else {
                    me3.d(me3.c.PRIVATE_CHAT_SYNC_CONTROL_PATTERN_BEGIN, me3.a());
                }
            }
            ChatSyncControl.this.G1(this.b);
            ChatSyncControl.this.K1();
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;

        public f(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ChatSyncControl.this.K1();
            qf3.C();
            if (this.a) {
                EntitySync entitySync = new EntitySync();
                entitySync.setType(EntitySync.SyncOPTType.swap.toString());
                T t = ChatSyncControl.this.c;
                if (t == 0 || !((User) t).isControlLink()) {
                    T t2 = ChatSyncControl.this.c;
                    if (t2 == 0 || !(t2 instanceof UserRoulette)) {
                        zb2.O().z0(((User) ChatSyncControl.this.c).getUserJid(), entitySync);
                    }
                } else {
                    dq2.w().C(entitySync, (UserControlLink) ChatSyncControl.this.c);
                }
            }
            ChatSyncControl chatSyncControl = ChatSyncControl.this;
            if (chatSyncControl.b == null) {
                chatSyncControl.b = ch3.n().u();
            }
            ChatSyncControl chatSyncControl2 = ChatSyncControl.this;
            Account account = chatSyncControl2.b;
            if (account == null) {
                return;
            }
            oa2 oa2Var = chatSyncControl2.p;
            if (oa2Var.e) {
                oa2Var.h0(false);
                oa2 oa2Var2 = ChatSyncControl.this.p;
                if (oa2Var2.g == null) {
                    if (oa2Var2.i() == 0) {
                        ChatSyncControl.this.C1();
                        ChatSyncControl.this.b.setLiveStatus(1);
                    } else {
                        ChatSyncControl.this.G0();
                        ChatSyncControl chatSyncControl3 = ChatSyncControl.this;
                        chatSyncControl3.multiControlPanel.m0(chatSyncControl3.p.i() + 1);
                        ChatSyncControl.this.b.setLiveStatus(2);
                    }
                }
            } else {
                int i = this.b;
                if (i != -1) {
                    chatSyncControl2.y = i;
                    ChatSyncControl.this.b.setLiveStatus(this.b);
                } else if (account.getLiveStatus() == 1) {
                    ChatSyncControl.this.b.setLiveStatus(2);
                    ChatSyncControl.this.y = 2;
                } else {
                    ChatSyncControl.this.b.setLiveStatus(1);
                    ChatSyncControl.this.y = 1;
                    ChatSyncControl chatSyncControl4 = ChatSyncControl.this;
                    if (chatSyncControl4.c != 0 && chatSyncControl4.A()) {
                        ChatSyncControl.this.V(ChatSyncControl.this.c instanceof UserRoulette ? String.format(ah4.e(R.string.sync_controller_notification), ah4.e(R.string.group_chat_controller)) : String.format(ah4.e(R.string.sync_controller_notification), ((User) ChatSyncControl.this.c).getShowNickName()));
                    }
                }
                ChatSyncControl.this.G1(this.a);
            }
            if (this.a) {
                ChatSyncControl chatSyncControl5 = ChatSyncControl.this;
                oa2 oa2Var3 = chatSyncControl5.p;
                if (oa2Var3.e) {
                    chatSyncControl5.L1(oa2Var3.n);
                } else {
                    chatSyncControl5.L1(chatSyncControl5.b.getLiveStatus());
                }
            }
            ChatSyncControl.this.E1();
        }
    }

    public class g implements MultiControlPanel.r {
        public g() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public /* synthetic */ void b(String str) {
            ip3.a(this, str);
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public void f(List<Ball2CurveEventBean> list) throws NumberFormatException {
            Account account = ChatSyncControl.this.b;
            if (account == null || account.getLiveStatus() == 0 || ChatSyncControl.this.b.getLiveStatus() == 2) {
                return;
            }
            ChatSyncControl chatSyncControl = ChatSyncControl.this;
            oa2 oa2Var = chatSyncControl.p;
            if ((!oa2Var.e || oa2Var.g == null) && chatSyncControl.b.getCurrentControlType() == MessageType.sync && ChatSyncControl.this.chatLiveBottomPatternLayer.getVisibility() != 0 && list.size() != 0) {
                if (ChatSyncControl.this.K != null) {
                    ChatSyncControl.this.K.k(list);
                }
                if (((User) ChatSyncControl.this.c).isControlLink()) {
                    T t = ChatSyncControl.this.c;
                    if (t instanceof UserControlLink) {
                        UserControlLink userControlLink = (UserControlLink) t;
                        if (TextUtils.equals(userControlLink.getPlatform(), "connect") || TextUtils.equals(userControlLink.getPlatform(), "vibemate") || TextUtils.equals(userControlLink.getPlatform(), "tophy")) {
                            ChatSyncControl chatSyncControl2 = ChatSyncControl.this;
                            if (chatSyncControl2.p.e) {
                                chatSyncControl2.s1(list);
                                return;
                            }
                        }
                    }
                }
                ChatSyncControl.this.o1(list);
            }
        }
    }

    public class h implements MultiControlPanel.o {
        public h() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.o
        public void a(List<MultiToyOFunBean> list, boolean z) throws Resources.NotFoundException {
            ChatSyncControl.this.E = list.size();
            ChatSyncControl.this.t1();
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public i(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatSyncControl.this.r1(this.a, this.b);
        }
    }

    public class j implements DialogInterface.OnDismissListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ChatSyncControl chatSyncControl = ChatSyncControl.this;
            chatSyncControl.t = null;
            chatSyncControl.s.a();
        }
    }

    public class k implements is3.d {
        public final /* synthetic */ ka2.l a;

        public k(ka2.l lVar) {
            this.a = lVar;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ka2.l lVar = this.a;
            if (lVar != null) {
                lVar.cancel();
            }
            ChatSyncControl.this.B();
            ChatSyncControl.this.f1(false, false);
        }
    }

    public class l implements View.OnClickListener {

        public class a implements is3.d {
            public a(l lVar) {
            }

            @Override // dc.is3.d
            public void doConfirm() {
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatSyncControl chatSyncControl = ChatSyncControl.this;
            int i = chatSyncControl.r;
            if (i == 0) {
                oa2 oa2Var = chatSyncControl.p;
                if (oa2Var.e) {
                    return;
                }
                oa2Var.b0(true);
                ChatSyncControl.this.A0(3, true);
                return;
            }
            if (i == 1) {
                sg3.l(String.format(ah4.e(R.string.dont_support_a_feature), ((User) ChatSyncControl.this.c).getShowNickName()));
                return;
            }
            is3.b bVar = new is3.b(MyApplication.H());
            bVar.p(ah4.e(R.string.Notification_sync_ldr_no_max));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new a(this));
            bVar.b(false);
            cs3.h(bVar).show();
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = ChatSyncControl.this.t;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            ChatSyncControl.this.t.dismiss();
        }
    }

    public class n implements Runnable {
        public final /* synthetic */ User a;
        public final /* synthetic */ boolean b;

        public n(User user, boolean z) {
            this.a = user;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ChatSyncControl.this.x = false;
            ChatSyncControl.this.L(this.a);
            if (this.a.isControlLink() || (this.a instanceof UserRoulette)) {
                ChatSyncControl.this.tvControlTime.setVisibility(8);
                ChatSyncControl.this.tvControlTime1.setVisibility(8);
            } else {
                ChatSyncControl.this.tvControlTime.setVisibility(0);
                ChatSyncControl.this.tvControlTime1.setVisibility(0);
            }
            ChatSyncControl.this.s.e();
            if (this.b) {
                ChatSyncControl chatSyncControl = ChatSyncControl.this;
                chatSyncControl.U0(chatSyncControl.b.getLiveStatus());
            } else {
                ChatSyncControl.this.U0(2);
            }
            ChatSyncControl.this.Y();
            T t = ChatSyncControl.this.c;
            if (t == 0) {
                return;
            }
            if (((User) t).isDateIng()) {
                me3.d(me3.c.DATING_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
            } else if (((User) ChatSyncControl.this.c).isControlLink()) {
                me3.e(me3.a.CONTROL_LINK_CHAT_SYNC_CONTROL);
                me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
                ye3.c("control link chatroom", "begin control link sync control", ChatSyncControl.this.d);
            } else {
                me3.e(me3.a.PRIVATE_CHAT_SYNC_CONTROL);
                me3.d(me3.c.PRIVATE_CHAT_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
                T t2 = ChatSyncControl.this.c;
                ye3.c((t2 == 0 || !(t2 instanceof UserRoulette)) ? "friend chatroom" : "control roulette chatroom", "begin sync control", ((User) t2).getUserJid());
            }
            sz1.d().r(((User) ChatSyncControl.this.c).isControlLink() ? 4 : 8);
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ MessageType a;

        public o(MessageType messageType) {
            this.a = messageType;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.control.ChatSyncControl.o.run():void");
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = ChatSyncControl.this.t;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            ChatSyncControl.this.t.dismiss();
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatSyncControl.this.i1();
        }
    }

    public class r implements ka2.k {
        public r() {
        }

        @Override // dc.ka2.k
        public void a() {
            ChatSyncControl.this.multiControlPanel.k0(true);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatSyncControl.this.O1(-1, true);
        }
    }

    public class t implements MultiControlPanel.n {
        public t() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.n
        public void a() {
            ChatSyncControl.this.O1(-1, true);
        }
    }

    public class u implements MultiControlPanel.m {
        public u() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.m
        public void m() {
            ChatSyncControl.this.a();
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatSyncControl.this.a();
            ChatSyncControl chatSyncControl = ChatSyncControl.this;
            T t = chatSyncControl.c;
            if (t == 0 || (t instanceof UserRoulette)) {
                return;
            }
            ye3.c(null, "end control link sync control", chatSyncControl.d);
        }
    }

    public class w implements View.OnClickListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatSyncControl.this.ivShowOrCloseMore.setEnabled(true);
            }
        }

        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            ChatSyncControl.this.z = true;
            int dimensionPixelSize = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_panel_height);
            int dimensionPixelSize2 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
            int dimensionPixelSize3 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_marbottom_height);
            ChatSyncControl.this.touchControlHorizontalBottom.setVisibility(8);
            ChatSyncControl.this.multiControlPanel.setSyncControlMode(true, dimensionPixelSize3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ChatSyncControl.this.multiControlPanel.getLayoutParams();
            if (ChatSyncControl.this.E >= 2) {
                ChatSyncControl.this.multiControlPanel.setPanelPercent(0.244008f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize3 + (dimensionPixelSize2 * 2);
            } else {
                ChatSyncControl.this.multiControlPanel.setPanelPercent(0.138957f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize2 + dimensionPixelSize3;
            }
            ChatSyncControl.this.multiControlPanel.setLayoutParams(layoutParams);
            ChatSyncControl.this.ivShowOrCloseMore.setEnabled(false);
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 500L);
        }
    }

    public class x implements MultiControlPanel.l {
        public x() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.l
        public void c() throws Resources.NotFoundException {
            ChatSyncControl.this.z = false;
            int dimensionPixelSize = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_panel_height);
            int dimensionPixelSize2 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
            int dimensionPixelSize3 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_marbottom_height);
            ChatSyncControl.this.touchControlHorizontalBottom.setVisibility(0);
            ChatSyncControl.this.multiControlPanel.setSyncControlMode(false, dimensionPixelSize3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ChatSyncControl.this.multiControlPanel.getLayoutParams();
            if (ChatSyncControl.this.E >= 2) {
                ChatSyncControl.this.multiControlPanel.setPanelPercent(0.2807f);
                layoutParams.height = dimensionPixelSize + (dimensionPixelSize2 * 2);
            } else {
                ChatSyncControl.this.multiControlPanel.setPanelPercent(0.16326f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize2;
            }
            ChatSyncControl.this.multiControlPanel.setLayoutParams(layoutParams);
        }
    }

    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatSyncControl.this.y == 1) {
                return;
            }
            ChatSyncControl.this.A0(1, true);
        }
    }

    public static class z {
        public static final ChatSyncControl a = new ChatSyncControl((a) null);
    }

    public /* synthetic */ ChatSyncControl(a aVar) {
        this();
    }

    public static ChatSyncControl N0() {
        return z.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y0(View view) {
        W0(view);
        V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a1(int i2) {
        jp3 jp3Var = this.K;
        if (jp3Var != null) {
            jp3Var.j(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c1(String str) {
        this.K.m(str);
    }

    public void A0(int i2, boolean z2) {
        U(new e(i2, z2));
    }

    public void A1(VelvoPreviewView velvoPreviewView) {
        if (velvoPreviewView == null) {
            return;
        }
        this.K = new jp3(this.multiControlPanel, velvoPreviewView, "CHAT_SYNC_CONTROL");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.q92
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.c1(str);
            }
        });
    }

    @Override // dc.ka2
    public void B() {
        this.x = true;
        this.s.b();
        T t2 = this.c;
        if (t2 != 0 && !((User) t2).isControlLink()) {
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.cancel.toString());
            entitySync.setId(gu3.j.getControlId());
            ou3.m(entitySync, this.c);
        }
        U(new m());
    }

    public final void B0() {
        int i2;
        this.multiControlPanel.setHiddenVelvoIcon(this.y == 2);
        jp3 jp3Var = this.K;
        if (jp3Var == null || (i2 = this.y) == 4) {
            return;
        }
        if (i2 == 1) {
            jp3Var.q(this.C);
        } else {
            jp3Var.e();
        }
    }

    public void B1() {
        W();
    }

    public void C0() {
        this.r = this.p.r();
    }

    public void C1() {
        if (this.ldrPanel.getVisibility() == 8) {
            this.ldrPanel.setVisibility(0);
            this.ldrPanel.e((User) this.c);
            this.C.clear();
            T t2 = this.c;
            if (t2 == 0 || !((User) t2).isControlLink()) {
                this.C.addAll(((User) this.c).getLinkedToys2());
            } else {
                this.C.addAll(((User) this.c).getCLLinkedToys2());
            }
            this.multiControlPanel.q0(this.C);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.setCurvePanelVisible(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
            layoutParams.height = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_panel_height);
            this.multiControlPanel.setLayoutParams(layoutParams);
            this.multiControlPanel.setPanelPercent(0.0f);
            this.syncLdrLayer.setVisibility(8);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.llControlLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ve0.a().getResources().getDimensionPixelOffset(R.dimen.multi_toy_ldr_margin_top);
            this.llControlLayout.setLayoutParams(layoutParams2);
            this.multiControlPanel.setMultiToysCurveShowMode(true);
            this.multiControlPanel.j0(true, true);
            this.multiControlPanel.m0(this.p.i());
        }
    }

    public void D0() {
        ka2.C(false, this.C, new r());
    }

    public void D1() {
        if (this.c instanceof UserRoulette) {
            return;
        }
        if (!this.s.c()) {
            F();
            return;
        }
        W();
        ViewGroup viewGroup = (ViewGroup) this.u.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.u);
        }
    }

    public void E0() {
        this.F.post(new d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E1() {
        E e2;
        if (!this.e || (e2 = this.f) == 0) {
            return;
        }
        e2.l(this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F0() {
        E e2 = this.f;
        if (e2 != 0) {
            e2.y(this.c);
        }
    }

    public void F1() {
        E e2 = this.f;
        if (e2 != 0) {
            e2.addViewToActivity(this.u);
            IPeopleInfo iPeopleInfo = this.c;
            if (!(iPeopleInfo instanceof UserRoulette)) {
                this.f.l(iPeopleInfo);
            }
            P1();
        }
        F();
    }

    public final void G0() {
        if (this.ldrPanel.getVisibility() == 0) {
            this.ldrPanel.setVisibility(8);
            this.C.clear();
            T t2 = this.c;
            if (t2 == 0) {
                return;
            }
            if (((User) t2).isControlLink()) {
                this.C.addAll(((User) this.c).getCLLinkedToys2());
            } else {
                this.C.addAll(((User) this.c).getLinkedToys2());
            }
            this.C.addAll((!((User) this.c).isControlLink() || this.b.isControlLinkJoiner()) ? pc1.a.P() : this.b.getControlLinkToys());
            this.multiControlPanel.q0(this.C);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.setCurvePanelVisible(0);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.llControlLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            this.llControlLayout.setLayoutParams(layoutParams);
        }
    }

    public void G1(boolean z2) throws Resources.NotFoundException {
        S0();
        int dimensionPixelSize = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_panel_height);
        ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_pattern_layer_height);
        int dimensionPixelSize2 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
        int dimensionPixelSize3 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_marbottom_height);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
        G0();
        n1();
        int i2 = this.y;
        if (i2 == 1) {
            this.multiControlPanel.setMultiToysCurveShowMode(true);
            this.multiControlPanel.j0(true, true);
            if (this.E < 2) {
                this.multiControlPanel.setPanelPercent(0.16326f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize2;
            } else {
                this.multiControlPanel.setPanelPercent(0.2807f);
                layoutParams.height = dimensionPixelSize + (dimensionPixelSize2 * 2);
            }
            this.multiControlPanel.setLayoutParams(layoutParams);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.g0();
            D0();
            this.multiControlPanel.m0(1);
            this.multiControlPanel.q0(this.C);
        } else if (i2 == 2) {
            if (this.z) {
                this.multiControlPanel.setSyncControlMode(false, dimensionPixelSize3);
                this.z = false;
            }
            this.touchControlHorizontalBottom.setVisibility(8);
            this.llControlled.setVisibility(0);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.setPanelPercent(1.0f);
            this.multiControlPanel.setMultiToysCurveShowMode(false);
            int i3 = this.E;
            if (i3 >= 5) {
                layoutParams.height = dimensionPixelSize2 * 5;
            } else if (i3 <= 2 || i3 >= 5) {
                layoutParams.height = dimensionPixelSize2 * 2 * i3;
            } else {
                layoutParams.height = (dimensionPixelSize2 * i3) + 20;
            }
            this.multiControlPanel.setLayoutParams(layoutParams);
        } else if (i2 == 3) {
            this.p.d0(z2);
        } else if (i2 == 4) {
            J0();
            this.multiControlPanel.setPanelPercent(1.0f);
            this.multiControlPanel.j0(false, true);
            this.multiControlPanel.setMultiToysCurveShowMode(true);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.g0();
            if (this.E < 2) {
                layoutParams.height = dimensionPixelSize2;
            } else {
                layoutParams.height = dimensionPixelSize2 * 2;
            }
            this.multiControlPanel.setLayoutParams(layoutParams);
        }
        if (this.y != 2) {
            this.llControlled.setVisibility(8);
            this.touchControlHorizontalBottom.setVisibility(0);
        }
        if (this.y == 4) {
            this.chatLiveBottomPatternLayer.setVisibility(0);
        } else {
            this.chatLiveBottomPatternLayer.setVisibility(8);
        }
        if (this.y == 1) {
            this.ivShowOrCloseMore.setVisibility(0);
        } else {
            this.ivShowOrCloseMore.setVisibility(8);
        }
        P1();
        B0();
    }

    public void H0() {
        if (this.multiControlPanel != null) {
            if (this.B.size() <= 0) {
                this.multiControlPanel.S(this.A);
            } else if (this.B.size() > 1) {
                this.multiControlPanel.S(this.B.remove(0));
            } else {
                this.multiControlPanel.S(this.B.get(0));
            }
        }
    }

    public void H1() {
        jp3 jp3Var;
        if (!r() || (jp3Var = this.K) == null || this.y == 2 || L) {
            return;
        }
        jp3Var.r();
    }

    public void I0(boolean z2, boolean z3) {
        EntitySync entitySync = new EntitySync();
        entitySync.setType(EntitySync.SyncOPTType.end.toString());
        entitySync.setId(gu3.j.getControlId());
        entitySync.setControlTime(K0());
        T t2 = this.c;
        if (t2 != 0) {
            if (((User) t2).isControlLink()) {
                if (z2) {
                    EventBus.getDefault().post(new ControlLinkChatControlEnd(this.d, K0(), MessageType.sync));
                }
                this.multiControlPanel.d0();
            } else {
                T t3 = this.c;
                if (t3 != 0 && (t3 instanceof UserRoulette) && z2) {
                    this.G.a();
                } else {
                    if (gu3.j.isCreate()) {
                        zb2.O().x0(entitySync, (User) this.c, this.b.getUserJid(), ((User) this.c).getUserJid());
                    } else {
                        zb2 zb2VarO = zb2.O();
                        T t4 = this.c;
                        zb2VarO.x0(entitySync, (User) t4, ((User) t4).getUserJid(), this.b.getUserJid());
                    }
                    if (z2) {
                        p1(entitySync);
                        yf3.b bVar = yf3.i;
                        bVar.a().s(RateFeature.Sync, Integer.valueOf(WearUtils.C0(K0())));
                        bVar.a().n();
                    }
                }
            }
        }
        U(new q());
        if (z2) {
            T t5 = this.c;
            if (t5 != 0 && !((User) t5).isControlLink()) {
                f1(z3, false);
            } else if (!c83.R1().P1()) {
                c83.R1().n2(2, z3 ? 1 : 0, WearUtils.C0(K0()));
            }
        }
        if (mk2.P().h0()) {
            mk2.P().n0(false);
        }
        me3.e(me3.a.OTHERS);
        T t6 = this.c;
        if (t6 == 0 || !((User) t6).isDateIng()) {
            T t7 = this.c;
            if (t7 == 0 || !((User) t7).isControlLink()) {
                me3.d(me3.c.PRIVATE_CHAT_SYNC_CONTROL_END, String.valueOf(WearUtils.C0(K0())));
                T t8 = this.c;
                if (t8 != 0 && !(t8 instanceof UserRoulette)) {
                    ye3.c(null, "ended sync control", this.d);
                }
            } else {
                me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_END, String.valueOf(WearUtils.C0(K0())));
            }
        } else {
            me3.d(me3.c.DATING_SYNC_CONTROL_END, String.valueOf(WearUtils.C0(K0())));
        }
        sz1.d().o();
    }

    public void I1(MessageType messageType) {
        U(new o(messageType));
    }

    public final void J0() {
        List<Pattern> listM = xe2.L0().m(WearUtils.y.r());
        this.w.clear();
        this.w.addAll(listM);
        this.v.notifyDataSetChanged();
    }

    public void J1(String str, ka2.l lVar) {
        this.s.f();
        is3.b bVar = new is3.b(I());
        bVar.p(str);
        bVar.o(ah4.e(R.string.common_cancel));
        bVar.k(R.layout.dialog_default_ok);
        bVar.d(new k(lVar));
        bVar.f(new j());
        is3 is3VarI = cs3.i(bVar, is3.class);
        this.t = is3VarI;
        is3VarI.show();
    }

    public String K0() {
        return (WearUtils.e1(this.tvControlTime.getText().toString()) || this.tvControlTime.getText().toString().equals("00:00")) ? "00:00" : this.tvControlTime.getText().toString();
    }

    public final void K1() {
        this.q.postDelayed(new Runnable() { // from class: dc.r92
            @Override // java.lang.Runnable
            public final void run() {
                rq1.d.q();
            }
        }, 200L);
        ou3.c();
        ou3.x((User) this.c, "v,r,p,t,s,f,d,pos", "0,0,0,0,0,0,0,0", false);
    }

    public final String L0(ArrayList<Toy> arrayList) {
        String str = "";
        for (String str2 : yg3.a(arrayList)) {
            str = str + str2 + ",";
        }
        return !TextUtils.isEmpty(str) ? str.substring(0, str.length() - 1) : PSOProgramService.VS_Key;
    }

    public void L1(int i2) {
        T t2 = this.c;
        if (t2 == 0 || !(t2 instanceof UserRoulette)) {
            return;
        }
        this.G.c(i2);
    }

    public void M1(String str) {
        T t2 = this.c;
        if (t2 == 0 || !(t2 instanceof UserRoulette)) {
            return;
        }
        this.G.f(str);
    }

    public View O0() {
        return this.u;
    }

    public void O1(int i2, boolean z2) {
        U(new f(z2, i2));
    }

    @Override // dc.ka2
    public void P() {
        T t2 = this.c;
        if (t2 == 0 || ((User) t2).getChatType() != Presence.Type.unavailable || ((User) this.c).isControlLink()) {
            return;
        }
        if (this.s.c()) {
            sg3.e(this.g, R.string.message_poor_network_webrtc);
            I0(false, true);
            return;
        }
        if (this.s.d()) {
            WearUtils.z2();
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.cancel.toString());
            entitySync.setId(gu3.j.getControlId());
            ou3.m(entitySync, this.c);
            Dialog dialog = this.t;
            if (dialog != null && dialog.isShowing()) {
                this.t.dismiss();
            }
            this.s.b();
            gu3.j.setAvailable(ControlIdBean.Status.cancel);
        }
    }

    public int P0() {
        return this.y;
    }

    public final void P1() {
        int i2 = this.y;
        if (i2 == 1) {
            this.tvTochangeControlRemote.setTextColor(th4.b(this.g, R.color.chat_sync_select));
            ce3.f(this.tvTochangeControlRemote, R.drawable.chat_toolbar_mirror_click);
            this.tvTochangeControlDlr.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvTochangeControlDlr, R.drawable.sync_longdistance);
            this.ivSyncPattern.setImageDrawable(th4.d(this.g, R.drawable.chat_toolbar_pattern));
            this.tvSyncPattern.setTextColor(th4.b(this.g, R.color.default_color));
            return;
        }
        if (i2 == 3) {
            this.tvTochangeControlRemote.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvTochangeControlRemote, R.drawable.chat_toolbar_mirror);
            this.tvTochangeControlDlr.setTextColor(th4.b(this.g, R.color.chat_sync_select));
            ce3.f(this.tvTochangeControlDlr, R.drawable.sync_longdistance_click);
            this.ivSyncPattern.setImageDrawable(th4.d(this.g, R.drawable.chat_toolbar_pattern));
            this.tvSyncPattern.setTextColor(th4.b(this.g, R.color.default_color));
            return;
        }
        if (i2 == 4) {
            this.tvTochangeControlRemote.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvTochangeControlRemote, R.drawable.chat_toolbar_mirror);
            this.tvTochangeControlDlr.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvTochangeControlDlr, R.drawable.sync_longdistance);
            this.ivSyncPattern.setImageDrawable(th4.d(this.g, R.drawable.chat_toolbar_pattern_click));
            this.tvSyncPattern.setTextColor(th4.b(this.g, R.color.chat_sync_select));
        }
    }

    @Override // dc.ka2
    public void Q(Activity activity) {
        T t2 = this.c;
        if (t2 != 0 && ((User) t2).isControlLink()) {
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
        if (!(this.c instanceof UserRoulette)) {
            if (activity instanceof ChatActivity) {
                ChatActivity chatActivity = (ChatActivity) activity;
                if (chatActivity.C() == this.c) {
                    chatActivity.V2();
                    return;
                }
            }
            pj3.j(activity, ChatActivity.class, "userId", ((User) this.c).getId());
            return;
        }
        if (activity instanceof NewChatActivity) {
            ((NewChatActivity) activity).j5();
            return;
        }
        UserJoinChatBean c2 = my2.i.a().getC();
        if (c2 != null) {
            c2.setFromOuter(true);
            NewChatActivity.n.a(activity, c2, false, false);
        }
    }

    public void Q0() {
        F();
    }

    public void Q1(int i2) {
        this.ldrPanel.n(i2);
    }

    public void R0() {
        if (this.K == null || !r()) {
            return;
        }
        this.K.e();
    }

    public void R1(String str, ToyBean toyBean, boolean z2) throws NumberFormatException {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Field field : ToyBean.class.getDeclaredFields()) {
                if (!TextUtils.equals(field.getName(), "time")) {
                    field.setAccessible(true);
                    int iIntValue = ((Integer) field.get(toyBean)).intValue();
                    if (iIntValue != -1) {
                        arrayList.add(field.getName());
                        arrayList2.add(String.valueOf(iIntValue));
                    }
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList.size()]);
            this.p.n0(str, strArr, strArr2);
            S1(str, strArr, strArr2, z2);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void S0() {
        this.B.clear();
        this.A.clear();
        if (TextUtils.isEmpty(this.D)) {
            this.D = PSOProgramService.VS_Key;
        }
        for (String str : this.D.split(",")) {
            str.hashCode();
            switch (str) {
                case "d":
                    this.A.add(new Ball2CurveEventBean("", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, String.valueOf(0)));
                    break;
                case "f":
                    this.A.add(new Ball2CurveEventBean("", "f", String.valueOf(0)));
                    break;
                case "p":
                    this.A.add(new Ball2CurveEventBean("", "p", String.valueOf(0)));
                    break;
                case "r":
                    this.A.add(new Ball2CurveEventBean("", StreamManagement.AckRequest.ELEMENT, String.valueOf(0)));
                    break;
                case "s":
                    this.A.add(new Ball2CurveEventBean("", "s", String.valueOf(0)));
                    break;
                case "t":
                    this.A.add(new Ball2CurveEventBean("", "t", String.valueOf(0)));
                    break;
                case "v":
                    this.A.add(new Ball2CurveEventBean("", PSOProgramService.VS_Key, String.valueOf(0)));
                    break;
                case "pos":
                    this.A.add(new Ball2CurveEventBean("", "pos", String.valueOf(0)));
                    break;
            }
        }
        this.B.add(this.A);
    }

    public void S1(String str, String[] strArr, String[] strArr2, boolean z2) throws NumberFormatException {
        if (this.ldrPanel.getVisibility() == 0 && this.p.i() == 0) {
            this.ldrPanel.t(str, strArr, strArr2, z2);
        }
    }

    public final void T0() {
        ViewGroup viewGroup = (ViewGroup) this.u.getParent();
        if (viewGroup == null || (this.c instanceof UserRoulette)) {
            return;
        }
        viewGroup.removeView(this.u);
    }

    public void T1(boolean z2) {
        int i2 = this.r;
        if (i2 == 0) {
            if (this.p.e) {
                return;
            }
            A0(3, z2);
        } else {
            if (i2 == 1) {
                sg3.l(String.format(ah4.e(R.string.dont_support_a_feature), ((User) this.c).getShowNickName()));
                return;
            }
            is3.b bVar = new is3.b(MyApplication.H());
            bVar.p(ah4.e(R.string.Notification_sync_ldr_no_max));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new c(this));
            bVar.b(false);
            cs3.h(bVar).show();
        }
    }

    public void U0(int i2) throws Resources.NotFoundException {
        this.i = 0;
        this.y = i2;
        this.b.setLiveStatus(i2);
        this.C.clear();
        T t2 = this.c;
        if (t2 == 0) {
            return;
        }
        if (((User) t2).isControlLink()) {
            this.C.addAll(((User) this.c).getCLLinkedToys2());
        } else {
            this.C.addAll(((User) this.c).getLinkedToys2());
        }
        this.C.addAll((!((User) this.c).isControlLink() || this.b.isControlLinkJoiner()) ? pc1.a.P() : this.b.getControlLinkToys());
        String strL0 = L0(this.C);
        this.D = strL0;
        String[] strArrSplit = strL0.split(",");
        this.E = 3;
        if (strArrSplit != null && strArrSplit.length > 0 && strArrSplit.length < 3) {
            this.E = strArrSplit.length;
        }
        S0();
        this.multiControlPanel.O(true, "CHAT_SYNC_CONTROL", this.C, Integer.MAX_VALUE, ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height));
        this.multiControlPanel.setControlLink(((User) this.c).isControlLink() || (this.c instanceof UserRoulette));
        w1();
        this.p.o(this.c);
        pc1.a.F();
        this.p.e = false;
        L = false;
        LDRControl.p = ((User) this.c).isSupportSolaceTapButtonControl();
        C0();
        G1(false);
    }

    public final void V0() {
        nl1 nl1Var = new nl1(this.w, this.g, R.layout.item_group_control_pattern);
        this.v = nl1Var;
        this.chatLiveBottomPatternList.setAdapter((ListAdapter) nl1Var);
        this.v.g(new a());
    }

    public final void W0(View view) {
        IPeopleInfo iPeopleInfo;
        this.u = view;
        ButterKnife.bind(this, view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        d0(this.g, R.drawable.full_control_sync, "sync.json");
        oa2 oa2Var = new oa2(this, this.syncLdrLayer, this.u);
        this.p = oa2Var;
        if (oa2Var.c == null && (iPeopleInfo = this.c) != null) {
            oa2Var.o(iPeopleInfo);
        }
        this.chatLiveBottomPatternList.setEmptyView(this.patternListEmpty);
        v1();
    }

    @Override // dc.ra2
    public void a() {
        I0(true, false);
    }

    public void e1(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || this.c == 0) {
            return;
        }
        if (!r()) {
            F();
        } else if (((User) this.c).getId().equals(iPeopleInfo.getId())) {
            F1();
        } else {
            D1();
        }
    }

    public void f0(User user, boolean z2) {
        U(new n(user, z2));
    }

    public final void f1(boolean z2, boolean z3) {
        g1(z2, z3, (User) this.c);
    }

    @Override // dc.na2.b
    public void g() {
        MultiControlPanel multiControlPanel;
        if (r()) {
            int i2 = this.i + 1;
            this.i = i2;
            String strQ = WearUtils.Q(i2);
            this.tvControlTime.setText(strQ);
            this.tvControlTime1.setText(strQ);
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(strQ);
            }
            if (!this.z || (multiControlPanel = this.multiControlPanel) == null) {
                return;
            }
            multiControlPanel.setControlTimer(strQ);
        }
    }

    public final void g1(boolean z2, boolean z3, User user) {
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
        jSONObject.put("controller_type", (Object) 2);
        jSONObject.put("control_type", (Object) (L ? "11" : "12"));
        jSONObject.put("control_end_type", (Object) Integer.valueOf(z3 ? 5 : this.x ? 4 : z2 ? 1 : 0));
        jSONObject.put("control_duration", (Object) Integer.valueOf(WearUtils.C0(K0())));
        jSONObject.put("control_id", (Object) gu3.j.getControlId());
        ye3.d("F0013", jSONObject.toString());
    }

    public void h1(boolean z2, boolean z3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g1(z2, z3, ch3.n().v(WearUtils.X(str)));
    }

    public void i1() {
        this.z = false;
        ou3.w(this.c);
        zb2.O().R0();
        Account account = this.b;
        if (account != null) {
            account.setCurrentControlType(null);
            this.b.setLiveStatus(0);
            this.b.setLiveFriendId(null);
        }
        T t2 = this.c;
        if (t2 != 0 && !((User) t2).isControlLink()) {
            ((User) this.c).setSupportLdrTouchPanel(false);
            ((User) this.c).setSupportLDRFillOrder(false);
            ((User) this.c).setSupportSolaceTapButtonControl(false);
        }
        this.p.p0(false);
        this.p.f();
        this.ldrPanel.b();
        qf3.C();
        gk2.e().l(false);
        K1();
        this.g.G().W(0);
        gu3.j.setAvailable(ControlIdBean.Status.end);
        pc1.a.I();
        this.s.b();
        F0();
        T0();
        E();
        E0();
        G();
    }

    public void j1(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        ChatSyncControl chatSyncControl = this;
        if (i3 == TouchControlView.Q) {
            return;
        }
        String str = "receiveToyMsg: v=" + i2 + "  r=" + i3 + "  p=" + i4 + "  t=" + i5 + "  s=" + i6 + "  f=" + i7 + "  d=" + i8 + "  pos=" + i9;
        ArrayList arrayList = new ArrayList();
        int i12 = i2 < 0 ? 0 : i2 * 5;
        int i13 = i3 < 0 ? 0 : i3 * 5;
        int iCeil = i4 < 0 ? 0 : (int) Math.ceil(i4 * 33.3d);
        int i14 = i5 < 0 ? 0 : i5 * 5;
        int i15 = i6 < 0 ? 0 : i6 * 5;
        int i16 = i7 < 0 ? 0 : i7 * 5;
        int i17 = i8 < 0 ? 0 : i8 * 5;
        int iMax = Math.max(i9, 0);
        String[] strArrSplit = chatSyncControl.D.split(",");
        int length = strArrSplit.length;
        int i18 = 0;
        while (i18 < length) {
            String str2 = strArrSplit[i18];
            str2.hashCode();
            String[] strArr = strArrSplit;
            int i19 = length;
            int i20 = i18;
            i10 = i17;
            i11 = i16;
            switch (str2) {
                case "d":
                    arrayList.add(new Ball2CurveEventBean("", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, String.valueOf(i10)));
                    break;
                case "f":
                    arrayList.add(new Ball2CurveEventBean("", "f", String.valueOf(i11)));
                    break;
                case "p":
                    arrayList.add(new Ball2CurveEventBean("", "p", String.valueOf(iCeil)));
                    break;
                case "r":
                    arrayList.add(new Ball2CurveEventBean("", StreamManagement.AckRequest.ELEMENT, String.valueOf(i13)));
                    break;
                case "s":
                    arrayList.add(new Ball2CurveEventBean("", "s", String.valueOf(i15)));
                    break;
                case "t":
                    arrayList.add(new Ball2CurveEventBean("", "t", String.valueOf(i14)));
                    break;
                case "v":
                    arrayList.add(new Ball2CurveEventBean("", PSOProgramService.VS_Key, String.valueOf(i12)));
                    break;
                case "pos":
                    arrayList.add(new Ball2CurveEventBean("", "pos", String.valueOf(iMax)));
                    break;
            }
            i18 = i20 + 1;
            chatSyncControl = this;
            strArrSplit = strArr;
            length = i19;
            i17 = i10;
            i16 = i11;
        }
        chatSyncControl.B.add(arrayList);
    }

    @Override // dc.na2.b
    public void k() {
        if (r() && !this.p.e) {
            int i2 = this.y;
            if (i2 == 2 || i2 == 4) {
                H0();
            }
        }
    }

    public void k1(MessageType messageType) {
        U(new p());
    }

    public void l1() {
        e0();
    }

    public void m1() {
        this.p.M();
    }

    public void n1() {
        String[] strArrSplit = this.D.split(",");
        this.E = 3;
        if (strArrSplit != null && strArrSplit.length > 0 && strArrSplit.length < 3) {
            this.E = strArrSplit.length;
        }
        this.multiControlPanel.Z();
    }

    public final void o1(List<Ball2CurveEventBean> list) throws NumberFormatException {
        String function = "";
        String groups = "";
        boolean z2 = false;
        for (Ball2CurveEventBean ball2CurveEventBean : list) {
            if (ball2CurveEventBean != null) {
                if (!WearUtils.e1(ball2CurveEventBean.getFunction())) {
                    function = WearUtils.e1(function) ? ball2CurveEventBean.getFunction() : function + "," + ball2CurveEventBean.getFunction();
                }
                if (!WearUtils.e1(ball2CurveEventBean.getGroups())) {
                    groups = WearUtils.e1(groups) ? ball2CurveEventBean.getGroups() : groups + "," + ball2CurveEventBean.getGroups();
                }
                if (ball2CurveEventBean.isRotateChange()) {
                    ball2CurveEventBean.getToyAddress();
                    z2 = true;
                }
            }
        }
        if (!z2 && !function.contains(PSOProgramService.VS_Key)) {
            function = "v," + function;
            groups = "0," + groups;
        }
        String strChangeSinglefuncLineToTayValue = Toy.changeSinglefuncLineToTayValue(function, groups);
        boolean zA = ou3.a(function, strChangeSinglefuncLineToTayValue);
        if (z2) {
            ou3.c();
        }
        if (zA || z2) {
            if (z2) {
                function = "r,";
                groups = "-2,";
            }
            if (this.p.e) {
                S1(null, function.split(","), strChangeSinglefuncLineToTayValue.split(","), true);
            } else {
                vg3.b().a(new i(function, groups));
            }
            ou3.x((User) this.c, function, strChangeSinglefuncLineToTayValue, z2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        if (!r() || MyApplication.P) {
            return;
        }
        I0(true, true);
    }

    public void p1(DataEntityAbstract dataEntityAbstract) {
        T t2 = this.c;
        if (t2 != 0 && ((User) t2).isControlLink()) {
            dq2.w().C(dataEntityAbstract, (UserControlLink) this.c);
        } else {
            if (this.c instanceof UserRoulette) {
                return;
            }
            zb2.O().z0(((User) this.c).getUserJid(), dataEntityAbstract);
        }
    }

    public void q1(Object obj, String str) {
        if (this.b.getLiveStatus() == 1 && !this.p.e && r() && this.chatLiveBottomPatternLayer.getVisibility() == 0) {
            String str2 = "发送数据param====" + str;
            String[] strArrB = ou3.B(str.split(","), obj == null ? "0" : obj.toString());
            Toy.changeToyValueToSinglefuncLine(str, obj.toString());
            String str3 = "playPattern: " + Arrays.toString(strArrB);
            if (strArrB == null || strArrB.length != 2) {
                return;
            }
            String str4 = strArrB[0];
            String string = strArrB[1];
            if (str4.equals("pos")) {
                y1(str4, string);
            } else if (string.length() >= str4.length()) {
                x1(str4, string);
            }
            String[] strArrSplit = str4.split(",");
            String[] strArrSplit2 = string.split(",");
            int i2 = 0;
            while (true) {
                if (i2 >= strArrSplit.length) {
                    i2 = -1;
                    break;
                } else if (strArrSplit[i2].equals("pos")) {
                    break;
                } else {
                    i2++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (i2 != -1) {
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    if (i3 == i2) {
                        sb.append(Integer.parseInt(strArrSplit2[i3]) * 5);
                        sb.append(",");
                    } else {
                        sb.append(strArrSplit2[i3]);
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            User user = (User) this.c;
            if (sb.length() > 0) {
                string = sb.toString();
            }
            ou3.x(user, str4, string, false);
        }
    }

    @Override // dc.ra2
    public boolean r() {
        return this.s.c();
    }

    public final void r1(String str, String str2) {
        Account account;
        String[] strArrSplit = str.split(",");
        String[] strArrSplit2 = str2.split(",");
        if (strArrSplit.length == strArrSplit2.length) {
            T t2 = this.c;
            if (t2 == 0 || !((User) t2).isControlLink() || (account = this.b) == null || account.isControlLinkJoiner()) {
                if (mp1.h()) {
                    rq1.d.d(Arrays.asList(strArrSplit), Arrays.asList(strArrSplit2), new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SETTING_ONLY));
                    return;
                } else {
                    pc1.a.c0(strArrSplit, strArrSplit2, true, true);
                    return;
                }
            }
            Iterator<Toy> it = this.b.getControlLinkToys().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (WearUtils.e1(next.getAddress()) && this.g.G().R(next.getId()) != null) {
                    next.setAddress(this.g.G().R(next.getId()).getAddress());
                }
                if (!WearUtils.e1(next.getAddress())) {
                    if (mp1.h()) {
                        rq1.d.o(next.getAddress(), Arrays.asList(strArrSplit), Arrays.asList(strArrSplit2), new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SETTING_ONLY));
                    } else {
                        pc1.a.n0(next, strArrSplit, strArrSplit2, true, true, true);
                    }
                }
            }
        }
    }

    public final void s1(List<Ball2CurveEventBean> list) throws NumberFormatException {
        ArrayList<Toy> cLLinkedToys2 = ((User) this.c).getCLLinkedToys2();
        if (cLLinkedToys2 == null || cLLinkedToys2.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Toy toy : cLLinkedToys2) {
            Ball2CurveEventBean ball2CurveEventBean = new Ball2CurveEventBean(toy.getDeviceId());
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            String toyFunction = Toy.getToyFunction(toy.getType());
            for (Ball2CurveEventBean ball2CurveEventBean2 : list) {
                if (ball2CurveEventBean2 != null && toyFunction.contains(ball2CurveEventBean2.getFunction())) {
                    sb.append(ball2CurveEventBean2.getFunction());
                    sb.append(",");
                    sb2.append(ball2CurveEventBean2.getGroups());
                    sb2.append(",");
                    if (ball2CurveEventBean2.isRotateChange()) {
                        ball2CurveEventBean.setRotateChange(ball2CurveEventBean2.isRotateChange());
                    }
                }
            }
            String strSubstring = sb.substring(0, sb.length() - 1);
            String strChangeSinglefuncLineToTayValue = Toy.changeSinglefuncLineToTayValue(strSubstring, sb2.substring(0, sb2.length() - 1));
            if (ou3.b(toy.getDeviceId(), strChangeSinglefuncLineToTayValue, "") || ball2CurveEventBean.isRotateChange()) {
                ball2CurveEventBean.setFunction(strSubstring);
                ball2CurveEventBean.setGroups(strChangeSinglefuncLineToTayValue);
                arrayList.add(ball2CurveEventBean);
                S1(null, strSubstring.split(","), strChangeSinglefuncLineToTayValue.split(","), true);
            }
        }
        if (arrayList.size() > 0) {
            ou3.r((User) this.c, MessageType.live, arrayList);
        }
    }

    public final void t1() throws Resources.NotFoundException {
        int dimensionPixelSize = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_panel_height);
        int dimensionPixelSize2 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
        int dimensionPixelSize3 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_marbottom_height);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
        if (this.y == 1) {
            if (this.z) {
                if (this.E < 2) {
                    this.multiControlPanel.setPanelPercent(0.138957f);
                    layoutParams.height = dimensionPixelSize + dimensionPixelSize2 + dimensionPixelSize3;
                } else {
                    this.multiControlPanel.setPanelPercent(0.244008f);
                    layoutParams.height = dimensionPixelSize + dimensionPixelSize3 + (dimensionPixelSize2 * 2);
                }
            } else if (this.E < 2) {
                this.multiControlPanel.setPanelPercent(0.16326f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize2;
            } else {
                this.multiControlPanel.setPanelPercent(0.2807f);
                layoutParams.height = dimensionPixelSize + (dimensionPixelSize2 * 2);
            }
            this.multiControlPanel.setLayoutParams(layoutParams);
        }
    }

    public void u1() {
        this.p.Y();
    }

    public final void v1() {
        this.tvTochangeControlDlr.setOnClickListener(new l());
        this.llBeControlled1.setOnClickListener(new s());
        this.multiControlPanel.setSwitchControlListener(new t());
        this.multiControlPanel.setEndControlListener(new u());
        v vVar = new v();
        this.llControlTime.setOnClickListener(vVar);
        this.llControlTime1.setOnClickListener(vVar);
        this.ivShowOrCloseMore.setOnClickListener(new w());
        this.multiControlPanel.setControShowMorelListener(new x());
        this.tvTochangeControlRemote.setOnClickListener(new y());
        this.llSyncPattern.setOnClickListener(new b());
    }

    public final void w1() {
        this.multiControlPanel.X(new g());
        this.multiControlPanel.setToyChangeListener(new h());
    }

    public final void x1(String str, String str2) {
        ToyCommandBean toyCommandBean = new ToyCommandBean();
        toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
        toyCommandBean.setAllFunc(str, str2, false);
        String str3 = "发送数据tag====" + str;
        String str4 = "发送数据group====" + str2;
        ToyBean all = toyCommandBean.getAll();
        if (all.getV1() != -1 && all.getV() == -1) {
            all.setV(all.getV1());
        }
        if (all != null) {
            j1(all.getV(), all.getR(), all.getP(), all.getT(), all.getS(), all.getF(), all.getD(), all.getPos());
            String str5 = "发送数据====" + all.getV() + "," + all.getR() + "," + all.getP() + "," + all.getT() + "," + all.getS() + "," + all.getF() + "," + all.getD() + "," + all.getPos();
        }
    }

    public final void y1(String str, String str2) {
        ToyCommandBean toyCommandBean = new ToyCommandBean();
        toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
        toyCommandBean.setAllFunc(str, str2, false);
        ToyBean all = toyCommandBean.getAll();
        if (all != null) {
            final int pos = all.getPos() != -1 ? all.getPos() * 5 : -1;
            j1(all.getV(), all.getR(), all.getP(), all.getT(), all.getS(), all.getF(), all.getD(), pos);
            String str3 = "发送数据====" + all.getV() + "," + all.getR() + "," + all.getP() + "," + all.getT() + "," + all.getS() + "," + all.getF() + "," + all.getD() + "," + pos;
            U(new Runnable() { // from class: dc.o92
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a1(pos);
                }
            });
        }
    }

    @Override // dc.ka2
    public boolean z() {
        return this.s.c() || this.s.d();
    }

    public void z1(va2 va2Var) {
        this.G = va2Var;
    }

    public ChatSyncControl() {
        this(LayoutInflater.from(WearUtils.x).inflate(R.layout.view_sync_control, (ViewGroup) null));
    }

    public ChatSyncControl(final View view) {
        this.q = new Handler(Looper.getMainLooper());
        this.s = new ad2();
        getClass().getSimpleName();
        this.w = new ArrayList();
        this.y = 0;
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList<>();
        this.F = new Handler(Looper.getMainLooper());
        this.b = ch3.n().u();
        this.g = WearUtils.x;
        U(new Runnable() { // from class: dc.p92
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Y0(view);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetworkInfoEvent networkInfoEvent) {
        if (!r() || networkInfoEvent.isAvailable) {
            return;
        }
        I0(false, true);
        sg3.h(R.string.message_poor_network_webrtc);
    }
}
