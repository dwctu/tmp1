package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_media_pattern")
/* loaded from: classes3.dex */
public class MediaPattern extends BaseEntity {

    @DatabaseField
    private String creator;

    @DatabaseField
    private String friend;
    public Pattern pattern;

    @DatabaseField
    private String patternId;

    @DatabaseField
    private String patternJson;

    @DatabaseField
    private String states;

    public String getCreator() {
        String strF = nd3.f(this.creator);
        return WearUtils.e1(strF) ? this.creator : strF;
    }

    public String getFriend() {
        String strF = nd3.f(this.friend);
        return WearUtils.e1(strF) ? this.friend : strF;
    }

    public String getOldCreator() {
        return this.creator;
    }

    public String getOldFriend() {
        return this.friend;
    }

    public String getOldPatternJson() {
        return this.patternJson;
    }

    public Pattern getPattern() {
        return this.pattern;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPatternJson() {
        String strF = nd3.f(this.patternJson);
        return WearUtils.e1(strF) ? this.patternJson : strF;
    }

    public String getStates() {
        return this.states;
    }

    public void setCreator(String str) {
        this.creator = nd3.p(str);
    }

    public void setFriend(String str) {
        this.friend = nd3.p(str);
    }

    public void setPattern(Pattern pattern, String str) {
        this.pattern = pattern;
        setId(pattern.getId());
        setPatternId(pattern.getId());
        setFriend(str);
        setCreator(pattern.getCreator());
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setPatternJson(String str) {
        this.patternJson = nd3.p(str);
    }

    public void setStates(String str) {
        this.states = str;
    }

    public void updatePatternJson() {
        Pattern pattern = this.pattern;
        if (pattern == null) {
            setPatternJson("");
        } else {
            setPatternJson(WearUtils.A.toJson(pattern));
        }
    }
}
