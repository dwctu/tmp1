package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.io.IOUtils;
import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.util.TempFile;
import com.broadcom.bt.util.mime4j.util.TempStorage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class TempFileBinaryBody extends AbstractBody implements BinaryBody {
    private static Log log = LogFactory.getLog(TempFileBinaryBody.class);
    private Entity parent = null;
    private TempFile tempFile;

    public TempFileBinaryBody(InputStream inputStream) throws IOException {
        this.tempFile = null;
        TempFile tempFileCreateTempFile = TempStorage.getInstance().getRootTempPath().createTempFile("attachment", ".bin");
        this.tempFile = tempFileCreateTempFile;
        OutputStream outputStream = tempFileCreateTempFile.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        outputStream.close();
    }

    @Override // com.broadcom.bt.util.mime4j.message.BinaryBody
    public InputStream getInputStream() throws IOException {
        return this.tempFile.getInputStream();
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
