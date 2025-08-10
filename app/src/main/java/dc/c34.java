package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.q24;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LinkedListChannel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class c34<E> extends o24<E> {
    public c34(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // dc.o24
    public final boolean I() {
        return true;
    }

    @Override // dc.o24
    public final boolean J() {
        return true;
    }

    @Override // dc.o24
    public void M(@NotNull Object obj, @NotNull a34<?> a34Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionC = null;
        if (obj != null) {
            if (obj instanceof ArrayList) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    UndeliveredElementException undeliveredElementExceptionC2 = null;
                    while (true) {
                        int i = size - 1;
                        k34 k34Var = (k34) arrayList.get(size);
                        if (k34Var instanceof q24.a) {
                            Function1<E, Unit> function1 = this.a;
                            undeliveredElementExceptionC2 = function1 == null ? null : n64.c(function1, ((q24.a) k34Var).d, undeliveredElementExceptionC2);
                        } else {
                            k34Var.M(a34Var);
                        }
                        if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                    undeliveredElementExceptionC = undeliveredElementExceptionC2;
                }
            } else {
                k34 k34Var2 = (k34) obj;
                if (k34Var2 instanceof q24.a) {
                    Function1<E, Unit> function12 = this.a;
                    if (function12 != null) {
                        undeliveredElementExceptionC = n64.c(function12, ((q24.a) k34Var2).d, null);
                    }
                } else {
                    k34Var2.M(a34Var);
                }
            }
        }
        if (undeliveredElementExceptionC != null) {
            throw undeliveredElementExceptionC;
        }
    }

    @Override // dc.q24
    public final boolean u() {
        return false;
    }

    @Override // dc.q24
    public final boolean v() {
        return false;
    }

    @Override // dc.q24
    @NotNull
    public Object x(E e) {
        i34<?> i34VarZ;
        do {
            Object objX = super.x(e);
            t64 t64Var = p24.b;
            if (objX == t64Var) {
                return t64Var;
            }
            if (objX != p24.c) {
                if (objX instanceof a34) {
                    return objX;
                }
                throw new IllegalStateException(Intrinsics.stringPlus("Invalid offerInternal result ", objX).toString());
            }
            i34VarZ = z(e);
            if (i34VarZ == null) {
                return t64Var;
            }
        } while (!(i34VarZ instanceof a34));
        return i34VarZ;
    }
}
