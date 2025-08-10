package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.bouncycastle.jcajce.spec.SkeinParameterSpec;

/* loaded from: classes5.dex */
public class BaseMac extends MacSpi implements PBE {
    private int keySize;
    private Mac macEngine;
    private int pbeHash;
    private int pbeType;

    public BaseMac(Mac mac) {
        this.pbeType = 2;
        this.pbeHash = 1;
        this.keySize = 160;
        this.macEngine = mac;
    }

    public BaseMac(Mac mac, int i, int i2, int i3) {
        this.pbeType = 2;
        this.pbeHash = 1;
        this.keySize = 160;
        this.macEngine = mac;
        this.pbeType = i;
        this.pbeHash = i2;
        this.keySize = i3;
    }

    private static Hashtable copyMap(Map map) {
        Hashtable hashtable = new Hashtable();
        for (Object obj : map.keySet()) {
            hashtable.put(obj, map.get(obj));
        }
        return hashtable;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() throws IllegalStateException, DataLengthException {
        byte[] bArr = new byte[engineGetMacLength()];
        this.macEngine.doFinal(bArr, 0);
        return bArr;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, IllegalArgumentException, InvalidAlgorithmParameterException {
        CipherParameters keyParameter;
        if (key == null) {
            throw new InvalidKeyException("key is null");
        }
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (bCPBEKey.getParam() != null) {
                keyParameter = bCPBEKey.getParam();
            } else {
                if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                keyParameter = PBE.Util.makePBEMacParameters(bCPBEKey, algorithmParameterSpec);
            }
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            keyParameter = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
        } else if (algorithmParameterSpec instanceof SkeinParameterSpec) {
            keyParameter = new SkeinParameters.Builder(copyMap(((SkeinParameterSpec) algorithmParameterSpec).getParameters())).setKey(key.getEncoded()).build();
        } else {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("unknown parameter type.");
            }
            keyParameter = new KeyParameter(key.getEncoded());
        }
        this.macEngine.init(keyParameter);
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        this.macEngine.reset();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b) throws IllegalStateException {
        this.macEngine.update(b);
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException {
        this.macEngine.update(bArr, i, i2);
    }
}
