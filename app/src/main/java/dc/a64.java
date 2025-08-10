package dc;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: FastServiceLoader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a64 {
    public static final boolean a;

    static {
        Object objM86constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM86constructorimpl = Result.m86constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM86constructorimpl = Result.m86constructorimpl(ResultKt.createFailure(th));
        }
        a = Result.m93isSuccessimpl(objM86constructorimpl);
    }

    public static final boolean a() {
        return a;
    }
}
