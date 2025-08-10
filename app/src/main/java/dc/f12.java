package dc;

import android.content.ContentUris;
import android.database.Cursor;
import android.os.Build;
import android.os.Message;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.j256.ormlite.field.FieldType;
import com.lovense.wear.R;
import com.wear.bean.Music;
import com.wear.bean.MusicBean;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.i12;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: LocalMusicUtils.java */
/* loaded from: classes3.dex */
public class f12 extends j12 {
    public Map<String, Music> d = new HashMap();
    public List<MusicPlaylist> e = new ArrayList();
    public List<MusicPlaylist> f = new ArrayList();
    public List<MusicPlaylist> g = new ArrayList();
    public List<Music> h = new ArrayList();
    public List<String> i = new ArrayList();
    public String[] j = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "album_id", MessageBundle.TITLE_ENTRY, "artist", TypedValues.TransitionType.S_DURATION, "_data", "album"};
    public String k = "is_music > 0 and duration > 60000";

    /* compiled from: LocalMusicUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ d a;

        /* compiled from: LocalMusicUtils.java */
        /* renamed from: dc.f12$a$a, reason: collision with other inner class name */
        public class C0177a extends HashMap<String, String> {
            public final /* synthetic */ MusicBean val$musicBean;

            public C0177a(MusicBean musicBean) {
                this.val$musicBean = musicBean;
                put("count", "" + musicBean.musics.size());
            }
        }

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Cursor cursorQuery = WearUtils.x.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, f12.this.j, f12.this.k, null, "title_key");
                f12.this.d.clear();
                f12.this.i.clear();
                MusicBean musicBean = new MusicBean();
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                Music music = new Music(cursorQuery.getLong(0), cursorQuery.getLong(1));
                                music.setTitle(cursorQuery.getString(2));
                                music.setArtist(cursorQuery.getString(3));
                                music.setDuration(cursorQuery.getInt(4));
                                music.setData(cursorQuery.getString(5));
                                music.setFuncType(2);
                                String data = music.getData();
                                if (!WearUtils.e1(data) && new File(data).exists()) {
                                    music.setAlbum(cursorQuery.getString(6));
                                    if (!"tempSoundPlay".equals(music.getTitle())) {
                                        DaoUtils.getMusicDao().addIfNotExist(music);
                                        if (!f12.this.d.containsKey(music.getId())) {
                                            musicBean.musics.add(music);
                                            f12.this.d.put(music.getId(), music);
                                        }
                                    }
                                    f12.this.i.add(music.getId());
                                }
                            } catch (Exception unused) {
                                if (MusicControl.h0().c != null) {
                                    MusicControl.h0().c.dismiss();
                                }
                            }
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    WearUtils.x.q("music_appleMusic", new C0177a(musicBean));
                    cursorQuery.close();
                }
                musicBean.musics = DaoUtils.getMusicDao().findAll();
                f12.this.d.clear();
                if (musicBean.musics == null) {
                    musicBean.musics = new ArrayList();
                }
                f12 f12Var = f12.this;
                if (f12Var.h == null) {
                    f12Var.h = new ArrayList();
                }
                if (MusicControl.h0().b != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1;
                    messageObtain.obj = musicBean;
                    MusicControl.h0().b.sendMessage(messageObtain);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.a.a();
        }
    }

    /* compiled from: LocalMusicUtils.java */
    public class b implements Runnable {
        public b(f12 f12Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            MusicControl.h0().b0();
        }
    }

    /* compiled from: LocalMusicUtils.java */
    public class c implements Runnable {
        public c(f12 f12Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            MusicControl.h0().b0();
        }
    }

    /* compiled from: LocalMusicUtils.java */
    public interface d {
        void a();
    }

    public f12(MyApplication myApplication) {
        this.a = myApplication;
        this.b = new so3();
    }

    public void f() {
        HashMap map = new HashMap();
        this.e.clear();
        HashMap map2 = new HashMap();
        this.f.clear();
        for (Music music : this.h) {
            if (map.containsKey(music.getArtist())) {
                ((MusicPlaylist) map.get(music.getArtist())).addPlaylistItemByMusicToList(music, null, false, true);
            } else {
                MusicPlaylist musicPlaylist = new MusicPlaylist();
                musicPlaylist.setName(music.getArtist());
                String imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
                if (music.getMusicType() == 1) {
                    imageUrl = music.getImageUrl();
                }
                musicPlaylist.setCover(imageUrl);
                musicPlaylist.addPlaylistItemByMusicToList(music, null, false, true);
                this.e.add(musicPlaylist);
                map.put(music.getArtist(), musicPlaylist);
            }
            if (map2.containsKey(music.getAlbum())) {
                ((MusicPlaylist) map2.get(music.getAlbum())).addPlaylistItemByMusicToList(music, null, false, true);
            } else {
                MusicPlaylist musicPlaylist2 = new MusicPlaylist();
                musicPlaylist2.setName(music.getAlbum());
                musicPlaylist2.setNotice(music.getArtist());
                String imageUrl2 = "content://media/external/audio/albumart/" + music.getAlbumId();
                if (music.getMusicType() == 1) {
                    imageUrl2 = music.getImageUrl();
                }
                musicPlaylist2.setCover(imageUrl2);
                musicPlaylist2.addPlaylistItemByMusicToList(music, null, false, true);
                this.f.add(musicPlaylist2);
                map2.put(music.getAlbum(), musicPlaylist2);
            }
        }
        map.clear();
        map2.clear();
        this.g.clear();
        MusicPlaylist musicPlaylist3 = new MusicPlaylist();
        musicPlaylist3.setId("-1");
        musicPlaylist3.setName(ah4.e(R.string.music_my_favorite));
        musicPlaylist3.setEmail(WearUtils.y.r());
        this.g.add(musicPlaylist3);
        Iterator<Music> it = this.h.iterator();
        int i = 0;
        while (it.hasNext()) {
            Music next = it.next();
            if (this.i.contains(next.getId())) {
                this.d.put(next.getId(), next);
                if (next.isFavorite()) {
                    if (i == 0) {
                        String imageUrl3 = "content://media/external/audio/albumart/" + next.getAlbumId();
                        if (next.getMusicType() == 1) {
                            imageUrl3 = next.getImageUrl();
                        }
                        musicPlaylist3.setCover(imageUrl3);
                    }
                    musicPlaylist3.addPlaylistItemByMusicToList(next, null, false, true);
                    i++;
                }
            } else {
                it.remove();
                DaoUtils.getMusicDao().delT(next);
                DaoUtils.getMergerMusicDao().delTs(DaoUtils.getMergerMusicDao().findMergerMusicBySongId(String.valueOf(next.getSongId())));
            }
        }
        MusicControl.h0().o(musicPlaylist3, true);
        List<MusicPlaylist> listFindByEmail = DaoUtils.getMusicPlaylistDao().findByEmail(WearUtils.y.r());
        if (listFindByEmail != null) {
            for (MusicPlaylist musicPlaylist4 : listFindByEmail) {
                musicPlaylist4.findPlaylistItemByDB(WearUtils.y.r());
                musicPlaylist4.initMusic(this.h);
                MusicControl.h0().o(musicPlaylist4, true);
                musicPlaylist4.setCreateFromLocalDB(1);
                musicPlaylist4.setCover(cf3.i(WearUtils.x, musicPlaylist4));
            }
            this.g.addAll(listFindByEmail);
        }
        if (musicPlaylist3.getItemsList().size() > 0) {
            for (MusicPlaylistItems musicPlaylistItems : musicPlaylist3.getItemsList()) {
                musicPlaylistItems.setSortId(DaoUtils.getMusicPlaylistItemsDao().checkFavMusic(musicPlaylistItems));
            }
            try {
                Collections.sort(musicPlaylist3.getItemsList());
                Music music2 = musicPlaylist3.getItemsList().get(0).getMusic();
                musicPlaylist3.setCover(music2.getMusicType() == 0 ? "content://media/external/audio/albumart/" + music2.getAlbumId() : music2.getImageUrl());
            } catch (Exception unused) {
            }
        }
        musicPlaylist3.setCreateFromLocalDB(1);
        musicPlaylist3.setCover(cf3.i(WearUtils.x, musicPlaylist3));
    }

    public Music g(String str) {
        for (Music music : this.h) {
            if (music.getSongId() == Integer.valueOf(str).intValue()) {
                return music;
            }
        }
        return null;
    }

    public boolean h() {
        so3 so3Var = this.b;
        return so3Var != null && so3Var.s();
    }

    public void i(boolean z) {
        String str = "playOrPauseMusic==" + h();
        if (MusicControl.h0().j != null) {
            MusicControl.h0().j.c(MusicControl.h0().g);
        }
        MusicControl.h0().Q(i12.a.d(MusicControl.h0().g));
        if (h()) {
            MusicControl.h0().A0(true);
            if (MusicControl.h0().j != null) {
                MusicControl.h0().j.e(true);
            }
            MusicControl.h0().K();
            this.b.u();
            MusicControl.h0().b0();
            MusicControl.h0().b.postDelayed(new c(this), 1000L);
            return;
        }
        WearUtils.x.k.isMusicActive();
        if (MusicControl.h0().t) {
            MusicControl.h0().t = false;
            File file = new File(MusicControl.h0().f.getData());
            if (!file.exists()) {
                sg3.i(MyApplication.K, R.string.music_notExist);
                return;
            }
            so3 so3Var = this.b;
            if (so3Var != null) {
                so3Var.b = 0;
                String string = Build.VERSION.SDK_INT >= 29 ? ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MusicControl.h0().f.getSongId()).toString() : file.getAbsolutePath();
                fk2.a.k(z);
                this.b.A(string, this.c);
            }
            MusicControl.h0().G0();
        } else {
            this.b.l();
            fk2.a.k(true);
        }
        MusicControl.h0().N();
        MusicControl.h0().A0(!h());
        if (MusicControl.h0().j != null) {
            MusicControl.h0().j.e(!h());
        }
        WearUtils.x.q("offlineMusic_play", null);
        MusicControl.h0().Q(i12.a.g(0));
    }

    public void j(d dVar) {
        vg3.b().a(new a(dVar));
    }

    public void k() {
        if (MusicControl.h0().O()) {
            MusicControl.h0().A0(true);
            if (MusicControl.h0().j != null) {
                MusicControl.h0().j.e(true);
            }
            MusicControl.h0().K();
            so3 so3Var = this.b;
            if (so3Var != null) {
                so3Var.u();
            }
            MusicControl.h0().b0();
            MusicControl.h0().b.postDelayed(new b(this), 1000L);
        }
    }
}
