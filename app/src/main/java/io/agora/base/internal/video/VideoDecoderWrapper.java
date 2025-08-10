package io.agora.base.internal.video;

import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.video.VideoDecoder;

/* loaded from: classes4.dex */
public class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(final long j) {
        return new VideoDecoder.Callback() { // from class: io.agora.base.internal.video.VideoDecoderWrapper.1
            @Override // io.agora.base.internal.video.VideoDecoder.Callback
            public void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2, int i, int i2, CodecSpecificInfo codecSpecificInfo) {
                VideoDecoderWrapper.nativeOnDecodedFrame(j, videoFrame, num, num2, i, i2, codecSpecificInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long j, VideoFrame videoFrame, Integer num, Integer num2, int i, int i2, CodecSpecificInfo codecSpecificInfo);
}
