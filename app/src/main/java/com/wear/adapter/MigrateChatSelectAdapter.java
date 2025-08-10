package com.wear.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Group;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.kf;
import dc.qo;
import dc.tg3;
import java.util.List;

/* loaded from: classes3.dex */
public class MigrateChatSelectAdapter extends BaseAdapter<IPeopleInfo> {
    public a j;
    public qo k;

    public interface a {
        boolean i(IPeopleInfo iPeopleInfo, boolean z);
    }

    public MigrateChatSelectAdapter(List<IPeopleInfo> list, int i) {
        super(list, i);
        this.k = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(IPeopleInfo iPeopleInfo, ImageView imageView, View view) {
        a aVar = this.j;
        if (aVar != null) {
            if (aVar.i(iPeopleInfo, false)) {
                imageView.setImageResource(R.drawable.chat_pattern_item_select);
            } else {
                imageView.setImageResource(R.drawable.chat_pattern_item_unselect);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B(List<IPeopleInfo> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    public void C(a aVar) {
        this.j = aVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, final IPeopleInfo iPeopleInfo, int i) {
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_migrate_select_iv);
        a aVar = this.j;
        if (aVar != null) {
            if (aVar.i(iPeopleInfo, true)) {
                imageView.setImageResource(R.drawable.chat_pattern_item_select);
            } else {
                imageView.setImageResource(R.drawable.chat_pattern_item_unselect);
            }
        }
        RoundedImageView roundedImageView = (RoundedImageView) viewHolder.getView(R.id.item_migrate_select_iv_header);
        if (iPeopleInfo.isGroup()) {
            Group group = (Group) iPeopleInfo;
            if (group.getMembers().size() == 1) {
                roundedImageView.setBorderWidth(ce3.a(this.c, 4.0f) * 1.0f);
            } else {
                roundedImageView.setBorderWidth(0.0f);
            }
            tg3.i(roundedImageView, group);
        } else {
            roundedImageView.setBorderWidth(0.0f);
            kf.w(this.c).v(WearUtils.e + iPeopleInfo.getAvatar()).a(this.k).A0(roundedImageView);
        }
        viewHolder.a(R.id.item_migrate_select_tv_username, iPeopleInfo.getShowNickName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.rj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A(iPeopleInfo, imageView, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
