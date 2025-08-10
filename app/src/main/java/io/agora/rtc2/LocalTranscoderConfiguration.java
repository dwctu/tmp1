package io.agora.rtc2;

import io.agora.rtc2.Constants;
import io.agora.rtc2.video.VideoEncoderConfiguration;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class LocalTranscoderConfiguration {
    public ArrayList<TranscodingVideoStream> transcodingVideoStreams = new ArrayList<>();
    public boolean syncWithPrimaryCamera = true;
    public VideoEncoderConfiguration videoOutputConfiguration = new VideoEncoderConfiguration();

    public static class TranscodingVideoStream {
        public int mediaPlayerId;
        public Constants.VideoSourceType sourceType = Constants.VideoSourceType.VIDEO_SOURCE_CAMERA_PRIMARY;
        public int remoteUserUid = 0;
        public String imageUrl = null;
        public int x = 0;
        public int y = 0;
        public int width = 0;
        public int height = 0;
        public int zOrder = 0;
        public double alpha = 1.0d;
        public boolean mirror = false;
    }
}
