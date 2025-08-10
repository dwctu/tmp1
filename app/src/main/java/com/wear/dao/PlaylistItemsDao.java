package com.wear.dao;

import com.wear.bean.PlaylistItems;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PlaylistItemsDao extends BaseDao<PlaylistItems> {
    public List<PlaylistItems> findByEmailAndPatternId(String str, String str2) {
        try {
            return this.dao.queryBuilder().orderBy("sortId", true).where().eq("email", str).and().eq("patternId", str2).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<PlaylistItems> findByEmailAndPlaylistCheckOfflineId(String str, String str2) {
        try {
            String value = WearUtils.e1(str) ? DaoUtils.getTestValueDao().getValue(TestValueDao.SAVE_KEY_LAST_LI_KEY, TestValueDao.SAVE_KEY_LAST_LI_TYPE) : "";
            if (!WearUtils.e1(value)) {
                new ArrayList<String>() { // from class: com.wear.dao.PlaylistItemsDao.2
                    {
                        add("");
                    }
                }.add(value);
                return this.dao.queryBuilder().where().eq("playlistId", str2).query();
            }
            if (str == null) {
                str = "";
            }
            return findByEmailAndPlaylistId(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<PlaylistItems> findByEmailAndPlaylistId(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return this.dao.queryBuilder().orderBy("sortId", true).where().eq("email", str).and().eq("playlistId", str2).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<PlaylistItems> findByEmailAndPlaylistIdCheckOffline(String str, String str2) {
        try {
            String value = WearUtils.e1(str) ? DaoUtils.getTestValueDao().getValue(TestValueDao.SAVE_KEY_LAST_LI_KEY, TestValueDao.SAVE_KEY_LAST_LI_TYPE) : "";
            if (WearUtils.e1(value)) {
                return findByEmailAndPlaylistId(str, str2);
            }
            new ArrayList<String>() { // from class: com.wear.dao.PlaylistItemsDao.1
                {
                    add("");
                }
            }.add(value);
            return this.dao.queryBuilder().orderBy("sortId", true).where().eq("playlistId", str2).query();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
