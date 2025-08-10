package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import dc.sc4;
import dc.yc4;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: HeadInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/component/dxhttp/interceptor/HeadInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ty implements sc4 {
    @Override // dc.sc4
    @NotNull
    public ad4 intercept(@NotNull sc4.a chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        yc4.a aVarH = chain.request().h();
        aVarH.a("BODY-X-TYPE", "2");
        aVarH.a("BODY-X-VERSION", "1.0");
        aVarH.a("timezone", ue0.c());
        aVarH.a("langkey", ce0.c().toString());
        String strC = tz.a.c();
        if (strC == null) {
            strC = "";
        }
        aVarH.a("di", strC);
        aVarH.a("av", gd0.g());
        aVarH.a("pf", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        aVarH.a("hv", "1");
        fy fyVarF = hy.d.a().getC();
        if (fyVarF != null) {
            if (!StringsKt__StringsJVMKt.isBlank(fyVarF.getX())) {
                aVarH.a("x", fyVarF.getX());
            }
            if (!StringsKt__StringsJVMKt.isBlank(fyVarF.d())) {
                aVarH.a("gtoken", fyVarF.d());
            }
            String lowerCase = fyVarF.b().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            aVarH.a("ac", lowerCase);
        }
        ad4 ad4VarProceed = chain.proceed(aVarH.b());
        Intrinsics.checkNotNullExpressionValue(ad4VarProceed, "chain.proceed(builder.build())");
        return ad4VarProceed;
    }
}
