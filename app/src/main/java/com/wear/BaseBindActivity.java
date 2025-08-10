package com.wear;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseBindActivity.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00028\u0000X\u0086.¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/wear/BaseBindActivity;", "DATABIND", "Landroidx/databinding/ViewDataBinding;", "Lcom/wear/BaseViewModelActivity;", "contentLayoutId", "", "viewModelBr", "(ILjava/lang/Integer;)V", "getContentLayoutId", "()I", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "Ljava/lang/Integer;", "getContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initData", "", "initView", "onBindView", "onCreate", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseBindActivity<DATABIND extends ViewDataBinding> extends BaseViewModelActivity {
    public final int c;

    @Nullable
    public final Integer d;
    public DATABIND e;

    public BaseBindActivity(@LayoutRes int i, @Nullable Integer num) {
        this.c = i;
        this.d = num;
    }

    @Override // com.wear.BaseViewModelActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer num = this.d;
        if (num != null) {
            v4().setVariable(num.intValue(), t4());
        }
        y4();
        v4().setLifecycleOwner(this);
        x4();
        w4();
    }

    @Override // com.wear.BaseViewModelActivity
    @NotNull
    public View s4(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(getLayoutInflater(), this.c, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(layoutInflater, …youtId, container, false)");
        z4(viewDataBindingInflate);
        View root = v4().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "dataBinding.root");
        return root;
    }

    @NotNull
    public final DATABIND v4() {
        DATABIND databind = this.e;
        if (databind != null) {
            return databind;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        return null;
    }

    public abstract void w4();

    public abstract void x4();

    public void y4() {
    }

    public final void z4(@NotNull DATABIND databind) {
        Intrinsics.checkNotNullParameter(databind, "<set-?>");
        this.e = databind;
    }
}
