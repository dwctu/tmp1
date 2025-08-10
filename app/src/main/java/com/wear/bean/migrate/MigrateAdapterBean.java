package com.wear.bean.migrate;

import com.google.firebase.messaging.Constants;
import com.wear.bean.SyncWsProtocol;
import com.wear.dao.DaoUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class MigrateAdapterBean {
    private Date created;
    private String data;
    private String email;
    private String friendName;
    private String from;
    private String id;
    private boolean isAtMe;
    private boolean isBlock;
    private boolean isBlur;
    private boolean isEncrypt;
    private boolean isRead;
    private boolean isSend;
    private boolean isShowEmojiAnim;
    private String messageType;
    private String other;
    private String realFrom;
    private String realFromNickName;
    private String realFromPhoto;
    private String receiveId;
    private String replyData;
    private String roomMsgId;
    private int sendStatus;
    private int sendType;
    private String status;
    private double timeStamp;
    private String to;
    private String type;
    private int error = 0;
    private boolean isComing = false;
    private String v = SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY;

    public static boolean checkFields() {
        List<String> allDbFields = getAllDbFields();
        List<String> allFields = getAllFields();
        allFields.remove("error");
        allFields.remove("isSend");
        allFields.remove("isRead");
        allFields.remove("isComing");
        allFields.remove("timeStamp");
        allFields.remove("other");
        allFields.remove(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        allFields.remove("friendName");
        allFields.remove("isBlock");
        allFields.remove("isBlur");
        allFields.remove("isAtMe");
        allDbFields.remove("ownerJid");
        allDbFields.remove("friendJid");
        allFields.remove("email");
        allDbFields.remove("userId");
        allFields.remove("roomMsgId");
        allDbFields.remove("msgId");
        return allDbFields.size() <= allFields.size();
    }

    private static List<String> getAllDbFields() {
        ArrayList arrayList = new ArrayList();
        List<String> listFindAllCols = DaoUtils.getCommunMessageDao().findAllCols();
        List<String> listFindAllCols2 = DaoUtils.getMessageUnReadDao().findAllCols();
        List<String> listFindAllCols3 = DaoUtils.getMessageHideDao().findAllCols();
        arrayList.addAll(listFindAllCols);
        arrayList.addAll(listFindAllCols2);
        arrayList.addAll(listFindAllCols3);
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<String> getAllFields() {
        ArrayList arrayList = new ArrayList();
        for (Field field : MigrateAdapterBean.class.getDeclaredFields()) {
            arrayList.add(field.getName());
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Date getCreated() {
        return this.created;
    }

    public String getData() {
        return this.data;
    }

    public String getEmail() {
        return this.email;
    }

    public int getError() {
        return this.error;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        return this.id;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public String getOther() {
        return this.other;
    }

    public String getRealFrom() {
        return this.realFrom;
    }

    public String getRealFromNickName() {
        return this.realFromNickName;
    }

    public String getRealFromPhoto() {
        return this.realFromPhoto;
    }

    public String getReceiveId() {
        return this.receiveId;
    }

    public String getReplyData() {
        return this.replyData;
    }

    public String getRoomMsgId() {
        return this.roomMsgId;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getStatus() {
        return this.status;
    }

    public double getTimeStamp() {
        return this.timeStamp;
    }

    public String getTo() {
        return this.to;
    }

    public String getType() {
        return this.type;
    }

    public String getV() {
        return this.v;
    }

    public boolean isAtMe() {
        return this.isAtMe;
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean isBlur() {
        return this.isBlur;
    }

    public boolean isComing() {
        return this.isComing;
    }

    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public boolean isSend() {
        return this.isSend;
    }

    public boolean isShowEmojiAnim() {
        return this.isShowEmojiAnim;
    }

    public void setAtMe(boolean z) {
        this.isAtMe = z;
    }

    public void setBlock(boolean z) {
        this.isBlock = z;
    }

    public void setBlur(boolean z) {
        this.isBlur = z;
    }

    public void setComing(boolean z) {
        this.isComing = z;
    }

    public void setCreated(Date date) {
        this.created = date;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEncrypt(boolean z) {
        this.isEncrypt = z;
    }

    public void setError(int i) {
        this.error = i;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public void setOther(String str) {
        this.other = str;
    }

    public void setRead(boolean z) {
        this.isRead = z;
    }

    public void setRealFrom(String str) {
        this.realFrom = str;
    }

    public void setRealFromNickName(String str) {
        this.realFromNickName = str;
    }

    public void setRealFromPhoto(String str) {
        this.realFromPhoto = str;
    }

    public void setReceiveId(String str) {
        this.receiveId = str;
    }

    public void setReplyData(String str) {
        this.replyData = str;
    }

    public void setRoomMsgId(String str) {
        this.roomMsgId = str;
    }

    public void setSend(boolean z) {
        this.isSend = z;
    }

    public void setSendStatus(int i) {
        this.sendStatus = i;
    }

    public void setSendType(int i) {
        this.sendType = i;
    }

    public void setShowEmojiAnim(boolean z) {
        this.isShowEmojiAnim = z;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimeStamp(double d) {
        this.timeStamp = d;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setV(String str) {
        this.v = str;
    }

    public String toString() {
        return "MigrateAdapterBean{id='" + this.id + "', email='" + this.email + "', from='" + this.from + "', to='" + this.to + "', type='" + this.type + "', data='" + this.data + "', created=" + this.created + ", error=" + this.error + ", isSend=" + this.isSend + ", isRead=" + this.isRead + ", isComing=" + this.isComing + ", timeStamp=" + this.timeStamp + ", other='" + this.other + "', friendName='" + this.friendName + "', isBlock=" + this.isBlock + ", isBlur=" + this.isBlur + ", sendType=" + this.sendType + ", messageType='" + this.messageType + "', sendStatus=" + this.sendStatus + ", receiveId='" + this.receiveId + "', roomMsgId='" + this.roomMsgId + "', realFrom='" + this.realFrom + "', realFromNickName='" + this.realFromNickName + "', realFromPhoto='" + this.realFromPhoto + "', isAtMe=" + this.isAtMe + ", isShowEmojiAnim=" + this.isShowEmojiAnim + ", replyData='" + this.replyData + "', status='" + this.status + "', v='" + this.v + "', isEncrypt=" + this.isEncrypt + MessageFormatter.DELIM_STOP;
    }
}
