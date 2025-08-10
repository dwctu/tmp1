package com.wear.ui.me;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.PolicyListBean;
import com.wear.main.account.HelpActivity;
import dc.eg3;
import dc.lg3;
import dc.pj3;
import dc.wg3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class DiaglogShowActivity extends Activity {
    public TextView a;
    public TextView b;
    public String c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DiaglogShowActivity.this.finish();
        }
    }

    public class b extends ClickableSpan {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public b(List list, String str) {
            this.a = list;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.a.size() >= 2) {
                String str = ((String) this.a.get(1)) + "?pf=" + wg3.a() + "&lang=" + this.b;
                String str2 = "协议URL====" + str;
                pj3.w(DiaglogShowActivity.this, str);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(DiaglogShowActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            pj3.f(DiaglogShowActivity.this, HelpActivity.class);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(DiaglogShowActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_diaglog_show);
        this.a = (TextView) findViewById(R.id.tv_text);
        this.b = (TextView) findViewById(R.id.tv_confirm);
        this.c = getIntent().getStringExtra("getSpannableString");
        this.b.setOnClickListener(new a());
        Gson gson = new Gson();
        Locale localeE = lg3.e(this);
        ArrayList arrayList = new ArrayList();
        PolicyListBean policyListBean = (PolicyListBean) gson.fromJson(eg3.h(this, "new_argement_list", ""), PolicyListBean.class);
        if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
            for (int i = 0; i < policyListBean.getData().size(); i++) {
                arrayList.add(policyListBean.getData().get(i).getUrl());
            }
        }
        String strC = lg3.c(localeE);
        SpannableString spannableString = new SpannableString(this.c);
        int iIndexOf = this.c.indexOf(getIntent().getStringExtra("second"));
        if (iIndexOf != -1) {
            spannableString.setSpan(new b(arrayList, strC), iIndexOf, getIntent().getStringExtra("second").length() + iIndexOf, 17);
        }
        int iIndexOf2 = this.c.indexOf(getIntent().getStringExtra("fourth"));
        if (iIndexOf2 != -1) {
            spannableString.setSpan(new c(), iIndexOf2, getIntent().getStringExtra("fourth").length() + iIndexOf2, 17);
        }
        this.a.setMovementMethod(LinkMovementMethod.getInstance());
        this.a.setText(spannableString);
    }
}
