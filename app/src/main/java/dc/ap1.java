package dc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToyRename;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.ToySearchActivity;
import com.wear.util.WearUtils;
import com.wear.widget.SwitchView;

/* compiled from: ToySearchAdapter.java */
/* loaded from: classes3.dex */
public class ap1 extends BaseAdapter {
    public LayoutInflater a;
    public ToySearchActivity b;

    /* compiled from: ToySearchAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ Toy b;

        public a(b bVar, Toy toy) {
            this.a = bVar;
            this.b = toy;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.c.setSelected(this.b.isSelect());
            this.a.c.setEnabled(this.b.isSelect());
            if (this.b.isSelect()) {
                ap1.this.b.h.x0(this.b.getAddress(), false);
            } else {
                ap1.this.b.h.x0(this.b.getAddress(), true);
            }
            ap1.this.notifyDataSetChanged();
        }
    }

    /* compiled from: ToySearchAdapter.java */
    public final class b {
        public TextView a;
        public ImageView b;
        public SwitchView c;

        public b(ap1 ap1Var) {
        }
    }

    public ap1(ToySearchActivity toySearchActivity) {
        this.a = null;
        this.b = toySearchActivity;
        this.a = LayoutInflater.from(toySearchActivity);
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Toy getItem(int i) {
        return this.b.h.q().get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        pc1 pc1Var;
        ToySearchActivity toySearchActivity = this.b;
        if (toySearchActivity == null || (pc1Var = toySearchActivity.h) == null) {
            return 0;
        }
        return pc1Var.q().size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        if (view == null) {
            bVar = new b(this);
            viewInflate = this.a.inflate(R.layout.account_toy_search_item, (ViewGroup) null);
            bVar.a = (TextView) viewInflate.findViewById(R.id.toy_search_name);
            bVar.b = (ImageView) viewInflate.findViewById(R.id.toy_search_image);
            bVar.c = (SwitchView) viewInflate.findViewById(R.id.toy_search_item_check_image);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        Toy item = getItem(i);
        if (item != null) {
            bVar.c.setSelected(item.isSelect());
            bVar.c.setEnabled(item.isSelect());
            bVar.b.setImageResource(item.getSearchToyIcon());
            bVar.c.setOnClickListener(new a(bVar, item));
            ToyRename toyRenameFindToyName = DaoUtils.getToyRenameDao().findToyName(WearUtils.y.r(), item.getAddress());
            if (toyRenameFindToyName != null && !WearUtils.e1(toyRenameFindToyName.getName())) {
                bVar.a.setText(item.getFullName() + " · " + toyRenameFindToyName.getName());
            } else if (WearUtils.e1(item.getDeviceName()) || item.getDeviceName().toLowerCase().startsWith("lvs")) {
                bVar.a.setText(item.getFullName());
            } else {
                bVar.a.setText(item.getFullName() + " · " + item.getDeviceName());
            }
        }
        return viewInflate;
    }
}
