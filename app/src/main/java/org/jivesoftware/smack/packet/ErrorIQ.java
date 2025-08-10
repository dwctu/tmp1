package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public class ErrorIQ extends SimpleIQ {
    public static final String ELEMENT = "error";

    public ErrorIQ(XMPPError xMPPError) {
        super("error", null);
        Objects.requireNonNull(xMPPError, "XMPPError must not be null");
        setType(IQ.Type.error);
        setError(xMPPError);
    }
}
