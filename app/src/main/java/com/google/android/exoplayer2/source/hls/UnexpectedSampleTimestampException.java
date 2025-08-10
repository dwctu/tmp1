package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long j, long j2) {
        long jUsToMs = Util.usToMs(j2);
        long j3 = mediaChunk.startTimeUs;
        long j4 = mediaChunk.endTimeUs;
        StringBuilder sb = new StringBuilder(103);
        sb.append("Unexpected sample timestamp: ");
        sb.append(jUsToMs);
        sb.append(" in chunk [");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append("]");
        super(sb.toString());
        this.mediaChunk = mediaChunk;
        this.lastAcceptedSampleTimeUs = j;
        this.rejectedSampleTimeUs = j2;
    }
}
