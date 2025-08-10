package dc;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import com.lovense.wear.R;
import com.wear.util.photoselector.PhotoItem;
import java.util.ArrayList;

/* compiled from: PhotoSelectorAdapter.java */
/* loaded from: classes4.dex */
public class sj3 extends qj3<rj3> {
    public int c;
    public int d;
    public AbsListView.LayoutParams e;
    public PhotoItem.b f;
    public View.OnClickListener g;

    public sj3(Context context, ArrayList<rj3> arrayList) {
        super(context, arrayList);
        this.d = 3;
    }

    public void b(int i) throws Resources.NotFoundException {
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.sticky_item_horizontalSpacing);
        int i2 = this.d;
        this.c = (i - (dimensionPixelSize * (i2 - 1))) / i2;
        int i3 = this.c;
        this.e = new AbsListView.LayoutParams(i3, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r2, android.view.View r3, android.view.ViewGroup r4) {
        /*
            r1 = this;
            if (r2 != 0) goto L3b
            java.util.ArrayList<T> r4 = r1.b
            java.lang.Object r4 = r4.get(r2)
            dc.rj3 r4 = (dc.rj3) r4
            java.lang.String r4 = r4.a()
            boolean r4 = dc.pj3.e(r4)
            if (r4 == 0) goto L3b
            if (r3 == 0) goto L1a
            boolean r2 = r3 instanceof android.widget.TextView
            if (r2 != 0) goto L35
        L1a:
            android.content.Context r2 = r1.a
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r3 = 2131558430(0x7f0d001e, float:1.8742176E38)
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r2 = r1.c
            r3.setHeight(r2)
            int r2 = r1.c
            r3.setWidth(r2)
        L35:
            android.view.View$OnClickListener r2 = r1.g
            r3.setOnClickListener(r2)
            goto L72
        L3b:
            if (r3 == 0) goto L46
            boolean r4 = r3 instanceof com.wear.util.photoselector.PhotoItem
            if (r4 != 0) goto L42
            goto L46
        L42:
            r4 = r3
            com.wear.util.photoselector.PhotoItem r4 = (com.wear.util.photoselector.PhotoItem) r4
            goto L53
        L46:
            com.wear.util.photoselector.PhotoItem r3 = new com.wear.util.photoselector.PhotoItem
            android.content.Context r4 = r1.a
            r3.<init>(r4)
            android.widget.AbsListView$LayoutParams r4 = r1.e
            r3.setLayoutParams(r4)
            r4 = r3
        L53:
            java.util.ArrayList<T> r0 = r1.b
            java.lang.Object r0 = r0.get(r2)
            dc.rj3 r0 = (dc.rj3) r0
            r4.setImageDrawable(r0)
            java.util.ArrayList<T> r0 = r1.b
            java.lang.Object r0 = r0.get(r2)
            dc.rj3 r0 = (dc.rj3) r0
            boolean r0 = r0.b()
            r4.setSelected(r0)
            com.wear.util.photoselector.PhotoItem$b r0 = r1.f
            r4.setOnClickListener(r0, r2)
        L72:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sj3.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public sj3(Context context, ArrayList<rj3> arrayList, int i, PhotoItem.b bVar, View.OnClickListener onClickListener) throws Resources.NotFoundException {
        this(context, arrayList);
        b(i);
        this.f = bVar;
        this.g = onClickListener;
    }
}
