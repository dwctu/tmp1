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
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.main.longDistance.EmojisManagerActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ie3;
import java.io.File;
import java.util.List;

/* compiled from: EmojisFavoriteGridViewAdapter.java */
/* loaded from: classes3.dex */
public class pl1 extends BaseAdapter {
    public Activity a;
    public List<FavoriteEmojisBean> b = null;
    public ie3 c;
    public ie3.m d;

    /* compiled from: EmojisFavoriteGridViewAdapter.java */
    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ d a;

        public a(pl1 pl1Var, d dVar) {
            this.a = dVar;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.a.b.setVisibility(8);
                this.a.a.setVisibility(0);
                this.a.a.setImageBitmap(bitmap);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.a.b.setVisibility(0);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* compiled from: EmojisFavoriteGridViewAdapter.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(R.id.imageview_favorite_image) == null || view.getTag(R.id.relativelayout_favorite_image) == null) {
                return;
            }
            String string = view.getTag(R.id.imageview_favorite_image).toString();
            String string2 = view.getTag(R.id.relativelayout_favorite_image).toString();
            if (WearUtils.e1(string)) {
                return;
            }
            if (string.equals(he3.a)) {
                pj3.o(pl1.this.a, EmojisManagerActivity.class, 545);
            } else {
                if (WearUtils.e1(string2)) {
                    return;
                }
                pl1.this.d.o2(new File(WearUtils.Y(), WearUtils.r0(string)), "emoji", string2, string);
            }
        }
    }

    /* compiled from: EmojisFavoriteGridViewAdapter.java */
    public class c implements View.OnLongClickListener {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            pl1.this.c.o(this.a, null, pl1.this.b);
            return false;
        }
    }

    /* compiled from: EmojisFavoriteGridViewAdapter.java */
    public class d {
        public ImageView a;
        public View b;
        public RelativeLayout c;

        public d(pl1 pl1Var) {
        }

        public /* synthetic */ d(pl1 pl1Var, a aVar) {
            this(pl1Var);
        }
    }

    public pl1(Activity activity, ie3.m mVar, ie3 ie3Var) {
        this.a = activity;
        this.c = ie3Var;
        this.d = mVar;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public FavoriteEmojisBean getItem(int i) {
        return this.b.get(i);
    }

    public void e(List<FavoriteEmojisBean> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FavoriteEmojisBean> list = this.b;
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
        d dVar;
        a aVar = null;
        if (view == null) {
            d dVar2 = new d(this, aVar);
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.item_gridpage_emojis_favorite, (ViewGroup) null);
            dVar2.c = (RelativeLayout) viewInflate.findViewById(R.id.relativelayout_favorite_image);
            dVar2.a = (ImageView) viewInflate.findViewById(R.id.imageview_favorite_image);
            dVar2.b = viewInflate.findViewById(R.id.imageview_glass);
            viewInflate.setTag(dVar2);
            dVar = dVar2;
            view = viewInflate;
        } else {
            dVar = (d) view.getTag();
        }
        view.setTag(R.id.imageview_favorite_image, null);
        dVar.a.setTag(R.id.imageview_favorite_image, null);
        dVar.a.setTag(R.id.relativelayout_favorite_image, null);
        FavoriteEmojisBean item = getItem(i);
        dVar.a.setVisibility(4);
        dVar.a.setOnLongClickListener(null);
        dVar.b.setVisibility(8);
        if (item != null) {
            String id = item.getId();
            if (WearUtils.e1(id)) {
                dVar.c.setBackgroundResource(R.color.transparent);
            } else {
                if (id.equals(he3.a)) {
                    dVar.a.setVisibility(0);
                    view.setTag(R.id.imageview_favorite_image, he3.a);
                    view.setTag(R.id.relativelayout_favorite_image, "");
                    dVar.a.setTag(R.id.imageview_favorite_image, he3.a);
                    dVar.a.setTag(R.id.relativelayout_favorite_image, "");
                    dVar.b.setVisibility(8);
                } else if (!WearUtils.e1(item.getPath())) {
                    dVar.b.setVisibility(0);
                    view.setTag(R.id.imageview_favorite_image, item.getId());
                    view.setTag(R.id.relativelayout_favorite_image, item.getFileMd5());
                    dVar.a.setTag(R.id.imageview_favorite_image, item.getId());
                    dVar.a.setTag(R.id.relativelayout_favorite_image, item.getFileMd5());
                    ImageLoader.getInstance().displayImage(WearUtils.e + item.getPath(), dVar.a, MyApplication.Y, new a(this, dVar));
                }
                dVar.a.setOnClickListener(new b());
                dVar.a.setOnLongClickListener(new c(i));
            }
        }
        return view;
    }
}
