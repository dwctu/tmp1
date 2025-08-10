package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_setting")
/* loaded from: classes3.dex */
public class Setting extends BaseEntity {

    @DatabaseField
    private Boolean acceptPrivacyLogs;

    @DatabaseField
    private Boolean autoLastLevel;

    @DatabaseField
    private Boolean autoSwithOff;

    @DatabaseField
    private int chatType;

    @DatabaseField
    private boolean firstInit;

    @DatabaseField
    private int playMusicModel;

    @DatabaseField
    private boolean sortKey;

    @DatabaseField
    private int theme;

    @DatabaseField
    private int weakPasswordRed;

    @DatabaseField
    private int weakPasswordV;

    public Setting() {
    }

    public Boolean getAcceptPrivacyLogs() {
        return this.acceptPrivacyLogs;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean getAutoLastLevel(java.lang.String r4) {
        /*
            r3 = this;
            com.wear.dao.TestValueDao r0 = com.wear.dao.DaoUtils.getTestValueDao()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r3.getId()
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            java.lang.String r4 = dc.nd3.u(r4)
            java.lang.String r1 = "toyAutoLastLevel"
            com.wear.bean.TestValue r4 = r0.getExistKey(r4, r1)
            if (r4 == 0) goto L50
            java.lang.String r0 = r4.getValue()
            boolean r0 = com.wear.util.WearUtils.e1(r0)
            if (r0 == 0) goto L30
            java.lang.String r4 = "0"
            goto L38
        L30:
            java.lang.String r4 = r4.getValue()
            java.lang.String r4 = dc.nd3.i(r4)
        L38:
            boolean r0 = com.wear.util.WearUtils.e1(r4)
            if (r0 != 0) goto L50
            boolean r0 = com.wear.util.WearUtils.q1(r4)
            if (r0 == 0) goto L50
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r4.intValue()
            if (r4 != 0) goto L50
            r4 = 0
            goto L51
        L50:
            r4 = 1
        L51:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.Setting.getAutoLastLevel(java.lang.String):java.lang.Boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean getAutoSwithOff(java.lang.String r4) {
        /*
            r3 = this;
            com.wear.dao.TestValueDao r0 = com.wear.dao.DaoUtils.getTestValueDao()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r3.getId()
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            java.lang.String r4 = dc.nd3.u(r4)
            java.lang.String r1 = "toyAutoSwith"
            com.wear.bean.TestValue r4 = r0.getExistKey(r4, r1)
            if (r4 == 0) goto L50
            java.lang.String r0 = r4.getValue()
            boolean r0 = com.wear.util.WearUtils.e1(r0)
            if (r0 == 0) goto L30
            java.lang.String r4 = "0"
            goto L38
        L30:
            java.lang.String r4 = r4.getValue()
            java.lang.String r4 = dc.nd3.i(r4)
        L38:
            boolean r0 = com.wear.util.WearUtils.e1(r4)
            if (r0 != 0) goto L50
            boolean r0 = com.wear.util.WearUtils.q1(r4)
            if (r0 == 0) goto L50
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r4.intValue()
            if (r4 != 0) goto L50
            r4 = 0
            goto L51
        L50:
            r4 = 1
        L51:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.Setting.getAutoSwithOff(java.lang.String):java.lang.Boolean");
    }

    public int getChatType() {
        return this.chatType;
    }

    @Override // com.wear.bean.BaseEntity
    public String getId() {
        String strF = nd3.f(super.getId());
        return WearUtils.e1(strF) ? super.getId() : strF;
    }

    public String getOldId() {
        return super.getId();
    }

    public int getPlayMusicModel() {
        return this.playMusicModel;
    }

    public int getTheme() {
        return this.theme;
    }

    public int getWeakPasswordRed() {
        return Integer.MAX_VALUE;
    }

    public int getWeakPasswordV() {
        return this.weakPasswordV;
    }

    public boolean isFirstInit() {
        return this.firstInit;
    }

    public boolean isSortKey() {
        return this.sortKey;
    }

    public void setAcceptPrivacyLogs(Boolean bool) {
        this.acceptPrivacyLogs = bool;
    }

    public void setAutoLastLevel(String str, Boolean bool) {
        String str2 = bool.booleanValue() ? "1" : "0";
        TestValue existKey = DaoUtils.getTestValueDao().getExistKey(nd3.u(getId() + str), TestValueDao.SAVE_KEY_KEEP_TOY_LASTLEVEL_TYPE);
        if (existKey != null) {
            existKey.setValue(nd3.u(str2));
            DaoUtils.getTestValueDao().update((TestValueDao) existKey);
            return;
        }
        DaoUtils.getTestValueDao().save(getId() + str, str2, TestValueDao.SAVE_KEY_KEEP_TOY_LASTLEVEL_TYPE);
    }

    public void setAutoSwithOff(String str, Boolean bool) {
        String str2 = bool.booleanValue() ? "1" : "0";
        TestValue existKey = DaoUtils.getTestValueDao().getExistKey(nd3.u(getId() + str), TestValueDao.SAVE_KEY_KEEP_TOY_AUTOSWITH_TYPE);
        if (existKey != null) {
            existKey.setValue(nd3.u(str2));
            DaoUtils.getTestValueDao().update((TestValueDao) existKey);
            return;
        }
        DaoUtils.getTestValueDao().save(getId() + str, str2, TestValueDao.SAVE_KEY_KEEP_TOY_AUTOSWITH_TYPE);
    }

    public void setChatType(int i) {
        this.chatType = i;
    }

    public void setFirstInit(boolean z) {
        this.firstInit = z;
    }

    @Override // com.wear.bean.BaseEntity
    public void setId(String str) {
        super.setId(nd3.p(str));
    }

    public void setPlayMusicModel(int i) {
        this.playMusicModel = i;
    }

    public void setSortKey(boolean z) {
        this.sortKey = z;
    }

    public void setTheme(int i) {
        this.theme = i;
    }

    public void setWeakPasswordRed(int i) {
        this.weakPasswordRed = i;
    }

    public void setWeakPasswordV(int i) {
        this.weakPasswordV = i;
    }

    public Setting(String str) {
        setId(str);
    }
}
