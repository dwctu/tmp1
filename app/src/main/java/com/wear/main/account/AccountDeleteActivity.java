package com.wear.main.account;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.response.CheckPasswordResponse;
import com.wear.bean.response.RemoveUserResponse;
import com.wear.main.MainActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.cs3;
import dc.ep1;
import dc.is3;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.tn2;
import dc.ue3;
import dc.xf3;
import dc.yn2;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.crypto.tls.CipherSuite;

/* loaded from: classes3.dex */
public class AccountDeleteActivity extends BaseActivity {
    public static String c = "isFromDeleteAccount";

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.confirm)
    public Button confirm;

    @BindView(R.id.editText)
    public EditText editText;

    @BindView(R.id.editTextCons)
    public ConstraintLayout editTextCons;

    @BindView(R.id.eyeImage)
    public ImageView eyeImage;

    @BindView(R.id.image)
    public ImageView image;

    @BindView(R.id.linear)
    public LinearLayout linear;

    @BindView(R.id.title)
    public TextView title;
    public boolean a = false;
    public long b = System.currentTimeMillis();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AccountDeleteActivity.this.a) {
                AccountDeleteActivity.this.a = false;
                AccountDeleteActivity.this.editText.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                AccountDeleteActivity.this.editText.setTypeface(Typeface.DEFAULT);
                AccountDeleteActivity accountDeleteActivity = AccountDeleteActivity.this;
                accountDeleteActivity.eyeImage.setImageDrawable(th4.d(accountDeleteActivity, R.drawable.login_password_invisible));
                return;
            }
            AccountDeleteActivity.this.a = true;
            AccountDeleteActivity.this.editText.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
            AccountDeleteActivity.this.editText.setTypeface(Typeface.DEFAULT);
            AccountDeleteActivity accountDeleteActivity2 = AccountDeleteActivity.this;
            accountDeleteActivity2.eyeImage.setImageDrawable(th4.d(accountDeleteActivity2, R.drawable.login_password_visible));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            AccountDeleteActivity accountDeleteActivity = AccountDeleteActivity.this;
            ue3.a(accountDeleteActivity.editText, accountDeleteActivity);
            AccountDeleteActivity.this.y4(AccountDeleteActivity.this.editText.getText().toString().trim());
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(AccountDeleteActivity.this.editText.getText().toString().trim())) {
                AccountDeleteActivity.this.confirm.setEnabled(false);
                AccountDeleteActivity.this.eyeImage.setVisibility(8);
                AccountDeleteActivity accountDeleteActivity = AccountDeleteActivity.this;
                accountDeleteActivity.confirm.setBackground(th4.d(accountDeleteActivity, R.drawable.accout_delete_confirm_background));
                AccountDeleteActivity accountDeleteActivity2 = AccountDeleteActivity.this;
                accountDeleteActivity2.confirm.setTextColor(th4.b(accountDeleteActivity2, R.color.account_delete_confirm_color));
                return;
            }
            AccountDeleteActivity.this.confirm.setEnabled(true);
            AccountDeleteActivity.this.eyeImage.setVisibility(0);
            AccountDeleteActivity accountDeleteActivity3 = AccountDeleteActivity.this;
            accountDeleteActivity3.confirm.setBackground(th4.d(accountDeleteActivity3, R.drawable.red_status_button_bg));
            AccountDeleteActivity accountDeleteActivity4 = AccountDeleteActivity.this;
            accountDeleteActivity4.confirm.setTextColor(th4.b(accountDeleteActivity4, R.color.white));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class d implements is3.d {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // dc.is3.d
        public void doConfirm() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            AccountDeleteActivity.this.z4(this.a);
        }
    }

    public class e implements is3.d {
        public e() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            Intent intent = new Intent(AccountDeleteActivity.this, (Class<?>) MainActivity.class);
            intent.putExtra(AccountDeleteActivity.c, true);
            pj3.u(AccountDeleteActivity.this, intent);
            AccountDeleteActivity.this.finish();
        }
    }

    public class f implements yn2<RemoveUserResponse> {
        public f() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(RemoveUserResponse removeUserResponse) {
            String str = "onSuccess: " + removeUserResponse;
            if (removeUserResponse.code == 0 && removeUserResponse.result) {
                ep1.b().h(1);
                AccountDeleteActivity.this.C4();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String str = "onError: " + netException.getMessage();
            sg3.h(R.string.login_after_deleting_toast);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class g implements yn2<CheckPasswordResponse> {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CheckPasswordResponse checkPasswordResponse) {
            String str = "onSuccess: " + checkPasswordResponse;
            if (checkPasswordResponse.code == 0 && checkPasswordResponse.result) {
                AccountDeleteActivity.this.B4(this.a);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String str = "onError: " + netException.getMessage();
            sg3.h(R.string.login_after_deleting_toast);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public final void A4() {
        this.actionbar.setTitle(ah4.e(R.string.setting_delete_account));
        this.eyeImage.setOnClickListener(new a());
        this.confirm.setOnClickListener(new b());
        this.editText.addTextChangedListener(new c());
    }

    public final void B4(String str) {
        cs3.a(this, ah4.e(R.string.delete_account_notice1), new d(str)).show();
    }

    public final void C4() {
        cs3.k(this, ah4.e(R.string.delete_account_notice2), new e()).show();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_delete);
        ButterKnife.bind(this);
        A4();
    }

    public final void y4(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (be3.r() - this.b < 1500) {
            return;
        }
        this.b = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = xf3.a(str, "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        map.put("password", strA);
        tn2.x(this.application).p("/check_password", map, new g(str));
    }

    public final void z4(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = xf3.a(str, "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        map.put("password", strA);
        tn2.x(this.application).p("/remove_user", map, new f());
    }
}
