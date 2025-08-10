package com.wear.protocol.controlLink;

import android.text.TextUtils;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IHandlerCommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAlexa;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityControlLinkTimer;
import com.wear.protocol.EntityControllink;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPartnerToy;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityToy;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.nd3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

@DatabaseTable(tableName = "tb_control_link_commun_message")
/* loaded from: classes3.dex */
public class ControlLinkCommunMessage extends BaseEntity implements IHandlerCommunMessage {

    @DatabaseField
    private long createTime;
    private DataEntityAbstract dataBean;

    @DatabaseField
    private String dateImType;

    @DatabaseField
    private String dateImTypeData;

    @DatabaseField
    private String extJsonStr;

    @DatabaseField
    private String fromId;

    @DatabaseField
    private boolean isRead;

    @DatabaseField
    private boolean isShowEmojiAnim;

    @DatabaseField
    private String msgData;

    @DatabaseField
    private String msgId;
    private String msgSendData;

    @DatabaseField
    private MessageType msgType;

    @DatabaseField
    private int msgVer;

    @DatabaseField
    private String receiveId;

    @DatabaseField
    private int sendStatus;

    @DatabaseField
    private int sendType;

    @DatabaseField
    private String status;

    @DatabaseField
    private String toId;

    /* renamed from: com.wear.protocol.controlLink.ControlLinkCommunMessage$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$wear$protocol$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$wear$protocol$MessageType = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.toy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.pattern.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.audio.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.picture.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.alarm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.live.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.sync.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.video.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.system.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.partnertoy.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.alexa.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.voice.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.shortvideo.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.controllink.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.controllinktimer.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.unsupport.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public static String decrypt(String str) {
        return nd3.d(str);
    }

    public static String encryp(String str) {
        return nd3.n(str);
    }

    public static String encrypXY(String str, String str2, String str3) {
        return nd3.x(str, str2, str3);
    }

    public static long getTimeToSecond(String str) {
        long j = 0;
        try {
            int length = str.split(SignatureImpl.INNER_SEP).length;
            for (int i = 0; i < length; i++) {
                j = (long) (j + (Integer.parseInt(r12[i]) * Math.pow(60.0d, (length - i) - 1)));
            }
        } catch (Exception unused) {
        }
        return j;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public DataEntityAbstract getDataBean() {
        return this.dataBean;
    }

    public String getDateImType() {
        return this.dateImType;
    }

    public String getDateImTypeData() {
        return this.dateImTypeData;
    }

    public String getExtJsonStr() {
        return this.extJsonStr;
    }

    public List<String> getFeature() {
        Map map;
        if (TextUtils.isEmpty(this.extJsonStr) || (map = (Map) WearUtils.A.fromJson(this.extJsonStr, Map.class)) == null || !map.containsKey("feature")) {
            return null;
        }
        return (List) map.get("feature");
    }

    public String getFromId() {
        return this.fromId;
    }

    public String getMsgData() {
        return this.msgData;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getMsgSendData() {
        return this.msgSendData;
    }

    public MessageType getMsgType() {
        return this.msgType;
    }

    public int getMsgVer() {
        return this.msgVer;
    }

    public String getReceiveId() {
        return this.receiveId;
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

    public String getToId() {
        return this.toId;
    }

    public String initExtJsonStr() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(User.FEATURE_IS_SUPPORT_CONTROLLINK_PERMISSION_REQUEST);
        if (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[this.msgType.ordinal()] != 8) {
            arrayList.add(User.FEATURE_IS_SUPPORT_CONTROLLINK_FRIEND_REQUEST);
        } else {
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_TOUCH_PANEL);
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_ORDER);
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_SOLACE);
        }
        map.put("feature", arrayList);
        return WearUtils.A.toJson(map);
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public boolean isFromGroup() {
        return false;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public boolean isSelfMessage(String str) {
        return getFromId().equals(str);
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public boolean isSendIng() {
        DataEntityAbstract dataEntityAbstract = this.dataBean;
        return (dataEntityAbstract == null || dataEntityAbstract.needReceiptReceived()) && this.sendStatus == 2;
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public boolean isSendSuc() {
        return this.sendStatus == 0;
    }

    public boolean isShowEmojiAnim() {
        return this.isShowEmojiAnim;
    }

    public void sendEntity(DataEntityAbstract dataEntityAbstract, String str, String str2) {
        if (dataEntityAbstract == null || WearUtils.e1(str) || WearUtils.e1(str2)) {
            return;
        }
        this.msgType = dataEntityAbstract.getEntityType();
        if (dataEntityAbstract.getEntityType() == MessageType.system) {
            EntitySystem entitySystem = (EntitySystem) dataEntityAbstract;
            this.msgData = encryp(WearUtils.A.toJson(entitySystem.getData()));
            this.msgSendData = encrypXY(WearUtils.A.toJson(entitySystem.getData()), str, str2);
        } else {
            this.msgData = encryp(WearUtils.A.toJson(dataEntityAbstract));
            this.msgSendData = encrypXY(WearUtils.A.toJson(dataEntityAbstract), str, str2);
        }
        this.dataBean = dataEntityAbstract;
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public void sendFail() {
        setSendStatus(4);
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public void sendSuc() {
        setSendStatus(0);
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public void sendSucImg() {
        setSendStatus(2);
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setDataBean(DataEntityAbstract dataEntityAbstract) {
        this.dataBean = dataEntityAbstract;
    }

    public void setDateImType(String str) {
        this.dateImType = str;
    }

    public void setDateImTypeData(String str) {
        this.dateImTypeData = str;
    }

    public void setExtJsonStr(String str) {
        this.extJsonStr = str;
    }

    public void setFromId(String str) {
        this.fromId = str;
    }

    public void setMsgData(String str) {
        this.msgData = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setMsgSendData(String str) {
        this.msgSendData = str;
    }

    public void setMsgType(MessageType messageType) {
        this.msgType = messageType;
    }

    public void setMsgVer(int i) {
        this.msgVer = i;
    }

    public void setRead(boolean z) {
        this.isRead = z;
    }

    public void setReceiveId(String str) {
        this.receiveId = str;
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

    public void setToId(String str) {
        this.toId = str;
    }

    public DataEntityAbstract syncDecryptBean() {
        switch (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[getMsgType().ordinal()]) {
            case 1:
                return new EntityChat(this.msgData);
            case 2:
                return new EntityToy(this.msgData);
            case 3:
                return new EntityPattern(this.msgData);
            case 4:
                return new EntityAudio(this.msgData);
            case 5:
                return new EntityPicture(this.msgData);
            case 6:
                return new EntityAlarm(this.msgData);
            case 7:
                return new EntityLive(this.msgData);
            case 8:
                return new EntitySync(this.msgData);
            case 9:
                return new EntityVideo(this.msgData);
            case 10:
                return new EntitySystem(this.msgData);
            case 11:
                return new EntityPartnerToy(this.msgData);
            case 12:
                return new EntityAlexa(this.msgData);
            case 13:
                return new EntityVoice(this.msgData);
            case 14:
                return new EntityShortVideo(this.msgData);
            case 15:
                return new EntityControllink(this.msgData);
            case 16:
                return new EntityControlLinkTimer(this.msgData);
            case 17:
                return new EntityUnSupport(this.msgData);
            default:
                return null;
        }
    }

    public void setMsgSendData(DataEntityAbstract dataEntityAbstract, String str, String str2) {
        this.msgSendData = encrypXY(WearUtils.A.toJson(dataEntityAbstract), str, str2);
    }

    public void sendEntity(DataEntityAbstract dataEntityAbstract) {
        if (dataEntityAbstract != null) {
            this.msgType = dataEntityAbstract.getEntityType();
            if (dataEntityAbstract.getEntityType() == MessageType.system) {
                this.msgData = encryp(WearUtils.A.toJson(((EntitySystem) dataEntityAbstract).getData()));
            } else {
                this.msgData = encryp(WearUtils.A.toJson(dataEntityAbstract));
            }
            this.dataBean = dataEntityAbstract;
        }
    }
}
