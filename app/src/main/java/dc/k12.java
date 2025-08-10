package dc;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.MergerMusic;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.bean.MusicSpotify;
import com.wear.bean.SearchSpotifyAbstract;
import com.wear.bean.SearchSpotifyAlbums;
import com.wear.bean.SearchSpotifyArtists;
import com.wear.bean.SearchSpotifyGroupAlbumTracks;
import com.wear.bean.SearchSpotifyGroupArtistTracks;
import com.wear.bean.SearchSpotifyPlaylists;
import com.wear.bean.SpotifyPlaylist;
import com.wear.bean.SpotifyTracks;
import com.wear.dao.DaoUtils;
import com.wear.dao.MergerMusicDao;
import com.wear.dao.MusicDao;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.f12;
import dc.i12;
import dc.nf3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SongsControl.java */
/* loaded from: classes3.dex */
public abstract class k12 extends rz1 {
    public static g12 m = null;
    public static boolean n = false;
    public static int o = 0;
    public static boolean p = true;
    public static boolean q = false;
    public BaseActivity a;
    public Handler b;
    public ProgressDialog c;
    public f12 d;
    public m12 e;
    public Music f;
    public Music h;
    public MusicControl.f j;
    public int g = -1;
    public List<Music> i = new ArrayList();
    public boolean k = false;
    public String l = null;

    /* compiled from: SongsControl.java */
    public class a implements nf3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ nf3.d b;
        public final /* synthetic */ boolean c;

        public a(String str, nf3.d dVar, boolean z) {
            this.a = str;
            this.b = dVar;
            this.c = z;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SpotifyPlaylist spotifyPlaylist;
            if (WearUtils.e1(str)) {
                spotifyPlaylist = null;
            } else {
                try {
                    spotifyPlaylist = (SpotifyPlaylist) new Gson().fromJson(str, SpotifyPlaylist.class);
                } catch (Exception unused) {
                }
            }
            if (spotifyPlaylist != null) {
                if (WearUtils.e1(this.a)) {
                    k12.this.e.l.clear();
                }
                if (spotifyPlaylist.getItems() != null) {
                    for (SpotifyPlaylist.ItemsBean itemsBean : spotifyPlaylist.getItems()) {
                        if (itemsBean.getOwner() != null) {
                            MusicPlaylist musicPlaylist = new MusicPlaylist();
                            musicPlaylist.setId(itemsBean.getId());
                            musicPlaylist.setName(itemsBean.getName());
                            musicPlaylist.setCover(itemsBean.getImages().size() > 0 ? itemsBean.getImages().get(0).getUrl() : null);
                            musicPlaylist.setTracksUrl(itemsBean.getTracks().getHref());
                            musicPlaylist.setTotal(itemsBean.getTracks().getTotal());
                            k12.this.o(musicPlaylist, false);
                            musicPlaylist.setCover(itemsBean.getImages().size() > 0 ? itemsBean.getImages().get(0).getUrl() : null);
                            k12.this.e.l.add(musicPlaylist);
                        }
                    }
                }
                if (WearUtils.e1(spotifyPlaylist.getNext())) {
                    nf3.d dVar = this.b;
                    if (dVar != null) {
                        dVar.onRequestComplete("true");
                    }
                } else {
                    k12.this.r(spotifyPlaylist.getNext(), this.b, false);
                }
            } else {
                sg3.h(R.string.common_serverError);
                nf3.d dVar2 = this.b;
                if (dVar2 != null) {
                    dVar2.onRequestComplete("false");
                }
            }
            if (this.c) {
                if (k12.this.b == null) {
                    FirebaseCrashlytics.getInstance().recordException(new Throwable("获取spotify播放列表 handler为空"));
                    k12.this.g();
                }
                k12.this.b.sendEmptyMessage(2);
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class b implements nf3.d {
        public final /* synthetic */ MusicPlaylist a;
        public final /* synthetic */ nf3.d b;

        public b(MusicPlaylist musicPlaylist, nf3.d dVar) {
            this.a = musicPlaylist;
            this.b = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SpotifyTracks spotifyTracks;
            k12.this.e();
            if (WearUtils.e1(str)) {
                spotifyTracks = null;
            } else {
                try {
                    spotifyTracks = (SpotifyTracks) new Gson().fromJson(str, SpotifyTracks.class);
                } catch (Exception unused) {
                }
            }
            if (spotifyTracks == null) {
                sg3.i(WearUtils.x, R.string.common_serverError);
                nf3.d dVar = this.b;
                if (dVar != null) {
                    dVar.onRequestComplete("false");
                    return;
                }
                return;
            }
            this.a.cleanMusics();
            if (spotifyTracks.getItems() != null) {
                for (SpotifyTracks.ItemsBean itemsBean : spotifyTracks.getItems()) {
                    if (itemsBean != null && itemsBean.getTrack() != null && itemsBean.getTrack().getArtists() != null && itemsBean.getTrack().getArtists().size() != 0) {
                        Music music = new Music();
                        music.setTitle(itemsBean.getTrack().getName());
                        StringBuilder sb = new StringBuilder();
                        sb.append(itemsBean.getTrack().getArtists().size() > 0 ? itemsBean.getTrack().getArtists().get(0).getName() : "");
                        sb.append(" - ");
                        sb.append(itemsBean.getTrack().getAlbum().getName());
                        music.setArtist(sb.toString());
                        music.setData(itemsBean.getTrack().getUri());
                        music.setDuration(itemsBean.getTrack().getDuration_ms());
                        if (itemsBean.getTrack().getAlbum().getImages() != null && itemsBean.getTrack().getAlbum().getImages().size() > 0) {
                            music.setImageUrl(itemsBean.getTrack().getAlbum().getImages().get(itemsBean.getTrack().getAlbum().getImages().size() - 1).getUrl());
                        }
                        music.setMusicType(1);
                        music.setCreated(itemsBean.getAdded_at());
                        this.a.addPlaylistItemByMusicToList(music, WearUtils.y.r(), false, true);
                    }
                }
            }
            k12.this.o(this.a, false);
            nf3.d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.onRequestComplete("true");
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressDialog progressDialog = k12.this.c;
            if (progressDialog != null) {
                progressDialog.dismiss();
                k12.this.c = null;
            }
            BaseActivity baseActivity = k12.this.a;
            if (baseActivity == null || baseActivity.isDestroyed()) {
                return;
            }
            k12 k12Var = k12.this;
            k12Var.c = ProgressDialog.show(k12Var.a, "", ah4.e(R.string.common_loading), true, true);
        }
    }

    /* compiled from: SongsControl.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressDialog progressDialog = k12.this.c;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            k12.this.c.dismiss();
            k12.this.c = null;
        }
    }

    /* compiled from: SongsControl.java */
    public class e implements nf3.d {
        public final /* synthetic */ boolean a;

        public e(boolean z) {
            this.a = z;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            if (this.a) {
                k12.this.e();
            }
            if (k12.p) {
                k12.this.x(false);
            } else {
                k12.q = false;
                EventBus.getDefault().post(new HomeMusicBean(6));
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class f implements nf3.d {
        public final /* synthetic */ nf3.d a;

        /* compiled from: SongsControl.java */
        public class a extends HashMap<String, String> {
            public final /* synthetic */ int val$itemSize;

            public a(int i) {
                this.val$itemSize = i;
                put("count", "" + i);
            }
        }

        public f(k12 k12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SpotifyTracks spotifyTracks;
            if (WearUtils.e1(str)) {
                spotifyTracks = null;
            } else {
                try {
                    spotifyTracks = (SpotifyTracks) new Gson().fromJson(str, SpotifyTracks.class);
                } catch (Exception unused) {
                }
            }
            if (spotifyTracks == null) {
                sg3.i(WearUtils.x, R.string.common_serverError);
                nf3.d dVar = this.a;
                if (dVar != null) {
                    k12.p = false;
                    dVar.onRequestComplete("false");
                    return;
                }
                return;
            }
            if (spotifyTracks.getItems() != null) {
                if (spotifyTracks.getItems().size() < 20) {
                    k12.p = false;
                } else {
                    k12.p = true;
                }
                if (k12.o <= 0) {
                    DaoUtils.getMusicSpotifyDao().deleteAll();
                }
                for (SpotifyTracks.ItemsBean itemsBean : spotifyTracks.getItems()) {
                    if (itemsBean.getTrack() != null) {
                        Music music = new Music();
                        music.setId(itemsBean.getTrack().getId());
                        music.setTitle(itemsBean.getTrack().getName());
                        StringBuilder sb = new StringBuilder();
                        sb.append(itemsBean.getTrack().getArtists().size() > 0 ? itemsBean.getTrack().getArtists().get(0).getName() : "");
                        sb.append(" - ");
                        sb.append(itemsBean.getTrack().getAlbum().getName());
                        music.setArtist(sb.toString());
                        music.setData(itemsBean.getTrack().getUri());
                        music.setDuration(itemsBean.getTrack().getDuration_ms());
                        if (itemsBean.getTrack().getAlbum().getImages() != null && itemsBean.getTrack().getAlbum().getImages().size() > 0) {
                            music.setImageUrl(itemsBean.getTrack().getAlbum().getImages().get(itemsBean.getTrack().getAlbum().getImages().size() - 1).getUrl());
                        }
                        music.setMusicType(1);
                        DaoUtils.getMusicSpotifyDao().addOrUpdate(k12.o, MusicSpotify.music2Spotify(music));
                        k12.o++;
                    }
                }
                WearUtils.x.q("music_spotify_music_count", new a(spotifyTracks.getItems().size()));
            }
            this.a.onRequestComplete("true");
            if (k12.o <= 20) {
                EventBus.getDefault().post(new HomeMusicBean(12));
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class g implements nf3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ nf3.d c;

        /* compiled from: SongsControl.java */
        public class a extends HashMap<String, String> {
            public final /* synthetic */ int val$itemSize;

            public a(int i) {
                this.val$itemSize = i;
                put("count", "" + i);
            }
        }

        public g(String str, boolean z, nf3.d dVar) {
            this.a = str;
            this.b = z;
            this.c = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SpotifyTracks spotifyTracks;
            if (WearUtils.e1(str)) {
                spotifyTracks = null;
            } else {
                try {
                    spotifyTracks = (SpotifyTracks) new Gson().fromJson(str, SpotifyTracks.class);
                } catch (Exception unused) {
                }
            }
            if (spotifyTracks == null) {
                sg3.i(WearUtils.x, R.string.common_serverError);
                nf3.d dVar = this.c;
                if (dVar != null) {
                    dVar.onRequestComplete("false");
                    return;
                }
                return;
            }
            if (WearUtils.e1(this.a) && !this.b) {
                k12.this.e.i.clear();
            }
            if (spotifyTracks.getItems() != null) {
                for (SpotifyTracks.ItemsBean itemsBean : spotifyTracks.getItems()) {
                    if (itemsBean.getTrack() != null) {
                        Music music = new Music();
                        music.setTitle(itemsBean.getTrack().getName());
                        StringBuilder sb = new StringBuilder();
                        sb.append(itemsBean.getTrack().getArtists().size() > 0 ? itemsBean.getTrack().getArtists().get(0).getName() : "");
                        sb.append(" - ");
                        sb.append(itemsBean.getTrack().getAlbum().getName());
                        music.setArtist(sb.toString());
                        music.setData(itemsBean.getTrack().getUri());
                        music.setDuration(itemsBean.getTrack().getDuration_ms());
                        if (itemsBean.getTrack().getAlbum().getImages() != null && itemsBean.getTrack().getAlbum().getImages().size() > 0) {
                            music.setImageUrl(itemsBean.getTrack().getAlbum().getImages().get(itemsBean.getTrack().getAlbum().getImages().size() - 1).getUrl());
                        }
                        music.setMusicType(1);
                        if (!this.b) {
                            k12.this.e.i.add(music);
                        }
                    }
                }
                WearUtils.x.q("music_spotify_music_count", new a(spotifyTracks.getItems().size()));
            }
            if (WearUtils.e1(spotifyTracks.getNext())) {
                k12.this.r(null, this.c, true);
            } else {
                k12.this.k(spotifyTracks.getNext(), this.c, this.b);
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class h implements nf3.d {
        public final /* synthetic */ MusicPlaylist a;
        public final /* synthetic */ nf3.d b;

        public h(MusicPlaylist musicPlaylist, nf3.d dVar) {
            this.a = musicPlaylist;
            this.b = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SearchSpotifyGroupAlbumTracks searchSpotifyGroupAlbumTracks;
            if (WearUtils.e1(str)) {
                searchSpotifyGroupAlbumTracks = null;
            } else {
                try {
                    searchSpotifyGroupAlbumTracks = (SearchSpotifyGroupAlbumTracks) new Gson().fromJson(str, SearchSpotifyGroupAlbumTracks.class);
                } catch (Exception unused) {
                }
            }
            if (searchSpotifyGroupAlbumTracks == null || searchSpotifyGroupAlbumTracks.getItems() == null) {
                sg3.i(WearUtils.x, R.string.common_serverError);
                nf3.d dVar = this.b;
                if (dVar != null) {
                    dVar.onRequestComplete("false");
                    return;
                }
                return;
            }
            for (SearchSpotifyGroupAlbumTracks.ItemsBean itemsBean : searchSpotifyGroupAlbumTracks.getItems()) {
                Music music = new Music();
                music.setTitle(itemsBean.getName());
                if (itemsBean.getArtists() != null && itemsBean.getArtists().size() > 0) {
                    music.setArtist(itemsBean.getArtists().get(0).getName() + " - " + itemsBean.getArtists().get(0).getType());
                }
                music.setData(itemsBean.getUri());
                music.setDuration(itemsBean.getDuration_ms());
                music.setMusicType(1);
                this.a.addPlaylistItemByMusicToList(music, WearUtils.y.r(), false, false);
            }
            if (!WearUtils.e1(searchSpotifyGroupAlbumTracks.getNext())) {
                k12.this.k(searchSpotifyGroupAlbumTracks.getNext(), this.b, true);
                return;
            }
            nf3.d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.onRequestComplete("true");
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class i implements nf3.d {
        public final /* synthetic */ MusicPlaylist a;
        public final /* synthetic */ nf3.d b;

        public i(MusicPlaylist musicPlaylist, nf3.d dVar) {
            this.a = musicPlaylist;
            this.b = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SpotifyTracks spotifyTracks;
            if (WearUtils.e1(str)) {
                spotifyTracks = null;
            } else {
                try {
                    spotifyTracks = (SpotifyTracks) new Gson().fromJson(str, SpotifyTracks.class);
                } catch (Exception unused) {
                }
            }
            if (spotifyTracks == null || spotifyTracks.getItems() == null || spotifyTracks.getItems().size() <= 0) {
                sg3.i(WearUtils.x, R.string.common_serverError);
                nf3.d dVar = this.b;
                if (dVar != null) {
                    dVar.onRequestComplete("false");
                    return;
                }
                return;
            }
            for (SpotifyTracks.ItemsBean itemsBean : spotifyTracks.getItems()) {
                if (itemsBean.getTrack() != null) {
                    Music music = new Music();
                    music.setTitle(itemsBean.getTrack().getName());
                    if (itemsBean.getTrack().getArtists() != null && itemsBean.getTrack().getArtists().size() > 0) {
                        music.setArtist(itemsBean.getTrack().getArtists().get(0).getName() + " - " + itemsBean.getTrack().getAlbum().getName());
                    }
                    music.setData(itemsBean.getTrack().getUri());
                    music.setDuration(itemsBean.getTrack().getDuration_ms());
                    if (itemsBean.getTrack().getAlbum().getImages().size() > 0) {
                        music.setImageUrl(itemsBean.getTrack().getAlbum().getImages().get(itemsBean.getTrack().getAlbum().getImages().size() - 1).getUrl());
                    }
                    music.setMusicType(1);
                    this.a.addPlaylistItemByMusicToList(music, WearUtils.y.r(), false, false);
                }
            }
            if (!WearUtils.e1(spotifyTracks.getNext())) {
                k12.this.k(spotifyTracks.getNext(), this.b, true);
                return;
            }
            nf3.d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.onRequestComplete("true");
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class j implements nf3.d {
        public final /* synthetic */ MusicPlaylist a;
        public final /* synthetic */ nf3.d b;

        public j(k12 k12Var, MusicPlaylist musicPlaylist, nf3.d dVar) {
            this.a = musicPlaylist;
            this.b = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SearchSpotifyGroupArtistTracks searchSpotifyGroupArtistTracks;
            if (WearUtils.e1(str)) {
                searchSpotifyGroupArtistTracks = null;
            } else {
                try {
                    searchSpotifyGroupArtistTracks = (SearchSpotifyGroupArtistTracks) new Gson().fromJson(str, SearchSpotifyGroupArtistTracks.class);
                } catch (Exception unused) {
                }
            }
            if (searchSpotifyGroupArtistTracks == null || searchSpotifyGroupArtistTracks.getTracks() == null) {
                sg3.i(WearUtils.x, R.string.common_serverError);
                nf3.d dVar = this.b;
                if (dVar != null) {
                    dVar.onRequestComplete("false");
                    return;
                }
                return;
            }
            for (SearchSpotifyGroupArtistTracks.TracksBean tracksBean : searchSpotifyGroupArtistTracks.getTracks()) {
                if (tracksBean != null) {
                    Music music = new Music();
                    music.setTitle(tracksBean.getName());
                    if (tracksBean.getArtists() != null && tracksBean.getArtists().size() > 0) {
                        music.setArtist(tracksBean.getArtists().get(0).getName() + " - " + tracksBean.getAlbum().getName());
                    }
                    music.setData(tracksBean.getUri());
                    music.setDuration(tracksBean.getDuration_ms());
                    music.setImageUrl(tracksBean.getAlbum().getImages().get(tracksBean.getAlbum().getImages().size() - 1).getUrl());
                    music.setMusicType(1);
                    this.a.addPlaylistItemByMusicToList(music, WearUtils.y.r(), false, false);
                }
            }
            nf3.d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.onRequestComplete("true");
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class k extends HashMap<String, String> {
        public k() {
            String str;
            if (k12.this.z() == null) {
                str = "0";
            } else {
                str = "" + k12.this.z().size();
            }
            put("count", str);
        }
    }

    /* compiled from: SongsControl.java */
    public class l implements nf3.d {

        /* compiled from: SongsControl.java */
        public class a implements nf3.d {
            public a(l lVar) {
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) {
                if (MyApplication.H() != null) {
                    jn3.a(MyApplication.H(), ah4.e(R.string.music_add_playlist_success), Integer.valueOf(R.drawable.pop_icon_success));
                }
            }
        }

        public l() {
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            if (WearUtils.e1(str)) {
                return;
            }
            Map map = (Map) WearUtils.A.fromJson(str, HashMap.class);
            Object obj = "";
            if (!WearUtils.e1(map == null ? "" : (String) map.get("snapshot_id"))) {
                k12.this.r(null, new a(this), false);
                return;
            }
            try {
                Map map2 = (Map) ((Map) WearUtils.A.fromJson(str, HashMap.class)).get("error");
                if (map2 != null) {
                    obj = map2.get("message");
                }
                String str2 = (String) obj;
                if (WearUtils.e1(str2)) {
                    return;
                }
                sg3.l(str2);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: SongsControl.java */
    public class m implements nf3.d {
        public final /* synthetic */ nf3.d a;

        /* compiled from: SongsControl.java */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(m mVar, String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                sg3.l(this.a);
            }
        }

        public m(k12 k12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            if (WearUtils.e1(str)) {
                return;
            }
            Map map = (Map) WearUtils.A.fromJson(str, HashMap.class);
            Object obj = "";
            if (!WearUtils.e1(map == null ? "" : (String) map.get("snapshot_id"))) {
                nf3.d dVar = this.a;
                if (dVar != null) {
                    dVar.onRequestComplete("true");
                    return;
                }
                return;
            }
            try {
                Map map2 = (Map) ((Map) WearUtils.A.fromJson(str, HashMap.class)).get("error");
                if (map2 != null) {
                    obj = map2.get("message");
                }
                String str2 = (String) obj;
                if (WearUtils.e1(str2)) {
                    return;
                }
                MyApplication.H().runOnUiThread(new a(this, str2));
            } catch (Exception unused) {
            }
        }
    }

    public List<MusicPlaylist> A() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.d.g);
        if (this.e.t()) {
            for (MusicPlaylist musicPlaylist : this.e.l) {
                if (musicPlaylist.getTracksUrl().contains("users/" + this.e.f)) {
                    arrayList.add(musicPlaylist);
                }
            }
        }
        return arrayList;
    }

    public void B(String str, Music music) {
        List<MergerMusic> listLoadMergerMusics = DaoUtils.getMergerMusicDao().loadMergerMusics(str, music.getMusicType() == 0 ? String.valueOf(music.getSongId()) : music.getData());
        if (listLoadMergerMusics == null || listLoadMergerMusics.size() <= 0) {
            return;
        }
        DaoUtils.getMergerMusicDao().delTs(listLoadMergerMusics);
    }

    public void C(String str, String str2, nf3.d dVar) {
        this.e.V(str, str2, new m(this, dVar));
    }

    public void D(f12.d dVar) {
        this.d.j(dVar);
    }

    public void E(String str, String str2, String str3, nf3.d dVar) {
        this.e.W(str, str2, str3, dVar);
    }

    public void F(String str, List<Music> list) {
        this.g = -1;
        this.l = str;
        this.i = list;
    }

    public void G(boolean z) {
        this.k = z;
    }

    public void H() {
        BaseActivity baseActivity = this.a;
        if (baseActivity == null) {
            return;
        }
        baseActivity.runOnUiThread(new c());
    }

    public MusicPlaylist I(MusicPlaylist musicPlaylist) {
        MusicPlaylist musicPlaylist2 = null;
        if (!WearUtils.e1(musicPlaylist.getId())) {
            Iterator<MusicPlaylist> it = this.d.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MusicPlaylist next = it.next();
                if (next.getId().equals(musicPlaylist.getId())) {
                    musicPlaylist2 = next;
                    break;
                }
            }
            if (musicPlaylist2 == null) {
                Iterator<MusicPlaylist> it2 = this.e.l.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    MusicPlaylist next2 = it2.next();
                    if (next2.getId().equals(musicPlaylist.getId())) {
                        musicPlaylist2 = next2;
                        break;
                    }
                }
            }
        }
        if (musicPlaylist2 != null) {
            for (MusicPlaylistItems musicPlaylistItems : musicPlaylist.getItemsList()) {
                Iterator<MusicPlaylistItems> it3 = musicPlaylist2.getItemsList().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        MusicPlaylistItems next3 = it3.next();
                        if (musicPlaylistItems.getId().equals(next3.getId())) {
                            next3.setSortId(musicPlaylistItems.getSortId());
                            break;
                        }
                    }
                }
            }
            if (musicPlaylist2.getItemsList().size() > 0) {
                try {
                    Collections.sort(musicPlaylist2.getItemsList());
                } catch (Exception unused) {
                }
            }
        }
        return musicPlaylist2;
    }

    public boolean b(MusicPlaylist musicPlaylist, Music music) {
        if (DaoUtils.getMergerMusicDao().isExistMergerMusic(musicPlaylist.getId(), music.getMusicType() == 0 ? String.valueOf(music.getSongId()) : music.getData())) {
            jn3.a(MyApplication.H(), ah4.e(R.string.music_already_exist_hint), Integer.valueOf(R.drawable.pop_icon_fail));
            return false;
        }
        musicPlaylist.addPlaylistItemByMusicToList(music, WearUtils.y.r(), false, WearUtils.e1(musicPlaylist.getTracksUrl()));
        musicPlaylist.setTotal(musicPlaylist.getTotal() + 1);
        DaoUtils.getMergerMusicDao().add((MergerMusicDao) new MergerMusic().createMergerMusic(musicPlaylist.getId(), music, WearUtils.y.r()));
        return true;
    }

    public void c(String str, String str2, String str3) {
        this.e.J(str2, str3, new l());
    }

    public void d(MusicPlaylist musicPlaylist, int i2) {
        String imageUrl;
        if (this.h == null) {
            return;
        }
        if (musicPlaylist.checkExistInList(WearUtils.e1(musicPlaylist.getTracksUrl()), this.h)) {
            jn3.a(MyApplication.H(), ah4.e(R.string.music_already_exist_hint), Integer.valueOf(R.drawable.pop_icon_fail));
            return;
        }
        if (WearUtils.e1(musicPlaylist.getTracksUrl())) {
            if (this.h.getMusicType() == 0) {
                if (i2 == 0) {
                    this.h.setIsFavorite(!r8.isFavorite());
                    if (this.d.g.get(0).getMusics().size() == 0) {
                        if (this.h.getMusicType() == 0) {
                            imageUrl = "content://media/external/audio/albumart/" + this.h.getAlbumId();
                        } else {
                            imageUrl = this.h.getImageUrl();
                        }
                        this.d.g.get(0).setCover(imageUrl);
                    }
                    this.d.g.get(0).addPlaylistItemByMusicToList(this.h, null, false, true);
                    DaoUtils.getMusicDao().update((MusicDao) this.h);
                } else {
                    musicPlaylist.addPlaylistItemByMusicToList(this.h, WearUtils.y.r(), true, true);
                }
            } else if (!b(musicPlaylist, this.h)) {
                return;
            }
            jn3.a(MyApplication.H(), ah4.e(R.string.music_add_playlist_success), Integer.valueOf(R.drawable.pop_icon_success));
        } else if (this.h.getMusicType() != 0) {
            c(musicPlaylist.getName(), musicPlaylist.getId(), this.h.getData());
        } else if (!b(musicPlaylist, this.h)) {
            return;
        } else {
            jn3.a(MyApplication.H(), ah4.e(R.string.music_add_playlist_success), Integer.valueOf(R.drawable.pop_icon_success));
        }
        WearUtils.x.q("music_playlist", new k());
        m.c();
        this.h = null;
        if (i2 != -1) {
            MusicControl.f fVar = this.j;
            if (fVar != null) {
                fVar.c(i2);
            }
            MusicControl.h0().Q(i12.a.d(i2));
        }
    }

    public void e() {
        BaseActivity baseActivity;
        if (this.c == null || (baseActivity = this.a) == null) {
            return;
        }
        baseActivity.runOnUiThread(new d());
    }

    public MusicPlaylist f(String str) {
        MusicPlaylist musicPlaylist = null;
        if (WearUtils.e1(str)) {
            return null;
        }
        Iterator<MusicPlaylist> it = this.d.g.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MusicPlaylist next = it.next();
            if (next.getId().equals(str)) {
                musicPlaylist = next;
                break;
            }
        }
        if (musicPlaylist != null) {
            return musicPlaylist;
        }
        for (MusicPlaylist musicPlaylist2 : this.e.l) {
            if (musicPlaylist2.getId().equals(str)) {
                return musicPlaylist2;
            }
        }
        return musicPlaylist;
    }

    public abstract void g();

    public boolean h(String str) {
        if (WearUtils.e1(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("users/");
        sb.append(this.e.f);
        return str.contains(sb.toString());
    }

    public boolean i() {
        Music music = this.f;
        return music == null || music.getMusicType() != 0;
    }

    public void k(String str, nf3.d dVar, boolean z) {
        this.e.N(str, new g(str, z, dVar));
    }

    public void l(String str, nf3.d dVar, boolean z) {
        this.e.N(str, new f(this, dVar));
    }

    public void m(MusicPlaylist musicPlaylist, String str, nf3.d dVar) {
        H();
        this.e.L(str, new b(musicPlaylist, dVar));
    }

    public void o(MusicPlaylist musicPlaylist, boolean z) {
        List<MergerMusic> listFindMergerMusicByPlaylistId = DaoUtils.getMergerMusicDao().findMergerMusicByPlaylistId(musicPlaylist.getId());
        if (listFindMergerMusicByPlaylistId != null) {
            for (MergerMusic mergerMusic : listFindMergerMusicByPlaylistId) {
                if (z) {
                    musicPlaylist.addPlaylistItemByMusicToList(mergerMusic.createStreamMusic(), null, false, true);
                    musicPlaylist.setTotal(musicPlaylist.getTotal() + 1);
                } else {
                    Music musicG = this.d.g(mergerMusic.getSongIdOrUri());
                    if (musicG != null) {
                        musicPlaylist.addPlaylistItemByMusicToList(mergerMusic.copyToMergerTypeMusic(musicG), WearUtils.y.r(), false, true);
                        musicPlaylist.setTotal(musicPlaylist.getTotal() + 1);
                    } else {
                        DaoUtils.getMergerMusicDao().delT(mergerMusic);
                    }
                }
            }
        }
    }

    public void r(String str, nf3.d dVar, boolean z) {
        this.e.M(str, new a(str, dVar, z));
    }

    public void s(MusicPlaylist musicPlaylist, String str, nf3.d dVar) {
        this.e.N(str, new h(musicPlaylist, dVar));
    }

    public void t(MusicPlaylist musicPlaylist, String str, nf3.d dVar) {
        this.e.N(str, new j(this, musicPlaylist, dVar));
    }

    public void u(SearchSpotifyAbstract searchSpotifyAbstract, MusicPlaylist musicPlaylist, String str, nf3.d dVar) {
        if (searchSpotifyAbstract instanceof SearchSpotifyArtists) {
            t(musicPlaylist, str, dVar);
            return;
        }
        if (searchSpotifyAbstract instanceof SearchSpotifyAlbums) {
            s(musicPlaylist, str, dVar);
            return;
        }
        if (searchSpotifyAbstract instanceof SearchSpotifyPlaylists) {
            v(musicPlaylist, str, dVar);
            return;
        }
        sg3.i(WearUtils.x, R.string.common_serverError);
        if (dVar != null) {
            dVar.onRequestComplete("false");
        }
    }

    public void v(MusicPlaylist musicPlaylist, String str, nf3.d dVar) {
        this.e.N(str, new i(musicPlaylist, dVar));
    }

    public void w(boolean z, boolean z2, boolean z3) {
        this.e.i.addAll(DaoUtils.getMusicSpotifyDao().findAllMusic());
        n = z3;
        if (this.b != null) {
            Message message = new Message();
            message.what = 4;
            message.obj = Boolean.FALSE;
            this.b.sendMessage(message);
        }
        if (!z2 || q) {
            return;
        }
        x(z2);
    }

    public void x(boolean z) {
        if (MainActivity.d0) {
            if (z) {
                o = 0;
            }
            String str = null;
            if (z) {
                p = true;
            } else if (o > 0) {
                str = "https://api.spotify.com/v1/me/tracks?offset=" + o + "&limit=20";
            }
            q = true;
            l(str, new e(false), z);
        }
    }

    public void y(boolean z) {
        m.i(z);
        MusicControl.f fVar = this.j;
        if (fVar != null) {
            fVar.e(z);
        }
    }

    public List<MusicPlaylist> z() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.d.g);
        if (this.e.t()) {
            arrayList.addAll(this.e.l);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            for (int i3 = 0; i3 < ((MusicPlaylist) arrayList.get(i2)).getItemsList().size(); i3++) {
                ((MusicPlaylist) arrayList.get(i2)).getItemsList().get(i3).getMusic().setFuncType(3);
            }
        }
        return arrayList;
    }
}
