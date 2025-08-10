package com.wear.main.longDistance.block;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.BlockFriendAdapter;
import com.wear.bean.BlockFriend;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.hu3;
import dc.n82;
import dc.vg3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* loaded from: classes3.dex */
public class BlockContactsActivity extends BaseActivity {
    public MyApplication a;

    @BindView(R.id.actionbar_account)
    public MyActionBar actionbarAccount;

    @BindView(R.id.black_contacts_list)
    public ListView blackContactsList;
    public BlockFriendAdapter e;
    public ProgressDialog g;

    @BindView(R.id.list_empty_tip)
    public TextView listEmptyTip;
    public int b = -1;
    public List<String> c = null;
    public ArrayList<BlockFriend> d = new ArrayList<>();
    public HashMap<String, String> f = new HashMap<>();

    public class a implements MyActionBar.f {

        /* renamed from: com.wear.main.longDistance.block.BlockContactsActivity$a$a, reason: collision with other inner class name */
        public class C0126a implements n82.d {
            public C0126a() {
            }

            @Override // dc.n82.d
            public void a(boolean z) {
                if (z) {
                    BlockContactsActivity.this.A4();
                }
                BlockContactsActivity.this.B4(true);
            }
        }

        public class b extends HashMap<String, String> {
            public b() {
                String str;
                if (WearUtils.y.y() == null) {
                    str = "0";
                } else {
                    str = "" + WearUtils.y.y().size();
                }
                put("count", str);
            }
        }

        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            BlockContactsActivity blockContactsActivity = BlockContactsActivity.this;
            String strSubstring = "";
            blockContactsActivity.g = ProgressDialog.show(blockContactsActivity, "", ah4.e(R.string.common_loading), true, true);
            BlockContactsActivity.this.B4(false);
            Iterator<String> it = BlockContactsActivity.this.f.keySet().iterator();
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next() + ",";
            }
            if (strSubstring.endsWith(",")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            BlockContactsActivity.this.a.i.y(strSubstring, new C0126a());
            WearUtils.x.q("longDistance_unblock_friend", new b());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BlockContactsActivity.this.A4();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            BlockContactsActivity.this.actionbarAccount.getYesBtn().setEnabled(this.a);
            BlockContactsActivity.this.C4();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BlockContactsActivity.this.g.dismiss();
            BlockContactsActivity.this.blackContactsList.setVisibility(8);
            BlockContactsActivity blockContactsActivity = BlockContactsActivity.this;
            if (blockContactsActivity.b == 0) {
                blockContactsActivity.listEmptyTip.setText(ah4.e(R.string.black_contacts_no_block_friends));
            } else {
                blockContactsActivity.listEmptyTip.setText(ah4.e(R.string.black_contacts_no_rejected_request));
            }
            BlockContactsActivity.this.actionbarAccount.getYesBtn().setEnabled(false);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BlockContactsActivity.this.e.b(BlockContactsActivity.this.d);
            BlockContactsActivity.this.e.notifyDataSetChanged();
        }
    }

    public class f implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BlockContactsActivity.this.g.dismiss();
                BlockContactsActivity.this.e.b(BlockContactsActivity.this.d);
                BlockContactsActivity.this.e.notifyDataSetChanged();
                BlockContactsActivity.this.C4();
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : BlockContactsActivity.this.c) {
                try {
                    if (str.indexOf("@" + WearUtils.d) != -1) {
                        BlockFriend blockFriend = new BlockFriend(str);
                        String strG0 = WearUtils.g0(str);
                        blockFriend.setName(strG0.substring(0, strG0.indexOf("@")));
                        BlockContactsActivity.this.d.add(blockFriend);
                        VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(str);
                        if (vCardLoadVCard != null) {
                            if (!WearUtils.e1(vCardLoadVCard.getNickName())) {
                                BlockContactsActivity.this.d.get(r3.size() - 1).setName(vCardLoadVCard.getNickName());
                            }
                            if (!WearUtils.i1(vCardLoadVCard.getAvatar())) {
                                BlockContactsActivity.this.d.get(r3.size() - 1).setAvatar(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"));
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            BlockContactsActivity.this.runOnUiThread(new a());
        }
    }

    public final void A4() {
        this.c = this.a.i.f(this.b);
        this.f.clear();
        if (this.c == null) {
            runOnUiThread(new d());
            return;
        }
        this.d.clear();
        runOnUiThread(new e());
        vg3.b().a(new f());
    }

    public final void B4(boolean z) {
        runOnUiThread(new c(z));
    }

    public final void C4() {
        if (this.f.size() > 0) {
            this.actionbarAccount.getYesBtn().setVisibility(0);
            this.actionbarAccount.setTitle(ah4.e(R.string.black_contacts_select));
        } else {
            this.actionbarAccount.getYesBtn().setVisibility(8);
            this.actionbarAccount.setTitle(ah4.e(R.string.setting_black_contacts));
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remote_block_contacts_list);
        ButterKnife.bind(this);
        this.a = (MyApplication) getApplication();
        this.actionbarAccount.getYesBtn().setVisibility(8);
        this.actionbarAccount.setYesAction(R.string.black_contacts_select_unblock, new a());
        this.b = getIntent().getIntExtra("block_list_type", -1);
        BlockFriendAdapter blockFriendAdapter = new BlockFriendAdapter(this, this.a);
        this.e = blockFriendAdapter;
        this.blackContactsList.setAdapter((ListAdapter) blockFriendAdapter);
        this.g = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
        this.a.l.postDelayed(new b(), 1000L);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void z4(int i) {
        BlockFriend blockFriend = this.d.get(i);
        blockFriend.setChoose(!blockFriend.isChoose());
        if (blockFriend.isChoose()) {
            this.f.put(blockFriend.getJid(), blockFriend.getJid());
        } else {
            this.f.remove(blockFriend.getJid());
        }
        C4();
        this.e.notifyDataSetChanged();
    }
}
