package dc;

import com.component.dxdlog.bean.LogServerRequestBean;
import com.component.dxdlog.bean.SessionToken;
import com.component.dxutilcode.lib.utils.NetworkUtils;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXDLogCache.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/component/dxdlog/DXDLogCache;", "", "()V", "isDoingCheckCacheFileUrls", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkBindUserFileUrl", "", "deleteAmazonS3TokenResponse", "deleteUploadFileInfo", "reqStr", "", "doCheckBindUserFileUrl", "loadAmazonS3TokenResponse", "Lcom/component/dxdlog/bean/SessionToken;", "loadUploadFileInfo", "", "saveAmazonS3TokenResponse", "tokenResp", "saveUploadFileInfo", "Companion", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ix {

    @NotNull
    public static final b b = new b(null);

    @NotNull
    public static final Lazy<ix> c = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: DXDLogCache.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxdlog/DXDLogCache;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<ix> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ix invoke() {
            return new ix();
        }
    }

    /* compiled from: DXDLogCache.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u00020\u00078FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/component/dxdlog/DXDLogCache$Companion;", "", "()V", "SP_KEY_AMAZON_S3_TOKEN_RESPONSE", "", "SP_KEY_BIND_LOG_URL_REQUEST", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/component/dxdlog/DXDLogCache;", "getInstance$annotations", "getInstance", "()Lcom/component/dxdlog/DXDLogCache;", "instance$delegate", "Lkotlin/Lazy;", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ix a() {
            return (ix) ix.c.getValue();
        }
    }

    /* compiled from: DXDLogCache.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "Lcom/component/dxdlog/bean/LogServerRequestBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function3<Boolean, String, LogServerRequestBean, Unit> {
        public final /* synthetic */ CountDownLatch $countDownLatch;
        public final /* synthetic */ String $reqBeanStr;
        public final /* synthetic */ ix this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CountDownLatch countDownLatch, ix ixVar, String str) {
            super(3);
            this.$countDownLatch = countDownLatch;
            this.this$0 = ixVar;
            this.$reqBeanStr = str;
        }

        public final void a(boolean z, @Nullable String str, @Nullable LogServerRequestBean logServerRequestBean) {
            this.$countDownLatch.countDown();
            if (z) {
                this.this$0.f(this.$reqBeanStr);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, LogServerRequestBean logServerRequestBean) {
            a(bool.booleanValue(), str, logServerRequestBean);
            return Unit.INSTANCE;
        }
    }

    public static final void d(ix this$0) throws InterruptedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NetworkUtils.d() && this$0.a.compareAndSet(false, true)) {
            this$0.g();
        }
    }

    public final void c() {
        se0.b().execute(new Runnable() { // from class: dc.ex
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                ix.d(this.a);
            }
        });
    }

    public final void e() {
        ne0.d().s("sp_key_amazon_s3_token_response");
    }

    public final void f(String str) {
        Set<String> setI = ne0.d().i("sp_key_bind_log_url_request");
        setI.remove(str);
        ne0.d().o("sp_key_bind_log_url_request", setI);
    }

    public final void g() throws InterruptedException {
        Set<String> setJ = j();
        if (setJ.isEmpty()) {
            this.a.set(false);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(setJ.size());
        for (String str : setJ) {
            LogServerRequestBean requestBean = (LogServerRequestBean) xd0.d(str, LogServerRequestBean.class);
            mx mxVarA = mx.a.a();
            Intrinsics.checkNotNullExpressionValue(requestBean, "requestBean");
            mxVarA.d(requestBean, new c(countDownLatch, this, str));
        }
        countDownLatch.await();
        this.a.set(false);
    }

    @Nullable
    public final SessionToken i() {
        return (SessionToken) ne0.d().a("sp_key_amazon_s3_token_response", SessionToken.class);
    }

    public final Set<String> j() {
        Set<String> setI = ne0.d().i("sp_key_bind_log_url_request");
        Intrinsics.checkNotNullExpressionValue(setI, "getInstance().getStringS…KEY_BIND_LOG_URL_REQUEST)");
        return setI;
    }

    public final void k(@NotNull SessionToken tokenResp) {
        Intrinsics.checkNotNullParameter(tokenResp, "tokenResp");
        ne0.d().l("sp_key_amazon_s3_token_response", tokenResp);
    }

    public final void l(@NotNull String reqStr) {
        Intrinsics.checkNotNullParameter(reqStr, "reqStr");
        Set<String> setI = ne0.d().i("sp_key_bind_log_url_request");
        setI.add(reqStr);
        ne0.d().o("sp_key_bind_log_url_request", setI);
    }
}
