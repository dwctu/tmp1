package dc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageSocketStrategy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/wear/ui/chat/action/ChatMessageSocketStrategy;", "Lcom/wear/ui/chat/action/IChatMessageStrategy;", "()V", "processMessage", "Lcom/wear/bean/chat/MessageResult;", "message", "Lcom/wear/bean/chat/Message;", "type", "", "(Lcom/wear/bean/chat/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class mr2 extends nr2 {

    /* compiled from: ChatMessageSocketStrategy.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.action.ChatMessageSocketStrategy", f = "ChatMessageSocketStrategy.kt", i = {0}, l = {21}, m = "processMessage", n = {"message"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public Object L$0;
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
            return mr2.this.c(null, 0, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // dc.nr2
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(@org.jetbrains.annotations.NotNull com.wear.bean.chat.Message r8, int r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.wear.bean.chat.MessageResult> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof dc.mr2.a
            if (r0 == 0) goto L13
            r0 = r10
            dc.mr2$a r0 = (dc.mr2.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dc.mr2$a r0 = new dc.mr2$a
            r0.<init>(r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r8 = r4.L$0
            com.wear.bean.chat.Message r8 = (com.wear.bean.chat.Message) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L52
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r9 != 0) goto L6d
            boolean r9 = r8.getSkipSend()
            if (r9 != 0) goto L6d
            dc.ft2 r1 = dc.ft2.a
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r8
            r4.label = r2
            r2 = r8
            java.lang.Object r10 = dc.ft2.v(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L52
            return r0
        L52:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r9 = r10.booleanValue()
            if (r9 == 0) goto L60
            com.wear.bean.chat.MessageResult$Success r9 = new com.wear.bean.chat.MessageResult$Success
            r9.<init>(r8)
            goto L6c
        L60:
            com.wear.bean.chat.MessageResult$Failure r9 = new com.wear.bean.chat.MessageResult$Failure
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r10 = "chat message send socket failed"
            r8.<init>(r10)
            r9.<init>(r8)
        L6c:
            return r9
        L6d:
            com.wear.bean.chat.MessageResult$Success r9 = new com.wear.bean.chat.MessageResult$Success
            r9.<init>(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.mr2.c(com.wear.bean.chat.Message, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
