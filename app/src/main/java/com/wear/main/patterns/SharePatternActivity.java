package com.wear.main.patterns;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.Pattern;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.event.NewYearPatternShareEvent;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.hf3;
import dc.kn3;
import dc.rf3;
import dc.sg3;
import dc.tn2;
import dc.uu1;
import dc.vl2;
import dc.xe2;
import dc.xe3;
import dc.ye3;
import dc.zn2;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class SharePatternActivity extends BaseActivity<vl2> {
    public EditText a;
    public ImageView b;
    public EditText c;
    public TextView d;
    public SwitchView e;
    public ProgressDialog f;
    public Pattern g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l = false;
    public int m = 0;
    public String n;
    public String o;
    public String p;
    public String q;

    public class a extends HashMap<String, String> {
        public a() {
            put("type", SharePatternActivity.this.i);
            put("time", "10");
        }
    }

    public class b implements zn2<String> {
        public final /* synthetic */ Account a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public class a implements kn3.d {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                SharePatternActivity.this.C4(this.a);
            }
        }

        public b(Account account, String str, String str2) {
            this.a = account;
            this.b = str;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(String str) {
            if (SharePatternActivity.this.isDestroyed() || SharePatternActivity.this.isFinishing()) {
                return;
            }
            rf3.p(SharePatternActivity.this, new a(str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(NormalResponse normalResponse) {
            if (SharePatternActivity.this.isDestroyed()) {
                return;
            }
            rf3.q(SharePatternActivity.this, normalResponse.getMessage());
        }

        @Override // dc.zn2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                SharePatternActivity.this.f.dismiss();
                sg3.i(SharePatternActivity.this, R.string.system_upload_error);
            } else {
                xe3.d();
                final NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
                SharePatternActivity.this.f.dismiss();
                if (normalResponse.isResult()) {
                    SharePatternActivity.this.O4(this.a, this.b, this.c);
                    SharePatternActivity sharePatternActivity = SharePatternActivity.this;
                    final String str2 = this.b;
                    sharePatternActivity.runOnMainThread(new Runnable() { // from class: dc.ne2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.c(str2);
                        }
                    });
                } else {
                    SharePatternActivity.this.f.dismiss();
                    SharePatternActivity.this.runOnMainThread(new Runnable() { // from class: dc.me2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.e(normalResponse);
                        }
                    });
                }
            }
            HashMap map = new HashMap();
            map.put("type", 1);
            ye3.d("M0035", WearUtils.A.toJson(map));
            SharePatternActivity.this.finish();
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            SharePatternActivity.this.f.dismiss();
            sg3.k(SharePatternActivity.this, netException.getMessage());
        }
    }

    public class c implements kn3.d {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            SharePatternActivity.this.C4(this.a);
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        @SuppressLint({"SetTextI18n"})
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.length();
            SharePatternActivity.this.d.setText(length + "/" + CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SharePatternActivity.this.b.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G4(View view) {
        this.a.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I4(View view) {
        B4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K4(String str, String str2) {
        if (!str.equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
            C4(str2);
        } else {
            if (isDestroyed() || isFinishing()) {
                return;
            }
            rf3.p(this, new c(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M4(Account account, final String str, String str2, boolean z, final String str3) {
        this.f.dismiss();
        if (z) {
            addAnalyticsEventId("editSharePattern", null);
            O4(account, str, str2);
            runOnMainThread(new Runnable() { // from class: dc.qe2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.K4(str3, str);
                }
            });
        }
    }

    public final void A4(Account account, String str, String str2) {
        Pattern pattern = new Pattern(this.h);
        this.g = pattern;
        pattern.setName(str);
        Pattern pattern2 = this.g;
        if (WearUtils.e1(str2)) {
            str2 = "";
        }
        pattern2.setText(str2);
        this.g.setEmail(account.getId());
        this.g.setCreator(account.getId());
        this.g.setAuthor(account.getUserName());
        this.g.setTimer(this.j);
        this.g.setShared(false);
        this.g.setToySymbol(this.p);
        this.g.setToyName(this.o);
        this.g.setToyVersion(this.q);
        if (WearUtils.e1(this.n)) {
            return;
        }
        this.g.setToyFeature(this.n);
    }

    public final void B4() {
        if (MyApplication.Z) {
            sg3.i(this, R.string.common_login_first);
            return;
        }
        if (!hf3.d(this)) {
            sg3.i(this, R.string.net_connect_error_tip);
            return;
        }
        Account accountU = WearUtils.y.u();
        String strTrim = this.a.getText().toString().trim();
        String string = this.c.getText().toString();
        if (!WearUtils.o1(strTrim)) {
            sg3.k(this, WearUtils.l0(this, strTrim));
            return;
        }
        if (WearUtils.S0(string)) {
            sg3.i(this, R.string.input_string_error);
            return;
        }
        if (WearUtils.e1(this.h) || rf3.c(this.h)) {
            addAnalyticsEventId("pattern_local_share", new a());
            this.f = ProgressDialog.show(this, "", ah4.e(R.string.common_uploading), false, true);
            if (this.g != null || WearUtils.e1(this.h)) {
                this.j = this.g.getTimer();
            } else {
                A4(accountU, strTrim, string);
                xe2.L0().t(this.g, true);
            }
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, this.h);
            map.put("timer", this.j);
            map.put("name", WearUtils.B(strTrim));
            map.put("text", WearUtils.B(string));
            if (this.m == 1) {
                map.put("type", "newYears");
            }
            if (!this.e.isChecked()) {
                map.put("author", accountU.getUserName());
            }
            map.put("toyTag", this.i);
            map.put("toyName", this.o);
            map.put("toySymbol", this.p);
            map.put("toyVersion", String.valueOf(this.q));
            if (!WearUtils.e1(this.n)) {
                map.put("toyFeature", this.n);
            }
            if (this.g.isShared()) {
                N4(accountU, strTrim, string);
            } else {
                P4(accountU, strTrim, string, map);
            }
            HashMap map2 = new HashMap();
            map2.put("type", 1);
            ye3.d("M0035", WearUtils.A.toJson(map2));
        }
    }

    public final void C4(String str) {
        Intent intent = new Intent();
        intent.putExtra("requestCode", 48);
        intent.putExtra("name", str);
        intent.putExtra("author", this.k);
        setResult(-1, intent);
        if (this.m == 1) {
            EventBus.getDefault().post(new NewYearPatternShareEvent());
        }
        finish();
    }

    public final void D4() {
        Intent intent = getIntent();
        this.h = intent.getStringExtra("patternId");
        this.l = intent.getBooleanExtra("isUpdate", false);
        this.m = intent.getIntExtra("into_type", 0);
        this.n = intent.getStringExtra("toyFeature");
        this.o = intent.getStringExtra("toyName");
        this.p = intent.getStringExtra("toySymbol");
        this.q = intent.getStringExtra("toyVersion");
    }

    public final void N4(final Account account, final String str, final String str2) {
        rf3.n(this.h, str, str2, this.e.isChecked() ? "1" : "0", new rf3.h() { // from class: dc.re2
            @Override // dc.rf3.h
            public final void a(boolean z, String str3) {
                this.a.M4(account, str, str2, z, str3);
            }
        });
    }

    public final void O4(Account account, String str, String str2) {
        if (WearUtils.e1(this.h)) {
            return;
        }
        this.g.setShared(true);
        this.g.setName(str);
        Pattern pattern = this.g;
        if (WearUtils.e1(str2)) {
            str2 = "";
        }
        pattern.setText(str2);
        this.g.setAuthor(account.getUserName());
        this.g.setAnony(this.e.isChecked());
        this.g.setLastUpdTime(System.currentTimeMillis());
        xe2.L0().E(this.g, true);
    }

    public final void P4(Account account, String str, String str2, Map<String, String> map) {
        tn2.x(WearUtils.x).A("/wear/pattern/add", WearUtils.x0(this.h), map, new b(account, str, str2));
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        boolean z;
        super.onCreate(bundle);
        setContentView(R.layout.discover_share_pattern);
        D4();
        if (!WearUtils.e1(this.h)) {
            this.g = xe2.L0().K(this.h);
        }
        Pattern pattern = this.g;
        if (pattern == null) {
            finish();
            return;
        }
        this.j = pattern.getTimer();
        String name = this.g.getName();
        String text = this.g.getText();
        WearUtils.e1(text);
        this.k = this.g.getAuthor();
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.a = (EditText) findViewById(R.id.pattern_name);
        this.b = (ImageView) findViewById(R.id.iv_clear);
        this.c = (EditText) findViewById(R.id.pattern_text);
        this.d = (TextView) findViewById(R.id.pattern_text_number);
        this.e = (SwitchView) findViewById(R.id.pattern_anonymous);
        View viewFindViewById = findViewById(R.id.new_year_bg);
        if (this.g != null) {
            if (WearUtils.e1(name)) {
                name = this.g.getName();
            }
            this.i = uu1.b(this.p) ? "t" : this.g.getToyFunc();
        }
        boolean z2 = false;
        if (this.m == 1) {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: dc.oe2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    sg3.l(ah4.e(R.string.forbid_share_anonymous));
                }
            });
        } else {
            viewFindViewById.setVisibility(8);
        }
        y4();
        this.a.setText(name);
        EditText editText = this.a;
        editText.setSelection(editText.getText().length());
        this.c.setText(text);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: dc.se2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G4(view);
            }
        });
        this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA)});
        TextView textView = this.d;
        if (WearUtils.e1(text)) {
            str = "0";
        } else {
            str = text.length() + "/" + CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA;
        }
        textView.setText(str);
        z4();
        if (this.g.isShared()) {
            z = !this.g.isDownload();
            if (this.g.getCreator().equals(WearUtils.y.r())) {
                z = true;
            }
        } else {
            z = false;
        }
        if (z) {
            SwitchView switchView = this.e;
            if (this.l && WearUtils.e1(this.k)) {
                z2 = true;
            }
            switchView.setChecked(z2);
            if (this.g.isAnony() || WearUtils.e1(this.k)) {
                this.e.setCheckedImmediatelyNoEvent(true);
            }
        } else {
            this.e.setCheckedImmediatelyNoEvent(false);
        }
        myActionBar.setYesAction(R.string.common_done, new MyActionBar.f() { // from class: dc.pe2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.I4(view);
            }
        });
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        rf3.e();
        EventBus.getDefault().unregister(this);
    }

    public final void y4() {
        this.a.addTextChangedListener(new e());
    }

    public final void z4() {
        this.c.addTextChangedListener(new d());
    }
}
