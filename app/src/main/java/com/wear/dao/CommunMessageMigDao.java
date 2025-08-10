package com.wear.dao;

import com.j256.ormlite.stmt.QueryBuilder;
import com.wear.protocol.CommunMessageMig;
import com.wear.util.WearUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CommunMessageMigDao extends BaseDao<CommunMessageMig> {
    public void add(List<CommunMessageMig> list) {
        Iterator<CommunMessageMig> it = list.iterator();
        while (it.hasNext()) {
            addIfNotExist(it.next());
        }
    }

    public boolean addIfNotExistEt(CommunMessageMig communMessageMig) {
        if (this.dao == null) {
            return false;
        }
        try {
            if (!WearUtils.e1(communMessageMig.getRealId()) && this.dao.idExists(communMessageMig.getRealId())) {
                return false;
            }
            add((CommunMessageMigDao) communMessageMig);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(List<CommunMessageMig> list) {
        try {
            this.dao.delete(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            this.dao.executeRawNoArgs("delete from tb_commun_message_mig");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CommunMessageMig> findPageMsgs(int i, int i2) {
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
