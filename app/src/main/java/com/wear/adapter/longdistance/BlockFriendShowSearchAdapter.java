package com.wear.adapter.longdistance;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.handlerbean.IContactInfo;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kf;
import dc.mg3;
import dc.qo;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class BlockFriendShowSearchAdapter extends BaseAdapter<IContactInfo> {
    public String j;
    public MyApplication k;
    public qo l;

    public BlockFriendShowSearchAdapter(ArrayList<IContactInfo> arrayList, int i) {
        super(arrayList, i);
        this.j = "";
        this.k = WearUtils.x;
        this.l = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IContactInfo iContactInfo, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_photo);
        String avatar = iContactInfo.getAvatar();
        if (!avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        kf.w(imageView.getContext()).v(avatar).a(this.l).A0(imageView);
        ((TextView) viewHolder.getView(R.id.contact_name)).setText(mg3.a(this.k, iContactInfo.getShowNickName(), this.j));
        ((FrameLayout) viewHolder.getView(R.id.fl_online_status)).setVisibility(8);
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
