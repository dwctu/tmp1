package dc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.wear.util.photoselector.AlbumItem;
import java.util.ArrayList;

/* compiled from: AlbumAdapter.java */
/* loaded from: classes4.dex */
public class lj3 extends qj3<nj3> {
    public lj3(Context context, ArrayList<nj3> arrayList) {
        super(context, arrayList);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        AlbumItem albumItem;
        if (view == null) {
            albumItem = new AlbumItem(this.a);
            view2 = albumItem;
        } else {
            view2 = view;
            albumItem = (AlbumItem) view;
        }
        albumItem.b((nj3) this.b.get(i));
        return view2;
    }
}
