package dc;

import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IChatMessageStrategy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/wear/ui/chat/action/IChatMessageStrategy;", "", "()V", "strategy", "deleteMessage", "Lcom/wear/bean/chat/MessageResult;", "message", "Lcom/wear/bean/chat/Message;", "(Lcom/wear/bean/chat/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processMessage", "type", "", "(Lcom/wear/bean/chat/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processMessageWithType", "sendMessage", "setNextStrategy", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class nr2 {

    @Nullable
    public nr2 a;

    /* compiled from: IChatMessageStrategy.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.action.IChatMessageStrategy", f = "IChatMessageStrategy.kt", i = {0, 0, 0}, l = {35, 37}, m = "processMessageWithType", n = {"this", "message", "type"}, s = {"L$0", "L$1", "I$0"})
    public static final class a extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return nr2.this.d(null, 0, this);
        }
    }

    @Nullable
    public final Object b(@NotNull Message message, @NotNull Continuation<? super MessageResult> continuation) {
        return d(message, 2, continuation);
    }

    @Nullable
    public abstract Object c(@NotNull Message message, int i, @NotNull Continuation<? super MessageResult> continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(com.wear.bean.chat.Message r6, int r7, kotlin.coroutines.Continuation<? super com.wear.bean.chat.MessageResult> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof dc.nr2.a
            if (r0 == 0) goto L13
            r0 = r8
            dc.nr2$a r0 = (dc.nr2.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dc.nr2$a r0 = new dc.nr2$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L70
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            com.wear.bean.chat.Message r6 = (com.wear.bean.chat.Message) r6
            java.lang.Object r2 = r0.L$0
            dc.nr2 r2 = (dc.nr2) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.c(r6, r7, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            r2 = r5
        L55:
            com.wear.bean.chat.MessageResult r8 = (com.wear.bean.chat.MessageResult) r8
            boolean r4 = r8 instanceof com.wear.bean.chat.MessageResult.Success
            if (r4 == 0) goto L70
            dc.nr2 r2 = r2.a
            if (r2 == 0) goto L70
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r8 = r2.c(r6, r7, r0)
            if (r8 != r1) goto L70
            return r1
        L70:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.nr2.d(com.wear.bean.chat.Message, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object e(@NotNull Message message, @NotNull Continuation<? super MessageResult> continuation) {
        return d(message, 0, continuation);
    }

    public final void f(@Nullable nr2 nr2Var) {
        this.a = nr2Var;
    }
}
