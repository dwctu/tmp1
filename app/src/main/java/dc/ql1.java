package dc;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import java.util.List;

/* compiled from: EmojisGridViewAdapter.java */
/* loaded from: classes3.dex */
public class ql1 extends BaseAdapter {
    public Activity a;
    public List<String> b = null;
    public ie3 c;

    /* compiled from: EmojisGridViewAdapter.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(R.id.imageview_smiley_image) != null) {
                ql1.this.c.x(view.getTag(R.id.imageview_smiley_image).toString());
            }
        }
    }

    /* compiled from: EmojisGridViewAdapter.java */
    public class b implements View.OnLongClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ql1.this.c.o(this.a, ql1.this.b, null);
            return false;
        }
    }

    /* compiled from: EmojisGridViewAdapter.java */
    public class c {
        public ImageView a;
        public RelativeLayout b;
        public ImageView c;

        public c(ql1 ql1Var) {
        }

        public /* synthetic */ c(ql1 ql1Var, a aVar) {
            this(ql1Var);
        }
    }

    public ql1(Activity activity, ie3 ie3Var) {
        this.a = activity;
        this.c = ie3Var;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.b.get(i);
    }

    public void d(List<String> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        a aVar = null;
        if (view == null) {
            c cVar2 = new c(this, aVar);
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.item_gridpage_emojis, (ViewGroup) null);
            cVar2.b = (RelativeLayout) viewInflate.findViewById(R.id.relativelayout_smiley_image);
            cVar2.a = (ImageView) viewInflate.findViewById(R.id.imageview_smiley_image);
            cVar2.c = (ImageView) viewInflate.findViewById(R.id.button_expression_backspace);
            viewInflate.setTag(cVar2);
            cVar = cVar2;
            view = viewInflate;
        } else {
            cVar = (c) view.getTag();
        }
        view.setTag(R.id.imageview_smiley_image, null);
        cVar.a.setTag(R.id.imageview_smiley_image, null);
        if (WearUtils.e1(getItem(i))) {
            cVar.b.setBackgroundResource(R.color.transparent);
            cVar.a.setVisibility(4);
            cVar.c.setVisibility(8);
        } else if (getItem(i).equals(this.c.a)) {
            cVar.a.setVisibility(8);
            cVar.c.setVisibility(0);
            view.setTag(R.id.imageview_smiley_image, this.c.a);
            cVar.a.setTag(R.id.imageview_smiley_image, this.c.a);
        } else {
            Bitmap bitmapE = this.c.E(getItem(i));
            if (bitmapE != null) {
                cVar.a.setVisibility(0);
                cVar.a.setImageBitmap(bitmapE);
                view.setTag(R.id.imageview_smiley_image, this.c.u(getItem(i)));
                cVar.a.setTag(R.id.imageview_smiley_image, this.c.u(getItem(i)));
            } else {
                cVar.a.setVisibility(8);
            }
            cVar.c.setVisibility(8);
        }
        cVar.a.setOnClickListener(new a());
        cVar.a.setOnLongClickListener(new b(i));
        return view;
    }
}
