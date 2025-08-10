package dc;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

/* compiled from: Player.java */
/* loaded from: classes.dex */
public final /* synthetic */ class xn0 {
    public static void $default$onAudioAttributesChanged(Player.Listener listener, AudioAttributes audioAttributes) {
    }

    public static void $default$onAudioSessionIdChanged(Player.Listener listener, int i) {
    }

    public static void $default$onAvailableCommandsChanged(Player.Listener listener, Player.Commands commands) {
    }

    public static void $default$onCues(Player.Listener listener, List list) {
    }

    public static void $default$onDeviceInfoChanged(Player.Listener listener, DeviceInfo deviceInfo) {
    }

    public static void $default$onDeviceVolumeChanged(Player.Listener listener, int i, boolean z) {
    }

    public static void $default$onEvents(Player.Listener listener, Player player, Player.Events events) {
    }

    public static void $default$onIsLoadingChanged(Player.Listener listener, boolean z) {
    }

    public static void $default$onIsPlayingChanged(Player.Listener listener, boolean z) {
    }

    public static void $default$onMediaItemTransition(@Nullable Player.Listener listener, MediaItem mediaItem, int i) {
    }

    public static void $default$onMediaMetadataChanged(Player.Listener listener, MediaMetadata mediaMetadata) {
    }

    public static void $default$onMetadata(Player.Listener listener, Metadata metadata) {
    }

    public static void $default$onPlayWhenReadyChanged(Player.Listener listener, boolean z, int i) {
    }

    public static void $default$onPlaybackParametersChanged(Player.Listener listener, PlaybackParameters playbackParameters) {
    }

    public static void $default$onPlaybackStateChanged(Player.Listener listener, int i) {
    }

    public static void $default$onPlaybackSuppressionReasonChanged(Player.Listener listener, int i) {
    }

    public static void $default$onPlayerError(Player.Listener listener, PlaybackException playbackException) {
    }

    public static void $default$onPlayerErrorChanged(@Nullable Player.Listener listener, PlaybackException playbackException) {
    }

    public static void $default$onPlaylistMetadataChanged(Player.Listener listener, MediaMetadata mediaMetadata) {
    }

    public static void $default$onPositionDiscontinuity(Player.Listener listener, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
    }

    public static void $default$onRenderedFirstFrame(Player.Listener listener) {
    }

    public static void $default$onRepeatModeChanged(Player.Listener listener, int i) {
    }

    public static void $default$onSeekBackIncrementChanged(Player.Listener listener, long j) {
    }

    public static void $default$onSeekForwardIncrementChanged(Player.Listener listener, long j) {
    }

    public static void $default$onShuffleModeEnabledChanged(Player.Listener listener, boolean z) {
    }

    public static void $default$onSkipSilenceEnabledChanged(Player.Listener listener, boolean z) {
    }

    public static void $default$onSurfaceSizeChanged(Player.Listener listener, int i, int i2) {
    }

    public static void $default$onTimelineChanged(Player.Listener listener, Timeline timeline, int i) {
    }

    public static void $default$onTracksInfoChanged(Player.Listener listener, TracksInfo tracksInfo) {
    }

    public static void $default$onVideoSizeChanged(Player.Listener listener, VideoSize videoSize) {
    }

    public static void $default$onVolumeChanged(Player.Listener listener, float f) {
    }
}
