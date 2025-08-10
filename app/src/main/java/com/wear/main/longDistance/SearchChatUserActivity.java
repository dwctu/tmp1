package com.wear.main.longDistance;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.ContactAdapter;
import com.wear.adapter.longdistance.SearchChatUserAdapter;
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IContactInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import com.wear.widget.LetterView;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.nv1;
import dc.t12;
import dc.ue3;
import dc.vd3;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SearchChatUserActivity extends BaseActivity {
    public String a;
    public String b;
    public String c;
    public t12 d = new t12();
    public ArrayList<IContactInfo> e;

    @BindView(R.id.et_search)
    public EditText et_search;
    public ContactAdapter f;
    public LinearLayoutManager g;
    public ArrayList<IContactInfo> h;
    public SearchChatUserAdapter i;

    @BindView(R.id.iv_delete)
    public ImageView iv_delete;

    @BindView(R.id.letter_view)
    public LetterView letter_view;

    @BindView(R.id.rv_contact)
    public RecyclerView rv_contact;

    @BindView(R.id.rv_search)
    public RecyclerView rv_search;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;

    public class a extends nv1 {
        public a() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                SearchChatUserActivity.this.iv_delete.setVisibility(0);
                SearchChatUserActivity.this.z4();
                return;
            }
            SearchChatUserActivity.this.iv_delete.setVisibility(8);
            SearchChatUserActivity.this.rv_contact.setVisibility(0);
            SearchChatUserActivity.this.letter_view.setVisibility(0);
            SearchChatUserActivity.this.rv_search.setVisibility(8);
            SearchChatUserActivity.this.tv_no_result.setVisibility(8);
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 1) {
                return false;
            }
            SearchChatUserActivity searchChatUserActivity = SearchChatUserActivity.this;
            ue3.a(searchChatUserActivity.et_search, searchChatUserActivity);
            SearchChatUserActivity.this.z4();
            return false;
        }
    }

    public class c implements ContactAdapter.c {
        public c() {
        }

        @Override // com.wear.adapter.longdistance.ContactAdapter.c
        public void q(IContactInfo iContactInfo) {
            SearchChatUserActivity.this.A4(iContactInfo);
        }
    }

    public class d implements LetterView.c {
        public d() {
        }

        @Override // com.wear.widget.LetterView.c
        public void a() {
            SearchChatUserActivity.this.g.scrollToPositionWithOffset(0, 0);
        }

        @Override // com.wear.widget.LetterView.c
        public void b(String str) {
            SearchChatUserActivity.this.g.scrollToPositionWithOffset(SearchChatUserActivity.this.f.m(str), 0);
        }
    }

    public class e implements BaseAdapter.b<IContactInfo> {
        public e() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(IContactInfo iContactInfo, int i, View view) {
            SearchChatUserActivity.this.A4(iContactInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A4(com.wear.bean.handlerbean.IContactInfo r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.wear.bean.User
            java.lang.String r1 = ""
            if (r0 == 0) goto L16
            com.wear.bean.User r6 = (com.wear.bean.User) r6
            java.lang.String r6 = r6.getUserJid()
            dc.ch3 r0 = com.wear.util.WearUtils.y
            java.lang.String r0 = r0.p()
        L12:
            r4 = r1
            r1 = r6
            r6 = r4
            goto L59
        L16:
            boolean r0 = r6 instanceof com.wear.bean.Account
            if (r0 == 0) goto L23
            dc.ch3 r6 = com.wear.util.WearUtils.y
            java.lang.String r6 = r6.p()
            java.lang.String r0 = r5.b
            goto L12
        L23:
            boolean r0 = r6 instanceof com.wear.bean.GroupMember
            if (r0 == 0) goto L57
            com.wear.bean.GroupMember r6 = (com.wear.bean.GroupMember) r6
            java.lang.String r0 = r6.getUserJid()
            dc.ch3 r2 = com.wear.util.WearUtils.y
            java.lang.String r2 = r2.p()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L46
            dc.ch3 r6 = com.wear.util.WearUtils.y
            java.lang.String r6 = r6.p()
            java.lang.String r0 = r5.c
            java.lang.String r0 = com.wear.util.WearUtils.k0(r0)
            goto L12
        L46:
            java.lang.String r0 = r5.c
            java.lang.String r1 = com.wear.util.WearUtils.k0(r0)
            dc.ch3 r0 = com.wear.util.WearUtils.y
            java.lang.String r0 = r0.p()
            java.lang.String r6 = r6.getUserJid()
            goto L59
        L57:
            r6 = r1
            r0 = r6
        L59:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "fromJid"
            r2.putString(r3, r1)
            java.lang.String r1 = "toJid"
            r2.putString(r1, r0)
            java.lang.String r0 = r5.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L78
            java.lang.String r6 = r5.a
            java.lang.String r0 = "userId"
            r2.putString(r0, r6)
            goto L8c
        L78:
            java.lang.String r0 = r5.c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L8c
            java.lang.String r0 = "realFromJid"
            r2.putString(r0, r6)
            java.lang.String r6 = r5.c
            java.lang.String r0 = "roomId"
            r2.putString(r0, r6)
        L8c:
            java.lang.Class<com.wear.main.longDistance.SearchChatUserMessageActivity> r6 = com.wear.main.longDistance.SearchChatUserMessageActivity.class
            dc.pj3.g(r5, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.SearchChatUserActivity.A4(com.wear.bean.handlerbean.IContactInfo):void");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        ue3.a(this.et_search, this);
    }

    @OnClick({R.id.iv_delete, R.id.tv_cancel})
    public void onClick(View view) {
        new Bundle();
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.et_search.setText("");
        } else {
            if (id != R.id.tv_cancel) {
                return;
            }
            onBackPressed();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_chat_user);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString("userId");
            this.a = string;
            this.b = WearUtils.i0(string);
            this.c = getIntent().getExtras().getString("roomId");
        }
        w4();
        y4();
    }

    public final void w4() {
        Group groupK;
        this.e = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.a)) {
            for (IPeopleInfo iPeopleInfo : ch3.i) {
                if (iPeopleInfo != null && !iPeopleInfo.isGroup() && TextUtils.equals(iPeopleInfo.getId(), this.a)) {
                    arrayList.add(iPeopleInfo);
                }
            }
            arrayList.add(ch3.n().u());
            vd3.b(arrayList, this.d);
            this.e.addAll(arrayList);
        } else if (!TextUtils.isEmpty(this.c) && (groupK = ch3.n().k(this.c)) != null) {
            arrayList.addAll(groupK.getList());
            vd3.b(arrayList, this.d);
            this.e.addAll(arrayList);
        }
        ContactAdapter contactAdapter = new ContactAdapter(this, this.e, ah4.e(R.string.friend_list_page_empt));
        this.f = contactAdapter;
        contactAdapter.o(new c());
        this.g = cg3.f(this.rv_contact, this.f);
        this.letter_view.setCharacterListener(new d());
    }

    public final void x4() {
        ArrayList<IContactInfo> arrayList = new ArrayList<>();
        this.h = arrayList;
        SearchChatUserAdapter searchChatUserAdapter = new SearchChatUserAdapter(this, arrayList, R.layout.item_contact);
        this.i = searchChatUserAdapter;
        searchChatUserAdapter.s(new e());
        cg3.f(this.rv_search, this.i);
    }

    public final void y4() {
        this.et_search.addTextChangedListener(new a());
        this.et_search.setOnKeyListener(new b());
        w4();
        x4();
    }

    public final void z4() {
        this.h.clear();
        String lowerCase = this.et_search.getText().toString().trim().toLowerCase();
        Iterator<IContactInfo> it = this.e.iterator();
        while (it.hasNext()) {
            IContactInfo next = it.next();
            if (next instanceof User) {
                User user = (User) next;
                if (user.getShowNickName().toLowerCase().contains(lowerCase)) {
                    this.h.add(user);
                }
            } else if (next instanceof Account) {
                Account account = (Account) next;
                if (account.getUserName().toLowerCase().contains(lowerCase)) {
                    this.h.add(account);
                }
            } else if (next instanceof GroupMember) {
                GroupMember groupMember = (GroupMember) next;
                if (groupMember.getNickName().toLowerCase().contains(lowerCase)) {
                    this.h.add(groupMember);
                }
            }
        }
        this.rv_contact.setVisibility(8);
        this.letter_view.setVisibility(8);
        this.rv_search.setVisibility(this.h.isEmpty() ? 8 : 0);
        this.tv_no_result.setVisibility(this.h.isEmpty() ? 0 : 8);
        this.i.z(lowerCase);
        this.i.notifyDataSetChanged();
    }
}
