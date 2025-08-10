package com.wear.dao;

import com.wear.bean.MediaPattern;
import com.wear.bean.Pattern;
import dc.nd3;
import dc.xe2;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MediaPatternDao extends BaseDao<MediaPattern> {
    public List<MediaPattern> findMediaPatternsByEmail(String str, String str2) {
        try {
            String strP = nd3.p(str);
            return this.dao.queryBuilder().orderBy("created", false).where().eq("creator", strP).and().eq("friend", nd3.p(str2)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Pattern> findPatternsByEmail(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        List<MediaPattern> listFindMediaPatternsByEmail = findMediaPatternsByEmail(str, str2);
        if (listFindMediaPatternsByEmail != null && listFindMediaPatternsByEmail.size() > 0) {
            Iterator<MediaPattern> it = listFindMediaPatternsByEmail.iterator();
            while (it.hasNext()) {
                Pattern patternK = xe2.L0().K(it.next().getId());
                if (patternK != null) {
                    arrayList.add(patternK);
                }
            }
        }
        return arrayList;
    }
}
