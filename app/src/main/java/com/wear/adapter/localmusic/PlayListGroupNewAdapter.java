package com.wear.adapter.localmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.MusicPlaylist;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.recycler.AutoRVAdapter;
import dc.ah4;
import dc.f12;
import dc.g12;
import dc.kf;
import dc.qo;
import dc.th4;
import dc.vs3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PlayListGroupNewAdapter extends AutoRVAdapter {
    public Context e;
    public qo f;
    public int g;

    public PlayListGroupNewAdapter(Context context, g12 g12Var, int i) {
        super(context, null);
        this.g = 0;
        this.e = context;
        this.g = i;
        LayoutInflater.from(g12Var.b());
        f12 f12Var = MusicControl.h0().d;
        this.f = new qo().h(R.drawable.content_icon_music_cover).X(R.drawable.content_icon_music_cover);
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
        ImageView imageView3 = (ImageView) vs3Var.a(R.id.music_more);
        View viewA = vs3Var.a(R.id.music_like_layout);
        ImageView imageView4 = (ImageView) vs3Var.a(R.id.music_type);
        if (MusicControl.h0().E == null || !MusicControl.h0().E.getId().equals(musicPlaylist.getId())) {
            textView.setTextColor(th4.b(textView.getContext(), R.color.text_color_85));
        } else {
            textView.setTextColor(th4.b(textView.getContext(), R.color.select_text_color));
        }
        String cover = musicPlaylist.getCover();
        if (i == 0 && musicPlaylist.getName().equals(ah4.e(R.string.music_my_favorite))) {
            imageView.setImageResource(R.drawable.musci_playlist_cover);
        } else if (WearUtils.e1(cover)) {
            imageView.setImageResource(R.drawable.content_icon_music_cover);
        } else {
            kf.w(this.e).v(cover).a(this.f).A0(imageView);
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
            imageView4.setVisibility(8);
            if (musicPlaylist.isStreamMusic()) {
                imageView4.setVisibility(0);
            }
        } else {
            textView2.setText(musicPlaylist.getTotal() + " " + ah4.e(R.string.music_tracks));
            imageView4.setVisibility(0);
        }
        if (this.g == 0) {
            viewA.setVisibility(0);
            imageView2.setVisibility(8);
            imageView3.setVisibility(0);
            viewA.setClickable(false);
            return;
        }
        viewA.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        viewA.setClickable(true);
    }

    @Override // com.wear.widget.recycler.AutoRVAdapter
    public int q(int i) {
        return R.layout.remote_music_item;
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
