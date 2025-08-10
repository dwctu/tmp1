package com.wear.backgroundservice.service;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.RemoteController;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.support.v4.media.MediaMetadataCompat;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.vending.expansion.downloader.Constants;
import com.lovense.wear.R;
import com.wear.bean.SongInformation;
import dc.be3;
import dc.k;
import dc.l43;
import dc.rd3;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MediaControllerService extends NotificationListenerService implements RemoteController.OnClientUpdateListener, l43 {
    public static final String f = MediaControllerService.class.getName();
    public SongInformation a = null;
    public int b = 0;
    public List<MediaController> c;
    public MediaController.Callback d;
    public RemoteController e;

    public class a implements MediaSessionManager.OnActiveSessionsChangedListener {
        public a(MediaControllerService mediaControllerService) {
        }

        @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
        public void onActiveSessionsChanged(@Nullable List<MediaController> list) {
            Iterator<MediaController> it = list.iterator();
            while (it.hasNext()) {
                it.next().getPackageName();
            }
        }
    }

    public class b extends MediaController.Callback {
        public b() {
        }

        @Override // android.media.session.MediaController.Callback
        @RequiresApi(api = 26)
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            if (mediaMetadata != null) {
                String string = mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_TITLE);
                String string2 = mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ARTIST);
                mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST);
                mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
                long j = mediaMetadata.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER);
                long j2 = mediaMetadata.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER);
                long j3 = mediaMetadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI);
                mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ART_URI);
                Bitmap bitmap = mediaMetadata.getBitmap(MediaMetadataCompat.METADATA_KEY_ART);
                Bitmap bitmap2 = mediaMetadata.getBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                SongInformation songInformation = MediaControllerService.this.a;
                if (songInformation == null || songInformation.getDiscNumber() <= 0 || MediaControllerService.this.a.getDiscNumber() != j2 || MediaControllerService.this.a.getTrackNumber() <= 0 || MediaControllerService.this.a.getTrackNumber() != j) {
                    if (string2 != null && string2.contains(Constants.FILENAME_SEQUENCE_SEPARATOR)) {
                        String[] strArrSplit = string2.split(Constants.FILENAME_SEQUENCE_SEPARATOR);
                        if (strArrSplit.length > 1) {
                            string = strArrSplit[0];
                            string2 = strArrSplit[1];
                        }
                    }
                    SongInformation songInformation2 = new SongInformation();
                    songInformation2.setTitle(string);
                    songInformation2.setArtist(string2);
                    if (bitmap != null) {
                        songInformation2.setBitmap(bitmap);
                    } else if (bitmap2 != null) {
                        songInformation2.setBitmap(bitmap2);
                    }
                    try {
                        songInformation2.setDuration(k.a(j3));
                    } catch (ArithmeticException unused) {
                        songInformation2.setDuration(0);
                    }
                    songInformation2.setAlbumId(-1L);
                    songInformation2.setMusicType(2);
                    songInformation2.setDiscNumber(j2);
                    songInformation2.setTrackNumber(j);
                    rd3.f().r(songInformation2);
                    MediaControllerService.this.a = songInformation2;
                }
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            String unused = MediaControllerService.f;
            String str = "onPlaybackStateChanged:" + playbackState.getState();
            if (playbackState != null) {
                MediaControllerService.this.b = playbackState.getState();
                boolean z = playbackState.getState() == 3;
                if (MediaControllerService.this.b == 3) {
                    return;
                }
                if (z) {
                    if (be3.x() - rd3.f().j() > 500) {
                        rd3.f().E(be3.x());
                        rd3.f().q(z);
                        return;
                    }
                    return;
                }
                if (be3.x() - rd3.f().d() > 500) {
                    rd3.f().w(be3.x());
                    rd3.f().q(z);
                }
            }
        }
    }

    public final void b() {
        stopForeground(true);
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1009);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c() {
        MediaSessionManager mediaSessionManager = (MediaSessionManager) getSystemService("media_session");
        ComponentName componentName = new ComponentName(this, (Class<?>) MediaControllerService.class);
        mediaSessionManager.addOnActiveSessionsChangedListener(new a(this), componentName);
        synchronized (this) {
            this.c = mediaSessionManager.getActiveSessions(componentName);
            e();
        }
    }

    public void d() throws IllegalArgumentException {
        boolean zRegisterRemoteController;
        this.e = new RemoteController(this, this);
        try {
            zRegisterRemoteController = ((AudioManager) getSystemService("audio")).registerRemoteController(this.e);
        } catch (NullPointerException unused) {
            zRegisterRemoteController = false;
        }
        if (zRegisterRemoteController) {
            try {
                this.e.setArtworkConfiguration(100, 100);
                this.e.setSynchronizationMode(1);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 21) {
            for (MediaController mediaController : this.c) {
                if (this.d == null) {
                    this.d = new b();
                }
                mediaController.registerCallback(this.d);
            }
        }
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientChange(boolean z) {
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientMetadataUpdate(RemoteController.MetadataEditor metadataEditor) {
        String string = metadataEditor.getString(2, "");
        metadataEditor.getString(1, "");
        String string2 = metadataEditor.getString(7, "");
        long j = metadataEditor.getLong(9, -1L);
        Bitmap bitmap = metadataEditor.getBitmap(100, BitmapFactory.decodeResource(getResources(), R.drawable.content_icon_music_cover));
        long j2 = metadataEditor.getLong(0, 0L);
        long j3 = metadataEditor.getLong(14, 0L);
        SongInformation songInformation = this.a;
        if (songInformation != null && string2 != null) {
            if (songInformation.getTitle() != null && this.a.getArtist() != null && this.a.getTitle().equals(string2) && this.a.getArtist().equals(string)) {
                return;
            }
            if (this.a.getDiscNumber() > 0 && this.a.getDiscNumber() == j3 && this.a.getTrackNumber() > 0 && this.a.getTrackNumber() == j2) {
                return;
            }
        }
        if (string != null && string.contains(Constants.FILENAME_SEQUENCE_SEPARATOR)) {
            String[] strArrSplit = string.split(Constants.FILENAME_SEQUENCE_SEPARATOR);
            if (strArrSplit.length > 1) {
                string2 = strArrSplit[0];
                string = strArrSplit[1];
            }
        }
        SongInformation songInformation2 = new SongInformation();
        songInformation2.setTitle(string2);
        songInformation2.setArtist(string);
        if (bitmap != null) {
            songInformation2.setBitmap(bitmap);
        }
        try {
            songInformation2.setDuration(Integer.parseInt(String.valueOf(j)));
        } catch (Exception unused) {
            songInformation2.setDuration(0);
        }
        songInformation2.setAlbumId(-1L);
        songInformation2.setMusicType(2);
        songInformation2.setDiscNumber(j3);
        songInformation2.setTrackNumber(j2);
        songInformation2.setFuncType(1);
        rd3.f().r(songInformation2);
        this.a = songInformation2;
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientPlaybackStateUpdate(int i) {
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientPlaybackStateUpdate(int i, long j, long j2, float f2) {
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public void onClientTransportControlUpdate(int i) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        rd3.f().F(this);
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) throws IllegalArgumentException {
        if (rd3.m(this)) {
            c();
            d();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
