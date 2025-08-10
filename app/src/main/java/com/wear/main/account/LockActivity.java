package com.wear.main.account;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.bean.event.LanguageEvent;
import com.wear.main.account.finger.FingerAuthCallback;
import com.wear.main.account.login.LoginActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cs3;
import dc.cy1;
import dc.eg3;
import dc.hu3;
import dc.is3;
import dc.lg3;
import dc.sg3;
import dc.vg3;
import java.util.concurrent.Executor;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class LockActivity extends FragmentActivity {
    public MyApplication a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;
    public hu3 b;

    @BindView(R.id.password1)
    public EditText edPassword1;

    @BindView(R.id.password2)
    public EditText edPassword2;

    @BindView(R.id.password3)
    public EditText edPassword3;

    @BindView(R.id.password4)
    public EditText edPassword4;
    public int j;

    @BindView(R.id.notice_forgot_btn)
    public TextView noticeForgotBtn;

    @BindView(R.id.passwordfild)
    public LinearLayout passwordfild;

    @BindView(R.id.point1)
    public ImageView point1;

    @BindView(R.id.point2)
    public ImageView point2;

    @BindView(R.id.point3)
    public ImageView point3;

    @BindView(R.id.point4)
    public ImageView point4;

    @BindView(R.id.relativeLayout1)
    public RelativeLayout relativeLayout1;

    @BindView(R.id.start_finger)
    public ImageView startFinger;

    @BindView(R.id.tip)
    public TextView tip;
    public boolean c = true;
    public int d = 0;
    public String e = "";
    public Handler f = null;
    public FingerprintManagerCompat g = null;
    public FingerAuthCallback h = null;
    public CancellationSignal i = null;
    public Executor k = new d();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    LockActivity.this.a.n = false;
                    LockActivity.this.i = null;
                    EventBus.getDefault().post(Boolean.TRUE);
                    LockActivity.this.finish();
                    break;
                case 101:
                    LockActivity.this.H4();
                    LockActivity.this.i = null;
                    System.out.println("finger.failed");
                    break;
                case 102:
                    System.out.println("finger.error");
                    break;
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sg3.i(LockActivity.this, R.string.fingerprint_hint);
            LockActivity.this.H4();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LockActivity.this.H4();
        }
    }

    public class d implements Executor {
        public d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            LockActivity.this.f.post(runnable);
        }
    }

    public class e extends BiometricPrompt.AuthenticationCallback {
        public e() {
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int i, @NonNull CharSequence charSequence) {
            super.onAuthenticationError(i, charSequence);
            if (LockActivity.this.f != null) {
                LockActivity.this.f.obtainMessage(102, i, 0).sendToTarget();
            }
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            if (LockActivity.this.f != null) {
                LockActivity.this.f.obtainMessage(101).sendToTarget();
            }
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult authenticationResult) {
            super.onAuthenticationSucceeded(authenticationResult);
            if (LockActivity.this.f != null) {
                LockActivity.this.f.obtainMessage(100).sendToTarget();
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cy1 cy1Var = new cy1();
                if (LockActivity.this.i == null) {
                    LockActivity.this.i = new CancellationSignal();
                }
                LockActivity.this.g.authenticate(cy1Var.c(), 0, LockActivity.this.i, LockActivity.this.h, null);
            } catch (Exception e) {
                LockActivity.this.startFinger.setVisibility(8);
                e.printStackTrace();
            }
        }
    }

    public class g implements View.OnClickListener {

        public class a implements is3.d {

            /* renamed from: com.wear.main.account.LockActivity$g$a$a, reason: collision with other inner class name */
            public class RunnableC0086a implements Runnable {
                public RunnableC0086a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (LockActivity.this.b != null) {
                        LockActivity.this.b.w(true);
                    }
                    WearUtils.y.V(null);
                }
            }

            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                hu3.R(LockActivity.this);
                vg3.b().a(new RunnableC0086a());
                eg3.m(LockActivity.this, "xmpp_password");
                Intent intent = new Intent(LockActivity.this.a, (Class<?>) LoginActivity.class);
                intent.putExtra("isChange", 1);
                intent.addFlags(268468224);
                LockActivity.this.a.startActivity(intent);
                try {
                    MyApplication unused = LockActivity.this.a;
                    MyApplication.D();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public class b implements is3.c {
            public b(g gVar) {
            }

            @Override // dc.is3.c
            public void doCancel() {
            }
        }

        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            cs3.d(LockActivity.this, ah4.e(R.string.forgot_lock_passcode), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new a(), new b(this)).show();
        }
    }

    public class h implements Animation.AnimationListener {
        public h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LockActivity lockActivity = LockActivity.this;
            if (lockActivity.c) {
                lockActivity.E4(ah4.e(R.string.setting_passcode_tip));
            } else {
                lockActivity.E4(ah4.e(R.string.setting_passcode_not_match_tip_lock));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public final void A4() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.passcode_error_anim);
        this.passwordfild.startAnimation(animationLoadAnimation);
        if (this.c) {
            this.tip.setText(ah4.e(R.string.setting_passcode_not_match_tip));
        } else {
            this.tip.setText(ah4.e(R.string.setting_passcode_not_match_tip_lock));
        }
        animationLoadAnimation.setAnimationListener(new h());
    }

    public final void B4() {
        this.f = new a();
        if (D4()) {
            int iCanAuthenticate = BiometricManager.from(this).canAuthenticate(255);
            if (iCanAuthenticate == -2 || iCanAuthenticate == -1 || iCanAuthenticate == 1 || iCanAuthenticate == 15 || iCanAuthenticate == 11 || iCanAuthenticate == 12) {
                return;
            }
            G4();
            return;
        }
        FingerprintManagerCompat fingerprintManagerCompatFrom = FingerprintManagerCompat.from(this);
        this.g = fingerprintManagerCompatFrom;
        if (fingerprintManagerCompatFrom.isHardwareDetected() && this.g.hasEnrolledFingerprints()) {
            try {
                this.h = new FingerAuthCallback(this.f);
                this.startFinger.setVisibility(8);
                this.startFinger.setOnClickListener(new b());
                this.f.postDelayed(new c(), 1500L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void C4() {
        this.tip.setText(ah4.e(R.string.setting_passcode_tip));
        this.noticeForgotBtn.setOnClickListener(new g());
        if (this.c) {
            this.noticeForgotBtn.setVisibility(8);
        } else {
            this.actionBar.setImageBackBtnVisibility(8);
            this.noticeForgotBtn.setVisibility(0);
        }
    }

    public final boolean D4() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public final void E4(String str) {
        this.tip.setText(str);
        this.edPassword4.setText("");
        this.edPassword3.setText("");
        this.edPassword2.setText("");
        this.edPassword1.setText("");
        z4(0);
    }

    public final void F4(String str) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(this.edPassword1.getText())) {
            this.edPassword1.setText(str);
            z4(1);
            return;
        }
        if (TextUtils.isEmpty(this.edPassword2.getText())) {
            this.edPassword2.setText(str);
            z4(2);
        } else if (TextUtils.isEmpty(this.edPassword3.getText())) {
            this.edPassword3.setText(str);
            z4(3);
        } else if (TextUtils.isEmpty(this.edPassword4.getText())) {
            this.edPassword4.setText(str);
            z4(4);
            I4();
        }
    }

    public final void G4() {
        new BiometricPrompt(this, this.k, new e()).authenticate(new BiometricPrompt.PromptInfo.Builder().setTitle(ah4.e(R.string.lock_biometric_recognition)).setSubtitle(ah4.e(R.string.lock_use_biometric_credential)).setNegativeButtonText(ah4.e(R.string.common_cancel)).build());
    }

    public final void H4() {
        runOnUiThread(new f());
    }

    public void I4() throws Resources.NotFoundException {
        String str = this.edPassword1.getText().toString() + this.edPassword2.getText().toString() + this.edPassword3.getText().toString() + this.edPassword4.getText().toString();
        System.out.println(str + "");
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return;
        }
        if (!this.c) {
            if (!str.equals(eg3.h(this, "passcode_code_key", ""))) {
                A4();
                return;
            }
            this.a.n = false;
            EventBus.getDefault().post(Boolean.TRUE);
            finish();
            return;
        }
        if (this.d == 1) {
            if (str.equals(this.e)) {
                eg3.i(this, "passcode_code_key", str);
                finish();
            } else {
                A4();
                if (this.c) {
                    this.d = 0;
                    return;
                }
            }
        }
        int i = this.d;
        if (i == 0) {
            this.e = str;
            this.d = i + 1;
            E4(ah4.e(R.string.setting_passcode_reenter_tip));
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(lg3.h(context));
    }

    public void del(View view) {
        if (!TextUtils.isEmpty(this.edPassword4.getText())) {
            this.edPassword4.setText("");
            z4(3);
            return;
        }
        if (!TextUtils.isEmpty(this.edPassword3.getText())) {
            this.edPassword3.setText("");
            z4(2);
        } else if (!TextUtils.isEmpty(this.edPassword2.getText())) {
            this.edPassword2.setText("");
            z4(1);
        } else {
            if (TextUtils.isEmpty(this.edPassword1.getText())) {
                return;
            }
            this.edPassword1.setText("");
            z4(0);
        }
    }

    public void enterNumber(View view) throws Resources.NotFoundException {
        F4(((Button) view).getText().toString());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_setting_lock);
        ButterKnife.bind(this);
        this.a = (MyApplication) getApplication();
        this.b = hu3.z(this);
        this.j = getIntent().getIntExtra("isChange", 0);
        this.actionBar.setTitle(ah4.e(R.string.lock_enter_title));
        this.c = getIntent().getIntExtra("open_passcode_lock", 1) > 0;
        this.d = 0;
        C4();
        if (Build.VERSION.SDK_INT >= 23 && this.j != 1 && eg3.a(this, "passcode_code_key")) {
            B4();
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CancellationSignal cancellationSignal = this.i;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LanguageEvent languageEvent) {
        recreate();
    }

    public final void z4(int i) {
        if (i == 0) {
            this.point1.setVisibility(8);
            this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_sel_new);
            this.point2.setVisibility(8);
            this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point3.setVisibility(8);
            this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point4.setVisibility(8);
            this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            return;
        }
        if (i == 1) {
            this.point1.setVisibility(0);
            this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point2.setVisibility(8);
            this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_sel_new);
            this.point3.setVisibility(8);
            this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point4.setVisibility(8);
            this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            return;
        }
        if (i == 2) {
            this.point2.setVisibility(0);
            this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point1.setVisibility(0);
            this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point3.setVisibility(8);
            this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_sel_new);
            this.point4.setVisibility(8);
            this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            return;
        }
        if (i == 3) {
            this.point3.setVisibility(0);
            this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point1.setVisibility(0);
            this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point2.setVisibility(0);
            this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
            this.point4.setVisibility(8);
            this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_sel_new);
            return;
        }
        if (i != 4) {
            return;
        }
        this.point4.setVisibility(0);
        this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
        this.point1.setVisibility(0);
        this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
        this.point2.setVisibility(0);
        this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
        this.point3.setVisibility(0);
        this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar_new);
    }
}
