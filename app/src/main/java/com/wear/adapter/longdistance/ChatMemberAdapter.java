package com.wear.adapter.longdistance;

import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.th4;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class ChatMemberAdapter extends BaseAdapter<GroupMember> {
    public ChatMemberAdapter(ArrayList<GroupMember> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, GroupMember groupMember, int i) {
        WearUtils.t2((ImageView) viewHolder.getView(R.id.iv_user_img), groupMember);
        viewHolder.getView(R.id.toy_type_name_1).setVisibility(8);
        viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
        if (groupMember.getOpenfireStatus() != 3) {
            viewHolder.getView(R.id.ll_toy_info).setVisibility(0);
            ArrayList arrayList = new ArrayList(groupMember.getToys());
            if (WearUtils.g1(arrayList)) {
                viewHolder.getView(R.id.toy_type_name_1).setVisibility(8);
                viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
                viewHolder.getView(R.id.toys_number_text).setVisibility(8);
            } else if (arrayList.size() == 1) {
                viewHolder.getView(R.id.toy_type_name_1).setVisibility(0);
                viewHolder.a(R.id.toy_type_name_1, Toy.NAME_MAP.get(Toy.generateType(((Toy) arrayList.get(0)).getType())));
                viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
                viewHolder.getView(R.id.toys_number_text).setVisibility(8);
            } else if (arrayList.size() == 2) {
                viewHolder.getView(R.id.toy_type_name_1).setVisibility(0);
                viewHolder.getView(R.id.toy_type_name_2).setVisibility(0);
                viewHolder.getView(R.id.toys_number_text).setVisibility(8);
                Map<String, String> map = Toy.NAME_MAP;
                viewHolder.a(R.id.toy_type_name_1, map.get(Toy.generateType(((Toy) arrayList.get(0)).getType())));
                viewHolder.a(R.id.toy_type_name_2, map.get(Toy.generateType(((Toy) arrayList.get(1)).getType())));
            } else {
                viewHolder.getView(R.id.toy_type_name_1).setVisibility(8);
                viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
                viewHolder.getView(R.id.toys_number_text).setVisibility(0);
                viewHolder.getView(R.id.toys_number_text).setBackgroundDrawable(th4.d(this.c, R.drawable.toys_number_background));
                viewHolder.a(R.id.toys_number_text, String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(arrayList.size())));
            }
        } else {
            viewHolder.getView(R.id.ll_toy_info).setVisibility(8);
        }
        ((TextView) viewHolder.getView(R.id.tv_show_name)).setText(groupMember.getShowNickName());
    }
}
