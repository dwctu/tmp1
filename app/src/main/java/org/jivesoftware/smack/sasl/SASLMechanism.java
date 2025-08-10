package org.jivesoftware.smack.sasl;

import android.text.TextUtils;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smack.util.JidTransformUtil;
import org.jivesoftware.smack.util.StringTransformer;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.json.JSONException;

/* loaded from: classes5.dex */
public abstract class SASLMechanism implements Comparable<SASLMechanism> {
    public static final String CRAMMD5 = "CRAM-MD5";
    public static final String DIGESTMD5 = "DIGEST-MD5";
    public static final String EXTERNAL = "EXTERNAL";
    public static final String GSSAPI = "GSSAPI";
    public static final String PLAIN = "PLAIN";
    private static StringTransformer saslPrepTransformer;
    public String authenticationId;
    public XMPPConnection connection;
    public String host;
    public String password;
    public String serviceName;
    private String modulus = "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883";
    private String exponent = "010001";

    public static String saslPrep(String str) {
        StringTransformer stringTransformer = saslPrepTransformer;
        return stringTransformer != null ? stringTransformer.transform(str) : str;
    }

    public static void setSaslPrepTransformer(StringTransformer stringTransformer) {
        saslPrepTransformer = stringTransformer;
    }

    public static byte[] toBytes(String str) {
        return StringUtils.toBytes(str);
    }

    public final void authenticate(String str, String str2, String str3, String str4) throws SmackException {
        this.authenticationId = str;
        this.host = str2;
        this.serviceName = str3;
        this.password = str4;
        authenticateInternal();
        authenticate();
    }

    public void authenticateInternal() throws SmackException {
    }

    public abstract void authenticateInternal(CallbackHandler callbackHandler) throws SmackException;

    public final void challengeReceived(String str, boolean z) throws SmackException, JSONException {
        byte[] bArrEvaluateChallenge = evaluateChallenge(Base64.decode(str));
        if (z) {
            return;
        }
        this.connection.send(bArrEvaluateChallenge == null ? new SaslStreamElements.Response() : new SaslStreamElements.Response(Base64.encodeToString(bArrEvaluateChallenge)));
    }

    public abstract void checkIfSuccessfulOrThrow() throws SmackException;

    public byte[] evaluateChallenge(byte[] bArr) throws SmackException, JSONException {
        if (bArr != null && bArr.length != 0) {
            String str = new String(bArr);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JidTransformUtil.setXY(str);
        }
        return null;
    }

    public abstract byte[] getAuthenticationText() throws SmackException;

    public abstract String getName();

    public abstract int getPriority();

    public SASLMechanism instanceForAuthentication(XMPPConnection xMPPConnection) {
        SASLMechanism sASLMechanismNewInstance = newInstance();
        sASLMechanismNewInstance.connection = xMPPConnection;
        return sASLMechanismNewInstance;
    }

    public abstract SASLMechanism newInstance();

    @Override // java.lang.Comparable
    public final int compareTo(SASLMechanism sASLMechanism) {
        return getPriority() - sASLMechanism.getPriority();
    }

    public void authenticate(String str, String str2, CallbackHandler callbackHandler) throws SmackException {
        this.host = str;
        this.serviceName = str2;
        authenticateInternal(callbackHandler);
        authenticate();
    }

    private final void authenticate() throws SmackException {
        byte[] authenticationText = getAuthenticationText();
        this.connection.send(new SaslStreamElements.AuthMechanism(getName(), authenticationText != null ? Base64.encodeToString(authenticationText) : "="));
    }
}
