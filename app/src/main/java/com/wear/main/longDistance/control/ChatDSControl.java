package com.wear.main.longDistance.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.DsControlBoardAllAdapter;
import com.wear.adapter.longdistance.DsControlBoardOneLineAdapter;
import com.wear.adapter.longdistance.GroupDSPatternAdapter;
import com.wear.adapter.longdistance.GroupToysBatteryAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.Pattern;
import com.wear.bean.RateFeature;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.BallToysComBean;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.bean.controlmutlitoys.ToyDSLocalEvent;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.handlerbean.item.FootUser;
import com.wear.bean.socketio.msg.Order;
import com.wear.bean.socketio.msg.response.AckCreateMultiToOneInfoResponse;
import com.wear.bean.socketio.msg.response.DSAckPlayerJoinMultiToOneResponse;
import com.wear.bean.socketio.msg.response.DSGroupInfoBean;
import com.wear.bean.socketio.msg.response.DSMultiToOneIsEndResponse;
import com.wear.bean.socketio.msg.response.DSMultiToySelectChangeResponse;
import com.wear.bean.socketio.msg.response.DSPlayerListBean;
import com.wear.bean.socketio.msg.response.DSPlayerListChangeResponse;
import com.wear.bean.socketio.msg.response.DSPlayerRefuseMultiToOneInviteResponse;
import com.wear.bean.socketio.msg.response.DSTargeterRefuseInviteResponse;
import com.wear.bean.socketio.msg.response.DSTargeterToyChangeResponse;
import com.wear.bean.socketio.msg.response.DSYouCatPlayingMultiToOneResponse;
import com.wear.bean.socketio.msg.response.DsMultiToOneIsStarNowResponse;
import com.wear.bean.socketio.msg.response.DsSomebodyCreateMultiToOneResponse;
import com.wear.bean.socketio.msg.response.MasterLineStatusNotifyResponse;
import com.wear.bean.socketio.msg.response.ReceiveMultiToOneControlInviteV2Response;
import com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest;
import com.wear.bean.socketio.msg.reuqest.MultiToOneToyOrderRequest;
import com.wear.bean.socketio.msg.reuqest.RoomSendDSRequest;
import com.wear.bean.socketio.msg.reuqest.RoomSendDSToysSelRequest;
import com.wear.bean.socketio.msg.reuqest.TargeterUpdateControlTimeRequest;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.AutoLineFeedLayoutManager;
import com.wear.widget.ChatDSControlBottomControlView;
import com.wear.widget.control.TouchControlView;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.dialog.GroupControlMemberInfoDialog;
import com.wear.widget.dialog.GroupDSWaitAccpetDialog;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.ce3;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.dk2;
import dc.ek2;
import dc.ff3;
import dc.fk2;
import dc.gg3;
import dc.gu3;
import dc.gv1;
import dc.h12;
import dc.h32;
import dc.hu3;
import dc.ip3;
import dc.is3;
import dc.jp3;
import dc.ka2;
import dc.la2;
import dc.me3;
import dc.mf2;
import dc.mk2;
import dc.mp1;
import dc.my2;
import dc.na2;
import dc.ob2;
import dc.og3;
import dc.ou3;
import dc.pc1;
import dc.pd3;
import dc.pj3;
import dc.qa2;
import dc.qf3;
import dc.rn3;
import dc.rq1;
import dc.sg3;
import dc.sz1;
import dc.th4;
import dc.uf2;
import dc.wb2;
import dc.xc1;
import dc.xe2;
import dc.xe3;
import dc.xz1;
import dc.y12;
import dc.ye3;
import dc.yf3;
import dc.zb2;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import skin.support.widget.SkinCompatTextView;

/* JADX WARN: Unexpected interfaces in signature: [dc.tz1, com.wear.adapter.longdistance.DsControlBoardOneLineAdapter$b] */
@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class ChatDSControl extends la2<Group, gv1> implements Object, Object, BaseAdapter.b<IPeopleInfo> {
    public HashMap<String, Order> A;
    public HashMap<String, Order> B;
    public List<Toy> C;
    public Dialog D;
    public boolean E;
    public ArrayList<Pattern> F;
    public GroupMember G;
    public GroupMember K;
    public long L;
    public long M;
    public DsControlBoardAllAdapter N;
    public boolean O;
    public boolean P;
    public int Q;
    public List<BaseBallBean> R;
    public is3 S;
    public GroupToysBatteryAdapter T;
    public GroupToysBatteryAdapter U;
    public View V;
    public Toy W;
    public boolean X;
    public Handler Y;
    public java.util.regex.Pattern Z;
    public jp3 a0;
    public boolean b0;

    @BindView(R.id.fl_wait_control_and_ed_parent)
    public View flWaitControlAndEdParent;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.iv_pattern_list_close)
    public ImageView ivPatternListClose;

    @BindView(R.id.ldr_sensitivity_layout)
    public LinearLayout ldrSensitivityLayout;

    @BindView(R.id.ll_control_layout)
    public RelativeLayout llControlLayout;

    @BindView(R.id.ll_expand)
    public LinearLayout llExpand;

    @BindView(R.id.ll_pattern)
    public RelativeLayout llPattern;

    @BindView(R.id.ll_real_control_ed)
    public LinearLayout llRealControlEd;

    @BindView(R.id.ll_setting_time)
    public LinearLayout llSettingTime;

    @BindView(R.id.ll_wait_control)
    public LinearLayout llWaitControl;

    @BindView(R.id.ll_wait_control_and_ed)
    public LinearLayout llWaitControlAndEd;

    @BindView(R.id.control_group_ds_multicontrolpanel)
    public MultiControlPanel multiControlPanel;
    public boolean p;
    public Handler q;
    public ArrayList<IPeopleInfo> r;

    @BindView(R.id.rv_pattern)
    public RecyclerView rvPattern;

    @BindView(R.id.rv_people)
    public RecyclerView rvPeople;

    @BindView(R.id.rv_people_all)
    public RecyclerView rvPeopleAll;
    public ArrayList<IPeopleInfo> s;

    @BindView(R.id.sb_change_time)
    public SeekBar sbChangeTime;
    public int t;

    @BindView(R.id.touch_control_horizontal_bottom)
    public ChatDSControlBottomControlView touchControlHorizontalBottom;

    @BindView(R.id.ll_toy_info_expand_recyclerview)
    public RecyclerView toysInfoExpandRecyclerView;

    @BindView(R.id.ll_toy_info_recyclerview)
    public RecyclerView toysInfoRecyclerView;

    @BindView(R.id.touch_control_horizontal_bottom_line)
    public TextView tvBottomLine;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_control_time)
    public TextView tvControlTime;

    @BindView(R.id.tv_control_time_ed)
    public TextView tvControlTimeEd;

    @BindView(R.id.tv_controled_time)
    public TextView tvControledTime;

    @BindView(R.id.tv_ds_pattern)
    public TextView tvDsPattern;

    @BindView(R.id.tv_name)
    public TextView tvName;

    @BindView(R.id.tv_next)
    public TextView tvNext;

    @BindView(R.id.tv_next_1)
    public TextView tvNext1;

    @BindView(R.id.tv_next_control)
    public TextView tvNextControl;

    @BindView(R.id.tv_ok)
    public TextView tvOk;

    @BindView(R.id.tv_pattern_empty)
    public TextView tvPatternEmpty;

    @BindView(R.id.tv_select_time)
    public TextView tvSelectTime;

    @BindView(R.id.tv_stop_1)
    public TextView tvStop1;

    @BindView(R.id.tv_sub_user_name)
    public TextView tvSubUserName;

    @BindView(R.id.tv_wait_control_numb)
    public TextView tvWaitControlNumb;

    @BindView(R.id.tv_wait_control_tip)
    public TextView tvWaitControlTip;
    public boolean u;

    @BindView(R.id.user_img)
    public RoundedImageView userImg;

    @BindView(R.id.user_img_expand)
    public RoundedImageView userImgExpand;
    public boolean v;

    @BindView(R.id.v_sub_margin_view)
    public View vSubMarginView;
    public GroupDSPatternAdapter w;
    public wb2 x;
    public DsControlBoardOneLineAdapter y;
    public MultiToOneToyOrderRequest z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.t1(chatDSControl.B, true);
            if (ChatDSControl.this.X) {
                if (ChatDSControl.this.o1() == 2 || ChatDSControl.this.o1() == 3) {
                    ChatDSControl.this.Y.postDelayed(this, 100L);
                }
            }
        }
    }

    public class a0 implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public class a extends BaseGroupControlRequest {
            public a() {
            }

            @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
            public String getAction() {
                return a0.this.a ? "REFUSE_MULTI_TO_ONE_INVITE" : "PLAYER_REFUSE_MULTI_TO_ONE_INVITE";
            }
        }

        public a0(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a();
            aVar.setRoomId(this.b);
            aVar.setAckId(WearUtils.E());
            ChatDSControl.this.x.a(aVar, null);
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.v = false;
            chatDSControl.D = null;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl.this.X = true;
            List<Toy> list = ChatDSControl.this.C;
            if (list != null && list.size() > 0) {
                for (Toy toy : ChatDSControl.this.C) {
                    if (!ChatDSControl.this.B.containsKey(toy.getDeviceId())) {
                        Order order = new Order();
                        order.resetZero();
                        ChatDSControl.this.B.put(toy.getDeviceId(), order);
                    }
                }
            }
            ChatDSControl.this.Y.postDelayed(this.a, 0L);
        }
    }

    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.p = false;
            Dialog dialog = chatDSControl.D;
            if (dialog != null) {
                if (dialog instanceof GroupDSWaitAccpetDialog) {
                    if (((GroupDSWaitAccpetDialog) dialog).i) {
                        chatDSControl.f2("GIVE_UP_CONTROL_MULTI_TO_ONE", null);
                        EntitySystem entitySystem = new EntitySystem();
                        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C328.toString(), null);
                        ChatDSControl.this.e2(entitySystem, MessageType.system);
                    }
                    Dialog dialog2 = ChatDSControl.this.D;
                    if (dialog2 != null && dialog2.isShowing()) {
                        ChatDSControl.this.D.dismiss();
                    }
                    ChatDSControl.this.V1();
                } else if (dialog != null && dialog.isShowing()) {
                    ChatDSControl.this.D.dismiss();
                }
            }
            ChatDSControl.this.o2(false);
        }
    }

    public class c implements GroupControlMemberInfoDialog.b {
        public c(ChatDSControl chatDSControl) {
        }

        @Override // com.wear.widget.dialog.GroupControlMemberInfoDialog.b
        public void a(GroupMember groupMember) {
        }
    }

    public class c0 implements MultiControlPanel.r {
        public c0() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public /* synthetic */ void b(String str) {
            ip3.a(this, str);
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public void f(List<Ball2CurveEventBean> list) {
            ChatDSControl.this.h1(list);
        }
    }

    public class d implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Group b;

        public d(Activity activity, Group group) {
            this.a = activity;
            this.b = group;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.v = false;
            chatDSControl.D = null;
            try {
                ((NotificationManager) this.a.getSystemService("notification")).cancel(this.b.getId().hashCode() + "", this.b.getId().hashCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d0 implements MultiControlPanel.l {
        public d0() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.l
        public void c() throws Resources.NotFoundException {
            ChatDSControl.this.E2(false);
        }
    }

    public class e implements is3.d {
        public final /* synthetic */ ReceiveMultiToOneControlInviteV2Response a;
        public final /* synthetic */ Activity b;

        public e(ReceiveMultiToOneControlInviteV2Response receiveMultiToOneControlInviteV2Response, Activity activity) {
            this.a = receiveMultiToOneControlInviteV2Response;
            this.b = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            Dialog dialog = ChatDSControl.this.D;
            if (dialog != null) {
                dialog.dismiss();
            }
            MusicControl.h0().S();
            y12.c.a().t();
            ChatDSControl.this.f2("AGREE_MULTI_TO_ONE_INVITE", null);
            me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
            me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
            ye3.c("friend chatroom", "begin group D&S control", this.a.getRoomId());
            sz1.d().r(8);
            ChatDSControl.this.v = false;
            pj3.j(this.b, ChatRoomActivity.class, "roomId", this.a.getRoomId());
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
            Activity activity = this.b;
            if (activity instanceof RemoteMultiControlActivity) {
                ((RemoteMultiControlActivity) activity).C4();
            } else if (activity instanceof ChatRoomActivity) {
                ((ChatRoomActivity) activity).N6();
            }
        }
    }

    public class e0 implements MultiControlPanel.m {
        public e0() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.m
        public void m() {
            ChatDSControl.this.g1();
        }
    }

    public class f implements is3.c {
        public f() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            ChatDSControl.this.B();
            ChatDSControl.this.f2("REFUSE_MULTI_TO_ONE_INVITE", null);
        }
    }

    public class f0 implements MultiControlPanel.q {
        public f0() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.q
        public void a(List<BaseBallBean> list) {
            ChatDSControl.this.c2(list, true);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<IPeopleInfo> it = ChatDSControl.this.r.iterator();
            while (it.hasNext()) {
                if (((GroupMember) it.next()).getDSStatus() == 0) {
                    it.remove();
                }
            }
            Dialog dialog = ChatDSControl.this.D;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            Dialog dialog2 = ChatDSControl.this.D;
            if (dialog2 instanceof GroupDSWaitAccpetDialog) {
                ((GroupDSWaitAccpetDialog) dialog2).r();
            }
        }
    }

    public class g0 implements Runnable {
        public g0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl.this.m1(ChatDSControl.this.I(), false, false);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ Group a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ GroupMember c;
        public final /* synthetic */ DsSomebodyCreateMultiToOneResponse d;
        public final /* synthetic */ boolean e;

        public class a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ Activity a;

            public a(Activity activity) {
                this.a = activity;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ChatDSControl chatDSControl = ChatDSControl.this;
                chatDSControl.v = false;
                chatDSControl.D = null;
                try {
                    ((NotificationManager) this.a.getSystemService("notification")).cancel(h.this.a.getId().hashCode() + "", h.this.a.getId().hashCode());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public class b implements is3.d {
            public final /* synthetic */ Activity a;

            public class a implements mf2 {
                public a() {
                }

                @Override // dc.mf2
                public void Q(String str) {
                    DSAckPlayerJoinMultiToOneResponse dSAckPlayerJoinMultiToOneResponse = (DSAckPlayerJoinMultiToOneResponse) JSON.parseObject(str, DSAckPlayerJoinMultiToOneResponse.class);
                    ChatDSControl chatDSControl = ChatDSControl.this;
                    chatDSControl.G = ((Group) chatDSControl.c).getMemberByJid(dSAckPlayerJoinMultiToOneResponse.getTargeter().getJid());
                    ChatDSControl chatDSControl2 = ChatDSControl.this;
                    chatDSControl2.y1(chatDSControl2.G, dSAckPlayerJoinMultiToOneResponse.getTargeter().getToyJson());
                    ChatDSControl chatDSControl3 = ChatDSControl.this;
                    chatDSControl3.K = ((Group) chatDSControl3.c).getMemberByJid(dSAckPlayerJoinMultiToOneResponse.getCurrentPlayerJid());
                    ChatDSControl.this.M = dSAckPlayerJoinMultiToOneResponse.getEveryoneHaveControlTime();
                    b bVar = b.this;
                    pj3.j(bVar.a, ChatRoomActivity.class, "roomId", h.this.d.getRoomId());
                    if (mk2.P().h0()) {
                        mk2.P().n0(true);
                    }
                    Activity activity = b.this.a;
                    if (activity instanceof RemoteMultiControlActivity) {
                        ((RemoteMultiControlActivity) activity).C4();
                    } else if (activity instanceof ChatRoomActivity) {
                        ((ChatRoomActivity) activity).N6();
                    }
                    me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
                    me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
                    ye3.c("friend chatroom", "begin group D&S control", h.this.d.getRoomId());
                    sz1.d().r(8);
                }

                @Override // dc.mf2
                public void a(Throwable th) {
                }
            }

            public b(Activity activity) {
                this.a = activity;
            }

            @Override // dc.is3.d
            public void doConfirm() {
                Dialog dialog = ChatDSControl.this.D;
                if (dialog != null) {
                    dialog.dismiss();
                }
                MusicControl.h0().S();
                y12.c.a().t();
                ChatDSControl.this.f2("PLAYER_JOIN_MULTI_TO_ONE", new a());
                ChatDSControl.this.v = false;
            }
        }

        public class c implements is3.c {
            public c() {
            }

            @Override // dc.is3.c
            public void doCancel() {
                ChatDSControl.this.B();
                ChatDSControl.this.f2("PLAYER_REFUSE_MULTI_TO_ONE_INVITE", null);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IPeopleInfo> it = ChatDSControl.this.r.iterator();
                while (it.hasNext()) {
                    if (((GroupMember) it.next()).getDSStatus() == 0) {
                        it.remove();
                    }
                }
                Dialog dialog = ChatDSControl.this.D;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                Dialog dialog2 = ChatDSControl.this.D;
                if (dialog2 instanceof GroupDSWaitAccpetDialog) {
                    ((GroupDSWaitAccpetDialog) dialog2).r();
                }
            }
        }

        public h(Group group, ArrayList arrayList, GroupMember groupMember, DsSomebodyCreateMultiToOneResponse dsSomebodyCreateMultiToOneResponse, boolean z) {
            this.a = group;
            this.b = arrayList;
            this.c = groupMember;
            this.d = dsSomebodyCreateMultiToOneResponse;
            this.e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH == null) {
                return;
            }
            ChatDSControl.this.L(this.a);
            ChatDSControl.this.x1(this.b);
            GroupDSWaitAccpetDialog.g gVar = new GroupDSWaitAccpetDialog.g();
            gVar.a = ChatDSControl.this.r;
            gVar.b = this.c;
            gVar.c = this.d.getRoomId();
            ChatDSControl.this.v = true;
            is3.b bVar = new is3.b(fragmentActivityH);
            bVar.e(gVar);
            bVar.h(true);
            bVar.x(ce3.a(fragmentActivityH, 311.0f));
            bVar.c(new c());
            bVar.d(new b(fragmentActivityH));
            bVar.f(new a(fragmentActivityH));
            ChatDSControl.this.D = cs3.i(bVar, GroupDSWaitAccpetDialog.class);
            ChatDSControl.this.D.show();
            if (this.e) {
                ChatDSControl.this.q.postDelayed(new d(), 3000L);
            }
            ((GroupDSWaitAccpetDialog) ChatDSControl.this.D).setNotice(false, this.a.getMemberByJid(this.d.getCreatorJid()).getShowNickName());
        }
    }

    public class h0 implements MultiControlPanel.p {
        public h0() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.p
        public void a(List<BaseBallBean> list) {
            ChatDSControl.this.c2(list, true);
        }
    }

    public class i implements mf2 {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ DsSomebodyCreateMultiToOneResponse b;

        public i(Activity activity, DsSomebodyCreateMultiToOneResponse dsSomebodyCreateMultiToOneResponse) {
            this.a = activity;
            this.b = dsSomebodyCreateMultiToOneResponse;
        }

        @Override // dc.mf2
        public void Q(String str) {
            DSAckPlayerJoinMultiToOneResponse dSAckPlayerJoinMultiToOneResponse = (DSAckPlayerJoinMultiToOneResponse) JSON.parseObject(str, DSAckPlayerJoinMultiToOneResponse.class);
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.G = ((Group) chatDSControl.c).getMemberByJid(dSAckPlayerJoinMultiToOneResponse.getTargeter().getJid());
            ChatDSControl chatDSControl2 = ChatDSControl.this;
            chatDSControl2.y1(chatDSControl2.G, dSAckPlayerJoinMultiToOneResponse.getTargeter().getToyJson());
            ChatDSControl chatDSControl3 = ChatDSControl.this;
            chatDSControl3.K = ((Group) chatDSControl3.c).getMemberByJid(dSAckPlayerJoinMultiToOneResponse.getCurrentPlayerJid());
            ChatDSControl.this.M = dSAckPlayerJoinMultiToOneResponse.getEveryoneHaveControlTime();
            pj3.j(this.a, ChatRoomActivity.class, "roomId", this.b.getRoomId());
            me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
            me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
            ye3.c("friend chatroom", "begin group D&S control", this.b.getRoomId());
            sz1.d().r(8);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            th.printStackTrace();
        }
    }

    public class i0 implements Runnable {
        public final /* synthetic */ DSMultiToySelectChangeResponse a;

        public i0(DSMultiToySelectChangeResponse dSMultiToySelectChangeResponse) {
            this.a = dSMultiToySelectChangeResponse;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            String str;
            ChatDSControl chatDSControl = ChatDSControl.this;
            if (chatDSControl.c == 0 || (str = chatDSControl.d) == null || !str.equals(this.a.getRoomId())) {
                return;
            }
            if (ChatDSControl.this.a0 != null) {
                ChatDSControl.this.a0.l(true);
            }
            ChatDSControl.this.multiControlPanel.n0(this.a.getListBalls());
            int dimensionPixelSize = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
            ArrayList arrayList = new ArrayList();
            for (DSMultiToySelectChangeResponse.BallSelectBean ballSelectBean : this.a.getListBalls()) {
                if (ballSelectBean.getIsSelect() == 1 && !arrayList.contains(ballSelectBean.getDeviceId())) {
                    arrayList.add(ballSelectBean.getDeviceId());
                }
            }
            int size = arrayList.size();
            int i = size >= 1 ? size > 2 ? 2 : size : 1;
            ChatDSControl.this.multiControlPanel.setPanelChildHeight(0, dimensionPixelSize, i, 1.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ChatDSControl.this.multiControlPanel.getLayoutParams();
            layoutParams.height = dimensionPixelSize * i;
            ChatDSControl.this.multiControlPanel.setLayoutParams(layoutParams);
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ DSYouCatPlayingMultiToOneResponse a;

        public j(DSYouCatPlayingMultiToOneResponse dSYouCatPlayingMultiToOneResponse) {
            this.a = dSYouCatPlayingMultiToOneResponse;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            Dialog dialog = ChatDSControl.this.D;
            if (dialog != null && dialog.isShowing()) {
                ChatDSControl.this.D.dismiss();
            }
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.G = ((Group) chatDSControl.c).getMemberByJid(this.a.getTargeter().getJid());
            ChatDSControl chatDSControl2 = ChatDSControl.this;
            chatDSControl2.K = ((Group) chatDSControl2.c).getMemberByJid(this.a.getCurrentPlayerJid());
            ChatDSControl.this.M = this.a.getEveryoneHaveControlTime().intValue();
            ChatDSControl.this.L = (this.a.getPlayerRemainTime().longValue() / 1000) + 1;
            if (ChatDSControl.this.D2()) {
                return;
            }
            ArrayList<Toy> toys = ChatDSControl.this.G.getToys();
            if (toys.size() <= 0) {
                return;
            }
            if (!ChatDSControl.this.r()) {
                me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
                me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
                ye3.c("friend chatroom", "begin group D&S control", this.a.getRoomId());
                sz1.d().r(8);
            }
            ChatDSControl.this.p2(1);
            ArrayList arrayList = new ArrayList();
            for (DSPlayerListBean dSPlayerListBean : this.a.getPlayerList()) {
                GroupMember memberByJid = ((Group) ChatDSControl.this.c).getMemberByJid(dSPlayerListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setDSStatus(dSPlayerListBean.getStatus().intValue());
                    arrayList.add(memberByJid);
                }
            }
            ChatDSControl.this.v1(arrayList);
            ChatDSControl chatDSControl3 = ChatDSControl.this;
            if (chatDSControl3.C == null) {
                chatDSControl3.C = new ArrayList();
            }
            ChatDSControl.this.C.clear();
            ChatDSControl.this.C.addAll(toys);
            ChatDSControl.this.n2();
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
            ChatDSControl.this.B1();
            ChatDSControl.this.t2();
        }
    }

    public class j0 implements mf2 {
        public final /* synthetic */ GroupDsControlSelectDomsPeopleActivity.d a;

        public j0(ChatDSControl chatDSControl, GroupDsControlSelectDomsPeopleActivity.d dVar) {
            this.a = dVar;
        }

        @Override // dc.mf2
        public void Q(String str) {
            AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse = (AckCreateMultiToOneInfoResponse) JSON.parseObject(str, AckCreateMultiToOneInfoResponse.class);
            if (ackCreateMultiToOneInfoResponse.getStatus() > 2) {
                GroupDsControlSelectDomsPeopleActivity.d dVar = this.a;
                if (dVar != null) {
                    dVar.a(ackCreateMultiToOneInfoResponse);
                    return;
                }
                return;
            }
            GroupDsControlSelectDomsPeopleActivity.d dVar2 = this.a;
            if (dVar2 != null) {
                dVar2.c(ackCreateMultiToOneInfoResponse);
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            GroupDsControlSelectDomsPeopleActivity.d dVar = this.a;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl.this.F1();
            ChatDSControl.this.w1();
        }
    }

    public class k0 implements is3.c {
        public k0() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            ChatDSControl.this.B();
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ DsMultiToOneIsStarNowResponse a;

        public l(DsMultiToOneIsStarNowResponse dsMultiToOneIsStarNowResponse) {
            this.a = dsMultiToOneIsStarNowResponse;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            Dialog dialog = ChatDSControl.this.D;
            if (dialog != null && dialog.isShowing()) {
                ChatDSControl.this.D.dismiss();
            }
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.G = ((Group) chatDSControl.c).getMemberByJid(this.a.getTargeter().getJid());
            if (ChatDSControl.this.D2()) {
                return;
            }
            ArrayList<Toy> toys = ChatDSControl.this.G.getToys();
            if (toys.size() <= 0) {
                return;
            }
            ChatDSControl chatDSControl2 = ChatDSControl.this;
            chatDSControl2.K = ((Group) chatDSControl2.c).getMemberByJid(this.a.getCurrentPlayerJid());
            ChatDSControl.this.M = this.a.getEveryoneHaveControlTime().intValue();
            ChatDSControl.this.p2(2);
            me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
            me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
            ye3.c("friend chatroom", "begin group D&S control", this.a.getRoomId());
            sz1.d().r(8);
            ChatDSControl chatDSControl3 = ChatDSControl.this;
            if (chatDSControl3.C == null) {
                chatDSControl3.C = new ArrayList();
            }
            ChatDSControl.this.C.clear();
            ChatDSControl.this.C.addAll(toys);
            ArrayList arrayList = new ArrayList();
            for (DSPlayerListBean dSPlayerListBean : this.a.getPlayerList()) {
                GroupMember memberByJid = ((Group) ChatDSControl.this.c).getMemberByJid(dSPlayerListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setDSStatus(dSPlayerListBean.getStatus().intValue());
                    arrayList.add(memberByJid);
                }
            }
            ChatDSControl.this.v1(arrayList);
            ChatDSControl.this.L = (this.a.getPlayerRemainTime().longValue() / 1000) + 1;
            ChatDSControl.this.n2();
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
            ChatDSControl.this.B1();
            ChatDSControl.this.t2();
        }
    }

    public class l0 implements Runnable {
        public l0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<IPeopleInfo> it = ChatDSControl.this.r.iterator();
            while (it.hasNext()) {
                if (((GroupMember) it.next()).getDSStatus() == 0) {
                    it.remove();
                }
            }
            Dialog dialog = ChatDSControl.this.D;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            Dialog dialog2 = ChatDSControl.this.D;
            if (dialog2 instanceof GroupDSWaitAccpetDialog) {
                ((GroupDSWaitAccpetDialog) dialog2).r();
            }
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ DSPlayerListChangeResponse a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ChatDSControl.this.R == null || ChatDSControl.this.R.size() <= 0) {
                    return;
                }
                ChatDSControl chatDSControl = ChatDSControl.this;
                chatDSControl.c2(chatDSControl.R, false);
            }
        }

        public m(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
            this.a = dSPlayerListChangeResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatDSControl.this.c == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (DSPlayerListBean dSPlayerListBean : this.a.getPlayerList()) {
                GroupMember memberByJid = ((Group) ChatDSControl.this.c).getMemberByJid(dSPlayerListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setDSStatus(dSPlayerListBean.getStatus().intValue());
                    arrayList.add(memberByJid);
                }
            }
            if (this.a.isStart()) {
                ChatDSControl chatDSControl = ChatDSControl.this;
                chatDSControl.K = ((Group) chatDSControl.c).getMemberByJid(this.a.getCurrentPlayerJid());
                ChatDSControl.this.L = (this.a.getPlayerRemainTime() / 1000) + 1;
                ChatDSControl.this.M = this.a.getEveryoneHaveControlTime();
                ChatDSControl.this.tvSelectTime.setText(String.format(ah4.e(R.string.ds_waiting_panel_duration_tip), WearUtils.Q(ChatDSControl.this.M / 1000)));
                ChatDSControl.this.v2();
                ChatDSControl.this.v1(arrayList);
            }
            ChatDSControl chatDSControl2 = ChatDSControl.this;
            if (chatDSControl2.t == 1) {
                chatDSControl2.q.postDelayed(new a(), 500L);
            }
        }
    }

    public class m0 implements DialogInterface.OnDismissListener {
        public m0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ChatDSControl chatDSControl = ChatDSControl.this;
            chatDSControl.D = null;
            chatDSControl.o2(false);
        }
    }

    public class n implements Runnable {
        public final /* synthetic */ MasterLineStatusNotifyResponse a;

        public n(MasterLineStatusNotifyResponse masterLineStatusNotifyResponse) {
            this.a = masterLineStatusNotifyResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl.this.O = this.a.isOnLine();
            ChatDSControl.this.v2();
            int i = ChatDSControl.this.t;
        }
    }

    public class n0 implements SeekBar.OnSeekBarChangeListener {
        public n0() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            String str = "onProgressChanged: " + i;
            ChatDSControl.this.tvControledTime.setText(WearUtils.I0((i + 1) * 10));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ DSTargeterToyChangeResponse a;

        public o(DSTargeterToyChangeResponse dSTargeterToyChangeResponse) {
            this.a = dSTargeterToyChangeResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            boolean z3;
            if (ChatDSControl.this.G.getJid().equals(this.a.getJid())) {
                ChatDSControl chatDSControl = ChatDSControl.this;
                chatDSControl.y1(chatDSControl.G, this.a.getToyJson());
                ArrayList<Toy> toys = ChatDSControl.this.G.getToys();
                ChatDSControl chatDSControl2 = ChatDSControl.this;
                if (chatDSControl2.t != 1 || chatDSControl2.O) {
                    if (toys.size() <= 0) {
                        for (Toy toy : ChatDSControl.this.C) {
                            ChatDSControl.this.multiControlPanel.p0(toy.getDeviceId(), false);
                            ChatDSControl.this.multiControlPanel.o0(toy.getDeviceId(), toy.getBattery());
                        }
                        return;
                    }
                    ChatDSControl chatDSControl3 = ChatDSControl.this;
                    if (chatDSControl3.C == null) {
                        chatDSControl3.C = new ArrayList();
                    }
                    ArrayList<Toy> arrayList = new ArrayList();
                    ArrayList<Toy> arrayList2 = new ArrayList();
                    for (Toy toy2 : ChatDSControl.this.C) {
                        Iterator<Toy> it = toys.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (toy2.getDeviceId().equals(it.next().getDeviceId())) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3) {
                            arrayList2.add(toy2);
                            toy2.setStatus(1);
                        } else {
                            arrayList.add(toy2);
                            toy2.setStatus(-1);
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (Toy toy3 : arrayList) {
                            ChatDSControl.this.multiControlPanel.p0(toy3.getDeviceId(), false);
                            ChatDSControl.this.multiControlPanel.o0(toy3.getDeviceId(), toy3.getBattery());
                        }
                    }
                    if (arrayList2.size() > 0) {
                        for (Toy toy4 : arrayList2) {
                            ChatDSControl.this.multiControlPanel.p0(toy4.getDeviceId(), true);
                            ChatDSControl.this.multiControlPanel.o0(toy4.getDeviceId(), toy4.getBattery());
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<Toy> it2 = toys.iterator();
                    while (it2.hasNext()) {
                        Toy next = it2.next();
                        Iterator<Toy> it3 = ChatDSControl.this.C.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (next.getDeviceId().equals(it3.next().getDeviceId())) {
                                z2 = true;
                                break;
                            }
                        }
                        if (!z2) {
                            arrayList3.add(next);
                            ChatDSControl.this.k2(next);
                        }
                    }
                    if (arrayList3.size() > 0) {
                        ChatDSControl.this.C.addAll(arrayList3);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ChatDSControl.this.b.setLiveStatus(1);
                        ChatDSControl.this.C1(false);
                        ChatDSControl chatDSControl4 = ChatDSControl.this;
                        chatDSControl4.multiControlPanel.r0(chatDSControl4.C, false);
                    }
                    ChatDSControl chatDSControl5 = ChatDSControl.this;
                    if (chatDSControl5.C == null || chatDSControl5.T == null || ChatDSControl.this.U == null) {
                        return;
                    }
                    ChatDSControl.this.t2();
                }
            }
        }
    }

    public class o0 implements GroupDSPatternAdapter.b {

        public class a extends ff3 {

            /* renamed from: com.wear.main.longDistance.control.ChatDSControl$o0$a$a, reason: collision with other inner class name */
            public class RunnableC0127a implements Runnable {
                public RunnableC0127a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    rq1.d.q();
                    ChatDSControl.this.m2();
                }
            }

            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ChatDSControl.this.w.C();
                }
            }

            public class c implements Runnable {
                public final /* synthetic */ String a;

                public c(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    TextView textView;
                    if (WearUtils.e1(this.a) || !qf3.a || (textView = ChatDSControl.this.w.j) == null) {
                        return;
                    }
                    textView.setText(this.a);
                }
            }

            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void f(Toy toy) {
                Order order;
                if (ChatDSControl.this.a0 == null || (order = ChatDSControl.this.A.get(toy.getDeviceId())) == null) {
                    return;
                }
                ChatDSControl.this.a0.j(order.getPos());
            }

            @Override // dc.ff3
            public void c(boolean z, Object obj, String str) {
                if (!z || obj == null) {
                    ChatDSControl.this.m2();
                    ChatDSControl.this.q.postDelayed(new RunnableC0127a(), 500L);
                    ChatDSControl.this.U(new b());
                    return;
                }
                if (ChatDSControl.this.o1() == 1 && ChatDSControl.this.E) {
                    ou3.B(str.split(","), obj == null ? "0" : obj.toString());
                    String strChangeToyValueToSinglefuncLine = Toy.changeToyValueToSinglefuncLine(str, obj.toString());
                    ChatDSControl.this.A.clear();
                    List<Toy> list = ChatDSControl.this.C;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    for (final Toy toy : ChatDSControl.this.C) {
                        ChatDSControl.this.i1(toy.getDeviceId(), str, strChangeToyValueToSinglefuncLine, false, true);
                        if (toy.isBAToy()) {
                            ChatDSControl.this.U(new Runnable() { // from class: dc.q82
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.f(toy);
                                }
                            });
                        }
                    }
                    ChatDSControl chatDSControl = ChatDSControl.this;
                    chatDSControl.z.setOrder(JSON.toJSONString(chatDSControl.A));
                    String str2 = "ds pattern发送播放指令=" + ChatDSControl.this.z.toString();
                    ChatDSControl chatDSControl2 = ChatDSControl.this;
                    chatDSControl2.x.d(chatDSControl2.z);
                }
            }

            @Override // dc.ff3
            public void d(boolean z, Object obj, String str, String str2, long j) {
                ChatDSControl.this.U(new c(str2));
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                rq1.d.q();
                ChatDSControl.this.m2();
            }
        }

        public o0() {
        }

        @Override // com.wear.adapter.longdistance.GroupDSPatternAdapter.b
        public void a(Pattern pattern) {
            qf3.B(pattern, 1, new a());
        }

        @Override // com.wear.adapter.longdistance.GroupDSPatternAdapter.b
        public void onPause() {
            rq1.d.q();
            ChatDSControl.this.m2();
            ChatDSControl.this.q.postDelayed(new b(), 500L);
        }
    }

    public class p implements Runnable {
        public final /* synthetic */ DSPlayerListChangeResponse a;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                ChatDSControl chatDSControl = ChatDSControl.this;
                chatDSControl.Q(chatDSControl.I());
            }
        }

        public p(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
            this.a = dSPlayerListChangeResponse;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0138  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 388
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.control.ChatDSControl.p.run():void");
        }
    }

    public static class p0 {
        public static final ChatDSControl a = new ChatDSControl(null);
    }

    public class q implements Runnable {
        public final /* synthetic */ DSPlayerRefuseMultiToOneInviteResponse a;

        public class a implements Runnable {
            public final /* synthetic */ GroupMember a;

            public a(GroupMember groupMember) {
                this.a = groupMember;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getDSStatus() == 3) {
                    ChatDSControl.this.r.remove(this.a);
                    Dialog dialog = ChatDSControl.this.D;
                    if (dialog == null || !dialog.isShowing()) {
                        return;
                    }
                    Dialog dialog2 = ChatDSControl.this.D;
                    if (dialog2 instanceof GroupDSWaitAccpetDialog) {
                        ((GroupDSWaitAccpetDialog) dialog2).r();
                    }
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ GroupMember a;

            public b(GroupMember groupMember) {
                this.a = groupMember;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getDSStatus() == 3) {
                    ChatDSControl.this.r.remove(this.a);
                    ChatDSControl.this.v1(null);
                }
            }
        }

        public q(DSPlayerRefuseMultiToOneInviteResponse dSPlayerRefuseMultiToOneInviteResponse) {
            this.a = dSPlayerRefuseMultiToOneInviteResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMember memberByJid;
            Dialog dialog;
            GroupMember memberByJid2;
            ChatDSControl chatDSControl = ChatDSControl.this;
            if (!chatDSControl.p && ((dialog = chatDSControl.D) == null || !dialog.isShowing() || !(ChatDSControl.this.D instanceof GroupDSWaitAccpetDialog))) {
                if (ChatDSControl.this.k1(this.a.getRoomId()) || (memberByJid2 = ((Group) ChatDSControl.this.c).getMemberByJid(this.a.getJid())) == null) {
                    return;
                }
                memberByJid2.setDSStatus(3);
                if (ChatDSControl.this.r.contains(memberByJid2)) {
                    ChatDSControl.this.q.postDelayed(new b(memberByJid2), 3000L);
                }
                DsControlBoardOneLineAdapter dsControlBoardOneLineAdapter = ChatDSControl.this.y;
                if (dsControlBoardOneLineAdapter != null) {
                    dsControlBoardOneLineAdapter.notifyDataSetChanged();
                }
                if (ChatDSControl.this.N != null) {
                    ChatDSControl.this.N.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (ChatDSControl.this.k1(this.a.getRoomId()) || (memberByJid = ((Group) ChatDSControl.this.c).getMemberByJid(this.a.getJid())) == null) {
                return;
            }
            memberByJid.setDSStatus(3);
            if (ChatDSControl.this.r.contains(memberByJid)) {
                ChatDSControl.this.q.postDelayed(new a(memberByJid), 3000L);
            }
            Dialog dialog2 = ChatDSControl.this.D;
            if (dialog2 == null || !dialog2.isShowing()) {
                return;
            }
            Dialog dialog3 = ChatDSControl.this.D;
            if (dialog3 instanceof GroupDSWaitAccpetDialog) {
                GroupDSWaitAccpetDialog groupDSWaitAccpetDialog = (GroupDSWaitAccpetDialog) dialog3;
                if (groupDSWaitAccpetDialog.isShowing()) {
                    groupDSWaitAccpetDialog.r();
                }
            }
        }
    }

    public class r extends BaseGroupControlRequest {
        public r(ChatDSControl chatDSControl) {
        }

        @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
        public String getAction() {
            return "PLAYER_JOIN_MULTI_TO_ONE";
        }
    }

    public class s implements ka2.k {
        public s() {
        }

        @Override // dc.ka2.k
        public void a() {
            ChatDSControl.this.multiControlPanel.k0(true);
        }
    }

    public class t implements Runnable {
        public final /* synthetic */ boolean a;

        public t(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl.this.P = this.a;
        }
    }

    public class u extends BaseGroupControlRequest {
        public final /* synthetic */ String a;

        public u(ChatDSControl chatDSControl, String str) {
            this.a = str;
        }

        @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
        public String getAction() {
            return this.a;
        }
    }

    public class v implements is3.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Activity b;

        public v(boolean z, Activity activity) {
            this.a = z;
            this.b = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pc1.a.I();
            if (ChatDSControl.this.r()) {
                ChatDSControl.this.a();
                if (this.a) {
                    this.b.finish();
                }
            }
        }
    }

    public class w extends BaseGroupControlRequest {
        public final /* synthetic */ String a;

        public w(ChatDSControl chatDSControl, String str) {
            this.a = str;
        }

        @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
        public String getAction() {
            return this.a;
        }
    }

    public class x implements mf2 {
        public x() {
        }

        @Override // dc.mf2
        public void Q(String str) throws Resources.NotFoundException {
            ChatDSControl chatDSControl = ChatDSControl.this;
            E e = chatDSControl.f;
            if (e != 0) {
                ((gv1) e).r3(chatDSControl.c, false);
            }
            DSGroupInfoBean dSGroupInfoBean = (DSGroupInfoBean) JSON.parseObject(str, DSGroupInfoBean.class);
            if (dSGroupInfoBean.isStart()) {
                ChatDSControl.this.p2(0);
                if (dSGroupInfoBean.getTargeter().getJid().equals(ch3.n().p())) {
                    ChatDSControl.this.p2(2);
                } else if (dSGroupInfoBean.getCurrentPlayerJid().equals(ch3.n().p())) {
                    ChatDSControl.this.p2(1);
                } else {
                    int i = 0;
                    while (true) {
                        if (i >= dSGroupInfoBean.getPlayerList().size()) {
                            break;
                        }
                        if (dSGroupInfoBean.getPlayerList().get(i).getJid().equals(ch3.n().p())) {
                            ChatDSControl.this.p2(3);
                            break;
                        }
                        i++;
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (DSPlayerListBean dSPlayerListBean : dSGroupInfoBean.getPlayerList()) {
                    GroupMember memberByJid = ((Group) ChatDSControl.this.c).getMemberByJid(dSPlayerListBean.getJid());
                    if (memberByJid != null) {
                        memberByJid.setDSStatus(dSPlayerListBean.getStatus().intValue());
                        arrayList.add(memberByJid);
                    }
                }
                if (arrayList.size() <= 0) {
                    ChatDSControl.this.p2(0);
                    return;
                }
                na2.m().f();
                ChatDSControl chatDSControl2 = ChatDSControl.this;
                chatDSControl2.G = ((Group) chatDSControl2.c).getMemberByJid(dSGroupInfoBean.getTargeter().getJid());
                ChatDSControl chatDSControl3 = ChatDSControl.this;
                chatDSControl3.y1(chatDSControl3.G, dSGroupInfoBean.getTargeter().getToyJson());
                ChatDSControl chatDSControl4 = ChatDSControl.this;
                chatDSControl4.K = ((Group) chatDSControl4.c).getMemberByJid(dSGroupInfoBean.getCurrentPlayerJid());
                ChatDSControl.this.v1(arrayList);
                ChatDSControl.this.M = dSGroupInfoBean.getEveryoneHaveControlTime();
                ChatDSControl.this.L = (dSGroupInfoBean.getPlayerRemainTime() / 1000) + 1;
                ArrayList<Toy> toys = ChatDSControl.this.G.getToys();
                if (toys.size() <= 0) {
                    return;
                }
                ChatDSControl chatDSControl5 = ChatDSControl.this;
                if (chatDSControl5.C == null) {
                    chatDSControl5.C = new ArrayList();
                }
                ChatDSControl.this.C.clear();
                ChatDSControl.this.C.addAll(toys);
                ChatDSControl.this.n2();
                ChatDSControl.this.B1();
                ChatDSControl.this.t2();
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ChatDSControl chatDSControl = ChatDSControl.this;
            E e = chatDSControl.f;
            if (e != 0) {
                ((gv1) e).r3(chatDSControl.c, false);
            }
        }
    }

    public class y implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public y(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WearUtils.e1(this.a) || WearUtils.e1(this.b) || TextUtils.isEmpty(this.c)) {
                return;
            }
            if (this.a.split(TouchControlView.O).length == this.b.split(TouchControlView.O).length) {
                HashMap map = new HashMap();
                map.put(this.c, this.b);
                ChatDSControl.this.multiControlPanel.L(map);
            }
        }
    }

    public class z implements Runnable {
        public final /* synthetic */ boolean a;

        public z(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatDSControl.this.llControlLayout.setVisibility(8);
            ChatDSControl chatDSControl = ChatDSControl.this;
            E e = chatDSControl.f;
            if (e != 0) {
                ((gv1) e).l2(chatDSControl.c);
                ((gv1) ChatDSControl.this.f).M0();
            }
            ViewGroup viewGroup = (ViewGroup) ChatDSControl.this.V.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(ChatDSControl.this.V);
            }
            qf3.C();
            if (ChatDSControl.this.r()) {
                me3.d(me3.c.GROUP_CHAT_DS_CONTROL_END, String.valueOf(ChatDSControl.this.i));
                ChatDSControl chatDSControl2 = ChatDSControl.this;
                int i = chatDSControl2.t;
                if (i == 2) {
                    ye3.c(null, "exit group D&S control", ((Group) chatDSControl2.c).getId());
                } else if (i == 1) {
                    ye3.c(null, "end group D&S control", ((Group) chatDSControl2.c).getId());
                }
                me3.e(me3.a.OTHERS);
            }
            if (this.a) {
                yf3.b bVar = yf3.i;
                bVar.a().s(RateFeature.GroupDS, Integer.valueOf(ChatDSControl.this.i));
                bVar.a().n();
            }
            ChatDSControl.this.p2(0);
            rq1.d.q();
            sz1.d().o();
            ChatDSControl.this.u1();
            ChatDSControl.this.E();
            ChatDSControl.this.E = false;
            ChatDSControl.this.F.clear();
            ChatDSControl.this.O = true;
            ChatDSControl.this.P = true;
            ChatDSControl.this.Q = 0;
            ChatDSControl.this.M = 3000L;
            ChatDSControl.this.r.clear();
            ChatDSControl.this.G();
            if (mk2.P().h0()) {
                mk2.P().n0(false);
            }
            ChatDSControl.this.multiControlPanel.U();
            try {
                if (ChatDSControl.this.S != null && ChatDSControl.this.S.isShowing()) {
                    ChatDSControl.this.S.dismiss();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ChatDSControl.this.S = null;
        }
    }

    public /* synthetic */ ChatDSControl(k kVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(Group group, ArrayList arrayList, GroupMember groupMember, ReceiveMultiToOneControlInviteV2Response receiveMultiToOneControlInviteV2Response, boolean z2, boolean z3) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        L(group);
        x1(arrayList);
        GroupDSWaitAccpetDialog.g gVar = new GroupDSWaitAccpetDialog.g();
        gVar.a = this.r;
        gVar.b = groupMember;
        gVar.c = receiveMultiToOneControlInviteV2Response.getRoomId();
        this.v = true;
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.e(gVar);
        bVar.h(true);
        bVar.x(ce3.a(fragmentActivityH, 311.0f));
        bVar.c(new f());
        bVar.d(new e(receiveMultiToOneControlInviteV2Response, fragmentActivityH));
        bVar.f(new d(fragmentActivityH, group));
        is3 is3VarI = cs3.i(bVar, GroupDSWaitAccpetDialog.class);
        this.D = is3VarI;
        is3VarI.show();
        ye3.c(null, "get group D&S control", group.getId());
        if (z2) {
            this.q.postDelayed(new g(), 3000L);
        }
        ((GroupDSWaitAccpetDialog) this.D).setNotice(z3, group.getMemberByJid(receiveMultiToOneControlInviteV2Response.getCreatorJid()).getShowNickName());
    }

    public static /* synthetic */ void O1() {
        MusicControl.h0().S();
        y12.c.a().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(String str) {
        this.a0.m(str);
    }

    public static /* synthetic */ void R1() {
        MusicControl.h0().S();
        y12.c.a().t();
    }

    public static void d2(Toy toy, Order order) {
        if (order == null) {
            return;
        }
        ek2 ek2VarC = fk2.a.c(toy.getAddress());
        if (qa2.a()) {
            pc1.a.d0(toy, order.getT(), false, true);
            return;
        }
        if (ek2VarC == ek2.POSITION) {
            dk2.a.e(toy.getAddress(), order.getPos(), true);
        } else {
            if (ek2VarC != ek2.SPEED || order.getT() == -1) {
                return;
            }
            pc1.a.d0(toy, order.getT(), false, true);
        }
    }

    public static ChatDSControl r1() {
        return p0.a;
    }

    public void A1(String str) {
        z1();
    }

    public void A2() {
        jp3 jp3Var;
        if (r() && (jp3Var = this.a0) != null && this.b0) {
            if (this.t != 1) {
                jp3Var.l(true);
            } else {
                jp3Var.r();
            }
        }
    }

    @Override // dc.ka2
    public void B() {
        U(new b0());
    }

    public final void B1() throws Resources.NotFoundException {
        this.multiControlPanel.setVisibility(0);
        int i2 = this.t;
        if (i2 == 1) {
            this.multiControlPanel.setHiddenVelvoIcon(false);
            this.llControlLayout.setVisibility(0);
            int dimensionPixelSize = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
            this.multiControlPanel.O(false, "GROUP_CHAT_DS_CONTROL", this.C, 4, dimensionPixelSize);
            this.multiControlPanel.setPanelHeight(WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_ds_controlball_panel_height), dimensionPixelSize, this.C.size());
            this.multiControlPanel.g0();
            E2(false);
            A2();
            this.multiControlPanel.X(new c0());
            this.multiControlPanel.setControShowMorelListener(new d0());
            this.multiControlPanel.setEndControlListener(new e0());
            this.multiControlPanel.setOnBallsInitListener(new f0());
            this.multiControlPanel.setOnBallsChangeListener(new h0());
            this.multiControlPanel.i0(true);
        } else {
            int i3 = 2;
            if (i2 == 2 || i2 == 3) {
                this.multiControlPanel.setHiddenVelvoIcon(true);
                this.llControlLayout.setVisibility(8);
                int dimensionPixelSize2 = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
                if (this.t == 2 || !this.u) {
                    jp3 jp3Var = this.a0;
                    if (jp3Var != null) {
                        jp3Var.l(true);
                    }
                    this.multiControlPanel.O(false, "GROUP_CHAT_DS_CONTROL", this.C, 4, dimensionPixelSize2);
                }
                int size = this.C.size();
                if (size < 1) {
                    i3 = 1;
                } else if (size <= 2) {
                    i3 = size;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
                layoutParams.height = dimensionPixelSize2 * i3;
                this.multiControlPanel.setLayoutParams(layoutParams);
                this.multiControlPanel.setPanelChildHeight(0, dimensionPixelSize2, i3, 1.0f);
                this.multiControlPanel.i0(false);
            }
        }
        this.u = true;
    }

    public void B2(DsSomebodyCreateMultiToOneResponse dsSomebodyCreateMultiToOneResponse) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        rn3 rn3Var;
        User user;
        Group groupK = ch3.n().k(dsSomebodyCreateMultiToOneResponse.getRoomId());
        if (groupK == null || groupK.isExit()) {
            return;
        }
        groupK.getId();
        GroupMember memberByJid = groupK.getMemberByJid(dsSomebodyCreateMultiToOneResponse.getTargeter().getJid());
        if (memberByJid == null) {
            return;
        }
        Dialog dialog = this.D;
        if (dialog instanceof GroupDSWaitAccpetDialog) {
            GroupDSWaitAccpetDialog groupDSWaitAccpetDialog = (GroupDSWaitAccpetDialog) dialog;
            if (groupDSWaitAccpetDialog.isShowing() && !groupDSWaitAccpetDialog.f().c.equals(dsSomebodyCreateMultiToOneResponse.getRoomId())) {
                sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
                d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
                return;
            }
        }
        if (na2.m().i()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        if (sz1.d().e() >= 8) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        if (my2.i.a().getB()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        Iterator<Activity> it = pd3.j().a.iterator();
        ChatActivity chatActivity = null;
        while (it.hasNext()) {
            Activity next = it.next();
            if (next instanceof ChatActivity) {
                chatActivity = (ChatActivity) next;
            }
        }
        if (chatActivity != null && (user = chatActivity.z) != null && (user.isDateIng() || ChatSyncControl.N0().z() || ChatVideoControl.a1().z())) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        gu3 gu3Var = hu3.p;
        if (gu3Var != null && (rn3Var = gu3Var.a) != null && rn3Var != null && rn3Var.d()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        if (ob2.o().q()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        if (h32.i().l()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(dsSomebodyCreateMultiToOneResponse.getRoomId(), false);
            return;
        }
        this.v = false;
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (DSPlayerListBean dSPlayerListBean : dsSomebodyCreateMultiToOneResponse.getPlayerList()) {
            GroupMember memberByJid2 = groupK.getMemberByJid(dSPlayerListBean.getJid());
            if (memberByJid2 != null) {
                memberByJid2.setDSStatus(dSPlayerListBean.getStatus().intValue());
                if (dSPlayerListBean.getStatus().intValue() == 0) {
                    z2 = true;
                }
                arrayList.add(memberByJid2);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        xz1.a();
        WearUtils.z2();
        if (!WearUtils.x.f0()) {
            WearUtils.K1(false, null);
        } else if (og3.b(1) && og3.b(2)) {
            WearUtils.K1(false, null);
        }
        if (this.g.f0()) {
            String str = "[" + ah4.e(R.string.group_chat_menu_ds) + "]";
            if (og3.b(1)) {
                PowerManager powerManager = (PowerManager) this.g.getSystemService("power");
                if (powerManager != null && (wakeLockNewWakeLock = powerManager.newWakeLock(268435462, ":target")) != null) {
                    wakeLockNewWakeLock.acquire();
                    wakeLockNewWakeLock.release();
                }
                try {
                    this.g.u(groupK, memberByJid, str, 2);
                } catch (Exception e2) {
                    FirebaseCrashlytics.getInstance().recordException(e2);
                }
            }
        }
        UserSetting userSettingZ = WearUtils.y.z(WearUtils.g0(groupK.getRealId()));
        if (!(userSettingZ != null && WearUtils.x1(userSettingZ.getAutoAccept()))) {
            U(new h(groupK, arrayList, memberByJid, dsSomebodyCreateMultiToOneResponse, z2));
            return;
        }
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        L(groupK);
        Dialog dialog2 = this.D;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        U(new Runnable() { // from class: dc.p82
            @Override // java.lang.Runnable
            public final void run() {
                ChatDSControl.R1();
            }
        });
        f2("PLAYER_JOIN_MULTI_TO_ONE", new i(fragmentActivityH, dsSomebodyCreateMultiToOneResponse));
        this.v = false;
    }

    public void C1(boolean z2) {
        if (z2) {
            this.V.setVisibility(0);
        }
        x2(z2);
        if (z2) {
            pc1.a.F();
            this.i = 0;
        }
    }

    public void C2(DSYouCatPlayingMultiToOneResponse dSYouCatPlayingMultiToOneResponse) {
        U(new j(dSYouCatPlayingMultiToOneResponse));
    }

    public void D1() {
        List<Pattern> listM = xe2.L0().m(WearUtils.y.r());
        this.F.clear();
        this.F.addAll(listM);
        this.w.notifyDataSetChanged();
    }

    public final boolean D2() {
        GroupMember groupMember = this.G;
        return groupMember == null || groupMember.isExit();
    }

    public final void E1() {
        if (this.E) {
            this.llPattern.setVisibility(0);
            this.llControlLayout.setVisibility(8);
            this.llExpand.setVisibility(8);
            this.multiControlPanel.setVisibility(8);
            if (this.F.size() <= 0) {
                this.tvPatternEmpty.setVisibility(0);
            } else {
                this.tvPatternEmpty.setVisibility(8);
            }
            me3.d(me3.c.GROUP_CHAT_DS_CONTROL_PATTERN_BEGIN, me3.a());
        } else {
            this.llPattern.setVisibility(8);
            this.llControlLayout.setVisibility(0);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.g0();
        }
        this.flWaitControlAndEdParent.setVisibility(8);
    }

    public final void E2(boolean z2) throws Resources.NotFoundException {
        int dimensionPixelSize = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
        int dimensionPixelSize2 = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_ds_controlball_bottom_height);
        int dimensionPixelSize3 = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_ds_controlball_panel_height);
        int size = this.C.size();
        if (size < 1) {
            size = 1;
        } else if (size > 2) {
            size = 2;
        }
        if (z2) {
            this.touchControlHorizontalBottom.setVisibility(8);
            this.tvBottomLine.setVisibility(8);
            this.llControlLayout.setVisibility(8);
            this.multiControlPanel.setSyncControlMode(true, dimensionPixelSize2);
            dimensionPixelSize3 += dimensionPixelSize2;
        } else {
            this.touchControlHorizontalBottom.setVisibility(0);
            this.tvBottomLine.setVisibility(0);
            this.llControlLayout.setVisibility(0);
            this.multiControlPanel.setSyncControlMode(false, dimensionPixelSize2);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
        int i2 = dimensionPixelSize * size;
        layoutParams.height = dimensionPixelSize3 + i2;
        this.multiControlPanel.setLayoutParams(layoutParams);
        this.multiControlPanel.setPanelChildHeight(dimensionPixelSize3, dimensionPixelSize, size, new BigDecimal(i2).divide(new BigDecimal(layoutParams.height), 6, RoundingMode.HALF_UP).floatValue());
    }

    public final void F1() {
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.view_group_ds, (ViewGroup) null);
        this.V = viewInflate;
        ButterKnife.bind(this, viewInflate);
        EventBus.getDefault().register(this);
    }

    public void F2(MasterLineStatusNotifyResponse masterLineStatusNotifyResponse) {
        U(new n(masterLineStatusNotifyResponse));
    }

    public final boolean G1() {
        return false;
    }

    public void G2(DSTargeterRefuseInviteResponse dSTargeterRefuseInviteResponse) {
        if (dSTargeterRefuseInviteResponse.getCreatorJid().equals(ch3.n().u().getUserJid())) {
            B();
            sg3.l(ah4.e(R.string.chat_video_busy));
        }
    }

    public boolean H1() {
        return this.v;
    }

    public void H2(DSTargeterToyChangeResponse dSTargeterToyChangeResponse) {
        if (r()) {
            U(new o(dSTargeterToyChangeResponse));
        }
    }

    public final boolean I1(String str) {
        if (this.Z == null) {
            this.Z = java.util.regex.Pattern.compile("^[-\\+]?[\\d]*$");
        }
        return this.Z.matcher(str).matches();
    }

    public void I2(boolean z2) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        List<Toy> listF1 = f1();
        if (listF1.size() > 0) {
            this.C.addAll(listF1);
        }
        if (this.T != null && this.U != null) {
            t2();
        }
        for (Toy toy : this.C) {
            String address = toy.getAddress();
            if (WearUtils.e1(address)) {
                address = toy.getDeviceId();
            }
            if (!z2) {
                this.multiControlPanel.p0(address, toy.getStatus() == 1);
            }
            this.multiControlPanel.o0(address, toy.getBattery());
        }
        if (listF1.size() > 0) {
            this.multiControlPanel.q0(this.C);
            Iterator<Toy> it = listF1.iterator();
            while (it.hasNext()) {
                k2(it.next());
            }
        }
    }

    public void J1(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
        U(new p(dSPlayerListChangeResponse));
    }

    public void K1(mf2 mf2Var) {
        MusicControl.h0().S();
        y12.c.a().t();
        r rVar = new r(this);
        rVar.setRoomId(((Group) this.c).getId());
        rVar.setAckId(WearUtils.E());
        this.x.a(rVar, mf2Var);
    }

    public void K2(Activity activity, String str, AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse) {
        Group groupK;
        GroupMember memberByJid;
        boolean z2;
        ArrayList<IPeopleInfo> arrayList;
        if (!this.p || (groupK = ch3.n().k(ackCreateMultiToOneInfoResponse.getRoomId())) == null || groupK.isExit() || (memberByJid = groupK.getMemberByJid(ackCreateMultiToOneInfoResponse.getTargeterJid())) == null) {
            return;
        }
        if (!this.p || (arrayList = this.r) == null || arrayList.size() <= 0) {
            ArrayList<GroupMember> arrayList2 = new ArrayList<>();
            z2 = false;
            for (DSPlayerListBean dSPlayerListBean : ackCreateMultiToOneInfoResponse.getPlayerList()) {
                GroupMember memberByJid2 = ((Group) this.c).getMemberByJid(dSPlayerListBean.getJid());
                if (memberByJid2 != null) {
                    memberByJid2.setDSStatus(dSPlayerListBean.getStatus().intValue());
                    if (dSPlayerListBean.getStatus().intValue() == 0) {
                        z2 = true;
                    }
                    arrayList2.add(memberByJid2);
                }
            }
            x1(arrayList2);
        } else {
            z2 = false;
        }
        this.p = false;
        GroupDSWaitAccpetDialog.g gVar = new GroupDSWaitAccpetDialog.g();
        gVar.a = this.r;
        gVar.b = memberByJid;
        gVar.c = ackCreateMultiToOneInfoResponse.getRoomId();
        is3.b bVar = new is3.b(activity);
        bVar.e(gVar);
        bVar.x(ce3.a(this.g, 311.0f));
        bVar.c(new k0());
        is3 is3VarI = cs3.i(bVar, GroupDSWaitAccpetDialog.class);
        this.D = is3VarI;
        is3VarI.show();
        if (z2) {
            this.q.postDelayed(new l0(), 3000L);
        }
        ((GroupDSWaitAccpetDialog) this.D).setButtonVisibility(true);
        o2(true);
        this.D.setOnDismissListener(new m0());
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C327.toString(), null);
        e2(entitySystem, MessageType.system);
    }

    public void L2(Activity activity, String str, ArrayList<String> arrayList, GroupDsControlSelectDomsPeopleActivity.d dVar) {
        this.p = false;
        String strRemove = arrayList.remove(0);
        RoomSendDSRequest roomSendDSRequest = new RoomSendDSRequest();
        roomSendDSRequest.setRoomId(str);
        roomSendDSRequest.setTargeterJid(strRemove);
        roomSendDSRequest.setPlayerJidList(arrayList);
        roomSendDSRequest.setAckId(WearUtils.E());
        if (dVar != null) {
            dVar.d();
        }
        this.x.a(roomSendDSRequest, new j0(this, dVar));
    }

    @Override // dc.ka2
    public void P() {
    }

    @Override // dc.ka2
    public void Q(Activity activity) {
        if (activity instanceof ChatRoomActivity) {
            ChatRoomActivity chatRoomActivity = (ChatRoomActivity) activity;
            if (chatRoomActivity.C() == this.c) {
                chatRoomActivity.O8();
                return;
            }
        }
        pj3.j(activity, ChatRoomActivity.class, "roomId", ((Group) this.c).getId());
    }

    public void S1(DSMultiToOneIsEndResponse dSMultiToOneIsEndResponse) {
        Dialog dialog;
        if (!this.p && (((dialog = this.D) == null || !(dialog instanceof GroupDSWaitAccpetDialog)) && o1() == 2)) {
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C328.toString(), null);
            e2(entitySystem, MessageType.system);
        }
        B();
        Z1(false);
        if (dSMultiToOneIsEndResponse.getType() == 2) {
            sg3.l(ah4.e(R.string.ds_ended_because_of_network));
        } else if (dSMultiToOneIsEndResponse.getType() == 3) {
            sg3.l(ah4.e(R.string.chat_video_busy));
        }
    }

    public void T1(DsMultiToOneIsStarNowResponse dsMultiToOneIsStarNowResponse) {
        U(new l(dsMultiToOneIsStarNowResponse));
    }

    @Override // com.wear.adapter.BaseAdapter.b
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void a0(IPeopleInfo iPeopleInfo, int i2, View view) {
        if (iPeopleInfo instanceof GroupMember) {
            is3.b bVar = new is3.b(I());
            bVar.e((GroupMember) iPeopleInfo);
            bVar.x(gg3.e(this.g));
            bVar.i(80);
            bVar.l(true);
            bVar.m(true);
            GroupControlMemberInfoDialog groupControlMemberInfoDialog = (GroupControlMemberInfoDialog) cs3.i(bVar, GroupControlMemberInfoDialog.class);
            groupControlMemberInfoDialog.show();
            groupControlMemberInfoDialog.setListener(new c(this));
        }
    }

    public final void V1() {
        this.v = false;
        p2(0);
        this.q.removeCallbacksAndMessages(null);
        this.r.clear();
        this.s.clear();
        this.D = null;
    }

    public void W1(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || this.c == 0) {
            return;
        }
        if (!r()) {
            F();
        } else if (((Group) this.c).getId().equals(iPeopleInfo.getId())) {
            z2();
        } else {
            w2();
        }
    }

    public void X1(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
        U(new m(dSPlayerListChangeResponse));
    }

    public void Y1(DSPlayerRefuseMultiToOneInviteResponse dSPlayerRefuseMultiToOneInviteResponse) {
        U(new q(dSPlayerRefuseMultiToOneInviteResponse));
    }

    public final void Z1(boolean z2) {
        U(new z(z2));
    }

    @Override // dc.ra2
    public void a() {
        if (this.c == 0) {
            return;
        }
        f2("GIVE_UP_CONTROL_MULTI_TO_ONE", null);
        if (o1() == 2) {
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C328.toString(), null);
            e2(entitySystem, MessageType.system);
        }
        Z1(true);
    }

    public void a2(String str, HashMap<String, Order> map) {
        if (this.d.equals(str)) {
            String str2 = "ds接收指令receviceToycommd: " + map.toString();
            this.B = map;
            this.Y.removeCallbacksAndMessages(null);
            this.X = false;
            this.Y.postDelayed(new b(new a()), 200L);
            t1(map, false);
        }
    }

    public void b2(final ReceiveMultiToOneControlInviteV2Response receiveMultiToOneControlInviteV2Response) {
        final GroupMember memberByJid;
        PowerManager.WakeLock wakeLockNewWakeLock;
        rn3 rn3Var;
        User user;
        final Group groupK = ch3.n().k(receiveMultiToOneControlInviteV2Response.getRoomId());
        if (groupK == null || groupK.isExit() || (memberByJid = groupK.getMemberByJid(receiveMultiToOneControlInviteV2Response.getTargeter().getJid())) == null) {
            return;
        }
        final boolean zEquals = ch3.n().u().getUserJid().equals(memberByJid.getUserJid());
        Dialog dialog = this.D;
        if (dialog instanceof GroupDSWaitAccpetDialog) {
            GroupDSWaitAccpetDialog groupDSWaitAccpetDialog = (GroupDSWaitAccpetDialog) dialog;
            if (groupDSWaitAccpetDialog.isShowing() && !groupDSWaitAccpetDialog.f().c.equals(receiveMultiToOneControlInviteV2Response.getRoomId())) {
                sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
                d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
                return;
            }
        }
        if (na2.m().i()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        if (sz1.d().e() >= 8) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        if (h32.i().l()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        if (my2.i.a().getB()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        Iterator<Activity> it = pd3.j().a.iterator();
        ChatActivity chatActivity = null;
        while (it.hasNext()) {
            Activity next = it.next();
            if (next instanceof ChatActivity) {
                chatActivity = (ChatActivity) next;
            }
        }
        if (chatActivity != null && (user = chatActivity.z) != null && (user.isDateIng() || ChatSyncControl.N0().z() || ChatVideoControl.a1().z())) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        gu3 gu3Var = hu3.p;
        if (gu3Var != null && (rn3Var = gu3Var.a) != null && rn3Var != null && rn3Var.d()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        if (ob2.o().q()) {
            sg3.l(String.format(ah4.e(R.string.conflict_notice_group_ds_control), memberByJid.getNickName()));
            d1(receiveMultiToOneControlInviteV2Response.getRoomId(), zEquals);
            return;
        }
        this.v = false;
        final ArrayList arrayList = new ArrayList();
        final boolean z2 = false;
        for (DSPlayerListBean dSPlayerListBean : receiveMultiToOneControlInviteV2Response.getPlayerList()) {
            GroupMember memberByJid2 = groupK.getMemberByJid(dSPlayerListBean.getJid());
            if (memberByJid2 != null) {
                memberByJid2.setDSStatus(dSPlayerListBean.getStatus().intValue());
                if (dSPlayerListBean.getStatus().intValue() == 0) {
                    z2 = true;
                }
                arrayList.add(memberByJid2);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        xz1.a();
        WearUtils.z2();
        if (!WearUtils.x.f0()) {
            WearUtils.K1(false, null);
        } else if (og3.b(1) && og3.b(2)) {
            WearUtils.K1(false, null);
        }
        if (this.g.f0()) {
            String str = "[" + ah4.e(R.string.group_chat_menu_ds) + "]";
            if (og3.b(1)) {
                PowerManager powerManager = (PowerManager) this.g.getSystemService("power");
                if (powerManager != null && (wakeLockNewWakeLock = powerManager.newWakeLock(268435462, ":target")) != null) {
                    wakeLockNewWakeLock.acquire();
                    wakeLockNewWakeLock.release();
                }
                try {
                    this.g.u(groupK, memberByJid, str, 2);
                } catch (Exception e2) {
                    FirebaseCrashlytics.getInstance().recordException(e2);
                }
            }
        }
        UserSetting userSettingZ = WearUtils.y.z(WearUtils.g0(groupK.getRealId()));
        if (!(userSettingZ != null && WearUtils.x1(userSettingZ.getAutoAccept()))) {
            U(new Runnable() { // from class: dc.r82
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.M1(groupK, arrayList, memberByJid, receiveMultiToOneControlInviteV2Response, z2, zEquals);
                }
            });
            return;
        }
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null) {
            return;
        }
        L(groupK);
        Dialog dialog2 = this.D;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        U(new Runnable() { // from class: dc.t82
            @Override // java.lang.Runnable
            public final void run() {
                ChatDSControl.O1();
            }
        });
        f2("AGREE_MULTI_TO_ONE_INVITE", null);
        me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
        me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
        ye3.c("friend chatroom", "begin group D&S control", receiveMultiToOneControlInviteV2Response.getRoomId());
        sz1.d().r(8);
        this.v = false;
        pj3.j(fragmentActivityH, ChatRoomActivity.class, "roomId", receiveMultiToOneControlInviteV2Response.getRoomId());
    }

    public void c() {
        this.llExpand.setVisibility(0);
        this.llControlLayout.setVisibility(8);
        this.llWaitControlAndEd.setVisibility(8);
        this.llSettingTime.setVisibility(8);
        if (this.t == 3) {
            this.tvNext1.setVisibility(4);
        } else {
            this.tvNext1.setVisibility(0);
        }
    }

    public final void c2(List<BaseBallBean> list, boolean z2) {
        if (this.c == 0 || list == null) {
            return;
        }
        if (z2) {
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.clear();
            this.R.addAll(list);
        }
        RoomSendDSToysSelRequest roomSendDSToysSelRequest = new RoomSendDSToysSelRequest();
        roomSendDSToysSelRequest.setRoomId(((Group) this.c).getId());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BaseBallBean baseBallBean = list.get(i2);
            arrayList.add(new DSMultiToySelectChangeResponse.BallSelectBean(baseBallBean.getToyAddress(), baseBallBean.getToyFun(), baseBallBean.isSelected() ? 1 : 0));
        }
        roomSendDSToysSelRequest.setListBalls(arrayList);
        roomSendDSToysSelRequest.setAckId(WearUtils.E());
        this.x.d(roomSendDSToysSelRequest);
    }

    public void d1(String str, boolean z2) {
        this.q.postDelayed(new a0(z2, str), 1500L);
    }

    public void e1() throws Resources.NotFoundException {
        int i2 = this.t;
        if (i2 == 1) {
            this.llControlLayout.setVisibility(0);
            this.llExpand.setVisibility(8);
            this.tvNext1.setVisibility(0);
            this.E = false;
            E1();
            this.flWaitControlAndEdParent.setVisibility(8);
            ou3.f();
        } else if (i2 == 2) {
            u1();
            this.llControlLayout.setVisibility(8);
            this.llExpand.setVisibility(8);
            this.llPattern.setVisibility(8);
            this.flWaitControlAndEdParent.setVisibility(0);
            this.llWaitControlAndEd.setVisibility(0);
            this.llRealControlEd.setVisibility(0);
            this.llWaitControl.setVisibility(8);
            this.vSubMarginView.setVisibility(0);
            this.tvWaitControlTip.setVisibility(8);
            this.tvNext1.setVisibility(0);
            this.llSettingTime.setVisibility(8);
            i2();
        } else if (i2 == 3) {
            u1();
            this.llControlLayout.setVisibility(8);
            this.llExpand.setVisibility(8);
            this.llPattern.setVisibility(8);
            this.llWaitControlAndEd.setVisibility(0);
            this.llRealControlEd.setVisibility(8);
            this.llWaitControl.setVisibility(0);
            this.vSubMarginView.setVisibility(8);
            this.flWaitControlAndEdParent.setVisibility(0);
            this.tvWaitControlTip.setVisibility(0);
            this.tvNext1.setVisibility(4);
            this.llSettingTime.setVisibility(8);
            Dialog dialog = this.D;
            if (dialog != null && dialog.isShowing()) {
                this.D.dismiss();
            }
            ou3.f();
        }
        v2();
        WearUtils.t2(this.userImg, this.G);
        GroupMember groupMember = this.G;
        if (groupMember != null) {
            this.tvName.setText(groupMember.getShowNickName());
            this.tvSubUserName.setText(this.G.getShowNickName());
        }
        C1(false);
        List<Toy> list = this.C;
        if (list == null || list.size() < 1) {
            I2(false);
        }
        s2();
    }

    public final void e2(DataEntityAbstract dataEntityAbstract, MessageType messageType) {
        if (zb2.O().B(messageType)) {
            zb2.O().H0(WearUtils.k0(((Group) this.c).getId()), dataEntityAbstract, true, false, null);
        } else {
            sg3.l(ah4.e(R.string.operate_frequently));
        }
    }

    public void f0(DSMultiToySelectChangeResponse dSMultiToySelectChangeResponse) {
        if (this.t == 1 || dSMultiToySelectChangeResponse == null) {
            return;
        }
        U(new i0(dSMultiToySelectChangeResponse));
    }

    public final List<Toy> f1() {
        boolean z2;
        ArrayList<Toy> arrayListP = WearUtils.x.G().p();
        ArrayList arrayList = new ArrayList();
        if (arrayListP != null) {
            Iterator<Toy> it = arrayListP.iterator();
            while (true) {
                boolean z3 = false;
                if (!it.hasNext()) {
                    break;
                }
                Toy next = it.next();
                Iterator<Toy> it2 = this.C.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (next.getDeviceId().equals(it2.next().getDeviceId())) {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    arrayList.add(next);
                }
            }
            for (Toy toy : this.C) {
                Iterator<Toy> it3 = arrayListP.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (toy.getDeviceId().equals(it3.next().getDeviceId())) {
                        z2 = true;
                        break;
                    }
                }
                toy.setStatus(z2 ? 1 : -1);
            }
        }
        return arrayList;
    }

    public final void f2(String str, mf2 mf2Var) {
        if (this.c == 0) {
            return;
        }
        u uVar = new u(this, str);
        uVar.setRoomId(((Group) this.c).getId());
        uVar.setAckId(WearUtils.E());
        this.x.a(uVar, mf2Var);
    }

    @Override // dc.na2.b
    public void g() {
        SkinCompatTextView skinCompatTextView;
        SkinCompatTextView skinCompatTextView2;
        if (r()) {
            this.Q++;
            int i2 = this.i + 1;
            this.i = i2;
            if (i2 % 5 == 0) {
                if (uf2.v().q()) {
                    this.Q = 0;
                    v2();
                } else {
                    this.tvWaitControlTip.setVisibility(0);
                    this.vSubMarginView.setVisibility(8);
                    this.tvWaitControlTip.setText(ah4.e(R.string.ds_panels_your_network_poor));
                    if (this.Q > 60) {
                        sg3.l(ah4.e(R.string.ds_toast_kicked_out));
                        a();
                        return;
                    }
                }
                if (r()) {
                    g2("MULTI_TO_ONE_HEARTBEAT");
                }
            }
            String strQ = WearUtils.Q(this.i);
            q2(strQ);
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(strQ);
            }
            TextView textView2 = this.tvControlTimeEd;
            if (textView2 != null) {
                textView2.setText(strQ);
            }
            TextView textView3 = this.tvStop1;
            if (textView3 != null) {
                textView3.setText(strQ);
            }
            long j2 = this.L - 1;
            this.L = j2;
            if (j2 <= 0) {
                this.L = 0L;
            }
            String strQ2 = WearUtils.Q(this.L);
            DsControlBoardOneLineAdapter dsControlBoardOneLineAdapter = this.y;
            if (dsControlBoardOneLineAdapter != null && (skinCompatTextView2 = dsControlBoardOneLineAdapter.j) != null) {
                skinCompatTextView2.setText(strQ2);
            }
            DsControlBoardAllAdapter dsControlBoardAllAdapter = this.N;
            if (dsControlBoardAllAdapter != null && (skinCompatTextView = dsControlBoardAllAdapter.j) != null) {
                skinCompatTextView.setText(strQ2);
            }
            TextView textView4 = this.tvNextControl;
            if (textView4 != null) {
                textView4.setText(ah4.e(R.string.ds_button_next) + SignatureImpl.INNER_SEP + strQ2);
            }
        }
    }

    public final void g1() {
        m1(I(), o1() == 1, false);
    }

    public final void g2(String str) {
        if (this.c == 0) {
            return;
        }
        w wVar = new w(this, str);
        wVar.setRoomId(((Group) this.c).getId());
        this.x.d(wVar);
    }

    public int getPriority() {
        T t2 = this.c;
        return ((t2 == 0 || !((Group) t2).isExit()) && z()) ? 8 : 0;
    }

    public final void h1(List<Ball2CurveEventBean> list) {
        if (this.b == null || this.t != 1 || this.E) {
            return;
        }
        this.a0.k(list);
        ArrayList<MultiToyOFunBean> arrayList = new ArrayList();
        arrayList.addAll(this.multiControlPanel.getListConnectToyOFuns());
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        for (MultiToyOFunBean multiToyOFunBean : arrayList) {
            String fun = multiToyOFunBean.isFunction() ? multiToyOFunBean.getFun() : multiToyOFunBean.getAllFun();
            arrayList2.add(new BallToysComBean(multiToyOFunBean.getTag(), fun));
            map.put(multiToyOFunBean.getTag(), fun);
        }
        boolean z2 = false;
        for (Ball2CurveEventBean ball2CurveEventBean : list) {
            String function = ball2CurveEventBean.isFunction() ? ball2CurveEventBean.getFunction() : ball2CurveEventBean.getToyAddress();
            String str = (String) map.get(function);
            if (!WearUtils.e1(str)) {
                map.put(function, str.replace(ball2CurveEventBean.getFunction(), ball2CurveEventBean.getGroups()));
            }
            if (ball2CurveEventBean.isRotateChange()) {
                z2 = true;
            }
        }
        for (String str2 : map.keySet()) {
            String strReplace = (String) map.get(str2);
            if (!WearUtils.e1(strReplace)) {
                String[] strArrSplit = strReplace.split(",");
                boolean z3 = false;
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    if (!I1(strArrSplit[i2])) {
                        strReplace = strReplace.replace(strArrSplit[i2], "0");
                        z3 = true;
                    }
                }
                if (z3) {
                    map.put(str2, strReplace);
                }
            }
        }
        synchronized (this.A) {
            this.A.clear();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                BallToysComBean ballToysComBean = (BallToysComBean) arrayList2.get(i3);
                String deviceId = ballToysComBean.getDeviceId();
                String str3 = (String) map.get(deviceId);
                for (Ball2CurveEventBean ball2CurveEventBean2 : list) {
                    if (TextUtils.equals(deviceId, ball2CurveEventBean2.getToyAddress())) {
                        boolean zB = ou3.b(deviceId, str3, "");
                        if (z2 || zB) {
                            i1(deviceId, ballToysComBean.getTag(), str3, ball2CurveEventBean2.isRotateChange(), false);
                        }
                    }
                }
            }
            this.z.setRoomId(this.d);
            HashMap<String, Order> map2 = this.A;
            if (map2 != null && map2.size() > 0) {
                this.z.setOrder(JSON.toJSONString(this.A));
                String str4 = "controlCommandLocal: " + this.z.toString();
                this.x.d(this.z);
            }
        }
    }

    public final void i1(String str, String str2, String str3, boolean z2, boolean z3) {
        String[] strArrSplit = Toy.changeSinglefuncLineToTayValue(str2, str3).split(TouchControlView.O);
        String[] strArrSplit2 = str2.split(TouchControlView.O);
        if (strArrSplit2.length > 5 || strArrSplit2.length != strArrSplit.length) {
            return;
        }
        Order order = new Order();
        for (int i2 = 0; i2 < strArrSplit2.length; i2++) {
            String str4 = strArrSplit[i2];
            if (!TextUtils.isEmpty(str4)) {
                if (PSOProgramService.VS_Key.equals(strArrSplit2[i2])) {
                    order.setV(Integer.parseInt(str4));
                } else if ("p".equals(strArrSplit2[i2])) {
                    order.setP(Integer.parseInt(str4));
                } else if (StreamManagement.AckRequest.ELEMENT.equals(strArrSplit2[i2])) {
                    order.setR(Integer.parseInt(str4));
                } else if ("v1".equals(strArrSplit2[i2])) {
                    order.setV1(Integer.parseInt(str4));
                } else if ("v2".equals(strArrSplit2[i2])) {
                    order.setV2(Integer.parseInt(str4));
                } else if ("v3".equals(strArrSplit2[i2])) {
                    order.setV3(Integer.parseInt(str4));
                } else if ("t".equals(strArrSplit2[i2])) {
                    order.setT(Integer.parseInt(str4));
                } else if ("s".equals(strArrSplit2[i2])) {
                    order.setS(Integer.parseInt(str4));
                } else if ("f".equals(strArrSplit2[i2])) {
                    order.setF(Integer.parseInt(str4));
                } else if (GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(strArrSplit2[i2])) {
                    order.setD(Integer.parseInt(str4));
                } else if ("pos".equals(strArrSplit2[i2])) {
                    order.setPos(Integer.parseInt(str4));
                }
                if (z3) {
                    if (order.getS() != -1) {
                        order.setV(order.getS());
                        order.setV1(order.getS());
                        order.setV2(order.getS());
                        order.setV3(order.getS());
                        order.setT(order.getS());
                    }
                    if (order.getV1() != -1) {
                        order.setV(order.getV1());
                    }
                    if (order.getV() != -1) {
                        order.setV1(order.getV());
                        order.setV2(order.getV());
                        order.setV3(order.getV());
                        order.setS(order.getV());
                        order.setT(order.getV());
                    }
                    if (order.getT() != -1) {
                        order.setV(order.getT());
                        order.setV1(order.getT());
                        order.setV2(order.getT());
                        order.setV3(order.getT());
                        order.setS(order.getT());
                    }
                    if (order.getF() != -1 && order.getV() != -1) {
                        order.setV1(order.getV());
                        order.setV2(order.getV());
                        order.setV3(order.getV());
                        order.setS(order.getV());
                        order.setT(order.getV());
                    }
                    if (order.getP() != -1 && order.getV() != -1) {
                        order.setV1(order.getV());
                        order.setV2(order.getV());
                        order.setV3(order.getV());
                        order.setS(order.getV());
                        order.setT(order.getV());
                    }
                    if (order.getR() != -1 && order.getV() != -1) {
                        order.setV1(order.getV());
                        order.setV2(order.getV());
                        order.setV3(order.getV());
                        order.setS(order.getV());
                        order.setT(order.getV());
                    }
                    if (order.getPos() != -1) {
                        order.setPos(order.getPos() * 5);
                    }
                }
            }
        }
        if (z2) {
            order.setR(-2);
        }
        this.A.put(str, order);
    }

    public final void i2() {
        int i2;
        HashMap<String, Order> map = new HashMap<>();
        Iterator<Toy> it = this.C.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Toy next = it.next();
            Order order = new Order();
            order.setV(0);
            order.setR(0);
            order.setP(0);
            order.setV1(0);
            order.setV2(0);
            order.setV3(0);
            order.setT(0);
            order.setS(0);
            order.setF(0);
            order.setPos(0);
            map.put(next.getDeviceId(), order);
        }
        for (i2 = 0; i2 < 4; i2++) {
            a2(this.d, map);
        }
    }

    public void j1(DSPlayerListChangeResponse dSPlayerListChangeResponse, boolean z2) {
        U(new t(z2));
    }

    @Override // dc.na2.b
    public void k() {
    }

    public final boolean k1(String str) {
        T t2 = this.c;
        return t2 == 0 || !((Group) t2).getId().equals(str) || G1();
    }

    public final void k2(Toy toy) {
        HashMap<String, Order> map;
        if (toy == null || (map = this.B) == null || map.containsKey(toy.getDeviceId())) {
            return;
        }
        Order order = new Order();
        order.setV(0);
        order.setR(0);
        order.setP(0);
        order.setV1(0);
        order.setV2(0);
        order.setV3(0);
        order.setT(0);
        order.setS(0);
        order.setF(0);
        order.setPos(0);
        this.B.put(toy.getDeviceId(), order);
    }

    public final void l1(String str, String str2, String str3) {
        xe3.a("Live", str + " " + str2 + "  " + str3);
        U(new y(str2, str3, str));
    }

    public final void m1(Activity activity, boolean z2, boolean z3) {
        v vVar = new v(z3, activity);
        if (!z2) {
            vVar.doConfirm();
            return;
        }
        is3.b bVar = new is3.b(activity);
        bVar.p(ah4.e(R.string.message_control_end));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.link_end_control));
        bVar.d(vVar);
        cs3.h(bVar).show();
    }

    public final void m2() {
        int i2;
        HashMap map = new HashMap();
        Iterator<Toy> it = this.C.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Toy next = it.next();
            Order order = new Order();
            order.setV(0);
            order.setR(0);
            order.setP(0);
            order.setV1(0);
            order.setV2(0);
            order.setV3(0);
            order.setT(0);
            order.setS(0);
            order.setF(0);
            order.setPos(0);
            map.put(next.getDeviceId(), order);
        }
        MultiToOneToyOrderRequest multiToOneToyOrderRequest = new MultiToOneToyOrderRequest();
        multiToOneToyOrderRequest.setOrder(JSON.toJSONString(map));
        multiToOneToyOrderRequest.setRoomId(((Group) this.c).getId());
        for (i2 = 0; i2 < 4; i2++) {
            this.x.d(multiToOneToyOrderRequest);
        }
    }

    public void n1() {
        this.tvSelectTime.setText(String.format(ah4.e(R.string.ds_waiting_panel_duration_tip), WearUtils.Q(this.M / 1000)));
    }

    public void n2() {
        int i2 = this.t;
        if (i2 == 1) {
            jp3.h.a();
            this.llControlLayout.setVisibility(0);
            this.llExpand.setVisibility(8);
            E1();
            this.flWaitControlAndEdParent.setVisibility(8);
            this.tvNext1.setVisibility(0);
        } else if (i2 == 2) {
            this.llControlLayout.setVisibility(8);
            this.llExpand.setVisibility(8);
            this.llPattern.setVisibility(8);
            this.flWaitControlAndEdParent.setVisibility(0);
            this.llWaitControlAndEd.setVisibility(0);
            this.llRealControlEd.setVisibility(0);
            this.llWaitControl.setVisibility(8);
            this.vSubMarginView.setVisibility(0);
            this.tvWaitControlTip.setVisibility(8);
            this.llSettingTime.setVisibility(8);
            i2();
            this.tvSelectTime.setText(String.format(ah4.e(R.string.ds_waiting_panel_duration_tip), WearUtils.Q(this.M / 1000)));
            this.tvNext1.setVisibility(8);
        } else if (i2 == 3) {
            this.llControlLayout.setVisibility(8);
            this.llExpand.setVisibility(8);
            this.llPattern.setVisibility(8);
            this.flWaitControlAndEdParent.setVisibility(0);
            this.llWaitControlAndEd.setVisibility(0);
            this.llRealControlEd.setVisibility(8);
            this.llWaitControl.setVisibility(0);
            this.vSubMarginView.setVisibility(8);
            this.tvWaitControlTip.setVisibility(0);
            this.tvWaitControlTip.setText(String.format(ah4.e(R.string.ds_waiting_panel_duration_tip), WearUtils.Q(this.M / 1000)));
            this.llSettingTime.setVisibility(8);
            Dialog dialog = this.D;
            if (dialog != null && dialog.isShowing()) {
                this.D.dismiss();
            }
            i2();
            this.tvNext1.setVisibility(8);
        }
        WearUtils.t2(this.userImg, this.G);
        GroupMember groupMember = this.G;
        if (groupMember != null) {
            this.tvName.setText(groupMember.getShowNickName());
            this.tvSubUserName.setText(this.G.getShowNickName());
        }
        C1(true);
        z2();
        if (this.t == 1) {
            ka2.C(false, this.C, new s());
        }
    }

    public int o1() {
        return this.t;
    }

    public void o2(boolean z2) {
        this.v = z2;
    }

    @OnClick({R.id.tv_cancel, R.id.tv_ok, R.id.tv_control_time, R.id.tv_next_control, R.id.tv_ds_pattern, R.id.tv_control_time_ed, R.id.tv_stop_1, R.id.iv_close, R.id.tv_select_time, R.id.tv_next, R.id.iv_pattern_list_close, R.id.tv_next_1, R.id.tv_ds_bottom_hide})
    public void onClick(View view) throws Resources.NotFoundException {
        switch (view.getId()) {
            case R.id.iv_close /* 2131363116 */:
                this.llExpand.setVisibility(8);
                if (this.t == 1) {
                    this.llControlLayout.setVisibility(0);
                    this.flWaitControlAndEdParent.setVisibility(8);
                } else {
                    this.llControlLayout.setVisibility(8);
                    this.flWaitControlAndEdParent.setVisibility(0);
                    this.llWaitControlAndEd.setVisibility(0);
                    if (this.t == 2) {
                        this.llRealControlEd.setVisibility(0);
                        this.llWaitControl.setVisibility(8);
                        this.vSubMarginView.setVisibility(0);
                        this.tvWaitControlTip.setVisibility(8);
                    } else {
                        this.llRealControlEd.setVisibility(8);
                        this.llWaitControl.setVisibility(0);
                        this.vSubMarginView.setVisibility(8);
                        this.tvWaitControlTip.setVisibility(0);
                    }
                    v2();
                }
                this.multiControlPanel.setVisibility(0);
                this.multiControlPanel.g0();
                break;
            case R.id.iv_pattern_list_close /* 2131363239 */:
                this.E = false;
                if (qf3.a) {
                    rq1.d.q();
                    m2();
                    qf3.C();
                    this.w.notifyDataSetChanged();
                }
                E1();
                ou3.c();
                break;
            case R.id.tv_cancel /* 2131364956 */:
                this.llWaitControlAndEd.setVisibility(0);
                this.llSettingTime.setVisibility(8);
                this.tvControledTime.setText(WearUtils.J0(this.M / 1000));
                break;
            case R.id.tv_control_time /* 2131365010 */:
                g1();
                break;
            case R.id.tv_control_time_ed /* 2131365013 */:
                m1(I(), true, false);
                break;
            case R.id.tv_ds_bottom_hide /* 2131365061 */:
                E2(true);
                break;
            case R.id.tv_ds_pattern /* 2131365064 */:
                this.E = !this.E;
                rq1.d.q();
                m2();
                if (qf3.a && !this.E) {
                    qf3.C();
                    this.w.notifyDataSetChanged();
                }
                E1();
                break;
            case R.id.tv_next /* 2131365204 */:
                g2("SWITCH_TO_NEXT_ONE");
                break;
            case R.id.tv_next_1 /* 2131365205 */:
                g2("SWITCH_TO_NEXT_ONE");
                break;
            case R.id.tv_next_control /* 2131365206 */:
                this.llControlLayout.setVisibility(8);
                this.llWaitControlAndEd.setVisibility(8);
                this.llSettingTime.setVisibility(8);
                this.llExpand.setVisibility(0);
                this.multiControlPanel.setVisibility(8);
                break;
            case R.id.tv_ok /* 2131365222 */:
                this.llWaitControlAndEd.setVisibility(0);
                this.llSettingTime.setVisibility(8);
                this.M = (this.sbChangeTime.getProgress() + 1) * 10 * 1000;
                this.tvSelectTime.setText(String.format(ah4.e(R.string.ds_waiting_panel_duration_tip), WearUtils.Q(this.M / 1000)));
                TargeterUpdateControlTimeRequest targeterUpdateControlTimeRequest = new TargeterUpdateControlTimeRequest();
                targeterUpdateControlTimeRequest.setRoomId(((Group) this.c).getId());
                targeterUpdateControlTimeRequest.setControlTime((this.M / 1000) + "");
                this.x.d(targeterUpdateControlTimeRequest);
                break;
            case R.id.tv_select_time /* 2131365295 */:
                this.llWaitControlAndEd.setVisibility(8);
                this.llSettingTime.setVisibility(0);
                this.tvControledTime.setText(WearUtils.J0(this.M / 1000));
                this.sbChangeTime.setProgress((int) (((this.M / 1000) / 10) - 1));
                this.sbChangeTime.setOnSeekBarChangeListener(new n0());
                break;
            case R.id.tv_stop_1 /* 2131365333 */:
                m1(I(), true, false);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (!TextUtils.isEmpty(xc1Var.a()) && r() && this.t == 2) {
            List<Toy> list = this.C;
            if (list != null && list.size() > 0) {
                Toy toy = new Toy();
                this.W = toy;
                toy.setDeviceId(this.C.get(0).getDeviceId());
                this.W.setName(this.C.get(0).getName());
                this.W.synNameToType();
            }
            I2(true);
        }
    }

    public void p1(String str, boolean z2) {
        if (this.c == 0) {
            return;
        }
        q1(z2);
    }

    public void p2(int i2) {
        this.t = i2;
        if (i2 != 0) {
            h12.D.isGroupDSChat = true;
            EventBus.getDefault().post(h12.D);
        } else {
            h12.D.isGroupDSChat = false;
        }
        ob2.o().H(0);
    }

    public void pauseConnon(int i2) {
    }

    public final void q1(boolean z2) {
        if (((Group) this.c).isExit()) {
            E e2 = this.f;
            if (e2 != 0) {
                ((gv1) e2).r3(this.c, false);
                return;
            }
            return;
        }
        if (z2) {
            this.i = 0;
            q2("00:00");
        }
        f2("getGroupInfoV2", new x());
    }

    public final void q2(String str) {
        this.tvControlTime.setText(str);
        this.multiControlPanel.setControlTimer(str);
    }

    @Override // dc.ra2
    public boolean r() {
        return o1() != 0;
    }

    public void recovery() {
    }

    public void s1(String str, boolean z2) {
        try {
            Dialog dialog = this.D;
            if (dialog instanceof GroupDSWaitAccpetDialog) {
                GroupDSWaitAccpetDialog groupDSWaitAccpetDialog = (GroupDSWaitAccpetDialog) dialog;
                if (groupDSWaitAccpetDialog.f() != null && groupDSWaitAccpetDialog.isShowing() && groupDSWaitAccpetDialog.f().c.equals(str)) {
                    groupDSWaitAccpetDialog.p(z2);
                }
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void s2() throws Resources.NotFoundException {
        this.multiControlPanel.U();
        B1();
    }

    public void stop(int i2) {
        if (r()) {
            U(new g0());
        } else if (H1()) {
            B();
        }
    }

    public final void t1(HashMap<String, Order> map, boolean z2) {
        String str;
        String str2;
        String deviceId;
        Toy toyR;
        for (String str3 : map.keySet()) {
            Order order = map.get(str3);
            if (order.getV() != -1) {
                str = order.getV() + ",";
                str2 = "v,";
            } else {
                str = "";
                str2 = str;
            }
            if (order.getR() != -1) {
                str2 = str2 + "r,";
                str = str + order.getR() + ",";
            }
            if (order.getP() != -1) {
                str2 = str2 + "p,";
                str = str + order.getP() + ",";
            }
            if (order.getV1() != -1) {
                str2 = str2 + "v1,";
                str = str + order.getV1() + ",";
            }
            if (order.getV2() != -1) {
                str2 = str2 + "v2,";
                str = str + order.getV2() + ",";
            }
            if (order.getV3() != -1) {
                str2 = str2 + "v3,";
                str = str + order.getV3() + ",";
            }
            if (order.getT() != -1) {
                str2 = str2 + "t,";
                str = str + order.getT() + ",";
            }
            if (order.getS() != -1) {
                str2 = str2 + "s,";
                str = str + order.getS() + ",";
            }
            if (order.getF() != -1) {
                str2 = str2 + "f,";
                str = str + order.getF() + ",";
            }
            if (order.getD() != -1) {
                str2 = str2 + "d,";
                str = str + order.getD() + ",";
            }
            if (order.getPos() != -1) {
                str2 = str2 + "pos,";
                str = str + order.getPos() + ",";
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                String strSubstring = str2.substring(0, str2.length() - 1);
                String strSubstring2 = str.substring(0, str.length() - 1);
                String strChangeToyValueToSinglefuncLine = Toy.changeToyValueToSinglefuncLine(strSubstring, strSubstring2);
                boolean zContains = str3.contains(SignatureImpl.INNER_SEP);
                List<Toy> list = this.C;
                if (list != null) {
                    for (Toy toy : list) {
                        String address = toy.getAddress();
                        if (zContains) {
                            if (WearUtils.e1(address) && str3.replace(SignatureImpl.INNER_SEP, "").toLowerCase().equals(toy.getDeviceId())) {
                                deviceId = toy.getDeviceId();
                                break;
                            }
                        } else {
                            if (!WearUtils.e1(address) && toy.getDeviceId().equals(str3)) {
                                deviceId = address;
                                break;
                            }
                        }
                    }
                    deviceId = str3;
                    l1(deviceId, strSubstring, strChangeToyValueToSinglefuncLine);
                    if (this.t != 2 && !z2 && (toyR = pc1.a.R(str3)) != null) {
                        if (mp1.h() || !toyR.isBAToy()) {
                            rq1.d.o(toyR.getAddress(), Arrays.asList(strSubstring.split(",")), Arrays.asList(strSubstring2.split(",")), new ToyControlBuilder(false, true, false, qa2.a() ? ToyControlBuilder.a.SPEED : ToyControlBuilder.a.SETTING_ONLY));
                        } else {
                            d2(toyR, order);
                        }
                    }
                } else {
                    deviceId = str3;
                    l1(deviceId, strSubstring, strChangeToyValueToSinglefuncLine);
                    if (this.t != 2) {
                    }
                }
            }
        }
    }

    public final void t2() {
        GroupToysBatteryAdapter groupToysBatteryAdapter = this.T;
        if (groupToysBatteryAdapter == null) {
            this.T = new GroupToysBatteryAdapter((ArrayList) this.C, R.layout.item_group_toy_battery);
        } else {
            groupToysBatteryAdapter.z((ArrayList) this.C);
        }
        AutoLineFeedLayoutManager autoLineFeedLayoutManager = new AutoLineFeedLayoutManager();
        autoLineFeedLayoutManager.setAutoMeasureEnabled(true);
        this.toysInfoRecyclerView.setLayoutManager(autoLineFeedLayoutManager);
        this.toysInfoRecyclerView.setAdapter(this.T);
        GroupToysBatteryAdapter groupToysBatteryAdapter2 = this.U;
        if (groupToysBatteryAdapter2 == null) {
            this.U = new GroupToysBatteryAdapter((ArrayList) this.C, R.layout.item_group_toy_battery);
        } else {
            groupToysBatteryAdapter2.z((ArrayList) this.C);
        }
        AutoLineFeedLayoutManager autoLineFeedLayoutManager2 = new AutoLineFeedLayoutManager();
        autoLineFeedLayoutManager2.setAutoMeasureEnabled(true);
        this.toysInfoExpandRecyclerView.setLayoutManager(autoLineFeedLayoutManager2);
        this.toysInfoExpandRecyclerView.setAdapter(this.T);
    }

    public void u1() {
        jp3 jp3Var = this.a0;
        if (jp3Var != null) {
            jp3Var.e();
        }
    }

    public void u2(VelvoPreviewView velvoPreviewView) {
        if (velvoPreviewView == null) {
            return;
        }
        this.a0 = new jp3(this.multiControlPanel, velvoPreviewView, "GROUP_CHAT_DS_CONTROL");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.s82
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.Q1(str);
            }
        });
    }

    public final void v1(ArrayList<GroupMember> arrayList) {
        if (this.K == null || this.t == 0) {
            return;
        }
        if (arrayList != null) {
            this.r.clear();
            this.r.addAll(arrayList);
        }
        this.s.clear();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z2 = false;
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            GroupMember groupMember = (GroupMember) this.r.get(i2);
            if (z2 && groupMember.getDSStatus() == 4) {
                arrayList2.add(groupMember);
            }
            if (groupMember.getJid().equals(this.K.getJid())) {
                arrayList2.add(0, groupMember);
                z2 = true;
            }
            if (!z2 && groupMember.getDSStatus() == 4) {
                arrayList3.add(groupMember);
            }
            if (groupMember.getDSStatus() != 4 && groupMember.getDSStatus() != 2) {
                arrayList4.add(groupMember);
            }
        }
        arrayList2.addAll(arrayList3);
        arrayList2.addAll(arrayList4);
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            if (((GroupMember) arrayList2.get(i4)).getJid().equals(ch3.n().p())) {
                i3 = i4;
            }
            if (this.s.size() >= 6) {
                if (i3 != 0) {
                    break;
                }
            } else {
                this.s.add((IPeopleInfo) arrayList2.get(i4));
            }
        }
        if (this.r.size() > 6) {
            FootUser footUser = new FootUser(1);
            footUser.setCount(this.r.size() - 6);
            this.s.add(footUser);
        }
        DsControlBoardOneLineAdapter dsControlBoardOneLineAdapter = this.y;
        if (dsControlBoardOneLineAdapter == null) {
            DsControlBoardOneLineAdapter dsControlBoardOneLineAdapter2 = new DsControlBoardOneLineAdapter(this.s, R.layout.item_ds_control_board_one_line);
            this.y = dsControlBoardOneLineAdapter2;
            cg3.a(this.rvPeople, dsControlBoardOneLineAdapter2, 7);
            this.y.s(this);
            this.y.z(this);
        } else {
            dsControlBoardOneLineAdapter.notifyDataSetChanged();
        }
        DsControlBoardAllAdapter dsControlBoardAllAdapter = this.N;
        if (dsControlBoardAllAdapter == null) {
            DsControlBoardAllAdapter dsControlBoardAllAdapter2 = new DsControlBoardAllAdapter(this.r, R.layout.item_ds_control_board_all);
            this.N = dsControlBoardAllAdapter2;
            cg3.a(this.rvPeopleAll, dsControlBoardAllAdapter2, 7);
            this.N.s(this);
        } else {
            dsControlBoardAllAdapter.notifyDataSetChanged();
        }
        if (this.t == 3) {
            this.tvWaitControlNumb.setText(String.format(ah4.f(R.string.ds_waiting_panel_order, WearUtils.w0(i3 + 1)), new Object[0]));
        }
    }

    public final void v2() {
        this.tvWaitControlTip.setTextColor(th4.b(WearUtils.x, R.color.text_color_45));
        int i2 = this.t;
        if (i2 != 2) {
            if (i2 == 3) {
                this.tvWaitControlTip.setVisibility(0);
                if (this.O) {
                    this.tvWaitControlTip.setText(String.format(ah4.e(R.string.ds_waiting_panel_duration_tip), WearUtils.Q(this.M / 1000)));
                    return;
                } else {
                    this.tvWaitControlTip.setText(ah4.e(R.string.ds_panels_sub_poor_network));
                    return;
                }
            }
            return;
        }
        if (this.P || this.K == null) {
            this.tvWaitControlTip.setVisibility(8);
            this.vSubMarginView.setVisibility(0);
        } else {
            this.tvWaitControlTip.setVisibility(0);
            this.vSubMarginView.setVisibility(8);
            this.tvWaitControlTip.setTextColor(th4.b(WearUtils.x, R.color.select_text_color));
            this.tvWaitControlTip.setText(String.format(ah4.e(R.string.ds_sub_panel_dom_is_offline), this.K.getNickName()));
        }
    }

    public final void w1() {
        d0(this.g, R.drawable.full_control_ds, "ds_dark.json");
        sz1.d().n(this);
        GroupDSPatternAdapter groupDSPatternAdapter = new GroupDSPatternAdapter(this.F, R.layout.item_group_ds_pattern);
        this.w = groupDSPatternAdapter;
        cg3.f(this.rvPattern, groupDSPatternAdapter);
        this.w.D(new o0());
        D1();
    }

    public void w2() {
        if (!r()) {
            F();
            return;
        }
        W();
        this.b0 = false;
        ViewGroup viewGroup = (ViewGroup) this.V.getParent();
        if (viewGroup != null) {
            u1();
            viewGroup.removeView(this.V);
        }
    }

    public final void x1(ArrayList<GroupMember> arrayList) {
        this.r.clear();
        this.r.addAll(arrayList);
    }

    public final void x2(boolean z2) {
        if (z2) {
            F();
        }
        E e2 = this.f;
        if (e2 != 0) {
            ((gv1) e2).l(this.c);
        }
    }

    public final void y1(GroupMember groupMember, String str) {
        SyncLinkToy syncLinkToy;
        if (TextUtils.isEmpty(str)) {
            syncLinkToy = null;
        } else {
            String strDecrypt = CommunMessage.decrypt(str);
            String str2 = "initGroupMemberToy: " + strDecrypt;
            syncLinkToy = (SyncLinkToy) JSON.parseObject(strDecrypt, SyncLinkToy.class);
        }
        if (syncLinkToy == null || syncLinkToy.getToys() == null) {
            groupMember.setToys(null);
        } else {
            groupMember.setToys(syncLinkToy.getToys());
        }
    }

    public void y2(Group group) {
        if (r()) {
            if (k1(group.getId())) {
                W();
            } else {
                z2();
            }
        }
    }

    @Override // dc.ka2
    public boolean z() {
        return r() || H1();
    }

    public final void z1() {
        p2(0);
        this.i = 0;
        F();
    }

    public void z2() {
        if (r()) {
            F();
            if (this.f != 0) {
                this.b0 = true;
                A2();
                ((gv1) this.f).n0(this.c, this.V);
            }
        }
    }

    public ChatDSControl() {
        this.p = false;
        pc1 pc1Var = pc1.a;
        this.q = new Handler(Looper.getMainLooper());
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
        this.t = 0;
        this.u = false;
        this.x = wb2.b();
        this.z = new MultiToOneToyOrderRequest();
        this.A = new HashMap<>();
        this.F = new ArrayList<>();
        this.L = 0L;
        this.M = 30000L;
        this.O = true;
        this.P = true;
        this.Q = 0;
        this.X = false;
        this.Y = new Handler(Looper.getMainLooper());
        this.b0 = false;
        this.g = WearUtils.x;
        this.b = ch3.n().u();
        U(new k());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToyDSLocalEvent toyDSLocalEvent) {
        if (this.t == 2) {
            I2(false);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChangeToyEvent changeToyEvent) {
        if (this.t == 2) {
            C1(false);
            I2(false);
        }
    }
}
