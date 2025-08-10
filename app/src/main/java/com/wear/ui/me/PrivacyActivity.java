package com.wear.ui.me;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.PolicyListBean;
import com.wear.bean.Setting;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.main.account.WebViewActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.longDistance.ConnectionsBlockActivity;
import com.wear.util.WearUtils;
import com.wear.widget.HtmlTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.ch3;
import dc.eg3;
import dc.hu3;
import dc.kg3;
import dc.lg3;
import dc.me3;
import dc.pj3;
import dc.th4;
import dc.tn2;
import dc.wg3;
import dc.ye3;
import dc.zn2;
import java.util.ArrayList;
import java.util.HashMap;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes4.dex */
public class PrivacyActivity extends BaseActivity implements View.OnClickListener {
    public Setting a;

    @BindView(R.id.accept_logs_swith)
    public SwitchView acceptLogsSwith;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Account b;

    @BindView(R.id.ll_add_group_friend_mode)
    public LinearLayout llAddGroupFriendMode;

    @BindView(R.id.ll_blocked_list)
    public LinearLayout llBlockedList;

    @BindView(R.id.ll_hidden_patterns)
    public LinearLayout llHiddenPatterns;

    @BindView(R.id.sb_add_group_friend_mode)
    public SwitchView sbAddGroupFriendMode;

    @BindView(R.id.view_block_red)
    public View viewBlockRed;

    @BindView(R.id.web_link)
    public HtmlTextView webLink;

    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: com.wear.ui.me.PrivacyActivity$a$a, reason: collision with other inner class name */
        public class C0155a implements zn2<String> {
            public final /* synthetic */ boolean a;

            public C0155a(boolean z) {
                this.a = z;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                if (this.a) {
                    ye3.U(false);
                    PrivacyActivity.this.a.setAcceptPrivacyLogs(Boolean.TRUE);
                    PrivacyActivity.this.addAnalyticsEventId("privacypolicy_open", null);
                } else {
                    PrivacyActivity.this.a.setAcceptPrivacyLogs(Boolean.FALSE);
                    PrivacyActivity.this.addAnalyticsEventId("privacypolicy_closed", null);
                }
                DaoUtils.getSettingDao().update((SettingDao) PrivacyActivity.this.a);
                WearUtils.x.j = this.a ? 1 : 0;
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
            }
        }

        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HashMap map = new HashMap();
            map.put("isOpen", Integer.valueOf(z ? 1 : 0));
            tn2.x(WearUtils.x).t("/app/logSwitch", map, new C0155a(z));
        }
    }

    public class b implements HtmlTextView.a {
        public b() {
        }

        @Override // com.wear.widget.HtmlTextView.a
        public void a(String str) {
            ArrayList arrayList = new ArrayList();
            String strC = lg3.c(lg3.e(PrivacyActivity.this));
            PolicyListBean policyListBean = (PolicyListBean) new Gson().fromJson(eg3.h(PrivacyActivity.this, "new_argement_list", ""), PolicyListBean.class);
            if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
                for (int i = 0; i < policyListBean.getData().size(); i++) {
                    arrayList.add(policyListBean.getData().get(i).getUrl());
                }
            }
            Bundle bundle = new Bundle();
            if (arrayList.size() > 0) {
                bundle.putString(ImagesContract.URL, ((String) arrayList.get(0)) + "?pf=" + wg3.a() + "&lang=" + strC);
            } else {
                bundle.putString(ImagesContract.URL, "https://hyttoapps.bandnana.com/remote/privacy-policy?pf=" + wg3.a() + "&lang=" + strC);
            }
            bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.privacy_policy));
            pj3.g(PrivacyActivity.this, WebViewActivity.class, bundle);
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                PrivacyActivity.this.b.setAddFriendFromGroup("1");
                PrivacyActivity.this.sbAddGroupFriendMode.setCheckedImmediatelyNoEvent(true);
            } else {
                PrivacyActivity.this.b.setAddFriendFromGroup("2");
                PrivacyActivity.this.sbAddGroupFriendMode.setCheckedImmediatelyNoEvent(false);
            }
            ch3.n().P();
            hu3.v0(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ll_hidden_patterns) {
            pj3.f(this, PatternsHiddenActivity.class);
        } else if (view.getId() == R.id.ll_blocked_list) {
            ConnectionsBlockActivity.F4(view.getContext());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_privacy_setting);
        me3.c(me3.c.ME_PRIVACY_UI_ENTER);
        ye3.c("privacy", "into page", null);
        ButterKnife.bind(this);
        setCurrentScreen(this, "setting_privacy_screen_view", PrivacyActivity.class.getSimpleName());
        this.llHiddenPatterns.setOnClickListener(this);
        this.llBlockedList.setOnClickListener(this);
        this.a = this.application.S();
        Account accountU = ch3.n().u();
        this.b = accountU;
        Setting setting = this.a;
        if (setting == null || accountU == null) {
            finish();
            return;
        }
        if (WearUtils.x.j == 1) {
            setting.setAcceptPrivacyLogs(Boolean.TRUE);
        } else {
            setting.setAcceptPrivacyLogs(Boolean.FALSE);
        }
        DaoUtils.getSettingDao().update((SettingDao) this.a);
        if (WearUtils.x1(this.a.getAcceptPrivacyLogs())) {
            this.acceptLogsSwith.setCheckedImmediatelyNoEvent(true);
        } else {
            this.acceptLogsSwith.setCheckedImmediatelyNoEvent(false);
        }
        this.acceptLogsSwith.setOnCheckedChangeListener(new a());
        this.webLink.setText(ah4.e(R.string.account_license_privacy).replaceAll(StringUtils.LT_ENCODE, SimpleComparison.LESS_THAN_OPERATION).replaceAll(StringUtils.GT_ENCODE, SimpleComparison.GREATER_THAN_OPERATION), Integer.valueOf(getResources().getColor(R.color.color_accent)), new b());
        if (WearUtils.e1(this.b.getAddFriendFromGroup()) || this.b.getAddFriendFromGroup().equals("1")) {
            this.sbAddGroupFriendMode.setCheckedImmediatelyNoEvent(true);
        } else {
            this.sbAddGroupFriendMode.setCheckedImmediatelyNoEvent(false);
        }
        this.sbAddGroupFriendMode.setOnCheckedChangeListener(new c());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.ME_PRIVACY_UI_EXIT);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.setAcceptPrivacyLogs(Boolean.valueOf(this.acceptLogsSwith.isChecked()));
        DaoUtils.getSettingDao().update((SettingDao) this.a);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        w4();
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

    public final void w4() {
        this.viewBlockRed.setVisibility(WearUtils.I1(this, "key_show_red_by_connections") ? 0 : 8);
    }
}
