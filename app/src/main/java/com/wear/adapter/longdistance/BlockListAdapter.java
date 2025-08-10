package com.wear.adapter.longdistance;

import android.view.View;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.BlockFriend;
import com.wear.util.WearUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BlockListAdapter extends BaseAdapter<BlockFriend> {
    public b j;

    public class a implements View.OnClickListener {
        public final /* synthetic */ BlockFriend a;

        public a(BlockFriend blockFriend) {
            this.a = blockFriend;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = BlockListAdapter.this.j;
            if (bVar != null) {
                bVar.z2(this.a);
            }
        }
    }

    public interface b {
        void z2(BlockFriend blockFriend);
    }

    public BlockListAdapter(ArrayList<BlockFriend> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, BlockFriend blockFriend, int i) {
        WearUtils.u2((ImageView) viewHolder.getView(R.id.riv_user_img), blockFriend.getAvatar());
        viewHolder.a(R.id.tv_name, blockFriend.getName());
        viewHolder.itemView.setOnClickListener(new a(blockFriend));
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
    }

    public void z(b bVar) {
        this.j = bVar;
    }
}
