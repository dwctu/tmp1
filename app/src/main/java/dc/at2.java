package dc;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DHCoder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011J\u001a\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011J\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/ui/chat/entry/DHCoder;", "", "()V", "KEY_ALGORITHM", "", "KEY_SIZE", "", "PRIVATE_KEY", "PUBLIC_KEY", "SECRET_KEY_ALGORITHM", "decrypt", "", "data", "key", "encrypt", "getPrivateKey", "keyMap", "", "getPublicKey", "getSecretKey", "publicKey", "privateKey", "initKey", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class at2 {

    @NotNull
    public static final at2 a = new at2();

    @NotNull
    public final byte[] a(@NotNull byte[] data, @NotNull byte[] key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
        cipher.init(2, secretKeySpec);
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
        return bArrDoFinal;
    }

    @NotNull
    public final byte[] b(@NotNull byte[] data, @NotNull byte[] key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
        cipher.init(1, secretKeySpec);
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
        return bArrDoFinal;
    }

    @NotNull
    public final byte[] c(@NotNull Map<String, ? extends Object> keyMap) {
        Intrinsics.checkNotNullParameter(keyMap, "keyMap");
        Object obj = keyMap.get("DHPrivateKey");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.security.Key");
        byte[] encoded = ((Key) obj).getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "key.encoded");
        return encoded;
    }

    @NotNull
    public final byte[] d(@NotNull Map<String, ? extends Object> keyMap) {
        Intrinsics.checkNotNullParameter(keyMap, "keyMap");
        Object obj = keyMap.get("DHPublicKey");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.security.Key");
        byte[] encoded = ((Key) obj).getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "key.encoded");
        return encoded;
    }

    @NotNull
    public final byte[] e(@NotNull byte[] publicKey, @NotNull byte[] privateKey) throws IllegalStateException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
        Intrinsics.checkNotNull(publicKeyGeneratePublic, "null cannot be cast to non-null type javax.crypto.interfaces.DHPublicKey");
        PrivateKey privateKeyGeneratePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        Intrinsics.checkNotNull(privateKeyGeneratePrivate, "null cannot be cast to non-null type javax.crypto.interfaces.DHPrivateKey");
        KeyAgreement keyAgreement = KeyAgreement.getInstance(keyFactory.getAlgorithm());
        keyAgreement.init((DHPrivateKey) privateKeyGeneratePrivate);
        keyAgreement.doPhase((DHPublicKey) publicKeyGeneratePublic, true);
        byte[] encoded = keyAgreement.generateSecret("AES").getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "secretKey.encoded");
        return encoded;
    }

    @NotNull
    public final Map<String, Object> f(@NotNull byte[] key) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(key, "key");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Intrinsics.checkNotNull(publicKeyGeneratePublic, "null cannot be cast to non-null type javax.crypto.interfaces.DHPublicKey");
        DHParameterSpec params = ((DHPublicKey) publicKeyGeneratePublic).getParams();
        Intrinsics.checkNotNullExpressionValue(params, "pubKey.params");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(keyFactory.getAlgorithm());
        Intrinsics.checkNotNullExpressionValue(keyPairGenerator, "getInstance(keyFactory.algorithm)");
        keyPairGenerator.initialize(params);
        KeyPair keyPairGenKeyPair = keyPairGenerator.genKeyPair();
        Intrinsics.checkNotNullExpressionValue(keyPairGenKeyPair, "keyPairGenerator.genKeyPair()");
        PublicKey publicKey = keyPairGenKeyPair.getPublic();
        Intrinsics.checkNotNull(publicKey, "null cannot be cast to non-null type javax.crypto.interfaces.DHPublicKey");
        PrivateKey privateKey = keyPairGenKeyPair.getPrivate();
        Intrinsics.checkNotNull(privateKey, "null cannot be cast to non-null type javax.crypto.interfaces.DHPrivateKey");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("DHPublicKey", (DHPublicKey) publicKey), TuplesKt.to("DHPrivateKey", (DHPrivateKey) privateKey));
    }
}
