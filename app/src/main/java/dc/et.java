package dc;

import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleConnect.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/component/dxbluetooth/lib/connect/BleConnect;", "", "mac", "", "(Ljava/lang/String;)V", "getMac", "()Ljava/lang/String;", "connect", "", "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "disconnect", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class et {

    @NotNull
    public final String a;

    public et(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
    }

    public final void a(@Nullable BleConnectConfigBean bleConnectConfigBean, @Nullable zv zvVar) {
        ot.a(kt.a, this.a).e().d(bleConnectConfigBean, zvVar);
    }

    public final void b() {
        ot.a(kt.a, this.a).e().e();
    }
}
