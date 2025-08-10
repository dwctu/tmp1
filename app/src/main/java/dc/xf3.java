package dc;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/* compiled from: RSAUtils.java */
/* loaded from: classes4.dex */
public final class xf3 {
    public static String a = "RSA";

    public static String a(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            String string = new StringBuilder(str).reverse().toString();
            PublicKey publicKeyB = b(str2, str3);
            Cipher cipher = Cipher.getInstance(a);
            cipher.init(1, publicKeyB);
            return new String(Hex.encodeHex(cipher.doFinal(string.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static PublicKey b(String str, String str2) throws InvalidKeySpecException, DecoderException, NoSuchAlgorithmException {
        return KeyFactory.getInstance(a).generatePublic(new RSAPublicKeySpec(new BigInteger(Hex.decodeHex(str.toCharArray())), new BigInteger(Hex.decodeHex(str2.toCharArray()))));
    }
}
