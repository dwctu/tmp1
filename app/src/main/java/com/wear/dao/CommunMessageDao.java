package com.wear.dao;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.wear.bean.BaseEntity;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityChatABean;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.ed2;
import dc.n12;
import dc.nd3;
import dc.xe3;
import dc.zb2;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class CommunMessageDao extends BaseDao<CommunMessage> {
    private final n12 compare = new n12();
    private HashMap<String, String> enJidMap;

    private long countMessage() {
        try {
            return this.dao.queryBuilder().where().isNull("userId").countOf();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private List<CommunMessage> findOldData(long j, long j2) {
        try {
            xe3.a("Database", "单次查询：" + j + "  " + j2);
            return this.dao.queryBuilder().offset((Long) 0L).limit(Long.valueOf(j2)).where().isNull("userId").query();
        } catch (SQLException e) {
            FirebaseCrashlytics.getInstance().setCustomKey("type", "单次查询异常");
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
            return new ArrayList();
        }
    }

    private String getEnJid(@NonNull String str) {
        if (this.enJidMap == null) {
            this.enJidMap = new HashMap<>();
        }
        if (this.enJidMap.containsKey(str)) {
            return this.enJidMap.get(str);
        }
        String strP = nd3.p(str);
        if (!WearUtils.e1(strP)) {
            this.enJidMap.put(str, strP);
        }
        return strP;
    }

    public void clearDateChat() {
        try {
            DeleteBuilder deleteBuilder = this.dao.deleteBuilder();
            deleteBuilder.where().eq("sendType", 2);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delDateDrafMessage(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            DeleteBuilder deleteBuilder = this.dao.deleteBuilder();
            deleteBuilder.where().eq("userId", str).and().eq("from", str).and().eq("to", str2).and().eq("sendType", 1).and().eq("userId", str);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            this.dao.executeRawNoArgs("delete from tb_commun_message");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByFriendEmail(String str) {
        String strP = WearUtils.y.p();
        String strJ0 = WearUtils.j0(str);
        try {
            DeleteBuilder deleteBuilder = this.dao.deleteBuilder();
            Where<T, ID> where = deleteBuilder.where();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            if (!WearUtils.e1(strJ0)) {
                strJ0 = nd3.p(strJ0);
            }
            where.eq("userId", strP).and().eq("from", strJ0).and().eq("to", strP);
            where.eq("userId", strP).and().eq("to", strJ0).and().eq("from", strP);
            where.or(where, where, new Where[0]);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CommunMessage> findAfterMessage(String str, String str2, CommunMessage communMessage, int i) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            String strP = !WearUtils.e1(str) ? nd3.p(str) : str;
            String strP2 = !WearUtils.e1(str2) ? nd3.p(str2) : str2;
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().gt("created", communMessage.getCreated());
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().gt("created", communMessage.getCreated());
            } else {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().gt("created", communMessage.getCreated());
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().gt("created", communMessage.getCreated());
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", true).limit(i);
            List<CommunMessage> listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery != null && !listQuery.isEmpty()) {
                Collections.sort(listQuery, this.compare);
            }
            return listQuery;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> findAllCols() {
        ArrayList arrayList = new ArrayList();
        for (Field field : CommunMessage.class.getDeclaredFields()) {
            String name = field.getName();
            if (field.getAnnotation(DatabaseField.class) != null) {
                arrayList.add(name);
            }
        }
        for (Field field2 : BaseEntity.class.getDeclaredFields()) {
            String name2 = field2.getName();
            if (field2.getAnnotation(DatabaseField.class) != null) {
                arrayList.add(name2);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public boolean findAllHaveMsgs() {
        List arrayList = new ArrayList();
        try {
            String strP = WearUtils.y.p();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("userId", strP).and().ne("sendType", "2").and().ne("type", MessageType.alarm).and().isNotNull("type");
            queryBuilder.offset((Long) 0L).limit((Long) 1L);
            arrayList = this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    public List<CommunMessage> findAllMessageWithMedia(String str, String str2) {
        try {
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            ArrayList arrayList = new ArrayList();
            arrayList.add(MessageType.shortvideo);
            arrayList.add(MessageType.picture);
            arrayList.add(MessageType.audio);
            arrayList.add(MessageType.burnvideo);
            arrayList.add(MessageType.burnpicture);
            int i = 2;
            where.eq("from", str).and().eq("to", str2).and().in("type", arrayList).and().eq("sendType", Integer.valueOf((iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) ? 0 : 2));
            Where whereAnd = where.eq("from", str2).and().eq("to", str).and().in("type", arrayList).and();
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                i = 0;
            }
            whereAnd.eq("sendType", Integer.valueOf(i));
            where.or(where, where, new Where[0]);
            return this.dao.query(queryBuilder.prepare());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long findAllMsgsNums(List<IPeopleInfo> list, int i) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        try {
            String strP = WearUtils.y.p();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            ArrayList arrayList = new ArrayList();
            for (IPeopleInfo iPeopleInfo : list) {
                if (iPeopleInfo.isGroup()) {
                    String strK0 = WearUtils.k0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strK0)) {
                        strK0 = nd3.p(strK0);
                    }
                    arrayList.add(strK0);
                } else {
                    String strI0 = WearUtils.i0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strI0)) {
                        strI0 = nd3.p(strI0);
                    }
                    arrayList.add(strI0);
                }
            }
            if (i == 0) {
                where.and(where.or(where.in("from", arrayList), where.in("to", arrayList), new Where[0]), where.eq("userId", strP).and().ne("sendType", "2").and().ne("type", MessageType.alarm).and().isNotNull("type"), new Where[0]);
            } else {
                where.and(where.or(where.in("from", arrayList), where.in("to", arrayList), new Where[0]), where.eq("userId", strP).and().eq("sendType", "0").and().in("type", ed2.x().G()), new Where[0]);
            }
            queryBuilder.setCountOf(true);
            return this.dao.countOf(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public List<CommunMessage> findAllPictures(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("from", str).and().eq("to", str2).and().eq("userId", str);
            where.eq("from", str2).and().eq("to", str).and().eq("userId", str);
            where.or(where, where, new Where[0]).and().eq("type", MessageType.picture);
            queryBuilder.orderBy("created", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findBeforeMessage(String str, String str2, CommunMessage communMessage, int i) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            String strP = !WearUtils.e1(str) ? nd3.p(str) : str;
            String strP2 = !WearUtils.e1(str2) ? nd3.p(str2) : str2;
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().lt("created", communMessage.getCreated());
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().lt("created", communMessage.getCreated());
            } else {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().lt("created", communMessage.getCreated());
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().lt("created", communMessage.getCreated());
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).limit(i);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findByEmails(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (str == null) {
                str = "";
            }
            return this.dao.queryBuilder().where().eq("userId", str).or().isNull("userId").query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public CommunMessage findByMsgId(String str) {
        try {
            Where<T, ID> where = this.dao.queryBuilder().where();
            String strP = ch3.n().p();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            where.eq("msgId", str).and().eq("userId", strP).and().isNotNull("type");
            List listQuery = where.query();
            if (listQuery != null && listQuery.size() != 0) {
                return (CommunMessage) listQuery.get(0);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findByMsgType(String str, String str2, MessageType messageType) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("type", messageType);
            where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("type", messageType);
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findByPage(String str, String str2, int i, int i2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            } else {
                where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", str);
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset(i * i2).limit(i2);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CommunMessage findByReceiveId(String str) {
        try {
            Where<T, ID> where = this.dao.queryBuilder().where();
            String strP = ch3.n().p();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            where.eq("receiveId", str).and().eq("userId", strP).and().isNotNull("type");
            List listQuery = where.query();
            if (listQuery != null && listQuery.size() != 0) {
                return (CommunMessage) listQuery.get(0);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findDateMessage(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            } else {
                where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", str);
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", true).groupByRaw("strftime('%Y-%m-%d', created)").having("MIN(created)");
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CommunMessage findDrafMessage(String str, String str2) {
        IPeopleInfo iPeopleInfoS;
        try {
            iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (iPeopleInfoS != null && iPeopleInfoS.isDateIng()) {
            return null;
        }
        if (!WearUtils.e1(str)) {
            str = getEnJid(str);
        }
        if (!WearUtils.e1(str2)) {
            str2 = getEnJid(str2);
        }
        QueryBuilder queryBuilder = this.dao.queryBuilder();
        Where<T, ID> where = queryBuilder.where();
        where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 1).and().eq("userId", str);
        where.and().ne("type", MessageType.system);
        queryBuilder.orderBy("created", false).offset(0).limit(1);
        List listQuery = this.dao.query(queryBuilder.prepare());
        if (listQuery != null && listQuery.size() > 0) {
            return (CommunMessage) listQuery.get(0);
        }
        return null;
    }

    public List<CommunMessage> findFriend(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            } else {
                where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", str);
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findGroupFriend(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            where.eq("realFrom", str2).and().eq("sendType", 2).and().isNotNull("type").and().eq("userId", str);
            queryBuilder.orderBy("created", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean findHaveMsgs(String str) {
        String strP = WearUtils.y.p();
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            if (ch3.n().s(WearUtils.g0(str)) == null) {
                ch3.n().s(WearUtils.g0(strP));
            }
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            Where whereAnd = where.eq("from", strP).and().eq("to", str).and().isNotNull("type").and().eq("userId", strP).and().ne("sendType", "2").and();
            MessageType messageType = MessageType.alarm;
            whereAnd.ne("type", messageType);
            where.eq("from", str).and().eq("to", strP).and().isNotNull("type").and().eq("userId", strP).and().ne("sendType", "2").and().ne("type", messageType);
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset((Long) 0L).limit((Long) 1L);
            List listQuery = this.dao.query(queryBuilder.prepare());
            return listQuery != null && listQuery.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CommunMessage findLastGroupMessage(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = getEnJid(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = getEnJid(str2);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset((Long) 0L).limit((Long) 1L);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (CommunMessage) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CommunMessage findLastMessage(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = getEnJid(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = getEnJid(str2);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str);
            where.or(where, where, new Where[0]);
            where.and().ne("type", MessageType.system);
            queryBuilder.orderBy("created", false).offset(0).limit(1);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (CommunMessage) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CommunMessage findLastRecMessage(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            where.eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str2).and().isNotNull("msgId");
            where.eq("from", str2).and().eq("to", str).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", str2).and().isNotNull("msgId");
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset((Long) 0L).limit((Long) 1L);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (CommunMessage) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findMessageByType(String str, String str2, String str3, boolean z, boolean z2, List<MessageType> list, int i, int i2) {
        String str4;
        try {
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
                str4 = str2;
            } else {
                str4 = str;
            }
            String strP = nd3.p(str4);
            String strP2 = !WearUtils.e1(str) ? nd3.p(str) : str;
            String strP3 = !WearUtils.e1(str2) ? nd3.p(str2) : str2;
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                try {
                    where.eq("from", strP2).and().eq("to", strP3).and().eq("sendType", 0).and().eq("userId", strP).and().in("type", list);
                    if (!TextUtils.isEmpty(str3)) {
                        where.and().eq("realFrom", nd3.p(str3));
                    }
                    if (z) {
                        where.eq("from", strP3).and().eq("to", strP2).and().eq("sendType", 0).and().eq("userId", strP).and().in("type", list);
                        if (!TextUtils.isEmpty(str3)) {
                            where.and().eq("realFrom", nd3.p(str3));
                        }
                        where.or(where, where, new Where[0]);
                    }
                } catch (SQLException e) {
                    e = e;
                    e.printStackTrace();
                    return null;
                }
            } else {
                where.eq("from", strP2).and().eq("to", strP3).and().eq("sendType", 2).and().eq("userId", strP).and().in("type", list);
                if (!TextUtils.isEmpty(str3)) {
                    where.and().eq("realFrom", nd3.p(str3));
                }
                if (z) {
                    where.eq("from", strP3).and().eq("to", strP2).and().eq("sendType", 2).and().eq("userId", strP).and().in("type", list);
                    if (!TextUtils.isEmpty(str3)) {
                        where.and().eq("realFrom", nd3.p(str3));
                    }
                    where.or(where, where, new Where[0]);
                }
            }
            queryBuilder.orderBy("created", z2);
            if (i2 != 0) {
                queryBuilder.offset(i * i2).limit(i2);
            }
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public List<CommunMessage> findMessageByTypeAndHours(String str, String str2, List<MessageType> list, int i, int i2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            Calendar gregorianCalendar = GregorianCalendar.getInstance();
            gregorianCalendar.setTime(new Date());
            gregorianCalendar.add(6, -7);
            Date time = gregorianCalendar.getTime();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            String strP = !WearUtils.e1(str) ? nd3.p(str) : str;
            String strP2 = !WearUtils.e1(str2) ? nd3.p(str2) : str2;
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                try {
                    where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().in("type", list).and().ge("created", time);
                    where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().in("type", list).and().ge("created", time);
                } catch (SQLException e) {
                    e = e;
                    e.printStackTrace();
                    return null;
                }
            } else {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().in("type", list).and().ge("created", time);
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().in("type", list).and().ge("created", time);
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset(i * i2).limit(i2);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public List<CommunMessage> findPageMsgs(String str, List<String> list, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        try {
            String strP = WearUtils.e1(str) ? "" : nd3.p(str);
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            if (i3 == 0) {
                where.and(where.or(where.in("from", list), where.in("to", list), new Where[0]), where.eq("userId", strP).and().ne("sendType", "2").and().ne("type", MessageType.alarm).and().isNotNull("type"), new Where[0]);
            } else {
                where.and(where.or(where.in("from", list), where.in("to", list), new Where[0]), where.eq("userId", strP).and().eq("sendType", "0").and().in("type", ed2.x().G()), new Where[0]);
            }
            queryBuilder.offset(Long.valueOf(i)).limit(Long.valueOf(i2));
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public List<CommunMessage> findShowEmojiAnimMessages(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("from", str).and().eq("to", str2).and().isNotNull("type").and().eq("sendType", 0).and().eq("isShowEmojiAnim", Boolean.TRUE);
            queryBuilder.orderBy("created", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findUnReadByPage(String str, String str2, int i, int i2, int i3) {
        try {
            int i4 = i3 / i2;
            if (i3 % i2 > 0) {
                i4++;
            }
            int i5 = i4 * i2;
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            if (!WearUtils.e1(str2)) {
                str2 = nd3.p(str2);
            }
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", str).and().eq("to", str2).and().eq("sendType", 0).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().eq("sendType", 0).and().eq("userId", str);
            } else {
                where.eq("from", str).and().eq("to", str2).and().eq("sendType", 2).and().eq("userId", str);
                where.eq("from", str2).and().eq("to", str).and().eq("sendType", 2).and().eq("userId", str);
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset(i * i2).limit(i5);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CommunMessage> findUnReadMessage(String str, String str2, int i, int i2, Date date, boolean z) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            String strP = !WearUtils.e1(str) ? nd3.p(str) : str;
            String strP2 = !WearUtils.e1(str2) ? nd3.p(str2) : str2;
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP);
            } else {
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP);
            }
            where.and().ge("created", date);
            if (z) {
                where.and().ne("type", MessageType.system);
            }
            queryBuilder.orderBy("created", false).offset(i * i2).limit(10000);
            List<CommunMessage> listQuery = this.dao.query(queryBuilder.prepare());
            return (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) ? listQuery != null ? listQuery : new ArrayList() : new ArrayList();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public int findUnReadSize(String str, String str2, int i, int i2, Date date, boolean z) {
        return findUnReadMessage(str, str2, i, i2, date, z).size();
    }

    public List<CommunMessage> findUserMessage(List<String> list, String str, String str2, MessageType messageType, boolean z, int i, int i2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
            if (iPeopleInfoS == null) {
                iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
            }
            String strP = !WearUtils.e1(str) ? nd3.p(str) : str;
            String strP2 = !WearUtils.e1(str2) ? nd3.p(str2) : str2;
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.set(i3, nd3.p(list.get(i3)));
            }
            String str3 = "realFrom";
            if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().in(z ? "realFrom" : "from", list).and().eq("type", messageType);
                where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 0).and().eq("userId", strP).and().in(z ? "realFrom" : "from", list).and().eq("type", messageType);
            } else {
                where.eq("from", strP).and().eq("to", strP2).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and().in(z ? "realFrom" : "from", list).and().eq("type", messageType);
                Where whereAnd = where.eq("from", strP2).and().eq("to", strP).and().isNotNull("type").and().eq("sendType", 2).and().eq("userId", strP).and();
                if (!z) {
                    str3 = "from";
                }
                whereAnd.in(str3, list).and().eq("type", messageType);
            }
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("created", false).offset(i * i2).limit(i2);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean hasPatternByFromIdAndUrl(String str, String str2, long j) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            Iterator it = this.dao.queryBuilder().where().eq("from", str).and().eq("type", MessageType.valueOf("pattern")).query().iterator();
            while (it.hasNext()) {
                EntityPattern entityPattern = (EntityPattern) ((CommunMessage) it.next()).syncDecryptBean();
                if (entityPattern != null && !TextUtils.isEmpty(entityPattern.getUrl()) && entityPattern.getUrl().equals(str2) && entityPattern.getTime() == j) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void upDateByFriendEmail(String str, int i) {
        String strP = WearUtils.y.p();
        String strI0 = WearUtils.i0(str);
        try {
            UpdateBuilder updateBuilder = this.dao.updateBuilder();
            updateBuilder.updateColumnValue("sendType", 0);
            Where<T, ID> where = updateBuilder.where();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            if (!WearUtils.e1(strI0)) {
                strI0 = nd3.p(strI0);
            }
            where.eq("userId", strP).and().eq("from", strI0).and().isNotNull("type").and().eq("to", strP).and().eq("sendType", Integer.valueOf(i));
            where.eq("userId", strP).and().eq("to", strI0).and().isNotNull("type").and().eq("from", strP).and().eq("sendType", Integer.valueOf(i));
            where.or(where, where, new Where[0]);
            updateBuilder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upDateDrafMessage(String str, String str2, String str3, List<EntityChatABean> list, CommunMessage communMessage) {
        IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
        if (iPeopleInfoS == null || !iPeopleInfoS.isDateIng()) {
            EntityChat entityChat = new EntityChat();
            entityChat.setText(str3);
            entityChat.setPeopleData(list);
            CommunMessage communMessageFindDrafMessage = findDrafMessage(str, str2);
            if (communMessageFindDrafMessage != null) {
                communMessageFindDrafMessage.setCreated(new Date());
                communMessageFindDrafMessage.sendEntity(entityChat);
                if (communMessage != null) {
                    communMessageFindDrafMessage.setReplyData(WearUtils.A.toJson(communMessage));
                }
            } else {
                communMessageFindDrafMessage = new CommunMessage();
                communMessageFindDrafMessage.setFrom(str);
                communMessageFindDrafMessage.setTo(str2);
                communMessageFindDrafMessage.sendEntity(entityChat);
                communMessageFindDrafMessage.setSendType(1);
                communMessageFindDrafMessage.setUserId(str);
                communMessageFindDrafMessage.setId(WearUtils.E());
                if (communMessage != null) {
                    communMessageFindDrafMessage.setReplyData(WearUtils.A.toJson(communMessage));
                }
            }
            if (zb2.O().l0(communMessageFindDrafMessage)) {
                updateOrAdd(communMessageFindDrafMessage);
            }
        }
    }

    public synchronized void updateList(Handler handler) {
        long jCountMessage;
        long j;
        try {
            xe3.a("Database", "updateList：");
            jCountMessage = countMessage();
            xe3.a("Database", "共有数据：" + jCountMessage);
            j = 0;
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().setCustomKey("type", "总体异常");
            FirebaseCrashlytics.getInstance().recordException(e);
            xe3.a("Database", "总体异常：" + e.getMessage());
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            handler.sendMessage(messageObtain);
        }
        if (jCountMessage == 0) {
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 1;
            handler.sendMessage(messageObtain2);
            return;
        }
        while (true) {
            final List<CommunMessage> listFindOldData = findOldData(j, 500L);
            int size = listFindOldData.size();
            if (size == 0) {
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 1;
                handler.sendMessage(messageObtain3);
                break;
            }
            this.dao.callBatchTasks(new Callable<Object>() { // from class: com.wear.dao.CommunMessageDao.1
                @Override // java.util.concurrent.Callable
                public Object call() throws Exception {
                    for (CommunMessage communMessage : listFindOldData) {
                        communMessage.setUserId(communMessage.getFrom());
                        CommunMessageDao.this.dao.update((Dao<T, String>) communMessage);
                        communMessage.setReceiveId(communMessage.getId());
                        communMessage.setId(WearUtils.E());
                        communMessage.setUserId(communMessage.getTo());
                        CommunMessageDao.this.dao.create(communMessage);
                    }
                    return null;
                }
            });
            if (size < 500) {
                Message messageObtain4 = Message.obtain();
                messageObtain4.what = 1;
                handler.sendMessage(messageObtain4);
                break;
            } else {
                int i = (int) ((((j * 500) + size) * 100) / jCountMessage);
                Message messageObtain5 = Message.obtain();
                messageObtain5.what = 0;
                messageObtain5.obj = Integer.valueOf(i);
                handler.sendMessage(messageObtain5);
                j++;
            }
        }
    }

    @Override // com.wear.dao.BaseDao
    public void add(CommunMessage communMessage) {
        try {
            if (!WearUtils.e1(communMessage.getData()) && communMessage.getType() != null) {
                if (WearUtils.e1(communMessage.getId())) {
                    communMessage.setId(WearUtils.E());
                }
                if (TextUtils.isEmpty(communMessage.getUserId())) {
                    communMessage.setUserId(ch3.n().p());
                }
                if (communMessage.getCreated() == null) {
                    communMessage.setCreated(new Date());
                }
                if (!communMessage.isEncrypt()) {
                    communMessage.setEncrypt(true);
                }
                this.dao.create(communMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.dao.BaseDao
    public void addIfExist(CommunMessage communMessage) {
        if (WearUtils.e1(communMessage.getData()) || communMessage.getType() == null) {
            return;
        }
        if (TextUtils.isEmpty(communMessage.getUserId())) {
            communMessage.setUserId(ch3.n().p());
        }
        super.addIfExist((CommunMessageDao) communMessage);
    }

    @Override // com.wear.dao.BaseDao
    public void addIfNotExist(CommunMessage communMessage) {
        if (WearUtils.e1(communMessage.getData()) || communMessage.getType() == null) {
            return;
        }
        if (TextUtils.isEmpty(communMessage.getUserId())) {
            communMessage.setUserId(ch3.n().p());
        }
        super.addIfNotExist((CommunMessageDao) communMessage);
    }

    @Override // com.wear.dao.BaseDao
    public CommunMessage findById(String str) {
        try {
            this.dao.queryBuilder().where().eq(TtmlNode.ATTR_ID, str);
            List listQuery = this.dao.queryBuilder().where().eq(TtmlNode.ATTR_ID, str).and().isNotNull("type").query();
            if (listQuery != null && listQuery.size() != 0) {
                return (CommunMessage) listQuery.get(0);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.wear.dao.BaseDao
    public void updateOrAdd(CommunMessage communMessage) {
        if (WearUtils.e1(communMessage.getData()) || communMessage.getType() == null) {
            return;
        }
        if (TextUtils.isEmpty(communMessage.getUserId())) {
            communMessage.setUserId(ch3.n().p());
        }
        super.updateOrAdd((CommunMessageDao) communMessage);
    }

    public void deleteByFriendEmail(String str, int i) {
        String strP = WearUtils.y.p();
        String strI0 = WearUtils.i0(str);
        try {
            DeleteBuilder deleteBuilder = this.dao.deleteBuilder();
            Where<T, ID> where = deleteBuilder.where();
            if (!WearUtils.e1(strP)) {
                strP = nd3.p(strP);
            }
            if (!WearUtils.e1(strI0)) {
                strI0 = nd3.p(strI0);
            }
            where.eq("userId", strP).and().eq("from", strI0).and().eq("sendType", Integer.valueOf(i));
            where.eq("userId", strP).and().eq("to", strI0).and().eq("sendType", Integer.valueOf(i));
            where.or(where, where, new Where[0]);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CommunMessage> findAllMessageWithMedia() {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("type", MessageType.shortvideo).or().eq("type", MessageType.picture).or().eq("type", MessageType.audio).or().eq("type", MessageType.burnvideo).or().eq("type", MessageType.burnpicture);
            return this.dao.query(queryBuilder.prepare());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
