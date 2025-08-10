package com.wear.protocol;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class EntityUnSupport extends DataEntityAbstract {
    private String messageBody;
    public String msgId;
    private String oldType;
    public List<EntityChatABean> peopleData;
    public String text;

    public EntityUnSupport() {
        setMsgId(WearUtils.E());
    }

    public static List<CommunMessage> filterMessages(List<CommunMessage> list) {
        if (list != null && list.size() > 0) {
            for (CommunMessage communMessage : list) {
                if (communMessage.getType() == MessageType.unsupport) {
                    EntityUnSupport entityUnSupport = (EntityUnSupport) new Gson().fromJson(CommunMessage.decrypt(communMessage.getData()), EntityUnSupport.class);
                    if (entityUnSupport != null && !WearUtils.e1(entityUnSupport.getOldType())) {
                        String oldType = entityUnSupport.getOldType();
                        if (isSupport(oldType)) {
                            communMessage.setType(MessageType.fromString(oldType));
                            communMessage.setData(entityUnSupport.getMessageBody());
                            communMessage.setDataBean(communMessage.syncDecryptBean());
                            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean isSupport(String str) {
        try {
            MessageType.fromString(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.chat;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getOldType() {
        return this.oldType;
    }

    public List<EntityChatABean> getPeopleData() {
        return this.peopleData;
    }

    public String getText() {
        return this.text;
    }

    public void setMessageBody(String str) {
        this.messageBody = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setOldType(String str) {
        this.oldType = str;
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

    public EntityUnSupport(String str) {
        EntityUnSupport entityUnSupport = (EntityUnSupport) fromJsonToDecrypt(str, EntityUnSupport.class);
        this.text = entityUnSupport.getText();
        this.msgId = entityUnSupport.getMsgId();
        this.peopleData = entityUnSupport.getPeopleData();
    }

    public static CommunMessage filterMessages(CommunMessage communMessage) {
        if (communMessage != null && communMessage.getType() == MessageType.unsupport) {
            EntityUnSupport entityUnSupport = (EntityUnSupport) new Gson().fromJson(CommunMessage.decrypt(communMessage.getData()), EntityUnSupport.class);
            String oldType = entityUnSupport.getOldType();
            if (isSupport(oldType)) {
                communMessage.setType(MessageType.fromString(oldType));
                communMessage.setData(entityUnSupport.getMessageBody());
                communMessage.setDataBean(communMessage.syncDecryptBean());
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            }
        }
        return communMessage;
    }
}
