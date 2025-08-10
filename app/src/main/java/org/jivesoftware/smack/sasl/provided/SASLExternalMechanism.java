package org.jivesoftware.smack.sasl.provided;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class SASLExternalMechanism extends SASLMechanism {
    public static final String NAME = "EXTERNAL";

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void authenticateInternal(CallbackHandler callbackHandler) throws SmackException {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() throws SmackException {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public byte[] getAuthenticationText() throws SmackException {
        if (StringUtils.isNullOrEmpty(this.authenticationId)) {
            return null;
        }
        return SASLMechanism.toBytes(XmppStringUtils.completeJidFrom(this.authenticationId, this.serviceName));
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return "EXTERNAL";
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return TypedValues.PositionType.TYPE_POSITION_TYPE;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SASLMechanism newInstance() {
        return new SASLExternalMechanism();
    }
}
