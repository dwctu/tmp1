package io.agora.base.internal.video;

import io.agora.base.internal.CalledByNative;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class CodecSpecificInfo {
    private final ByteBuffer compressed_alpha_buffer;
    private final ByteBuffer metadata;

    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    public class CodecSpecificInfoHEVC extends CodecSpecificInfo {
        private VideoCodecProfile profile;

        public CodecSpecificInfoHEVC(VideoCodecProfile videoCodecProfile) {
            this.profile = videoCodecProfile;
        }

        @Override // io.agora.base.internal.video.CodecSpecificInfo
        public VideoCodecProfile getVideoCodecProfile() {
            return this.profile;
        }

        @Override // io.agora.base.internal.video.CodecSpecificInfo
        public VideoCodecType getVideoCodecType() {
            return VideoCodecType.H265;
        }
    }

    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    public CodecSpecificInfo() {
        this(null, null);
    }

    @CalledByNative
    public ByteBuffer getCompressedAlphadata() {
        return this.compressed_alpha_buffer;
    }

    @CalledByNative
    public ByteBuffer getMetadata() {
        return this.metadata;
    }

    public VideoCodecProfile getVideoCodecProfile() {
        return VideoCodecProfile.UNKNOWN;
    }

    public VideoCodecType getVideoCodecType() {
        return VideoCodecType.UNKNOWN;
    }

    @CalledByNative
    public CodecSpecificInfo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        this.metadata = byteBuffer;
        this.compressed_alpha_buffer = byteBuffer2;
    }
}
