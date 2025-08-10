package com.wear.dao;

import com.wear.bean.NewAccountBean;
import dc.nd3;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public class AccountDao extends BaseDao<NewAccountBean> {
    public NewAccountBean getAccountSetting(String str) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq("email", nd3.p(str)).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (NewAccountBean) listQuery.get(0);
        } catch (SQLException unused) {
            return null;
        }
    }

    public NewAccountBean getRemoteAccountId(String str) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq("remoteAccountId", str).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (NewAccountBean) listQuery.get(0);
        } catch (SQLException unused) {
            return null;
        }
    }
}
