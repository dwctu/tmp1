package dc;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: AddClickableSpanListener.java */
/* loaded from: classes3.dex */
public abstract class av1 extends ClickableSpan {
    public String a;
    public String b;

    public av1(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public abstract void a(String str, String str2);

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        a(this.a, this.b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
