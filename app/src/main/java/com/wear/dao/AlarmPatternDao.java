package com.wear.dao;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.AlarmPattern;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AlarmPatternDao extends BaseDao<AlarmPattern> {
    public List<AlarmPattern> findPatternsByEmail(String str) {
        try {
            return this.dao.queryBuilder().orderBy("created", false).where().eq("email", nd3.p(str)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<AlarmPattern> findPatternsByEmailAndTimes(String str, int i) {
        try {
            return this.dao.queryBuilder().orderBy("created", false).where().eq("email", nd3.p(str)).and().le("timer", WearUtils.Q(i)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<AlarmPattern> findPatternsByEmailOrderBySort(String str) {
        try {
            return this.dao.queryBuilder().orderBy("sortId", true).orderBy("created", false).where().eq("email", nd3.p(str)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<AlarmPattern> findPatternsInIds(String str, List<String> list) {
        try {
            return this.dao.queryBuilder().orderBy("created", false).where().eq("email", nd3.p(str)).and().in(TtmlNode.ATTR_ID, list).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
