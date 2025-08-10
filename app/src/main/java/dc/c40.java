package dc;

import com.wear.widget.control.FingImageLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyGetToyThresholdEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/component/dxtoy/business/waggle/xmachine/event/ToyGetToyThresholdEvent;", "", "mac", "", "x", "", FingImageLayout.ObjectAnimatorY, "(Ljava/lang/String;II)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c40 {

    @JvmField
    @NotNull
    public String a;

    @JvmField
    public int b;

    @JvmField
    public int c;

    public c40(@NotNull String mac, int i, int i2) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = i;
        this.c = i2;
    }
}
