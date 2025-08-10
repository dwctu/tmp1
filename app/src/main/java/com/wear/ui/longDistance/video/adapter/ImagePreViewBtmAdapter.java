package com.wear.ui.longDistance.video.adapter;

import android.content.ContentUris;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Build;
import android.provider.MediaStore;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import dc.f93;
import dc.g93;
import dc.n93;
import java.util.List;

/* loaded from: classes4.dex */
public class ImagePreViewBtmAdapter extends BaseAdapter<MediaFile> {
    public ImagePreViewBtmAdapter(List<MediaFile> list, int i) {
        super(list, i);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, MediaFile mediaFile, int i) {
        viewHolder.getView(R.id.iv_preview_video).setVisibility(mediaFile.b() > 0 ? 0 : 8);
        viewHolder.getView(R.id.v_isSelected).setVisibility(n93.b().a() != i ? 8 : 0);
        if (g93.c().e().contains(mediaFile.f())) {
            ((ImageView) viewHolder.getView(R.id.iv_preview_btm)).setColorFilter((ColorFilter) null);
        } else {
            ((ImageView) viewHolder.getView(R.id.iv_preview_btm)).setColorFilter(Color.parseColor("#80ffffff"));
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                f93.b().a().O((ImageView) viewHolder.getView(R.id.iv_preview_btm), mediaFile.b() > 0 ? ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaFile.e()) : ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e()));
            } else {
                f93.b().a().y((ImageView) viewHolder.getView(R.id.iv_preview_btm), mediaFile.f());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
