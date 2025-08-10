package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.kf;
import dc.qo;
import java.util.ArrayList;
import java.util.HashMap;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class FriendShowOnLineAdapter extends BaseAdapter<IPeopleInfo> {
    public qo j;

    public FriendShowOnLineAdapter(ArrayList<IPeopleInfo> arrayList, int i) {
        super(arrayList, i);
        MyApplication myApplication = WearUtils.x;
        this.j = new qo().h(R.drawable.icon_default_new).X(R.drawable.icon_default_new);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_user_img);
        ImageView imageView2 = (ImageView) viewHolder.getView(R.id.online_status);
        String avatar = iPeopleInfo.getAvatar();
        if (TextUtils.isEmpty(avatar)) {
            imageView.setImageResource(R.drawable.icon_default_new);
        } else {
            if (!avatar.startsWith("http")) {
                avatar = WearUtils.e + avatar;
            }
            kf.w(imageView.getContext()).v(avatar).a(this.j).A0(imageView);
        }
        viewHolder.a(R.id.tv_show_name, iPeopleInfo.getShowNickName());
        B(iPeopleInfo, imageView2);
    }

    public void B(IPeopleInfo iPeopleInfo, ImageView imageView) {
        if (iPeopleInfo.isGroup()) {
            imageView.setVisibility(4);
            return;
        }
        imageView.setVisibility(0);
        Presence.Mode statusMode = iPeopleInfo.getStatusMode();
        if (!iPeopleInfo.isOnline() || statusMode == null) {
            imageView.setImageResource(R.drawable.content_icon_status_offline);
        } else if (statusMode == Presence.Mode.chat) {
            imageView.setImageResource(R.drawable.status_available);
        } else if (statusMode == Presence.Mode.dnd) {
            imageView.setImageResource(R.drawable.status_busy);
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    public int n(int i) {
        return ((IPeopleInfo) this.b.get(i)).getTempViewType();
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
        HashMap<Integer, Integer> map = this.d;
        Integer numValueOf = Integer.valueOf(R.layout.view_friends_search_list_title);
        map.put(1, numValueOf);
        this.d.put(2, numValueOf);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void v(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        if (iPeopleInfo.getTempViewType() == 1) {
            viewHolder.a(R.id.tv_tip, ah4.e(R.string.people_chat_contact));
        } else {
            viewHolder.a(R.id.tv_tip, ah4.e(R.string.people_group_chats));
        }
    }
}
