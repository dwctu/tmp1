package com.wear.adapter.longdistance;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.kf;
import dc.n93;
import dc.qo;
import dc.rf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchChatMediaPreviewAdapter extends BaseAdapter<CommunMessage> {
    public qo j;
    public List<CommunMessage> k;

    public SearchChatMediaPreviewAdapter(List<CommunMessage> list, int i) {
        super(list, i);
        this.k = new ArrayList();
        this.j = new qo().h(R.drawable.content_icon_picture_loading).X(R.drawable.content_icon_picture_loading);
    }

    public void A(List<CommunMessage> list) {
        this.k.clear();
        this.k.addAll(list);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, CommunMessage communMessage, int i) {
        String picUrl;
        String picLocalUrl;
        View view = viewHolder.getView(R.id.iv_preview_video);
        MessageType type = communMessage.getType();
        MessageType messageType = MessageType.shortvideo;
        boolean z = false;
        view.setVisibility(type == messageType ? 0 : 8);
        viewHolder.getView(R.id.v_isSelected).setVisibility(n93.b().a() == i ? 0 : 8);
        C(viewHolder, communMessage);
        try {
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(communMessage.getFrom()));
            if (communMessage.getType() == MessageType.picture) {
                EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
                picUrl = entityPicture.getUrl();
                picLocalUrl = entityPicture.getLocalUrl();
                String type2 = entityPicture.getType();
                if (!WearUtils.e1(type2) && type2.equals("emoji")) {
                    z = true;
                }
            } else if (communMessage.getType() == messageType) {
                EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
                picUrl = entityShortVideo.getPicUrl();
                picLocalUrl = entityShortVideo.getPicLocalUrl();
            } else {
                picUrl = "";
                picLocalUrl = picUrl;
            }
            if (iPeopleInfoS != null) {
                rf rfVarW = kf.w(this.c);
                StringBuilder sb = new StringBuilder();
                sb.append(WearUtils.e);
                if (z) {
                    picUrl = picUrl.replace("thum_", "");
                }
                sb.append(picUrl);
                rfVarW.v(sb.toString()).a(this.j).A0((ImageView) viewHolder.getView(R.id.iv_preview_btm));
                return;
            }
            if (!WearUtils.e1(picLocalUrl) && (WearUtils.c0(picLocalUrl).exists() || WearUtils.Z(picLocalUrl).exists() || WearUtils.a0(picLocalUrl).exists())) {
                kf.w(this.c).s(z ? WearUtils.Z(picLocalUrl).exists() ? WearUtils.Z(picLocalUrl) : WearUtils.a0(picLocalUrl) : WearUtils.c0(picLocalUrl)).a(this.j).A0((ImageView) viewHolder.getView(R.id.iv_preview_btm));
                return;
            }
            if (WearUtils.e1(picUrl)) {
                ((ImageView) viewHolder.getView(R.id.iv_preview_btm)).setImageResource(R.drawable.content_icon_picture_loading);
                return;
            }
            rf rfVarW2 = kf.w(this.c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(WearUtils.e);
            if (z) {
                picUrl = picUrl.replace("thum_", "");
            }
            sb2.append(picUrl);
            rfVarW2.v(sb2.toString()).a(this.j).A0((ImageView) viewHolder.getView(R.id.iv_preview_btm));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void C(BaseAdapter.ViewHolder viewHolder, CommunMessage communMessage) {
        if (this.k.contains(communMessage)) {
            ((ImageView) viewHolder.getView(R.id.iv_preview_btm)).setColorFilter((ColorFilter) null);
        } else {
            ((ImageView) viewHolder.getView(R.id.iv_preview_btm)).setColorFilter(Color.parseColor("#80ffffff"));
        }
    }

    public void D(CommunMessage communMessage) {
        if (this.k.contains(communMessage)) {
            this.k.remove(communMessage);
        } else {
            this.k.add(communMessage);
        }
        notifyItemChanged(this.b.indexOf(communMessage), "select");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
            return;
        }
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals("select", it.next().toString())) {
                C(viewHolder, (CommunMessage) this.b.get(i));
            }
        }
    }
}
