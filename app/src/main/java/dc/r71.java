package dc;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HighlightPro.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0012\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001cJ\u0014\u0010\u001d\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018J\u001a\u0010\u001f\u001a\u00020\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0!J\u001a\u0010#\u001a\u00020\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0!J\b\u0010%\u001a\u00020\u000eH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/hyy/highlightpro/HighlightPro;", "Lcom/hyy/highlightpro/HighlightViewInteractiveAction;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "view", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "highlightProImpl", "Lcom/hyy/highlightpro/HighlightProImpl;", "dismiss", "", "enableHighlight", "", "interceptBackPressed", "needAnchorTipView", "setBackgroundColor", "color", "", "setHighlightParameter", "block", "Lkotlin/Function0;", "Lcom/hyy/highlightpro/parameter/HighlightParameter;", "setHighlightParameters", "highlightParameters", "", "setOnDismissCallback", "dismissCallback", "setOnMaskViewClickCallback", "clickCallback", "Lkotlin/Function1;", "Landroid/view/View;", "setOnShowCallback", "showCallback", "show", "Companion", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r71 {

    @NotNull
    public static final a b = new a(null);

    @NotNull
    public final s71 a;

    /* compiled from: HighlightPro.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/hyy/highlightpro/HighlightPro$Companion;", "", "()V", "with", "Lcom/hyy/highlightpro/HighlightPro;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", TtmlNode.RUBY_CONTAINER, "Landroid/widget/FrameLayout;", "fragment", "Landroidx/fragment/app/Fragment;", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final r71 a(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return new r71(fragment, null);
        }
    }

    public r71(Fragment fragment) {
        this.a = new s71(fragment);
    }

    public /* synthetic */ r71(Fragment fragment, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment);
    }

    public void a() {
        this.a.f();
    }

    @NotNull
    public final r71 b(int i) {
        this.a.j(i);
        return this;
    }

    @NotNull
    public final r71 c(@NotNull Function0<u71> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.a.k(block);
        return this;
    }

    @NotNull
    public final r71 d(@NotNull Function0<Unit> dismissCallback) {
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        this.a.l(dismissCallback);
        return this;
    }

    @NotNull
    public final r71 e(@NotNull Function1<? super Integer, Unit> showCallback) {
        Intrinsics.checkNotNullParameter(showCallback, "showCallback");
        this.a.m(showCallback);
        return this;
    }

    public void f() {
        this.a.n();
    }
}
