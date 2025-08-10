package dc;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: MyTextSpan.java */
/* loaded from: classes4.dex */
public class gf3 extends MetricAffectingSpan {
    public String a;
    public String b;

    public gf3(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
    }
}
