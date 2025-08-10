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
import com.wear.main.closeRange.localMusic.SoreMusicPlaylistsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;

/* compiled from: SoreMusicAdapter.java */
/* loaded from: classes3.dex */
public class kk1 extends BaseAdapter {
    public LayoutInflater a;
    public SoreMusicPlaylistsActivity b;

    /* compiled from: SoreMusicAdapter.java */
    public class a implements ImageLoadingListener {
        public a(kk1 kk1Var) {
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

    /* compiled from: SoreMusicAdapter.java */
    public class b {
        public String a;
        public TextView b;
        public ImageView c;
        public ImageView d;
        public TextView e;
        public TextView f;

        public b(kk1 kk1Var) {
        }
    }

    public kk1(SoreMusicPlaylistsActivity soreMusicPlaylistsActivity, MyApplication myApplication) {
        this.a = null;
        this.a = LayoutInflater.from(soreMusicPlaylistsActivity);
        this.b = soreMusicPlaylistsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        String imageUrl;
        Music music = this.b.e.get(i).getMusic();
        if (view == null) {
            bVar = new b(this);
            viewInflate = this.a.inflate(R.layout.remote_sore_music_item, (ViewGroup) null);
            bVar.b = (TextView) viewInflate.findViewById(R.id.music_index);
            bVar.c = (ImageView) viewInflate.findViewById(R.id.music_cover);
            bVar.d = (ImageView) viewInflate.findViewById(R.id.music_type);
            bVar.e = (TextView) viewInflate.findViewById(R.id.music_title);
            bVar.f = (TextView) viewInflate.findViewById(R.id.music_artist);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.a = music.getId();
        if (music.getMusicType() == 0) {
            imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
        } else {
            imageUrl = music.getImageUrl();
        }
        if (WearUtils.e1(imageUrl)) {
            bVar.c.setImageResource(R.drawable.content_icon_music_cover);
        } else {
            ImageLoader.getInstance().displayImage(imageUrl, bVar.c, new a(this));
        }
        bVar.b.setText(String.valueOf(i + 1));
        bVar.b.setVisibility(0);
        bVar.f.setVisibility(0);
        bVar.e.setText(music.getTitle());
        if (music.getMusicType() == 0) {
            bVar.d.setVisibility(8);
            bVar.f.setText(music.getArtist());
        } else {
            bVar.d.setVisibility(0);
            if (music.getArtist() != null) {
                String[] strArrSplit = music.getArtist().split(Constants.FILENAME_SEQUENCE_SEPARATOR);
                String strTrim = strArrSplit.length > 0 ? strArrSplit[0].trim() : "";
                if (strArrSplit.length > 1) {
                    strArrSplit[1].trim();
                }
                bVar.f.setVisibility(0);
                bVar.f.setText(strTrim);
            } else {
                bVar.f.setVisibility(8);
            }
        }
        return viewInflate;
    }
}
