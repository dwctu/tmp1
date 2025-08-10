package com.wear.bean.event;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatPictureEvent {
    private ArrayList<String> delIds;
    private boolean isAddEmojis;

    public ChatPictureEvent(boolean z, ArrayList<String> arrayList) {
        this.isAddEmojis = z;
        this.delIds = arrayList;
    }

    public ArrayList<String> getDelIds() {
        return this.delIds;
    }

    public boolean isAddEmojis() {
        return this.isAddEmojis;
    }

    public void setAddEmojis(boolean z) {
        this.isAddEmojis = z;
    }

    public void setDelIds(ArrayList<String> arrayList) {
        this.delIds = arrayList;
    }
}
