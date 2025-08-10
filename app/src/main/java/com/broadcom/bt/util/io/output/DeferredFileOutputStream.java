package com.broadcom.bt.util.io.output;

import com.broadcom.bt.util.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class DeferredFileOutputStream extends ThresholdingOutputStream {
    private boolean closed;
    private OutputStream currentOutputStream;
    private File directory;
    private ByteArrayOutputStream memoryOutputStream;
    private File outputFile;
    private String prefix;
    private String suffix;

    public DeferredFileOutputStream(int i, File file) {
        super(i);
        this.closed = false;
        this.outputFile = file;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.memoryOutputStream = byteArrayOutputStream;
        this.currentOutputStream = byteArrayOutputStream;
    }

    @Override // com.broadcom.bt.util.io.output.ThresholdingOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.closed = true;
        IOUtils.closeQuietly(this.currentOutputStream);
        ByteArrayOutputStream byteArrayOutputStream = this.memoryOutputStream;
        if (byteArrayOutputStream != this.currentOutputStream) {
            IOUtils.closeQuietly(byteArrayOutputStream);
        }
        this.currentOutputStream = null;
        this.memoryOutputStream = null;
    }

    public void finalize() {
        if (this.closed) {
            try {
                close();
            } catch (Throwable unused) {
            }
        }
    }

    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.memoryOutputStream;
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.outputFile;
    }

    @Override // com.broadcom.bt.util.io.output.ThresholdingOutputStream
    public OutputStream getStream() throws IOException {
        return this.currentOutputStream;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    @Override // com.broadcom.bt.util.io.output.ThresholdingOutputStream
    public void thresholdReached() throws IOException {
        String str = this.prefix;
        if (str != null) {
            this.outputFile = File.createTempFile(str, this.suffix, this.directory);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
        this.memoryOutputStream.writeTo(fileOutputStream);
        this.currentOutputStream = fileOutputStream;
        this.memoryOutputStream = null;
        fileOutputStream.close();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (!this.closed) {
            throw new IOException("Stream not closed");
        }
        if (isInMemory()) {
            this.memoryOutputStream.writeTo(outputStream);
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(this.outputFile);
        try {
            IOUtils.copy(fileInputStream, outputStream);
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }
    }

    public DeferredFileOutputStream(int i, String str, String str2, File file) {
        this(i, null);
        if (str != null) {
            this.prefix = str;
            this.suffix = str2;
            this.directory = file;
            return;
        }
        throw new IllegalArgumentException("Temporary file prefix is missing");
    }
}
