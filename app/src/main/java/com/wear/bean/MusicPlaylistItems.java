package com.wear.bean;

import androidx.annotation.NonNull;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_music_playlist_items")
/* loaded from: classes3.dex */
public class MusicPlaylistItems extends BaseEntity implements Comparable<MusicPlaylistItems> {

    @DatabaseField
    private String email;
    private Music music;
    private int musicType = 0;

    @DatabaseField
    private String playlistId;

    @DatabaseField
    private String songId;

    @DatabaseField
    private int sortId;

    public MusicPlaylistItems() {
        setId(WearUtils.E());
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public Music getMusic() {
        return this.music;
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

    public String getSongId() {
        return this.songId;
    }

    public int getSortId() {
        return this.sortId;
    }

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public void setPlaylistId(String str) {
        this.playlistId = str;
    }

    public void setSongId(String str) {
        this.songId = str;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    @Override // java.lang.Comparable
    public synchronized int compareTo(@NonNull MusicPlaylistItems musicPlaylistItems) {
        if (getSortId() == musicPlaylistItems.getSortId()) {
            return 0;
        }
        if (getSortId() > musicPlaylistItems.getSortId()) {
            return 1;
        }
        return getSortId() < musicPlaylistItems.getSortId() ? -1 : 0;
    }

    public MusicPlaylistItems(String str) {
        setId(str);
    }
}
