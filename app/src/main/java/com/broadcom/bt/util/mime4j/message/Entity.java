package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.mime4j.field.ContentTransferEncodingField;
import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.broadcom.bt.util.mime4j.field.Field;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class Entity {
    private Header header = null;
    private Body body = null;
    private Entity parent = null;

    public Body getBody() {
        return this.body;
    }

    public String getCharset() {
        return ContentTypeField.getCharset((ContentTypeField) getHeader().getField("Content-Type"));
    }

    public String getContentTransferEncoding() {
        return ContentTransferEncodingField.getEncoding((ContentTransferEncodingField) getHeader().getField(Field.CONTENT_TRANSFER_ENCODING));
    }

    public Header getHeader() {
        return this.header;
    }

    public String getMimeType() {
        return ContentTypeField.getMimeType((ContentTypeField) getHeader().getField("Content-Type"), getParent() != null ? (ContentTypeField) getParent().getHeader().getField("Content-Type") : null);
    }

    public Entity getParent() {
        return this.parent;
    }

    public boolean isMimeType(String str) {
        return getMimeType().equalsIgnoreCase(str);
    }

    public boolean isMultipart() {
        ContentTypeField contentTypeField = (ContentTypeField) getHeader().getField("Content-Type");
        return (contentTypeField == null || contentTypeField.getBoundary() == null || !getMimeType().startsWith("multipart/")) ? false : true;
    }

    public void setBody(Body body) {
        this.body = body;
        body.setParent(this);
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setParent(Entity entity) {
        this.parent = entity;
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;
}
