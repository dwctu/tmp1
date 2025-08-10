package org.jivesoftware.smack.sasl;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;

/* loaded from: classes5.dex */
public class SASLAnonymous extends SASLMechanism {
    public static final String NAME = "ANONYMOUS";

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void authenticateInternal(CallbackHandler callbackHandler) throws SmackException {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() throws SmackException {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public byte[] getAuthenticationText() throws SmackException {
        return null;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return NAME;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 500;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SASLAnonymous newInstance() {
        return new SASLAnonymous();
    }
}
