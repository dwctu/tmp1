package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.io.IOUtils;
import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.util.TempStorage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class MemoryBinaryBody extends AbstractBody implements BinaryBody {
    private static Log log = LogFactory.getLog(MemoryBinaryBody.class);
    private Entity parent = null;
    private byte[] tempFile;

    public MemoryBinaryBody(InputStream inputStream) throws IOException {
        this.tempFile = null;
        TempStorage.getInstance().getRootTempPath();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        this.tempFile = byteArrayOutputStream.toByteArray();
    }

    @Override // com.broadcom.bt.util.mime4j.message.BinaryBody
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.tempFile);
    }

    @Override // com.broadcom.bt.util.mime4j.message.AbstractBody, com.broadcom.bt.util.mime4j.message.Body
    public Entity getParent() {
        return this.parent;
    }

    @Override // com.broadcom.bt.util.mime4j.message.AbstractBody, com.broadcom.bt.util.mime4j.message.Body
    public void setParent(Entity entity) {
        this.parent = entity;
    }

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public void writeTo(OutputStream outputStream) throws IOException {
        IOUtils.copy(getInputStream(), outputStream);
    }
}
