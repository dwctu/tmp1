package com.wear.main.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.DsFriendHaveSelectAdapter;
import com.wear.adapter.longdistance.GroupMemmberShowSelectAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.msg.response.AckCreateMultiToOneInfoResponse;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.is3;
import dc.nv1;
import dc.ov1;
import dc.q12;
import dc.th4;
import dc.ue3;
import dc.vd3;
import dc.ye3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupDsControlSelectDomsPeopleActivity extends BaseActivity implements GroupMemmberShowSelectAdapter.b, DsFriendHaveSelectAdapter.b {
    public DsFriendHaveSelectAdapter a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public GroupMemmberShowSelectAdapter c;
    public Group e;

    @BindView(R.id.et_search)
    public EditText etSearch;
    public String g;
    public boolean h;
    public boolean i;

    @BindView(R.id.iv_all)
    public ImageView ivAll;

    @BindView(R.id.ll_all)
    public LinearLayout llAll;

    @BindView(R.id.ll_root)
    public LinearLayout llRoot;

    @BindView(R.id.ll_tip)
    public LinearLayout llTip;

    @BindView(R.id.ll_top)
    public LinearLayout llTop;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_select_friend)
    public RecyclerView rvSelectFriend;

    @BindView(R.id.tv_Cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_tip)
    public TextView tvTip;
    public ArrayList<IPeopleInfo> b = new ArrayList<>();
    public ArrayList<IPeopleInfo> d = new ArrayList<>();
    public List<IPeopleInfo> f = new ArrayList();

    public class a implements d {

        /* renamed from: com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0118a implements Runnable {
            public RunnableC0118a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GroupDsControlSelectDomsPeopleActivity.this.showDialog();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GroupDsControlSelectDomsPeopleActivity.this.dissDialog();
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ AckCreateMultiToOneInfoResponse a;

            /* renamed from: com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity$a$c$a, reason: collision with other inner class name */
            public class C0119a implements is3.d {
                public C0119a() {
                }

                @Override // dc.is3.d
                public void doConfirm() {
                    Intent intent = new Intent();
                    intent.putExtra("status", 1);
                    intent.putExtra("data", c.this.a);
                    GroupDsControlSelectDomsPeopleActivity.this.setResult(-1, intent);
                    GroupDsControlSelectDomsPeopleActivity.this.finish();
                }
            }

            public class b implements is3.d {
                public b() {
                }

                @Override // dc.is3.d
                public void doConfirm() {
                    Intent intent = new Intent();
                    intent.putExtra("status", 2);
                    intent.putExtra("data", c.this.a);
                    GroupDsControlSelectDomsPeopleActivity.this.setResult(-1, intent);
                    GroupDsControlSelectDomsPeopleActivity.this.finish();
                }
            }

            public c(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse) {
                this.a = ackCreateMultiToOneInfoResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                GroupDsControlSelectDomsPeopleActivity.this.dissDialog();
                switch (this.a.getStatus()) {
                    case 3:
                    case 8:
                        is3.b bVar = new is3.b(GroupDsControlSelectDomsPeopleActivity.this);
                        bVar.p(ah4.e(R.string.group_ds_control_is_on));
                        bVar.o(ah4.e(R.string.common_join));
                        bVar.d(new C0119a());
                        cs3.h(bVar).show();
                        break;
                    case 4:
                        GroupMember memberByJid = GroupDsControlSelectDomsPeopleActivity.this.e.getMemberByJid(this.a.getTargeterJid());
                        if (memberByJid != null) {
                            is3.b bVar2 = new is3.b(GroupDsControlSelectDomsPeopleActivity.this);
                            bVar2.q(GroupDsControlSelectDomsPeopleActivity.this.e.getShowNickName());
                            bVar2.s(true);
                            bVar2.p(String.format(ah4.e(R.string.ds_sub_busy_notification), memberByJid.getNickName()));
                            bVar2.b(false);
                            cs3.h(bVar2).show();
                            break;
                        }
                        break;
                    case 5:
                        is3.b bVar3 = new is3.b(GroupDsControlSelectDomsPeopleActivity.this);
                        bVar3.q(GroupDsControlSelectDomsPeopleActivity.this.e.getShowNickName());
                        bVar3.s(true);
                        bVar3.p(ah4.e(R.string.ds_doms_all_busy_notification));
                        bVar3.b(false);
                        cs3.h(bVar3).show();
                        break;
                    case 6:
                        is3.b bVar4 = new is3.b(GroupDsControlSelectDomsPeopleActivity.this);
                        bVar4.p(ah4.e(R.string.group_sync_control_is_on));
                        bVar4.o(ah4.e(R.string.common_join));
                        bVar4.d(new b());
                        cs3.h(bVar4).show();
                        break;
                    case 7:
                        GroupMember memberByJid2 = GroupDsControlSelectDomsPeopleActivity.this.e.getMemberByJid(this.a.getTargeterJid());
                        if (memberByJid2 != null) {
                            is3.b bVar5 = new is3.b(GroupDsControlSelectDomsPeopleActivity.this);
                            bVar5.q(GroupDsControlSelectDomsPeopleActivity.this.e.getShowNickName());
                            bVar5.s(true);
                            bVar5.p(String.format(ah4.e(R.string.group_ds_control_is_on_1), memberByJid2.getNickName()));
                            bVar5.b(false);
                            cs3.h(bVar5).show();
                            break;
                        }
                        break;
                }
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ AckCreateMultiToOneInfoResponse a;

            public d(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse) {
                this.a = ackCreateMultiToOneInfoResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                GroupDsControlSelectDomsPeopleActivity.this.dissDialog();
                ChatDSControl.r1().p = true;
                Intent intent = new Intent();
                intent.putExtra("data", this.a);
                GroupDsControlSelectDomsPeopleActivity.this.setResult(-1, intent);
                GroupDsControlSelectDomsPeopleActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity.d
        public void a(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse) {
            GroupDsControlSelectDomsPeopleActivity.this.runOnMainThread(new c(ackCreateMultiToOneInfoResponse));
        }

        @Override // com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity.d
        public void b() {
            GroupDsControlSelectDomsPeopleActivity.this.runOnMainThread(new b());
        }

        @Override // com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity.d
        public void c(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse) {
            GroupDsControlSelectDomsPeopleActivity.this.runOnMainThread(new d(ackCreateMultiToOneInfoResponse));
        }

        @Override // com.wear.main.longDistance.GroupDsControlSelectDomsPeopleActivity.d
        public void d() {
            GroupDsControlSelectDomsPeopleActivity.this.runOnMainThread(new RunnableC0118a());
        }
    }

    public class b extends nv1 {
        public b() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            GroupDsControlSelectDomsPeopleActivity.this.t4(editable.toString());
        }
    }

    public class c implements ov1.b {
        public c() {
        }

        @Override // dc.ov1.b
        public void a(int i) {
            GroupDsControlSelectDomsPeopleActivity.this.tvCancel.setVisibility(8);
        }

        @Override // dc.ov1.b
        public void b(int i) {
            GroupDsControlSelectDomsPeopleActivity.this.tvCancel.setVisibility(0);
        }
    }

    public interface d {
        void a(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse);

        void b();

        void c(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse);

        void d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(String str, View view) {
        String strP = ch3.n().p();
        if (this.b.size() == 0 && strP.equals(this.g)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.g);
        if (!strP.equals(this.g)) {
            arrayList.add(ch3.n().p());
        }
        for (int i = 0; i < this.b.size(); i++) {
            arrayList.add(this.b.get(i).getUserJid());
        }
        ye3.c(null, "sponsor group D&S control", this.e.getId());
        B4(str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(View view) {
        this.etSearch.setText("");
        t4("");
        ue3.a(this.etSearch, this.activity);
    }

    public final void B4(String str, ArrayList<String> arrayList) {
        ChatDSControl.r1().L2(this, str, arrayList, new a());
    }

    public final void C4() {
        this.etSearch.addTextChangedListener(new b());
        this.tvCancel.setOnClickListener(new View.OnClickListener() { // from class: dc.b72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A4(view);
            }
        });
        new ov1(this.llRoot).b(new c());
    }

    public final void D4() {
        boolean z;
        Iterator<IPeopleInfo> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (it.next().isOnline()) {
                z = false;
                break;
            }
        }
        this.llTip.setVisibility(z ? 0 : 8);
        this.tvTip.setText(this.h ? R.string.ds_no_available_dom2 : R.string.ds_no_available_dom1);
    }

    public final void E4() {
        if (this.b.size() == 0) {
            this.llTop.setVisibility(8);
        } else {
            this.llTop.setVisibility(0);
        }
        if (this.h) {
            this.abTitle.getYesBtn().setEnabled(true);
            this.abTitle.getYesBtn().setAlpha(1.0f);
        } else if (this.b.size() == 0) {
            this.abTitle.getYesBtn().setEnabled(false);
            this.abTitle.getYesBtn().setAlpha(0.4f);
        } else {
            this.abTitle.getYesBtn().setEnabled(true);
            this.abTitle.getYesBtn().setAlpha(1.0f);
        }
    }

    @Override // com.wear.adapter.longdistance.DsFriendHaveSelectAdapter.b
    public void I(IPeopleInfo iPeopleInfo) {
        E4();
        int iIndexOf = this.d.indexOf(iPeopleInfo);
        if (iIndexOf != -1) {
            this.c.notifyItemChanged(iIndexOf);
            this.i = false;
            this.ivAll.setImageResource(R.drawable.choose_member_unselect);
        }
    }

    @Override // com.wear.adapter.longdistance.GroupMemmberShowSelectAdapter.b
    public boolean i(IPeopleInfo iPeopleInfo, boolean z) {
        if (z) {
            return this.b.contains(iPeopleInfo);
        }
        if (this.b.contains(iPeopleInfo)) {
            this.a.r(this.b.indexOf(iPeopleInfo));
            E4();
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_unselect);
            this.i = false;
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
        this.b.add(iPeopleInfo);
        this.a.notifyItemInserted(this.b.size() - 1);
        this.rvSelectFriend.scrollToPosition(this.a.getItemCount() - 1);
        E4();
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
            this.i = true;
        }
        return true;
    }

    @OnClick({R.id.ll_all})
    public void onClick() {
        boolean z = !this.i;
        this.i = z;
        if (z) {
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_select);
            Iterator<IPeopleInfo> it = this.d.iterator();
            while (it.hasNext()) {
                IPeopleInfo next = it.next();
                if (!this.b.contains(next) && next.isOnline()) {
                    this.b.add(next);
                }
            }
            this.a.notifyDataSetChanged();
            this.c.notifyDataSetChanged();
        } else {
            this.ivAll.setImageResource(R.drawable.chat_pattern_item_unselect);
            this.b.clear();
            this.a.notifyDataSetChanged();
            this.c.notifyDataSetChanged();
        }
        E4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ds_control_select_doms_people);
        ButterKnife.bind(this);
        String stringExtra = getIntent().getStringExtra("roomId");
        this.g = getIntent().getStringExtra("userJId");
        Group groupK = ch3.n().k(WearUtils.A0(stringExtra));
        this.e = groupK;
        if (groupK == null) {
            finish();
            return;
        }
        GroupMember memberByJid = groupK.getMemberByJid(ch3.n().p());
        if (memberByJid == null) {
            finish();
            return;
        }
        GroupMember memberByJid2 = this.e.getMemberByJid(this.g);
        if (memberByJid2 == null) {
            finish();
            return;
        }
        u4(stringExtra);
        v4();
        w4();
        ArrayList arrayList = new ArrayList(this.e.getList());
        vd3.b(arrayList, new q12());
        this.f.addAll(arrayList);
        this.f.remove(memberByJid2);
        if (memberByJid != memberByJid2) {
            this.f.remove(memberByJid);
            this.h = true;
        } else {
            this.h = false;
        }
        t4("");
        E4();
        D4();
        C4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.etSearch, this);
    }

    public final void t4(String str) {
        if (TextUtils.isEmpty(str)) {
            this.tvCancel.setVisibility(8);
        } else {
            this.tvCancel.setVisibility(0);
        }
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
        this.c.C(str);
        this.c.notifyDataSetChanged();
    }

    public final void u4(final String str) {
        this.abTitle.setTitle(ah4.e(R.string.ds_choose_doms));
        this.abTitle.setYesAction(ah4.e(R.string.common_done), new MyActionBar.f() { // from class: dc.c72
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.y4(str, view);
            }
        });
    }

    public final void v4() {
        DsFriendHaveSelectAdapter dsFriendHaveSelectAdapter = new DsFriendHaveSelectAdapter(this.b, R.layout.item_ds_friends_hava_select);
        this.a = dsFriendHaveSelectAdapter;
        cg3.d(this.rvSelectFriend, dsFriendHaveSelectAdapter);
        this.a.z(this);
    }

    public final void w4() {
        GroupMemmberShowSelectAdapter groupMemmberShowSelectAdapter = new GroupMemmberShowSelectAdapter(this.d, R.layout.item_group_ds_control_select_sub_people);
        this.c = groupMemmberShowSelectAdapter;
        cg3.f(this.rvFriend, groupMemmberShowSelectAdapter);
        this.c.B(this.e, 1);
        GroupMemmberShowSelectAdapter groupMemmberShowSelectAdapter2 = this.c;
        groupMemmberShowSelectAdapter2.t("No found");
        groupMemmberShowSelectAdapter2.x(th4.b(this, R.color.text_color_45));
        this.c.D(this);
    }
}
