package com.wear.dao;

import com.wear.bean.ToyStrength;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyStrengthDao extends BaseDao<ToyStrength> {
    public List<ToyStrength> findAllStrength(String str) {
        try {
            return this.dao.queryBuilder().where().eq("user", nd3.p(str)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public ToyStrength findToyStrength(String str, String str2) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq("user", nd3.p(str)).and().eq("toyAddress", str2).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ToyStrength) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
