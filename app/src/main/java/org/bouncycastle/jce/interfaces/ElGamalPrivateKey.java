package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* loaded from: classes5.dex */
public interface ElGamalPrivateKey extends ElGamalKey, PrivateKey {
    BigInteger getX();
}
