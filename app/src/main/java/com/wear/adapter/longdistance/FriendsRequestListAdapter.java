package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.mg3;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FriendsRequestListAdapter extends BaseAdapter<IPeopleInfo> {
    public c j;
    public String k;

    public class a implements View.OnClickListener {
        public final /* synthetic */ IPeopleInfo a;

        public a(IPeopleInfo iPeopleInfo) {
            this.a = iPeopleInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = FriendsRequestListAdapter.this.j;
            if (cVar != null) {
                cVar.n(this.a);
            }
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ IPeopleInfo a;

        public b(IPeopleInfo iPeopleInfo) {
            this.a = iPeopleInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = FriendsRequestListAdapter.this.j;
            if (cVar != null) {
                cVar.k(this.a);
            }
        }
    }

    public interface c {
        void k(IPeopleInfo iPeopleInfo);

        void n(IPeopleInfo iPeopleInfo);
    }

    public FriendsRequestListAdapter(ArrayList<IPeopleInfo> arrayList, int i) {
        super(arrayList, i);
        this.k = "";
    }

    public void A(c cVar) {
        this.j = cVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void v(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        super.v(viewHolder, iPeopleInfo, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        WearUtils.t2((ImageView) viewHolder.getView(R.id.riv_user_img), iPeopleInfo);
        ((TextView) viewHolder.getView(R.id.tv_name)).setText(mg3.a(this.c, iPeopleInfo.getShowNickName(), this.k));
        viewHolder.getView(R.id.btn_user_accept).setOnClickListener(new a(iPeopleInfo));
        viewHolder.getView(R.id.btn_user_reject).setOnClickListener(new b(iPeopleInfo));
    }

    @Override // com.wear.adapter.BaseAdapter
    public int n(int i) {
        return ((IPeopleInfo) this.b.get(i)).getTempViewType();
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
        this.d.put(1, Integer.valueOf(R.layout.view_friends_request_list_new_title));
        this.d.put(2, Integer.valueOf(R.layout.view_friends_request_list_old_title));
    }

    public void z(String str) {
        if (str == null) {
            str = "";
        }
        this.k = str;
        if (this.c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            t(ah4.e(R.string.friend_request_page_empty));
        } else {
            t(ah4.e(R.string.common_search_no_result));
        }
    }
}
