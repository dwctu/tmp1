package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/command/code/CmdPlName;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value1", "", "value2", "value3", "value4", "(Ljava/lang/String;IIILjava/lang/String;)V", "getValue1", "()I", "getValue2", "getValue3", "getValue4", "()Ljava/lang/String;", "value4MaxLength", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class v60 extends b90 {
    public final int f;
    public final int g;
    public final int h;

    @NotNull
    public final String i;
    public final int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v60(@NotNull String mac, int i, int i2, int i3, @NotNull String value4) {
        super(pa0.a.N(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value4, "value4");
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = value4;
        this.j = 500;
        f(CollectionsKt__CollectionsJVMKt.listOf(new IntRange(0, 9)));
    }

    @Override // dc.b90
    public boolean g() {
        boolean z;
        if (this.i.length() == 0) {
            return false;
        }
        if (d().get(0).contains(this.f) && this.h >= this.g && this.i.length() <= this.j) {
            String str = this.i;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf(str.charAt(i)));
                if (!(intOrNull != null && d().get(0).contains(intOrNull.intValue()))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                setValues(String.valueOf(this.f), String.valueOf(this.g), String.valueOf(this.h), this.i);
                return true;
            }
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy command value is invalid");
        return false;
    }
}
