package com.wear.adapter.longdistance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.ui.longDistance.imagepicker.view.SquareImageView;
import com.wear.ui.longDistance.imagepicker.view.SquareRelativeLayout;
import dc.hp;
import dc.kf;
import dc.o93;
import dc.qo;
import dc.wo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class SearchChatMediaAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    public Context a;
    public List b;
    public b d;
    public boolean e;
    public HashMap<String, GifImageView> g = new HashMap<>();
    public HashMap<String, View> h = new HashMap<>();
    public qo c = new qo().h(R.drawable.content_icon_picture_loading).X(R.drawable.content_icon_picture_loading);
    public List<CommunMessage> f = new ArrayList();

    public static class LabelViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_label)
        public TextView tv_label;

        public LabelViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class LabelViewHolder_ViewBinding implements Unbinder {
        public LabelViewHolder a;

        @UiThread
        public LabelViewHolder_ViewBinding(LabelViewHolder labelViewHolder, View view) {
            this.a = labelViewHolder;
            labelViewHolder.tv_label = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_label, "field 'tv_label'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LabelViewHolder labelViewHolder = this.a;
            if (labelViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            labelViewHolder.tv_label = null;
        }
    }

    public static class MediaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_check)
        public ImageView mImageCheck;

        @BindView(R.id.iv_item_image)
        public SquareImageView mImageView;

        @BindView(R.id.srl_item)
        public SquareRelativeLayout mSquareRelativeLayout;

        public MediaViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class MediaViewHolder_ViewBinding implements Unbinder {
        public MediaViewHolder a;

        @UiThread
        public MediaViewHolder_ViewBinding(MediaViewHolder mediaViewHolder, View view) {
            this.a = mediaViewHolder;
            mediaViewHolder.mSquareRelativeLayout = (SquareRelativeLayout) Utils.findRequiredViewAsType(view, R.id.srl_item, "field 'mSquareRelativeLayout'", SquareRelativeLayout.class);
            mediaViewHolder.mImageView = (SquareImageView) Utils.findRequiredViewAsType(view, R.id.iv_item_image, "field 'mImageView'", SquareImageView.class);
            mediaViewHolder.mImageCheck = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_item_check, "field 'mImageCheck'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MediaViewHolder mediaViewHolder = this.a;
            if (mediaViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            mediaViewHolder.mSquareRelativeLayout = null;
            mediaViewHolder.mImageView = null;
            mediaViewHolder.mImageCheck = null;
        }
    }

    public static class PhotoViewHolder extends MediaViewHolder {

        @BindView(R.id.iv_item_gif)
        public ImageView mImageGif;

        public PhotoViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class PhotoViewHolder_ViewBinding extends MediaViewHolder_ViewBinding {
        public PhotoViewHolder b;

        @UiThread
        public PhotoViewHolder_ViewBinding(PhotoViewHolder photoViewHolder, View view) {
            super(photoViewHolder, view);
            this.b = photoViewHolder;
            photoViewHolder.mImageGif = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_item_gif, "field 'mImageGif'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.SearchChatMediaAdapter.MediaViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PhotoViewHolder photoViewHolder = this.b;
            if (photoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            photoViewHolder.mImageGif = null;
            super.unbind();
        }
    }

    public static class ShortVideoViewHolder extends MediaViewHolder {

        @BindView(R.id.tv_item_videoDuration)
        public TextView mVideoDuration;

        public ShortVideoViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ShortVideoViewHolder_ViewBinding extends MediaViewHolder_ViewBinding {
        public ShortVideoViewHolder b;

        @UiThread
        public ShortVideoViewHolder_ViewBinding(ShortVideoViewHolder shortVideoViewHolder, View view) {
            super(shortVideoViewHolder, view);
            this.b = shortVideoViewHolder;
            shortVideoViewHolder.mVideoDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_item_videoDuration, "field 'mVideoDuration'", TextView.class);
        }

        @Override // com.wear.adapter.longdistance.SearchChatMediaAdapter.MediaViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ShortVideoViewHolder shortVideoViewHolder = this.b;
            if (shortVideoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            shortVideoViewHolder.mVideoDuration = null;
            super.unbind();
        }
    }

    public class a extends wo<Bitmap> {
        public final /* synthetic */ PhotoViewHolder d;
        public final /* synthetic */ Object e;

        public a(PhotoViewHolder photoViewHolder, Object obj) {
            this.d = photoViewHolder;
            this.e = obj;
        }

        @Override // dc.cp
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull @NotNull Bitmap bitmap, @Nullable @org.jetbrains.annotations.Nullable hp<? super Bitmap> hpVar) {
            this.d.mImageView.setImageBitmap(bitmap);
            Object obj = this.e;
            String string = obj instanceof File ? Uri.fromFile((File) obj).toString() : obj instanceof String ? (String) obj : "";
            SearchChatMediaAdapter.this.h.put(string, this.d.mImageView);
            GifImageView gifImageView = new GifImageView(SearchChatMediaAdapter.this.a);
            gifImageView.setImageBitmap(bitmap);
            SearchChatMediaAdapter.this.g.put(string, gifImageView);
        }

        @Override // dc.cp
        public void e(@Nullable @org.jetbrains.annotations.Nullable Drawable drawable) {
        }
    }

    public interface b {
        void a();

        void b(int i);

        void c(CommunMessage communMessage);
    }

    public SearchChatMediaAdapter(Context context, List list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object obj = this.b.get(i);
        if (!(obj instanceof CommunMessage)) {
            return 1;
        }
        CommunMessage communMessage = (CommunMessage) obj;
        if (communMessage.getType() == MessageType.picture) {
            return 2;
        }
        return communMessage.getType() == MessageType.shortvideo ? 3 : 0;
    }

    public HashMap<String, GifImageView> o() {
        return this.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) {
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals("select", it.next().toString()) && (viewHolder instanceof MediaViewHolder)) {
                u((MediaViewHolder) viewHolder, (CommunMessage) this.b.get(i));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CommunMessage communMessage = (CommunMessage) view.getTag(R.id.tag1);
        int id = view.getId();
        if (id == R.id.iv_item_check) {
            if (this.e) {
                if (this.f.contains(communMessage)) {
                    boolean z = this.f.size() == 9;
                    this.f.remove(communMessage);
                    if (z) {
                        for (Object obj : this.b) {
                            if (obj instanceof CommunMessage) {
                                notifyItemChanged(this.b.indexOf(obj), "select");
                            }
                        }
                    } else {
                        notifyItemChanged(this.b.indexOf(communMessage), "select");
                    }
                } else if (this.f.size() < 9) {
                    this.f.add(communMessage);
                    if (this.f.size() == 9) {
                        for (Object obj2 : this.b) {
                            if (obj2 instanceof CommunMessage) {
                                notifyItemChanged(this.b.indexOf(obj2), "select");
                            }
                        }
                    } else {
                        notifyItemChanged(this.b.indexOf(communMessage), "select");
                    }
                }
                b bVar = this.d;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            return;
        }
        if (id != R.id.srl_item) {
            return;
        }
        if (!this.e) {
            b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.c(communMessage);
                return;
            }
            return;
        }
        if (this.f.contains(communMessage)) {
            b bVar3 = this.d;
            if (bVar3 != null) {
                bVar3.b(this.f.indexOf(communMessage));
                return;
            }
            return;
        }
        if (this.f.size() < 9) {
            this.f.add(communMessage);
            if (this.f.size() == 9) {
                for (Object obj3 : this.b) {
                    if (obj3 instanceof CommunMessage) {
                        notifyItemChanged(this.b.indexOf(obj3), "select");
                    }
                }
            } else {
                notifyItemChanged(this.b.indexOf(communMessage), "select");
            }
            b bVar4 = this.d;
            if (bVar4 != null) {
                bVar4.a();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.a);
        return i == 1 ? new LabelViewHolder(layoutInflaterFrom.inflate(R.layout.item_search_chat_media_header, viewGroup, false)) : i == 2 ? new PhotoViewHolder(layoutInflaterFrom.inflate(R.layout.item_imagepicker_recyclerview_image, viewGroup, false)) : new ShortVideoViewHolder(layoutInflaterFrom.inflate(R.layout.item_imagepicker_recyclerview_video, viewGroup, false));
    }

    public View p(String str) {
        return this.h.get(str);
    }

    public List<CommunMessage> q() {
        return this.f;
    }

    public void r(boolean z) {
        this.e = z;
        if (!z) {
            this.f.clear();
        }
        v();
    }

    public void s(b bVar) {
        this.d = bVar;
    }

    public void t(List<CommunMessage> list) {
        this.f.clear();
        this.f.addAll(list);
        v();
    }

    public final void u(MediaViewHolder mediaViewHolder, CommunMessage communMessage) {
        if (!this.e) {
            mediaViewHolder.mImageCheck.setVisibility(8);
            mediaViewHolder.mImageView.setColorFilter((ColorFilter) null);
            return;
        }
        mediaViewHolder.mImageCheck.setVisibility(0);
        if (this.f.contains(communMessage)) {
            mediaViewHolder.mImageView.setColorFilter(Color.parseColor("#80000000"));
            mediaViewHolder.mImageCheck.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_image_checked));
        } else {
            mediaViewHolder.mImageView.setColorFilter(Color.parseColor(this.f.size() == 9 ? "#80ffffff" : "#00000000"));
            mediaViewHolder.mImageCheck.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_image_check));
        }
    }

    public final void v() {
        for (Object obj : this.b) {
            if (obj instanceof CommunMessage) {
                notifyItemChanged(this.b.indexOf(obj), "select");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof LabelViewHolder) {
            ((LabelViewHolder) viewHolder).tv_label.setText((String) this.b.get(i));
            return;
        }
        if (viewHolder instanceof PhotoViewHolder) {
            PhotoViewHolder photoViewHolder = (PhotoViewHolder) viewHolder;
            CommunMessage communMessage = (CommunMessage) this.b.get(i);
            Object tempMediaData = communMessage.getTempMediaData();
            if (tempMediaData != null) {
                kf.w(this.a).j().I0(tempMediaData).a(this.c).x0(new a(photoViewHolder, tempMediaData));
            } else {
                photoViewHolder.mImageView.setImageResource(R.drawable.content_icon_picture_loading);
            }
            photoViewHolder.mSquareRelativeLayout.setTag(R.id.tag1, communMessage);
            photoViewHolder.mSquareRelativeLayout.setOnClickListener(this);
            photoViewHolder.mImageCheck.setTag(R.id.tag1, communMessage);
            photoViewHolder.mImageCheck.setOnClickListener(this);
            u(photoViewHolder, communMessage);
            return;
        }
        if (viewHolder instanceof ShortVideoViewHolder) {
            ShortVideoViewHolder shortVideoViewHolder = (ShortVideoViewHolder) viewHolder;
            CommunMessage communMessage2 = (CommunMessage) this.b.get(i);
            EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage2.getDataBean();
            if (communMessage2.getTempMediaData() != null) {
                kf.w(this.a).u(communMessage2.getTempMediaData()).a(this.c).A0(shortVideoViewHolder.mImageView);
            } else {
                shortVideoViewHolder.mImageView.setImageResource(R.drawable.content_icon_picture_loading);
            }
            shortVideoViewHolder.mVideoDuration.setText(o93.b(entityShortVideo.getDuration()));
            shortVideoViewHolder.mSquareRelativeLayout.setTag(R.id.tag1, communMessage2);
            shortVideoViewHolder.mSquareRelativeLayout.setOnClickListener(this);
            shortVideoViewHolder.mImageCheck.setTag(R.id.tag1, communMessage2);
            shortVideoViewHolder.mImageCheck.setOnClickListener(this);
            u(shortVideoViewHolder, communMessage2);
        }
    }
}
