package com.wear.adapter.longdistance;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IGroupMember;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.de3;
import dc.dm;
import dc.kf;
import dc.qo;
import dc.xe3;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupMemberAdapter extends BaseAdapter<IGroupMember> {
    public qo j;

    public class a implements View.OnClickListener {
        public final /* synthetic */ IGroupMember a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BaseAdapter.ViewHolder c;

        public a(IGroupMember iGroupMember, int i, BaseAdapter.ViewHolder viewHolder) {
            this.a = iGroupMember;
            this.b = i;
            this.c = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseAdapter.b bVar = GroupMemberAdapter.this.a;
            if (bVar != null) {
                bVar.a0(this.a, this.b, this.c.itemView);
            }
        }
    }

    public GroupMemberAdapter(ArrayList<IGroupMember> arrayList, int i, Context context) {
        super(arrayList, i);
        this.j = new qo().j0(new dm(de3.a(context, 8.0f))).h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IGroupMember iGroupMember, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_user_img);
        xe3.a("GroupMemberAdapter", iGroupMember.getNickName() + " " + iGroupMember.getAvatar());
        String avatar = iGroupMember.getAvatar();
        if (!avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        kf.w(this.c).v(avatar).a(this.j).A0(imageView);
        String nickName = iGroupMember.getNickName();
        User userV = ch3.n().v(iGroupMember.getId());
        if (userV != null && !TextUtils.isEmpty(userV.getShowNickName())) {
            nickName = userV.getShowNickName();
        }
        viewHolder.a(R.id.tv_user_name, nickName);
        if (iGroupMember.isAdmin()) {
            viewHolder.getView(R.id.iv_role).setVisibility(0);
        } else {
            viewHolder.getView(R.id.iv_role).setVisibility(8);
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    public int n(int i) {
        return ((IGroupMember) this.b.get(i)).getTempViewType();
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
        this.d.put(2, Integer.valueOf(R.layout.item_group_member_add));
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void v(BaseAdapter.ViewHolder viewHolder, IGroupMember iGroupMember, int i) {
        viewHolder.itemView.setOnClickListener(new a(iGroupMember, i, viewHolder));
    }
}
