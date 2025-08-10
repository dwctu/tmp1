package com.wear.ui.discover.voicebook;

import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.BaseActivity;
import com.wear.adapter.discover.AudioBookListAdapter;
import com.wear.adapter.discover.TagListAdapter;
import com.wear.bean.data.AudioBookList;
import com.wear.databinding.ActivityVoiceBookBinding;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.media.MediaPlaybackService;
import com.wear.ui.discover.chatgpt.ChatGPTActivity;
import com.wear.ui.discover.voicebook.VoiceBookActivity;
import com.wear.util.MyApplication;
import com.wear.widget.MyActionBar;
import com.wear.widget.dialog.AudioBookDialog;
import dc.Event;
import dc.ae1;
import dc.ah4;
import dc.br;
import dc.c22;
import dc.ce3;
import dc.cs3;
import dc.eg3;
import dc.is3;
import dc.k22;
import dc.kf;
import dc.le1;
import dc.na2;
import dc.ne1;
import dc.pc1;
import dc.pj3;
import dc.qf;
import dc.rr3;
import dc.vl2;
import dc.x12;
import dc.y12;
import dc.ye3;
import dc.zq;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceBookActivity.kt */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003\r\u0012\u0015\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0003J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0016J\u0012\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\"H\u0014J\b\u0010/\u001a\u00020\"H\u0014J\b\u00100\u001a\u00020\"H\u0014J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020\"H\u0002J\"\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u001e\u0010>\u001a\u00020\"2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@2\u0006\u0010B\u001a\u000207H\u0002J\u0010\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u000207H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006F"}, d2 = {"Lcom/wear/ui/discover/voicebook/VoiceBookActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "audioBookBottomControlDialog", "Lcom/wear/widget/dialog/AudioBookBottomControlDialog;", "audioBookDialog", "Lcom/wear/widget/dialog/AudioBookDialog;", "audioBookListAdapter", "Lcom/wear/adapter/discover/AudioBookListAdapter;", "binding", "Lcom/wear/databinding/ActivityVoiceBookBinding;", "connectionCallbacks", "com/wear/ui/discover/voicebook/VoiceBookActivity$connectionCallbacks$1", "Lcom/wear/ui/discover/voicebook/VoiceBookActivity$connectionCallbacks$1;", "controller", "Lcom/wear/main/control/voicecontrol/VoiceBookController;", "controllerCallback", "com/wear/ui/discover/voicebook/VoiceBookActivity$controllerCallback$1", "Lcom/wear/ui/discover/voicebook/VoiceBookActivity$controllerCallback$1;", "handler", "com/wear/ui/discover/voicebook/VoiceBookActivity$handler$1", "Lcom/wear/ui/discover/voicebook/VoiceBookActivity$handler$1;", "mediaBrowser", "Landroid/support/v4/media/MediaBrowserCompat;", "tagAdapter", "Lcom/wear/adapter/discover/TagListAdapter;", "viewModel", "Lcom/wear/ui/discover/voicebook/VoiceBookViewModel;", "getViewModel", "()Lcom/wear/ui/discover/voicebook/VoiceBookViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "buildTransportControls", "", "dispatchPlayAction", "mediaId", "", "initAction", "initListView", "notifyPlayState", "observableViewModelData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "playListBundle", "sendS008", "sendS009Log", TtmlNode.TAG_METADATA, "Landroid/support/v4/media/MediaMetadataCompat;", FirebaseAnalytics.Param.LOCATION, "", TypedValues.TransitionType.S_DURATION, "", "showBottomBar", "", "it", "Landroid/support/v4/media/MediaDescriptionCompat;", "showDetail", "data", "", "Lcom/wear/bean/data/AudioBookList;", "position", "showLoginDialog", "resId", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceBookActivity extends BaseActivity<vl2> {
    public ActivityVoiceBookBinding a;
    public MediaBrowserCompat b;

    @NotNull
    public final Lazy c = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VoiceBookViewModel.class), new i(this), new h(this), new j(null, this));

    @Nullable
    public AudioBookDialog d;

    @Nullable
    public k22 e;

    @Nullable
    public rr3 f;

    @NotNull
    public final TagListAdapter g;

    @NotNull
    public final d h;

    @NotNull
    public final AudioBookListAdapter i;

    @NotNull
    public final b j;

    @NotNull
    public final c k;

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "data", "", "Lcom/wear/bean/data/AudioBookList;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<List<AudioBookList>, Unit> {
        public a() {
            super(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(@org.jetbrains.annotations.Nullable java.util.List<com.wear.bean.data.AudioBookList> r8) {
            /*
                r7 = this;
                r0 = 0
                r1 = 1
                if (r8 == 0) goto Ld
                boolean r2 = r8.isEmpty()
                if (r2 == 0) goto Lb
                goto Ld
            Lb:
                r2 = 0
                goto Le
            Ld:
                r2 = 1
            Le:
                r3 = 0
                java.lang.String r4 = "binding"
                if (r2 == 0) goto L37
                com.wear.ui.discover.voicebook.VoiceBookActivity r8 = com.wear.ui.discover.voicebook.VoiceBookActivity.this
                com.wear.databinding.ActivityVoiceBookBinding r8 = com.wear.ui.discover.voicebook.VoiceBookActivity.u4(r8)
                if (r8 != 0) goto L1f
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
                r8 = r3
            L1f:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r8 = r8.n
                r8.l()
                com.wear.ui.discover.voicebook.VoiceBookActivity r8 = com.wear.ui.discover.voicebook.VoiceBookActivity.this
                com.wear.databinding.ActivityVoiceBookBinding r8 = com.wear.ui.discover.voicebook.VoiceBookActivity.u4(r8)
                if (r8 != 0) goto L30
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
                goto L31
            L30:
                r3 = r8
            L31:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r8 = r3.n
                r8.C(r0)
                goto L9c
            L37:
                com.wear.ui.discover.voicebook.VoiceBookActivity r2 = com.wear.ui.discover.voicebook.VoiceBookActivity.this
                com.wear.databinding.ActivityVoiceBookBinding r2 = com.wear.ui.discover.voicebook.VoiceBookActivity.u4(r2)
                if (r2 != 0) goto L43
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
                goto L44
            L43:
                r3 = r2
            L44:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = r3.n
                r2.C(r1)
                com.wear.ui.discover.voicebook.VoiceBookActivity r2 = com.wear.ui.discover.voicebook.VoiceBookActivity.this
                android.support.v4.media.session.MediaControllerCompat r2 = android.support.v4.media.session.MediaControllerCompat.getMediaController(r2)
                java.util.Iterator r8 = r8.iterator()
            L53:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto L9c
                java.lang.Object r3 = r8.next()
                com.wear.bean.data.AudioBookList r3 = (com.wear.bean.data.AudioBookList) r3
                android.support.v4.media.MediaMetadataCompat r4 = r2.getMetadata()
                java.lang.String r5 = "metadata"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                java.lang.String r5 = "android.media.metadata.MEDIA_ID"
                java.lang.String r4 = r4.getString(r5)
                java.lang.String r5 = r3.getId()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L97
                android.support.v4.media.session.PlaybackStateCompat r4 = r2.getPlaybackState()
                java.lang.String r5 = "playbackState"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                int r5 = r4.getState()
                r6 = 6
                if (r5 == r6) goto L92
                int r4 = r4.getState()
                r5 = 3
                if (r4 != r5) goto L90
                goto L92
            L90:
                r4 = 0
                goto L93
            L92:
                r4 = 1
            L93:
                if (r4 == 0) goto L97
                r4 = 1
                goto L98
            L97:
                r4 = 0
            L98:
                r3.setPlay(r4)
                goto L53
            L9c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicebook.VoiceBookActivity.a.a(java.util.List):void");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<AudioBookList> list) {
            a(list);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/voicebook/VoiceBookActivity$connectionCallbacks$1", "Landroid/support/v4/media/MediaBrowserCompat$ConnectionCallback;", "onConnected", "", "onConnectionFailed", "onConnectionSuspended", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends MediaBrowserCompat.ConnectionCallback {
        public b() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat = VoiceBookActivity.this.b;
            if (mediaBrowserCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaBrowser");
                mediaBrowserCompat = null;
            }
            MediaSessionCompat.Token sessionToken = mediaBrowserCompat.getSessionToken();
            VoiceBookActivity voiceBookActivity = VoiceBookActivity.this;
            MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(voiceBookActivity, sessionToken);
            int iF = eg3.f(voiceBookActivity, "sensitivity_seek", 75);
            MediaControllerCompat.TransportControls transportControls = mediaControllerCompat.getTransportControls();
            Bundle bundle = new Bundle();
            bundle.putInt("sensitivity", iF);
            Unit unit = Unit.INSTANCE;
            transportControls.sendCustomAction("com.lovens.wear.SENSITIVITY", bundle);
            MediaControllerCompat.setMediaController(voiceBookActivity, mediaControllerCompat);
            VoiceBookActivity.this.B4();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
        }
    }

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/voicebook/VoiceBookActivity$controllerCallback$1", "Landroid/support/v4/media/session/MediaControllerCompat$Callback;", "onMetadataChanged", "", TtmlNode.TAG_METADATA, "Landroid/support/v4/media/MediaMetadataCompat;", "onPlaybackStateChanged", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends MediaControllerCompat.Callback {
        public c() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(@Nullable MediaMetadataCompat metadata) {
            StringBuilder sb = new StringBuilder();
            sb.append("onMetadataChanged :");
            ActivityVoiceBookBinding activityVoiceBookBinding = null;
            sb.append(metadata != null ? metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID) : null);
            sb.toString();
            if ((metadata != null ? metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID) : null) != null) {
                MediaDescriptionCompat description = metadata.getDescription();
                if (description != null) {
                    VoiceBookActivity.this.p5(description);
                    return;
                }
                return;
            }
            rr3 rr3Var = VoiceBookActivity.this.f;
            if (rr3Var != null) {
                rr3Var.dismiss();
            }
            ActivityVoiceBookBinding activityVoiceBookBinding2 = VoiceBookActivity.this.a;
            if (activityVoiceBookBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceBookBinding = activityVoiceBookBinding2;
            }
            activityVoiceBookBinding.c.setVisibility(8);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPlaybackStateChanged(@org.jetbrains.annotations.Nullable android.support.v4.media.session.PlaybackStateCompat r8) {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onPlaybackStateChanged :"
                r0.append(r1)
                r1 = 0
                r2 = 3
                r3 = 6
                r4 = 0
                r5 = 1
                if (r8 == 0) goto L26
                int r6 = r8.getState()
                if (r6 == r3) goto L20
                int r6 = r8.getState()
                if (r6 != r2) goto L1e
                goto L20
            L1e:
                r6 = 0
                goto L21
            L20:
                r6 = 1
            L21:
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                goto L27
            L26:
                r6 = r1
            L27:
                r0.append(r6)
                r6 = 32
                r0.append(r6)
                r0.toString()
                com.wear.ui.discover.voicebook.VoiceBookActivity r0 = com.wear.ui.discover.voicebook.VoiceBookActivity.this
                com.wear.ui.discover.voicebook.VoiceBookActivity.w4(r0)
                com.wear.ui.discover.voicebook.VoiceBookActivity r0 = com.wear.ui.discover.voicebook.VoiceBookActivity.this
                com.wear.databinding.ActivityVoiceBookBinding r0 = com.wear.ui.discover.voicebook.VoiceBookActivity.u4(r0)
                if (r0 != 0) goto L45
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                goto L46
            L45:
                r1 = r0
            L46:
                android.widget.ImageView r0 = r1.f
                if (r8 == 0) goto L5e
                int r1 = r8.getState()
                if (r1 == r3) goto L59
                int r1 = r8.getState()
                if (r1 != r2) goto L57
                goto L59
            L57:
                r1 = 0
                goto L5a
            L59:
                r1 = 1
            L5a:
                if (r1 != r5) goto L5e
                r1 = 1
                goto L5f
            L5e:
                r1 = 0
            L5f:
                if (r1 == 0) goto L65
                r1 = 2131232603(0x7f08075b, float:1.808132E38)
                goto L68
            L65:
                r1 = 2131232604(0x7f08075c, float:1.8081322E38)
            L68:
                r0.setImageResource(r1)
                if (r8 == 0) goto L80
                int r0 = r8.getState()
                if (r0 == r3) goto L7c
                int r8 = r8.getState()
                if (r8 != r2) goto L7a
                goto L7c
            L7a:
                r8 = 0
                goto L7d
            L7c:
                r8 = 1
            L7d:
                if (r8 != r5) goto L80
                r4 = 1
            L80:
                if (r4 == 0) goto L85
                dc.qf3.C()
            L85:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicebook.VoiceBookActivity.c.onPlaybackStateChanged(android.support.v4.media.session.PlaybackStateCompat):void");
        }
    }

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/voicebook/VoiceBookActivity$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 14) {
                MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(VoiceBookActivity.this);
                long position = mediaController.getPlaybackState().getPosition();
                Intrinsics.checkNotNullExpressionValue(mediaController.getMetadata(), "mediaController.metadata");
                float f = (position * 100.0f) / r6.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                if (!Float.isNaN(f)) {
                    ActivityVoiceBookBinding activityVoiceBookBinding = VoiceBookActivity.this.a;
                    if (activityVoiceBookBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceBookBinding = null;
                    }
                    activityVoiceBookBinding.m.setProgress(MathKt__MathJVMKt.roundToInt(f));
                }
                sendEmptyMessageDelayed(14, 200L);
            }
        }
    }

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/voicebook/VoiceBookActivity$onCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", PSOProgramService.VS_Key, "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v) {
            if (MyApplication.Z) {
                VoiceBookActivity.this.r5(R.string.common_login_first);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("story_chatgpt", 1);
            pj3.g(VoiceBookActivity.this, ChatGPTActivity.class, bundle);
        }
    }

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "mediaId", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function2<View, String, Unit> {
        public f() {
            super(2);
        }

        public final void a(@NotNull View view, @NotNull String mediaId) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(mediaId, "mediaId");
            VoiceBookActivity.this.C4(mediaId);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
            a(view, str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceBookActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "mediaId", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function2<View, String, Unit> {
        public g() {
            super(2);
        }

        public final void a(@NotNull View view, @NotNull String mediaId) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(mediaId, "mediaId");
            VoiceBookActivity.this.C4(mediaId);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
            a(view, str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.$extrasProducer = function0;
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            Function0 function0 = this.$extrasProducer;
            if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                return creationExtras;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_viewModels.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    public VoiceBookActivity() {
        final TagListAdapter tagListAdapter = new TagListAdapter();
        tagListAdapter.E0(new br() { // from class: dc.uy2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoiceBookActivity.t5(tagListAdapter, this, baseQuickAdapter, view, i2);
            }
        });
        this.g = tagListAdapter;
        this.h = new d(Looper.getMainLooper());
        final AudioBookListAdapter audioBookListAdapter = new AudioBookListAdapter();
        audioBookListAdapter.n(R.id.iv_audio_book_play);
        audioBookListAdapter.E0(new br() { // from class: dc.wy2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoiceBookActivity.z4(this.a, audioBookListAdapter, baseQuickAdapter, view, i2);
            }
        });
        audioBookListAdapter.A0(new zq() { // from class: dc.fz2
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoiceBookActivity.A4(audioBookListAdapter, this, baseQuickAdapter, view, i2);
            }
        });
        audioBookListAdapter.N0(new a());
        this.i = audioBookListAdapter;
        this.j = new b();
        this.k = new c();
    }

    public static final void A4(AudioBookListAdapter this_apply, VoiceBookActivity this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        String mediaId = this_apply.K().get(i2).getId();
        Intrinsics.checkNotNullExpressionValue(mediaId, "mediaId");
        this$0.C4(mediaId);
    }

    public static final void F4(VoiceBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void G4(VoiceBookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    public static final void b5(VoiceBookActivity this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g.x0(list);
    }

    public static final void c5(VoiceBookActivity this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudioBookListAdapter audioBookListAdapter = this$0.i;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        audioBookListAdapter.O0(CollectionsKt___CollectionsKt.toMutableList((Collection) it));
        this$0.i.x0(it);
    }

    public static final void d5(VoiceBookActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i.getFilter().filter(str);
        ActivityVoiceBookBinding activityVoiceBookBinding = this$0.a;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        final SmartRefreshLayout smartRefreshLayout = activityVoiceBookBinding.n;
        smartRefreshLayout.l();
        smartRefreshLayout.postDelayed(new Runnable() { // from class: dc.ty2
            @Override // java.lang.Runnable
            public final void run() {
                VoiceBookActivity.e5(smartRefreshLayout);
            }
        }, 500L);
    }

    public static final void e5(SmartRefreshLayout this_run) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.q();
    }

    public static final void f5(VoiceBookActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            ActivityVoiceBookBinding activityVoiceBookBinding = this$0.a;
            if (activityVoiceBookBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceBookBinding = null;
            }
            activityVoiceBookBinding.i.setVisibility(8);
        }
    }

    public static final void g5(VoiceBookActivity this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue()) {
            return;
        }
        ActivityVoiceBookBinding activityVoiceBookBinding = this$0.a;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        activityVoiceBookBinding.h.setVisibility(0);
    }

    public static final void h5(VoiceBookActivity this$0, View view) {
        MediaControllerCompat mediaController;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        if (!y12.c.a().s(y12.c.TYPE_VOICE_BOOK) || (mediaController = MediaControllerCompat.getMediaController(this$0)) == null) {
            return;
        }
        PlaybackStateCompat playbackState = mediaController.getPlaybackState();
        Intrinsics.checkNotNullExpressionValue(playbackState, "playbackState");
        if (playbackState.getState() == 6 || playbackState.getState() == 3) {
            mediaController.getTransportControls().pause();
        } else {
            mediaController.getTransportControls().play();
        }
        k22 k22Var = this$0.e;
        if (k22Var != null) {
            k22Var.h(new Event(c22.EVENT_START, null, 2, null));
        }
    }

    public static final void i5(VoiceBookActivity this$0, View view) {
        rr3 rr3Var;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rr3 rr3Var2 = new rr3(this$0);
        rr3Var2.x(this$0.new f());
        this$0.f = rr3Var2;
        boolean z = false;
        if (rr3Var2 != null && !rr3Var2.isShowing()) {
            z = true;
        }
        if (!z || (rr3Var = this$0.f) == null) {
            return;
        }
        rr3Var.show();
    }

    public static final void j5(SmartRefreshLayout this_run, ae1 it) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(it, "it");
        this_run.s(300);
    }

    public static final void k5(final SmartRefreshLayout this_run, ae1 it) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(it, "it");
        this_run.postDelayed(new Runnable() { // from class: dc.bz2
            @Override // java.lang.Runnable
            public final void run() {
                VoiceBookActivity.l5(this_run);
            }
        }, 300L);
    }

    public static final void l5(SmartRefreshLayout this_run) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.q();
    }

    public static final void s5(VoiceBookActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.t(this$0, LoginActivity.class, 2);
    }

    public static final void t5(TagListAdapter this_apply, VoiceBookActivity this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this_apply.K().get(i2).setSelect(!r3.getSelect());
        this_apply.notifyItemChanged(i2);
        this$0.D4().e(this_apply.K());
    }

    public static final void z4(VoiceBookActivity this$0, AudioBookListAdapter this_apply, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AudioBookDialog audioBookDialog = this$0.d;
        if (audioBookDialog != null) {
            boolean z = false;
            if (audioBookDialog != null && !audioBookDialog.isShowing()) {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        this$0.q5(this_apply.K(), i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B4() {
        /*
            r9 = this;
            android.support.v4.media.session.MediaControllerCompat r0 = android.support.v4.media.session.MediaControllerCompat.getMediaController(r9)
            if (r0 == 0) goto La6
            android.support.v4.media.MediaMetadataCompat r1 = r0.getMetadata()
            r2 = 2
            r3 = 0
            r4 = 3
            r5 = 6
            java.lang.String r6 = "playbackState"
            r7 = 1
            if (r1 == 0) goto L75
            android.support.v4.media.session.PlaybackStateCompat r1 = r0.getPlaybackState()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            int r8 = r1.getState()
            if (r8 == r5) goto L2f
            int r8 = r1.getState()
            if (r8 == r4) goto L2f
            int r1 = r1.getState()
            if (r1 != r2) goto L2d
            goto L2f
        L2d:
            r1 = 0
            goto L30
        L2f:
            r1 = 1
        L30:
            if (r1 == 0) goto L75
            android.support.v4.media.MediaMetadataCompat r1 = r0.getMetadata()
            android.support.v4.media.MediaDescriptionCompat r1 = r1.getDescription()
            java.lang.String r2 = "metadata.description"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r9.p5(r1)
            r9.Z4()
            com.wear.databinding.ActivityVoiceBookBinding r1 = r9.a
            if (r1 != 0) goto L4f
            java.lang.String r1 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = 0
        L4f:
            android.widget.ImageView r1 = r1.f
            android.support.v4.media.session.PlaybackStateCompat r2 = r0.getPlaybackState()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            int r8 = r2.getState()
            if (r8 == r5) goto L67
            int r2 = r2.getState()
            if (r2 != r4) goto L65
            goto L67
        L65:
            r2 = 0
            goto L68
        L67:
            r2 = 1
        L68:
            if (r2 == 0) goto L6e
            r2 = 2131232603(0x7f08075b, float:1.808132E38)
            goto L71
        L6e:
            r2 = 2131232604(0x7f08075c, float:1.8081322E38)
        L71:
            r1.setImageResource(r2)
            goto L7c
        L75:
            android.support.v4.media.session.MediaControllerCompat$TransportControls r1 = r0.getTransportControls()
            r1.setRepeatMode(r2)
        L7c:
            android.support.v4.media.session.PlaybackStateCompat r1 = r0.getPlaybackState()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            int r2 = r1.getState()
            if (r2 == r5) goto L8f
            int r1 = r1.getState()
            if (r1 != r4) goto L90
        L8f:
            r3 = 1
        L90:
            if (r3 == 0) goto La1
            android.support.v4.media.MediaMetadataCompat r1 = r0.getMetadata()
            android.support.v4.media.session.PlaybackStateCompat r2 = r0.getPlaybackState()
            long r2 = r2.getPosition()
            r9.o5(r1, r7, r2)
        La1:
            com.wear.ui.discover.voicebook.VoiceBookActivity$c r1 = r9.k
            r0.registerCallback(r1)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicebook.VoiceBookActivity.B4():void");
    }

    public final void C4(String str) {
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        if (y12.c.a().s(y12.c.TYPE_VOICE_BOOK)) {
            MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(this);
            PlaybackStateCompat playbackState = mediaController.getPlaybackState();
            Intrinsics.checkNotNullExpressionValue(playbackState, "mediaController.playbackState");
            boolean z = playbackState.getState() == 6 || playbackState.getState() == 3 || playbackState.getState() == 2;
            MediaMetadataCompat metadata = mediaController.getMetadata();
            Intrinsics.checkNotNullExpressionValue(metadata, "mediaController.metadata");
            if (!Intrinsics.areEqual(str, metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID)) || !z) {
                mediaController.getTransportControls().playFromMediaId(str, m5());
            } else if (mediaController.getPlaybackState().getState() == 3) {
                mediaController.getTransportControls().pause();
            } else {
                mediaController.getTransportControls().play();
            }
            k22 k22Var = this.e;
            if (k22Var != null) {
                k22Var.h(new Event(c22.EVENT_START, null, 2, null));
            }
        }
    }

    public final VoiceBookViewModel D4() {
        return (VoiceBookViewModel) this.c.getValue();
    }

    public final void E4() {
        ActivityVoiceBookBinding activityVoiceBookBinding = this.a;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        MyActionBar myActionBar = activityVoiceBookBinding.b;
        myActionBar.setBackAction(new MyActionBar.f() { // from class: dc.cz2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                VoiceBookActivity.F4(this.a, view);
            }
        });
        myActionBar.setToysAction(new MyActionBar.f() { // from class: dc.ez2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                VoiceBookActivity.G4(this.a, view);
            }
        }, true, this);
        myActionBar.n();
        HashMap map = new HashMap();
        map.put("page_name", "erotic audio");
        map.put("referrer", "erotic audio");
        map.put("page_type", "");
        map.put("control_type", "");
        ye3.e("S0007", map);
    }

    public final void H4() {
        ActivityVoiceBookBinding activityVoiceBookBinding = this.a;
        ActivityVoiceBookBinding activityVoiceBookBinding2 = null;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        RecyclerView recyclerView = activityVoiceBookBinding.j;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        ActivityVoiceBookBinding activityVoiceBookBinding3 = this.a;
        if (activityVoiceBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding3 = null;
        }
        activityVoiceBookBinding3.j.setAdapter(this.g);
        ActivityVoiceBookBinding activityVoiceBookBinding4 = this.a;
        if (activityVoiceBookBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding4 = null;
        }
        activityVoiceBookBinding4.k.setLayoutManager(new GridLayoutManager(this, 2));
        ActivityVoiceBookBinding activityVoiceBookBinding5 = this.a;
        if (activityVoiceBookBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceBookBinding2 = activityVoiceBookBinding5;
        }
        activityVoiceBookBinding2.k.setAdapter(this.i);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    @android.annotation.SuppressLint({"NotifyDataSetChanged"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Z4() {
        /*
            r8 = this;
            android.support.v4.media.session.MediaControllerCompat r0 = android.support.v4.media.session.MediaControllerCompat.getMediaController(r8)
            if (r0 == 0) goto L5a
            com.wear.adapter.discover.AudioBookListAdapter r1 = r8.i
            java.util.List r1 = r1.K()
            java.util.Iterator r1 = r1.iterator()
        L10:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L5a
            java.lang.Object r2 = r1.next()
            com.wear.bean.data.AudioBookList r2 = (com.wear.bean.data.AudioBookList) r2
            android.support.v4.media.MediaMetadataCompat r3 = r0.getMetadata()
            java.lang.String r4 = "metadata"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r4 = "android.media.metadata.MEDIA_ID"
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = r2.getId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L55
            android.support.v4.media.session.PlaybackStateCompat r3 = r0.getPlaybackState()
            java.lang.String r6 = "playbackState"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            int r6 = r3.getState()
            r7 = 6
            if (r6 == r7) goto L51
            int r3 = r3.getState()
            r6 = 3
            if (r3 != r6) goto L4f
            goto L51
        L4f:
            r3 = 0
            goto L52
        L51:
            r3 = 1
        L52:
            if (r3 == 0) goto L55
            goto L56
        L55:
            r4 = 0
        L56:
            r2.setPlay(r4)
            goto L10
        L5a:
            com.wear.adapter.discover.AudioBookListAdapter r0 = r8.i
            r0.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicebook.VoiceBookActivity.Z4():void");
    }

    public final void a5() {
        D4().j().observe(this, new Observer() { // from class: dc.yy2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceBookActivity.b5(this.a, (List) obj);
            }
        });
        D4().f().observe(this, new Observer() { // from class: dc.az2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceBookActivity.c5(this.a, (List) obj);
            }
        });
        D4().g().observe(this, new Observer() { // from class: dc.zy2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceBookActivity.d5(this.a, (String) obj);
            }
        });
        D4().h().observe(this, new Observer() { // from class: dc.vy2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceBookActivity.f5(this.a, (Boolean) obj);
            }
        });
        D4().i().observe(this, new Observer() { // from class: dc.xy2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceBookActivity.g5(this.a, (Boolean) obj);
            }
        });
    }

    public final Bundle m5() {
        Bundle bundle = new Bundle();
        List<AudioBookList> listK = this.i.K();
        Intrinsics.checkNotNull(listK, "null cannot be cast to non-null type java.io.Serializable");
        bundle.putSerializable("audio_book_list", (Serializable) listK);
        return bundle;
    }

    public final void n5() {
        HashMap map = new HashMap();
        map.put("page_name", "erotic audio");
        map.put("page_type", "");
        map.put("control_type", "");
        ye3.e("S0008", map);
    }

    public final void o5(MediaMetadataCompat mediaMetadataCompat, int i2, long j2) {
        String string;
        String string2;
        HashMap map = new HashMap();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j2);
        map.put("page_name", "erotic audio");
        map.put("event_id", "erotic_audio_play_location");
        String str = "";
        if (mediaMetadataCompat == null || (string = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID)) == null) {
            string = "";
        }
        map.put("element_id", string);
        map.put("element_type", "");
        map.put("element_content", Integer.valueOf(i2));
        if (mediaMetadataCompat != null && (string2 = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_TITLE)) != null) {
            str = string2;
        }
        map.put("element_name", str);
        map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(seconds));
        map.put("toys", pc1.a.m());
        ye3.e("S0009", map);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(this);
        if (mediaController != null) {
            PlaybackStateCompat playbackState = mediaController.getPlaybackState();
            Intrinsics.checkNotNullExpressionValue(playbackState, "playbackState");
            if (playbackState.getState() == 6 || playbackState.getState() == 3) {
                if (checkFloatWindowsPermission()) {
                    finish();
                }
            } else {
                k22 k22Var = this.e;
                if (k22Var != null) {
                    k22Var.h(new Event(c22.EVENT_STOP, null, 2, null));
                }
                finish();
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVoiceBookBinding activityVoiceBookBindingC = ActivityVoiceBookBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityVoiceBookBindingC, "inflate(layoutInflater)");
        this.a = activityVoiceBookBindingC;
        if (activityVoiceBookBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBindingC = null;
        }
        setContentView(activityVoiceBookBindingC.getRoot());
        E4();
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(this, new ComponentName(this, (Class<?>) MediaPlaybackService.class), this.j, null);
        this.b = mediaBrowserCompat;
        if (mediaBrowserCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaBrowser");
            mediaBrowserCompat = null;
        }
        mediaBrowserCompat.connect();
        a5();
        H4();
        ActivityVoiceBookBinding activityVoiceBookBinding = this.a;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        final SmartRefreshLayout smartRefreshLayout = activityVoiceBookBinding.n;
        smartRefreshLayout.G(new ne1() { // from class: dc.jz2
            @Override // dc.ne1
            public final void b(ae1 ae1Var) {
                VoiceBookActivity.j5(smartRefreshLayout, ae1Var);
            }
        });
        smartRefreshLayout.F(new le1() { // from class: dc.gz2
            @Override // dc.le1
            public final void f(ae1 ae1Var) {
                VoiceBookActivity.k5(smartRefreshLayout, ae1Var);
            }
        });
        D4().d(this);
        D4().c(this);
        ActivityVoiceBookBinding activityVoiceBookBinding2 = this.a;
        if (activityVoiceBookBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding2 = null;
        }
        activityVoiceBookBinding2.g.setOnClickListener(new e());
        ActivityVoiceBookBinding activityVoiceBookBinding3 = this.a;
        if (activityVoiceBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding3 = null;
        }
        activityVoiceBookBinding3.f.setOnClickListener(new View.OnClickListener() { // from class: dc.hz2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceBookActivity.h5(this.a, view);
            }
        });
        ActivityVoiceBookBinding activityVoiceBookBinding4 = this.a;
        if (activityVoiceBookBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding4 = null;
        }
        activityVoiceBookBinding4.d.setOnClickListener(new View.OnClickListener() { // from class: dc.iz2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceBookActivity.i5(this.a, view);
            }
        });
        int iA = getResources().getDisplayMetrics().widthPixels - ce3.a(this, 32.0f);
        ActivityVoiceBookBinding activityVoiceBookBinding5 = this.a;
        if (activityVoiceBookBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding5 = null;
        }
        activityVoiceBookBinding5.e.getLayoutParams().width = iA;
        ActivityVoiceBookBinding activityVoiceBookBinding6 = this.a;
        if (activityVoiceBookBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding6 = null;
        }
        activityVoiceBookBinding6.e.getLayoutParams().height = MathKt__MathJVMKt.roundToInt(iA / 3.76f);
        x12 x12VarI = y12.c.a().i(y12.c.TYPE_VOICE_BOOK);
        this.e = x12VarI instanceof k22 ? (k22) x12VarI : null;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n5();
        ActivityVoiceBookBinding activityVoiceBookBinding = this.a;
        MediaBrowserCompat mediaBrowserCompat = null;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        activityVoiceBookBinding.b.s();
        MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(this);
        if (mediaController != null) {
            PlaybackStateCompat playbackState = mediaController.getPlaybackState();
            Intrinsics.checkNotNullExpressionValue(playbackState, "playbackState");
            if (playbackState.getState() == 6 || playbackState.getState() == 3) {
                o5(mediaController.getMetadata(), 2, mediaController.getPlaybackState().getPosition());
            }
            mediaController.unregisterCallback(this.k);
        }
        MediaBrowserCompat mediaBrowserCompat2 = this.b;
        if (mediaBrowserCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaBrowser");
        } else {
            mediaBrowserCompat = mediaBrowserCompat2;
        }
        mediaBrowserCompat.disconnect();
        rr3 rr3Var = this.f;
        if (rr3Var != null) {
            rr3Var.dismiss();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ActivityVoiceBookBinding activityVoiceBookBinding = this.a;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        activityVoiceBookBinding.b.setToy(pc1.a.P());
        setVolumeControlStream(3);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.h.removeMessages(14);
    }

    public final boolean p5(MediaDescriptionCompat mediaDescriptionCompat) {
        ActivityVoiceBookBinding activityVoiceBookBinding = this.a;
        ActivityVoiceBookBinding activityVoiceBookBinding2 = null;
        if (activityVoiceBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding = null;
        }
        activityVoiceBookBinding.c.setVisibility(0);
        qf<Drawable> qfVarR = kf.z(this).r(mediaDescriptionCompat.getIconUri());
        ActivityVoiceBookBinding activityVoiceBookBinding3 = this.a;
        if (activityVoiceBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding3 = null;
        }
        qfVarR.A0(activityVoiceBookBinding3.l);
        ActivityVoiceBookBinding activityVoiceBookBinding4 = this.a;
        if (activityVoiceBookBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceBookBinding4 = null;
        }
        activityVoiceBookBinding4.o.setText(mediaDescriptionCompat.getTitle());
        ActivityVoiceBookBinding activityVoiceBookBinding5 = this.a;
        if (activityVoiceBookBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceBookBinding2 = activityVoiceBookBinding5;
        }
        activityVoiceBookBinding2.n.l();
        return this.h.sendEmptyMessage(14);
    }

    public final void q5(List<AudioBookList> list, int i2) {
        AudioBookDialog audioBookDialog = new AudioBookDialog(this, list, i2);
        audioBookDialog.g(new g());
        this.d = audioBookDialog;
        if (audioBookDialog != null) {
            audioBookDialog.show();
        }
    }

    public final void r5(int i2) {
        cs3.c(this, ah4.e(i2), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.dz2
            @Override // dc.is3.d
            public final void doConfirm() {
                VoiceBookActivity.s5(this.a);
            }
        }).show();
    }
}
