package dc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.lovense.wear.R;
import com.spotify.sdk.android.player.Connectivity;
import com.spotify.sdk.android.player.Error;
import com.spotify.sdk.android.player.Metadata;
import com.spotify.sdk.android.player.PlaybackState;
import com.spotify.sdk.android.player.Player;
import com.spotify.sdk.android.player.PlayerEvent;
import com.spotify.sdk.android.player.PlayerOperationCallback;
import com.spotify.sdk.android.player.Spotify;
import com.spotify.sdk.android.player.SpotifyPlayer;
import com.spotify.sdk.android.player.SpotifyTrack;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.event.SpotifyPlayEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.i12;
import dc.nf3;
import dc.yc4;
import java.io.IOException;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: SpotifyMusicUtils.java */
/* loaded from: classes3.dex */
public class m12 extends l12 implements Player.NotificationCallback {
    public PlaybackState v;
    public BroadcastReceiver w;
    public Metadata x;

    /* compiled from: SpotifyMusicUtils.java */
    public class a implements bc4 {
        public final /* synthetic */ nf3.d a;

        public a(m12 m12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            System.out.println("Failed to fetch data: " + iOException);
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete(ad4Var.b().string());
            }
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class b implements bc4 {
        public final /* synthetic */ nf3.d a;

        public b(m12 m12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete("");
            }
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete(ad4Var.b().string());
            }
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m12.this.i = DaoUtils.getMusicSpotifyDao().findAllMusic();
            EventBus.getDefault().post(new HomeMusicBean(11));
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            m12 m12Var = m12.this;
            if (m12Var.h != null) {
                Connectivity connectivityQ = m12Var.q(k12.m.b());
                String str = "Network state changed: " + connectivityQ.toString();
                m12 m12Var2 = m12.this;
                PlayerOperationCallback playerOperationCallback = m12Var2.d;
                playerOperationCallback.operation = "setConnectivityStatus";
                m12Var2.h.setConnectivityStatus(playerOperationCallback, connectivityQ);
            }
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class e implements Runnable {
        public e(m12 m12Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            MusicControl.h0().b0();
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class f implements bc4 {
        public final /* synthetic */ nf3.d a;

        public f(m12 m12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            System.out.println("Failed to fetch data: " + iOException);
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete(ad4Var.b().string());
            }
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class g implements bc4 {
        public final /* synthetic */ nf3.d a;

        public g(m12 m12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            System.out.println("Failed to fetch data: " + iOException);
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete(ad4Var.b().string());
            }
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class h implements bc4 {
        public final /* synthetic */ nf3.d a;

        public h(m12 m12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            System.out.println("Failed to fetch data: " + iOException);
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete(ad4Var.b().string());
            }
        }
    }

    /* compiled from: SpotifyMusicUtils.java */
    public class i implements bc4 {
        public final /* synthetic */ nf3.d a;

        public i(m12 m12Var, nf3.d dVar) {
            this.a = dVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            System.out.println("Failed to fetch data: " + iOException);
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            nf3.d dVar = this.a;
            if (dVar != null) {
                dVar.onRequestComplete(ad4Var.b().string());
            }
        }
    }

    public m12(MyApplication myApplication) {
        this.a = myApplication;
        this.b = new so3();
    }

    @Override // dc.l12
    public void B(String str) {
        if (!S(true)) {
            MusicControl.h0().N();
        }
        MusicControl.h0().m0();
        String str2 = "Starting playback for " + str;
        if (this.h == null) {
            A();
            return;
        }
        if (!O() || !u()) {
            sg3.i(k12.m.b(), R.string.spotify_premium_supported);
        }
        PlayerOperationCallback playerOperationCallback = this.d;
        playerOperationCallback.operation = "playUri";
        l12.u = true;
        this.h.playUri(playerOperationCallback, str, 0, 0);
    }

    public void I() {
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer != null) {
            spotifyPlayer.addNotificationCallback(this);
            this.h.addConnectionStateCallback(this);
        }
    }

    public void J(String str, String str2, nf3.d dVar) {
        zc4 zc4VarCreate = zc4.create(tc4.d("application/json; charset=utf-8"), "{\"uris\": [\"" + str2 + "\"]}");
        yc4.a aVar = new yc4.a();
        aVar.k("https://api.spotify.com/v1/users/" + this.f + "/playlists/" + str + "/tracks");
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(this.e);
        aVar.a(HttpHeaders.AUTHORIZATION, sb.toString());
        aVar.h(zc4VarCreate);
        yc4 yc4VarB = aVar.b();
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new g(this, dVar));
    }

    public void K() {
        HashMap map = new HashMap();
        this.j.clear();
        HashMap map2 = new HashMap();
        this.k.clear();
        for (Music music : this.i) {
            String[] strArrSplit = music.getArtist().split(Constants.FILENAME_SEQUENCE_SEPARATOR);
            String strTrim = strArrSplit.length > 0 ? strArrSplit[0].trim() : "";
            String strTrim2 = strArrSplit.length > 1 ? strArrSplit[1].trim() : "";
            if (map.containsKey(strTrim)) {
                ((MusicPlaylist) map.get(strTrim)).addPlaylistItemByMusicToList(music, null, false, true);
            } else {
                MusicPlaylist musicPlaylist = new MusicPlaylist();
                musicPlaylist.setStreamMusic(true);
                musicPlaylist.setName(strTrim);
                musicPlaylist.setCover(music.getImageUrl());
                musicPlaylist.addPlaylistItemByMusicToList(music, null, false, true);
                this.j.add(musicPlaylist);
                map.put(strTrim, musicPlaylist);
            }
            if (map2.containsKey(music.getAlbum())) {
                ((MusicPlaylist) map2.get(strTrim2)).addPlaylistItemByMusicToList(music, null, false, true);
            } else {
                MusicPlaylist musicPlaylist2 = new MusicPlaylist();
                musicPlaylist2.setStreamMusic(true);
                musicPlaylist2.setNotice(strTrim);
                musicPlaylist2.setName(strTrim2);
                musicPlaylist2.setCover(music.getImageUrl());
                musicPlaylist2.addPlaylistItemByMusicToList(music, null, false, true);
                this.k.add(musicPlaylist2);
                map2.put(strTrim2, musicPlaylist2);
            }
        }
        map.clear();
        map2.clear();
    }

    public void L(String str, nf3.d dVar) {
        yc4.a aVar = new yc4.a();
        aVar.k(str);
        aVar.a(HttpHeaders.AUTHORIZATION, "Bearer " + this.e);
        yc4 yc4VarB = aVar.b();
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new i(this, dVar));
    }

    public void M(String str, nf3.d dVar) {
        yc4.a aVar = new yc4.a();
        if (WearUtils.e1(str)) {
            str = "https://api.spotify.com/v1/users/" + this.f + "/playlists";
        }
        aVar.k(str);
        aVar.a(HttpHeaders.AUTHORIZATION, "Bearer " + this.e);
        yc4 yc4VarB = aVar.b();
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new f(this, dVar));
    }

    public void N(String str, nf3.d dVar) {
        yc4.a aVar = new yc4.a();
        aVar.k(WearUtils.e1(str) ? "https://api.spotify.com/v1/me/tracks" : str);
        aVar.a(HttpHeaders.AUTHORIZATION, "Bearer " + this.e);
        yc4 yc4VarB = aVar.b();
        String str2 = "getTrackSongs: " + str;
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new a(this, dVar));
    }

    public boolean O() {
        return !WearUtils.e1(this.f);
    }

    public boolean P() {
        PlaybackState playbackState;
        return (this.h == null || (playbackState = this.v) == null || !playbackState.isPlaying) ? false : true;
    }

    public void Q() {
        if (!MainActivity.d0 || this.i.size() > 0) {
            return;
        }
        vg3.b().a(new c());
    }

    public void R() {
        try {
            if (this.w != null) {
                k12.m.b().unregisterReceiver(this.w);
            }
            this.w = null;
        } catch (Exception unused) {
        }
    }

    public boolean S(boolean z) {
        PlaybackState playbackState = this.v;
        boolean z2 = true;
        if (playbackState == null || !playbackState.isPlaying) {
            WearUtils.x.k.isMusicActive();
            SpotifyPlayer spotifyPlayer = this.h;
            if (spotifyPlayer != null) {
                PlayerOperationCallback playerOperationCallback = this.d;
                playerOperationCallback.operation = StreamManagement.Resume.ELEMENT;
                spotifyPlayer.resume(playerOperationCallback);
            }
            MusicControl.h0().A0(false);
            if (MusicControl.h0().j != null) {
                MusicControl.h0().j.e(false);
            }
            MusicControl.h0().N();
        } else {
            SpotifyPlayer spotifyPlayer2 = this.h;
            if (spotifyPlayer2 != null) {
                PlayerOperationCallback playerOperationCallback2 = this.d;
                playerOperationCallback2.operation = "pause";
                spotifyPlayer2.pause(playerOperationCallback2);
            }
            MusicControl.h0().A0(true);
            if (MusicControl.h0().j != null) {
                MusicControl.h0().j.e(true);
            }
            MusicControl.h0().K();
            MusicControl.h0().b0();
            MusicControl.h0().b.postDelayed(new e(this), 1000L);
            z2 = false;
        }
        if (MusicControl.h0().j != null) {
            MusicControl.h0().j.c(MusicControl.h0().g);
        }
        MusicControl.h0().Q(i12.a.d(MusicControl.h0().g));
        return z2;
    }

    public void T() {
        this.w = new d();
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= 33) {
            k12.m.b().registerReceiver(this.w, intentFilter, 2);
        } else {
            k12.m.b().registerReceiver(this.w, intentFilter);
        }
    }

    public void U() {
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer != null) {
            spotifyPlayer.refreshCache();
        }
    }

    public void V(String str, String str2, nf3.d dVar) {
        zc4 zc4VarCreate = zc4.create(tc4.d("application/json; charset=utf-8"), "{\"tracks\":[{\"uri\":\"" + str2 + "\"}]}");
        yc4.a aVar = new yc4.a();
        aVar.k("https://api.spotify.com/v1/users/" + this.f + "/playlists/" + str + "/tracks");
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(this.e);
        aVar.a(HttpHeaders.AUTHORIZATION, sb.toString());
        aVar.c(zc4VarCreate);
        yc4 yc4VarB = aVar.b();
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new h(this, dVar));
    }

    public void W(String str, String str2, String str3, nf3.d dVar) {
        yc4.a aVar = new yc4.a();
        if (WearUtils.e1(str)) {
            str = "https://api.spotify.com/v1/search?q=" + Uri.encode(str2) + "&type=" + str3;
        }
        aVar.k(str);
        aVar.a(HttpHeaders.AUTHORIZATION, "Bearer " + this.e);
        yc4 yc4VarB = aVar.b();
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new b(this, dVar));
    }

    public void X(int i2) {
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer != null) {
            PlayerOperationCallback playerOperationCallback = this.d;
            playerOperationCallback.operation = "seekToPosition";
            spotifyPlayer.seekToPosition(playerOperationCallback, i2);
        }
    }

    public void Y() {
        SpotifyPlayer spotifyPlayer;
        PlaybackState playbackState = this.v;
        if (playbackState == null || !playbackState.isPlaying || (spotifyPlayer = this.h) == null) {
            return;
        }
        PlayerOperationCallback playerOperationCallback = this.d;
        playerOperationCallback.operation = "pause";
        spotifyPlayer.pause(playerOperationCallback);
    }

    @Override // com.spotify.sdk.android.player.Player.NotificationCallback
    public void onPlaybackError(Error error) {
        String str = " Error 0.0: " + error;
    }

    @Override // com.spotify.sdk.android.player.Player.NotificationCallback
    public void onPlaybackEvent(PlayerEvent playerEvent) throws IllegalStateException {
        ff3 ff3Var;
        String str = " Event: " + playerEvent;
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer == null) {
            return;
        }
        this.v = spotifyPlayer.getPlaybackState();
        this.x = this.h.getMetadata();
        String str2 = "Player state: " + this.v;
        EventBus.getDefault().post(new SpotifyPlayEvent(playerEvent, this.v));
        String str3 = "Metadata: " + this.x + " playerEvent.name()=" + playerEvent.name();
        System.out.println("PlayerEvent.playerEvent.name()=>" + playerEvent.name() + this.v.isActiveDevice);
        if (playerEvent == PlayerEvent.kSpPlaybackEventAudioFlush && t()) {
            if (MusicControl.h0().i()) {
                this.b.G();
                this.b.B(SpotifyTrack.getAudioSessionId(), this.c);
                if (MusicControl.h0().j != null) {
                    MusicControl.h0().j.c(MusicControl.h0().g);
                }
                MusicControl.h0().Q(i12.a.d(MusicControl.h0().g));
                MusicControl.h0().n0();
                return;
            }
            return;
        }
        PlayerEvent playerEvent2 = PlayerEvent.kSpPlaybackNotifyPause;
        if (playerEvent != playerEvent2 && playerEvent != PlayerEvent.kSpPlaybackNotifyPlay) {
            if (playerEvent == PlayerEvent.kSpPlaybackNotifyAudioDeliveryDone) {
                ff3 ff3Var2 = this.c;
                if (ff3Var2 != null) {
                    ff3Var2.b(true, -1);
                    return;
                }
                return;
            }
            if (playerEvent != PlayerEvent.kSpPlaybackNotifyLostPermission || (ff3Var = this.c) == null) {
                return;
            }
            ff3Var.a();
            return;
        }
        if (playerEvent == playerEvent2) {
            so3 so3Var = this.b;
            if (so3Var != null) {
                so3Var.u();
            }
        } else {
            so3 so3Var2 = this.b;
            if (so3Var2 != null) {
                so3Var2.l();
            }
        }
        l12.u = false;
        if (MusicControl.h0().j != null) {
            MusicControl.h0().j.c(MusicControl.h0().g);
        }
        MusicControl.h0().Q(i12.a.d(MusicControl.h0().g));
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() == 1) {
            MusicControl.h0().y(playerEvent == playerEvent2);
            EventBus.getDefault().post(new HomeMusicBean(7));
            if (playerEvent == PlayerEvent.kSpPlaybackNotifyPlay) {
                WearUtils.x.q("spotifyMusci_play", null);
                MusicControl.h0().Q(i12.a.f());
                MusicControl.h0().Q(i12.a.g(1));
            }
        }
    }

    @Override // dc.l12
    public void z() {
        Spotify.destroyPlayer(this);
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer != null) {
            spotifyPlayer.removeNotificationCallback(this);
            this.h.removeConnectionStateCallback(this);
        }
        this.h = null;
    }
}
