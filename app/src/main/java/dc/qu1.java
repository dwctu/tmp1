package dc;

import android.content.res.Resources;
import kotlin.Metadata;

/* compiled from: SizeUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"dp", "", "", "getDp", "(I)F", "px", "getPx", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qu1 {
    public static final float a(int i) {
        return i * Resources.getSystem().getDisplayMetrics().density;
    }
}
