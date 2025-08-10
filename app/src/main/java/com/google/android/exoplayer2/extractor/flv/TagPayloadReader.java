package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes2.dex */
public abstract class TagPayloadReader {
    public final TrackOutput output;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final boolean consume(ParsableByteArray parsableByteArray, long j) throws ParserException {
        return parseHeader(parsableByteArray) && parsePayload(parsableByteArray, j);
    }

    public abstract boolean parseHeader(ParsableByteArray parsableByteArray) throws ParserException;

    public abstract boolean parsePayload(ParsableByteArray parsableByteArray, long j) throws ParserException;

    public abstract void seek();
}
