package com.wear.bean;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.RequiresApi;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.ef3;
import dc.nd3;
import java.util.Objects;

@DatabaseTable(tableName = "tb_music_spotify")
/* loaded from: classes3.dex */
public class MusicSpotify extends BaseEntity {

    @DatabaseField
    private String album;

    @DatabaseField
    private long albumId;

    @DatabaseField
    private String artist;
    private Bitmap cover;

    @DatabaseField
    private String data;

    @DatabaseField
    private int duration;

    @DatabaseField
    private String imageUrl;

    @DatabaseField
    private boolean isFavorite;

    @DatabaseField
    private long songId;

    @DatabaseField
    private String title;

    @DatabaseField
    private int musicType = 0;
    private int mergerType = 0;

    public MusicSpotify() {
    }

    public static MusicSpotify music2Spotify(Music music) {
        MusicSpotify musicSpotify = new MusicSpotify();
        if (music != null) {
            musicSpotify.setId(music.getId());
            musicSpotify.setSongId(music.getSongId());
            musicSpotify.setAlbumId(music.getAlbumId());
            musicSpotify.setTitle(music.getTitle());
            musicSpotify.setArtist(music.getArtist());
            musicSpotify.setDuration(music.getDuration());
            musicSpotify.setData(music.getData());
            musicSpotify.setIsFavorite(music.isFavorite());
            musicSpotify.setAlbum(music.getAlbum());
            musicSpotify.setImageUrl(music.getImageUrl());
            musicSpotify.setMusicType(music.getMusicType());
        }
        return musicSpotify;
    }

    public static Music spotify2Music(MusicSpotify musicSpotify) {
        Music music = new Music();
        if (musicSpotify != null) {
            music.setId(musicSpotify.getId());
            music.setSongId(musicSpotify.getSongId());
            music.setAlbumId(musicSpotify.getAlbumId());
            music.setTitle(musicSpotify.getTitle());
            music.setArtist(musicSpotify.getArtist());
            music.setDuration(musicSpotify.getDuration());
            music.setData(musicSpotify.getData());
            music.setIsFavorite(musicSpotify.isFavorite());
            music.setAlbum(musicSpotify.getAlbum());
            music.setImageUrl(musicSpotify.getImageUrl());
            music.setMusicType(musicSpotify.getMusicType());
        }
        return music;
    }

    @RequiresApi(api = 19)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MusicSpotify musicSpotify = (MusicSpotify) obj;
        return this.songId == musicSpotify.songId && this.albumId == musicSpotify.albumId && this.duration == musicSpotify.duration && this.isFavorite == musicSpotify.isFavorite && this.musicType == musicSpotify.musicType && this.mergerType == musicSpotify.mergerType && Objects.equals(this.title, musicSpotify.title) && Objects.equals(this.artist, musicSpotify.artist) && Objects.equals(this.data, musicSpotify.data) && Objects.equals(this.album, musicSpotify.album) && Objects.equals(this.imageUrl, musicSpotify.imageUrl);
    }

    public String getAlbum() {
        return this.album;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public String getArtist() {
        return this.artist;
    }

    public Bitmap getArtistCover(Context context) {
        if (this.cover == null) {
            this.cover = ef3.a(context, this.songId, this.albumId, true);
        }
        return this.cover;
    }

    public String getData() {
        return this.data;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override // com.wear.bean.BaseEntity
    public String getId() {
        String strF = nd3.f(super.getId());
        return WearUtils.e1(strF) ? super.getId() : strF;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMergerType() {
        return this.mergerType;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public long getSongId() {
        return this.songId;
    }

    public String getTitle() {
        return this.title;
    }

    @RequiresApi(api = 19)
    public int hashCode() {
        return Objects.hash(Long.valueOf(this.songId), Long.valueOf(this.albumId), this.title, this.artist, Integer.valueOf(this.duration), this.data, Boolean.valueOf(this.isFavorite), this.album, this.imageUrl, Integer.valueOf(this.musicType), Integer.valueOf(this.mergerType));
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setIsFavorite(boolean z) {
        this.isFavorite = z;
    }

    public void setMergerType(int i) {
        this.mergerType = i;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public void setSongId(long j) {
        this.songId = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public MusicSpotify(long j, long j2) {
        this.songId = j;
        this.albumId = j2;
        setId(j + "--" + j2);
    }
}
