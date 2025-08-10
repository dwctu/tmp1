package com.wear.ui.longDistance.imagepicker.adapter;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
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
import dc.f93;
import dc.y83;
import java.util.List;

/* loaded from: classes4.dex */
public class ImageFoldersAdapter extends RecyclerView.Adapter<c> {
    public Context a;
    public List<y83> b;
    public int c;
    public b d;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageFoldersAdapter.this.c = this.a;
            ImageFoldersAdapter.this.notifyDataSetChanged();
            ImageFoldersAdapter.this.d.u2(view, this.a);
        }
    }

    public interface b {
        void u2(View view, int i);
    }

    public class c extends RecyclerView.ViewHolder {
        public ImageView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public c(ImageFoldersAdapter imageFoldersAdapter, View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_item_imageCover);
            this.b = (TextView) view.findViewById(R.id.tv_item_folderName);
            this.c = (TextView) view.findViewById(R.id.tv_item_imageSize);
            this.d = (ImageView) view.findViewById(R.id.iv_item_check);
        }
    }

    public ImageFoldersAdapter(Context context, List<y83> list, int i) {
        this.a = context;
        this.b = list;
        this.c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<y83> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i) {
        y83 y83Var = this.b.get(i);
        String strA = y83Var.a();
        y83Var.b();
        String strC = y83Var.c();
        int size = y83Var.d().size();
        if (!TextUtils.isEmpty(strC)) {
            cVar.b.setText(strC);
        }
        cVar.c.setText(String.format(this.a.getString(R.string.image_num), Integer.valueOf(size)));
        if (this.c == i) {
            cVar.d.setVisibility(0);
        } else {
            cVar.d.setVisibility(8);
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Uri uriWithAppendedId = null;
                if (y83Var.d().size() > 0) {
                    MediaFile mediaFile = y83Var.d().get(0);
                    uriWithAppendedId = mediaFile.b() > 0 ? ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaFile.e()) : ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e());
                }
                f93.b().a().O(cVar.a, uriWithAppendedId);
            } else {
                f93.b().a().y(cVar.a, strA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.d != null) {
            cVar.itemView.setOnClickListener(new a(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(this, LayoutInflater.from(this.a).inflate(R.layout.item_imagepicker_recyclerview_folder, (ViewGroup) null));
    }

    public void p(b bVar) {
        this.d = bVar;
    }
}
