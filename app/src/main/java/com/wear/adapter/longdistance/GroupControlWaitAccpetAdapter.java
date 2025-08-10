package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.util.WearUtils;
import dc.kf;
import dc.qo;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupControlWaitAccpetAdapter extends BaseAdapter<GroupMember> {
    public qo j;

    public GroupControlWaitAccpetAdapter(ArrayList<GroupMember> arrayList, int i) {
        super(arrayList, i);
        this.j = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, GroupMember groupMember, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_user_img);
        String avatar = groupMember.getAvatar();
        if (!TextUtils.isEmpty(avatar) && !avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        if (groupMember.getStatus() == 1) {
            viewHolder.getView(R.id.tv_status).setVisibility(8);
        } else {
            viewHolder.getView(R.id.tv_status).setVisibility(0);
        }
        kf.w(imageView.getContext()).v(avatar).a(this.j).A0(imageView);
    }
}
