package com.wear.dao;

import com.wear.bean.MusicPlaylist;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MusicPlaylistDao extends BaseDao<MusicPlaylist> {
    public List<MusicPlaylist> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return this.dao.queryBuilder().orderBy("created", false).where().eq("email", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
