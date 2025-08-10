package com.wear.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import com.wear.protocol.MessageType;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import com.wear.util.WearUtils;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class ControlLinkCommunMessageDao extends BaseDao<ControlLinkCommunMessage> {
    public void clearMessages() {
        try {
            Dao<T, String> dao = this.dao;
            if (dao == 0 || dao.getConnectionSource() == null) {
                return;
            }
            TableUtils.clearTable(this.dao.getConnectionSource(), ControlLinkCommunMessage.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delMessages(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("dateImTypeData", str);
            delTs(this.dao.query(queryBuilder.prepare()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ControlLinkCommunMessage> findByAll() {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("dateImType", "control_link");
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ControlLinkCommunMessage> findByPage(String str, int i, int i2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("dateImTypeData", str).and().eq("sendType", 0).and().notIn("msgType", MessageType.live).and().notIn("msgType", MessageType.sync);
            queryBuilder.orderBy("createTime", false).offset(i * i2).limit(i2);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ControlLinkCommunMessage findLastControlMessage(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("dateImTypeData", str).and().eq("sendType", 0);
            where.eq("msgType", MessageType.live).or().eq("msgType", MessageType.sync);
            where.and(where, where, new Where[0]);
            queryBuilder.orderBy("createTime", false).offset(0).limit(1);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ControlLinkCommunMessage) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ControlLinkCommunMessage findLastMessage(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("fromId", str).and().eq("toId", str2).and().eq("sendType", 0);
            where.eq("fromId", str2).and().eq("toId", str).and().eq("sendType", 0);
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("createTime", false).offset(0).limit(1);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ControlLinkCommunMessage) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ControlLinkCommunMessage findLastReceiveMessage(String str) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (WearUtils.e1(str)) {
            return null;
        }
        QueryBuilder queryBuilder = this.dao.queryBuilder();
        queryBuilder.orderBy("createTime", false).offset(0).limit(1);
        queryBuilder.where().isNotNull("fromId").and().eq("toId", str).and().eq("sendType", 0);
        List listQuery = this.dao.query(queryBuilder.prepare());
        if (listQuery != null && listQuery.size() > 0) {
            return (ControlLinkCommunMessage) listQuery.get(0);
        }
        return null;
    }

    public List<ControlLinkCommunMessage> findShowEmojiAnimMessages(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("fromId", str).and().eq("toId", str2).and().eq("sendType", 0).and().eq("isShowEmojiAnim", Boolean.TRUE);
            queryBuilder.orderBy("createTime", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean findStartMessage(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("dateImTypeData", str).and().eq("dateImType", "control_link");
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery != null) {
                return listQuery.size() > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ControlLinkCommunMessage getLastUnreadMessage(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.orderBy("createTime", false).offset(0).limit(1);
            queryBuilder.where().eq("isRead", Boolean.FALSE).and().eq("dateImTypeData", str).and().eq("dateImType", "control_link").and().eq("sendType", 0);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ControlLinkCommunMessage) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ControlLinkCommunMessage getMessage(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("msgId", str);
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ControlLinkCommunMessage) listQuery.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ControlLinkCommunMessage> getMessages(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            Where<T, ID> where = queryBuilder.where();
            where.eq("fromId", str).and().eq("toId", str2).and().eq("sendType", 0);
            where.eq("toId", str).and().eq("fromId", str2).and().eq("sendType", 0);
            where.or(where, where, new Where[0]);
            queryBuilder.orderBy("createTime", false);
            return this.dao.query(queryBuilder.prepare());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ControlLinkCommunMessage> getUnReadMessage(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().and().eq("isRead", Boolean.FALSE).and().eq("dateImTypeData", str).and().eq("dateImType", "control_link").and().eq("sendType", 0);
            return this.dao.query(queryBuilder.prepare());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getUnReadMessageCount(String str, String str2) {
        List<ControlLinkCommunMessage> unReadMessage = getUnReadMessage(str);
        if (unReadMessage != null) {
            return unReadMessage.size();
        }
        return 0;
    }

    public boolean isAddMessage(String str) {
        try {
            QueryBuilder queryBuilder = this.dao.queryBuilder();
            queryBuilder.where().eq("msgId", str).and().eq("dateImType", "control_link");
            List listQuery = this.dao.query(queryBuilder.prepare());
            if (listQuery != null) {
                return listQuery.size() > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.wear.dao.BaseDao
    public void add(ControlLinkCommunMessage controlLinkCommunMessage) {
        try {
            if (WearUtils.e1(controlLinkCommunMessage.getId())) {
                controlLinkCommunMessage.setId(WearUtils.E());
            }
            if (controlLinkCommunMessage.getCreated() == null) {
                controlLinkCommunMessage.setCreated(new Date());
            }
            if (!controlLinkCommunMessage.isEncrypt()) {
                controlLinkCommunMessage.setEncrypt(true);
            }
            this.dao.create(controlLinkCommunMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
