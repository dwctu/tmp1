package com.wear.ui.longDistance;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.ContactAdapter;
import com.wear.adapter.longdistance.FriendShowSearchAdapter;
import com.wear.bean.event.AddFriendsEvent;
import com.wear.bean.handlerbean.IContactInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.handlerbean.item.HeadUser;
import com.wear.bean.official.OfficialAcount;
import com.wear.main.BaseFragment;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.LetterView;
import dc.ah4;
import dc.cg3;
import dc.pj3;
import dc.t12;
import dc.th4;
import dc.v83;
import dc.vd3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class AllFriendsFragment extends BaseFragment {
    public ContactAdapter k;

    @BindView(R.id.letter_view)
    public LetterView letterView;
    public LinearLayoutManager m;
    public FriendShowSearchAdapter o;
    public String q;

    @BindView(R.id.rv_list)
    public RecyclerView rvList;
    public List<IContactInfo> l = new ArrayList();
    public ArrayList<IPeopleInfo> n = new ArrayList<>();
    public t12 p = new t12();
    public int r = 0;

    public class a implements BaseAdapter.b<IPeopleInfo> {
        public a() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(IPeopleInfo iPeopleInfo, int i, View view) {
            if (iPeopleInfo != null) {
                if (iPeopleInfo.isGroup()) {
                    pj3.j(AllFriendsFragment.this.getActivity(), ChatRoomActivity.class, "roomId", iPeopleInfo.getId());
                } else if (iPeopleInfo instanceof OfficialAcount) {
                    pj3.f(AllFriendsFragment.this.getActivity(), OfficialAccountActivity.class);
                } else {
                    pj3.j(AllFriendsFragment.this.getActivity(), ChatActivity.class, "userId", iPeopleInfo.getId());
                }
                v83.a();
            }
        }
    }

    public class b implements LetterView.c {
        public b() {
        }

        @Override // com.wear.widget.LetterView.c
        public void a() {
            AllFriendsFragment.this.m.scrollToPositionWithOffset(0, 0);
        }

        @Override // com.wear.widget.LetterView.c
        public void b(String str) {
            AllFriendsFragment.this.m.scrollToPositionWithOffset(AllFriendsFragment.this.k.m(str), 0);
        }
    }

    public class c implements ContactAdapter.c {
        public c() {
        }

        @Override // com.wear.adapter.longdistance.ContactAdapter.c
        public void q(IContactInfo iContactInfo) {
            if (iContactInfo instanceof IPeopleInfo) {
                IPeopleInfo iPeopleInfo = (IPeopleInfo) iContactInfo;
                if (iPeopleInfo.isGroup()) {
                    pj3.j(AllFriendsFragment.this.getActivity(), ChatRoomActivity.class, "roomId", iPeopleInfo.getId());
                } else if (iPeopleInfo instanceof OfficialAcount) {
                    pj3.f(AllFriendsFragment.this.getActivity(), OfficialAccountActivity.class);
                } else {
                    pj3.j(AllFriendsFragment.this.getActivity(), ChatActivity.class, "userId", iPeopleInfo.getId());
                }
                v83.a();
            }
        }
    }

    public void a0(String str, int i) {
        this.q = str;
        this.r = i;
        if (TextUtils.isEmpty(str)) {
            b0();
            this.m = cg3.f(this.rvList, this.k);
            return;
        }
        this.letterView.setVisibility(8);
        this.n.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, IPeopleInfo> mapH = WearUtils.y.h();
        if ("lovenseremoteofficial".contains(str) || "notification assistant".contains(str.toLowerCase())) {
            mapH.put("lovenseRemoteOfficial", OfficialaCountModel.g.a().o().getValue());
        }
        for (String str2 : mapH.keySet()) {
            IPeopleInfo iPeopleInfo = mapH.get(str2);
            if (iPeopleInfo != null && (!TextUtils.isEmpty(iPeopleInfo.getUserName()) || !TextUtils.isEmpty(iPeopleInfo.getAvatar()))) {
                if (!this.n.contains(iPeopleInfo) && iPeopleInfo.isShowInFriendsList() && !WearUtils.w1(iPeopleInfo.getId()) && iPeopleInfo.showBykey(str)) {
                    if (iPeopleInfo.isGroup()) {
                        arrayList2.add(iPeopleInfo);
                    } else if (iPeopleInfo instanceof OfficialAcount) {
                        arrayList.add(iPeopleInfo);
                    } else if (i != 999) {
                        arrayList.add(iPeopleInfo);
                    } else if (!WearUtils.x.i.k(WearUtils.j0(str2))) {
                        arrayList.add(iPeopleInfo);
                    }
                }
            }
        }
        if (arrayList.size() != 0) {
            this.n.add(new HeadUser(1));
            vd3.b(arrayList, this.p);
            this.n.addAll(arrayList);
        }
        if (arrayList2.size() != 0) {
            this.n.add(new HeadUser(2));
            vd3.b(arrayList2, this.p);
            this.n.addAll(arrayList2);
        }
        if (TextUtils.isEmpty(str)) {
            this.o.w(false);
        } else {
            this.o.w(true);
        }
        this.o.z(str);
        this.o.notifyDataSetChanged();
        cg3.f(this.rvList, this.o);
    }

    public final void b0() {
        Map<String, IPeopleInfo> mapH = WearUtils.y.h();
        mapH.put("lovenseRemoteOfficial", OfficialaCountModel.g.a().o().getValue());
        ArrayList arrayList = new ArrayList();
        for (String str : mapH.keySet()) {
            IPeopleInfo iPeopleInfo = mapH.get(str);
            if (iPeopleInfo != null && (!TextUtils.isEmpty(iPeopleInfo.getUserName()) || !TextUtils.isEmpty(iPeopleInfo.getAvatar()))) {
                if (!WearUtils.x.i.k(WearUtils.j0(str)) && iPeopleInfo.isShowInFriendsList() && !WearUtils.w1(iPeopleInfo.getId())) {
                    arrayList.add(iPeopleInfo);
                }
            }
        }
        vd3.b(arrayList, this.p);
        this.l.clear();
        this.l.addAll(arrayList);
        this.k = new ContactAdapter(getActivity(), this.l, ah4.e(R.string.friend_list_page_empt));
        this.letterView.setCharacterListener(new b());
        this.k.o(new c());
        this.letterView.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_all_friends, (ViewGroup) null, false);
        ButterKnife.bind(this, viewInflate);
        M(MyApplication.N());
        FriendShowSearchAdapter friendShowSearchAdapter = new FriendShowSearchAdapter(this.n, R.layout.item_friends_show_search);
        this.o = friendShowSearchAdapter;
        friendShowSearchAdapter.t(ah4.e(R.string.common_search_no_result));
        friendShowSearchAdapter.x(th4.b(getActivity(), R.color.text_color_85));
        this.o.w(true);
        this.o.s(new a());
        EventBus.getDefault().register(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsEvent addFriendsEvent) {
        a0(this.q, this.r);
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        a0(this.q, this.r);
    }
}
