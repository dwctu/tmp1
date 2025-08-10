package dc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.zt3;
import java.util.ArrayList;

/* compiled from: AlarmNoticesAdapter.java */
/* loaded from: classes3.dex */
public class tj1 extends BaseAdapter {
    public LayoutInflater a;
    public ArrayList<zt3.g> b;

    /* compiled from: AlarmNoticesAdapter.java */
    public class a {
        public TextView a;
        public TextView b;

        public a(tj1 tj1Var) {
        }
    }

    public tj1(ArrayList<zt3.g> arrayList) {
        this.a = null;
        this.b = arrayList;
        this.a = LayoutInflater.from(WearUtils.x);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zt3.g getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        zt3.g item = getItem(i);
        if (view == null) {
            aVar = new a(this);
            viewInflate = this.a.inflate(R.layout.dialog_alarm_notices_item_layout, (ViewGroup) null);
            aVar.a = (TextView) viewInflate.findViewById(R.id.tv_alarm_state);
            aVar.b = (TextView) viewInflate.findViewById(R.id.tv_alarm_message);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        aVar.a.setText("");
        if (item.c() == zt3.e) {
            aVar.a.setText(ah4.e(R.string.alarm_notice_state_received));
        } else if (item.c() == zt3.f) {
            aVar.a.setText(ah4.e(R.string.alarm_notice_state_play));
        } else if (item.c() == zt3.h) {
            aVar.a.setText(ah4.e(R.string.alarm_notice_state_Missed));
        }
        aVar.b.setText(item.b());
        return viewInflate;
    }
}
