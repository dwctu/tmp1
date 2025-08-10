package dc;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.bean.MusicPlaylist;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SheetToAddPlayListItemAdapter.java */
/* loaded from: classes3.dex */
public class jk1 extends BaseAdapter {
    public LayoutInflater a;
    public List<MusicPlaylist> b = new ArrayList();
    public int c;

    /* compiled from: SheetToAddPlayListItemAdapter.java */
    public class a implements ImageLoadingListener {
        public a(jk1 jk1Var) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (view == null || bitmap == null) {
                return;
            }
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

    /* compiled from: SheetToAddPlayListItemAdapter.java */
    public class b {
        public String a;
        public ImageView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public View f;
        public ImageView g;

        public b(jk1 jk1Var) {
        }
    }

    public jk1(g12 g12Var, int i) {
        this.a = null;
        this.c = 0;
        this.c = i;
        this.a = LayoutInflater.from(g12Var.b());
        f12 f12Var = MusicControl.h0().d;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MusicPlaylist getItem(int i) {
        return this.b.get(i);
    }

    public void b(List<MusicPlaylist> list) {
        this.b.clear();
        if (list != null) {
            this.b.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        String str;
        MusicPlaylist item = getItem(i);
        if (view == null) {
            bVar = new b(this);
            viewInflate = this.a.inflate(R.layout.remote_music_item, (ViewGroup) null);
            bVar.b = (ImageView) viewInflate.findViewById(R.id.music_cover);
            bVar.c = (TextView) viewInflate.findViewById(R.id.music_title);
            bVar.d = (TextView) viewInflate.findViewById(R.id.music_artist);
            bVar.e = (ImageView) viewInflate.findViewById(R.id.music_like);
            bVar.f = viewInflate.findViewById(R.id.music_like_layout);
            bVar.g = (ImageView) viewInflate.findViewById(R.id.music_type);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        if (MusicControl.h0().E == null || !MusicControl.h0().E.getId().equals(item.getId())) {
            TextView textView = bVar.c;
            textView.setTextColor(th4.b(textView.getContext(), R.color.text_color_85));
        } else {
            TextView textView2 = bVar.c;
            textView2.setTextColor(th4.b(textView2.getContext(), R.color.select_text_color));
        }
        bVar.a = item.getId();
        if (i == 0 && item.getName().equals(ah4.e(R.string.music_my_favorite))) {
            bVar.b.setImageResource(R.drawable.musci_playlist_cover);
        } else {
            String cover = item.getCover();
            if (WearUtils.e1(cover)) {
                bVar.b.setImageResource(R.drawable.content_icon_music_cover);
            } else {
                ImageLoader.getInstance().displayImage(cover, bVar.b, new a(this));
            }
        }
        bVar.c.setText(item.getName() == null ? ah4.e(R.string.common_unknown) : item.getName());
        if (WearUtils.e1(item.getTracksUrl())) {
            TextView textView3 = bVar.d;
            StringBuilder sb = new StringBuilder();
            if (item.getNotice() == null) {
                str = "";
            } else {
                str = item.getNotice() + "   ";
            }
            sb.append(str);
            sb.append(item.getItemsList().size());
            sb.append(" ");
            sb.append(ah4.e(R.string.music_tracks));
            textView3.setText(sb.toString());
            bVar.g.setVisibility(8);
        } else {
            bVar.d.setText(item.getTotal() + " " + ah4.e(R.string.music_tracks));
            bVar.g.setVisibility(0);
        }
        if (this.c == 0) {
            bVar.f.setVisibility(0);
            bVar.e.setVisibility(0);
            bVar.e.setImageResource(R.drawable.item_enter);
            bVar.f.setClickable(false);
        } else {
            bVar.f.setVisibility(8);
            bVar.e.setVisibility(8);
            bVar.f.setClickable(true);
        }
        return viewInflate;
    }
}
