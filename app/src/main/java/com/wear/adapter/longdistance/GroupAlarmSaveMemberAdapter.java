package com.wear.adapter.longdistance;

import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.util.WearUtils;
import dc.lg3;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.jivesoftware.smackx.disco.bean.response.ResponsePatternOrAlarmMessage;

/* loaded from: classes3.dex */
public class GroupAlarmSaveMemberAdapter extends BaseAdapter<ResponsePatternOrAlarmMessage.DataBean> {
    public GroupAlarmSaveMemberAdapter(ArrayList<ResponsePatternOrAlarmMessage.DataBean> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, ResponsePatternOrAlarmMessage.DataBean dataBean, int i) {
        RoundedImageView roundedImageView = (RoundedImageView) viewHolder.getView(R.id.iv_user_img);
        viewHolder.a(R.id.tv_user_name, dataBean.getNickname());
        Locale localeE = lg3.e(WearUtils.x);
        viewHolder.a(R.id.tv_create_time, DateFormat.getDateTimeInstance(2, 3, localeE).format(new Date(dataBean.getCreateTime())));
        WearUtils.u2(roundedImageView, dataBean.getPhoto());
    }
}
