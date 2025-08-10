package com.wear.bean.event;

import com.wear.bean.Pattern;

/* loaded from: classes3.dex */
public class PatternListChangeEvent {
    private Pattern pattern;

    public PatternListChangeEvent(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return this.pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
