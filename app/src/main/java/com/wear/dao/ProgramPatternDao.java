package com.wear.dao;

import com.wear.bean.ProgramPattern;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public class ProgramPatternDao extends BaseDao<ProgramPattern> {
    public ProgramPattern findPatterns(String str, String str2, String str3) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("email", str).and().eq("btAddress", str2).and().eq("data", str3).query();
            if (listQuery == null || listQuery.size() < 1) {
                return null;
            }
            return (ProgramPattern) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
