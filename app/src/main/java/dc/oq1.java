package dc;

import androidx.core.app.NotificationCompat;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import dc.kq1;
import java.text.SimpleDateFormat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseToyCmdBridgeLog.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/base/BaseToyCmdBridgeLog;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public class oq1 {

    @NotNull
    public static final d a = new d(null);

    @NotNull
    public static final Lazy<SimpleDateFormat> b = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public static final Lazy<Boolean> c = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final Object d = new Object();

    @NotNull
    public static final Lazy<wz3> e = LazyKt__LazyJVMKt.lazy(b.a);

    /* compiled from: BaseToyCmdBridgeLog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<SimpleDateFormat> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("HH:mm:ss:SSS");
        }
    }

    /* compiled from: BaseToyCmdBridgeLog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<wz3> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final wz3 invoke() {
            return xz3.a(n04.b());
        }
    }

    /* compiled from: BaseToyCmdBridgeLog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Boolean> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(gd0.i());
        }
    }

    /* compiled from: BaseToyCmdBridgeLog.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0005J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0005J*\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0004J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0004H\u0005J\u001c\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0011\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/base/BaseToyCmdBridgeLog$Companion;", "", "()V", "FILE_DIR", "", "TAG", "dayTimeFormat", "Ljava/text/SimpleDateFormat;", "getDayTimeFormat", "()Ljava/text/SimpleDateFormat;", "dayTimeFormat$delegate", "Lkotlin/Lazy;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope$delegate", "isDebug", "", "()Z", "isDebug$delegate", JoinPoint.SYNCHRONIZATION_LOCK, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "", "tag", NotificationCompat.CATEGORY_MESSAGE, "logType", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeLog$LogType;", "getFileName", "getFilePath", "fileDir", "intercept", "print2File", "printSingle", "cmd", "readFile", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d {

        /* compiled from: BaseToyCmdBridgeLog.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.component.dxtoy.command.common.bridge.base.BaseToyCmdBridgeLog$Companion$print2File$1", f = "BaseToyCmdBridgeLog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ String $fileDir;
            public final /* synthetic */ kq1.b $logType;
            public final /* synthetic */ String $msg;
            public final /* synthetic */ String $tag;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, kq1.b bVar, String str2, String str3, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$fileDir = str;
                this.$logType = bVar;
                this.$tag = str2;
                this.$msg = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$fileDir, this.$logType, this.$tag, this.$msg, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                String str;
                Unit unit;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object obj2 = oq1.d;
                String str2 = this.$fileDir;
                kq1.b bVar = this.$logType;
                String str3 = this.$tag;
                String str4 = this.$msg;
                synchronized (obj2) {
                    d dVar = oq1.a;
                    String strF = dVar.f(str2, bVar);
                    if (bVar.getIsWithTime()) {
                        str = ue0.h(dVar.d()) + ' ' + str3 + '\n' + str4 + '\n';
                    } else {
                        str = str4 + '\n';
                    }
                    ud0.f(strF, str, true);
                    unit = Unit.INSTANCE;
                }
                return unit;
            }
        }

        /* compiled from: BaseToyCmdBridgeLog.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.component.dxtoy.command.common.bridge.base.BaseToyCmdBridgeLog$Companion$printSingle$1", f = "BaseToyCmdBridgeLog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ String $cmd;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Continuation<? super b> continuation) {
                super(2, continuation);
                this.$cmd = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.$cmd, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object obj2 = oq1.d;
                String str = this.$cmd;
                synchronized (obj2) {
                    d dVar = oq1.a;
                    kq1.b bVar = kq1.b.SINGLE;
                    String strL = dVar.l("LogCmd", bVar);
                    if (strL != null && StringsKt__StringsKt.contains$default((CharSequence) strL, (CharSequence) str, false, 2, (Object) null)) {
                        return Unit.INSTANCE;
                    }
                    dVar.j("LogCmd", "ToyCmdBridgeLog", str, bVar);
                    return Unit.INSTANCE;
                }
            }
        }

        public d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void c(@NotNull String tag, @NotNull String msg, @NotNull kq1.b logType) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(logType, "logType");
            de0.i(tag, msg);
            j("LogCmd", tag, msg, logType);
        }

        public final SimpleDateFormat d() {
            return (SimpleDateFormat) oq1.b.getValue();
        }

        public final String e(kq1.b bVar) {
            if (!bVar.getIsFileNameDay()) {
                return bVar.name();
            }
            return ue0.h(ue0.b) + '_' + bVar.name();
        }

        public final String f(String str, kq1.b bVar) {
            return sz.b(str, null, 2, null) + IOUtils.DIR_SEPARATOR_UNIX + e(bVar);
        }

        public final wz3 g() {
            return (wz3) oq1.e.getValue();
        }

        @JvmStatic
        public final boolean h() {
            return !i();
        }

        public final boolean i() {
            return ((Boolean) oq1.c.getValue()).booleanValue();
        }

        public final void j(@NotNull String fileDir, @NotNull String tag, @NotNull String msg, @NotNull kq1.b logType) {
            Intrinsics.checkNotNullParameter(fileDir, "fileDir");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(logType, "logType");
            uy3.d(g(), null, null, new a(fileDir, logType, tag, msg, null), 3, null);
        }

        @JvmStatic
        public final void k(@NotNull String cmd) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            uy3.d(g(), null, null, new b(cmd, null), 3, null);
        }

        @Nullable
        public final String l(@NotNull String fileDir, @NotNull kq1.b logType) {
            Intrinsics.checkNotNullParameter(fileDir, "fileDir");
            Intrinsics.checkNotNullParameter(logType, "logType");
            return ud0.d(f(fileDir, logType), "UTF-8");
        }
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull String str2, @NotNull kq1.b bVar) {
        a.c(str, str2, bVar);
    }

    @JvmStatic
    public static final boolean f() {
        return a.h();
    }

    @JvmStatic
    public static final void g(@NotNull String str) {
        a.k(str);
    }
}
