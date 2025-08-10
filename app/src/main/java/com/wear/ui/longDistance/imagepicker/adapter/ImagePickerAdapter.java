package com.wear.ui.longDistance.imagepicker.adapter;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.imagepicker.view.SquareImageView;
import com.wear.ui.longDistance.imagepicker.view.SquareRelativeLayout;
import dc.f93;
import dc.g93;
import dc.le3;
import dc.o93;
import java.util.List;

/* loaded from: classes4.dex */
public class ImagePickerAdapter extends RecyclerView.Adapter<c> {
    public Context a;
    public List<MediaFile> b;
    public boolean c = f93.b().g();
    public f d;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePickerAdapter.this.d.h3(view, this.a);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePickerAdapter.this.d.w2(view, this.a);
        }
    }

    public class c extends RecyclerView.ViewHolder {
        public SquareRelativeLayout a;

        public c(ImagePickerAdapter imagePickerAdapter, View view) {
            super(view);
            this.a = (SquareRelativeLayout) view.findViewById(R.id.srl_item);
        }
    }

    public class d extends e {
        public ImageView e;

        public d(ImagePickerAdapter imagePickerAdapter, View view) {
            super(imagePickerAdapter, view);
            this.e = (ImageView) view.findViewById(R.id.iv_item_gif);
        }
    }

    public class e extends c {
        public SquareImageView b;
        public ImageView c;
        public View d;

        public e(ImagePickerAdapter imagePickerAdapter, View view) {
            super(imagePickerAdapter, view);
            this.b = (SquareImageView) view.findViewById(R.id.iv_item_image);
            this.c = (ImageView) view.findViewById(R.id.iv_item_check);
            this.d = view.findViewById(R.id.v_bg);
        }
    }

    public interface f {
        void h3(View view, int i);

        void w2(View view, int i);
    }

    public class g extends e {
        public TextView e;

        public g(ImagePickerAdapter imagePickerAdapter, View view) {
            super(imagePickerAdapter, view);
            this.e = (TextView) view.findViewById(R.id.tv_item_videoDuration);
        }
    }

    public ImagePickerAdapter(Context context, List<MediaFile> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MediaFile> list = this.b;
        if (list == null) {
            return 0;
        }
        boolean z = this.c;
        int size = list.size();
        return z ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.c) {
            if (i == 0) {
                return 1;
            }
            i--;
        }
        return this.b.get(i).b() > 0 ? 3 : 2;
    }

    public final void m(e eVar, MediaFile mediaFile, int i) {
        String strF = mediaFile.f();
        if (TextUtils.isEmpty(strF)) {
            return;
        }
        if (eVar instanceof d) {
            if ("gif".equals(le3.g(strF))) {
                ((d) eVar).e.setVisibility(0);
            } else {
                ((d) eVar).e.setVisibility(8);
            }
        }
        if (g93.c().i(strF) || g93.c().e().size() != f93.b().c()) {
            if (g93.c().i(strF)) {
                eVar.b.setColorFilter(Color.parseColor("#80000000"));
                eVar.c.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_image_checked));
            } else {
                eVar.b.setColorFilter((ColorFilter) null);
                eVar.c.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_image_check));
            }
            eVar.d.setVisibility(8);
        } else {
            eVar.c.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_image_check));
            eVar.d.setVisibility(0);
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                f93.b().a().O(eVar.b, i == 3 ? ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaFile.e()) : ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e()));
            } else {
                f93.b().a().y(eVar.b, strF);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (eVar instanceof g) {
            ((g) eVar).e.setText(o93.b(mediaFile.b()));
        }
    }

    public MediaFile n(int i) {
        if (!this.c) {
            return this.b.get(i);
        }
        if (i == 0) {
            return null;
        }
        return this.b.get(i - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i) {
        int itemViewType = getItemViewType(i);
        MediaFile mediaFileN = n(i);
        if (itemViewType == 2 || itemViewType == 3) {
            m((e) cVar, mediaFileN, itemViewType);
        }
        if (this.d != null) {
            cVar.a.setOnClickListener(new a(i));
            if (cVar instanceof e) {
                ((e) cVar).c.setOnClickListener(new b(i));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new c(this, LayoutInflater.from(this.a).inflate(R.layout.item_imagepicker_recyclerview_camera, (ViewGroup) null));
        }
        if (i == 2) {
            return new d(this, LayoutInflater.from(this.a).inflate(R.layout.item_imagepicker_recyclerview_image, (ViewGroup) null));
        }
        if (i == 3) {
            return new g(this, LayoutInflater.from(this.a).inflate(R.layout.item_imagepicker_recyclerview_video, (ViewGroup) null));
        }
        return null;
    }

    public void q(f fVar) {
        this.d = fVar;
    }
}
