package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_merger_music")
/* loaded from: classes3.dex */
public class MergerMusic extends BaseEntity {

    @DatabaseField
    private String artist;

    @DatabaseField
    private String data;

    @DatabaseField
    private int duration;

    @DatabaseField
    private String email;

    @DatabaseField
    private String imageUrl;

    @DatabaseField
    private int musicType = 0;

    @DatabaseField
    private String playlistId;

    @DatabaseField
    private String songIdOrUri;

    @DatabaseField
    private String title;

    public MergerMusic() {
    }

    public Music copyToMergerTypeMusic(Music music) {
        Music music2 = new Music();
        music2.setSongId(music.getSongId());
        music2.setTitle(music.getTitle());
        music2.setAlbumId(music.getAlbumId());
        music2.setIsFavorite(music.isFavorite());
        music2.setArtist(music.getArtist());
        music2.setData(music.getData());
        music2.setDuration(music.getDuration());
        music2.setImageUrl(music.getImageUrl());
        music2.setMusicType(music.getMusicType());
        music2.setMergerType(1);
        return music2;
    }

    public MergerMusic createMergerMusic(String str, Music music, String str2) {
        this.playlistId = str;
        this.musicType = music.getMusicType();
        setEmail(str2);
        if (music.getMusicType() == 0) {
            this.songIdOrUri = String.valueOf(music.getSongId());
        } else {
            this.songIdOrUri = music.getData();
            this.title = music.getTitle();
            this.artist = music.getArtist();
            this.data = music.getData();
            this.duration = music.getDuration();
            this.imageUrl = music.getImageUrl();
        }
        return this;
    }

    public Music createStreamMusic() {
        Music music = new Music();
        music.setTitle(this.title);
        music.setArtist(this.artist);
        music.setData(this.data);
        music.setDuration(this.duration);
        music.setImageUrl(this.imageUrl);
        music.setMusicType(1);
        music.setMergerType(1);
        return music;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getData() {
        return this.data;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public String getOldEmail() {
        return this.email;
    }

    public String getPlaylistId() {
        return this.playlistId;
    }

    public String getSongIdOrUri() {
        return this.songIdOrUri;
    }

    public String getTitle() {
        return this.title;
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

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public void setPlaylistId(String str) {
        this.playlistId = str;
    }

    public void setSongIdOrUri(String str) {
        this.songIdOrUri = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public MergerMusic(String str, String str2) {
        this.playlistId = str;
        this.songIdOrUri = str2;
    }
}
