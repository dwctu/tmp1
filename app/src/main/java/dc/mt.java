package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: BleEum.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b*\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00066"}, d2 = {"Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "", XHTMLText.CODE, "", NotificationCompat.CATEGORY_MESSAGE, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "toResultBean", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "status", "(Ljava/lang/Integer;)Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "BLE_NOT_SUPPORT", "BLE_NOT_ADAPTER", "BLE_NOT_OPEN", "BLE_NOT_CONNECTED", "BLE_NOT_FOUND_DEVICE", "BLE_NOT_FOUND_SERVICE", "BLE_NOT_FOUND_CHARACTER", "BLE_NOT_FOUND_DESCRIPTOR", "BLE_NOT_SUPPORT_OPERATION", "BLE_NOT_SUPPORT_WRITE", "BLE_NOT_SUPPORT_READ", "BLE_NOT_SUPPORT_NOTIFY", "BLE_NOT_SUPPORT_INDICATE", "BLE_NOT_SUPPORT_MTU", "BLE_NOT_SUPPORT_DESCRIPTOR", "BLE_SERVICE_NOT_BIND", "BLE_SERVICE_UNREADY", "REQUEST_FAILED", "REQUEST_SUCCESS", "REQUEST_EXCEPTION", "REQUEST_TIMEOUT", "REQUEST_CANCEL", "REQUEST_OVERFLOW", "REQUEST_DENIED", "SEARCH_START", "SEARCH_CANCEL", "SEARCH_STOP", "SEARCH_DEVICE_FOUND", "SEARCHING", "SEARCH_TOO_FAST", "CONNECT_CANCEL", "CONNECT_FAILED_BY_BASE_REQUEST_TIMEOUT", "CONNECT_FAILED_BY_STATE_CHANGE", "CONNECT_FAILED_BY_GATT", "CONNECT_FAILED_BY_CONNECT_TIMEOUT", "CONNECT_FAILED_BY_SERVICE_TIMEOUT", "CONNECT_FAILED_BY_CONNECT_RETRY_COUNT", "CONNECT_FAILED_SERVICE_RETRY_COUNT", "ILLEGAL_ARGUMENT", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public enum mt {
    BLE_NOT_SUPPORT(101, "ble_not_support"),
    BLE_NOT_ADAPTER(102, "ble_not_adapter"),
    BLE_NOT_OPEN(103, "ble_not_open"),
    BLE_NOT_CONNECTED(104, "ble_not_connected"),
    BLE_NOT_FOUND_DEVICE(105, "ble_not_found_device"),
    BLE_NOT_FOUND_SERVICE(106, "ble_not_found_service"),
    BLE_NOT_FOUND_CHARACTER(107, "ble_not_found_character"),
    BLE_NOT_FOUND_DESCRIPTOR(108, "ble_not_found_descriptor"),
    BLE_NOT_SUPPORT_OPERATION(109, "ble_not_support_operation"),
    BLE_NOT_SUPPORT_WRITE(110, "ble_not_support_write"),
    BLE_NOT_SUPPORT_READ(111, "ble_not_support_read"),
    BLE_NOT_SUPPORT_NOTIFY(112, "ble_not_support_notify"),
    BLE_NOT_SUPPORT_INDICATE(113, "ble_not_support_indicate"),
    BLE_NOT_SUPPORT_MTU(114, "ble_not_support_mtu"),
    BLE_NOT_SUPPORT_DESCRIPTOR(115, "ble_not_support_descriptor"),
    BLE_SERVICE_NOT_BIND(116, "ble_service_not_bind"),
    BLE_SERVICE_UNREADY(116, "ble_service_unready"),
    REQUEST_FAILED(201, "request_failed"),
    REQUEST_SUCCESS(202, "request_success"),
    REQUEST_EXCEPTION(203, "request_exception"),
    REQUEST_TIMEOUT(204, "request_timeout"),
    REQUEST_CANCEL(205, "request_cancel"),
    REQUEST_OVERFLOW(206, "request_overflow"),
    REQUEST_DENIED(207, "request_denied"),
    SEARCH_START(301, "search_start"),
    SEARCH_CANCEL(302, "search_cancel"),
    SEARCH_STOP(304, "search_stop"),
    SEARCH_DEVICE_FOUND(304, "search_device_found"),
    SEARCHING(305, "searching"),
    SEARCH_TOO_FAST(306, "search_too_fast"),
    CONNECT_CANCEL(TypedValues.CycleType.TYPE_VISIBILITY, "connect_cancel"),
    CONNECT_FAILED_BY_BASE_REQUEST_TIMEOUT(401, "connect_failed_by_base_request_timeout"),
    CONNECT_FAILED_BY_STATE_CHANGE(TypedValues.CycleType.TYPE_VISIBILITY, "connect_failed_by_state_change"),
    CONNECT_FAILED_BY_GATT(TypedValues.CycleType.TYPE_VISIBILITY, "connect_gatt_failed"),
    CONNECT_FAILED_BY_CONNECT_TIMEOUT(403, "connect_failed_by_connect_timeout"),
    CONNECT_FAILED_BY_SERVICE_TIMEOUT(403, "connect_failed_by_service_timeout"),
    CONNECT_FAILED_BY_CONNECT_RETRY_COUNT(403, "connect_failed_by_connect_retry_count"),
    CONNECT_FAILED_SERVICE_RETRY_COUNT(403, "connect_failed_service_retry_count"),
    ILLEGAL_ARGUMENT(901, "illegal_argument");

    private final int code;

    @NotNull
    private final String msg;

    mt(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public static /* synthetic */ BleResultBean toResultBean$default(mt mtVar, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toResultBean");
        }
        if ((i & 1) != 0) {
            num = null;
        }
        return mtVar.toResultBean(num);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final BleResultBean toResultBean(@Nullable Integer status) {
        return new BleResultBean(this.code, this.msg, status);
    }

    /* synthetic */ mt(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str);
    }
}
