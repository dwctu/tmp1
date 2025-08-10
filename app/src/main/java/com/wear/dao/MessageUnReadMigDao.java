package com.wear.dao;

import com.j256.ormlite.stmt.QueryBuilder;
import com.wear.bean.MessageUnReadMig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MessageUnReadMigDao extends BaseDao<MessageUnReadMig> {
    public void add(List<MessageUnReadMig> list) {
        Iterator<MessageUnReadMig> it = list.iterator();
        while (it.hasNext()) {
            addIfNotExist(it.next());
        }
    }

    public void delete(List<MessageUnReadMig> list) {
        try {
            this.dao.delete(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            this.dao.executeRawNoArgs("delete from tb_msg_unread_mig");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MessageUnReadMig> findPageMsgs(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
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
}
