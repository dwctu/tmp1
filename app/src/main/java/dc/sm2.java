package dc;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.bean.LangVersionBean;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import com.wear.network.presenter.bean.Lang;
import com.wear.network.presenter.bean.RequestLangBean;
import com.wear.util.WearUtils;
import dc.yf1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LangVersonUtils.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J%\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/wear/network/presenter/main/LangVersionUtils;", "", "()V", "canpareAndLoad", "", "key", "", "version", "data", "compareObjects", "", "", "obj1", "Lcom/wear/bean/LangVersionBean;", "obj2", "getLangVersion", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getNewLang", "lang", "Lcom/wear/network/presenter/bean/Lang;", "langVersionBean", "(Lcom/wear/network/presenter/bean/Lang;Lcom/wear/bean/LangVersionBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class sm2 {

    /* compiled from: LangVersonUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.network.presenter.main.LangVersionUtils$getLangVersion$1", f = "LangVersonUtils.kt", i = {0}, l = {52, 83, 87}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ RequestLangBean $headerData;
        public int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RequestLangBean requestLangBean, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$headerData = requestLangBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return sm2.this.new a(this.$headerData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            RemoteResponse remoteResponseA;
            RemoteResult remoteResult;
            int i;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
            } catch (Exception e) {
                e.printStackTrace();
                remoteResponseA = al2.a.a(e);
            }
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                RequestLangBean requestLangBean = this.$headerData;
                bl2 bl2VarA = xk2.c.a();
                String strB = qx.b(WearUtils.A.toJson(requestLangBean));
                Intrinsics.checkNotNullExpressionValue(strB, "dtxEncrypt(\n            …  )\n                    )");
                this.I$0 = 1;
                this.label = 1;
                obj = bl2VarA.f(strB, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = 1;
            } else {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
            }
            RemoteResult remoteResult2 = (RemoteResult) obj;
            if (remoteResult2.isSuccess()) {
                remoteResponseA = new RemoteResponse.Success(remoteResult2);
            } else {
                String message = remoteResult2.getMessage();
                if (message == null) {
                    message = ah4.e(R.string.common_netError);
                }
                if (i != 0) {
                    sg3.l(message);
                }
                zk2.a.a(remoteResult2.getCode(), message);
                remoteResponseA = new RemoteResponse.Error(Boxing.boxInt(remoteResult2.getCode()), message);
            }
            LangVersionBean langVersionBean = (LangVersionBean) ((!(remoteResponseA instanceof RemoteResponse.Success) || (remoteResult = (RemoteResult) ((RemoteResponse.Success) remoteResponseA).getData()) == null) ? null : remoteResult.getData());
            if (langVersionBean == null) {
                return Unit.INSTANCE;
            }
            String langVersionData = eg3.h(WearUtils.x, "lang_version", "");
            if (langVersionData == null || langVersionData.length() == 0) {
                sm2 sm2Var = sm2.this;
                Lang version = langVersionBean.getVersion();
                this.label = 3;
                if (sm2Var.f(version, langVersionBean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                yf1.a aVar = new yf1.a();
                aVar.a(new eg1());
                yf1 yf1VarB = aVar.b();
                nf1 nf1VarC = yf1VarB.c(LangVersionBean.class);
                Intrinsics.checkNotNullExpressionValue(langVersionData, "langVersionData");
                if (StringsKt__StringsKt.contains$default((CharSequence) langVersionData, (CharSequence) "zhTw", false, 2, (Object) null)) {
                    Intrinsics.checkNotNullExpressionValue(langVersionData, "langVersionData");
                    langVersionData = StringsKt__StringsJVMKt.replace$default(langVersionData, "zhTw", "zh-tw", false, 4, (Object) null);
                }
                String str = "langVersionData: " + langVersionData;
                LangVersionBean langVersionBean2 = (LangVersionBean) nf1VarC.c(langVersionData);
                sm2 sm2Var2 = sm2.this;
                Intrinsics.checkNotNull(langVersionBean2);
                String json = WearUtils.A.toJson(sm2Var2.d(langVersionBean2, langVersionBean));
                String str2 = "Different properties: " + json;
                if (!r1.isEmpty()) {
                    Lang lang = (Lang) yf1VarB.c(Lang.class).c(json);
                    sm2 sm2Var3 = sm2.this;
                    this.label = 2;
                    if (sm2Var3.f(lang, langVersionBean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LangVersonUtils.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.network.presenter.main.LangVersionUtils", f = "LangVersonUtils.kt", i = {0, 0, 0}, l = {122}, m = "getNewLang", n = {"this", "langVersionBean", "isShowToast$iv$iv"}, s = {"L$0", "L$1", "I$0"})
    public static final class b extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return sm2.this.f(null, null, this);
        }
    }

    public final void c(String str, String str2, String str3) throws IOException {
        String strG = pe3.g(str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Intrinsics.areEqual(str2, strG) || TextUtils.isEmpty(str3)) {
            return;
        }
        WearUtils.h2(new Regex("<#4#>").replace(new Regex("<#3#>").replace(new Regex("<#2#>").replace(new Regex("<#1#>").replace(str3, "%1$s"), "%2$s"), "%3$s"), "%4$s"), "language/" + str, false);
        pe3.l(str, str2);
    }

    public final Map<String, Long> d(LangVersionBean langVersionBean, LangVersionBean langVersionBean2) {
        Long es;
        Long zh;
        Long fr;
        Long pl2;
        Long en;
        Long ja;
        Long zhTw;
        Long ko;
        Long ru;
        Long de2;
        HashMap map = new HashMap();
        Lang version = langVersionBean.getVersion();
        Long de3 = version != null ? version.getDe() : null;
        Lang version2 = langVersionBean2.getVersion();
        boolean zAreEqual = Intrinsics.areEqual(de3, version2 != null ? version2.getDe() : null);
        long jLongValue = 0;
        if (!zAreEqual) {
            Lang version3 = langVersionBean2.getVersion();
            map.put("de", Long.valueOf((version3 == null || (de2 = version3.getDe()) == null) ? 0L : de2.longValue()));
        }
        Lang version4 = langVersionBean.getVersion();
        Long ru2 = version4 != null ? version4.getRu() : null;
        Lang version5 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(ru2, version5 != null ? version5.getRu() : null)) {
            Lang version6 = langVersionBean2.getVersion();
            map.put("ru", Long.valueOf((version6 == null || (ru = version6.getRu()) == null) ? 0L : ru.longValue()));
        }
        Lang version7 = langVersionBean.getVersion();
        Long ko2 = version7 != null ? version7.getKo() : null;
        Lang version8 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(ko2, version8 != null ? version8.getKo() : null)) {
            Lang version9 = langVersionBean2.getVersion();
            map.put("ko", Long.valueOf((version9 == null || (ko = version9.getKo()) == null) ? 0L : ko.longValue()));
        }
        Lang version10 = langVersionBean.getVersion();
        Long zhTw2 = version10 != null ? version10.getZhTw() : null;
        Lang version11 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(zhTw2, version11 != null ? version11.getZhTw() : null)) {
            Lang version12 = langVersionBean2.getVersion();
            map.put("zh-tw", Long.valueOf((version12 == null || (zhTw = version12.getZhTw()) == null) ? 0L : zhTw.longValue()));
        }
        Lang version13 = langVersionBean.getVersion();
        Long ja2 = version13 != null ? version13.getJa() : null;
        Lang version14 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(ja2, version14 != null ? version14.getJa() : null)) {
            Lang version15 = langVersionBean2.getVersion();
            map.put("ja", Long.valueOf((version15 == null || (ja = version15.getJa()) == null) ? 0L : ja.longValue()));
        }
        Lang version16 = langVersionBean.getVersion();
        Long en2 = version16 != null ? version16.getEn() : null;
        Lang version17 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(en2, version17 != null ? version17.getEn() : null)) {
            Lang version18 = langVersionBean2.getVersion();
            map.put("en", Long.valueOf((version18 == null || (en = version18.getEn()) == null) ? 0L : en.longValue()));
        }
        Lang version19 = langVersionBean.getVersion();
        Long pl3 = version19 != null ? version19.getPl() : null;
        Lang version20 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(pl3, version20 != null ? version20.getPl() : null)) {
            Lang version21 = langVersionBean2.getVersion();
            map.put("pl", Long.valueOf((version21 == null || (pl2 = version21.getPl()) == null) ? 0L : pl2.longValue()));
        }
        Lang version22 = langVersionBean.getVersion();
        Long fr2 = version22 != null ? version22.getFr() : null;
        Lang version23 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(fr2, version23 != null ? version23.getFr() : null)) {
            Lang version24 = langVersionBean2.getVersion();
            map.put("fr", Long.valueOf((version24 == null || (fr = version24.getFr()) == null) ? 0L : fr.longValue()));
        }
        Lang version25 = langVersionBean.getVersion();
        Long zh2 = version25 != null ? version25.getZh() : null;
        Lang version26 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(zh2, version26 != null ? version26.getZh() : null)) {
            Lang version27 = langVersionBean2.getVersion();
            map.put("zh", Long.valueOf((version27 == null || (zh = version27.getZh()) == null) ? 0L : zh.longValue()));
        }
        Lang version28 = langVersionBean.getVersion();
        Long es2 = version28 != null ? version28.getEs() : null;
        Lang version29 = langVersionBean2.getVersion();
        if (!Intrinsics.areEqual(es2, version29 != null ? version29.getEs() : null)) {
            Lang version30 = langVersionBean2.getVersion();
            if (version30 != null && (es = version30.getEs()) != null) {
                jLongValue = es.longValue();
            }
            map.put("es", Long.valueOf(jLongValue));
        }
        return map;
    }

    public final void e(@NotNull LifecycleCoroutineScope lifecycleCoroutineScope) {
        Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleCoroutineScope");
        RequestLangBean requestLangBean = new RequestLangBean(null, null, null, null, null, 31, null);
        requestLangBean.setAppName("remote");
        requestLangBean.setAppVersion(ye3.s());
        requestLangBean.setDevice(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        requestLangBean.setTimeMillis(String.valueOf(System.currentTimeMillis()));
        String str = "json加密前===" + WearUtils.A.toJson(requestLangBean);
        String str2 = "json加密后===" + qx.b(WearUtils.A.toJson(requestLangBean));
        uy3.d(lifecycleCoroutineScope, n04.b(), null, new a(requestLangBean, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x011a A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:12:0x0038, B:35:0x0112, B:37:0x011a, B:38:0x0120, B:40:0x0126, B:42:0x012f, B:43:0x0132), top: B:75:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:12:0x0038, B:35:0x0112, B:37:0x011a, B:38:0x0120, B:40:0x0126, B:42:0x012f, B:43:0x0132), top: B:75:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(com.wear.network.presenter.bean.Lang r17, com.wear.bean.LangVersionBean r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sm2.f(com.wear.network.presenter.bean.Lang, com.wear.bean.LangVersionBean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
