package dc;

import dc.e90;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCommandManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J$\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001c\u0010\u0014\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0016R-\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/component/dxtoy/command/ToyCommandManager;", "Lcom/component/dxtoy/command/listener/IToyCommandManager;", "()V", "orderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "getOrderMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "orderMap$delegate", "Lkotlin/Lazy;", "queueSchedule", "Lcom/component/dxtoy/command/DealCommandQueueSchedule;", "getQueueSchedule", "()Lcom/component/dxtoy/command/DealCommandQueueSchedule;", "queueSchedule$delegate", "cancelAll", "", "mac", "sendCommand", "command", "valueMap", "", "", "sendCommandList", "commandList", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class l40 implements e90 {

    @NotNull
    public static final l40 a = new l40();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(c.a);

    /* compiled from: ToyCommandManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[na0.values().length];
            iArr[na0.CTRL_SINGLE.ordinal()] = 1;
            iArr[na0.CTRL_MULTI.ordinal()] = 2;
            iArr[na0.CTRL_LVS.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: ToyCommandManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ConcurrentHashMap<String, ConcurrentLinkedQueue<b90>>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, ConcurrentLinkedQueue<b90>> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: ToyCommandManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/command/DealCommandQueueSchedule;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<k40> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k40 invoke() {
            return new k40();
        }
    }

    /* compiled from: ToyCommandManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.component.dxtoy.command.ToyCommandManager$sendCommand$2", f = "ToyCommandManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $mac;
        public final /* synthetic */ Map<String, Integer> $valueMap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Map<String, Integer> map, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$mac = str;
            this.$valueMap = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$mac, this.$valueMap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            l40.a.g(c90.a.a(this.$mac, this.$valueMap));
            return Unit.INSTANCE;
        }
    }

    public void a(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        ConcurrentLinkedQueue<b90> concurrentLinkedQueue = b().get(mac);
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        f90.a.b(mac);
    }

    @NotNull
    public final ConcurrentHashMap<String, ConcurrentLinkedQueue<b90>> b() {
        return (ConcurrentHashMap) b.getValue();
    }

    public final k40 c() {
        return (k40) c.getValue();
    }

    public <T> void d(@NotNull sa0<T> sa0Var) {
        e90.a.a(this, sa0Var);
    }

    public void e(@NotNull b90 command) {
        Intrinsics.checkNotNullParameter(command, "command");
        int i = a.a[command.getCommandConstant().getD().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            c().e(command);
        } else if (command.g()) {
            f90.a.k(command);
        }
    }

    public void f(@NotNull String mac, @NotNull Map<String, Integer> valueMap) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(valueMap, "valueMap");
        uy3.d(xz3.a(n04.b()), null, null, new d(mac, valueMap, null), 3, null);
    }

    public void g(@NotNull List<? extends b90> commandList) {
        Intrinsics.checkNotNullParameter(commandList, "commandList");
        Iterator<T> it = commandList.iterator();
        while (it.hasNext()) {
            a.e((b90) it.next());
        }
    }
}
