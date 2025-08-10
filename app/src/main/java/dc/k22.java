package dc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.lovense.wear.R;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.game.ui.GameActivity;
import com.wear.main.longDistance.player.ui.PlayerActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.media.MediaPlaybackService;
import com.wear.ui.discover.voicebook.VoiceBookActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.MyApplication;
import com.wear.widget.control.FingImageLayout;
import com.wear.widget.dialog.ControlGeneralExpandDialog;
import dc.is3;
import dc.x12;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceBookController.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005*\u0002\n\u0011\u0018\u0000 62\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00070#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010&\u001a\u00020!H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J \u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0016J\u0006\u00104\u001a\u00020\u001fJ\u0012\u00105\u001a\u00020\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/wear/main/control/voicecontrol/VoiceBookController;", "Lcom/wear/main/control/ControlInterface;", "mediator", "Lcom/wear/main/control/Mediator;", "(Lcom/wear/main/control/Mediator;)V", "blackList", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "connectionCallback", "com/wear/main/control/voicecontrol/VoiceBookController$connectionCallback$1", "Lcom/wear/main/control/voicecontrol/VoiceBookController$connectionCallback$1;", "context", "Landroid/content/Context;", "controlState", "Lcom/wear/main/control/state/ControlState;", "controllerCallback", "com/wear/main/control/voicecontrol/VoiceBookController$controllerCallback$1", "Lcom/wear/main/control/voicecontrol/VoiceBookController$controllerCallback$1;", "controllingState", "Lcom/wear/main/control/state/ControllingState;", "expandDialog", "Ljava/lang/ref/WeakReference;", "Lcom/wear/widget/dialog/ControlGeneralExpandDialog;", "idleState", "Lcom/wear/main/control/state/IdleState;", "mediaBrowser", "Landroid/support/v4/media/MediaBrowserCompat;", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "closeExpandWindow", "", "getAnimation", "", "getBlackList", "", "getControlState", "getControllingState", "getControllingTip", "getIdleState", "getMediator", "getPriority", "Lcom/wear/main/control/ControlPriority;", "isOpeningExpandWindow", "", "onActivityCreated", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "openExpandWindow", TtmlNode.LEFT, "x", "", FingImageLayout.ObjectAnimatorY, "pause", "setControlState", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class k22 implements x12 {

    @NotNull
    public final e22 a;

    @NotNull
    public Context b;
    public MediaBrowserCompat c;

    @Nullable
    public MediaControllerCompat d;

    @NotNull
    public final List<Class<? extends Activity>> e;

    @Nullable
    public WeakReference<ControlGeneralExpandDialog> f;

    @NotNull
    public final c g;

    @NotNull
    public final d h;

    @Nullable
    public f22 i;

    @Nullable
    public h22 j;

    @Nullable
    public g22 k;

    /* compiled from: VoiceBookController.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/main/control/voicecontrol/VoiceBookController$1", "Lcom/wear/main/control/state/IdleState;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends h22 {
        @Override // dc.f22
        public void b(@Nullable Map<String, ? extends Object> map) {
        }

        @Override // dc.f22
        public void c(@Nullable Map<String, ? extends Object> map) {
        }
    }

    /* compiled from: VoiceBookController.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/main/control/voicecontrol/VoiceBookController$2", "Lcom/wear/main/control/state/ControllingState;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends g22 {
        public b() {
        }

        @Override // dc.g22, dc.f22
        public void b(@Nullable Map<String, ? extends Object> map) {
            super.b(map);
            MediaBrowserCompat mediaBrowserCompat = null;
            k22.this.c = new MediaBrowserCompat(k22.this.b, new ComponentName(k22.this.b, (Class<?>) MediaPlaybackService.class), k22.this.g, null);
            MediaBrowserCompat mediaBrowserCompat2 = k22.this.c;
            if (mediaBrowserCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaBrowser");
            } else {
                mediaBrowserCompat = mediaBrowserCompat2;
            }
            mediaBrowserCompat.connect();
        }

        @Override // dc.f22
        public void c(@Nullable Map<String, ? extends Object> map) {
            MediaControllerCompat.TransportControls transportControls;
            MediaControllerCompat mediaControllerCompat = k22.this.d;
            if (mediaControllerCompat != null && (transportControls = mediaControllerCompat.getTransportControls()) != null) {
                transportControls.stop();
            }
            MediaBrowserCompat mediaBrowserCompat = k22.this.c;
            if (mediaBrowserCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaBrowser");
                mediaBrowserCompat = null;
            }
            mediaBrowserCompat.disconnect();
            MediaControllerCompat mediaControllerCompat2 = k22.this.d;
            if (mediaControllerCompat2 != null) {
                mediaControllerCompat2.unregisterCallback(k22.this.h);
            }
        }
    }

    /* compiled from: VoiceBookController.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/wear/main/control/voicecontrol/VoiceBookController$connectionCallback$1", "Landroid/support/v4/media/MediaBrowserCompat$ConnectionCallback;", "onConnected", "", "onConnectionFailed", "onConnectionSuspended", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends MediaBrowserCompat.ConnectionCallback {
        public c() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat = k22.this.c;
            if (mediaBrowserCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaBrowser");
                mediaBrowserCompat = null;
            }
            MediaSessionCompat.Token sessionToken = mediaBrowserCompat.getSessionToken();
            k22 k22Var = k22.this;
            k22Var.d = new MediaControllerCompat(k22Var.b, sessionToken);
            MediaControllerCompat mediaControllerCompat = k22.this.d;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.registerCallback(k22.this.h);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
        }
    }

    /* compiled from: VoiceBookController.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/wear/main/control/voicecontrol/VoiceBookController$controllerCallback$1", "Landroid/support/v4/media/session/MediaControllerCompat$Callback;", "onMetadataChanged", "", TtmlNode.TAG_METADATA, "Landroid/support/v4/media/MediaMetadataCompat;", "onPlaybackStateChanged", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends MediaControllerCompat.Callback {
        public d() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(@Nullable MediaMetadataCompat metadata) {
            StringBuilder sb = new StringBuilder();
            sb.append("onMetadataChanged :");
            sb.append(metadata != null ? metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID) : null);
            sb.toString();
            if (metadata != null) {
                ControlGeneralExpandDialog.i.a(String.valueOf(metadata.getString(MediaMetadataCompat.METADATA_KEY_TITLE)), metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(@Nullable PlaybackStateCompat state) {
            Boolean boolValueOf;
            StringBuilder sb = new StringBuilder();
            sb.append("onPlaybackStateChanged :");
            if (state != null) {
                boolValueOf = Boolean.valueOf(state.getState() == 6 || state.getState() == 3);
            } else {
                boolValueOf = null;
            }
            sb.append(boolValueOf);
            sb.append(' ');
            sb.toString();
            if (state != null) {
                k22 k22Var = k22.this;
                ControlGeneralExpandDialog.i.b(state.getState() == 6 || state.getState() == 3);
                if (state.getState() == 6 || state.getState() == 3) {
                    k22Var.a.c();
                    qf3.C();
                } else {
                    k22Var.a.e();
                }
            }
            ControlGeneralExpandDialog.i.c(state != null ? state.getPosition() : 0L);
        }
    }

    /* compiled from: VoiceBookController.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/wear/main/control/voicecontrol/VoiceBookController$openExpandWindow$3", "Lcom/wear/widget/dialog/ControlGeneralExpandDialog$Listener;", TtmlNode.END, "", "next", "playOrPause", "previous", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements ControlGeneralExpandDialog.b {
        public e() {
        }

        @Override // com.wear.widget.dialog.ControlGeneralExpandDialog.b
        public void a() {
            MediaControllerCompat mediaControllerCompat = k22.this.d;
            if (mediaControllerCompat != null) {
                PlaybackStateCompat playbackState = mediaControllerCompat.getPlaybackState();
                Intrinsics.checkNotNullExpressionValue(playbackState, "it.playbackState");
                if (playbackState.getState() == 6 || playbackState.getState() == 3) {
                    mediaControllerCompat.getTransportControls().pause();
                } else {
                    mediaControllerCompat.getTransportControls().play();
                }
            }
        }

        @Override // com.wear.widget.dialog.ControlGeneralExpandDialog.b
        public void end() {
            k22.this.h(new Event(c22.EVENT_STOP, null, 2, null));
        }

        @Override // com.wear.widget.dialog.ControlGeneralExpandDialog.b
        public void next() {
            MediaControllerCompat mediaControllerCompat;
            MediaControllerCompat.TransportControls transportControls;
            PlaybackStateCompat playbackState;
            MediaControllerCompat.TransportControls transportControls2;
            MediaControllerCompat mediaControllerCompat2 = k22.this.d;
            if (mediaControllerCompat2 != null && (transportControls2 = mediaControllerCompat2.getTransportControls()) != null) {
                transportControls2.skipToNext();
            }
            MediaControllerCompat mediaControllerCompat3 = k22.this.d;
            boolean z = false;
            if (mediaControllerCompat3 != null && (playbackState = mediaControllerCompat3.getPlaybackState()) != null && playbackState.getState() == 2) {
                z = true;
            }
            if (!z || (mediaControllerCompat = k22.this.d) == null || (transportControls = mediaControllerCompat.getTransportControls()) == null) {
                return;
            }
            transportControls.play();
        }

        @Override // com.wear.widget.dialog.ControlGeneralExpandDialog.b
        public void previous() {
            MediaControllerCompat mediaControllerCompat;
            MediaControllerCompat.TransportControls transportControls;
            PlaybackStateCompat playbackState;
            MediaControllerCompat.TransportControls transportControls2;
            MediaControllerCompat mediaControllerCompat2 = k22.this.d;
            if (mediaControllerCompat2 != null && (transportControls2 = mediaControllerCompat2.getTransportControls()) != null) {
                transportControls2.skipToPrevious();
            }
            MediaControllerCompat mediaControllerCompat3 = k22.this.d;
            boolean z = false;
            if (mediaControllerCompat3 != null && (playbackState = mediaControllerCompat3.getPlaybackState()) != null && playbackState.getState() == 2) {
                z = true;
            }
            if (!z || (mediaControllerCompat = k22.this.d) == null || (transportControls = mediaControllerCompat.getTransportControls()) == null) {
                return;
            }
            transportControls.play();
        }
    }

    public k22(@NotNull e22 mediator) {
        Intrinsics.checkNotNullParameter(mediator, "mediator");
        this.a = mediator;
        MyApplication myApplicationN = MyApplication.N();
        Intrinsics.checkNotNullExpressionValue(myApplicationN, "getMyAppcation()");
        this.b = myApplicationN;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.g = new c();
        this.h = new d();
        a aVar = new a();
        this.j = aVar;
        this.k = new b();
        this.i = aVar;
        arrayList.add(VoiceBookActivity.class);
    }

    public static final void A(Activity activity) {
        pj3.f(activity, VoiceBookActivity.class);
    }

    public static final void z(k22 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a.b();
    }

    public final void B() {
        MediaControllerCompat mediaControllerCompat = this.d;
        if (mediaControllerCompat != null) {
            PlaybackStateCompat playbackState = mediaControllerCompat.getPlaybackState();
            Intrinsics.checkNotNullExpressionValue(playbackState, "it.playbackState");
            if (playbackState.getState() == 6 || playbackState.getState() == 3) {
                mediaControllerCompat.getTransportControls().pause();
            }
        }
    }

    @Override // dc.x12
    public boolean a() {
        ControlGeneralExpandDialog controlGeneralExpandDialog;
        WeakReference<ControlGeneralExpandDialog> weakReference = this.f;
        if (weakReference == null || (controlGeneralExpandDialog = weakReference.get()) == null) {
            return false;
        }
        return controlGeneralExpandDialog.isShowing();
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.i = f22Var;
    }

    @Override // dc.x12
    @NotNull
    public String d() {
        return "Voice Book is controlling";
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e, reason: from getter */
    public f22 getI() {
        return this.i;
    }

    @Override // dc.x12
    public boolean f() {
        return x12.b.a(this);
    }

    @Override // dc.x12
    public void g() {
        ControlGeneralExpandDialog controlGeneralExpandDialog;
        WeakReference<ControlGeneralExpandDialog> weakReference = this.f;
        if (weakReference == null || (controlGeneralExpandDialog = weakReference.get()) == null) {
            return;
        }
        controlGeneralExpandDialog.dismiss();
    }

    @Override // dc.x12
    @NotNull
    public a22 getPriority() {
        return a22.PRIORITY_1;
    }

    @Override // dc.x12
    public /* synthetic */ boolean h(Event event) {
        return w12.b(this, event);
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: i, reason: from getter */
    public h22 getJ() {
        return this.j;
    }

    @Override // dc.x12
    public void j(boolean z, int i, int i2) {
        PlaybackStateCompat playbackState;
        PlaybackStateCompat playbackState2;
        MediaMetadataCompat metadata;
        MediaMetadataCompat metadata2;
        final FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
            return;
        }
        this.a.f();
        ExpandData expandData = new ExpandData(0, 0, false, 0, null, 0, 0L, 0L, false, FrameMetricsAggregator.EVERY_DURATION, null);
        expandData.k(z);
        expandData.p(i);
        expandData.q(i2);
        MediaControllerCompat mediaControllerCompat = this.d;
        expandData.l(String.valueOf((mediaControllerCompat == null || (metadata2 = mediaControllerCompat.getMetadata()) == null) ? null : metadata2.getString(MediaMetadataCompat.METADATA_KEY_TITLE)));
        MediaControllerCompat mediaControllerCompat2 = this.d;
        long position = 0;
        expandData.i((mediaControllerCompat2 == null || (metadata = mediaControllerCompat2.getMetadata()) == null) ? 0L : metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        MediaControllerCompat mediaControllerCompat3 = this.d;
        if (mediaControllerCompat3 != null && (playbackState2 = mediaControllerCompat3.getPlaybackState()) != null) {
            position = playbackState2.getPosition();
        }
        expandData.m(position);
        MediaControllerCompat mediaControllerCompat4 = this.d;
        boolean z2 = false;
        if (mediaControllerCompat4 != null && (playbackState = mediaControllerCompat4.getPlaybackState()) != null && (playbackState.getState() == 6 || playbackState.getState() == 3)) {
            z2 = true;
        }
        expandData.n(z2);
        expandData.j(R.drawable.full_control_voice_book_expand);
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.e(expandData);
        bVar.c(new is3.c() { // from class: dc.j22
            @Override // dc.is3.c
            public final void doCancel() {
                k22.z(this.a);
            }
        });
        bVar.d(new is3.d() { // from class: dc.i22
            @Override // dc.is3.d
            public final void doConfirm() {
                k22.A(fragmentActivityH);
            }
        });
        ControlGeneralExpandDialog controlGeneralExpandDialog = (ControlGeneralExpandDialog) cs3.i(bVar, ControlGeneralExpandDialog.class);
        controlGeneralExpandDialog.setListener(new e());
        controlGeneralExpandDialog.p(fragmentActivityH);
        controlGeneralExpandDialog.show();
        this.f = new WeakReference<>(controlGeneralExpandDialog);
    }

    @Override // dc.x12
    @NotNull
    /* renamed from: k, reason: from getter */
    public e22 getA() {
        return this.a;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: l, reason: from getter */
    public g22 getK() {
        return this.k;
    }

    @Override // dc.x12
    public void m(@Nullable Activity activity) {
        if ((activity instanceof SoundPlayActivity) || (activity instanceof CreatePatternActivity) || (activity instanceof PatternPlayActivity) || (activity instanceof AlarmSoundPlayActivity) || (activity instanceof RemoteControlActivity) || (activity instanceof RemoteMultiControlActivity) || (activity instanceof MusicRecordActivity) || (activity instanceof GameActivity) || (activity instanceof PlayerActivity)) {
            h(new Event(c22.EVENT_STOP, null, 2, null));
        }
    }

    @Override // dc.x12
    @NotNull
    public List<Class<? extends Activity>> n() {
        return this.e;
    }

    @Override // dc.x12
    @NotNull
    public String o() {
        return "voice_book_anim.json";
    }
}
