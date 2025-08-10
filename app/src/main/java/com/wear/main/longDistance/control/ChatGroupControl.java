package com.wear.main.longDistance.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.wear.adapter.longdistance.FriendControlAdapter;
import com.wear.adapter.longdistance.GroupControlPatternAdapter;
import com.wear.adapter.longdistance.GroupLdrToyAdapter;
import com.wear.adapter.longdistance.GroupToysBatteryAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.Pattern;
import com.wear.bean.RateFeature;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.bean.event.ReCheckRoomStatusEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.controlLink.request.ToyCommandBean;
import com.wear.bean.socketio.msg.Order;
import com.wear.bean.socketio.msg.response.ChangeLdrToyTypeResponse;
import com.wear.bean.socketio.msg.response.ChangeToSyncMasterResponse;
import com.wear.bean.socketio.msg.response.ClearExitPlayerResponse;
import com.wear.bean.socketio.msg.response.CreateRoomSyncResponse;
import com.wear.bean.socketio.msg.response.MasterLineStatusNotifyResponse;
import com.wear.bean.socketio.msg.response.PlayerAcceptRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveAllRejectRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveCancelRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveEndRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveLdrControlResponse;
import com.wear.bean.socketio.msg.response.ReceivePlayerRejectRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomBeControllerToyInfoResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomControllerToyInfoResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomRemoteControlResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomSyncToyResponse;
import com.wear.bean.socketio.msg.response.RoomReceiveSyncResponse;
import com.wear.bean.socketio.msg.response.UpdateSyncMasterResponse;
import com.wear.bean.socketio.msg.reuqest.AcceptRoomSyncRequest;
import com.wear.bean.socketio.msg.reuqest.AccusedPartyRefuseRequest;
import com.wear.bean.socketio.msg.reuqest.CancelRoomSyncRequest;
import com.wear.bean.socketio.msg.reuqest.ChangeRoomControllerRequest;
import com.wear.bean.socketio.msg.reuqest.EndRoomsSyncRequest;
import com.wear.bean.socketio.msg.reuqest.GetGroupInfoRequest;
import com.wear.bean.socketio.msg.reuqest.PlayerExitSyncRequest;
import com.wear.bean.socketio.msg.reuqest.RoomSendSyncRequest;
import com.wear.bean.socketio.msg.reuqest.RoomSyncHeartbeatRequest;
import com.wear.bean.socketio.msg.reuqest.SendRoomSyncToyRequest;
import com.wear.bean.socketio.msg.reuqest.SetLdrToyTypeRequest;
import com.wear.bean.socketio.msg.reuqest.SwitchRoomLDRRequest;
import com.wear.bean.socketio.msg.reuqest.SwitchRoomRemoteControlRequest;
import com.wear.bean.socketio.msg.reuqest.SyncTransferStatusRequest;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityToy;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.AutoLineFeedLayoutManager;
import com.wear.widget.control.TouchControlView;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.dialog.GroupControlMemberInfoDialog;
import com.wear.widget.dialog.GroupControlWaitAccpetDialog;
import com.wear.widget.dialog.GroupControledWaitAccpetDialog;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.ce3;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.ff3;
import dc.gg3;
import dc.gu3;
import dc.gv1;
import dc.h12;
import dc.h32;
import dc.hh0;
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
import dc.qf3;
import dc.rn3;
import dc.rq1;
import dc.sg3;
import dc.sz1;
import dc.th4;
import dc.ua2;
import dc.vb2;
import dc.vc1;
import dc.ve0;
import dc.xc1;
import dc.xe2;
import dc.xe3;
import dc.xz1;
import dc.y12;
import dc.ye3;
import dc.yf3;
import dc.yg3;
import dc.zb2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX WARN: Unexpected interfaces in signature: [dc.yc1, dc.tz1] */
/* loaded from: classes3.dex */
public class ChatGroupControl extends la2<Group, gv1> implements Object, Object, BaseAdapter.b<GroupMember> {
    public boolean A;
    public boolean B;
    public boolean C;
    public GroupControlPatternAdapter D;
    public vb2 E;
    public GroupMember F;
    public String G;
    public SendRoomSyncToyRequest K;
    public boolean L;
    public Dialog M;
    public String N;
    public GroupToysBatteryAdapter O;
    public ArrayList<Toy> P;
    public GroupToysBatteryAdapter Q;
    public ArrayList<Toy> R;
    public boolean S;
    public ArrayList<Pattern> T;
    public GroupLdrToyAdapter U;
    public ArrayList<Toy> V;
    public ArrayList<Toy> W;
    public ArrayList<Toy> X;
    public GroupLdrToyAdapter Y;
    public ArrayList<Toy> Z;
    public GroupLdrToyAdapter a0;
    public Toy b0;
    public int c0;

    @BindView(R.id.cl_ldr_controlled)
    public ConstraintLayout clLdrControlled;

    @BindView(R.id.cl_ldr_master_control)
    public ConstraintLayout clLdrMasterControl;

    @BindView(R.id.cl_remote_controled)
    public ConstraintLayout clRemoteControled;
    public List<List<Ball2CurveEventBean>> d0;
    public List<Ball2CurveEventBean> e0;
    public View f0;
    public String g0;
    public jp3 h0;

    @BindView(R.id.iv_friend_avatar)
    public RoundedImageView ivFriendAvatar;

    @BindView(R.id.iv_friend_avatar_1)
    public RoundedImageView ivFriendAvatar1;

    @BindView(R.id.iv_i_avatar_1)
    public RoundedImageView ivIAvatar1;

    @BindView(R.id.iv_ldr_control_states)
    public ImageView ivLdrControlStates;

    @BindView(R.id.iv_ldr_control_states_temp)
    public ImageView ivLdrControlStatesTemp;

    @BindView(R.id.iv_remote_controled)
    public ImageView ivRemoteControled;

    @BindView(R.id.iv_self_avatar)
    public RoundedImageView ivSelfAvatar;

    @BindView(R.id.iv_show_more_friend)
    public ImageView ivShowMoreFriend;

    @BindView(R.id.iv_show_more_friend_1)
    public ImageView ivShowMoreFriend1;

    @BindView(R.id.ll_control)
    public LinearLayout llControl;

    @BindView(R.id.ll_control_bottom)
    public LinearLayout llControlBottom;

    @BindView(R.id.ll_control_friends)
    public LinearLayout llControlFriends;

    @BindView(R.id.multi_control_panel)
    public MultiControlPanel multiControlPanel;
    public pc1 p;
    public Handler q;
    public ArrayList<GroupMember> r;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_friend_toy)
    public RecyclerView rvFriendToy;

    @BindView(R.id.rv_ldr_master_control_toy)
    public RecyclerView rvLdrMasterControlToy;

    @BindView(R.id.rv_master_toy_list)
    public RecyclerView rvMasterToysBatteryView;

    @BindView(R.id.rv_toy_list)
    public RecyclerView rvMyToysBatteryView;

    @BindView(R.id.rv_pattern)
    public RecyclerView rvPattern;

    @BindView(R.id.rv_self_toy)
    public RecyclerView rvSelfToy;
    public vb2 s;
    public int t;

    @BindView(R.id.tv_center)
    public TextView tvCenter;

    @BindView(R.id.tv_control_dlr)
    public TextView tvControlDlr;

    @BindView(R.id.tv_control_pattern)
    public TextView tvControlPattern;

    @BindView(R.id.tv_end_control_time)
    public TextView tvEndControlTime;

    @BindView(R.id.tv_friend_user_name)
    public TextView tvFriendUserName;

    @BindView(R.id.tv_friend_user_name_1)
    public TextView tvFriendUserName1;

    @BindView(R.id.tv_i_user_name_1)
    public TextView tvIUserName1;

    @BindView(R.id.tv_ldr_wait_reconnect_tip)
    public TextView tvLdrWaitReconnectTip;

    @BindView(R.id.tv_me)
    public TextView tvMe;

    @BindView(R.id.tv_remote_control)
    public TextView tvRemoteControl;

    @BindView(R.id.tv_remote_wait_reconnect_tip)
    public TextView tvRemoteWaitReconnectTip;

    @BindView(R.id.tv_self_user_name)
    public TextView tvSelfUserName;
    public boolean u;
    public FriendControlAdapter v;
    public ArrayList<GroupMember> w;
    public ArrayList<GroupMember> x;
    public boolean y;
    public boolean z;

    public class a implements mf2 {
        public a() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            chatGroupControl.z = true;
            chatGroupControl.s1();
            ChatGroupControl.this.clRemoteControled.setVisibility(8);
            ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
            if (chatGroupControl2.y) {
                chatGroupControl2.y2();
                if (qf3.a) {
                    rq1.d.q();
                    qf3.C();
                    ChatGroupControl.this.D.notifyDataSetChanged();
                }
                ChatGroupControl.this.multiControlPanel.K();
                ChatGroupControl.this.multiControlPanel.setVisibility(8);
                ChatGroupControl.this.llControlFriends.setVisibility(0);
                ChatGroupControl.this.clLdrMasterControl.setVisibility(0);
                ChatGroupControl.this.Z2(2);
                ChatGroupControl.this.ivShowMoreFriend1.setVisibility(8);
                ChatGroupControl.this.ivShowMoreFriend.setVisibility(0);
                ChatGroupControl chatGroupControl3 = ChatGroupControl.this;
                if (chatGroupControl3.C) {
                    chatGroupControl3.C = false;
                    chatGroupControl3.t3();
                }
                ChatGroupControl.this.S = false;
                ChatGroupControl.this.rvPattern.setVisibility(8);
                if (ChatGroupControl.this.b0 != null) {
                    SetLdrToyTypeRequest setLdrToyTypeRequest = new SetLdrToyTypeRequest();
                    setLdrToyTypeRequest.setToyType(ChatGroupControl.this.b0.getAndUpdateDeviceId());
                    setLdrToyTypeRequest.setRoomId(((Group) ChatGroupControl.this.c).getId());
                    ChatGroupControl.this.E.d(setLdrToyTypeRequest);
                }
            } else {
                chatGroupControl2.multiControlPanel.setVisibility(8);
                ChatGroupControl.this.llControlFriends.setVisibility(0);
                ChatGroupControl.this.clLdrMasterControl.setVisibility(8);
                ChatGroupControl.this.Z2(0);
                ChatGroupControl.this.clLdrControlled.setVisibility(0);
                ChatGroupControl.this.ivShowMoreFriend1.setVisibility(8);
                ChatGroupControl.this.ivShowMoreFriend.setVisibility(0);
                ChatGroupControl chatGroupControl4 = ChatGroupControl.this;
                if (chatGroupControl4.C) {
                    chatGroupControl4.C = false;
                    chatGroupControl4.t3();
                }
                ChatGroupControl.this.S = false;
                ChatGroupControl.this.rvPattern.setVisibility(8);
            }
            me3.d(me3.c.GROUP_CHAT_SYNC_CONTROL_SENCE_BEGIN, me3.a());
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class a0 implements ka2.k {
        public a0() {
        }

        @Override // dc.ka2.k
        public void a() {
            ChatGroupControl.this.multiControlPanel.k0(true);
        }
    }

    public class b implements GroupControlMemberInfoDialog.b {

        public class a implements mf2 {
            public final /* synthetic */ GroupMember a;

            public a(GroupMember groupMember) {
                this.a = groupMember;
            }

            @Override // dc.mf2
            public void Q(String str) {
                ChatGroupControl.this.b0 = null;
                sg3.l(ah4.e(R.string.group_chat_controller_transfer_successed));
                ChatGroupControl.this.m1(false);
                rq1.d.q();
            }

            @Override // dc.mf2
            public void a(Throwable th) {
                if (th instanceof TimeoutException) {
                    sg3.l(String.format(ah4.e(R.string.group_chat_controller_transfer_failed), this.a.getNickName()));
                }
            }
        }

        public b() {
        }

        @Override // com.wear.widget.dialog.GroupControlMemberInfoDialog.b
        public void a(GroupMember groupMember) {
            ChangeRoomControllerRequest changeRoomControllerRequest = new ChangeRoomControllerRequest();
            changeRoomControllerRequest.setRoomId(((Group) ChatGroupControl.this.c).getId());
            changeRoomControllerRequest.setJid(groupMember.getJid());
            changeRoomControllerRequest.setAckId(WearUtils.E());
            ChatGroupControl.this.E.a(changeRoomControllerRequest, new a(groupMember));
        }
    }

    public class b0 implements is3.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Activity b;

        public b0(boolean z, Activity activity) {
            this.a = z;
            this.b = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pc1.a.I();
            if (ChatGroupControl.this.r()) {
                ChatGroupControl.this.a();
                if (this.a) {
                    this.b.finish();
                }
            }
        }
    }

    public class c implements View.OnClickListener {
        public c(ChatGroupControl chatGroupControl) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c0 implements Runnable {
        public c0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatGroupControl.this.h1(ChatGroupControl.this.I(), false, false);
        }
    }

    public class d implements mf2 {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatGroupControl.this.y = false;
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH == null || fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            me3.d(me3.c.GROUP_CHAT_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
            ye3.c("friend chatroom", "begin group sync control", ChatGroupControl.this.G);
            pj3.j(fragmentActivityH, ChatRoomActivity.class, "roomId", this.a);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            th.printStackTrace();
        }
    }

    public class d0 implements mf2 {
        public final /* synthetic */ Activity a;

        public class a implements is3.c {
            public a() {
            }

            @Override // dc.is3.c
            public void doCancel() {
                ChatGroupControl.this.B();
            }
        }

        public class b implements DialogInterface.OnDismissListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ChatGroupControl chatGroupControl = ChatGroupControl.this;
                chatGroupControl.M = null;
                chatGroupControl.a3(false);
            }
        }

        public d0(Activity activity) {
            this.a = activity;
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            E e = chatGroupControl.f;
            if (e != 0) {
                ((gv1) e).r3(chatGroupControl.c, false);
            }
            CreateRoomSyncResponse createRoomSyncResponse = (CreateRoomSyncResponse) JSON.parseObject(str, CreateRoomSyncResponse.class);
            if (!createRoomSyncResponse.suc()) {
                Integer num = createRoomSyncResponse.status;
                if (num == null) {
                    return;
                }
                if (num.intValue() == 4) {
                    sg3.l(ah4.e(R.string.group_sync_in_progress));
                    return;
                }
                sg3.l(String.format(ah4.e(R.string.group_room_sync_failed), createRoomSyncResponse.status + ""));
                return;
            }
            try {
                MusicControl.h0().S();
                y12.c.a().t();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ArrayList<GroupMember> arrayList = new ArrayList<>();
            for (CreateRoomSyncResponse.PlayerListBean playerListBean : createRoomSyncResponse.getPlayerList()) {
                GroupMember memberByJid = ((Group) ChatGroupControl.this.c).getMemberByJid(playerListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setStatus(playerListBean.getStatus());
                    arrayList.add(memberByJid);
                }
            }
            is3.b bVar = new is3.b(this.a);
            bVar.e(arrayList);
            bVar.x(ce3.a(ChatGroupControl.this.g, 311.0f));
            bVar.c(new a());
            ChatGroupControl.this.M = cs3.i(bVar, GroupControlWaitAccpetDialog.class);
            ChatGroupControl.this.M.show();
            ChatGroupControl.this.t1(arrayList);
            ChatGroupControl.this.a3(true);
            ChatGroupControl.this.M.setOnDismissListener(new b());
            ChatGroupControl.this.y = true;
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C325.toString(), null);
            ChatGroupControl.this.Q2(entitySystem, MessageType.system);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            E e = chatGroupControl.f;
            if (e != 0) {
                ((gv1) e).r3(chatGroupControl.c, false);
            }
        }
    }

    public class e implements mf2 {
        public e() {
        }

        @Override // dc.mf2
        public void Q(String str) throws Resources.NotFoundException {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            E e = chatGroupControl.f;
            if (e != 0) {
                ((gv1) e).r3(chatGroupControl.c, false);
            }
            ChatGroupControl.this.s2(str);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            E e = chatGroupControl.f;
            if (e != 0) {
                ((gv1) e).r3(chatGroupControl.c, false);
            }
        }
    }

    public class e0 extends GridLayoutManager {
        public e0(ChatGroupControl chatGroupControl, Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean isAutoMeasureEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, int i2) {
            super.onMeasure(recycler, state, i, i2);
            int itemCount = state.getItemCount();
            int spanCount = getSpanCount();
            if (itemCount <= 0 || spanCount == 0) {
                return;
            }
            View viewForPosition = recycler.getViewForPosition(0);
            measureChild(viewForPosition, i, i2);
            int measuredHeight = viewForPosition.getMeasuredHeight();
            int i3 = itemCount / spanCount;
            if (itemCount % spanCount != 0) {
                i3++;
            }
            int i4 = measuredHeight * i3;
            if (i3 >= 5) {
                i4 = measuredHeight * 5;
            }
            setMeasuredDimension(i, i4);
        }
    }

    public class f implements MultiControlPanel.r {
        public f() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public /* synthetic */ void b(String str) {
            ip3.a(this, str);
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public void f(List<Ball2CurveEventBean> list) {
            ChatGroupControl chatGroupControl;
            boolean z;
            boolean z2;
            if (ChatGroupControl.this.S || !(z = (chatGroupControl = ChatGroupControl.this).y) || qf3.a) {
                return;
            }
            if (!(chatGroupControl.z && chatGroupControl.A && z) && chatGroupControl.r()) {
                ChatGroupControl.this.h0.k(list);
                Iterator<Ball2CurveEventBean> it = list.iterator();
                String function = "";
                String groups = "";
                String toyAddress = groups;
                boolean z3 = false;
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Ball2CurveEventBean next = it.next();
                    if (!WearUtils.e1(next.getFunction())) {
                        function = WearUtils.e1(function) ? next.getFunction() : function + "," + next.getFunction();
                    }
                    if (!WearUtils.e1(next.getGroups())) {
                        groups = WearUtils.e1(groups) ? next.getGroups() : groups + "," + next.getGroups();
                    }
                    if (next.isRotateChange()) {
                        toyAddress = next.getToyAddress();
                        z3 = true;
                    }
                }
                boolean zA = ou3.a(function, groups);
                if (z3) {
                    ou3.c();
                } else {
                    z2 = zA;
                }
                if (z2) {
                    Order order = new Order();
                    if (z3) {
                        ChatGroupControl.this.S2(toyAddress);
                        order.setR(-2);
                    } else {
                        ChatGroupControl.this.U2(function, groups);
                        String[] strArrSplit = Toy.changeSinglefuncLineToTayValue(function, groups).split(TouchControlView.O);
                        String[] strArrSplit2 = function.split(TouchControlView.O);
                        if (strArrSplit2.length == strArrSplit.length) {
                            for (int i = 0; i < strArrSplit2.length; i++) {
                                String str = strArrSplit[i];
                                if (!TextUtils.isEmpty(str)) {
                                    if (PSOProgramService.VS_Key.equals(strArrSplit2[i])) {
                                        order.setV(Integer.parseInt(str));
                                    }
                                    if ("p".equals(strArrSplit2[i])) {
                                        order.setP(Integer.parseInt(str));
                                    }
                                    if (StreamManagement.AckRequest.ELEMENT.equals(strArrSplit2[i])) {
                                        order.setR(Integer.parseInt(str));
                                    }
                                    if ("t".equals(strArrSplit2[i])) {
                                        order.setT(Integer.parseInt(str));
                                    }
                                    if ("s".equals(strArrSplit2[i])) {
                                        order.setS(Integer.parseInt(str));
                                    }
                                    if ("f".equals(strArrSplit2[i])) {
                                        order.setF(Integer.parseInt(str));
                                    }
                                    if (GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(strArrSplit2[i])) {
                                        order.setD(Integer.parseInt(str));
                                    }
                                    if ("pos".equals(strArrSplit2[i])) {
                                        order.setPos(Integer.parseInt(str));
                                    }
                                }
                            }
                        }
                    }
                    ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
                    if (chatGroupControl2.K == null) {
                        chatGroupControl2.K = new SendRoomSyncToyRequest();
                    }
                    ChatGroupControl.this.K.setOrder(JSON.toJSONString(order));
                    ChatGroupControl chatGroupControl3 = ChatGroupControl.this;
                    chatGroupControl3.K.setRoomId(((Group) chatGroupControl3.c).getId());
                    String str2 = "onReceiveCommand: chatGroup" + ChatGroupControl.this.K.toString();
                    ChatGroupControl chatGroupControl4 = ChatGroupControl.this;
                    chatGroupControl4.E.d(chatGroupControl4.K);
                }
            }
        }
    }

    public class f0 implements GroupLdrToyAdapter.a {
        public f0() {
        }

        @Override // com.wear.adapter.longdistance.GroupLdrToyAdapter.a
        public void a(View view) {
            ChatGroupControl.this.L2(view);
        }

        @Override // com.wear.adapter.longdistance.GroupLdrToyAdapter.a
        public void b(BaseAdapter.ViewHolder viewHolder, Toy toy, int i) {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            if (chatGroupControl.A && chatGroupControl.z && chatGroupControl.y) {
                boolean z = toy.isSupportLdr() || ChatGroupControl.this.S1(toy);
                if (!z && ChatGroupControl.this.y) {
                    sg3.h(R.string.sync_lds_click_unsupported_toy);
                }
                if (ChatGroupControl.this.a0.j == i || !z) {
                    return;
                }
                if (!toy.isConnected()) {
                    sg3.l(String.format(ah4.e(R.string.str_select_fail_by_toy_disconnected), toy.getSimpleName()));
                    return;
                }
                WearUtils.U0(ChatGroupControl.this.V);
                ChatGroupControl.this.e3(toy);
                ChatGroupControl.this.a0.j = i;
                ChatGroupControl.this.a0.notifyDataSetChanged();
                SetLdrToyTypeRequest setLdrToyTypeRequest = new SetLdrToyTypeRequest();
                setLdrToyTypeRequest.setToyType(toy.getAndUpdateDeviceId());
                setLdrToyTypeRequest.setRoomId(((Group) ChatGroupControl.this.c).getId());
                ChatGroupControl.this.E.d(setLdrToyTypeRequest);
            }
        }
    }

    public class g implements MultiControlPanel.o {
        public g() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.o
        public void a(List<MultiToyOFunBean> list, boolean z) throws Resources.NotFoundException {
            ChatGroupControl.this.c0 = list.size();
            int dimensionPixelSize = ChatGroupControl.this.I().getResources().getDimensionPixelSize(R.dimen.mutli_toys_group_sync_control_panel_height);
            int dimensionPixelSize2 = ChatGroupControl.this.I().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ChatGroupControl.this.multiControlPanel.getLayoutParams();
            if (ChatGroupControl.this.c0 < 2) {
                ChatGroupControl.this.multiControlPanel.setPanelPercent(0.16326f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize2;
            } else {
                ChatGroupControl.this.multiControlPanel.setPanelPercent(0.2807f);
                layoutParams.height = dimensionPixelSize + (dimensionPixelSize2 * 2);
            }
            ChatGroupControl.this.multiControlPanel.setLayoutParams(layoutParams);
        }
    }

    public class g0 implements GroupControlPatternAdapter.b {

        public class a extends ff3 {

            /* renamed from: com.wear.main.longDistance.control.ChatGroupControl$g0$a$a, reason: collision with other inner class name */
            public class RunnableC0128a implements Runnable {
                public RunnableC0128a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ChatGroupControl.this.D.C();
                }
            }

            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void f(int i) {
                if (ChatGroupControl.this.h0 == null || i == -1) {
                    return;
                }
                ChatGroupControl.this.h0.j(i);
            }

            @Override // dc.ff3
            public void c(boolean z, Object obj, String str) {
                if (!z || obj == null) {
                    ChatGroupControl.this.v1();
                    ChatGroupControl.this.y2();
                    ChatGroupControl.this.U(new RunnableC0128a());
                    return;
                }
                ChatGroupControl chatGroupControl = ChatGroupControl.this;
                if (!chatGroupControl.y || chatGroupControl.z) {
                    return;
                }
                String[] strArrB = ou3.B(str.split(","), obj == null ? "0" : obj.toString());
                StringBuilder sb = new StringBuilder();
                sb.append("callback: ");
                sb.append(strArrB[0]);
                sb.append("->");
                sb.append(strArrB[1]);
                sb.toString();
                if (strArrB != null && strArrB.length == 2 && (strArrB[1].length() >= strArrB[0].length() || strArrB[0].equals("pos"))) {
                    ToyCommandBean toyCommandBean = new ToyCommandBean();
                    toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
                    toyCommandBean.setAllFunc(strArrB[0], strArrB[1], false);
                    ToyBean all = toyCommandBean.getAll();
                    ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
                    if (!chatGroupControl2.y || chatGroupControl2.z) {
                        return;
                    }
                    if (all != null) {
                        final int pos = all.getPos() == -1 ? -1 : all.getPos() * 5;
                        ChatGroupControl.this.U(new Runnable() { // from class: dc.u82
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.f(pos);
                            }
                        });
                        ChatGroupControl.this.K2(all.getV(), all.getR(), all.getP(), all.getT(), all.getS(), all.getF(), all.getD(), pos);
                    }
                }
                String[] strArrSplit = strArrB[1].split(",");
                String[] strArrSplit2 = strArrB[0].split(",");
                if (strArrSplit2.length == strArrSplit.length) {
                    Order order = new Order();
                    for (int i = 0; i < strArrSplit2.length; i++) {
                        String str2 = strArrSplit[i];
                        if (!TextUtils.isEmpty(str2)) {
                            if (PSOProgramService.VS_Key.equals(strArrSplit2[i])) {
                                order.setV(Integer.parseInt(str2));
                                order.setT(Integer.parseInt(str2));
                                order.setS(Integer.parseInt(str2));
                            }
                            if ("p".equals(strArrSplit2[i])) {
                                order.setP(Integer.parseInt(str2));
                            }
                            if (StreamManagement.AckRequest.ELEMENT.equals(strArrSplit2[i])) {
                                order.setR(Integer.parseInt(str2));
                            }
                            if ("t".equals(strArrSplit2[i])) {
                                order.setT(Integer.parseInt(str2));
                            }
                            if (GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(strArrSplit2[i])) {
                                order.setD(Integer.parseInt(str2));
                            }
                            if ("s".equals(strArrSplit2[i])) {
                                order.setS(Integer.parseInt(str2));
                            }
                            if ("f".equals(strArrSplit2[i])) {
                                order.setF(Integer.parseInt(str2));
                            }
                            if ("pos".equals(strArrSplit2[i]) && Integer.parseInt(str2) != -1) {
                                order.setPos(Integer.parseInt(str2) * 5);
                            }
                        }
                    }
                    String str3 = "callback send: " + order;
                    SendRoomSyncToyRequest sendRoomSyncToyRequest = new SendRoomSyncToyRequest();
                    sendRoomSyncToyRequest.setOrder(JSON.toJSONString(order));
                    sendRoomSyncToyRequest.setRoomId(((Group) ChatGroupControl.this.c).getId());
                    ChatGroupControl.this.E.d(sendRoomSyncToyRequest);
                }
            }
        }

        public g0() {
        }

        @Override // com.wear.adapter.longdistance.GroupControlPatternAdapter.b
        public void a(Pattern pattern) {
            qf3.B(pattern, 2, new a());
        }

        @Override // com.wear.adapter.longdistance.GroupControlPatternAdapter.b
        public void onPause() {
            ChatGroupControl.this.v1();
            ChatGroupControl.this.y2();
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ ReceiveCancelRoomSyncResponse a;

        public h(ReceiveCancelRoomSyncResponse receiveCancelRoomSyncResponse) {
            this.a = receiveCancelRoomSyncResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = ChatGroupControl.this.M;
            if (dialog instanceof GroupControledWaitAccpetDialog) {
                GroupControledWaitAccpetDialog groupControledWaitAccpetDialog = (GroupControledWaitAccpetDialog) dialog;
                if (groupControledWaitAccpetDialog.isShowing() && groupControledWaitAccpetDialog.f().c.equals(this.a.getRoomId())) {
                    ChatGroupControl.this.u = false;
                    groupControledWaitAccpetDialog.dismiss();
                }
            }
        }
    }

    public class h0 implements mf2 {
        public final /* synthetic */ int a;

        public h0(int i) {
            this.a = i;
        }

        @Override // dc.mf2
        public void Q(String str) throws Resources.NotFoundException {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            chatGroupControl.z = false;
            chatGroupControl.clLdrMasterControl.setVisibility(8);
            ChatGroupControl.this.clLdrControlled.setVisibility(8);
            ChatGroupControl.this.y2();
            if (qf3.a) {
                rq1.d.q();
                qf3.C();
                ChatGroupControl.this.D.notifyDataSetChanged();
            }
            ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
            if (!chatGroupControl2.y) {
                chatGroupControl2.multiControlPanel.setVisibility(0);
                ChatGroupControl.this.multiControlPanel.g0();
                ChatGroupControl.this.s3(false, true);
                ChatGroupControl.this.Z2(0);
                ChatGroupControl.this.llControlFriends.setVisibility(0);
                ChatGroupControl.this.clRemoteControled.setVisibility(0);
                ChatGroupControl.this.ivShowMoreFriend1.setVisibility(8);
                ChatGroupControl.this.ivShowMoreFriend.setVisibility(0);
                ChatGroupControl chatGroupControl3 = ChatGroupControl.this;
                if (chatGroupControl3.C) {
                    chatGroupControl3.C = false;
                    chatGroupControl3.t3();
                }
                ChatGroupControl.this.S = false;
                ChatGroupControl.this.rvPattern.setVisibility(8);
            } else if (this.a != 3) {
                chatGroupControl2.multiControlPanel.setVisibility(0);
                ChatGroupControl.this.multiControlPanel.g0();
                ChatGroupControl.this.v3();
                ChatGroupControl.this.s3(true, true);
                ChatGroupControl.this.Z2(1);
                ChatGroupControl.this.llControlFriends.setVisibility(0);
                ChatGroupControl.this.clRemoteControled.setVisibility(8);
                ChatGroupControl.this.ivShowMoreFriend1.setVisibility(8);
                ChatGroupControl.this.ivShowMoreFriend.setVisibility(0);
                ChatGroupControl chatGroupControl4 = ChatGroupControl.this;
                if (chatGroupControl4.C) {
                    chatGroupControl4.C = false;
                    chatGroupControl4.t3();
                }
                ChatGroupControl.this.S = false;
                ChatGroupControl.this.rvPattern.setVisibility(8);
            }
            rq1.d.q();
            ChatGroupControl.this.p.B();
            me3.d(this.a == 1 ? me3.c.GROUP_CHAT_SYNC_CONTROL_MIRROR_BEGIN : me3.c.GROUP_CHAT_SYNC_CONTROL_PATTERN_BEGIN, me3.a());
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ PlayerAcceptRoomSyncResponse a;

        public i(PlayerAcceptRoomSyncResponse playerAcceptRoomSyncResponse) {
            this.a = playerAcceptRoomSyncResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            SendRoomSyncToyRequest sendRoomSyncToyRequest;
            T t = ChatGroupControl.this.c;
            if (t == 0 || WearUtils.e1(((Group) t).getId()) || !((Group) ChatGroupControl.this.c).getId().equals(this.a.getRoomId()) || ChatGroupControl.this.I1()) {
                return;
            }
            Dialog dialog = ChatGroupControl.this.M;
            if ((dialog != null && dialog.isShowing()) || !ChatGroupControl.this.r()) {
                Dialog dialog2 = ChatGroupControl.this.M;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                ChatGroupControl.this.m1(true);
                return;
            }
            GroupMember memberByJid = ((Group) ChatGroupControl.this.c).getMemberByJid(this.a.getJid());
            if (memberByJid != null) {
                memberByJid.setStatus(2);
                if (!ChatGroupControl.this.x.contains(memberByJid)) {
                    ChatGroupControl.this.x.add(memberByJid);
                }
                ChatGroupControl chatGroupControl = ChatGroupControl.this;
                if (chatGroupControl.y) {
                    String strP1 = chatGroupControl.p1();
                    if (ChatGroupControl.this.o2(strP1, true)) {
                        ChatGroupControl.this.g0 = strP1;
                    }
                    if (!qf3.a) {
                        ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
                        if (!chatGroupControl2.z && (sendRoomSyncToyRequest = chatGroupControl2.K) != null) {
                            sendRoomSyncToyRequest.setRoomId(((Group) chatGroupControl2.c).getId());
                            ChatGroupControl chatGroupControl3 = ChatGroupControl.this;
                            chatGroupControl3.E.d(chatGroupControl3.K);
                        }
                    }
                }
                ChatGroupControl.this.t3();
                sg3.l(String.format(ah4.e(R.string.group_chat_joined_sync), memberByJid.getNickName()));
            }
        }
    }

    public static class i0 {
        public static final ChatGroupControl a = new ChatGroupControl(null);
    }

    public class j implements Runnable {
        public final /* synthetic */ ReceiveAllRejectRoomSyncResponse a;

        public j(ReceiveAllRejectRoomSyncResponse receiveAllRejectRoomSyncResponse) {
            this.a = receiveAllRejectRoomSyncResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.z()) {
                EntitySystem entitySystem = new EntitySystem();
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C326.toString(), null);
                ChatGroupControl.this.Q2(entitySystem, MessageType.system);
                Dialog dialog = ChatGroupControl.this.M;
                if (dialog != null && dialog.isShowing()) {
                    ChatGroupControl.this.M.dismiss();
                    sg3.l(ah4.e(R.string.chat_video_busy));
                }
                ChatGroupControl.this.u = false;
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatGroupControl.this.F1();
            ChatGroupControl.this.w1();
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ ClearExitPlayerResponse a;

        public class a implements Runnable {
            public final /* synthetic */ GroupMember a;

            public a(GroupMember groupMember) {
                this.a = groupMember;
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (this.a.getStatus() == 4) {
                    ChatGroupControl.this.x.remove(this.a);
                    ChatGroupControl chatGroupControl = ChatGroupControl.this;
                    if (chatGroupControl.y && chatGroupControl.j1() == 1) {
                        if (this.a.getToys().size() == 0) {
                            ChatGroupControl.this.t3();
                            return;
                        }
                        String strP1 = ChatGroupControl.this.p1();
                        if (ChatGroupControl.this.o2(strP1, false)) {
                            ChatGroupControl.this.g0 = strP1;
                            ChatGroupControl.this.u1();
                        }
                    }
                }
                ChatGroupControl.this.t3();
            }
        }

        public l(ClearExitPlayerResponse clearExitPlayerResponse) {
            this.a = clearExitPlayerResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMember memberByJid;
            if (ChatGroupControl.this.f1(this.a.getRoomId()) || !ChatGroupControl.this.z() || (memberByJid = ((Group) ChatGroupControl.this.c).getMemberByJid(this.a.getJid())) == null) {
                return;
            }
            memberByJid.setStatus(4);
            if (ChatGroupControl.this.x.contains(memberByJid)) {
                ChatGroupControl.this.q.postDelayed(new a(memberByJid), 3000L);
                ChatGroupControl.this.t3();
            }
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ ReceiveLdrControlResponse a;

        public m(ReceiveLdrControlResponse receiveLdrControlResponse) {
            this.a = receiveLdrControlResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.z()) {
                ChatGroupControl.this.y3(false);
            }
        }
    }

    public class n implements Runnable {
        public final /* synthetic */ ReceiveEndRoomSyncResponse a;

        public n(ReceiveEndRoomSyncResponse receiveEndRoomSyncResponse) {
            this.a = receiveEndRoomSyncResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.z()) {
                if (ChatGroupControl.this.j1() == 1) {
                    EntitySystem entitySystem = new EntitySystem();
                    entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C326.toString(), null);
                    ChatGroupControl.this.Q2(entitySystem, MessageType.system);
                }
                ChatGroupControl.this.z2(false);
            }
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ boolean a;

        public class a implements Runnable {
            public a(o oVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                rq1.d.q();
            }
        }

        public o(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            int i = chatGroupControl.t;
            if (i == 2) {
                ye3.c(null, "exit group sync control", ((Group) chatGroupControl.c).getId());
            } else if (i == 1) {
                ye3.c(null, "end group sync control", ((Group) chatGroupControl.c).getId());
            }
            ChatGroupControl.this.g0 = "";
            ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
            E e = chatGroupControl2.f;
            if (e != 0) {
                ((gv1) e).l2(chatGroupControl2.c);
            }
            ViewGroup viewGroup = (ViewGroup) ChatGroupControl.this.f0.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(ChatGroupControl.this.f0);
            }
            qf3.C();
            ChatGroupControl.this.b3(0);
            ChatGroupControl.this.p.B();
            ChatGroupControl.this.q.postDelayed(new a(this), 300L);
            sz1.d().o();
            ChatGroupControl.this.s1();
            ChatGroupControl.this.E();
            ChatGroupControl chatGroupControl3 = ChatGroupControl.this;
            chatGroupControl3.L = false;
            chatGroupControl3.z = false;
            chatGroupControl3.multiControlPanel.U();
            me3.e(me3.a.OTHERS);
            me3.d(me3.c.GROUP_CHAT_SYNC_CONTROL_END, String.valueOf(ChatGroupControl.this.i));
            if (this.a) {
                yf3.b bVar = yf3.i;
                bVar.a().s(RateFeature.GroupSync, Integer.valueOf(ChatGroupControl.this.i));
                bVar.a().n();
            }
            ChatGroupControl.this.G();
            EventBus.getDefault().post(new hh0(1, 0));
            EventBus.getDefault().unregister(this);
            if (mk2.P().h0()) {
                mk2.P().n0(false);
            }
        }
    }

    public class p implements Runnable {
        public final /* synthetic */ ReceiveRoomRemoteControlResponse a;

        public p(ReceiveRoomRemoteControlResponse receiveRoomRemoteControlResponse) {
            this.a = receiveRoomRemoteControlResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.r()) {
                ChatGroupControl.this.z3(false, 0);
            }
        }
    }

    public class q implements Runnable {
        public final /* synthetic */ ChangeToSyncMasterResponse a;

        public q(ChangeToSyncMasterResponse changeToSyncMasterResponse) {
            this.a = changeToSyncMasterResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.r()) {
                SyncTransferStatusRequest syncTransferStatusRequest = new SyncTransferStatusRequest();
                syncTransferStatusRequest.setRoomId(((Group) ChatGroupControl.this.c).getId());
                ChatGroupControl.this.E.d(syncTransferStatusRequest);
                ChatGroupControl.this.m1(false);
                ChatGroupControl chatGroupControl = ChatGroupControl.this;
                if (chatGroupControl.F == null || !chatGroupControl.A()) {
                    return;
                }
                ChatGroupControl.this.V(String.format(ah4.e(R.string.sync_controller_notification), ChatGroupControl.this.F.getShowNickName()));
            }
        }
    }

    public class r implements Runnable {
        public final /* synthetic */ UpdateSyncMasterResponse a;

        public r(UpdateSyncMasterResponse updateSyncMasterResponse) {
            this.a = updateSyncMasterResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.r()) {
                ChatGroupControl.this.m1(false);
            }
        }
    }

    public class s implements Runnable {
        public final /* synthetic */ int a;

        public s(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatGroupControl.this.I1()) {
                return;
            }
            Iterator<Map.Entry<Toy, ImageView>> it = ChatGroupControl.this.U.o.entrySet().iterator();
            while (it.hasNext()) {
                ChatGroupControl.this.C3(it.next().getValue(), this.a);
            }
            Iterator<Map.Entry<Toy, ImageView>> it2 = ChatGroupControl.this.Y.o.entrySet().iterator();
            while (it2.hasNext()) {
                ChatGroupControl.this.C3(it2.next().getValue(), this.a);
            }
        }
    }

    public class t implements Runnable {
        public final /* synthetic */ ReceiveRoomBeControllerToyInfoResponse a;

        public t(ReceiveRoomBeControllerToyInfoResponse receiveRoomBeControllerToyInfoResponse) {
            this.a = receiveRoomBeControllerToyInfoResponse;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            GroupMember memberByJid;
            if (ChatGroupControl.this.f1(this.a.getRoomId()) || !ChatGroupControl.this.r() || (memberByJid = ((Group) ChatGroupControl.this.c).getMemberByJid(this.a.getJid())) == null) {
                return;
            }
            Iterator<GroupMember> it = ChatGroupControl.this.x.iterator();
            while (it.hasNext()) {
                GroupMember next = it.next();
                if (next.getUserJid().equals(memberByJid.getUserJid())) {
                    ChatGroupControl.this.x1(next, this.a.getToyJson());
                }
            }
            ArrayList arrayList = new ArrayList();
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            if (chatGroupControl.y) {
                Iterator<GroupMember> it2 = chatGroupControl.x.iterator();
                while (it2.hasNext()) {
                    arrayList.addAll(it2.next().getToys());
                }
                ChatGroupControl.this.g3(arrayList);
                if (ChatGroupControl.this.S) {
                    ChatGroupControl.this.s3(false, false);
                } else {
                    ChatGroupControl.this.s3(true, false);
                }
            }
        }
    }

    public class u implements Runnable {
        public final /* synthetic */ ReceiveRoomControllerToyInfoResponse a;

        public u(ReceiveRoomControllerToyInfoResponse receiveRoomControllerToyInfoResponse) {
            this.a = receiveRoomControllerToyInfoResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMember memberByJid;
            int i;
            boolean z;
            try {
                if (ChatGroupControl.this.f1(this.a.getRoomId()) || !ChatGroupControl.this.r() || (memberByJid = ((Group) ChatGroupControl.this.c).getMemberByJid(this.a.getJid())) == null) {
                    return;
                }
                ChatGroupControl chatGroupControl = ChatGroupControl.this;
                chatGroupControl.F = memberByJid;
                Iterator<GroupMember> it = chatGroupControl.x.iterator();
                while (it.hasNext()) {
                    GroupMember next = it.next();
                    if (next.getUserJid().equals(memberByJid.getUserJid())) {
                        ChatGroupControl.this.x1(next, this.a.getToyJson());
                    }
                }
                ChatGroupControl.this.B1();
                ChatGroupControl chatGroupControl2 = ChatGroupControl.this;
                if (chatGroupControl2.y) {
                    return;
                }
                if (chatGroupControl2.F.getToys().size() != 0) {
                    ChatGroupControl.this.V.clear();
                    ChatGroupControl.this.V.addAll(ChatGroupControl.this.F.getToys());
                    ChatGroupControl.this.i3();
                    Collections.reverse(ChatGroupControl.this.V);
                    if (ChatGroupControl.this.b0 != null) {
                        Iterator it2 = ChatGroupControl.this.V.iterator();
                        while (true) {
                            i = 0;
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            } else if (((Toy) it2.next()).getAndUpdateDeviceId().equals(ChatGroupControl.this.b0.getAndUpdateDeviceId())) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            while (true) {
                                if (i >= ChatGroupControl.this.V.size()) {
                                    break;
                                }
                                if (((Toy) ChatGroupControl.this.V.get(i)).getAndUpdateDeviceId().equals(ChatGroupControl.this.b0.getAndUpdateDeviceId())) {
                                    ChatGroupControl.this.U.j = i;
                                    break;
                                }
                                i++;
                            }
                        } else {
                            ChatGroupControl.this.U.j = -1;
                        }
                    }
                    ChatGroupControl chatGroupControl3 = ChatGroupControl.this;
                    chatGroupControl3.A = LDRControl.n(chatGroupControl3.V, true);
                    ChatGroupControl.this.U.notifyDataSetChanged();
                }
                ChatGroupControl chatGroupControl4 = ChatGroupControl.this;
                chatGroupControl4.u3(1, chatGroupControl4.F.getToys());
            } catch (Exception unused) {
            }
        }
    }

    public class v implements Runnable {
        public final /* synthetic */ int a;

        public v(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatGroupControl.this.I1()) {
                return;
            }
            ChatGroupControl chatGroupControl = ChatGroupControl.this;
            if (chatGroupControl.z && chatGroupControl.A && chatGroupControl.y) {
                Iterator<Map.Entry<Toy, ImageView>> it = chatGroupControl.a0.o.entrySet().iterator();
                while (it.hasNext()) {
                    ChatGroupControl.this.C3(it.next().getValue(), this.a);
                }
            }
        }
    }

    public class w implements Runnable {
        public final /* synthetic */ ChangeLdrToyTypeResponse a;

        public w(ChangeLdrToyTypeResponse changeLdrToyTypeResponse) {
            this.a = changeLdrToyTypeResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.r()) {
                ChatGroupControl chatGroupControl = ChatGroupControl.this;
                chatGroupControl.p2(chatGroupControl.U, this.a.getToyType());
            }
        }
    }

    public class x implements Runnable {
        public final /* synthetic */ ReceivePlayerRejectRoomSyncResponse a;

        public class a implements Runnable {
            public final /* synthetic */ GroupMember a;

            public a(GroupMember groupMember) {
                this.a = groupMember;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getStatus() == 4) {
                    ChatGroupControl.this.x.remove(this.a);
                }
                ChatGroupControl.this.t3();
            }
        }

        public x(ReceivePlayerRejectRoomSyncResponse receivePlayerRejectRoomSyncResponse) {
            this.a = receivePlayerRejectRoomSyncResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMember memberByJid;
            if (ChatGroupControl.this.f1(this.a.getRoomId()) || !ChatGroupControl.this.r() || (memberByJid = ((Group) ChatGroupControl.this.c).getMemberByJid(this.a.getJid())) == null) {
                return;
            }
            memberByJid.setStatus(4);
            if (ChatGroupControl.this.x.contains(memberByJid)) {
                ChatGroupControl.this.q.postDelayed(new a(memberByJid), 3000L);
                ChatGroupControl.this.t3();
            }
            Dialog dialog = ChatGroupControl.this.M;
            if (dialog instanceof GroupControlWaitAccpetDialog) {
                GroupControlWaitAccpetDialog groupControlWaitAccpetDialog = (GroupControlWaitAccpetDialog) dialog;
                if (groupControlWaitAccpetDialog.isShowing()) {
                    groupControlWaitAccpetDialog.p();
                }
            }
        }
    }

    public class y implements Runnable {
        public final /* synthetic */ MasterLineStatusNotifyResponse a;

        public y(MasterLineStatusNotifyResponse masterLineStatusNotifyResponse) {
            this.a = masterLineStatusNotifyResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ChatGroupControl.this.f1(this.a.getRoomId()) && ChatGroupControl.this.r()) {
                if (this.a.isOnLine()) {
                    ChatGroupControl.this.tvLdrWaitReconnectTip.setVisibility(8);
                    ChatGroupControl.this.tvRemoteWaitReconnectTip.setVisibility(8);
                } else {
                    ChatGroupControl.this.tvLdrWaitReconnectTip.setVisibility(0);
                    ChatGroupControl.this.tvRemoteWaitReconnectTip.setVisibility(0);
                }
            }
        }
    }

    public class z implements Runnable {
        public z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatGroupControl.this.M instanceof GroupControlWaitAccpetDialog) {
                EntitySystem entitySystem = new EntitySystem();
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C326.toString(), null);
                ChatGroupControl.this.Q2(entitySystem, MessageType.system);
                ChatGroupControl.this.W0();
            } else {
                AccusedPartyRefuseRequest accusedPartyRefuseRequest = new AccusedPartyRefuseRequest();
                accusedPartyRefuseRequest.setRoomId(ChatGroupControl.this.d);
                ChatGroupControl.this.s.d(accusedPartyRefuseRequest);
            }
            Dialog dialog = ChatGroupControl.this.M;
            if (dialog != null && dialog.isShowing()) {
                ChatGroupControl.this.M.dismiss();
            }
            ChatGroupControl.this.a3(false);
        }
    }

    public /* synthetic */ ChatGroupControl(k kVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(xc1 xc1Var) {
        xe3.a("send", "玩具重新连接，发送startMoveWaggle指令给玩具");
        Iterator<Toy> it = this.Z.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (xc1Var.a().equals(next.getAddress())) {
                if (next.getAddress().equals(this.b0.getAddress())) {
                    if (next.isConnected()) {
                        if (next.isF01Toy()) {
                            this.p.r0(next);
                        } else {
                            this.p.s0(next);
                        }
                    }
                } else if (next.isConnected() && next.isF01Toy()) {
                    this.p.s0(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y1(xc1 xc1Var) {
        Iterator<Toy> it = this.Z.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isF01Toy() && xc1Var.a().equals(next.getAddress()) && next.isConnected()) {
                this.p.s0(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2(View view) {
        if (I() == null || I().isFinishing()) {
            return;
        }
        ua2.e(I(), view, this.b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(Group group, RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember, ArrayList arrayList) {
        L(group);
        n3(roomReceiveSyncResponse, group, groupMember, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f2(String str) {
        this.h0.m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i2(Activity activity, RoomReceiveSyncResponse roomReceiveSyncResponse) {
        Dialog dialog = this.M;
        if (dialog != null) {
            dialog.dismiss();
        }
        MusicControl.h0().S();
        y12.c.a().t();
        if (activity instanceof RemoteMultiControlActivity) {
            ((RemoteMultiControlActivity) activity).C4();
        } else if (activity instanceof ChatRoomActivity) {
            ((ChatRoomActivity) activity).N6();
        }
        P2(roomReceiveSyncResponse.getRoomId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m2(Activity activity, Group group, DialogInterface dialogInterface) {
        this.u = false;
        this.M = null;
        try {
            ((NotificationManager) activity.getSystemService("notification")).cancel(group.getId().hashCode() + "", group.getId().hashCode());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static ChatGroupControl o1() {
        return i0.a;
    }

    public void A1() {
        List<Pattern> listM = xe2.L0().m(WearUtils.y.r());
        this.T.clear();
        this.T.addAll(listM);
        this.D.notifyDataSetChanged();
    }

    public void A2(ReceiveAllRejectRoomSyncResponse receiveAllRejectRoomSyncResponse) {
        U(new j(receiveAllRejectRoomSyncResponse));
    }

    public final void A3(RoomReceiveSyncResponse roomReceiveSyncResponse) {
        this.x.clear();
        for (RoomReceiveSyncResponse.PlayerListBean playerListBean : roomReceiveSyncResponse.getPlayerList()) {
            GroupMember memberByJid = ((Group) this.c).getMemberByJid(playerListBean.getJid());
            if (memberByJid != null) {
                x1(memberByJid, playerListBean.getToyJson());
                memberByJid.setStatus(playerListBean.getStatus());
                if (playerListBean.getStatus() == 2 || playerListBean.getStatus() == 1) {
                    this.x.add(memberByJid);
                }
            }
        }
        this.x.add(0, this.F);
    }

    @Override // dc.ka2
    public void B() {
        U(new z());
    }

    public final void B1() {
        this.tvFriendUserName.setText(this.F.getNickName());
        this.tvFriendUserName1.setText(this.F.getNickName());
        WearUtils.t2(this.ivFriendAvatar, this.F);
        WearUtils.t2(this.ivFriendAvatar1, this.F);
    }

    public void B2(ReceiveCancelRoomSyncResponse receiveCancelRoomSyncResponse) {
        U(new h(receiveCancelRoomSyncResponse));
    }

    public void B3(UpdateSyncMasterResponse updateSyncMasterResponse) {
        U(new r(updateSyncMasterResponse));
    }

    public final void C1() throws Resources.NotFoundException {
        if (this.C) {
            this.ivShowMoreFriend1.setVisibility(0);
            this.ivShowMoreFriend.setVisibility(8);
            this.multiControlPanel.setVisibility(8);
            this.clRemoteControled.setVisibility(8);
            this.clLdrControlled.setVisibility(8);
            this.clLdrMasterControl.setVisibility(8);
            return;
        }
        this.ivShowMoreFriend1.setVisibility(8);
        this.ivShowMoreFriend.setVisibility(0);
        if (this.y) {
            this.clRemoteControled.setVisibility(8);
            this.clLdrControlled.setVisibility(8);
            if (this.z && this.A) {
                this.multiControlPanel.setVisibility(8);
                this.clLdrMasterControl.setVisibility(0);
                return;
            } else {
                this.multiControlPanel.setVisibility(0);
                this.multiControlPanel.g0();
                s3(true, true);
                this.clLdrMasterControl.setVisibility(8);
                return;
            }
        }
        this.clLdrMasterControl.setVisibility(8);
        if (this.z && this.A) {
            this.multiControlPanel.setVisibility(8);
            this.clLdrControlled.setVisibility(0);
            this.clRemoteControled.setVisibility(8);
        } else {
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.g0();
            s3(false, true);
            this.clLdrControlled.setVisibility(8);
            this.clRemoteControled.setVisibility(0);
        }
    }

    public void C2(ReceiveEndRoomSyncResponse receiveEndRoomSyncResponse) {
        U(new n(receiveEndRoomSyncResponse));
    }

    public void C3(ImageView imageView, int i2) {
        if (i2 <= 0) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level0);
            return;
        }
        if (i2 < 5) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level1);
            return;
        }
        if (i2 < 10) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level2);
        } else if (i2 < 15) {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level3);
        } else {
            imageView.setBackgroundResource(R.drawable.chat_ldr_feedback_level4);
        }
    }

    public final void D1() throws Resources.NotFoundException {
        if (this.S) {
            this.rvPattern.setVisibility(0);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.g0();
            s3(false, true);
            Z2(3);
            this.clRemoteControled.setVisibility(8);
            this.clLdrControlled.setVisibility(8);
            this.clLdrMasterControl.setVisibility(8);
            this.llControlFriends.setVisibility(8);
            x3();
            return;
        }
        this.rvPattern.setVisibility(8);
        if (this.C) {
            this.llControlFriends.setVisibility(0);
            this.ivShowMoreFriend1.setVisibility(0);
            this.ivShowMoreFriend.setVisibility(8);
            this.multiControlPanel.setVisibility(8);
            this.clRemoteControled.setVisibility(8);
            this.clLdrControlled.setVisibility(8);
            this.clLdrMasterControl.setVisibility(8);
            return;
        }
        if (!this.y) {
            Z2(0);
            this.clLdrMasterControl.setVisibility(8);
            if (this.z) {
                this.clLdrControlled.setVisibility(0);
                this.clRemoteControled.setVisibility(8);
                this.multiControlPanel.setVisibility(8);
                return;
            } else {
                this.clLdrControlled.setVisibility(8);
                this.clRemoteControled.setVisibility(0);
                this.multiControlPanel.setVisibility(0);
                this.multiControlPanel.g0();
                s3(false, true);
                return;
            }
        }
        this.llControlFriends.setVisibility(0);
        this.clRemoteControled.setVisibility(8);
        this.clLdrControlled.setVisibility(8);
        if (this.z) {
            this.multiControlPanel.setVisibility(8);
            this.clLdrMasterControl.setVisibility(0);
            Z2(2);
        } else {
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.g0();
            s3(true, true);
            this.clLdrMasterControl.setVisibility(8);
            Z2(1);
        }
    }

    public void D2(ReceiveLdrControlResponse receiveLdrControlResponse) {
        U(new m(receiveLdrControlResponse));
    }

    public void D3(Activity activity, String str, ArrayList<String> arrayList) {
        RoomSendSyncRequest roomSendSyncRequest = new RoomSendSyncRequest();
        roomSendSyncRequest.setRoomId(str);
        roomSendSyncRequest.setPlayerJidList(arrayList);
        roomSendSyncRequest.setAckId(WearUtils.E());
        E e2 = this.f;
        if (e2 != 0) {
            ((gv1) e2).r3(this.c, true);
        }
        this.E.a(roomSendSyncRequest, new d0(activity));
    }

    public final void E1() {
        u3(1, this.F.getToys());
        WearUtils.t2(this.ivIAvatar1, this.b);
        u3(0, this.Z);
    }

    public void E2(ReceivePlayerRejectRoomSyncResponse receivePlayerRejectRoomSyncResponse) {
        U(new x(receivePlayerRejectRoomSyncResponse));
    }

    public final void F1() {
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.view_group_control, (ViewGroup) null);
        this.f0 = viewInflate;
        ButterKnife.bind(this, viewInflate);
        this.f0.setOnClickListener(new c(this));
    }

    public void F2(ReceiveRoomBeControllerToyInfoResponse receiveRoomBeControllerToyInfoResponse) {
        U(new t(receiveRoomBeControllerToyInfoResponse));
    }

    public final boolean G1(Group group) {
        UserSetting userSettingZ = WearUtils.y.z(WearUtils.g0(group.getRealId()));
        return userSettingZ != null && WearUtils.x1(userSettingZ.getAutoAccept());
    }

    public void G2(ReceiveRoomControllerToyInfoResponse receiveRoomControllerToyInfoResponse) {
        U(new u(receiveRoomControllerToyInfoResponse));
    }

    public final boolean H1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        if (!na2.m().i()) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public void H2(ReceiveRoomRemoteControlResponse receiveRoomRemoteControlResponse) {
        U(new p(receiveRoomRemoteControlResponse));
    }

    public final boolean I1() {
        return false;
    }

    public void I2(ReceiveRoomSyncToyResponse receiveRoomSyncToyResponse) {
        if (!f1(receiveRoomSyncToyResponse.getRoomId()) && r() && j1() == 2) {
            Order order = (Order) JSON.parseObject(receiveRoomSyncToyResponse.getOrder(), Order.class);
            String str = "receiveRoomSyncToy: order指令=" + receiveRoomSyncToyResponse.toString();
            String str2 = this.g0;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.g.G().P();
            String[] strArrSplit = str2.split(",");
            String str3 = "";
            for (String str4 : strArrSplit) {
                if (str4.contains(PSOProgramService.VS_Key)) {
                    str3 = order.getV() == -1 ? str3 + "0," : str3 + order.getV() + ",";
                } else if (str4.contains(StreamManagement.AckRequest.ELEMENT)) {
                    if (order.getR() == TouchControlView.Q) {
                        str3 = str3 + "-2,";
                        this.g.G().f("RotateChange;");
                    } else if (order.getR() == -1) {
                        str3 = str3 + "0,";
                    } else {
                        str3 = str3 + order.getR() + ",";
                    }
                } else if (!str4.contains("t") || receiveRoomSyncToyResponse.getVersion() < 1) {
                    if (!str4.contains("f") || receiveRoomSyncToyResponse.getVersion() < 2) {
                        if (!str4.contains(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) || receiveRoomSyncToyResponse.getVersion() < 2) {
                            if (str4.equals("pos")) {
                                str3 = order.getPos() == -1 ? str3 + "0," : str3 + order.getPos() + ",";
                            } else if (str4.equals("p")) {
                                str3 = order.getP() == -1 ? str3 + "0," : str3 + order.getP() + ",";
                            } else if (str4.equals("s") && receiveRoomSyncToyResponse.getVersion() >= 2) {
                                str3 = order.getS() == -1 ? str3 + "0," : str3 + order.getS() + ",";
                            }
                        } else if (order.getD() == -1) {
                            str3 = str3 + "0,";
                        } else {
                            str3 = str3 + order.getD() + ",";
                        }
                    } else if (order.getF() == -1) {
                        str3 = str3 + "0,";
                    } else {
                        str3 = str3 + order.getF() + ",";
                    }
                } else if (order.getT() == -1) {
                    str3 = str3 + "0,";
                } else {
                    str3 = str3 + order.getT() + ",";
                }
            }
            String[] strArrSplit2 = str3.split(",");
            if (mp1.h()) {
                rq1.d.d(Arrays.asList(strArrSplit), Arrays.asList(strArrSplit2), new ToyControlBuilder(false, true, false, ToyControlBuilder.a.SETTING_ONLY));
            } else {
                this.p.c0(strArrSplit, strArrSplit2, false, true);
            }
            if (this.z && this.A && order.getV() != -1) {
                U(new s(order.getV()));
            }
            ToyCommandBean toyCommandBean = new ToyCommandBean();
            toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
            toyCommandBean.setAllFunc(str2, str3, false);
            ToyBean all = toyCommandBean.getAll();
            if (receiveRoomSyncToyResponse.getVersion() == 0) {
                all.setT(all.getV());
            }
            if (receiveRoomSyncToyResponse.getVersion() < 2) {
                all.setS(all.getV());
            }
            if (all != null) {
                K2(all.getV(), all.getR(), all.getP(), all.getT(), all.getS(), all.getF(), all.getD(), all.getPos());
            }
        }
    }

    public boolean J1() {
        return this.u;
    }

    public final boolean K1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        if (!ob2.o().q()) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public void K2(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        ChatGroupControl chatGroupControl = this;
        String str = "receiveToyMsg: v=" + i2 + "  r=" + i3 + "  p=" + i4 + "  t=" + i5 + "  s=" + i6 + "  f=" + i7 + "  d=" + i8 + "  pos=" + i9;
        if (i3 == TouchControlView.Q) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i12 = i2 < 0 ? 0 : i2 * 5;
        int i13 = i3 < 0 ? 0 : i3 * 5;
        int iCeil = i4 < 0 ? 0 : (int) Math.ceil(i4 * 33.3d);
        int i14 = i5 < 0 ? 0 : i5 * 5;
        int i15 = i6 < 0 ? 0 : i6 * 5;
        int i16 = i7 < 0 ? 0 : i7 * 5;
        int i17 = i8 < 0 ? 0 : i8 * 5;
        int iMax = Math.max(i9, 0);
        String[] strArrSplit = chatGroupControl.g0.split(",");
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
            chatGroupControl = this;
            strArrSplit = strArr;
            length = i19;
            i17 = i10;
            i16 = i11;
        }
        chatGroupControl.d0.add(arrayList);
    }

    public final boolean L1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        User user;
        Iterator<Activity> it = pd3.j().a.iterator();
        ChatActivity chatActivity = null;
        while (it.hasNext()) {
            Activity next = it.next();
            if (next instanceof ChatActivity) {
                chatActivity = (ChatActivity) next;
            }
        }
        if (chatActivity == null || (user = chatActivity.z) == null || !(user.isDateIng() || ChatSyncControl.N0().z() || ChatVideoControl.a1().z())) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public final void L2(final View view) {
        this.rvLdrMasterControlToy.post(new Runnable() { // from class: dc.w82
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a2(view);
            }
        });
    }

    public final boolean M1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        if (!h32.i().l()) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public final void M2() {
        jp3 jp3Var = this.h0;
        if (jp3Var != null) {
            jp3Var.j(0);
        }
    }

    public void N2(final RoomReceiveSyncResponse roomReceiveSyncResponse) {
        final Group groupK = ch3.n().k(roomReceiveSyncResponse.getRoomId());
        if (groupK == null || groupK.isExit()) {
            return;
        }
        this.G = groupK.getId();
        final GroupMember memberByJid = groupK.getMemberByJid(roomReceiveSyncResponse.getMaster().getJid());
        if (memberByJid == null || T1(roomReceiveSyncResponse, memberByJid) || H1(roomReceiveSyncResponse, memberByJid) || O1(roomReceiveSyncResponse, memberByJid) || M1(roomReceiveSyncResponse, memberByJid) || Q1(roomReceiveSyncResponse, memberByJid) || L1(roomReceiveSyncResponse, memberByJid) || R1(roomReceiveSyncResponse, memberByJid) || K1(roomReceiveSyncResponse, memberByJid)) {
            return;
        }
        final ArrayList<GroupMember> arrayListN1 = n1(roomReceiveSyncResponse, groupK);
        if (arrayListN1.isEmpty()) {
            return;
        }
        xz1.a();
        this.u = false;
        v2();
        if (this.g.f0()) {
            Y2(groupK, memberByJid);
        }
        boolean zG1 = G1(groupK);
        ye3.c(null, "get group sync control", groupK.getId());
        if (!zG1) {
            U(new Runnable() { // from class: dc.v82
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c2(groupK, roomReceiveSyncResponse, memberByJid, arrayListN1);
                }
            });
            return;
        }
        Dialog dialog = this.M;
        if (dialog != null) {
            dialog.dismiss();
        }
        MusicControl.h0().S();
        U(new Runnable() { // from class: dc.x82
            @Override // java.lang.Runnable
            public final void run() {
                y12.c.a().t();
            }
        });
        P2(roomReceiveSyncResponse.getRoomId());
    }

    public final boolean O1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        if (sz1.d().e() < 8) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public void O2() {
        int i2 = this.U.j;
        if (i2 == -1) {
            this.rvFriendToy.scrollToPosition(0);
        } else if (i2 < this.V.size() - 1) {
            this.rvFriendToy.scrollToPosition(i2 + 1);
        } else {
            this.rvFriendToy.scrollToPosition(i2);
        }
    }

    @Override // dc.ka2
    public void P() {
    }

    public boolean P1() {
        return this.z;
    }

    public final void P2(String str) {
        AcceptRoomSyncRequest acceptRoomSyncRequest = new AcceptRoomSyncRequest();
        acceptRoomSyncRequest.setRoomId(str);
        acceptRoomSyncRequest.setAckId(WearUtils.E());
        this.s.a(acceptRoomSyncRequest, new d(str));
        this.u = false;
    }

    @Override // dc.ka2
    public void Q(Activity activity) {
        if (activity instanceof ChatRoomActivity) {
            ChatRoomActivity chatRoomActivity = (ChatRoomActivity) activity;
            if (chatRoomActivity.C() == this.c) {
                chatRoomActivity.S8();
                return;
            }
        }
        pj3.j(activity, ChatRoomActivity.class, "roomId", ((Group) this.c).getId());
    }

    public final boolean Q1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        if (!my2.i.a().getB()) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public final void Q2(DataEntityAbstract dataEntityAbstract, MessageType messageType) {
        if (zb2.O().B(messageType)) {
            zb2.O().H0(WearUtils.k0(((Group) this.c).getId()), dataEntityAbstract, true, false, null);
        } else {
            sg3.l(ah4.e(R.string.operate_frequently));
        }
    }

    public final boolean R1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        rn3 rn3Var;
        gu3 gu3Var = hu3.p;
        if (gu3Var == null || (rn3Var = gu3Var.a) == null || !rn3Var.d()) {
            return false;
        }
        sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
        X0(roomReceiveSyncResponse.getRoomId());
        return true;
    }

    public final void R2() {
        RoomSyncHeartbeatRequest roomSyncHeartbeatRequest = new RoomSyncHeartbeatRequest();
        roomSyncHeartbeatRequest.setRoomId(((Group) this.c).getId());
        this.E.d(roomSyncHeartbeatRequest);
    }

    public final boolean S1(Toy toy) {
        return toy.isH01Toy() || toy.isBAToy();
    }

    public final void S2(String str) {
        String str2 = "sendRotationCommand: address=" + str;
        MyApplication myApplication = this.g;
        if (myApplication == null || myApplication.G() == null || this.g.G().P().size() <= 0) {
            return;
        }
        for (Toy toy : this.g.G().P()) {
            if (toy.isNora()) {
                if (WearUtils.e1(str)) {
                    rq1.d.i();
                    return;
                } else if (TextUtils.equals(toy.getAddress(), str)) {
                    rq1.d.f(str);
                    return;
                }
            }
        }
    }

    public final boolean T1(RoomReceiveSyncResponse roomReceiveSyncResponse, GroupMember groupMember) {
        Dialog dialog = this.M;
        if (dialog instanceof GroupControledWaitAccpetDialog) {
            GroupControledWaitAccpetDialog groupControledWaitAccpetDialog = (GroupControledWaitAccpetDialog) dialog;
            if (groupControledWaitAccpetDialog.isShowing() && !groupControledWaitAccpetDialog.f().c.equals(roomReceiveSyncResponse.getRoomId())) {
                sg3.l(String.format(ah4.e(R.string.conflict_notice_group_sync_control), groupMember.getNickName()));
                X0(roomReceiveSyncResponse.getRoomId());
                return true;
            }
        }
        return false;
    }

    public final void T2() {
        ou3.c();
        Iterator<Map.Entry<Toy, ImageView>> it = this.a0.o.entrySet().iterator();
        while (it.hasNext()) {
            C3(it.next().getValue(), 0);
        }
        Order order = new Order();
        order.setV(0);
        order.setP(0);
        order.setR(0);
        SendRoomSyncToyRequest sendRoomSyncToyRequest = new SendRoomSyncToyRequest();
        sendRoomSyncToyRequest.setOrder(JSON.toJSONString(order));
        sendRoomSyncToyRequest.setRoomId(((Group) this.c).getId());
        this.E.d(sendRoomSyncToyRequest);
    }

    public void U1(String str, mf2 mf2Var) {
        AcceptRoomSyncRequest acceptRoomSyncRequest = new AcceptRoomSyncRequest();
        acceptRoomSyncRequest.setRoomId(str);
        acceptRoomSyncRequest.setAckId(WearUtils.E());
        this.E.a(acceptRoomSyncRequest, mf2Var);
    }

    public final void U2(String str, String str2) {
        String[] strArrSplit = str.split(",");
        String[] strArrSplit2 = str2.split(",");
        if (mp1.h()) {
            rq1.d.d(Arrays.asList(strArrSplit), Arrays.asList(strArrSplit2), new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SETTING_ONLY));
        } else {
            this.p.c0(strArrSplit, strArrSplit2, true, true);
        }
    }

    public void W0() {
        u2();
        CancelRoomSyncRequest cancelRoomSyncRequest = new CancelRoomSyncRequest();
        cancelRoomSyncRequest.setRoomId(this.d);
        this.E.d(cancelRoomSyncRequest);
    }

    public void W2(String str, int i2, int i3) {
        Order order = new Order();
        order.setV(i2);
        if (i3 >= 4) {
            i3 = 3;
        }
        order.setP(i3);
        order.setR(i2);
        order.setT(i2);
        order.setS(i2);
        order.setF(i2);
        order.setD(i2);
        SendRoomSyncToyRequest sendRoomSyncToyRequest = new SendRoomSyncToyRequest();
        sendRoomSyncToyRequest.setOrder(JSON.toJSONString(order));
        sendRoomSyncToyRequest.setRoomId(((Group) this.c).getId());
        String str2 = "感应模式+sendWaggleMessageToFriend: " + sendRoomSyncToyRequest.toString();
        this.E.d(sendRoomSyncToyRequest);
    }

    public void X0(String str) {
        AccusedPartyRefuseRequest accusedPartyRefuseRequest = new AccusedPartyRefuseRequest();
        accusedPartyRefuseRequest.setRoomId(str);
        this.s.d(accusedPartyRefuseRequest);
        this.u = false;
        this.M = null;
    }

    public final void X2(String str, int i2, int i3) {
        Iterator<Toy> it = this.Z.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (!next.isThridPartToy() || !next.getAddress().equals(str)) {
                if (mp1.h()) {
                    rq1.d.a(next.getAddress(), i2, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
                } else {
                    pc1.a.o0(next, i2, false, true);
                }
            }
        }
    }

    public void Y0(ChangeLdrToyTypeResponse changeLdrToyTypeResponse) {
        U(new w(changeLdrToyTypeResponse));
    }

    public final void Y2(Group group, GroupMember groupMember) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        String str = "[" + ah4.e(R.string.message_notification_type_sync) + "]";
        if (og3.b(1)) {
            PowerManager powerManager = (PowerManager) this.g.getSystemService("power");
            if (powerManager != null && (wakeLockNewWakeLock = powerManager.newWakeLock(268435462, ":target")) != null) {
                wakeLockNewWakeLock.acquire();
                wakeLockNewWakeLock.release();
            }
            try {
                this.g.u(group, groupMember, str, 1);
            } catch (Exception e2) {
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        }
    }

    public final void Z0() throws Resources.NotFoundException {
        this.z = false;
        E e2 = this.f;
        if (e2 != 0) {
            ((gv1) e2).l(this.c);
        }
        F();
        this.multiControlPanel.setVisibility(0);
        s3(false, true);
        this.llControlFriends.setVisibility(0);
        this.clRemoteControled.setVisibility(0);
        this.clLdrMasterControl.setVisibility(8);
        this.clLdrControlled.setVisibility(8);
        Z2(0);
        this.llControlFriends.setVisibility(0);
        this.ivShowMoreFriend1.setVisibility(8);
        this.ivShowMoreFriend.setVisibility(0);
        if (this.C) {
            this.C = false;
            t3();
        }
        this.S = false;
        this.rvPattern.setVisibility(8);
        s1();
    }

    public final void Z2(int i2) {
        if (i2 == 0) {
            this.tvEndControlTime.setVisibility(0);
            this.llControl.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.tvEndControlTime.setVisibility(0);
            this.llControl.setVisibility(0);
            if (this.B) {
                this.tvControlDlr.setVisibility(0);
            }
            this.tvRemoteControl.setTextColor(th4.b(this.g, R.color.chat_sync_select));
            ce3.f(this.tvRemoteControl, R.drawable.chat_toolbar_mirror_click);
            this.tvControlDlr.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvControlDlr, R.drawable.sync_longdistance);
            this.tvControlPattern.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvControlPattern, R.drawable.control_panel_pattern);
            return;
        }
        if (i2 == 2) {
            this.tvEndControlTime.setVisibility(0);
            this.llControl.setVisibility(0);
            this.tvControlDlr.setVisibility(0);
            this.tvRemoteControl.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvRemoteControl, R.drawable.chat_toolbar_mirror);
            this.tvControlDlr.setTextColor(th4.b(this.g, R.color.chat_sync_select));
            ce3.f(this.tvControlDlr, R.drawable.sync_longdistance_click);
            this.tvControlPattern.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvControlPattern, R.drawable.control_panel_pattern);
            return;
        }
        if (i2 == 3) {
            this.tvEndControlTime.setVisibility(0);
            this.llControl.setVisibility(0);
            if (this.B) {
                this.tvControlDlr.setVisibility(0);
            }
            this.tvRemoteControl.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvRemoteControl, R.drawable.chat_toolbar_mirror);
            this.tvControlDlr.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvControlDlr, R.drawable.sync_longdistance);
            this.tvControlPattern.setTextColor(th4.b(this.g, R.color.default_color));
            ce3.f(this.tvControlPattern, R.drawable.chat_toolbar_pattern_click);
        }
    }

    @Override // dc.ra2
    public void a() {
        if (this.c == 0) {
            return;
        }
        if (j1() == 1) {
            EndRoomsSyncRequest endRoomsSyncRequest = new EndRoomsSyncRequest();
            endRoomsSyncRequest.setRoomId(((Group) this.c).getId());
            this.E.d(endRoomsSyncRequest);
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C326.toString(), null);
            Q2(entitySystem, MessageType.system);
        } else {
            PlayerExitSyncRequest playerExitSyncRequest = new PlayerExitSyncRequest();
            playerExitSyncRequest.setRoomId(((Group) this.c).getId());
            this.E.d(playerExitSyncRequest);
        }
        z2(true);
    }

    public void a1(ChangeToSyncMasterResponse changeToSyncMasterResponse) {
        U(new q(changeToSyncMasterResponse));
    }

    public void a3(boolean z2) {
        this.u = z2;
    }

    public void b1() {
        ArrayList arrayList = new ArrayList();
        Iterator<GroupMember> it = this.x.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getToys());
        }
        ka2.C(false, arrayList, new a0());
    }

    public void b3(int i2) {
        this.t = i2;
        if (i2 != 0) {
            h12.D.isGroupControlChat = true;
            EventBus.getDefault().post(h12.D);
        } else {
            h12.D.isGroupControlChat = false;
        }
        ob2.o().H(0);
    }

    public void c1(ClearExitPlayerResponse clearExitPlayerResponse) {
        U(new l(clearExitPlayerResponse));
    }

    public final void c3(RoomReceiveSyncResponse roomReceiveSyncResponse, String str) {
        for (RoomReceiveSyncResponse.PlayerListBean playerListBean : roomReceiveSyncResponse.getPlayerList()) {
            if (str.equals(playerListBean.getJid()) && playerListBean.getStatus() == 2) {
                b3(2);
            }
        }
        if (str.equals(roomReceiveSyncResponse.getMaster().getJid())) {
            b3(1);
        }
    }

    public final void d1(int i2, boolean z2, boolean z3) throws Resources.NotFoundException {
        this.y = false;
        this.Z.clear();
        this.Z.addAll(pc1.a.P());
        this.g0 = k1(this.Z);
        GroupMember memberByJid = ((Group) this.c).getMemberByJid(ch3.n().p());
        if (memberByJid != null) {
            this.tvSelfUserName.setText(memberByJid.getNickName());
            this.tvIUserName1.setText(memberByJid.getNickName());
            WearUtils.t2(this.ivSelfAvatar, memberByJid);
            if (this.Z.size() != 0) {
                memberByJid.setRealToy(this.Z);
            }
            h3(memberByJid.getToys());
        }
        this.Y.notifyDataSetChanged();
        this.C = true;
        s1();
        u1();
        if (i2 == 1) {
            rq1.d.q();
        }
        Z0();
        if (this.A) {
            i3();
            Collections.reverse(this.V);
            for (int i3 = 0; i3 < this.V.size(); i3++) {
                if (this.V.get(i3).isSupportLdr() || S1(this.V.get(i3))) {
                    this.U.j = i3;
                    this.b0 = this.V.get(i3);
                }
            }
            this.U.notifyDataSetChanged();
            O2();
        }
        if (z3 && this.A) {
            y3(false);
        }
        R2();
        pc1.a.F();
        E1();
        E e2 = this.f;
        if (e2 != 0) {
            ((gv1) e2).n0(this.c, this.f0);
        }
        Y();
        rq1.d.q();
        this.p.B();
        if (z2) {
            return;
        }
        me3.e(me3.a.GROUP_CHAT_SYNC_CONTROL);
        me3.d(me3.c.GROUP_CHAT_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
        sz1.d().r(8);
    }

    public void d3() {
        x3();
        if (this.b0 == null) {
            return;
        }
        Iterator<Toy> it = this.Z.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.getAddress().equals(this.b0.getAddress())) {
                if (next.isF01Toy()) {
                    this.p.r0(next);
                } else {
                    this.p.s0(next);
                }
            } else if (next.isF01Toy()) {
                this.p.s0(next);
            }
        }
    }

    public final void e1(RoomReceiveSyncResponse roomReceiveSyncResponse, boolean z2, boolean z3) throws Resources.NotFoundException {
        this.y = true;
        this.Z.clear();
        ArrayList<Toy> arrayList = this.Z;
        pc1 pc1Var = pc1.a;
        arrayList.addAll(pc1Var.P());
        this.V.clear();
        this.V.addAll(this.Z);
        this.z = false;
        i3();
        this.F.setRealToy(this.Z);
        this.A = LDRControl.n(this.V, true);
        this.U.notifyDataSetChanged();
        this.a0.notifyDataSetChanged();
        this.g0 = p1();
        u1();
        w3(true);
        if (z3) {
            if (this.A) {
                i3();
                int iQ1 = q1(roomReceiveSyncResponse.getMaster().getToyType());
                GroupLdrToyAdapter groupLdrToyAdapter = this.a0;
                groupLdrToyAdapter.j = iQ1;
                groupLdrToyAdapter.notifyDataSetChanged();
                this.b0 = this.V.get(iQ1);
                y3(false);
            } else {
                z3(true, 0);
            }
        }
        R2();
        pc1Var.F();
        E1();
        E e2 = this.f;
        if (e2 != 0) {
            ((gv1) e2).n0(this.c, this.f0);
        }
        Y();
        b1();
        if (z2) {
            return;
        }
        me3.e(me3.a.GROUP_CHAT_SYNC_CONTROL);
        me3.d(me3.c.GROUP_CHAT_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
        ye3.c("friend chatroom", "begin group sync control", ((Group) this.c).getId());
        sz1.d().r(8);
    }

    public void e3(Toy toy) {
        x3();
        Toy toy2 = this.b0;
        if (toy2 != null) {
            if (toy2.isF01Toy()) {
                this.p.s0(this.b0);
            } else {
                this.p.E(this.b0);
            }
        }
        if (toy.isF01Toy()) {
            this.p.r0(toy);
        } else {
            this.p.s0(toy);
        }
        this.b0 = toy;
    }

    public final boolean f1(String str) {
        T t2 = this.c;
        return t2 == 0 || !((Group) t2).getId().equals(str) || I1();
    }

    public final void f3() {
        this.multiControlPanel.X(new f());
        this.multiControlPanel.setToyChangeListener(new g());
    }

    @Override // dc.na2.b
    public void g() {
        if (r()) {
            int i2 = this.i + 1;
            this.i = i2;
            if (i2 % 5 == 0 && (this.y || i2 % 10 == 0)) {
                R2();
            }
            String strQ = WearUtils.Q(this.i);
            this.tvEndControlTime.setText(strQ);
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(strQ);
            }
        }
    }

    public final void g1() {
        if (this.multiControlPanel != null) {
            if (this.d0.size() <= 0) {
                this.multiControlPanel.S(this.e0);
            } else if (this.d0.size() > 1) {
                this.multiControlPanel.S(this.d0.remove(0));
            } else {
                this.multiControlPanel.S(this.d0.get(0));
            }
        }
    }

    public final void g3(ArrayList<Toy> arrayList) throws Resources.NotFoundException {
        this.W.clear();
        this.W.addAll(arrayList);
        if (arrayList.size() == 0) {
            Toy toy = new Toy();
            toy.setType("Diamo");
            toy.setName("Diamo");
            arrayList.add(toy);
            this.B = false;
            this.tvControlDlr.setVisibility(8);
        } else {
            Iterator<Toy> it = this.Z.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                if (S1(it.next())) {
                    z2 = true;
                }
            }
            if (LDRControl.m(this.Z) || z2) {
                this.B = true;
                this.tvControlDlr.setVisibility(0);
            } else {
                this.B = false;
                this.tvControlDlr.setVisibility(8);
            }
        }
        this.multiControlPanel.setHiddenVelvoIcon(!this.y);
        if (this.L) {
            this.multiControlPanel.q0(arrayList);
        } else {
            this.L = true;
            this.multiControlPanel.O(true, "GROUP_CHAT_SYNC_CONTROL", arrayList, Integer.MAX_VALUE, I().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height));
            f3();
        }
        l3(arrayList);
    }

    public int getPriority() {
        T t2 = this.c;
        return ((t2 == 0 || !((Group) t2).isExit()) && z()) ? 8 : 0;
    }

    public final void h1(Activity activity, boolean z2, boolean z3) {
        b0 b0Var = new b0(z3, activity);
        if (z2 && this.y) {
            is3.b bVar = new is3.b(activity);
            bVar.p(ah4.e(R.string.group_chat_sync_end_note));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.o(ah4.e(R.string.link_end_control));
            bVar.d(b0Var);
            cs3.h(bVar).show();
            return;
        }
        if (!z2) {
            b0Var.doConfirm();
            return;
        }
        is3.b bVar2 = new is3.b(activity);
        bVar2.p(ah4.e(R.string.message_control_end));
        bVar2.n(ah4.e(R.string.common_cancel));
        bVar2.o(ah4.e(R.string.link_end_control));
        bVar2.d(b0Var);
        cs3.h(bVar2).show();
    }

    public final void h3(ArrayList<Toy> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<Toy> it = arrayList.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isSupportLdr() || S1(next)) {
                arrayList2.add(next);
            }
        }
        Iterator<Toy> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Toy next2 = it2.next();
            if (!next2.isSupportLdr() && !S1(next2)) {
                arrayList2.add(next2);
            }
        }
        this.X.clear();
        this.X.addAll(arrayList2);
    }

    public void i1(String str, Activity activity, boolean z2, boolean z3) {
        T t2 = this.c;
        if (t2 == 0 || !((Group) t2).getId().equals(str)) {
            return;
        }
        if (r()) {
            h1(activity, z2, z3);
        } else {
            activity.finish();
        }
    }

    public final void i3() {
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = this.V.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isSupportLdr() || S1(next)) {
                arrayList.add(next);
            }
        }
        Iterator<Toy> it2 = this.V.iterator();
        while (it2.hasNext()) {
            Toy next2 = it2.next();
            if (!next2.isSupportLdr() && !S1(next2)) {
                arrayList.add(next2);
            }
        }
        this.V.clear();
        this.V.addAll(arrayList);
    }

    public void j(String str, List<Integer> list, List<Integer> list2) {
        Toy toy;
        if (I1() || (toy = this.b0) == null || WearUtils.e1(toy.getAddress()) || !this.b0.getAddress().equals(str)) {
            return;
        }
        int iIntValue = list.size() > 0 ? list.get(0).intValue() : 0;
        int iIntValue2 = list2.size() > 0 ? list2.get(0).intValue() : 0;
        if (iIntValue != 0) {
            ua2.a();
            WearUtils.p2(this.V, str);
            this.a0.notifyDataSetChanged();
        }
        U(new v(iIntValue));
        if (this.z && this.A && this.y) {
            W2(str, iIntValue, iIntValue2);
            X2(str, iIntValue, iIntValue2);
        }
    }

    public int j1() {
        return this.t;
    }

    @Override // dc.na2.b
    public void k() {
        if (this.S && !this.z) {
            g1();
        } else {
            if (this.y || this.z) {
                return;
            }
            g1();
        }
    }

    public final String k1(ArrayList<Toy> arrayList) {
        String str = "";
        for (String str2 : yg3.a(arrayList)) {
            str = str + str2 + ",";
        }
        if (TextUtils.isEmpty(str)) {
            return PSOProgramService.VS_Key;
        }
        String strSubstring = str.substring(0, str.length() - 1);
        return strSubstring.contains("s") ? "s" : strSubstring;
    }

    public void k3(boolean z2) {
        WearUtils.U0(this.V);
        this.a0.notifyDataSetChanged();
    }

    public void l1(String str, boolean z2) {
        if (this.c == 0) {
            return;
        }
        m1(z2);
    }

    public final void l3(List<Toy> list) {
        this.g0 = "";
        for (String str : yg3.a(list)) {
            this.g0 += str + ",";
        }
        if (TextUtils.isEmpty(this.g0)) {
            this.g0 = PSOProgramService.VS_Key;
        } else {
            this.g0 = this.g0.substring(0, r8.length() - 1);
        }
        String[] strArrSplit = this.g0.split(",");
        this.c0 = 3;
        if (strArrSplit == null || strArrSplit.length <= 0 || strArrSplit.length >= 3) {
            return;
        }
        this.c0 = strArrSplit.length;
    }

    public final void m1(boolean z2) {
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
            this.tvEndControlTime.setText("00:00");
        }
        GetGroupInfoRequest getGroupInfoRequest = new GetGroupInfoRequest();
        getGroupInfoRequest.setAckId(WearUtils.E());
        getGroupInfoRequest.setRoomId(((Group) this.c).getId());
        this.E.a(getGroupInfoRequest, new e());
    }

    public void m3(VelvoPreviewView velvoPreviewView) {
        if (velvoPreviewView == null) {
            return;
        }
        this.h0 = new jp3(this.multiControlPanel, velvoPreviewView, "GROUP_CHAT_SYNC_CONTROL");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.y82
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.f2(str);
            }
        });
    }

    public final ArrayList<GroupMember> n1(RoomReceiveSyncResponse roomReceiveSyncResponse, Group group) {
        ArrayList<GroupMember> arrayList = new ArrayList<>();
        for (RoomReceiveSyncResponse.PlayerListBean playerListBean : roomReceiveSyncResponse.getPlayerList()) {
            GroupMember memberByJid = group.getMemberByJid(playerListBean.getJid());
            if (memberByJid != null) {
                memberByJid.setStatus(playerListBean.getStatus());
                arrayList.add(memberByJid);
            }
        }
        return arrayList;
    }

    public void n2(MasterLineStatusNotifyResponse masterLineStatusNotifyResponse) {
        U(new y(masterLineStatusNotifyResponse));
    }

    public final void n3(final RoomReceiveSyncResponse roomReceiveSyncResponse, final Group group, GroupMember groupMember, ArrayList<GroupMember> arrayList) {
        final FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
            return;
        }
        if (arrayList.size() > 0) {
            String strP = ch3.n().p();
            Iterator<GroupMember> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GroupMember next = it.next();
                if (TextUtils.equals(strP, next.getJid())) {
                    arrayList.remove(next);
                    break;
                }
            }
        }
        GroupControledWaitAccpetDialog.c cVar = new GroupControledWaitAccpetDialog.c();
        cVar.a = arrayList;
        cVar.b = groupMember;
        cVar.c = roomReceiveSyncResponse.getRoomId();
        this.u = true;
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.e(cVar);
        bVar.h(true);
        bVar.x(ce3.a(fragmentActivityH, 311.0f));
        bVar.c(new is3.c() { // from class: dc.ja2
            @Override // dc.is3.c
            public final void doCancel() {
                this.a.B();
            }
        });
        bVar.d(new is3.d() { // from class: dc.b92
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.i2(fragmentActivityH, roomReceiveSyncResponse);
            }
        });
        is3 is3VarI = cs3.i(bVar, GroupControledWaitAccpetDialog.class);
        this.M = is3VarI;
        is3VarI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.c92
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.m2(fragmentActivityH, group, dialogInterface);
            }
        });
        this.M.show();
    }

    public final boolean o2(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return z2 ? str.length() > this.g0.length() : !str.equals(this.g0);
    }

    public void o3() {
        if (!r()) {
            F();
            return;
        }
        W();
        ViewGroup viewGroup = (ViewGroup) this.f0.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f0);
        }
    }

    @OnClick({R.id.iv_show_more_friend_1, R.id.iv_show_more_friend, R.id.tv_end_control_time, R.id.tv_control_dlr, R.id.tv_remote_control, R.id.tv_control_pattern})
    public void onClick(View view) throws Resources.NotFoundException {
        switch (view.getId()) {
            case R.id.iv_show_more_friend /* 2131363300 */:
            case R.id.iv_show_more_friend_1 /* 2131363301 */:
                this.C = !this.C;
                C1();
                t3();
                break;
            case R.id.tv_control_dlr /* 2131364995 */:
                y3(true);
                break;
            case R.id.tv_control_pattern /* 2131365008 */:
                if (this.z) {
                    z3(true, 3);
                }
                if (!this.S) {
                    this.S = true;
                    this.rvPattern.setVisibility(0);
                    this.multiControlPanel.setVisibility(0);
                    this.multiControlPanel.g0();
                    s3(false, true);
                    Z2(3);
                    this.clRemoteControled.setVisibility(8);
                    this.clLdrControlled.setVisibility(8);
                    this.clLdrMasterControl.setVisibility(8);
                    this.llControlFriends.setVisibility(8);
                    M2();
                    x3();
                }
                me3.d(me3.c.GROUP_CHAT_SYNC_CONTROL_PATTERN_BEGIN, me3.a());
                break;
            case R.id.tv_end_control_time /* 2131365075 */:
                h1(I(), j1() == 1, false);
                break;
            case R.id.tv_remote_control /* 2131365272 */:
                z3(true, 1);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ReCheckRoomStatusEvent reCheckRoomStatusEvent) {
        if (r()) {
            m1(false);
        }
    }

    public final String p1() {
        String[] strArrA;
        if (this.y) {
            ArrayList arrayList = new ArrayList();
            Iterator<GroupMember> it = this.x.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getToys());
            }
            strArrA = yg3.a(arrayList);
        } else {
            strArrA = yg3.a(this.Z);
        }
        String str = "";
        for (String str2 : strArrA) {
            str = str + str2 + ",";
        }
        return !TextUtils.isEmpty(str) ? str.substring(0, str.length() - 1) : PSOProgramService.VS_Key;
    }

    public final void p2(GroupLdrToyAdapter groupLdrToyAdapter, String str) {
        groupLdrToyAdapter.j = q1(str);
        groupLdrToyAdapter.notifyDataSetChanged();
        O2();
    }

    public void p3(Group group) {
        if (r()) {
            if (f1(group.getId())) {
                W();
            } else {
                q3();
            }
        }
    }

    public void pauseConnon(int i2) {
    }

    public final int q1(String str) {
        Iterator<Toy> it = this.V.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Toy next = it.next();
            if (TextUtils.isEmpty(str)) {
                if (next.isSupportLdr() || S1(next)) {
                    break;
                }
                i2++;
            } else {
                if (str.equals(next.getAndUpdateDeviceId())) {
                    break;
                }
                i2++;
            }
        }
        if (i2 < this.V.size()) {
            this.b0 = this.V.get(i2);
        }
        return i2;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void q2(int i2) {
        if (i2 != 0) {
            return;
        }
        this.a0.notifyDataSetChanged();
    }

    public void q3() {
        if (r()) {
            F();
            E e2 = this.f;
            if (e2 != 0) {
                ((gv1) e2).n0(this.c, this.f0);
            }
        }
    }

    @Override // dc.ra2
    public boolean r() {
        return j1() != 0;
    }

    public void r1(String str, boolean z2) {
        try {
            Dialog dialog = this.M;
            if (dialog instanceof GroupControledWaitAccpetDialog) {
                GroupControledWaitAccpetDialog groupControledWaitAccpetDialog = (GroupControledWaitAccpetDialog) dialog;
                if (groupControledWaitAccpetDialog.f() != null && groupControledWaitAccpetDialog.isShowing() && groupControledWaitAccpetDialog.f().c.equals(str)) {
                    groupControledWaitAccpetDialog.p(z2);
                }
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public void recovery() {
    }

    public void s1() {
        jp3 jp3Var = this.h0;
        if (jp3Var != null) {
            jp3Var.e();
        }
    }

    public final void s2(String str) throws Resources.NotFoundException {
        RoomReceiveSyncResponse roomReceiveSyncResponse = (RoomReceiveSyncResponse) JSON.parseObject(str, RoomReceiveSyncResponse.class);
        if (roomReceiveSyncResponse.suc()) {
            if (!roomReceiveSyncResponse.isSyncControlling()) {
                if (r()) {
                    E e2 = this.f;
                    if (e2 != 0) {
                        ((gv1) e2).N1(this.c, 1);
                    }
                    y1();
                    return;
                }
                return;
            }
            int iJ1 = j1();
            String strP = ch3.n().p();
            GroupMember memberByJid = ((Group) this.c).getMemberByJid(roomReceiveSyncResponse.getMaster().getJid());
            this.F = memberByJid;
            if (memberByJid == null) {
                return;
            }
            na2.m().f();
            boolean zR = r();
            b3(0);
            this.tvLdrWaitReconnectTip.setVisibility(8);
            this.tvRemoteWaitReconnectTip.setVisibility(8);
            x1(this.F, roomReceiveSyncResponse.getMaster().getToyJson());
            if (this.F.getToys().size() != 0) {
                this.V.clear();
                this.V.addAll(this.F.getToys());
                this.A = LDRControl.n(this.V, true);
                this.U.notifyDataSetChanged();
                this.a0.notifyDataSetChanged();
            }
            this.F.setStatus(2);
            A3(roomReceiveSyncResponse);
            c3(roomReceiveSyncResponse, strP);
            B1();
            boolean zEquals = "LDR".equals(roomReceiveSyncResponse.getMaster().getScMethodEnum());
            if (j1() == 1) {
                e1(roomReceiveSyncResponse, zR, zEquals);
                return;
            }
            if (j1() == 2) {
                d1(iJ1, zR, zEquals);
                return;
            }
            pc1.a.I();
            if (iJ1 != 0) {
                y1();
                E e3 = this.f;
                if (e3 != 0) {
                    ((gv1) e3).N1(this.c, 1);
                }
            }
        }
    }

    public final void s3(boolean z2, boolean z3) throws Resources.NotFoundException {
        v1();
        int dimensionPixelSize = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_group_sync_control_panel_height);
        int dimensionPixelSize2 = ve0.a().getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_curve_item_height);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
        if (z2) {
            this.multiControlPanel.j0(true, z3);
            if (this.c0 >= 2) {
                this.multiControlPanel.setPanelPercent(0.2807f);
                layoutParams.height = dimensionPixelSize + (dimensionPixelSize2 * 2);
            } else {
                this.multiControlPanel.setPanelPercent(0.16326f);
                layoutParams.height = dimensionPixelSize + dimensionPixelSize2;
            }
            this.multiControlPanel.setLayoutParams(layoutParams);
            return;
        }
        this.multiControlPanel.j0(false, z3);
        this.multiControlPanel.setPanelPercent(1.0f);
        layoutParams.width = gg3.e(ve0.a());
        if (this.c0 >= 2) {
            layoutParams.height = dimensionPixelSize2 * 2;
        } else {
            layoutParams.height = dimensionPixelSize2;
        }
        this.multiControlPanel.setLayoutParams(layoutParams);
    }

    public void stop(int i2) {
        if (r()) {
            U(new c0());
        } else if (J1()) {
            B();
        }
    }

    public void t1(ArrayList<GroupMember> arrayList) {
        this.r.clear();
        this.r.addAll(arrayList);
    }

    @Override // com.wear.adapter.BaseAdapter.b
    /* renamed from: t2, reason: merged with bridge method [inline-methods] */
    public void a0(GroupMember groupMember, int i2, View view) {
        if (groupMember.getStatus() != 2) {
            sg3.l(String.format(ah4.e(R.string.group_chat_sync_request_onhold), groupMember.getNickName()));
            return;
        }
        is3.b bVar = new is3.b(I());
        bVar.e(groupMember);
        bVar.x(gg3.e(this.g));
        bVar.i(80);
        bVar.l(true);
        bVar.m(true);
        GroupControlMemberInfoDialog groupControlMemberInfoDialog = (GroupControlMemberInfoDialog) cs3.i(bVar, GroupControlMemberInfoDialog.class);
        if (this.b.getUserJid().equals(groupMember.getJid())) {
            groupControlMemberInfoDialog.setMasterControl(false);
        } else {
            groupControlMemberInfoDialog.setMasterControl(this.y);
        }
        groupControlMemberInfoDialog.show();
        groupControlMemberInfoDialog.setListener(new b());
    }

    public final void t3() {
        this.w.clear();
        if (this.C) {
            this.w.addAll(this.x);
        } else {
            Iterator<GroupMember> it = this.x.iterator();
            while (it.hasNext()) {
                GroupMember next = it.next();
                if (this.w.size() < 5) {
                    this.w.add(next);
                }
            }
        }
        this.v.notifyDataSetChanged();
    }

    public void u1() throws Resources.NotFoundException {
        ArrayList<Toy> arrayList = new ArrayList<>();
        if (this.y) {
            Iterator<GroupMember> it = this.x.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getToys());
            }
        } else {
            arrayList.addAll(this.Z);
        }
        v1();
        g3(arrayList);
        ou3.c();
    }

    public final void u2() {
        this.u = false;
        this.t = 0;
        this.q.removeCallbacksAndMessages(null);
        this.r.clear();
        this.M = null;
    }

    public final void u3(int i2, ArrayList<Toy> arrayList) {
        GroupToysBatteryAdapter groupToysBatteryAdapter;
        GroupToysBatteryAdapter groupToysBatteryAdapter2;
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() < 3) {
            arrayList.size();
        }
        if (i2 == 0) {
            this.P.clear();
            this.P.addAll(arrayList);
            if (this.P.size() == 0 && (groupToysBatteryAdapter2 = this.O) != null) {
                groupToysBatteryAdapter2.notifyDataSetChanged();
                return;
            }
            this.O = new GroupToysBatteryAdapter(this.P, R.layout.item_group_toy_battery);
            AutoLineFeedLayoutManager autoLineFeedLayoutManager = new AutoLineFeedLayoutManager();
            autoLineFeedLayoutManager.setAutoMeasureEnabled(true);
            this.rvMyToysBatteryView.setLayoutManager(autoLineFeedLayoutManager);
            this.rvMyToysBatteryView.setAdapter(this.O);
            return;
        }
        this.R.clear();
        this.R.addAll(arrayList);
        if (this.R.size() == 0 && (groupToysBatteryAdapter = this.Q) != null) {
            groupToysBatteryAdapter.notifyDataSetChanged();
            return;
        }
        this.Q = new GroupToysBatteryAdapter(this.R, R.layout.item_group_toy_battery);
        AutoLineFeedLayoutManager autoLineFeedLayoutManager2 = new AutoLineFeedLayoutManager();
        autoLineFeedLayoutManager2.setAutoMeasureEnabled(true);
        this.rvMasterToysBatteryView.setLayoutManager(autoLineFeedLayoutManager2);
        this.rvMasterToysBatteryView.setAdapter(this.Q);
    }

    public final void v1() {
        this.d0.clear();
        this.e0.clear();
        if (TextUtils.isEmpty(this.g0)) {
            this.g0 = PSOProgramService.VS_Key;
        }
        for (String str : this.g0.split(",")) {
            str.hashCode();
            switch (str) {
                case "d":
                    this.e0.add(new Ball2CurveEventBean("", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, String.valueOf(0)));
                    break;
                case "f":
                    this.e0.add(new Ball2CurveEventBean("", "f", String.valueOf(0)));
                    break;
                case "p":
                    this.e0.add(new Ball2CurveEventBean("", "p", String.valueOf(0)));
                    break;
                case "r":
                    this.e0.add(new Ball2CurveEventBean("", StreamManagement.AckRequest.ELEMENT, String.valueOf(0)));
                    break;
                case "s":
                    this.e0.add(new Ball2CurveEventBean("", "s", String.valueOf(0)));
                    break;
                case "t":
                    this.e0.add(new Ball2CurveEventBean("", "t", String.valueOf(0)));
                    break;
                case "v":
                    this.e0.add(new Ball2CurveEventBean("", PSOProgramService.VS_Key, String.valueOf(0)));
                    break;
                case "pos":
                    this.e0.add(new Ball2CurveEventBean("", "pos", String.valueOf(0)));
                    break;
            }
        }
        this.d0.add(this.e0);
    }

    public final void v2() {
        WearUtils.z2();
        if (!WearUtils.x.f0()) {
            WearUtils.K1(false, null);
        } else if (og3.b(1) && og3.b(2)) {
            WearUtils.K1(false, null);
        }
    }

    public void v3() {
        if (r() && this.h0 != null && this.y && !P1()) {
            this.h0.r();
        }
    }

    public final void w1() {
        d0(this.g, R.drawable.full_control_sync, "sync.json");
        this.g.G().t(this);
        sz1.d().n(this);
        EventBus.getDefault().register(this);
        this.v = new FriendControlAdapter(this.w, R.layout.item_friends_control);
        this.rvFriend.setLayoutManager(new e0(this, this.rvFriend.getContext(), 5));
        this.rvFriend.setAdapter(this.v);
        this.v.s(this);
        this.U = new GroupLdrToyAdapter(this.V, R.layout.item_group_ldr_toy);
        GroupLdrToyAdapter groupLdrToyAdapter = new GroupLdrToyAdapter(this.V, R.layout.item_group_ldr_toy, true);
        this.a0 = groupLdrToyAdapter;
        cg3.d(this.rvLdrMasterControlToy, groupLdrToyAdapter);
        cg3.d(this.rvFriendToy, this.U);
        GroupLdrToyAdapter groupLdrToyAdapter2 = new GroupLdrToyAdapter(this.X, R.layout.item_group_ldr_toy);
        this.Y = groupLdrToyAdapter2;
        cg3.d(this.rvSelfToy, groupLdrToyAdapter2);
        this.a0.B(new f0());
        GroupControlPatternAdapter groupControlPatternAdapter = new GroupControlPatternAdapter(this.T, R.layout.item_group_control_pattern);
        this.D = groupControlPatternAdapter;
        cg3.f(this.rvPattern, groupControlPatternAdapter);
        this.D.D(new g0());
        A1();
    }

    public void w2(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || this.c == 0) {
            return;
        }
        if (!r()) {
            F();
        } else if (((Group) this.c).getId().equals(iPeopleInfo.getId())) {
            q3();
        } else {
            o3();
        }
    }

    public final void w3(boolean z2) throws Resources.NotFoundException {
        this.C = false;
        this.y = true;
        this.z = false;
        E e2 = this.f;
        if (e2 != 0) {
            ((gv1) e2).l(this.c);
        }
        F();
        C1();
        t3();
        this.clLdrControlled.setVisibility(8);
        this.clLdrMasterControl.setVisibility(8);
        this.rvPattern.setVisibility(8);
        this.clRemoteControled.setVisibility(8);
        this.llControlFriends.setVisibility(0);
        if (this.A) {
            Z2(2);
        } else {
            Z2(1);
        }
        this.S = false;
        D1();
    }

    public final void x1(GroupMember groupMember, String str) {
        SyncLinkToy syncLinkToy = !TextUtils.isEmpty(str) ? (SyncLinkToy) JSON.parseObject(CommunMessage.decrypt(str), SyncLinkToy.class) : null;
        if (syncLinkToy == null || syncLinkToy.getToys() == null) {
            groupMember.setToys(null);
        } else {
            groupMember.setToys(syncLinkToy.getToys());
        }
    }

    public void x2(PlayerAcceptRoomSyncResponse playerAcceptRoomSyncResponse) {
        if (playerAcceptRoomSyncResponse.suc()) {
            U(new i(playerAcceptRoomSyncResponse));
        }
    }

    public final void x3() {
        W2(null, 0, 0);
        X2(null, 0, 0);
        Iterator<Map.Entry<Toy, ImageView>> it = this.a0.o.entrySet().iterator();
        while (it.hasNext()) {
            C3(it.next().getValue(), 0);
        }
    }

    public final void y1() {
        b3(0);
        this.y = false;
        this.A = false;
        this.z = false;
        this.i = 0;
        F();
    }

    public final void y2() {
        rq1.d.q();
        T2();
    }

    public final void y3(boolean z2) {
        k3(true);
        a aVar = new a();
        if (!z2) {
            aVar.Q("");
            Iterator<Toy> it = this.Z.iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isF01Toy()) {
                    this.p.s0(next);
                }
            }
            return;
        }
        SwitchRoomLDRRequest switchRoomLDRRequest = new SwitchRoomLDRRequest();
        switchRoomLDRRequest.setRoomId(((Group) this.c).getId());
        switchRoomLDRRequest.setAckId(WearUtils.E());
        this.E.a(switchRoomLDRRequest, aVar);
        if (this.y && this.V.size() != 0) {
            Toy toy = this.b0;
            if (toy == null || !this.V.contains(toy)) {
                for (int i2 = 0; i2 < this.V.size(); i2++) {
                    if (this.V.get(i2).isSupportLdr() || S1(this.V.get(i2))) {
                        this.a0.j = i2;
                        this.b0 = this.V.get(i2);
                        break;
                    }
                }
            } else {
                this.a0.j = this.V.indexOf(this.b0);
            }
            this.a0.notifyDataSetChanged();
        }
        d3();
    }

    @Override // dc.ka2
    public boolean z() {
        return r() || J1();
    }

    public void z1(String str) {
        y1();
    }

    public final void z2(boolean z2) {
        U(new o(z2));
    }

    public final void z3(boolean z2, int i2) {
        h0 h0Var = new h0(i2);
        if (!z2) {
            h0Var.Q("");
            return;
        }
        SwitchRoomRemoteControlRequest switchRoomRemoteControlRequest = new SwitchRoomRemoteControlRequest();
        switchRoomRemoteControlRequest.setRoomId(((Group) this.c).getId());
        switchRoomRemoteControlRequest.setAckId(WearUtils.E());
        this.E.a(switchRoomRemoteControlRequest, h0Var);
    }

    public ChatGroupControl() {
        this.p = pc1.a;
        this.q = new Handler(Looper.getMainLooper());
        this.r = new ArrayList<>();
        this.t = 0;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.A = true;
        this.B = true;
        this.C = false;
        this.E = vb2.b();
        this.G = "";
        this.L = false;
        this.N = getClass().getSimpleName();
        this.P = new ArrayList<>();
        this.R = new ArrayList<>();
        this.T = new ArrayList<>();
        this.V = new ArrayList<>();
        this.W = new ArrayList<>();
        this.X = new ArrayList<>();
        this.Z = new ArrayList<>();
        this.d0 = new ArrayList();
        this.e0 = new ArrayList();
        this.g0 = PSOProgramService.VS_Key;
        this.g = WearUtils.x;
        this.s = vb2.b();
        this.b = ch3.n().u();
        U(new k());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(final xc1 xc1Var) throws Resources.NotFoundException {
        Toy toy;
        if (!TextUtils.isEmpty(xc1Var.a()) && r()) {
            pc1.a.G(xc1Var.a());
            Toy toyQ = this.p.Q(xc1Var.a());
            if (!this.Z.contains(toyQ) && toyQ.isConnected()) {
                this.Z.clear();
                this.Z.addAll(this.p.P());
                if (this.Y != null) {
                    h3(this.Z);
                    this.Y.notifyDataSetChanged();
                }
            } else if (this.Z.contains(toyQ) && !toyQ.isConnected()) {
                this.Z.remove(toyQ);
                if (this.Y != null) {
                    h3(this.Z);
                    this.Y.notifyDataSetChanged();
                }
            }
            u3(0, this.Z);
            ArrayList<Toy> arrayList = new ArrayList<>();
            if (this.y) {
                if (!this.V.contains(toyQ) && toyQ.isConnected()) {
                    this.V.clear();
                    this.V.addAll(this.p.P());
                    if (this.a0 != null) {
                        i3();
                        Toy toy2 = this.b0;
                        if (toy2 != null) {
                            if (this.V.contains(toy2)) {
                                this.a0.j = this.V.indexOf(this.b0);
                            } else {
                                this.a0.j = -1;
                            }
                        }
                        this.a0.notifyDataSetChanged();
                    }
                } else if (this.V.contains(toyQ) && !toyQ.isConnected()) {
                    this.V.remove(toyQ);
                    if (this.a0 != null) {
                        Toy toy3 = this.b0;
                        if (toy3 != null) {
                            if (this.V.contains(toy3)) {
                                this.a0.j = this.V.indexOf(this.b0);
                            } else {
                                this.a0.j = -1;
                            }
                        }
                        this.a0.notifyDataSetChanged();
                    }
                }
                Iterator<GroupMember> it = this.x.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next().getToys());
                }
                if (arrayList.contains(toyQ) && !toyQ.isConnected()) {
                    arrayList.remove(toyQ);
                }
                if (!arrayList.contains(toyQ) && toyQ.isConnected()) {
                    arrayList.add(toyQ);
                }
            } else {
                arrayList.addAll(this.Z);
            }
            g3(arrayList);
            if (this.y && !this.S) {
                s3(true, true);
            } else {
                s3(false, true);
            }
            if (this.z) {
                if (this.y && (toy = this.b0) != null && !WearUtils.e1(toy.getAddress())) {
                    this.q.postDelayed(new Runnable() { // from class: dc.z82
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.W1(xc1Var);
                        }
                    }, 1000L);
                } else {
                    this.q.postDelayed(new Runnable() { // from class: dc.a92
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.Y1(xc1Var);
                        }
                    }, 1000L);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        ImageView imageView;
        Toy toyQ = this.p.Q(vc1Var.a());
        if (toyQ != null) {
            ImageView imageView2 = this.a0.p.get(toyQ.getAndUpdateDeviceId());
            if (!toyQ.isF01Toy()) {
                Toy.updateToyBattery(imageView2, vc1Var.b());
            } else if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.Y.p.get(toyQ.getAndUpdateDeviceId());
            if (!toyQ.isF01Toy()) {
                Toy.updateToyBattery(imageView3, vc1Var.b());
            } else if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            if (j1() == 1) {
                ImageView imageView4 = this.U.p.get(toyQ.getAndUpdateDeviceId());
                if (!toyQ.isF01Toy()) {
                    Toy.updateToyBattery(imageView4, vc1Var.b());
                } else if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
            }
            GroupToysBatteryAdapter groupToysBatteryAdapter = this.O;
            if (groupToysBatteryAdapter == null || (imageView = groupToysBatteryAdapter.j.get(toyQ.getAndUpdateDeviceId())) == null) {
                return;
            }
            if (toyQ.isF01Toy()) {
                imageView.setVisibility(8);
            } else {
                Toy.updateToyBattery(imageView, toyQ.getBattery());
            }
        }
    }
}
