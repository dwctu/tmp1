package dc;

import dc.wz1;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsumerDialogAction.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/wear/main/action/ConsumerDialogAction;", "", "()V", "currentAdapter", "Lcom/wear/main/action/ConsumerDialogAdapter;", "priorityQueue", "Ljava/util/PriorityQueue;", "appendLooper", "", "consumerDialogAdapter", "handlerResult", "priority", "Lcom/wear/main/action/ConsumerDialogAdapter$Priority;", "nextLooper", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class uz1 {

    @NotNull
    public static final uz1 a = new uz1();

    @NotNull
    public static final PriorityQueue<wz1> b = new PriorityQueue<>();

    @Nullable
    public static volatile wz1 c;

    public final void a(@NotNull wz1 consumerDialogAdapter) {
        Intrinsics.checkNotNullParameter(consumerDialogAdapter, "consumerDialogAdapter");
        synchronized (this) {
            b.add(consumerDialogAdapter);
            if (c == null) {
                a.c();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(@NotNull wz1.b priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        synchronized (this) {
            wz1 wz1Var = c;
            if ((wz1Var != null ? wz1Var.getA() : null) == priority) {
                uz1 uz1Var = a;
                c = null;
                if (!b.isEmpty()) {
                    uz1Var.c();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c() {
        c = b.poll();
        wz1 wz1Var = c;
        if (wz1Var != null) {
            wz1Var.c();
        }
    }
}
