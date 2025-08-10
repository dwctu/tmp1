package dc;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: IBleWorker.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J!\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u001c\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J&\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0015\u001a\u00020\rH&J\b\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\rH&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\nH&J$\u0010\u001b\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\rH&J$\u0010\u001e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\rH&J \u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH&J&\u0010#\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010%H&J&\u0010&\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010%H&J0\u0010'\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010%H&¨\u0006("}, d2 = {"Lcom/component/dxbluetooth/lib/listener/IBleWorker;", "", "clearGattResponseListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxbluetooth/lib/connect/listener/GattResponseListener;", "closeGatt", "result", "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "status", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "discoverService", "", "openGatt", "readCharacteristic", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", "characteristic", "readDescriptor", "descriptor", "readPhy", "readRemoteRssi", "refreshDeviceCache", "registerGattResponseListener", "requestMtu", "mtu", "setCharacteristicIndication", FirebaseAnalytics.Param.CHARACTER, StreamManagement.Enable.ELEMENT, "setCharacteristicNotification", "setPreferredPhy", "tx", "rx", "phyOptions", "writeCharacteristic", "value", "", "writeCharacteristicWithNoRsp", "writeDescriptor", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface tt {

    /* compiled from: IBleWorker.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(tt ttVar, mt mtVar, Integer num, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeGatt");
            }
            if ((i & 2) != 0) {
                num = null;
            }
            ttVar.h(mtVar, num);
        }
    }

    void h(@NotNull mt mtVar, @Nullable Integer num);
}
