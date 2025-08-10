package com.wear.adapter.longdistance;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Account;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IContactInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import dc.kf;
import dc.mg3;
import dc.qo;
import java.util.List;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class SearchChatUserAdapter extends BaseAdapter<IContactInfo> {
    public Context j;
    public qo k;
    public String l;

    public SearchChatUserAdapter(Context context, List<IContactInfo> list, int i) {
        super(list, i);
        this.j = context;
        this.k = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IContactInfo iContactInfo, int i) {
        String userName;
        TextView textView = (TextView) viewHolder.getView(R.id.contact_name);
        TextView textView2 = (TextView) viewHolder.getView(R.id.tv_emotion);
        RoundedImageView roundedImageView = (RoundedImageView) viewHolder.getView(R.id.iv_photo);
        FrameLayout frameLayout = (FrameLayout) viewHolder.getView(R.id.fl_online_status);
        ImageView imageView = (ImageView) viewHolder.getView(R.id.online_status);
        textView2.setVisibility(8);
        if (iContactInfo instanceof User) {
            User user = (User) iContactInfo;
            userName = user.getShowNickName();
            if (!TextUtils.isEmpty(user.getMoodMessage())) {
                textView2.setVisibility(0);
                textView2.setText(user.getMoodMessage());
            }
        } else {
            userName = iContactInfo instanceof Account ? ((Account) iContactInfo).getUserName() : iContactInfo instanceof GroupMember ? ((GroupMember) iContactInfo).getNickName() : "";
        }
        textView.setText(mg3.a(this.j, userName, this.l));
        String avatar = iContactInfo.getAvatar();
        if (!avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        kf.w(this.j).v(avatar).a(this.k).A0(roundedImageView);
        if (iContactInfo instanceof IPeopleInfo) {
            B((IPeopleInfo) iContactInfo, imageView, frameLayout);
        } else {
            frameLayout.setVisibility(4);
        }
    }

    public void B(IPeopleInfo iPeopleInfo, ImageView imageView, View view) {
        if (iPeopleInfo.isGroup()) {
            view.setVisibility(4);
            return;
        }
        Presence.Mode statusMode = iPeopleInfo.getStatusMode();
        if (!iPeopleInfo.isOnline() || statusMode == null) {
            view.setVisibility(4);
            return;
        }
        if (statusMode == Presence.Mode.chat) {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.status_available);
        } else if (statusMode == Presence.Mode.dnd) {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.status_busy);
        } else if (statusMode == Presence.Mode.away) {
            view.setVisibility(4);
        }
    }

    public void z(String str) {
        if (str == null) {
            str = "";
        }
        this.l = str;
    }
}
