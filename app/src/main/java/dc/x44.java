package dc;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\fH¤@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R9\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class x44<T> implements d54<T> {

    @JvmField
    @NotNull
    public final CoroutineContext a;

    @JvmField
    public final int b;

    @JvmField
    @NotNull
    public final s24 c;

    /* compiled from: ChannelFlow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ u34<T> $collector;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ x44<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(u34<? super T> u34Var, x44<T> x44Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$collector = u34Var;
            this.this$0 = x44Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.$collector, this.this$0, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                wz3 wz3Var = (wz3) this.L$0;
                u34<T> u34Var = this.$collector;
                h34<T> h34VarI = this.this$0.i(wz3Var);
                this.label = 1;
                if (v34.i(u34Var, h34VarI, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChannelFlow.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<f34<? super T>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ x44<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x44<T> x44Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.this$0 = x44Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(this.this$0, continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull f34<? super T> f34Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(f34Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                f34<? super T> f34Var = (f34) this.L$0;
                x44<T> x44Var = this.this$0;
                this.label = 1;
                if (x44Var.e(f34Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public x44(@NotNull CoroutineContext coroutineContext, int i, @NotNull s24 s24Var) {
        this.a = coroutineContext;
        this.b = i;
        this.c = s24Var;
        if (a04.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
    }

    public static /* synthetic */ Object d(x44 x44Var, u34 u34Var, Continuation continuation) {
        Object objD = xz3.d(new a(u34Var, x44Var, null), continuation);
        return objD == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objD : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002a A[PHI: r6
  0x002a: PHI (r6v12 int) = (r6v2 int), (r6v2 int), (r6v7 int) binds: [B:18:0x0028, B:23:0x0030, B:45:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // dc.d54
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.t34<T> a(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r4, int r5, @org.jetbrains.annotations.NotNull dc.s24 r6) {
        /*
            r3 = this;
            boolean r0 = dc.a04.a()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L17
            r0 = -1
            if (r5 == r0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            if (r0 == 0) goto L11
            goto L17
        L11:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L17:
            kotlin.coroutines.CoroutineContext r0 = r3.a
            kotlin.coroutines.CoroutineContext r4 = r4.plus(r0)
            dc.s24 r0 = dc.s24.SUSPEND
            if (r6 == r0) goto L22
            goto L67
        L22:
            int r6 = r3.b
            r0 = -3
            if (r6 != r0) goto L28
            goto L65
        L28:
            if (r5 != r0) goto L2c
        L2a:
            r5 = r6
            goto L65
        L2c:
            r0 = -2
            if (r6 != r0) goto L30
            goto L65
        L30:
            if (r5 != r0) goto L33
            goto L2a
        L33:
            boolean r6 = dc.a04.a()
            if (r6 == 0) goto L49
            int r6 = r3.b
            if (r6 < 0) goto L3f
            r6 = 1
            goto L40
        L3f:
            r6 = 0
        L40:
            if (r6 == 0) goto L43
            goto L49
        L43:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L49:
            boolean r6 = dc.a04.a()
            if (r6 == 0) goto L5c
            if (r5 < 0) goto L52
            goto L53
        L52:
            r1 = 0
        L53:
            if (r1 == 0) goto L56
            goto L5c
        L56:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L5c:
            int r6 = r3.b
            int r6 = r6 + r5
            if (r6 < 0) goto L62
            goto L2a
        L62:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L65:
            dc.s24 r6 = r3.c
        L67:
            kotlin.coroutines.CoroutineContext r0 = r3.a
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            if (r0 == 0) goto L78
            int r0 = r3.b
            if (r5 != r0) goto L78
            dc.s24 r0 = r3.c
            if (r6 != r0) goto L78
            return r3
        L78:
            dc.x44 r4 = r3.f(r4, r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.x44.a(kotlin.coroutines.CoroutineContext, int, dc.s24):dc.t34");
    }

    @Nullable
    public String c() {
        return null;
    }

    @Override // dc.t34
    @Nullable
    public Object collect(@NotNull u34<? super T> u34Var, @NotNull Continuation<? super Unit> continuation) {
        return d(this, u34Var, continuation);
    }

    @Nullable
    public abstract Object e(@NotNull f34<? super T> f34Var, @NotNull Continuation<? super Unit> continuation);

    @NotNull
    public abstract x44<T> f(@NotNull CoroutineContext coroutineContext, int i, @NotNull s24 s24Var);

    @NotNull
    public final Function2<f34<? super T>, Continuation<? super Unit>, Object> g() {
        return new b(this, null);
    }

    public final int h() {
        int i = this.b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    @NotNull
    public h34<T> i(@NotNull wz3 wz3Var) {
        return d34.c(wz3Var, this.a, h(), this.c, yz3.ATOMIC, null, g(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        CoroutineContext coroutineContext = this.a;
        if (coroutineContext != EmptyCoroutineContext.INSTANCE) {
            arrayList.add(Intrinsics.stringPlus("context=", coroutineContext));
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add(Intrinsics.stringPlus("capacity=", Integer.valueOf(i)));
        }
        s24 s24Var = this.c;
        if (s24Var != s24.SUSPEND) {
            arrayList.add(Intrinsics.stringPlus("onBufferOverflow=", s24Var));
        }
        return b04.a(this) + '[' + CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
