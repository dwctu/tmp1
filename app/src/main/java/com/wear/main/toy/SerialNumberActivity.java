package com.wear.main.toy;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.account.HelpActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ln2;
import dc.np2;
import dc.pj3;
import dc.sg3;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SerialNumberActivity extends BaseActivity implements np2 {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public ln2 c;

    @BindView(R.id.fl_serial_number)
    public FrameLayout mFlSerialNumber;

    @BindView(R.id.iv_serial_number_loading)
    public ImageView mIvSerialnumberLoading;

    @BindView(R.id.ll_serial_number_bg)
    public LinearLayout mLlSerialNumberBg;

    @BindView(R.id.tv_no_serial_num)
    public TextView mTvNoSerialNum;

    @BindView(R.id.tv_serial_number)
    public TextView mTvSerialNumber;
    public String a = "";
    public String b = "";

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((ClipboardManager) SerialNumberActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, SerialNumberActivity.this.b));
            sg3.l(ah4.e(R.string.chat_message_item_copy_notice));
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            SerialNumberActivity.this.finish();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ BaseResponseBean a;

        public c(BaseResponseBean baseResponseBean) {
            this.a = baseResponseBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            SerialNumberActivity.this.t4(this.a);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SerialNumberActivity.this.t4(null);
        }
    }

    public class e extends ClickableSpan {
        public e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            pj3.f(SerialNumberActivity.this, HelpActivity.class);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.clearShadowLayer();
        }
    }

    @Override // dc.np2
    public void U2(boolean z, BaseResponseBean baseResponseBean) {
        runOnUiThread(new c(baseResponseBean));
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.m(this);
        this.mPresenter = this.c;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_seria_number);
        ButterKnife.bind(this);
        if (getIntent().getData() == null) {
            this.b = "";
        }
        this.a = getIntent().getStringExtra("seria_number");
        this.mLlSerialNumberBg.getBackground().mutate().setAlpha(20);
        this.mIvSerialnumberLoading.startAnimation(AnimationUtils.loadAnimation(this, R.anim.roate_img));
        this.mFlSerialNumber.setOnClickListener(new a());
        this.actionbar.setBackAction(new b());
        s4();
    }

    public void s4() {
        String str = this.a;
        if (str == null || str.length() <= 0) {
            return;
        }
        HashMap map = new HashMap();
        map.put("mac", this.a);
        this.c.h(false, new Gson().toJson(map));
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        super.showErrorMsg(str, z);
        runOnUiThread(new d());
    }

    public void t4(BaseResponseBean baseResponseBean) {
        if (baseResponseBean != null && baseResponseBean.getData() != null) {
            this.b = (String) ((Map) baseResponseBean.getData()).get("serialNo");
        }
        this.mIvSerialnumberLoading.clearAnimation();
        this.mIvSerialnumberLoading.setVisibility(8);
        String strE = ah4.e(R.string.clickable_here);
        String str = String.format(ah4.e(R.string.toys_serial_number_notfound), strE);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iIndexOf = str.indexOf(strE);
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.diff_select_text_color)), iIndexOf, strE.length() + iIndexOf, 33);
            spannableStringBuilder.setSpan(new e(), iIndexOf, strE.length() + iIndexOf, 33);
        }
        this.mTvNoSerialNum.setMovementMethod(new LinkMovementMethod());
        this.mTvNoSerialNum.setText(spannableStringBuilder);
        this.mTvNoSerialNum.setHighlightColor(0);
        String str2 = this.b;
        if (str2 == null || str2.length() <= 0) {
            this.mTvNoSerialNum.setVisibility(0);
            this.mFlSerialNumber.setVisibility(8);
        } else {
            this.mTvSerialNumber.setText(this.b);
            this.mFlSerialNumber.setVisibility(0);
            this.mTvNoSerialNum.setVisibility(8);
        }
    }
}
