package com.wear.dao;

import com.wear.bean.data.ChatGPTStoryBean;
import dc.ch3;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTStoryDao.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"Lcom/wear/dao/ChatGPTStoryDao;", "Lcom/wear/dao/BaseDao;", "Lcom/wear/bean/data/ChatGPTStoryBean;", "()V", "findChatGPTStoryByAccount", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTStoryDao extends BaseDao<ChatGPTStoryBean> {
    @Nullable
    public final List<ChatGPTStoryBean> findChatGPTStoryByAccount() {
        try {
            return this.dao.queryBuilder().where().eq("remoteAccountId", ch3.n().o().getRemoteAccountId()).query();
        } catch (Exception unused) {
            return null;
        }
    }
}
