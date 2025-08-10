package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.common.base.Supplier;
import java.util.List;

/* loaded from: classes.dex */
public interface ExoPlayer extends Player {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;

    @Deprecated
    public interface AudioComponent {
        @Deprecated
        void clearAuxEffectInfo();

        @Deprecated
        AudioAttributes getAudioAttributes();

        @Deprecated
        int getAudioSessionId();

        @Deprecated
        boolean getSkipSilenceEnabled();

        @Deprecated
        float getVolume();

        @Deprecated
        void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

        @Deprecated
        void setAudioSessionId(int i);

        @Deprecated
        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        @Deprecated
        void setSkipSilenceEnabled(boolean z);

        @Deprecated
        void setVolume(float f);
    }

    public interface AudioOffloadListener {
        void onExperimentalOffloadSchedulingEnabledChanged(boolean z);

        void onExperimentalSleepingForOffloadChanged(boolean z);
    }

    public static final class Builder {
        public Supplier<AnalyticsCollector> analyticsCollectorSupplier;
        public AudioAttributes audioAttributes;
        public Supplier<BandwidthMeter> bandwidthMeterSupplier;
        public boolean buildCalled;
        public Clock clock;
        public final Context context;
        public long detachSurfaceTimeoutMs;
        public long foregroundModeTimeoutMs;
        public boolean handleAudioBecomingNoisy;
        public boolean handleAudioFocus;
        public LivePlaybackSpeedControl livePlaybackSpeedControl;
        public Supplier<LoadControl> loadControlSupplier;
        public Looper looper;
        public Supplier<MediaSourceFactory> mediaSourceFactorySupplier;
        public boolean pauseAtEndOfMediaItems;

        @Nullable
        public PriorityTaskManager priorityTaskManager;
        public long releaseTimeoutMs;
        public Supplier<RenderersFactory> renderersFactorySupplier;
        public long seekBackIncrementMs;
        public long seekForwardIncrementMs;
        public SeekParameters seekParameters;
        public boolean skipSilenceEnabled;
        public Supplier<TrackSelector> trackSelectorSupplier;
        public boolean useLazyPreparation;
        public int videoChangeFrameRateStrategy;
        public int videoScalingMode;
        public int wakeMode;

        public Builder(final Context context) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: dc.hl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.a(context);
                }
            }, (Supplier<MediaSourceFactory>) new Supplier() { // from class: dc.nl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.b(context);
                }
            });
        }

        public static /* synthetic */ RenderersFactory a(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public static /* synthetic */ MediaSourceFactory b(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public static /* synthetic */ TrackSelector c(TrackSelector trackSelector) {
            return trackSelector;
        }

        public static /* synthetic */ LoadControl d(LoadControl loadControl) {
            return loadControl;
        }

        public static /* synthetic */ BandwidthMeter e(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        public static /* synthetic */ AnalyticsCollector f(AnalyticsCollector analyticsCollector) {
            return analyticsCollector;
        }

        public static /* synthetic */ TrackSelector g(Context context) {
            return new DefaultTrackSelector(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ AnalyticsCollector j() {
            return new AnalyticsCollector((Clock) Assertions.checkNotNull(this.clock));
        }

        public static /* synthetic */ RenderersFactory k(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ MediaSourceFactory l(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public static /* synthetic */ RenderersFactory m(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public static /* synthetic */ MediaSourceFactory n(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        public static /* synthetic */ RenderersFactory o(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ MediaSourceFactory p(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        public static /* synthetic */ RenderersFactory q(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ MediaSourceFactory r(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        public static /* synthetic */ AnalyticsCollector s(AnalyticsCollector analyticsCollector) {
            return analyticsCollector;
        }

        public static /* synthetic */ BandwidthMeter t(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        public static /* synthetic */ LoadControl u(LoadControl loadControl) {
            return loadControl;
        }

        public static /* synthetic */ MediaSourceFactory v(MediaSourceFactory mediaSourceFactory) {
            return mediaSourceFactory;
        }

        public static /* synthetic */ RenderersFactory w(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ TrackSelector x(TrackSelector trackSelector) {
            return trackSelector;
        }

        public ExoPlayer build() {
            return buildSimpleExoPlayer();
        }

        public SimpleExoPlayer buildSimpleExoPlayer() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }

        public Builder experimentalSetForegroundModeTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.foregroundModeTimeoutMs = j;
            return this;
        }

        public Builder setAnalyticsCollector(final AnalyticsCollector analyticsCollector) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollectorSupplier = new Supplier() { // from class: dc.gl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    AnalyticsCollector analyticsCollector2 = analyticsCollector;
                    ExoPlayer.Builder.s(analyticsCollector2);
                    return analyticsCollector2;
                }
            };
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = audioAttributes;
            this.handleAudioFocus = z;
            return this;
        }

        public Builder setBandwidthMeter(final BandwidthMeter bandwidthMeter) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeterSupplier = new Supplier() { // from class: dc.bl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    BandwidthMeter bandwidthMeter2 = bandwidthMeter;
                    ExoPlayer.Builder.t(bandwidthMeter2);
                    return bandwidthMeter2;
                }
            };
            return this;
        }

        @VisibleForTesting
        public Builder setClock(Clock clock) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock;
            return this;
        }

        public Builder setDetachSurfaceTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z;
            return this;
        }

        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = livePlaybackSpeedControl;
            return this;
        }

        public Builder setLoadControl(final LoadControl loadControl) {
            Assertions.checkState(!this.buildCalled);
            this.loadControlSupplier = new Supplier() { // from class: dc.dl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    LoadControl loadControl2 = loadControl;
                    ExoPlayer.Builder.u(loadControl2);
                    return loadControl2;
                }
            };
            return this;
        }

        public Builder setLooper(Looper looper) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper;
            return this;
        }

        public Builder setMediaSourceFactory(final MediaSourceFactory mediaSourceFactory) {
            Assertions.checkState(!this.buildCalled);
            this.mediaSourceFactorySupplier = new Supplier() { // from class: dc.al0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    MediaSourceFactory mediaSourceFactory2 = mediaSourceFactory;
                    ExoPlayer.Builder.v(mediaSourceFactory2);
                    return mediaSourceFactory2;
                }
            };
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z;
            return this;
        }

        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager;
            return this;
        }

        public Builder setReleaseTimeoutMs(long j) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j;
            return this;
        }

        public Builder setRenderersFactory(final RenderersFactory renderersFactory) {
            Assertions.checkState(!this.buildCalled);
            this.renderersFactorySupplier = new Supplier() { // from class: dc.cl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    RenderersFactory renderersFactory2 = renderersFactory;
                    ExoPlayer.Builder.w(renderersFactory2);
                    return renderersFactory2;
                }
            };
            return this;
        }

        public Builder setSeekBackIncrementMs(@IntRange(from = 1) long j) {
            Assertions.checkArgument(j > 0);
            Assertions.checkState(true ^ this.buildCalled);
            this.seekBackIncrementMs = j;
            return this;
        }

        public Builder setSeekForwardIncrementMs(@IntRange(from = 1) long j) {
            Assertions.checkArgument(j > 0);
            Assertions.checkState(true ^ this.buildCalled);
            this.seekForwardIncrementMs = j;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = seekParameters;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z;
            return this;
        }

        public Builder setTrackSelector(final TrackSelector trackSelector) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelectorSupplier = new Supplier() { // from class: dc.jl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    TrackSelector trackSelector2 = trackSelector;
                    ExoPlayer.Builder.x(trackSelector2);
                    return trackSelector2;
                }
            };
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }

        public Builder setVideoChangeFrameRateStrategy(int i) {
            Assertions.checkState(!this.buildCalled);
            this.videoChangeFrameRateStrategy = i;
            return this;
        }

        public Builder setVideoScalingMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i;
            return this;
        }

        public Builder setWakeMode(int i) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i;
            return this;
        }

        public Builder(final Context context, final RenderersFactory renderersFactory) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: dc.ul0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    RenderersFactory renderersFactory2 = renderersFactory;
                    ExoPlayer.Builder.k(renderersFactory2);
                    return renderersFactory2;
                }
            }, (Supplier<MediaSourceFactory>) new Supplier() { // from class: dc.ql0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.l(context);
                }
            });
        }

        public Builder(final Context context, final MediaSourceFactory mediaSourceFactory) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: dc.ml0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.m(context);
                }
            }, (Supplier<MediaSourceFactory>) new Supplier() { // from class: dc.vl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    MediaSourceFactory mediaSourceFactory2 = mediaSourceFactory;
                    ExoPlayer.Builder.n(mediaSourceFactory2);
                    return mediaSourceFactory2;
                }
            });
        }

        public Builder(Context context, final RenderersFactory renderersFactory, final MediaSourceFactory mediaSourceFactory) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: dc.zk0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    RenderersFactory renderersFactory2 = renderersFactory;
                    ExoPlayer.Builder.o(renderersFactory2);
                    return renderersFactory2;
                }
            }, (Supplier<MediaSourceFactory>) new Supplier() { // from class: dc.tl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    MediaSourceFactory mediaSourceFactory2 = mediaSourceFactory;
                    ExoPlayer.Builder.p(mediaSourceFactory2);
                    return mediaSourceFactory2;
                }
            });
        }

        public Builder(Context context, final RenderersFactory renderersFactory, final MediaSourceFactory mediaSourceFactory, final TrackSelector trackSelector, final LoadControl loadControl, final BandwidthMeter bandwidthMeter, final AnalyticsCollector analyticsCollector) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: dc.ll0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    RenderersFactory renderersFactory2 = renderersFactory;
                    ExoPlayer.Builder.q(renderersFactory2);
                    return renderersFactory2;
                }
            }, (Supplier<MediaSourceFactory>) new Supplier() { // from class: dc.il0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    MediaSourceFactory mediaSourceFactory2 = mediaSourceFactory;
                    ExoPlayer.Builder.r(mediaSourceFactory2);
                    return mediaSourceFactory2;
                }
            }, (Supplier<TrackSelector>) new Supplier() { // from class: dc.ol0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    TrackSelector trackSelector2 = trackSelector;
                    ExoPlayer.Builder.c(trackSelector2);
                    return trackSelector2;
                }
            }, (Supplier<LoadControl>) new Supplier() { // from class: dc.fl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    LoadControl loadControl2 = loadControl;
                    ExoPlayer.Builder.d(loadControl2);
                    return loadControl2;
                }
            }, (Supplier<BandwidthMeter>) new Supplier() { // from class: dc.rl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    BandwidthMeter bandwidthMeter2 = bandwidthMeter;
                    ExoPlayer.Builder.e(bandwidthMeter2);
                    return bandwidthMeter2;
                }
            }, (Supplier<AnalyticsCollector>) new Supplier() { // from class: dc.pl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    AnalyticsCollector analyticsCollector2 = analyticsCollector;
                    ExoPlayer.Builder.f(analyticsCollector2);
                    return analyticsCollector2;
                }
            });
        }

        private Builder(final Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSourceFactory> supplier2) {
            this(context, supplier, supplier2, (Supplier<TrackSelector>) new Supplier() { // from class: dc.kl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.Builder.g(context);
                }
            }, new Supplier() { // from class: dc.uk0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return new DefaultLoadControl();
                }
            }, (Supplier<BandwidthMeter>) new Supplier() { // from class: dc.el0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return DefaultBandwidthMeter.getSingletonInstance(context);
                }
            }, (Supplier<AnalyticsCollector>) null);
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSourceFactory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, @Nullable Supplier<AnalyticsCollector> supplier6) {
            this.context = context;
            this.renderersFactorySupplier = supplier;
            this.mediaSourceFactorySupplier = supplier2;
            this.trackSelectorSupplier = supplier3;
            this.loadControlSupplier = supplier4;
            this.bandwidthMeterSupplier = supplier5;
            this.analyticsCollectorSupplier = supplier6 == null ? new Supplier() { // from class: dc.sl0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return this.a.j();
                }
            } : supplier6;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.videoChangeFrameRateStrategy = 0;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.seekBackIncrementMs = 5000L;
            this.seekForwardIncrementMs = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500L;
            this.detachSurfaceTimeoutMs = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }
    }

    @Deprecated
    public interface DeviceComponent {
        @Deprecated
        void decreaseDeviceVolume();

        @Deprecated
        DeviceInfo getDeviceInfo();

        @Deprecated
        int getDeviceVolume();

        @Deprecated
        void increaseDeviceVolume();

        @Deprecated
        boolean isDeviceMuted();

        @Deprecated
        void setDeviceMuted(boolean z);

        @Deprecated
        void setDeviceVolume(int i);
    }

    @Deprecated
    public interface TextComponent {
        @Deprecated
        List<Cue> getCurrentCues();
    }

    @Deprecated
    public interface VideoComponent {
        @Deprecated
        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void clearVideoSurface();

        @Deprecated
        void clearVideoSurface(@Nullable Surface surface);

        @Deprecated
        void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void clearVideoTextureView(@Nullable TextureView textureView);

        @Deprecated
        int getVideoChangeFrameRateStrategy();

        @Deprecated
        int getVideoScalingMode();

        @Deprecated
        VideoSize getVideoSize();

        @Deprecated
        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        @Deprecated
        void setVideoChangeFrameRateStrategy(int i);

        @Deprecated
        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void setVideoScalingMode(int i);

        @Deprecated
        void setVideoSurface(@Nullable Surface surface);

        @Deprecated
        void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void setVideoTextureView(@Nullable TextureView textureView);
    }

    void addAnalyticsListener(AnalyticsListener analyticsListener);

    void addAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void addListener(Player.EventListener eventListener);

    void addMediaSource(int i, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    void clearAuxEffectInfo();

    void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

    void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    PlayerMessage createMessage(PlayerMessage.Target target);

    boolean experimentalIsSleepingForOffload();

    void experimentalSetOffloadSchedulingEnabled(boolean z);

    AnalyticsCollector getAnalyticsCollector();

    @Nullable
    @Deprecated
    AudioComponent getAudioComponent();

    @Nullable
    DecoderCounters getAudioDecoderCounters();

    @Nullable
    Format getAudioFormat();

    int getAudioSessionId();

    Clock getClock();

    @Nullable
    @Deprecated
    DeviceComponent getDeviceComponent();

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    @Override // com.google.android.exoplayer2.Player
    ExoPlaybackException getPlayerError();

    @Override // com.google.android.exoplayer2.Player
    /* bridge */ /* synthetic */ PlaybackException getPlayerError();

    int getRendererCount();

    int getRendererType(int i);

    SeekParameters getSeekParameters();

    boolean getSkipSilenceEnabled();

    @Nullable
    @Deprecated
    TextComponent getTextComponent();

    @Nullable
    TrackSelector getTrackSelector();

    int getVideoChangeFrameRateStrategy();

    @Nullable
    @Deprecated
    VideoComponent getVideoComponent();

    @Nullable
    DecoderCounters getVideoDecoderCounters();

    @Nullable
    Format getVideoFormat();

    int getVideoScalingMode();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void removeAnalyticsListener(AnalyticsListener analyticsListener);

    void removeAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void removeListener(Player.EventListener eventListener);

    @Deprecated
    void retry();

    void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

    void setAudioSessionId(int i);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setCameraMotionListener(CameraMotionListener cameraMotionListener);

    void setForegroundMode(boolean z);

    void setHandleAudioBecomingNoisy(boolean z);

    @Deprecated
    void setHandleWakeLock(boolean z);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j);

    void setMediaSource(MediaSource mediaSource, boolean z);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i, long j);

    void setMediaSources(List<MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager);

    void setSeekParameters(@Nullable SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    void setSkipSilenceEnabled(boolean z);

    @Deprecated
    void setThrowsWhenUsingWrongThread(boolean z);

    void setVideoChangeFrameRateStrategy(int i);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void setVideoScalingMode(int i);

    void setWakeMode(int i);
}
