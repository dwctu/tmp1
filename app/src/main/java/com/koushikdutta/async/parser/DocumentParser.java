package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.ThenCallback;
import com.koushikdutta.async.http.body.DocumentBody;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

/* loaded from: classes3.dex */
public class DocumentParser implements AsyncParser<Document> {
    @Override // com.koushikdutta.async.parser.AsyncParser
    public String getMime() {
        return "text/xml";
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return Document.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<Document> parse(DataEmitter dataEmitter) {
        return new ByteBufferListParser().parse(dataEmitter).thenConvert(new ThenCallback() { // from class: dc.cb1
            @Override // com.koushikdutta.async.future.ThenCallback
            public final Object then(Object obj) {
                return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteBufferListInputStream((ByteBufferList) obj));
            }
        });
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, Document document, CompletedCallback completedCallback) throws TransformerException, IOException {
        new DocumentBody(document).write(null, dataSink, completedCallback);
    }
}
