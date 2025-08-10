package com.wear.widget;

import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class HtmlTextView extends TextView {

    public interface a {
        void a(String str);
    }

    public class b extends ClickableSpan {
        public String a;
        public a b;

        public b(HtmlTextView htmlTextView, String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(this.a);
            }
        }
    }

    public HtmlTextView(Context context) {
        super(context);
    }

    public void setText(String str, Integer num, a aVar) {
        setText(Html.fromHtml(str));
        setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = getText();
        if (text instanceof Spannable) {
            int length = text.length();
            Spannable spannable = (Spannable) getText();
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            for (URLSpan uRLSpan : uRLSpanArr) {
                System.out.println("url=" + uRLSpan.getURL() + " " + uRLSpan.toString());
                spannableStringBuilder.setSpan(new b(this, uRLSpan.getURL(), aVar), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(num != null ? num.intValue() : getTextColors().getDefaultColor()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
            }
            setText(spannableStringBuilder);
        }
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
