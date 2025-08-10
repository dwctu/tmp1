package com.wear.main.toy.pin;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.ExoPlayer;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.a20;
import dc.ah4;
import dc.as1;
import dc.b20;
import dc.qg3;
import dc.xb1;
import dc.y10;
import dc.ye3;
import dc.zr1;
import java.util.HashMap;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes3.dex */
public class ToyPinSetCodeActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String c;
    public Toy d;

    @BindView(R.id.password1)
    public EditText edPassword1;

    @BindView(R.id.password2)
    public EditText edPassword2;

    @BindView(R.id.password3)
    public EditText edPassword3;

    @BindView(R.id.password4)
    public EditText edPassword4;

    @BindView(R.id.password5)
    public EditText edPassword5;

    @BindView(R.id.password6)
    public EditText edPassword6;

    @BindView(R.id.error_tip)
    public TextView errorTip;
    public String g;

    @BindView(R.id.input_bottom_bar)
    public LinearLayout inputBottomBar;

    @BindView(R.id.input_code)
    public LinearLayout inputCode;

    @BindView(R.id.k_layout1)
    public LinearLayout kLayout1;

    @BindView(R.id.k_layout2)
    public LinearLayout kLayout2;

    @BindView(R.id.ll_set_pin_fail)
    public LinearLayout llSetPinFail;

    @BindView(R.id.ll_set_pin_success)
    public LinearLayout llSetPinSuccess;

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

    @BindView(R.id.point5)
    public ImageView point5;

    @BindView(R.id.point6)
    public ImageView point6;

    @BindView(R.id.set_fail_ok)
    public TextView setFailOk;

    @BindView(R.id.set_success_ok)
    public TextView setSuccessOk;

    @BindView(R.id.tip)
    public TextView tip;

    @BindView(R.id.tv_pin_fail)
    public TextView tvPinFail;

    @BindView(R.id.tv_pin_success)
    public TextView tvPinSuccess;
    public int a = 0;
    public String b = "";
    public int e = 0;
    public Handler f = new Handler();
    public Runnable h = new g();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinSetCodeActivity.this.startActivity(new Intent(ToyPinSetCodeActivity.this, (Class<?>) NewToyActivity.class));
            ToyPinSetCodeActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinSetCodeActivity.this.finish();
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ToyPinSetCodeActivity.this.errorTip.setVisibility(8);
            ToyPinSetCodeActivity.this.y4(ah4.e(R.string.pin_set_pin_title));
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyPinSetCodeActivity.this.d.setPinStatus("1");
            ToyPinSetCodeActivity.this.inputCode.setVisibility(8);
            ToyPinSetCodeActivity.this.llSetPinSuccess.setVisibility(0);
            ToyPinSetCodeActivity.this.tvPinSuccess.setText(Html.fromHtml(String.format(ah4.e(R.string.pin_set_pin_success).replaceAll(StringUtils.LT_ENCODE, SimpleComparison.LESS_THAN_OPERATION).replaceAll(StringUtils.GT_ENCODE, SimpleComparison.GREATER_THAN_OPERATION), ToyPinSetCodeActivity.this.b)));
            ToyPinSetCodeActivity.this.llSetPinFail.setVisibility(8);
            as1.a(ToyPinSetCodeActivity.this.d.getAddress());
            ToyPinSetCodeActivity.this.d.setUuid(xb1.a(ToyPinSetCodeActivity.this.d.getUuid()));
            DaoUtils.getToyDao().updateOrAdd(ToyPinSetCodeActivity.this.d);
            DaoUtils.getToyPinStatusDao().delToyPinStatus(ToyPinSetCodeActivity.this.d.getAddress());
            ToyPinSetCodeActivity toyPinSetCodeActivity = ToyPinSetCodeActivity.this;
            qg3.e(toyPinSetCodeActivity, toyPinSetCodeActivity.d.getAddress());
            ToyPinSetCodeActivity.this.d.setIsSelect(0);
            ToyPinSetCodeActivity.this.dissDialog();
            HashMap map = new HashMap();
            map.put("mac", ToyPinSetCodeActivity.this.d.getAddress().toUpperCase().replace(SignatureImpl.INNER_SEP, ""));
            map.put("type", ToyPinSetCodeActivity.this.d.getType());
            map.put("pin", ToyPinSetCodeActivity.this.g);
            ye3.d("C0010", WearUtils.A.toJson(map));
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zr1.c(ToyPinSetCodeActivity.this.d, true);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyPinSetCodeActivity.this.inputCode.setVisibility(8);
            ToyPinSetCodeActivity.this.llSetPinSuccess.setVisibility(0);
            ToyPinSetCodeActivity.this.tvPinSuccess.setText(Html.fromHtml(String.format(ah4.e(R.string.pin_set_pin_success).replaceAll(StringUtils.LT_ENCODE, SimpleComparison.LESS_THAN_OPERATION).replaceAll(StringUtils.GT_ENCODE, SimpleComparison.GREATER_THAN_OPERATION), ToyPinSetCodeActivity.this.b)));
            ToyPinSetCodeActivity.this.llSetPinFail.setVisibility(8);
            as1.a(ToyPinSetCodeActivity.this.d.getAddress());
            DaoUtils.getToyPinStatusDao().delToyPinStatus(ToyPinSetCodeActivity.this.d.getAddress());
            ToyPinSetCodeActivity toyPinSetCodeActivity = ToyPinSetCodeActivity.this;
            qg3.e(toyPinSetCodeActivity, toyPinSetCodeActivity.d.getAddress());
            ToyPinSetCodeActivity.this.d.setIsSelect(0);
            ToyPinSetCodeActivity.this.dissDialog();
            HashMap map = new HashMap();
            map.put("mac", ToyPinSetCodeActivity.this.d.getAddress().toUpperCase().replace(SignatureImpl.INNER_SEP, ""));
            map.put("type", ToyPinSetCodeActivity.this.d.getType());
            map.put("pin", ToyPinSetCodeActivity.this.g);
            ye3.d("C0011", WearUtils.A.toJson(map));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyPinSetCodeActivity.this.inputCode.setVisibility(8);
            ToyPinSetCodeActivity.this.llSetPinSuccess.setVisibility(8);
            ToyPinSetCodeActivity.this.llSetPinFail.setVisibility(0);
            ToyPinSetCodeActivity.this.dissDialog();
        }
    }

    public void A4() throws Resources.NotFoundException {
        String str = this.edPassword1.getText().toString() + this.edPassword2.getText().toString() + this.edPassword3.getText().toString() + this.edPassword4.getText().toString() + this.edPassword5.getText().toString() + this.edPassword6.getText().toString();
        System.out.println(str + "");
        if (TextUtils.isEmpty(str) || str.length() != 6) {
            return;
        }
        if (this.a == 1) {
            if (!str.equals(this.b)) {
                x4();
                this.a = 0;
                return;
            } else {
                showDialog();
                zr1.b(this.d, str);
                this.g = str;
            }
        }
        int i = this.a;
        if (i == 0) {
            this.b = str;
            this.a = i + 1;
            y4(ah4.e(R.string.enter_pin_code_again));
        }
    }

    public void del(View view) {
        if (!TextUtils.isEmpty(this.edPassword6.getText())) {
            this.edPassword6.setText("");
            w4(5);
            return;
        }
        if (!TextUtils.isEmpty(this.edPassword5.getText())) {
            this.edPassword5.setText("");
            w4(4);
            return;
        }
        if (!TextUtils.isEmpty(this.edPassword4.getText())) {
            this.edPassword4.setText("");
            w4(3);
            return;
        }
        if (!TextUtils.isEmpty(this.edPassword3.getText())) {
            this.edPassword3.setText("");
            w4(2);
        } else if (!TextUtils.isEmpty(this.edPassword2.getText())) {
            this.edPassword2.setText("");
            w4(1);
        } else {
            if (TextUtils.isEmpty(this.edPassword1.getText())) {
                return;
            }
            this.edPassword1.setText("");
            w4(0);
        }
    }

    public final void delayTimeOut() {
        this.delayHandler.postDelayed(this.h, 10000L);
    }

    @Override // com.wear.BaseActivity
    public void dissDialog() {
        this.delayHandler.removeCallbacks(this.h);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    public void enterNumber(View view) throws Resources.NotFoundException {
        z4(((Button) view).getText().toString());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_pin_set_code);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.a = 0;
        this.errorTip.setVisibility(8);
        this.c = getIntent().getStringExtra("toyAddress");
        this.e = getIntent().getIntExtra("type", 0);
        Toy toyQ = WearUtils.x.G().Q(this.c);
        this.d = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        WearUtils.x.G();
        this.inputCode.setVisibility(0);
        this.llSetPinSuccess.setVisibility(8);
        this.llSetPinFail.setVisibility(8);
        this.setSuccessOk.setOnClickListener(new a());
        this.setFailOk.setOnClickListener(new b());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(b20 b20Var) {
        if (this.d.getAddress().equals(b20Var.getA())) {
            if (b20Var.getB() == 1) {
                this.f.postDelayed(new d(), 1500L);
            } else if (b20Var.getB() == -1) {
                this.inputCode.setVisibility(8);
                this.llSetPinSuccess.setVisibility(8);
                this.llSetPinFail.setVisibility(0);
                dissDialog();
            }
        }
    }

    @Override // com.wear.BaseActivity
    public void showDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressDialog.show();
        delayTimeOut();
    }

    public final void w4(int i) {
        switch (i) {
            case 0:
                this.point1.setVisibility(8);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_sel);
                this.point2.setVisibility(8);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point3.setVisibility(8);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point4.setVisibility(8);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point5.setVisibility(8);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point6.setVisibility(8);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_nar);
                break;
            case 1:
                this.point1.setVisibility(0);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point2.setVisibility(8);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_sel);
                this.point3.setVisibility(8);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point4.setVisibility(8);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point5.setVisibility(8);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point6.setVisibility(8);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_nar);
                break;
            case 2:
                this.point2.setVisibility(0);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point1.setVisibility(0);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point3.setVisibility(8);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_sel);
                this.point4.setVisibility(8);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point5.setVisibility(8);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point6.setVisibility(8);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_nar);
                break;
            case 3:
                this.point3.setVisibility(0);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point1.setVisibility(0);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point2.setVisibility(0);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point4.setVisibility(8);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_sel);
                this.point5.setVisibility(8);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point6.setVisibility(8);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_nar);
                break;
            case 4:
                this.point4.setVisibility(0);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point1.setVisibility(0);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point2.setVisibility(0);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point3.setVisibility(0);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point5.setVisibility(8);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_sel);
                this.point6.setVisibility(8);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_nar);
                break;
            case 5:
                this.point4.setVisibility(0);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point1.setVisibility(0);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point2.setVisibility(0);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point3.setVisibility(0);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point5.setVisibility(0);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point6.setVisibility(8);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_sel);
                break;
            case 6:
                this.point4.setVisibility(0);
                this.edPassword1.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point1.setVisibility(0);
                this.edPassword2.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point2.setVisibility(0);
                this.edPassword3.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point3.setVisibility(0);
                this.edPassword4.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point5.setVisibility(0);
                this.edPassword5.setBackgroundResource(R.drawable.content_passcode_input_nar);
                this.point6.setVisibility(0);
                this.edPassword6.setBackgroundResource(R.drawable.content_passcode_input_nar);
                break;
        }
    }

    public final void x4() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.passcode_error_anim);
        this.passwordfild.startAnimation(animationLoadAnimation);
        this.errorTip.setVisibility(0);
        animationLoadAnimation.setAnimationListener(new c());
    }

    public final void y4(String str) {
        this.tip.setText(str);
        this.edPassword6.setText("");
        this.edPassword5.setText("");
        this.edPassword4.setText("");
        this.edPassword3.setText("");
        this.edPassword2.setText("");
        this.edPassword1.setText("");
        w4(0);
    }

    public final void z4(String str) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(this.edPassword1.getText())) {
            this.edPassword1.setText(str);
            w4(1);
            return;
        }
        if (TextUtils.isEmpty(this.edPassword2.getText())) {
            this.edPassword2.setText(str);
            w4(2);
            return;
        }
        if (TextUtils.isEmpty(this.edPassword3.getText())) {
            this.edPassword3.setText(str);
            w4(3);
            return;
        }
        if (TextUtils.isEmpty(this.edPassword4.getText())) {
            this.edPassword4.setText(str);
            w4(4);
        } else if (TextUtils.isEmpty(this.edPassword5.getText())) {
            this.edPassword5.setText(str);
            w4(5);
        } else if (TextUtils.isEmpty(this.edPassword6.getText())) {
            this.edPassword6.setText(str);
            w4(6);
            A4();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(y10 y10Var) {
        this.d.getAddress().equals(y10Var.getA());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a20 a20Var) {
        if (this.d.getAddress().equals(a20Var.getA())) {
            if (a20Var.getB() == 1) {
                if (this.e == 0) {
                    this.f.postDelayed(new e(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                } else {
                    this.f.postDelayed(new f(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                }
            }
            this.inputCode.setVisibility(8);
            this.llSetPinSuccess.setVisibility(8);
            this.llSetPinFail.setVisibility(0);
            dissDialog();
        }
    }
}
