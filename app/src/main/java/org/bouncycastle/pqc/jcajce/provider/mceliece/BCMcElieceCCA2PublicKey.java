package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.broadcom.bt.util.io.IOUtils;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2PublicKeySpec;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes5.dex */
public class BCMcElieceCCA2PublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceCCA2Parameters McElieceCCA2Params;
    private GF2Matrix g;
    private int n;
    private String oid;
    private int t;

    public BCMcElieceCCA2PublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i;
        this.t = i2;
        this.g = gF2Matrix;
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this(mcElieceCCA2PublicKeyParameters.getOIDString(), mcElieceCCA2PublicKeyParameters.getN(), mcElieceCCA2PublicKeyParameters.getT(), mcElieceCCA2PublicKeyParameters.getMatrixG());
        this.McElieceCCA2Params = mcElieceCCA2PublicKeyParameters.getParameters();
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeySpec mcElieceCCA2PublicKeySpec) {
        this(mcElieceCCA2PublicKeySpec.getOIDString(), mcElieceCCA2PublicKeySpec.getN(), mcElieceCCA2PublicKeySpec.getT(), mcElieceCCA2PublicKeySpec.getMatrixG());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
        return this.n == bCMcElieceCCA2PublicKey.n && this.t == bCMcElieceCCA2PublicKey.t && this.g.equals(bCMcElieceCCA2PublicKey.g);
    }

    public ASN1Primitive getAlgParams() {
        return null;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), (ASN1Encodable) DERNull.INSTANCE), new McElieceCCA2PublicKey(new ASN1ObjectIdentifier(this.oid), this.n, this.t, this.g)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    public GF2Matrix getG() {
        return this.g;
    }

    public int getK() {
        return this.g.getNumRows();
    }

    public McElieceCCA2Parameters getMcElieceCCA2Parameters() {
        return this.McElieceCCA2Params;
    }

    public int getN() {
        return this.n;
    }

    public ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    }

    public String getOIDString() {
        return this.oid;
    }

    public int getT() {
        return this.t;
    }

    public int hashCode() {
        return this.n + this.t + this.g.hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.n + IOUtils.LINE_SEPARATOR_UNIX) + " error correction capability: " + this.t + IOUtils.LINE_SEPARATOR_UNIX) + " generator matrix           : " + this.g.toString();
    }
}
