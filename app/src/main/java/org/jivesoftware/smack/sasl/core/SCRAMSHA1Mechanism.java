package org.jivesoftware.smack.sasl.core;

import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jivesoftware.smack.util.MAC;
import org.jivesoftware.smack.util.SHA1;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.LruCache;

/* loaded from: classes5.dex */
public class SCRAMSHA1Mechanism extends SASLMechanism {
    private static final String DEFAULT_GS2_HEADER = "n,,";
    public static final String NAME = "SCRAM-SHA-1";
    private static final int RANDOM_ASCII_BYTE_COUNT = 32;
    private String clientFirstMessageBare;
    private String clientRandomAscii;
    private byte[] serverSignature;
    private State state = State.INITIAL;
    private static final byte[] CLIENT_KEY_BYTES = SASLMechanism.toBytes("Client Key");
    private static final byte[] SERVER_KEY_BYTES = SASLMechanism.toBytes("Server Key");
    private static final byte[] ONE = {0, 0, 0, 1};
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Cache<String, Keys> CACHE = new LruCache(10);

    /* renamed from: org.jivesoftware.smack.sasl.core.SCRAMSHA1Mechanism$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$sasl$core$SCRAMSHA1Mechanism$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$jivesoftware$smack$sasl$core$SCRAMSHA1Mechanism$State = iArr;
            try {
                iArr[State.AUTH_TEXT_SENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$sasl$core$SCRAMSHA1Mechanism$State[State.RESPONSE_SENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Keys {
        private final byte[] clientKey;
        private final byte[] serverKey;

        public Keys(byte[] bArr, byte[] bArr2) {
            this.clientKey = bArr;
            this.serverKey = bArr2;
        }
    }

    public enum State {
        INITIAL,
        AUTH_TEXT_SENT,
        RESPONSE_SENT,
        VALID_SERVER_RESPONSE
    }

    private static String escape(String str) {
        StringBuilder sb = new StringBuilder((int) (str.length() * 1.1d));
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ',') {
                sb.append("=2C");
            } else if (cCharAt != '=') {
                sb.append(cCharAt);
            } else {
                sb.append("=3D");
            }
        }
        return sb.toString();
    }

    private static byte[] hi(String str, byte[] bArr, int i) throws SmackException {
        byte[] bytes = str.getBytes();
        byte[] bArrHmac = hmac(bytes, ByteUtils.concact(bArr, ONE));
        byte[] bArr2 = (byte[]) bArrHmac.clone();
        for (int i2 = 1; i2 < i; i2++) {
            bArrHmac = hmac(bytes, bArrHmac);
            for (int i3 = 0; i3 < bArrHmac.length; i3++) {
                bArr2[i3] = (byte) (bArr2[i3] ^ bArrHmac[i3]);
            }
        }
        return bArr2;
    }

    private static byte[] hmac(byte[] bArr, byte[] bArr2) throws SmackException {
        try {
            return MAC.hmacsha1(bArr, bArr2);
        } catch (InvalidKeyException e) {
            throw new SmackException("SCRAM-SHA-1 HMAC-SHA1 Exception", e);
        }
    }

    private static boolean isPrintableNonCommaAsciiChar(char c) {
        return c != ',' && c >= ' ' && c < 127;
    }

    private static Map<Character, String> parseAttributes(String str) throws SmackException {
        if (str.length() == 0) {
            return Collections.emptyMap();
        }
        String[] strArrSplit = str.split(",");
        HashMap map = new HashMap(strArrSplit.length, 1.0f);
        for (String str2 : strArrSplit) {
            if (str2.length() < 3) {
                throw new SmackException("Invalid Key-Value pair: " + str2);
            }
            char cCharAt = str2.charAt(0);
            if (str2.charAt(1) != '=') {
                throw new SmackException("Invalid Key-Value pair: " + str2);
            }
            map.put(Character.valueOf(cCharAt), str2.substring(2));
        }
        return map;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void authenticateInternal(CallbackHandler callbackHandler) throws SmackException {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() throws SmackException {
        if (this.state != State.VALID_SERVER_RESPONSE) {
            throw new SmackException("SCRAM-SHA1 is missing valid server response");
        }
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public byte[] evaluateChallenge(byte[] bArr) throws SmackException, NumberFormatException {
        byte[] bArrHmac;
        byte[] bArrHmac2;
        String str = new String(bArr);
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$sasl$core$SCRAMSHA1Mechanism$State[this.state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new SmackException("Invalid state");
            }
            if (!("v=" + Base64.encodeToString(this.serverSignature)).equals(str)) {
                throw new SmackException("Server final message does not match calculated one");
            }
            this.state = State.VALID_SERVER_RESPONSE;
            return null;
        }
        Map<Character, String> attributes = parseAttributes(str);
        String str2 = attributes.get('r');
        if (str2 == null) {
            throw new SmackException("Server random ASCII is null");
        }
        if (str2.length() <= this.clientRandomAscii.length()) {
            throw new SmackException("Server random ASCII is shorter then client random ASCII");
        }
        if (!str2.substring(0, this.clientRandomAscii.length()).equals(this.clientRandomAscii)) {
            throw new SmackException("Received client random ASCII does not match client random ASCII");
        }
        String str3 = attributes.get('i');
        if (str3 == null) {
            throw new SmackException("Iterations attribute not set");
        }
        try {
            int i2 = Integer.parseInt(str3);
            String str4 = attributes.get('s');
            if (str4 == null) {
                throw new SmackException("SALT not send");
            }
            String str5 = "c=" + Base64.encode(DEFAULT_GS2_HEADER) + ",r=" + str2;
            byte[] bytes = SASLMechanism.toBytes(this.clientFirstMessageBare + ',' + str + ',' + str5);
            StringBuilder sb = new StringBuilder();
            sb.append(this.password);
            sb.append(',');
            sb.append(str4);
            String string = sb.toString();
            Cache<String, Keys> cache = CACHE;
            Keys keys = cache.get(string);
            if (keys == null) {
                byte[] bArrHi = hi(SASLMechanism.saslPrep(this.password), Base64.decode(str4), i2);
                bArrHmac = hmac(bArrHi, SERVER_KEY_BYTES);
                bArrHmac2 = hmac(bArrHi, CLIENT_KEY_BYTES);
                cache.put(string, new Keys(bArrHmac2, bArrHmac));
            } else {
                bArrHmac = keys.serverKey;
                bArrHmac2 = keys.clientKey;
            }
            this.serverSignature = hmac(bArrHmac, bytes);
            byte[] bArrHmac3 = hmac(SHA1.bytes(bArrHmac2), bytes);
            int length = bArrHmac2.length;
            byte[] bArr2 = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                bArr2[i3] = (byte) (bArrHmac2[i3] ^ bArrHmac3[i3]);
            }
            String str6 = str5 + ",p=" + Base64.encodeToString(bArr2);
            this.state = State.RESPONSE_SENT;
            return SASLMechanism.toBytes(str6);
        } catch (NumberFormatException e) {
            throw new SmackException("Exception parsing iterations", e);
        }
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public byte[] getAuthenticationText() throws SmackException {
        this.clientRandomAscii = getRandomAscii();
        this.clientFirstMessageBare = "n=" + escape(SASLMechanism.saslPrep(this.authenticationId)) + ",r=" + this.clientRandomAscii;
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_GS2_HEADER);
        sb.append(this.clientFirstMessageBare);
        String string = sb.toString();
        this.state = State.AUTH_TEXT_SENT;
        return SASLMechanism.toBytes(string);
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return NAME;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 110;
    }

    public String getRandomAscii() {
        char[] cArr = new char[32];
        int i = 0;
        while (i < 32) {
            char cNextInt = (char) RANDOM.nextInt(128);
            if (isPrintableNonCommaAsciiChar(cNextInt)) {
                cArr[i] = cNextInt;
                i++;
            }
        }
        return new String(cArr);
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SCRAMSHA1Mechanism newInstance() {
        return new SCRAMSHA1Mechanism();
    }
}
