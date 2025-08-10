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
import org.bouncycastle.pqc.asn1.McEliecePublicKey;
import org.bouncycastle.pqc.crypto.mceliece.McElieceParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McEliecePublicKeySpec;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes5.dex */
public class BCMcEliecePublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceParameters McElieceParams;
    private GF2Matrix g;
    private int n;
    private String oid;
    private int t;

    public BCMcEliecePublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i;
        this.t = i2;
        this.g = gF2Matrix;
    }

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this(mcEliecePublicKeyParameters.getOIDString(), mcEliecePublicKeyParameters.getN(), mcEliecePublicKeyParameters.getT(), mcEliecePublicKeyParameters.getG());
        this.McElieceParams = mcEliecePublicKeyParameters.getParameters();
    }

    public BCMcEliecePublicKey(McEliecePublicKeySpec mcEliecePublicKeySpec) {
        this(mcEliecePublicKeySpec.getOIDString(), mcEliecePublicKeySpec.getN(), mcEliecePublicKeySpec.getT(), mcEliecePublicKeySpec.getG());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        return this.n == bCMcEliecePublicKey.n && this.t == bCMcEliecePublicKey.t && this.g.equals(bCMcEliecePublicKey.g);
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
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), (ASN1Encodable) DERNull.INSTANCE), new McEliecePublicKey(new ASN1ObjectIdentifier(this.oid), this.n, this.t, this.g)).getEncoded();
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

    public McElieceParameters getMcElieceParameters() {
        return this.McElieceParams;
    }

    public int getN() {
        return this.n;
    }

    public ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
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
