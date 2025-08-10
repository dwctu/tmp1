package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsumerDialogAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000e\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/wear/main/action/ConsumerDialogAdapter;", "", "priority", "Lcom/wear/main/action/ConsumerDialogAdapter$Priority;", "consumerDialogListener", "Lcom/wear/main/action/ConsumerDialogAdapter$ConsumerDialogAdapterListener;", "(Lcom/wear/main/action/ConsumerDialogAdapter$Priority;Lcom/wear/main/action/ConsumerDialogAdapter$ConsumerDialogAdapterListener;)V", "getPriority$app_marketRelease", "()Lcom/wear/main/action/ConsumerDialogAdapter$Priority;", "compareTo", "", "other", "handlerRequest", "", "ConsumerDialogAdapterListener", "Priority", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class wz1 implements Comparable<wz1> {

    @NotNull
    public final b a;

    @NotNull
    public final a b;

    /* compiled from: ConsumerDialogAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/main/action/ConsumerDialogAdapter$ConsumerDialogAdapterListener;", "", "onConsumerDialogRequest", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    /* compiled from: ConsumerDialogAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wear/main/action/ConsumerDialogAdapter$Priority;", "", "(Ljava/lang/String;I)V", "INVITE", "ROULETTE", "POWER", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        INVITE,
        ROULETTE,
        POWER
    }

    public wz1(@NotNull b priority, @NotNull a consumerDialogListener) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(consumerDialogListener, "consumerDialogListener");
        this.a = priority;
        this.b = consumerDialogListener;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull wz1 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.a.ordinal() - other.a.ordinal();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final b getA() {
        return this.a;
    }

    public final void c() {
        this.b.a();
    }
}
