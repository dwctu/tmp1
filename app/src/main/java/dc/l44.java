package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SharedFlow.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", TtmlNode.TAG_HEAD, "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", FirebaseAnalytics.Param.INDEX, "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class l44<T> extends u44<n44> implements f44<T>, Object<T>, d54<T> {
    public final int e;
    public final int f;

    @NotNull
    public final s24 g;

    @Nullable
    public Object[] h;
    public long i;
    public long j;
    public int k;
    public int l;

    /* compiled from: SharedFlow.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", FirebaseAnalytics.Param.INDEX, "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements o04 {

        @JvmField
        @NotNull
        public final l44<?> a;

        @JvmField
        public long b;

        @JvmField
        @Nullable
        public final Object c;

        @JvmField
        @NotNull
        public final Continuation<Unit> d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull l44<?> l44Var, long j, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
            this.a = l44Var;
            this.b = j;
            this.c = obj;
            this.d = continuation;
        }

        @Override // dc.o04
        public void dispose() {
            this.a.v(this);
        }
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[s24.values().length];
            iArr[s24.SUSPEND.ordinal()] = 1;
            iArr[s24.DROP_LATEST.ordinal()] = 2;
            iArr[s24.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {373, 380, 383}, m = "collect$suspendImpl", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class c extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;
        public final /* synthetic */ l44<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l44<T> l44Var, Continuation<? super c> continuation) {
            super(continuation);
            this.this$0 = l44Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l44.x(this.this$0, null, this);
        }
    }

    public l44(int i, int i2, @NotNull s24 s24Var) {
        this.e = i;
        this.f = i2;
        this.g = s24Var;
    }

    public static /* synthetic */ Object C(l44 l44Var, Object obj, Continuation continuation) {
        Object objD;
        return (!l44Var.b(obj) && (objD = l44Var.D(obj, continuation)) == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objD : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object x(dc.l44 r8, dc.u34 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.l44.x(dc.l44, dc.u34, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // dc.u44
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public n44[] g(int i) {
        return new n44[i];
    }

    public final void B() {
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        m44.g(objArr, H(), null);
        this.k--;
        long jH = H() + 1;
        if (this.i < jH) {
            this.i = jH;
        }
        if (this.j < jH) {
            y(jH);
        }
        if (a04.a()) {
            if (!(H() == jH)) {
                throw new AssertionError();
            }
        }
    }

    public final Object D(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArrF;
        a aVar;
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        Continuation<Unit>[] continuationArrF2 = v44.a;
        synchronized (this) {
            if (N(t)) {
                Result.Companion companion = Result.INSTANCE;
                zy3Var.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
                continuationArrF = F(continuationArrF2);
                aVar = null;
            } else {
                a aVar2 = new a(this, L() + H(), t, zy3Var);
                E(aVar2);
                this.l++;
                if (this.f == 0) {
                    continuationArrF2 = F(continuationArrF2);
                }
                continuationArrF = continuationArrF2;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            bz3.a(zy3Var, aVar);
        }
        int i = 0;
        int length = continuationArrF.length;
        while (i < length) {
            Continuation<Unit> continuation2 = continuationArrF[i];
            i++;
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
            }
        }
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : Unit.INSTANCE;
    }

    public final void E(Object obj) {
        int iL = L();
        Object[] objArrM = this.h;
        if (objArrM == null) {
            objArrM = M(null, 0, 2);
        } else if (iL >= objArrM.length) {
            objArrM = M(objArrM, iL, objArrM.length * 2);
        }
        m44.g(objArrM, H() + iL, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation<Unit>[] F(Continuation<Unit>[] continuationArr) {
        w44[] w44VarArr;
        n44 n44Var;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (this.b != 0 && (w44VarArr = this.a) != null) {
            int i = 0;
            int length2 = w44VarArr.length;
            while (i < length2) {
                w44 w44Var = w44VarArr[i];
                i++;
                if (w44Var != null && (continuation = (n44Var = (n44) w44Var).b) != null && P(n44Var) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(CopyOf, "copyOf(this, newSize)");
                        continuationArr = CopyOf;
                    }
                    continuationArr[length] = continuation;
                    n44Var.b = null;
                    length++;
                }
            }
        }
        return continuationArr;
    }

    public final long G() {
        return H() + this.k;
    }

    public final long H() {
        return Math.min(this.j, this.i);
    }

    public final Object I(long j) {
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        Object objF = m44.f(objArr, j);
        return objF instanceof a ? ((a) objF).c : objF;
    }

    public final long J() {
        return H() + this.k + this.l;
    }

    public final int K() {
        return (int) ((H() + this.k) - this.i);
    }

    public final int L() {
        return this.k + this.l;
    }

    public final Object[] M(Object[] objArr, int i, int i2) {
        if (!(i2 > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i2];
        this.h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jH = H();
        for (int i3 = 0; i3 < i; i3++) {
            long j = i3 + jH;
            m44.g(objArr2, j, m44.f(objArr, j));
        }
        return objArr2;
    }

    public final boolean N(T t) {
        if (getB() == 0) {
            return O(t);
        }
        if (this.k >= this.f && this.j <= this.i) {
            int i = b.a[this.g.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        E(t);
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 > this.f) {
            B();
        }
        if (K() > this.e) {
            R(this.i + 1, this.j, G(), J());
        }
        return true;
    }

    public final boolean O(T t) {
        if (a04.a()) {
            if (!(getB() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.e == 0) {
            return true;
        }
        E(t);
        int i = this.k + 1;
        this.k = i;
        if (i > this.e) {
            B();
        }
        this.j = H() + this.k;
        return true;
    }

    public final long P(n44 n44Var) {
        long j = n44Var.a;
        if (j < G()) {
            return j;
        }
        if (this.f <= 0 && j <= H() && this.l != 0) {
            return j;
        }
        return -1L;
    }

    public final Object Q(n44 n44Var) {
        Object obj;
        Continuation<Unit>[] continuationArrS = v44.a;
        synchronized (this) {
            long jP = P(n44Var);
            if (jP < 0) {
                obj = m44.a;
            } else {
                long j = n44Var.a;
                Object objI = I(jP);
                n44Var.a = jP + 1;
                continuationArrS = S(j);
                obj = objI;
            }
        }
        int i = 0;
        int length = continuationArrS.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArrS[i];
            i++;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    public final void R(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        if (a04.a()) {
            if (!(jMin >= H())) {
                throw new AssertionError();
            }
        }
        for (long jH = H(); jH < jMin; jH = 1 + jH) {
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            m44.g(objArr, jH, null);
        }
        this.i = j;
        this.j = j2;
        this.k = (int) (j3 - jMin);
        this.l = (int) (j4 - j3);
        if (a04.a()) {
            if (!(this.k >= 0)) {
                throw new AssertionError();
            }
        }
        if (a04.a()) {
            if (!(this.l >= 0)) {
                throw new AssertionError();
            }
        }
        if (a04.a()) {
            if (!(this.i <= H() + ((long) this.k))) {
                throw new AssertionError();
            }
        }
    }

    @NotNull
    public final Continuation<Unit>[] S(long j) {
        long j2;
        w44[] w44VarArr;
        if (a04.a()) {
            if (!(j >= this.j)) {
                throw new AssertionError();
            }
        }
        if (j > this.j) {
            return v44.a;
        }
        long jH = H();
        long j3 = this.k + jH;
        long j4 = 1;
        if (this.f == 0 && this.l > 0) {
            j3++;
        }
        if (this.b != 0 && (w44VarArr = this.a) != null) {
            int length = w44VarArr.length;
            int i = 0;
            while (i < length) {
                w44 w44Var = w44VarArr[i];
                i++;
                if (w44Var != null) {
                    long j5 = ((n44) w44Var).a;
                    if (j5 >= 0 && j5 < j3) {
                        j3 = j5;
                    }
                }
            }
        }
        if (a04.a()) {
            if (!(j3 >= this.j)) {
                throw new AssertionError();
            }
        }
        if (j3 <= this.j) {
            return v44.a;
        }
        long jG = G();
        int iMin = getB() > 0 ? Math.min(this.l, this.f - ((int) (jG - j3))) : this.l;
        Continuation<Unit>[] continuationArr = v44.a;
        long j6 = this.l + jG;
        if (iMin > 0) {
            continuationArr = new Continuation[iMin];
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            long j7 = jG;
            int i2 = 0;
            while (true) {
                if (jG >= j6) {
                    j2 = j3;
                    break;
                }
                long j8 = jG + j4;
                Object objF = m44.f(objArr, jG);
                t64 t64Var = m44.a;
                if (objF != t64Var) {
                    j2 = j3;
                    Objects.requireNonNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i3 = i2 + 1;
                    continuationArr[i2] = aVar.d;
                    m44.g(objArr, jG, t64Var);
                    m44.g(objArr, j7, aVar.c);
                    j7++;
                    if (i3 >= iMin) {
                        break;
                    }
                    i2 = i3;
                    jG = j8;
                    j3 = j2;
                } else {
                    jG = j8;
                }
                j4 = 1;
            }
            jG = j7;
        } else {
            j2 = j3;
        }
        int i4 = (int) (jG - jH);
        long j9 = getB() == 0 ? jG : j2;
        long jMax = Math.max(this.i, jG - Math.min(this.e, i4));
        if (this.f == 0 && jMax < j6) {
            Object[] objArr2 = this.h;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(m44.f(objArr2, jMax), m44.a)) {
                jG++;
                jMax++;
            }
        }
        R(jMax, j9, jG, j6);
        w();
        return true ^ (continuationArr.length == 0) ? F(continuationArr) : continuationArr;
    }

    public final long T() {
        long j = this.i;
        if (j < this.j) {
            this.j = j;
        }
        return j;
    }

    @Override // dc.d54
    @NotNull
    public t34<T> a(@NotNull CoroutineContext coroutineContext, int i, @NotNull s24 s24Var) {
        return m44.e(this, coroutineContext, i, s24Var);
    }

    @Override // dc.f44
    public boolean b(T t) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArrF = v44.a;
        synchronized (this) {
            i = 0;
            if (N(t)) {
                continuationArrF = F(continuationArrF);
                z = true;
            } else {
                z = false;
            }
        }
        int length = continuationArrF.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArrF[i];
            i++;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    @Override // dc.k44, dc.t34
    @Nullable
    public Object collect(@NotNull u34<? super T> u34Var, @NotNull Continuation<?> continuation) {
        return x(this, u34Var, continuation);
    }

    @Override // dc.u34
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        return C(this, t, continuation);
    }

    public final Object u(n44 n44Var, Continuation<? super Unit> continuation) {
        Unit unit;
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        synchronized (this) {
            if (P(n44Var) < 0) {
                n44Var.b = zy3Var;
                n44Var.b = zy3Var;
            } else {
                Result.Companion companion = Result.INSTANCE;
                zy3Var.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
            }
            unit = Unit.INSTANCE;
        }
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : unit;
    }

    public final void v(a aVar) {
        synchronized (this) {
            if (aVar.b < H()) {
                return;
            }
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            if (m44.f(objArr, aVar.b) != aVar) {
                return;
            }
            m44.g(objArr, aVar.b, m44.a);
            w();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void w() {
        if (this.f != 0 || this.l > 1) {
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            while (this.l > 0 && m44.f(objArr, (H() + L()) - 1) == m44.a) {
                this.l--;
                m44.g(objArr, H() + L(), null);
            }
        }
    }

    public final void y(long j) {
        w44[] w44VarArr;
        if (this.b != 0 && (w44VarArr = this.a) != null) {
            int i = 0;
            int length = w44VarArr.length;
            while (i < length) {
                w44 w44Var = w44VarArr[i];
                i++;
                if (w44Var != null) {
                    n44 n44Var = (n44) w44Var;
                    long j2 = n44Var.a;
                    if (j2 >= 0 && j2 < j) {
                        n44Var.a = j;
                    }
                }
            }
        }
        this.j = j;
    }

    @Override // dc.u44
    @NotNull
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public n44 f() {
        return new n44();
    }
}
