package com.wear.dao;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.MessageUnRead;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import dc.nd3;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class MessageUnReadDao extends BaseDao<MessageUnRead> {
    public void cleanRecords() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), MessageUnRead.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllUnRead(String str, String str2) {
        try {
            String strP = nd3.p(str);
            String strP2 = nd3.p(str2);
            DeleteBuilder deleteBuilder = this.dao.deleteBuilder();
            deleteBuilder.where().eq("ownerJid", strP).and().eq("friendJid", strP2);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> findAllCols() {
        ArrayList arrayList = new ArrayList();
        for (Field field : MessageUnRead.class.getDeclaredFields()) {
            String name = field.getName();
            if (field.getAnnotation(DatabaseField.class) != null) {
                arrayList.add(name);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public boolean findIsUnread(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.setCountOf(true);
            queryBuilder.where().eq(TtmlNode.ATTR_ID, str);
            return this.dao.countOf(queryBuilder.prepare()) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MessageUnRead> findPageMsgs(String str, List<IPeopleInfo> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        try {
            String strP = WearUtils.e1(str) ? "" : nd3.p(str);
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            ArrayList arrayList2 = new ArrayList();
            for (IPeopleInfo iPeopleInfo : list) {
                if (iPeopleInfo.isGroup()) {
                    String strK0 = WearUtils.k0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strK0)) {
                        strK0 = nd3.p(strK0);
                    }
                    arrayList2.add(strK0);
                } else {
                    String strI0 = WearUtils.i0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strI0)) {
                        strI0 = nd3.p(strI0);
                    }
                    arrayList2.add(strI0);
                }
            }
            where.eq("ownerJid", strP).and().in("friendJid", arrayList2);
            queryBuilder.offset(Long.valueOf(i + 0)).limit(Long.valueOf(i2 + 0));
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public long findUnReadsNums(String str, List<IPeopleInfo> list) {
        try {
            String strP = nd3.p(str);
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.setCountOf(true);
            Where<T, ID> where = queryBuilder.where();
            ArrayList arrayList = new ArrayList();
            for (IPeopleInfo iPeopleInfo : list) {
                if (iPeopleInfo.isGroup()) {
                    String strK0 = WearUtils.k0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strK0)) {
                        strK0 = nd3.p(strK0);
                    }
                    arrayList.add(strK0);
                } else {
                    String strI0 = WearUtils.i0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strI0)) {
                        strI0 = nd3.p(strI0);
                    }
                    arrayList.add(strI0);
                }
            }
            where.eq("ownerJid", strP).and().in("friendJid", arrayList);
            return this.dao.countOf(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public List<MessageUnRead> getAllLoginUserUnReads(String str) {
        try {
            List<MessageUnRead> listFindAll = findAll();
            if (listFindAll != null && listFindAll.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (MessageUnRead messageUnRead : listFindAll) {
                    if (messageUnRead.getOwnerJid().equals(str)) {
                        arrayList.add(messageUnRead);
                    } else {
                        String str2 = "不相等" + messageUnRead.getOwnerJid() + "  " + messageUnRead.getOldOwnerJid();
                    }
                }
                String str3 = "find " + arrayList.size();
                return arrayList;
            }
            return new ArrayList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MessageUnRead getUnRead(String str, String str2) {
        List<MessageUnRead> unReads = getUnReads(str, str2);
        if (unReads == null || unReads.size() <= 0) {
            return null;
        }
        return unReads.get(0);
    }

    public List<MessageUnRead> getUnReads(String str, String str2) {
        try {
            String strP = nd3.p(str);
            return this.dao.queryBuilder().where().eq("ownerJid", strP).and().eq("friendJid", nd3.p(str2)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isExistUnRead(String str, String str2) {
        List<MessageUnRead> unReads = getUnReads(str, str2);
        return unReads != null && unReads.size() > 0;
    }
}
