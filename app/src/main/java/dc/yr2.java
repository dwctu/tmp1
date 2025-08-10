package dc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import com.wear.databinding.ItemChatSystemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SystemItemProvider.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/SystemItemProvider;", "Lcom/wear/ui/chat/adapter/provoder/BaseProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/wear/bean/chat/Message;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class yr2 extends wr2 {
    @Override // dc.lr
    public int g() {
        return 0;
    }

    @Override // dc.lr
    public int h() {
        return R.layout.item_chat_system;
    }

    @Override // dc.lr
    @NotNull
    public BaseViewHolder m(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemChatSystemBinding itemChatSystemBindingB = ItemChatSystemBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemChatSystemBindingB, "inflate(LayoutInflater.f….context), parent, false)");
        View root = itemChatSystemBindingB.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new BaseDataBindingHolder(root);
    }

    @Override // dc.wr2
    /* renamed from: t */
    public void a(@NotNull BaseViewHolder helper, @NotNull Message item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        super.a(helper, item);
        ItemChatSystemBinding itemChatSystemBinding = (ItemChatSystemBinding) DataBindingUtil.getBinding(helper.itemView);
        if (itemChatSystemBinding == null) {
            return;
        }
        itemChatSystemBinding.d(item);
        itemChatSystemBinding.executePendingBindings();
        BaseProviderMultiAdapter<Message> baseProviderMultiAdapterC = c();
        if (baseProviderMultiAdapterC != null) {
            pr2.a(helper, baseProviderMultiAdapterC);
        }
    }
}
