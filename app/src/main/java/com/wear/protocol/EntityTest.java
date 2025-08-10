package com.wear.protocol;

/* loaded from: classes3.dex */
public class EntityTest extends DataEntityAbstract {
    public String test1;
    public String test2;

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.test;
    }

    public String getTest1() {
        return this.test1;
    }

    public String getTest2() {
        return this.test2;
    }

    public void setTest1(String str) {
        this.test1 = str;
    }

    public void setTest2(String str) {
        this.test2 = str;
    }
}
