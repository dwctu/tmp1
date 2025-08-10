package com.wear.dao;

import com.alibaba.fastjson.JSON;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.wear.bean.official.OfficialMsg;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageDao.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0017"}, d2 = {"Lcom/wear/dao/OfficialMessageDao;", "Lcom/wear/dao/BaseDao;", "Lcom/wear/bean/official/OfficialMsg;", "()V", "addAll", "", "messageList", "", "checkDao", "", "deleteAll", "", "userid", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "queryAll", "lastTime", "", "pageSize", "pullNew", "queryLatestNews", "queryUnreadMessage", "setMessageRead", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class OfficialMessageDao extends BaseDao<OfficialMsg> {
    private final boolean checkDao() {
        if (this.dao != null) {
            return false;
        }
        ChatMessageDao.INSTANCE.getTAG();
        return true;
    }

    public final void addAll(@NotNull List<OfficialMsg> messageList) {
        Intrinsics.checkNotNullParameter(messageList, "messageList");
        if (checkDao()) {
            return;
        }
        try {
            Dao<T, String> dao = this.dao;
            if (dao != 0) {
                for (OfficialMsg officialMsg : messageList) {
                    String jSONString = JSON.toJSONString(officialMsg.getLang());
                    Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(msg.lang)");
                    officialMsg.setLangString(jSONString);
                    officialMsg.setId(officialMsg.getOfficialMsgId() + '+' + officialMsg.getUserId());
                    if (dao.idExists(officialMsg.getId())) {
                        dao.update((Dao<T, String>) officialMsg);
                    } else {
                        dao.create(officialMsg);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final Integer deleteAll(@NotNull String userid) {
        DeleteBuilder deleteBuilder;
        Intrinsics.checkNotNullParameter(userid, "userid");
        if (checkDao()) {
            return null;
        }
        try {
            Dao<T, String> dao = this.dao;
            if (dao == 0 || (deleteBuilder = dao.deleteBuilder()) == null) {
                return null;
            }
            deleteBuilder.where().eq("userId", userid);
            return Integer.valueOf(deleteBuilder.delete());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Nullable
    public final List<OfficialMsg> queryAll(@NotNull String userid, long lastTime, int pageSize, boolean pullNew) {
        Intrinsics.checkNotNullParameter(userid, "userid");
        Dao<T, String> dao = this.dao;
        if (dao == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        try {
            Intrinsics.checkNotNull(dao);
            QueryBuilder queryBuilder = dao.queryBuilder();
            if (pullNew || lastTime == 0) {
                queryBuilder.where().eq("userId", userid);
            } else {
                queryBuilder.where().eq("userId", userid).and().lt("userReceiveTime", Long.valueOf(lastTime));
            }
            queryBuilder.orderBy("userReceiveTime", false).limit(pageSize);
            Dao<T, String> dao2 = this.dao;
            Intrinsics.checkNotNull(dao2);
            return dao2.query(queryBuilder.prepare());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    @Nullable
    public final OfficialMsg queryLatestNews(@NotNull String userid) {
        Intrinsics.checkNotNullParameter(userid, "userid");
        Dao<T, String> dao = this.dao;
        if (dao == 0) {
            return null;
        }
        try {
            Intrinsics.checkNotNull(dao);
            QueryBuilder queryBuilder = dao.queryBuilder();
            queryBuilder.where().eq("userId", userid);
            queryBuilder.orderBy("userReceiveTime", false);
            Dao<T, String> dao2 = this.dao;
            Intrinsics.checkNotNull(dao2);
            if (dao2.query(queryBuilder.prepare()).size() <= 0) {
                return null;
            }
            Dao<T, String> dao3 = this.dao;
            Intrinsics.checkNotNull(dao3);
            return (OfficialMsg) dao3.query(queryBuilder.prepare()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final long queryUnreadMessage(@NotNull String userid) {
        Intrinsics.checkNotNullParameter(userid, "userid");
        Dao<T, String> dao = this.dao;
        if (dao == 0) {
            return 0L;
        }
        try {
            Intrinsics.checkNotNull(dao);
            QueryBuilder queryBuilder = dao.queryBuilder();
            queryBuilder.where().eq("userId", userid).and().eq("unreadMessage", 0);
            queryBuilder.orderBy("userReceiveTime", false);
            Intrinsics.checkNotNull(this.dao);
            return r7.query(queryBuilder.prepare()).size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public final boolean setMessageRead(@NotNull String userid) {
        Intrinsics.checkNotNullParameter(userid, "userid");
        Dao<T, String> dao = this.dao;
        if (dao == 0) {
            return false;
        }
        try {
            UpdateBuilder updateBuilder = dao.updateBuilder();
            updateBuilder.where().eq("userId", userid).and().eq("unreadMessage", 0);
            updateBuilder.updateColumnValue("unreadMessage", 1);
            return this.dao.update((PreparedUpdate<T>) updateBuilder.prepare()) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
