package com.wear.dao;

import com.j256.ormlite.stmt.QueryBuilder;
import com.wear.bean.MergerMusic;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MergerMusicDao extends BaseDao<MergerMusic> {
    public MergerMusic findLastMergerMusic(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.orderBy("created", false);
            queryBuilder.where().eq("playlistId", str).and().eq("songIdOrUri", str2);
            return (MergerMusic) this.dao.queryForFirst(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MergerMusic> findMergerMusicByPlaylistId(String str) {
        try {
            return this.dao.queryBuilder().orderBy("created", true).where().eq("playlistId", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<MergerMusic> findMergerMusicBySongId(String str) {
        try {
            return this.dao.queryBuilder().orderBy("created", true).where().eq("songIdOrUri", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public boolean isExistMergerMusic(String str, String str2) {
        try {
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("playlistId", str).and().eq("songIdOrUri", str2).query();
            if (listQuery != null) {
                return listQuery.size() > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MergerMusic> loadMergerMusics(String str, String str2) {
        try {
            return this.dao.queryBuilder().orderBy("created", true).where().eq("playlistId", str).and().eq("songIdOrUri", str2).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
