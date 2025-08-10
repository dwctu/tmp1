package com.wear.bean;

import com.wear.bean.SwitchBean;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import dc.og3;
import dc.xg3;

/* loaded from: classes3.dex */
public class SwitchBeanFeaturesConfig implements SwitchBean.ToEntity {
    public static final int SWITCH_KEY_FEATURES_CONFIG = 2;
    public static final int alarmKey = 4;
    public static final int alexaKey = 1;
    public static final int controllinkKey = 2;
    public static final int loginErrorKey = 12;
    public static final int loginKey = 10;
    public static final int openfireSocketIo = 8;
    public static final int pinCodeOpenStatus = 9;
    public static final int quakeKey = 11;
    public static final int recallKey = 3;
    public static final int voiceKey = 5;
    private Entity bean;
    private String values;

    public class Entity {
        private VersionEntity A0001;
        private VersionEntity A0002;
        private VersionEntity A0003;
        private VersionEntity A0004;
        private VersionEntity A0005;
        private VersionEntity A0007;
        private VersionEntity A0008;
        private VersionEntity C0001;
        private VersionEntity L0003;
        private VersionEntity L0004;

        public Entity() {
        }

        public VersionEntity getA0001() {
            return this.A0001;
        }

        public VersionEntity getA0002() {
            return this.A0002;
        }

        public VersionEntity getA0003() {
            return this.A0003;
        }

        public VersionEntity getA0004() {
            return this.A0004;
        }

        public VersionEntity getA0005() {
            return this.A0005;
        }

        public VersionEntity getA0007() {
            return this.A0007;
        }

        public VersionEntity getA0008() {
            return this.A0008;
        }

        public VersionEntity getC0001() {
            return this.C0001;
        }

        public VersionEntity getL0003() {
            return this.L0003;
        }

        public VersionEntity getL0004() {
            return this.L0004;
        }

        public void setA0001(VersionEntity versionEntity) {
            this.A0001 = versionEntity;
        }

        public void setA0002(VersionEntity versionEntity) {
            this.A0002 = versionEntity;
        }

        public void setA0003(VersionEntity versionEntity) {
            this.A0003 = versionEntity;
        }

        public void setA0004(VersionEntity versionEntity) {
            this.A0004 = versionEntity;
        }

        public void setA0005(VersionEntity versionEntity) {
            this.A0005 = versionEntity;
        }

        public void setA0007(VersionEntity versionEntity) {
            this.A0007 = versionEntity;
        }

        public void setA0008(VersionEntity versionEntity) {
            this.A0008 = versionEntity;
        }

        public void setC0001(VersionEntity versionEntity) {
            this.C0001 = versionEntity;
        }

        public void setL0003(VersionEntity versionEntity) {
            this.L0003 = versionEntity;
        }

        public void setL0004(VersionEntity versionEntity) {
            this.L0004 = versionEntity;
        }
    }

    public class VersionEntity {
        private String minAsv;
        private String minIsv;
        private String minPsv;
        private int status = 0;

        public VersionEntity() {
        }

        public String getMinAsv() {
            return this.minAsv;
        }

        public String getMinIsv() {
            return this.minIsv;
        }

        public String getMinPsv() {
            return this.minPsv;
        }

        public int getStatus() {
            return this.status;
        }

        public void setMinAsv(String str) {
            this.minAsv = str;
        }

        public void setMinIsv(String str) {
            this.minIsv = str;
        }

        public void setMinPsv(String str) {
            this.minPsv = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }
    }

    @Override // com.wear.bean.SwitchBean.ToEntity
    public void decode(boolean z) {
        SwitchBean byKey;
        if (WearUtils.e1(this.values) && (byKey = DaoUtils.getSwitchDao().getByKey(2)) != null) {
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
        WearUtils.x.i0(2, this);
        if (z) {
            try {
                DaoUtils.getSwitchDao().save(2, WearUtils.A.toJson(this.bean));
            } catch (Exception unused2) {
            }
        }
        xg3.i().a = og3.a(4);
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
            DaoUtils.getSwitchDao().save(2, this.values);
        }
    }

    @Override // com.wear.bean.SwitchBean.ToEntity
    public Entity getEntity() {
        return this.bean;
    }
}
