package dc;

import com.j256.ormlite.table.TableUtils;
import com.wear.bean.ToyType;
import com.wear.dao.BaseDao;
import com.wear.util.WearUtils;
import java.sql.SQLException;
import java.util.List;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: OldToyTypeDao.java */
/* loaded from: classes3.dex */
public class os1 extends BaseDao<ToyType> {
    public ToyType a(String str) {
        try {
            List listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq(MultipleAddresses.Address.ELEMENT, str).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            if (listQuery.size() > 1) {
                for (int i = 1; i < listQuery.size(); i++) {
                    delT((ToyType) listQuery.get(i));
                }
            }
            return (ToyType) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean b(String str) {
        List listQuery;
        try {
            if (WearUtils.e1(str) || (listQuery = this.dao.queryBuilder().orderBy("created", true).where().eq(MultipleAddresses.Address.ELEMENT, str).query()) == null) {
                return false;
            }
            return listQuery.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int c() {
        try {
            List listQuery = this.dao.queryBuilder().orderBy("created", true).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return 0;
            }
            return listQuery.size();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void cleanDefine() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), ToyType.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
