package dc;

import com.component.dxbilog.lib.bean.BILogHttpConfigDefault;
import com.component.dxbilog.lib.bean.BILogUserConfig;
import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxhttp.NetException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BILogManualManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u001c\u0010\u001f\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0013R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogManualManager;", "Lcom/component/dxbilog/lib/auto/listener/IBILogManualManager;", "()V", "value", "Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "httpConfig", "getHttpConfig", "()Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "setHttpConfig", "(Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;)V", "httpConfigDefault", "Lcom/component/dxbilog/lib/bean/BILogHttpConfigDefault;", "getHttpConfigDefault", "()Lcom/component/dxbilog/lib/bean/BILogHttpConfigDefault;", "setHttpConfigDefault", "(Lcom/component/dxbilog/lib/bean/BILogHttpConfigDefault;)V", "userConfigHashMap", "Ljava/util/HashMap;", "", "Lcom/component/dxbilog/lib/bean/BILogUserConfig;", "Lkotlin/collections/HashMap;", "add", "", "logNo", FirebaseAnalytics.Param.CONTENT, "", "getUserConfig", "accountCode", "init", "initHttpConfig", "initUserConfig", "send", "setUserConfig", "userConfig", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ls {

    @Nullable
    public BILogHttpConfigDefault a;

    @Nullable
    public volatile BILogHttpConfig b;

    @NotNull
    public HashMap<String, BILogUserConfig> c = new HashMap<>();

    /* compiled from: BILogManualManager.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxbilog/lib/manager/BILogManualManager$initHttpConfig$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ny<BILogHttpConfig> {
        public a() {
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull BILogHttpConfig response) {
            Intrinsics.checkNotNullParameter(response, "response");
            ms.a.a("BILogManualConsume", "initHttpConfig======onSuccess=======");
            ls.this.g(response);
        }
    }

    public void a(@Nullable String str, @Nullable Object obj) {
        if (ks.a.h()) {
            qs.a.a(str, obj);
        }
    }

    @Nullable
    public final BILogHttpConfig b() {
        if (this.b == null) {
            this.b = BILogHttpConfig.INSTANCE.load();
            if (this.b == null) {
                this.b = new BILogHttpConfig(0, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 0, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 4095, null);
            }
            ms.a.a(Intrinsics.stringPlus("httpConfig = ", this.b));
        }
        return this.b;
    }

    @Nullable
    public final BILogHttpConfigDefault c() {
        if (this.a == null) {
            this.a = new BILogHttpConfigDefault();
        }
        return this.a;
    }

    @Nullable
    public final BILogUserConfig d(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        BILogUserConfig bILogUserConfigLoad = this.c.get(str);
        if (bILogUserConfigLoad == null) {
            bILogUserConfigLoad = BILogUserConfig.INSTANCE.load(str);
            if (bILogUserConfigLoad == null) {
                bILogUserConfigLoad = new BILogUserConfig(null, false, 3, null);
                bILogUserConfigLoad.setAccountCode(str);
            }
            this.c.put(str, bILogUserConfigLoad);
        }
        return bILogUserConfigLoad;
    }

    public final void e() {
        f();
        if (ks.a.h()) {
            rs.c.c();
        } else {
            rs.c.d();
        }
    }

    public void f() {
        if (ks.a.h()) {
            ms.a.a("BILogManualConsume", "initHttpConfig=============");
            ss.a.a(new a());
        }
    }

    public final void g(@Nullable BILogHttpConfig bILogHttpConfig) {
        this.b = bILogHttpConfig;
        BILogHttpConfig.INSTANCE.save(bILogHttpConfig);
    }
}
