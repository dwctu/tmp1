package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.broadcom.bt.util.io.IOUtils;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2PrivateKeySpec;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* loaded from: classes5.dex */
public class BCMcElieceCCA2PrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;
    private GF2Matrix h;
    private int k;
    private McElieceCCA2Parameters mcElieceCCA2Params;
    private int n;
    private String oid;
    private Permutation p;
    private PolynomialGF2mSmallM[] qInv;

    public BCMcElieceCCA2PrivateKey(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, GF2Matrix gF2Matrix, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.oid = str;
        this.n = i;
        this.k = i2;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.p = permutation;
        this.h = gF2Matrix;
        this.qInv = polynomialGF2mSmallMArr;
    }

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this(mcElieceCCA2PrivateKeyParameters.getOIDString(), mcElieceCCA2PrivateKeyParameters.getN(), mcElieceCCA2PrivateKeyParameters.getK(), mcElieceCCA2PrivateKeyParameters.getField(), mcElieceCCA2PrivateKeyParameters.getGoppaPoly(), mcElieceCCA2PrivateKeyParameters.getP(), mcElieceCCA2PrivateKeyParameters.getH(), mcElieceCCA2PrivateKeyParameters.getQInv());
        this.mcElieceCCA2Params = mcElieceCCA2PrivateKeyParameters.getParameters();
    }

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeySpec mcElieceCCA2PrivateKeySpec) {
        this(mcElieceCCA2PrivateKeySpec.getOIDString(), mcElieceCCA2PrivateKeySpec.getN(), mcElieceCCA2PrivateKeySpec.getK(), mcElieceCCA2PrivateKeySpec.getField(), mcElieceCCA2PrivateKeySpec.getGoppaPoly(), mcElieceCCA2PrivateKeySpec.getP(), mcElieceCCA2PrivateKeySpec.getH(), mcElieceCCA2PrivateKeySpec.getQInv());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PrivateKey)) {
            return false;
        }
        BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) obj;
        return this.n == bCMcElieceCCA2PrivateKey.n && this.k == bCMcElieceCCA2PrivateKey.k && this.field.equals(bCMcElieceCCA2PrivateKey.field) && this.goppaPoly.equals(bCMcElieceCCA2PrivateKey.goppaPoly) && this.p.equals(bCMcElieceCCA2PrivateKey.p) && this.h.equals(bCMcElieceCCA2PrivateKey.h);
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
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(getOID(), (ASN1Encodable) DERNull.INSTANCE), new McElieceCCA2PrivateKey(new ASN1ObjectIdentifier(this.oid), this.n, this.k, this.field, this.goppaPoly, this.p, this.h, this.qInv)).getEncoded();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public GF2mField getField() {
        return this.field;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.h;
    }

    public int getK() {
        return this.k;
    }

    public McElieceCCA2Parameters getMcElieceCCA2Parameters() {
        return this.mcElieceCCA2Params;
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

    public Permutation getP() {
        return this.p;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public int getT() {
        return this.goppaPoly.getDegree();
    }

    public int hashCode() {
        return this.k + this.n + this.field.hashCode() + this.goppaPoly.hashCode() + this.p.hashCode() + this.h.hashCode();
    }

    public String toString() {
        return ((" extension degree of the field      : " + this.n + IOUtils.LINE_SEPARATOR_UNIX) + " dimension of the code              : " + this.k + IOUtils.LINE_SEPARATOR_UNIX) + " irreducible Goppa polynomial       : " + this.goppaPoly + IOUtils.LINE_SEPARATOR_UNIX;
    }
}
