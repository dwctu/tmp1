package com.wear.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.LogType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class LogDao extends BaseDao<LogType> {
    public void cleanLogs() {
        try {
            Dao<T, String> dao = this.dao;
            if (dao == 0 || dao.getConnectionSource() == null) {
                return;
            }
            TableUtils.clearTable(this.dao.getConnectionSource(), LogType.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LogType findLastLog() {
        QueryBuilder queryBuilder = this.dao.queryBuilder();
        queryBuilder.orderBy("created", false);
        try {
            return (LogType) this.dao.queryForFirst(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
