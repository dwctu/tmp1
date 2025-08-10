package com.wear.dao;

import com.wear.bean.Playlist;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PlaylistDao extends BaseDao<Playlist> {
    public List<Playlist> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return this.dao.queryBuilder().orderBy("sortId", true).orderBy("created", false).where().like("email", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Playlist> findPlayListByEmailOrderBySort(String str) {
        try {
            return (!WearUtils.e1(WearUtils.e1(str) ? DaoUtils.getTestValueDao().getValue(TestValueDao.SAVE_KEY_LAST_LI_KEY, TestValueDao.SAVE_KEY_LAST_LI_TYPE) : "") || WearUtils.e1(str)) ? this.dao.queryBuilder().orderBy("created", false).query() : findByEmail(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
