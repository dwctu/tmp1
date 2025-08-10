package com.wear.adapter.discover;

import androidx.appcompat.widget.AppCompatTextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.FFBasicMsgBean;
import dc.th4;
import java.util.List;

/* loaded from: classes3.dex */
public class FFBasicSelectMsgAdapter extends BaseAdapter<FFBasicMsgBean> {
    public FFBasicSelectMsgAdapter(List<FFBasicMsgBean> list, int i) {
        super(list, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, FFBasicMsgBean fFBasicMsgBean, int i) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewHolder.getView(R.id.tv_tag);
        appCompatTextView.setText(fFBasicMsgBean.getKey());
        if (fFBasicMsgBean.isSelect()) {
            appCompatTextView.setBackground(th4.d(this.c, R.drawable.shape_pattern_filter_select));
            appCompatTextView.setTextColor(th4.b(this.c, R.color.white));
        } else {
            appCompatTextView.setBackground(th4.d(this.c, R.drawable.shape_pattern_filter));
            appCompatTextView.setTextColor(th4.b(this.c, R.color.text_color_b45_wo));
        }
    }
}
