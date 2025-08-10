package com.wear.main.toy.newtoy;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToyRename;
import com.wear.dao.DaoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SearchToyAdapter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/wear/main/toy/newtoy/SearchToyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/Toy;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchToyAdapter extends BaseQuickAdapter<Toy, BaseViewHolder> {
    public SearchToyAdapter() {
        super(R.layout.toy_mytoyitem2, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull Toy item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ToyRename toyRenameFindToyRenameByAddress = DaoUtils.getToyRenameDao().findToyRenameByAddress(item.getAddress());
        if (toyRenameFindToyRenameByAddress != null) {
            item.setDefineRename(toyRenameFindToyRenameByAddress.getName());
        }
        String defineRename = item.getDefineRename();
        if (defineRename == null || defineRename.length() == 0) {
            holder.setText(R.id.toy_mytoyitem2_name, item.getSimpleFullName());
        } else {
            holder.setText(R.id.toy_mytoyitem2_name, item.getSimpleFullName() + " · " + item.getDefineRename());
        }
        holder.setText(R.id.toy_mytoyitem2_nameiv, item.getUpCaseName());
    }
}
