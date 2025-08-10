package com.wear.dao;

import com.wear.bean.Music;
import com.wear.bean.MusicSpotify;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MusicSpotifyDao extends BaseDao<MusicSpotify> {
    public void addOrUpdate(long j, MusicSpotify musicSpotify) {
        try {
            this.dao.createOrUpdate(musicSpotify);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long countOf() {
        try {
            return this.dao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void deleteAll() {
        try {
            this.dao.executeRawNoArgs("delete from tb_music_spotify");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Music> findAllMusic() {
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                List listFindAll = super.findAll();
                if (listFindAll != null && listFindAll.size() > 0) {
                    Iterator it = listFindAll.iterator();
                    while (it.hasNext()) {
                        arrayList.add(MusicSpotify.spotify2Music((MusicSpotify) it.next()));
                    }
                }
                sb = new StringBuilder();
            } catch (Exception e) {
                e.printStackTrace();
                sb = new StringBuilder();
            }
        } catch (Throwable unused) {
            sb = new StringBuilder();
        }
        sb.append("findAllMusic 耗时:");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb.toString();
        return arrayList;
    }

    public List<MusicSpotify> findMusicSongIdBy(String str) {
        try {
            return this.dao.queryBuilder().orderBy("songId", true).where().eq("songId", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
