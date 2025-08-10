package com.broadcom.bt.util.mime4j.message;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BodyPart extends Entity {
    @Override // com.broadcom.bt.util.mime4j.message.Entity
    public void writeTo(OutputStream outputStream) throws IOException {
        getHeader().writeTo(outputStream);
        getBody().writeTo(outputStream);
    }
}
