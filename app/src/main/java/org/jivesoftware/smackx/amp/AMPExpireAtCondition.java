package org.jivesoftware.smackx.amp;

import java.util.Date;
import java.util.Objects;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jxmpp.util.XmppDateTime;

/* loaded from: classes5.dex */
public class AMPExpireAtCondition implements AMPExtension.Condition {
    public static final String NAME = "expire-chat_notification_at";
    private final String value;

    public AMPExpireAtCondition(Date date) {
        Objects.requireNonNull(date, "Can't create AMPExpireAtCondition with null value");
        this.value = XmppDateTime.formatXEP0082Date(date);
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
        return this.value;
    }

    public AMPExpireAtCondition(String str) {
        Objects.requireNonNull(str, "Can't create AMPExpireAtCondition with null value");
        this.value = str;
    }
}
