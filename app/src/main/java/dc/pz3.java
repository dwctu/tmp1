package dc;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, d2 = {"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class pz3 {

    /* compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final CoroutineContext invoke(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
            return element instanceof nz3 ? coroutineContext.plus(((nz3) element).x()) : coroutineContext.plus(element);
        }
    }

    /* compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
        public final /* synthetic */ boolean $isNewCoroutine;
        public final /* synthetic */ Ref.ObjectRef<CoroutineContext> $leftoverContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.ObjectRef<CoroutineContext> objectRef, boolean z) {
            super(2);
            this.$leftoverContext = objectRef;
            this.$isNewCoroutine = z;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final CoroutineContext invoke(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
            if (!(element instanceof nz3)) {
                return coroutineContext.plus(element);
            }
            CoroutineContext.Element element2 = this.$leftoverContext.element.get(element.getKey());
            if (element2 != null) {
                Ref.ObjectRef<CoroutineContext> objectRef = this.$leftoverContext;
                objectRef.element = objectRef.element.minusKey(element.getKey());
                return coroutineContext.plus(((nz3) element).e(element2));
            }
            nz3 nz3VarX = (nz3) element;
            if (this.$isNewCoroutine) {
                nz3VarX = nz3VarX.x();
            }
            return coroutineContext.plus(nz3VarX);
        }
    }

    /* compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ZLkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function2<Boolean, CoroutineContext.Element, Boolean> {
        public static final c a = new c();

        public c() {
            super(2);
        }

        @NotNull
        public final Boolean a(boolean z, @NotNull CoroutineContext.Element element) {
            return Boolean.valueOf(z || (element instanceof nz3));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.Element element) {
            return a(bool.booleanValue(), element);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        boolean zC = c(coroutineContext);
        boolean zC2 = c(coroutineContext2);
        if (!zC && !zC2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new b(objectRef, z));
        if (zC2) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(emptyCoroutineContext, a.a);
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    @Nullable
    public static final String b(@NotNull CoroutineContext coroutineContext) {
        CoroutineId uz3Var;
        String a2;
        if (!a04.c() || (uz3Var = (CoroutineId) coroutineContext.get(CoroutineId.b)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.b);
        String str = "coroutine";
        if (coroutineName != null && (a2 = coroutineName.getA()) != null) {
            str = a2;
        }
        return str + '#' + uz3Var.getA();
    }

    public static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, c.a)).booleanValue();
    }

    @NotNull
    public static final CoroutineContext d(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
        return !c(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : a(coroutineContext, coroutineContext2, false);
    }

    @NotNull
    public static final CoroutineContext e(@NotNull wz3 wz3Var, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(wz3Var.getCoroutineContext(), coroutineContext, true);
        CoroutineContext coroutineContextPlus = a04.c() ? coroutineContextA.plus(new CoroutineId(a04.b().incrementAndGet())) : coroutineContextA;
        return (coroutineContextA == n04.a() || coroutineContextA.get(ContinuationInterceptor.INSTANCE) != null) ? coroutineContextPlus : coroutineContextPlus.plus(n04.a());
    }

    @Nullable
    public static final i24<?> f(@NotNull CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof j04) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof i24) {
                return (i24) coroutineStackFrame;
            }
        }
        return null;
    }

    @Nullable
    public static final i24<?> g(@NotNull Continuation<?> continuation, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (!(coroutineContext.get(j24.a) != null)) {
            return null;
        }
        i24<?> i24VarF = f((CoroutineStackFrame) continuation);
        if (i24VarF != null) {
            i24VarF.Q0(coroutineContext, obj);
        }
        return i24VarF;
    }
}
