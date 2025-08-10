package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/command/code/CmdPsName;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value1", "", "value2", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue1", "()I", "getValue2", "()Ljava/lang/String;", "value2MaxLength", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class y60 extends b90 {
    public final int f;

    @NotNull
    public final String g;
    public final int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y60(@NotNull String mac, int i, @NotNull String value2) {
        super(pa0.a.Q(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value2, "value2");
        this.f = i;
        this.g = value2;
        this.h = 14;
        f(CollectionsKt__CollectionsKt.listOf((Object[]) new IntRange[]{new IntRange(0, 9), new IntRange(0, 9)}));
    }

    @Override // dc.b90
    public boolean g() {
        boolean z;
        if ((this.g.length() == 0) || !d().get(0).contains(this.f) || this.g.length() > this.h) {
            return false;
        }
        String str = this.g;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            }
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf(str.charAt(i)));
            if (!(intOrNull != null && d().get(1).contains(intOrNull.intValue()))) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            setValues(String.valueOf(this.f), this.g);
        }
        return z;
    }
}
