package com.wear.dao;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.j256.ormlite.dao.Dao;
import com.wear.bean.ReCall;
import dc.be3;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class ReCallDao extends BaseDao<ReCall> {
    public void addRecall(String str, String str2, boolean z) {
        ReCall reCall = new ReCall();
        reCall.setId(str);
        reCall.setMsgId(str2);
        reCall.setCanBe(0);
        reCall.setFlag(!z ? 1 : 0);
        addIfNotExist(reCall);
    }

    public void addReceiveReSendPatternRecall(String str, String str2) {
        ReCall reCall = new ReCall();
        reCall.setId(str);
        reCall.setMsgId(str2);
        reCall.setCanBe(0);
        reCall.setFlag(1);
        addIfNotExist(reCall);
    }

    public boolean canPlayPattern(String str, Date date) {
        return (findById(str) == null && be3.B(date, be3.I(), 2)) ? false : true;
    }

    public String canRecall(String str) {
        ReCall recallById = getRecallById(str, 0);
        String msgId = null;
        if (recallById != null) {
            if (recallById.getCanBe() == 0 && be3.B(recallById.getCreated(), be3.I(), 2)) {
                msgId = recallById.getMsgId();
            }
            if (!be3.B(recallById.getCreated(), be3.I(), 2)) {
                try {
                    this.dao.delete((Dao<T, String>) recallById);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return msgId;
    }

    public String getCommunMessageId(String str, int i) {
        ReCall recallByMsgId = getRecallByMsgId(str, i);
        if (recallByMsgId != null) {
            id = be3.B(recallByMsgId.getCreated(), be3.I(), 2) ? recallByMsgId.getId() : null;
            if (!be3.B(recallByMsgId.getCreated(), be3.I(), 2)) {
                try {
                    this.dao.delete((Dao<T, String>) recallByMsgId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    public ReCall getRecallById(String str, int i) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq(TtmlNode.ATTR_ID, str).and().eq("flag", Integer.valueOf(i)).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ReCall) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ReCall getRecallByMsgId(String str, int i) {
        try {
            List listQuery = this.dao.queryBuilder().where().eq("msgId", str).and().eq("flag", Integer.valueOf(i)).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (ReCall) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String receiveCanRecall(String str) {
        ReCall recallByMsgId = getRecallByMsgId(str, 1);
        String id = null;
        if (recallByMsgId != null) {
            if (recallByMsgId.getCanBe() == 0 && be3.B(recallByMsgId.getCreated(), be3.I(), 2)) {
                id = recallByMsgId.getId();
            }
            if (!be3.B(recallByMsgId.getCreated(), be3.I(), 2) || recallByMsgId.getCanBe() == 1) {
                try {
                    this.dao.delete((Dao<T, String>) recallByMsgId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }
}
