package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import dc.ah4;
import dc.is3;

/* loaded from: classes4.dex */
public class DatingAddFriendDialog extends is3 implements DialogInterface.OnDismissListener {
    public Handler f;
    public TextView g;
    public int h;
    public b i;
    public Runnable j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DatingAddFriendDialog datingAddFriendDialog = DatingAddFriendDialog.this;
            int i = datingAddFriendDialog.h - 1;
            datingAddFriendDialog.h = i;
            if (i <= 0) {
                datingAddFriendDialog.f.removeCallbacksAndMessages(null);
                DatingAddFriendDialog.this.a.h.doCancel();
                DatingAddFriendDialog.this.dismiss();
                return;
            }
            try {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                String str = String.format(ah4.e(R.string.str_date_end_invite_add_friend_tip), DatingAddFriendDialog.this.a.c);
                spannableStringBuilder.append((CharSequence) str).append((CharSequence) ("\n(" + DatingAddFriendDialog.this.h + "s)"));
                int iLastIndexOf = str.lastIndexOf(DatingAddFriendDialog.this.a.c.toString());
                if (iLastIndexOf != -1 && DatingAddFriendDialog.this.a.c.toString().length() + iLastIndexOf <= spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(DatingAddFriendDialog.this.getContext(), R.color.color_accent)), iLastIndexOf, DatingAddFriendDialog.this.a.c.toString().length() + iLastIndexOf, 34);
                }
                DatingAddFriendDialog.this.g.setText(spannableStringBuilder);
                DatingAddFriendDialog datingAddFriendDialog2 = DatingAddFriendDialog.this;
                datingAddFriendDialog2.f.postDelayed(datingAddFriendDialog2.j, 1000L);
            } catch (Exception e) {
                e.printStackTrace();
                String strE = ah4.e(R.string.str_date_end_invite_add_friend_tip);
                StringBuilder sb = new StringBuilder();
                sb.append(strE);
                sb.append("    ");
                sb.append(TextUtils.isEmpty(DatingAddFriendDialog.this.a.c) ? "null" : DatingAddFriendDialog.this.a.c);
                FirebaseCrashlytics.getInstance().recordException(new Throwable(sb.toString()));
            }
        }
    }

    public interface b {
        void onDismiss();
    }

    public DatingAddFriendDialog(Context context) {
        super(context);
        this.f = new Handler(Looper.getMainLooper());
        this.h = 61;
        this.j = new a();
        setOnDismissListener(this);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f.removeCallbacksAndMessages(null);
        b bVar = this.i;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    public void p() {
        TextView textView = (TextView) findViewById(this.a.s);
        this.g = textView;
        if (textView == null) {
            return;
        }
        this.f.removeCallbacksAndMessages(null);
        this.f.postDelayed(this.j, 0L);
    }

    public void setListener(b bVar) {
        this.i = bVar;
    }
}
