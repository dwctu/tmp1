package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/command/code/CmdChangeName;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class f50 extends b90 {

    @NotNull
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f50(@NotNull String mac, @NotNull String value) {
        super(pa0.a.h(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f = value;
    }

    @Override // dc.b90
    public boolean g() {
        if (this.f.length() == 0) {
            onError(mt.ILLEGAL_ARGUMENT, "Value is empty");
            return false;
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) this.f, (CharSequence) DfuBaseService.NOTIFICATION_CHANNEL_DFU, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) this.f, (CharSequence) "new", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) this.f, (CharSequence) "lvs", false, 2, (Object) null)) {
            onError(mt.ILLEGAL_ARGUMENT, "Change name can not contain dfu/new/lvs");
            return false;
        }
        nb0 nb0VarC = c();
        if (!(nb0VarC != null && tb0.g(nb0VarC))) {
            onError(mt.ILLEGAL_ARGUMENT, "isSupportChangeName is false");
            return false;
        }
        if (new Regex("^[0-9a-zA-Z_\\s]{1,12}$").matches(this.f)) {
            setValues(this.f);
            return true;
        }
        onError(mt.ILLEGAL_ARGUMENT, "You can only use letters, numbers, underscore, and space.");
        return false;
    }
}
