package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.io.IOUtils;
import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.util.CharsetUtil;
import com.broadcom.bt.util.mime4j.util.TempFile;
import com.broadcom.bt.util.mime4j.util.TempStorage;
import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

/* loaded from: classes.dex */
public class TempFileTextBody extends AbstractBody implements TextBody {
    private static Log log = LogFactory.getLog(TempFileTextBody.class);
    private String mimeCharset;
    private TempFile tempFile;

    public TempFileTextBody(InputStream inputStream) throws IOException {
        this(inputStream, null);
    }

    @Override // com.broadcom.bt.util.mime4j.message.TextBody
    public Reader getReader() throws IOException {
        String str = this.mimeCharset;
        String javaCharset = str != null ? CharsetUtil.toJavaCharset(str) : null;
        if (javaCharset == null) {
            javaCharset = "ISO-8859-1";
            if (log.isWarnEnabled()) {
                if (this.mimeCharset == null) {
                    log.warn("No MIME charset specified. Using ISO-8859-1 instead.");
                } else {
                    log.warn("MIME charset '" + this.mimeCharset + "' has no corresponding Java charset. Using ISO-8859-1 instead.");
                }
            }
        }
        return new InputStreamReader(this.tempFile.getInputStream(), javaCharset);
    }

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public void writeTo(OutputStream outputStream) throws IOException {
        IOUtils.copy(this.tempFile.getInputStream(), outputStream);
    }

    public TempFileTextBody(InputStream inputStream, String str) throws IOException {
        this.mimeCharset = null;
        this.tempFile = null;
        this.mimeCharset = str;
        TempFile tempFileCreateTempFile = TempStorage.getInstance().getRootTempPath().createTempFile("attachment", PSOProgramService.LogExt);
        this.tempFile = tempFileCreateTempFile;
        OutputStream outputStream = tempFileCreateTempFile.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        outputStream.close();
    }
}
