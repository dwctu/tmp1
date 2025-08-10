package dc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KeyboardStatePopupWindow.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0002\u0015\u0016B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/freddy/kulakeyboard/library/KeyboardStatePopupWindow;", "Landroid/widget/PopupWindow;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "anchorView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "maxHeight", "", "onKeyboardStateListener", "Lcom/freddy/kulakeyboard/library/KeyboardStatePopupWindow$OnKeyboardStateListener;", "onGlobalLayout", "", "release", "setOnKeyboardStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "OnKeyboardStateListener", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ch0 extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {

    @NotNull
    public static final a d = new a(null);
    public static boolean e;

    @NotNull
    public Context a;
    public int b;

    @Nullable
    public b c;

    /* compiled from: KeyboardStatePopupWindow.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/freddy/kulakeyboard/library/KeyboardStatePopupWindow$Companion;", "", "()V", "isSoftKeyboardOpened", "", "()Z", "setSoftKeyboardOpened", "(Z)V", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: KeyboardStatePopupWindow.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/freddy/kulakeyboard/library/KeyboardStatePopupWindow$OnKeyboardStateListener;", "", "onClosed", "", "onOpened", "keyboardHeight", "", "onOpenedResize", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a(int i);

        void b(int i);

        void onClosed();
    }

    public ch0(@NotNull Context context, @NotNull final View anchorView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        this.a = context;
        View view = new View(this.a);
        setContentView(view);
        setWidth(0);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(16);
        setInputMethodMode(1);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        anchorView.postDelayed(new Runnable() { // from class: dc.xg0
            @Override // java.lang.Runnable
            public final void run() {
                ch0.a(this.a, anchorView);
            }
        }, 100L);
    }

    public static final void a(ch0 this$0, View anchorView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
        Context context = this$0.a;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) context).isFinishing()) {
            return;
        }
        Context context2 = this$0.a;
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) context2).isDestroyed()) {
            return;
        }
        this$0.showAtLocation(anchorView, 0, 0, 0);
    }

    public final void c() {
        getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public final void d(@Nullable b bVar) {
        this.c = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        b bVar;
        Rect rect = new Rect();
        getContentView().getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom;
        if (i > this.b) {
            this.b = i;
        }
        int iB = gh0.a.b(this.a);
        int i2 = this.b - rect.bottom;
        boolean z = i2 > iB / 4;
        String str = "onGlobalLayout keyboardHeight: " + i2 + ",screenHeight:" + iB;
        String str2 = "onGlobalLayout isSoftKeyboardOpened: " + e + ",visible:" + z;
        boolean z2 = e;
        if (!z2 && z) {
            e = true;
            b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a(i2);
            }
        } else if (z2 && !z) {
            e = false;
            b bVar3 = this.c;
            if (bVar3 != null) {
                bVar3.onClosed();
            }
        }
        if (e && z && (bVar = this.c) != null) {
            bVar.b(i2);
        }
    }
}
