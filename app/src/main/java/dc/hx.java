package dc;

import androidx.core.app.NotificationCompat;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXDLog.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J5\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0013J5\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0013J5\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u0010\u0019\u001a\u00020\fH\u0007J\u001c\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J5\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0013J5\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lcom/component/dxdlog/DXDLog;", "", "()V", "appCode", "", "dxdLogImp", "Lcom/component/dxdlog/DXDLogImp;", "getDxdLogImp", "()Lcom/component/dxdlog/DXDLogImp;", "dxdLogImp$delegate", "Lkotlin/Lazy;", "bindUser", "", "accountCode", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "tag", NotificationCompat.CATEGORY_MESSAGE, "formatArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "init", "config", "Lcom/component/dxdlog/DXDLogConfig;", "releaseDXLogInstance", "uploadLogWithReason", "reason", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxdlog/UploadLogListener;", PSOProgramService.VS_Key, "w", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class hx {

    @Nullable
    public static String b;

    @NotNull
    public static final hx a = new hx();

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: DXDLog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxdlog/DXDLogImp;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<lx> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lx invoke() {
            if (hx.b == null) {
                de0.l("Please init sdk at firstly");
                Unit unit = Unit.INSTANCE;
            }
            return new lx();
        }
    }

    @JvmStatic
    public static final void b(@Nullable String str) {
        a.e().g(str);
    }

    @JvmStatic
    public static final void c(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        a.e().h(tag, msg, formatArgs);
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        a.e().i(tag, msg, formatArgs);
    }

    @JvmStatic
    public static final void f(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        a.e().j(tag, msg, formatArgs);
    }

    @JvmStatic
    public static final void g(@NotNull String appCode, @Nullable jx jxVar) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        hx hxVar = a;
        b = appCode;
        lx lxVarE = hxVar.e();
        if (jxVar == null) {
            jxVar = new jx();
        }
        lxVarE.k(appCode, jxVar);
    }

    @JvmStatic
    public static final void h(@Nullable String str, @Nullable nx nxVar) {
        a.e().s(str, nxVar);
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        a.e().u(tag, msg, formatArgs);
    }

    @JvmStatic
    public static final void j(@NotNull String tag, @NotNull String msg, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        a.e().v(tag, msg, formatArgs);
    }

    public final lx e() {
        return (lx) c.getValue();
    }
}
