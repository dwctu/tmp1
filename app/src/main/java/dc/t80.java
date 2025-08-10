package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Single.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/component/dxtoy/command/code/CmdVibrate1;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "", "(Ljava/lang/String;I)V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class t80 extends b90 {

    @NotNull
    public static final a f = new a(null);

    /* compiled from: ToyCommandCode+Single.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/command/code/CmdVibrate1$Companion;", "", "()V", "initToyCommandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "mac", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final la0 a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            nb0 nb0Var = hb0.a.e().get(mac);
            return (nb0Var == null || !ub0.i(nb0Var)) ? ma0.a.G() : ma0.a.H();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t80(@NotNull String mac, int i) {
        super(f.a(mac), mac, i);
        Intrinsics.checkNotNullParameter(mac, "mac");
    }
}
