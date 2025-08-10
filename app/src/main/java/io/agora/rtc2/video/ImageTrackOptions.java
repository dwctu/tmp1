package io.agora.rtc2.video;

import io.agora.rtc2.video.VideoEncoderConfiguration;

/* loaded from: classes4.dex */
public class ImageTrackOptions {
    private int fps;
    private String imageUrl;
    private VideoEncoderConfiguration.MIRROR_MODE_TYPE mirrorMode;

    public ImageTrackOptions(String str, int i) {
        this.imageUrl = str;
        this.fps = i;
        this.mirrorMode = VideoEncoderConfiguration.MIRROR_MODE_TYPE.MIRROR_MODE_DISABLED;
    }

    public ImageTrackOptions(String str, int i, VideoEncoderConfiguration.MIRROR_MODE_TYPE mirror_mode_type) {
        this.imageUrl = str;
        this.fps = i;
        this.mirrorMode = mirror_mode_type;
    }

    public int getFps() {
        return this.fps;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMirrorMode() {
        return this.mirrorMode.getValue();
    }
}
