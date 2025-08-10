package com.wear.main.longDistance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.BaseActivity;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.GroupMemberAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.UserSetting;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.event.GroupInvitationEvent;
import com.wear.bean.event.GroupInvitationSettingEvent;
import com.wear.bean.event.GroupMemberEvent;
import com.wear.bean.event.GroupNameChangeEvent;
import com.wear.bean.handlerbean.IGroupMember;
import com.wear.bean.handlerbean.item.HeadGroupMember;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.main.account.EditNickNameActivity;
import com.wear.main.account.EditNickNameByFriendActivity;
import com.wear.main.longDistance.report.ReasonOptionActivity;
import com.wear.main.longDistance.report.ResultActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.wear.widget.dialog.ManagerGroupMemberInfoDialog;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import dc.ah4;
import dc.be3;
import dc.bo3;
import dc.ce3;
import dc.ch3;
import dc.cs3;
import dc.dv1;
import dc.eg3;
import dc.ep1;
import dc.gg3;
import dc.gp1;
import dc.hf3;
import dc.hp1;
import dc.ip1;
import dc.is3;
import dc.kg3;
import dc.kn3;
import dc.kv1;
import dc.pf3;
import dc.pj3;
import dc.q61;
import dc.qe3;
import dc.r12;
import dc.sg3;
import dc.t51;
import dc.tg3;
import dc.th4;
import dc.u51;
import dc.vg3;
import dc.vo2;
import dc.ye3;
import dc.yl2;
import dc.zb2;
import dc.zt3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.disco.bean.request.InviteBean;
import org.jivesoftware.smackx.disco.bean.request.RequestMemberInvite;
import org.jivesoftware.smackx.disco.bean.request.RequestMembersRemove;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomExit;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomQrcodeCreate;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomSetting;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponseCreateChatRoom;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeCreate;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomSettingInfo;

/* loaded from: classes3.dex */
public class ChatRoomInfoActivity extends BaseActivity<yl2> implements BaseAdapter.b<IGroupMember>, vo2 {
    public yl2 a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public Group b;
    public GroupMemberAdapter c;

    @BindView(R.id.group_qrcode_line)
    public View groupQrcodeLine;
    public IGroupMember h;
    public ResponseRoomSettingInfo i;

    @BindView(R.id.iv_chat_background)
    public ImageView ivChatBackground;

    @BindView(R.id.iv_group_name)
    public ImageView ivGroupName;

    @BindView(R.id.iv_group_nick_name)
    public ImageView ivGroupNickName;

    @BindView(R.id.iv_manager_group)
    public ImageView ivManagerGroup;

    @BindView(R.id.iv_user_nick_name)
    public ImageView ivUserNickName;

    @BindView(R.id.ll_auto_control)
    public LinearLayout llAutoControl;

    @BindView(R.id.ll_exit_tip)
    public LinearLayout llExitTip;

    @BindView(R.id.ll_group_members)
    public LinearLayout llGroupMembers;

    @BindView(R.id.ll_notification_setting)
    public LinearLayout llNotificationSetting;

    @BindView(R.id.ll_screan_root_layout)
    public LinearLayout llScreanRootLayout;

    @BindView(R.id.ll_search_chat_history)
    public LinearLayout llSearchChatHistory;

    @BindView(R.id.ll_show_more)
    public SkinRoundAutoLinearLayout llShowMore;

    @BindView(R.id.ll_top_info)
    public LinearLayout llTopInfo;

    @BindView(R.id.ll_vibrate_toy)
    public LinearLayout llVibrateToy;
    public UserSetting m;

    @BindView(R.id.manager_group_line)
    public View manager_group_line;
    public int n;
    public File o;
    public Uri p;

    @BindView(R.id.rl_chat_background)
    public RelativeLayout rlChatBackground;

    @BindView(R.id.rl_clear_chat_message)
    public RelativeLayout rlClearChatMessage;

    @BindView(R.id.rl_exit_group)
    public RelativeLayout rlExitGroup;

    @BindView(R.id.rl_group_name)
    public View rlGroupName;

    @BindView(R.id.rl_group_nick_name)
    public View rlGroupNickName;

    @BindView(R.id.rl_group_qrcode)
    public LinearLayout rlGroupQrcode;

    @BindView(R.id.rl_manager_group)
    public View rlManagerGroup;

    @BindView(R.id.rl_mute)
    public RelativeLayout rlMute;

    @BindView(R.id.rl_report)
    public RelativeLayout rlReport;

    @BindView(R.id.rl_stick_top)
    public RelativeLayout rlStickTop;

    @BindView(R.id.rl_user_nick_name)
    public View rlUserNickName;

    @BindView(R.id.rl_v_alarm)
    public RelativeLayout rlVAlarm;

    @BindView(R.id.rl_v_audio)
    public RelativeLayout rlVAudio;

    @BindView(R.id.rl_v_auto_play_control)
    public RelativeLayout rlVAutoPlayControl;

    @BindView(R.id.rl_v_message)
    public RelativeLayout rlVMessage;

    @BindView(R.id.rl_v_pattern)
    public RelativeLayout rlVPattern;

    @BindView(R.id.rv_group_members)
    public RecyclerView rvGroupMembers;

    @BindView(R.id.sb_mute)
    public SwitchView sbMute;

    @BindView(R.id.sb_stick_top)
    public SwitchView sbStickTop;

    @BindView(R.id.sb_v_alarm)
    public SwitchView sbVAlarm;

    @BindView(R.id.sb_v_audio)
    public SwitchView sbVAudio;

    @BindView(R.id.sb_v_auto_play_control)
    public SwitchView sbVAutoPlayControl;

    @BindView(R.id.sb_v_message)
    public SwitchView sbVMessage;

    @BindView(R.id.sb_v_pattern)
    public SwitchView sbVPattern;

    @BindView(R.id.tv_clear_chat_message_text)
    public TextView tvClearChatMessageText;

    @BindView(R.id.tv_count)
    public TextView tvCount;

    @BindView(R.id.tv_exit_group)
    public TextView tvExitGroup;

    @BindView(R.id.tv_exit_tip)
    public TextView tvExitTip;

    @BindView(R.id.tv_group_name)
    public TextView tvGroupName;

    @BindView(R.id.tv_group_nick_name)
    public TextView tvGroupNickName;

    @BindView(R.id.tv_show_more)
    public TextView tvShowMore;

    @BindView(R.id.tv_user_nick_name)
    public TextView tvUserNickName;

    @BindView(R.id.user_img)
    public RoundedImageView userImg;

    @BindView(R.id.view_search_chat_history)
    public View view_search_chat_history;
    public ArrayList<IGroupMember> d = new ArrayList<>();
    public int e = 4;
    public int f = 5;
    public UserSettingsBean g = null;
    public HeadGroupMember j = new HeadGroupMember();
    public String k = "";
    public String l = "";

    public class a implements is3.d {
        public final /* synthetic */ int a;

        /* renamed from: com.wear.main.longDistance.ChatRoomInfoActivity$a$a, reason: collision with other inner class name */
        public class C0115a implements kv1 {
            public C0115a() {
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    ChatRoomInfoActivity.this.b.setStatus(2);
                    ChatRoomInfoActivity.this.finish();
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class b implements dv1 {
            public b() {
            }

            @Override // dc.dv1
            public void d() {
                ChatRoomInfoActivity.this.b.setStatus(3);
                ChatRoomInfoActivity.this.finish();
            }
        }

        public a(int i) {
            this.a = i;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (this.a != 1) {
                ch3.n().I(ChatRoomInfoActivity.this.l, new b());
                return;
            }
            RequestRoomExit requestRoomExit = new RequestRoomExit();
            requestRoomExit.setRoomId(ChatRoomInfoActivity.this.l);
            requestRoomExit.setStatus(2);
            zb2.O().C0(requestRoomExit, WearUtils.k0(ChatRoomInfoActivity.this.l), new C0115a());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WearUtils.A(ChatRoomInfoActivity.this.b.getUserJid());
            DaoUtils.getCommunMessageDao().deleteByFriendEmail(ChatRoomInfoActivity.this.l);
            DaoUtils.getEmojiFavoriteDao().deleteAllOwner(ChatRoomInfoActivity.this.l);
            DaoUtils.getMessageHideDao().deleteAllHides(WearUtils.i0(zt3.k), WearUtils.k0(ChatRoomInfoActivity.this.l));
            DaoUtils.getMessageUnReadDao().deleteAllUnRead(WearUtils.i0(zt3.k), WearUtils.k0(ChatRoomInfoActivity.this.l));
            EventBus.getDefault().post(new ClearChatViewFriendIdEvent(ChatRoomInfoActivity.this.l));
        }
    }

    public class c implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(ChatRoomInfoActivity.this);
            }
        }

        public c() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                is3.b bVar = new is3.b(ChatRoomInfoActivity.this.activity);
                bVar.p(ah4.e(R.string.app_open_camera_permission));
                bVar.o(ah4.e(R.string.common_confirm));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.d(new a());
                cs3.h(bVar).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ChatRoomInfoActivity.this.Y4();
            }
        }
    }

    public class d implements bo3.d {
        public d() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (ChatRoomInfoActivity.this.o.exists()) {
                ChatRoomInfoActivity.this.o.delete();
            }
            tg3.k(ChatRoomInfoActivity.this.activity, 17);
        }
    }

    public class e implements bo3.d {
        public e() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ChatRoomInfoActivity chatRoomInfoActivity = ChatRoomInfoActivity.this;
            chatRoomInfoActivity.p = tg3.l(chatRoomInfoActivity, chatRoomInfoActivity.o, 16);
        }
    }

    public class f implements bo3.d {
        public final /* synthetic */ File a;

        public f(File file) {
            this.a = file;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (this.a.delete()) {
                sg3.i(ChatRoomInfoActivity.this, R.string.partner_profile_black_setting_success);
            }
            ChatRoomInfoActivity.this.addAnalyticsEventId("resetChatBackground", null);
        }
    }

    public class g implements bo3.d {
        public g(ChatRoomInfoActivity chatRoomInfoActivity) {
        }

        @Override // dc.bo3.d
        public void a(int i) {
        }
    }

    public class h implements ManagerGroupMemberInfoDialog.j {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public h(ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.j
        public void a(IGroupMember iGroupMember) {
            ChatRoomInfoActivity.this.V4(WearUtils.i0(iGroupMember.getId()));
            this.a.dismiss();
        }
    }

    public class i implements ManagerGroupMemberInfoDialog.i {
        public final /* synthetic */ int a;

        public class a implements kv1 {
            public final /* synthetic */ IGroupMember a;

            /* renamed from: com.wear.main.longDistance.ChatRoomInfoActivity$i$a$a, reason: collision with other inner class name */
            public class RunnableC0116a implements Runnable {
                public RunnableC0116a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a.setPermission(30);
                    i iVar = i.this;
                    ChatRoomInfoActivity.this.c.notifyItemChanged(iVar.a);
                }
            }

            public a(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    ChatRoomInfoActivity.this.runOnMainThread(new RunnableC0116a());
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class b implements kv1 {
            public final /* synthetic */ IGroupMember a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.a.setPermission(20);
                    i iVar = i.this;
                    ChatRoomInfoActivity.this.c.notifyItemChanged(iVar.a);
                }
            }

            public b(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((ResponseCreateChatRoom) JSON.parseObject(str, ResponseCreateChatRoom.class)).suc()) {
                    ChatRoomInfoActivity.this.runOnMainThread(new a());
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class c implements kv1 {
            public final /* synthetic */ IGroupMember a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    int size = ChatRoomInfoActivity.this.b.getMembers().size();
                    c cVar = c.this;
                    ChatRoomInfoActivity chatRoomInfoActivity = ChatRoomInfoActivity.this;
                    if (size >= chatRoomInfoActivity.e * chatRoomInfoActivity.f) {
                        chatRoomInfoActivity.b.removeMemberByJid(WearUtils.i0(cVar.a.getId()));
                        ChatRoomInfoActivity.this.I4();
                    } else {
                        chatRoomInfoActivity.b.removeMemberByJid(WearUtils.i0(cVar.a.getId()));
                        i iVar = i.this;
                        ChatRoomInfoActivity.this.c.r(iVar.a);
                    }
                }
            }

            public c(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    ChatRoomInfoActivity.this.runOnMainThread(new a());
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public i(int i) {
            this.a = i;
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void a(IGroupMember iGroupMember) {
            RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
            requestMembersRemove.setRoomId(ChatRoomInfoActivity.this.l);
            requestMembersRemove.setType(1);
            requestMembersRemove.setJid(WearUtils.i0(iGroupMember.getId()));
            zb2.O().C0(requestMembersRemove, WearUtils.k0(ChatRoomInfoActivity.this.l), new c(iGroupMember));
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void b(IGroupMember iGroupMember) {
            RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
            requestMembersRemove.setRoomId(ChatRoomInfoActivity.this.l);
            requestMembersRemove.setType(2);
            requestMembersRemove.setJid(WearUtils.i0(iGroupMember.getId()));
            zb2.O().C0(requestMembersRemove, WearUtils.k0(ChatRoomInfoActivity.this.l), new a(iGroupMember));
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void c(IGroupMember iGroupMember) {
            RequestMemberInvite requestMemberInvite = new RequestMemberInvite();
            ArrayList arrayList = new ArrayList();
            InviteBean inviteBean = new InviteBean();
            inviteBean.setJid(WearUtils.i0(iGroupMember.getId()));
            inviteBean.setNickName(iGroupMember.getNickName());
            arrayList.add(inviteBean);
            requestMemberInvite.setInvite(arrayList);
            requestMemberInvite.setRoomId(ChatRoomInfoActivity.this.l);
            requestMemberInvite.setSetAffiliation(20);
            zb2.O().C0(requestMemberInvite, WearUtils.k0(ChatRoomInfoActivity.this.l), new b(iGroupMember));
        }
    }

    public class j implements kn3.d {
        public j() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(ChatRoomInfoActivity.this);
        }
    }

    public class k extends GridLayoutManager {
        public k(ChatRoomInfoActivity chatRoomInfoActivity, Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public class l implements tg3.a {
        public l() {
        }

        @Override // dc.tg3.a
        public void a(Bitmap bitmap, String str) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            File fileO = WearUtils.O();
            WearUtils.r(byteArrayInputStream, fileO);
            ChatRoomInfoActivity.this.X4(fileO);
        }
    }

    public class m implements kv1 {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ChatRoomInfoActivity.this.isFinishing() || ChatRoomInfoActivity.this.isDestroyed()) {
                    return;
                }
                ChatRoomInfoActivity.this.K4();
            }
        }

        public m(String str) {
            this.a = str;
        }

        @Override // dc.kv1
        public void a(String str) {
            if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                ChatRoomInfoActivity.this.b.setName(this.a);
                ChatRoomInfoActivity.this.runOnMainThread(new a());
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
        }
    }

    public class n implements kv1 {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar = n.this;
                ChatRoomInfoActivity.this.tvUserNickName.setText(nVar.a);
                ChatRoomInfoActivity.this.c.notifyDataSetChanged();
            }
        }

        public n(String str) {
            this.a = str;
        }

        @Override // dc.kv1
        public void a(String str) {
            GroupMember memberByJid;
            if (!((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc() || (memberByJid = ChatRoomInfoActivity.this.b.getMemberByJid(ch3.n().p())) == null) {
                return;
            }
            memberByJid.setNickName(this.a);
            ChatRoomInfoActivity.this.runOnMainThread(new a());
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
        }
    }

    public class o implements u51 {
        public o() {
        }

        @Override // dc.u51
        public /* synthetic */ void a(List list, boolean z) {
            t51.a(this, list, z);
        }

        @Override // dc.u51
        public void b(@NonNull List<String> list, boolean z) {
            if (z) {
                ChatRoomInfoActivity.this.sbVAlarm.setCheckedImmediatelyNoEvent(true);
                ChatRoomInfoActivity.this.W4(true);
            }
        }
    }

    public class p implements CompoundButton.OnCheckedChangeListener {
        public p() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChatRoomInfoActivity.this.m != null) {
                ChatRoomInfoActivity.this.m.setMessageVibration(Boolean.valueOf(ChatRoomInfoActivity.this.sbVMessage.isChecked()));
                DaoUtils.getUserSettingDao().update((UserSettingDao) ChatRoomInfoActivity.this.m);
            }
        }
    }

    public class q implements CompoundButton.OnCheckedChangeListener {
        public q() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChatRoomInfoActivity.this.m != null) {
                ChatRoomInfoActivity.this.m.setAudioVibration(Boolean.valueOf(ChatRoomInfoActivity.this.sbVAudio.isChecked()));
                DaoUtils.getUserSettingDao().update((UserSettingDao) ChatRoomInfoActivity.this.m);
            }
        }
    }

    public class r implements CompoundButton.OnCheckedChangeListener {

        public class a implements Runnable {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (this.a) {
                    ChatRoomInfoActivity chatRoomInfoActivity = ChatRoomInfoActivity.this;
                    UserSettingsBean userSettingsBean = chatRoomInfoActivity.g;
                    if (userSettingsBean != null) {
                        userSettingsBean.setMuteFlag(1);
                    } else {
                        WearUtils.x.i.F(WearUtils.k0(chatRoomInfoActivity.l), 1);
                        WearUtils.x.i.B(true, WearUtils.k0(ChatRoomInfoActivity.this.l));
                    }
                    i = 1;
                } else {
                    ChatRoomInfoActivity chatRoomInfoActivity2 = ChatRoomInfoActivity.this;
                    UserSettingsBean userSettingsBean2 = chatRoomInfoActivity2.g;
                    if (userSettingsBean2 != null) {
                        userSettingsBean2.setMuteFlag(0);
                    } else {
                        WearUtils.x.i.F(WearUtils.k0(chatRoomInfoActivity2.l), 0);
                        WearUtils.x.i.B(false, WearUtils.k0(ChatRoomInfoActivity.this.l));
                    }
                    i = 0;
                }
                String str = "jid=" + WearUtils.k0(ChatRoomInfoActivity.this.l) + "&isOpen=" + i + "&time=" + be3.I().getTime();
                HashMap map = new HashMap();
                map.put("isChecked", String.valueOf(this.a).trim());
                map.put("friendEmail", String.valueOf(ChatRoomInfoActivity.this.l).trim());
                hp1.b(str, map, true, String.valueOf(ChatRoomInfoActivity.this.l).trim());
                ChatRoomInfoActivity.this.dissDialog();
                ChatRoomInfoActivity.this.n = 0;
            }
        }

        public class b implements ip1 {
            public final /* synthetic */ boolean a;

            public b(boolean z) {
                this.a = z;
            }

            @Override // dc.ip1
            public void G() {
                ChatRoomInfoActivity.this.dissDialog();
                ChatRoomInfoActivity.this.n = 0;
                ChatRoomInfoActivity.this.sbMute.setCheckedImmediatelyNoEvent(!this.a);
            }

            @Override // dc.ip1
            public void d() {
                ChatRoomInfoActivity.this.cancleDelay();
            }
        }

        public r() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            gp1 gp1Var = new gp1(new a(z), new b(z));
            ChatRoomInfoActivity.this.n = 2;
            if (ep1.b().r(ChatRoomInfoActivity.this, gp1Var)) {
                ChatRoomInfoActivity.this.showDialog();
            }
        }
    }

    public class s implements CompoundButton.OnCheckedChangeListener {
        public s() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i;
            if (z) {
                ChatRoomInfoActivity chatRoomInfoActivity = ChatRoomInfoActivity.this;
                UserSettingsBean userSettingsBean = chatRoomInfoActivity.g;
                if (userSettingsBean != null) {
                    userSettingsBean.setSetTop(be3.I().getTime());
                } else {
                    WearUtils.x.i.E(WearUtils.k0(chatRoomInfoActivity.l), be3.I().getTime());
                }
                i = 1;
            } else {
                i = 0;
                ChatRoomInfoActivity chatRoomInfoActivity2 = ChatRoomInfoActivity.this;
                UserSettingsBean userSettingsBean2 = chatRoomInfoActivity2.g;
                if (userSettingsBean2 != null) {
                    userSettingsBean2.setSetTop(0L);
                } else {
                    WearUtils.x.i.E(WearUtils.k0(chatRoomInfoActivity2.l), 0L);
                }
            }
            String str = "jid=" + WearUtils.k0(ChatRoomInfoActivity.this.l) + "&isOpen=" + i + "&time=" + be3.I().getTime();
            HashMap map = new HashMap();
            map.put("isChecked", String.valueOf(z).trim());
            map.put("friendEmail", String.valueOf(ChatRoomInfoActivity.this.l).trim());
            hp1.c(str, map, true, String.valueOf(ChatRoomInfoActivity.this.l).trim());
        }
    }

    public class t implements kn3.d {
        public t() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ChatRoomInfoActivity.this.F4();
        }
    }

    public class u implements kv1 {
        public u() {
        }

        @Override // dc.kv1
        public void a(String str) {
            if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                ChatRoomInfoActivity.this.b.setStatus(2);
                ChatRoomInfoActivity.this.finish();
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
        }
    }

    public class v implements kv1 {
        public v() {
        }

        @Override // dc.kv1
        public void a(String str) {
            ChatRoomInfoActivity.this.progressDialog.dismiss();
            ResponseRoomQrcodeCreate responseRoomQrcodeCreate = (ResponseRoomQrcodeCreate) JSON.parseObject(str, ResponseRoomQrcodeCreate.class);
            if (responseRoomQrcodeCreate.suc()) {
                Intent intent = new Intent(ChatRoomInfoActivity.this.activity, (Class<?>) GroupQrcodeShowActivity.class);
                intent.putExtra("roomId", ChatRoomInfoActivity.this.l);
                intent.putExtra("data", responseRoomQrcodeCreate.getData());
                boolean z = false;
                ResponseRoomSettingInfo responseRoomSettingInfo = ChatRoomInfoActivity.this.i;
                if (responseRoomSettingInfo != null && responseRoomSettingInfo.getRoom().getMemberCanInvite() == 1) {
                    z = true;
                }
                intent.putExtra("isCanInvite", z);
                ChatRoomInfoActivity.this.startActivity(intent);
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            ChatRoomInfoActivity.this.progressDialog.dismiss();
        }
    }

    public ChatRoomInfoActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.o = fileE0;
        this.p = Uri.fromFile(fileE0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N4(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.m;
        if (userSetting != null) {
            userSetting.setAutoPlayPattern(Boolean.valueOf(this.sbVPattern.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P4(CompoundButton compoundButton, boolean z) {
        if (!z || zt3.f()) {
            W4(this.sbVAlarm.isChecked());
        } else {
            this.sbVAlarm.setCheckedImmediatelyNoEvent(false);
            zt3.v(this, new o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R4(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.m;
        if (userSetting != null) {
            userSetting.setAutoAccept(Boolean.valueOf(this.sbVAutoPlayControl.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T4() {
        RequestRoomExit requestRoomExit = new RequestRoomExit();
        requestRoomExit.setRoomId(this.l);
        requestRoomExit.setStatus(2);
        zb2.O().C0(requestRoomExit, WearUtils.k0(this.l), new u());
    }

    public final void E4() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new c());
    }

    public final void F4() {
        vg3.b().a(new b());
        this.rlClearChatMessage.setEnabled(false);
        this.tvClearChatMessageText.setTextColor(Color.parseColor("#9a9a9a"));
    }

    public final void G4() {
        int status = this.b.getStatus();
        String strE = ah4.e(R.string.group_chat_exit_group_content);
        if (status != 1) {
            strE = ah4.e(R.string.group_chat_delete_group_note);
        }
        is3.b bVar = new is3.b(this);
        bVar.p(strE);
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.d(new a(status));
        cs3.h(bVar).show();
    }

    public final String H4(Uri uri, Bitmap bitmap) {
        return qe3.g(this, uri, bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    public final void I4() {
        ArrayList<IGroupMember> arrayList;
        ArrayList arrayList2 = new ArrayList(this.b.getList());
        Collections.sort(arrayList2, new r12());
        ArrayList arrayList3 = new ArrayList();
        this.d.clear();
        int i2 = (this.e * this.f) - 1;
        if (arrayList2.size() > i2) {
            ?? SubList = arrayList2.subList(0, i2);
            this.llShowMore.setVisibility(0);
            arrayList3 = SubList;
        } else {
            arrayList3.addAll(arrayList2);
            this.llShowMore.setVisibility(8);
        }
        this.d.addAll(arrayList3);
        Collections.sort(this.d, new r12());
        this.d.add(this.j);
        if (TextUtils.isEmpty(this.b.getShowNickName()) && (arrayList = this.d) != null) {
            this.tvGroupName.setText(this.b.getShowNameByList(arrayList));
        } else {
            this.tvGroupName.setText(this.b.getShowNickName());
        }
        this.c.notifyDataSetChanged();
    }

    public final void J4() {
        if (!this.b.isExit()) {
            this.rlClearChatMessage.setVisibility(0);
            this.tvExitGroup.setText(ah4.e(R.string.group_chat_setting_exit));
        } else {
            if (this.b.getStatus() == 3) {
                finish();
            }
            this.tvExitGroup.setText(ah4.e(R.string.group_chat_delete_group));
            this.rlClearChatMessage.setVisibility(8);
        }
    }

    public final void K4() {
        this.abTitle.setTitle(ah4.e(R.string.people_group_chat) + "(" + this.b.getMembers().size() + ")");
        this.tvGroupNickName.setText(this.b.getRemark());
        GroupMember memberByJid = this.b.getMemberByJid(ch3.n().p());
        this.h = memberByJid;
        if (memberByJid == null) {
            this.rlManagerGroup.setVisibility(8);
            this.manager_group_line.setVisibility(8);
        } else {
            this.tvUserNickName.setText(memberByJid.getNickName());
            if (this.h.isAdmin()) {
                this.manager_group_line.setVisibility(0);
                this.rlManagerGroup.setVisibility(0);
            } else {
                this.rlManagerGroup.setVisibility(8);
                this.manager_group_line.setVisibility(8);
            }
        }
        if (this.b.isExit()) {
            this.abTitle.setTitle(ah4.e(R.string.people_group_chat));
            this.rvGroupMembers.setVisibility(8);
            this.llVibrateToy.setVisibility(8);
            this.llAutoControl.setVisibility(8);
            this.llNotificationSetting.setVisibility(8);
            this.llExitTip.setVisibility(0);
            this.rlManagerGroup.setVisibility(8);
            this.llGroupMembers.setVisibility(8);
            this.rlGroupQrcode.setVisibility(8);
            this.groupQrcodeLine.setVisibility(8);
            this.manager_group_line.setVisibility(8);
            this.llSearchChatHistory.setVisibility(8);
            this.rlReport.setVisibility(8);
        } else {
            this.rvGroupMembers.setVisibility(0);
            this.llVibrateToy.setVisibility(0);
            this.llAutoControl.setVisibility(0);
            this.llNotificationSetting.setVisibility(0);
            this.llExitTip.setVisibility(8);
            this.llGroupMembers.setVisibility(0);
            this.rlGroupQrcode.setVisibility(0);
            this.groupQrcodeLine.setVisibility(0);
            this.llSearchChatHistory.setVisibility(0);
            this.rlManagerGroup.setVisibility(0);
            this.manager_group_line.setVisibility(0);
            this.rlReport.setVisibility(0);
        }
        if (this.b.getMembers().size() == 1) {
            this.userImg.setBorderWidth(ce3.a(this, 4.0f) * 1.0f);
        } else {
            this.userImg.setBorderWidth(0.0f);
        }
        tg3.i(this.userImg, this.b);
    }

    public final void L4() {
        if (WearUtils.x1(this.m.getAutoPlayPattern())) {
            this.sbVPattern.setCheckedImmediatelyNoEvent(true);
        }
        this.sbVPattern.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.b62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.N4(compoundButton, z);
            }
        });
        if (WearUtils.x1(this.m.getAutoPlayAlarm())) {
            this.sbVAlarm.setCheckedImmediatelyNoEvent(true);
        }
        this.sbVAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.y52
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.P4(compoundButton, z);
            }
        });
        if (WearUtils.x1(this.m.getAutoAccept())) {
            this.sbVAutoPlayControl.setCheckedImmediatelyNoEvent(true);
        }
        this.sbVAutoPlayControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.a62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.R4(compoundButton, z);
            }
        });
        if (WearUtils.x1(this.m.getMessageVibration())) {
            this.sbVMessage.setCheckedImmediatelyNoEvent(true);
        }
        this.sbVMessage.setOnCheckedChangeListener(new p());
        if (WearUtils.x1(this.m.getAudioVibration())) {
            this.sbVAudio.setCheckedImmediatelyNoEvent(true);
        }
        this.sbVAudio.setOnCheckedChangeListener(new q());
        UserSettingsBean userSettingsBean = this.g;
        if (userSettingsBean != null && userSettingsBean.getMuteFlag() > 0) {
            this.sbMute.setCheckedImmediatelyNoEvent(true);
        }
        this.sbMute.setOnCheckedChangeListener(new r());
        UserSettingsBean userSettingsBean2 = this.g;
        if (userSettingsBean2 != null && userSettingsBean2.getSetTop() > 0) {
            this.sbStickTop.setCheckedImmediatelyNoEvent(true);
        }
        this.sbStickTop.setOnCheckedChangeListener(new s());
    }

    @Override // com.wear.adapter.BaseAdapter.b
    /* renamed from: U4, reason: merged with bridge method [inline-methods] */
    public void a0(IGroupMember iGroupMember, int i2, View view) {
        this.k = "";
        if (!hf3.d(this)) {
            sg3.l(ah4.e(R.string.net_connect_error_tip));
            return;
        }
        String avatar = iGroupMember.getAvatar();
        if (!WearUtils.e1(avatar) && !avatar.startsWith("http")) {
            this.k = WearUtils.e + avatar;
        }
        if (iGroupMember instanceof HeadGroupMember) {
            ResponseRoomSettingInfo responseRoomSettingInfo = this.i;
            if (responseRoomSettingInfo == null) {
                zb2.O().R(this.l);
                sg3.l(ah4.e(R.string.toast_member_cant_invite_others));
                return;
            } else {
                if (responseRoomSettingInfo.getRoom().getMemberCanInvite() != 1 && !this.b.iIsAdamin()) {
                    sg3.l(ah4.e(R.string.toast_member_cant_invite_others));
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("flag", 1);
                bundle.putString("roomId", this.l);
                pj3.p(this, CreateChatRoomActivity.class, 18, bundle);
                return;
            }
        }
        GroupMember memberByJid = this.b.getMemberByJid(ch3.n().p());
        if (memberByJid != null && (iGroupMember instanceof GroupMember)) {
            ManagerGroupMemberInfoDialog.h hVar = new ManagerGroupMemberInfoDialog.h(this.b, (GroupMember) iGroupMember, memberByJid, ch3.n().v(iGroupMember.getId()));
            is3.b bVar = new is3.b(this);
            bVar.e(hVar);
            bVar.x(gg3.e(this));
            bVar.i(80);
            ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog = (ManagerGroupMemberInfoDialog) cs3.i(bVar, ManagerGroupMemberInfoDialog.class);
            managerGroupMemberInfoDialog.show();
            managerGroupMemberInfoDialog.setReportListener(new h(managerGroupMemberInfoDialog));
            managerGroupMemberInfoDialog.setListener(new i(i2));
        }
    }

    public void V4(String str) {
        this.a.n(str);
        showDialog();
    }

    public final void W4(boolean z) {
        UserSetting userSetting = this.m;
        if (userSetting != null) {
            userSetting.setAutoPlayAlarm(Boolean.valueOf(z));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.m);
        }
    }

    public final void X4(File file) throws IOException {
        addAnalyticsEventId("setChatBackground", null);
        WearUtils.q(file, WearUtils.N(this.b));
        if (!WearUtils.N(this.b).exists()) {
            sg3.i(this, R.string.setting_black_image_not_exist);
        } else {
            sg3.i(this, R.string.partner_profile_black_setting_success);
            finish();
        }
    }

    @Override // dc.vo2
    public void Y0(boolean z, String str) {
        String userName;
        dissDialog();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, this.l);
        Iterator<GroupMember> it = this.b.getMembers().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                userName = "";
                break;
            }
            GroupMember next = it.next();
            if (next.isOwrn()) {
                userName = next.getUserName();
                break;
            }
        }
        String showNickName = this.b.getShowNickName();
        bundle.putString("group_owner", userName);
        bundle.putString("group_name", showNickName);
        if (!str.equals("pending")) {
            pj3.g(this, ReasonOptionActivity.class, bundle);
        } else {
            bundle.putInt("status", 1);
            pj3.g(this, ResultActivity.class, bundle);
        }
    }

    public final void Y4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_chat_photo);
        bo3Var.show();
        bo3Var.d(R.id.from_album, new d());
        bo3Var.d(R.id.from_camera, new e());
        bo3Var.d(R.id.cancel_from, null);
        bo3Var.a(R.id.clean_layout).setVisibility(0);
        File fileN = WearUtils.N(this.b);
        if (!fileN.exists()) {
            bo3Var.d(R.id.action_clean, new g(this));
        } else {
            bo3Var.a(R.id.clean_layout).setVisibility(0);
            bo3Var.d(R.id.action_clean, new f(fileN));
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.z(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (i2 == 119) {
            if (i3 != -1 || intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("nickname");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            RequestRoomSetting requestRoomSetting = new RequestRoomSetting();
            requestRoomSetting.setRoomId(this.l);
            requestRoomSetting.setNickName(stringExtra);
            zb2.O().C0(requestRoomSetting, WearUtils.k0(this.l), new n(stringExtra));
            return;
        }
        if (i2 == 136) {
            if (i3 != -1 || intent == null) {
                return;
            }
            String stringExtra2 = intent.getStringExtra("nickname");
            RequestRoomSetting requestRoomSetting2 = new RequestRoomSetting();
            requestRoomSetting2.setRoomId(this.l);
            requestRoomSetting2.setRoomName(stringExtra2);
            zb2.O().C0(requestRoomSetting2, WearUtils.k0(this.l), new m(stringExtra2));
            return;
        }
        if (i2 == 999) {
            if (i3 == -1) {
                boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                intent.getIntArrayExtra("grant_results");
                if (booleanExtra) {
                    Y4();
                    return;
                } else {
                    new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new j()).show();
                    return;
                }
            }
            return;
        }
        switch (i2) {
            case 16:
                if (i3 == -1) {
                    Uri data = this.p;
                    if (intent != null && intent.getData() != null) {
                        data = intent.getData();
                    }
                    tg3.e(this.o, this, data, new l());
                    return;
                }
                return;
            case 17:
                if (intent == null || intent.getData() == null) {
                    return;
                }
                Uri data2 = intent.getData();
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inSampleSize = 2;
                    options.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data2), null, options);
                    Bitmap bitmapL = WearUtils.l(this.application, bitmapDecodeStream, H4(data2, bitmapDecodeStream));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmapL.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    File fileO = WearUtils.O();
                    WearUtils.r(byteArrayInputStream, fileO);
                    if (fileO != null && (fileO == null || fileO.exists())) {
                        X4(fileO);
                        return;
                    }
                    sg3.i(this, R.string.setting_black_image_not_exist);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    sg3.i(this, R.string.setting_black_image_not_exist);
                    return;
                }
            case 18:
                if (i3 == -1) {
                    I4();
                    return;
                }
                return;
            default:
                return;
        }
        e2.printStackTrace();
    }

    @Override // com.wear.BaseActivity, dc.cs3.b
    public void onCancel() {
        this.sbMute.setCheckedImmediatelyNoEvent(!r0.isChecked());
        ep1.b().m(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_room_info);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.l = getIntent().getStringExtra("roomId");
        Group groupK = ch3.n().k(this.l);
        this.b = groupK;
        if (groupK == null) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.c = new GroupMemberAdapter(this.d, R.layout.item_group_member, this);
        this.rvGroupMembers.setLayoutManager(new k(this, this.rvGroupMembers.getContext(), this.f));
        this.rvGroupMembers.setAdapter(this.c);
        this.c.s(this);
        this.m = WearUtils.y.z(this.l);
        this.g = WearUtils.x.i.g(WearUtils.j0(this.l));
        L4();
        if (!this.b.isExit()) {
            this.progressDialog.show();
            zb2.O().R(this.l);
            if (this.b.iIsAdamin()) {
                zb2.O().Q(this.l);
            }
        }
        if (!pf3.d(this)) {
            View view = this.view_search_chat_history;
            StringBuilder sb = new StringBuilder();
            sb.append("SearchChatTip_");
            sb.append(ch3.n().r());
            view.setVisibility(eg3.d(this, sb.toString(), false) ? 8 : 0);
        }
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.ab_title);
        this.abTitle = myActionBar;
        myActionBar.setParentBackgroundColor(th4.b(this.application, R.color.lvs_ui_standard_systemBackground6));
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FinishChatPageEvent finishChatPageEvent) {
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        K4();
        I4();
        J4();
    }

    @OnClick({R.id.rl_group_qrcode, R.id.rl_manager_group, R.id.rl_clear_chat_message, R.id.rl_exit_group, R.id.rl_chat_background, R.id.rl_group_nick_name, R.id.rl_user_nick_name, R.id.rl_group_name, R.id.tv_show_more, R.id.user_img, R.id.rl_report, R.id.ll_search_chat_history})
    public void onViewClicked(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (view.getId()) {
            case R.id.ll_search_chat_history /* 2131363580 */:
                Bundle bundle = new Bundle();
                bundle.putString("roomId", this.l);
                pj3.g(this, SearchChatHistoryActivity.class, bundle);
                eg3.j(this, "SearchChatTip_" + ch3.n().r(), true);
                this.view_search_chat_history.setVisibility(8);
                HashMap map = new HashMap();
                map.put("chat_type", "2");
                ye3.e("M0040", map);
                break;
            case R.id.rl_chat_background /* 2131364247 */:
                E4();
                break;
            case R.id.rl_clear_chat_message /* 2131364257 */:
                kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.clear_chat_message) + "?", ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new t());
                kn3Var.show();
                kn3Var.p();
                kn3Var.l();
                break;
            case R.id.rl_exit_group /* 2131364267 */:
                GroupMember memberByJid = this.b.getMemberByJid(ch3.n().p());
                String strE = ah4.e(this.b.getMembers().size() == 1 ? R.string.group_chat_disband_comfirm : R.string.group_chat_admin_leave);
                if (memberByJid != null && memberByJid.isOwrn() && this.b.onlyOneAdmin() && !this.b.isExit()) {
                    is3.b bVar = new is3.b(this);
                    bVar.p(strE);
                    bVar.n(ah4.e(R.string.common_cancel));
                    bVar.o(ah4.e(R.string.common_ok));
                    bVar.d(new is3.d() { // from class: dc.z52
                        @Override // dc.is3.d
                        public final void doConfirm() {
                            this.a.T4();
                        }
                    });
                    cs3.h(bVar).show();
                    break;
                } else {
                    G4();
                    break;
                }
            case R.id.rl_group_name /* 2131364271 */:
                if (!this.b.isExit()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("nickname", this.tvGroupName.getText().toString());
                    bundle2.putInt("flag", 1);
                    pj3.p(this, EditNickNameActivity.class, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, bundle2);
                    break;
                } else {
                    sg3.l(ah4.e(R.string.group_chat_cant_edit_info));
                    break;
                }
            case R.id.rl_group_nick_name /* 2131364272 */:
                if (!this.b.isExit()) {
                    pj3.q(this, EditNickNameByFriendActivity.class, 153, "userId", this.l);
                    break;
                } else {
                    sg3.l(ah4.e(R.string.group_chat_cant_edit_info));
                    break;
                }
            case R.id.rl_group_qrcode /* 2131364273 */:
                if (!this.b.isExit()) {
                    RequestRoomQrcodeCreate requestRoomQrcodeCreate = new RequestRoomQrcodeCreate();
                    requestRoomQrcodeCreate.setRoomId(this.l);
                    requestRoomQrcodeCreate.setFromType(1);
                    this.progressDialog.show();
                    zb2.O().C0(requestRoomQrcodeCreate, WearUtils.k0(this.l), new v());
                    break;
                } else {
                    sg3.l(ah4.e(R.string.group_chat_cant_edit_info));
                    break;
                }
            case R.id.rl_manager_group /* 2131364285 */:
                ManagerGroupActivity.c.a(view.getContext(), this.l);
                break;
            case R.id.rl_report /* 2131364297 */:
                showDialog();
                this.a.o(this.l);
                break;
            case R.id.rl_user_nick_name /* 2131364318 */:
                if (!this.b.isExit()) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("nickname", this.tvUserNickName.getText().toString());
                    bundle3.putInt("flag", 2);
                    pj3.p(this, EditNickNameActivity.class, 119, bundle3);
                    break;
                } else {
                    sg3.l(ah4.e(R.string.group_chat_cant_edit_info));
                    break;
                }
            case R.id.tv_show_more /* 2131365313 */:
                if (!this.b.isExit()) {
                    pj3.q(this, AllGroupMembersActivity.class, 102, "roomId", this.l);
                    break;
                } else {
                    sg3.l(ah4.e(R.string.group_chat_cant_edit_info));
                    break;
                }
            case R.id.user_img /* 2131365468 */:
                if (!this.b.isExit()) {
                    pj3.q(this, ChangeGroupPhotoActivity.class, 85, "roomId", this.l);
                    break;
                } else {
                    sg3.l(ah4.e(R.string.group_chat_cant_edit_info));
                    break;
                }
        }
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        super.settingBarColor();
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        Window window = getWindow();
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (MyApplication.l0) {
                window.setNavigationBarColor(Color.parseColor("#1E1F29"));
                return;
            } else {
                window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
                return;
            }
        }
        if (i2 == 2) {
            window.setNavigationBarColor(Color.parseColor("#1E1F29"));
        } else {
            window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
        }
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        sg3.l(str);
        dissDialog();
    }

    @Override // dc.vo2
    public void z(boolean z, String str, String str2) {
        dissDialog();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", WearUtils.g0(str2));
        bundle.putString("user_img", this.k);
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, this.l);
        if (!str.equals("pending")) {
            pj3.g(this, ReasonOptionActivity.class, bundle);
        } else {
            bundle.putInt("status", 1);
            pj3.g(this, ResultActivity.class, bundle);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupMemberEvent groupMemberEvent) {
        I4();
        K4();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupNameChangeEvent groupNameChangeEvent) {
        if (this.l.equals(groupNameChangeEvent.roomId)) {
            this.tvGroupName.setText(this.b.getName());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupInvitationEvent groupInvitationEvent) {
        String str = this.l;
        if (str == null || !str.equals(groupInvitationEvent.roomId)) {
            return;
        }
        if (this.b.getInvitationList() != null && this.b.getInvitationList().size() != 0) {
            this.tvCount.setVisibility(0);
            this.tvCount.setText("" + this.b.getInvitationList().size());
            return;
        }
        this.tvCount.setVisibility(4);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupInvitationSettingEvent groupInvitationSettingEvent) {
        String str = this.l;
        if (str != null && str.equals(groupInvitationSettingEvent.roomId) && groupInvitationSettingEvent.suc) {
            this.i = groupInvitationSettingEvent.responseRoomSettingInfo;
            I4();
        }
        this.progressDialog.dismiss();
    }
}
