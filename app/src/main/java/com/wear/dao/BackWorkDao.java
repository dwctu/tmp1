package com.wear.dao;

import com.j256.ormlite.table.TableUtils;
import com.wear.bean.BackWork;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public class BackWorkDao extends BaseDao<BackWork> {
    public void cleanWorks() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), BackWork.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String str, String str2) {
        BackWork worksByType;
        try {
            if (WearUtils.e1(str) || WearUtils.e1(str2) || (worksByType = getWorksByType(str, str2)) == null) {
                return;
            }
            delT(worksByType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BackWork> getWorks(String str) {
        try {
            return this.dao.queryBuilder().where().eq("owner", nd3.p(str)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BackWork getWorksByType(String str, String str2) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq("workId", str).and().eq("targetEmail", nd3.p(str2)).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (BackWork) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isExistWorksByType(String str, String str2) {
        return getWorksByType(str, nd3.p(str2)) != null;
    }

    public void updateOrAddToWork(BackWork backWork) {
        if (backWork == null) {
            return;
        }
        try {
            String workId = backWork.getWorkId();
            String targetEmail = backWork.getTargetEmail();
            if (WearUtils.e1(workId) || WearUtils.e1(targetEmail)) {
                return;
            }
            BackWork worksByType = getWorksByType(workId, targetEmail);
            if (worksByType != null) {
                delT(worksByType);
            }
            add((BackWorkDao) backWork);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
