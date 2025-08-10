package com.wear.dao;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.wear.bean.ToyPinStatusBean;
import java.sql.SQLException;
import java.util.List;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* loaded from: classes3.dex */
public class ToyPinStatusDao extends BaseDao<ToyPinStatusBean> {
    public void delToyPinStatus(String str) {
        try {
            DeleteBuilder deleteBuilder = this.dao.deleteBuilder();
            deleteBuilder.where().eq(MultipleAddresses.Address.ELEMENT, str);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ToyPinStatusBean findToyPinStatus(String str) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq(MultipleAddresses.Address.ELEMENT, str).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ToyPinStatusBean) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
