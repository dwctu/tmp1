package com.wear.ui.longDistance.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.adapter.base.BaseAutoDataBindingHolder;
import com.wear.bean.ConnectionUserBean;
import com.wear.databinding.ItemConnectionRequestBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionsRequestAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/wear/ui/longDistance/adapter/ConnectionsRequestAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/ConnectionUserBean;", "Lcom/wear/adapter/base/BaseAutoDataBindingHolder;", "Lcom/wear/databinding/ItemConnectionRequestBinding;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "removeData", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionsRequestAdapter extends BaseQuickAdapter<ConnectionUserBean, BaseAutoDataBindingHolder<ItemConnectionRequestBinding>> {

    /* compiled from: Animator.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,136:1\n*E\n"})
    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ int b;

        public a(int i) {
            this.b = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ConnectionsRequestAdapter.this.q0(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionsRequestAdapter(@NotNull List<ConnectionUserBean> datas) {
        super(R.layout.item_connection_request, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseAutoDataBindingHolder<ItemConnectionRequestBinding> holder, @NotNull ConnectionUserBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemConnectionRequestBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.b(item);
            dataBinding.executePendingBindings();
        }
    }

    public final void J0(int i) {
        View viewZ = Z(i, R.id.root);
        if (viewZ == null) {
            return;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(viewZ, "translationX", 0.0f, viewZ.getWidth());
        objectAnimator.setDuration(300L);
        objectAnimator.start();
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "objectAnimator");
        objectAnimator.addListener(new a(i));
    }
}
