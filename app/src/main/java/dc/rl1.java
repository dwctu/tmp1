package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.bean.Group;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: ForwardChooseAdapter.java */
/* loaded from: classes3.dex */
public class rl1 extends BaseAdapter {
    public LayoutInflater a;
    public Context b;
    public List<IPeopleInfo> d;
    public Map<String, IPeopleInfo> f;
    public qo g;
    public String e = "";
    public MyApplication c = WearUtils.x;

    /* compiled from: ForwardChooseAdapter.java */
    public class a {
        public RoundedImageView a;
        public FrameLayout b;
        public TextView c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public ImageView g;

        public a(rl1 rl1Var) {
        }
    }

    public rl1(Context context, Map<String, IPeopleInfo> map, List<IPeopleInfo> list) {
        this.a = null;
        this.a = LayoutInflater.from(context);
        this.b = context;
        this.d = list;
        if (list == null) {
            this.d = new ArrayList();
        }
        this.f = map;
        qo qoVarH = new qo().h(R.drawable.chat_avatar_default);
        ii iiVar = ii.a;
        this.g = qoVarH.f(iiVar).X(R.drawable.chat_avatar_default);
        new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default).f(iiVar);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IPeopleInfo getItem(int i) {
        return this.d.get(i);
    }

    public void b(String str) {
        this.e = str;
    }

    public final void c(IPeopleInfo iPeopleInfo, RoundedImageView roundedImageView, String str) {
        if (iPeopleInfo.isGroup()) {
            Group group = (Group) iPeopleInfo;
            if (group.getMembers().size() == 1) {
                roundedImageView.setBorderWidth(ce3.a(this.b, 4.0f) * 1.0f);
            } else {
                roundedImageView.setBorderWidth(0.0f);
            }
            tg3.i(roundedImageView, group);
            return;
        }
        roundedImageView.setBorderWidth(0.0f);
        if (!str.startsWith("http")) {
            str = WearUtils.e + str;
        }
        kf.w(this.b).v(str).a(this.g).A0(roundedImageView);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        IPeopleInfo item = getItem(i);
        if (view == null) {
            aVar = new a(this);
            viewInflate = this.a.inflate(R.layout.long_choose_chat_item, (ViewGroup) null);
            aVar.a = (RoundedImageView) viewInflate.findViewById(R.id.user_img);
            aVar.b = (FrameLayout) viewInflate.findViewById(R.id.fl_online_status);
            aVar.c = (TextView) viewInflate.findViewById(R.id.chat_name);
            aVar.d = (LinearLayout) viewInflate.findViewById(R.id.ll_user_name);
            aVar.e = (TextView) viewInflate.findViewById(R.id.tv_user_name_tip);
            aVar.f = (TextView) viewInflate.findViewById(R.id.tv_user_name);
            viewInflate.findViewById(R.id.select_status_layout);
            aVar.g = (ImageView) viewInflate.findViewById(R.id.select_status);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        c(item, aVar.a, item.getAvatar());
        aVar.b.setVisibility((!item.isOnline() || item.isGroup()) ? 8 : 0);
        String remark = item.getRemark();
        String userName = item.getUserName();
        if (!TextUtils.isEmpty(remark)) {
            aVar.c.setText(mg3.a(this.c, remark, this.e));
            if (remark.toLowerCase().contains(this.e.toLowerCase())) {
                aVar.d.setVisibility(8);
            } else if (item.isGroup()) {
                Group group = (Group) item;
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().contains(this.e.toLowerCase())) {
                    aVar.f.setText(mg3.a(this.c, userName, this.e));
                    aVar.d.setVisibility(0);
                    aVar.e.setText(ah4.e(R.string.group_chat_group_name) + SignatureImpl.INNER_SEP);
                } else if (group.isExit()) {
                    String rns = group.getRns();
                    if (WearUtils.e1(rns)) {
                        rns = group.getShowNickName();
                    }
                    aVar.f.setText(mg3.a(this.c, rns, this.e));
                    aVar.d.setVisibility(0);
                    aVar.e.setText(ah4.e(R.string.group_member) + SignatureImpl.INNER_SEP);
                } else {
                    aVar.f.setText(mg3.b(this.c, group.getList(), this.e));
                    aVar.d.setVisibility(0);
                    aVar.e.setText(ah4.e(R.string.group_member) + SignatureImpl.INNER_SEP);
                }
            } else {
                aVar.f.setText(mg3.a(this.c, userName, this.e));
                aVar.d.setVisibility(0);
                aVar.e.setText(ah4.e(R.string.signup_name_hint) + SignatureImpl.INNER_SEP);
            }
        } else if (item.isGroup()) {
            Group group2 = (Group) item;
            if (TextUtils.isEmpty(userName)) {
                String rns2 = group2.getRns();
                if (WearUtils.e1(rns2)) {
                    rns2 = group2.getShowNickName();
                }
                aVar.c.setText(mg3.a(this.c, rns2, this.e));
                if (group2.isExit() || rns2.toLowerCase().contains(this.e.toLowerCase())) {
                    aVar.d.setVisibility(8);
                } else {
                    aVar.f.setText(mg3.b(this.c, group2.getList(), this.e));
                    aVar.d.setVisibility(0);
                    aVar.e.setText(ah4.e(R.string.group_member) + SignatureImpl.INNER_SEP);
                }
            } else {
                aVar.c.setText(mg3.a(this.c, userName, this.e));
                if (userName.toLowerCase().contains(this.e.toLowerCase())) {
                    aVar.d.setVisibility(8);
                } else if (group2.isExit()) {
                    aVar.f.setText(mg3.a(this.c, group2.getRns(), this.e));
                    aVar.d.setVisibility(0);
                    aVar.e.setText(ah4.e(R.string.group_member) + SignatureImpl.INNER_SEP);
                } else {
                    aVar.f.setText(mg3.b(this.c, group2.getList(), this.e));
                    aVar.e.setText(ah4.e(R.string.group_member) + SignatureImpl.INNER_SEP);
                    aVar.d.setVisibility(0);
                }
            }
        } else {
            if (WearUtils.e1(userName)) {
                userName = item.getShowNickName();
            }
            aVar.c.setText(mg3.a(this.c, userName, this.e));
            aVar.d.setVisibility(8);
        }
        if (this.f.containsKey(item.getUserJid())) {
            aVar.g.setImageResource(R.drawable.user_select_new);
        } else {
            aVar.g.setImageResource(R.drawable.user_unselect_new);
        }
        return viewInflate;
    }
}
