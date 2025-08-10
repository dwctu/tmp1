package dc;

import com.component.dxhttp.NetException;
import com.component.dxhttp.bean.BaseResponse;
import com.component.dxtoy.config.bean.ToyConfigReqBean;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: DXToyConfigApi.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/component/dxtoy/DXToyConfigApi;", "", "()V", "isRequestConfig", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRetry", "requestUrl", "", "generateType", "type", "getConfigBySymbol", "Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;", "symbol", "getNameBySymbol", "getToyConfigData", "getToyConfigList", "", "getTypeByName", "name", "init", "", "onSuccess", "Lkotlin/Function0;", "openDebug", "isDebug", "", "requestConfig", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a00 {

    @NotNull
    public static String b = "https://apps2.lovense-api.com/app/toy/config/lastUpdateV2";

    @NotNull
    public static final a00 a = new a00();

    @NotNull
    public static final AtomicBoolean c = new AtomicBoolean(false);

    @NotNull
    public static final AtomicBoolean d = new AtomicBoolean(false);

    /* compiled from: DXToyConfigApi.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/component/dxtoy/DXToyConfigApi$requestConfig$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxhttp/bean/BaseResponse;", "", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ny<BaseResponse<String>> {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            if (a00.d.compareAndSet(false, true)) {
                a00.a.h(this.a);
            } else {
                a00.d.set(false);
                a00.c.set(false);
            }
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable BaseResponse<String> baseResponse) {
            String data;
            if (baseResponse != null && (data = baseResponse.getData()) != null) {
                Function0<Unit> function0 = this.a;
                if (!(data.length() == 0)) {
                    gb0.a.k(data);
                    function0.invoke();
                }
            }
            a00.d.set(false);
            a00.c.set(false);
        }
    }

    @JvmStatic
    @Nullable
    public static final String d() {
        return gb0.a.c();
    }

    @JvmStatic
    @NotNull
    public static final List<ToyConfigInfoBean> e() {
        return gb0.a.d();
    }

    @JvmStatic
    public static final void f(@NotNull Function0<Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        if (c.compareAndSet(false, true)) {
            a.h(onSuccess);
        }
    }

    @JvmStatic
    public static final void g(boolean z) {
        gb0 gb0Var = gb0.a;
        gb0Var.f(z);
        b = gb0Var.g() ? "https://test10.lovense.com/app/toy/config/lastUpdateV2" : "https://apps2.lovense-api.com/app/toy/config/lastUpdateV2";
    }

    public final void h(Function0<Unit> function0) {
        String strValueOf = String.valueOf(gb0.a.e());
        gz gzVar = gz.a;
        ky.e(b, new ToyConfigReqBean(gzVar.c().b().name(), DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, gzVar.c().a(), strValueOf), null, new a(function0));
    }
}
