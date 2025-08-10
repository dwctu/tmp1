package com.wear.main.longDistance.controllink;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.ToyActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.db2;
import dc.hf3;
import dc.kg3;
import dc.kn3;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.ue3;
import dc.un3;
import dc.y12;
import java.util.HashMap;
import java.util.Iterator;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ControlLinkActivity extends BaseActivity implements View.OnClickListener {
    public String a = "";

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.bt_create_control_link)
    public Button btCreateControlLink;

    @BindView(R.id.et_control_times)
    public EditText etControlTimes;

    @BindView(R.id.layout_contro_message)
    public LinearLayout layoutControMessage;

    @BindView(R.id.rl_times_untis)
    public RelativeLayout rlTimesUntis;

    @BindView(R.id.rl_toys_untis)
    public RelativeLayout rlToysUntis;

    @BindView(R.id.tv_times_untis)
    public TextView tvTimesUntis;

    @BindView(R.id.tv_toys_untis)
    public TextView tvToysUntis;

    public class a implements un3.b {
        public a() {
        }

        @Override // dc.un3.b
        public void a(int i) {
            ControlLinkActivity.this.tvTimesUntis.setText(ah4.e(R.string.link_notice_times_seconds));
            String string = ControlLinkActivity.this.etControlTimes.getText().toString();
            if (WearUtils.e1(string)) {
                string = "0";
            }
            ControlLinkActivity.this.etControlTimes.setText(string);
            EditText editText = ControlLinkActivity.this.etControlTimes;
            editText.setSelection(editText.length());
        }
    }

    public class b implements un3.b {
        public b() {
        }

        @Override // dc.un3.b
        public void a(int i) {
            ControlLinkActivity.this.tvTimesUntis.setText(ah4.e(R.string.link_notice_times_minutes));
            String string = ControlLinkActivity.this.etControlTimes.getText().toString();
            if (WearUtils.e1(string)) {
                string = "0";
            }
            ControlLinkActivity.this.etControlTimes.setText(string);
            EditText editText = ControlLinkActivity.this.etControlTimes;
            editText.setSelection(editText.length());
        }
    }

    public class c implements un3.c {
        public c(ControlLinkActivity controlLinkActivity) {
        }

        @Override // dc.un3.c
        public void a(View view) {
            view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_up);
        }

        @Override // dc.un3.c
        public void b(View view) {
            view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_down);
        }
    }

    public class d implements MyActionBar.f {
        public d() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(ControlLinkActivity.this, ToyActivity.class);
        }
    }

    public class e implements MyActionBar.f {
        public e() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ControlLinkActivity.this.finish();
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!editable.toString().startsWith("0") || editable.toString().length() <= 1) {
                return;
            }
            ControlLinkActivity.this.etControlTimes.setText(editable.toString().substring(1));
            EditText editText = ControlLinkActivity.this.etControlTimes;
            editText.setSelection(editText.getText().length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ControlLinkActivity.this.x4(true);
        }
    }

    public class g implements View.OnFocusChangeListener {
        public g() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            EditText editText;
            if (z || (editText = ControlLinkActivity.this.etControlTimes) == null || !WearUtils.e1(editText.getText().toString())) {
                return;
            }
            ControlLinkActivity.this.etControlTimes.setText("0");
            EditText editText2 = ControlLinkActivity.this.etControlTimes;
            editText2.setSelection(editText2.getText().length());
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkActivity.this.y4(view);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.x.G().P().size() > 0) {
                pj3.q(ControlLinkActivity.this, MulChooseToysActivity.class, 909, "choose_toys_keys_split", db2.A().e);
            } else {
                sg3.h(R.string.toy_empty_connected_notice);
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkActivity controlLinkActivity = ControlLinkActivity.this;
            ue3.a(controlLinkActivity.etControlTimes, controlLinkActivity);
        }
    }

    public class k implements db2.s {

        public class a extends HashMap<String, String> {
            public final /* synthetic */ String val$finalTimes;

            public a(String str) {
                this.val$finalTimes = str;
                put("time", "" + str);
                put("toy", ControlLinkActivity.this.a);
            }
        }

        public class b implements kn3.d {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ int b;
            public final /* synthetic */ String c;

            public b(boolean z, int i, String str) {
                this.a = z;
                this.b = i;
                this.c = str;
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                MusicControl.h0().S();
                y12.c.a().t();
                db2.A().P();
                db2.A().r();
                db2.A().u(ControlLinkActivity.this.a, this.a, this.b, this.c);
            }
        }

        public k() {
        }

        @Override // dc.db2.s
        public void a() {
            db2.A().x = "";
            int iIntValue = 0;
            String strSubstring = "";
            boolean z = false;
            boolean z2 = false;
            for (String str : ControlLinkActivity.this.a.split(",")) {
                Toy toyR = WearUtils.x.G().R(str);
                if (toyR != null) {
                    if (toyR.isSupportLdr()) {
                        z2 = true;
                    }
                    if (WearUtils.x.G().a(toyR.getAddress())) {
                        z = true;
                    }
                    strSubstring = strSubstring + toyR.getName().toLowerCase() + ",";
                    StringBuilder sb = new StringBuilder();
                    db2 db2VarA = db2.A();
                    sb.append(db2VarA.x);
                    sb.append(toyR.getType().toLowerCase());
                    sb.append(SignatureImpl.INNER_SEP);
                    sb.append(str);
                    sb.append(",");
                    db2VarA.x = sb.toString();
                }
            }
            if (z) {
                if (!hf3.d(ControlLinkActivity.this)) {
                    sg3.l(ah4.e(R.string.common_settingTip));
                    return;
                }
                if (!WearUtils.e1(strSubstring) && strSubstring.endsWith(",")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                    db2.A().x = db2.A().x.substring(0, db2.A().x.length() - 1);
                }
                String string = ControlLinkActivity.this.etControlTimes.getText().toString();
                if (WearUtils.e1(string)) {
                    string = "0";
                }
                if (ControlLinkActivity.this.tvTimesUntis.getText().toString().equals(ah4.e(R.string.link_notice_times_seconds))) {
                    iIntValue = Integer.valueOf(string).intValue();
                } else if (ControlLinkActivity.this.tvTimesUntis.getText().toString().equals(ah4.e(R.string.link_notice_times_minutes))) {
                    iIntValue = Integer.valueOf(string).intValue() * 60;
                }
                db2.A().w = "";
                ControlLinkActivity.this.addAnalyticsEventId("controlLink_create", new a("" + iIntValue));
                if (ControlLinkActivity.this.layoutControMessage.getChildCount() > 0) {
                    kn3 kn3Var = new kn3((Context) ControlLinkActivity.this, ah4.e(R.string.link_end_control_notice), ah4.e(R.string.common_generate), ah4.e(R.string.common_cancel), true, (kn3.d) new b(z2, iIntValue, strSubstring));
                    kn3Var.show();
                    kn3Var.p();
                } else {
                    MusicControl.h0().S();
                    y12.c.a().t();
                    db2.A().P();
                    db2.A().r();
                    db2.A().u(ControlLinkActivity.this.a, z2, iIntValue, strSubstring);
                }
            }
        }
    }

    public static class l {
        public l(String str, String str2, String str3) {
        }
    }

    public static class m {
    }

    public final void A4() {
        this.btCreateControlLink.setAlpha(1.0f);
        this.btCreateControlLink.setEnabled(true);
        if (db2.A().C() && this.layoutControMessage.getVisibility() != 0) {
            db2.A().J();
        }
        if (WearUtils.e1(this.etControlTimes.getText().toString())) {
            return;
        }
        EditText editText = this.etControlTimes;
        editText.setSelection(editText.length());
    }

    public final void B4() {
        String strSubstring;
        strSubstring = "";
        if (WearUtils.e1(db2.A().e)) {
            this.a = "";
            this.tvToysUntis.setText(ah4.e(R.string.choose_toys_title));
        } else {
            String[] strArrSplit = db2.A().e.split(",");
            if (strArrSplit.length > 1) {
                String strSubstring2 = "";
                int i2 = 0;
                for (String str : strArrSplit) {
                    Toy toyR = WearUtils.x.G().R(str);
                    if (i2 == 2) {
                        break;
                    }
                    if (toyR.isConnected()) {
                        strSubstring = strSubstring + toyR.getName() + ",";
                        strSubstring2 = strSubstring2 + toyR.getAndUpdateDeviceId() + ",";
                        i2++;
                    }
                }
                if (strSubstring.endsWith(",")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                if (strSubstring2.endsWith(",")) {
                    strSubstring2 = strSubstring2.substring(0, strSubstring2.length() - 1);
                }
                this.a = strSubstring2;
                this.tvToysUntis.setText(strSubstring);
            } else {
                Toy toyR2 = WearUtils.x.G().R(strArrSplit[0]);
                if (toyR2 == null) {
                    db2.A().e = "";
                    this.a = "";
                    this.tvToysUntis.setText(ah4.e(R.string.choose_toys_title));
                } else {
                    String str2 = WearUtils.e1(toyR2.getDefineRename()) ? "" : " (" + toyR2.getDefineRename() + ")";
                    this.a = WearUtils.e1(toyR2.getAndUpdateDeviceId()) ? "" : toyR2.getAndUpdateDeviceId();
                    this.tvToysUntis.setText(toyR2.getName() + str2);
                }
            }
        }
        A4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 909 && i3 == -1 && intent != null) {
            db2.A().e = intent.getStringExtra("choose_toys_keys_split");
            A4();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.bt_create_control_link) {
            return;
        }
        if (WearUtils.x.G().o().size() == 0) {
            sg3.h(R.string.lan_api_connect_toy_first);
            return;
        }
        if (WearUtils.x.G().P().size() == 0) {
            sg3.h(R.string.controllink_notoy_text);
            return;
        }
        if (WearUtils.e1(this.a)) {
            sg3.h(R.string.controllink_choose_text);
            return;
        }
        if (!w4()) {
            finish();
        } else if (x4(false)) {
            pj3.f(this, CreateControlLinkActivity.class);
            db2.A().p(new k());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_control_link);
        ButterKnife.bind(this);
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.actionbar.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground));
        db2.A().Q(this, this.layoutControMessage);
        this.actionbar.setToysAction(new d(), true, this);
        this.actionbar.n();
        this.actionbar.setBackAction(new e());
        this.btCreateControlLink.setEnabled(true);
        this.btCreateControlLink.setOnClickListener(this);
        this.etControlTimes.addTextChangedListener(new f());
        this.etControlTimes.setOnFocusChangeListener(new g());
        this.rlTimesUntis.setOnClickListener(new h());
        this.rlToysUntis.setOnClickListener(new i());
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new m());
        db2.A().J();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.actionbar.s();
        db2.A().Q(null, null);
        EventBus.getDefault().unregister(this);
        ue3.a(this.etControlTimes, this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public synchronized void onMessageEvent(m mVar) {
        Toy toyN = WearUtils.x.G().N();
        String address = toyN == null ? "" : toyN.getAddress();
        Iterator<Toy> it = WearUtils.x.G().o().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (address.contains(next.getAddress())) {
                WearUtils.x.G().a(next.getAddress());
            }
        }
        A4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new j(), 100L);
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        db2.A().E();
        B4();
    }

    public final boolean w4() {
        if (WearUtils.y.r() != null) {
            return true;
        }
        Intent intent = new Intent(this.application, (Class<?>) LoginActivity.class);
        pj3.d(intent);
        intent.addFlags(268468224);
        this.application.startActivity(intent);
        try {
            finish();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean x4(boolean z) {
        String string = this.etControlTimes.getText().toString();
        if (this.tvTimesUntis.getText().toString().equals(ah4.e(R.string.link_notice_times_minutes))) {
            if (!WearUtils.e1(string) && Integer.valueOf(string).intValue() > 60) {
                if (z) {
                    this.etControlTimes.setText("60");
                    EditText editText = this.etControlTimes;
                    editText.setSelection(editText.getText().length());
                }
                db2.A().a(ah4.e(R.string.link_overtime_minutes));
            }
        } else if (this.tvTimesUntis.getText().toString().equals(ah4.e(R.string.link_notice_times_seconds)) && !WearUtils.e1(string) && Integer.valueOf(string).intValue() > 120) {
            if (z) {
                this.etControlTimes.setText("120");
                EditText editText2 = this.etControlTimes;
                editText2.setSelection(editText2.getText().length());
            }
            db2.A().a(ah4.e(R.string.link_overtime_seconds));
        }
        return true;
    }

    public final void y4(View view) {
        un3 un3Var = new un3(this);
        un3Var.b(ah4.e(R.string.link_notice_times_seconds), true, true, new a());
        un3Var.b(ah4.e(R.string.link_notice_times_minutes), false, true, new b());
        StringBuilder sb = new StringBuilder();
        sb.append("showSheetDialogTimes:手机型号 ");
        String str = Build.BRAND;
        sb.append(str);
        sb.toString();
        un3Var.c(view, 220, str.equals("OnePlus") ? -1 : -18, new c(this));
        un3Var.show();
    }

    public void z4() {
        addAnalyticsEventId("contolLink_open", null);
    }
}
