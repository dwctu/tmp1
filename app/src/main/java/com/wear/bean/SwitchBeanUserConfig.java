package com.wear.bean;

import com.wear.bean.SwitchBean;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class SwitchBeanUserConfig implements SwitchBean.ToEntity {
    public static final int SWITCH_KEY_USER_CONFIG = 1;
    public static final int notificationCallKey = 3;
    public static final int notificationKey = 1;
    public static final int notificationPreviewKey = 4;
    public static final int notificationSoundKey = 2;
    private Entity bean;
    private String values;

    public class Entity {
        private int notification = 1;
        private int notificationSound = 1;
        private int notificationCall = 1;
        private int notificationPreview = 1;

        public Entity() {
        }

        public int getNotification() {
            setNotification(this.notification);
            return this.notification;
        }

        public int getNotificationCall() {
            setNotificationCall(this.notificationCall);
            return this.notificationCall;
        }

        public int getNotificationPreview() {
            setNotificationPreview(this.notificationPreview);
            return this.notificationPreview;
        }

        public int getNotificationSound() {
            setNotificationSound(this.notificationSound);
            return this.notificationSound;
        }

        public void setNotification(int i) {
            this.notification = i;
        }

        public void setNotificationCall(int i) {
            this.notificationCall = i;
        }

        public void setNotificationPreview(int i) {
            this.notificationPreview = i;
        }

        public void setNotificationSound(int i) {
            this.notificationSound = i;
        }
    }

    @Override // com.wear.bean.SwitchBean.ToEntity
    public void decode(boolean z) {
        SwitchBean byKey;
        if (WearUtils.e1(this.values) && (byKey = DaoUtils.getSwitchDao().getByKey(1)) != null) {
            this.values = byKey.getValues();
        }
        if (!WearUtils.e1(this.values)) {
            try {
                this.bean = (Entity) WearUtils.A.fromJson(this.values, Entity.class);
            } catch (Exception unused) {
            }
        }
        if (this.bean == null) {
            this.bean = new Entity();
        }
        WearUtils.x.i0(1, this);
        if (z) {
            DaoUtils.getSwitchDao().save(1, WearUtils.A.toJson(this.bean));
        }
    }

    @Override // com.wear.bean.SwitchBean.ToEntity
    public void setValues(String str) {
        this.values = str;
    }

    @Override // com.wear.bean.SwitchBean.ToEntity
    public void update2Db() {
        Entity entity = this.bean;
        if (entity != null) {
            setValues(WearUtils.A.toJson(entity));
            DaoUtils.getSwitchDao().save(1, this.values);
        }
    }

    @Override // com.wear.bean.SwitchBean.ToEntity
    public Entity getEntity() {
        return this.bean;
    }
}
