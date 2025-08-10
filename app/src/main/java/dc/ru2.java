package dc;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.IdRes;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.ru2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: ContentContainerImpl.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u00015B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016JV\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J&\u00102\u001a\u00020\u001f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\b2\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl;", "Lcom/wear/ui/chat/pancel/helper/view/content/IContentContainer;", "Lcom/wear/ui/chat/pancel/helper/interfaces/ViewAssertion;", "mViewGroup", "Landroid/view/ViewGroup;", "autoReset", "", "editTextId", "", "resetId", "(Landroid/view/ViewGroup;ZII)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mEditText", "Landroid/widget/EditText;", "mInputAction", "Lcom/wear/ui/chat/pancel/helper/view/content/IInputAction;", "mPixelInputView", "mResetAction", "Lcom/wear/ui/chat/pancel/helper/view/content/IResetAction;", "mResetView", "Landroid/view/View;", "map", "Ljava/util/HashMap;", "Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$ViewPosition;", "Lkotlin/collections/HashMap;", "skipLayoutListener", "tag", "", "assertView", "", "changeContainerHeight", "targetHeight", "findTriggerView", TtmlNode.ATTR_ID, "getInputActionImpl", "getResetActionImpl", "layoutContainer", "l", "t", StreamManagement.AckRequest.ELEMENT, "b", "contentScrollMeasurers", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurer;", "defaultScrollHeight", "canScrollOutsize", "reset", "changed", "translationContainer", "contentTranslationY", "", "ViewPosition", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ru2 implements su2 {

    @NotNull
    public final ViewGroup a;
    public final boolean b;
    public final int c;
    public final int d;

    @Nullable
    public final EditText e;
    public final Context f;

    @Nullable
    public final View g;

    @NotNull
    public final tu2 h;

    @NotNull
    public final uu2 i;
    public final String j;

    @NotNull
    public final EditText k;
    public boolean l;

    @NotNull
    public final HashMap<Integer, ViewPosition> m;

    /* compiled from: ContentContainerImpl.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$1", "Lcom/wear/ui/chat/pancel/helper/view/content/IResetAction;", AMPExtension.Action.ATTRIBUTE_NAME, "Ljava/lang/Runnable;", "enableReset", "", "", StreamManagement.Enable.ELEMENT, "eventInViewArea", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "hookDispatchTouchEvent", "consume", "hookOnTouchEvent", "setResetCallback", "runnable", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements uu2 {
        public boolean a;

        @Nullable
        public Runnable b;

        public a() {
        }

        @Override // dc.uu2
        public boolean a(@Nullable MotionEvent motionEvent) {
            Runnable runnable;
            if (motionEvent == null) {
                return true;
            }
            ru2 ru2Var = ru2.this;
            if (motionEvent.getAction() != 0 || (runnable = this.b) == null || !ru2Var.b || !this.a) {
                return true;
            }
            if (ru2Var.g != null && !e(ru2Var.g, motionEvent)) {
                return true;
            }
            runnable.run();
            au2.g(ru2Var.j + "#hookOnTouchEvent", "hook ACTION_DOWN");
            return true;
        }

        @Override // dc.uu2
        public void b(boolean z) {
            this.a = z;
        }

        @Override // dc.uu2
        public boolean c(@Nullable MotionEvent motionEvent, boolean z) {
            Runnable runnable;
            if (motionEvent == null) {
                return false;
            }
            ru2 ru2Var = ru2.this;
            if (motionEvent.getAction() != 1 || (runnable = this.b) == null || !ru2Var.b || !this.a || z) {
                return false;
            }
            if (ru2Var.g != null && !e(ru2Var.g, motionEvent)) {
                return false;
            }
            runnable.run();
            au2.g(ru2Var.j + "#hookDispatchTouchEvent", "hook ACTION_UP");
            return true;
        }

        @Override // dc.uu2
        public void d(@NotNull Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.b = runnable;
        }

        public final boolean e(@NotNull View view, @Nullable MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (motionEvent == null) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            return rawX >= ((float) rect.left) && rawX <= ((float) rect.right) && rawY >= ((float) rect.top) && rawY <= ((float) rect.bottom);
        }
    }

    /* compiled from: ContentContainerImpl.kt */
    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b*\u0003\u0000\r\u0010\b\n\u0018\u00002\u00020\u0001:\u0002,-J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u001c\u0010 \u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010$\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J \u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2", "Lcom/wear/ui/chat/pancel/helper/view/content/IInputAction;", "checkoutInputRight", "", "curPanelId", "", "mainFocusIndex", "mainInputView", "Landroid/widget/EditText;", "onClickListener", "Landroid/view/View$OnClickListener;", "realEditViewAttach", "requestFocusRunnable", "com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2.RequestFocusRunnable", "Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2$RequestFocusRunnable;", "resetSelectionRunnable", "com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2.ResetSelectionRunnable", "Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2$ResetSelectionRunnable;", "secondaryViewRequestFocus", "secondaryViews", "Ljava/util/WeakHashMap;", "addSecondaryInputView", "", "editText", "getFullScreenPixelInputView", "giveUpFocusRight", "hideKeyboard", "isKeyboardShowing", "clearFocus", "recycler", "removeSecondaryInputView", "requestKeyboard", "retrieveFocusRight", "requestFocus", "resetSelection", "setEditTextClickListener", "l", "setEditTextFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "showKeyboard", "updateFullScreenParams", "isFullScreen", "panelId", "panelHeight", "RequestFocusRunnable", "ResetSelectionRunnable", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements tu2 {

        @NotNull
        public final EditText a;
        public int b;
        public boolean c;

        @Nullable
        public View.OnClickListener d;
        public boolean e;
        public int f;
        public boolean g;

        @NotNull
        public final c h;

        @NotNull
        public final d i;

        /* compiled from: ContentContainerImpl.kt */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s) {
                if (b.this.e && b.this.a.hasFocus() && !b.this.g) {
                    b bVar = b.this;
                    bVar.b = bVar.a.getSelectionStart();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
            }
        }

        /* compiled from: ContentContainerImpl.kt */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2$2", "Landroid/view/View$AccessibilityDelegate;", "sendAccessibilityEvent", "", "host", "Landroid/view/View;", "eventType", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: dc.ru2$b$b, reason: collision with other inner class name */
        public static final class C0214b extends View.AccessibilityDelegate {
            public C0214b() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(@NotNull View host, int eventType) {
                Intrinsics.checkNotNullParameter(host, "host");
                super.sendAccessibilityEvent(host, eventType);
                if (eventType == 8192 && b.this.e && b.this.a.hasFocus() && !b.this.g) {
                    b bVar = b.this;
                    bVar.b = bVar.a.getSelectionStart();
                }
            }
        }

        /* compiled from: ContentContainerImpl.kt */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\u008a\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2.RequestFocusRunnable", "Ljava/lang/Runnable;", "(Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2;)V", "resetSelection", "", "getResetSelection", "()Z", "setResetSelection", "(Z)V", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public final class c implements Runnable {
            public boolean a;

            public c() {
            }

            public final void a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a.requestFocus();
                if (this.a) {
                    b.this.a.postDelayed(b.this.i, 100L);
                } else {
                    b.this.g = false;
                }
            }
        }

        /* compiled from: ContentContainerImpl.kt */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\u008a\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2.ResetSelectionRunnable", "Ljava/lang/Runnable;", "(Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$2;)V", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public final class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.b == -1 || b.this.b > b.this.a.getText().length()) {
                    b.this.a.setSelection(b.this.a.getText().length());
                } else {
                    b.this.a.setSelection(b.this.b);
                }
                b.this.g = false;
            }
        }

        public b() {
            EditText editText = ru2.this.e;
            Intrinsics.checkNotNull(editText);
            this.a = editText;
            this.b = -1;
            new WeakHashMap();
            this.e = true;
            this.f = Integer.MAX_VALUE;
            this.g = true;
            this.h = new c();
            this.i = new d();
            editText.addTextChangedListener(new a());
            editText.setAccessibilityDelegate(new C0214b());
        }

        public static /* synthetic */ void u(b bVar, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            bVar.t(z, z2);
        }

        public static final void v(b this$0, ru2 this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!this$0.e) {
                this$1.k.requestFocus();
                return;
            }
            View.OnClickListener onClickListener = this$0.d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        public static final void w(b this$0, View.OnFocusChangeListener l, ru2 this$1, View view, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(l, "$l");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (z) {
                if (this$0.e) {
                    l.onFocusChange(view, z);
                } else {
                    this$1.k.requestFocus();
                }
            }
        }

        public static final void x(View.OnFocusChangeListener l, View view, boolean z) {
            Intrinsics.checkNotNullParameter(l, "$l");
            if (z) {
                l.onFocusChange(view, z);
            }
        }

        @Override // dc.tu2
        public boolean a() {
            EditText editText = this.e ? this.a : ru2.this.k;
            Context context = ru2.this.f;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return du2.f(context, editText);
        }

        @Override // dc.tu2
        public void b(@NotNull View.OnClickListener l) {
            Intrinsics.checkNotNullParameter(l, "l");
            this.d = l;
            EditText editText = this.a;
            final ru2 ru2Var = ru2.this;
            editText.setOnClickListener(new View.OnClickListener() { // from class: dc.ou2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ru2.b.v(this.a, ru2Var, view);
                }
            });
        }

        @Override // dc.tu2
        public void c() {
            EditText editText = this.e ? this.a : ru2.this.k;
            if (editText.hasFocus()) {
                editText.performClick();
            } else {
                editText.requestFocus();
            }
        }

        @Override // dc.tu2
        public void d(boolean z, int i, int i2) {
            if (i == this.f) {
                return;
            }
            this.f = i;
            if (this.c) {
                this.c = false;
                return;
            }
            ru2.this.k.setVisibility(z ? 0 : 8);
            if (ru2.this.k.getParent() instanceof ViewGroup) {
                ViewParent parent = ru2.this.k.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).setFocusableInTouchMode(true);
                ViewParent parent2 = ru2.this.k.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).setFocusable(true);
            }
            if (!z) {
                u(this, false, false, 3, null);
                return;
            }
            if (i == 0) {
                t(true, true);
                return;
            }
            if (i != -1) {
                Context context = ru2.this.f;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (!du2.d(context, i2)) {
                    t(false, true);
                    return;
                }
            }
            p();
        }

        @Override // dc.tu2
        public void e(boolean z, boolean z2) {
            EditText editText = this.e ? this.a : ru2.this.k;
            if (z) {
                Context context = ru2.this.f;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                du2.c(context, editText);
            }
            if (z2) {
                editText.clearFocus();
            }
        }

        @Override // dc.tu2
        public void f(@NotNull final View.OnFocusChangeListener l) {
            Intrinsics.checkNotNullParameter(l, "l");
            EditText editText = this.a;
            final ru2 ru2Var = ru2.this;
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.pu2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ru2.b.w(this.a, l, ru2Var, view, z);
                }
            });
            ru2.this.k.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.qu2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ru2.b.x(l, view, z);
                }
            });
        }

        @Override // dc.tu2
        @NotNull
        public EditText g() {
            ru2.this.k.setBackground(null);
            return ru2.this.k;
        }

        @Override // dc.tu2
        public void h() {
            this.a.removeCallbacks(this.h);
            this.a.removeCallbacks(this.i);
        }

        public final void p() {
            this.g = true;
            this.e = false;
            if (ru2.this.k.hasFocus()) {
                ru2.this.k.clearFocus();
            }
            this.g = false;
        }

        public final void t(boolean z, boolean z2) {
            this.g = true;
            this.e = true;
            if (ru2.this.k.hasFocus()) {
                ru2.this.k.clearFocus();
            }
            h();
            if (z) {
                this.h.a(z2);
                this.a.postDelayed(this.h, 200L);
            } else if (z2) {
                this.i.run();
            } else {
                this.g = false;
            }
        }
    }

    /* compiled from: ContentContainerImpl.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J;\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010/\u001a\u00020-J\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0006\u00101\u001a\u00020!J&\u00102\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003J\t\u00103\u001a\u000204HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\f¨\u00065"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl$ViewPosition;", "", TtmlNode.ATTR_ID, "", "l", "t", StreamManagement.AckRequest.ELEMENT, "b", "(IIIII)V", "getB", "()I", "setB", "(I)V", "changeB", "getChangeB", "setChangeB", "changeL", "getChangeL", "setChangeL", "changeR", "getChangeR", "setChangeR", "changeT", "getChangeT", "setChangeT", "getId", "getL", "setL", "getR", "setR", "getT", "setT", "change", "", "newL", "newT", "newR", "newB", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hasChange", "hashCode", "reset", "syncPosition", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: dc.ru2$c, reason: from toString */
    public static final /* data */ class ViewPosition {

        /* renamed from: a, reason: from toString */
        public final int id;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        public int l;

        /* renamed from: c, reason: from toString */
        public int t;

        /* renamed from: d, reason: from toString */
        public int r;

        /* renamed from: e, reason: from toString */
        public int b;
        public int f;
        public int g;
        public int h;
        public int i;

        public ViewPosition(int i, int i2, int i3, int i4, int i5) {
            this.id = i;
            this.l = i2;
            this.t = i3;
            this.r = i4;
            this.b = i5;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = i5;
        }

        public final void a(int i, int i2, int i3, int i4) {
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
        }

        /* renamed from: b, reason: from getter */
        public final int getB() {
            return this.b;
        }

        /* renamed from: c, reason: from getter */
        public final int getI() {
            return this.i;
        }

        /* renamed from: d, reason: from getter */
        public final int getF() {
            return this.f;
        }

        /* renamed from: e, reason: from getter */
        public final int getH() {
            return this.h;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewPosition)) {
                return false;
            }
            ViewPosition viewPosition = (ViewPosition) other;
            return this.id == viewPosition.id && this.l == viewPosition.l && this.t == viewPosition.t && this.r == viewPosition.r && this.b == viewPosition.b;
        }

        /* renamed from: f, reason: from getter */
        public final int getG() {
            return this.g;
        }

        /* renamed from: g, reason: from getter */
        public final int getL() {
            return this.l;
        }

        /* renamed from: h, reason: from getter */
        public final int getR() {
            return this.r;
        }

        public int hashCode() {
            return (((((((this.id * 31) + this.l) * 31) + this.t) * 31) + this.r) * 31) + this.b;
        }

        /* renamed from: i, reason: from getter */
        public final int getT() {
            return this.t;
        }

        public final boolean j() {
            return (this.f == this.l && this.g == this.t && this.h == this.r && this.i == this.b) ? false : true;
        }

        public final void k() {
            this.f = this.l;
            this.g = this.t;
            this.h = this.r;
            this.i = this.b;
        }

        public final void l(int i, int i2, int i3, int i4) {
            this.l = i;
            this.t = i2;
            this.r = i3;
            this.b = i4;
        }

        @NotNull
        public String toString() {
            return "ViewPosition(id=" + this.id + ", l=" + this.l + ", t=" + this.t + ", r=" + this.r + ", b=" + this.b + ')';
        }
    }

    public ru2(@NotNull ViewGroup mViewGroup, boolean z, @IdRes int i, @IdRes int i2) {
        Intrinsics.checkNotNullParameter(mViewGroup, "mViewGroup");
        this.a = mViewGroup;
        this.b = z;
        this.c = i;
        this.d = i2;
        EditText editText = (EditText) mViewGroup.findViewById(i);
        this.e = editText;
        this.f = mViewGroup.getContext();
        this.g = mViewGroup.findViewById(i2);
        this.j = ru2.class.getSimpleName();
        EditText editText2 = new EditText(editText != null ? editText.getContext() : null);
        this.k = editText2;
        k();
        Integer numValueOf = editText != null ? Integer.valueOf(editText.getImeOptions()) : null;
        if (numValueOf != null) {
            Integer numValueOf2 = Integer.valueOf(numValueOf.intValue() | 268435456);
            if (editText != null) {
                editText.setImeOptions(numValueOf2.intValue());
            }
            editText2.setImeOptions(numValueOf2.intValue());
        }
        this.i = new a();
        this.h = new b();
        this.m = new HashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(ru2 this$0, Ref.ObjectRef viewPosition, View view, View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewPosition, "$viewPosition");
        if (this$0.l) {
            return;
        }
        ((ViewPosition) viewPosition.element).l(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    @Override // dc.su2
    public void a(@NotNull List<ot2> contentScrollMeasurers, int i, float f) {
        Intrinsics.checkNotNullParameter(contentScrollMeasurers, "contentScrollMeasurers");
        this.a.setTranslationY(f);
        for (ot2 ot2Var : contentScrollMeasurers) {
            int iB = ot2Var.b();
            View viewFindViewById = this.a.findViewById(iB);
            int iA = ot2Var.a(i);
            int i2 = iA < i ? i - iA : 0;
            float f2 = -f;
            float f3 = i2;
            if (f2 < f3) {
                viewFindViewById.setTranslationY(f2);
            } else {
                viewFindViewById.setTranslationY(f3);
            }
            String str = "viewId = " + iB + ", maxDistance = " + i2 + ", parentY = " + f2 + ", y = " + viewFindViewById.getTranslationY();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8, types: [T, dc.ru2$c] */
    @Override // dc.su2
    public void b(int i, int i2, int i3, int i4, @NotNull List<ot2> contentScrollMeasurers, int i5, boolean z, boolean z2, boolean z3) {
        View viewFindViewById;
        Iterator<ot2> it;
        final Ref.ObjectRef objectRef;
        final View view;
        int i6;
        int iA;
        final ru2 ru2Var = this;
        Intrinsics.checkNotNullParameter(contentScrollMeasurers, "contentScrollMeasurers");
        ru2Var.l = false;
        ru2Var.a.layout(i, i2, i3, i4);
        if (z) {
            ru2Var.l = true;
            Iterator<ot2> it2 = contentScrollMeasurers.iterator();
            while (it2.hasNext()) {
                ot2 next = it2.next();
                int iB = next.b();
                if (iB == -1 || (viewFindViewById = ru2Var.a.findViewById(iB)) == null) {
                    ru2Var = this;
                } else {
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    ?? r10 = ru2Var.m.get(Integer.valueOf(iB));
                    objectRef2.element = r10;
                    if (r10 == 0) {
                        it = it2;
                        objectRef = objectRef2;
                        view = viewFindViewById;
                        i6 = iB;
                        objectRef.element = new ViewPosition(iB, viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
                        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: dc.nu2
                            @Override // android.view.View.OnLayoutChangeListener
                            public final void onLayoutChange(View view2, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                                ru2.m(this.a, objectRef, view, view2, i7, i8, i9, i10, i11, i12, i13, i14);
                            }
                        });
                        ru2Var.m.put(Integer.valueOf(i6), objectRef.element);
                    } else {
                        it = it2;
                        objectRef = objectRef2;
                        view = viewFindViewById;
                        i6 = iB;
                    }
                    if (z2) {
                        if (((ViewPosition) objectRef.element).j()) {
                            view.layout(((ViewPosition) objectRef.element).getL(), ((ViewPosition) objectRef.element).getT(), ((ViewPosition) objectRef.element).getR(), ((ViewPosition) objectRef.element).getB());
                            ((ViewPosition) objectRef.element).k();
                        }
                        iA = 0;
                    } else {
                        iA = next.a(i5);
                        if (iA > i5) {
                            return;
                        }
                        if (iA < 0) {
                            iA = 0;
                        }
                        int i7 = i5 - iA;
                        T t = objectRef.element;
                        ((ViewPosition) t).a(((ViewPosition) t).getL(), ((ViewPosition) objectRef.element).getT() + i7, ((ViewPosition) objectRef.element).getR(), ((ViewPosition) objectRef.element).getB() + i7);
                        view.layout(((ViewPosition) objectRef.element).getF(), ((ViewPosition) objectRef.element).getG(), ((ViewPosition) objectRef.element).getH(), ((ViewPosition) objectRef.element).getI());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("ContentScrollMeasurer(id ");
                    int i8 = i6;
                    sb.append(i8);
                    sb.append(" , defaultScrollHeight ");
                    sb.append(i5);
                    sb.append(" , scrollDistance ");
                    sb.append(iA);
                    sb.append(" reset ");
                    sb.append(z2);
                    sb.append(") origin (l ");
                    sb.append(((ViewPosition) objectRef.element).getL());
                    sb.append(",t ");
                    sb.append(((ViewPosition) objectRef.element).getT());
                    sb.append(",r ");
                    sb.append(((ViewPosition) objectRef.element).getR());
                    sb.append(", b ");
                    sb.append(((ViewPosition) objectRef.element).getB());
                    sb.append(')');
                    au2.g("PanelSwitchLayout#onLayout", sb.toString());
                    au2.g("PanelSwitchLayout#onLayout", "ContentScrollMeasurer(id " + i8 + " , defaultScrollHeight " + i5 + " , scrollDistance " + iA + " reset " + z2 + ") layout parent(l " + i + ",t " + i2 + ",r " + i3 + ",b " + i4 + ") self(l " + ((ViewPosition) objectRef.element).getF() + ",t " + ((ViewPosition) objectRef.element).getG() + ",r " + ((ViewPosition) objectRef.element).getH() + ", b" + ((ViewPosition) objectRef.element).getI() + ')');
                    ru2Var = this;
                    it2 = it;
                }
            }
        }
    }

    @Override // dc.su2
    @Nullable
    public View c(int i) {
        return this.a.findViewById(i);
    }

    @Override // dc.su2
    public void d(int i) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams == null || layoutParams.height == i) {
            return;
        }
        layoutParams.height = i;
        this.a.setLayoutParams(layoutParams);
    }

    @Override // dc.su2
    @NotNull
    /* renamed from: getInputActionImpl, reason: from getter */
    public tu2 getH() {
        return this.h;
    }

    @Override // dc.su2
    @NotNull
    /* renamed from: getResetActionImpl, reason: from getter */
    public uu2 getI() {
        return this.i;
    }

    public void k() {
        if (this.e == null) {
            throw new RuntimeException("ContentContainer should set edit_view to get the editText!");
        }
    }
}
