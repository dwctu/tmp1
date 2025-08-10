package dc;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;

/* compiled from: Player.java */
/* loaded from: classes.dex */
public final /* synthetic */ class wn0 {
    public static void $default$onAvailableCommandsChanged(Player.EventListener eventListener, Player.Commands commands) {
    }

    public static void $default$onEvents(Player.EventListener eventListener, Player player, Player.Events events) {
    }

    public static void $default$onIsLoadingChanged(Player.EventListener eventListener, boolean z) {
    }

    public static void $default$onIsPlayingChanged(Player.EventListener eventListener, boolean z) {
    }

    @Deprecated
    public static void $default$onLoadingChanged(Player.EventListener eventListener, boolean z) {
    }

    public static void $default$onMaxSeekToPreviousPositionChanged(Player.EventListener eventListener, long j) {
    }

    public static void $default$onMediaItemTransition(@Nullable Player.EventListener eventListener, MediaItem mediaItem, int i) {
    }

    public static void $default$onMediaMetadataChanged(Player.EventListener eventListener, MediaMetadata mediaMetadata) {
    }

    public static void $default$onPlayWhenReadyChanged(Player.EventListener eventListener, boolean z, int i) {
    }

    public static void $default$onPlaybackParametersChanged(Player.EventListener eventListener, PlaybackParameters playbackParameters) {
    }

    public static void $default$onPlaybackStateChanged(Player.EventListener eventListener, int i) {
    }

    public static void $default$onPlaybackSuppressionReasonChanged(Player.EventListener eventListener, int i) {
    }

    public static void $default$onPlayerError(Player.EventListener eventListener, PlaybackException playbackException) {
    }

    public static void $default$onPlayerErrorChanged(@Nullable Player.EventListener eventListener, PlaybackException playbackException) {
    }

    @Deprecated
    public static void $default$onPlayerStateChanged(Player.EventListener eventListener, boolean z, int i) {
    }

    public static void $default$onPlaylistMetadataChanged(Player.EventListener eventListener, MediaMetadata mediaMetadata) {
    }

    @Deprecated
    public static void $default$onPositionDiscontinuity(Player.EventListener eventListener, int i) {
    }

    public static void $default$onPositionDiscontinuity(Player.EventListener eventListener, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
    }

    public static void $default$onRepeatModeChanged(Player.EventListener eventListener, int i) {
    }

    public static void $default$onSeekBackIncrementChanged(Player.EventListener eventListener, long j) {
    }

    public static void $default$onSeekForwardIncrementChanged(Player.EventListener eventListener, long j) {
    }

    @Deprecated
    public static void $default$onSeekProcessed(Player.EventListener eventListener) {
    }

    public static void $default$onShuffleModeEnabledChanged(Player.EventListener eventListener, boolean z) {
    }

    public static void $default$onTimelineChanged(Player.EventListener eventListener, Timeline timeline, int i) {
    }

    public static void $default$onTrackSelectionParametersChanged(Player.EventListener eventListener, TrackSelectionParameters trackSelectionParameters) {
    }

    @Deprecated
    public static void $default$onTracksChanged(Player.EventListener eventListener, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public static void $default$onTracksInfoChanged(Player.EventListener eventListener, TracksInfo tracksInfo) {
    }
}
