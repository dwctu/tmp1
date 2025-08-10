package com.wear.dao;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.wear.bean.BaseEntity;
import com.wear.util.WearUtils;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public abstract class BaseDao<T extends BaseEntity> {
    public static final String TAG = "db";
    public Dao<T, String> dao;
    private DatabaseHelper helper;

    public BaseDao() {
        if (DatabaseHelper.getHelper() != null) {
            DatabaseHelper helper = DatabaseHelper.getHelper();
            this.helper = helper;
            try {
                this.dao = helper.getDao(getTClass());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(T t) {
        if (this.dao == null) {
            return;
        }
        try {
            if (WearUtils.e1(t.getRealId())) {
                t.setId(WearUtils.E());
            }
            if (t.getCreated() == null) {
                t.setCreated(new Date());
            }
            if (!t.isEncrypt()) {
                t.setEncrypt(true);
            }
            this.dao.create(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addIfExist(T t) {
        if (this.dao == null) {
            return;
        }
        try {
            if (!WearUtils.e1(t.getRealId()) && this.dao.idExists(t.getRealId())) {
                delT(t);
            }
            t.setCreated(null);
            add((BaseDao<T>) t);
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("addIfExist 异常：", e));
        }
    }

    public void addIfNotExist(T t) {
        if (this.dao == null) {
            return;
        }
        try {
            if (WearUtils.e1(t.getRealId()) || !this.dao.idExists(t.getRealId())) {
                add((BaseDao<T>) t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("addIfNotExist 异常：", e));
        }
    }

    public void delById(String str) {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return;
        }
        try {
            dao.deleteById(str);
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("delById 异常：", e));
        }
    }

    public void delT(T t) {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return;
        }
        try {
            dao.delete((Dao<T, String>) t);
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("delT 异常：", e));
        }
    }

    public void delTs(Collection<T> collection) {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return;
        }
        try {
            dao.delete(collection);
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("delTs 异常：", e));
        }
    }

    public List<T> findAll() {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return null;
        }
        try {
            List<T> listQueryForAll = dao.queryForAll();
            if (listQueryForAll != null) {
                if (listQueryForAll.size() != 0) {
                    return listQueryForAll;
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public T findById(String str) {
        if (this.dao != null && !WearUtils.e1(str)) {
            try {
                return this.dao.queryForId(str);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Class<T> getTClass() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public GenericRawResults<String[]> queryBySQL(String str) {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return null;
        }
        try {
            return dao.queryRaw(str, new String[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(T t) {
        if (this.dao == null) {
            return;
        }
        try {
            if (!t.isEncrypt()) {
                t.setEncrypt(true);
            }
            this.dao.update((Dao<T, String>) t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrAdd(T t) {
        if (this.dao == null) {
            return;
        }
        try {
            if (WearUtils.e1(t.getRealId()) || !this.dao.idExists(t.getRealId())) {
                add((BaseDao<T>) t);
            } else {
                update((BaseDao<T>) t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("updateOrAdd 异常：", e));
        }
    }

    public void update(final List<T> list) {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return;
        }
        try {
            dao.callBatchTasks(new Callable<Void>() { // from class: com.wear.dao.BaseDao.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        BaseDao.this.update((BaseDao) it.next());
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("update 异常：", e));
        }
    }

    public void add(final Collection<T> collection) {
        Dao<T, String> dao = this.dao;
        if (dao == null) {
            return;
        }
        try {
            dao.callBatchTasks(new Callable<Void>() { // from class: com.wear.dao.BaseDao.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        BaseDao.this.add((BaseDao) it.next());
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
