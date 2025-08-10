package dc;

import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: RandomAccessFileMode.java */
/* loaded from: classes5.dex */
public enum x94 {
    READ(StreamManagement.AckRequest.ELEMENT),
    WRITE("rw");

    private String value;

    x94(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
