package com.wear.adapter.localmusic;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.bean.Music;
import com.wear.main.closeRange.localMusic.SearchLocalMusicActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.widget.recycler.AutoRVAdapter;
import dc.f12;
import dc.g12;
import dc.k12;
import dc.mg3;
import dc.vs3;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.gif.GifDrawable;

/* loaded from: classes3.dex */
public class LocalMusicSearchAdapter extends AutoRVAdapter {
    public SearchLocalMusicActivity e;
    public String f;

    public class a implements ImageLoadingListener {
        public a(LocalMusicSearchAdapter localMusicSearchAdapter) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ((ImageView) view).setImageBitmap(bitmap);
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

    public class b implements View.OnClickListener {
        public final /* synthetic */ Music a;

        public b(LocalMusicSearchAdapter localMusicSearchAdapter, Music music) {
            this.a = music;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g12 g12Var = k12.m;
            g12Var.y(g12Var, this.a);
        }
    }

    public LocalMusicSearchAdapter(SearchLocalMusicActivity searchLocalMusicActivity) {
        super(searchLocalMusicActivity, null);
        this.e = searchLocalMusicActivity;
        f12 f12Var = MusicControl.h0().d;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void o(vs3 vs3Var, int i) {
        String imageUrl;
        Music music = (Music) this.a.get(i);
        ImageView imageView = (ImageView) vs3Var.a(R.id.music_cover);
        TextView textView = (TextView) vs3Var.a(R.id.music_title);
        TextView textView2 = (TextView) vs3Var.a(R.id.music_artist);
        ImageView imageView2 = (ImageView) vs3Var.a(R.id.music_like);
        ImageView imageView3 = (ImageView) vs3Var.a(R.id.pattern_play_icon);
        if (music.getMusicType() == 0) {
            imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
        } else {
            imageUrl = music.getImageUrl();
        }
        if (imageView.getTag() == null || !imageView.getTag().equals(imageUrl)) {
            ImageLoader.getInstance().displayImage(imageUrl, imageView, new a(this));
        }
        imageView.setTag(imageUrl);
        imageView2.setVisibility(0);
        textView.setText(mg3.a(this.e, music.getTitle(), this.f));
        textView2.setText(music.getArtist());
        if (music.isFavorite()) {
            imageView2.setTag("liked");
        } else {
            imageView2.setTag("like_it");
        }
        imageView2.setImageResource(R.drawable.nav_add);
        if (MusicControl.h0().f == null) {
            v(textView, textView2, imageView3, false);
        } else if (MusicControl.h0().f.getMusicType() == 1) {
            v(textView, textView2, imageView3, MusicControl.h0().f.getData().equals(music.getData()));
        } else {
            v(textView, textView2, imageView3, MusicControl.h0().f.getSongId() == music.getSongId());
        }
        imageView2.setOnClickListener(new b(this, music));
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public int q(int i) {
        return R.layout.music_item;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void s(String str) {
        this.f = str;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            if (((Music) getItem(i)).getTitle().toLowerCase().indexOf(str.toLowerCase()) != -1) {
                arrayList.add((Music) getItem(i));
            }
        }
        this.a = arrayList;
        notifyDataSetChanged();
    }

    public void v(TextView textView, TextView textView2, ImageView imageView, boolean z) {
        if (!z) {
            imageView.setVisibility(4);
            return;
        }
        if (!MusicControl.h0().O()) {
            imageView.setVisibility(0);
            ((GifDrawable) imageView.getDrawable()).stop();
            return;
        }
        imageView.setVisibility(0);
        GifDrawable gifDrawable = (GifDrawable) imageView.getDrawable();
        if (gifDrawable.isPlaying()) {
            return;
        }
        gifDrawable.start();
    }

    public void w(List<?> list) {
        if (list != null) {
            this.a = list;
        }
        notifyDataSetChanged();
    }
}
