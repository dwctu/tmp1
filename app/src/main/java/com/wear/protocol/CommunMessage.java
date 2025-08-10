package com.wear.protocol;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IHandlerCommunMessage;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.nd3;
import dc.ye3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.aspectj.runtime.reflect.SignatureImpl;

@DatabaseTable(tableName = "tb_commun_message")
/* loaded from: classes3.dex */
public class CommunMessage extends BaseEntity implements IHandlerCommunMessage, Serializable {

    @DatabaseField
    private String data;
    private DataEntityAbstract dataBean;
    private String emojiLogType;
    private List<String> feature;

    @DatabaseField
    private String from;

    @DatabaseField
    private boolean isShowEmojiAnim;

    @DatabaseField
    private String msgId;

    @DatabaseField
    private String realFrom;

    @DatabaseField
    private String realFromNickName;

    @DatabaseField
    private String realFromPhoto;

    @DatabaseField
    private String receiveId;

    @DatabaseField
    private String replyData;

    @DatabaseField
    private int sendStatus;

    @DatabaseField
    private int sendType;

    @DatabaseField
    private String status;
    private Object tempMediaData;

    @DatabaseField
    private String to;

    @DatabaseField
    private MessageType type;

    @DatabaseField
    private String userId;

    @DatabaseField
    private String v = SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY;

    /* renamed from: com.wear.protocol.CommunMessage$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$wear$protocol$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$wear$protocol$MessageType = iArr;
            try {
                iArr[MessageType.sync.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.voice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.chat.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.toy.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.pattern.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.audio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.picture.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.alarm.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.live.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.system.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.partnertoy.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.alexa.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.shortvideo.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.wishlist.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.giftcard.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.unsupport.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.burnpicture.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.burnvideo.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.vmsharecard.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public static String decrypt(String str) {
        return nd3.d(str);
    }

    public static String encryp(String str) {
        return nd3.n(str);
    }

    public static String getSecondTimeString(long j) {
        Object objValueOf;
        Object objValueOf2;
        int i = (int) j;
        int i2 = i / 60;
        int i3 = i % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 > 9) {
            objValueOf = Integer.valueOf(i2);
        } else {
            objValueOf = "0" + i2;
        }
        sb.append(objValueOf);
        sb.append(SignatureImpl.INNER_SEP);
        if (i3 > 9) {
            objValueOf2 = Integer.valueOf(i3);
        } else {
            objValueOf2 = "0" + i3;
        }
        sb.append(objValueOf2);
        return sb.toString();
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

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(super.getId(), ((CommunMessage) obj).getId());
    }

    public String getData() {
        return this.data;
    }

    public DataEntityAbstract getDataBean() {
        return this.dataBean;
    }

    public String getEmojiLogType() {
        return this.emojiLogType;
    }

    public List<String> getFeature() {
        return this.feature;
    }

    public String getFrom() {
        String strF = nd3.f(this.from);
        return WearUtils.e1(strF) ? this.from : strF;
    }

    public String getLogType() {
        switch (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[getType().ordinal()]) {
            case 4:
                return "text";
            case 5:
            default:
                return null;
            case 6:
                return "pattern";
            case 7:
                return "audio";
            case 8:
                return "photo";
            case 9:
                return NotificationCompat.CATEGORY_ALARM;
        }
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getOldFrom() {
        return this.from;
    }

    public String getOldRealFrom() {
        return this.realFrom;
    }

    public String getOldTo() {
        return this.to;
    }

    public String getOldUserId() {
        return this.userId;
    }

    public String getRealFrom() {
        if (WearUtils.e1(this.realFrom)) {
            return this.realFrom;
        }
        String strF = nd3.f(this.realFrom);
        return WearUtils.e1(strF) ? this.realFrom : strF;
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

    public int getSendStatus() {
        return this.sendStatus;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getStatus() {
        return this.status;
    }

    public Object getTempMediaData() {
        return this.tempMediaData;
    }

    public String getTo() {
        String strF = nd3.f(this.to);
        return WearUtils.e1(strF) ? this.to : strF;
    }

    public MessageType getType() {
        return this.type;
    }

    public String getUserId() {
        if (WearUtils.e1(this.userId)) {
            return this.userId;
        }
        String strF = nd3.f(this.userId);
        return WearUtils.e1(strF) ? this.userId : strF;
    }

    public String getV() {
        return this.v;
    }

    public boolean isDefinedProtocal(String str) {
        switch (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return true;
            default:
                return false;
        }
    }

    @Override // com.wear.bean.handlerbean.IHandlerCommunMessage
    public boolean isFromGroup() {
        return getFrom().equals(getRealFrom());
    }

    public boolean isSelfMessage(String str) {
        return getFrom().equals(WearUtils.i0(str));
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

    public void sendEntity(DataEntityAbstract dataEntityAbstract) {
        if (dataEntityAbstract == null) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("entity is null"));
            return;
        }
        this.type = dataEntityAbstract.getEntityType();
        if (dataEntityAbstract.getEntityType() == MessageType.system) {
            this.data = encryp(WearUtils.A.toJson(((EntitySystem) dataEntityAbstract).getData()));
        } else {
            this.data = encryp(WearUtils.A.toJson(dataEntityAbstract));
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

    public void setData(String str) {
        this.data = str;
    }

    public void setDataBean(DataEntityAbstract dataEntityAbstract) {
        this.dataBean = dataEntityAbstract;
    }

    public void setEmojiLogType(String str) {
        this.emojiLogType = str;
    }

    public List<String> setFeature() {
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[this.type.ordinal()];
        if (i == 1) {
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_TOUCH_PANEL);
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_ORDER);
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_SOLACE);
        } else if (i == 2 || i == 3) {
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_TOUCH_PANEL);
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_ORDER);
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_SOLACE);
            if (ch3.n().o().isEnableAgoraIO()) {
                arrayList.add(User.EN_ABLE_AGORAIO);
            }
        }
        return arrayList;
    }

    public void setFrom(String str) {
        this.from = nd3.p(str);
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setRealFrom(String str) {
        if (!WearUtils.e1(str)) {
            str = nd3.p(str);
        }
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

    public void setTempMediaData(Object obj) {
        this.tempMediaData = obj;
    }

    public void setTo(String str) {
        this.to = nd3.p(str);
    }

    public void setType(MessageType messageType) {
        this.type = messageType;
    }

    public void setUnEncryptFrom(String str) {
        this.from = str;
    }

    public void setUnEncryptRealFrom(String str) {
        this.realFrom = str;
    }

    public void setUnEncryptTo(String str) {
        this.to = str;
    }

    public void setUserId(String str) {
        if (!WearUtils.e1(str)) {
            str = nd3.p(str);
        }
        this.userId = str;
    }

    public void setV(String str) {
        this.v = str;
    }

    public DataEntityAbstract syncDecryptBean() {
        if (TextUtils.isEmpty(this.data) || getType() == null) {
            ye3.d("Z0030", toString());
            MessageType messageType = MessageType.unsupport;
            setType(messageType);
            EntityUnSupport entityUnSupport = new EntityUnSupport();
            entityUnSupport.setOldType(messageType.toString());
            entityUnSupport.setMessageBody("");
            return entityUnSupport;
        }
        switch (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[getType().ordinal()]) {
            case 1:
                return new EntitySync(this.data);
            case 2:
                return new EntityVideo(this.data);
            case 3:
                return new EntityVoice(this.data);
            case 4:
                return new EntityChat(this.data);
            case 5:
                return new EntityToy(this.data);
            case 6:
                return new EntityPattern(this.data);
            case 7:
                return new EntityAudio(this.data);
            case 8:
                return new EntityPicture(this.data);
            case 9:
                return new EntityAlarm(this.data);
            case 10:
                return new EntityLive(this.data);
            case 11:
                return new EntitySystem(this.data);
            case 12:
                return new EntityPartnerToy(this.data);
            case 13:
                return new EntityAlexa(this.data);
            case 14:
                return new EntityShortVideo(this.data);
            case 15:
                return new EntityWishList(this.data);
            case 16:
                return new EntityGiftCard(this.data);
            case 17:
                return new EntityUnSupport(this.data);
            case 18:
                return new EntityBurnPicture(this.data);
            case 19:
                return new EntityBurnShortVideo(this.data);
            case 20:
                return new EntityVMShareCard(this.data);
            default:
                return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("type:");
        Object obj = this.type;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", fromJid:");
        sb.append(getFrom());
        sb.append(", toJid:");
        sb.append(getTo());
        sb.append(", data:");
        String str = this.data;
        sb.append(str != null ? str : "null");
        sb.append(",creatTime:");
        sb.append(getCreated() == null ? "000" : Long.valueOf(getCreated().getTime()));
        sb.append(", data.decrypt:");
        sb.append(nd3.d(this.data));
        sb.append(", data.encrypt:");
        sb.append(nd3.n(this.data));
        return sb.toString();
    }
}
