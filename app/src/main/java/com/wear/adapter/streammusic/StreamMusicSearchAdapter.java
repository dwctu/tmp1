package com.wear.adapter.streammusic;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.bean.Music;
import com.wear.bean.SearchSpotifyAbstract;
import com.wear.bean.SearchSpotifyPlaylists;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.recycler.AutoRVAdapter;
import dc.ah4;
import dc.g12;
import dc.mg3;
import dc.vs3;
import pl.droidsonroids.gif.GifDrawable;

/* loaded from: classes3.dex */
public class StreamMusicSearchAdapter extends AutoRVAdapter {
    public Context e;
    public g12 f;
    public SearchSpotifyAbstract g;
    public String h;

    public class a implements ImageLoadingListener {
        public a(StreamMusicSearchAdapter streamMusicSearchAdapter) {
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
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StreamMusicSearchAdapter streamMusicSearchAdapter = StreamMusicSearchAdapter.this;
            g12 g12Var = streamMusicSearchAdapter.f;
            g12Var.y(g12Var, streamMusicSearchAdapter.v(this.a));
        }
    }

    public StreamMusicSearchAdapter(Context context, g12 g12Var, SearchSpotifyAbstract searchSpotifyAbstract) {
        super(context, null);
        this.e = context;
        this.f = g12Var;
        this.g = searchSpotifyAbstract;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void o(vs3 vs3Var, int i) {
        String str;
        ImageView imageView = (ImageView) vs3Var.a(R.id.music_cover);
        TextView textView = (TextView) vs3Var.a(R.id.music_title);
        TextView textView2 = (TextView) vs3Var.a(R.id.music_artist);
        ImageView imageView2 = (ImageView) vs3Var.a(R.id.music_like);
        ImageView imageView3 = (ImageView) vs3Var.a(R.id.pattern_play_icon);
        ImageView imageView4 = (ImageView) vs3Var.a(R.id.music_more);
        String strImageUrl = this.g.imageUrl(i);
        if (imageView.getTag() == null || !imageView.getTag().equals(strImageUrl)) {
            ImageLoader.getInstance().displayImage(strImageUrl, imageView, new a(this));
        }
        imageView.setTag(strImageUrl);
        imageView2.setVisibility(0);
        textView.setText(mg3.a(this.e, this.g.title(i), this.h));
        if (this.g.isGroupItem()) {
            imageView2.setClickable(false);
            imageView2.setVisibility(8);
            imageView4.setVisibility(0);
            if (WearUtils.e1(this.g.notice(i))) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                StringBuilder sb = new StringBuilder();
                sb.append(this.g.notice(i));
                if (this.g instanceof SearchSpotifyPlaylists) {
                    str = " " + ah4.e(R.string.music_tracks);
                } else {
                    str = "";
                }
                sb.append(str);
                textView2.setText(sb.toString());
            }
        } else {
            imageView2.setClickable(true);
            imageView2.setImageResource(R.drawable.nav_add);
            imageView4.setVisibility(8);
            textView2.setText(this.g.notice(i));
        }
        if (this.g.isGroupItem()) {
            imageView2.setOnClickListener(null);
        } else {
            imageView2.setOnClickListener(new b(i));
        }
        w(textView, textView2, imageView3, false);
        if (MusicControl.h0().f == null) {
            w(textView, textView2, imageView3, false);
        } else if (MusicControl.h0().f.getMusicType() == 1) {
            w(textView, textView2, imageView3, MusicControl.h0().f.getData().equals(this.g.getTracksUri(i)));
        }
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public int q(int i) {
        return R.layout.music_item;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void s(String str) {
        this.h = str;
    }

    public Music v(int i) {
        Music music = new Music();
        music.setTitle(this.g.title(i));
        music.setArtist(this.g.notice(i));
        music.setData(this.g.getTracksUri(i));
        music.setDuration(this.g.getDuration(i));
        music.setImageUrl(this.g.imageUrl(i));
        music.setMusicType(1);
        return music;
    }

    public void w(TextView textView, TextView textView2, ImageView imageView, boolean z) {
        if (!z) {
            imageView.setVisibility(8);
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

    public void x(SearchSpotifyAbstract searchSpotifyAbstract) {
        this.g = searchSpotifyAbstract;
        if (searchSpotifyAbstract != null) {
            this.a = searchSpotifyAbstract.getList();
        }
        notifyDataSetChanged();
    }
}
