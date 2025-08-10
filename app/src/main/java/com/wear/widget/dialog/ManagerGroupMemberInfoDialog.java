package com.wear.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.longdistance.GroupToysBatteryAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.handlerbean.IGroupMember;
import com.wear.bean.socketio.msg.response.ReceiveGroupMemberStateResponse;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import com.wear.widget.AutoLineFeedLayoutManager;
import dc.ah4;
import dc.ch3;
import dc.cs3;
import dc.df3;
import dc.hu3;
import dc.is3;
import dc.mf2;
import dc.mu3;
import dc.n82;
import dc.pj3;
import dc.sg3;
import dc.vg3;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes4.dex */
public class ManagerGroupMemberInfoDialog extends is3<h> {
    public i f;
    public j g;

    @BindView(R.id.iv_role)
    public ImageView ivRole;

    @BindView(R.id.riv_user_img)
    public RoundedImageView rivUserImg;

    @BindView(R.id.toy_recyclerview)
    public RecyclerView toyRecyclerView;

    @BindView(R.id.tv_add_friend)
    public TextView tvAddFriend;

    @BindView(R.id.tv_block)
    public TextView tvBlock;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_dismiss_admin)
    public TextView tvDismissAdmin;

    @BindView(R.id.tv_make_admin)
    public TextView tvMakeAdmin;

    @BindView(R.id.tv_name)
    public TextView tvName;

    @BindView(R.id.tv_remove)
    public TextView tvRemove;

    @BindView(R.id.tv_report)
    public TextView tvReport;

    @BindView(R.id.tv_send_message)
    public TextView tvSendMessage;

    public class a implements mf2 {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.mf2
        public void Q(String str) {
            ReceiveGroupMemberStateResponse receiveGroupMemberStateResponse = (ReceiveGroupMemberStateResponse) JSON.parseObject(str, ReceiveGroupMemberStateResponse.class);
            if (ManagerGroupMemberInfoDialog.this.isShowing()) {
                for (ReceiveGroupMemberStateResponse.PlayerJidListBean playerJidListBean : receiveGroupMemberStateResponse.getPlayerJidList()) {
                    D d = ManagerGroupMemberInfoDialog.this.c;
                    if (((h) d).b != null) {
                        ((h) d).b.setOnLine(playerJidListBean.getOnLine() == 1);
                        SyncLinkToy syncLinkToy = !TextUtils.isEmpty(playerJidListBean.getToyJson()) ? (SyncLinkToy) JSON.parseObject(CommunMessage.decrypt(playerJidListBean.getToyJson()), SyncLinkToy.class) : null;
                        if (syncLinkToy == null || syncLinkToy.getToys() == null) {
                            ((h) ManagerGroupMemberInfoDialog.this.c).b.setToys(null);
                        } else {
                            ((h) ManagerGroupMemberInfoDialog.this.c).b.setToys(syncLinkToy.getToys());
                        }
                        ((h) ManagerGroupMemberInfoDialog.this.c).b.setOpenfireStatus(playerJidListBean.getOpenfireStatus());
                        if (((h) ManagerGroupMemberInfoDialog.this.c).b.getOpenfireStatus() != 3) {
                            ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog = ManagerGroupMemberInfoDialog.this;
                            managerGroupMemberInfoDialog.r(((h) managerGroupMemberInfoDialog.c).b.getToys());
                        }
                    }
                }
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class b implements is3.d {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.is3.d
        public void doConfirm() {
            ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog = ManagerGroupMemberInfoDialog.this;
            managerGroupMemberInfoDialog.s(((h) managerGroupMemberInfoDialog.c).b);
        }
    }

    public class c implements is3.d {
        public c(ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ User a;

        public d(User user) {
            this.a = user;
        }

        @Override // java.lang.Runnable
        public void run() {
            hu3.z(ManagerGroupMemberInfoDialog.this.b).J(this.a);
        }
    }

    public class e implements is3.d {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.is3.d
        public void doConfirm() {
            WearUtils.x.i.b(((h) ManagerGroupMemberInfoDialog.this.c).d.getUserJid(), !((h) ManagerGroupMemberInfoDialog.this.c).d.isShowInFriendsList() ? 1 : 0, null);
        }
    }

    public class f extends HashMap<String, String> {
        public f() {
            String str;
            if (WearUtils.y.y() == null) {
                str = "0";
            } else {
                str = "" + WearUtils.y.y().size();
            }
            put("count", str);
        }
    }

    public class g implements n82.d {
        public final /* synthetic */ GroupMember a;

        public class a implements Runnable {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a) {
                    UserSetting userSettingZ = WearUtils.y.z(g.this.a.getId());
                    if (userSettingZ.isFriendsRequestClick()) {
                        mu3.c++;
                        userSettingZ.setFriendsRequestClick(false);
                        DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                        df3.e().a(g.this.a.getId());
                    }
                }
            }
        }

        public g(GroupMember groupMember) {
            this.a = groupMember;
        }

        @Override // dc.n82.d
        public void a(boolean z) {
            ManagerGroupMemberInfoDialog.this.o(new a(z));
        }
    }

    public static class h {
        public Group a;
        public GroupMember b;
        public IGroupMember c;
        public User d;

        public h(Group group, GroupMember groupMember, IGroupMember iGroupMember, User user) {
            this.a = group;
            this.b = groupMember;
            this.c = iGroupMember;
            this.d = user;
        }
    }

    public interface i {
        void a(IGroupMember iGroupMember);

        void b(IGroupMember iGroupMember);

        void c(IGroupMember iGroupMember);
    }

    public interface j {
        void a(IGroupMember iGroupMember);
    }

    public ManagerGroupMemberInfoDialog(Context context) {
        super(context, R.style.MaterialDialogSheet);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_manager_group_member_info;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c5  */
    @Override // dc.is3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnClick({R.id.tv_send_message, R.id.tv_add_friend, R.id.tv_dismiss_admin, R.id.tv_make_admin, R.id.tv_block, R.id.tv_remove, R.id.tv_cancel, R.id.tv_report})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add_friend /* 2131364906 */:
                if (!WearUtils.x.i.p(((h) this.c).b.getUserJid())) {
                    D d2 = this.c;
                    if (((h) d2).d == null) {
                        User user = new User(((h) d2).b.getId());
                        String strL = hu3.z(WearUtils.x).L(user.getId());
                        if (!WearUtils.e1(strL) && strL.equals("2")) {
                            cs3.k(this.b, String.format(ah4.e(R.string.group_chat_unable_add_from_group), ((h) this.c).b.getShowNickName()), new c(this)).show();
                            dismiss();
                            break;
                        } else if (hu3.k(((h) this.c).b.getId())) {
                            user.addFriendType(2);
                            ch3.n().b(user);
                            vg3.b().a(new d(user));
                            sg3.i(this.b, R.string.user_add_success);
                            HashMap map = new HashMap();
                            map.put("add_channel", 3);
                            map.put("who_be_invited", user.getUserJid());
                            ye3.d("F0011", WearUtils.A.toJson(map));
                        }
                    } else if (!((h) d2).d.isFriend()) {
                        D d3 = this.c;
                        if (((h) d3).d != null && ((h) d3).d.addSendToMe()) {
                            sg3.k(this.b, String.format(ah4.e(R.string.add_friend_user_requested), ((h) this.c).d.getUserName()));
                            dismiss();
                            break;
                        } else {
                            String strL2 = hu3.z(WearUtils.x).L(((h) this.c).d.getId());
                            if (!WearUtils.e1(strL2) && strL2.equals("2")) {
                                cs3.k(this.b, String.format(ah4.e(R.string.group_chat_unable_add_from_group), ((h) this.c).d.getUserName()), null).show();
                                dismiss();
                                break;
                            } else if (hu3.k(((h) this.c).d.getId())) {
                                ((h) this.c).d.addFriendType(2);
                                sg3.i(getContext(), R.string.user_add_success);
                                HashMap map2 = new HashMap();
                                map2.put("add_channel", 3);
                                map2.put("who_be_invited", ((h) this.c).d.getUserJid());
                                ye3.d("F0011", WearUtils.A.toJson(map2));
                            }
                        }
                    } else {
                        sg3.i(this.b, R.string.add_friend_user_exist);
                        dismiss();
                        break;
                    }
                    dismiss();
                    break;
                } else {
                    dismiss();
                    cs3.a(this.b, String.format(ah4.e(R.string.add_blocke_friends_fail_1), ((h) this.c).b.getNickName()), new b()).show();
                    break;
                }
                break;
            case R.id.tv_block /* 2131364945 */:
                if (!ChatSyncControl.N0().D(((h) this.c).d.getId())) {
                    if (!ChatLiveControl.q0().D(((h) this.c).d.getId())) {
                        if (!ChatVideoControl.a1().D(((h) this.c).d.getId())) {
                            if (!WearUtils.x.i.k(((h) this.c).d.getUserJid()) && !WearUtils.x.i.p(((h) this.c).d.getUserJid())) {
                                cs3.a(this.b, String.format(ah4.e(R.string.common_block_note), ((h) this.c).b.getNickName(), ((h) this.c).b.getNickName()), new e()).show();
                                dismiss();
                                break;
                            } else {
                                sg3.l(String.format(ah4.e(R.string.common_block), ((h) this.c).b.getNickName()));
                                dismiss();
                                break;
                            }
                        } else {
                            sg3.l(ah4.e(ChatVideoControl.a1().k1() ? R.string.block_fail_tip_video_call : R.string.block_fail_tip_voice_call));
                            dismiss();
                            break;
                        }
                    } else {
                        sg3.l(ah4.e(R.string.block_fail_tip_live_control));
                        dismiss();
                        break;
                    }
                } else {
                    sg3.l(ah4.e(R.string.block_fail_tip_sync_control));
                    dismiss();
                    break;
                }
                break;
            case R.id.tv_cancel /* 2131364956 */:
                dismiss();
                break;
            case R.id.tv_dismiss_admin /* 2131365057 */:
                if (!((h) this.c).b.isOwrn()) {
                    i iVar = this.f;
                    if (iVar != null) {
                        iVar.b(((h) this.c).b);
                    }
                    dismiss();
                    break;
                } else {
                    sg3.l(String.format(ah4.e(R.string.group_chat_dismiss_note), ((h) this.c).b.getNickName()));
                    break;
                }
            case R.id.tv_make_admin /* 2131365171 */:
                i iVar2 = this.f;
                if (iVar2 != null) {
                    iVar2.c(((h) this.c).b);
                }
                dismiss();
                break;
            case R.id.tv_remove /* 2131365274 */:
                if (!((h) this.c).b.isOwrn()) {
                    i iVar3 = this.f;
                    if (iVar3 != null) {
                        iVar3.a(((h) this.c).b);
                    }
                    dismiss();
                    break;
                } else {
                    sg3.l(String.format(ah4.e(R.string.group_chat_remove_note), ((h) this.c).b.getNickName()));
                    break;
                }
            case R.id.tv_report /* 2131365279 */:
                j jVar = this.g;
                if (jVar != null) {
                    jVar.a(((h) this.c).b);
                    break;
                }
                break;
            case R.id.tv_send_message /* 2131365299 */:
                dismiss();
                if (ch3.n().v(((h) this.c).d.getId()) != null) {
                    EventBus.getDefault().post(new FinishChatPageEvent(1));
                    pj3.j(getContext(), ChatActivity.class, "userId", ((h) this.c).d.getId());
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ArrayList<Toy> arrayList) {
        if (((h) this.c).a.isExit()) {
            return;
        }
        if (arrayList == null || arrayList.size() == 0) {
            this.toyRecyclerView.setVisibility(8);
            return;
        }
        this.toyRecyclerView.setVisibility(0);
        GroupToysBatteryAdapter groupToysBatteryAdapter = new GroupToysBatteryAdapter(arrayList, R.layout.item_group_toy_battery);
        AutoLineFeedLayoutManager autoLineFeedLayoutManager = new AutoLineFeedLayoutManager();
        autoLineFeedLayoutManager.setAutoMeasureEnabled(true);
        this.toyRecyclerView.setLayoutManager(autoLineFeedLayoutManager);
        this.toyRecyclerView.setAdapter(groupToysBatteryAdapter);
    }

    public final void s(GroupMember groupMember) {
        WearUtils.x.q("longDistance_unblock_friend", new f());
        WearUtils.x.i.y(groupMember.getJid(), new g(groupMember));
    }

    public void setListener(i iVar) {
        this.f = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setReportListener(j jVar) {
        this.g = jVar;
        if (jVar == null || ((h) this.c).c.getId().equals(((h) this.c).b.getId())) {
            return;
        }
        this.tvReport.setVisibility(0);
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        setCanceledOnTouchOutside(true);
    }
}
