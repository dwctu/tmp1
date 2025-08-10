package dc;

import androidx.exifinterface.media.ExifInterface;
import com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean;
import dc.sa0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdRemoveAllClockHandler.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J5\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/component/dxtoy/business/clock/handler/ToyCmdRemoveAllClockHandler;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "", "()V", "CMD_TAG", "", "handleCommand", ExifInterface.GPS_DIRECTION_TRUE, "mac", "value", "bytes", "", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isHandle", "removeAllClock", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class j00 implements sa0<Boolean> {

    @NotNull
    public static final j00 b = new j00();

    @Override // dc.sa0
    public boolean a(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return d90.k(value, "rac");
    }

    @Override // dc.sa0
    public boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3) {
        return sa0.b.b(this, str, str2, bArr, str3);
    }

    @Override // dc.sa0
    @Nullable
    public <T> T c(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        if (yb0.e(mac) != null) {
            return (T) Boolean.valueOf(d90.j(value));
        }
        return null;
    }

    public final void d(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        c70 c70Var = new c70(mac);
        c70Var.addSendType(BaseToyCommandBean.INSTANCE.getDefaultResend());
        c70Var.e();
    }

    @Override // dc.sa0
    @Nullable
    public ta0<Boolean> getCallback() {
        return sa0.b.a(this);
    }
}
