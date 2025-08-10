package com.wear.adapter.localmusic;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.bean.MusicPlaylist;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.recycler.AutoRVAdapter;
import dc.ah4;
import dc.f12;
import dc.g12;
import dc.vs3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PlayListGroupAdapter extends AutoRVAdapter {
    public int e;

    public class a implements ImageLoadingListener {
        public a(PlayListGroupAdapter playListGroupAdapter) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (view != null) {
                ((ImageView) view).setImageBitmap(bitmap);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if (view != null) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_music_cover);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public PlayListGroupAdapter(Context context, g12 g12Var, int i) {
        super(context, null);
        this.e = 0;
        this.e = i;
        f12 f12Var = MusicControl.h0().d;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void o(vs3 vs3Var, int i) {
        String str;
        MusicPlaylist musicPlaylist = (MusicPlaylist) this.a.get(i);
        if (musicPlaylist == null) {
            return;
        }
        ImageView imageView = (ImageView) vs3Var.a(R.id.music_cover);
        TextView textView = (TextView) vs3Var.a(R.id.music_title);
        TextView textView2 = (TextView) vs3Var.a(R.id.music_artist);
        ImageView imageView2 = (ImageView) vs3Var.a(R.id.music_like);
        ImageView imageView3 = (ImageView) vs3Var.a(R.id.music_type);
        ImageView imageView4 = (ImageView) vs3Var.a(R.id.music_more);
        String cover = musicPlaylist.getCover();
        if (i == 0 && musicPlaylist.getName().equals(ah4.e(R.string.music_my_favorite))) {
            imageView.setImageResource(R.drawable.musci_playlist_cover);
        } else if (WearUtils.e1(cover)) {
            imageView.setImageResource(R.drawable.content_icon_music_cover);
        } else {
            imageView.setImageResource(R.drawable.content_icon_music_cover);
            ImageLoader.getInstance().displayImage(cover, imageView, new a(this));
        }
        textView.setText(musicPlaylist.getName() == null ? ah4.e(R.string.common_unknown) : musicPlaylist.getName());
        if (WearUtils.e1(musicPlaylist.getTracksUrl())) {
            StringBuilder sb = new StringBuilder();
            if (musicPlaylist.getNotice() == null) {
                str = "";
            } else {
                str = musicPlaylist.getNotice() + "   ";
            }
            sb.append(str);
            sb.append(musicPlaylist.getItemsList().size());
            sb.append(" ");
            sb.append(ah4.e(R.string.music_tracks));
            textView2.setText(sb.toString());
            imageView3.setVisibility(8);
            if (musicPlaylist.isStreamMusic()) {
                imageView3.setVisibility(0);
            }
        } else {
            textView2.setText(musicPlaylist.getTotal() + " " + ah4.e(R.string.music_tracks));
            imageView3.setVisibility(0);
        }
        if (this.e != 0) {
            imageView2.setVisibility(8);
            imageView2.setClickable(true);
        } else {
            imageView2.setVisibility(8);
            imageView4.setVisibility(0);
            imageView2.setClickable(false);
        }
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public int q(int i) {
        return R.layout.music_item;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void s(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            if (v(i).getName().toLowerCase().indexOf(str.toLowerCase()) != -1) {
                arrayList.add(v(i));
            }
        }
        this.a = arrayList;
        notifyDataSetChanged();
    }

    public MusicPlaylist v(int i) {
        if (i >= this.a.size()) {
            return null;
        }
        return (MusicPlaylist) this.a.get(i);
    }

    public void w(int i) {
        MusicPlaylist musicPlaylist = (MusicPlaylist) this.a.remove(i);
        MusicControl.h0().d.g.remove(musicPlaylist);
        DaoUtils.getMusicPlaylistDao().delT(musicPlaylist);
        notifyDataSetChanged();
    }

    public void x(List<?> list) {
        if (list != null) {
            this.a = list;
        }
        notifyDataSetChanged();
    }
}
