package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class FileDataSink extends OutputStreamDataSink {
    public File file;

    public FileDataSink(AsyncServer asyncServer, File file) {
        super(asyncServer);
        this.file = file;
    }

    @Override // com.koushikdutta.async.stream.OutputStreamDataSink
    public OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = super.getOutputStream();
        if (outputStream != null) {
            return outputStream;
        }
        this.file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        setOutputStream(fileOutputStream);
        return fileOutputStream;
    }
}
