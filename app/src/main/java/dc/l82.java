package dc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.GroupMemberRequest;
import com.wear.bean.IGroupMember;
import com.wear.databinding.ItemGroupManagerInvitationBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: GroupMemberProvider.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/wear/main/longDistance/adapter/GroupMemberRequestProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/wear/bean/IGroupMember;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class l82 extends lr<IGroupMember> {
    @Override // dc.lr
    public int g() {
        return 2;
    }

    @Override // dc.lr
    public int h() {
        return R.layout.item_group_manager_invitation;
    }

    @Override // dc.lr
    @NotNull
    public BaseViewHolder m(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemGroupManagerInvitationBinding itemGroupManagerInvitationBindingB = ItemGroupManagerInvitationBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemGroupManagerInvitationBindingB, "inflate(\n            Lay…          false\n        )");
        View root = itemGroupManagerInvitationBindingB.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new BaseDataBindingHolder(root);
    }

    @Override // dc.lr
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull BaseViewHolder helper, @NotNull IGroupMember item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        BaseDataBindingHolder baseDataBindingHolder = (BaseDataBindingHolder) helper;
        ItemGroupManagerInvitationBinding itemGroupManagerInvitationBinding = (ItemGroupManagerInvitationBinding) baseDataBindingHolder.getDataBinding();
        if (itemGroupManagerInvitationBinding != null) {
            itemGroupManagerInvitationBinding.d((GroupMemberRequest) item);
        }
        ItemGroupManagerInvitationBinding itemGroupManagerInvitationBinding2 = (ItemGroupManagerInvitationBinding) baseDataBindingHolder.getDataBinding();
        if (itemGroupManagerInvitationBinding2 != null) {
            itemGroupManagerInvitationBinding2.executePendingBindings();
        }
    }
}
