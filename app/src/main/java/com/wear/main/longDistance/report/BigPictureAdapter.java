package com.wear.main.longDistance.report;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.main.longDistance.report.BigPictureAdapter;
import dc.kf;

/* loaded from: classes3.dex */
public class BigPictureAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    public String[] a;
    public a b;

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView a;

        public ImageViewHolder(View view, final BigPictureAdapter bigPictureAdapter) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
            this.a = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.dc2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BigPictureAdapter.ImageViewHolder.a(bigPictureAdapter, view2);
                }
            });
        }

        public static /* synthetic */ void a(BigPictureAdapter bigPictureAdapter, View view) {
            if (bigPictureAdapter.b != null) {
                bigPictureAdapter.b.a();
            }
        }
    }

    public interface a {
        void a();
    }

    public BigPictureAdapter(String[] strArr) {
        this.a = strArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        kf.w(imageViewHolder.a.getContext()).v(this.a[i]).l().A0(imageViewHolder.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_view_item, viewGroup, false), this);
    }

    public void o(a aVar) {
        this.b = aVar;
    }
}
