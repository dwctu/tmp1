package com.wear.main.longDistance;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.kproduce.roundcorners.CircleImageView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.BlockFriend;
import com.wear.bean.event.BlockFinishEvent;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.event.FriendsRequestEvent;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.ch3;
import dc.ep1;
import dc.gp1;
import dc.ip1;
import dc.kg3;
import dc.kn3;
import dc.n82;
import dc.pj3;
import dc.th4;
import dc.zt3;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class HandlerBlockedFriendsActivity extends BaseActivity {
    public BlockFriend a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.black_setting)
    public SwitchView blackSetting;

    @BindView(R.id.btn_send_message)
    public View btnSendMessage;

    @BindView(R.id.riv_user_img)
    public CircleImageView rivUserImg;

    @BindView(R.id.tv_clear_history)
    public TextView tvClearHistory;

    @BindView(R.id.tv_names)
    public TextView tvName;

    @BindView(R.id.tv_remarks)
    public TextView tvRemarks;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            HandlerBlockedFriendsActivity.this.t4(this.a);
        }
    }

    public class b implements ip1 {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // dc.ip1
        public void G() {
            HandlerBlockedFriendsActivity.this.blackSetting.setCheckedImmediatelyNoEvent(!this.a);
            HandlerBlockedFriendsActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            HandlerBlockedFriendsActivity.this.cancleDelay();
        }
    }

    public class c extends HashMap<String, String> {
        public c() {
            String str;
            if (WearUtils.y.y() == null) {
                str = "0";
            } else {
                str = "" + WearUtils.y.y().size();
            }
            put("count", str);
        }
    }

    public class d extends HashMap<String, String> {
        public d() {
            String str;
            if (WearUtils.y.y() == null) {
                str = "0";
            } else {
                str = "" + WearUtils.y.y().size();
            }
            put("count", str);
        }
    }

    public class e implements kn3.d {
        public e() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            EventBus.getDefault().post(new BlockFinishEvent());
            HandlerBlockedFriendsActivity.this.finish();
        }
    }

    public class f implements kn3.d {
        public f(HandlerBlockedFriendsActivity handlerBlockedFriendsActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class g implements kn3.d {
        public g() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            DaoUtils.getCommunMessageDao().deleteByFriendEmail(WearUtils.g0(HandlerBlockedFriendsActivity.this.a.getJid()));
            DaoUtils.getEmojiFavoriteDao().deleteAllOwner(WearUtils.g0(HandlerBlockedFriendsActivity.this.a.getJid()));
            DaoUtils.getMessageHideDao().deleteAllHides(WearUtils.i0(zt3.k), HandlerBlockedFriendsActivity.this.a.getJid());
            DaoUtils.getMessageUnReadDao().deleteAllUnRead(WearUtils.i0(zt3.k), HandlerBlockedFriendsActivity.this.a.getJid());
            EventBus.getDefault().post(new ClearChatViewFriendIdEvent(WearUtils.g0(HandlerBlockedFriendsActivity.this.a.getJid())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C4(final boolean z, final boolean z2) {
        this.parentHandler.post(new Runnable() { // from class: dc.k72
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A4(z2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E4(CompoundButton compoundButton, boolean z) {
        gp1 gp1Var = new gp1(new a(z), new b(z));
        showDialog();
        ep1.b().r(this, gp1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w4(boolean z, boolean z2) {
        if (z) {
            EventBus.getDefault().post(new FriendsRequestEvent());
        } else {
            EventBus.getDefault().post(new FriendsRequestEvent());
        }
        dissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(final boolean z, final boolean z2) {
        this.parentHandler.post(new Runnable() { // from class: dc.i72
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w4(z2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(boolean z, boolean z2) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        EventBus.getDefault().post(new FriendsRequestEvent());
        if (z) {
            F4();
        }
        dissDialog();
    }

    public final void F4() {
        if (this.a.isFriends() || ch3.n().v(WearUtils.g0(this.a.getJid())) != null) {
            return;
        }
        kn3 kn3Var = new kn3((Context) this, String.format(ah4.e(R.string.unblock_frends_message_tip), this.a.getName()), ah4.e(R.string.common_ok), false, false, (kn3.d) new e());
        kn3Var.show();
        kn3Var.n();
    }

    @Override // com.wear.BaseActivity, dc.cs3.b
    public void onCancel() {
        super.onCancel();
        this.blackSetting.setCheckedImmediatelyNoEvent(!r0.isChecked());
        ep1.b().m(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_handler_blocked_friends);
        ButterKnife.bind(this);
        this.blackSetting.setCheckedImmediatelyNoEvent(true);
        BlockFriend blockFriend = (BlockFriend) getIntent().getParcelableExtra("values");
        this.a = blockFriend;
        if (blockFriend != null) {
            boolean z = !TextUtils.isEmpty(blockFriend.getRemarkName());
            TextView textView = this.tvRemarks;
            BlockFriend blockFriend2 = this.a;
            textView.setText(z ? blockFriend2.getRemarkName() : blockFriend2.getName());
            this.tvName.setText(this.a.getName());
            this.tvName.setVisibility(z ? 0 : 8);
        }
        BlockFriend blockFriend3 = this.a;
        if (blockFriend3 == null || !blockFriend3.isFriends()) {
            this.btnSendMessage.setVisibility(8);
            this.tvClearHistory.setVisibility(8);
        } else {
            this.btnSendMessage.setVisibility(0);
            this.tvClearHistory.setVisibility(0);
        }
        WearUtils.u2(this.rivUserImg, this.a.getAvatar());
        this.blackSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.j72
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.E4(compoundButton, z2);
            }
        });
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

    @OnClick({R.id.btn_send_message, R.id.tv_clear_history})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.btn_send_message) {
            if (id != R.id.tv_clear_history) {
                return;
            }
            u4();
        } else {
            if (this.a.isFriends() || ch3.n().v(WearUtils.g0(this.a.getJid())) != null) {
                pj3.j(this, ChatActivity.class, "userId", WearUtils.g0(this.a.getJid()));
                return;
            }
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.str_unblock_tip), ah4.e(R.string.common_ok), false, false, (kn3.d) new f(this));
            kn3Var.show();
            kn3Var.n();
        }
    }

    @Override // com.wear.BaseActivity
    public boolean skipBaseSettingBarColor() {
        kg3.i(this, !WearUtils.Y0());
        kg3.g(this, th4.b(this, R.color.lvs_ui_standard_systemBackground6));
        MyActionBar myActionBar = this.actionbar;
        if (myActionBar != null) {
            myActionBar.setParentBackgroundColor(0);
        }
        return true;
    }

    public final void t4(final boolean z) {
        if (z) {
            WearUtils.x.i.b(this.a.getJid(), !this.a.isFriends() ? 1 : 0, new n82.d() { // from class: dc.l72
                @Override // dc.n82.d
                public final void a(boolean z2) {
                    this.a.y4(z, z2);
                }
            });
            WearUtils.x.q("longDistance_block_friend", new c());
        } else {
            WearUtils.x.q("longDistance_unblock_friend", new d());
            WearUtils.x.i.y(this.a.getJid(), new n82.d() { // from class: dc.h72
                @Override // dc.n82.d
                public final void a(boolean z2) {
                    this.a.C4(z, z2);
                }
            });
        }
    }

    public final void u4() {
        kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.clear_chat_message) + "?", ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new g());
        kn3Var.show();
        kn3Var.p();
        kn3Var.l();
    }
}
