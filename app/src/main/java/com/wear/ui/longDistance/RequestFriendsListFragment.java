package com.wear.ui.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.adapter.longdistance.FriendsRequestListAdapter;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.event.AddFriendsEvent;
import com.wear.bean.event.AddFriendsRequestEvent;
import com.wear.bean.event.BlockFinishEvent;
import com.wear.bean.event.FriendsRequestEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.handlerbean.item.HeadUser;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.main.BaseFragment;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.bo3;
import dc.cg3;
import dc.ch3;
import dc.df3;
import dc.ep1;
import dc.gp1;
import dc.hu3;
import dc.ip1;
import dc.mu3;
import dc.n82;
import dc.sg3;
import dc.th4;
import dc.vd3;
import dc.ye3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class RequestFriendsListFragment extends BaseFragment implements FriendsRequestListAdapter.c {
    public FriendsRequestListAdapter k;
    public ArrayList<IPeopleInfo> l = new ArrayList<>();
    public ArrayList<IPeopleInfo> m = new ArrayList<>();
    public ArrayList<IPeopleInfo> n = new ArrayList<>();
    public MyApplication o;
    public View p;
    public boolean q;
    public String r;

    @BindView(R.id.rv_list)
    public RecyclerView rvList;

    public class a implements Comparator<IPeopleInfo> {
        public a(RequestFriendsListFragment requestFriendsListFragment) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(IPeopleInfo iPeopleInfo, IPeopleInfo iPeopleInfo2) {
            if (iPeopleInfo2.getAddTime() > iPeopleInfo.getAddTime()) {
                return 1;
            }
            return iPeopleInfo2.getAddTime() < iPeopleInfo.getAddTime() ? -1 : 0;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ IPeopleInfo a;

        public b(IPeopleInfo iPeopleInfo) {
            this.a = iPeopleInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestFriendsListFragment.this.y();
            hu3.a(this.a.getId());
            RequestFriendsListFragment.this.m.remove(this.a);
            RequestFriendsListFragment.this.l.remove(this.a);
            ch3.j.remove(this.a);
            RequestFriendsListFragment.this.b0();
            sg3.l(String.format(ah4.e(R.string.str_add_friends_suc), this.a.getUserName()));
            User userV = ch3.n().v(this.a.getId());
            if (userV != null) {
                userV.resetFriendType(1);
            }
            ch3.i.add(userV);
            EventBus.getDefault().post(new AddFriendsEvent());
            HashMap map = new HashMap();
            map.put("who_oppo", this.a.getUserJid());
            map.put("invite_result", 1);
            ye3.d("F0012", WearUtils.A.toJson(map));
        }
    }

    public class c implements ip1 {
        public c() {
        }

        @Override // dc.ip1
        public void G() {
            RequestFriendsListFragment.this.y();
        }

        @Override // dc.ip1
        public void d() {
            RequestFriendsListFragment.this.u();
        }
    }

    public class d implements bo3.d {
        public final /* synthetic */ IPeopleInfo a;
        public final /* synthetic */ User b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestFriendsListFragment.this.y();
                hu3.Z(d.this.a.getId());
                d.this.b.resetFriendType(16);
                d dVar = d.this;
                RequestFriendsListFragment.this.m.remove(dVar.a);
                d dVar2 = d.this;
                RequestFriendsListFragment.this.l.remove(dVar2.a);
                synchronized (ch3.h) {
                    ch3.j.remove(d.this.a);
                }
                UserSetting userSettingZ = WearUtils.y.z(d.this.a.getId());
                userSettingZ.setFriendsRequestClick(false);
                DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                RequestFriendsListFragment.this.b0();
                sg3.l(String.format(ah4.e(R.string.str_decline_add_friends_suc), d.this.a.getUserName()));
                HashMap map = new HashMap();
                map.put("who_oppo", d.this.a.getUserJid());
                map.put("invite_result", 0);
                ye3.d("F0012", WearUtils.A.toJson(map));
            }
        }

        public class b implements ip1 {
            public b() {
            }

            @Override // dc.ip1
            public void G() {
                RequestFriendsListFragment.this.y();
            }

            @Override // dc.ip1
            public void d() {
                RequestFriendsListFragment.this.u();
            }
        }

        public d(IPeopleInfo iPeopleInfo, User user) {
            this.a = iPeopleInfo;
            this.b = user;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            gp1 gp1Var = new gp1(new a(), new b());
            RequestFriendsListFragment.this.R();
            ep1.b().r(RequestFriendsListFragment.this, gp1Var);
        }
    }

    public class e implements bo3.d {
        public final /* synthetic */ IPeopleInfo a;

        public class a implements Runnable {

            /* renamed from: com.wear.ui.longDistance.RequestFriendsListFragment$e$a$a, reason: collision with other inner class name */
            public class C0149a implements n82.d {

                /* renamed from: com.wear.ui.longDistance.RequestFriendsListFragment$e$a$a$a, reason: collision with other inner class name */
                public class RunnableC0150a implements Runnable {
                    public RunnableC0150a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = e.this;
                        RequestFriendsListFragment.this.m.remove(eVar.a);
                        e eVar2 = e.this;
                        RequestFriendsListFragment.this.l.remove(eVar2.a);
                        RequestFriendsListFragment.this.b0();
                        sg3.l(String.format(ah4.e(R.string.str_block_add_friends_suc), e.this.a.getUserName()));
                        EventBus.getDefault().post(new BlockFinishEvent());
                        HashMap map = new HashMap();
                        map.put("who_oppo", e.this.a.getUserJid());
                        map.put("invite_result", 2);
                        ye3.d("F0012", WearUtils.A.toJson(map));
                    }
                }

                public C0149a() {
                }

                @Override // dc.n82.d
                public void a(boolean z) {
                    RequestFriendsListFragment.this.y();
                    if (z) {
                        RequestFriendsListFragment.this.L(new RunnableC0150a());
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WearUtils.x.i.b(WearUtils.i0(e.this.a.getId()), 1, new C0149a());
            }
        }

        public class b implements ip1 {
            public b() {
            }

            @Override // dc.ip1
            public void G() {
                RequestFriendsListFragment.this.y();
            }

            @Override // dc.ip1
            public void d() {
                RequestFriendsListFragment.this.u();
            }
        }

        public e(IPeopleInfo iPeopleInfo) {
            this.a = iPeopleInfo;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            gp1 gp1Var = new gp1(new a(), new b());
            RequestFriendsListFragment.this.R();
            ep1.b().r(RequestFriendsListFragment.this, gp1Var);
        }
    }

    public void X(String str) {
        this.r = str;
        this.k.z(str);
        if (TextUtils.isEmpty(str)) {
            b0();
            return;
        }
        this.n.clear();
        Iterator<IPeopleInfo> it = this.l.iterator();
        while (it.hasNext()) {
            IPeopleInfo next = it.next();
            if (next.showBykey(str)) {
                this.n.add(next);
            }
        }
        Iterator<IPeopleInfo> it2 = this.m.iterator();
        while (it2.hasNext()) {
            IPeopleInfo next2 = it2.next();
            if (next2.showBykey(str)) {
                this.n.add(next2);
            }
        }
        this.k.notifyDataSetChanged();
    }

    public final void a0() {
        this.q = true;
        synchronized (ch3.h) {
            for (User user : ch3.j) {
                UserSetting userSettingZ = WearUtils.y.z(user.getId());
                if (this.o.i.q(WearUtils.i0(user.getId()))) {
                    userSettingZ.setFriendsRequestClick(true);
                    DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                    df3.e().c(user.getId());
                } else {
                    user.setAddTime(userSettingZ.getAddTime());
                    if (!userSettingZ.isFriendsRequestClick()) {
                        userSettingZ.setFriendsRequestClick(true);
                        DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                        df3.e().c(user.getId());
                    }
                }
            }
        }
        mu3.c = 0;
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
    }

    public final void b0() {
        this.n.clear();
        if (this.l.size() > 0) {
            this.n.add(new HeadUser(1));
            this.n.addAll(this.l);
        }
        if (this.n.size() > 0 && this.m.size() > 0) {
            this.n.add(new HeadUser(2));
        }
        this.n.addAll(this.m);
        this.k.notifyDataSetChanged();
    }

    public final void c0() {
        this.m.clear();
        this.l.clear();
        synchronized (ch3.h) {
            for (User user : new ArrayList(ch3.j)) {
                if (user.isFriend()) {
                    ch3.j.remove(user);
                    UserSetting userSettingZ = WearUtils.y.z(user.getId());
                    userSettingZ.setFriendsRequestClick(false);
                    DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                } else {
                    UserSetting userSettingZ2 = WearUtils.y.z(user.getId());
                    if (!this.o.i.q(WearUtils.i0(user.getId()))) {
                        user.setAddTime(userSettingZ2.getAddTime());
                        if (userSettingZ2.isFriendsRequestClick()) {
                            this.m.add(user);
                        } else {
                            this.l.add(user);
                        }
                    }
                }
            }
        }
        e0(this.m);
        e0(this.l);
    }

    public final void d0(IPeopleInfo iPeopleInfo) {
        bo3 bo3Var = new bo3(getActivity(), R.layout.view_decline_friends_tip);
        bo3Var.show();
        bo3Var.d(R.id.tv_decline, new d(iPeopleInfo, (User) iPeopleInfo));
        bo3Var.d(R.id.tv_block, new e(iPeopleInfo));
        bo3Var.d(R.id.tv_cancel, null);
        ((TextView) bo3Var.a(R.id.tv_name)).setText(iPeopleInfo.getUserName());
        WearUtils.t2((ImageView) bo3Var.a(R.id.riv_user_img), iPeopleInfo);
    }

    public final void e0(ArrayList<IPeopleInfo> arrayList) {
        vd3.b(arrayList, new a(this));
    }

    @Override // com.wear.adapter.longdistance.FriendsRequestListAdapter.c
    public void k(IPeopleInfo iPeopleInfo) {
        d0(iPeopleInfo);
    }

    @Override // com.wear.adapter.longdistance.FriendsRequestListAdapter.c
    public void n(IPeopleInfo iPeopleInfo) {
        gp1 gp1Var = new gp1(new b(iPeopleInfo), new c());
        R();
        ep1.b().r(this, gp1Var);
    }

    @Override // com.wear.main.BaseFragment, dc.cs3.b
    public void onCancel() {
        super.onCancel();
        ep1.b().m(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_request_friends_list, (ViewGroup) null, false);
        this.p = viewInflate;
        ButterKnife.bind(this, viewInflate);
        MyApplication myApplicationN = MyApplication.N();
        this.o = myApplicationN;
        M(myApplicationN);
        FriendsRequestListAdapter friendsRequestListAdapter = new FriendsRequestListAdapter(this.n, R.layout.item_friends_request_list);
        this.k = friendsRequestListAdapter;
        friendsRequestListAdapter.t(ah4.e(R.string.friend_request_page_empty));
        friendsRequestListAdapter.x(th4.b(getActivity(), R.color.text_color_85));
        cg3.f(this.rvList, this.k);
        this.k.A(this);
        c0();
        b0();
        EventBus.getDefault().register(this);
        if (!this.q && getUserVisibleHint()) {
            a0();
        }
        return this.p;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsRequestEvent addFriendsRequestEvent) {
        User user;
        if (addFriendsRequestEvent == null || (user = addFriendsRequestEvent.user) == null) {
            return;
        }
        int i = addFriendsRequestEvent.flag;
        if (i == 0) {
            this.l.add(0, user);
            b0();
            return;
        }
        if (i == 1) {
            this.m.add(0, user);
            b0();
            return;
        }
        if (i == 3) {
            Iterator<IPeopleInfo> it = this.l.iterator();
            while (it.hasNext()) {
                IPeopleInfo next = it.next();
                if (next.getId().equals(addFriendsRequestEvent.user.getId())) {
                    this.l.remove(next);
                }
            }
            Iterator<IPeopleInfo> it2 = this.m.iterator();
            while (it2.hasNext()) {
                IPeopleInfo next2 = it2.next();
                if (next2.getId().equals(addFriendsRequestEvent.user.getId())) {
                    this.m.remove(next2);
                }
            }
            b0();
        }
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        c0();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || this.p == null || this.q) {
            return;
        }
        a0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FriendsRequestEvent friendsRequestEvent) {
        c0();
        X(this.r);
    }
}
