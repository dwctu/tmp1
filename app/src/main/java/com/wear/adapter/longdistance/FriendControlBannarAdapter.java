package com.wear.adapter.longdistance;

import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.util.WearUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FriendControlBannarAdapter extends BaseAdapter<GroupMember> {
    public FriendControlBannarAdapter(ArrayList<GroupMember> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, GroupMember groupMember, int i) {
        WearUtils.t2((ImageView) viewHolder.getView(R.id.iv_user_img), groupMember);
    }
}
