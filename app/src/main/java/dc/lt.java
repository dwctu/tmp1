package dc;

import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xtremeprog.sdk.ble.BleService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: BleEum.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;", "", "status", "", NotificationCompat.CATEGORY_MESSAGE, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getStatus", "()I", GrsBaseInfo.CountryCodeSource.UNKNOWN, "CONNECTING", BleService.EXTRA_CONNECTED, "DISCONNECTING", "DISCONNECTED", "SERVICE_READY", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public enum lt {
    UNKNOWN(-1, EnvironmentCompat.MEDIA_UNKNOWN),
    CONNECTING(1, "connecting"),
    CONNECTED(2, "connected"),
    DISCONNECTING(3, "disconnecting"),
    DISCONNECTED(0, "disconnected"),
    SERVICE_READY(19, "service_ready");


    @NotNull
    private final String msg;
    private final int status;

    lt(int i, String str) {
        this.status = i;
        this.msg = str;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public final int getStatus() {
        return this.status;
    }
}
