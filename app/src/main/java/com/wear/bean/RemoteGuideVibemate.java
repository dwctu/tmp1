package com.wear.bean;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_remote_guide_vibemate")
/* loaded from: classes3.dex */
public class RemoteGuideVibemate extends BaseEntity {

    @SerializedName("shouldDisguise")
    @DatabaseField
    private boolean shouldDisguise;

    public RemoteGuideVibemate() {
    }

    public boolean isShouldDisguise() {
        return this.shouldDisguise;
    }

    public void setShouldDisguise(boolean z) {
        this.shouldDisguise = z;
    }

    public RemoteGuideVibemate(boolean z) {
        this.shouldDisguise = z;
    }
}
