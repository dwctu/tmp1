package com.wear.adapter.longdistance;

import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.util.WearUtils;
import dc.ah4;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FriendControlAdapter extends BaseAdapter<GroupMember> {
    public FriendControlAdapter(ArrayList<GroupMember> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, GroupMember groupMember, int i) {
        WearUtils.t2((ImageView) viewHolder.getView(R.id.iv_user_img), groupMember);
        TextView textView = (TextView) viewHolder.getView(R.id.tv_status);
        if (groupMember.getStatus() == 2) {
            textView.setVisibility(8);
        } else if (groupMember.getStatus() == 1) {
            textView.setVisibility(0);
            textView.setText("...");
        } else {
            textView.setVisibility(0);
            textView.setText(ah4.e(R.string.common_busy));
        }
    }
}
