package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Group;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.kf;
import dc.mg3;
import dc.qo;
import dc.tg3;
import java.util.ArrayList;
import java.util.HashMap;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class FriendShowSearchAdapter extends BaseAdapter<IPeopleInfo> {
    public String j;
    public MyApplication k;
    public qo l;

    public FriendShowSearchAdapter(ArrayList<IPeopleInfo> arrayList, int i) {
        super(arrayList, i);
        this.j = "";
        this.k = WearUtils.x;
        this.l = new qo().c().h(R.drawable.icon_default_new).X(R.drawable.icon_default_new);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void v(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        if (iPeopleInfo.getTempViewType() == 1) {
            viewHolder.a(R.id.tv_tip, ah4.e(R.string.people_chat_contact));
        } else {
            viewHolder.a(R.id.tv_tip, ah4.e(R.string.people_group_chats));
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_user_img);
        ImageView imageView2 = (ImageView) viewHolder.getView(R.id.iv_official);
        String avatar = iPeopleInfo.getAvatar();
        if (iPeopleInfo.isGroup()) {
            tg3.i(imageView, (Group) iPeopleInfo);
        } else if (iPeopleInfo instanceof OfficialAcount) {
            imageView.setImageResource(((OfficialAcount) iPeopleInfo).getAvatarRes());
        } else {
            if (!avatar.startsWith("http")) {
                avatar = WearUtils.e + avatar;
            }
            kf.w(this.k).v(avatar).a(this.l).A0(imageView);
        }
        boolean z = iPeopleInfo instanceof OfficialAcount;
        if (z) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        String remark = iPeopleInfo.getRemark();
        String userName = iPeopleInfo.getUserName();
        TextView textView = (TextView) viewHolder.getView(R.id.tv_show_name);
        TextView textView2 = (TextView) viewHolder.getView(R.id.tv_user_name);
        TextView textView3 = (TextView) viewHolder.getView(R.id.tv_user_name_tip);
        LinearLayout linearLayout = (LinearLayout) viewHolder.getView(R.id.ll_user_name);
        if (!TextUtils.isEmpty(remark)) {
            textView.setText(mg3.a(this.k, remark, this.j));
            if (remark.toLowerCase().contains(this.j.toLowerCase())) {
                linearLayout.setVisibility(8);
            } else if (iPeopleInfo.isGroup()) {
                Group group = (Group) iPeopleInfo;
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().contains(this.j.toLowerCase())) {
                    textView2.setText(mg3.a(this.k, userName, this.j));
                    linearLayout.setVisibility(0);
                    textView3.setText(ah4.e(R.string.group_chat_group_name) + ": ");
                } else if (group.isExit()) {
                    String rns = group.getRns();
                    if (WearUtils.e1(rns)) {
                        rns = group.getShowNickName();
                    }
                    textView2.setText(mg3.a(this.k, rns, this.j));
                    linearLayout.setVisibility(0);
                    textView3.setText(ah4.e(R.string.group_member) + ": ");
                } else {
                    textView2.setText(mg3.b(this.k, group.getList(), this.j));
                    linearLayout.setVisibility(0);
                    textView3.setText(ah4.e(R.string.group_member) + ": ");
                }
            } else if (z) {
                textView2.setText(mg3.a(this.k, userName, this.j));
                linearLayout.setVisibility(8);
            } else {
                textView2.setText(mg3.a(this.k, userName, this.j));
                linearLayout.setVisibility(0);
                textView3.setText(ah4.e(R.string.signup_name_hint) + ": ");
            }
        } else if (iPeopleInfo.isGroup()) {
            Group group2 = (Group) iPeopleInfo;
            if (TextUtils.isEmpty(userName)) {
                String rns2 = group2.getRns();
                if (WearUtils.e1(rns2)) {
                    rns2 = group2.getShowNickName();
                }
                textView.setText(mg3.a(this.k, rns2, this.j));
                if (group2.isExit() || rns2.toLowerCase().contains(this.j.toLowerCase())) {
                    linearLayout.setVisibility(8);
                } else {
                    textView2.setText(mg3.b(this.k, group2.getList(), this.j));
                    linearLayout.setVisibility(0);
                    textView3.setText(ah4.e(R.string.group_member) + ": ");
                }
            } else {
                textView.setText(mg3.a(this.k, userName, this.j));
                if (userName.toLowerCase().contains(this.j.toLowerCase())) {
                    linearLayout.setVisibility(8);
                } else if (group2.isExit()) {
                    textView2.setText(mg3.a(this.k, group2.getRns(), this.j));
                    linearLayout.setVisibility(0);
                    textView3.setText(ah4.e(R.string.group_member) + ": ");
                } else {
                    textView2.setText(mg3.b(this.k, group2.getList(), this.j));
                    textView3.setText(ah4.e(R.string.group_member) + ": ");
                    linearLayout.setVisibility(0);
                }
            }
        } else {
            if (z) {
                if ("notification assistant".contains(this.j.toLowerCase())) {
                    userName = "Notification Assistant";
                }
            } else if (WearUtils.e1(userName)) {
                userName = iPeopleInfo.getShowNickName();
            }
            textView.setText(mg3.a(this.k, userName, this.j));
            linearLayout.setVisibility(8);
        }
        C(viewHolder, iPeopleInfo);
    }

    public void C(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo) {
        FrameLayout frameLayout = (FrameLayout) viewHolder.getView(R.id.fl_online_status);
        View view = viewHolder.getView(R.id.sv_online_status_online);
        View view2 = viewHolder.getView(R.id.sv_online_status_offline);
        if (iPeopleInfo.isGroup()) {
            frameLayout.setVisibility(4);
            return;
        }
        if (iPeopleInfo instanceof OfficialAcount) {
            frameLayout.setVisibility(8);
            return;
        }
        Presence.Mode statusMode = iPeopleInfo.getStatusMode();
        if (iPeopleInfo.isOnline()) {
            frameLayout.setVisibility(0);
            view.setVisibility(0);
        } else if (statusMode == Presence.Mode.dnd) {
            frameLayout.setVisibility(0);
            view2.setVisibility(0);
        } else {
            frameLayout.setVisibility(8);
            view.setVisibility(8);
            view2.setVisibility(8);
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

    public void z(String str) {
        if (str == null) {
            str = "";
        }
        this.j = str;
    }
}
