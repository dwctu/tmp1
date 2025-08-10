package com.broadcom.bt.util.mime4j;

import com.broadcom.bt.util.mime4j.decoder.Base64InputStream;
import com.broadcom.bt.util.mime4j.decoder.QuotedPrintableInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class MimeStreamParser {
    private static final boolean DEBUG_LOG_MESSAGE = false;
    private static BitSet fieldChars;
    private static final Log log = LogFactory.getLog(MimeStreamParser.class);
    private RootInputStream rootStream = null;
    private LinkedList bodyDescriptors = new LinkedList();
    private ContentHandler handler = null;
    private boolean raw = false;

    static {
        fieldChars = null;
        fieldChars = new BitSet();
        for (int i = 33; i <= 57; i++) {
            fieldChars.set(i);
        }
        for (int i2 = 59; i2 <= 126; i2++) {
            fieldChars.set(i2);
        }
    }

    private void parseBodyPart(InputStream inputStream) throws IOException {
        if (this.raw) {
            this.handler.raw(new CloseShieldInputStream(inputStream));
            return;
        }
        this.handler.startBodyPart();
        parseEntity(inputStream);
        this.handler.endBodyPart();
    }

    private void parseEntity(InputStream inputStream) throws IOException {
        InputStream eOLConvertingInputStream;
        BodyDescriptor header = parseHeader(inputStream);
        if (header.isMultipart()) {
            this.bodyDescriptors.addFirst(header);
            this.handler.startMultipart(header);
            MimeBoundaryInputStream mimeBoundaryInputStream = new MimeBoundaryInputStream(inputStream, header.getBoundary());
            this.handler.preamble(new CloseShieldInputStream(mimeBoundaryInputStream));
            mimeBoundaryInputStream.consume();
            while (true) {
                if (!mimeBoundaryInputStream.hasMoreParts()) {
                    break;
                }
                mimeBoundaryInputStream = new MimeBoundaryInputStream(inputStream, header.getBoundary());
                parseBodyPart(mimeBoundaryInputStream);
                mimeBoundaryInputStream.consume();
                if (mimeBoundaryInputStream.parentEOF()) {
                    Log log2 = log;
                    if (log2.isWarnEnabled()) {
                        log2.warn("Line " + this.rootStream.getLineNumber() + ": Body part ended prematurely. Higher level boundary detected or EOF reached.");
                    }
                }
            }
            this.handler.epilogue(new CloseShieldInputStream(inputStream));
            this.handler.endMultipart();
            this.bodyDescriptors.removeFirst();
        } else if (header.isMessage()) {
            if (header.isBase64Encoded()) {
                log.warn("base64 encoded message/rfc822 detected");
                eOLConvertingInputStream = new EOLConvertingInputStream(new Base64InputStream(inputStream));
            } else {
                if (header.isQuotedPrintableEncoded()) {
                    log.warn("quoted-printable encoded message/rfc822 detected");
                    eOLConvertingInputStream = new EOLConvertingInputStream(new QuotedPrintableInputStream(inputStream));
                }
                this.bodyDescriptors.addFirst(header);
                parseMessage(inputStream);
                this.bodyDescriptors.removeFirst();
            }
            inputStream = eOLConvertingInputStream;
            this.bodyDescriptors.addFirst(header);
            parseMessage(inputStream);
            this.bodyDescriptors.removeFirst();
        } else {
            this.handler.body(header, new CloseShieldInputStream(inputStream));
        }
        while (inputStream.read() != -1) {
        }
    }

    private BodyDescriptor parseHeader(InputStream inputStream) throws IOException {
        int i;
        char c;
        char c2;
        boolean z;
        BodyDescriptor bodyDescriptor = new BodyDescriptor(this.bodyDescriptors.isEmpty() ? null : (BodyDescriptor) this.bodyDescriptors.getFirst());
        this.handler.startHeader();
        int lineNumber = this.rootStream.getLineNumber();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = inputStream.read();
            c = '\r';
            c2 = '\n';
            if (i != -1) {
                if (i == 10 && (i3 == 10 || i3 == 0)) {
                    break;
                }
                stringBuffer.append((char) i);
                if (i != 13) {
                    i3 = i;
                }
            } else {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        if (i == -1) {
            Log log2 = log;
            if (log2.isWarnEnabled()) {
                log2.warn("Line " + this.rootStream.getLineNumber() + ": Unexpected end of headers detected. Boundary detected in header or EOF reached.");
            }
        }
        int i4 = lineNumber;
        int i5 = 0;
        int i6 = 0;
        while (i5 < stringBuffer.length()) {
            while (i5 < stringBuffer.length() && stringBuffer.charAt(i5) != c) {
                i5++;
            }
            if (i5 < stringBuffer.length() - 1) {
                int i7 = i5 + 1;
                if (stringBuffer.charAt(i7) != c2) {
                    i5 = i7;
                }
            }
            if (i5 >= stringBuffer.length() - 2 || fieldChars.get(stringBuffer.charAt(i5 + 2))) {
                String strSubstring = stringBuffer.substring(i6, i5);
                int i8 = i5 + 2;
                int iIndexOf = strSubstring.indexOf(58);
                if (iIndexOf == -1 || !fieldChars.get(strSubstring.charAt(i2))) {
                    z = false;
                } else {
                    String strTrim = strSubstring.substring(i2, iIndexOf).trim();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= strTrim.length()) {
                            z = true;
                            break;
                        }
                        if (!fieldChars.get(strTrim.charAt(i9))) {
                            z = false;
                            break;
                        }
                        i9++;
                    }
                    if (z) {
                        this.handler.field(strSubstring);
                        bodyDescriptor.addField(strTrim, strSubstring.substring(iIndexOf + 1));
                    }
                }
                if (!z) {
                    Log log3 = log;
                    if (log3.isWarnEnabled()) {
                        log3.warn("Line " + i4 + ": Ignoring invalid field: '" + strSubstring.trim() + "'");
                    }
                }
                i4 = lineNumber;
                i6 = i8;
            }
            i5 += 2;
            lineNumber++;
            i2 = 0;
            c = '\r';
            c2 = '\n';
        }
        this.handler.endHeader();
        return bodyDescriptor;
    }

    private void parseMessage(InputStream inputStream) throws IOException {
        if (this.raw) {
            this.handler.raw(new CloseShieldInputStream(inputStream));
            return;
        }
        this.handler.startMessage();
        parseEntity(inputStream);
        this.handler.endMessage();
    }

    public boolean isRaw() {
        return this.raw;
    }

    public void parse(InputStream inputStream) throws IOException {
        RootInputStream rootInputStream = new RootInputStream(inputStream);
        this.rootStream = rootInputStream;
        parseMessage(rootInputStream);
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.handler = contentHandler;
    }

    public void setRaw(boolean z) {
        this.raw = z;
    }

    public void stop() {
        this.rootStream.truncate();
    }
}
