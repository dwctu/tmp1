package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.ro2;
import java.util.HashMap;

@DatabaseTable(tableName = "tb_orgy")
/* loaded from: classes3.dex */
public class Orgy extends BaseEntity {

    @DatabaseField
    private String activityId;

    @DatabaseField
    private String showBannerJson;

    @DatabaseField
    private boolean showHot;

    public Orgy() {
    }

    public String getActivityId() {
        return this.activityId;
    }

    @Override // com.wear.bean.BaseEntity
    public String getId() {
        String strF = nd3.f(super.getId());
        return WearUtils.e1(strF) ? super.getId() : strF;
    }

    public String getOldId() {
        return super.getId();
    }

    public String getShowBanner() {
        return this.showBannerJson;
    }

    public boolean isShowHot() {
        return this.showHot;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    @Override // com.wear.bean.BaseEntity
    public void setId(String str) {
        super.setId(nd3.p(str));
    }

    public void setShowBanner(HashMap map) {
        this.showBannerJson = ro2.c(map);
    }

    public void setShowBannerString(String str) {
        this.showBannerJson = str;
    }

    public void setShowHot(boolean z) {
        this.showHot = z;
    }

    public Orgy(String str, String str2) {
        setId(str);
        this.activityId = str2;
    }
}
