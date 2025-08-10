package com.orangegangsters.github.swipyrefreshlayout.library;

/* loaded from: classes3.dex */
public enum SwipyRefreshLayoutDirection {
    TOP(0),
    BOTTOM(1),
    BOTH(2);

    private int mValue;

    SwipyRefreshLayoutDirection(int i) {
        this.mValue = i;
    }

    public static SwipyRefreshLayoutDirection getFromInt(int i) {
        for (SwipyRefreshLayoutDirection swipyRefreshLayoutDirection : values()) {
            if (swipyRefreshLayoutDirection.mValue == i) {
                return swipyRefreshLayoutDirection;
            }
        }
        return BOTH;
    }
}
