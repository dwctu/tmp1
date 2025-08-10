package dc;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.wear.databinding.PanelChatContainerBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionPanelAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wear/ui/chat/controller/FunctionPanelAdapter;", "VB", "Landroidx/viewbinding/ViewBinding;", "", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "createBinding", "binding", "Lcom/wear/databinding/PanelChatContainerBinding;", "(Lcom/wear/databinding/PanelChatContainerBinding;)Landroidx/viewbinding/ViewBinding;", "getTriggerViewId", "", "getViewBinding", "()Landroidx/viewbinding/ViewBinding;", "onBinding", "", "(Landroidx/viewbinding/ViewBinding;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class rs2<VB extends ViewBinding> {

    @NotNull
    public final Function3<LayoutInflater, ViewGroup, Boolean, VB> a;

    /* JADX WARN: Multi-variable type inference failed */
    public rs2(@NotNull Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VB> inflate) {
        Intrinsics.checkNotNullParameter(inflate, "inflate");
        this.a = inflate;
    }

    @NotNull
    public final VB j(@NotNull PanelChatContainerBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        VB vb = (VB) m();
        if (vb != null) {
            return vb;
        }
        Function3<LayoutInflater, ViewGroup, Boolean, VB> function3 = this.a;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(binding.getRoot().getContext());
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(binding.root.context)");
        return function3.invoke(layoutInflaterFrom, binding.getRoot(), Boolean.FALSE);
    }

    public abstract int k();

    @Nullable
    public VB m() {
        return null;
    }

    public abstract void n(@NotNull VB vb);
}
