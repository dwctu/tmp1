package com.wear.dao;

import com.wear.bean.Music;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MusicDao extends BaseDao<Music> {
    public List<Music> findMusicSongIdBy(String str) {
        try {
            return this.dao.queryBuilder().orderBy("songId", true).where().eq("songId", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
