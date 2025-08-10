package com.wear.main.longDistance;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.BlockListAdapter;
import com.wear.bean.BlockFriend;
import com.wear.bean.User;
import com.wear.bean.event.BlockFinishEvent;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.hu3;
import dc.pj3;
import dc.vg3;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* loaded from: classes3.dex */
public class BlockListActivity extends BaseActivity implements BlockListAdapter.b {
    public BlockListAdapter b;
    public ProgressDialog c;

    @BindView(R.id.rv_list)
    public RecyclerView rvList;
    public ArrayList<BlockFriend> a = new ArrayList<>();
    public List<String> d = new ArrayList();

    public class a implements Runnable {

        /* renamed from: com.wear.main.longDistance.BlockListActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0107a implements Runnable {
            public final /* synthetic */ ArrayList a;

            public RunnableC0107a(ArrayList arrayList) {
                this.a = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BlockListActivity.this.isFinishing() || BlockListActivity.this.isDestroyed()) {
                    return;
                }
                BlockListActivity.this.a.clear();
                BlockListActivity.this.a.addAll(this.a);
                BlockListActivity.this.c.dismiss();
                BlockListActivity.this.b.notifyDataSetChanged();
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> listF = BlockListActivity.this.application.i.f(0);
            List<String> listF2 = BlockListActivity.this.application.i.f(1);
            BlockListActivity.this.d.clear();
            if (listF != null) {
                BlockListActivity.this.d.addAll(listF);
            }
            if (listF2 != null) {
                BlockListActivity.this.d.addAll(listF2);
            }
            ArrayList arrayList = new ArrayList();
            for (String str : BlockListActivity.this.d) {
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
            BlockListActivity.this.runOnMainThread(new RunnableC0107a(arrayList));
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_block_list);
        ButterKnife.bind(this);
        BlockListAdapter blockListAdapter = new BlockListAdapter(this.a, R.layout.item_friends_blocked_list);
        this.b = blockListAdapter;
        cg3.f(this.rvList, blockListAdapter);
        this.c = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
        this.b.z(this);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BlockFinishEvent blockFinishEvent) {
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        v4();
    }

    public final void v4() {
        vg3.b().a(new a());
    }

    @Override // com.wear.adapter.longdistance.BlockListAdapter.b
    public void z2(BlockFriend blockFriend) {
        pj3.i(this, HandlerBlockedFriendsActivity.class, "values", blockFriend);
    }
}
