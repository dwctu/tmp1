package com.wear.dao;

import com.wear.bean.Alarm;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AlarmDao extends BaseDao<Alarm> {
    public Alarm findAlarm(String str, String str2) {
        try {
            String strP = nd3.p(str);
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("ownerEmail", strP).and().eq("friendEmail", nd3.p(str2)).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (Alarm) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Alarm> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            return this.dao.queryBuilder().where().eq("ownerEmail", str).or().isNull("ownerEmail").query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Alarm> findByFriendEmails(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            return this.dao.queryBuilder().where().eq("friendEmail", str).or().isNull("friendEmail").query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
