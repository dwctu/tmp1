package com.wear.bean.event;

import java.util.List;

/* loaded from: classes3.dex */
public class ControlLinkDescriptionEvent {
    public static final String tag = "ControlLinkDescriptionEvent";
    private String content;
    private List<String> selectedTags;

    public ControlLinkDescriptionEvent(List<String> list, String str) {
        this.selectedTags = list;
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public List<String> getSelectedTags() {
        return this.selectedTags;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setSelectedTags(List<String> list) {
        this.selectedTags = list;
    }
}
