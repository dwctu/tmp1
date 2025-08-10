package com.wear.dao;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.Pattern;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.rf3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PatternDao extends BaseDao<Pattern> {
    private boolean sameEmail(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.equals(str2);
    }

    public List<Pattern> finPatternsCheckOfflineInIds(String str, List<String> list) {
        try {
            String value = WearUtils.e1(str) ? DaoUtils.getTestValueDao().getValue(TestValueDao.SAVE_KEY_LAST_LI_KEY, TestValueDao.SAVE_KEY_LAST_LI_TYPE) : "";
            if (WearUtils.e1(value)) {
                return findPatternsInIds(str, list);
            }
            new ArrayList<String>() { // from class: com.wear.dao.PatternDao.2
                {
                    add("");
                }
            }.add(value);
            return rf3.m(this.dao.queryBuilder().orderBy("created", false).where().in(TtmlNode.ATTR_ID, list).query());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Pattern> findPatternsByCreator(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return rf3.m(this.dao.queryBuilder().orderBy("created", false).where().eq("creator", str).query());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Pattern> findPatternsByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return rf3.m(this.dao.queryBuilder().orderBy("created", false).where().eq("email", str).query());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Pattern> findPatternsByEmailAndTimes(String str, int i) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return rf3.m(this.dao.queryBuilder().orderBy("created", false).where().eq("email", str).and().le("timer", WearUtils.Q(i)).query());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Pattern> findPatternsByEmailOrderBySort(String str) {
        ArrayList arrayList = new ArrayList();
        if (!WearUtils.e1(str)) {
            str = nd3.p(str);
        }
        try {
            if (!WearUtils.e1(WearUtils.e1(str) ? DaoUtils.getTestValueDao().getValue(TestValueDao.SAVE_KEY_LAST_LI_KEY, TestValueDao.SAVE_KEY_LAST_LI_TYPE) : "") || WearUtils.e1(str)) {
                List listQuery = this.dao.queryBuilder().orderBy("created", false).query();
                if (listQuery != null) {
                    arrayList.addAll(listQuery);
                }
                return rf3.m(arrayList);
            }
            List listQuery2 = this.dao.queryBuilder().orderBy("created", false).where().like("emails", '%' + str + '%').or().eq("email", str).query();
            if (listQuery2 != null) {
                arrayList.addAll(listQuery2);
            }
            return rf3.m(arrayList);
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public List<Pattern> findPatternsInIds(String str, List<String> list) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return rf3.m(this.dao.queryBuilder().orderBy("created", false).where().eq("email", str).and().in(TtmlNode.ATTR_ID, list).query());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Pattern> findSharePatternsByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return rf3.m(this.dao.queryBuilder().orderBy("created", false).where().like("emails", '%' + str + '%').or().eq("email", str).and().eq("shared", Boolean.TRUE).and().ne("status", Pattern.DOWNLOAD).query());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public boolean hasPatterns(String str, String str2) {
        if (!WearUtils.e1(str)) {
            str = nd3.p(str);
        }
        List<Pattern> listFindPatternsInIds = findPatternsInIds(str, new ArrayList<String>(str2) { // from class: com.wear.dao.PatternDao.1
            public final /* synthetic */ String val$id;

            {
                this.val$id = str2;
                add(str2);
            }
        });
        return listFindPatternsInIds != null && listFindPatternsInIds.size() > 0;
    }

    @Override // com.wear.dao.BaseDao
    public void addIfNotExist(Pattern pattern) {
        if (this.dao == null) {
            return;
        }
        try {
            if (WearUtils.e1(pattern.getRealId()) || !this.dao.idExists(pattern.getRealId())) {
                add((PatternDao) pattern);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
