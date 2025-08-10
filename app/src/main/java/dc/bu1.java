package dc;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Application.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\"$\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001@@X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\"\u0012\u0010\f\u001a\u00020\b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\t\"\u0012\u0010\r\u001a\u00020\b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"\u0016\u0010\r\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"<set-?>", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "isAppBackground", "", "()Z", "setAppBackground", "(Z)V", "isAppDarkMode", "isAppDebug", "(Landroid/app/Application;)Z", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class bu1 {
    public static Application a;
    public static boolean b;

    @NotNull
    public static final Application a() {
        Application application = a;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
        return null;
    }

    public static final boolean b() {
        return b;
    }

    public static final void c(boolean z) {
        b = z;
    }

    public static final void d(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "<set-?>");
        a = application;
    }
}
