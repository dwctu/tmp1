package com.wear.ui.chat.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.lovense.wear.R;
import com.wear.bean.chat.ChatActionMenuBean;
import com.wear.databinding.ItemChatActionMenuBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatActionMenuAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/wear/ui/chat/adapter/ChatActionMenuAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/chat/ChatActionMenuBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/wear/databinding/ItemChatActionMenuBinding;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatActionMenuAdapter extends BaseQuickAdapter<ChatActionMenuBean, BaseDataBindingHolder<ItemChatActionMenuBinding>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActionMenuAdapter(@NotNull List<ChatActionMenuBean> datas) {
        super(R.layout.item_chat_action_menu, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseDataBindingHolder<ItemChatActionMenuBinding> holder, @NotNull ChatActionMenuBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemChatActionMenuBinding itemChatActionMenuBinding = (ItemChatActionMenuBinding) holder.getDataBinding();
        if (itemChatActionMenuBinding != null) {
            itemChatActionMenuBinding.b(item);
            itemChatActionMenuBinding.executePendingBindings();
        }
    }
}
