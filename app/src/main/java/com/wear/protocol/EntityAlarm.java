package com.wear.protocol;

import com.wear.bean.AlarmListItems;
import com.wear.util.WearUtils;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class EntityAlarm extends DataEntityAbstract {
    public String id;
    public String msgId;
    public String name;
    public String notiType;
    public int notify;
    public PatternBean pattern;
    public String soundurl;
    public String type;
    public int version;

    public enum AlarmNotiType {
        pattern,
        sound;

        public static AlarmNotiType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public enum AlarmOPTType {
        delete,
        pattern;

        public static AlarmOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public class PatternBean implements Serializable {
        public String[] dates;
        public String frequency;
        public String missMsg;
        public String time;
        public String url;

        public PatternBean(String str) {
            this.url = str;
        }

        public String[] getDates() {
            return this.dates;
        }

        public String getFrequency() {
            return this.frequency;
        }

        public String getMissMsg() {
            return this.missMsg;
        }

        public String getTime() {
            return this.time;
        }

        public String getUrl() {
            return this.url;
        }

        public void setDates(String[] strArr) {
            this.dates = strArr;
        }

        public void setFrequency(String str) {
            this.frequency = str;
        }

        public void setMissMsg(String str) {
            this.missMsg = str;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public EntityAlarm() {
        this.notify = 0;
        this.version = 1;
    }

    public EntityAlarm copy() {
        EntityAlarm entityAlarm = new EntityAlarm();
        entityAlarm.setId(getId());
        entityAlarm.setType(getType());
        entityAlarm.setName(getName());
        entityAlarm.setNotify(getNotify());
        entityAlarm.setVersion(getVersion());
        entityAlarm.setNotiType(getNotiType());
        entityAlarm.setSoundurl(getSoundurl());
        entityAlarm.setMsgId(getMsgId());
        PatternBean patternBean = new PatternBean(getPattern().getUrl());
        patternBean.setTime(getPattern().getTime());
        patternBean.setFrequency(getPattern().getFrequency());
        patternBean.setDates(getPattern().getDates());
        entityAlarm.setPattern(patternBean);
        return entityAlarm;
    }

    public AlarmNotiType getAlarmNotiType() {
        return AlarmNotiType.fromString(this.notiType);
    }

    public AlarmOPTType getAlarmOPTType() {
        return AlarmOPTType.fromString(this.type);
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.alarm;
    }

    public String getId() {
        return this.id;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getName() {
        return this.name;
    }

    public String getNotiType() {
        return this.notiType;
    }

    public int getNotify() {
        return this.notify;
    }

    public PatternBean getPattern() {
        return this.pattern;
    }

    public String getSoundurl() {
        return this.soundurl;
    }

    public String getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotiType(String str) {
        this.notiType = str;
    }

    public void setNotify(int i) {
        this.notify = i;
    }

    public void setPattern(PatternBean patternBean) {
        this.pattern = patternBean;
    }

    public void setSoundurl(String str) {
        this.soundurl = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setPattern(AlarmListItems alarmListItems, String str) {
        PatternBean patternBean = new PatternBean(str);
        this.pattern = patternBean;
        patternBean.setTime(alarmListItems.getSendTime());
        this.pattern.setFrequency(alarmListItems.getFrequency());
        this.pattern.setDates((String[]) WearUtils.A.fromJson(alarmListItems.getDates(), String[].class));
    }

    public EntityAlarm(String str) {
        this.notify = 0;
        this.version = 1;
        EntityAlarm entityAlarm = (EntityAlarm) fromJsonToDecrypt(str, EntityAlarm.class);
        this.id = entityAlarm.getId();
        this.name = entityAlarm.getName();
        this.type = entityAlarm.getType();
        this.version = entityAlarm.getVersion();
        this.notify = entityAlarm.getNotify();
        this.notiType = entityAlarm.getNotiType();
        this.soundurl = entityAlarm.getSoundurl();
        this.pattern = entityAlarm.getPattern();
        this.msgId = entityAlarm.getMsgId();
    }
}
