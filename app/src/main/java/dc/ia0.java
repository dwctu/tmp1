package dc;

import androidx.exifinterface.media.ExifInterface;
import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: ToyCommandCoreManager.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u001e\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'J,\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010(\u001a\u00020 2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020,J\u001a\u0010-\u001a\u00020\u001e\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lcom/component/dxtoy/core/commandcore/ToyCommandCoreManager;", "", "()V", "commandDispatcher", "Lcom/component/dxtoy/core/commandcore/dispatcher/ToyCommandDispatcher;", "getCommandDispatcher$core_release", "()Lcom/component/dxtoy/core/commandcore/dispatcher/ToyCommandDispatcher;", "commandDispatcher$delegate", "Lkotlin/Lazy;", "commandInterceptor", "Lcom/component/dxtoy/core/commandcore/interceptor/ToyCommandInterceptor;", "getCommandInterceptor$core_release", "()Lcom/component/dxtoy/core/commandcore/interceptor/ToyCommandInterceptor;", "commandInterceptor$delegate", "commandQueue", "Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueue;", "getCommandQueue$core_release", "()Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueue;", "commandQueue$delegate", "commandReceive", "Lcom/component/dxtoy/core/commandcore/ToyCommandReceive;", "getCommandReceive$core_release", "()Lcom/component/dxtoy/core/commandcore/ToyCommandReceive;", "commandReceive$delegate", "commandSend", "Lcom/component/dxtoy/core/commandcore/ToyCommandSend;", "getCommandSend$core_release", "()Lcom/component/dxtoy/core/commandcore/ToyCommandSend;", "commandSend$delegate", "cancelAll", "", "mac", "", "registerDispatcher", ExifInterface.GPS_DIRECTION_TRUE, "handler", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "sendCommand", "commandBean", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "value", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "", "unregisterDispatcher", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ia0 {

    @NotNull
    public static final ia0 a = new ia0();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(e.a);

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public static final Lazy e = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy f = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: ToyCommandCoreManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/dispatcher/ToyCommandDispatcher;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<qa0> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final qa0 invoke() {
            return new qa0();
        }
    }

    /* compiled from: ToyCommandCoreManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/interceptor/ToyCommandInterceptor;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ua0> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ua0 invoke() {
            return new ua0();
        }
    }

    /* compiled from: ToyCommandCoreManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueue;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<wa0> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final wa0 invoke() {
            return new wa0();
        }
    }

    /* compiled from: ToyCommandCoreManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/ToyCommandReceive;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<ja0> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ja0 invoke() {
            return new ja0();
        }
    }

    /* compiled from: ToyCommandCoreManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/ToyCommandSend;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<ka0> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ka0 invoke() {
            return new ka0();
        }
    }

    public final void a(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        d().d(mac);
    }

    @NotNull
    public final qa0 b() {
        return (qa0) f.getValue();
    }

    @NotNull
    public final ua0 c() {
        return (ua0) e.getValue();
    }

    @NotNull
    public final wa0 d() {
        return (wa0) b.getValue();
    }

    @NotNull
    public final ja0 e() {
        return (ja0) d.getValue();
    }

    @NotNull
    public final ka0 f() {
        return (ka0) c.getValue();
    }

    public final <T> void g(@NotNull sa0<T> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        b().b(handler);
    }

    public final void h(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        f().a(commandBean);
    }

    public final void i(@NotNull String mac, @NotNull String value, @Nullable fw fwVar, boolean z) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        f().b(mac, value, fwVar, z);
    }
}
