package com.wear.dao;

import com.wear.bean.UserSetting;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class UserSettingDao extends BaseDao<UserSetting> {
    public void deleteUserSettingsByUserIdAndFriendUserId(String str, String str2) {
        try {
            delT(findUserSettingsByUserIdAndFriendUserId(str, str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserSetting> findUserSettingsByUserId(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return this.dao.queryBuilder().orderBy("created", false).where().eq("userId", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public UserSetting findUserSettingsByUserIdAndFriendUserId(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            return (UserSetting) this.dao.queryBuilder().orderBy("created", false).where().eq("userId", str).and().eq("friendUserId", str2).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
