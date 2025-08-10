package dc;

import dc.g30;
import dc.q90;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyRssi.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0005J\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0006j\b\u0012\u0004\u0012\u00020\u0005`\u00072\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$R7\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0006j\b\u0012\u0004\u0012\u00020\u0005`\u00070\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/component/dxtoy/business/toyinfo/rssi/ToyRssi;", "", "()V", "rssiListMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRssiListMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "rssiListMap$delegate", "Lkotlin/Lazy;", "rssiResponseList", "", "Lcom/component/dxtoy/business/toyinfo/rssi/ToyRssiResponse;", "getRssiResponseList", "()Ljava/util/List;", "rssiResponseList$delegate", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "getTask", "()Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "task$delegate", "getResponse", "mac", "getRssi", "", "getRssiList", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "setIntervalTime", "intervalTime", "", "setRssiList", "rssi", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class g30 {

    @NotNull
    public static final g30 a;

    @NotNull
    public static final Lazy b;

    @NotNull
    public static final Lazy c;

    @NotNull
    public static final Lazy d;

    /* compiled from: ToyRssi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sb0.values().length];
            iArr[sb0.CONNECT_SUC.ordinal()] = 1;
            iArr[sb0.NOT_CONNECT.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: ToyRssi.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0003j\b\u0012\u0004\u0012\u00020\u0002`\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ConcurrentHashMap<String, ArrayList<String>>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, ArrayList<String>> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: ToyRssi.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/component/dxtoy/business/toyinfo/rssi/ToyRssiResponse;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<List<h30>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<h30> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: ToyRssi.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<q90.b> {
        public static final d a = new d();

        /* compiled from: ToyRssi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.component.dxtoy.business.toyinfo.rssi.ToyRssi$task$2$1$1$1", f = "ToyRssi.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ConcurrentHashMap<String, nb0> $toyMap;
            public Object L$0;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ConcurrentHashMap<String, nb0> concurrentHashMap, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$toyMap = concurrentHashMap;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$toyMap, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Iterator<Map.Entry<String, nb0>> it;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    it = this.$toyMap.entrySet().iterator();
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    Map.Entry<String, nb0> next = it.next();
                    if (next.getValue().getF() == sb0.CONNECT_SUC) {
                        g30.a.b(next.getKey());
                        this.L$0 = it;
                        this.label = 1;
                        if (h04.a(100L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }

        public d() {
            super(0);
        }

        public static final void b() {
            ConcurrentHashMap<String, nb0> concurrentHashMapF = yb0.f();
            if (concurrentHashMapF.size() == 0) {
                return;
            }
            uy3.d(xz3.a(n04.b()), null, null, new a(concurrentHashMapF, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q90.b invoke() {
            return new q90.b() { // from class: dc.f30
                @Override // dc.q90.b
                public final void execute() {
                    g30.d.b();
                }
            };
        }
    }

    static {
        g30 g30Var = new g30();
        a = g30Var;
        b = LazyKt__LazyJVMKt.lazy(c.a);
        c = LazyKt__LazyJVMKt.lazy(b.a);
        d = LazyKt__LazyJVMKt.lazy(d.a);
        wb0.a.b(g30Var);
        g30Var.g(10000L);
    }

    public final synchronized h30 a(String str) {
        Object next;
        h30 h30Var;
        Iterator<T> it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((h30) next).getA(), str)) {
                break;
            }
        }
        h30Var = (h30) next;
        if (h30Var == null) {
            h30Var = new h30(str);
            e().add(h30Var);
        }
        return h30Var;
    }

    public final void b(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        nb0 nb0VarE = yb0.e(mac);
        if (nb0VarE != null && nb0VarE.getF() == sb0.CONNECT_SUC) {
            f90.a.g(mac, a(mac).getB());
        }
    }

    @NotNull
    public final ArrayList<String> c(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        ArrayList<String> arrayList = d().get(mac);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final ConcurrentHashMap<String, ArrayList<String>> d() {
        return (ConcurrentHashMap) c.getValue();
    }

    public final List<h30> e() {
        return (List) b.getValue();
    }

    public final q90.b f() {
        return (q90.b) d.getValue();
    }

    public final void g(long j) {
        q90.c.e(f(), j);
    }

    public final synchronized void h(@NotNull String mac, int i) {
        ArrayList<String> arrayListPutIfAbsent;
        Intrinsics.checkNotNullParameter(mac, "mac");
        ConcurrentHashMap<String, ArrayList<String>> concurrentHashMapD = d();
        ArrayList<String> arrayList = concurrentHashMapD.get(mac);
        if (arrayList == null && (arrayListPutIfAbsent = concurrentHashMapD.putIfAbsent(mac, (arrayList = new ArrayList<>()))) != null) {
            arrayList = arrayListPutIfAbsent;
        }
        ArrayList<String> arrayList2 = arrayList;
        if (arrayList2.size() < 20) {
            arrayList2.add(i + "");
        } else {
            arrayList2.remove(0);
            arrayList2.add(i + "");
        }
    }

    @Subscribe
    public final void onMessageEvent(@NotNull i90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = a.a[event.getB().ordinal()];
        if (i == 1) {
            b(event.getA());
        } else {
            if (i != 2) {
                return;
            }
            d().remove(event.getA());
        }
    }
}
