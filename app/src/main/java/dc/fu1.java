package dc;

import android.content.Context;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.Nullable;

/* compiled from: Glide.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¨\u0006\u0006"}, d2 = {"getGlideSafeKey", "", ImagesContract.URL, "getGlideSafePath", "context", "Landroid/content/Context;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class fu1 {
    @Nullable
    public static final String a(@Nullable String str) {
        Object objM86constructorimpl;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            lp lpVarC = lp.c();
            Intrinsics.checkNotNullExpressionValue(lpVarC, "obtain()");
            lpVarC.b(messageDigest);
            new ek(str).b(messageDigest);
            String strU = wp.u(messageDigest.digest());
            Intrinsics.checkNotNullExpressionValue(strU, "sha256BytesToHex(messageDigest.digest())");
            objM86constructorimpl = Result.m86constructorimpl(strU + ".0");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM86constructorimpl = Result.m86constructorimpl(ResultKt.createFailure(th));
        }
        Result.m89exceptionOrNullimpl(objM86constructorimpl);
        return (String) (Result.m92isFailureimpl(objM86constructorimpl) ? null : objM86constructorimpl);
    }

    @Nullable
    public static final String b(@Nullable Context context, @Nullable String str) {
        String strA;
        String absolutePath;
        if ((str == null || str.length() == 0) || (strA = a(str)) == null) {
            return null;
        }
        File fileJ = context != null ? kf.j(context) : null;
        if (fileJ == null || (absolutePath = fileJ.getAbsolutePath()) == null) {
            return null;
        }
        return absolutePath + IOUtils.DIR_SEPARATOR_UNIX + strA;
    }
}
