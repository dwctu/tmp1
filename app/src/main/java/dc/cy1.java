package dc;

import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* compiled from: CryptoObjectHelper.java */
/* loaded from: classes3.dex */
public class cy1 {
    public final KeyStore a;

    public cy1() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        this.a = keyStore;
        keyStore.load(null);
    }

    @TargetApi(23)
    public void a() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder("com.createchance.android.sample.fingerprint_authentication_key", 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setUserAuthenticationRequired(true).build());
        keyGenerator.generateKey();
    }

    public Key b() throws Exception {
        if (!this.a.isKeyEntry("com.createchance.android.sample.fingerprint_authentication_key")) {
            a();
        }
        return this.a.getKey("com.createchance.android.sample.fingerprint_authentication_key", null);
    }

    public FingerprintManagerCompat.CryptoObject c() throws Exception {
        return new FingerprintManagerCompat.CryptoObject(d(true));
    }

    @TargetApi(23)
    public Cipher d(boolean z) throws Exception {
        Key keyB = b();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        try {
            cipher.init(3, keyB);
        } catch (KeyPermanentlyInvalidatedException e) {
            this.a.deleteEntry("com.createchance.android.sample.fingerprint_authentication_key");
            if (!z) {
                throw new Exception("Could not create the cipher for fingerprint authentication.", e);
            }
            d(false);
        }
        return cipher;
    }
}
