package dc;

import androidx.exifinterface.media.ExifInterface;
import com.wear.bean.SyncWsProtocol;
import dc.g64;
import dc.x24;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AbstractChannel.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u000e\u0012\u0002\b\u00030\u0011j\u0006\u0012\u0002\b\u0003`\u00122\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010!\u001a\u00020\b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010#J)\u0010&\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016¢\u0006\u0004\b&\u0010\u0007J\u0019\u0010'\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0004\b+\u0010,J#\u0010/\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u000201H\u0014¢\u0006\u0004\b2\u00103JX\u00109\u001a\u00020\u0003\"\u0004\b\u0001\u001042\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001a\u00028\u00002(\u00108\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001a05H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010;J\u001d\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b?\u0010;J\u0017\u0010@\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bH\u0010,J+\u0010J\u001a\u00020\u0003*\u0006\u0012\u0002\b\u0003072\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020D8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bL\u0010FR\u001a\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010S\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0011\u0010V\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010TR#\u0010[\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\\R\u001a\u0010^\u001a\u00020]8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010F\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006h"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "cause", "", Close.ELEMENT, "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", SyncWsProtocol.DataBean.CONTROL_STATUS_QUEUE_TYPE_KEY, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class q24<E> implements l34<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(q24.class, Object.class, "onCloseHandler");

    @JvmField
    @Nullable
    public final Function1<E, Unit> a;

    @NotNull
    public final e64 b = new e64();

    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a<E> extends k34 {

        @JvmField
        public final E d;

        public a(E e) {
            this.d = e;
        }

        @Override // dc.k34
        public void K() {
        }

        @Override // dc.k34
        @Nullable
        /* renamed from: L, reason: from getter */
        public Object getD() {
            return this.d;
        }

        @Override // dc.k34
        public void M(@NotNull a34<?> a34Var) {
            if (a04.a()) {
                throw new AssertionError();
            }
        }

        @Override // dc.k34
        @Nullable
        public t64 N(@Nullable g64.c cVar) {
            t64 t64Var = az3.a;
            if (cVar == null) {
                return t64Var;
            }
            cVar.d();
            throw null;
        }

        @Override // dc.g64
        @NotNull
        public String toString() {
            return "SendBuffered@" + b04.b(this) + '(' + this.d + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends g64.b {
        public final /* synthetic */ q24 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g64 g64Var, q24 q24Var) {
            super(g64Var);
            this.d = q24Var;
        }

        @Override // dc.r54
        @Nullable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(@NotNull g64 g64Var) {
            if (this.d.v()) {
                return null;
            }
            return f64.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q24(@Nullable Function1<? super E, Unit> function1) {
        this.a = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0055 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(E r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r5)
            dc.zy3 r0 = dc.bz3.b(r0)
        L8:
            boolean r1 = c(r3)
            if (r1 == 0) goto L4d
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r1 = r3.a
            if (r1 != 0) goto L18
            dc.m34 r1 = new dc.m34
            r1.<init>(r4, r0)
            goto L1f
        L18:
            dc.n34 r1 = new dc.n34
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r3.a
            r1.<init>(r4, r0, r2)
        L1f:
            java.lang.Object r2 = r3.f(r1)
            if (r2 != 0) goto L29
            dc.bz3.c(r0, r1)
            goto L6f
        L29:
            boolean r1 = r2 instanceof dc.a34
            if (r1 == 0) goto L33
            dc.a34 r2 = (dc.a34) r2
            a(r3, r0, r4, r2)
            goto L6f
        L33:
            dc.t64 r1 = dc.p24.e
            if (r2 != r1) goto L38
            goto L4d
        L38:
            boolean r1 = r2 instanceof dc.g34
            if (r1 == 0) goto L3d
            goto L4d
        L3d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "enqueueSend returned "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r2)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L4d:
            java.lang.Object r1 = r3.x(r4)
            dc.t64 r2 = dc.p24.b
            if (r1 != r2) goto L61
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r4 = kotlin.Result.m86constructorimpl(r4)
            r0.resumeWith(r4)
            goto L6f
        L61:
            dc.t64 r2 = dc.p24.c
            if (r1 != r2) goto L66
            goto L8
        L66:
            boolean r2 = r1 instanceof dc.a34
            if (r2 == 0) goto L86
            dc.a34 r1 = (dc.a34) r1
            a(r3, r0, r4, r1)
        L6f:
            java.lang.Object r4 = r0.x()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r0) goto L7c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5)
        L7c:
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L83
            return r4
        L83:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L86:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "offerInternal returned "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r1)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.q24.A(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [dc.g64] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.i34<E> B() {
        /*
            r4 = this;
            dc.e64 r0 = r4.b
        L2:
            java.lang.Object r1 = r0.z()
            dc.g64 r1 = (dc.g64) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof dc.i34
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            dc.i34 r2 = (dc.i34) r2
            boolean r2 = r2 instanceof dc.a34
            if (r2 == 0) goto L20
            boolean r2 = r1.E()
            if (r2 != 0) goto L20
            goto L26
        L20:
            dc.g64 r2 = r1.H()
            if (r2 != 0) goto L29
        L26:
            dc.i34 r1 = (dc.i34) r1
            return r1
        L29:
            r2.D()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.q24.B():dc.i34");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = null;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dc.k34 C() {
        /*
            r4 = this;
            dc.e64 r0 = r4.b
        L2:
            java.lang.Object r1 = r0.z()
            dc.g64 r1 = (dc.g64) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof dc.k34
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            dc.k34 r2 = (dc.k34) r2
            boolean r2 = r2 instanceof dc.a34
            if (r2 == 0) goto L20
            boolean r2 = r1.E()
            if (r2 != 0) goto L20
            goto L26
        L20:
            dc.g64 r2 = r1.H()
            if (r2 != 0) goto L29
        L26:
            dc.k34 r1 = (dc.k34) r1
            return r1
        L29:
            r2.D()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.q24.C():dc.k34");
    }

    @Override // dc.l34
    public void d(@NotNull Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != p24.f) {
                throw new IllegalStateException(Intrinsics.stringPlus("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        a34<?> a34VarJ = j();
        if (a34VarJ == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, p24.f)) {
            return;
        }
        function1.invoke(a34VarJ.d);
    }

    public final int e() {
        e64 e64Var = this.b;
        int i = 0;
        for (g64 g64VarA = (g64) e64Var.z(); !Intrinsics.areEqual(g64VarA, e64Var); g64VarA = g64VarA.A()) {
            if (g64VarA instanceof g64) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return dc.p24.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(@org.jetbrains.annotations.NotNull dc.k34 r5) {
        /*
            r4 = this;
            boolean r0 = r4.u()
            if (r0 == 0) goto L18
            dc.e64 r0 = r4.b
        L8:
            dc.g64 r1 = r0.B()
            boolean r2 = r1 instanceof dc.i34
            if (r2 == 0) goto L11
            return r1
        L11:
            boolean r1 = r1.u(r5, r0)
            if (r1 == 0) goto L8
            goto L39
        L18:
            dc.e64 r0 = r4.b
            dc.q24$b r1 = new dc.q24$b
            r1.<init>(r5, r4)
        L1f:
            dc.g64 r2 = r0.B()
            boolean r3 = r2 instanceof dc.i34
            if (r3 == 0) goto L28
            return r2
        L28:
            int r2 = r2.J(r5, r0, r1)
            r3 = 1
            if (r2 == r3) goto L34
            r3 = 2
            if (r2 == r3) goto L33
            goto L1f
        L33:
            r3 = 0
        L34:
            if (r3 != 0) goto L39
            dc.t64 r5 = dc.p24.e
            return r5
        L39:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.q24.f(dc.k34):java.lang.Object");
    }

    @NotNull
    public String g() {
        return "";
    }

    @Override // dc.l34
    @NotNull
    public final Object h(E e) {
        Object objX = x(e);
        if (objX == p24.b) {
            x24.b bVar = x24.b;
            Unit unit = Unit.INSTANCE;
            bVar.c(unit);
            return unit;
        }
        if (objX == p24.c) {
            a34<?> a34VarJ = j();
            return a34VarJ == null ? x24.b.b() : x24.b.a(p(a34VarJ));
        }
        if (objX instanceof a34) {
            return x24.b.a(p((a34) objX));
        }
        throw new IllegalStateException(Intrinsics.stringPlus("trySend returned ", objX).toString());
    }

    @Nullable
    public final a34<?> i() {
        g64 g64VarA = this.b.A();
        a34<?> a34Var = g64VarA instanceof a34 ? (a34) g64VarA : null;
        if (a34Var == null) {
            return null;
        }
        n(a34Var);
        return a34Var;
    }

    @Nullable
    public final a34<?> j() {
        g64 g64VarB = this.b.B();
        a34<?> a34Var = g64VarB instanceof a34 ? (a34) g64VarB : null;
        if (a34Var == null) {
            return null;
        }
        n(a34Var);
        return a34Var;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final e64 getB() {
        return this.b;
    }

    public final String m() {
        g64 g64VarA = this.b.A();
        if (g64VarA == this.b) {
            return "EmptyQueue";
        }
        String string = g64VarA instanceof a34 ? g64VarA.toString() : g64VarA instanceof g34 ? "ReceiveQueued" : g64VarA instanceof k34 ? "SendQueued" : Intrinsics.stringPlus("UNEXPECTED:", g64VarA);
        g64 g64VarB = this.b.B();
        if (g64VarB == g64VarA) {
            return string;
        }
        String str = string + ",queueSize=" + e();
        if (!(g64VarB instanceof a34)) {
            return str;
        }
        return str + ",closedForSend=" + g64VarB;
    }

    public final void n(a34<?> a34Var) {
        Object objB = b64.b(null, 1, null);
        while (true) {
            g64 g64VarB = a34Var.B();
            g34 g34Var = g64VarB instanceof g34 ? (g34) g64VarB : null;
            if (g34Var == null) {
                break;
            } else if (g34Var.F()) {
                objB = b64.c(objB, g34Var);
            } else {
                g34Var.C();
            }
        }
        if (objB != null) {
            if (objB instanceof ArrayList) {
                Objects.requireNonNull(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) objB;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((g34) arrayList.get(size)).M(a34Var);
                        if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                }
            } else {
                ((g34) objB).M(a34Var);
            }
        }
        y(a34Var);
    }

    @Override // dc.l34
    public boolean o(@Nullable Throwable th) {
        boolean z;
        a34<?> a34Var = new a34<>(th);
        g64 g64Var = this.b;
        while (true) {
            g64 g64VarB = g64Var.B();
            z = true;
            if (!(!(g64VarB instanceof a34))) {
                z = false;
                break;
            }
            if (g64VarB.u(a34Var, g64Var)) {
                break;
            }
        }
        if (!z) {
            a34Var = (a34) this.b.B();
        }
        n(a34Var);
        if (z) {
            t(th);
        }
        return z;
    }

    public final Throwable p(a34<?> a34Var) {
        n(a34Var);
        return a34Var.S();
    }

    public final void q(Continuation<?> continuation, E e, a34<?> a34Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionD;
        n(a34Var);
        Throwable thS = a34Var.S();
        Function1<E, Unit> function1 = this.a;
        if (function1 == null || (undeliveredElementExceptionD = n64.d(function1, e, null, 2, null)) == null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(thS)));
        } else {
            ExceptionsKt__ExceptionsKt.addSuppressed(undeliveredElementExceptionD, thS);
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(undeliveredElementExceptionD)));
        }
    }

    @Override // dc.l34
    @Nullable
    public final Object r(E e, @NotNull Continuation<? super Unit> continuation) {
        Object objA;
        return (x(e) != p24.b && (objA = A(e, continuation)) == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objA : Unit.INSTANCE;
    }

    @Override // dc.l34
    public final boolean s() {
        return j() != null;
    }

    public final void t(Throwable th) {
        t64 t64Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (t64Var = p24.f) || !c.compareAndSet(this, obj, t64Var)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
    }

    @NotNull
    public String toString() {
        return b04.a(this) + '@' + b04.b(this) + MessageFormatter.DELIM_START + m() + MessageFormatter.DELIM_STOP + g();
    }

    public abstract boolean u();

    public abstract boolean v();

    public final boolean w() {
        return !(this.b.A() instanceof i34) && v();
    }

    @NotNull
    public Object x(E e) {
        i34<E> i34VarB;
        t64 t64VarP;
        do {
            i34VarB = B();
            if (i34VarB == null) {
                return p24.c;
            }
            t64VarP = i34VarB.p(e, null);
        } while (t64VarP == null);
        if (a04.a()) {
            if (!(t64VarP == az3.a)) {
                throw new AssertionError();
            }
        }
        i34VarB.h(e);
        return i34VarB.b();
    }

    public void y(@NotNull g64 g64Var) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final i34<?> z(E e) {
        g64 g64VarB;
        e64 e64Var = this.b;
        a aVar = new a(e);
        do {
            g64VarB = e64Var.B();
            if (g64VarB instanceof i34) {
                return (i34) g64VarB;
            }
        } while (!g64VarB.u(aVar, e64Var));
        return null;
    }
}
