package com.wear.main.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.GroupMemmberShowSelectAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.nv1;
import dc.ov1;
import dc.pj3;
import dc.q12;
import dc.th4;
import dc.ue3;
import dc.vd3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupDsControlSelectsubPeopleActivity extends BaseActivity implements GroupMemmberShowSelectAdapter.b {
    public GroupMemmberShowSelectAdapter a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public Group c;
    public IPeopleInfo e;

    @BindView(R.id.empty_view)
    public TextView emptyView;

    @BindView(R.id.et_search)
    public EditText etSearch;

    @BindView(R.id.ll_root)
    public LinearLayout llRoot;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.tv_Cancel)
    public TextView tvCancel;
    public ArrayList<IPeopleInfo> b = new ArrayList<>();
    public List<IPeopleInfo> d = new ArrayList();

    public class a implements MyActionBar.f {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (GroupDsControlSelectsubPeopleActivity.this.e != null) {
                Bundle bundle = new Bundle();
                bundle.putString("userJId", GroupDsControlSelectsubPeopleActivity.this.e.getUserJid());
                bundle.putString("roomId", this.a);
                pj3.p(GroupDsControlSelectsubPeopleActivity.this, GroupDsControlSelectDomsPeopleActivity.class, 21, bundle);
            }
        }
    }

    public class b extends nv1 {
        public b() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            GroupDsControlSelectsubPeopleActivity.this.t4(editable.toString());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupDsControlSelectsubPeopleActivity.this.etSearch.setText("");
            GroupDsControlSelectsubPeopleActivity.this.t4("");
            GroupDsControlSelectsubPeopleActivity groupDsControlSelectsubPeopleActivity = GroupDsControlSelectsubPeopleActivity.this;
            ue3.a(groupDsControlSelectsubPeopleActivity.etSearch, groupDsControlSelectsubPeopleActivity.activity);
        }
    }

    public class d implements ov1.b {
        public d() {
        }

        @Override // dc.ov1.b
        public void a(int i) {
            GroupDsControlSelectsubPeopleActivity.this.tvCancel.setVisibility(8);
        }

        @Override // dc.ov1.b
        public void b(int i) {
            GroupDsControlSelectsubPeopleActivity.this.tvCancel.setVisibility(0);
        }
    }

    @Override // com.wear.adapter.longdistance.GroupMemmberShowSelectAdapter.b
    public boolean i(IPeopleInfo iPeopleInfo, boolean z) {
        if (z) {
            return iPeopleInfo == this.e;
        }
        IPeopleInfo iPeopleInfo2 = this.e;
        if (iPeopleInfo2 != null) {
            int iIndexOf = this.b.indexOf(iPeopleInfo2);
            if (this.e != iPeopleInfo) {
                this.e = iPeopleInfo;
                if (iIndexOf >= 0) {
                    this.a.notifyItemChanged(iIndexOf);
                } else {
                    this.a.notifyDataSetChanged();
                }
            }
        } else {
            this.e = iPeopleInfo;
        }
        u4();
        return true;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 21 && i2 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ds_control_select_sub_people);
        ButterKnife.bind(this);
        this.abTitle.setTitle(ah4.e(R.string.ds_choose_a_sub));
        String stringExtra = getIntent().getStringExtra("roomId");
        Group groupK = ch3.n().k(WearUtils.A0(stringExtra));
        this.c = groupK;
        if (groupK == null) {
            finish();
            return;
        }
        this.abTitle.setYesAction(ah4.e(R.string.ds_button_next), new a(stringExtra));
        GroupMemmberShowSelectAdapter groupMemmberShowSelectAdapter = new GroupMemmberShowSelectAdapter(this.b, R.layout.item_group_ds_control_select_sub_people);
        this.a = groupMemmberShowSelectAdapter;
        cg3.f(this.rvFriend, groupMemmberShowSelectAdapter);
        this.a.B(this.c, 0);
        GroupMemmberShowSelectAdapter groupMemmberShowSelectAdapter2 = this.a;
        groupMemmberShowSelectAdapter2.t("No found");
        groupMemmberShowSelectAdapter2.x(th4.b(this, R.color.text_color_45));
        ArrayList<GroupMember> arrayList = new ArrayList(this.c.getList());
        if (this.c.getMemberByJid(ch3.n().p()) == null) {
            finish();
            return;
        }
        vd3.b(arrayList, new q12());
        this.d.addAll(arrayList);
        for (GroupMember groupMember : arrayList) {
            if (!groupMember.realOnline() || groupMember.getToys().size() == 0) {
                this.d.remove(groupMember);
            }
        }
        t4("");
        u4();
        this.a.D(this);
        this.etSearch.addTextChangedListener(new b());
        this.tvCancel.setOnClickListener(new c());
        new ov1(this.llRoot).b(new d());
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.etSearch, this);
    }

    public final void t4(String str) {
        ArrayList<IPeopleInfo> arrayList = new ArrayList(this.d);
        this.b.clear();
        for (IPeopleInfo iPeopleInfo : arrayList) {
            if (!iPeopleInfo.isGroup()) {
                if (TextUtils.isEmpty(str)) {
                    this.b.add(iPeopleInfo);
                } else if (iPeopleInfo.showBykey(str)) {
                    this.b.add(iPeopleInfo);
                }
            }
        }
        this.a.C(str);
        this.a.notifyDataSetChanged();
        this.rvFriend.setVisibility(this.b.isEmpty() ? 8 : 0);
        this.emptyView.setVisibility(this.b.isEmpty() ? 0 : 8);
    }

    public final void u4() {
        if (this.e == null) {
            this.abTitle.getYesBtn().setEnabled(false);
            this.abTitle.getYesBtn().setAlpha(0.4f);
        } else {
            this.abTitle.getYesBtn().setEnabled(true);
            this.abTitle.getYesBtn().setAlpha(1.0f);
        }
    }
}
