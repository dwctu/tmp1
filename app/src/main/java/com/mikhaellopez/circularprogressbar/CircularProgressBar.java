package com.mikhaellopez.circularprogressbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.widget.control.FingImageLayout;
import dc.cd1;
import dc.dd1;
import dc.ed1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: CircularProgressBar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0094\u0001©\u0001B\u001c\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0005\b¬\u0001\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010\u0004J!\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010\u0004J'\u0010\u0007\u001a\u00020-2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b\u0007\u0010.J\u0013\u0010/\u001a\u00020\u0017*\u00020\u0017H\u0002¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\u0017*\u00020\u0017H\u0002¢\u0006\u0004\b1\u00100J\u0013\u00103\u001a\u000202*\u00020\u0005H\u0002¢\u0006\u0004\b3\u00104J\u0013\u00105\u001a\u000202*\u000202H\u0002¢\u0006\u0004\b5\u00106J\u0013\u00108\u001a\u000207*\u000202H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020+*\u00020\u0005H\u0002¢\u0006\u0004\b:\u0010;R$\u0010A\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010H\u001a\u0002022\u0006\u0010<\u001a\u0002028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR*\u0010L\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010>\u001a\u0004\bI\u0010J\"\u0004\bK\u0010@R*\u0010O\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010>\u001a\u0004\bM\u0010J\"\u0004\bN\u0010@R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR$\u0010V\u001a\u0002022\u0006\u0010<\u001a\u0002028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bT\u0010C\"\u0004\bU\u0010GR0\u0010]\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0002\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010b\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010\u0012R*\u0010h\u001a\u00020+2\u0006\u0010<\u001a\u00020+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR.\u0010n\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR*\u0010t\u001a\u0002072\u0006\u0010<\u001a\u0002078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR.\u0010{\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010i\u001a\u0004\by\u0010k\"\u0004\bz\u0010mR\u0016\u0010}\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010RR/\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010i\u001a\u0004\b~\u0010k\"\u0004\b\u007f\u0010mR1\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b5\u0010i\u001a\u0005\b\u0081\u0001\u0010k\"\u0005\b\u0082\u0001\u0010mR.\u0010\u0087\u0001\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010>\u001a\u0005\b\u0085\u0001\u0010J\"\u0005\b\u0086\u0001\u0010@R.\u0010\u008b\u0001\u001a\u0002072\u0006\u0010<\u001a\u0002078\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010o\u001a\u0005\b\u0089\u0001\u0010q\"\u0005\b\u008a\u0001\u0010sR-\u0010\u008e\u0001\u001a\u00020+2\u0006\u0010<\u001a\u00020+8\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010c\u001a\u0005\b\u008c\u0001\u0010e\"\u0005\b\u008d\u0001\u0010gR.\u0010\u0092\u0001\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010>\u001a\u0005\b\u0090\u0001\u0010J\"\u0005\b\u0091\u0001\u0010@R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R-\u0010\u0018\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010>\u001a\u0005\b\u0098\u0001\u0010J\"\u0005\b\u0099\u0001\u0010@R\u001a\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R-\u0010 \u0001\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b%\u0010^\u001a\u0005\b\u009e\u0001\u0010`\"\u0005\b\u009f\u0001\u0010\u0012R4\u0010¤\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0002\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010X\u001a\u0005\b¢\u0001\u0010Z\"\u0005\b£\u0001\u0010\\R'\u0010§\u0001\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00178\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\b¥\u0001\u0010>\"\u0005\b¦\u0001\u0010@R\u001c\u0010«\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lcom/mikhaellopez/circularprogressbar/CircularProgressBar;", "Landroid/view/View;", "", "onDetachedFromWindow", "()V", "", "w", XHTMLText.H, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "setBackgroundColor", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "progress", "", TypedValues.TransitionType.S_DURATION, "Landroid/animation/TimeInterpolator;", "interpolator", "startDelay", "setProgressWithAnimation", "(FLjava/lang/Long;Landroid/animation/TimeInterpolator;Ljava/lang/Long;)V", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "j", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "m", "l", "startColor", "endColor", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;", "gradientDirection", "Landroid/graphics/LinearGradient;", "(IILcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;)Landroid/graphics/LinearGradient;", "i", "(F)F", "o", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;", StreamManagement.AckRequest.ELEMENT, "(I)Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;", "p", "(Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;)Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;", "", "k", "(Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;)Z", XHTMLText.Q, "(I)Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;", "value", "z", "F", "setStartAngleIndeterminateMode", "(F)V", "startAngleIndeterminateMode", "t", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;", "getProgressDirection", "()Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;", "setProgressDirection", "(Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;)V", "progressDirection", "getProgressBarWidth", "()F", "setProgressBarWidth", "progressBarWidth", "getBackgroundProgressBarWidth", "setBackgroundProgressBarWidth", "backgroundProgressBarWidth", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "foregroundPaint", FingImageLayout.ObjectAnimatorY, "setProgressDirectionIndeterminateMode", "progressDirectionIndeterminateMode", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnIndeterminateModeChangeListener", "()Lkotlin/jvm/functions/Function1;", "setOnIndeterminateModeChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "onIndeterminateModeChangeListener", "I", "getBackgroundProgressBarColor", "()I", "setBackgroundProgressBarColor", "backgroundProgressBarColor", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;", "getProgressBarColorDirection", "()Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;", "setProgressBarColorDirection", "(Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;)V", "progressBarColorDirection", "Ljava/lang/Integer;", "getProgressBarColorEnd", "()Ljava/lang/Integer;", "setProgressBarColorEnd", "(Ljava/lang/Integer;)V", "progressBarColorEnd", "Z", "getRoundBorder", "()Z", "setRoundBorder", "(Z)V", "roundBorder", "Ljava/lang/Runnable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Runnable;", "indeterminateModeRunnable", "getProgressBarColorStart", "setProgressBarColorStart", "progressBarColorStart", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "backgroundPaint", "getBackgroundProgressBarColorStart", "setBackgroundProgressBarColorStart", "backgroundProgressBarColorStart", "getBackgroundProgressBarColorEnd", "setBackgroundProgressBarColorEnd", "backgroundProgressBarColorEnd", "g", "getProgressMax", "setProgressMax", "progressMax", "u", "getIndeterminateMode", "setIndeterminateMode", "indeterminateMode", "getBackgroundProgressBarColorDirection", "setBackgroundProgressBarColorDirection", "backgroundProgressBarColorDirection", "s", "getStartAngle", "setStartAngle", "startAngle", "Landroid/animation/ValueAnimator;", "a", "Landroid/animation/ValueAnimator;", "progressAnimator", "f", "getProgress", "setProgress", "Landroid/graphics/RectF;", "c", "Landroid/graphics/RectF;", "rectF", "getProgressBarColor", "setProgressBarColor", "progressBarColor", PSOProgramService.VS_Key, "getOnProgressChangeListener", "setOnProgressChangeListener", "onProgressChangeListener", "x", "setProgressIndeterminateMode", "progressIndeterminateMode", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "indeterminateModeHandler", "<init>", "circularprogressbar_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CircularProgressBar extends View {

    /* renamed from: A, reason: from kotlin metadata */
    public final Runnable indeterminateModeRunnable;

    /* renamed from: a, reason: from kotlin metadata */
    public ValueAnimator progressAnimator;

    /* renamed from: b, reason: from kotlin metadata */
    public Handler indeterminateModeHandler;

    /* renamed from: c, reason: from kotlin metadata */
    public RectF rectF;

    /* renamed from: d, reason: from kotlin metadata */
    public Paint backgroundPaint;

    /* renamed from: e, reason: from kotlin metadata */
    public Paint foregroundPaint;

    /* renamed from: f, reason: from kotlin metadata */
    public float progress;

    /* renamed from: g, reason: from kotlin metadata */
    public float progressMax;

    /* renamed from: h, reason: from kotlin metadata */
    public float progressBarWidth;

    /* renamed from: i, reason: from kotlin metadata */
    public float backgroundProgressBarWidth;

    /* renamed from: j, reason: from kotlin metadata */
    public int progressBarColor;

    /* renamed from: k, reason: from kotlin metadata */
    @Nullable
    public Integer progressBarColorStart;

    /* renamed from: l, reason: from kotlin metadata */
    @Nullable
    public Integer progressBarColorEnd;

    /* renamed from: m, reason: from kotlin metadata */
    @NotNull
    public a progressBarColorDirection;

    /* renamed from: n, reason: from kotlin metadata */
    public int backgroundProgressBarColor;

    /* renamed from: o, reason: from kotlin metadata */
    @Nullable
    public Integer backgroundProgressBarColorStart;

    /* renamed from: p, reason: from kotlin metadata */
    @Nullable
    public Integer backgroundProgressBarColorEnd;

    /* renamed from: q, reason: from kotlin metadata */
    @NotNull
    public a backgroundProgressBarColorDirection;

    /* renamed from: r, reason: from kotlin metadata */
    public boolean roundBorder;

    /* renamed from: s, reason: from kotlin metadata */
    public float startAngle;

    /* renamed from: t, reason: from kotlin metadata */
    @NotNull
    public b progressDirection;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean indeterminateMode;

    /* renamed from: v, reason: from kotlin metadata */
    @Nullable
    public Function1<? super Float, Unit> onProgressChangeListener;

    /* renamed from: w, reason: from kotlin metadata */
    @Nullable
    public Function1<? super Boolean, Unit> onIndeterminateModeChangeListener;

    /* renamed from: x, reason: from kotlin metadata */
    public float progressIndeterminateMode;

    /* renamed from: y, reason: from kotlin metadata */
    public b progressDirectionIndeterminateMode;

    /* renamed from: z, reason: from kotlin metadata */
    public float startAngleIndeterminateMode;

    /* compiled from: CircularProgressBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/mikhaellopez/circularprogressbar/CircularProgressBar$a", "", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$a;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "TOP_TO_BOTTOM", "BOTTOM_TO_END", "circularprogressbar_release"}, k = 1, mv = {1, 4, 0})
    public enum a {
        LEFT_TO_RIGHT(1),
        RIGHT_TO_LEFT(2),
        TOP_TO_BOTTOM(3),
        BOTTOM_TO_END(4);

        private final int value;

        a(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: CircularProgressBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/mikhaellopez/circularprogressbar/CircularProgressBar$b", "", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar$b;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "TO_RIGHT", "TO_LEFT", "circularprogressbar_release"}, k = 1, mv = {1, 4, 0})
    public enum b {
        TO_RIGHT(1),
        TO_LEFT(2);

        private final int value;

        b(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: CircularProgressBar.kt */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CircularProgressBar.this.getIndeterminateMode()) {
                CircularProgressBar.this.n();
                CircularProgressBar circularProgressBar = CircularProgressBar.this;
                circularProgressBar.setProgressDirectionIndeterminateMode(circularProgressBar.p(circularProgressBar.progressDirectionIndeterminateMode));
                CircularProgressBar circularProgressBar2 = CircularProgressBar.this;
                if (circularProgressBar2.k(circularProgressBar2.progressDirectionIndeterminateMode)) {
                    CircularProgressBar.setProgressWithAnimation$default(CircularProgressBar.this, 0.0f, 1500L, null, null, 12, null);
                } else {
                    CircularProgressBar circularProgressBar3 = CircularProgressBar.this;
                    CircularProgressBar.setProgressWithAnimation$default(circularProgressBar3, circularProgressBar3.getProgressMax(), 1500L, null, null, 12, null);
                }
            }
        }
    }

    /* compiled from: CircularProgressBar.kt */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkExpressionValueIsNotNull(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (!(animatedValue instanceof Float)) {
                animatedValue = null;
            }
            Float f = (Float) animatedValue;
            if (f != null) {
                float fFloatValue = f.floatValue();
                if (CircularProgressBar.this.getIndeterminateMode()) {
                    CircularProgressBar.this.setProgressIndeterminateMode(fFloatValue);
                } else {
                    CircularProgressBar.this.setProgress(fFloatValue);
                }
                if (CircularProgressBar.this.getIndeterminateMode()) {
                    float f2 = (fFloatValue * 360) / 100;
                    CircularProgressBar circularProgressBar = CircularProgressBar.this;
                    if (!circularProgressBar.k(circularProgressBar.progressDirectionIndeterminateMode)) {
                        f2 = -f2;
                    }
                    circularProgressBar.setStartAngleIndeterminateMode(f2 + 270.0f);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.rectF = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        this.backgroundPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.foregroundPaint = paint2;
        this.progressMax = 100.0f;
        this.progressBarWidth = getResources().getDimension(dd1.default_stroke_width);
        this.backgroundProgressBarWidth = getResources().getDimension(dd1.default_background_stroke_width);
        this.progressBarColor = ViewCompat.MEASURED_STATE_MASK;
        a aVar = a.LEFT_TO_RIGHT;
        this.progressBarColorDirection = aVar;
        this.backgroundProgressBarColor = -7829368;
        this.backgroundProgressBarColorDirection = aVar;
        this.startAngle = 270.0f;
        b bVar = b.TO_RIGHT;
        this.progressDirection = bVar;
        this.progressDirectionIndeterminateMode = bVar;
        this.startAngleIndeterminateMode = 270.0f;
        this.indeterminateModeRunnable = new c();
        j(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setProgressDirectionIndeterminateMode(b bVar) {
        this.progressDirectionIndeterminateMode = bVar;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setProgressIndeterminateMode(float f) {
        this.progressIndeterminateMode = f;
        invalidate();
    }

    public static /* synthetic */ void setProgressWithAnimation$default(CircularProgressBar circularProgressBar, float f, Long l, TimeInterpolator timeInterpolator, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            timeInterpolator = null;
        }
        if ((i & 8) != 0) {
            l2 = null;
        }
        circularProgressBar.setProgressWithAnimation(f, l, timeInterpolator, l2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStartAngleIndeterminateMode(float f) {
        this.startAngleIndeterminateMode = f;
        invalidate();
    }

    public final int getBackgroundProgressBarColor() {
        return this.backgroundProgressBarColor;
    }

    @NotNull
    public final a getBackgroundProgressBarColorDirection() {
        return this.backgroundProgressBarColorDirection;
    }

    @Nullable
    public final Integer getBackgroundProgressBarColorEnd() {
        return this.backgroundProgressBarColorEnd;
    }

    @Nullable
    public final Integer getBackgroundProgressBarColorStart() {
        return this.backgroundProgressBarColorStart;
    }

    public final float getBackgroundProgressBarWidth() {
        return this.backgroundProgressBarWidth;
    }

    public final boolean getIndeterminateMode() {
        return this.indeterminateMode;
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnIndeterminateModeChangeListener() {
        return this.onIndeterminateModeChangeListener;
    }

    @Nullable
    public final Function1<Float, Unit> getOnProgressChangeListener() {
        return this.onProgressChangeListener;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getProgressBarColor() {
        return this.progressBarColor;
    }

    @NotNull
    public final a getProgressBarColorDirection() {
        return this.progressBarColorDirection;
    }

    @Nullable
    public final Integer getProgressBarColorEnd() {
        return this.progressBarColorEnd;
    }

    @Nullable
    public final Integer getProgressBarColorStart() {
        return this.progressBarColorStart;
    }

    public final float getProgressBarWidth() {
        return this.progressBarWidth;
    }

    @NotNull
    public final b getProgressDirection() {
        return this.progressDirection;
    }

    public final float getProgressMax() {
        return this.progressMax;
    }

    public final boolean getRoundBorder() {
        return this.roundBorder;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }

    public final LinearGradient h(int startColor, int endColor, a gradientDirection) {
        float width;
        float width2;
        float height;
        float height2;
        int i = cd1.a[gradientDirection.ordinal()];
        if (i != 1) {
            if (i == 2) {
                width2 = getWidth();
            } else {
                if (i == 3) {
                    height2 = getHeight();
                    width2 = 0.0f;
                    height = 0.0f;
                    width = 0.0f;
                    return new LinearGradient(width2, height, width, height2, startColor, endColor, Shader.TileMode.CLAMP);
                }
                if (i != 4) {
                    width2 = 0.0f;
                } else {
                    height = getHeight();
                    width2 = 0.0f;
                    width = 0.0f;
                }
            }
            height = 0.0f;
            width = 0.0f;
        } else {
            width = getWidth();
            width2 = 0.0f;
            height = 0.0f;
        }
        height2 = 0.0f;
        return new LinearGradient(width2, height, width, height2, startColor, endColor, Shader.TileMode.CLAMP);
    }

    public final float i(float f) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return f * system.getDisplayMetrics().density;
    }

    public final void j(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, ed1.CircularProgressBar, 0, 0);
        Intrinsics.checkExpressionValueIsNotNull(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…ircularProgressBar, 0, 0)");
        setProgress(typedArrayObtainStyledAttributes.getFloat(ed1.CircularProgressBar_cpb_progress, this.progress));
        setProgressMax(typedArrayObtainStyledAttributes.getFloat(ed1.CircularProgressBar_cpb_progress_max, this.progressMax));
        setProgressBarWidth(o(typedArrayObtainStyledAttributes.getDimension(ed1.CircularProgressBar_cpb_progressbar_width, this.progressBarWidth)));
        setBackgroundProgressBarWidth(o(typedArrayObtainStyledAttributes.getDimension(ed1.CircularProgressBar_cpb_background_progressbar_width, this.backgroundProgressBarWidth)));
        setProgressBarColor(typedArrayObtainStyledAttributes.getInt(ed1.CircularProgressBar_cpb_progressbar_color, this.progressBarColor));
        int color = typedArrayObtainStyledAttributes.getColor(ed1.CircularProgressBar_cpb_progressbar_color_start, 0);
        if (color != 0) {
            setProgressBarColorStart(Integer.valueOf(color));
        }
        int color2 = typedArrayObtainStyledAttributes.getColor(ed1.CircularProgressBar_cpb_progressbar_color_end, 0);
        if (color2 != 0) {
            setProgressBarColorEnd(Integer.valueOf(color2));
        }
        setProgressBarColorDirection(q(typedArrayObtainStyledAttributes.getInteger(ed1.CircularProgressBar_cpb_progressbar_color_direction, this.progressBarColorDirection.getValue())));
        setBackgroundProgressBarColor(typedArrayObtainStyledAttributes.getInt(ed1.CircularProgressBar_cpb_background_progressbar_color, this.backgroundProgressBarColor));
        int color3 = typedArrayObtainStyledAttributes.getColor(ed1.CircularProgressBar_cpb_background_progressbar_color_start, 0);
        if (color3 != 0) {
            setBackgroundProgressBarColorStart(Integer.valueOf(color3));
        }
        int color4 = typedArrayObtainStyledAttributes.getColor(ed1.CircularProgressBar_cpb_background_progressbar_color_end, 0);
        if (color4 != 0) {
            setBackgroundProgressBarColorEnd(Integer.valueOf(color4));
        }
        setBackgroundProgressBarColorDirection(q(typedArrayObtainStyledAttributes.getInteger(ed1.CircularProgressBar_cpb_background_progressbar_color_direction, this.backgroundProgressBarColorDirection.getValue())));
        setProgressDirection(r(typedArrayObtainStyledAttributes.getInteger(ed1.CircularProgressBar_cpb_progress_direction, this.progressDirection.getValue())));
        setRoundBorder(typedArrayObtainStyledAttributes.getBoolean(ed1.CircularProgressBar_cpb_round_border, this.roundBorder));
        setStartAngle(typedArrayObtainStyledAttributes.getFloat(ed1.CircularProgressBar_cpb_start_angle, 0.0f));
        setIndeterminateMode(typedArrayObtainStyledAttributes.getBoolean(ed1.CircularProgressBar_cpb_indeterminate_mode, this.indeterminateMode));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean k(@NotNull b bVar) {
        return bVar == b.TO_RIGHT;
    }

    public final void l() {
        Paint paint = this.backgroundPaint;
        Integer num = this.backgroundProgressBarColorStart;
        int iIntValue = num != null ? num.intValue() : this.backgroundProgressBarColor;
        Integer num2 = this.backgroundProgressBarColorEnd;
        paint.setShader(h(iIntValue, num2 != null ? num2.intValue() : this.backgroundProgressBarColor, this.backgroundProgressBarColorDirection));
    }

    public final void m() {
        Paint paint = this.foregroundPaint;
        Integer num = this.progressBarColorStart;
        int iIntValue = num != null ? num.intValue() : this.progressBarColor;
        Integer num2 = this.progressBarColorEnd;
        paint.setShader(h(iIntValue, num2 != null ? num2.intValue() : this.progressBarColor, this.progressBarColorDirection));
    }

    public final void n() {
        Handler handler = this.indeterminateModeHandler;
        if (handler != null) {
            handler.postDelayed(this.indeterminateModeRunnable, 1500L);
        }
    }

    public final float o(float f) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return f / system.getDisplayMetrics().density;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.progressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler = this.indeterminateModeHandler;
        if (handler != null) {
            handler.removeCallbacks(this.indeterminateModeRunnable);
        }
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawOval(this.rectF, this.backgroundPaint);
        boolean z = this.indeterminateMode;
        canvas.drawArc(this.rectF, this.indeterminateMode ? this.startAngleIndeterminateMode : this.startAngle, ((((z && k(this.progressDirectionIndeterminateMode)) || (!this.indeterminateMode && k(this.progressDirection))) ? 360 : -360) * (((z ? this.progressIndeterminateMode : this.progress) * 100.0f) / this.progressMax)) / 100, false, this.foregroundPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMin = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), View.getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        setMeasuredDimension(iMin, iMin);
        float f = this.progressBarWidth;
        float f2 = this.backgroundProgressBarWidth;
        if (f <= f2) {
            f = f2;
        }
        float f3 = f / 2;
        float f4 = 0 + f3;
        float f5 = iMin - f3;
        this.rectF.set(f4, f4, f5, f5);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        m();
        l();
        invalidate();
    }

    public final b p(@NotNull b bVar) {
        return k(bVar) ? b.TO_LEFT : b.TO_RIGHT;
    }

    public final a q(int i) {
        if (i == 1) {
            return a.LEFT_TO_RIGHT;
        }
        if (i == 2) {
            return a.RIGHT_TO_LEFT;
        }
        if (i == 3) {
            return a.TOP_TO_BOTTOM;
        }
        if (i == 4) {
            return a.BOTTOM_TO_END;
        }
        throw new IllegalArgumentException("This value is not supported for GradientDirection: " + i);
    }

    public final b r(int i) {
        if (i == 1) {
            return b.TO_RIGHT;
        }
        if (i == 2) {
            return b.TO_LEFT;
        }
        throw new IllegalArgumentException("This value is not supported for ProgressDirection: " + i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int backgroundColor) {
        setBackgroundProgressBarColor(backgroundColor);
    }

    public final void setBackgroundProgressBarColor(int i) {
        this.backgroundProgressBarColor = i;
        l();
        invalidate();
    }

    public final void setBackgroundProgressBarColorDirection(@NotNull a value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.backgroundProgressBarColorDirection = value;
        l();
        invalidate();
    }

    public final void setBackgroundProgressBarColorEnd(@Nullable Integer num) {
        this.backgroundProgressBarColorEnd = num;
        l();
        invalidate();
    }

    public final void setBackgroundProgressBarColorStart(@Nullable Integer num) {
        this.backgroundProgressBarColorStart = num;
        l();
        invalidate();
    }

    public final void setBackgroundProgressBarWidth(float f) {
        float fI = i(f);
        this.backgroundProgressBarWidth = fI;
        this.backgroundPaint.setStrokeWidth(fI);
        requestLayout();
        invalidate();
    }

    public final void setIndeterminateMode(boolean z) {
        this.indeterminateMode = z;
        Function1<? super Boolean, Unit> function1 = this.onIndeterminateModeChangeListener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        setProgressIndeterminateMode(0.0f);
        setProgressDirectionIndeterminateMode(b.TO_RIGHT);
        setStartAngleIndeterminateMode(270.0f);
        Handler handler = this.indeterminateModeHandler;
        if (handler != null) {
            handler.removeCallbacks(this.indeterminateModeRunnable);
        }
        ValueAnimator valueAnimator = this.progressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler2 = new Handler();
        this.indeterminateModeHandler = handler2;
        if (!this.indeterminateMode || handler2 == null) {
            return;
        }
        handler2.post(this.indeterminateModeRunnable);
    }

    public final void setOnIndeterminateModeChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onIndeterminateModeChangeListener = function1;
    }

    public final void setOnProgressChangeListener(@Nullable Function1<? super Float, Unit> function1) {
        this.onProgressChangeListener = function1;
    }

    public final void setProgress(float f) {
        float f2 = this.progress;
        float f3 = this.progressMax;
        if (f2 > f3) {
            f = f3;
        }
        this.progress = f;
        Function1<? super Float, Unit> function1 = this.onProgressChangeListener;
        if (function1 != null) {
            function1.invoke(Float.valueOf(f));
        }
        invalidate();
    }

    public final void setProgressBarColor(int i) {
        this.progressBarColor = i;
        m();
        invalidate();
    }

    public final void setProgressBarColorDirection(@NotNull a value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.progressBarColorDirection = value;
        m();
        invalidate();
    }

    public final void setProgressBarColorEnd(@Nullable Integer num) {
        this.progressBarColorEnd = num;
        m();
        invalidate();
    }

    public final void setProgressBarColorStart(@Nullable Integer num) {
        this.progressBarColorStart = num;
        m();
        invalidate();
    }

    public final void setProgressBarWidth(float f) {
        float fI = i(f);
        this.progressBarWidth = fI;
        this.foregroundPaint.setStrokeWidth(fI);
        requestLayout();
        invalidate();
    }

    public final void setProgressDirection(@NotNull b value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.progressDirection = value;
        invalidate();
    }

    public final void setProgressMax(float f) {
        if (this.progressMax < 0) {
            f = 100.0f;
        }
        this.progressMax = f;
        invalidate();
    }

    @JvmOverloads
    public final void setProgressWithAnimation(float f) {
        setProgressWithAnimation$default(this, f, null, null, null, 14, null);
    }

    @JvmOverloads
    public final void setProgressWithAnimation(float f, @Nullable Long l) {
        setProgressWithAnimation$default(this, f, l, null, null, 12, null);
    }

    @JvmOverloads
    public final void setProgressWithAnimation(float f, @Nullable Long l, @Nullable TimeInterpolator timeInterpolator) {
        setProgressWithAnimation$default(this, f, l, timeInterpolator, null, 8, null);
    }

    @JvmOverloads
    public final void setProgressWithAnimation(float progress, @Nullable Long duration, @Nullable TimeInterpolator interpolator, @Nullable Long startDelay) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.progressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        float[] fArr = new float[2];
        fArr[0] = this.indeterminateMode ? this.progressIndeterminateMode : this.progress;
        fArr[1] = progress;
        this.progressAnimator = ValueAnimator.ofFloat(fArr);
        if (duration != null) {
            long jLongValue = duration.longValue();
            ValueAnimator valueAnimator3 = this.progressAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.setDuration(jLongValue);
            }
        }
        if (interpolator != null && (valueAnimator = this.progressAnimator) != null) {
            valueAnimator.setInterpolator(interpolator);
        }
        if (startDelay != null) {
            long jLongValue2 = startDelay.longValue();
            ValueAnimator valueAnimator4 = this.progressAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.setStartDelay(jLongValue2);
            }
        }
        ValueAnimator valueAnimator5 = this.progressAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.addUpdateListener(new d());
        }
        ValueAnimator valueAnimator6 = this.progressAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.start();
        }
    }

    public final void setRoundBorder(boolean z) {
        this.roundBorder = z;
        this.foregroundPaint.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        invalidate();
    }

    public final void setStartAngle(float f) {
        float f2;
        float f3 = f + 270.0f;
        while (true) {
            f2 = 360;
            if (f3 <= f2) {
                break;
            } else {
                f3 -= f2;
            }
        }
        if (f3 < 0) {
            f3 = 0.0f;
        } else if (f3 > f2) {
            f3 = 360.0f;
        }
        this.startAngle = f3;
        invalidate();
    }
}
