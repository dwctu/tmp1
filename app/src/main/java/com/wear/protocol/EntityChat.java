package com.wear.protocol;

import androidx.annotation.NonNull;
import com.wear.util.WearUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class EntityChat extends DataEntityAbstract {
    public String msgId;
    public List<EntityChatABean> peopleData;
    public String text;

    public EntityChat() {
        setMsgId(WearUtils.E());
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.chat;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public List<EntityChatABean> getPeopleData() {
        return this.peopleData;
    }

    public String getText() {
        return this.text;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setPeopleData(List<EntityChatABean> list) {
        this.peopleData = list;
    }

    public void setText(String str) {
        this.text = str;
    }

    @NonNull
    public String toString() {
        return "文本信息是：" + this.text;
    }

    public EntityChat(String str) {
        EntityChat entityChat = (EntityChat) fromJsonToDecrypt(str, EntityChat.class);
        this.text = entityChat.getText();
        this.msgId = entityChat.getMsgId();
        this.peopleData = entityChat.getPeopleData();
    }
}
