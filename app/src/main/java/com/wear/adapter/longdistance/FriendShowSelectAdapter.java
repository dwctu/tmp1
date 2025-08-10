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
import com.wear.bean.GroupMember;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ch3;
import dc.mg3;
import dc.sg3;
import dc.th4;
import java.util.ArrayList;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class FriendShowSelectAdapter extends BaseAdapter<IPeopleInfo> {
    public b j;
    public String k;
    public MyApplication l;
    public Group m;
    public int n;

    public class a implements View.OnClickListener {
        public final /* synthetic */ IPeopleInfo a;
        public final /* synthetic */ ImageView b;

        public a(IPeopleInfo iPeopleInfo, ImageView imageView) {
            this.a = iPeopleInfo;
            this.b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FriendShowSelectAdapter.this.j != null) {
                if ("0".equals(this.a.isSupportGroup())) {
                    sg3.k(FriendShowSelectAdapter.this.l, String.format(ah4.e(R.string.group_chat_not_support2), this.a.getShowNickName()));
                } else if (FriendShowSelectAdapter.this.j.i(this.a, false)) {
                    this.b.setImageResource(R.drawable.chat_pattern_item_select);
                } else {
                    this.b.setImageResource(R.drawable.chat_pattern_item_unselect);
                }
            }
        }
    }

    public interface b {
        boolean i(IPeopleInfo iPeopleInfo, boolean z);
    }

    public FriendShowSelectAdapter(ArrayList<IPeopleInfo> arrayList, int i) {
        super(arrayList, i);
        this.k = "";
        this.l = WearUtils.x;
    }

    public void A(String str) {
        this.k = str;
    }

    public void B(b bVar) {
        this.j = bVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_user_img);
        WearUtils.t2(imageView, iPeopleInfo);
        ImageView imageView2 = (ImageView) viewHolder.getView(R.id.iv_select_status);
        b bVar = this.j;
        if (bVar != null) {
            if (bVar.i(iPeopleInfo, true)) {
                imageView2.setImageResource(R.drawable.chat_pattern_item_select);
            } else {
                imageView2.setImageResource(R.drawable.chat_pattern_item_unselect);
            }
        }
        imageView2.setAlpha(1.0f);
        viewHolder.itemView.setEnabled(true);
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.getView(R.id.toy_type_name_1).setVisibility(8);
        viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
        viewHolder.getView(R.id.fl_online_status).setVisibility(iPeopleInfo.isOnline() ? 0 : 8);
        Group group = this.m;
        if (group != null) {
            GroupMember memberByJid = group.getMemberByJid(iPeopleInfo.getUserJid());
            int i2 = this.n;
            if (i2 == 1) {
                if (memberByJid != null) {
                    imageView2.setImageResource(R.drawable.chat_pattern_item_select);
                    viewHolder.itemView.setEnabled(false);
                    imageView2.setAlpha(0.4f);
                }
            } else if (i2 == 2) {
                if (memberByJid != null && memberByJid.isAdmin()) {
                    imageView2.setImageResource(R.drawable.chat_pattern_item_select);
                    viewHolder.itemView.setEnabled(false);
                    imageView2.setAlpha(0.4f);
                }
            } else if (i2 == 3) {
                FrameLayout frameLayout = (FrameLayout) viewHolder.getView(R.id.fl_online_status);
                ImageView imageView3 = (ImageView) viewHolder.getView(R.id.online_status);
                frameLayout.setVisibility(8);
                if (!iPeopleInfo.isOnline()) {
                    viewHolder.itemView.setEnabled(false);
                    viewHolder.itemView.setAlpha(0.4f);
                    frameLayout.setVisibility(8);
                } else if (memberByJid != null) {
                    int openfireStatus = memberByJid.getOpenfireStatus();
                    if (openfireStatus == 2) {
                        viewHolder.itemView.setEnabled(true);
                        viewHolder.itemView.setAlpha(1.0f);
                        frameLayout.setVisibility(0);
                        imageView3.setImageResource(R.drawable.status_busy);
                    } else if (openfireStatus != 3) {
                        viewHolder.itemView.setEnabled(true);
                        viewHolder.itemView.setAlpha(1.0f);
                        frameLayout.setVisibility(0);
                        imageView3.setImageResource(R.drawable.status_available);
                    } else {
                        viewHolder.itemView.setEnabled(false);
                        viewHolder.itemView.setAlpha(0.4f);
                        frameLayout.setVisibility(8);
                    }
                    if (memberByJid.getOpenfireStatus() != 3) {
                        ArrayList arrayList = new ArrayList(memberByJid.getToys());
                        if (WearUtils.g1(arrayList)) {
                            viewHolder.getView(R.id.toy_type_name_1).setVisibility(8);
                            viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
                            viewHolder.getView(R.id.toys_number_text).setVisibility(8);
                        } else if (arrayList.size() == 1) {
                            viewHolder.getView(R.id.toy_type_name_1).setVisibility(0);
                            viewHolder.a(R.id.toy_type_name_1, Toy.NAME_MAP.get(Toy.generateType(memberByJid.getToys().get(0).getType())));
                            viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
                            viewHolder.getView(R.id.toys_number_text).setVisibility(8);
                        } else if (arrayList.size() == 2) {
                            viewHolder.getView(R.id.toy_type_name_1).setVisibility(0);
                            viewHolder.getView(R.id.toy_type_name_2).setVisibility(0);
                            viewHolder.getView(R.id.toys_number_text).setVisibility(8);
                            Map<String, String> map = Toy.NAME_MAP;
                            viewHolder.a(R.id.toy_type_name_1, map.get(Toy.generateType(memberByJid.getToys().get(0).getType())));
                            viewHolder.a(R.id.toy_type_name_2, map.get(Toy.generateType(memberByJid.getToys().get(1).getType())));
                        } else {
                            viewHolder.getView(R.id.toy_type_name_1).setVisibility(8);
                            viewHolder.getView(R.id.toy_type_name_2).setVisibility(8);
                            viewHolder.getView(R.id.toys_number_text).setVisibility(0);
                            viewHolder.getView(R.id.toys_number_text).setBackgroundDrawable(th4.d(this.c, R.drawable.toys_number_background));
                            viewHolder.a(R.id.toys_number_text, String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(arrayList.size())));
                        }
                    }
                }
            }
        }
        viewHolder.itemView.setOnClickListener(new a(iPeopleInfo, imageView2));
        TextView textView = (TextView) viewHolder.getView(R.id.tv_show_name);
        TextView textView2 = (TextView) viewHolder.getView(R.id.tv_user_name);
        TextView textView3 = (TextView) viewHolder.getView(R.id.tv_user_name_tip);
        LinearLayout linearLayout = (LinearLayout) viewHolder.getView(R.id.ll_user_name);
        if (TextUtils.isEmpty(this.k)) {
            textView.setText(iPeopleInfo.getShowNickName());
            linearLayout.setVisibility(8);
            return;
        }
        int i3 = this.n;
        if (i3 == 0 || i3 == 1) {
            String remark = iPeopleInfo.getRemark();
            String userName = iPeopleInfo.getUserName();
            if (TextUtils.isEmpty(remark)) {
                textView.setText(mg3.a(this.l, userName, this.k));
                linearLayout.setVisibility(8);
                return;
            }
            textView.setText(mg3.a(this.l, remark, this.k));
            if (remark.toLowerCase().contains(this.k.toLowerCase())) {
                linearLayout.setVisibility(8);
                return;
            }
            textView2.setText(mg3.a(this.l, userName, this.k));
            linearLayout.setVisibility(0);
            textView3.setText(ah4.e(R.string.signup_name_hint) + SignatureImpl.INNER_SEP);
            return;
        }
        if ((i3 != 2 && i3 != 3) || !(iPeopleInfo instanceof GroupMember)) {
            textView.setText(iPeopleInfo.getShowNickName());
            linearLayout.setVisibility(8);
            return;
        }
        User userV = ch3.n().v(iPeopleInfo.getId());
        GroupMember groupMember = (GroupMember) iPeopleInfo;
        if (userV == null || !userV.isShowInFriendsList()) {
            textView.setText(mg3.a(this.l, groupMember.getRealNickName(), this.k));
            linearLayout.setVisibility(8);
            return;
        }
        String remark2 = userV.getRemark();
        String userName2 = userV.getUserName();
        String realNickName = groupMember.getRealNickName();
        if (TextUtils.isEmpty(remark2)) {
            textView.setText(mg3.a(this.l, realNickName, this.k));
            if (realNickName.toLowerCase().contains(this.k.toLowerCase())) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            textView3.setText(ah4.e(R.string.signup_name_hint) + SignatureImpl.INNER_SEP);
            textView2.setText(mg3.a(this.l, userName2, this.k));
            return;
        }
        textView.setText(mg3.a(this.l, remark2, this.k));
        if (remark2.toLowerCase().contains(this.k.toLowerCase())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        textView2.setText(mg3.a(this.l, userName2, this.k));
        textView3.setText(ah4.e(R.string.signup_name_hint) + SignatureImpl.INNER_SEP);
    }

    public void z(Group group, int i) {
        this.m = group;
        this.n = i;
    }
}
