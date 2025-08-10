package com.wear.ui.longDistance;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.BlockFriendShowSearchAdapter;
import com.wear.adapter.longdistance.ContactAdapter;
import com.wear.bean.BlockFriend;
import com.wear.bean.User;
import com.wear.bean.event.BlockFinishEvent;
import com.wear.bean.handlerbean.IContactInfo;
import com.wear.main.BaseFragment;
import com.wear.main.longDistance.HandlerBlockedFriendsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.hu3;
import dc.pj3;
import dc.th4;
import dc.vg3;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* loaded from: classes3.dex */
public class BlockListFragment extends BaseFragment implements ContactAdapter.c {
    public ContactAdapter l;
    public MyApplication n;
    public BlockFriendShowSearchAdapter p;

    @BindView(R.id.rv_list)
    public RecyclerView rvList;
    public List<IContactInfo> k = new ArrayList();
    public List<String> m = new ArrayList();
    public ArrayList<IContactInfo> o = new ArrayList<>();
    public String q = "";

    public class a implements BaseAdapter.b<IContactInfo> {
        public a() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(IContactInfo iContactInfo, int i, View view) {
            if (iContactInfo instanceof BlockFriend) {
                pj3.i(BlockListFragment.this.getActivity(), HandlerBlockedFriendsActivity.class, "values", (BlockFriend) iContactInfo);
                BlockListFragment.this.getActivity().finish();
            }
        }
    }

    public class b implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ ArrayList a;

            public a(ArrayList arrayList) {
                this.a = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity = BlockListFragment.this.getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                BlockListFragment.this.k.clear();
                BlockListFragment.this.k.addAll(this.a);
                BlockListFragment blockListFragment = BlockListFragment.this;
                blockListFragment.l = new ContactAdapter(blockListFragment.getActivity(), BlockListFragment.this.k, ah4.e(R.string.blocked_page_empty));
                BlockListFragment blockListFragment2 = BlockListFragment.this;
                blockListFragment2.l.o(blockListFragment2);
                if (TextUtils.isEmpty(BlockListFragment.this.q)) {
                    BlockListFragment blockListFragment3 = BlockListFragment.this;
                    cg3.f(blockListFragment3.rvList, blockListFragment3.l);
                    return;
                }
                BlockListFragment blockListFragment4 = BlockListFragment.this;
                blockListFragment4.p.z(blockListFragment4.q);
                BlockListFragment.this.o.clear();
                for (IContactInfo iContactInfo : BlockListFragment.this.k) {
                    String showNickName = iContactInfo.getShowNickName();
                    if (!TextUtils.isEmpty(showNickName) && showNickName.toLowerCase().contains(BlockListFragment.this.q.toLowerCase())) {
                        BlockListFragment.this.o.add(iContactInfo);
                    }
                }
                BlockListFragment blockListFragment5 = BlockListFragment.this;
                cg3.f(blockListFragment5.rvList, blockListFragment5.p);
                BlockListFragment.this.p.notifyDataSetChanged();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> listF = BlockListFragment.this.n.i.f(0);
            List<String> listF2 = BlockListFragment.this.n.i.f(1);
            BlockListFragment.this.m.clear();
            if (listF != null) {
                BlockListFragment.this.m.addAll(listF);
            }
            if (listF2 != null) {
                BlockListFragment.this.m.addAll(listF2);
            }
            ArrayList arrayList = new ArrayList();
            for (String str : BlockListFragment.this.m) {
                try {
                    if (str.indexOf("@" + WearUtils.d) != -1) {
                        BlockFriend blockFriend = new BlockFriend(str);
                        if (listF == null || !listF.contains(str)) {
                            blockFriend.setFriends(true);
                        } else {
                            blockFriend.setFriends(false);
                        }
                        blockFriend.setName(ah4.e(R.string.str_unknown));
                        User userV = ch3.n().v(WearUtils.g0(str));
                        if (userV != null) {
                            blockFriend.setName(userV.getShowNickName());
                            blockFriend.setAvatar(userV.getAvatar());
                        } else {
                            VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(str);
                            if (vCardLoadVCard != null) {
                                if (!WearUtils.e1(vCardLoadVCard.getNickName())) {
                                    blockFriend.setName(vCardLoadVCard.getNickName());
                                }
                                if (!WearUtils.i1(vCardLoadVCard.getAvatar())) {
                                    blockFriend.setAvatar(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"));
                                }
                            }
                        }
                        arrayList.add(blockFriend);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            BlockListFragment.this.L(new a(arrayList));
        }
    }

    public void W(String str) {
        this.q = str;
        if (this.l == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            cg3.f(this.rvList, this.l);
            return;
        }
        this.p.z(str);
        this.o.clear();
        for (IContactInfo iContactInfo : this.k) {
            String showNickName = iContactInfo.getShowNickName();
            if (!TextUtils.isEmpty(showNickName) && showNickName.toLowerCase().contains(str.toLowerCase())) {
                this.o.add(iContactInfo);
            }
        }
        cg3.f(this.rvList, this.p);
        this.p.notifyDataSetChanged();
    }

    public final void X() {
        vg3.b().a(new b());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_block_list, (ViewGroup) null, false);
        ButterKnife.bind(this, viewInflate);
        this.n = MyApplication.N();
        M(MyApplication.N());
        EventBus.getDefault().register(this);
        X();
        BlockFriendShowSearchAdapter blockFriendShowSearchAdapter = new BlockFriendShowSearchAdapter(this.o, R.layout.item_contact);
        this.p = blockFriendShowSearchAdapter;
        blockFriendShowSearchAdapter.t(ah4.e(R.string.common_search_no_result));
        blockFriendShowSearchAdapter.x(th4.b(getActivity(), R.color.text_color_85));
        this.p.w(true);
        this.p.s(new a());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BlockFinishEvent blockFinishEvent) {
        X();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            X();
        }
    }

    @Override // com.wear.adapter.longdistance.ContactAdapter.c
    public void q(IContactInfo iContactInfo) {
        if (iContactInfo instanceof BlockFriend) {
            pj3.i(getActivity(), HandlerBlockedFriendsActivity.class, "values", (BlockFriend) iContactInfo);
            getActivity().finish();
        }
    }
}
