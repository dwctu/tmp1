package com.wear;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import dc.ui1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateWrapLayout.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:BG\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\rJ\u001e\u0010\u0017\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J`\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\b2\u0019\u0010!\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"¢\u0006\u0002\b$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0018H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016JY\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010\u001d2\b\u0010-\u001a\u0004\u0018\u00010\u001d2\b\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u00010\b2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&H\u0016¢\u0006\u0002\u00102J+\u00103\u001a\u00020\u00182\b\b\u0001\u00104\u001a\u0002052\n\b\u0001\u00106\u001a\u0004\u0018\u00010\b2\u0006\u00107\u001a\u00020\u001aH\u0016¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u00182\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0002X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006;"}, d2 = {"Lcom/wear/StateWrapLayout;", "Landroid/widget/FrameLayout;", "Lcom/wear/IStateView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", FirebaseAnalytics.Param.CONTENT, "Landroid/view/View;", "stateLayout", "(Landroid/content/Context;Landroid/util/AttributeSet;IILandroid/view/View;Lcom/wear/IStateView;)V", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "delegate", "getDelegate", "()Lcom/wear/IStateView;", "setDelegate", "(Lcom/wear/IStateView;)V", "initView", "", "isShowContent", "", "setTitleBar", MessageBundle.TITLE_ENTRY, "", "bgColor", "titleColor", "backRes", "bgUpdate", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ExtensionFunctionType;", "back", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lcom/wear/IStateView;", "showContent", "showEmpty", "showError", OrmLiteConfigUtil.RESOURCE_DIR_NAME, "tips", "btnText", "backGroundRes", "isShowWgLogo", "tipsTextColor", "block", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "showLoading", "alpha", "", "loadingRes", "cancelable", "(FLjava/lang/Integer;Z)V", "showNetworkError", "Helper", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StateWrapLayout extends FrameLayout implements ui1 {

    @Nullable
    public View a;
    public ui1 b;

    /* compiled from: StateWrapLayout.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/wear/StateWrapLayout$Helper;", "", "()V", "wrap", "Lcom/wear/StateWrapLayout;", "view", "Landroid/view/View;", "stateLayout", "Lcom/wear/IStateView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        @NotNull
        public static final a a = new a();

        public static /* synthetic */ StateWrapLayout b(a aVar, View view, ui1 ui1Var, int i, Object obj) {
            if ((i & 2) != 0) {
                ui1Var = null;
            }
            return aVar.a(view, ui1Var);
        }

        @NotNull
        public final StateWrapLayout a(@NotNull View view, @Nullable ui1 ui1Var) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof StateWrapLayout) {
                return (StateWrapLayout) view;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof StateWrapLayout) {
                return (StateWrapLayout) parent;
            }
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            return new StateWrapLayout(context, null, 0, 0, view, ui1Var, 14, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateWrapLayout(@NotNull Context context) {
        this(context, null, 0, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateWrapLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, null, null, 60, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateWrapLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, null, null, 56, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StateWrapLayout(Context context, AttributeSet attributeSet, int i, int i2, View view, ui1 ui1Var, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? null : view, (i3 & 32) == 0 ? ui1Var : null);
    }

    public final void a(View view, ui1 ui1Var) {
        if (!(getChildCount() <= 2)) {
            throw new IllegalStateException("StateWrapLayout can only host two direct child, one is content, one is stateLayout".toString());
        }
        setBackground(new ColorDrawable(0));
        setClickable(true);
        if (view == null) {
            this.a = getChildAt(0);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewParent parent = view.getParent();
        Unit unit = null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            int iIndexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            addView(view, new FrameLayout.LayoutParams(-1, -1));
            viewGroup.addView(this, iIndexOfChild, layoutParams);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        this.a = view;
    }

    @Nullable
    /* renamed from: getContent, reason: from getter */
    public final View getA() {
        return this.a;
    }

    @NotNull
    public final ui1 getDelegate() {
        ui1 ui1Var = this.b;
        if (ui1Var != null) {
            return ui1Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        return null;
    }

    public final void setContent(@Nullable View view) {
        this.a = view;
    }

    public final void setDelegate(@NotNull ui1 ui1Var) {
        Intrinsics.checkNotNullParameter(ui1Var, "<set-?>");
        this.b = ui1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateWrapLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2, @Nullable View view, @Nullable ui1 ui1Var) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        a(view, ui1Var);
    }
}
