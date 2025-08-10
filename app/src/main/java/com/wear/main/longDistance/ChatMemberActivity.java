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
import com.wear.adapter.longdistance.ChatMemberAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.socketio.msg.response.ReceiveGroupMemberStateResponse;
import com.wear.bean.socketio.msg.reuqest.GetGroupMemberStateRequest;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.mf2;
import dc.vb2;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ChatMemberActivity extends BaseActivity {
    public ChatMemberAdapter a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public String b;
    public Group c;

    @BindView(R.id.contact_list)
    public RecyclerView contactList;
    public ArrayList<GroupMember> d = new ArrayList<>();

    public class a implements BaseAdapter.b<GroupMember> {
        public a() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(GroupMember groupMember, int i, View view) {
            Intent intent = new Intent();
            intent.putExtra("groupMember", groupMember);
            ChatMemberActivity.this.setResult(-1, intent);
            ChatMemberActivity.this.finish();
        }
    }

    public class b implements mf2 {
        public b() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            for (ReceiveGroupMemberStateResponse.PlayerJidListBean playerJidListBean : ((ReceiveGroupMemberStateResponse) JSON.parseObject(str, ReceiveGroupMemberStateResponse.class)).getPlayerJidList()) {
                GroupMember memberByJid = ChatMemberActivity.this.c.getMemberByJid(playerJidListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setOnLine(playerJidListBean.getOnLine() == 1);
                    SyncLinkToy syncLinkToy = !TextUtils.isEmpty(playerJidListBean.getToyJson()) ? (SyncLinkToy) JSON.parseObject(CommunMessage.decrypt(playerJidListBean.getToyJson()), SyncLinkToy.class) : null;
                    if (syncLinkToy == null || syncLinkToy.getToys() == null) {
                        memberByJid.setToys(null);
                    } else {
                        memberByJid.setToys(syncLinkToy.getToys());
                    }
                    memberByJid.setOpenfireStatus(playerJidListBean.getOpenfireStatus());
                }
                ChatMemberActivity.this.a.notifyDataSetChanged();
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_new);
        ButterKnife.bind(this);
        this.b = getIntent().getStringExtra("roomId");
        this.c = ch3.n().k(this.b);
        this.abTitle.setTitle(ah4.e(R.string.group_chat_choose_members));
        Group group = this.c;
        if (group == null || group.isExit()) {
            finish();
            return;
        }
        this.d.addAll(this.c.getList());
        this.d.remove(this.c.getMemberByJid(ch3.n().p()));
        ChatMemberAdapter chatMemberAdapter = new ChatMemberAdapter(this.d, R.layout.item_chat_group_menber);
        this.a = chatMemberAdapter;
        cg3.f(this.contactList, chatMemberAdapter);
        this.a.s(new a());
        u4();
    }

    public final void u4() {
        GetGroupMemberStateRequest getGroupMemberStateRequest = new GetGroupMemberStateRequest();
        ArrayList arrayList = new ArrayList();
        Iterator<GroupMember> it = this.c.getList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getJid());
        }
        getGroupMemberStateRequest.setPlayerJidList(arrayList);
        getGroupMemberStateRequest.setAckId(WearUtils.E());
        vb2.b().a(getGroupMemberStateRequest, new b());
    }
}
