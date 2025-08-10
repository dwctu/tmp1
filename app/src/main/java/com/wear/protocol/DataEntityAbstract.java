package com.wear.protocol;

import com.wear.util.WearUtils;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class DataEntityAbstract implements Serializable, IHandleMessage {
    private static final String TAG = DataEntityAbstract.class.getSimpleName();

    @Override // com.wear.protocol.IHandleMessage
    public boolean autoResendMessage() {
        return (getEntityType() == MessageType.live || getEntityType() == MessageType.sync || getEntityType() == MessageType.video || getEntityType() == MessageType.voice || getEntityType() == MessageType.alarm || getEntityType() == MessageType.toy || getEntityType() == MessageType.partnertoy || getEntityType() == MessageType.alexa) ? false : true;
    }

    public <T> T fromJsonToDecrypt(String str, Class<T> cls) {
        return (T) WearUtils.A.fromJson(CommunMessage.decrypt(str), (Class) cls);
    }

    public abstract MessageType getEntityType();

    @Override // com.wear.protocol.IHandleMessage
    public boolean needReceiptReceived() {
        return (getEntityType() == MessageType.live || getEntityType() == MessageType.sync || getEntityType() == MessageType.video || getEntityType() == MessageType.voice || getEntityType() == MessageType.toy || getEntityType() == MessageType.partnertoy || getEntityType() == MessageType.alexa || getEntityType() == MessageType.test) ? false : true;
    }
}
