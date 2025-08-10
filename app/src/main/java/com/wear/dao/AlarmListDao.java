package com.wear.dao;

import com.wear.bean.AlarmListItems;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.zt3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AlarmListDao extends BaseDao<AlarmListItems> {
    public AlarmListItems findAlarmByreceiveAlarmId(String str) {
        try {
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("receiveAlarmId", str).query();
            if (listQuery == null || listQuery.size() == 0) {
                return null;
            }
            return (AlarmListItems) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AlarmListItems> findAlarmList(String str, int i, String str2) {
        try {
            return this.dao.queryBuilder().orderBy("created", true).where().eq("friendEmail", nd3.p(str)).and().eq("receiveFlag", Integer.valueOf(i)).and().eq("ownerEmail", nd3.p(str2)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AlarmListItems> findAllDefendAlarmList() {
        try {
            return this.dao.queryBuilder().orderBy("created", true).where().eq("receiveFlag", 0).and().eq("ownerEmail", nd3.p(zt3.k)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AlarmListItems> findAllReceiveAlarmList() {
        try {
            return this.dao.queryBuilder().orderBy("created", true).where().eq("receiveFlag", 1).and().eq("ownerEmail", nd3.p(zt3.k)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AlarmListItems> findFriedndAlarmList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!WearUtils.e1(str)) {
                String strP = nd3.p(str);
                List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("friendEmail", "").and().eq("receiveFlag", 0).and().eq("ownerEmail", strP).query();
                if (listQuery != null) {
                    arrayList.addAll(listQuery);
                }
                List listQuery2 = this.dao.queryBuilder().orderBy("created", true).where().eq("receiveFlag", 1).and().eq("ownerEmail", strP).and().eq("accept", 1).query();
                if (listQuery2 != null) {
                    arrayList.addAll(listQuery2);
                }
            }
            return arrayList;
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public List<AlarmListItems> findAlarmList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            String strP = nd3.p(str);
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("friendEmail", "").and().eq("receiveFlag", 0).and().eq("ownerEmail", strP).query();
            if (listQuery != null) {
                arrayList.addAll(listQuery);
            }
            List listQuery2 = this.dao.queryBuilder().orderBy("created", true).where().eq("receiveFlag", 1).and().eq("ownerEmail", strP).and().eq("accept", 1).query();
            if (listQuery2 != null) {
                arrayList.addAll(listQuery2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
