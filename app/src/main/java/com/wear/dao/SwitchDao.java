package com.wear.dao;

import com.j256.ormlite.table.TableUtils;
import com.wear.bean.SwitchBean;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.zt3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SwitchDao extends BaseDao<SwitchBean> {
    public void cleanRecords() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), SwitchBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SwitchBean> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            return this.dao.queryBuilder().where().eq("owner", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public SwitchBean getByKey(int i) {
        SwitchBean switchBean = null;
        try {
            List listQuery = this.dao.queryBuilder().where().eq("owner", nd3.p(zt3.k)).and().eq("key", Integer.valueOf(i)).query();
            if (listQuery != null && listQuery.size() > 0) {
                switchBean = (SwitchBean) listQuery.get(0);
            }
        } catch (Exception unused) {
        }
        if (switchBean != null && !WearUtils.e1(switchBean.getValues())) {
            switchBean.setValues(nd3.i(switchBean.getValues()));
        }
        return switchBean;
    }

    public void save(int i, String str) {
        String strU = nd3.u(str);
        SwitchBean byKey = getByKey(i);
        if (byKey != null) {
            byKey.setValues(strU);
            update((SwitchDao) byKey);
            return;
        }
        SwitchBean switchBean = new SwitchBean();
        switchBean.setKey(i);
        switchBean.setOwner(zt3.k);
        switchBean.setValues(strU);
        add((SwitchDao) switchBean);
    }
}
