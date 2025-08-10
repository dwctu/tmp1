package com.wear.bean;

import android.content.Context;
import android.graphics.Bitmap;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dc.ef3;
import org.slf4j.helpers.MessageFormatter;

@DatabaseTable(tableName = "tb_music")
/* loaded from: classes3.dex */
public class Music extends BaseEntity {

    @DatabaseField
    private String album;

    @DatabaseField
    private long albumId;

    @DatabaseField
    private String artist;
    private Bitmap bitmap;
    private Bitmap cover;

    @DatabaseField
    private String data;

    @DatabaseField
    private int duration;
    private String imageUrl;

    @DatabaseField
    private boolean isFavorite;

    @DatabaseField
    private long songId;

    @DatabaseField
    private String title;
    private int musicType = 0;
    private int mergerType = 0;
    private int funcType = 0;

    public Music() {
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

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getData() {
        return this.data;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFuncType() {
        return this.funcType;
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

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setFuncType(int i) {
        this.funcType = i;
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

    public String toString() {
        return "Music{songId=" + this.songId + ", albumId=" + this.albumId + ", title='" + this.title + "', artist='" + this.artist + "', duration=" + this.duration + ", data='" + this.data + "', isFavorite=" + this.isFavorite + ", album='" + this.album + "', imageUrl='" + this.imageUrl + "', musicType=" + this.musicType + ", mergerType=" + this.mergerType + ", cover=" + this.cover + ", funcType=" + this.funcType + MessageFormatter.DELIM_STOP;
    }

    public Music(long j, long j2) {
        this.songId = j;
        this.albumId = j2;
        setId(j + "--" + j2);
    }
}
