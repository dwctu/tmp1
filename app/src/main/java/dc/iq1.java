package dc;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyClock.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/clock/ToyClock;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class iq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyClock.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0007J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¨\u0006\u001b"}, d2 = {"Lcom/wear/component/dxtoy/command/clock/ToyClock$Companion;", "", "()V", "getAI", "", "mac", "", "getAllClock", "getClock", "value", "", "getConnectToysAllClock", "getExecutingClock", "onGetClockAI", MultipleAddresses.Address.ELEMENT, "removeAllClock", "removeClock", "setAIW", "setClock", "value1", "value2", "value3", "value4", "updateAgArray", "agValue", "updateAiValue", "aiValue", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* compiled from: ToyClock.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.component.dxtoy.command.clock.ToyClock$Companion$onGetClockAI$1", f = "ToyClock.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: dc.iq1$a$a, reason: collision with other inner class name */
        public static final class C0186a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ String $address;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0186a(String str, Continuation<? super C0186a> continuation) {
                super(2, continuation);
                this.$address = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0186a(this.$address, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((C0186a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (h04.a(300L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                iq1.a.b(this.$address);
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                e00.a.a(mac);
            } else {
                pc1.a.e(mac, "AI;");
            }
        }

        @JvmStatic
        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                e00.a.b(mac);
            } else {
                pc1.a.e(mac, "AG;");
            }
        }

        @JvmStatic
        public final void c() {
            for (Toy toy : pc1.a.P()) {
                a aVar = iq1.a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "it.address");
                aVar.b(address);
            }
        }

        @JvmStatic
        public final void d(@NotNull String address, @NotNull String value) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(value, "value");
            j(address, value);
            uy3.d(xz3.a(n04.a()), null, null, new C0186a(address, null), 3, null);
        }

        @JvmStatic
        public final void e(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                e00.a.e(mac);
            } else {
                pc1.a.e(mac, "AC;");
            }
        }

        @JvmStatic
        public final void f(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                e00.a.f(mac, i);
                return;
            }
            pc1.a.e(mac, "AD:" + i + ';');
        }

        @JvmStatic
        public final void g(@NotNull String mac, @NotNull String value) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            if (mp1.a.b()) {
                e00.a.g(mac, value);
                return;
            }
            pc1.a.e(mac, "AIW:" + value + ';');
        }

        @JvmStatic
        public final void h(@NotNull String mac, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                e00.a.h(mac, i, i2, i3, i4);
                return;
            }
            pc1.a.e(mac, "AW:" + i + ':' + i2 + ':' + i3 + ':' + i4 + ';');
        }

        @JvmStatic
        public final void i(@NotNull String address, @Nullable String str) {
            Toy toyQ;
            Intrinsics.checkNotNullParameter(address, "address");
            if (str != null) {
                if (!(str.length() > 0) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "null", false, 2, (Object) null) || (toyQ = pc1.a.Q(address)) == null) {
                    return;
                }
                toyQ.setAgString(StringsKt__StringsJVMKt.replace$default(str, ";", "", false, 4, (Object) null));
            }
        }

        public final void j(String str, String str2) {
            Toy toyQ = pc1.a.Q(str);
            if (toyQ != null) {
                toyQ.setAiString(StringsKt__StringsJVMKt.replace$default(str2, ";", "", false, 4, (Object) null), true);
            }
        }
    }

    static {
        g00.b.e(new ta0() { // from class: dc.gq1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                iq1.a((Unit) obj, str, str2, bArr, str3);
            }
        });
        f00.b.e(new ta0() { // from class: dc.hq1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                iq1.b((Boolean) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(Unit unit, String mac, String value, byte[] bytes, String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        a.i(mac, value);
    }

    public static final void b(Boolean bool, String mac, String value, byte[] bytes, String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        a.d(mac, value);
    }

    @JvmStatic
    public static final void c(@NotNull String str) {
        a.a(str);
    }

    @JvmStatic
    public static final void d(@NotNull String str) {
        a.b(str);
    }

    @JvmStatic
    public static final void e() {
        a.c();
    }

    @JvmStatic
    public static final void h(@NotNull String str, @NotNull String str2) {
        a.d(str, str2);
    }

    @JvmStatic
    public static final void i(@NotNull String str) {
        a.e(str);
    }

    @JvmStatic
    public static final void j(@NotNull String str, int i) {
        a.f(str, i);
    }

    @JvmStatic
    public static final void k(@NotNull String str, @NotNull String str2) {
        a.g(str, str2);
    }

    @JvmStatic
    public static final void l(@NotNull String str, int i, int i2, int i3, int i4) {
        a.h(str, i, i2, i3, i4);
    }

    @JvmStatic
    public static final void m(@NotNull String str, @Nullable String str2) {
        a.i(str, str2);
    }
}
