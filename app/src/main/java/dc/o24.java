package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.g64;
import dc.yy3;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class o24<E> extends q24<E> implements t24<E> {

    /* compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\rH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a<E> implements v24<E> {

        @JvmField
        @NotNull
        public final o24<E> a;

        @Nullable
        public Object b = p24.d;

        public a(@NotNull o24<E> o24Var) {
            this.a = o24Var;
        }

        @Override // dc.v24
        @Nullable
        public Object a(@NotNull Continuation<? super Boolean> continuation) {
            Object b = getB();
            t64 t64Var = p24.d;
            if (b != t64Var) {
                return Boxing.boxBoolean(c(getB()));
            }
            e(this.a.P());
            return getB() != t64Var ? Boxing.boxBoolean(c(getB())) : d(continuation);
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getB() {
            return this.b;
        }

        public final boolean c(Object obj) throws Throwable {
            if (!(obj instanceof a34)) {
                return true;
            }
            a34 a34Var = (a34) obj;
            if (a34Var.d == null) {
                return false;
            }
            throw s64.k(a34Var.R());
        }

        public final Object d(Continuation<? super Boolean> continuation) {
            zy3 zy3VarB = bz3.b(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            d dVar = new d(this, zy3VarB);
            while (true) {
                if (this.a.G(dVar)) {
                    this.a.R(zy3VarB, dVar);
                    break;
                }
                Object objP = this.a.P();
                e(objP);
                if (objP instanceof a34) {
                    a34 a34Var = (a34) objP;
                    if (a34Var.d == null) {
                        Result.Companion companion = Result.INSTANCE;
                        zy3VarB.resumeWith(Result.m86constructorimpl(Boxing.boxBoolean(false)));
                    } else {
                        Result.Companion companion2 = Result.INSTANCE;
                        zy3VarB.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(a34Var.R())));
                    }
                } else if (objP != p24.d) {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.a.a;
                    zy3VarB.i(boolBoxBoolean, function1 == null ? null : n64.a(function1, objP, zy3VarB.getB()));
                }
            }
            Object objX = zy3VarB.x();
            if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return objX;
        }

        public final void e(@Nullable Object obj) {
            this.b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.v24
        public E next() throws Throwable {
            E e = (E) this.b;
            if (e instanceof a34) {
                throw s64.k(((a34) e).R());
            }
            t64 t64Var = p24.d;
            if (e == t64Var) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.b = t64Var;
            return e;
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class b<E> extends g34<E> {

        @JvmField
        @NotNull
        public final yy3<Object> d;

        @JvmField
        public final int e;

        public b(@NotNull yy3<Object> yy3Var, int i) {
            this.d = yy3Var;
            this.e = i;
        }

        @Override // dc.g34
        public void M(@NotNull a34<?> a34Var) {
            if (this.e == 1) {
                yy3<Object> yy3Var = this.d;
                Result.Companion companion = Result.INSTANCE;
                yy3Var.resumeWith(Result.m86constructorimpl(x24.b(x24.b.a(a34Var.d))));
            } else {
                yy3<Object> yy3Var2 = this.d;
                Result.Companion companion2 = Result.INSTANCE;
                yy3Var2.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(a34Var.R())));
            }
        }

        @Nullable
        public final Object N(E e) {
            if (this.e != 1) {
                return e;
            }
            x24.b.c(e);
            return x24.b(e);
        }

        @Override // dc.i34
        public void h(E e) {
            this.d.t(az3.a);
        }

        @Override // dc.i34
        @Nullable
        public t64 p(E e, @Nullable g64.c cVar) {
            Object objL = this.d.l(N(e), cVar == null ? null : cVar.a, L(e));
            if (objL == null) {
                return null;
            }
            if (a04.a()) {
                if (!(objL == az3.a)) {
                    throw new AssertionError();
                }
            }
            if (cVar == null) {
                return az3.a;
            }
            cVar.d();
            throw null;
        }

        @Override // dc.g64
        @NotNull
        public String toString() {
            return "ReceiveElement@" + b04.b(this) + "[receiveMode=" + this.e + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c<E> extends b<E> {

        @JvmField
        @NotNull
        public final Function1<E, Unit> f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull yy3<Object> yy3Var, int i, @NotNull Function1<? super E, Unit> function1) {
            super(yy3Var, i);
            this.f = function1;
        }

        @Override // dc.g34
        @Nullable
        public Function1<Throwable, Unit> L(E e) {
            return n64.a(this.f, e, this.d.getB());
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class d<E> extends g34<E> {

        @JvmField
        @NotNull
        public final a<E> d;

        @JvmField
        @NotNull
        public final yy3<Boolean> e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull a<E> aVar, @NotNull yy3<? super Boolean> yy3Var) {
            this.d = aVar;
            this.e = yy3Var;
        }

        @Override // dc.g34
        @Nullable
        public Function1<Throwable, Unit> L(E e) {
            Function1<E, Unit> function1 = this.d.a.a;
            if (function1 == null) {
                return null;
            }
            return n64.a(function1, e, this.e.getB());
        }

        @Override // dc.g34
        public void M(@NotNull a34<?> a34Var) {
            Object objA = a34Var.d == null ? yy3.a.a(this.e, Boolean.FALSE, null, 2, null) : this.e.g(a34Var.R());
            if (objA != null) {
                this.d.e(a34Var);
                this.e.t(objA);
            }
        }

        @Override // dc.i34
        public void h(E e) {
            this.d.e(e);
            this.e.t(az3.a);
        }

        @Override // dc.i34
        @Nullable
        public t64 p(E e, @Nullable g64.c cVar) {
            Object objL = this.e.l(Boolean.TRUE, cVar == null ? null : cVar.a, L(e));
            if (objL == null) {
                return null;
            }
            if (a04.a()) {
                if (!(objL == az3.a)) {
                    throw new AssertionError();
                }
            }
            if (cVar == null) {
                return az3.a;
            }
            cVar.d();
            throw null;
        }

        @Override // dc.g64
        @NotNull
        public String toString() {
            return Intrinsics.stringPlus("ReceiveHasNext@", b04.b(this));
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class e extends py3 {

        @NotNull
        public final g34<?> a;

        public e(@NotNull g34<?> g34Var) {
            this.a = g34Var;
        }

        @Override // dc.xy3
        public void a(@Nullable Throwable th) {
            if (this.a.F()) {
                o24.this.N();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends g64.b {
        public final /* synthetic */ o24 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(g64 g64Var, o24 o24Var) {
            super(g64Var);
            this.d = o24Var;
        }

        @Override // dc.r54
        @Nullable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(@NotNull g64 g64Var) {
            if (this.d.J()) {
                return null;
            }
            return f64.a();
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {}, l = {633}, m = "receiveCatching-JP2dKIU", n = {}, s = {})
    public static final class g extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;
        public final /* synthetic */ o24<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(o24<E> o24Var, Continuation<? super g> continuation) {
            super(continuation);
            this.this$0 = o24Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objK = this.this$0.k(this);
            return objK == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objK : x24.b(objK);
        }
    }

    public o24(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // dc.q24
    @Nullable
    public i34<E> B() {
        i34<E> i34VarB = super.B();
        if (i34VarB != null && !(i34VarB instanceof a34)) {
            N();
        }
        return i34VarB;
    }

    public final boolean F(@Nullable Throwable th) {
        boolean zO = o(th);
        L(zO);
        return zO;
    }

    public final boolean G(g34<? super E> g34Var) {
        boolean zH = H(g34Var);
        if (zH) {
            O();
        }
        return zH;
    }

    public boolean H(@NotNull g34<? super E> g34Var) {
        int iJ;
        g64 g64VarB;
        if (!I()) {
            g64 b2 = getB();
            f fVar = new f(g34Var, this);
            do {
                g64 g64VarB2 = b2.B();
                if (!(!(g64VarB2 instanceof k34))) {
                    return false;
                }
                iJ = g64VarB2.J(g34Var, b2, fVar);
                if (iJ != 1) {
                }
            } while (iJ != 2);
            return false;
        }
        g64 b3 = getB();
        do {
            g64VarB = b3.B();
            if (!(!(g64VarB instanceof k34))) {
                return false;
            }
        } while (!g64VarB.u(g34Var, b3));
        return true;
    }

    public abstract boolean I();

    public abstract boolean J();

    public boolean K() {
        return i() != null && J();
    }

    public void L(boolean z) {
        a34<?> a34VarJ = j();
        if (a34VarJ == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objB = b64.b(null, 1, null);
        while (true) {
            g64 g64VarB = a34VarJ.B();
            if (g64VarB instanceof e64) {
                M(objB, a34VarJ);
                return;
            } else {
                if (a04.a() && !(g64VarB instanceof k34)) {
                    throw new AssertionError();
                }
                if (g64VarB.F()) {
                    objB = b64.c(objB, (k34) g64VarB);
                } else {
                    g64VarB.C();
                }
            }
        }
    }

    public void M(@NotNull Object obj, @NotNull a34<?> a34Var) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((k34) obj).M(a34Var);
            return;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            ((k34) arrayList.get(size)).M(a34Var);
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    public void N() {
    }

    public void O() {
    }

    @Nullable
    public Object P() {
        while (true) {
            k34 k34VarC = C();
            if (k34VarC == null) {
                return p24.d;
            }
            t64 t64VarN = k34VarC.N(null);
            if (t64VarN != null) {
                if (a04.a()) {
                    if (!(t64VarN == az3.a)) {
                        throw new AssertionError();
                    }
                }
                k34VarC.K();
                return k34VarC.getD();
            }
            k34VarC.O();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Object Q(int i, Continuation<? super R> continuation) {
        zy3 zy3VarB = bz3.b(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        b bVar = this.a == null ? new b(zy3VarB, i) : new c(zy3VarB, i, this.a);
        while (true) {
            if (G(bVar)) {
                R(zy3VarB, bVar);
                break;
            }
            Object objP = P();
            if (objP instanceof a34) {
                bVar.M((a34) objP);
                break;
            }
            if (objP != p24.d) {
                zy3VarB.i(bVar.N(objP), bVar.L(objP));
                break;
            }
        }
        Object objX = zy3VarB.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    public final void R(yy3<?> yy3Var, g34<?> g34Var) {
        yy3Var.f(new e(g34Var));
    }

    @Override // dc.h34
    public final void b(@Nullable CancellationException cancellationException) {
        if (K()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(Intrinsics.stringPlus(b04.a(this), " was cancelled"));
        }
        F(cancellationException);
    }

    @Override // dc.h34
    @NotNull
    public final v24<E> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // dc.h34
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super dc.x24<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof dc.o24.g
            if (r0 == 0) goto L13
            r0 = r5
            dc.o24$g r0 = (dc.o24.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dc.o24$g r0 = new dc.o24$g
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5a
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.P()
            dc.t64 r2 = dc.p24.d
            if (r5 == r2) goto L51
            boolean r0 = r5 instanceof dc.a34
            if (r0 == 0) goto L4b
            dc.x24$b r0 = dc.x24.b
            dc.a34 r5 = (dc.a34) r5
            java.lang.Throwable r5 = r5.d
            java.lang.Object r5 = r0.a(r5)
            goto L50
        L4b:
            dc.x24$b r0 = dc.x24.b
            r0.c(r5)
        L50:
            return r5
        L51:
            r0.label = r3
            java.lang.Object r5 = r4.Q(r3, r0)
            if (r5 != r1) goto L5a
            return r1
        L5a:
            dc.x24 r5 = (dc.x24) r5
            java.lang.Object r5 = r5.getA()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.o24.k(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
