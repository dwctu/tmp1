package com.wear.adapter.mutlitoys;

import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.widget.control.multiToys.MultiTradPercentSeekBar;
import java.util.List;

/* loaded from: classes3.dex */
public class MultiTradBallsAdapter extends BaseAdapter<ControlBallBean> {
    public int j;
    public b k;

    public class a implements MultiTradPercentSeekBar.b {
        public final /* synthetic */ ControlBallBean a;

        public a(ControlBallBean controlBallBean) {
            this.a = controlBallBean;
        }

        @Override // com.wear.widget.control.multiToys.MultiTradPercentSeekBar.b
        public void a(int i) {
            if (MultiTradBallsAdapter.this.k != null) {
                MultiTradBallsAdapter.this.k.b(this.a);
            }
        }

        @Override // com.wear.widget.control.multiToys.MultiTradPercentSeekBar.b
        public void b(int i) {
            if (MultiTradBallsAdapter.this.k != null) {
                MultiTradBallsAdapter.this.k.a(this.a, i);
            }
        }
    }

    public interface b {
        void a(ControlBallBean controlBallBean, int i);

        void b(ControlBallBean controlBallBean);
    }

    public MultiTradBallsAdapter(List<ControlBallBean> list, int i) {
        super(list, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A(List<ControlBallBean> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    public void B(b bVar) {
        this.k = bVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, ControlBallBean controlBallBean, int i) {
        MultiTradPercentSeekBar multiTradPercentSeekBar = (MultiTradPercentSeekBar) viewHolder.getView(R.id.item_multi_trad_seekbar);
        multiTradPercentSeekBar.c(controlBallBean);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) multiTradPercentSeekBar.getLayoutParams();
        if (this.b.size() == 2 && i == 1) {
            layoutParams.leftMargin = this.j;
        } else {
            layoutParams.leftMargin = 0;
        }
        multiTradPercentSeekBar.setLayoutParams(layoutParams);
        multiTradPercentSeekBar.setListener(new a(controlBallBean));
    }

    public MultiTradBallsAdapter(List<ControlBallBean> list, int i, int i2) {
        this(list, i);
        this.j = i2;
    }
}
