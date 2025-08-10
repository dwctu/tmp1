package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.widget.dialog.RouletteExpandDialog;
import dc.ExpandData;
import dc.ag3;
import dc.is3;
import dc.kr2;
import dc.my2;
import java.lang.reflect.InvocationTargetException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteExpandDialog.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0007R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/wear/widget/dialog/RouletteExpandDialog;", "Lcom/wear/widget/dialog/FullScreenDialog;", "Lcom/wear/main/control/ExpandData;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "LLExpandBg", "Landroid/widget/LinearLayout;", "blur", "Lcom/wear/util/RenderScriptGaussianBlur;", "chatMessageAction", "Lcom/wear/ui/chat/action/ChatMessageAction;", "getChatMessageAction", "()Lcom/wear/ui/chat/action/ChatMessageAction;", "chatMessageAction$delegate", "Lkotlin/Lazy;", "flRootView", "Landroid/widget/FrameLayout;", "ivIcon", "Landroid/widget/ImageView;", "tvPatternName", "Landroid/widget/TextView;", "getLayoutResID", "", "initData", "", "onClick", "view", "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RouletteExpandDialog extends FullScreenDialog<ExpandData> {

    @BindView(R.id.ll_expand_bg)
    @JvmField
    @Nullable
    public LinearLayout LLExpandBg;

    @BindView(R.id.fl_root_view)
    @JvmField
    @Nullable
    public FrameLayout flRootView;

    @NotNull
    public final Lazy g;

    @BindView(R.id.iv_icon)
    @JvmField
    @Nullable
    public ImageView ivIcon;

    @BindView(R.id.tv_pattern_name)
    @JvmField
    @Nullable
    public TextView tvPatternName;

    /* compiled from: RouletteExpandDialog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/action/ChatMessageAction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<kr2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kr2 invoke() {
            return kr2.c.a(kr2.b.MESSAGE);
        }
    }

    public RouletteExpandDialog(@Nullable Context context) {
        super(context);
        this.g = LazyKt__LazyJVMKt.lazy(a.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(RouletteExpandDialog this$0) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.LLExpandBg;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this$0.LLExpandBg;
        Intrinsics.checkNotNull(linearLayout2);
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        D d = this$0.c;
        Intrinsics.checkNotNull(d);
        int y = ((ExpandData) d).getY();
        layoutParams2.topMargin = y;
        if (y < 0) {
            layoutParams2.topMargin = 0;
        } else {
            FrameLayout frameLayout = this$0.flRootView;
            Intrinsics.checkNotNull(frameLayout);
            int height = frameLayout.getHeight();
            LinearLayout linearLayout3 = this$0.LLExpandBg;
            Intrinsics.checkNotNull(linearLayout3);
            if (y > height - linearLayout3.getHeight()) {
                FrameLayout frameLayout2 = this$0.flRootView;
                Intrinsics.checkNotNull(frameLayout2);
                int height2 = frameLayout2.getHeight();
                LinearLayout linearLayout4 = this$0.LLExpandBg;
                Intrinsics.checkNotNull(linearLayout4);
                layoutParams2.topMargin = height2 - linearLayout4.getHeight();
            }
        }
        D d2 = this$0.c;
        Intrinsics.checkNotNull(d2);
        if (((ExpandData) d2).getLeft()) {
            layoutParams2.gravity = 3;
            LinearLayout linearLayout5 = this$0.LLExpandBg;
            Intrinsics.checkNotNull(linearLayout5);
            linearLayout5.setBackgroundResource(R.drawable.minimize_expand_left);
            LinearLayout linearLayout6 = this$0.LLExpandBg;
            Intrinsics.checkNotNull(linearLayout6);
            animationLoadAnimation = AnimationUtils.loadAnimation(linearLayout6.getContext(), R.anim.slide_left);
            Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(LLExpandBg…ntext, R.anim.slide_left)");
        } else {
            layoutParams2.gravity = 5;
            LinearLayout linearLayout7 = this$0.LLExpandBg;
            Intrinsics.checkNotNull(linearLayout7);
            linearLayout7.setBackgroundResource(R.drawable.minimize_expand_right);
            LinearLayout linearLayout8 = this$0.LLExpandBg;
            Intrinsics.checkNotNull(linearLayout8);
            animationLoadAnimation = AnimationUtils.loadAnimation(linearLayout8.getContext(), R.anim.slide_right);
            Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(LLExpandBg…text, R.anim.slide_right)");
        }
        TextView textView = this$0.tvPatternName;
        Intrinsics.checkNotNull(textView);
        D d3 = this$0.c;
        Intrinsics.checkNotNull(d3);
        textView.setText(((ExpandData) d3).getName());
        ImageView imageView = this$0.ivIcon;
        Intrinsics.checkNotNull(imageView);
        D d4 = this$0.c;
        Intrinsics.checkNotNull(d4);
        imageView.setImageResource(((ExpandData) d4).getIcon());
        LinearLayout linearLayout9 = this$0.LLExpandBg;
        Intrinsics.checkNotNull(linearLayout9);
        linearLayout9.setLayoutParams(layoutParams2);
        LinearLayout linearLayout10 = this$0.LLExpandBg;
        Intrinsics.checkNotNull(linearLayout10);
        linearLayout10.startAnimation(animationLoadAnimation);
    }

    public static final void r(RouletteExpandDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogInterface.OnDismissListener onDismissListener = this$0.a.i;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_speed_mode_expand;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        new ag3(this.f);
        FrameLayout frameLayout = this.flRootView;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.post(new Runnable() { // from class: dc.zq3
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                RouletteExpandDialog.q(this.a);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.ar3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RouletteExpandDialog.r(this.a, dialogInterface);
            }
        });
    }

    @OnClick({R.id.iv_bg, R.id.iv_end, R.id.ll_expand_bg})
    public final void onClick(@NotNull View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        is3.d dVar;
        Intrinsics.checkNotNullParameter(view, "view");
        dismiss();
        int id = view.getId();
        if (id == R.id.iv_bg) {
            is3.c cVar = this.a.h;
            if (cVar != null) {
                cVar.doCancel();
                return;
            }
            return;
        }
        if (id == R.id.iv_end) {
            my2.i.a().y(true);
        } else if (id == R.id.ll_expand_bg && (dVar = this.a.g) != null) {
            dVar.doConfirm();
        }
    }
}
