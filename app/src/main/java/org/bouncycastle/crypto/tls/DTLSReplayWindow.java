package org.bouncycastle.crypto.tls;

/* loaded from: classes5.dex */
public class DTLSReplayWindow {
    private static final long VALID_SEQ_MASK = 281474976710655L;
    private static final long WINDOW_SIZE = 64;
    private long latestConfirmedSeq = -1;
    private long bitmap = 0;

    public void reportAuthenticated(long j) {
        if ((VALID_SEQ_MASK & j) != j) {
            throw new IllegalArgumentException("'seq' out of range");
        }
        long j2 = this.latestConfirmedSeq;
        if (j <= j2) {
            long j3 = j2 - j;
            if (j3 < 64) {
                this.bitmap |= 1 << ((int) j3);
                return;
            }
            return;
        }
        long j4 = j - j2;
        if (j4 >= 64) {
            this.bitmap = 1L;
        } else {
            long j5 = this.bitmap << ((int) j4);
            this.bitmap = j5;
            this.bitmap = j5 | 1;
        }
        this.latestConfirmedSeq = j;
    }

    public void reset() {
        this.latestConfirmedSeq = -1L;
        this.bitmap = 0L;
    }

    public boolean shouldDiscard(long j) {
        if ((VALID_SEQ_MASK & j) != j) {
            return true;
        }
        long j2 = this.latestConfirmedSeq;
        if (j > j2) {
            return false;
        }
        long j3 = j2 - j;
        return j3 >= 64 || (this.bitmap & (1 << ((int) j3))) != 0;
    }
}
