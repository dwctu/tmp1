package dc;

import dc.sc4;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONObject;

/* compiled from: ResponseInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/component/dxhttp/interceptor/ResponseInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class uy implements sc4 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // dc.sc4
    @Nullable
    public ad4 intercept(@NotNull sc4.a chain) {
        fy fyVarF;
        Intrinsics.checkNotNullParameter(chain, "chain");
        ad4 ad4Var = null;
        try {
            try {
                ad4 ad4VarProceed = chain.proceed(chain.request());
                try {
                    bd4 bd4VarB = ad4VarProceed.A().c().b();
                    Intrinsics.checkNotNull(bd4VarB);
                    pd4 pd4VarSource = bd4VarB.source();
                    pd4VarSource.request(Long.MAX_VALUE);
                    JSONObject jSONObject = new JSONObject(pd4VarSource.a().clone().Q(Charset.forName("UTF-8")));
                    String code = jSONObject.optString(XHTMLText.CODE);
                    String message = jSONObject.optString("message");
                    if (code != null) {
                        switch (code.hashCode()) {
                            case 47713265:
                                if (!code.equals("22001")) {
                                    break;
                                }
                                break;
                            case 47713266:
                                if (!code.equals("22002") || (fyVarF = hy.d.a().getC()) == null) {
                                    break;
                                } else {
                                    fyVarF.c();
                                    break;
                                }
                                break;
                            case 47713267:
                                if (!code.equals("22003")) {
                                    break;
                                }
                                break;
                            case 50424311:
                                if (!code.equals("50024")) {
                                    break;
                                }
                                break;
                            case 1563155496:
                                if (!code.equals("500409")) {
                                    break;
                                } else {
                                    fy fyVarF2 = hy.d.a().getC();
                                    if (fyVarF2 == null) {
                                        return null;
                                    }
                                    Intrinsics.checkNotNullExpressionValue(code, "code");
                                    Intrinsics.checkNotNullExpressionValue(message, "message");
                                    fyVarF2.e(code, message, "xmppConflict");
                                    return null;
                                }
                            case 1563155518:
                                if (!code.equals("500410")) {
                                    break;
                                }
                                break;
                            case 1563155519:
                                if (!code.equals("500411")) {
                                    break;
                                } else {
                                    fy fyVarF3 = hy.d.a().getC();
                                    if (fyVarF3 == null) {
                                        return null;
                                    }
                                    Intrinsics.checkNotNullExpressionValue(code, "code");
                                    Intrinsics.checkNotNullExpressionValue(message, "message");
                                    fyVarF3.e(code, message, "forbiddenByServer");
                                    return null;
                                }
                        }
                        fy fyVarF4 = hy.d.a().getC();
                        if (fyVarF4 == null) {
                            return null;
                        }
                        Intrinsics.checkNotNullExpressionValue(code, "code");
                        Intrinsics.checkNotNullExpressionValue(message, "message");
                        fyVarF4.e(code, message, "invalidRToken");
                        return null;
                    }
                    return ad4VarProceed;
                } catch (Exception e) {
                    e = e;
                    ad4Var = ad4VarProceed;
                    e.printStackTrace();
                    return ad4Var;
                } catch (Throwable unused) {
                    return ad4VarProceed;
                }
            } catch (Throwable unused2) {
                return ad4Var;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
