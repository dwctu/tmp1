package com.wear.dao;

import android.database.Cursor;
import com.wear.bean.RemoteGuideVibemate;

/* loaded from: classes3.dex */
public class RemoteGuideVibematedDao extends BaseDao<RemoteGuideVibemate> {
    public void clear() {
        delTs(findAll());
    }

    public Cursor getDisguiseCursor() {
        if (DatabaseHelper.getHelper() != null) {
            return DatabaseHelper.getHelper().getReadableDatabase().rawQuery("SELECT * FROM tb_remote_guide_vibemate", null);
        }
        return null;
    }

    public void isRemoveDisguise() {
        try {
            DaoUtils.getRemoteGuideVibematedDao().clear();
            DaoUtils.getRemoteGuideVibematedDao().add((RemoteGuideVibematedDao) new RemoteGuideVibemate(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
