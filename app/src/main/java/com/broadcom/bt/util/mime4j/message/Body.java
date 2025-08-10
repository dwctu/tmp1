package com.broadcom.bt.util.mime4j.message;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface Body {
    Entity getParent();

    void setParent(Entity entity);

    void writeTo(OutputStream outputStream) throws IOException;
}
