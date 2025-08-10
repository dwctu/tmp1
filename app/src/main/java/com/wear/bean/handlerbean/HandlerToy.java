package com.wear.bean.handlerbean;

/* loaded from: classes3.dex */
public interface HandlerToy {
    boolean canSetLed();

    int getLdrIcon();

    boolean isMax();

    boolean isSupportBt();

    boolean isSupportControlPanel();

    boolean isSupportDepthMode();

    boolean isSupportGame();

    boolean isSupportLdr();

    boolean isThridPartToy();

    boolean isVirtualToy();

    boolean supportCommand(String str);
}
