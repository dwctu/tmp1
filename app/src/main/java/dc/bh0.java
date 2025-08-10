package dc;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dc.ch0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KeyboardHelper.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u001d\u0010\u0014\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\n2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u0017J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u001d\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u0002H\u0015¢\u0006\u0002\u0010\u0017J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0003J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020\u001eJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020,J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/freddy/kulakeyboard/library/KeyboardHelper;", "", "()V", "chatBottom", "Landroid/view/View;", "context", "Landroid/content/Context;", "expressionPanel", "Lcom/freddy/kulakeyboard/library/IPanel;", "inputPanel", "Lcom/freddy/kulakeyboard/library/IInputPanel;", "keyboardStatePopupWindow", "Lcom/freddy/kulakeyboard/library/KeyboardStatePopupWindow;", "morePanel", "onKeyboardStateListener", "Lcom/freddy/kulakeyboard/library/KeyboardHelper$OnKeyboardStateListener;", "rootLayout", "scrollBodyLayout", "", "bindChatBottom", "bindExpressionPanel", "P", "panel", "(Lcom/freddy/kulakeyboard/library/IPanel;)Lcom/freddy/kulakeyboard/library/KeyboardHelper;", "bindInputPanel", "(Lcom/freddy/kulakeyboard/library/IInputPanel;)Lcom/freddy/kulakeyboard/library/KeyboardHelper;", "bindMorePanel", "bindRootLayout", "bindVoicePanel", "handlePanelMoveAnimator", "", "panelType", "Lcom/freddy/kulakeyboard/library/PanelType;", "lastPanelType", "fromValue", "", "toValue", "isLayer", "isFast", "init", "release", "reset", "setKeyboardHeight", "keyboardHeight", "", "setOnKeyboardStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPanelHeight0", "panelHeightO", "setScrollBodyLayout", "Companion", "OnKeyboardStateListener", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class bh0 {

    @NotNull
    public static final a h = new a(null);
    public static int i;
    public static int j;
    public Context a;

    @Nullable
    public View b;

    @Nullable
    public yg0 c;

    @Nullable
    public zg0 d;

    @Nullable
    public zg0 e;

    @Nullable
    public ch0 f;

    @Nullable
    public b g;

    /* compiled from: KeyboardHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/freddy/kulakeyboard/library/KeyboardHelper$Companion;", "", "()V", "keyboardHeight", "", "getKeyboardHeight", "()I", "setKeyboardHeight", "(I)V", "panelHeight", "getPanelHeight", "setPanelHeight", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return bh0.i;
        }

        public final int b() {
            return bh0.j;
        }

        public final void c(int i) {
            bh0.i = i;
        }

        public final void d(int i) {
            bh0.j = i;
        }
    }

    /* compiled from: KeyboardHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/freddy/kulakeyboard/library/KeyboardHelper$OnKeyboardStateListener;", "", "onClosed", "", "onOpened", "keyboardHeight", "", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a(int i);

        void onClosed();
    }

    /* compiled from: KeyboardHelper.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/freddy/kulakeyboard/library/KeyboardHelper$bindInputPanel$1", "Lcom/freddy/kulakeyboard/library/OnInputPanelStateChangedListener;", "onShowExpressionPanel", "", "onShowInputMethodPanel", "onShowMorePanel", "onShowVoicePanel", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements dh0 {
        public c() {
        }

        @Override // dc.dh0
        public void a() {
            Object obj;
            if ((bh0.this.e instanceof ViewGroup) && (obj = bh0.this.e) != null) {
                ((ViewGroup) obj).setVisibility(0);
            }
        }

        @Override // dc.dh0
        public void b() {
            Object obj;
            if ((bh0.this.d instanceof ViewGroup) && (obj = bh0.this.d) != null) {
                ((ViewGroup) obj).setVisibility(0);
            }
        }
    }

    /* compiled from: KeyboardHelper.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"com/freddy/kulakeyboard/library/KeyboardHelper$bindInputPanel$2", "Lcom/freddy/kulakeyboard/library/OnLayoutAnimatorHandleListener;", "onAnimatorHandle", "", "panelType", "Lcom/freddy/kulakeyboard/library/PanelType;", "lastPanelType", "fromValue", "", "toValue", "isLayer", "", "isFast", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements eh0 {
        public d() {
        }

        @Override // dc.eh0
        public void a(@NotNull fh0 panelType, @NotNull fh0 lastPanelType, float f, float f2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(panelType, "panelType");
            Intrinsics.checkNotNullParameter(lastPanelType, "lastPanelType");
            bh0.this.o(panelType, lastPanelType, f, f2, z, z2);
        }
    }

    /* compiled from: KeyboardHelper.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/freddy/kulakeyboard/library/KeyboardHelper$bindRootLayout$1", "Lcom/freddy/kulakeyboard/library/KeyboardStatePopupWindow$OnKeyboardStateListener;", "onClosed", "", "onOpened", "keyboardHeight", "", "onOpenedResize", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements ch0.b {
        public e() {
        }

        @Override // dc.ch0.b
        public void a(int i) {
            yg0 yg0Var = bh0.this.c;
            if (yg0Var != null) {
                yg0Var.c(i);
            }
            b bVar = bh0.this.g;
            if (bVar != null) {
                bVar.a(i);
            }
        }

        @Override // dc.ch0.b
        public void b(int i) {
            yg0 yg0Var = bh0.this.c;
            if (yg0Var != null) {
                yg0Var.b(i);
            }
        }

        @Override // dc.ch0.b
        public void onClosed() {
            yg0 yg0Var = bh0.this.c;
            if (yg0Var != null) {
                yg0Var.a();
            }
            b bVar = bh0.this.g;
            if (bVar != null) {
                bVar.onClosed();
            }
        }
    }

    /* compiled from: KeyboardHelper.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/freddy/kulakeyboard/library/KeyboardHelper$handlePanelMoveAnimator$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ah0.a = false;
            Object obj = bh0.this.d;
            if (obj != null) {
                ((ViewGroup) obj).requestLayout();
            }
            Object obj2 = bh0.this.e;
            if (obj2 != null) {
                ((ViewGroup) obj2).requestLayout();
            }
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

    @NotNull
    public final bh0 j(@NotNull View chatBottom) {
        Intrinsics.checkNotNullParameter(chatBottom, "chatBottom");
        this.b = chatBottom;
        return this;
    }

    @NotNull
    public final <P extends zg0> bh0 k(@NotNull P panel) {
        Intrinsics.checkNotNullParameter(panel, "panel");
        this.d = panel;
        return this;
    }

    @NotNull
    public final <P extends yg0> bh0 l(@NotNull P panel) {
        Intrinsics.checkNotNullParameter(panel, "panel");
        this.c = panel;
        panel.setOnInputStateChangedListener(new c());
        panel.setOnLayoutAnimatorHandleListener(new d());
        return this;
    }

    @NotNull
    public final <P extends zg0> bh0 m(@NotNull P panel) {
        Intrinsics.checkNotNullParameter(panel, "panel");
        this.e = panel;
        return this;
    }

    @NotNull
    public final bh0 n(@NotNull View rootLayout) {
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Context context = this.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ch0 ch0Var = new ch0(context, rootLayout);
        this.f = ch0Var;
        if (ch0Var != null) {
            ch0Var.d(new e());
        }
        return this;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void o(fh0 fh0Var, fh0 fh0Var2, float f2, float f3, boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "translationY", f2, f3);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(chatBottom, \"tra…onY\", fromValue, toValue)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", f2, f3);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(inputPanel, \"tra…onY\", fromValue, toValue)");
        ah0.a = true;
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            animatorSet.setDuration(20L);
        } else if (z2) {
            animatorSet.setDuration(1L);
            ah0.a((int) (f2 - f3));
        } else {
            animatorSet.setDuration(200L);
            ah0.a((int) (f2 - f3));
        }
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.addListener(new f());
        animatorSet.start();
    }

    @NotNull
    public final bh0 p(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        return this;
    }

    public final void q() {
        r();
        this.c = null;
        this.d = null;
        this.e = null;
        ch0 ch0Var = this.f;
        if (ch0Var != null) {
            ch0Var.dismiss();
        }
        this.f = null;
    }

    public final void r() {
        yg0 yg0Var = this.c;
        if (yg0Var != null) {
            yg0Var.reset();
        }
        zg0 zg0Var = this.d;
        if (zg0Var != null) {
            zg0Var.reset();
        }
        zg0 zg0Var2 = this.e;
        if (zg0Var2 != null) {
            zg0Var2.reset();
        }
    }

    @NotNull
    public final bh0 s(int i2) {
        int i3 = i;
        if (i3 > 0 && i2 >= i3 * 2) {
            i2 -= i3;
        }
        gh0 gh0Var = gh0.a;
        Context context = this.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        if (i2 > (gh0Var.b(context) / 3) * 2) {
            return this;
        }
        i = i2;
        u(i2);
        return this;
    }

    @NotNull
    public final bh0 t(@Nullable b bVar) {
        this.g = bVar;
        return this;
    }

    public final void u(int i2) {
        gh0 gh0Var = gh0.a;
        Context context = this.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        int iB = gh0Var.b(context);
        if (i2 < iB / 3) {
            j = (iB * 2) / 5;
        } else {
            j = i2;
        }
    }

    @NotNull
    public final bh0 v(boolean z) {
        return this;
    }
}
