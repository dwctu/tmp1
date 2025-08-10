package org.jivesoftware.smack.sasl.provided;

import javax.security.auth.callback.CallbackHandler;
import kotlin.text.Typography;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jivesoftware.smack.util.MD5;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes5.dex */
public class SASLDigestMD5Mechanism extends SASLMechanism {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INITAL_NONCE = "00000001";
    public static final String NAME = "DIGEST-MD5";
    private static final String QOP_VALUE = "auth";
    private static boolean verifyServerResponse = true;
    private String cnonce;
    private String digestUri;
    private String hex_hashed_a1;
    private String nonce;
    private State state = State.INITIAL;

    /* renamed from: org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State = iArr;
            try {
                iArr[State.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State[State.RESPONSE_SENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum DigestType {
        ClientResponse,
        ServerResponse
    }

    public enum State {
        INITIAL,
        RESPONSE_SENT,
        VALID_SERVER_RESPONSE
    }

    private String calcResponse(DigestType digestType) {
        StringBuilder sb = new StringBuilder();
        if (digestType == DigestType.ClientResponse) {
            sb.append("AUTHENTICATE");
        }
        sb.append(':');
        sb.append(this.digestUri);
        return StringUtils.encodeHex(MD5.bytes(this.hex_hashed_a1 + ':' + this.nonce + ':' + INITAL_NONCE + ':' + this.cnonce + ":auth:" + StringUtils.encodeHex(MD5.bytes(sb.toString()))));
    }

    public static void setVerifyServerResponse(boolean z) {
        verifyServerResponse = z;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void authenticateInternal(CallbackHandler callbackHandler) throws SmackException {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() throws SmackException {
        if (verifyServerResponse && this.state != State.VALID_SERVER_RESPONSE) {
            throw new SmackException("DIGEST-MD5 no valid server response");
        }
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public byte[] evaluateChallenge(byte[] bArr) throws SmackException {
        String str;
        if (bArr.length == 0) {
            throw new SmackException("Initial challenge has zero length");
        }
        String[] strArrSplit = new String(bArr).split(",");
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State[this.state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            if (verifyServerResponse) {
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str = null;
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i2].split("=");
                    String str2 = strArrSplit2[0];
                    str = strArrSplit2[1];
                    if ("rspauth".equals(str2)) {
                        break;
                    }
                    i2++;
                }
                if (str == null) {
                    throw new SmackException("No server response received while performing DIGEST-MD5 authentication");
                }
                if (!str.equals(calcResponse(DigestType.ServerResponse))) {
                    throw new SmackException("Invalid server response  while performing DIGEST-MD5 authentication");
                }
            }
            this.state = State.VALID_SERVER_RESPONSE;
            return null;
        }
        for (String str3 : strArrSplit) {
            String[] strArrSplit3 = str3.split("=");
            String strReplaceFirst = strArrSplit3[0].replaceFirst("^\\s+", "");
            String str4 = strArrSplit3[1];
            if ("nonce".equals(strReplaceFirst)) {
                if (this.nonce != null) {
                    throw new SmackException("Nonce value present multiple times");
                }
                this.nonce = str4.replace("\"", "");
            } else if ("qop".equals(strReplaceFirst)) {
                String strReplace = str4.replace("\"", "");
                if (!strReplace.equals("auth")) {
                    throw new SmackException("Unsupported qop operation: " + strReplace);
                }
            } else {
                continue;
            }
        }
        if (this.nonce == null) {
            throw new SmackException("nonce value not present in initial challenge");
        }
        byte[] bArrBytes = MD5.bytes(this.authenticationId + ':' + this.serviceName + ':' + this.password);
        this.cnonce = StringUtils.randomString(32);
        byte[] bArrConcact = ByteUtils.concact(bArrBytes, SASLMechanism.toBytes(':' + this.nonce + ':' + this.cnonce));
        StringBuilder sb = new StringBuilder();
        sb.append("xmpp/");
        sb.append(this.serviceName);
        this.digestUri = sb.toString();
        this.hex_hashed_a1 = StringUtils.encodeHex(MD5.bytes(bArrConcact));
        byte[] bytes = SASLMechanism.toBytes("username=\"" + this.authenticationId + Typography.quote + ",realm=\"" + this.serviceName + Typography.quote + ",nonce=\"" + this.nonce + Typography.quote + ",cnonce=\"" + this.cnonce + Typography.quote + ",nc=" + INITAL_NONCE + ",qop=auth,digest-uri=\"" + this.digestUri + Typography.quote + ",response=" + calcResponse(DigestType.ClientResponse) + ",charset=utf-8");
        this.state = State.RESPONSE_SENT;
        return bytes;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public byte[] getAuthenticationText() throws SmackException {
        return null;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return "DIGEST-MD5";
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 210;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SASLDigestMD5Mechanism newInstance() {
        return new SASLDigestMD5Mechanism();
    }
}
