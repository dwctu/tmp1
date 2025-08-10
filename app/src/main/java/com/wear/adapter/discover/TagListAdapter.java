package com.wear.adapter.discover;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.data.TagList;
import dc.ce3;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TagListAdapter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/wear/adapter/discover/TagListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/data/TagList;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TagListAdapter extends BaseQuickAdapter<TagList, BaseViewHolder> {
    public TagListAdapter() {
        super(R.layout.item_voice_book_tag, new ArrayList());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull TagList item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = (TextView) holder.getView(R.id.text);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        textView.setSelected(item.getSelect());
        int layoutPosition = holder.getLayoutPosition();
        if (layoutPosition == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ce3.a(J(), 16.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ce3.a(J(), 5.0f);
        } else if (layoutPosition == getItemCount() - 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ce3.a(J(), 5.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ce3.a(J(), 16.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ce3.a(J(), 5.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ce3.a(J(), 5.0f);
        }
        String name = item.getName();
        if (name != null) {
            textView.setText(name);
        }
    }
}
