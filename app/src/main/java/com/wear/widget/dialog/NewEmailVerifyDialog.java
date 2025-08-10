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
public class NewEmailVerifyDialog extends VerifyDialog implements VerifyDialog.c {
    public boolean j;
    public boolean k;
    public c l;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    @BindView(R.id.tv_text)
    public TextView tvText;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public class a extends ClickableSpan {

        /* renamed from: com.wear.widget.dialog.NewEmailVerifyDialog$a$a, reason: collision with other inner class name */
        public class RunnableC0158a implements Runnable {
            public RunnableC0158a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NewEmailVerifyDialog.this.tvTip.setText(ah4.e(R.string.notif_note2));
            }
        }

        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (NewEmailVerifyDialog.this.l != null) {
                NewEmailVerifyDialog.this.l.c();
            }
            NewEmailVerifyDialog.this.tvTip.setText("");
            NewEmailVerifyDialog.this.tvTip.setVisibility(0);
            if (System.currentTimeMillis() - ge3.b <= 60000) {
                WearUtils.x.l.postDelayed(new RunnableC0158a(), 100L);
                return;
            }
            NewEmailVerifyDialog.this.j = true;
            NewEmailVerifyDialog newEmailVerifyDialog = NewEmailVerifyDialog.this;
            newEmailVerifyDialog.q(newEmailVerifyDialog);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(NewEmailVerifyDialog.this.b.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NewEmailVerifyDialog.this.k || VerifyDialog.i) {
                return;
            }
            NewEmailVerifyDialog.this.k = true;
            NewEmailVerifyDialog.this.tvTip.setText("");
            NewEmailVerifyDialog newEmailVerifyDialog = NewEmailVerifyDialog.this;
            newEmailVerifyDialog.p(newEmailVerifyDialog);
        }
    }

    public interface c {
        void a();

        void b(int i);

        void c();
    }

    public NewEmailVerifyDialog(Context context) {
        super(context);
        this.j = false;
        this.k = false;
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void a() {
        this.k = false;
        VerifyDialog.h = true;
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void b(int i) {
        this.k = false;
        c cVar = this.l;
        if (cVar != null) {
            cVar.b(i);
        }
        if (this.j) {
            this.tvTip.setVisibility(0);
            this.tvTip.setText(ah4.e(R.string.notice_hasnt_verify_email));
        }
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void c(int i, String str) {
        if (i == 50000) {
            this.tvTip.setVisibility(0);
            this.tvTip.setText(ah4.e(R.string.error_verify_reach_limit));
        }
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_new_email_verify;
    }

    @Override // dc.is3
    public void i() {
        String str = ((String.format(ah4.e(R.string.notif_old_body1_2), this.c) + "\n\n") + ah4.e(R.string.notif_old_body2) + "\n\n") + ah4.e(R.string.notif_old_body3);
        String strE = ah4.e(R.string.button_resend);
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.toLowerCase().indexOf(strE.toLowerCase());
        if (iIndexOf != -1) {
            spannableString.setSpan(new a(), iIndexOf, strE.length() + iIndexOf, 17);
        }
        this.tvText.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvText.setText(spannableString);
        this.tvText.setHighlightColor(this.b.getResources().getColor(android.R.color.transparent));
        if (this.g) {
            q(this);
        } else {
            this.g = true;
            this.j = true;
            this.tvTip.setVisibility(0);
        }
        this.tvConfirm.setOnClickListener(new b());
    }

    @Override // com.wear.widget.dialog.VerifyDialog.c
    public void sendSuc() {
        if (this.j) {
            this.tvTip.setVisibility(0);
            this.tvTip.setText(ah4.e(R.string.notif_note1));
        }
    }

    public void setiVerifyEmailListener(c cVar) {
        this.l = cVar;
    }
}
