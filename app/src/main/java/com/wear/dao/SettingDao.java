package com.wear.dao;

import com.wear.bean.Setting;
import dc.nd3;

/* loaded from: classes3.dex */
public class SettingDao extends BaseDao<Setting> {
    @Override // com.wear.dao.BaseDao
    public Setting findById(String str) {
        return (Setting) super.findById(nd3.p(str));
    }
}
