package com.wear.bean.handlerbean;

/* loaded from: classes3.dex */
public interface IHandlerCommunMessage {
    public static final int MESSAGE_SENDDING = 2;
    public static final int MESSAGE_SEND_ERROR = 4;
    public static final int MESSAGE_SEND_SUCCESS = 0;

    boolean isFromGroup();

    boolean isSendIng();

    boolean isSendSuc();

    void sendFail();

    void sendSuc();

    void sendSucImg();
}
