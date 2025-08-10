package dc;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* compiled from: LPaint.java */
/* loaded from: classes.dex */
public class v7 extends Paint {
    public v7() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public v7(int i) {
        super(i);
    }

    public v7(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public v7(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
