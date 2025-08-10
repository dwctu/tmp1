package com.wear.ui.discover.chatgpt;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.data.ChatGPTStoryBean;
import com.wear.bean.data.ChatGPTStoryData;
import com.wear.databinding.ActivityChatGptStoryBookBinding;
import com.wear.ui.discover.chatgpt.ChatGPTStoryBookActivity;
import com.wear.util.WearUtils;
import dc.be3;
import dc.n04;
import dc.pc1;
import dc.ro2;
import dc.rq1;
import dc.sy3;
import dc.uy3;
import dc.vl2;
import dc.wn0;
import dc.wz3;
import dc.xn0;
import dc.ye3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTStoryBookActivity.kt */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0018\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002OPB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u0012\u0010E\u001a\u00020C2\b\u0010F\u001a\u0004\u0018\u00010GH\u0015J\b\u0010H\u001a\u00020CH\u0014J\b\u0010I\u001a\u00020CH\u0014J\u0019\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020CH\u0016J\u0006\u0010N\u001a\u00020CR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010/\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u0012\u00102\u001a\u000603R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, d2 = {"Lcom/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityChatGptStoryBookBinding;", "btWork", "Lcom/lovense/btservice/work/BtWork;", "chatGPTStory", "Lcom/wear/bean/data/ChatGPTStoryData;", "chatGPTStoryBean", "Lcom/wear/bean/data/ChatGPTStoryBean;", "commandMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "getExoPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayer$delegate", "Lkotlin/Lazy;", "handler", "com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$handler$1", "Lcom/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$handler$1;", "isEscalation", "", "()Ljava/lang/Boolean;", "setEscalation", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isExpand", "setExpand", "mediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "getMediaItem", "()Lcom/google/android/exoplayer2/MediaItem;", "setMediaItem", "(Lcom/google/android/exoplayer2/MediaItem;)V", "playbackRecordEnd", "", "getPlaybackRecordEnd", "()Ljava/lang/Long;", "setPlaybackRecordEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "playbackRecordStart", "getPlaybackRecordStart", "setPlaybackRecordStart", "playerListener", "Lcom/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$PlayerEventListener;", "timeIndex", "getTimeIndex", "()I", "setTimeIndex", "(I)V", "timeSecond", "getTimeSecond", "setTimeSecond", "timerPlay", "Ljava/util/Timer;", "timerTask", "Ljava/util/TimerTask;", "uAmpAudioAttributes", "Lcom/google/android/exoplayer2/audio/AudioAttributes;", "addLogExposureS0009", "", "type", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "parseCommands", "mediaId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settingBarColor", "startTimerPlay", "Companion", "PlayerEventListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTStoryBookActivity extends BaseActivity<vl2> {
    public ActivityChatGptStoryBookBinding a;

    @Nullable
    public ChatGPTStoryBean b;

    @Nullable
    public ChatGPTStoryData e;

    @Nullable
    public TimerTask f;

    @Nullable
    public Timer g;
    public int h;
    public int i;

    @NotNull
    public final AudioAttributes n;

    @NotNull
    public final Lazy o;

    @Nullable
    public MediaItem p;

    @NotNull
    public final c q;

    @NotNull
    public final a c = new a();

    @NotNull
    public final ConcurrentHashMap<Integer, Map<String, Integer>> d = new ConcurrentHashMap<>();

    @Nullable
    public Long j = 0L;

    @Nullable
    public Long k = 0L;

    @Nullable
    public Boolean l = Boolean.TRUE;

    @NotNull
    public final pc1 m = pc1.a;

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$PlayerEventListener;", "Lcom/google/android/exoplayer2/Player$Listener;", "(Lcom/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity;)V", "onIsPlayingChanged", "", "isPlaying", "", "onPlayWhenReadyChanged", "playWhenReady", "reason", "", "onPlaybackStateChanged", "playbackState", "onPlayerError", "error", "Lcom/google/android/exoplayer2/PlaybackException;", "onVideoSizeChanged", "videoSize", "Lcom/google/android/exoplayer2/video/VideoSize;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a implements Player.Listener {
        public a() {
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            xn0.$default$onAudioAttributesChanged(this, audioAttributes);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onAudioSessionIdChanged(int i) {
            xn0.$default$onAudioSessionIdChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            xn0.$default$onAvailableCommandsChanged(this, commands);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onCues(List list) {
            xn0.$default$onCues(this, list);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            xn0.$default$onDeviceInfoChanged(this, deviceInfo);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            xn0.$default$onDeviceVolumeChanged(this, i, z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            xn0.$default$onEvents(this, player, events);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            xn0.$default$onIsLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onIsPlayingChanged(boolean isPlaying) {
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = null;
            if (isPlaying) {
                ChatGPTStoryBookActivity.this.q.sendEmptyMessage(255);
                ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding2 = ChatGPTStoryBookActivity.this.a;
                if (activityChatGptStoryBookBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityChatGptStoryBookBinding = activityChatGptStoryBookBinding2;
                }
                activityChatGptStoryBookBinding.c.setImageDrawable(ChatGPTStoryBookActivity.this.getResources().getDrawable(R.drawable.story_book_minibar_pause));
                ChatGPTStoryBookActivity chatGPTStoryBookActivity = ChatGPTStoryBookActivity.this;
                chatGPTStoryBookActivity.S4(Long.valueOf(chatGPTStoryBookActivity.D4().getCurrentPosition()));
                return;
            }
            ChatGPTStoryBookActivity.this.m.u0();
            ChatGPTStoryBookActivity.this.q.removeMessages(255);
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding3 = ChatGPTStoryBookActivity.this.a;
            if (activityChatGptStoryBookBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityChatGptStoryBookBinding = activityChatGptStoryBookBinding3;
            }
            activityChatGptStoryBookBinding.c.setImageDrawable(ChatGPTStoryBookActivity.this.getResources().getDrawable(R.drawable.story_book_minibar_play));
            long currentPosition = ChatGPTStoryBookActivity.this.D4().getCurrentPosition();
            Long k = ChatGPTStoryBookActivity.this.getK();
            if (currentPosition > (k != null ? k.longValue() + 5000 : 0L)) {
                ChatGPTStoryBookActivity.this.C4(4);
                ChatGPTStoryBookActivity.this.Q4(Boolean.TRUE);
            }
            ChatGPTStoryBookActivity chatGPTStoryBookActivity2 = ChatGPTStoryBookActivity.this;
            chatGPTStoryBookActivity2.R4(Long.valueOf(chatGPTStoryBookActivity2.D4().getCurrentPosition()));
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            wn0.$default$onLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            wn0.$default$onMaxSeekToPreviousPositionChanged(this, j);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            xn0.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            xn0.$default$onMediaMetadataChanged(this, mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
            xn0.$default$onMetadata(this, metadata);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            xn0.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int playbackState) {
            if ((playbackState == 2 || playbackState == 3) && ChatGPTStoryBookActivity.this.D4().getPlayWhenReady()) {
                ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = ChatGPTStoryBookActivity.this.a;
                ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding2 = null;
                if (activityChatGptStoryBookBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatGptStoryBookBinding = null;
                }
                activityChatGptStoryBookBinding.g.setMax((int) ChatGPTStoryBookActivity.this.D4().getDuration());
                ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding3 = ChatGPTStoryBookActivity.this.a;
                if (activityChatGptStoryBookBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityChatGptStoryBookBinding2 = activityChatGptStoryBookBinding3;
                }
                activityChatGptStoryBookBinding2.i.setText(be3.l(ChatGPTStoryBookActivity.this.D4().getDuration()));
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            xn0.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(@NotNull PlaybackException error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            xn0.$default$onPlayerErrorChanged(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            wn0.$default$onPlayerStateChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            xn0.$default$onPlaylistMetadataChanged(this, mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            wn0.$default$onPositionDiscontinuity(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            xn0.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onRenderedFirstFrame() {
            xn0.$default$onRenderedFirstFrame(this);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            xn0.$default$onRepeatModeChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            xn0.$default$onSeekBackIncrementChanged(this, j);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            xn0.$default$onSeekForwardIncrementChanged(this, j);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            wn0.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            xn0.$default$onShuffleModeEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            xn0.$default$onSkipSilenceEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            xn0.$default$onSurfaceSizeChanged(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            xn0.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            wn0.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            wn0.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksInfoChanged(TracksInfo tracksInfo) {
            xn0.$default$onTracksInfoChanged(this, tracksInfo);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onVideoSizeChanged(@NotNull VideoSize videoSize) {
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onVolumeChanged(float f) {
            xn0.$default$onVolumeChanged(this, f);
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/exoplayer2/ExoPlayer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ExoPlayer> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExoPlayer invoke() {
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(ChatGPTStoryBookActivity.this.getBaseContext()).build();
            ChatGPTStoryBookActivity chatGPTStoryBookActivity = ChatGPTStoryBookActivity.this;
            exoPlayerBuild.setPlayWhenReady(true);
            exoPlayerBuild.setAudioAttributes(chatGPTStoryBookActivity.n, true);
            exoPlayerBuild.setHandleAudioBecomingNoisy(true);
            exoPlayerBuild.setWakeMode(2);
            exoPlayerBuild.addListener((Player.Listener) chatGPTStoryBookActivity.c);
            Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "Builder(baseContext).bui…playerListener)\n        }");
            return exoPlayerBuild;
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 255) {
                long currentPosition = ChatGPTStoryBookActivity.this.D4().getCurrentPosition();
                long j = currentPosition % 100;
                if (j != 0) {
                    currentPosition += 100 - j;
                }
                int i = (int) currentPosition;
                if (ChatGPTStoryBookActivity.this.d.containsKey(Integer.valueOf(i))) {
                    Map mapEmptyMap = (Map) ChatGPTStoryBookActivity.this.d.get(Integer.valueOf(i));
                    if (mapEmptyMap == null) {
                        mapEmptyMap = MapsKt__MapsKt.emptyMap();
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry entry : mapEmptyMap.entrySet()) {
                        if (mapEmptyMap.size() == 1) {
                            rq1.d.j(((Number) entry.getValue()).intValue());
                        } else if (mapEmptyMap.size() > 1) {
                            arrayList.add(String.valueOf(((Number) entry.getValue()).intValue()));
                            arrayList2.add(entry.getKey());
                        }
                    }
                    if (arrayList.size() > 1 || arrayList2.size() > 1) {
                        rq1.d.k(arrayList2, arrayList);
                    }
                }
                sendEmptyMessageDelayed(255, 100L);
            }
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$onCreate$6", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements AppBarLayout.OnOffsetChangedListener {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(@Nullable AppBarLayout appBarLayout, int verticalOffset) {
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = null;
            if (verticalOffset < -500) {
                ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding2 = ChatGPTStoryBookActivity.this.a;
                if (activityChatGptStoryBookBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatGptStoryBookBinding2 = null;
                }
                activityChatGptStoryBookBinding2.e.setVisibility(0);
                ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding3 = ChatGPTStoryBookActivity.this.a;
                if (activityChatGptStoryBookBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityChatGptStoryBookBinding = activityChatGptStoryBookBinding3;
                }
                activityChatGptStoryBookBinding.b.setBackVisibility(8);
                return;
            }
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding4 = ChatGPTStoryBookActivity.this.a;
            if (activityChatGptStoryBookBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityChatGptStoryBookBinding4 = null;
            }
            activityChatGptStoryBookBinding4.e.setVisibility(8);
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding5 = ChatGPTStoryBookActivity.this.a;
            if (activityChatGptStoryBookBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityChatGptStoryBookBinding = activityChatGptStoryBookBinding5;
            }
            activityChatGptStoryBookBinding.b.setBackVisibility(0);
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$onCreate$7", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements SeekBar.OnSeekBarChangeListener {
        public e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                ChatGPTStoryBookActivity.this.D4().seekTo(progress);
            }
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = ChatGPTStoryBookActivity.this.a;
            if (activityChatGptStoryBookBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityChatGptStoryBookBinding = null;
            }
            activityChatGptStoryBookBinding.j.setText(be3.l(ChatGPTStoryBookActivity.this.D4().getCurrentPosition()));
            long currentPosition = ChatGPTStoryBookActivity.this.D4().getCurrentPosition();
            Long j = ChatGPTStoryBookActivity.this.getJ();
            Intrinsics.checkNotNull(j);
            if (currentPosition - j.longValue() > 5000 && Intrinsics.areEqual(ChatGPTStoryBookActivity.this.getL(), Boolean.TRUE) && ChatGPTStoryBookActivity.this.D4().isPlaying()) {
                ChatGPTStoryBookActivity.this.C4(3);
                ChatGPTStoryBookActivity.this.Q4(Boolean.FALSE);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.ChatGPTStoryBookActivity$onCreate$8", f = "ChatGPTStoryBookActivity.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ChatGPTStoryBookActivity.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String id;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ChatGPTStoryBean chatGPTStoryBean = ChatGPTStoryBookActivity.this.b;
                if (chatGPTStoryBean != null && (id = chatGPTStoryBean.getId()) != null) {
                    ChatGPTStoryBookActivity chatGPTStoryBookActivity = ChatGPTStoryBookActivity.this;
                    this.label = 1;
                    if (chatGPTStoryBookActivity.P4(id, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.ChatGPTStoryBookActivity$parseCommands$2", f = "ChatGPTStoryBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $mediaId;
        public int label;

        /* compiled from: ChatGPTStoryBookActivity.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$parseCommands$2$mapType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<Map<String, ? extends Integer>> {
        }

        /* compiled from: ChatGPTStoryBookActivity.kt */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$parseCommands$2$type$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class b extends TypeToken<ArrayList<Object>> {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$mediaId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ChatGPTStoryBookActivity.this.new g(this.$mediaId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File file = new File(ChatGPTStoryBookActivity.this.getExternalFilesDir("wear/audioBook"), String.valueOf(this.$mediaId));
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                Type type = new b().getType();
                Type type2 = new a().getType();
                try {
                    Gson gson = new Gson();
                    ArrayList array = (ArrayList) gson.fromJson(bufferedReader, type);
                    Intrinsics.checkNotNullExpressionValue(array, "array");
                    ChatGPTStoryBookActivity chatGPTStoryBookActivity = ChatGPTStoryBookActivity.this;
                    Iterator it = array.iterator();
                    while (it.hasNext()) {
                        Map map = (Map) gson.fromJson(gson.toJson(it.next()), type2);
                        Object obj2 = map.get("t");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) obj2).intValue();
                        Intrinsics.checkNotNullExpressionValue(map, "map");
                        for (Map.Entry entry : map.entrySet()) {
                            if (iIntValue >= 0 && !Intrinsics.areEqual(entry.getKey(), "t")) {
                                chatGPTStoryBookActivity.d.put(Boxing.boxInt(iIntValue), MapsKt__MapsJVMKt.mapOf(TuplesKt.to(entry.getKey(), entry.getValue())));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTStoryBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/wear/ui/discover/chatgpt/ChatGPTStoryBookActivity$startTimerPlay$1", "Ljava/util/TimerTask;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class h extends TimerTask {
        public h() {
        }

        public static final void b(ChatGPTStoryBookActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = this$0.a;
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding2 = null;
            if (activityChatGptStoryBookBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityChatGptStoryBookBinding = null;
            }
            activityChatGptStoryBookBinding.j.setText(be3.l(this$0.D4().getCurrentPosition()));
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding3 = this$0.a;
            if (activityChatGptStoryBookBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityChatGptStoryBookBinding2 = activityChatGptStoryBookBinding3;
            }
            activityChatGptStoryBookBinding2.g.setProgress((int) this$0.D4().getCurrentPosition());
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        @RequiresApi(24)
        public void run() {
            ChatGPTStoryBookActivity chatGPTStoryBookActivity = ChatGPTStoryBookActivity.this;
            chatGPTStoryBookActivity.T4(chatGPTStoryBookActivity.getI() + 1);
            if (ChatGPTStoryBookActivity.this.getI() % 10 == 0) {
                ChatGPTStoryBookActivity chatGPTStoryBookActivity2 = ChatGPTStoryBookActivity.this;
                chatGPTStoryBookActivity2.U4(chatGPTStoryBookActivity2.getH() + 1);
                final ChatGPTStoryBookActivity chatGPTStoryBookActivity3 = ChatGPTStoryBookActivity.this;
                chatGPTStoryBookActivity3.runOnUiThread(new Runnable() { // from class: dc.wv2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatGPTStoryBookActivity.h.b(chatGPTStoryBookActivity3);
                    }
                });
            }
        }
    }

    public ChatGPTStoryBookActivity() {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(2).setUsage(1).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "Builder()\n        .setCo…E_MEDIA)\n        .build()");
        this.n = audioAttributesBuild;
        this.o = LazyKt__LazyJVMKt.lazy(new b());
        this.q = new c(Looper.getMainLooper());
    }

    public static final void M4(ChatGPTStoryBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatGPTStoryBean chatGPTStoryBean = this$0.b;
        if (chatGPTStoryBean == null || chatGPTStoryBean.getId() == null) {
            return;
        }
        ExoPlayer exoPlayerD4 = this$0.D4();
        if (!(exoPlayerD4.getPlaybackState() == 3 || exoPlayerD4.getPlaybackState() == 2)) {
            MediaItem mediaItem = this$0.p;
            if (mediaItem != null) {
                this$0.D4().setMediaItem(mediaItem);
                this$0.D4().prepare();
                return;
            }
            return;
        }
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = null;
        if (this$0.D4().isPlaying()) {
            this$0.D4().pause();
            ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding2 = this$0.a;
            if (activityChatGptStoryBookBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityChatGptStoryBookBinding = activityChatGptStoryBookBinding2;
            }
            activityChatGptStoryBookBinding.c.setImageDrawable(this$0.getResources().getDrawable(R.drawable.story_book_minibar_play));
            return;
        }
        this$0.D4().play();
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding3 = this$0.a;
        if (activityChatGptStoryBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatGptStoryBookBinding = activityChatGptStoryBookBinding3;
        }
        activityChatGptStoryBookBinding.c.setImageDrawable(this$0.getResources().getDrawable(R.drawable.story_book_minibar_pause));
    }

    public static final boolean N4(Ref.FloatRef mDownX, ChatGPTStoryBookActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(mDownX, "$mDownX");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            mDownX.element = motionEvent.getX();
        } else if (numValueOf != null && numValueOf.intValue() == 1 && motionEvent.getX() - mDownX.element > ViewConfiguration.get(this$0).getScaledTouchSlop()) {
            this$0.finish();
        }
        return true;
    }

    public static final void O4(ChatGPTStoryBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = this$0.a;
        if (activityChatGptStoryBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding = null;
        }
        activityChatGptStoryBookBinding.d.setExpanded(true);
        view.setVisibility(8);
    }

    public final void C4(int i) {
        HashMap map = new HashMap();
        map.put("page_name", "chatgpt story");
        map.put("toys", WearUtils.x.G().m());
        if (i == 1) {
            map.put("element_id", "library_lust");
            map.put("event_type", "exposure");
            map.put("event_id", "library_lust_exposure");
        } else if (i == 2) {
            map.put("element_id", "story_text");
            map.put("event_type", "exposure");
            map.put("event_id", "story_text_exposure");
        } else if (i == 3) {
            map.put("element_id", "play_chatgpt_story");
            map.put("event_id", "start_play_chatgpt_story");
        } else if (i == 4) {
            map.put("element_id", "play_chatgpt_story");
            map.put("event_id", "end_play_chatgpt_story");
            long j = 1000;
            long currentPosition = D4().getCurrentPosition() / j;
            Long l = this.k;
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(currentPosition - (l != null ? l.longValue() / j : 0L)));
            map.put("element_name", Long.valueOf(D4().getDuration() / j));
        }
        ye3.e("S0009", map);
    }

    public final ExoPlayer D4() {
        return (ExoPlayer) this.o.getValue();
    }

    @Nullable
    /* renamed from: E4, reason: from getter */
    public final Long getK() {
        return this.k;
    }

    @Nullable
    /* renamed from: F4, reason: from getter */
    public final Long getJ() {
        return this.j;
    }

    /* renamed from: G4, reason: from getter */
    public final int getI() {
        return this.i;
    }

    /* renamed from: H4, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @Nullable
    /* renamed from: I4, reason: from getter */
    public final Boolean getL() {
        return this.l;
    }

    public final Object P4(String str, Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.b(), new g(str, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final void Q4(@Nullable Boolean bool) {
        this.l = bool;
    }

    public final void R4(@Nullable Long l) {
        this.k = l;
    }

    public final void S4(@Nullable Long l) {
        this.j = l;
    }

    public final void T4(int i) {
        this.i = i;
    }

    public final void U4(int i) {
        this.h = i;
    }

    public final void V4() {
        if (this.g == null) {
            this.f = new h();
        }
        Timer timer = new Timer();
        this.g = timer;
        Intrinsics.checkNotNull(timer);
        timer.scheduleAtFixedRate(this.f, 0L, 100L);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String audiobookUrl;
        super.onCreate(savedInstanceState);
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBindingC = ActivityChatGptStoryBookBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityChatGptStoryBookBindingC, "inflate(layoutInflater)");
        this.a = activityChatGptStoryBookBindingC;
        ChatGPTStoryBean chatGPTStoryBean = (ChatGPTStoryBean) getIntent().getSerializableExtra("chatgptstorybean");
        this.b = chatGPTStoryBean;
        this.e = (ChatGPTStoryData) ro2.a(chatGPTStoryBean != null ? chatGPTStoryBean.getStoryDB() : null, ChatGPTStoryData.class);
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding = this.a;
        if (activityChatGptStoryBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding = null;
        }
        setContentView(activityChatGptStoryBookBinding.getRoot());
        settingBarColor();
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding2 = this.a;
        if (activityChatGptStoryBookBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding2 = null;
        }
        activityChatGptStoryBookBinding2.b.setParentBackgroundColor(getResources().getColor(R.color.transparent));
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding3 = this.a;
        if (activityChatGptStoryBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding3 = null;
        }
        activityChatGptStoryBookBinding3.c.setOnClickListener(new View.OnClickListener() { // from class: dc.tv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatGPTStoryBookActivity.M4(this.a, view);
            }
        });
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding4 = this.a;
        if (activityChatGptStoryBookBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding4 = null;
        }
        activityChatGptStoryBookBinding4.f.setOnTouchListener(new View.OnTouchListener() { // from class: dc.vv2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatGPTStoryBookActivity.N4(floatRef, this, view, motionEvent);
            }
        });
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding5 = this.a;
        if (activityChatGptStoryBookBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding5 = null;
        }
        TextView textView = activityChatGptStoryBookBinding5.h;
        ChatGPTStoryData chatGPTStoryData = this.e;
        textView.setText(chatGPTStoryData != null ? chatGPTStoryData.getAudiobookContent() : null);
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding6 = this.a;
        if (activityChatGptStoryBookBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding6 = null;
        }
        TextView textView2 = activityChatGptStoryBookBinding6.k;
        ChatGPTStoryData chatGPTStoryData2 = this.e;
        textView2.setText(chatGPTStoryData2 != null ? chatGPTStoryData2.getAudiobookTitle() : null);
        ChatGPTStoryData chatGPTStoryData3 = this.e;
        MediaItem mediaItemFromUri = (chatGPTStoryData3 == null || (audiobookUrl = chatGPTStoryData3.getAudiobookUrl()) == null) ? null : MediaItem.fromUri(audiobookUrl);
        this.p = mediaItemFromUri;
        if (mediaItemFromUri != null) {
            D4().setMediaItem(mediaItemFromUri);
            D4().prepare();
            V4();
        }
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding7 = this.a;
        if (activityChatGptStoryBookBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding7 = null;
        }
        activityChatGptStoryBookBinding7.e.setOnClickListener(new View.OnClickListener() { // from class: dc.uv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatGPTStoryBookActivity.O4(this.a, view);
            }
        });
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding8 = this.a;
        if (activityChatGptStoryBookBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding8 = null;
        }
        activityChatGptStoryBookBinding8.d.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d());
        ActivityChatGptStoryBookBinding activityChatGptStoryBookBinding9 = this.a;
        if (activityChatGptStoryBookBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptStoryBookBinding9 = null;
        }
        activityChatGptStoryBookBinding9.g.setOnSeekBarChangeListener(new e());
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new f(null), 3, null);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        D4().stop();
        D4().release();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C4(1);
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().setStatusBarContrastEnforced(false);
        }
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
        getWindow().setNavigationBarColor(0);
        getWindow().setStatusBarColor(0);
    }
}
