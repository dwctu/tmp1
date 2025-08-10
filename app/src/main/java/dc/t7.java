package dc;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* compiled from: SimpleColorFilter.java */
/* loaded from: classes.dex */
public class t7 extends PorterDuffColorFilter {
    public t7(@ColorInt int i) {
        super(i, PorterDuff.Mode.SRC_ATOP);
    }
}
