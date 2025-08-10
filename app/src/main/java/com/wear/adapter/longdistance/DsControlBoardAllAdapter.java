package com.wear.adapter.longdistance;

import android.view.View;
import android.widget.TextView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import java.util.List;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes3.dex */
public class DsControlBoardAllAdapter extends BaseAdapter<IPeopleInfo> {
    public SkinCompatTextView j;

    public DsControlBoardAllAdapter(List<IPeopleInfo> list, int i) {
        super(list, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    public int n(int i) {
        return ((IPeopleInfo) this.b.get(i)).getTempViewType();
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        RoundedImageView roundedImageView = (RoundedImageView) viewHolder.getView(R.id.user_img);
        View view = viewHolder.getView(R.id.user_img_top);
        WearUtils.t2(roundedImageView, iPeopleInfo);
        TextView textView = (TextView) viewHolder.getView(R.id.tv_status);
        GroupMember groupMember = (GroupMember) iPeopleInfo;
        if (groupMember.getDSStatus() == 2) {
            viewHolder.getView(R.id.tv_time).setVisibility(0);
            view.setVisibility(0);
            this.j = (SkinCompatTextView) viewHolder.getView(R.id.tv_time);
            textView.setVisibility(8);
            viewHolder.getView(R.id.iv_status).setVisibility(8);
            return;
        }
        if (groupMember.getDSStatus() == 4) {
            view.setVisibility(8);
            viewHolder.getView(R.id.tv_time).setVisibility(8);
            textView.setVisibility(8);
            viewHolder.getView(R.id.iv_status).setVisibility(8);
            return;
        }
        if (groupMember.getDSStatus() == 0 || groupMember.getDSStatus() == 3) {
            view.setVisibility(8);
            viewHolder.getView(R.id.tv_time).setVisibility(8);
            textView.setVisibility(0);
            textView.setText(this.c.getText(R.string.common_busy));
            viewHolder.getView(R.id.iv_status).setVisibility(8);
            return;
        }
        if (groupMember.getDSStatus() == 1) {
            view.setVisibility(8);
            viewHolder.getView(R.id.tv_time).setVisibility(8);
            textView.setVisibility(0);
            textView.setText("");
            viewHolder.getView(R.id.iv_status).setVisibility(0);
        }
    }
}
