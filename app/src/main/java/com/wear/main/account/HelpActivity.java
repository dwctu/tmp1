package com.wear.main.account;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.main.NetTestActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.cp2;
import dc.hf3;
import dc.jn3;
import dc.kn3;
import dc.me3;
import dc.mm2;
import dc.nd3;
import dc.pj3;
import dc.pn3;
import dc.sg3;
import dc.ue3;
import dc.vg3;
import dc.ye3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class HelpActivity extends BaseActivity implements cp2 {
    public View a;
    public mm2 b;
    public MyActionBar c;
    public RelativeLayout d;
    public RelativeLayout e;
    public TextView f;
    public EditText g;
    public TextView h;
    public View i;
    public pn3 j;
    public EditText l;
    public LinearLayout m;
    public int o;
    public long p;
    public boolean k = false;
    public int n = 0;

    public class a implements pn3.i {
        public a() {
        }

        @Override // dc.pn3.i
        public void a(int i) {
            if (HelpActivity.this.j.i() <= 0 && WearUtils.e1(HelpActivity.this.g.getText().toString())) {
                HelpActivity.this.f.setEnabled(false);
                return;
            }
            if (HelpActivity.this.j.j()) {
                HelpActivity.this.f.setEnabled(false);
            } else if (MyApplication.Z) {
                HelpActivity.this.f.setEnabled(HelpActivity.this.l.getText().length() > 0);
            } else {
                HelpActivity.this.f.setEnabled(true);
            }
        }

        @Override // dc.pn3.i
        public void b(String str, String str2) {
            if ((WearUtils.e1(str) && WearUtils.e1(str2)) || HelpActivity.this.k) {
                return;
            }
            HelpActivity.this.X4(str, str2);
        }

        @Override // dc.pn3.i
        public void c() {
            HelpActivity.B4(HelpActivity.this);
            System.out.println("currentUplodingIndex:" + HelpActivity.this.n);
            if (!hf3.d(HelpActivity.this)) {
                HelpActivity.this.s4();
            } else if (HelpActivity.this.n <= 2) {
                HelpActivity.this.j.l();
            } else {
                HelpActivity.this.s4();
            }
        }

        @Override // dc.pn3.i
        public void cancel() {
            HelpActivity.this.k = true;
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.length();
            if ((length < 1 || length > 300) && HelpActivity.this.j.i() <= 0) {
                HelpActivity.this.f.setEnabled(false);
            } else if (!MyApplication.Z || HelpActivity.this.l.getText().toString().length() > 0) {
                HelpActivity.this.f.setEnabled(true);
            } else {
                HelpActivity.this.f.setEnabled(false);
            }
            HelpActivity.this.h.setText(length + "/300");
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() < 1) {
                HelpActivity.this.f.setEnabled(false);
                return;
            }
            if (!MyApplication.Z) {
                HelpActivity.this.f.setEnabled(true);
            } else if (HelpActivity.this.g.getText().length() >= 0 || HelpActivity.this.j.i() > 0) {
                HelpActivity.this.f.setEnabled(true);
            } else {
                HelpActivity.this.f.setEnabled(false);
            }
        }
    }

    public class d implements Runnable {

        public class a implements kn3.d {
            public a(d dVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HelpActivity.this.j.g();
            kn3 kn3Var = new kn3((Context) HelpActivity.this, ah4.e(R.string.enquires_error_upload_notice), ah4.e(R.string.common_ok), false, false, (kn3.d) new a(this));
            kn3Var.show();
            kn3Var.s(R.drawable.pop_icon_warning);
            kn3Var.n();
        }
    }

    public class e extends HashMap {
        public final /* synthetic */ String val$finalContent;

        public e(String str) {
            this.val$finalContent = str;
            put("text", str);
            put("image", "" + HelpActivity.this.j.i());
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HelpActivity.this.i.setVisibility(8);
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
            RequestPermissionActivity.s4(HelpActivity.this);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ ArrayList b;

        public h(ArrayList arrayList, ArrayList arrayList2) {
            this.a = arrayList;
            this.b = arrayList2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            int iH = HelpActivity.this.j.h();
            if (Build.VERSION.SDK_INT >= 29 && (arrayList = this.a) != null && !arrayList.isEmpty()) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    HelpActivity.this.j.o(iH, WearUtils.m(HelpActivity.this.application, ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ((MediaFile) it.next()).e())));
                    iH++;
                }
                return;
            }
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str != null && !WearUtils.e1(str)) {
                    HelpActivity.this.j.o(iH, WearUtils.m(HelpActivity.this.application, Uri.fromFile(new File(str))));
                    iH++;
                }
            }
        }
    }

    public static /* synthetic */ int B4(HelpActivity helpActivity) {
        int i = helpActivity.n;
        helpActivity.n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J4(View view) {
        if (this.p != 0 && be3.r() - this.p > 500) {
            this.o = 0;
        }
        if (this.o == 0) {
            this.p = be3.r();
        }
        int i = this.o + 1;
        this.o = i;
        if (i == 3) {
            pj3.f(this, NetTestActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L4(View view) {
        pj3.f(this, FAQActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N4(View view) {
        if (!hf3.d(WearUtils.x)) {
            sg3.h(R.string.net_connect_error_tip);
            return;
        }
        String string = this.g.getText().toString();
        if (WearUtils.S0(string)) {
            sg3.i(this, R.string.input_string_error);
            return;
        }
        if (this.j.i() == 0 && (string.length() < 15 || string.length() > 300)) {
            sg3.i(this, R.string.help_feedback_content_error);
            return;
        }
        if (!MyApplication.Z || G4(true)) {
            ue3.a(this.g, this);
            if (WearUtils.e1(string)) {
                string = ah4.e(R.string.enquires_default_notice);
            }
            this.k = false;
            this.n = 0;
            this.j.y(string, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P4(View view) {
        pj3.f(this, UserGuidesActivity.class);
    }

    @Override // dc.cp2
    public void F3(boolean z, BaseResponseBean baseResponseBean, String str) {
        if (baseResponseBean == null || !baseResponseBean.isResult()) {
            if (baseResponseBean == null || WearUtils.e1(baseResponseBean.getMessage())) {
                return;
            }
            sg3.l(baseResponseBean.getMessage());
            return;
        }
        addAnalyticsEventId("feedback_success", new e(str));
        this.j.n();
        this.g.setText("");
        this.i.setVisibility(0);
        WearUtils.x.l.postDelayed(new f(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        jn3.a(this, ah4.e(R.string.help_feedback_send_success), Integer.valueOf(R.drawable.pop_icon_success));
    }

    public final boolean G4(boolean z) {
        String strTrim = this.l.getText().toString().trim();
        if (!WearUtils.e1(strTrim) && WearUtils.G2(strTrim)) {
            return true;
        }
        if (z) {
            sg3.i(this, R.string.system_email_error);
        }
        return false;
    }

    public final void H4() {
        this.c = (MyActionBar) findViewById(R.id.actionbar);
        this.i = findViewById(R.id.glass_layer);
        this.d = (RelativeLayout) findViewById(R.id.help_frequent_question);
        this.e = (RelativeLayout) findViewById(R.id.help_user_guide);
        TextView textView = (TextView) findViewById(R.id.submit_btn);
        this.f = textView;
        textView.setEnabled(false);
        this.l = (EditText) findViewById(R.id.edit_email);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.offline_email);
        this.m = linearLayout;
        linearLayout.setVisibility(MyApplication.Z ? 0 : 8);
        EditText editText = (EditText) findViewById(R.id.message_text);
        this.g = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(300)});
        TextView textView2 = (TextView) findViewById(R.id.message_text_number);
        this.h = textView2;
        textView2.setText("0/300");
        View viewFindViewById = findViewById(R.id.screan_root_layout);
        this.a = viewFindViewById;
        this.j = new pn3(this, viewFindViewById, findViewById(R.id.enquires_pics_1), findViewById(R.id.enquires_pics_2), new a());
    }

    public final void Q4() {
        this.c.getLabelStatus().setOnClickListener(new View.OnClickListener() { // from class: dc.mx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.J4(view);
            }
        });
    }

    public final void R4() {
        this.l.addTextChangedListener(new c());
    }

    public final void S4() {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: dc.nx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.L4(view);
            }
        });
    }

    public final void T4() {
        Q4();
        S4();
        W4();
        U4();
        R4();
        V4();
    }

    public final void U4() {
        this.g.addTextChangedListener(new b());
    }

    public final void V4() {
        this.f.setOnClickListener(new View.OnClickListener() { // from class: dc.ox1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.N4(view);
            }
        });
    }

    public final void W4() {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: dc.lx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.P4(view);
            }
        });
    }

    public void X4(String str, String str2) {
        String str3;
        String strE = ah4.e(R.string.common_anonymous);
        Account accountU = WearUtils.y.u();
        if (accountU != null) {
            strE = accountU.getUserName();
            WearUtils.g0(accountU.getUserJid());
        }
        HashMap map = new HashMap();
        map.put("name", strE);
        map.put(FirebaseAnalytics.Param.CONTENT, str);
        map.put("medias", str2);
        map.put("t", "5000158009");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("appType", "remote");
        map.put("version", WearUtils.q);
        if (MyApplication.Z) {
            map.put("email", this.l.getText().toString());
            map.put("pwd", nd3.w("remote_app_off_line"));
            str3 = "/sales/off-line/submit-enquires";
        } else {
            str3 = "/sales/submitEnquires";
        }
        this.b.h(false, str3, map, str);
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.d(this);
        this.mPresenter = this.b;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 16) {
            if (i2 == -1) {
                Uri data = this.j.k;
                if (intent != null && intent.getData() != null) {
                    data = intent.getData();
                }
                this.j.p(WearUtils.m(this.application, data));
                return;
            }
            return;
        }
        if (i == 17) {
            if (i2 != -1 || intent == null || intent.getData() == null) {
                return;
            }
            Uri data2 = intent.getData();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inSampleSize = 2;
                options.inJustDecodeBounds = false;
                this.j.p(BitmapFactory.decodeStream(getContentResolver().openInputStream(data2), null, options));
                return;
            } catch (FileNotFoundException unused) {
                return;
            }
        }
        if (i == 888) {
            if (i2 == -1) {
                boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                intent.getIntArrayExtra("grant_results");
                if (booleanExtra) {
                    this.j.m();
                    return;
                } else {
                    new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new g()).show();
                    return;
                }
            }
            return;
        }
        if (i == 9097 && i2 == -1 && intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selectItems");
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectMediaFile");
            if (stringArrayListExtra != null) {
                int iH = this.j.h();
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    this.j.u(iH + i3);
                }
                this.f.setEnabled(false);
                vg3.b().a(new h(parcelableArrayListExtra, stringArrayListExtra));
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_help);
        me3.c(me3.c.ME_HELP_UI_ENTER);
        ye3.c("help", "into page", null);
        EventBus.getDefault().register(this);
        setCurrentScreen(this, "setting_helpe_screen_view", HelpActivity.class.getSimpleName());
        H4();
        T4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.ME_HELP_UI_EXIT);
        EventBus.getDefault().unregister(this);
        WearUtils.Q1(WearUtils.b0().getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        this.j.g();
        if (hf3.d(WearUtils.x)) {
            return;
        }
        sg3.h(R.string.net_connect_error_tip);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.g, this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void s4() {
        runOnUiThread(new d());
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        sg3.l(str);
    }
}
