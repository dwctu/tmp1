package com.wear.adapter.localmusic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Music;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.widget.recycler.AutoRVAdapter;
import dc.g12;
import dc.ii;
import dc.k12;
import dc.kf;
import dc.qo;
import dc.th4;
import dc.vs3;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import pl.droidsonroids.gif.GifDrawable;

/* loaded from: classes3.dex */
public class MusicNewAdapter extends AutoRVAdapter {
    public NewMusicActivity e;
    public final qo f;
    public boolean g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ Music a;

        public a(Music music) {
            this.a = music;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            MusicNewAdapter.this.e.C4();
            g12 g12Var = k12.m;
            g12Var.y(g12Var, this.a);
        }
    }

    public MusicNewAdapter(NewMusicActivity newMusicActivity, boolean z) {
        super(newMusicActivity, null);
        this.e = newMusicActivity;
        this.g = z;
        this.f = new qo().h(R.drawable.content_icon_music_cover).X(R.drawable.content_icon_music_cover).f(ii.b);
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void o(vs3 vs3Var, int i) {
        String imageUrl;
        Music music = (Music) this.a.get(i);
        ImageView imageView = (ImageView) vs3Var.a(R.id.music_cover);
        TextView textView = (TextView) vs3Var.a(R.id.music_title);
        TextView textView2 = (TextView) vs3Var.a(R.id.music_artist);
        ImageView imageView2 = (ImageView) vs3Var.a(R.id.music_like);
        View viewA = vs3Var.a(R.id.music_like_layout);
        ImageView imageView3 = (ImageView) vs3Var.a(R.id.pattern_play_icon);
        ImageView imageView4 = (ImageView) vs3Var.a(R.id.music_type);
        if (music.getMusicType() == 0) {
            imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
            imageView4.setVisibility(8);
        } else {
            imageUrl = music.getImageUrl();
            imageView4.setVisibility(0);
        }
        kf.z(this.e).v(imageUrl).a(this.f).A0(imageView);
        viewA.setVisibility(0);
        imageView2.setVisibility(0);
        textView.setText(music.getTitle());
        textView2.setText(music.getArtist());
        if (music.isFavorite()) {
            imageView2.setTag("liked");
        } else {
            imageView2.setTag("like_it");
        }
        imageView2.setImageResource(R.drawable.nav_add);
        v(textView, textView2, imageView3, false, i);
        if (MusicControl.h0().f == null) {
            v(textView, textView2, imageView3, false, i);
        } else if (MusicControl.h0().f.getMusicType() == 1) {
            v(textView, textView2, imageView3, MusicControl.h0().f.getData().equals(music.getData()), i);
        } else {
            v(textView, textView2, imageView3, MusicControl.h0().f.getSongId() == music.getSongId() && this.g, i);
        }
        viewA.setOnClickListener(new a(music));
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public int q(int i) {
        return R.layout.remote_music_item;
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public void s(String str) {
    }

    public void v(TextView textView, TextView textView2, ImageView imageView, boolean z, int i) {
        if (!z) {
            textView.setTextColor(th4.b(textView.getContext(), R.color.text_color_85));
            imageView.setVisibility(8);
            return;
        }
        this.e.d = i;
        textView.setTextColor(th4.b(textView.getContext(), R.color.select_text_color));
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

    public void x(boolean z) {
        this.g = z;
    }
}
