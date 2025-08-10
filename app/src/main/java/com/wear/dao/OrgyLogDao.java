package com.wear.dao;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.OrgyLogBean;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class OrgyLogDao extends BaseDao<OrgyLogBean> {
    public void cleanLogs() {
        try {
            Dao<T, String> dao = this.dao;
            if (dao == 0 || dao.getConnectionSource() == null) {
                return;
            }
            TableUtils.clearTable(this.dao.getConnectionSource(), OrgyLogBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.dao.BaseDao
    public void delTs(Collection<OrgyLogBean> collection) {
        Dao<T, String> dao = this.dao;
        if (dao == 0) {
            return;
        }
        try {
            dao.delete(collection);
        } catch (SQLException e) {
            e.printStackTrace();
            cleanLogs();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("delTs 异常：", e));
        }
    }

    public OrgyLogBean findLastLog() {
        QueryBuilder queryBuilder = this.dao.queryBuilder();
        queryBuilder.orderBy("created", false);
        try {
            return (OrgyLogBean) this.dao.queryForFirst(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OrgyLogBean> findLogsByActivityId(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("activityId", str);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFirstLogActivityId() {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().isNotNull("activityId");
            queryBuilder.orderBy("created", true);
            OrgyLogBean orgyLogBean = (OrgyLogBean) this.dao.queryForFirst(queryBuilder.prepare());
            if (orgyLogBean != null) {
                return orgyLogBean.getActivityId();
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
