package com.wear.ui.longDistance.video.adapter;

import android.content.ContentUris;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.video.component.PrepareView;
import dc.f93;
import dc.fa3;
import dc.ga3;
import java.util.List;

/* loaded from: classes4.dex */
public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoHolder> {
    public List<MediaFile> a;
    public fa3 b;
    public ga3 c;

    public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int a;
        public FrameLayout b;
        public ImageView c;
        public PrepareView d;
        public ImageView e;

        public VideoHolder(View view) {
            super(view);
            this.b = (FrameLayout) view.findViewById(R.id.player_container);
            PrepareView prepareView = (PrepareView) view.findViewById(R.id.prepare_view);
            this.d = prepareView;
            this.c = (ImageView) prepareView.findViewById(R.id.thumb);
            this.e = (ImageView) this.d.findViewById(R.id.start_play);
            if (VideoRecyclerViewAdapter.this.b != null) {
                this.b.setOnClickListener(this);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            if (VideoRecyclerViewAdapter.this.c != null) {
                view.setOnClickListener(this);
            }
            view.setTag(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.start_play) {
                if (VideoRecyclerViewAdapter.this.b != null) {
                    VideoRecyclerViewAdapter.this.b.m1(view, this.a);
                }
            } else if (VideoRecyclerViewAdapter.this.c != null) {
                VideoRecyclerViewAdapter.this.c.a(this.a);
            }
        }
    }

    public VideoRecyclerViewAdapter(List<MediaFile> list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public void n(List<MediaFile> list) {
        int size = this.a.size();
        this.a.addAll(list);
        notifyItemRangeChanged(size, this.a.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull VideoHolder videoHolder, int i) {
        MediaFile mediaFile = this.a.get(i);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                f93.b().a().O(videoHolder.c, mediaFile.b() > 0 ? ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaFile.e()) : ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e()));
            } else {
                f93.b().a().I(videoHolder.c, mediaFile.f());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediaFile.b() > 0) {
            videoHolder.e.setVisibility(0);
        } else {
            videoHolder.e.setVisibility(8);
        }
        videoHolder.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_imagepicke_video, viewGroup, false));
    }

    public void q(fa3 fa3Var) {
        this.b = fa3Var;
    }

    public void r(ga3 ga3Var) {
        this.c = ga3Var;
    }
}
