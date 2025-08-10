package dc;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainDispatchers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k64 {

    @NotNull
    public static final k64 a;
    public static final boolean b;

    @JvmField
    @NotNull
    public static final s14 c;

    static {
        k64 k64Var = new k64();
        a = k64Var;
        b = u64.e("kotlinx.coroutines.fast.service.loader", true);
        c = k64Var.a();
    }

    public final s14 a() {
        Object next;
        try {
            List<j64> listC = b ? z54.a.c() : SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(a.b()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((j64) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((j64) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            j64 j64Var = (j64) next;
            s14 s14VarE = j64Var == null ? null : l64.e(j64Var, listC);
            return s14VarE == null ? l64.b(null, null, 3, null) : s14VarE;
        } catch (Throwable th) {
            return l64.b(th, null, 2, null);
        }
    }
}
