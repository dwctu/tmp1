package dc;

import kotlin.Metadata;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: AAEum.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/business/longc/data/AAEum$Type;", "", XHTMLText.CODE, "", "(Ljava/lang/String;IB)V", "getCode", "()B", "WRITE_PATTERN_JUST_20", "WRITE_PATTERN_CLEAR_20", "WRITE_PATTERN_CLEAR_RUN_20", "WRITE_PATTERN_JUST_100", "WRITE_PATTERN_CLEAR_100", "WRITE_PATTERN_CLEAR_RUN_100", "PLAY_PATTERN_ACTION", "READ_PATTERN_STATUS", "SET_PATTERN_SPEED", "SET_PATTERN_PROGRAM", "SET_PATTERN_PROGRAM_CONTROL", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public enum k10 {
    WRITE_PATTERN_JUST_20(Byte.MIN_VALUE),
    WRITE_PATTERN_CLEAR_20((byte) -127),
    WRITE_PATTERN_CLEAR_RUN_20((byte) -126),
    WRITE_PATTERN_JUST_100((byte) -123),
    WRITE_PATTERN_CLEAR_100((byte) -122),
    WRITE_PATTERN_CLEAR_RUN_100((byte) -121),
    PLAY_PATTERN_ACTION((byte) -118),
    READ_PATTERN_STATUS((byte) -117),
    SET_PATTERN_SPEED((byte) -116),
    SET_PATTERN_PROGRAM((byte) -115),
    SET_PATTERN_PROGRAM_CONTROL((byte) -114);

    private final byte code;

    k10(byte b) {
        this.code = b;
    }

    public final byte getCode() {
        return this.code;
    }
}
