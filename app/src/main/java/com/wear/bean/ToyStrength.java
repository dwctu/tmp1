package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_toy_strength")
/* loaded from: classes3.dex */
public class ToyStrength extends BaseEntity {

    @DatabaseField
    private String airStrength;

    @DatabaseField
    private String depthStrength;

    @DatabaseField
    private String fingeringStrength;

    @DatabaseField
    private String rotateStrength;

    @DatabaseField
    private Integer strokeMax;

    @DatabaseField
    private Integer strokeMin;

    @DatabaseField
    private String suctionStrength;

    @DatabaseField
    private String thrustingStrength;

    @DatabaseField
    private String toyAddress;

    @DatabaseField
    private String user;

    @DatabaseField
    private String vibration1Strength;

    @DatabaseField
    private String vibration2Strength;

    @DatabaseField
    private String vibration3Strength;

    @DatabaseField
    private String vibrationStrength;

    public ToyStrength() {
    }

    public String getAirStrength() {
        return this.airStrength;
    }

    public String getDepthStrength() {
        return this.depthStrength;
    }

    public String getFingeringStrength() {
        return this.fingeringStrength;
    }

    @Override // com.wear.bean.BaseEntity
    public String getId() {
        String strF = nd3.f(super.getId());
        return WearUtils.e1(strF) ? super.getId() : strF;
    }

    public String getOldId() {
        return super.getId();
    }

    public String getRotateStrength() {
        return this.rotateStrength;
    }

    public Integer getStrokeMax() {
        return this.strokeMax;
    }

    public Integer getStrokeMin() {
        return this.strokeMin;
    }

    public String getSuctionStrength() {
        return this.suctionStrength;
    }

    public String getThrustingStrength() {
        return this.thrustingStrength;
    }

    public String getToyAddress() {
        return this.toyAddress;
    }

    public String getUser() {
        return nd3.f(this.user);
    }

    public String getVibration1Strength() {
        return this.vibration1Strength;
    }

    public String getVibration2Strength() {
        return this.vibration2Strength;
    }

    public String getVibration3Strength() {
        return this.vibration3Strength;
    }

    public String getVibrationStrength() {
        return this.vibrationStrength;
    }

    public void setAirStrength(String str) {
        this.airStrength = str;
    }

    public void setDepthStrength(String str) {
        this.depthStrength = str;
    }

    public void setFingeringStrength(String str) {
        this.fingeringStrength = str;
    }

    @Override // com.wear.bean.BaseEntity
    public void setId(String str) {
        super.setId(nd3.p(str));
    }

    public void setRotateStrength(String str) {
        this.rotateStrength = str;
    }

    public void setStrength(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12) {
        if (num != null) {
            this.vibrationStrength = num + "";
        }
        if (num2 != null) {
            this.vibration1Strength = num2 + "";
        }
        if (num3 != null) {
            this.vibration2Strength = num3 + "";
        }
        if (num4 != null) {
            this.vibration3Strength = num4 + "";
        }
        if (num5 != null) {
            this.rotateStrength = num5 + "";
        }
        if (num6 != null) {
            this.airStrength = num6 + "";
        }
        if (num7 != null) {
            this.suctionStrength = num7 + "";
        }
        if (num8 != null) {
            this.thrustingStrength = num8 + "";
        }
        if (num9 != null) {
            this.fingeringStrength = num9 + "";
        }
        if (num10 != null) {
            this.depthStrength = num10 + "";
        }
        if (num11 != null) {
            this.strokeMin = num11;
        }
        if (num12 != null) {
            this.strokeMax = num12;
        }
    }

    public void setStrokeMax(Integer num) {
        this.strokeMax = num;
    }

    public void setStrokeMin(Integer num) {
        this.strokeMin = num;
    }

    public void setSuctionStrength(String str) {
        this.suctionStrength = str;
    }

    public void setThrustingStrength(String str) {
        this.thrustingStrength = str;
    }

    public void setToyAddress(String str) {
        this.toyAddress = str;
    }

    public void setVibration1Strength(String str) {
        this.vibration1Strength = str;
    }

    public void setVibration2Strength(String str) {
        this.vibration2Strength = str;
    }

    public void setVibration3Strength(String str) {
        this.vibration3Strength = str;
    }

    public void setVibrationStrength(String str) {
        this.vibrationStrength = str;
    }

    public ToyStrength(String str, String str2) {
        this.user = nd3.p(str);
        this.toyAddress = str2;
    }
}
