package org.jivesoftware.smackx.amp;

import java.util.Objects;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* loaded from: classes5.dex */
public class AMPMatchResourceCondition implements AMPExtension.Condition {
    public static final String NAME = "match-resource";
    private final Value value;

    public enum Value {
        any,
        exact,
        other
    }

    public AMPMatchResourceCondition(Value value) {
        Objects.requireNonNull(value, "Can't create AMPMatchResourceCondition with null value");
        this.value = value;
    }

    public static boolean isSupported(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return AMPManager.isConditionSupported(xMPPConnection, NAME);
    }

    @Override // org.jivesoftware.smackx.amp.packet.AMPExtension.Condition
    public String getName() {
        return NAME;
    }

    @Override // org.jivesoftware.smackx.amp.packet.AMPExtension.Condition
    public String getValue() {
        return this.value.toString();
    }
}
