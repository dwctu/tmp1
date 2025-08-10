package com.wear.dao;

import com.j256.ormlite.stmt.QueryBuilder;
import com.wear.bean.MessageHideMig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MessageHideMigDao extends BaseDao<MessageHideMig> {
    public void add(List<MessageHideMig> list) {
        Iterator<MessageHideMig> it = list.iterator();
        while (it.hasNext()) {
            addIfNotExist(it.next());
        }
    }

    public void delete(List<MessageHideMig> list) {
        try {
            this.dao.delete(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            this.dao.executeRawNoArgs("delete from tb_msg_hide_mig");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MessageHideMig> findPageMsgs(int i, int i2) {
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
