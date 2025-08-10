package dc;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.databinding.DialogAudioBookBottomControlBinding;
import com.wear.ui.discover.voicebook.VoiceBookActivity;
import com.wear.util.WearUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookBottomControlDialog.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u000201B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0012\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0017H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/wear/widget/dialog/AudioBookBottomControlDialog;", "Landroid/app/Dialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/wear/ui/discover/voicebook/VoiceBookActivity;", "(Lcom/wear/ui/discover/voicebook/VoiceBookActivity;)V", "binding", "Lcom/wear/databinding/DialogAudioBookBottomControlBinding;", "controllerCallback", "com/wear/widget/dialog/AudioBookBottomControlDialog$controllerCallback$1", "Lcom/wear/widget/dialog/AudioBookBottomControlDialog$controllerCallback$1;", "handler", "com/wear/widget/dialog/AudioBookBottomControlDialog$handler$1", "Lcom/wear/widget/dialog/AudioBookBottomControlDialog$handler$1;", "mediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "getMediaController", "()Landroid/support/v4/media/session/MediaControllerCompat;", "mediaController$delegate", "Lkotlin/Lazy;", "onPlayClick", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnPlayClick", "()Lkotlin/jvm/functions/Function2;", "setOnPlayClick", "(Lkotlin/jvm/functions/Function2;)V", "reReplayModels", "", "Lcom/wear/widget/dialog/AudioBookBottomControlDialog$PlayModel;", "dismiss", "formatDate", "time", "", "initControlState", "initDialog", "observableEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "playModelEvent", "showUI", TtmlNode.TAG_METADATA, "Landroid/support/v4/media/MediaMetadataCompat;", "updateSkipStatus", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "Companion", "PlayModel", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class rr3 extends Dialog {

    @NotNull
    public final VoiceBookActivity a;

    @Nullable
    public Function2<? super View, ? super String, Unit> b;
    public DialogAudioBookBottomControlBinding c;

    @NotNull
    public final Lazy d;

    @NotNull
    public final List<a> e;

    @NotNull
    public final d f;

    @NotNull
    public final c g;

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wear/widget/dialog/AudioBookBottomControlDialog$PlayModel;", "", "(Ljava/lang/String;I)V", "SHUFFLE_MODE_ALL", "REPEAT_MODE_ONE", "REPEAT_MODE_ALL", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum a {
        SHUFFLE_MODE_ALL,
        REPEAT_MODE_ONE,
        REPEAT_MODE_ALL
    }

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.REPEAT_MODE_ALL.ordinal()] = 1;
            iArr[a.REPEAT_MODE_ONE.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"com/wear/widget/dialog/AudioBookBottomControlDialog$controllerCallback$1", "Landroid/support/v4/media/session/MediaControllerCompat$Callback;", "onMetadataChanged", "", TtmlNode.TAG_METADATA, "Landroid/support/v4/media/MediaMetadataCompat;", "onPlaybackStateChanged", "state", "Landroid/support/v4/media/session/PlaybackStateCompat;", "onRepeatModeChanged", "repeatMode", "", "onShuffleModeChanged", "shuffleMode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends MediaControllerCompat.Callback {
        public c() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(@Nullable MediaMetadataCompat metadata) {
            if (metadata != null) {
                rr3.this.y(metadata);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(@Nullable PlaybackStateCompat state) {
            boolean z = false;
            if (state != null ? Intrinsics.areEqual(state.getPlaybackState(), (Object) 6) : false) {
                rr3.this.f.removeMessages(15);
            } else {
                if (state != null ? Intrinsics.areEqual(state.getPlaybackState(), (Object) 3) : false) {
                    rr3.this.f.sendEmptyMessage(15);
                }
            }
            if (state != null) {
                if (state.getState() == 6 || state.getState() == 3) {
                    z = true;
                }
            }
            DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = null;
            if (z) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = rr3.this.c;
                if (dialogAudioBookBottomControlBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    dialogAudioBookBottomControlBinding = dialogAudioBookBottomControlBinding2;
                }
                dialogAudioBookBottomControlBinding.d.setImageResource(R.drawable.pattern_play_pause);
                qf3.C();
            } else {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = rr3.this.c;
                if (dialogAudioBookBottomControlBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    dialogAudioBookBottomControlBinding = dialogAudioBookBottomControlBinding3;
                }
                dialogAudioBookBottomControlBinding.d.setImageResource(R.drawable.pattern_play_play);
            }
            rr3.this.z(state);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onRepeatModeChanged(int repeatMode) {
            DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = null;
            if (repeatMode == 1) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = rr3.this.c;
                if (dialogAudioBookBottomControlBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    dialogAudioBookBottomControlBinding = dialogAudioBookBottomControlBinding2;
                }
                dialogAudioBookBottomControlBinding.f.setImageResource(R.drawable.audio_book_play_model_one);
                return;
            }
            if (repeatMode != 2) {
                return;
            }
            DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = rr3.this.c;
            if (dialogAudioBookBottomControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogAudioBookBottomControlBinding = dialogAudioBookBottomControlBinding3;
            }
            dialogAudioBookBottomControlBinding.f.setImageResource(R.drawable.audio_book_play_model_all);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onShuffleModeChanged(int shuffleMode) {
            if (shuffleMode == 1) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = rr3.this.c;
                if (dialogAudioBookBottomControlBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding = null;
                }
                dialogAudioBookBottomControlBinding.f.setImageResource(R.drawable.audio_book_play_model_none);
            }
        }
    }

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/AudioBookBottomControlDialog$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            PlaybackStateCompat playbackState;
            MediaMetadataCompat metadata;
            PlaybackStateCompat playbackState2;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 15) {
                MediaControllerCompat mediaControllerCompatI = rr3.this.i();
                long j = 0;
                long position = (mediaControllerCompatI == null || (playbackState2 = mediaControllerCompatI.getPlaybackState()) == null) ? 0L : playbackState2.getPosition() / 1000;
                MediaControllerCompat mediaControllerCompatI2 = rr3.this.i();
                if (mediaControllerCompatI2 != null && (metadata = mediaControllerCompatI2.getMetadata()) != null) {
                    j = metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION) / 1000;
                }
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = rr3.this.c;
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = null;
                if (dialogAudioBookBottomControlBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding = null;
                }
                dialogAudioBookBottomControlBinding.l.setText(SignatureImpl.SEP + rr3.this.h(j - position));
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = rr3.this.c;
                if (dialogAudioBookBottomControlBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding3 = null;
                }
                dialogAudioBookBottomControlBinding3.k.setText(rr3.this.h(position));
                MediaControllerCompat mediaControllerCompatI3 = rr3.this.i();
                if (mediaControllerCompatI3 != null && (playbackState = mediaControllerCompatI3.getPlaybackState()) != null) {
                    float position2 = ((playbackState.getState() == 3 ? (long) (playbackState.getPosition() + ((SystemClock.elapsedRealtime() - playbackState.getLastPositionUpdateTime()) * playbackState.getPlaybackSpeed())) : playbackState.getPosition()) * 1.0f) / j;
                    DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding4 = rr3.this.c;
                    if (dialogAudioBookBottomControlBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        dialogAudioBookBottomControlBinding2 = dialogAudioBookBottomControlBinding4;
                    }
                    dialogAudioBookBottomControlBinding2.h.setProgress((int) position2);
                }
                sendEmptyMessageDelayed(15, 200L);
            }
        }
    }

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/support/v4/media/session/MediaControllerCompat;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<MediaControllerCompat> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaControllerCompat invoke() {
            return MediaControllerCompat.getMediaController(rr3.this.a);
        }
    }

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/wear/widget/dialog/AudioBookBottomControlDialog$observableEvent$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements SeekBar.OnSeekBarChangeListener {
        public f() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser) {
            if (!fromUser) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            long j;
            MediaControllerCompat.TransportControls transportControls;
            MediaMetadataCompat metadata;
            if (seekBar != null) {
                rr3 rr3Var = rr3.this;
                MediaControllerCompat mediaControllerCompatI = rr3Var.i();
                if (mediaControllerCompatI == null || (metadata = mediaControllerCompatI.getMetadata()) == null) {
                    j = 0;
                } else {
                    Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
                    j = metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                }
                long progress = (long) ((seekBar.getProgress() / 1000.0f) * j);
                MediaControllerCompat mediaControllerCompatI2 = rr3Var.i();
                if (mediaControllerCompatI2 == null || (transportControls = mediaControllerCompatI2.getTransportControls()) == null) {
                    return;
                }
                transportControls.seekTo(progress);
            }
        }
    }

    /* compiled from: AudioBookBottomControlDialog.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/wear/widget/dialog/AudioBookBottomControlDialog$observableEvent$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements SeekBar.OnSeekBarChangeListener {
        public g() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser) {
            if (!fromUser) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            MediaControllerCompat.TransportControls transportControls;
            if (seekBar != null) {
                rr3 rr3Var = rr3.this;
                eg3.i(seekBar.getContext(), "sensitivity_seek", Integer.valueOf(seekBar.getProgress()));
                MediaControllerCompat mediaControllerCompatI = rr3Var.i();
                if (mediaControllerCompatI == null || (transportControls = mediaControllerCompatI.getTransportControls()) == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("sensitivity", seekBar.getProgress());
                Unit unit = Unit.INSTANCE;
                transportControls.sendCustomAction("com.lovens.wear.SENSITIVITY", bundle);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rr3(@NotNull VoiceBookActivity activity) {
        super(activity, R.style.MaterialDialogSheet);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.d = LazyKt__LazyJVMKt.lazy(new e());
        this.e = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{a.SHUFFLE_MODE_ALL, a.REPEAT_MODE_ONE, a.REPEAT_MODE_ALL});
        this.f = new d(Looper.getMainLooper());
        this.g = new c();
    }

    public static final void r(rr3 this$0, View view) {
        MediaControllerCompat mediaControllerCompatI;
        MediaControllerCompat.TransportControls transportControls;
        PlaybackStateCompat playbackState;
        MediaControllerCompat.TransportControls transportControls2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaControllerCompat mediaControllerCompatI2 = this$0.i();
        if (mediaControllerCompatI2 != null && (transportControls2 = mediaControllerCompatI2.getTransportControls()) != null) {
            transportControls2.skipToNext();
        }
        MediaControllerCompat mediaControllerCompatI3 = this$0.i();
        boolean z = false;
        if (mediaControllerCompatI3 != null && (playbackState = mediaControllerCompatI3.getPlaybackState()) != null && playbackState.getState() == 2) {
            z = true;
        }
        if (!z || (mediaControllerCompatI = this$0.i()) == null || (transportControls = mediaControllerCompatI.getTransportControls()) == null) {
            return;
        }
        transportControls.play();
    }

    public static final void s(rr3 this$0, View view) {
        MediaControllerCompat mediaControllerCompatI;
        MediaControllerCompat.TransportControls transportControls;
        PlaybackStateCompat playbackState;
        MediaControllerCompat.TransportControls transportControls2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaControllerCompat mediaControllerCompatI2 = this$0.i();
        if (mediaControllerCompatI2 != null && (transportControls2 = mediaControllerCompatI2.getTransportControls()) != null) {
            transportControls2.skipToPrevious();
        }
        MediaControllerCompat mediaControllerCompatI3 = this$0.i();
        boolean z = false;
        if (mediaControllerCompatI3 != null && (playbackState = mediaControllerCompatI3.getPlaybackState()) != null && playbackState.getState() == 2) {
            z = true;
        }
        if (!z || (mediaControllerCompatI = this$0.i()) == null || (transportControls = mediaControllerCompatI.getTransportControls()) == null) {
            return;
        }
        transportControls.play();
    }

    public static final void t(rr3 this$0, View view) {
        MediaMetadataCompat metadata;
        String string;
        Function2<? super View, ? super String, Unit> function2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaControllerCompat mediaControllerCompatI = this$0.i();
        if (mediaControllerCompatI == null || (metadata = mediaControllerCompatI.getMetadata()) == null || (string = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID)) == null || (function2 = this$0.b) == null) {
            return;
        }
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = this$0.c;
        if (dialogAudioBookBottomControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding = null;
        }
        ImageButton imageButton = dialogAudioBookBottomControlBinding.d;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.ivAudioBookBottomPlay");
        function2.invoke(imageButton, string);
    }

    public static final void u(rr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
    }

    public static final void v(rr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.f.removeMessages(15);
        MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(this.a);
        if (mediaController != null) {
            mediaController.unregisterCallback(this.g);
        }
    }

    public final String h(long j) {
        StringBuilder sb = new StringBuilder();
        if (j == 0) {
            sb.append("00:00");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.append(\"00:00\").toString()");
            return string;
        }
        long j2 = 60;
        long j3 = j / j2;
        if (j3 < 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            sb2.append(j3);
            sb.append(sb2.toString());
        } else {
            sb.append(j3);
        }
        sb.append(" : ");
        long j4 = j % j2;
        if (j4 < 10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('0');
            sb3.append(j4);
            sb.append(sb3.toString());
        } else {
            sb.append(j4);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "builder.toString()");
        return string2;
    }

    public final MediaControllerCompat i() {
        return (MediaControllerCompat) this.d.getValue();
    }

    public final void j() {
        MediaControllerCompat mediaControllerCompatI = i();
        if (mediaControllerCompatI != null) {
            MediaMetadataCompat metadata = mediaControllerCompatI.getMetadata();
            Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
            y(metadata);
            PlaybackStateCompat playbackState = mediaControllerCompatI.getPlaybackState();
            Intrinsics.checkNotNullExpressionValue(playbackState, "playbackState");
            DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = null;
            if (playbackState.getState() == 6 || playbackState.getState() == 3) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = this.c;
                if (dialogAudioBookBottomControlBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding2 = null;
                }
                dialogAudioBookBottomControlBinding2.d.setImageResource(R.drawable.pattern_play_pause);
            } else {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = this.c;
                if (dialogAudioBookBottomControlBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding3 = null;
                }
                dialogAudioBookBottomControlBinding3.d.setImageResource(R.drawable.pattern_play_play);
            }
            int repeatMode = mediaControllerCompatI.getRepeatMode();
            if (repeatMode == 1) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding4 = this.c;
                if (dialogAudioBookBottomControlBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding4 = null;
                }
                dialogAudioBookBottomControlBinding4.f.setImageResource(R.drawable.audio_book_play_model_one);
            } else if (repeatMode == 2) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding5 = this.c;
                if (dialogAudioBookBottomControlBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogAudioBookBottomControlBinding5 = null;
                }
                dialogAudioBookBottomControlBinding5.f.setImageResource(R.drawable.audio_book_play_model_all);
            }
            if (mediaControllerCompatI.getShuffleMode() == 1) {
                DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding6 = this.c;
                if (dialogAudioBookBottomControlBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    dialogAudioBookBottomControlBinding = dialogAudioBookBottomControlBinding6;
                }
                dialogAudioBookBottomControlBinding.f.setImageResource(R.drawable.audio_book_play_model_none);
            }
            z(mediaControllerCompatI.getPlaybackState());
            mediaControllerCompatI.registerCallback(this.g);
            this.f.sendEmptyMessage(15);
        }
    }

    public final void k() {
        WindowManager.LayoutParams attributes;
        WearUtils.q2(this);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -2;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.getDecorView().setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MediaControllerCompat.TransportControls transportControls;
        super.onCreate(savedInstanceState);
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBindingC = DialogAudioBookBottomControlBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogAudioBookBottomControlBindingC, "inflate(layoutInflater)");
        this.c = dialogAudioBookBottomControlBindingC;
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = null;
        if (dialogAudioBookBottomControlBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBindingC = null;
        }
        setContentView(dialogAudioBookBottomControlBindingC.getRoot());
        k();
        j();
        q();
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = this.c;
        if (dialogAudioBookBottomControlBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding2 = null;
        }
        dialogAudioBookBottomControlBinding2.b.setOnClickListener(new View.OnClickListener() { // from class: dc.op3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rr3.r(this.a, view);
            }
        });
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = this.c;
        if (dialogAudioBookBottomControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding3 = null;
        }
        dialogAudioBookBottomControlBinding3.c.setOnClickListener(new View.OnClickListener() { // from class: dc.lp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rr3.s(this.a, view);
            }
        });
        int iF = eg3.f(getContext(), "sensitivity_seek", 75);
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding4 = this.c;
        if (dialogAudioBookBottomControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding4 = null;
        }
        dialogAudioBookBottomControlBinding4.i.setProgress(iF);
        MediaControllerCompat mediaControllerCompatI = i();
        if (mediaControllerCompatI != null && (transportControls = mediaControllerCompatI.getTransportControls()) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("sensitivity", iF);
            Unit unit = Unit.INSTANCE;
            transportControls.sendCustomAction("com.lovens.wear.SENSITIVITY", bundle);
        }
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding5 = this.c;
        if (dialogAudioBookBottomControlBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding5 = null;
        }
        dialogAudioBookBottomControlBinding5.d.setOnClickListener(new View.OnClickListener() { // from class: dc.kp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rr3.t(this.a, view);
            }
        });
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding6 = this.c;
        if (dialogAudioBookBottomControlBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding6 = null;
        }
        dialogAudioBookBottomControlBinding6.f.setOnClickListener(new View.OnClickListener() { // from class: dc.mp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rr3.u(this.a, view);
            }
        });
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding7 = this.c;
        if (dialogAudioBookBottomControlBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogAudioBookBottomControlBinding = dialogAudioBookBottomControlBinding7;
        }
        dialogAudioBookBottomControlBinding.e.setOnClickListener(new View.OnClickListener() { // from class: dc.np3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rr3.v(this.a, view);
            }
        });
    }

    public final void q() {
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = this.c;
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = null;
        if (dialogAudioBookBottomControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding = null;
        }
        dialogAudioBookBottomControlBinding.h.setOnSeekBarChangeListener(new f());
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = this.c;
        if (dialogAudioBookBottomControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogAudioBookBottomControlBinding2 = dialogAudioBookBottomControlBinding3;
        }
        dialogAudioBookBottomControlBinding2.i.setOnSeekBarChangeListener(new g());
    }

    public final void w() {
        int iIndexOf;
        MediaControllerCompat mediaControllerCompatI = i();
        if (mediaControllerCompatI != null) {
            int repeatMode = mediaControllerCompatI.getRepeatMode();
            if (mediaControllerCompatI.getShuffleMode() != 0) {
                iIndexOf = this.e.indexOf(a.SHUFFLE_MODE_ALL);
            } else {
                iIndexOf = this.e.indexOf(repeatMode == 1 ? a.REPEAT_MODE_ONE : a.REPEAT_MODE_ALL);
            }
            int i = (iIndexOf + 1) % 3;
            if (i == 0) {
                mediaControllerCompatI.getTransportControls().setShuffleMode(1);
                return;
            }
            int i2 = b.a[this.e.get(i).ordinal()];
            if (i2 == 1) {
                mediaControllerCompatI.getTransportControls().setRepeatMode(2);
            } else if (i2 == 2) {
                mediaControllerCompatI.getTransportControls().setRepeatMode(1);
            }
            mediaControllerCompatI.getTransportControls().setShuffleMode(0);
        }
    }

    public final void x(@Nullable Function2<? super View, ? super String, Unit> function2) {
        this.b = function2;
    }

    public final void y(MediaMetadataCompat mediaMetadataCompat) {
        qf<Drawable> qfVarR = kf.z(this.a).r(mediaMetadataCompat.getDescription().getIconUri());
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding = this.c;
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding2 = null;
        if (dialogAudioBookBottomControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAudioBookBottomControlBinding = null;
        }
        qfVarR.A0(dialogAudioBookBottomControlBinding.g);
        DialogAudioBookBottomControlBinding dialogAudioBookBottomControlBinding3 = this.c;
        if (dialogAudioBookBottomControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogAudioBookBottomControlBinding2 = dialogAudioBookBottomControlBinding3;
        }
        dialogAudioBookBottomControlBinding2.j.setText(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z(android.support.v4.media.session.PlaybackStateCompat r12) {
        /*
            r11 = this;
            r0 = 0
            r2 = 1
            r3 = 0
            if (r12 == 0) goto L18
            long r4 = r12.getActions()
            r6 = 16
            long r4 = r4 & r6
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 == 0) goto L13
            r4 = 1
            goto L14
        L13:
            r4 = 0
        L14:
            if (r4 != r2) goto L18
            r4 = 1
            goto L19
        L18:
            r4 = 0
        L19:
            r5 = 0
            java.lang.String r6 = "binding"
            if (r4 == 0) goto L2f
            com.wear.databinding.DialogAudioBookBottomControlBinding r4 = r11.c
            if (r4 != 0) goto L26
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r4 = r5
        L26:
            android.widget.ImageButton r4 = r4.c
            r7 = 2131232845(0x7f08084d, float:1.808181E38)
            r4.setImageResource(r7)
            goto L3f
        L2f:
            com.wear.databinding.DialogAudioBookBottomControlBinding r4 = r11.c
            if (r4 != 0) goto L37
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r4 = r5
        L37:
            android.widget.ImageButton r4 = r4.c
            r7 = 2131232617(0x7f080769, float:1.8081348E38)
            r4.setImageResource(r7)
        L3f:
            if (r12 == 0) goto L52
            long r7 = r12.getActions()
            r9 = 32
            long r7 = r7 & r9
            int r12 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r12 == 0) goto L4e
            r12 = 1
            goto L4f
        L4e:
            r12 = 0
        L4f:
            if (r12 != r2) goto L52
            goto L53
        L52:
            r2 = 0
        L53:
            if (r2 == 0) goto L67
            com.wear.databinding.DialogAudioBookBottomControlBinding r12 = r11.c
            if (r12 != 0) goto L5d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L5e
        L5d:
            r5 = r12
        L5e:
            android.widget.ImageButton r12 = r5.b
            r0 = 2131232841(0x7f080849, float:1.8081803E38)
            r12.setImageResource(r0)
            goto L78
        L67:
            com.wear.databinding.DialogAudioBookBottomControlBinding r12 = r11.c
            if (r12 != 0) goto L6f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L70
        L6f:
            r5 = r12
        L70:
            android.widget.ImageButton r12 = r5.b
            r0 = 2131232609(0x7f080761, float:1.8081332E38)
            r12.setImageResource(r0)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.rr3.z(android.support.v4.media.session.PlaybackStateCompat):void");
    }
}
