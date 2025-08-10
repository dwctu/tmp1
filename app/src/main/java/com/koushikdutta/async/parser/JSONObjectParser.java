package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.ThenCallback;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSONObjectParser implements AsyncParser<JSONObject> {
    @Override // com.koushikdutta.async.parser.AsyncParser
    public String getMime() {
        return "application/json";
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return JSONObject.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<JSONObject> parse(DataEmitter dataEmitter) {
        return new StringParser().parse(dataEmitter).thenConvert(new ThenCallback() { // from class: dc.fb1
            @Override // com.koushikdutta.async.future.ThenCallback
            public final Object then(Object obj) {
                return new JSONObject((String) obj);
            }
        });
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, JSONObject jSONObject, CompletedCallback completedCallback) {
        new StringParser().write(dataSink, jSONObject.toString(), completedCallback);
    }
}
