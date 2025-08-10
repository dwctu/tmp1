package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hyy.highlightpro.view.MaskContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HighlightProImpl.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u001aH\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u0010H\u0016J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\fJ\b\u0010,\u001a\u00020\fH\u0002J\u000e\u0010-\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0012J\u0014\u00100\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014J\u0014\u00102\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u00103\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014J\u001a\u00104\u001a\u00020\u00102\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u001a\u00105\u001a\u00020\u00102\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u000eJ\b\u00106\u001a\u00020\u0010H\u0016J\b\u00107\u001a\u00020\u0010H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/hyy/highlightpro/HighlightProImpl;", "Lcom/hyy/highlightpro/HighlightViewInteractiveAction;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "view", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "autoNext", "", "clickCallback", "Lkotlin/Function1;", "Landroid/view/View;", "", "curIndex", "", "dismissCallback", "Lkotlin/Function0;", "fragmentRootView", "hasShow", "highlightParameters", "", "", "Lcom/hyy/highlightpro/parameter/HighlightParameter;", "isFragmentRoot", "maskContainer", "Lcom/hyy/highlightpro/view/MaskContainer;", "needAnchorTipView", "onClickListener", "Landroid/view/View$OnClickListener;", "released", "rootView", "showCallback", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "checkOrInitParameter", "parameter", "checkTipViewIdIsValid", "dismiss", "enableHighlight", "hasHighLightView", "interceptBackPressed", "setBackgroundColor", "color", "setGuideViewParameter", "block", "setGuideViewParameters", "setOnDismissCallback", "setOnGuideViewClickCallback", "setOnShowCallback", "show", "showNextHighLightView", "Companion", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHighlightProImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HighlightProImpl.kt\ncom/hyy/highlightpro/HighlightProImpl\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,231:1\n84#2:232\n84#2:233\n1855#3,2:234\n*S KotlinDebug\n*F\n+ 1 HighlightProImpl.kt\ncom/hyy/highlightpro/HighlightProImpl\n*L\n110#1:232\n118#1:233\n141#1:234,2\n*E\n"})
/* loaded from: classes3.dex */
public final class s71 {
    public boolean a;

    @Nullable
    public View b;
    public int c;

    @NotNull
    public final List<List<u71>> d;
    public boolean e;

    @NotNull
    public final ViewGroup f;

    @NotNull
    public final MaskContainer g;
    public boolean h;

    @Nullable
    public Function1<? super Integer, Unit> i;

    @Nullable
    public Function0<Unit> j;

    @Nullable
    public Function1<? super View, Unit> k;
    public boolean l;

    @NotNull
    public final View.OnClickListener m;

    /* compiled from: View.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n+ 2 HighlightProImpl.kt\ncom/hyy/highlightpro/HighlightProImpl\n*L\n1#1,432:1\n111#2,6:433\n*E\n"})
    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ s71 b;

        public a(View view, s71 s71Var) {
            this.a = view;
            this.b = s71Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            System.out.println((Object) "HYY-GuideProImpl fragmentRootView pre draw");
            if (this.b.e) {
                return;
            }
            this.b.e = false;
            this.b.n();
        }
    }

    /* compiled from: View.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n+ 2 HighlightProImpl.kt\ncom/hyy/highlightpro/HighlightProImpl\n*L\n1#1,432:1\n120#2,4:433\n*E\n"})
    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ s71 b;

        public b(View view, s71 s71Var) {
            this.a = view;
            this.b = s71Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.e) {
                return;
            }
            this.b.e = false;
            this.b.n();
        }
    }

    /* compiled from: HighlightProImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<Unit> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            s71.this.o();
        }
    }

    public s71(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.d = new ArrayList();
        this.l = true;
        this.m = new View.OnClickListener() { // from class: dc.q71
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s71.i(this.a, view);
            }
        };
        if (fragment.getView() == null) {
            throw new IllegalStateException("The fragment's view not created yet,please call this after fragment's onViewCreated()");
        }
        if (fragment.isDetached()) {
            throw new IllegalStateException("The fragment have detached. It is not attach to an activity!");
        }
        View decorView = fragment.requireActivity().getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        this.f = viewGroup;
        this.b = fragment.getView();
        this.a = true;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.g = new MaskContainer(context, null, 2, 0 == true ? 1 : 0);
    }

    public static final void i(s71 this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super View, Unit> function1 = this$0.k;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
        }
        if (this$0.l) {
            this$0.o();
        }
    }

    public final void d(u71 u71Var) {
        if (u71Var.getB() == null) {
            u71Var.n(this.f.findViewById(u71Var.getA()));
        }
        if (u71Var.getD() == null && e(u71Var)) {
            u71Var.s(LayoutInflater.from(this.g.getContext()).inflate(u71Var.getC(), (ViewGroup) this.g, false));
        }
        if (u71Var.getE() == null) {
            u71Var.p(new y71(z71.b(2.0f), z71.b(2.0f), z71.b(2.0f)));
        }
        z71.a(u71Var, this.f);
    }

    public final boolean e(u71 u71Var) {
        return u71Var.getC() != -1;
    }

    public void f() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.g.setFocusable(false);
        this.g.clearFocus();
        this.f.removeView(this.g);
        this.g.removeAllViews();
        Function0<Unit> function0 = this.j;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean g() {
        return !this.d.isEmpty();
    }

    public final void j(int i) {
        this.g.setBackgroundColor(i);
    }

    public final void k(@NotNull Function0<u71> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.h) {
            return;
        }
        this.d.add(CollectionsKt__CollectionsJVMKt.listOf(block.invoke()));
    }

    public final void l(@NotNull Function0<Unit> dismissCallback) {
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        this.j = dismissCallback;
    }

    public final void m(@NotNull Function1<? super Integer, Unit> showCallback) {
        Intrinsics.checkNotNullParameter(showCallback, "showCallback");
        this.i = showCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r2 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n() {
        /*
            r5 = this;
            boolean r0 = r5.h
            if (r0 == 0) goto L5
            return
        L5:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = "HYY-GuideProImpl show"
            r0.println(r1)
            com.hyy.highlightpro.view.MaskContainer r0 = r5.g
            android.view.View$OnClickListener r1 = r5.m
            r0.setOnClickListener(r1)
            boolean r0 = r5.a
            r1 = 1
            if (r0 != 0) goto L20
            android.view.ViewGroup r0 = r5.f
            boolean r0 = dc.z71.d(r0)
            if (r0 != 0) goto L32
        L20:
            boolean r0 = r5.a
            if (r0 == 0) goto L66
            android.view.View r0 = r5.b
            r2 = 0
            if (r0 == 0) goto L30
            int r0 = r0.getWidth()
            if (r0 != 0) goto L30
            r2 = 1
        L30:
            if (r2 != 0) goto L66
        L32:
            com.hyy.highlightpro.view.MaskContainer r0 = r5.g
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L8b
            android.view.ViewGroup r0 = r5.f
            com.hyy.highlightpro.view.MaskContainer r2 = r5.g
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r4 = -1
            r3.<init>(r4, r4)
            r0.addView(r2, r3)
            com.hyy.highlightpro.view.MaskContainer r0 = r5.g
            boolean r0 = r0.getG()
            if (r0 == 0) goto L62
            com.hyy.highlightpro.view.MaskContainer r0 = r5.g
            r0.setFocusable(r1)
            r0.setFocusableInTouchMode(r1)
            r0.requestFocus()
            dc.s71$c r1 = new dc.s71$c
            r1.<init>()
            r0.setOnBackPressedCallback(r1)
        L62:
            r5.o()
            goto L8b
        L66:
            boolean r0 = r5.a
            java.lang.String r1 = "View.doOnPreDraw(\n    cr…dd(this) { action(this) }"
            if (r0 == 0) goto L7d
            android.view.View r0 = r5.b
            if (r0 == 0) goto L8b
            dc.s71$a r2 = new dc.s71$a
            r2.<init>(r0, r5)
            androidx.core.view.OneShotPreDrawListener r0 = androidx.core.view.OneShotPreDrawListener.add(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L8b
        L7d:
            android.view.ViewGroup r0 = r5.f
            dc.s71$b r2 = new dc.s71$b
            r2.<init>(r0, r5)
            androidx.core.view.OneShotPreDrawListener r0 = androidx.core.view.OneShotPreDrawListener.add(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.s71.n():void");
    }

    public final void o() {
        if (this.h) {
            return;
        }
        System.out.println((Object) "HYY-GuideProImpl showNextHighLightView");
        if (!g()) {
            f();
            return;
        }
        Iterator<T> it = this.d.get(0).iterator();
        while (it.hasNext()) {
            d((u71) it.next());
        }
        Function1<? super Integer, Unit> function1 = this.i;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.c));
        }
        this.c++;
        this.g.setRootWidth((this.f.getWidth() - this.f.getPaddingLeft()) - this.f.getPaddingRight());
        this.g.setRootHeight((this.f.getHeight() - this.f.getPaddingTop()) - this.f.getPaddingBottom());
        this.g.setHighLightParameters(this.d.get(0));
        this.d.remove(0);
    }
}
