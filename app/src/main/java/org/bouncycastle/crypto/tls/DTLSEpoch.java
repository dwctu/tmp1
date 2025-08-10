package org.bouncycastle.crypto.tls;

/* loaded from: classes5.dex */
public class DTLSEpoch {
    private final TlsCipher cipher;
    private final int epoch;
    private final DTLSReplayWindow replayWindow = new DTLSReplayWindow();
    private long sequence_number = 0;

    public DTLSEpoch(int i, TlsCipher tlsCipher) {
        if (i < 0) {
            throw new IllegalArgumentException("'epoch' must be >= 0");
        }
        if (tlsCipher == null) {
            throw new IllegalArgumentException("'cipher' cannot be null");
        }
        this.epoch = i;
        this.cipher = tlsCipher;
    }

    public long allocateSequenceNumber() {
        long j = this.sequence_number;
        this.sequence_number = 1 + j;
        return j;
    }

    public TlsCipher getCipher() {
        return this.cipher;
    }

    public int getEpoch() {
        return this.epoch;
    }

    public DTLSReplayWindow getReplayWindow() {
        return this.replayWindow;
    }

    public long getSequence_number() {
        return this.sequence_number;
    }
}
