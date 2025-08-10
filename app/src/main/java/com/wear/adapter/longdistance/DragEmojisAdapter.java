package com.wear.adapter.longdistance;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.main.longDistance.EmojisManagerActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.he3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DragEmojisAdapter extends BaseAdapter {
    public LayoutInflater a;
    public boolean b = false;
    public EmojisManagerActivity c;

    public static class ViewHolder {

        @BindView(R.id.imageview_glass)
        public LinearLayout imageviewGlass;

        @BindView(R.id.choose_status)
        public ImageView mImageChoose;

        @BindView(R.id.imageview_favorite_image)
        public ImageView mImageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.mImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.imageview_favorite_image, "field 'mImageView'", ImageView.class);
            viewHolder.mImageChoose = (ImageView) Utils.findRequiredViewAsType(view, R.id.choose_status, "field 'mImageChoose'", ImageView.class);
            viewHolder.imageviewGlass = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.imageview_glass, "field 'imageviewGlass'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.mImageView = null;
            viewHolder.mImageChoose = null;
            viewHolder.imageviewGlass = null;
        }
    }

    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ ViewHolder a;

        public a(DragEmojisAdapter dragEmojisAdapter, ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.a.imageviewGlass.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.a.imageviewGlass.setVisibility(0);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ ViewHolder b;

        public b(int i, ViewHolder viewHolder) {
            this.a = i;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DragEmojisAdapter.this.c.D4(view, this.a);
            if (DragEmojisAdapter.this.f()) {
                if (DragEmojisAdapter.this.getItem(this.a).isChoose()) {
                    this.b.mImageChoose.setBackgroundResource(R.drawable.icon_pattern_preset_selected);
                } else {
                    this.b.mImageChoose.setBackgroundResource(R.drawable.icon_pattern_gif_default);
                }
            }
        }
    }

    public DragEmojisAdapter(EmojisManagerActivity emojisManagerActivity) {
        this.a = LayoutInflater.from(emojisManagerActivity);
        this.c = emojisManagerActivity;
    }

    public void b() {
        for (FavoriteEmojisBean favoriteEmojisBean : WearUtils.E) {
            if (!WearUtils.e1(favoriteEmojisBean.getId()) && !favoriteEmojisBean.getId().equals(he3.a) && favoriteEmojisBean.isChoose()) {
                favoriteEmojisBean.setChoose(false);
            }
        }
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        for (FavoriteEmojisBean favoriteEmojisBean : WearUtils.E) {
            if (!WearUtils.e1(favoriteEmojisBean.getId()) && !favoriteEmojisBean.getId().equals(he3.a) && favoriteEmojisBean.isChoose()) {
                arrayList.add(favoriteEmojisBean.getFileMd5());
            }
        }
        return arrayList;
    }

    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        for (FavoriteEmojisBean favoriteEmojisBean : WearUtils.E) {
            if (!WearUtils.e1(favoriteEmojisBean.getId()) && !favoriteEmojisBean.getId().equals(he3.a) && favoriteEmojisBean.isChoose()) {
                arrayList.add(favoriteEmojisBean.getId());
            }
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public FavoriteEmojisBean getItem(int i) {
        return WearUtils.E.get(i);
    }

    public boolean f() {
        return this.b;
    }

    public void g(boolean z) {
        this.b = z;
        if (z) {
            return;
        }
        Iterator<FavoriteEmojisBean> it = WearUtils.E.iterator();
        while (it.hasNext()) {
            it.next().setChoose(false);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return WearUtils.E.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.a.inflate(R.layout.item_gridpage_manage_emojis_favorite, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        FavoriteEmojisBean item = getItem(i);
        viewHolder.mImageChoose.setVisibility(8);
        viewHolder.imageviewGlass.setVisibility(0);
        if (item != null) {
            String id = item.getId();
            if (!WearUtils.e1(id)) {
                if (id.equals(he3.a)) {
                    view.setTag(R.id.imageview_favorite_image, he3.a);
                    viewHolder.mImageChoose.setVisibility(8);
                    viewHolder.imageviewGlass.setVisibility(8);
                } else if (!WearUtils.e1(item.getPath())) {
                    if (this.b) {
                        viewHolder.mImageChoose.setVisibility(0);
                        if (item.isChoose()) {
                            viewHolder.mImageChoose.setBackgroundResource(R.drawable.icon_pattern_preset_selected);
                        } else {
                            viewHolder.mImageChoose.setBackgroundResource(R.drawable.icon_pattern_gif_default);
                        }
                    } else {
                        viewHolder.mImageChoose.setVisibility(8);
                    }
                    view.setTag(R.id.imageview_favorite_image, item.getId());
                    ImageLoader.getInstance().displayImage(WearUtils.e + item.getPath(), viewHolder.mImageView, MyApplication.Y, new a(this, viewHolder));
                }
            }
        }
        view.setOnClickListener(new b(i, viewHolder));
        return view;
    }
}
