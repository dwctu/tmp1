package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.PolicyListBean;
import com.wear.main.account.WebViewActivity;
import java.util.ArrayList;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: DialogUtils.java */
/* loaded from: classes3.dex */
public class vc2 {

    /* compiled from: DialogUtils.java */
    public class a extends ClickableSpan {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            ArrayList arrayList = new ArrayList();
            String strC = lg3.c(lg3.e(this.a));
            PolicyListBean policyListBean = (PolicyListBean) new Gson().fromJson(eg3.h(this.a, "new_argement_list", ""), PolicyListBean.class);
            if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
                for (int i = 0; i < policyListBean.getData().size(); i++) {
                    arrayList.add(policyListBean.getData().get(i).getUrl());
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.terms_and_conditions));
            bundle.putString(ImagesContract.URL, arrayList.size() > 0 ? ((String) arrayList.get(1)) + "?pf=" + wg3.a() + "&lang=" + strC : "https://hyttoapps.bandnana.com/remote/end-user-license-agreement?pf=" + wg3.a() + "&lang=" + strC);
            pj3.g(this.a, WebViewActivity.class, bundle);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public static /* synthetic */ void a(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static void b(Context context, final View.OnClickListener onClickListener) {
        String strE = ah4.e(R.string.notification_account_banned);
        String strE2 = ah4.e(R.string.terms_and_conditions);
        String str = String.format(strE, strE2);
        int iIndexOf = str.indexOf(strE2);
        int length = strE2.length() + iIndexOf;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.pink)), iIndexOf, length, 33);
        }
        a aVar = new a(context);
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(aVar, iIndexOf, length, 33);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.ban_account_notice_dialog, (ViewGroup) null);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.content_text);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(new LinkMovementMethod());
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        alertDialogCreate.show();
        ((Button) viewInflate.findViewById(R.id.ok_btn)).setOnClickListener(new View.OnClickListener() { // from class: dc.ec2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                vc2.a(alertDialogCreate, onClickListener, view);
            }
        });
    }
}
