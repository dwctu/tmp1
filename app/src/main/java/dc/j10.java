package dc;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import kotlin.Metadata;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: AAEum.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/business/longc/data/AAEum$Status;", "", XHTMLText.CODE, "", "(Ljava/lang/String;IB)V", "getCode", "()B", MonitorResult.SUCCESS, "ERROR_CMD", "ERROR_PARAM", "ERROR_CMD_NOT_SUPPORT", "ERROR_CRC", "ERROR_WRITE_FLASH", "ERROR_FUNSCRIPT_QUEUE_FULL", "ERROR_FUNSCRIPT_NEED_SUPPLY", "ERROR_FUNSCRIPT_QUEUE_EMPTY", "ERROR_FUNSCRIPT_UNKNOWN", "ERROR_QUEUE_EMPTY", "ERROR_UNKNOWN", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public enum j10 {
    SUCCESS((byte) 0),
    ERROR_CMD((byte) 1),
    ERROR_PARAM((byte) 2),
    ERROR_CMD_NOT_SUPPORT((byte) 3),
    ERROR_CRC((byte) 4),
    ERROR_WRITE_FLASH((byte) 5),
    ERROR_FUNSCRIPT_QUEUE_FULL((byte) 32),
    ERROR_FUNSCRIPT_NEED_SUPPLY((byte) 33),
    ERROR_FUNSCRIPT_QUEUE_EMPTY((byte) 34),
    ERROR_FUNSCRIPT_UNKNOWN((byte) 47),
    ERROR_QUEUE_EMPTY((byte) 48),
    ERROR_UNKNOWN(Byte.MIN_VALUE);

    private final byte code;

    j10(byte b) {
        this.code = b;
    }

    public final byte getCode() {
        return this.code;
    }
}
