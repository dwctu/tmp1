package com.wear.main.account;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.CheckIsNewBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.lg3;
import dc.pj3;
import dc.tn2;
import dc.zn2;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class WarmPromptActivity extends BaseActivity {
    public CheckIsNewBean a;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            pj3.w(WarmPromptActivity.this, WarmPromptActivity.this.a.getPrivacyUrl() + "&lang=" + lg3.b(WarmPromptActivity.this));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(WarmPromptActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            pj3.w(WarmPromptActivity.this, WarmPromptActivity.this.a.getTermsUrl() + "&lang=" + lg3.b(WarmPromptActivity.this));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(WarmPromptActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public class c implements zn2<String> {
        public c(WarmPromptActivity warmPromptActivity) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @OnClick({R.id.tv_agree, R.id.tv_disagree})
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_agree) {
            if (id != R.id.tv_disagree) {
                return;
            }
            this.application.E();
            return;
        }
        HashMap map = new HashMap();
        if (this.a.getTermsUpd() == 1) {
            map.put("termsType", 1);
        }
        if (this.a.getPrivacyUpd() == 1) {
            map.put("privacyType", 1);
        }
        tn2.x(WearUtils.x).t("/api/policy/accept", map, new c(this));
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_warm_prompt);
        ButterKnife.bind(this);
        CheckIsNewBean checkIsNewBean = (CheckIsNewBean) getIntent().getParcelableExtra("data");
        this.a = checkIsNewBean;
        if (checkIsNewBean == null || (checkIsNewBean.getTermsUpd() == 0 && this.a.getPrivacyUpd() == 0)) {
            finish();
            return;
        }
        String strE = ah4.e(R.string.privacy_policy1);
        String strE2 = ah4.e(R.string.terms_and_conditions1);
        String str = (this.a.getTermsUpd() == 1 && this.a.getPrivacyUpd() == 1) ? String.format(ah4.e(R.string.new_terms_notification2), strE, strE2) : this.a.getPrivacyUpd() == 1 ? String.format(ah4.e(R.string.new_terms_notification1), strE) : String.format(ah4.e(R.string.new_terms_notification1), strE2);
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf(strE);
        if (iIndexOf != -1) {
            spannableString.setSpan(new a(), iIndexOf, strE.length() + iIndexOf, 17);
        }
        int iIndexOf2 = str.indexOf(strE2);
        if (iIndexOf2 != -1) {
            spannableString.setSpan(new b(), iIndexOf2, strE2.length() + iIndexOf2, 17);
        }
        this.tvTip.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvTip.setText(spannableString);
    }
}
