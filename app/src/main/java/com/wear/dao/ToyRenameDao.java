package com.wear.dao;

import com.j256.ormlite.table.TableUtils;
import com.wear.bean.ToyRename;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.List;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* loaded from: classes3.dex */
public class ToyRenameDao extends BaseDao<ToyRename> {
    public void cleanDefine() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), ToyRename.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ToyRename findToyName(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("email", str).and().eq(MultipleAddresses.Address.ELEMENT, str2).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            if (listQuery.size() > 1) {
                for (int i = 1; i < listQuery.size(); i++) {
                    DaoUtils.getToyRenameDao().delT((ToyRename) listQuery.get(i));
                }
            }
            return (ToyRename) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ToyRename findToyRenameByAddress(String str) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq(MultipleAddresses.Address.ELEMENT, str).query();
            if (listQuery == null || listQuery.size() == 0) {
                return null;
            }
            return (ToyRename) listQuery.get(listQuery.size() - 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isExistToyName(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq("email", str).and().eq("name", str2).query();
            if (listQuery != null) {
                return listQuery.size() > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
