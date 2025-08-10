package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

/* loaded from: classes5.dex */
public class BasicEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;
    private final SecureRandom _sr;

    public BasicEntropySourceProvider(SecureRandom secureRandom, boolean z) {
        this._sr = secureRandom;
        this._predictionResistant = z;
    }

    @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(final int i) {
        return new EntropySource() { // from class: org.bouncycastle.crypto.prng.BasicEntropySourceProvider.1
            @Override // org.bouncycastle.crypto.prng.EntropySource
            public int entropySize() {
                return i;
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public byte[] getEntropy() {
                return BasicEntropySourceProvider.this._sr.generateSeed((i + 7) / 8);
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public boolean isPredictionResistant() {
                return BasicEntropySourceProvider.this._predictionResistant;
            }
        };
    }
}
