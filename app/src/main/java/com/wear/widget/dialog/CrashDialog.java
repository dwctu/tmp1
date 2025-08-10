package com.wear.widget.dialog;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.is3;

/* loaded from: classes4.dex */
public class CrashDialog extends is3<String> {

    @BindView(R.id.tv_text)
    public TextView tvText;

    public CrashDialog(Context context, int i) {
        super(context, i);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_crash;
    }

    public TextView p() {
        return this.tvText;
    }

    public void setText() {
        TextView textView = this.tvText;
        if (textView != null) {
            textView.setText(Html.fromHtml(this.a.c.toString()));
        }
    }

    public CrashDialog(Context context) {
        super(context);
    }
}
