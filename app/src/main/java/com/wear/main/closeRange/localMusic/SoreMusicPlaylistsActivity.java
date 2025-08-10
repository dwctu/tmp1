package com.wear.main.closeRange.localMusic;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.dao.DaoUtils;
import com.wear.dao.MusicPlaylistDao;
import com.wear.dao.MusicPlaylistItemsDao;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.cf3;
import dc.kk1;
import dc.yu3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SoreMusicPlaylistsActivity extends BaseActivity {
    public MyActionBar a;
    public SlideAndDragListView b;
    public kk1 c;
    public MusicPlaylist d;
    public List<MusicPlaylistItems> e = new ArrayList();

    public class a implements AdapterView.OnItemLongClickListener {
        public a(SoreMusicPlaylistsActivity soreMusicPlaylistsActivity) {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            return false;
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            SoreMusicPlaylistsActivity.this.x4();
        }
    }

    public class c implements SlideAndDragListView.a {
        public MusicPlaylistItems a = null;

        public c() {
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void a(int i, int i2) {
            SoreMusicPlaylistsActivity.this.e.add(i2, SoreMusicPlaylistsActivity.this.e.remove(i));
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void b(int i) {
            SoreMusicPlaylistsActivity.this.e.set(i, this.a);
            int i2 = 0;
            for (MusicPlaylistItems musicPlaylistItems : SoreMusicPlaylistsActivity.this.e) {
                if (i2 == 0) {
                    SoreMusicPlaylistsActivity.this.w4(musicPlaylistItems.getMusic());
                }
                int i3 = i2 + 1;
                musicPlaylistItems.setSortId(i2);
                if (musicPlaylistItems.getPlaylistId().equals("-1")) {
                    DaoUtils.getMusicPlaylistItemsDao().updateSore(musicPlaylistItems);
                } else {
                    DaoUtils.getMusicPlaylistItemsDao().update((MusicPlaylistItemsDao) musicPlaylistItems);
                }
                i2 = i3;
            }
            SoreMusicPlaylistsActivity.this.notifyDataSetChanged();
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void c(int i) {
            this.a = SoreMusicPlaylistsActivity.this.e.get(i);
        }
    }

    public final void notifyDataSetChanged() {
        kk1 kk1Var = this.c;
        if (kk1Var != null) {
            kk1Var.notifyDataSetChanged();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        x4();
        super.onBackPressed();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sore_music);
        this.a = (MyActionBar) findViewById(R.id.actionbar);
        this.b = (SlideAndDragListView) findViewById(R.id.music_data_list);
        MusicPlaylist musicPlaylist = (MusicPlaylist) getIntent().getSerializableExtra("playListItem");
        this.d = musicPlaylist;
        this.e = musicPlaylist.getItemsList();
        this.b.setMenu(new yu3(false, 0));
        kk1 kk1Var = new kk1(this, this.application);
        this.c = kk1Var;
        this.b.setAdapter((ListAdapter) kk1Var);
        this.b.setOnItemLongClickListener(new a(this));
        this.b.setOnItemClickListener(null);
        this.a.setBackAction(new b());
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        v4();
    }

    public final synchronized void v4() {
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnDragDropListener(new c());
        if (this.e.size() == 0) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
        notifyDataSetChanged();
    }

    public final void w4(Music music) {
        if (music.getMusicType() == 0) {
            String str = "content://media/external/audio/albumart/" + music.getAlbumId();
        } else {
            music.getImageUrl();
        }
        MusicPlaylist musicPlaylist = this.d;
        musicPlaylist.setCover(cf3.i(this, musicPlaylist));
        DaoUtils.getMusicPlaylistDao().update((MusicPlaylistDao) this.d);
        MusicControl.h0().L0(this.d);
    }

    public final void x4() {
        MusicPlaylist musicPlaylistI = MusicControl.h0().I(this.d);
        if (!WearUtils.e1(MusicControl.h0().l) && this.d.getId().equals(MusicControl.h0().l)) {
            MusicControl.h0().F(this.d.getId(), musicPlaylistI.getMusics());
            int i = 0;
            if (MusicControl.h0().f != null) {
                int i2 = 0;
                for (Music music : musicPlaylistI.getMusics()) {
                    if (MusicControl.h0().f.getMusicType() == 1) {
                        if (MusicControl.h0().f.getData().equals(music.getData())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    } else {
                        if (MusicControl.h0().f.getSongId() == music.getSongId()) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
            }
            MusicControl.h0().E = musicPlaylistI;
            MusicControl.h0().M0(i);
        }
        finish();
    }
}
