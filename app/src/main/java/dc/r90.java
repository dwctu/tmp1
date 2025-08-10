package dc;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.h14;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseCoroutineScopeLoop.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/component/dxtoy/core/api/schedule/base/BaseCoroutineScopeLoop;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "job", "Lkotlinx/coroutines/Job;", "getLoopDelayTime", "", "loopBody", "", TtmlNode.START, "stop", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class r90 {

    @NotNull
    public final wz3 a;

    @Nullable
    public h14 b;

    /* compiled from: BaseCoroutineScopeLoop.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.component.dxtoy.core.api.schedule.base.BaseCoroutineScopeLoop$start$1", f = "BaseCoroutineScopeLoop.kt", i = {0}, l = {34}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = r90.this.new a(continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0039 -> B:20:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r1 = r5.L$0
                dc.wz3 r1 = (dc.wz3) r1
                kotlin.ResultKt.throwOnFailure(r6)
                r6 = r5
                goto L3c
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                dc.wz3 r6 = (dc.wz3) r6
                r1 = r6
                r6 = r5
            L25:
                boolean r3 = dc.xz3.e(r1)
                if (r3 == 0) goto L47
                dc.r90 r3 = dc.r90.this
                long r3 = r3.a()
                r6.L$0 = r1
                r6.label = r2
                java.lang.Object r3 = dc.h04.a(r3, r6)
                if (r3 != r0) goto L3c
                return r0
            L3c:
                dc.r90 r3 = dc.r90.this     // Catch: java.lang.Exception -> L42
                r3.b()     // Catch: java.lang.Exception -> L42
                goto L25
            L42:
                r3 = move-exception
                r3.printStackTrace()
                goto L25
            L47:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.r90.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public r90(@NotNull wz3 scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.a = scope;
    }

    public abstract long a();

    public abstract void b();

    public final void c() {
        h14 h14Var = this.b;
        if (h14Var != null && h14Var.isActive()) {
            return;
        }
        d();
        this.b = uy3.d(this.a, null, null, new a(null), 3, null);
    }

    public final void d() {
        h14 h14Var = this.b;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
    }
}
