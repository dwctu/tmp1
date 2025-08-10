package com.wear.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.response.VersionHistoryResponse;
import com.wear.util.WearUtils;
import dc.th4;
import java.util.List;

/* loaded from: classes3.dex */
public class VersionHistoryAdapter extends BaseAdapter<VersionHistoryResponse.DataDTO.PageItemsDTO> {
    public LinearLayoutManager j;

    public VersionHistoryAdapter(List<VersionHistoryResponse.DataDTO.PageItemsDTO> list, int i) {
        super(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(VersionHistoryResponse.DataDTO.PageItemsDTO pageItemsDTO, int i, View view) {
        BaseAdapter.b bVar = this.a;
        if (bVar != null) {
            bVar.a0(pageItemsDTO, i, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void C(List<VersionHistoryResponse.DataDTO.PageItemsDTO> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, final VersionHistoryResponse.DataDTO.PageItemsDTO pageItemsDTO, final int i) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.sj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.B(pageItemsDTO, i, view);
            }
        });
        ((TextView) viewHolder.itemView.findViewById(R.id.title)).setTextColor(th4.b(this.c, R.color.version_history_text));
        ((TextView) viewHolder.itemView.findViewById(R.id.time)).setTextColor(th4.b(this.c, R.color.version_history_text_gray));
        viewHolder.a(R.id.title, pageItemsDTO.getAppName() + " " + pageItemsDTO.getVersion());
        viewHolder.a(R.id.time, WearUtils.N0(pageItemsDTO.getReleaseTimeStamp().longValue()));
        viewHolder.itemView.findViewById(R.id.underLine).setVisibility(8);
        this.j.findFirstVisibleItemPosition();
        this.j.findLastVisibleItemPosition();
        List<T> list = this.b;
        if (list != 0) {
            if (list.size() == 1) {
                viewHolder.itemView.setBackground(th4.d(this.c, R.drawable.item_version_history));
            }
            if (this.b.size() > 1) {
                if (i == 0) {
                    viewHolder.itemView.setBackground(th4.d(this.c, R.drawable.item_version_history_top));
                    viewHolder.itemView.findViewById(R.id.underLine).setVisibility(0);
                } else if (i == this.b.size() - 1) {
                    viewHolder.itemView.setBackground(th4.d(this.c, R.drawable.item_version_history_bottom));
                } else {
                    viewHolder.itemView.setBackground(th4.d(this.c, R.drawable.item_version_history_center));
                    viewHolder.itemView.findViewById(R.id.underLine).setVisibility(0);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.j = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    public void z(List<VersionHistoryResponse.DataDTO.PageItemsDTO> list) {
        this.b.addAll(list);
        notifyDataSetChanged();
    }
}
