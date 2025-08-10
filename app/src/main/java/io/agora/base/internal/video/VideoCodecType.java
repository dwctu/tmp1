package io.agora.base.internal.video;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public enum VideoCodecType {
    VP8(MimeTypes.VIDEO_VP8),
    VP9(MimeTypes.VIDEO_VP9),
    H264(MimeTypes.VIDEO_H264),
    H265(MimeTypes.VIDEO_H265),
    UNKNOWN("video/unknown");

    private static Set<String> _values = new HashSet();
    private final String mimeType;

    static {
        for (VideoCodecType videoCodecType : values()) {
            _values.add(videoCodecType.name());
        }
    }

    VideoCodecType(String str) {
        this.mimeType = str;
    }

    public static boolean contains(String str) {
        return _values.contains(str);
    }

    public String mimeType() {
        return this.mimeType;
    }
}
