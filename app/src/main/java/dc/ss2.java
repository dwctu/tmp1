package dc;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewbinding.ViewBinding;
import com.wear.databinding.PanelChatContainerBinding;
import com.wear.ui.chat.pancel.helper.view.PanelEmptyView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FunctionPanelFactory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/wear/ui/chat/controller/FunctionPanelFactory;", "", "binding", "Lcom/wear/databinding/PanelChatContainerBinding;", "(Lcom/wear/databinding/PanelChatContainerBinding;)V", "getBinding", "()Lcom/wear/databinding/PanelChatContainerBinding;", "createWithAdapter", "", "VB", "Landroidx/viewbinding/ViewBinding;", "adapter", "Lcom/wear/ui/chat/controller/FunctionPanelAdapter;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ss2 {

    @NotNull
    public final PanelChatContainerBinding a;

    public ss2(@NotNull PanelChatContainerBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = binding;
    }

    public final <VB extends ViewBinding> void a(@NotNull rs2<VB> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Context context = this.a.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        PanelEmptyView panelEmptyView = new PanelEmptyView(context, null, 2, null);
        panelEmptyView.setTriggerViewId(adapter.k());
        ViewBinding viewBindingJ = adapter.j(this.a);
        if (viewBindingJ.getRoot().getParent() != null) {
            ViewParent parent = viewBindingJ.getRoot().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(viewBindingJ.getRoot());
            }
        }
        panelEmptyView.addView(viewBindingJ.getRoot());
        adapter.n(viewBindingJ);
        this.a.getRoot().addView(panelEmptyView);
    }
}
