package dc;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

/* compiled from: AudioRendererEventListener.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class br0 {
    public static void $default$onAudioCodecError(AudioRendererEventListener audioRendererEventListener, Exception exc) {
    }

    public static void $default$onAudioDecoderInitialized(AudioRendererEventListener audioRendererEventListener, String str, long j, long j2) {
    }

    public static void $default$onAudioDecoderReleased(AudioRendererEventListener audioRendererEventListener, String str) {
    }

    public static void $default$onAudioDisabled(AudioRendererEventListener audioRendererEventListener, DecoderCounters decoderCounters) {
    }

    public static void $default$onAudioEnabled(AudioRendererEventListener audioRendererEventListener, DecoderCounters decoderCounters) {
    }

    @Deprecated
    public static void $default$onAudioInputFormatChanged(AudioRendererEventListener audioRendererEventListener, Format format) {
    }

    public static void $default$onAudioInputFormatChanged(AudioRendererEventListener audioRendererEventListener, @Nullable Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    public static void $default$onAudioPositionAdvancing(AudioRendererEventListener audioRendererEventListener, long j) {
    }

    public static void $default$onAudioSinkError(AudioRendererEventListener audioRendererEventListener, Exception exc) {
    }

    public static void $default$onAudioUnderrun(AudioRendererEventListener audioRendererEventListener, int i, long j, long j2) {
    }

    public static void $default$onSkipSilenceEnabledChanged(AudioRendererEventListener audioRendererEventListener, boolean z) {
    }
}
