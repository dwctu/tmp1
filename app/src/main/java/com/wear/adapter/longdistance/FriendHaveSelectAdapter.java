package com.wear.adapter.longdistance;

import android.view.View;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FriendHaveSelectAdapter extends BaseAdapter<IPeopleInfo> {
    public b j;

    public class a implements View.OnClickListener {
        public final /* synthetic */ IPeopleInfo a;

        public a(IPeopleInfo iPeopleInfo) {
            this.a = iPeopleInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FriendHaveSelectAdapter friendHaveSelectAdapter = FriendHaveSelectAdapter.this;
            if (friendHaveSelectAdapter.j != null) {
                FriendHaveSelectAdapter.this.r(friendHaveSelectAdapter.b.indexOf(this.a));
                FriendHaveSelectAdapter.this.j.I(this.a);
            }
        }
    }

    public interface b {
        void I(IPeopleInfo iPeopleInfo);
    }

    public FriendHaveSelectAdapter(ArrayList<IPeopleInfo> arrayList, int i) {
        super(arrayList, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, IPeopleInfo iPeopleInfo, int i) {
        WearUtils.t2((ImageView) viewHolder.getView(R.id.iv_user_img), iPeopleInfo);
        viewHolder.a(R.id.tv_user_name, iPeopleInfo.getShowNickName());
        viewHolder.itemView.setOnClickListener(new a(iPeopleInfo));
    }

    public void z(b bVar) {
        this.j = bVar;
    }
}
