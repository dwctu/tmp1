package dc;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.vending.expansion.downloader.Constants;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.bean.Music;
import com.wear.main.closeRange.localMusic.PlaylistDetailsActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.gif.GifDrawable;

/* compiled from: PlaylistDetailsAdapter.java */
/* loaded from: classes3.dex */
public class ik1 extends BaseAdapter {
    public LayoutInflater a;
    public int b;
    public List<Music> c = new ArrayList();

    /* compiled from: PlaylistDetailsAdapter.java */
    public class a implements ImageLoadingListener {
        public a(ik1 ik1Var) {
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
            ((ImageView) view).setImageResource(R.drawable.content_icon_music_cover);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* compiled from: PlaylistDetailsAdapter.java */
    public class b implements View.OnClickListener {
        public final /* synthetic */ Music a;

        public b(ik1 ik1Var, Music music) {
            this.a = music;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g12 g12Var = k12.m;
            g12Var.y(g12Var, this.a);
        }
    }

    /* compiled from: PlaylistDetailsAdapter.java */
    public class c {
        public TextView a;
        public ImageView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public ImageView f;
        public ImageView g;

        public c(ik1 ik1Var) {
        }
    }

    public ik1(PlaylistDetailsActivity playlistDetailsActivity) {
        this.a = null;
        this.a = LayoutInflater.from(playlistDetailsActivity);
        f12 f12Var = MusicControl.h0().d;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Music getItem(int i) {
        return this.c.get(i);
    }

    public void b(c cVar, boolean z) {
        if (!z) {
            cVar.f.setVisibility(8);
            return;
        }
        if (!MusicControl.h0().O()) {
            cVar.f.setVisibility(0);
            ((GifDrawable) cVar.f.getDrawable()).stop();
            return;
        }
        cVar.f.setVisibility(0);
        GifDrawable gifDrawable = (GifDrawable) cVar.f.getDrawable();
        if (gifDrawable.isPlaying()) {
            return;
        }
        gifDrawable.start();
    }

    public void c() {
        ArrayList arrayList = new ArrayList();
        for (Music music : this.c) {
            if (music != null) {
                arrayList.add(music);
            }
        }
        this.c.clear();
        List<Music> list = this.c;
        if (list != null) {
            list.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void d(List<Music> list) {
        this.c.clear();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setFuncType(3);
        }
        if (list != null) {
            this.c.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        String imageUrl;
        Music item = getItem(i);
        if (view == null) {
            c cVar2 = new c(this);
            View viewInflate = this.a.inflate(R.layout.music_item, (ViewGroup) null);
            cVar2.a = (TextView) viewInflate.findViewById(R.id.music_index);
            cVar2.b = (ImageView) viewInflate.findViewById(R.id.music_cover);
            cVar2.c = (TextView) viewInflate.findViewById(R.id.music_title);
            cVar2.d = (TextView) viewInflate.findViewById(R.id.music_artist);
            cVar2.e = (ImageView) viewInflate.findViewById(R.id.music_like);
            cVar2.f = (ImageView) viewInflate.findViewById(R.id.pattern_play_icon);
            cVar2.g = (ImageView) viewInflate.findViewById(R.id.music_type);
            viewInflate.setTag(cVar2);
            cVar = cVar2;
            view = viewInflate;
        } else {
            cVar = (c) view.getTag();
        }
        if (item == null) {
            c();
            return view;
        }
        if (item.getMusicType() == 0) {
            imageUrl = "content://media/external/audio/albumart/" + item.getAlbumId();
        } else {
            imageUrl = item.getImageUrl();
        }
        if (WearUtils.e1(imageUrl)) {
            cVar.b.setImageResource(R.drawable.content_icon_music_cover);
        } else {
            ImageLoader.getInstance().displayImage(imageUrl, cVar.b, new a(this));
        }
        cVar.a.setText(String.valueOf(i + 1));
        cVar.a.setVisibility(0);
        cVar.b.getLayoutParams().width = 0;
        cVar.c.setText(item.getTitle());
        cVar.e.setVisibility(0);
        if (item.getMusicType() == 0) {
            cVar.g.setVisibility(8);
            cVar.d.setText(item.getArtist());
        } else {
            cVar.g.setVisibility(0);
            if (item.getArtist() != null) {
                String[] strArrSplit = item.getArtist().split(Constants.FILENAME_SEQUENCE_SEPARATOR);
                String strTrim = strArrSplit.length > 0 ? strArrSplit[0].trim() : "";
                if (strArrSplit.length > 1) {
                    strArrSplit[1].trim();
                }
                cVar.d.setVisibility(0);
                cVar.d.setText(strTrim);
            } else {
                cVar.d.setVisibility(8);
            }
        }
        if (item.isFavorite()) {
            cVar.e.setTag("liked");
        } else {
            cVar.e.setTag("like_it");
        }
        cVar.e.setImageResource(R.drawable.nav_add);
        if (MusicControl.h0().f == null) {
            b(cVar, false);
        } else if (MusicControl.h0().f.getMusicType() == 1) {
            b(cVar, MusicControl.h0().f.getData().equals(item.getData()));
        } else {
            b(cVar, MusicControl.h0().f.getSongId() == item.getSongId());
        }
        cVar.e.setOnClickListener(new b(this, item));
        return view;
    }
}
