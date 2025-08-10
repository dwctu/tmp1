package dc;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+LVS.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/command/code/CmdLVS;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "", "(Ljava/lang/String;[B)V", "lvsValue", "maxValueSize", "", "prefix", "suffix", "getMotorCountFromCAP", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class p60 extends b90 {

    @NotNull
    public final String f;

    @NotNull
    public final String g;
    public final int h;

    @NotNull
    public byte[] i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p60(@NotNull String mac, @NotNull byte[] value) {
        super(ma0.a.r(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f = ";";
        this.g = "LVS:";
        this.h = (20 - ";".length()) - "LVS:".length();
        this.i = value;
    }

    @Override // dc.b90
    public boolean g() {
        if (this.i.length == 0) {
            onError(mt.ILLEGAL_ARGUMENT, "lvs values is empty");
            return false;
        }
        int iH = h();
        if (iH == 0) {
            onError(mt.ILLEGAL_ARGUMENT, "dx lvs is not support");
            return false;
        }
        byte[] bArr = this.i;
        int length = bArr.length;
        if (length > iH) {
            this.i = ArraysKt___ArraysJvmKt.copyOfRange(bArr, 0, iH);
        } else if (length < iH) {
            int i = iH - length;
            for (int i2 = 0; i2 < i; i2++) {
                this.i = ArraysKt___ArraysJvmKt.plus(this.i, (byte) -1);
            }
        }
        byte[] bArr2 = this.i;
        if (bArr2.length > this.h) {
            onError(mt.ILLEGAL_ARGUMENT, "lvs values is too long, over 15 length");
            return false;
        }
        setValues(bArr2);
        return true;
    }

    public final int h() {
        nb0 nb0VarC;
        nb0 nb0VarC2 = c();
        if ((nb0VarC2 != null ? tb0.l(nb0VarC2) : false) && (nb0VarC = c()) != null) {
            return tb0.d(nb0VarC);
        }
        return 0;
    }
}
