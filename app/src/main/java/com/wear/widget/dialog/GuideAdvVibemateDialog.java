package com.wear.widget.dialog;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.ah4;
import dc.is3;

/* loaded from: classes4.dex */
public class GuideAdvVibemateDialog extends is3 {
    public c f;

    @BindView(R.id.tv_des1)
    public TextView tvDes1;

    @BindView(R.id.tv_des2)
    public TextView tvDes2;

    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (GuideAdvVibemateDialog.this.f != null) {
                GuideAdvVibemateDialog.this.f.b();
            }
            GuideAdvVibemateDialog.this.dismiss();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (GuideAdvVibemateDialog.this.f != null) {
                GuideAdvVibemateDialog.this.f.a();
            }
            GuideAdvVibemateDialog.this.dismiss();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
        }
    }

    public interface c {
        void a();

        void b();
    }

    public GuideAdvVibemateDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_guide_adv_vibemate;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        q();
        r();
    }

    public final void q() {
        String strE = ah4.e(R.string.terms_and_conditions);
        String str = String.format(ah4.e(R.string.banned_generating_link_des1), strE);
        int iIndexOf = str.indexOf(strE);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.diff_select_text_color));
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(foregroundColorSpan, iIndexOf, strE.length() + iIndexOf, 33);
            spannableStringBuilder.setSpan(new a(), iIndexOf, strE.length() + iIndexOf, 33);
        }
        this.tvDes1.setMovementMethod(new LinkMovementMethod());
        this.tvDes1.setText(spannableStringBuilder);
        this.tvDes1.setHighlightColor(this.b.getResources().getColor(android.R.color.transparent));
    }

    public final void r() {
        String strE = ah4.e(R.string.clickable_here);
        String str = String.format(ah4.e(R.string.banned_generating_link_des2), strE);
        int iIndexOf = str.indexOf(strE);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.diff_select_text_color));
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(foregroundColorSpan, iIndexOf, strE.length() + iIndexOf, 33);
            spannableStringBuilder.setSpan(new b(), iIndexOf, strE.length() + iIndexOf, 33);
        }
        this.tvDes2.setMovementMethod(new LinkMovementMethod());
        this.tvDes2.setText(spannableStringBuilder);
        this.tvDes2.setHighlightColor(this.b.getResources().getColor(android.R.color.transparent));
    }

    public void setListener(c cVar) {
        this.f = cVar;
    }
}
