package com.broadcom.bt.util.mime4j.decoder;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class QuotedPrintableInputStream extends InputStream {
    private static Log log = LogFactory.getLog(QuotedPrintableInputStream.class);
    public ByteQueue byteq = new ByteQueue();
    public ByteQueue pushbackq = new ByteQueue();
    private byte state = 0;
    private InputStream stream;

    public QuotedPrintableInputStream(InputStream inputStream) {
        this.stream = inputStream;
    }

    private byte asciiCharToNumericValue(byte b) {
        int i;
        if (b < 48 || b > 57) {
            byte b2 = 65;
            if (b < 65 || b > 90) {
                b2 = 97;
                if (b < 97 || b > 122) {
                    throw new IllegalArgumentException(((char) b) + " is not a hexadecimal digit");
                }
            }
            i = (b - b2) + 10;
        } else {
            i = b - 48;
        }
        return (byte) i;
    }

    private void fillBuffer() throws IOException {
        byte b = 0;
        while (this.byteq.count() == 0) {
            if (this.pushbackq.count() == 0) {
                populatePushbackQueue();
                if (this.pushbackq.count() == 0) {
                    return;
                }
            }
            byte bDequeue = this.pushbackq.dequeue();
            byte b2 = this.state;
            if (b2 != 0) {
                if (b2 != 1) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            log.error("Illegal state: " + ((int) this.state));
                            this.state = (byte) 0;
                            this.byteq.enqueue(bDequeue);
                        } else if ((bDequeue < 48 || bDequeue > 57) && ((bDequeue < 65 || bDequeue > 70) && (bDequeue < 97 || bDequeue > 102))) {
                            if (log.isWarnEnabled()) {
                                log.warn("Malformed MIME; expected [0-9A-Z], got " + ((int) bDequeue));
                            }
                            this.state = (byte) 0;
                            this.byteq.enqueue((byte) 61);
                            this.byteq.enqueue(b);
                            this.byteq.enqueue(bDequeue);
                        } else {
                            byte bAsciiCharToNumericValue = asciiCharToNumericValue(b);
                            byte bAsciiCharToNumericValue2 = asciiCharToNumericValue(bDequeue);
                            this.state = (byte) 0;
                            this.byteq.enqueue((byte) (bAsciiCharToNumericValue2 | (bAsciiCharToNumericValue << 4)));
                        }
                    } else if (bDequeue == 10) {
                        this.state = (byte) 0;
                    } else {
                        if (log.isWarnEnabled()) {
                            log.warn("Malformed MIME; expected 10, got " + ((int) bDequeue));
                        }
                        this.state = (byte) 0;
                        this.byteq.enqueue((byte) 61);
                        this.byteq.enqueue((byte) 13);
                        this.byteq.enqueue(bDequeue);
                    }
                } else if (bDequeue == 13) {
                    this.state = (byte) 2;
                } else if ((bDequeue >= 48 && bDequeue <= 57) || ((bDequeue >= 65 && bDequeue <= 70) || (bDequeue >= 97 && bDequeue <= 102))) {
                    this.state = (byte) 3;
                    b = bDequeue;
                } else if (bDequeue == 61) {
                    if (log.isWarnEnabled()) {
                        log.warn("Malformed MIME; got ==");
                    }
                    this.byteq.enqueue((byte) 61);
                } else {
                    if (log.isWarnEnabled()) {
                        log.warn("Malformed MIME; expected \\r or [0-9A-Z], got " + ((int) bDequeue));
                    }
                    this.state = (byte) 0;
                    this.byteq.enqueue((byte) 61);
                    this.byteq.enqueue(bDequeue);
                }
            } else if (bDequeue != 61) {
                this.byteq.enqueue(bDequeue);
            } else {
                this.state = (byte) 1;
            }
        }
    }

    private void populatePushbackQueue() throws IOException {
        int i;
        if (this.pushbackq.count() != 0) {
            return;
        }
        while (true) {
            i = this.stream.read();
            if (i == -1) {
                this.pushbackq.clear();
                return;
            }
            if (i == 13) {
                break;
            }
            if (i == 32 || i == 9) {
                this.pushbackq.enqueue((byte) i);
            } else if (i != 10) {
                this.pushbackq.enqueue((byte) i);
                return;
            }
        }
        this.pushbackq.clear();
        this.pushbackq.enqueue((byte) i);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        fillBuffer();
        if (this.byteq.count() == 0) {
            return -1;
        }
        byte bDequeue = this.byteq.dequeue();
        return bDequeue >= 0 ? bDequeue : bDequeue & 255;
    }
}
