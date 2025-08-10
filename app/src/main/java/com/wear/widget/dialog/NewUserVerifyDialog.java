package com.wear.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.VerifyDialog;
import dc.ah4;
import dc.ge3;

/* loaded from: classes4.dex */
public class NewUserVerifyDialog extends VerifyDialog implements VerifyDialog.c {

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    @BindView(R.id.tv_skip)
    public TextView tvSkip;

    @BindView(R.id.tv_step)
    public TextView tvStep;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (System.currentTimeMillis() - ge3.b <= 60000) {
                NewUserVerifyDialog.this.tvStep.setText(ah4.e(R.string.notif_note2));
            } else {
                NewUserVerifyDialog newUserVerifyDialog = NewUserVerifyDialog.this;
                newUserVerifyDialog.q(newUserVerifyDialog);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(NewUserVerifyDialog.this.b.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public NewUserVerifyDialog(Context context) {
        super(context);
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void a() {
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void b(int i) {
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void c(int i, String str) {
        if (i == 50000) {
            this.tvTip.setVisibility(0);
            if (WearUtils.e1(str)) {
                this.tvTip.setText(ah4.e(R.string.notif_note2));
            } else {
                this.tvTip.setText(ah4.e(R.string.error_verify_reach_limit));
            }
        }
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_sign_up_verify;
    }

    @Override // dc.is3
    public void i() {
        String str = ((String.format(ah4.e(R.string.notif_new_body1), this.c) + "\n\n") + ah4.e(R.string.notif_old_body2) + "\n\n") + ah4.e(R.string.notif_old_body3);
        String strE = ah4.e(R.string.lowercase_resend);
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.toLowerCase().indexOf(strE.toLowerCase());
        if (iIndexOf != -1) {
            spannableString.setSpan(new a(), iIndexOf, strE.length() + iIndexOf, 17);
        }
        this.tvTip.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvTip.setText(spannableString);
        this.tvTip.setHighlightColor(this.b.getResources().getColor(android.R.color.transparent));
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void sendSuc() {
        this.tvStep.setVisibility(0);
        this.tvStep.setText(ah4.e(R.string.notif_note1));
    }
}
