package dc;

import com.component.dxbilog.lib.BILogApi;
import com.component.dxbilog.lib.bean.BILogConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.util.WearUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: DXBiLogUtil.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/wear/util/DXBiLogUtil;", "", "()V", "init", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class xd3 {

    @NotNull
    public static final b a = new b(null);

    @NotNull
    public static final Lazy<xd3> b = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    /* compiled from: DXBiLogUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/util/DXBiLogUtil;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<xd3> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final xd3 invoke() {
            return new xd3();
        }
    }

    /* compiled from: DXBiLogUtil.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wear/util/DXBiLogUtil$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/util/DXBiLogUtil;", "getInstance", "()Lcom/wear/util/DXBiLogUtil;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final xd3 a() {
            return (xd3) xd3.b.getValue();
        }
    }

    /* compiled from: DXBiLogUtil.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/wear/util/DXBiLogUtil$init$1", "Lcom/component/dxbilog/lib/listener/IBILogAppActionEngine;", "addLog", "", "logNo", "", FirebaseAnalytics.Param.CONTENT, "", "filterContent", "sendLog", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements as {
        @Override // dc.as
        public void a(@NotNull String logNo, @NotNull Object content) {
            Intrinsics.checkNotNullParameter(logNo, "logNo");
            Intrinsics.checkNotNullParameter(content, "content");
            ye3.R(logNo, b(content));
        }

        public final String b(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            String json = WearUtils.A.toJson(obj);
            Intrinsics.checkNotNullExpressionValue(json, "{\n                    We…ontent)\n                }");
            return json;
        }
    }

    public final void b() {
        BILogApi.b(new c());
        BILogConfig bILogConfig = new BILogConfig();
        bILogConfig.setAppTest(true);
        bILogConfig.setAutoTrackAll(false);
        bILogConfig.setManualAll(false);
        BILogApi.a(bILogConfig);
    }
}
