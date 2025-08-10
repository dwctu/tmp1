package com.wear.dao;

import com.wear.bean.AccountSetting;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AccountSettingDao extends BaseDao<AccountSetting> {
    public List<AccountSetting> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            return this.dao.queryBuilder().where().eq("userId", str).or().isNull("userId").query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public AccountSetting getAccountSetting(String str, String str2) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq("userId", nd3.p(str)).and().eq("version", str2).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (AccountSetting) listQuery.get(0);
        } catch (SQLException unused) {
            return null;
        }
    }
}
