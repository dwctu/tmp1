package com.wear.main.longDistance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.FriendHaveSelectAdapter;
import com.wear.adapter.longdistance.FriendShowSelectAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntitySystem;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;
import dc.ah4;
import dc.bv1;
import dc.cg3;
import dc.ch3;
import dc.dh3;
import dc.eg3;
import dc.hu3;
import dc.kv1;
import dc.p12;
import dc.pj3;
import dc.sg3;
import dc.u12;
import dc.vd3;
import dc.ye3;
import dc.zb2;
import io.agora.rtm2.RtmConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smackx.disco.bean.request.InviteBean;
import org.jivesoftware.smackx.disco.bean.request.RequestCreateChatRoom;
import org.jivesoftware.smackx.disco.bean.request.RequestMemberInvite;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomQrcodeCreate;
import org.jivesoftware.smackx.disco.bean.response.ResponseCreateChatRoom;
import org.jivesoftware.smackx.disco.bean.response.ResponseMemberInvite;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeCreate;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class CreateChatRoomActivity extends BaseActivity implements FriendShowSelectAdapter.b, FriendHaveSelectAdapter.b, SearchButton.e, bv1 {
    public FriendHaveSelectAdapter a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public FriendShowSelectAdapter c;
    public Group e;
    public int g;
    public boolean h;

    @BindView(R.id.iv_all)
    public ImageView ivAll;

    @BindView(R.id.ll_all)
    public RelativeLayout llAll;

    @BindView(R.id.ll_top)
    public LinearLayout llTop;

    @BindView(R.id.rl_single_group_create)
    public RelativeLayout rl_single_group_create;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_select_friend)
    public RecyclerView rvSelectFriend;

    @BindView(R.id.sb_search)
    public SearchButton sbSearch;

    @BindView(R.id.tv_create)
    public TextView tvCreate;
    public ArrayList<IPeopleInfo> b = new ArrayList<>();
    public ArrayList<IPeopleInfo> d = new ArrayList<>();
    public List<IPeopleInfo> f = new ArrayList();

    public class a implements kv1 {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ ArrayList d;

        public a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.a = arrayList;
            this.b = arrayList2;
            this.c = arrayList3;
            this.d = arrayList4;
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseMemberInvite responseMemberInvite = (ResponseMemberInvite) JSON.parseObject(str, ResponseMemberInvite.class);
            if (!responseMemberInvite.suc()) {
                CreateChatRoomActivity.this.progressDialog.dismiss();
                if (responseMemberInvite.getCode() == 50105) {
                    sg3.l(ah4.e(R.string.group_chat_none_members));
                    return;
                }
                if (responseMemberInvite.getCode() == 50103) {
                    sg3.l(ah4.e(R.string.group_user_create_50groups));
                    return;
                }
                if (responseMemberInvite.getCode() == 50104) {
                    sg3.l(ah4.e(R.string.group_support_100people));
                    return;
                }
                sg3.l(WearUtils.a2() + responseMemberInvite.code);
                return;
            }
            if (CreateChatRoomActivity.this.g == 1 && !CreateChatRoomActivity.this.e.iIsAdamin()) {
                sg3.l(ah4.e(R.string.group_chat_member_invitations));
            }
            if (CreateChatRoomActivity.this.g == 1) {
                for (ResponseMemberInvite.UserBean userBean : responseMemberInvite.getUser()) {
                    User userV = ch3.n().v(WearUtils.g0(userBean.getJid()));
                    if (userV != null) {
                        if ("delete".equals(userBean.getResultType())) {
                            this.a.add(userV);
                        } else if ("black".equals(userBean.getResultType())) {
                            this.b.add(userV);
                        } else if ("oneway".equals(userBean.getResultType())) {
                            this.c.add(userV);
                        } else if ("oldversion".equals(userBean.getResultType())) {
                            this.d.add(userV);
                        }
                    }
                }
                CreateChatRoomActivity.this.y4(responseMemberInvite.getRoomId(), RtmConstants.RTM_ERR_INVALID_TOPIC_NAME, this.a);
                CreateChatRoomActivity.this.y4(responseMemberInvite.getRoomId(), 10000, this.b);
                CreateChatRoomActivity.this.y4(responseMemberInvite.getRoomId(), 10001, this.c);
                CreateChatRoomActivity.this.y4(responseMemberInvite.getRoomId(), RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION, this.d);
            }
            hu3.z(CreateChatRoomActivity.this.application).q(CreateChatRoomActivity.this.e.getId(), CreateChatRoomActivity.this);
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            CreateChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class b implements kv1 {
        public final /* synthetic */ List a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ ArrayList e;

        public b(List list, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.a = list;
            this.b = arrayList;
            this.c = arrayList2;
            this.d = arrayList3;
            this.e = arrayList4;
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseCreateChatRoom responseCreateChatRoom = (ResponseCreateChatRoom) JSON.parseObject(str, ResponseCreateChatRoom.class);
            if (responseCreateChatRoom.suc()) {
                if (this.a.isEmpty()) {
                    CreateChatRoomActivity.this.B4(responseCreateChatRoom.getRoomId());
                } else {
                    CreateChatRoomActivity.this.z4(responseCreateChatRoom, this.b, this.c, this.d, this.e);
                }
                CreateChatRoomActivity.this.rl_single_group_create.setEnabled(true);
                return;
            }
            if (responseCreateChatRoom.getCode() == 50000) {
                sg3.l("param error");
            } else if (responseCreateChatRoom.getCode() == 50101) {
                sg3.l(ah4.e(R.string.group_chat_none_members));
            } else if (responseCreateChatRoom.getCode() == 50103) {
                sg3.l(ah4.e(R.string.group_user_create_50groups));
            } else if (responseCreateChatRoom.getCode() == 50104) {
                sg3.l(ah4.e(R.string.group_support_100people));
            } else if (responseCreateChatRoom.getCode() == 0) {
                sg3.l(responseCreateChatRoom.getMsg() + "");
            } else {
                sg3.l(WearUtils.a2() + responseCreateChatRoom.code);
            }
            CreateChatRoomActivity.this.progressDialog.dismiss();
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            CreateChatRoomActivity.this.rl_single_group_create.setEnabled(true);
            CreateChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class c implements bv1 {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // dc.bv1
        public void Q(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ch3.n().u());
            CreateChatRoomActivity.this.y4(str, 110, arrayList);
            eg3.j(CreateChatRoomActivity.this, WearUtils.k0(this.a), true);
            CreateChatRoomActivity.this.I4(str);
        }

        @Override // dc.bv1
        public void r1(String str) {
            CreateChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class d implements kv1 {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // dc.kv1
        public void a(String str) {
            CreateChatRoomActivity.this.progressDialog.dismiss();
            ResponseRoomQrcodeCreate responseRoomQrcodeCreate = (ResponseRoomQrcodeCreate) JSON.parseObject(str, ResponseRoomQrcodeCreate.class);
            if (responseRoomQrcodeCreate.suc()) {
                Intent intent = new Intent(CreateChatRoomActivity.this.activity, (Class<?>) GroupQrcodeShowActivity.class);
                intent.putExtra("roomId", this.a);
                intent.putExtra("data", responseRoomQrcodeCreate.getData());
                intent.putExtra("isCanInvite", true);
                intent.putExtra("isForward", true);
                CreateChatRoomActivity.this.startActivity(intent);
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            CreateChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class e implements bv1 {
        public e() {
        }

        @Override // dc.bv1
        public void Q(String str) {
            CreateChatRoomActivity.this.progressDialog.dismiss();
            pj3.j(CreateChatRoomActivity.this, ChatRoomActivity.class, "roomId", str);
            CreateChatRoomActivity.this.finish();
        }

        @Override // dc.bv1
        public void r1(String str) {
            CreateChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F4(View view) {
        ye3.c("friend chatroom", "sponsor group sync control", getIntent().getStringExtra("roomId"));
        ye3.i("New Group", "new_group_create_click", "click", "new_group_create", "button");
        if (this.g == 0) {
            A4();
        } else {
            D4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H4(View view) {
        D4();
    }

    public final void A4() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<IPeopleInfo> it = this.b.iterator();
        while (it.hasNext()) {
            IPeopleInfo next = it.next();
            if (next instanceof User) {
                User user = (User) next;
                if (WearUtils.x.i.l(user.getUserJid())) {
                    arrayList4.add(user);
                } else if (user.isDeleteByFriend()) {
                    arrayList2.add(user);
                } else if (dh3.n(user)) {
                    InviteBean inviteBean = new InviteBean();
                    inviteBean.setJid(next.getUserJid());
                    String userName = next.getUserName();
                    if (TextUtils.isEmpty(userName)) {
                        userName = next.getShowNickName();
                    }
                    inviteBean.setNickName(userName);
                    arrayList.add(inviteBean);
                } else {
                    arrayList3.add(user);
                }
            }
        }
        RequestCreateChatRoom requestCreateChatRoom = new RequestCreateChatRoom();
        requestCreateChatRoom.setInvite(arrayList);
        requestCreateChatRoom.setNewAppVersion(1);
        this.progressDialog.show();
        zb2.O().B0(requestCreateChatRoom, new b(arrayList, arrayList5, arrayList4, arrayList2, arrayList3));
    }

    public final void B4(String str) {
        hu3.z(this.application).q(str, new c(str));
    }

    public final void C4(String str) {
        ArrayList<IPeopleInfo> arrayList = new ArrayList(this.f);
        this.d.clear();
        for (IPeopleInfo iPeopleInfo : arrayList) {
            if (!iPeopleInfo.isGroup()) {
                if (TextUtils.isEmpty(str)) {
                    this.d.add(iPeopleInfo);
                } else if (iPeopleInfo.showBykey(str)) {
                    this.d.add(iPeopleInfo);
                }
            }
        }
        this.c.A(str);
        this.c.notifyDataSetChanged();
    }

    public final void D4() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<IPeopleInfo> it = this.b.iterator();
        while (it.hasNext()) {
            IPeopleInfo next = it.next();
            int i = this.g;
            if (i == 2 || i == 3) {
                InviteBean inviteBean = new InviteBean();
                inviteBean.setJid(next.getUserJid());
                String userName = next.getUserName();
                if (TextUtils.isEmpty(userName)) {
                    userName = next.getShowNickName();
                }
                inviteBean.setNickName(userName);
                arrayList.add(inviteBean);
            } else if (next instanceof User) {
                User user = (User) next;
                if (WearUtils.x.i.l(user.getUserJid())) {
                    arrayList4.add(user);
                } else if (user.isDeleteByFriend()) {
                    arrayList2.add(user);
                } else if (dh3.n(user)) {
                    InviteBean inviteBean2 = new InviteBean();
                    inviteBean2.setJid(next.getUserJid());
                    String userName2 = next.getUserName();
                    if (TextUtils.isEmpty(userName2)) {
                        userName2 = next.getShowNickName();
                    }
                    inviteBean2.setNickName(userName2);
                    arrayList.add(inviteBean2);
                } else {
                    arrayList3.add(user);
                }
            }
        }
        if (arrayList.size() == 0) {
            sg3.l(ah4.e(R.string.group_chat_none_members));
            return;
        }
        int i2 = this.g;
        if (i2 == 1 || i2 == 2) {
            RequestMemberInvite requestMemberInvite = new RequestMemberInvite();
            requestMemberInvite.setRoomId(this.e.getId());
            if (this.g == 1) {
                requestMemberInvite.setSetAffiliation(30);
            } else {
                requestMemberInvite.setSetAffiliation(20);
            }
            requestMemberInvite.setInvite(arrayList);
            this.progressDialog.show();
            zb2.O().C0(requestMemberInvite, this.e.getUserJid(), new a(arrayList5, arrayList4, arrayList2, arrayList3));
            return;
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList6.add(((InviteBean) it2.next()).getJid());
        }
        Intent intent = new Intent();
        intent.putExtra("data", arrayList6);
        setResult(-1, intent);
        finish();
    }

    @Override // com.wear.adapter.longdistance.FriendHaveSelectAdapter.b
    public void I(IPeopleInfo iPeopleInfo) {
        K4();
        int iIndexOf = this.d.indexOf(iPeopleInfo);
        if (iIndexOf != -1) {
            this.c.notifyItemChanged(iIndexOf);
            this.h = false;
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_unselect);
        }
    }

    public final void I4(String str) {
        RequestRoomQrcodeCreate requestRoomQrcodeCreate = new RequestRoomQrcodeCreate();
        requestRoomQrcodeCreate.setRoomId(str);
        requestRoomQrcodeCreate.setFromType(2);
        zb2.O().C0(requestRoomQrcodeCreate, WearUtils.k0(str), new d(str));
    }

    public final void J4() {
        this.h = !this.h;
        Iterator<IPeopleInfo> it = this.d.iterator();
        while (it.hasNext()) {
            IPeopleInfo next = it.next();
            if ("0".equals(next.isSupportGroup())) {
                sg3.k(this.application, String.format(ah4.e(R.string.group_chat_not_support2), next.getShowNickName()));
                this.h = !this.h;
                return;
            }
        }
        if (this.h) {
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_select);
            Iterator<IPeopleInfo> it2 = this.d.iterator();
            while (it2.hasNext()) {
                IPeopleInfo next2 = it2.next();
                if (this.g == 0) {
                    this.b.add(next2);
                } else {
                    GroupMember memberByJid = this.e.getMemberByJid(next2.getUserJid());
                    if (this.g == 0 || (!this.b.contains(next2) && memberByJid != null && memberByJid.isOnline())) {
                        this.b.add(next2);
                    }
                }
            }
        } else {
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_unselect);
            this.b.clear();
        }
        this.a.notifyDataSetChanged();
        this.c.notifyDataSetChanged();
        K4();
    }

    public final void K4() {
        if (this.b.size() == 0) {
            this.llTop.setVisibility(8);
            if (this.g == 0) {
                this.abTitle.setTitle(ah4.e(R.string.group_chat_new));
            } else {
                this.abTitle.setTitle(ah4.e(R.string.group_chat_choose_members));
            }
            this.tvCreate.setSelected(false);
            this.tvCreate.setEnabled(false);
            return;
        }
        this.tvCreate.setSelected(true);
        this.tvCreate.setEnabled(true);
        this.llTop.setVisibility(0);
        if (this.g == 0) {
            this.abTitle.setTitle(ah4.e(R.string.group_chat_new) + " (" + this.b.size() + ")");
            return;
        }
        this.abTitle.setTitle(ah4.e(R.string.group_chat_choose_members) + " (" + this.b.size() + ")");
    }

    @Override // dc.bv1
    public void Q(String str) {
        Intent intent = new Intent();
        intent.putExtra("suc", true);
        setResult(-1, intent);
        finish();
    }

    @Override // com.wear.adapter.longdistance.FriendShowSelectAdapter.b
    public boolean i(IPeopleInfo iPeopleInfo, boolean z) {
        int i;
        if (z) {
            return this.b.contains(iPeopleInfo);
        }
        if (this.b.contains(iPeopleInfo)) {
            this.a.r(this.b.indexOf(iPeopleInfo));
            K4();
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_unselect);
            this.h = false;
            return false;
        }
        int size = this.b.size();
        Group group = this.e;
        if (group != null) {
            size = group.getMembers().size() + this.b.size();
        }
        if (size >= 300) {
            return false;
        }
        if ("0".equals(iPeopleInfo.isSupportGroup()) && ((i = this.g) == 0 || i == 1)) {
            sg3.k(this.application, String.format(ah4.e(R.string.group_chat_not_support2), iPeopleInfo.getShowNickName()));
            return false;
        }
        this.b.add(iPeopleInfo);
        this.a.notifyItemInserted(this.b.size() - 1);
        this.rvSelectFriend.scrollToPosition(this.a.getItemCount() - 1);
        K4();
        Iterator<IPeopleInfo> it = this.d.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            IPeopleInfo next = it.next();
            if (!this.b.contains(next) && next.isOnline()) {
                z2 = false;
            }
        }
        if (z2) {
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_select);
            this.h = true;
        }
        return true;
    }

    @OnClick({R.id.ll_all, R.id.rl_single_group_create})
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id = view.getId();
        if (id == R.id.ll_all) {
            J4();
            return;
        }
        if (id != R.id.rl_single_group_create) {
            return;
        }
        this.b.clear();
        view.setEnabled(false);
        A4();
        eg3.j(this, "createChatRoomSinglePoint", true);
        ye3.i("New Group", "solo_group_create_click", "click", "solo_group_create", "button");
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_chat_room);
        ButterKnife.bind(this);
        int intExtra = getIntent().getIntExtra("flag", 0);
        this.g = intExtra;
        if (intExtra == 0) {
            this.abTitle.setTitle(ah4.e(R.string.group_chat_new));
        } else {
            this.abTitle.setTitle(ah4.e(R.string.group_chat_choose_members));
            Group groupK = ch3.n().k(WearUtils.A0(getIntent().getStringExtra("roomId")));
            this.e = groupK;
            if (groupK == null) {
                finish();
                return;
            }
        }
        this.tvCreate.setOnClickListener(new View.OnClickListener() { // from class: dc.d62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F4(view);
            }
        });
        if (this.g != 0) {
            this.rl_single_group_create.setVisibility(8);
            this.tvCreate.setVisibility(8);
            this.abTitle.setYesAction(R.string.common_done, new MyActionBar.f() { // from class: dc.c62
                @Override // com.wear.widget.MyActionBar.f
                public final void performAction(View view) {
                    this.a.H4(view);
                }
            });
        }
        FriendHaveSelectAdapter friendHaveSelectAdapter = new FriendHaveSelectAdapter(this.b, R.layout.item_friends_hava_select);
        this.a = friendHaveSelectAdapter;
        cg3.d(this.rvSelectFriend, friendHaveSelectAdapter);
        FriendShowSelectAdapter friendShowSelectAdapter = new FriendShowSelectAdapter(this.d, R.layout.item_friends_show_select);
        this.c = friendShowSelectAdapter;
        cg3.f(this.rvFriend, friendShowSelectAdapter);
        this.c.z(this.e, this.g);
        int i = this.g;
        if (i == 2 || i == 3) {
            ArrayList arrayList = new ArrayList(this.e.getList());
            GroupMember memberByJid = this.e.getMemberByJid(ch3.n().p());
            if (memberByJid == null) {
                finish();
                return;
            }
            if (this.g == 3) {
                vd3.b(arrayList, new p12());
            }
            arrayList.remove(memberByJid);
            this.f.addAll(arrayList);
        } else {
            this.f.addAll(ch3.i);
            vd3.b(this.f, new u12());
        }
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            IPeopleInfo iPeopleInfo = this.f.get(i2);
            if (iPeopleInfo instanceof OfficialAcount) {
                this.f.remove(iPeopleInfo);
            }
        }
        int i3 = this.g;
        if (i3 == 0 || i3 == 3) {
            this.llAll.setEnabled(true);
            this.llAll.setVisibility(0);
        } else {
            this.llAll.setVisibility(8);
        }
        this.tvCreate.setText(ah4.e(R.string.common_create));
        C4("");
        K4();
        this.c.B(this);
        this.a.z(this);
        this.sbSearch.setListener(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.sbSearch.b();
    }

    @Override // com.wear.widget.SearchButton.e
    public void p3(String str) {
        C4(str);
    }

    @Override // dc.bv1
    public void r1(String str) {
        Intent intent = new Intent();
        intent.putExtra("suc", false);
        setResult(-1, intent);
        finish();
    }

    public final void y4(String str, int i, ArrayList<IPeopleInfo> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        EntitySystem entitySystem = new EntitySystem();
        EntitySystem.C10001Json c10001Json = new EntitySystem.C10001Json();
        c10001Json.setRoomId(str);
        c10001Json.setAfiiliatation(10);
        c10001Json.setOperationType(i);
        c10001Json.setByWho(ch3.n().p());
        c10001Json.setByWhoNickName(ch3.n().u().getUserName());
        ArrayList arrayList2 = new ArrayList();
        Iterator<IPeopleInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IPeopleInfo next = it.next();
            EntitySystem.C10001Json.WhoBean whoBean = new EntitySystem.C10001Json.WhoBean();
            whoBean.setWho(next.getUserJid());
            whoBean.setWhoNickName(next.getUserName());
            arrayList2.add(whoBean);
        }
        c10001Json.setWhos(arrayList2);
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C10001.toString(), JSON.toJSONString(c10001Json));
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.k0(str));
        communMessage.setTo(WearUtils.y.p());
        communMessage.sendEntity(entitySystem);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(ch3.n().p());
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        zb2.O().i0(communMessage);
    }

    public final void z4(ResponseCreateChatRoom responseCreateChatRoom, ArrayList<IPeopleInfo> arrayList, ArrayList<IPeopleInfo> arrayList2, ArrayList<IPeopleInfo> arrayList3, ArrayList<IPeopleInfo> arrayList4) {
        ArrayList<IPeopleInfo> arrayList5 = new ArrayList<>();
        arrayList5.add(ch3.n().u());
        y4(responseCreateChatRoom.getRoomId(), 110, arrayList5);
        for (ResponseCreateChatRoom.UserBean userBean : responseCreateChatRoom.getUser()) {
            User userV = ch3.n().v(WearUtils.g0(userBean.getJid()));
            if (userV != null) {
                if ("delete".equals(userBean.getResultType())) {
                    arrayList.add(userV);
                } else if ("black".equals(userBean.getResultType())) {
                    arrayList2.add(userV);
                } else if ("oneway".equals(userBean.getResultType())) {
                    arrayList3.add(userV);
                } else if ("oldversion".equals(userBean.getResultType())) {
                    arrayList4.add(userV);
                }
            }
        }
        y4(responseCreateChatRoom.getRoomId(), RtmConstants.RTM_ERR_INVALID_TOPIC_NAME, arrayList);
        y4(responseCreateChatRoom.getRoomId(), 10000, arrayList2);
        y4(responseCreateChatRoom.getRoomId(), 10001, arrayList3);
        y4(responseCreateChatRoom.getRoomId(), RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION, arrayList4);
        hu3.z(this.application).q(responseCreateChatRoom.getRoomId(), new e());
    }
}
