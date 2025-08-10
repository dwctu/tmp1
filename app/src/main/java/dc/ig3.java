package dc;

import android.text.SpannableStringBuilder;

/* compiled from: SpannableStringBuilderAllVer.java */
/* loaded from: classes4.dex */
public class ig3 extends SpannableStringBuilder {
    public ig3() {
        super("");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ig3 append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        return (ig3) replace(length, length, charSequence, 0, charSequence.length());
    }

    public ig3 b(CharSequence charSequence, Object obj, int i) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i);
        return this;
    }

    public ig3(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }

    @Override // android.text.SpannableStringBuilder
    public /* bridge */ /* synthetic */ SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        b(charSequence, obj, i);
        return this;
    }
}
