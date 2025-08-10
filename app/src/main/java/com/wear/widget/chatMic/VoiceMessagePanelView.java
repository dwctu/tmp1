package com.wear.widget.chatMic;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaRecorder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.wear.databinding.ViewVoiceMessagePanelBinding;
import com.wear.ext.ActivityKt;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import dc.ah4;
import dc.gg3;
import dc.q61;
import dc.sg3;
import dc.th4;
import dc.u51;
import dc.xu1;
import dc.yu1;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceMessagePanelView.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\t\"\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0003TUVB\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020(J\u0010\u0010/\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J!\u00100\u001a\u00020(2\u0006\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J$\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\n\b\u0002\u00109\u001a\u0004\u0018\u0001082\b\b\u0002\u0010:\u001a\u00020\u0015J\b\u0010;\u001a\u00020(H\u0002J&\u0010<\u001a\u00020(2\u0006\u00107\u001a\u0002082\n\b\u0002\u00109\u001a\u0004\u0018\u0001082\b\b\u0002\u0010:\u001a\u00020\u0015H\u0002J.\u0010<\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u0010=\u001a\u00020\u000e2\n\b\u0002\u00109\u001a\u0004\u0018\u0001082\b\b\u0002\u0010:\u001a\u00020\u0015H\u0002J\u0006\u0010>\u001a\u00020\u000eJ\b\u0010?\u001a\u00020(H\u0002J0\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020AH\u0002J\b\u0010G\u001a\u00020(H\u0002J\u0018\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u000e\u0010M\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020\u0015H\u0002J\b\u0010P\u001a\u00020(H\u0002J\b\u0010Q\u001a\u00020(H\u0002J\u0010\u0010R\u001a\u00020(2\u0006\u0010O\u001a\u00020\u0015H\u0002J\b\u0010S\u001a\u00020(H\u0002R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0018\u0010$\u001a\u00020\u000e*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006W"}, d2 = {"Lcom/wear/widget/chatMic/VoiceMessagePanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationRunnable", "com/wear/widget/chatMic/VoiceMessagePanelView$animationRunnable$1", "Lcom/wear/widget/chatMic/VoiceMessagePanelView$animationRunnable$1;", "binding", "Lcom/wear/databinding/ViewVoiceMessagePanelBinding;", "countTime", "", "downTime", "", "downX", "", "downY", "hasNavigation", "", "isAnimation", "Ljava/util/concurrent/atomic/AtomicBoolean;", "value", "isCancel", "setCancel", "(Z)V", "isLocked", "longClickRunnable", "Ljava/lang/Runnable;", "recordActionListener", "Lcom/wear/widget/chatMic/VoiceMessagePanelView$RecordActionListener;", "timerRunnable", "com/wear/widget/chatMic/VoiceMessagePanelView$timerRunnable$1", "Lcom/wear/widget/chatMic/VoiceMessagePanelView$timerRunnable$1;", "dp", "getDp", "(I)I", "bindClickButton", "", "button", "Landroid/view/View;", "bindMediaRecorder", "mMediaRecorder", "Landroid/media/MediaRecorder;", "cancelAudioRecord", "changeAnimationViewStatus", "changeSettingBarColor", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "color", "(Landroid/app/Activity;Ljava/lang/Integer;)V", "checkAudioRecordPermission", "checkNavigationHeight", "viewGroup", "Landroid/view/ViewGroup;", "fillViewGroup", "isGroupRoom", "createAnimationView", "fillNavigationHeight", "paddingBottom", "getCountTime", "initListener", "mapRange", "", "x", "inMin", "inMax", "outMin", "outMax", "onDestroy", "onTouch", PSOProgramService.VS_Key, "event", "Landroid/view/MotionEvent;", "setCancelStatusColor", "setRecordActionListener", "showHiddenLockedLayout", "isShow", "startAnimationTimber", "startArrowUpAnimation", "startChatLockedIconAnimate", "startLoopTimer", "Companion", "LongClickRunnable", "RecordActionListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes4.dex */
public final class VoiceMessagePanelView extends ConstraintLayout implements View.OnTouchListener {

    @NotNull
    public final ViewVoiceMessagePanelBinding a;

    @Nullable
    public Runnable b;
    public float c;
    public float d;
    public int e;
    public volatile boolean f;
    public boolean g;

    @Nullable
    public b h;
    public boolean i;
    public long j;

    @NotNull
    public final h k;

    @NotNull
    public final c l;

    @NotNull
    public final AtomicBoolean m;

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/wear/widget/chatMic/VoiceMessagePanelView$LongClickRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Runnable {

        @NotNull
        public final View a;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.performLongClick();
        }
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/wear/widget/chatMic/VoiceMessagePanelView$RecordActionListener;", "", "cancelRecord", "", "sendRecord", "startRecord", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void O();

        void W2();

        void a1();
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/wear/widget/chatMic/VoiceMessagePanelView$animationRunnable$1", "Ljava/lang/Runnable;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceMessagePanelView.this.getVisibility() != 0) {
                return;
            }
            VoiceMessagePanelView.this.s();
            VoiceMessagePanelView.this.postDelayed(this, 500L);
        }
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<View, Unit> {
        public d() {
            super(1);
        }

        public static final void b(View it) {
            Intrinsics.checkNotNullParameter(it, "$it");
            it.setSelected(false);
        }

        public final void a(@NotNull final View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.setSelected(true);
            sg3.o(ah4.e(R.string.tip_fail_to_record));
            VoiceMessagePanelView.this.postDelayed(new Runnable() { // from class: dc.mo3
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceMessagePanelView.d.b(it);
                }
            }, 1500L);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            a(view);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"com/wear/widget/chatMic/VoiceMessagePanelView$checkAudioRecordPermission$1", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "doNotAskAgain", "", "onGranted", "p0", "p1", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements u51 {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            sg3.i(this.a, R.string.chat_record_failure);
        }

        @Override // dc.u51
        public void b(@NotNull List<String> p0, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/widget/chatMic/VoiceMessagePanelView$createAnimationView$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ VoiceMessagePanelAnimationView b;

        public f(VoiceMessagePanelAnimationView voiceMessagePanelAnimationView) {
            this.b = voiceMessagePanelAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            VoiceMessagePanelView.this.a.l.removeView(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/widget/chatMic/VoiceMessagePanelView$startChatLockedIconAnimate$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements Animator.AnimatorListener {
        public final /* synthetic */ boolean b;

        public g(boolean z) {
            this.b = z;
        }

        public static final void b(VoiceMessagePanelView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getVisibility() != 0) {
                return;
            }
            this$0.a.h.setVisibility(4);
            this$0.a.n.setText("");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            VoiceMessagePanelView.this.m.set(false);
            if (VoiceMessagePanelView.this.getVisibility() != 0) {
                return;
            }
            if (this.b) {
                Context context = VoiceMessagePanelView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                xu1.a(context);
                VoiceMessagePanelView.this.a.n.setText(ah4.e(R.string.voice_message_locked));
                final VoiceMessagePanelView voiceMessagePanelView = VoiceMessagePanelView.this;
                voiceMessagePanelView.postDelayed(new Runnable() { // from class: dc.ro3
                    @Override // java.lang.Runnable
                    public final void run() {
                        VoiceMessagePanelView.g.b(voiceMessagePanelView);
                    }
                }, 1000L);
            }
            VoiceMessagePanelView.this.a.g.setVisibility(this.b ? 4 : 0);
            VoiceMessagePanelView.this.a.i.setImageResource(this.b ? R.drawable.chat_function_send : R.drawable.chat_function_record);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: VoiceMessagePanelView.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/wear/widget/chatMic/VoiceMessagePanelView$timerRunnable$1", "Ljava/lang/Runnable;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceMessagePanelView.this.getVisibility() != 0) {
                return;
            }
            VoiceMessagePanelView.this.e++;
            if (VoiceMessagePanelView.this.e >= 60) {
                b bVar = VoiceMessagePanelView.this.h;
                if (bVar != null) {
                    bVar.a1();
                }
                VoiceMessagePanelView.this.I();
                return;
            }
            TextView textView = VoiceMessagePanelView.this.a.k;
            String strE = ah4.e(R.string.chat_record_timer_count);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.chat_record_timer_count)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{Integer.valueOf(VoiceMessagePanelView.this.e)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            textView.setText(str);
            boolean z = VoiceMessagePanelView.this.e >= 50;
            VoiceMessagePanelView.this.a.d.setVisibility(z ? 4 : 0);
            VoiceMessagePanelView.this.a.b.setVisibility(z ? 0 : 4);
            TextView textView2 = VoiceMessagePanelView.this.a.b;
            String strE2 = ah4.e(R.string.voice_message_end_countdown);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.voice_message_end_countdown)");
            String str2 = String.format(strE2, Arrays.copyOf(new Object[]{Integer.valueOf(60 - VoiceMessagePanelView.this.e)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(this, *args)");
            textView2.setText(str2);
            VoiceMessagePanelView.this.postDelayed(this, 1000L);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceMessagePanelView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceMessagePanelView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void K(VoiceMessagePanelView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.a.g.getLayoutParams();
        layoutParams.height = iIntValue;
        this$0.a.g.setLayoutParams(layoutParams);
        if (iIntValue == this$0.v(40)) {
            this$0.a.g.setVisibility(4);
            this$0.N(true);
        }
    }

    public static final boolean i(final VoiceMessagePanelView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        if (this$0.o(context)) {
            return true;
        }
        this$0.M();
        this$0.O();
        this$0.g = false;
        this$0.setCancel(false);
        this$0.a.g.setVisibility(0);
        this$0.a.l.removeAllViews();
        this$0.post(new Runnable() { // from class: dc.po3
            @Override // java.lang.Runnable
            public final void run() {
                VoiceMessagePanelView.j(this.a);
            }
        });
        return true;
    }

    public static final void j(VoiceMessagePanelView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        xu1.a(context);
        this$0.setVisibility(0);
        this$0.L();
        b bVar = this$0.h;
        if (bVar != null) {
            bVar.W2();
        }
        this$0.a.c.g();
    }

    public static /* synthetic */ void q(VoiceMessagePanelView voiceMessagePanelView, ViewGroup viewGroup, ViewGroup viewGroup2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            viewGroup2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        voiceMessagePanelView.p(viewGroup, viewGroup2, z);
    }

    public static final void r(Activity activity, ViewGroup viewGroup, VoiceMessagePanelView this$0, ViewGroup viewGroup2, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(viewGroup, "$viewGroup");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int iC = gg3.c(activity);
        int[] iArr = new int[2];
        viewGroup.getLocationInWindow(iArr);
        int height = iArr[1] + viewGroup.getHeight();
        String str = "fillNavigationHeight: screenHeight = " + iC + " , y=" + (iArr[1] + viewGroup.getHeight()) + " , height=" + viewGroup.getHeight();
        this$0.i = height < iC;
        this$0.u(viewGroup, viewGroup2, z);
    }

    private final void setCancel(boolean z) {
        if (this.f == z) {
            return;
        }
        this.f = z;
        setCancelStatusColor(z);
    }

    private final void setCancelStatusColor(boolean isCancel) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityA = ActivityKt.a(context);
        if (activityA == null) {
            return;
        }
        n(activityA, isCancel ? Integer.valueOf(th4.b(getContext(), R.color.voice_message_panel_setting_bar)) : null);
        this.a.g.setSelected(isCancel);
        this.a.d.setSelected(isCancel);
        this.a.c.setSelected(isCancel);
        m(isCancel);
        if (isCancel) {
            this.a.e.setBackground(th4.d(getContext(), R.drawable.bg_audio_view_topper));
        } else {
            this.a.e.setBackground(th4.d(getContext(), R.drawable.bg_audio_view_bottom));
        }
        this.a.n.setText(ah4.e(isCancel ? R.string.voice_message_release_cancel : R.string.voice_message_release_send));
        if (isCancel) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            xu1.a(context2);
        }
    }

    public static final void x(View view) {
    }

    public static final void y(VoiceMessagePanelView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.g) {
            b bVar = this$0.h;
            if (bVar != null) {
                bVar.a1();
            }
            this$0.I();
        }
    }

    public static final void z(VoiceMessagePanelView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.h;
        if (bVar != null) {
            bVar.O();
        }
        this$0.I();
    }

    public final double H(double d2, double d3, double d4, double d5, double d6) {
        return (((d2 - d3) * (d6 - d5)) / (d4 - d3)) + d5;
    }

    public final void I() {
        removeCallbacks(this.k);
        removeCallbacks(this.l);
        this.a.d.setVisibility(0);
        this.a.b.setVisibility(8);
        this.a.i.setImageResource(R.drawable.chat_function_record);
        J(false);
        setCancelStatusColor(false);
        this.a.c.h();
        setVisibility(8);
    }

    public final void J(boolean z) {
        if (this.m.get()) {
            return;
        }
        this.m.set(true);
        this.a.h.setVisibility(0);
        if (!z) {
            N(false);
            ViewGroup.LayoutParams layoutParams = this.a.g.getLayoutParams();
            layoutParams.height = v(80);
            this.a.g.setLayoutParams(layoutParams);
            this.a.g.setVisibility(0);
            return;
        }
        this.g = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(v(80), v(40));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.qo3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VoiceMessagePanelView.K(this.a, valueAnimator);
            }
        });
        Unit unit = Unit.INSTANCE;
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.start();
    }

    public final void L() {
        removeCallbacks(this.l);
        post(this.l);
    }

    public final void M() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -v(5));
        translateAnimation.setDuration(500L);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        this.a.f.startAnimation(translateAnimation);
    }

    public final void N(boolean z) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.a.h.animate();
        viewPropertyAnimatorAnimate.setListener(new g(z));
        float f2 = z ? 1.5f : 1.0f;
        viewPropertyAnimatorAnimate.translationY(z ? -v(40) : 0.0f).setDuration(300L).scaleX(f2).scaleY(f2).start();
    }

    public final void O() {
        this.e = 0;
        TextView textView = this.a.k;
        String strE = ah4.e(R.string.chat_record_timer_count);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.chat_record_timer_count)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{Integer.valueOf(this.e)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        textView.setText(str);
        removeCallbacks(this.k);
        postDelayed(this.k, 1000L);
    }

    /* renamed from: getCountTime, reason: from getter */
    public final int getE() {
        return this.e;
    }

    public final void h(@NotNull View button) {
        Intrinsics.checkNotNullParameter(button, "button");
        yu1.b(button, 3000, false, new d(), 2, null);
        this.b = new a(button);
        button.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.oo3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return VoiceMessagePanelView.i(this.a, view);
            }
        });
        button.setOnTouchListener(this);
    }

    public final void k(@Nullable MediaRecorder mediaRecorder) {
        if (mediaRecorder != null) {
            this.a.c.c(mediaRecorder);
        }
    }

    public final void l() {
        if (getVisibility() != 0) {
            return;
        }
        b bVar = this.h;
        if (bVar != null) {
            bVar.O();
        }
        I();
    }

    public final void m(boolean z) {
        this.a.m.setCancel(z);
        int childCount = this.a.l.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.l.getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.wear.widget.chatMic.VoiceMessagePanelAnimationView");
            ((VoiceMessagePanelAnimationView) childAt).setCancel(z);
        }
    }

    public final void n(Activity activity, Integer num) {
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        window.setNavigationBarColor(num != null ? num.intValue() : th4.b(getContext(), R.color.lvs_ui_standard_systemBackground2));
    }

    public final boolean o(Context context) {
        if (q61.f(context, "android.permission.RECORD_AUDIO")) {
            return false;
        }
        q61 q61VarM = q61.m(context);
        q61VarM.h("android.permission.RECORD_AUDIO");
        q61VarM.j(new e(context));
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View v, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            Runnable runnable = this.b;
            if (runnable != null) {
                getHandler().removeCallbacks(runnable);
            }
            this.j = System.currentTimeMillis();
            this.c = event.getX();
            this.d = event.getY();
            Runnable runnable2 = this.b;
            if (runnable2 != null) {
                getHandler().postDelayed(runnable2, 200L);
            }
        }
        int action = event.getAction();
        boolean z = false;
        if (action == 1) {
            Runnable runnable3 = this.b;
            if (runnable3 != null) {
                getHandler().removeCallbacks(runnable3);
            }
            if (getVisibility() != 0 || this.g) {
                if (System.currentTimeMillis() - this.j < 200) {
                    v.performClick();
                }
                return false;
            }
            if (this.f) {
                b bVar = this.h;
                if (bVar != null) {
                    bVar.O();
                }
            } else {
                b bVar2 = this.h;
                if (bVar2 != null) {
                    bVar2.a1();
                }
            }
            I();
        } else if (action == 2) {
            if (getVisibility() != 0 || this.g) {
                return false;
            }
            float x = event.getX();
            float y = event.getY();
            float f2 = x - this.c;
            float f3 = y - this.d;
            int measuredWidth = getMeasuredWidth() / 3;
            setCancel(measuredWidth != 0 && Math.abs(f2) > ((float) measuredWidth));
            int iV = v(30);
            int iV2 = v(58);
            if (f3 < (-iV) && Math.abs(f2) < iV2) {
                z = true;
            }
            J(z);
        }
        return true;
    }

    public final void p(@NotNull final ViewGroup viewGroup, @Nullable final ViewGroup viewGroup2, final boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        final Activity activityA = ActivityKt.a(context);
        if (activityA == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: dc.no3
            @Override // java.lang.Runnable
            public final void run() {
                VoiceMessagePanelView.r(activityA, viewGroup, this, viewGroup2, z);
            }
        });
    }

    public final void s() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VoiceMessagePanelAnimationView voiceMessagePanelAnimationView = new VoiceMessagePanelAnimationView(context, null, 2, 0 == true ? 1 : 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, v(50));
        layoutParams.gravity = 80;
        voiceMessagePanelAnimationView.setLayoutParams(layoutParams);
        voiceMessagePanelAnimationView.setCancel(this.f);
        ViewPropertyAnimator viewPropertyAnimatorAnimate = voiceMessagePanelAnimationView.animate();
        viewPropertyAnimatorAnimate.setListener(new f(voiceMessagePanelAnimationView));
        viewPropertyAnimatorAnimate.translationY(-v((int) H(this.a.c.getL(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 25.0d, 40.0d))).setDuration(1000L).alpha(0.0f).start();
        this.a.l.addView(voiceMessagePanelAnimationView);
    }

    public final void setRecordActionListener(@NotNull b recordActionListener) {
        Intrinsics.checkNotNullParameter(recordActionListener, "recordActionListener");
        this.h = recordActionListener;
    }

    public final void t(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
        viewGroup.setPadding(0, 0, 0, i);
        int iV = v(15);
        this.a.e.setPadding(iV, 0, iV, i);
        if (viewGroup2 != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int dimensionPixelSize = z ? 0 : viewGroup2.getResources().getDimensionPixelSize(R.dimen.chat_input_panel_height);
            if (i != 0) {
                dimensionPixelSize += i;
            }
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, dimensionPixelSize);
        }
    }

    public final void u(ViewGroup viewGroup, ViewGroup viewGroup2, boolean z) {
        t(viewGroup, !this.i ? v(20) : 0, viewGroup2, z);
    }

    public final int v(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void w() {
        setOnClickListener(new View.OnClickListener() { // from class: dc.jo3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceMessagePanelView.x(view);
            }
        });
        this.a.i.setOnClickListener(new View.OnClickListener() { // from class: dc.lo3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceMessagePanelView.y(this.a, view);
            }
        });
        this.a.j.setOnClickListener(new View.OnClickListener() { // from class: dc.ko3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceMessagePanelView.z(this.a, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceMessagePanelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewVoiceMessagePanelBinding viewVoiceMessagePanelBindingC = ViewVoiceMessagePanelBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewVoiceMessagePanelBindingC, "inflate(LayoutInflater.from(context), this, true)");
        this.a = viewVoiceMessagePanelBindingC;
        w();
        this.k = new h();
        this.l = new c();
        this.m = new AtomicBoolean(false);
    }
}
