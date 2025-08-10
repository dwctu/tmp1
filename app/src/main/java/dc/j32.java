package dc;

import java.io.Serializable;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: SetToyResponse.java */
/* loaded from: classes3.dex */
public class j32 implements Serializable {
    private String code;
    private String message;
    private boolean result;

    public String toString() {
        return "SetToyResponse{result=" + this.result + ", message='" + this.message + "', code='" + this.code + '\'' + MessageFormatter.DELIM_STOP;
    }
}
