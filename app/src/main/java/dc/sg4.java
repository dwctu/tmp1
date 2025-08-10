package dc;

import androidx.annotation.Nullable;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;

/* compiled from: VideoProcessor.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class sg4 {
    public static void $default$onFrameCaptured(VideoProcessor _this, VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        VideoFrame videoFrameA = a(videoFrame, frameAdaptationParameters);
        if (videoFrameA != null) {
            _this.onFrameCaptured(videoFrameA);
            videoFrameA.release();
        }
    }

    @Nullable
    public static VideoFrame a(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        if (frameAdaptationParameters.drop) {
            return null;
        }
        return new VideoFrame(videoFrame.getBuffer().cropAndScale(frameAdaptationParameters.cropX, frameAdaptationParameters.cropY, frameAdaptationParameters.cropWidth, frameAdaptationParameters.cropHeight, frameAdaptationParameters.scaleWidth, frameAdaptationParameters.scaleHeight), videoFrame.getRotation(), frameAdaptationParameters.timestampNs);
    }
}
