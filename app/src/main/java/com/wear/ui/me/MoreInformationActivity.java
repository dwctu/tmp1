package com.wear.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.FFBasicMsgBean;
import com.wear.bean.event.VCardChangeEvent;
import com.wear.main.MainActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.FFBasicMsgSelectDialog;
import dc.ep1;
import dc.gp1;
import dc.ip1;
import dc.pj3;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class MoreInformationActivity extends BaseActivity {
    public List<FFBasicMsgBean> a = new ArrayList();

    @BindView(R.id.age_layout)
    public LinearLayout ageLayout;
    public String b;
    public Account c;
    public FFBasicMsgBean d;

    @BindView(R.id.mood_layout)
    public LinearLayout moodLayout;

    @BindView(R.id.screan_root_layout)
    public LinearLayout screanRootLayout;

    @BindView(R.id.tv_age)
    public AppCompatTextView tvAge;

    @BindView(R.id.mood_message)
    public AppCompatTextView tvMoodMessage;

    public class a implements View.OnClickListener {

        /* renamed from: com.wear.ui.me.MoreInformationActivity$a$a, reason: collision with other inner class name */
        public class C0154a implements FFBasicMsgSelectDialog.b {
            public C0154a() {
            }

            @Override // com.wear.widget.dialog.FFBasicMsgSelectDialog.b
            public void a(FFBasicMsgBean fFBasicMsgBean) {
                MoreInformationActivity.this.tvAge.setText(fFBasicMsgBean.getKey());
                MoreInformationActivity.this.u4(fFBasicMsgBean);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MoreInformationActivity moreInformationActivity = MoreInformationActivity.this;
            FFBasicMsgSelectDialog fFBasicMsgSelectDialog = new FFBasicMsgSelectDialog(moreInformationActivity, moreInformationActivity.a);
            fFBasicMsgSelectDialog.show();
            fFBasicMsgSelectDialog.d(new C0154a());
            fFBasicMsgSelectDialog.e(0);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MoreInformationActivity moreInformationActivity = MoreInformationActivity.this;
            pj3.q(moreInformationActivity, EditMoodMessageActivity.class, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, "moodMessage", moreInformationActivity.b);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Account a;
        public final /* synthetic */ String b;

        public c(MoreInformationActivity moreInformationActivity, Account account, String str) {
            this.a = account;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setAge(this.b);
            WearUtils.x.l.post(new Runnable() { // from class: dc.hb3
                @Override // java.lang.Runnable
                public final void run() {
                    hu3.v0(true);
                }
            });
        }
    }

    public class d implements ip1 {
        public final /* synthetic */ MainActivity a;

        public d(MoreInformationActivity moreInformationActivity, MainActivity mainActivity) {
            this.a = mainActivity;
        }

        @Override // dc.ip1
        public void G() {
            this.a.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            this.a.cancleDelay();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 150 && i2 == -1 && intent != null && intent.getStringExtra("moodMessage") != null) {
            String stringExtra = intent.getStringExtra("moodMessage");
            this.b = stringExtra;
            this.tvMoodMessage.setText(stringExtra);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView(R.layout.account_more_information);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        Account accountU = WearUtils.y.u();
        this.c = accountU;
        if (accountU == null) {
            finish();
            return;
        }
        this.a.clear();
        this.a.add(new FFBasicMsgBean("18-29", 1));
        this.a.add(new FFBasicMsgBean("30-39", 2));
        this.a.add(new FFBasicMsgBean("40-49", 3));
        this.a.add(new FFBasicMsgBean("50-59", 4));
        this.a.add(new FFBasicMsgBean("60+", 5));
        this.b = this.c.getMoodMessage();
        this.tvMoodMessage.setText(this.c.getMoodMessage());
        String age = this.c.getAge();
        if (WearUtils.e1(age) || !WearUtils.n1(age) || (i = Integer.parseInt(age) - 1) < 0 || i >= this.a.size()) {
            this.tvAge.setText("");
        } else {
            FFBasicMsgBean fFBasicMsgBean = this.a.get(i);
            this.d = fFBasicMsgBean;
            fFBasicMsgBean.setSelect(true);
            this.tvAge.setText(this.d.getKey());
        }
        this.ageLayout.setOnClickListener(new a());
        this.moodLayout.setOnClickListener(new b());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VCardChangeEvent vCardChangeEvent) {
        v4();
    }

    public final void u4(FFBasicMsgBean fFBasicMsgBean) {
        Account accountU = WearUtils.y.u();
        MainActivity mainActivity = MyApplication.M;
        if (mainActivity == null || mainActivity.isFinishing() || mainActivity.isDestroyed() || accountU == null) {
            return;
        }
        String age = accountU.getAge();
        String str = fFBasicMsgBean.getValue() + "";
        if (str.equals(age)) {
            return;
        }
        if (ep1.b().r(this, new gp1(new c(this, accountU, str), new d(this, mainActivity)))) {
            mainActivity.showDialog();
        }
    }

    public final void v4() {
        Account accountU = WearUtils.y.u();
        if (accountU != null) {
            this.c = accountU;
            this.tvMoodMessage.setText(accountU.getMoodMessage());
            String age = accountU.getAge();
            if (WearUtils.e1(age) || !WearUtils.n1(age)) {
                this.tvAge.setText("");
                return;
            }
            int i = Integer.parseInt(age) - 1;
            if (i < 0 || i >= this.a.size()) {
                this.tvAge.setText("");
                return;
            }
            FFBasicMsgBean fFBasicMsgBean = this.a.get(i);
            this.d = fFBasicMsgBean;
            fFBasicMsgBean.setSelect(true);
            this.tvAge.setText(this.d.getKey());
        }
    }
}
