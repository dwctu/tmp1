package com.wear.main.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.GroupMemberAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.event.GroupInvitationSettingEvent;
import com.wear.bean.handlerbean.IGroupMember;
import com.wear.bean.handlerbean.item.HeadGroupMember;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;
import com.wear.widget.dialog.ManagerGroupMemberInfoDialog;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.gg3;
import dc.is3;
import dc.kv1;
import dc.pj3;
import dc.r12;
import dc.vd3;
import dc.zb2;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.disco.bean.request.InviteBean;
import org.jivesoftware.smackx.disco.bean.request.RequestMemberInvite;
import org.jivesoftware.smackx.disco.bean.request.RequestMembersRemove;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponseCreateChatRoom;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomSettingInfo;

/* loaded from: classes3.dex */
public class AllGroupMembersActivity extends BaseActivity implements BaseAdapter.b<IGroupMember>, SearchButton.e {

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public Group b;
    public GroupMemberAdapter c;
    public ResponseRoomSettingInfo f;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.sb_search)
    public SearchButton sbSearch;
    public String a = "liaodewei_group";
    public ArrayList<IGroupMember> d = new ArrayList<>();
    public int e = 5;
    public List<GroupMember> g = new ArrayList();
    public HeadGroupMember h = new HeadGroupMember();

    public class a implements ManagerGroupMemberInfoDialog.i {
        public final /* synthetic */ int a;

        /* renamed from: com.wear.main.longDistance.AllGroupMembersActivity$a$a, reason: collision with other inner class name */
        public class C0103a implements kv1 {
            public final /* synthetic */ IGroupMember a;

            /* renamed from: com.wear.main.longDistance.AllGroupMembersActivity$a$a$a, reason: collision with other inner class name */
            public class RunnableC0104a implements Runnable {
                public RunnableC0104a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0103a.this.a.setPermission(30);
                    a aVar = a.this;
                    AllGroupMembersActivity.this.c.notifyItemChanged(aVar.a);
                }
            }

            public C0103a(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    AllGroupMembersActivity.this.runOnMainThread(new RunnableC0104a());
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class b implements kv1 {
            public final /* synthetic */ IGroupMember a;

            /* renamed from: com.wear.main.longDistance.AllGroupMembersActivity$a$b$a, reason: collision with other inner class name */
            public class RunnableC0105a implements Runnable {
                public RunnableC0105a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.a.setPermission(20);
                    a aVar = a.this;
                    AllGroupMembersActivity.this.c.notifyItemChanged(aVar.a);
                }
            }

            public b(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((ResponseCreateChatRoom) JSON.parseObject(str, ResponseCreateChatRoom.class)).suc()) {
                    AllGroupMembersActivity.this.runOnMainThread(new RunnableC0105a());
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class c implements kv1 {
            public final /* synthetic */ IGroupMember a;

            /* renamed from: com.wear.main.longDistance.AllGroupMembersActivity$a$c$a, reason: collision with other inner class name */
            public class RunnableC0106a implements Runnable {
                public RunnableC0106a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    AllGroupMembersActivity.this.b.removeMemberByJid(WearUtils.i0(cVar.a.getId()));
                    a aVar = a.this;
                    AllGroupMembersActivity.this.c.r(aVar.a);
                }
            }

            public c(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    AllGroupMembersActivity.this.runOnMainThread(new RunnableC0106a());
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public a(int i) {
            this.a = i;
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void a(IGroupMember iGroupMember) {
            RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
            requestMembersRemove.setRoomId(AllGroupMembersActivity.this.a);
            requestMembersRemove.setType(1);
            requestMembersRemove.setJid(WearUtils.i0(iGroupMember.getId()));
            zb2.O().C0(requestMembersRemove, WearUtils.k0(AllGroupMembersActivity.this.a), new c(iGroupMember));
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void b(IGroupMember iGroupMember) {
            RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
            requestMembersRemove.setRoomId(AllGroupMembersActivity.this.a);
            requestMembersRemove.setType(2);
            requestMembersRemove.setJid(WearUtils.i0(iGroupMember.getId()));
            zb2.O().C0(requestMembersRemove, WearUtils.k0(AllGroupMembersActivity.this.a), new C0103a(iGroupMember));
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
            requestMemberInvite.setRoomId(AllGroupMembersActivity.this.a);
            requestMemberInvite.setSetAffiliation(20);
            zb2.O().C0(requestMemberInvite, WearUtils.k0(AllGroupMembersActivity.this.a), new b(iGroupMember));
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 18 && i2 == -1) {
            u4();
            t4(this.sbSearch.getKey());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_all_group_members);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.a = getIntent().getStringExtra("roomId");
        Group groupK = ch3.n().k(this.a);
        this.b = groupK;
        if (groupK == null) {
            finish();
        }
        GroupMemberAdapter groupMemberAdapter = new GroupMemberAdapter(this.d, R.layout.item_group_member, this);
        this.c = groupMemberAdapter;
        cg3.a(this.rvFriend, groupMemberAdapter, this.e);
        u4();
        t4("");
        this.c.s(this);
        zb2.O().R(this.a);
        this.sbSearch.setListener(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupInvitationSettingEvent groupInvitationSettingEvent) {
        String str = this.a;
        if (str != null && str.equals(groupInvitationSettingEvent.roomId) && groupInvitationSettingEvent.suc) {
            this.f = groupInvitationSettingEvent.responseRoomSettingInfo;
            this.d.remove(this.h);
            if (this.f.getRoom().getMemberCanInvite() == 1 || this.b.iIsAdamin()) {
                this.d.add(this.h);
            }
            this.c.notifyDataSetChanged();
        }
        this.progressDialog.dismiss();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.sbSearch.b();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b == null) {
            finish();
            return;
        }
        this.abTitle.setTitle(this.b.getShowNickName() + "(" + this.b.getMembers().size() + ")");
        u4();
    }

    @Override // com.wear.widget.SearchButton.e
    public void p3(String str) {
        t4(str);
    }

    public final void t4(String str) {
        ArrayList<GroupMember> arrayList = new ArrayList(this.g);
        vd3.b(arrayList, new r12());
        this.d.clear();
        for (GroupMember groupMember : arrayList) {
            if (TextUtils.isEmpty(str)) {
                this.d.add(groupMember);
            } else if (groupMember.showBykey(str)) {
                this.d.add(groupMember);
            }
        }
        if (this.f != null) {
            this.d.remove(this.h);
            if (this.f.getRoom().getMemberCanInvite() == 1 || this.b.iIsAdamin()) {
                this.d.add(this.h);
            }
        }
        this.c.notifyDataSetChanged();
    }

    public final void u4() {
        if (this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.b.getList());
        this.g.clear();
        this.g.addAll(arrayList);
    }

    @Override // com.wear.adapter.BaseAdapter.b
    /* renamed from: v4, reason: merged with bridge method [inline-methods] */
    public void a0(IGroupMember iGroupMember, int i, View view) {
        if (iGroupMember instanceof HeadGroupMember) {
            ResponseRoomSettingInfo responseRoomSettingInfo = this.f;
            if (responseRoomSettingInfo == null) {
                zb2.O().R(this.a);
                return;
            }
            if (responseRoomSettingInfo.getRoom().getMemberCanInvite() == 1 || this.b.iIsAdamin()) {
                Bundle bundle = new Bundle();
                bundle.putInt("flag", 1);
                bundle.putString("roomId", this.a);
                pj3.p(this, CreateChatRoomActivity.class, 18, bundle);
                return;
            }
            return;
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
            managerGroupMemberInfoDialog.setListener(new a(i));
        }
    }
}
