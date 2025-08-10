package com.wear.dao;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.j256.ormlite.dao.Dao;
import com.wear.bean.User;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class UserDao extends BaseDao<User> {
    public String TAG = "UserDao";

    public List<User> findByIds(String str) {
        try {
            return this.dao.queryBuilder().where().eq(TtmlNode.ATTR_ID, nd3.p(str)).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findRemoteAccountIdByIds(String str) {
        try {
            return (User) this.dao.queryBuilder().where().eq("remoteAccountId", str).query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.wear.dao.BaseDao
    public void add(final Collection<User> collection) {
        Dao<T, String> dao = this.dao;
        if (dao == 0) {
            return;
        }
        try {
            dao.callBatchTasks(new Callable<Void>() { // from class: com.wear.dao.UserDao.1
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        UserDao.this.add((User) it.next());
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.dao.BaseDao
    public User findById(String str) {
        return (User) super.findById(nd3.p(str));
    }

    @Override // com.wear.dao.BaseDao
    public void update(User user) {
        if (this.dao == null) {
            return;
        }
        try {
            if (!user.isEncrypt()) {
                user.setEncrypt(true);
            }
            String str = "update: " + user.getId() + "  " + user.getRealId() + "   " + user.getRemoteAccountId();
            this.dao.update((Dao<T, String>) user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.dao.BaseDao
    public void updateOrAdd(User user) {
        if (this.dao == null) {
            return;
        }
        try {
            String str = "updateOrAdd: " + user.getId() + "  " + user.getRealId() + "   " + user.getRemoteAccountId();
            if (WearUtils.e1(user.getRealId()) || !this.dao.idExists(user.getRealId())) {
                add(user);
            } else {
                String str2 = "update111: " + user.getId() + "  " + user.getRealId();
                update(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String str3 = "error = " + e.getMessage();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("updateOrAdd 异常：", e));
        }
    }

    @Override // com.wear.dao.BaseDao
    public void add(User user) {
        if (this.dao == null) {
            return;
        }
        try {
            if (WearUtils.e1(user.getRealId())) {
                user.setId(WearUtils.E());
            }
            if (user.getCreated() == null) {
                user.setCreated(new Date());
            }
            if (!user.isEncrypt()) {
                user.setEncrypt(true);
            }
            String str = "add: " + user.getId() + "  " + user.getRealId() + "   " + user.getRemoteAccountId();
            this.dao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
