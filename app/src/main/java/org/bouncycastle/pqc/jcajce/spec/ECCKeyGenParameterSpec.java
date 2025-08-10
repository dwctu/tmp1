package org.bouncycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

/* loaded from: classes5.dex */
public class ECCKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;
    private int m;
    private int n;
    private int t;

    public ECCKeyGenParameterSpec() {
        this(11, 50);
    }

    public ECCKeyGenParameterSpec(int i) throws InvalidParameterException {
        if (i < 1) {
            throw new InvalidParameterException("key size must be positive");
        }
        this.m = 0;
        this.n = 1;
        while (true) {
            int i2 = this.n;
            if (i2 >= i) {
                int i3 = i2 >>> 1;
                this.t = i3;
                int i4 = this.m;
                this.t = i3 / i4;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i4);
                return;
            }
            this.n = i2 << 1;
            this.m++;
        }
    }

    public ECCKeyGenParameterSpec(int i, int i2) throws InvalidParameterException {
        if (i < 1) {
            throw new InvalidParameterException("m must be positive");
        }
        if (i > 32) {
            throw new InvalidParameterException("m is too large");
        }
        this.m = i;
        int i3 = 1 << i;
        this.n = i3;
        if (i2 < 0) {
            throw new InvalidParameterException("t must be positive");
        }
        if (i2 > i3) {
            throw new InvalidParameterException("t must be less than n = 2^m");
        }
        this.t = i2;
        this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i);
    }

    public ECCKeyGenParameterSpec(int i, int i2, int i3) throws InvalidParameterException {
        this.m = i;
        if (i < 1) {
            throw new InvalidParameterException("m must be positive");
        }
        if (i > 32) {
            throw new InvalidParameterException(" m is too large");
        }
        int i4 = 1 << i;
        this.n = i4;
        this.t = i2;
        if (i2 < 0) {
            throw new InvalidParameterException("t must be positive");
        }
        if (i2 > i4) {
            throw new InvalidParameterException("t must be less than n = 2^m");
        }
        if (PolynomialRingGF2.degree(i3) != i || !PolynomialRingGF2.isIrreducible(i3)) {
            throw new InvalidParameterException("polynomial is not a field polynomial for GF(2^m)");
        }
        this.fieldPoly = i3;
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.m;
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }
}
