package com.wear.widget.chatMic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.lovense.wear.R;
import dc.th4;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.widget.SkinCompatView;

/* compiled from: VoiceMessagePanelAnimationView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/wear/widget/chatMic/VoiceMessagePanelAnimationView;", "Lskin/support/widget/SkinCompatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelDrawable", "Landroid/graphics/drawable/Drawable;", "destRectF", "Landroid/graphics/RectF;", "getDestRectF", "()Landroid/graphics/RectF;", "destRectF$delegate", "Lkotlin/Lazy;", "drawable", "value", "", "isCancel", "()Z", "setCancel", "(Z)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "applySkin", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class VoiceMessagePanelAnimationView extends SkinCompatView {

    @NotNull
    public final Lazy b;
    public boolean c;

    @NotNull
    public final Lazy d;

    @NotNull
    public Drawable e;

    @NotNull
    public Drawable f;

    /* compiled from: VoiceMessagePanelAnimationView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<RectF> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RectF invoke() {
            RectF rectF = new RectF();
            VoiceMessagePanelAnimationView voiceMessagePanelAnimationView = VoiceMessagePanelAnimationView.this;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = voiceMessagePanelAnimationView.getWidth();
            rectF.bottom = voiceMessagePanelAnimationView.getHeight();
            return rectF;
        }
    }

    /* compiled from: VoiceMessagePanelAnimationView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            Context context = this.$context;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(th4.b(context, R.color.lvs_ui_standard_systemBackground2));
            return paint;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceMessagePanelAnimationView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceMessagePanelAnimationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final RectF getDestRectF() {
        return (RectF) this.d.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.b.getValue();
    }

    @Override // skin.support.widget.SkinCompatView, dc.aj4
    public void P1() {
        super.P1();
        getPaint().setColor(th4.b(getContext(), R.color.lvs_ui_standard_systemBackground2));
        Drawable drawableD = th4.d(getContext(), R.drawable.bg_audio_view_topper1);
        Intrinsics.checkNotNull(drawableD);
        this.e = drawableD;
        Drawable drawableD2 = th4.d(getContext(), R.drawable.bg_audio_view_bottom1);
        Intrinsics.checkNotNull(drawableD2);
        this.f = drawableD2;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.c) {
            Drawable drawable = this.e;
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            canvas.drawBitmap(((BitmapDrawable) drawable).getBitmap(), (Rect) null, getDestRectF(), getPaint());
        } else {
            Drawable drawable2 = this.f;
            Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            canvas.drawBitmap(((BitmapDrawable) drawable2).getBitmap(), (Rect) null, getDestRectF(), getPaint());
        }
    }

    public final void setCancel(boolean z) {
        if (this.c == z) {
            return;
        }
        this.c = z;
        getPaint().setColor(th4.b(getContext(), R.color.lvs_ui_standard_systemBackground2));
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceMessagePanelAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt__LazyJVMKt.lazy(new b(context));
        this.d = LazyKt__LazyJVMKt.lazy(new a());
        Drawable drawableD = th4.d(context, R.drawable.bg_audio_view_topper1);
        Intrinsics.checkNotNullExpressionValue(drawableD, "getDrawable(context, R.d…le.bg_audio_view_topper1)");
        this.e = drawableD;
        Drawable drawableD2 = th4.d(context, R.drawable.bg_audio_view_bottom1);
        Intrinsics.checkNotNullExpressionValue(drawableD2, "getDrawable(context, R.d…le.bg_audio_view_bottom1)");
        this.f = drawableD2;
    }
}
