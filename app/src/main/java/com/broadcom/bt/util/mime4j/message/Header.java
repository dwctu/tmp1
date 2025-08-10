package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.mime4j.AbstractContentHandler;
import com.broadcom.bt.util.mime4j.MimeStreamParser;
import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.broadcom.bt.util.mime4j.field.Field;
import com.broadcom.bt.util.mime4j.util.CharsetUtil;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class Header {
    private List fields = new LinkedList();
    private HashMap fieldMap = new HashMap();

    public Header() {
    }

    public void addField(Field field) {
        List linkedList = (List) this.fieldMap.get(field.getName().toLowerCase());
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.fieldMap.put(field.getName().toLowerCase(), linkedList);
        }
        linkedList.add(field);
        this.fields.add(field);
    }

    public Field getField(String str) {
        List list = (List) this.fieldMap.get(str.toLowerCase());
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (Field) list.get(0);
    }

    public List getFields() {
        return Collections.unmodifiableList(this.fields);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.fields.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
            stringBuffer.append("\r\n");
        }
        return stringBuffer.toString();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, CharsetUtil.getCharset(((ContentTypeField) getField("Content-Type")).getCharset())), 8192);
        bufferedWriter.write(toString() + "\r\n");
        bufferedWriter.flush();
    }

    public List getFields(String str) {
        return Collections.unmodifiableList((List) this.fieldMap.get(str.toLowerCase()));
    }

    public Header(InputStream inputStream) throws IOException {
        final MimeStreamParser mimeStreamParser = new MimeStreamParser();
        mimeStreamParser.setContentHandler(new AbstractContentHandler() { // from class: com.broadcom.bt.util.mime4j.message.Header.1
            @Override // com.broadcom.bt.util.mime4j.AbstractContentHandler, com.broadcom.bt.util.mime4j.ContentHandler
            public void endHeader() {
                mimeStreamParser.stop();
            }

            @Override // com.broadcom.bt.util.mime4j.AbstractContentHandler, com.broadcom.bt.util.mime4j.ContentHandler
            public void field(String str) {
                Header.this.addField(Field.parse(str));
            }
        });
        mimeStreamParser.parse(inputStream);
    }
}
