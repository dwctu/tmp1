package com.wear.adapter.longdistance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.protocol.CommunMessage;
import com.wear.ui.longDistance.video.component.PrepareView;
import dc.fa3;
import dc.ga3;
import dc.qo;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchChatMediaPreviewFullAdapter extends RecyclerView.Adapter<VideoHolder> {
    public Context a;
    public List<CommunMessage> b;
    public qo c = new qo().h(R.drawable.content_icon_picture_loading).X(R.drawable.content_icon_picture_loading);
    public fa3 d;
    public ga3 e;

    public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int a;
        public FrameLayout b;
        public ImageView c;
        public ImageView d;
        public PrepareView e;

        public VideoHolder(View view) {
            super(view);
            this.b = (FrameLayout) view.findViewById(R.id.player_container);
            PrepareView prepareView = (PrepareView) view.findViewById(R.id.prepare_view);
            this.e = prepareView;
            this.d = (ImageView) prepareView.findViewById(R.id.thumb);
            this.c = (ImageView) this.e.findViewById(R.id.start_play);
            if (SearchChatMediaPreviewFullAdapter.this.d != null) {
                this.b.setOnClickListener(this);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            if (SearchChatMediaPreviewFullAdapter.this.e != null) {
                view.setOnClickListener(this);
            }
            view.setTag(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.start_play) {
                if (SearchChatMediaPreviewFullAdapter.this.d != null) {
                    SearchChatMediaPreviewFullAdapter.this.d.m1(view, this.a);
                }
            } else if (SearchChatMediaPreviewFullAdapter.this.e != null) {
                SearchChatMediaPreviewFullAdapter.this.e.a(this.a);
            }
        }
    }

    public SearchChatMediaPreviewFullAdapter(Context context, List<CommunMessage> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public void n(List<CommunMessage> list) {
        int size = this.b.size();
        this.b.addAll(list);
        notifyItemRangeChanged(size, this.b.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063 A[Catch: Exception -> 0x0121, TRY_ENTER, TryCatch #0 {Exception -> 0x0121, blocks: (B:3:0x0009, B:6:0x0023, B:8:0x003b, B:19:0x0063, B:21:0x0075, B:22:0x0079, B:23:0x0091, B:25:0x0097, B:27:0x00a1, B:29:0x00ab, B:32:0x00b7, B:34:0x00c1, B:37:0x00cf, B:35:0x00c6, B:36:0x00cb, B:38:0x00e5, B:40:0x00eb, B:42:0x00fd, B:43:0x0101, B:44:0x0118, B:11:0x0045, B:13:0x004d), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091 A[Catch: Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:3:0x0009, B:6:0x0023, B:8:0x003b, B:19:0x0063, B:21:0x0075, B:22:0x0079, B:23:0x0091, B:25:0x0097, B:27:0x00a1, B:29:0x00ab, B:32:0x00b7, B:34:0x00c1, B:37:0x00cf, B:35:0x00c6, B:36:0x00cb, B:38:0x00e5, B:40:0x00eb, B:42:0x00fd, B:43:0x0101, B:44:0x0118, B:11:0x0045, B:13:0x004d), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0135  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(@androidx.annotation.NonNull com.wear.adapter.longdistance.SearchChatMediaPreviewFullAdapter.VideoHolder r10, int r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.SearchChatMediaPreviewFullAdapter.onBindViewHolder(com.wear.adapter.longdistance.SearchChatMediaPreviewFullAdapter$VideoHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_imagepicke_video, viewGroup, false));
    }

    public void q(fa3 fa3Var) {
        this.d = fa3Var;
    }

    public void r(ga3 ga3Var) {
        this.e = ga3Var;
    }
}
