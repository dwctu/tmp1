package org.bouncycastle.pqc.jcajce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* loaded from: classes5.dex */
public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    private static final String ALGORITHM_PACKAGE = "org.bouncycastle.pqc.jcajce.provider.";
    public static final ProviderConfiguration CONFIGURATION = null;
    public static String PROVIDER_NAME = "BCPQC";
    private static String info = "BouncyCastle Post-Quantum Security Provider v1.50";
    private static final Map keyInfoConverters = new HashMap();
    private static final String[] ALGORITHMS = {"Rainbow", "McEliece"};

    public BouncyCastlePQCProvider() {
        super(PROVIDER_NAME, 1.5d, info);
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider.1
            @Override // java.security.PrivilegedAction
            public Object run() throws ClassNotFoundException {
                BouncyCastlePQCProvider.this.setup();
                return null;
            }
        });
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) keyInfoConverters.get(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePrivate(privateKeyInfo);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) keyInfoConverters.get(subjectPublicKeyInfo.getAlgorithm().getAlgorithm());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePublic(subjectPublicKeyInfo);
    }

    private void loadAlgorithms(String str, String[] strArr) throws ClassNotFoundException {
        for (int i = 0; i != strArr.length; i++) {
            Class<?> clsLoadClass = null;
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                clsLoadClass = classLoader != null ? classLoader.loadClass(str + strArr[i] + "$Mappings") : Class.forName(str + strArr[i] + "$Mappings");
            } catch (ClassNotFoundException unused) {
            }
            if (clsLoadClass != null) {
                try {
                    ((AlgorithmProvider) clsLoadClass.newInstance()).configure(this);
                } catch (Exception e) {
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() throws ClassNotFoundException {
        loadAlgorithms(ALGORITHM_PACKAGE, ALGORITHMS);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException("duplicate provider key (" + str + ") found");
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        keyInfoConverters.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + "." + str2)) {
            if (!containsKey("Alg.Alias." + str + "." + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void setParameter(String str, Object obj) {
        synchronized (CONFIGURATION) {
        }
    }
}
