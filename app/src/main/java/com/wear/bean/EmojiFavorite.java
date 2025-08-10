package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_emoji_favorite")
/* loaded from: classes3.dex */
public class EmojiFavorite extends BaseEntity {

    @DatabaseField
    private String emojiId;

    @DatabaseField
    private String owner;

    @DatabaseField
    private String path;

    public EmojiFavorite() {
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public String getOldOwner() {
        return this.owner;
    }

    public String getOwner() {
        String strF = nd3.f(this.owner);
        return WearUtils.e1(strF) ? this.owner : strF;
    }

    public String getPath() {
        return this.path;
    }

    public void setEmojiId(String str) {
        this.emojiId = str;
    }

    public void setOwner(String str) {
        this.owner = nd3.p(str);
    }

    public void setPath(String str) {
        this.path = str;
    }

    public EmojiFavorite(String str) {
        setId(str);
    }
}
