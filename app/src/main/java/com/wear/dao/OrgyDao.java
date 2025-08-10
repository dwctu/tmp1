package com.wear.dao;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.Orgy;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class OrgyDao extends BaseDao<Orgy> {
    public Orgy getOrgy(String str, String str2) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq(TtmlNode.ATTR_ID, nd3.p(str)).and().eq("activityId", str2).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (Orgy) listQuery.get(0);
        } catch (SQLException unused) {
            return null;
        }
    }

    public List<Orgy> getUserIdList(String str) {
        try {
            return this.dao.queryBuilder().where().eq(TtmlNode.ATTR_ID, nd3.p(str)).query();
        } catch (SQLException unused) {
            return new ArrayList();
        }
    }
}
