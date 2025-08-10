package dc;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;

/* compiled from: VideoRendererEventListener.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class gz0 {
    public static void $default$onDroppedFrames(VideoRendererEventListener videoRendererEventListener, int i, long j) {
    }

    public static void $default$onRenderedFirstFrame(VideoRendererEventListener videoRendererEventListener, Object obj, long j) {
    }

    public static void $default$onVideoCodecError(VideoRendererEventListener videoRendererEventListener, Exception exc) {
    }

    public static void $default$onVideoDecoderInitialized(VideoRendererEventListener videoRendererEventListener, String str, long j, long j2) {
    }

    public static void $default$onVideoDecoderReleased(VideoRendererEventListener videoRendererEventListener, String str) {
    }

    public static void $default$onVideoDisabled(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
    }

    public static void $default$onVideoEnabled(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
    }

    public static void $default$onVideoFrameProcessingOffset(VideoRendererEventListener videoRendererEventListener, long j, int i) {
    }

    @Deprecated
    public static void $default$onVideoInputFormatChanged(VideoRendererEventListener videoRendererEventListener, Format format) {
    }

    public static void $default$onVideoInputFormatChanged(VideoRendererEventListener videoRendererEventListener, @Nullable Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    public static void $default$onVideoSizeChanged(VideoRendererEventListener videoRendererEventListener, VideoSize videoSize) {
    }
}
