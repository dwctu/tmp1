package com.wear.media;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media.MediaBrowserServiceCompat;
import com.alibaba.fastjson.JSON;
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
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.bean.data.AudioBookList;
import com.wear.bean.data.AudioBookListBeanKt;
import dc.e24;
import dc.hz3;
import dc.n04;
import dc.pc1;
import dc.rq1;
import dc.tk2;
import dc.uk2;
import dc.uy3;
import dc.wn0;
import dc.wz3;
import dc.xn0;
import dc.xz3;
import dc.ye3;
import io.agora.rtc2.internal.AudioRoutingController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: MediaPlaybackService.kt */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\b*\u0001\u0014\u0018\u0000 G2\u00020\u0001:\u0006GHIJKLB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0016J$\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u000101H\u0016J$\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\t2\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070605H\u0016J\u0012\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0019\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010=J(\u0010>\u001a\u00020*2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u0010A\u001a\u00020\u0017H\u0002J(\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/wear/media/MediaPlaybackService;", "Landroidx/media/MediaBrowserServiceCompat;", "()V", "btWork", "Lcom/lovense/btservice/work/BtWork;", "commandMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "currentPlaylistItems", "", "Landroid/support/v4/media/MediaMetadataCompat;", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "getExoPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayer$delegate", "Lkotlin/Lazy;", "handler", "com/wear/media/MediaPlaybackService$handler$1", "Lcom/wear/media/MediaPlaybackService$handler$1;", "isForegroundService", "", "lastUpdateLogTime", "", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSessionConnector", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector;", "notificationManager", "Lcom/wear/media/NotificationManager;", "playerListener", "Lcom/wear/media/MediaPlaybackService$PlayerEventListener;", "sensitivity", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "uAmpAudioAttributes", "Lcom/google/android/exoplayer2/audio/AudioAttributes;", "onCreate", "", "onDestroy", "onGetRoot", "Landroidx/media/MediaBrowserServiceCompat$BrowserRoot;", "clientPackageName", "clientUid", "rootHints", "Landroid/os/Bundle;", "onLoadChildren", "parentId", "result", "Landroidx/media/MediaBrowserServiceCompat$Result;", "", "Landroid/support/v4/media/MediaBrowserCompat$MediaItem;", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "parseCommands", "mediaId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preparePlaylist", "metadataList", "itemToPlay", "playWhenReady", "sendLogEvent", "eventId", "albumTitle", "", MessageBundle.TITLE_ENTRY, "Companion", "PlaybackPreparer", "PlayerEventListener", "PlayerNotificationListener", "QueueNavigator", "SpeedCustomActionProvider", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MediaPlaybackService extends MediaBrowserServiceCompat {

    @NotNull
    public final ConcurrentHashMap<Integer, Map<String, Integer>> a = new ConcurrentHashMap<>();
    public MediaSessionCompat b;
    public uk2 c;
    public MediaSessionConnector d;
    public boolean e;

    @NotNull
    public final hz3 f;

    @NotNull
    public final wz3 g;

    @NotNull
    public List<MediaMetadataCompat> h;
    public long i;
    public int j;

    @NotNull
    public final AudioAttributes k;

    @NotNull
    public final b l;

    @NotNull
    public final pc1 m;

    @NotNull
    public final Lazy n;

    @NotNull
    public final g o;

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\"\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0019"}, d2 = {"Lcom/wear/media/MediaPlaybackService$PlaybackPreparer;", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector$PlaybackPreparer;", "(Lcom/wear/media/MediaPlaybackService;)V", "getSupportedPrepareActions", "", "onCommand", "", "player", "Lcom/google/android/exoplayer2/Player;", "command", "", "extras", "Landroid/os/Bundle;", "cb", "Landroid/os/ResultReceiver;", "onPrepare", "", "playWhenReady", "onPrepareFromMediaId", "mediaId", "onPrepareFromSearch", "query", "onPrepareFromUri", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Landroid/net/Uri;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a implements MediaSessionConnector.PlaybackPreparer {
        public a() {
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer
        public long getSupportedPrepareActions() {
            return 33792L;
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CommandReceiver
        public boolean onCommand(@NotNull Player player, @NotNull String command, @Nullable Bundle extras, @Nullable ResultReceiver cb) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(command, "command");
            return false;
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer
        public void onPrepare(boolean playWhenReady) {
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer
        public void onPrepareFromMediaId(@NotNull String mediaId, boolean playWhenReady, @Nullable Bundle extras) {
            Object next;
            Intrinsics.checkNotNullParameter(mediaId, "mediaId");
            if (extras != null) {
                MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
                Serializable serializable = extras.getSerializable("audio_book_list");
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.collections.List<com.wear.bean.data.AudioBookList>");
                List list = (List) serializable;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AudioBookListBeanKt.from(new MediaMetadataCompat.Builder(), (AudioBookList) it.next()).build());
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    MediaMetadataCompat it3 = (MediaMetadataCompat) next;
                    Intrinsics.checkNotNullExpressionValue(it3, "it");
                    if (Intrinsics.areEqual(it3.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID), mediaId)) {
                        break;
                    }
                }
                mediaPlaybackService.u(arrayList, (MediaMetadataCompat) next, playWhenReady);
            }
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer
        public void onPrepareFromSearch(@NotNull String query, boolean playWhenReady, @Nullable Bundle extras) {
            Intrinsics.checkNotNullParameter(query, "query");
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.PlaybackPreparer
        public void onPrepareFromUri(@NotNull Uri uri, boolean playWhenReady, @Nullable Bundle extras) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/wear/media/MediaPlaybackService$PlayerEventListener;", "Lcom/google/android/exoplayer2/Player$Listener;", "(Lcom/wear/media/MediaPlaybackService;)V", "onIsPlayingChanged", "", "isPlaying", "", "onMediaMetadataChanged", "mediaMetadata", "Lcom/google/android/exoplayer2/MediaMetadata;", "onPlayWhenReadyChanged", "playWhenReady", "reason", "", "onPlaybackStateChanged", "playbackState", "onPlayerError", "error", "Lcom/google/android/exoplayer2/PlaybackException;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class b implements Player.Listener {

        /* compiled from: MediaPlaybackService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.media.MediaPlaybackService$PlayerEventListener$onMediaMetadataChanged$1", f = "MediaPlaybackService.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Object $mediaId;
            public int label;
            public final /* synthetic */ MediaPlaybackService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(MediaPlaybackService mediaPlaybackService, Object obj, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = mediaPlaybackService;
                this.$mediaId = obj;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$mediaId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MediaPlaybackService mediaPlaybackService = this.this$0;
                    Object obj2 = this.$mediaId;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    this.label = 1;
                    if (mediaPlaybackService.t((String) obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
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

        public b() {
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.CharSequence] */
        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onIsPlayingChanged(boolean isPlaying) {
            MediaItem currentMediaItem;
            if (isPlaying) {
                MediaPlaybackService.this.o.sendEmptyMessage(255);
            } else {
                MediaPlaybackService.this.m.u0();
                MediaPlaybackService.this.o.removeMessages(255);
            }
            String str = isPlaying ? "erotic_audio_start_play" : "erotic_audio_end_play";
            if ((isPlaying || System.currentTimeMillis() - MediaPlaybackService.this.i >= 5000) && (currentMediaItem = MediaPlaybackService.this.s().getCurrentMediaItem()) != null) {
                MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
                mediaPlaybackService.i = System.currentTimeMillis();
                String mediaId = currentMediaItem.mediaId;
                Intrinsics.checkNotNullExpressionValue(mediaId, "mediaId");
                CharSequence charSequence = currentMediaItem.mediaMetadata.albumTitle;
                if (charSequence == null) {
                    charSequence = "";
                }
                Intrinsics.checkNotNullExpressionValue(charSequence, "mediaMetadata.albumTitle ?: \"\"");
                ?? r7 = currentMediaItem.mediaMetadata.title;
                String str2 = r7 != 0 ? r7 : "";
                Intrinsics.checkNotNullExpressionValue(str2, "mediaMetadata.title ?: \"\"");
                mediaPlaybackService.v(str, mediaId, charSequence, str2);
            }
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
        public void onMediaMetadataChanged(@NotNull MediaMetadata mediaMetadata) {
            Object obj;
            Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
            xn0.$default$onMediaMetadataChanged(this, mediaMetadata);
            MediaPlaybackService.this.a.clear();
            Bundle bundle = mediaMetadata.extras;
            if (bundle == null || (obj = bundle.get(MediaMetadataCompat.METADATA_KEY_MEDIA_ID)) == null) {
                obj = "";
            }
            uy3.d(MediaPlaybackService.this.g, null, null, new a(MediaPlaybackService.this, obj, null), 3, null);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
            xn0.$default$onMetadata(this, metadata);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            if (playWhenReady) {
                return;
            }
            MediaPlaybackService.this.stopForeground(false);
            MediaPlaybackService.this.e = false;
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            xn0.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int playbackState) {
            uk2 uk2Var = null;
            if (playbackState == 2 || playbackState == 3) {
                uk2 uk2Var2 = MediaPlaybackService.this.c;
                if (uk2Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                } else {
                    uk2Var = uk2Var2;
                }
                uk2Var.d(MediaPlaybackService.this.s());
                return;
            }
            uk2 uk2Var3 = MediaPlaybackService.this.c;
            if (uk2Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            } else {
                uk2Var = uk2Var3;
            }
            uk2Var.c();
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            xn0.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(@NotNull PlaybackException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            String str = "Player error: " + error.getErrorCodeName() + " (" + error.errorCode + ')';
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
        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            xn0.$default$onVideoSizeChanged(this, videoSize);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public /* synthetic */ void onVolumeChanged(float f) {
            xn0.$default$onVolumeChanged(this, f);
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/wear/media/MediaPlaybackService$PlayerNotificationListener;", "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager$NotificationListener;", "(Lcom/wear/media/MediaPlaybackService;)V", "onNotificationCancelled", "", "notificationId", "", "dismissedByUser", "", "onNotificationPosted", "notification", "Landroid/app/Notification;", "ongoing", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class c implements PlayerNotificationManager.NotificationListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener
        public void onNotificationCancelled(int notificationId, boolean dismissedByUser) {
            MediaPlaybackService.this.stopForeground(true);
            MediaPlaybackService.this.e = false;
            MediaPlaybackService.this.stopSelf();
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener
        public void onNotificationPosted(int notificationId, @NotNull Notification notification, boolean ongoing) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            if (!ongoing || MediaPlaybackService.this.e) {
                return;
            }
            ContextCompat.startForegroundService(MediaPlaybackService.this.getApplicationContext(), new Intent(MediaPlaybackService.this.getApplicationContext(), MediaPlaybackService.this.getClass()));
            MediaPlaybackService.this.startForeground(notificationId, notification);
            MediaPlaybackService.this.e = true;
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/wear/media/MediaPlaybackService$QueueNavigator;", "Lcom/google/android/exoplayer2/ext/mediasession/TimelineQueueNavigator;", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "(Lcom/wear/media/MediaPlaybackService;Landroid/support/v4/media/session/MediaSessionCompat;)V", "getMediaDescription", "Landroid/support/v4/media/MediaDescriptionCompat;", "player", "Lcom/google/android/exoplayer2/Player;", "windowIndex", "", "onSkipToNext", "", "onSkipToPrevious", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class d extends TimelineQueueNavigator {
        public final /* synthetic */ MediaPlaybackService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull MediaPlaybackService mediaPlaybackService, MediaSessionCompat mediaSession) {
            super(mediaSession);
            Intrinsics.checkNotNullParameter(mediaSession, "mediaSession");
            this.a = mediaPlaybackService;
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator
        @NotNull
        public MediaDescriptionCompat getMediaDescription(@NotNull Player player, int windowIndex) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (windowIndex < this.a.h.size()) {
                MediaDescriptionCompat description = ((MediaMetadataCompat) this.a.h.get(windowIndex)).getDescription();
                Intrinsics.checkNotNullExpressionValue(description, "currentPlaylistItems[windowIndex].description");
                return description;
            }
            MediaDescriptionCompat mediaDescriptionCompatBuild = new MediaDescriptionCompat.Builder().build();
            Intrinsics.checkNotNullExpressionValue(mediaDescriptionCompatBuild, "Builder().build()");
            return mediaDescriptionCompatBuild;
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator, com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
        public void onSkipToNext(@NotNull Player player) {
            Intrinsics.checkNotNullParameter(player, "player");
            player.seekToNextMediaItem();
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator, com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
        public void onSkipToPrevious(@NotNull Player player) {
            Intrinsics.checkNotNullParameter(player, "player");
            player.seekToPreviousMediaItem();
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/wear/media/MediaPlaybackService$SpeedCustomActionProvider;", "Lcom/google/android/exoplayer2/ext/mediasession/MediaSessionConnector$CustomActionProvider;", "(Lcom/wear/media/MediaPlaybackService;)V", "getCustomAction", "Landroid/support/v4/media/session/PlaybackStateCompat$CustomAction;", "player", "Lcom/google/android/exoplayer2/Player;", "onCustomAction", "", AMPExtension.Action.ATTRIBUTE_NAME, "", "extras", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class e implements MediaSessionConnector.CustomActionProvider {
        public e() {
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CustomActionProvider
        @Nullable
        public PlaybackStateCompat.CustomAction getCustomAction(@NotNull Player player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return new PlaybackStateCompat.CustomAction.Builder("com.lovens.wear.SENSITIVITY", "change", R.drawable.exo_media_action_repeat_off).build();
        }

        @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CustomActionProvider
        public void onCustomAction(@NotNull Player player, @NotNull String action, @Nullable Bundle extras) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(action, "action");
            MediaPlaybackService.this.j = extras != null ? extras.getInt("sensitivity") : 75;
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/exoplayer2/ExoPlayer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<ExoPlayer> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExoPlayer invoke() {
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(MediaPlaybackService.this.getBaseContext()).build();
            MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
            exoPlayerBuild.setAudioAttributes(mediaPlaybackService.k, true);
            exoPlayerBuild.setHandleAudioBecomingNoisy(true);
            exoPlayerBuild.setWakeMode(2);
            exoPlayerBuild.addListener((Player.Listener) mediaPlaybackService.l);
            Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "Builder(baseContext).bui…playerListener)\n        }");
            return exoPlayerBuild;
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/media/MediaPlaybackService$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 255) {
                long currentPosition = MediaPlaybackService.this.s().getCurrentPosition();
                long j = currentPosition % 100;
                if (j != 0) {
                    currentPosition += 100 - j;
                }
                int i = (int) currentPosition;
                if (MediaPlaybackService.this.a.containsKey(Integer.valueOf(i))) {
                    Map mapEmptyMap = (Map) MediaPlaybackService.this.a.get(Integer.valueOf(i));
                    if (mapEmptyMap == null) {
                        mapEmptyMap = MapsKt__MapsKt.emptyMap();
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
                    for (Map.Entry entry : mapEmptyMap.entrySet()) {
                        float fFloatValue = ((Number) entry.getValue()).floatValue() * ((mediaPlaybackService.j * 1.0f) / 100);
                        if (mapEmptyMap.size() == 1) {
                            rq1.d.j(MathKt__MathJVMKt.roundToInt(fFloatValue));
                        } else if (mapEmptyMap.size() > 1) {
                            arrayList.add(String.valueOf(MathKt__MathJVMKt.roundToInt(fFloatValue)));
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

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.media.MediaPlaybackService", f = "MediaPlaybackService.kt", i = {0}, l = {302}, m = "parseCommands", n = {"this"}, s = {"L$0"})
    public static final class h extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaPlaybackService.this.t(null, this);
        }
    }

    /* compiled from: MediaPlaybackService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.media.MediaPlaybackService$parseCommands$2", f = "MediaPlaybackService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $mediaId;
        public int label;

        /* compiled from: MediaPlaybackService.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/wear/media/MediaPlaybackService$parseCommands$2$mapType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<Map<String, ? extends Integer>> {
        }

        /* compiled from: MediaPlaybackService.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/wear/media/MediaPlaybackService$parseCommands$2$type$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class b extends TypeToken<ArrayList<Object>> {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, Continuation<? super i> continuation) {
            super(2, continuation);
            this.$mediaId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return MediaPlaybackService.this.new i(this.$mediaId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((i) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File file = new File(MediaPlaybackService.this.getExternalFilesDir("wear/audioBook"), this.$mediaId + ".json");
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                Type type = new b().getType();
                Type type2 = new a().getType();
                try {
                    Gson gson = new Gson();
                    ArrayList array = (ArrayList) gson.fromJson(bufferedReader, type);
                    String str = "array size = " + array.size();
                    Intrinsics.checkNotNullExpressionValue(array, "array");
                    MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
                    Iterator it = array.iterator();
                    while (it.hasNext()) {
                        Map map = (Map) gson.fromJson(gson.toJson(it.next()), type2);
                        Object obj2 = map.get("t");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) obj2).intValue();
                        Intrinsics.checkNotNullExpressionValue(map, "map");
                        for (Map.Entry entry : map.entrySet()) {
                            if (iIntValue >= 0 && !Intrinsics.areEqual(entry.getKey(), "t")) {
                                mediaPlaybackService.a.put(Boxing.boxInt(iIntValue), MapsKt__MapsJVMKt.mapOf(TuplesKt.to(entry.getKey(), entry.getValue())));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    String str2 = "gson format error :" + e.getMessage();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public MediaPlaybackService() {
        hz3 hz3VarB = e24.b(null, 1, null);
        this.f = hz3VarB;
        this.g = xz3.a(n04.c().plus(hz3VarB));
        this.h = CollectionsKt__CollectionsKt.emptyList();
        this.j = 75;
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(2).setUsage(1).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "Builder()\n        .setCo…E_MEDIA)\n        .build()");
        this.k = audioAttributesBuild;
        this.l = new b();
        this.m = pc1.a;
        this.n = LazyKt__LazyJVMKt.lazy(new f());
        this.o = new g(Looper.getMainLooper());
    }

    @Override // androidx.media.MediaBrowserServiceCompat, android.app.Service
    public void onCreate() {
        Intent launchIntentForPackage;
        super.onCreate();
        PackageManager packageManager = getPackageManager();
        uk2 uk2Var = null;
        PendingIntent activity = (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(getPackageName())) == null) ? null : Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(this, 0, launchIntentForPackage, AudioRoutingController.DEVICE_OUT_USB_HEADSET) : PendingIntent.getActivity(this, 0, launchIntentForPackage, 134217728);
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(getBaseContext(), "MediaPlaybackService");
        mediaSessionCompat.setSessionActivity(activity);
        mediaSessionCompat.setActive(true);
        this.b = mediaSessionCompat;
        if (mediaSessionCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSession");
            mediaSessionCompat = null;
        }
        setSessionToken(mediaSessionCompat.getSessionToken());
        MediaSessionCompat mediaSessionCompat2 = this.b;
        if (mediaSessionCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSession");
            mediaSessionCompat2 = null;
        }
        MediaSessionCompat.Token sessionToken = mediaSessionCompat2.getSessionToken();
        Intrinsics.checkNotNullExpressionValue(sessionToken, "mediaSession.sessionToken");
        this.c = new uk2(this, sessionToken, new c());
        MediaSessionCompat mediaSessionCompat3 = this.b;
        if (mediaSessionCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSession");
            mediaSessionCompat3 = null;
        }
        MediaSessionConnector mediaSessionConnector = new MediaSessionConnector(mediaSessionCompat3);
        this.d = mediaSessionConnector;
        if (mediaSessionConnector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSessionConnector");
            mediaSessionConnector = null;
        }
        mediaSessionConnector.setPlaybackPreparer(new a());
        MediaSessionConnector mediaSessionConnector2 = this.d;
        if (mediaSessionConnector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSessionConnector");
            mediaSessionConnector2 = null;
        }
        MediaSessionCompat mediaSessionCompat4 = this.b;
        if (mediaSessionCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSession");
            mediaSessionCompat4 = null;
        }
        mediaSessionConnector2.setQueueNavigator(new d(this, mediaSessionCompat4));
        MediaSessionConnector mediaSessionConnector3 = this.d;
        if (mediaSessionConnector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSessionConnector");
            mediaSessionConnector3 = null;
        }
        mediaSessionConnector3.setCustomActionProviders(new e());
        MediaSessionConnector mediaSessionConnector4 = this.d;
        if (mediaSessionConnector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSessionConnector");
            mediaSessionConnector4 = null;
        }
        mediaSessionConnector4.setPlayer(s());
        uk2 uk2Var2 = this.c;
        if (uk2Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
        } else {
            uk2Var = uk2Var2;
        }
        uk2Var.d(s());
    }

    @Override // android.app.Service
    public void onDestroy() {
        MediaSessionCompat mediaSessionCompat = this.b;
        if (mediaSessionCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSession");
            mediaSessionCompat = null;
        }
        mediaSessionCompat.setActive(false);
        mediaSessionCompat.release();
        s().removeListener((Player.Listener) this.l);
        s().release();
        this.o.removeMessages(255);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    @Nullable
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(@NotNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        Intrinsics.checkNotNullParameter(clientPackageName, "clientPackageName");
        if (TextUtils.equals(clientPackageName, getPackageName())) {
            return new MediaBrowserServiceCompat.BrowserRoot("media_root_id", null);
        }
        return null;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(@NotNull String parentId, @NotNull MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(result, "result");
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        this.m.u0();
        s().clearMediaItems();
        s().stop();
    }

    public final ExoPlayer s() {
        return (ExoPlayer) this.n.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.wear.media.MediaPlaybackService.h
            if (r0 == 0) goto L13
            r0 = r7
            com.wear.media.MediaPlaybackService$h r0 = (com.wear.media.MediaPlaybackService.h) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.media.MediaPlaybackService$h r0 = new com.wear.media.MediaPlaybackService$h
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            com.wear.media.MediaPlaybackService r6 = (com.wear.media.MediaPlaybackService) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            dc.qz3 r7 = dc.n04.b()
            com.wear.media.MediaPlaybackService$i r2 = new com.wear.media.MediaPlaybackService$i
            r4 = 0
            r2.<init>(r6, r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = dc.sy3.g(r7, r2, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r6 = r5
        L4e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "解析完成 commandMap size = "
            r7.append(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.util.Map<java.lang.String, java.lang.Integer>> r6 = r6.a
            int r6 = r6.size()
            r7.append(r6)
            r7.toString()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.media.MediaPlaybackService.t(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void u(List<MediaMetadataCompat> list, MediaMetadataCompat mediaMetadataCompat, boolean z) {
        int iIndexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends MediaMetadataCompat>) list, mediaMetadataCompat);
        this.h = list;
        s().setPlayWhenReady(z);
        s().stop();
        ExoPlayer exoPlayerS = s();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(tk2.a((MediaMetadataCompat) it.next()));
        }
        exoPlayerS.setMediaItems(arrayList, iIndexOf, 0L);
        s().prepare();
    }

    public final void v(String str, String str2, CharSequence charSequence, CharSequence charSequence2) {
        HashMap map = new HashMap();
        map.put("page_name", "erotic audio");
        map.put("event_id", str);
        map.put("element_id", str2);
        map.put("element_type", "");
        List array = JSON.parseArray(charSequence.toString(), String.class);
        Intrinsics.checkNotNullExpressionValue(array, "parseArray(albumTitle.to…ng(), String::class.java)");
        map.put("element_content", array);
        map.put("element_name", charSequence2);
        map.put(TypedValues.TransitionType.S_DURATION, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(s().getCurrentPosition())));
        map.put("toys", this.m.m());
        ye3.e("S0009", map);
    }
}
