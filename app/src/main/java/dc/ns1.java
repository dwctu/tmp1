package dc;

import android.text.TextUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;
import com.wear.dao.BaseDao;
import com.wear.util.WearUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: OldToyDao.java */
/* loaded from: classes3.dex */
public class ns1 extends BaseDao<ws1> {
    public void a() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), ws1.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean b(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            List listQuery = this.dao.queryBuilder().where().eq("email", str).or().isNull("email").and().eq(MultipleAddresses.Address.ELEMENT, str2).query();
            if (listQuery != null) {
                return listQuery.size() > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ws1 c(String str) {
        try {
            return (ws1) this.dao.queryBuilder().where().eq(MultipleAddresses.Address.ELEMENT, str).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final List<ws1> d(List<ws1> list) throws SQLException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (ws1 ws1Var : list) {
            if (ws1Var != null && !TextUtils.isEmpty(ws1Var.d1())) {
                boolean z = false;
                boolean z2 = true;
                if (TextUtils.equals("ToyA", ws1Var.P())) {
                    ws1Var.setType(ws1.w("ToyA".toLowerCase()));
                    z = true;
                }
                if (TextUtils.equals("ToyB", ws1Var.P())) {
                    ws1Var.setType(ws1.w("ToyB".toLowerCase()));
                    z = true;
                }
                ws1Var.a3();
                String name = ws1Var.getName();
                Map<String, String> map2 = ws1.b;
                if (TextUtils.equals(name, map2.get(ws1Var.getType()))) {
                    ws1Var.setName(map2.get(ws1Var.getType()));
                } else {
                    z2 = z;
                }
                if (z2) {
                    this.dao.update((Dao<T, String>) ws1Var);
                }
                if (map.get(ws1Var.getAddress()) != null) {
                    arrayList.add(ws1Var);
                }
                map.put(ws1Var.getAddress(), ws1Var);
            }
        }
        return arrayList;
    }

    public void e(String str, int i) {
        try {
            this.dao.executeRawNoArgs("update tb_toy set \"ledSetting\"=" + i + " where \"address\"=\"" + str + "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.dao.BaseDao
    public List<ws1> findAll() {
        try {
            List<ws1> listFindAll = super.findAll();
            if (listFindAll != null) {
                Iterator<ws1> it = d(listFindAll).iterator();
                while (it.hasNext()) {
                    listFindAll.remove(it.next());
                }
                return listFindAll;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }

    public List<ws1> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            List<ws1> listQuery = this.dao.queryBuilder().where().eq("email", str).or().isNull("email").query();
            Iterator<ws1> it = d(listQuery).iterator();
            while (it.hasNext()) {
                listQuery.remove(it.next());
            }
            return listQuery;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
