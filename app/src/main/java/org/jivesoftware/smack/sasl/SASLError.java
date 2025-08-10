package org.jivesoftware.smack.sasl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes5.dex */
public enum SASLError {
    aborted,
    account_disabled,
    credentials_expired,
    encryption_required,
    incorrect_encoding,
    invalid_authzid,
    invalid_mechanism,
    malformed_request,
    mechanism_too_weak,
    not_authorized,
    temporary_auth_failure;

    private static final Logger LOGGER = Logger.getLogger(SASLError.class.getName());

    public static SASLError fromString(String str) {
        String strReplace = str.replace(SignatureImpl.SEP, '_');
        try {
            return valueOf(strReplace);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not transform string '" + strReplace + "' to SASLError", (Throwable) e);
            return null;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().replace('_', SignatureImpl.SEP);
    }
}
