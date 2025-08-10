package com.wear.dao;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.j256.ormlite.table.TableUtils;
import com.wear.bean.EmojiFavorite;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.zt3;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class EmojiFavoriteDao extends BaseDao<EmojiFavorite> {
    public void cleanRecords() {
        try {
            TableUtils.clearTable(this.dao.getConnectionSource(), EmojiFavorite.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllOwner(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        try {
            this.dao.executeRawNoArgs("delete from tb_emoji_favorite where \"owner\"=" + nd3.p(str));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmojiFavorite getEmojiRecord(String str, String str2) {
        if (str == null) {
            str = "";
        }
        try {
            List listQuery = this.dao.queryBuilder().where().eq("owner", nd3.p(str)).and().eq(TtmlNode.ATTR_ID, str2).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return null;
            }
            return (EmojiFavorite) listQuery.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<EmojiFavorite> getListEmojiRecord(String str, String str2) {
        if (str == null) {
            str = "";
        }
        try {
            return this.dao.queryBuilder().where().eq("owner", nd3.p(str)).and().eq(TtmlNode.ATTR_ID, str2).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public boolean hasEmojiResource(String str) {
        EmojiFavorite emojiRecord = getEmojiRecord(zt3.k, str);
        if (emojiRecord != null && !WearUtils.e1(emojiRecord.getEmojiId()) && new File(WearUtils.Y(), WearUtils.r0(emojiRecord.getEmojiId())).exists()) {
            return true;
        }
        List<FavoriteEmojisBean> list = WearUtils.E;
        if (list != null && list.size() > 0) {
            for (FavoriteEmojisBean favoriteEmojisBean : WearUtils.E) {
                if (!WearUtils.e1(favoriteEmojisBean.getFileMd5()) && !WearUtils.e1(str) && favoriteEmojisBean.getFileMd5().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeEmojiFavorite(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        try {
            List listQuery = this.dao.queryBuilder().where().eq("owner", nd3.p(zt3.k)).and().eq(TtmlNode.ATTR_ID, str).query();
            if (listQuery == null || listQuery.size() <= 0) {
                return;
            }
            Iterator it = listQuery.iterator();
            while (it.hasNext()) {
                delT((EmojiFavorite) it.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEmojiFavorites(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            removeEmojiFavorite(it.next());
        }
    }
}
