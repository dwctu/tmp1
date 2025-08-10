package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import dc.kf;
import dc.qo;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupDSWaitAccpetAdapter extends BaseAdapter<IPeopleInfo> {
    public qo j;

    public GroupDSWaitAccpetAdapter(ArrayList<IPeopleInfo> arrayList, int i) {
        super(arrayList, i);
        this.j = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_user_img);
        GroupMember groupMember = (GroupMember) iPeopleInfo;
        String avatar = groupMember.getAvatar();
        if (!TextUtils.isEmpty(avatar) && !avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        TextView textView = (TextView) viewHolder.getView(R.id.tv_status);
        if (groupMember.getDSStatus() == 3 || groupMember.getDSStatus() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        kf.w(imageView.getContext()).v(avatar).a(this.j).A0(imageView);
    }
}
