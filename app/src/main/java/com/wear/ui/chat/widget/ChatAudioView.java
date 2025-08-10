package com.wear.ui.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import dc.de3;
import dc.mz1;
import dc.nz1;
import dc.th4;
import dc.vi1;
import java.util.Objects;
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
import skin.support.widget.SkinCompatLinearLayout;

/* compiled from: ChatAudioView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/wear/ui/chat/widget/ChatAudioView;", "Lskin/support/widget/SkinCompatLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "direction", "iThemeManager", "Lcom/wear/main/account/setting/IThemeManager;", "getIThemeManager", "()Lcom/wear/main/account/setting/IThemeManager;", "iThemeManager$delegate", "Lkotlin/Lazy;", "isPlaying", "", "root", "Landroid/view/View;", "voiceTime", "Landroid/widget/TextView;", "setDirection", "", "setDuration", TypedValues.TransitionType.S_DURATION, "setImageResource", "startPlayAnimation", "stopPlayAnimation", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatAudioView extends SkinCompatLinearLayout {

    @NotNull
    public final Lazy c;

    @NotNull
    public final TextView d;

    @NotNull
    public final View e;

    @NotNull
    public final LottieAnimationView f;
    public int g;

    /* compiled from: ChatAudioView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/main/account/setting/IThemeManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<mz1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final mz1 invoke() {
            return nz1.e().d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAudioView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAudioView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChatAudioView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final mz1 getIThemeManager() {
        Object value = this.c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-iThemeManager>(...)");
        return (mz1) value;
    }

    public final boolean a() {
        return this.f.o();
    }

    public final void b() {
        this.f.setImageDrawable(th4.d(getContext(), this.g == 0 ? getIThemeManager().i0() : getIThemeManager().o()));
    }

    public final void c() {
        if (this.f.o()) {
            return;
        }
        this.f.setAnimation(getIThemeManager().U(this.g == 0));
        this.f.r();
    }

    public final void d() {
        this.f.g();
        this.f.clearAnimation();
        b();
    }

    public final void setDirection(int direction) {
        this.g = direction;
        TextView textView = this.d;
        mz1 iThemeManager = getIThemeManager();
        textView.setTextColor(direction == 0 ? iThemeManager.K() : iThemeManager.h0());
        this.e.setBackground(th4.d(getContext(), direction == 0 ? getIThemeManager().y() : getIThemeManager().g0()));
        b();
    }

    public final void setDuration(int duration) {
        int iA = de3.a(getContext(), 100.0f) + de3.a(getContext(), (duration * 60.0f) / 60);
        View view = this.e;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = iA;
        view.setLayoutParams(layoutParams2);
        this.d.setText(getContext().getString(R.string.chat_new_audio_time, Integer.valueOf(duration)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAudioView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = LazyKt__LazyJVMKt.lazy(a.a);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.ChatAudioView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.ChatAudioView)");
        if (typedArrayObtainStyledAttributes.getInt(0, 0) == 0) {
            LayoutInflater.from(context).inflate(R.layout.view_chat_audio_right, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.view_chat_audio_left, (ViewGroup) this, true);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewFindViewById = findViewById(R.id.ll_voice);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.ll_voice)");
        this.e = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.voice_time);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.voice_time)");
        this.d = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.animation_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.animation_view)");
        this.f = (LottieAnimationView) viewFindViewById3;
    }
}
