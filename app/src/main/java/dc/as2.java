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
import com.wear.databinding.ItemChatTextRightBinding;
import com.wear.ui.chat.adapter.ChatAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextRightItemProvider.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/TextRightItemProvider;", "Lcom/wear/ui/chat/adapter/provoder/BaseTextItemProvider;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "isSelectMode", "", "chatAdapterListener", "Lcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;", "(Lcom/wear/util/EmojisUtils;ZLcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;)V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/wear/bean/chat/Message;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class as2 extends xr2 {

    @NotNull
    public final ie3 f;
    public final boolean g;

    @Nullable
    public final ChatAdapter.a h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as2(@NotNull ie3 emojisUtils, boolean z, @Nullable ChatAdapter.a aVar) {
        super(emojisUtils);
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        this.f = emojisUtils;
        this.g = z;
        this.h = aVar;
    }

    @Override // dc.lr
    public int g() {
        return 2;
    }

    @Override // dc.lr
    public int h() {
        return R.layout.item_chat_text_right;
    }

    @Override // dc.lr
    @NotNull
    public BaseViewHolder m(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemChatTextRightBinding itemChatTextRightBindingB = ItemChatTextRightBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemChatTextRightBindingB, "inflate(LayoutInflater.f….context), parent, false)");
        View root = itemChatTextRightBindingB.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new BaseDataBindingHolder(root);
    }

    @Override // dc.xr2, dc.wr2
    /* renamed from: t */
    public void a(@NotNull BaseViewHolder helper, @NotNull Message item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        super.a(helper, item);
        ItemChatTextRightBinding itemChatTextRightBinding = (ItemChatTextRightBinding) DataBindingUtil.getBinding(helper.itemView);
        if (itemChatTextRightBinding != null) {
            itemChatTextRightBinding.h(item);
        }
        if (itemChatTextRightBinding != null) {
            itemChatTextRightBinding.f(Boolean.valueOf(this.g));
        }
        if (itemChatTextRightBinding != null) {
            itemChatTextRightBinding.d(Integer.valueOf(getE()));
        }
        if (itemChatTextRightBinding != null) {
            itemChatTextRightBinding.e(this.f);
        }
        if (itemChatTextRightBinding != null) {
            itemChatTextRightBinding.g(this.h);
        }
        if (itemChatTextRightBinding != null) {
            itemChatTextRightBinding.executePendingBindings();
        }
        BaseProviderMultiAdapter<Message> baseProviderMultiAdapterC = c();
        if (baseProviderMultiAdapterC != null) {
            pr2.a(helper, baseProviderMultiAdapterC);
        }
    }
}
