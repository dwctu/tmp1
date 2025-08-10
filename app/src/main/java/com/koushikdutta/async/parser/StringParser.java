package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.ThenCallback;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class StringParser implements AsyncParser<String> {
    public Charset forcedCharset;

    public StringParser() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String b(String str, ByteBufferList byteBufferList) throws Exception {
        Charset charsetForName = this.forcedCharset;
        if (charsetForName == null && str != null) {
            charsetForName = Charset.forName(str);
        }
        return byteBufferList.readString(charsetForName);
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public String getMime() {
        return null;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return String.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<String> parse(DataEmitter dataEmitter) {
        final String strCharset = dataEmitter.charset();
        return new ByteBufferListParser().parse(dataEmitter).thenConvert(new ThenCallback() { // from class: dc.eb1
            @Override // com.koushikdutta.async.future.ThenCallback
            public final Object then(Object obj) {
                return this.a.b(strCharset, (ByteBufferList) obj);
            }
        });
    }

    public StringParser(Charset charset) {
        this.forcedCharset = charset;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, String str, CompletedCallback completedCallback) {
        new ByteBufferListParser().write(dataSink, new ByteBufferList(str.getBytes()), completedCallback);
    }
}
