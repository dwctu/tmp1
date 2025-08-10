package com.wear.adapter.base;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import dc.yv3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseAutoDataBindingHolder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/adapter/base/BaseAutoDataBindingHolder;", "BD", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseAutoDataBindingHolder<BD extends ViewDataBinding> extends BaseDataBindingHolder<BD> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAutoDataBindingHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        yv3.a(view);
    }
}
