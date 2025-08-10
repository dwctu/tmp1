package com.wear.adapter.longdistance;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.he3;
import java.util.List;

/* loaded from: classes3.dex */
public class EmojisFavoriteAdapter extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener {
    public Context a;
    public List<FavoriteEmojisBean> b;
    public b c;

    public static class EmojiViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview_glass)
        public LinearLayout imageviewGlass;

        @BindView(R.id.imageview_favorite_image)
        public ImageView mImageView;

        @BindView(R.id.relativelayout_favorite_image)
        public RelativeLayout relativelayoutFavoriteImage;

        public EmojiViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class EmojiViewHolder_ViewBinding implements Unbinder {
        public EmojiViewHolder a;

        @UiThread
        public EmojiViewHolder_ViewBinding(EmojiViewHolder emojiViewHolder, View view) {
            this.a = emojiViewHolder;
            emojiViewHolder.relativelayoutFavoriteImage = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.relativelayout_favorite_image, "field 'relativelayoutFavoriteImage'", RelativeLayout.class);
            emojiViewHolder.imageviewGlass = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.imageview_glass, "field 'imageviewGlass'", LinearLayout.class);
            emojiViewHolder.mImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.imageview_favorite_image, "field 'mImageView'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            EmojiViewHolder emojiViewHolder = this.a;
            if (emojiViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            emojiViewHolder.relativelayoutFavoriteImage = null;
            emojiViewHolder.imageviewGlass = null;
            emojiViewHolder.mImageView = null;
        }
    }

    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ EmojiViewHolder a;

        public a(EmojisFavoriteAdapter emojisFavoriteAdapter, EmojiViewHolder emojiViewHolder) {
            this.a = emojiViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.a.mImageView.setImageBitmap(bitmap);
            } else {
                this.a.imageviewGlass.setVisibility(0);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.a.imageviewGlass.setVisibility(0);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public interface b {
        void a(FavoriteEmojisBean favoriteEmojisBean);

        void b(FavoriteEmojisBean favoriteEmojisBean, int[] iArr);
    }

    public EmojisFavoriteAdapter(Context context, List<FavoriteEmojisBean> list, b bVar) {
        this.a = context;
        this.b = list;
        this.c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        EmojiViewHolder emojiViewHolder = (EmojiViewHolder) viewHolder;
        FavoriteEmojisBean favoriteEmojisBean = this.b.get(i);
        if (TextUtils.isEmpty(favoriteEmojisBean.getId())) {
            emojiViewHolder.mImageView.setVisibility(4);
            emojiViewHolder.imageviewGlass.setVisibility(8);
            emojiViewHolder.relativelayoutFavoriteImage.setBackgroundResource(R.color.transparent);
        } else {
            emojiViewHolder.mImageView.setVisibility(0);
            if (TextUtils.equals(favoriteEmojisBean.getId(), he3.a)) {
                emojiViewHolder.mImageView.setImageResource(R.drawable.icon_emojis_add);
                emojiViewHolder.imageviewGlass.setVisibility(8);
            } else {
                emojiViewHolder.imageviewGlass.setVisibility(8);
                ImageLoader.getInstance().displayImage(WearUtils.e + favoriteEmojisBean.getPath(), emojiViewHolder.mImageView, MyApplication.Y, new a(this, emojiViewHolder));
            }
        }
        emojiViewHolder.mImageView.setOnClickListener(this);
        emojiViewHolder.mImageView.setOnLongClickListener(this);
        emojiViewHolder.mImageView.setTag(R.id.tag1, favoriteEmojisBean);
        int size = this.b.size() / 5;
        int iA = ce3.a(this.a, i < 5 ? 16.0f : 8.0f);
        int iA2 = ce3.a(this.a, i < size * 5 ? 8.0f : 16.0f);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) emojiViewHolder.itemView.getLayoutParams();
        layoutParams.setMargins(0, iA, 0, iA2);
        emojiViewHolder.itemView.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c != null) {
            this.c.a((FavoriteEmojisBean) view.getTag(R.id.tag1));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EmojiViewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_gridpage_emojis_favorite, viewGroup, false));
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.c != null) {
            FavoriteEmojisBean favoriteEmojisBean = (FavoriteEmojisBean) view.getTag(R.id.tag1);
            if (!TextUtils.equals(favoriteEmojisBean.getId(), he3.a)) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                iArr[0] = iArr[0] + (view.getWidth() / 2);
                iArr[1] = (iArr[1] - (view.getHeight() / 2)) + ce3.a(this.a, 16.0f);
                this.c.b(favoriteEmojisBean, iArr);
            }
        }
        return false;
    }
}
