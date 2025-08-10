package com.wear.adapter.longdistance;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityChat;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.kf;
import dc.mg3;
import dc.qo;
import dc.zb2;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchChatHistoryAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    public Context a;
    public List<CommunMessage> b;
    public Account c = ch3.n().u();
    public User d;
    public Group e;
    public boolean f;
    public qo g;
    public String h;
    public a i;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_user_img)
        public RoundedImageView iv_user_img;

        @BindView(R.id.tv_content)
        public TextView tv_content;

        @BindView(R.id.tv_time)
        public TextView tv_time;

        @BindView(R.id.tv_user_name)
        public TextView tv_user_name;

        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.iv_user_img = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'iv_user_img'", RoundedImageView.class);
            viewHolder.tv_user_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
            viewHolder.tv_content = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tv_content'", TextView.class);
            viewHolder.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.iv_user_img = null;
            viewHolder.tv_user_name = null;
            viewHolder.tv_content = null;
            viewHolder.tv_time = null;
        }
    }

    public interface a {
        void c(CommunMessage communMessage);
    }

    public SearchChatHistoryAdapter(Context context, List<CommunMessage> list, String str, boolean z, a aVar) {
        this.a = context;
        this.b = list;
        this.f = z;
        if (z) {
            this.e = ch3.n().k(str);
        } else {
            this.d = WearUtils.y.v(str);
        }
        this.i = aVar;
        this.g = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CommunMessage communMessage = this.b.get(i);
        EntityChat entityChat = (EntityChat) communMessage.getDataBean();
        if (this.f) {
            GroupMember groupMember = this.e.getMembers().get(communMessage.getRealFrom());
            if (groupMember != null) {
                o(viewHolder.iv_user_img, groupMember);
                viewHolder.tv_user_name.setText(groupMember.getNickName());
            }
        } else {
            o(viewHolder.iv_user_img, TextUtils.equals(this.c.getUserJid(), communMessage.getFrom()) ? this.c : this.d);
            viewHolder.tv_user_name.setText(TextUtils.equals(this.c.getUserJid(), communMessage.getFrom()) ? this.c.getUserName() : this.d.getShowNickName());
        }
        viewHolder.tv_time.setText(WearUtils.u0(communMessage.getCreated()));
        viewHolder.tv_content.setText(mg3.a(this.a, entityChat.getText(), this.h));
        viewHolder.itemView.setTag(R.id.tag1, communMessage);
        viewHolder.itemView.setOnClickListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_search_chat_history, viewGroup, false));
    }

    public void n(String str) {
        this.h = str;
    }

    public final void o(RoundedImageView roundedImageView, IPeopleInfo iPeopleInfo) {
        String strM = zb2.O().M(iPeopleInfo.getUserJid());
        if (!TextUtils.isEmpty(strM) && !strM.startsWith("http")) {
            strM = WearUtils.e + strM;
        }
        kf.w(this.a).v(strM).a(this.g).A0(roundedImageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CommunMessage communMessage = (CommunMessage) view.getTag(R.id.tag1);
        a aVar = this.i;
        if (aVar == null || communMessage == null) {
            return;
        }
        aVar.c(communMessage);
    }
}
