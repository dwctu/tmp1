package com.broadcom.bt.util.mime4j;

import com.broadcom.bt.util.mime4j.field.ContentTransferEncodingField;
import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BodyDescriptor {
    private static Log log = LogFactory.getLog(BodyDescriptor.class);
    private String boundary;
    private String charset;
    private boolean contentTransferEncSet;
    private boolean contentTypeSet;
    private String mimeType;
    private Map parameters;
    private String transferEncoding;

    public BodyDescriptor() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00af A[PHI: r7
  0x00af: PHI (r7v11 char) = (r7v8 char), (r7v1 char) binds: [B:43:0x00ac, B:16:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8 A[PHI: r7
  0x00d8: PHI (r7v17 char) = (r7v16 char), (r7v1 char) binds: [B:51:0x00d5, B:18:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e0 A[PHI: r2 r3
  0x00e0: PHI (r2v11 java.lang.StringBuffer) = (r2v6 java.lang.StringBuffer), (r2v10 java.lang.StringBuffer), (r2v6 java.lang.StringBuffer) binds: [B:60:0x00e7, B:64:0x0100, B:56:0x00de] A[DONT_GENERATE, DONT_INLINE]
  0x00e0: PHI (r3v8 java.lang.StringBuffer) = (r3v5 java.lang.StringBuffer), (r3v7 java.lang.StringBuffer), (r3v5 java.lang.StringBuffer) binds: [B:60:0x00e7, B:64:0x0100, B:56:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0108 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map getHeaderParams(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.BodyDescriptor.getHeaderParams(java.lang.String):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addField(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.BodyDescriptor.addField(java.lang.String, java.lang.String):void");
    }

    public String getBoundary() {
        return this.boundary;
    }

    public String getCharset() {
        return this.charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Map getParameters() {
        return this.parameters;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public boolean isBase64Encoded() {
        return ContentTransferEncodingField.ENC_BASE64.equals(this.transferEncoding);
    }

    public boolean isMessage() {
        return this.mimeType.equals(ContentTypeField.TYPE_MESSAGE_RFC822);
    }

    public boolean isMimeType(String str) {
        return this.mimeType.equals(str.toLowerCase());
    }

    public boolean isMultipart() {
        return this.mimeType.startsWith("multipart/");
    }

    public boolean isQuotedPrintableEncoded() {
        return ContentTransferEncodingField.ENC_QUOTED_PRINTABLE.equals(this.transferEncoding);
    }

    public String toString() {
        return this.mimeType;
    }

    public BodyDescriptor(BodyDescriptor bodyDescriptor) {
        this.mimeType = "text/plain";
        this.boundary = null;
        this.charset = "us-ascii";
        this.transferEncoding = ContentTransferEncodingField.ENC_7BIT;
        this.parameters = new HashMap();
        this.contentTypeSet = false;
        this.contentTransferEncSet = false;
        if (bodyDescriptor == null || !bodyDescriptor.isMimeType(ContentTypeField.TYPE_MULTIPART_DIGEST)) {
            this.mimeType = "text/plain";
        } else {
            this.mimeType = ContentTypeField.TYPE_MESSAGE_RFC822;
        }
    }
}
