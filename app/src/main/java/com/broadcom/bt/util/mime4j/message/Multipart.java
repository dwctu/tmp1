package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.broadcom.bt.util.mime4j.util.CharsetUtil;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class Multipart implements Body {
    private String preamble = "";
    private String epilogue = "";
    private List bodyParts = new LinkedList();
    private Entity parent = null;
    private String subType = "alternative";

    private String getBoundary() {
        return ((ContentTypeField) getParent().getHeader().getField("Content-Type")).getBoundary();
    }

    private String getCharset() {
        return ((ContentTypeField) getParent().getHeader().getField("Content-Type")).getCharset();
    }

    public void addBodyPart(BodyPart bodyPart) {
        this.bodyParts.add(bodyPart);
        bodyPart.setParent(this.parent);
    }

    public List getBodyParts() {
        return Collections.unmodifiableList(this.bodyParts);
    }

    public String getEpilogue() {
        return this.epilogue;
    }

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public Entity getParent() {
        return this.parent;
    }

    public String getPreamble() {
        return this.preamble;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setBodyParts(List list) {
        this.bodyParts = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((BodyPart) it.next()).setParent(this.parent);
        }
    }

    public void setEpilogue(String str) {
        this.epilogue = str;
    }

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public void setParent(Entity entity) {
        this.parent = entity;
        Iterator it = this.bodyParts.iterator();
        while (it.hasNext()) {
            ((BodyPart) it.next()).setParent(entity);
        }
    }

    public void setPreamble(String str) {
        this.preamble = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public void writeTo(OutputStream outputStream) throws IOException {
        String boundary = getBoundary();
        List bodyParts = getBodyParts();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, CharsetUtil.getCharset(getCharset())), 8192);
        bufferedWriter.write(getPreamble() + "\r\n");
        for (int i = 0; i < bodyParts.size(); i++) {
            bufferedWriter.write(boundary + "\r\n");
            ((BodyPart) bodyParts.get(i)).writeTo(outputStream);
        }
        bufferedWriter.write(getEpilogue() + "\r\n");
        bufferedWriter.write(boundary + "--\r\n");
    }
}
