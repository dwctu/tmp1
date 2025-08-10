package dc;

import kotlin.Metadata;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: AAEum.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/business/longc/data/AAEum$PlayState;", "", XHTMLText.CODE, "", "(Ljava/lang/String;IB)V", "getCode", "()B", "STOP", "PAUSE", "PLAY", "PLAYING_END", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public enum i10 {
    STOP((byte) 0),
    PAUSE((byte) 1),
    PLAY((byte) 2),
    PLAYING_END((byte) 2);

    private final byte code;

    i10(byte b) {
        this.code = b;
    }

    public final byte getCode() {
        return this.code;
    }
}
