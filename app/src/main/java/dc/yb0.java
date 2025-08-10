package dc;

import com.component.dxtoy.data.bean.OuterToyData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXToyDataApi.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\rH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\rH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\rH\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/component/dxtoy/data/DXToyDataApi;", "", "()V", "isImportingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "clearImportToyDataLabel", "", "deleteToy", "mac", "", "getCacheToy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "getCacheToyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getConnectToy", "getConnectToyByMap", "getConnectToyMap", "getScanToy", "getScanToyMap", "importToyData", "toyData", "Lcom/component/dxtoy/data/bean/OuterToyData;", "toyDataList", "", "isHasImportedToyData", "", "updateOrAddToy", "toy", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class yb0 {

    @NotNull
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: DXToyDataApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.component.dxtoy.data.DXToyDataApi$deleteToy$1", f = "DXToyDataApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $mac;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$mac = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$mac, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                hb0.a.a(this.$mac);
            } finally {
                try {
                    return Unit.INSTANCE;
                } finally {
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: DXToyDataApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.component.dxtoy.data.DXToyDataApi$updateOrAddToy$1", f = "DXToyDataApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $mac;
        public final /* synthetic */ nb0 $toy;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, nb0 nb0Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$mac = str;
            this.$toy = nb0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$mac, this.$toy, continuation);
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
            try {
                hb0.a.l(this.$mac, this.$toy);
            } finally {
                try {
                    return Unit.INSTANCE;
                } finally {
                }
            }
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void b() {
        ib0.a.a();
    }

    @JvmStatic
    public static final void c(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        if ((mac.length() == 0) || !a.compareAndSet(false, true)) {
            return;
        }
        uy3.d(xz3.a(n04.b()), null, null, new a(mac, null), 3, null);
    }

    @JvmStatic
    @NotNull
    public static final ConcurrentHashMap<String, nb0> d() {
        return hb0.a.d();
    }

    @JvmStatic
    @Nullable
    public static final nb0 e(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        nb0 nb0Var = hb0.a.e().get(mac);
        if (nb0Var == null || nb0Var.getF() != sb0.CONNECT_SUC) {
            return null;
        }
        return nb0Var;
    }

    @JvmStatic
    @NotNull
    public static final ConcurrentHashMap<String, nb0> f() {
        return hb0.a.e();
    }

    @JvmStatic
    @NotNull
    public static final ConcurrentHashMap<String, nb0> g() {
        return hb0.a.g();
    }

    @JvmStatic
    public static final void h(@Nullable List<OuterToyData> list) {
        if (ib0.a.e()) {
            return;
        }
        if (a.compareAndSet(false, true)) {
            ArrayList arrayList = null;
            if (list != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (OuterToyData outerToyData : list) {
                        nb0 toyInfo = outerToyData != null ? outerToyData.toToyInfo() : null;
                        if (toyInfo != null) {
                            arrayList2.add(toyInfo);
                        }
                    }
                    arrayList = arrayList2;
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            ib0.a.d(arrayList);
        }
    }

    @JvmStatic
    public static final boolean i() {
        return ib0.a.e();
    }

    @JvmStatic
    public static final void j(@NotNull String mac, @NotNull nb0 toy) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(toy, "toy");
        if ((mac.length() == 0) || !a.compareAndSet(false, true)) {
            return;
        }
        uy3.d(xz3.a(n04.b()), null, null, new b(mac, toy, null), 3, null);
    }
}
