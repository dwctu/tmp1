package com.wear.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.GameModeToysBean;
import com.wear.bean.Toy;
import dc.ah4;
import dc.th4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: GameModeToyAdapter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/wear/adapter/GameModeToyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/GameModeToysBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "CenterSpanSizeLookup", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GameModeToyAdapter extends BaseQuickAdapter<GameModeToysBean, BaseViewHolder> {

    /* compiled from: GameModeToyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/wear/adapter/GameModeToyAdapter$CenterSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanCount", "", "allCount", "(II)V", "getAllCount", "()I", "setAllCount", "(I)V", "getSpanCount", "setSpanCount", "getSpanSize", "position", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CenterSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        public int a;
        public int b;

        public CenterSpanSizeLookup(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            int[][] iArr = {new int[]{30, 0, 0}, new int[]{15, 15, 0}, new int[]{10, 10, 10}};
            int i = this.b;
            int i2 = this.a;
            int i3 = i / i2;
            return iArr[(i2 == i || position < i3 * i2) ? i2 - 1 : (i - (i3 * i2)) - 1][position % i2];
        }
    }

    public GameModeToyAdapter() {
        super(R.layout.item_game_mode_toys, new ArrayList());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull GameModeToysBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tv_toy_title);
        RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.rv_toy);
        Integer type = item.getType();
        if (type != null && type.intValue() == 0) {
            textView.setText(ah4.e(R.string.toys_control_games5));
            textView.setTextColor(th4.b(J(), R.color.text_color_b65_wo));
        } else if (type != null && type.intValue() == 1) {
            textView.setText(ah4.e(R.string.toys_control_games4));
            textView.setTextColor(th4.b(J(), R.color.top_tip_text_color));
        } else if (type != null && type.intValue() == 2) {
            textView.setText(ah4.e(R.string.toys_control_games3));
            textView.setTextColor(th4.b(J(), R.color.top_tip_text_color));
        }
        List<Toy> toys = item.getToys();
        if (toys != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(J(), 30);
            gridLayoutManager.setSpanSizeLookup(new CenterSpanSizeLookup(toys.size() < 3 ? toys.size() : 3, toys.size()));
            recyclerView.setLayoutManager(gridLayoutManager);
            GameModeSubToyAdapter gameModeSubToyAdapter = new GameModeSubToyAdapter();
            gameModeSubToyAdapter.r0(CollectionsKt___CollectionsKt.toMutableList((Collection) toys));
            recyclerView.setAdapter(gameModeSubToyAdapter);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        int paddingTop = holder.itemView.getPaddingTop();
        holder.itemView.setPadding(0, paddingTop, 0, holder.getAdapterPosition() == K().size() - 1 ? 0 : paddingTop);
    }
}
