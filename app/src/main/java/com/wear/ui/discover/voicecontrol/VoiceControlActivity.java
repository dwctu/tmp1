package com.wear.ui.discover.voicecontrol;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.discover.VoiceControlDebugPanelAdapter;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.data.VoiceModelData;
import com.wear.bean.event.DownloadModelEvent;
import com.wear.databinding.ActivityVoiceControlBinding;
import com.wear.databinding.PopVocieStartBinding;
import com.wear.databinding.PopupVoiceConfirmBinding;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.discover.voicecontrol.VoiceControlActivity;
import com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel;
import com.wear.util.WearUtils;
import com.wear.widget.SpaceItemDecoration;
import com.wear.widget.chatMic.DrawView;
import com.wear.widget.control.AutoHideTextView;
import dc.ScaleVolume;
import dc.VoskResult;
import dc.ah4;
import dc.b13;
import dc.br;
import dc.bu1;
import dc.bu2;
import dc.c13;
import dc.ce3;
import dc.e13;
import dc.eg3;
import dc.gg3;
import dc.h04;
import dc.h14;
import dc.kg3;
import dc.ku1;
import dc.n04;
import dc.na2;
import dc.pc1;
import dc.pj3;
import dc.q61;
import dc.qe0;
import dc.s14;
import dc.sg3;
import dc.sy3;
import dc.u34;
import dc.u51;
import dc.uy3;
import dc.v34;
import dc.vl2;
import dc.w03;
import dc.wz3;
import dc.x03;
import dc.xu1;
import dc.y03;
import dc.y12;
import dc.ye3;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt__MathJVMKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vosk.LibVosk;
import org.vosk.LogLevel;

/* compiled from: VoiceControlActivity.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0019\u001c\u0018\u0000 c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002cdB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u000202H\u0002J\b\u00107\u001a\u000202H\u0002J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u000202H\u0002J\b\u0010<\u001a\u000202H\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u000202H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u000202H\u0002J\u0010\u0010B\u001a\u0002022\u0006\u00103\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0013H\u0002J\b\u0010E\u001a\u000202H\u0002J\u0012\u0010F\u001a\u0002022\b\u0010G\u001a\u0004\u0018\u00010HH\u0015J\b\u0010I\u001a\u000202H\u0014J\b\u0010J\u001a\u000202H\u0014J\b\u0010K\u001a\u000202H\u0002J\b\u0010L\u001a\u000202H\u0002J\b\u0010M\u001a\u000202H\u0002J\b\u0010N\u001a\u000202H\u0002J\u0012\u0010O\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010PH\u0002J\b\u0010Q\u001a\u000202H\u0016J\b\u0010R\u001a\u000202H\u0002J\b\u0010S\u001a\u000202H\u0002J\b\u0010T\u001a\u000202H\u0002J\u0012\u0010U\u001a\u0002022\b\u0010V\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010W\u001a\u000202H\u0002J\"\u0010X\u001a\u00020'2\u0018\b\u0002\u0010Y\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010[\u0012\u0004\u0012\u000202\u0018\u00010ZH\u0002J\u0010\u0010\\\u001a\u0002022\u0006\u00103\u001a\u00020\u0013H\u0002J\u0012\u0010]\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010^\u001a\u0002022\u0006\u00103\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u0002022\u0006\u0010a\u001a\u00020bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00060\"R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/VoiceControlActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "accessCount", "", "accessDate", "", "binding", "Lcom/wear/databinding/ActivityVoiceControlBinding;", "bottomDialog", "Lcom/wear/ui/discover/voicecontrol/CommandBottomDialog;", "exoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "getExoPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "exoPlayer$delegate", "Lkotlin/Lazy;", "firstStart", "", "interval", "", "isNewGuideShowBesidesStartTip", "isShowMicrophone", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/wear/ui/discover/voicecontrol/VoiceControlActivity$listener$1", "Lcom/wear/ui/discover/voicecontrol/VoiceControlActivity$listener$1;", "mHandle", "com/wear/ui/discover/voicecontrol/VoiceControlActivity$mHandle$1", "Lcom/wear/ui/discover/voicecontrol/VoiceControlActivity$mHandle$1;", "playStartTime", "popupWindow", "Landroid/widget/PopupWindow;", "receiveBroadCast", "Lcom/wear/ui/discover/voicecontrol/VoiceControlActivity$ReceiveBroadCast;", "recognizeLength", "recognizeNum", "startVoicePop", "timerCoroutines", "Lkotlinx/coroutines/Job;", "viewModel", "Lcom/wear/ui/discover/voicecontrol/viewmodel/VoiceControlViewModel;", "getViewModel", "()Lcom/wear/ui/discover/voicecontrol/viewmodel/VoiceControlViewModel;", "viewModel$delegate", "voiceController", "Lcom/wear/ui/discover/voicecontrol/VoiceController;", "voiceControllerListener", "Lcom/wear/ui/discover/voicecontrol/VoiceController$VoiceControllerListener;", "buryingPoint", "", "it", "Lcom/wear/ui/discover/voicecontrol/GuideStep;", "checkPermission", "completeNewGuide", "downloadVoiceModel", "handleVoskResult", "result", "Lcom/wear/ui/discover/voicecontrol/VoskResult;", "hideTopGuide", "initDebugView", "initDownload", "initModel", "initView", "newGuide", "initVoiceController", "initVoiceModel", "Lcom/wear/bean/data/VoiceModelData;", "isAccessUpload", "observeVoskStatus", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onTipsClick", "playVideo", "registerToysReceiver", "setRssiImage", "setScaleBottomImage", "Lcom/wear/ui/discover/voicecontrol/PatternType;", "settingBarColor", "showBottomDialog", "showConfirmDialog", "showDownloadDialog", "showStartVoice", "str", "showTopGuide", "startTimerCoroutines", "onTick", "Lkotlin/Function1;", "", "updateFrequencyAnim", "updateGuideStep", "updateScaleVolume", "Lcom/wear/ui/discover/voicecontrol/ScaleVolume;", "updateVoskStatus", "voskStatus", "Lcom/wear/ui/discover/voicecontrol/VoskStatus;", "Companion", "ReceiveBroadCast", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceControlActivity extends BaseActivity<vl2> {
    public ActivityVoiceControlBinding a;
    public ReceiveBroadCast b;

    @Nullable
    public PopupWindow c;

    @Nullable
    public PopupWindow d;

    @Nullable
    public h14 e;
    public long g;

    @Nullable
    public c13 i;

    @Nullable
    public CommandBottomDialog j;

    @Nullable
    public c13.c k;
    public int m;
    public int n;
    public int o;
    public long t;
    public boolean f = true;
    public boolean h = true;
    public boolean l = true;

    @NotNull
    public String p = "";

    @NotNull
    public final Lazy q = LazyKt__LazyJVMKt.lazy(new c());

    @NotNull
    public final Lazy s = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VoiceControlViewModel.class), new h(this), new n(), new i(null, this));

    @NotNull
    public final f u = new f(Looper.getMainLooper());

    @NotNull
    public final e v = new e();

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/VoiceControlActivity$ReceiveBroadCast;", "Landroid/content/BroadcastReceiver;", "(Lcom/wear/ui/discover/voicecontrol/VoiceControlActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class ReceiveBroadCast extends BroadcastReceiver {
        public ReceiveBroadCast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), "ACTION_TOY_UPDATE")) {
                VoiceControlActivity.this.l6();
            }
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[x03.b.values().length];
            iArr[x03.b.NORMAL.ordinal()] = 1;
            iArr[x03.b.COMPLETE.ordinal()] = 2;
            iArr[x03.b.ERROR.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[e13.values().length];
            iArr2[e13.STATE_MIC.ordinal()] = 1;
            iArr2[e13.STATE_DONE.ordinal()] = 2;
            iArr2[e13.STATUS_PLAY.ordinal()] = 3;
            iArr2[e13.STATUS_STOP.ordinal()] = 4;
            iArr2[e13.STATUS_ERROR.ordinal()] = 5;
            b = iArr2;
            int[] iArr3 = new int[y03.values().length];
            iArr3[y03.DEFAULT.ordinal()] = 1;
            iArr3[y03.STRAIGHT.ordinal()] = 2;
            iArr3[y03.WAVE.ordinal()] = 3;
            c = iArr3;
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/voicecontrol/VoiceControlActivity$checkPermission$1", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "doNotAskAgain", "", "onGranted", "allGranted", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements u51 {
        public b() {
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            if (!z) {
                ku1.a("Voice Control", "voice_control_access_popup_click", "click", "voice_control_access_popup", "button", "no", null, null);
            } else {
                q61.k(VoiceControlActivity.this, permissions);
                ku1.a("Voice Control", "voice_control_access_popup_click", "click", "voice_control_access_popup", "button", "deny", null, null);
            }
        }

        @Override // dc.u51
        public void b(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            if (z) {
                ku1.a("Voice Control", "voice_control_access_popup_click", "click", "voice_control_access_popup", "button", "allow", null, null);
                VoiceControlActivity.this.R4();
            }
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/exoplayer2/ExoPlayer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ExoPlayer> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExoPlayer invoke() {
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(VoiceControlActivity.this).build();
            exoPlayerBuild.setPlayWhenReady(true);
            exoPlayerBuild.setRepeatMode(1);
            Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "Builder(this).build().ap…REPEAT_MODE_ONE\n        }");
            return exoPlayerBuild;
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/discover/voicecontrol/VoiceControlActivity$initVoiceController$1", "Lcom/wear/ui/discover/voicecontrol/VoiceController$VoiceControllerListener;", "onVoiceControllerStart", "", "onVoiceControllerStop", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements c13.c {
        public d() {
        }

        @Override // dc.c13.c
        public void a() {
        }

        @Override // dc.c13.c
        public void b() {
            boolean zD = eg3.d(VoiceControlActivity.this, "newGuide", true);
            if (VoiceControlActivity.this.I4().O().getValue() == null || zD) {
                VoiceControlActivity.this.finish();
                return;
            }
            VoiceControlActivity.this.I4().u();
            h14 h14Var = VoiceControlActivity.this.e;
            ActivityVoiceControlBinding activityVoiceControlBinding = null;
            if (h14Var != null) {
                h14.a.a(h14Var, null, 1, null);
            }
            ActivityVoiceControlBinding activityVoiceControlBinding2 = VoiceControlActivity.this.a;
            if (activityVoiceControlBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding2;
            }
            activityVoiceControlBinding.K.setPause(true);
            activityVoiceControlBinding.j.setVisibility(0);
            activityVoiceControlBinding.B.setVisibility(0);
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/voicecontrol/VoiceControlActivity$listener$1", "Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadModelListener;", "onComplete", "", "onError", "message", "", "onProgress", "progress", "", "onStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements x03.a {
        public e() {
        }

        @Override // dc.x03.a
        public void a(int i) {
            Message messageObtain = Message.obtain();
            messageObtain.arg1 = i;
            messageObtain.what = 2;
            VoiceControlActivity.this.u.sendMessage(messageObtain);
        }

        @Override // dc.x03.a
        public void onComplete() {
            VoiceControlActivity.this.u.sendEmptyMessage(3);
        }

        @Override // dc.x03.a
        public void onError(@Nullable String message) {
            VoiceControlActivity.this.u.sendEmptyMessage(4);
        }

        @Override // dc.x03.a
        public void onStart() {
            VoiceControlActivity.this.u.sendEmptyMessage(1);
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/voicecontrol/VoiceControlActivity$mHandle$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ActivityVoiceControlBinding activityVoiceControlBinding = null;
            switch (msg.what) {
                case 1:
                    ActivityVoiceControlBinding activityVoiceControlBinding2 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding2 = null;
                    }
                    activityVoiceControlBinding2.o.setVisibility(0);
                    ActivityVoiceControlBinding activityVoiceControlBinding3 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding3 = null;
                    }
                    activityVoiceControlBinding3.o.setProgressDrawable(ContextCompat.getDrawable(VoiceControlActivity.this, R.drawable.model_progress_bg));
                    ActivityVoiceControlBinding activityVoiceControlBinding4 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding4 = null;
                    }
                    activityVoiceControlBinding4.z.setVisibility(0);
                    ActivityVoiceControlBinding activityVoiceControlBinding5 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityVoiceControlBinding = activityVoiceControlBinding5;
                    }
                    activityVoiceControlBinding.g.setVisibility(8);
                    break;
                case 2:
                    ActivityVoiceControlBinding activityVoiceControlBinding6 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding6 = null;
                    }
                    ProgressBar progressBar = activityVoiceControlBinding6.o;
                    if (progressBar.getVisibility() == 8) {
                        progressBar.setVisibility(0);
                    }
                    progressBar.setProgress(msg.arg1);
                    ActivityVoiceControlBinding activityVoiceControlBinding7 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding7 = null;
                    }
                    TextView textView = activityVoiceControlBinding7.z;
                    StringBuilder sb = new StringBuilder();
                    sb.append(msg.arg1);
                    sb.append('%');
                    textView.setText(sb.toString());
                    if (textView.getVisibility() == 8) {
                        textView.setVisibility(0);
                    }
                    ActivityVoiceControlBinding activityVoiceControlBinding8 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityVoiceControlBinding = activityVoiceControlBinding8;
                    }
                    PlayerView playerView = activityVoiceControlBinding.n;
                    VoiceControlActivity voiceControlActivity = VoiceControlActivity.this;
                    if (playerView.getVisibility() == 8) {
                        ExoPlayer exoPlayerH4 = voiceControlActivity.H4();
                        if (!(exoPlayerH4.getPlaybackState() == 3 || exoPlayerH4.getPlaybackState() == 2)) {
                            voiceControlActivity.j6();
                            break;
                        }
                    }
                    break;
                case 3:
                    ActivityVoiceControlBinding activityVoiceControlBinding9 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding9 = null;
                    }
                    activityVoiceControlBinding9.o.setVisibility(8);
                    ActivityVoiceControlBinding activityVoiceControlBinding10 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding10 = null;
                    }
                    activityVoiceControlBinding10.z.setVisibility(8);
                    ActivityVoiceControlBinding activityVoiceControlBinding11 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding11 = null;
                    }
                    activityVoiceControlBinding11.B.setVisibility(0);
                    ActivityVoiceControlBinding activityVoiceControlBinding12 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityVoiceControlBinding = activityVoiceControlBinding12;
                    }
                    activityVoiceControlBinding.j.setVisibility(0);
                    EventBus.getDefault().post(new DownloadModelEvent(x03.b.COMPLETE));
                    ku1.a("Voice Control", "voice_control_feature_pack_download_success", null, "voice_control_feature_pack_download", null, null, null, null);
                    break;
                case 4:
                    ku1.a("Voice Control", "voice_control_feature_pack_download_fail", null, "voice_control_feature_pack_download", null, null, null, null);
                    ActivityVoiceControlBinding activityVoiceControlBinding13 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding13 = null;
                    }
                    VoiceControlActivity voiceControlActivity2 = VoiceControlActivity.this;
                    ActivityVoiceControlBinding activityVoiceControlBinding14 = voiceControlActivity2.a;
                    if (activityVoiceControlBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityVoiceControlBinding14 = null;
                    }
                    activityVoiceControlBinding14.o.setVisibility(0);
                    ActivityVoiceControlBinding activityVoiceControlBinding15 = voiceControlActivity2.a;
                    if (activityVoiceControlBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityVoiceControlBinding = activityVoiceControlBinding15;
                    }
                    activityVoiceControlBinding.o.setProgress(x03.a.g());
                    activityVoiceControlBinding13.o.setProgressDrawable(ContextCompat.getDrawable(voiceControlActivity2, R.drawable.model_error_progress_bg));
                    activityVoiceControlBinding13.z.setText("Continue downloading");
                    activityVoiceControlBinding13.g.setVisibility(0);
                    sg3.l("Download failed. Please try again");
                    break;
                case 5:
                    ActivityVoiceControlBinding activityVoiceControlBinding16 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityVoiceControlBinding = activityVoiceControlBinding16;
                    }
                    activityVoiceControlBinding.C.setText(WearUtils.v0(VoiceControlActivity.this.g));
                    VoiceControlActivity.this.g++;
                    sendEmptyMessageDelayed(5, 1000L);
                    break;
                case 6:
                    ActivityVoiceControlBinding activityVoiceControlBinding17 = VoiceControlActivity.this.a;
                    if (activityVoiceControlBinding17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityVoiceControlBinding = activityVoiceControlBinding17;
                    }
                    activityVoiceControlBinding.F.setText("Now try a different command");
                    VoiceControlActivity.this.x6();
                    break;
            }
        }
    }

    /* compiled from: Animator.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,136:1\n*E\n"})
    public static final class g implements Animator.AnimatorListener {
        public g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            xu1.a(VoiceControlActivity.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
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
    public static final class i extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Function0 function0, ComponentActivity componentActivity) {
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

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.VoiceControlActivity$startTimerCoroutines$1", f = "VoiceControlActivity.kt", i = {0, 1}, l = {564, 565}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class j extends SuspendLambda implements Function2<u34<? super Float>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            j jVar = VoiceControlActivity.this.new j(continuation);
            jVar.L$0 = obj;
            return jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull u34<? super Float> u34Var, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(u34Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Path cross not found for [B:19:0x005a, B:16:0x004a], limit reached: 33 */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009c -> B:12:0x0031). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r7.L$0
                dc.u34 r1 = (dc.u34) r1
                kotlin.ResultKt.throwOnFailure(r8)
                r8 = r1
                goto L30
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                java.lang.Object r1 = r7.L$0
                dc.u34 r1 = (dc.u34) r1
                kotlin.ResultKt.throwOnFailure(r8)
                r8 = r1
                r1 = r7
                goto L92
            L29:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                dc.u34 r8 = (dc.u34) r8
            L30:
                r1 = r7
            L31:
                com.wear.ui.discover.voicecontrol.VoiceControlActivity r4 = com.wear.ui.discover.voicecontrol.VoiceControlActivity.this
                com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel r4 = com.wear.ui.discover.voicecontrol.VoiceControlActivity.x4(r4)
                androidx.lifecycle.MutableLiveData r4 = r4.z()
                java.lang.Object r4 = r4.getValue()
                dc.a13 r4 = (dc.VoiceControlCommand) r4
                r5 = 0
                if (r4 == 0) goto L87
                boolean r6 = r4.getIsMultiply()
                if (r6 == 0) goto L5a
                java.lang.Integer r4 = r4.getValue()
                if (r4 == 0) goto L72
                int r4 = r4.intValue()
                float r4 = (float) r4
                java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
                goto L73
            L5a:
                java.util.List r4 = r4.a()
                if (r4 == 0) goto L72
                r6 = 0
                java.lang.Object r4 = r4.get(r6)
                java.lang.String r4 = (java.lang.String) r4
                if (r4 == 0) goto L72
                float r4 = java.lang.Float.parseFloat(r4)
                java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
                goto L73
            L72:
                r4 = r5
            L73:
                if (r4 == 0) goto L87
                float r4 = r4.floatValue()
                r5 = 1073951539(0x40033333, float:2.05)
                float r4 = r4 * r5
                r5 = 40
                float r5 = (float) r5
                float r4 = r4 / r5
                java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
                r5 = r4
            L87:
                r1.L$0 = r8
                r1.label = r3
                java.lang.Object r4 = r8.emit(r5, r1)
                if (r4 != r0) goto L92
                return r0
            L92:
                r4 = 16
                r1.L$0 = r8
                r1.label = r2
                java.lang.Object r4 = dc.h04.a(r4, r1)
                if (r4 != r0) goto L31
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.VoiceControlActivity.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.VoiceControlActivity$startTimerCoroutines$2", f = "VoiceControlActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Float, Unit> $onTick;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public k(Function1<? super Float, Unit> function1, Continuation<? super k> continuation) {
            super(2, continuation);
            this.$onTick = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable Float f, @Nullable Continuation<? super Unit> continuation) {
            return ((k) create(f, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            k kVar = new k(this.$onTick, continuation);
            kVar.L$0 = obj;
            return kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Float f = (Float) this.L$0;
            Function1<Float, Unit> function1 = this.$onTick;
            if (function1 != null) {
                function1.invoke(f);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.VoiceControlActivity$updateFrequencyAnim$1$1", f = "VoiceControlActivity.kt", i = {}, l = {955, 956}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LottieAnimationView $this_run;
        public int label;

        /* compiled from: VoiceControlActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.VoiceControlActivity$updateFrequencyAnim$1$1$1", f = "VoiceControlActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ LottieAnimationView $this_run;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(LottieAnimationView lottieAnimationView, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$this_run = lottieAnimationView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$this_run, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$this_run.setVisibility(8);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(LottieAnimationView lottieAnimationView, Continuation<? super l> continuation) {
            super(2, continuation);
            this.$this_run = lottieAnimationView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new l(this.$this_run, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            s14 s14VarC = n04.c();
            a aVar = new a(this.$this_run, null);
            this.label = 2;
            if (sy3.g(s14VarC, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Float;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<Float, Unit> {
        public m() {
            super(1);
        }

        public final void a(@Nullable Float f) {
            if (f != null) {
                VoiceControlActivity voiceControlActivity = VoiceControlActivity.this;
                float fFloatValue = f.floatValue();
                ActivityVoiceControlBinding activityVoiceControlBinding = voiceControlActivity.a;
                if (activityVoiceControlBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityVoiceControlBinding = null;
                }
                DrawView drawView = activityVoiceControlBinding.K;
                drawView.setPause(false);
                drawView.m = (drawView.m + Math.max(fFloatValue, 0.01f)) / 2;
                drawView.f += drawView.e;
                drawView.invalidate();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
            a(f);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function0<ViewModelProvider.Factory> {
        public n() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return new VoiceControlViewModel.Factory(VoiceControlActivity.this);
        }
    }

    public static final void L4(VoiceControlActivity this$0, float f2, int i2, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        TextView textView = activityVoiceControlBinding.F;
        textView.getLayoutParams().height = iIntValue;
        float f3 = iIntValue;
        textView.getLayoutParams().width = MathKt__MathJVMKt.roundToInt(f2 * f3);
        textView.setAlpha((f3 * 1.0f) / i2);
        textView.requestLayout();
    }

    public static final void N4(ActivityVoiceControlBinding this_run, View view) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.d.setVisibility(0);
    }

    public static final void O4(VoiceControlDebugPanelAdapter this_apply, VoiceControlActivity this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.I4().Q(this_apply.getItem(i2));
    }

    public static final void P4(ActivityVoiceControlBinding this_run, View view) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.d.setVisibility(8);
    }

    public static final void R5(VoiceControlActivity this$0, VoiceModelData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.d5(it);
    }

    public static final void S5(VoiceControlActivity this$0, VoskResult result) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.J4(result);
    }

    public static final void T4(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void T5(VoiceControlActivity this$0, e13 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.D6(it);
    }

    public static final void U4(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    public static final void U5(VoiceControlActivity this$0, w03 w03Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B6(w03Var);
    }

    public static final void V4(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    public static final void V5(VoiceControlActivity this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        DrawView drawView = activityVoiceControlBinding.K;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        drawView.c = it.floatValue();
    }

    public static final void W4(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i6();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void W5(com.wear.ui.discover.voicecontrol.VoiceControlActivity r6, dc.VoiceControlCommand r7) throws java.lang.NumberFormatException {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r7.getIsMultiply()
            r1 = 0
            if (r0 == 0) goto L17
            java.lang.Integer r0 = r7.getValue()
            if (r0 == 0) goto L2a
            int r0 = r0.intValue()
            goto L2b
        L17:
            java.util.List r0 = r7.a()
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L2a
            int r0 = java.lang.Integer.parseInt(r0)
            goto L2b
        L2a:
            r0 = 0
        L2b:
            com.wear.databinding.ActivityVoiceControlBinding r2 = r6.a
            r3 = 0
            java.lang.String r4 = "binding"
            if (r2 != 0) goto L36
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
        L36:
            com.wear.widget.ScaleView r2 = r2.s
            boolean r5 = r7.getIsMultiply()
            if (r5 == 0) goto L49
            java.lang.Integer r7 = r7.getValue()
            if (r7 == 0) goto L5b
            int r1 = r7.intValue()
            goto L5b
        L49:
            java.util.List r7 = r7.a()
            if (r7 == 0) goto L5b
            java.lang.Object r7 = r7.get(r1)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L5b
            int r1 = java.lang.Integer.parseInt(r7)
        L5b:
            r2.a(r1)
            com.wear.databinding.ActivityVoiceControlBinding r6 = r6.a
            if (r6 != 0) goto L66
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L67
        L66:
            r3 = r6
        L67:
            android.widget.TextView r6 = r3.y
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "指令值："
            r7.append(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.setText(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.VoiceControlActivity.W5(com.wear.ui.discover.voicecontrol.VoiceControlActivity, dc.a13):void");
    }

    public static final void X4(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ku1.a("Voice Control", "voice_control_start_click", "click", "voice_control_start", "button", null, null, null);
        this$0.E4();
    }

    public static final void X5(VoiceControlActivity this$0, y03 y03Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.x.setText("当前播放：" + this$0.I4().D().getValue() + ' ');
        this$0.m6(y03Var);
    }

    public static final void Y4(ActivityVoiceControlBinding this_apply, VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_apply.g.getVisibility() == 0) {
            ku1.a("Voice Control", "voice_control_feature_pack_continue_download_click", "click", "voice_control_feature_pack_continue_download", "button", null, null, null);
        }
        this$0.G4();
    }

    public static final void Y5(VoiceControlActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v6(str);
    }

    public static final void Z4(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ku1.a("Voice Control", "voice_control_feature_pack_continue_download_click", "click", "voice_control_feature_pack_continue_download", "button", null, null, null);
        this$0.G4();
    }

    public static final void Z5(VoiceControlActivity this$0, ScaleVolume it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.C6(it);
    }

    public static final void a5(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I4().K();
        this$0.I4().M();
    }

    public static final void a6(VoiceControlActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.A6(it.booleanValue());
    }

    public static final void b5(ActivityVoiceControlBinding this_apply, VoiceControlActivity this$0) throws Resources.NotFoundException, ClassNotFoundException {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this_apply.c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = gg3.g(this$0);
    }

    public static final void b6(final VoiceControlActivity this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Runnable runnable = new Runnable() { // from class: dc.pz2
            @Override // java.lang.Runnable
            public final void run() {
                VoiceControlActivity.c6(this.a);
            }
        };
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ActivityVoiceControlBinding activityVoiceControlBinding = null;
        if (ArraysKt___ArraysKt.contains(new String[]{"stat", "star", TtmlNode.START}, it)) {
            if (this$0.l || this$0.I4().B().getValue() != w03.STEP_03) {
                ActivityVoiceControlBinding activityVoiceControlBinding2 = this$0.a;
                if (activityVoiceControlBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityVoiceControlBinding = activityVoiceControlBinding2;
                }
                activityVoiceControlBinding.F.setText("Try a command besides \"Start\"");
                this$0.x6();
                this$0.u.postDelayed(runnable, 5000L);
                return;
            }
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"stop", "stall", "spawn", "spock"}, it)) {
            CommandBottomDialog commandBottomDialog = this$0.j;
            if (commandBottomDialog != null) {
                commandBottomDialog.dismiss();
            }
            this$0.u.removeCallbacks(runnable);
            this$0.F4();
            return;
        }
        CommandBottomDialog commandBottomDialog2 = this$0.j;
        if (commandBottomDialog2 != null) {
            commandBottomDialog2.dismiss();
        }
        this$0.K4();
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this$0.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding = activityVoiceControlBinding3;
        }
        if (Intrinsics.areEqual(activityVoiceControlBinding.b.getText(), "Great! Now try: \"Stop\"")) {
            return;
        }
        this$0.I4().N().postValue(new VoskResult(it, false));
        this$0.u.postDelayed(new Runnable() { // from class: dc.mz2
            @Override // java.lang.Runnable
            public final void run() {
                VoiceControlActivity.d6(this.a);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public static final void c6(VoiceControlActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.F.setText("Now try a different command");
        this$0.x6();
    }

    public static final void d6(VoiceControlActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I4().X();
        this$0.l = false;
    }

    public static final void e6(VoiceControlActivity this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m++;
        this$0.n += it.length();
        if (this$0.e5()) {
            VoiceControlViewModel voiceControlViewModelI4 = this$0.I4();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ye3.j("Voice Control", "voice_control_AI_recognition", "recognize", "", "", it, voiceControlViewModelI4.Y(it) ? b13.a(it) : EnvironmentCompat.MEDIA_UNKNOWN, -1L);
        }
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.w.setText(it);
    }

    public static final void f6(VoiceControlActivity this$0, Float f2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.v.setText("频率值：" + f2);
    }

    public static final void g6(final VoiceControlActivity this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.s.setAlpha(1.0f);
        this$0.u.postDelayed(new Runnable() { // from class: dc.k03
            @Override // java.lang.Runnable
            public final void run() {
                VoiceControlActivity.h6(this.a);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public static final void h6(VoiceControlActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.s.setAlpha(0.5f);
    }

    public static final void o6(boolean z, VoiceControlActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z && this$0.I4().getN()) {
            if (this$0.I4().B().getValue() == w03.STEP_04) {
                this$0.F4();
                return;
            }
            ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
            ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
            if (activityVoiceControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding = null;
            }
            if (activityVoiceControlBinding.F.getAlpha() == 1.0f) {
                ActivityVoiceControlBinding activityVoiceControlBinding3 = this$0.a;
                if (activityVoiceControlBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityVoiceControlBinding2 = activityVoiceControlBinding3;
                }
                activityVoiceControlBinding2.b.setVisibility(8);
            }
        }
    }

    public static final void q6(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I4().W(true);
        this$0.I4().j0(false);
        ku1.a("Voice Control", "voice_control_new_guide_click", "click", "voice_control_new_guide", "button", "1", null, null);
        PopupWindow popupWindow = this$0.c;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this$0.I4().i0(true);
    }

    public static final void r6(VoiceControlActivity this$0, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ku1.a("Voice Control", "voice_control_new_guide_click", "click", "voice_control_new_guide", "button", "0", null, null);
        this$0.I4().W(false);
        eg3.j(this$0, "newGuide", false);
        PopupWindow popupWindow = this$0.c;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this$0.I4().i0(true);
    }

    public static final void t6(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ku1.a("Voice Control", "voice_control_feature_pack_click", "click", "voice_control_feature_pack", "button", "no", null, null);
        this$0.finish();
    }

    public static final void u6(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ku1.a("Voice Control", "voice_control_feature_pack_click", "click", "voice_control_feature_pack", "button", Pattern.DOWNLOAD, null, null);
        VoiceModelData voiceModelDataH = x03.a.h();
        if (voiceModelDataH != null) {
            VoiceControlViewModel voiceControlViewModelI4 = this$0.I4();
            String url = voiceModelDataH.getUrl();
            if (url == null) {
                url = "";
            }
            String modelName = voiceModelDataH.getModelName();
            voiceControlViewModelI4.y(url, modelName != null ? modelName : "");
            ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
            if (activityVoiceControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding = null;
            }
            activityVoiceControlBinding.p.setVisibility(8);
        }
    }

    public static final void w6(VoiceControlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.d;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public static final void y6(VoiceControlActivity this$0, float f2, int i2, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ActivityVoiceControlBinding activityVoiceControlBinding = this$0.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        TextView textView = activityVoiceControlBinding.F;
        textView.getLayoutParams().height = iIntValue;
        float f3 = iIntValue;
        textView.getLayoutParams().width = MathKt__MathJVMKt.roundToInt(f2 * f3);
        textView.setAlpha((f3 * 1.0f) / i2);
        textView.requestLayout();
    }

    public final void A6(boolean z) {
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        LottieAnimationView lottieAnimationView = activityVoiceControlBinding.i;
        lottieAnimationView.setVisibility(0);
        if (z) {
            lottieAnimationView.setImageAssetsFolder("anim/frequency/in/images");
            lottieAnimationView.setAnimation("anim/frequency/in/data.json");
        } else {
            lottieAnimationView.setImageAssetsFolder("anim/frequency/out/images");
            lottieAnimationView.setAnimation("anim/frequency/out/data.json");
        }
        lottieAnimationView.r();
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new l(lottieAnimationView, null), 3, null);
    }

    public final void B6(w03 w03Var) {
        ActivityVoiceControlBinding activityVoiceControlBinding = null;
        if (w03Var == w03.STEP_02) {
            ActivityVoiceControlBinding activityVoiceControlBinding2 = this.a;
            if (activityVoiceControlBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding2 = null;
            }
            activityVoiceControlBinding2.D.setBackground(ContextCompat.getDrawable(this, R.drawable.voice_control_tips_click_bg));
            ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
            if (activityVoiceControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding3;
            }
            activityVoiceControlBinding.D.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else if (w03Var == w03.STEP_04) {
            F4();
        } else {
            ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
            if (activityVoiceControlBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding4 = null;
            }
            activityVoiceControlBinding4.D.setBackground(ContextCompat.getDrawable(this, R.drawable.voice_control_tips_bg));
            ActivityVoiceControlBinding activityVoiceControlBinding5 = this.a;
            if (activityVoiceControlBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding5;
            }
            activityVoiceControlBinding.D.setTextColor(ContextCompat.getColor(this, R.color.color_FFFFFFF_30));
        }
        D4(w03Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C6(dc.ScaleVolume r8) {
        /*
            r7 = this;
            com.wear.databinding.ActivityVoiceControlBinding r0 = r7.a
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        Lb:
            com.wear.widget.ScaleView r0 = r0.s
            int r0 = r0.getH()
            float r0 = (float) r0
            r3 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r3
            com.wear.databinding.ActivityVoiceControlBinding r3 = r7.a
            if (r3 != 0) goto L1d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r1
        L1d:
            com.wear.widget.control.ScaleTextView r3 = r3.A
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r3 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r3
            r4 = 22
            float r4 = (float) r4
            float r0 = r0 * r4
            int r0 = dc.ce3.a(r7, r0)
            r3.bottomMargin = r0
            com.wear.databinding.ActivityVoiceControlBinding r0 = r7.a
            if (r0 != 0) goto L3d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L3d:
            com.wear.widget.control.ScaleTextView r0 = r0.A
            java.lang.String r3 = r8.getCommand()
            int r4 = r3.hashCode()
            r5 = -1707959739(0xffffffff9a329a45, float:-3.6934155E-23)
            if (r4 == r5) goto Lb6
            r5 = 1855960161(0x6e9fb461, float:2.471309E28)
            r6 = 43
            if (r4 == r5) goto L76
            r5 = 1865194916(0x6f2c9da4, float:5.3421998E28)
            if (r4 == r5) goto L59
            goto Lbe
        L59:
            java.lang.String r4 = "Stronger"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L62
            goto Lbe
        L62:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            int r8 = r8.getValue()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            goto Lc9
        L76:
            java.lang.String r4 = "Strength"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L7f
            goto Lbe
        L7f:
            int r8 = r8.getValue()
            com.wear.databinding.ActivityVoiceControlBinding r3 = r7.a
            if (r3 != 0) goto L8b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r1
        L8b:
            com.wear.widget.ScaleView r3 = r3.s
            int r3 = r3.getH()
            int r8 = r8 - r3
            if (r8 <= 0) goto La4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            goto Lc9
        La4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 45
            r3.append(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            goto Lc9
        Lb6:
            java.lang.String r4 = "Weaker"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
        Lbe:
            java.lang.String r8 = ""
            goto Lc9
        Lc1:
            int r8 = r8.getValue()
            java.lang.String r8 = java.lang.String.valueOf(r8)
        Lc9:
            r0.setText(r8)
            com.wear.databinding.ActivityVoiceControlBinding r8 = r7.a
            if (r8 != 0) goto Ld4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto Ld5
        Ld4:
            r1 = r8
        Ld5:
            com.wear.widget.control.ScaleTextView r8 = r1.A
            r8.b()
            r8.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.VoiceControlActivity.C6(dc.z03):void");
    }

    public final void D4(w03 w03Var) {
        ku1.a("Voice Control", "voice_control_new_guide_exposure", "exposure", "voice_control_new_guide", "text", Integer.valueOf(I4().C(w03Var)), null, null);
    }

    public final void D6(e13 e13Var) {
        h14 h14Var;
        int i2 = a.b[e13Var.ordinal()];
        ActivityVoiceControlBinding activityVoiceControlBinding = null;
        if (i2 == 1) {
            if (this.h) {
                ActivityVoiceControlBinding activityVoiceControlBinding2 = this.a;
                if (activityVoiceControlBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityVoiceControlBinding = activityVoiceControlBinding2;
                }
                LottieAnimationView lottieAnimationView = activityVoiceControlBinding.j;
                lottieAnimationView.setImageAssetsFolder("anim/images");
                lottieAnimationView.setAnimation("anim/voice_control_data.json");
                lottieAnimationView.r();
                this.h = false;
            }
            I4().i0(true);
            return;
        }
        if (i2 == 2) {
            ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
            if (activityVoiceControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding3;
            }
            LottieAnimationView lottieAnimationView2 = activityVoiceControlBinding.j;
            lottieAnimationView2.setImageAssetsFolder("anim/ripple/images");
            lottieAnimationView2.setAnimation("anim/ripple/data.json");
            lottieAnimationView2.r();
            this.h = true;
            I4().i0(false);
            return;
        }
        if (i2 == 3) {
            h14 h14Var2 = this.e;
            boolean zIsActive = h14Var2 != null ? h14Var2.isActive() : false;
            if ((!eg3.d(this, "newGuide", true) || !I4().getN()) && this.f) {
                this.t = System.currentTimeMillis();
                this.u.sendEmptyMessage(5);
                this.f = false;
                ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
                if (activityVoiceControlBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityVoiceControlBinding4 = null;
                }
                activityVoiceControlBinding4.s.setVisibility(0);
                ActivityVoiceControlBinding activityVoiceControlBinding5 = this.a;
                if (activityVoiceControlBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityVoiceControlBinding5 = null;
                }
                activityVoiceControlBinding5.l.setVisibility(0);
            }
            if (zIsActive && (h14Var = this.e) != null) {
                h14.a.a(h14Var, null, 1, null);
            }
            PopupWindow popupWindow = this.d;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            this.e = z6(new m());
            return;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                return;
            }
            ActivityVoiceControlBinding activityVoiceControlBinding6 = this.a;
            if (activityVoiceControlBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding6 = null;
            }
            activityVoiceControlBinding6.e.setVisibility(8);
            ActivityVoiceControlBinding activityVoiceControlBinding7 = this.a;
            if (activityVoiceControlBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding7;
            }
            activityVoiceControlBinding.q.setVisibility(0);
            return;
        }
        h14 h14Var3 = this.e;
        if (h14Var3 != null) {
            h14.a.a(h14Var3, null, 1, null);
        }
        ActivityVoiceControlBinding activityVoiceControlBinding8 = this.a;
        if (activityVoiceControlBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding8 = null;
        }
        DrawView drawView = activityVoiceControlBinding8.K;
        drawView.m = 0.0f;
        drawView.invalidate();
        ActivityVoiceControlBinding activityVoiceControlBinding9 = this.a;
        if (activityVoiceControlBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding = activityVoiceControlBinding9;
        }
        activityVoiceControlBinding.s.a(0);
    }

    public final void E4() {
        ku1.a("Voice Control", "voice_control_access_popup_exposure", "exposure", "voice_control_access_popup", "button", null, null, null);
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.RECORD_AUDIO");
        q61VarM.j(new b());
    }

    public final void F4() {
        if (I4().B().getValue() != w03.STEP_04 || this.j == null) {
            return;
        }
        ku1.a("Voice Control", "voice_control_new_guide_exposure", "exposure", "voice_control_new_guide", "text", "6", null, null);
        CommandBottomDialog commandBottomDialog = this.j;
        if (commandBottomDialog != null) {
            commandBottomDialog.dismiss();
        }
        K4();
        p6();
    }

    public final void G4() {
        VoiceModelData voiceModelDataH;
        if (x03.f() != x03.b.ERROR || (voiceModelDataH = x03.a.h()) == null) {
            return;
        }
        VoiceControlViewModel voiceControlViewModelI4 = I4();
        String url = voiceModelDataH.getUrl();
        if (url == null) {
            url = "";
        }
        String modelName = voiceModelDataH.getModelName();
        voiceControlViewModelI4.y(url, modelName != null ? modelName : "");
    }

    public final ExoPlayer H4() {
        return (ExoPlayer) this.q.getValue();
    }

    public final VoiceControlViewModel I4() {
        return (VoiceControlViewModel) this.s.getValue();
    }

    public final void J4(VoskResult voskResult) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        AutoHideTextView autoHideTextView = activityVoiceControlBinding.b;
        autoHideTextView.setText(voskResult.getContent());
        if (voskResult.getShowAlways()) {
            autoHideTextView.c();
        } else {
            autoHideTextView.b();
        }
        if (TextUtils.equals("Yes", voskResult.getContent())) {
            I4().W(true);
            I4().i0(true);
            I4().j0(false);
            PopupWindow popupWindow = this.c;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        if (TextUtils.equals("No", voskResult.getContent())) {
            I4().W(false);
            I4().i0(true);
            eg3.j(this, "newGuide", false);
            PopupWindow popupWindow2 = this.c;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
        }
    }

    public final void K4() {
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        final int height = activityVoiceControlBinding.F.getHeight();
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding2 = activityVoiceControlBinding3;
        }
        final float width = height > 0 ? (activityVoiceControlBinding2.F.getWidth() * 1.0f) / height : 9.02f;
        ValueAnimator valueAnimatorOfInt = ObjectAnimator.ofInt(height, 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.t03
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VoiceControlActivity.L4(this.a, width, height, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.start();
    }

    public final void M4() {
        if (((bu1.a().getApplicationInfo().flags & 2) != 0) || WearUtils.v) {
            final ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
            ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
            if (activityVoiceControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding = null;
            }
            activityVoiceControlBinding.x.setText("当前播放：" + y03.DEFAULT + ' ');
            ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
            if (activityVoiceControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding2 = activityVoiceControlBinding3;
            }
            activityVoiceControlBinding2.y.setText("指令值：0");
            activityVoiceControlBinding.v.setText("频率值：0.4");
            activityVoiceControlBinding.E.setOnClickListener(new View.OnClickListener() { // from class: dc.i03
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VoiceControlActivity.N4(activityVoiceControlBinding, view);
                }
            });
            RecyclerView recyclerView = activityVoiceControlBinding.r;
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            final VoiceControlDebugPanelAdapter voiceControlDebugPanelAdapter = new VoiceControlDebugPanelAdapter();
            voiceControlDebugPanelAdapter.x0(b13.b());
            voiceControlDebugPanelAdapter.E0(new br() { // from class: dc.g03
                @Override // dc.br
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    VoiceControlActivity.O4(voiceControlDebugPanelAdapter, this, baseQuickAdapter, view, i2);
                }
            });
            recyclerView.setAdapter(voiceControlDebugPanelAdapter);
            recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, qe0.a(5.0f), qe0.a(5.0f)));
            activityVoiceControlBinding.h.setOnClickListener(new View.OnClickListener() { // from class: dc.r03
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VoiceControlActivity.P4(activityVoiceControlBinding, view);
                }
            });
        }
    }

    public final void Q4() {
        int i2 = a.a[x03.f().ordinal()];
        if (i2 == 1 || i2 == 2) {
            I4().M();
        } else {
            if (i2 != 3) {
                return;
            }
            this.u.sendEmptyMessage(4);
        }
    }

    public final void Q5() {
        I4().L().observe(this, new Observer() { // from class: dc.vz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.R5(this.a, (VoiceModelData) obj);
            }
        });
        I4().N().observe(this, new Observer() { // from class: dc.a03
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                VoiceControlActivity.S5(this.a, (VoskResult) obj);
            }
        });
        I4().O().observe(this, new Observer() { // from class: dc.yz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.T5(this.a, (e13) obj);
            }
        });
        I4().B().observe(this, new Observer() { // from class: dc.j03
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.U5(this.a, (w03) obj);
            }
        });
        I4().P().observe(this, new Observer() { // from class: dc.b03
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.V5(this.a, (Float) obj);
            }
        });
        I4().z().observe(this, new Observer() { // from class: dc.l03
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws NumberFormatException {
                VoiceControlActivity.W5(this.a, (VoiceControlCommand) obj);
            }
        });
        I4().D().observe(this, new Observer() { // from class: dc.rz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.X5(this.a, (y03) obj);
            }
        });
        I4().I().observe(this, new Observer() { // from class: dc.e03
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.Y5(this.a, (String) obj);
            }
        });
        I4().G().observe(this, new Observer() { // from class: dc.oz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.Z5(this.a, (ScaleVolume) obj);
            }
        });
        I4().Z().observe(this, new Observer() { // from class: dc.tz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.a6(this.a, (Boolean) obj);
            }
        });
        I4().J().observe(this, new Observer() { // from class: dc.u03
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.b6(this.a, (String) obj);
            }
        });
        I4().E().observe(this, new Observer() { // from class: dc.zz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.e6(this.a, (String) obj);
            }
        });
        I4().A().observe(this, new Observer() { // from class: dc.uz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.f6(this.a, (Float) obj);
            }
        });
        I4().F().observe(this, new Observer() { // from class: dc.sz2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoiceControlActivity.g6(this.a, (Boolean) obj);
            }
        });
    }

    public final void R4() {
        String modelName;
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        if (y12.c.a().s(y12.c.TYPE_VOICE_CONTROL)) {
            ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
            ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
            if (activityVoiceControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding = null;
            }
            activityVoiceControlBinding.n.setVisibility(8);
            H4().stop();
            ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
            if (activityVoiceControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding3 = null;
            }
            activityVoiceControlBinding3.B.setVisibility(8);
            ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
            if (activityVoiceControlBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding2 = activityVoiceControlBinding4;
            }
            activityVoiceControlBinding2.j.setVisibility(0);
            File externalFilesDir = getExternalFilesDir("wear/model");
            String strH = eg3.h(this, "modelName", "");
            VoiceModelData voiceModelDataH = x03.a.h();
            if (voiceModelDataH != null && (modelName = voiceModelDataH.getModelName()) != null) {
                strH = modelName;
            }
            File file = new File(externalFilesDir, strH);
            VoiceControlViewModel voiceControlViewModelI4 = I4();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "modelFile.absolutePath");
            voiceControlViewModelI4.V(absolutePath);
        }
    }

    public final void S4(boolean z) {
        final ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.f.setOnClickListener(new View.OnClickListener() { // from class: dc.h03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.T4(this.a, view);
            }
        });
        activityVoiceControlBinding.G.setOnClickListener(new View.OnClickListener() { // from class: dc.q03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.U4(this.a, view);
            }
        });
        activityVoiceControlBinding.m.setOnClickListener(new View.OnClickListener() { // from class: dc.f03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.V4(this.a, view);
            }
        });
        activityVoiceControlBinding.D.setOnClickListener(new View.OnClickListener() { // from class: dc.s03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.W4(this.a, view);
            }
        });
        activityVoiceControlBinding.B.setOnClickListener(new View.OnClickListener() { // from class: dc.m03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.X4(this.a, view);
            }
        });
        activityVoiceControlBinding.z.setOnClickListener(new View.OnClickListener() { // from class: dc.xz2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.Y4(activityVoiceControlBinding, this, view);
            }
        });
        activityVoiceControlBinding.g.setOnClickListener(new View.OnClickListener() { // from class: dc.lz2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.Z4(this.a, view);
            }
        });
        activityVoiceControlBinding.D.setText(ah4.e(R.string.button_tips));
        activityVoiceControlBinding.D.setTextColor(z ? ContextCompat.getColor(this, R.color.color_FFFFFFF_30) : ContextCompat.getColor(this, R.color.white));
        activityVoiceControlBinding.k.setOnClickListener(new View.OnClickListener() { // from class: dc.p03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.a5(this.a, view);
            }
        });
        activityVoiceControlBinding.c.postDelayed(new Runnable() { // from class: dc.wz2
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException, ClassNotFoundException {
                VoiceControlActivity.b5(activityVoiceControlBinding, this);
            }
        }, 200L);
        M4();
    }

    public final void c5() {
        c13 c13Var = (c13) y12.c.a().i(y12.c.TYPE_VOICE_CONTROL);
        this.i = c13Var;
        d dVar = new d();
        this.k = dVar;
        if (c13Var != null) {
            c13Var.q(dVar);
            c13Var.r();
        }
    }

    public final void d5(VoiceModelData voiceModelData) {
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.q.setVisibility(8);
        activityVoiceControlBinding.e.setVisibility(0);
        x03 x03Var = x03.a;
        String modelName = voiceModelData.getModelName();
        if (modelName == null) {
            modelName = "";
        }
        boolean zI = x03Var.i(this, modelName);
        x03Var.l(voiceModelData);
        if (voiceModelData.getHasUpdate() || !zI) {
            s6();
            return;
        }
        List<String> listB = q61.b(this, "android.permission.RECORD_AUDIO");
        EventBus.getDefault().post(new DownloadModelEvent(x03.b.COMPLETE));
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding3 = null;
        }
        activityVoiceControlBinding3.j.setVisibility(0);
        if (listB == null || listB.isEmpty()) {
            R4();
            return;
        }
        activityVoiceControlBinding3.B.setVisibility(0);
        ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
        if (activityVoiceControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding2 = activityVoiceControlBinding4;
        }
        if (activityVoiceControlBinding2.n.getVisibility() == 8) {
            ExoPlayer exoPlayerH4 = H4();
            if (exoPlayerH4.getPlaybackState() == 3 || exoPlayerH4.getPlaybackState() == 2) {
                return;
            }
            j6();
        }
    }

    public final boolean e5() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "SimpleDateFormat(\"yyyy-M…Default()).format(Date())");
        if (Intrinsics.areEqual(str, this.p)) {
            this.o++;
        } else {
            this.o = 1;
            this.p = str;
        }
        return this.o <= 10;
    }

    public final void i6() {
        ku1.a("Voice Control", "voice_control_tips_click", "click", "voice_control_tips", "button", null, null, null);
        if (!eg3.d(this, "newGuide", true)) {
            n6();
            return;
        }
        if (I4().B().getValue() != w03.STEP_01) {
            if (this.j == null) {
                this.u.sendEmptyMessageAtTime(6, 200L);
            }
            n6();
            I4().B().setValue(w03.STEP_03);
            ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
            ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
            if (activityVoiceControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVoiceControlBinding = null;
            }
            activityVoiceControlBinding.D.setBackground(ContextCompat.getDrawable(this, R.drawable.voice_control_tips_bg));
            ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
            if (activityVoiceControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding2 = activityVoiceControlBinding3;
            }
            activityVoiceControlBinding2.D.setTextColor(ContextCompat.getColor(this, R.color.white));
            ku1.a("Voice Control", "voice_control_new_guide_exposure", "exposure", "voice_control_new_guide", "text", "5", null, null);
        }
    }

    public final void j6() {
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.n.setVisibility(0);
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding2 = activityVoiceControlBinding3;
        }
        activityVoiceControlBinding2.n.setPlayer(H4());
        MediaItem mediaItemFromUri = MediaItem.fromUri(Uri.parse("asset:///video/voice_control_download.mp4"));
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(uri)");
        H4().addMediaItem(mediaItemFromUri);
        H4().prepare();
    }

    public final void k6() {
        this.b = new ReceiveBroadCast();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        ReceiveBroadCast receiveBroadCast = this.b;
        if (receiveBroadCast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveBroadCast");
            receiveBroadCast = null;
        }
        localBroadcastManager.registerReceiver(receiveBroadCast, new IntentFilter("ACTION_TOY_UPDATE"));
        l6();
    }

    public final void l6() {
        ArrayList<Toy> arrayListP = pc1.a.P();
        ActivityVoiceControlBinding activityVoiceControlBinding = null;
        if (arrayListP.isEmpty()) {
            ActivityVoiceControlBinding activityVoiceControlBinding2 = this.a;
            if (activityVoiceControlBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding2;
            }
            activityVoiceControlBinding.m.setVisibility(0);
            activityVoiceControlBinding.G.setVisibility(8);
            return;
        }
        if (arrayListP.size() == 1) {
            Toy toy = arrayListP.get(0);
            Intrinsics.checkNotNullExpressionValue(toy, "connectList[0]");
            String str = Toy.NAME_MAP.get(toy.getType());
            ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
            if (activityVoiceControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding = activityVoiceControlBinding3;
            }
            activityVoiceControlBinding.m.setVisibility(8);
            activityVoiceControlBinding.G.setVisibility(0);
            activityVoiceControlBinding.G.setText(str);
            return;
        }
        String str2 = arrayListP.size() + " Toys";
        ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
        if (activityVoiceControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding = activityVoiceControlBinding4;
        }
        activityVoiceControlBinding.m.setVisibility(8);
        activityVoiceControlBinding.G.setVisibility(0);
        activityVoiceControlBinding.G.setText(str2);
    }

    public final void m6(y03 y03Var) {
        Drawable drawable;
        if (y03Var == null) {
            return;
        }
        int i2 = a.c[y03Var.ordinal()];
        if (i2 == 1) {
            drawable = ContextCompat.getDrawable(this, R.drawable.ic_vocie_pattern_default);
        } else if (i2 == 2) {
            drawable = ContextCompat.getDrawable(this, R.drawable.ic_voice_pattern_wave);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            drawable = ContextCompat.getDrawable(this, R.drawable.ic_voice_pattern_staight);
        }
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.l.setImageDrawable(drawable);
    }

    public final void n6() {
        Window window;
        CommandBottomDialog commandBottomDialog = new CommandBottomDialog(this);
        this.j = commandBottomDialog;
        WindowManager.LayoutParams attributes = (commandBottomDialog == null || (window = commandBottomDialog.getWindow()) == null) ? null : window.getAttributes();
        if (attributes != null) {
            attributes.dimAmount = 0.0f;
        }
        CommandBottomDialog commandBottomDialog2 = this.j;
        Window window2 = commandBottomDialog2 != null ? commandBottomDialog2.getWindow() : null;
        if (window2 != null) {
            window2.setAttributes(attributes);
        }
        final boolean zD = eg3.d(this, "newGuide", true);
        CommandBottomDialog commandBottomDialog3 = this.j;
        if (commandBottomDialog3 != null) {
            commandBottomDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.v03
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    VoiceControlActivity.o6(zD, this, dialogInterface);
                }
            });
        }
        CommandBottomDialog commandBottomDialog4 = this.j;
        if (commandBottomDialog4 != null) {
            commandBottomDialog4.show();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVoiceControlBinding activityVoiceControlBindingC = ActivityVoiceControlBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityVoiceControlBindingC, "inflate(layoutInflater)");
        this.a = activityVoiceControlBindingC;
        setRequestedOrientation(1);
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        setContentView(activityVoiceControlBinding.getRoot());
        ye3.c("voice control", "into page", null);
        k6();
        LibVosk.setLogLevel(LogLevel.INFO);
        String strH = eg3.h(this, "accessDate", "");
        Intrinsics.checkNotNullExpressionValue(strH, "getString(this, ACCESS_DATE, \"\")");
        this.p = strH;
        this.o = eg3.e(this, "accessCount");
        Q5();
        x03.a.k(this.v);
        Q4();
        boolean zD = eg3.d(this, "newGuide", true);
        I4().K();
        S4(zD);
        c5();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.t) / 1000;
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        boolean z = activityVoiceControlBinding.s.getVisibility() == 8;
        StringBuilder sb = new StringBuilder();
        sb.append(this.m);
        sb.append('_');
        sb.append(this.n);
        String string = sb.toString();
        String str = z ? "1" : "2";
        if (z) {
            jCurrentTimeMillis = 0;
        }
        ye3.j("Voice Control", "voice_control_exit_page", "exit", "", "", string, str, jCurrentTimeMillis);
        eg3.i(this, "accessDate", this.p);
        eg3.k(this, "accessCount", this.o);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        ReceiveBroadCast receiveBroadCast = this.b;
        if (receiveBroadCast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiveBroadCast");
            receiveBroadCast = null;
        }
        localBroadcastManager.unregisterReceiver(receiveBroadCast);
        h14 h14Var = this.e;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        x03.a.m(this.v);
        this.u.removeMessages(2);
        this.u.removeMessages(3);
        this.u.removeMessages(5);
        c13 c13Var = this.i;
        if (c13Var != null) {
            c13Var.s();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        l6();
    }

    public final void p6() {
        PopupWindow popupWindow = this.c;
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
        I4().i0(false);
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.b.setVisibility(8);
        PopupVoiceConfirmBinding popupVoiceConfirmBindingC = PopupVoiceConfirmBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(popupVoiceConfirmBindingC, "inflate(layoutInflater)");
        this.c = new PopupWindow(popupVoiceConfirmBindingC.getRoot(), -1, -2);
        popupVoiceConfirmBindingC.c.setOnClickListener(new View.OnClickListener() { // from class: dc.c03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.q6(this.a, view);
            }
        });
        popupVoiceConfirmBindingC.b.setOnClickListener(new View.OnClickListener() { // from class: dc.qz2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                VoiceControlActivity.r6(this.a, view);
            }
        });
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding3 = null;
        }
        int height = activityVoiceControlBinding3.j.getHeight() + ce3.a(this, 60.0f);
        PopupWindow popupWindow2 = this.c;
        if (popupWindow2 != null) {
            ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
            if (activityVoiceControlBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding2 = activityVoiceControlBinding4;
            }
            popupWindow2.showAtLocation(activityVoiceControlBinding2.j, 80, 0, height);
        }
    }

    public final void s6() {
        j6();
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.p.setVisibility(0);
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding3 = null;
        }
        activityVoiceControlBinding3.u.setOnClickListener(new View.OnClickListener() { // from class: dc.d03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.t6(this.a, view);
            }
        });
        ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
        if (activityVoiceControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVoiceControlBinding2 = activityVoiceControlBinding4;
        }
        activityVoiceControlBinding2.t.setOnClickListener(new View.OnClickListener() { // from class: dc.o03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceControlActivity.u6(this.a, view);
            }
        });
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        kg3.j(this);
        getWindow().setNavigationBarColor(Color.parseColor("#000004"));
    }

    public final void v6(String str) {
        if (this.d == null) {
            PopVocieStartBinding popVocieStartBindingC = PopVocieStartBinding.c(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(popVocieStartBindingC, "inflate(layoutInflater)");
            popVocieStartBindingC.c.setText(str);
            popVocieStartBindingC.b.setOnClickListener(new View.OnClickListener() { // from class: dc.nz2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VoiceControlActivity.w6(this.a, view);
                }
            });
            this.d = new PopupWindow(popVocieStartBindingC.getRoot(), -1, -2);
        }
        PopupWindow popupWindow = this.d;
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
        int[] iArr = new int[2];
        ActivityVoiceControlBinding activityVoiceControlBinding = this.a;
        ActivityVoiceControlBinding activityVoiceControlBinding2 = null;
        if (activityVoiceControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding = null;
        }
        activityVoiceControlBinding.c.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        ActivityVoiceControlBinding activityVoiceControlBinding3 = this.a;
        if (activityVoiceControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVoiceControlBinding3 = null;
        }
        int height = i2 + activityVoiceControlBinding3.c.getHeight();
        PopupWindow popupWindow2 = this.d;
        if (popupWindow2 != null) {
            ActivityVoiceControlBinding activityVoiceControlBinding4 = this.a;
            if (activityVoiceControlBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVoiceControlBinding2 = activityVoiceControlBinding4;
            }
            popupWindow2.showAtLocation(activityVoiceControlBinding2.c, 48, 0, height);
        }
    }

    public final void x6() {
        final int iA = bu2.a(this, 38.0f);
        final float fA = ((getResources().getDisplayMetrics().widthPixels - bu2.a(this, 32.0f)) * 1.0f) / iA;
        ValueAnimator animator = ObjectAnimator.ofInt(0, iA);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.n03
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VoiceControlActivity.y6(this.a, fA, iA, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.addListener(new g());
        animator.setDuration(500L);
        animator.start();
    }

    public final h14 z6(Function1<? super Float, Unit> function1) {
        return v34.n(v34.q(v34.m(v34.k(new j(null)), n04.c()), new k(function1, null)), LifecycleOwnerKt.getLifecycleScope(this));
    }
}
