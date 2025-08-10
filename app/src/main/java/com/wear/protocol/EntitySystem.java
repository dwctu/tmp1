package com.wear.protocol;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONLexer;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.ah4;
import io.agora.rtc2.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.jivesoftware.smackx.disco.bean.response.BroadDataBean;

/* loaded from: classes3.dex */
public class EntitySystem extends DataEntityAbstract {
    public ArrayList<EntityArray> data;

    /* renamed from: com.wear.protocol.EntitySystem$1, reason: invalid class name */
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
                $SwitchMap$com$wear$protocol$MessageType[MessageType.pattern.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.audio.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.picture.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.alarm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.live.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.sync.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.video.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$wear$protocol$MessageType[MessageType.voice.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static class C10001Json {
        private int afiiliatation;
        private String byWho;
        private String byWhoNickName;
        private int operationType;
        private String roomId;
        private String showList;
        private List<WhoBean> whos;

        public static class WhoBean {
            private String who;
            private String whoNickName;

            public String getWho() {
                return this.who;
            }

            public String getWhoNickName() {
                return this.whoNickName;
            }

            public void setWho(String str) {
                this.who = str;
            }

            public void setWhoNickName(String str) {
                this.whoNickName = str;
            }
        }

        public int getAfiiliatation() {
            return this.afiiliatation;
        }

        public String getByWho() {
            return this.byWho;
        }

        public String getByWhoNickName() {
            return this.byWhoNickName;
        }

        public int getOperationType() {
            return this.operationType;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public String getShowList() {
            return this.showList;
        }

        public List<WhoBean> getWhos() {
            return this.whos;
        }

        public void setAfiiliatation(int i) {
            this.afiiliatation = i;
        }

        public void setByWho(String str) {
            this.byWho = str;
        }

        public void setByWhoNickName(String str) {
            this.byWhoNickName = str;
        }

        public void setOperationType(int i) {
            this.operationType = i;
        }

        public void setRoomId(String str) {
            this.roomId = str;
        }

        public void setShowList(String str) {
            this.showList = str;
        }

        public void setWhos(List<WhoBean> list) {
            this.whos = list;
        }
    }

    public class EntityArray {
        public String code;
        public String key;
        public String text;
        public String type;

        public EntityArray() {
        }

        public String getCode() {
            return this.code;
        }

        public String getKey() {
            return this.key;
        }

        public SystemOPTCode getSysOPTCode() {
            return SystemOPTCode.fromString(this.code);
        }

        public SystemOPTType getSysOPTType() {
            return SystemOPTType.fromString(this.type);
        }

        public String getText() {
            return this.text;
        }

        public String getType() {
            return this.type;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public enum SystemOPTCode {
        C200(200, "通知对方会自动播放对方的pattern"),
        C201(201, "通知对方始终允许控制"),
        C202(202, "对方版本暂不支持"),
        C203(203, "对方设置黑名单信息提示拒绝接收"),
        C204(204, "正在输入中.."),
        C205(205, "对方在阅后即焚时截图"),
        C300(300, "开启错失闹钟后提示对方"),
        C301(301, "关闭错失闹钟后提示对方"),
        C302(302, "开启错失闹钟自定义信息提示，（text里带信息内容）"),
        C303(303, "关闭错失闹钟自定义提示"),
        C304(304, "打开自动接受好友的控制"),
        C305(305, "关闭自动接受好友的控制"),
        C306(306, "设置好友黑名单通知"),
        C307(307, "解除好友黑名单通知"),
        C308(308, "提示敏感词通知"),
        C309(309, "阅后即焚消息已读通知"),
        C311(311, "设置消息免打扰"),
        C312(312, "解除消息免打扰"),
        C320(320, "消息撤回"),
        C321(321, "消息不允许撤回"),
        C322(322, "论坛在 Remote 约会完, 弹窗后, 点击希望和对方成为好友."),
        C323(323, "论坛在 Remote 约会完, 弹窗后, 点击不希望和对方成为好友."),
        C324(324, "把玩具指令切换到 openfire. 由检测到openfire 有问题(不管是自己还是对方有问题)一方发出."),
        C325(325, "开始群控制信息"),
        C326(326, "结束群控制"),
        C327(327, "开始多控一"),
        C328(328, "结束多控一"),
        C329(329, "control link 成功的系统提示"),
        C666(666, "系统消息"),
        C10000(10000, "[username] is no longer your friend. Send a friend request to chat again."),
        C10001(10001, "群广播消息"),
        C700(TypedValues.TransitionType.TYPE_DURATION, "控制方第一次进入时被控方不在任何聊天室。（还没有进入）"),
        C701(701, "被控方进入聊天室"),
        C702(702, "被控方不在聊天室"),
        C703(Constants.AUDIO_MIXING_REASON_INTERRUPTED_EOF, "发送消息失败显示服务器返回信息"),
        C704(TypedValues.TransitionType.TYPE_AUTO_TRANSITION, "对方掉线发送离线提醒"),
        C705(TypedValues.TransitionType.TYPE_INTERPOLATOR, "对方重连发送重连提醒"),
        C706(TypedValues.TransitionType.TYPE_STAGGERED, "创建者离开聊天室"),
        C707(TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, "control link 加好友"),
        C708(708, "请求控制主动取消"),
        C709(709, "请求控制超时取消"),
        C710(Constants.AUDIO_MIXING_STATE_PLAYING, "创建者拒绝请求控制");

        private int code;

        SystemOPTCode(int i, String str) {
            this.code = i;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static SystemOPTCode fromString(String str) {
            if (str == null) {
                return null;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 49586:
                    if (str.equals("200")) {
                        c = 0;
                        break;
                    }
                    break;
                case 49587:
                    if (str.equals("201")) {
                        c = 1;
                        break;
                    }
                    break;
                case 49588:
                    if (str.equals("202")) {
                        c = 2;
                        break;
                    }
                    break;
                case 49589:
                    if (str.equals("203")) {
                        c = 3;
                        break;
                    }
                    break;
                case 49590:
                    if (str.equals("204")) {
                        c = 4;
                        break;
                    }
                    break;
                case 49591:
                    if (str.equals("205")) {
                        c = 5;
                        break;
                    }
                    break;
                case 50547:
                    if (str.equals("300")) {
                        c = 6;
                        break;
                    }
                    break;
                case 50548:
                    if (str.equals("301")) {
                        c = 7;
                        break;
                    }
                    break;
                case 50549:
                    if (str.equals("302")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 50550:
                    if (str.equals("303")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 50551:
                    if (str.equals("304")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 50552:
                    if (str.equals("305")) {
                        c = 11;
                        break;
                    }
                    break;
                case 50553:
                    if (str.equals("306")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 50554:
                    if (str.equals("307")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 50555:
                    if (str.equals("308")) {
                        c = 14;
                        break;
                    }
                    break;
                case 50556:
                    if (str.equals("309")) {
                        c = 15;
                        break;
                    }
                    break;
                case 50579:
                    if (str.equals("311")) {
                        c = 16;
                        break;
                    }
                    break;
                case 50580:
                    if (str.equals("312")) {
                        c = 17;
                        break;
                    }
                    break;
                case 50609:
                    if (str.equals("320")) {
                        c = 18;
                        break;
                    }
                    break;
                case 50610:
                    if (str.equals("321")) {
                        c = 19;
                        break;
                    }
                    break;
                case 50611:
                    if (str.equals("322")) {
                        c = 20;
                        break;
                    }
                    break;
                case 50612:
                    if (str.equals("323")) {
                        c = 21;
                        break;
                    }
                    break;
                case 50613:
                    if (str.equals("324")) {
                        c = 22;
                        break;
                    }
                    break;
                case 50614:
                    if (str.equals("325")) {
                        c = 23;
                        break;
                    }
                    break;
                case 50615:
                    if (str.equals("326")) {
                        c = 24;
                        break;
                    }
                    break;
                case 50616:
                    if (str.equals("327")) {
                        c = 25;
                        break;
                    }
                    break;
                case 50617:
                    if (str.equals("328")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 50618:
                    if (str.equals("329")) {
                        c = 27;
                        break;
                    }
                    break;
                case 53622:
                    if (str.equals("666")) {
                        c = 28;
                        break;
                    }
                    break;
                case 54391:
                    if (str.equals("700")) {
                        c = 29;
                        break;
                    }
                    break;
                case 54392:
                    if (str.equals("701")) {
                        c = 30;
                        break;
                    }
                    break;
                case 54393:
                    if (str.equals("702")) {
                        c = 31;
                        break;
                    }
                    break;
                case 54394:
                    if (str.equals("703")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 54395:
                    if (str.equals("704")) {
                        c = '!';
                        break;
                    }
                    break;
                case 54396:
                    if (str.equals("705")) {
                        c = Typography.quote;
                        break;
                    }
                    break;
                case 54397:
                    if (str.equals("706")) {
                        c = '#';
                        break;
                    }
                    break;
                case 54398:
                    if (str.equals("707")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case 54399:
                    if (str.equals("708")) {
                        c = '%';
                        break;
                    }
                    break;
                case 54400:
                    if (str.equals("709")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 54422:
                    if (str.equals("710")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 46730161:
                    if (str.equals("10000")) {
                        c = '(';
                        break;
                    }
                    break;
                case 46730162:
                    if (str.equals("10001")) {
                        c = ')';
                        break;
                    }
                    break;
            }
            switch (c) {
            }
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.code);
        }
    }

    public enum SystemOPTType {
        T200(200, "普通提示信息"),
        T201(201, "弹窗类信息"),
        T300(300, "设置类"),
        T400(400, "control link");

        private int code;

        SystemOPTType(int i, String str) {
            this.code = i;
        }

        public static SystemOPTType fromString(String str) {
            if (str == null) {
                return null;
            }
            str.hashCode();
            switch (str) {
            }
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.code);
        }
    }

    public EntitySystem() {
    }

    public void addDataToArray(String str, String str2, String str3) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        EntityArray entityArray = new EntityArray();
        entityArray.setType(str);
        entityArray.setCode(str2);
        entityArray.setText(str3);
        this.data.add(entityArray);
    }

    public ArrayList<EntityArray> getData() {
        return this.data;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.system;
    }

    public String getFirstString() {
        ArrayList<EntityArray> arrayList = this.data;
        return (arrayList == null || arrayList.size() <= 0) ? "" : this.data.get(0).getText();
    }

    public SystemOPTCode getFirstSysOPTCode() {
        ArrayList<EntityArray> arrayList = this.data;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.data.get(0).getSysOPTCode();
    }

    public SystemOPTType getFirstSysOPTType() {
        ArrayList<EntityArray> arrayList = this.data;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.data.get(0).getSysOPTType();
    }

    public String getFirstSysText() {
        ArrayList<EntityArray> arrayList = this.data;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.data.get(0).getText();
    }

    public String getJSONText(BroadDataBean broadDataBean) {
        C10001Json c10001Json = new C10001Json();
        c10001Json.setRoomId(broadDataBean.getRoomId());
        c10001Json.setAfiiliatation(broadDataBean.getAffiliation());
        c10001Json.setOperationType(broadDataBean.getOperationType());
        c10001Json.setByWho(broadDataBean.getByWho());
        c10001Json.setByWhoNickName(broadDataBean.getByWhoNickName());
        c10001Json.setShowList(broadDataBean.getShowList());
        ArrayList arrayList = new ArrayList();
        C10001Json.WhoBean whoBean = new C10001Json.WhoBean();
        whoBean.setWho(broadDataBean.getWho());
        whoBean.setWhoNickName(broadDataBean.getWhoNickName());
        arrayList.add(whoBean);
        c10001Json.setWhos(arrayList);
        return JSON.toJSONString(c10001Json);
    }

    public String getNotificationMessage(MessageType messageType) {
        switch (AnonymousClass1.$SwitchMap$com$wear$protocol$MessageType[messageType.ordinal()]) {
            case 1:
                return "" + ("" + ah4.e(R.string.message_notification_type_chat) + "").toLowerCase();
            case 2:
                return "" + ("" + ah4.e(R.string.message_notification_type_pattern) + "").toLowerCase();
            case 3:
                return "" + ("" + ah4.e(R.string.message_notification_type_audio) + "").toLowerCase();
            case 4:
                return "" + ("" + ah4.e(R.string.message_notification_type_picture) + "").toLowerCase();
            case 5:
                return "" + ("" + ah4.e(R.string.message_notification_type_alarm) + "").toLowerCase();
            case 6:
                return "" + ("" + ah4.e(R.string.message_notification_type_live) + "").toLowerCase();
            case 7:
                return "" + ("" + ah4.e(R.string.message_notification_type_sync) + "").toLowerCase();
            case 8:
                return "" + ("" + ah4.e(R.string.message_notification_type_video) + "").toLowerCase();
            case 9:
                return "" + ("" + ah4.e(R.string.message_notification_type_voice) + "").toLowerCase();
            default:
                return "";
        }
    }

    public C10001Json getObjectFromJson() {
        try {
            return (C10001Json) JSON.parseObject(getFirstString(), C10001Json.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSystemMessage() {
        ArrayList<EntityArray> arrayList = this.data;
        return (arrayList == null || arrayList.size() <= 0) ? "" : (WearUtils.e1(this.data.get(0).key) || WearUtils.e1(ah4.g(this.data.get(0).getKey()))) ? this.data.get(0).getText() : ah4.g(this.data.get(0).getKey());
    }

    public void setData(ArrayList<EntityArray> arrayList) {
        this.data = arrayList;
    }

    public EntitySystem(String str) {
        EntitySystem entitySystem = (EntitySystem) fromJsonToDecrypt(CommunMessage.encryp("{\"data\":" + CommunMessage.decrypt(str) + "}"), EntitySystem.class);
        if (entitySystem != null) {
            this.data = entitySystem.getData();
        }
    }
}
