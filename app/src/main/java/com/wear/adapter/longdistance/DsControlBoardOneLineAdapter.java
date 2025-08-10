package com.wear.adapter.longdistance;

import android.view.View;
import android.widget.TextView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.handlerbean.item.FootUser;
import com.wear.util.WearUtils;
import java.util.List;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes3.dex */
public class DsControlBoardOneLineAdapter extends BaseAdapter<IPeopleInfo> {
    public SkinCompatTextView j;
    public b k;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = DsControlBoardOneLineAdapter.this.k;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public interface b {
        void c();
    }

    public DsControlBoardOneLineAdapter(List<IPeopleInfo> list, int i) {
        super(list, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void v(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        if (iPeopleInfo instanceof FootUser) {
            viewHolder.a(R.id.tv_time, String.valueOf(((FootUser) iPeopleInfo).getCount()) + "+");
            viewHolder.itemView.setOnClickListener(new a());
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        RoundedImageView roundedImageView = (RoundedImageView) viewHolder.getView(R.id.user_img);
        View view = viewHolder.getView(R.id.user_img_top);
        WearUtils.t2(roundedImageView, iPeopleInfo);
        TextView textView = (TextView) viewHolder.getView(R.id.tv_status);
        if (i == 0) {
            viewHolder.getView(R.id.tv_time).setVisibility(0);
            view.setVisibility(0);
            this.j = (SkinCompatTextView) viewHolder.getView(R.id.tv_time);
            ((TextView) viewHolder.getView(R.id.tv_controlling_name)).setText(iPeopleInfo.getShowNickName());
            viewHolder.getView(R.id.tv_controlling_name).setVisibility(0);
            textView.setVisibility(8);
            viewHolder.getView(R.id.iv_status).setVisibility(8);
            return;
        }
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

    @Override // com.wear.adapter.BaseAdapter
    public int n(int i) {
        return ((IPeopleInfo) this.b.get(i)).getTempViewType();
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
        this.d.put(1, Integer.valueOf(R.layout.item_ds_control_board_one_line_last));
    }

    public void z(b bVar) {
        this.k = bVar;
    }
}
