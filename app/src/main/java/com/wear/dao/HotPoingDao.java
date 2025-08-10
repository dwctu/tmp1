package com.wear.dao;

import com.j256.ormlite.table.TableUtils;
import com.wear.bean.HotPoint;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.zt3;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public class HotPoingDao extends BaseDao<HotPoint> {
    public void cleanRecords() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), HotPoint.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllOldHot(int i) {
        try {
            this.dao.executeRawNoArgs("delete from tb_hot_point where \"appVersionCode\"<" + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HotPoint getHotPoints(String str, String str2) {
        try {
            if (WearUtils.e1(str)) {
                str = "";
            }
            if (WearUtils.e1(str2)) {
                str2 = "";
            }
            List listQuery = this.dao.queryBuilder().where().eq("owner", nd3.p(str)).and().eq("resId", str2).and().eq("appVersionCode", Integer.valueOf(MyApplication.U())).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (HotPoint) listQuery.get(0);
        } catch (SQLException unused) {
            cleanRecords();
            return null;
        }
    }

    public boolean isPressed(String str) {
        HotPoint hotPoints = getHotPoints(zt3.k, str);
        return hotPoints != null && hotPoints.getPressed().booleanValue();
    }

    public void pressedView(String str) {
        HotPoint hotPoints = getHotPoints(zt3.k, str);
        if (hotPoints != null) {
            if (hotPoints.getPressed().booleanValue()) {
                return;
            }
            hotPoints.setPressed(Boolean.TRUE);
            update((HotPoingDao) hotPoints);
            return;
        }
        HotPoint hotPoint = new HotPoint();
        hotPoint.setPressed(Boolean.TRUE);
        hotPoint.setResId(str);
        hotPoint.setOwner(zt3.k);
        hotPoint.setAppVersionCode(MyApplication.U());
        add((HotPoingDao) hotPoint);
    }

    public void removeView(String str) {
        HotPoint hotPoints = getHotPoints(zt3.k, str);
        if (hotPoints != null) {
            delT(hotPoints);
        }
    }
}
