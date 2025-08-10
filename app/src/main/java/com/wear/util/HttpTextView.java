package com.wear.util;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.wear.widget.GlassText;
import dc.ie3;
import dc.ig3;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class HttpTextView extends GlassText {
    public Matcher c;
    public LinkedList<String> d;
    public LinkedList<c> e;
    public int f;
    public String g;
    public Pattern h;
    public a i;
    public ie3 j;
    public boolean k;
    public String l;
    public long m;
    public boolean n;
    public long o;

    public interface a {
        void a(boolean z, String str);
    }

    public class b extends ClickableSpan {
        public String a;

        public b(String str) {
            this.a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (HttpTextView.this.d()) {
                return;
            }
            boolean z = true;
            String lowerCase = this.a.toLowerCase(Locale.ENGLISH);
            if (lowerCase.contains("lovense.com") || lowerCase.contains("lovenselife.com") || lowerCase.contains("lovense-api.com") || lowerCase.contains("lovense.cn")) {
                z = false;
                this.a = lowerCase;
            }
            if (HttpTextView.this.i != null) {
                HttpTextView.this.i.a(z, this.a);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-11436114);
            textPaint.setUnderlineText(false);
        }
    }

    public class c {
        public int a;
        public int b;

        public c(HttpTextView httpTextView) {
        }
    }

    public HttpTextView(Context context) {
        this(context, null);
    }

    public final SpannableStringBuilder c(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<SpannableString> listP = this.j.p(str);
        if (listP != null && listP.size() > 0) {
            Iterator<SpannableString> it = listP.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) it.next());
            }
        }
        return spannableStringBuilder;
    }

    public synchronized boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.o < 300) {
            return true;
        }
        this.o = jCurrentTimeMillis;
        return false;
    }

    public final ig3 e(CharSequence charSequence, CharSequence charSequence2) {
        ig3 ig3Var = charSequence != null ? new ig3(charSequence) : new ig3();
        if (this.d.size() <= 0) {
            ig3Var.append(c(charSequence2.toString()));
        } else if (this.d.size() == 1) {
            String strSubstring = charSequence2.toString().substring(0, this.e.get(0).a);
            String str = "jointText: 前text=" + strSubstring;
            if (TextUtils.isEmpty(strSubstring)) {
                ig3Var.append(strSubstring);
            } else {
                ig3Var.append(c(strSubstring));
            }
            String str2 = this.d.get(0);
            ig3Var.b(str2, new b(str2), this.f);
            if (this.e.get(0).a != -1 && this.e.get(0).b <= ig3Var.length()) {
                ig3Var.setSpan(new ForegroundColorSpan(Color.parseColor(this.l)), this.e.get(0).a, this.e.get(0).b, this.f);
                ig3Var.setSpan(new UnderlineSpan(), this.e.get(0).a, this.e.get(0).b, this.f);
            }
            String strSubstring2 = charSequence2.toString().substring(this.e.get(0).b);
            String str3 = "jointText: 尾部text=" + strSubstring2;
            if (TextUtils.isEmpty(strSubstring2)) {
                ig3Var.append(strSubstring2);
            } else {
                ig3Var.append(c(strSubstring2));
            }
        } else {
            for (int i = 0; i < this.d.size(); i++) {
                if (i == 0) {
                    String strSubstring3 = charSequence2.toString().substring(0, this.e.get(0).a);
                    String str4 = "jointText: 前text1=" + strSubstring3;
                    if (TextUtils.isEmpty(strSubstring3)) {
                        ig3Var.append(strSubstring3);
                    } else {
                        ig3Var.append(c(strSubstring3));
                    }
                }
                if (i == this.d.size() - 1) {
                    ig3Var.b(this.d.get(i), new b(this.d.get(i)), this.f);
                    if (this.e.get(i).a != -1 && this.e.get(0).b <= ig3Var.length()) {
                        ig3Var.setSpan(new ForegroundColorSpan(Color.parseColor(this.l)), this.e.get(i).a, this.e.get(i).b, this.f);
                        ig3Var.setSpan(new UnderlineSpan(), this.e.get(i).a, this.e.get(i).b, this.f);
                    }
                    String strSubstring4 = charSequence2.toString().substring(this.e.get(i).b);
                    String str5 = "jointText: 尾部text1=" + strSubstring4;
                    if (TextUtils.isEmpty(strSubstring4)) {
                        ig3Var.append(strSubstring4);
                    } else {
                        ig3Var.append(c(strSubstring4));
                    }
                }
                if (i != this.d.size() - 1) {
                    ig3Var.b(this.d.get(i), new b(this.d.get(i)), this.f);
                    if (this.e.get(i).a != -1 && this.e.get(0).b <= ig3Var.length()) {
                        ig3Var.setSpan(new ForegroundColorSpan(Color.parseColor(this.l)), this.e.get(i).a, this.e.get(i).b, this.f);
                        ig3Var.setSpan(new UnderlineSpan(), this.e.get(i).a, this.e.get(i).b, this.f);
                    }
                    String strSubstring5 = charSequence2.toString().substring(this.e.get(i).b, this.e.get(i + 1).a);
                    String str6 = "jointText: 中间text=" + strSubstring5;
                    if (TextUtils.isEmpty(strSubstring5)) {
                        ig3Var.append(strSubstring5);
                    } else {
                        ig3Var.append(c(strSubstring5));
                    }
                }
            }
        }
        return ig3Var;
    }

    public final ig3 f(CharSequence charSequence) {
        CharSequence charSequenceSubSequence;
        this.d.clear();
        this.e.clear();
        if (charSequence == null) {
            charSequence = "";
        }
        ig3 ig3Var = new ig3(charSequence);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ig3Var.getSpans(0, charSequence.length(), ClickableSpan.class);
        if (clickableSpanArr.length > 0) {
            int spanEnd = 0;
            int spanStart = 0;
            for (ClickableSpan clickableSpan : clickableSpanArr) {
                spanStart = ig3Var.getSpanStart(clickableSpanArr[0]);
                spanEnd = ig3Var.getSpanEnd(clickableSpan);
            }
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(spanEnd, charSequence.length());
            charSequenceSubSequence = charSequence.subSequence(spanStart, spanEnd);
            charSequence = charSequenceSubSequence2;
        } else {
            charSequenceSubSequence = null;
        }
        this.c = this.h.matcher(charSequence);
        while (this.c.find()) {
            c cVar = new c(this);
            cVar.a = this.c.start();
            cVar.b = this.c.end();
            this.d.add(this.c.group());
            this.e.add(cVar);
        }
        return e(charSequenceSubSequence, charSequence);
    }

    public boolean getIsNeedToRegionUrl() {
        return this.k;
    }

    @Override // com.wear.widget.GlassText, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CharSequence text = getText();
        if (text == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.n && (text instanceof Spannable)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) text).getSpans(0, text.length(), ClickableSpan.class);
            if (clickableSpanArr == null || clickableSpanArr.length == 0) {
                return super.onTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                this.m = System.currentTimeMillis();
            } else if (motionEvent.getAction() == 1 && System.currentTimeMillis() - this.m > 1000) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLinkIsResponseLongClick(boolean z) {
        this.n = z;
    }

    public void setOpenRegionUrl(boolean z) {
        this.k = z;
    }

    public void setUrlText(ie3 ie3Var, CharSequence charSequence, boolean z, a aVar) {
        if (MyApplication.m0 == 0) {
            if (MyApplication.l0) {
                this.l = "#0C9EF2";
            } else {
                this.l = "#00A3FF";
            }
        }
        int i = MyApplication.m0;
        if (i == 1) {
            this.l = "#00A3FF";
        }
        if (i == 2) {
            this.l = "#0075B9";
        }
        this.j = ie3Var;
        this.i = aVar;
        if (!this.k) {
            super.setText(charSequence);
        } else {
            super.setText(f(charSequence));
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public HttpTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HttpTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 33;
        this.g = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
        this.h = Pattern.compile("((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?", 74);
        this.k = true;
        this.n = false;
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
    }
}
