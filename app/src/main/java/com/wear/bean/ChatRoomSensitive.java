package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_sensitive_chat_room")
/* loaded from: classes3.dex */
public class ChatRoomSensitive extends BaseEntity {

    @DatabaseField
    private int count;

    @DatabaseField
    private String partId;

    @DatabaseField
    private String roomId;

    @DatabaseField
    private String word;

    public int getCount() {
        return this.count;
    }

    public String getPartId() {
        return this.partId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getWord() {
        return this.word;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setPartId(String str) {
        this.partId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setWord(String str) {
        this.word = str;
    }
}
