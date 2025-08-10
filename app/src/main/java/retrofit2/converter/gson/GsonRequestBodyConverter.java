package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import dc.nd4;
import dc.tc4;
import dc.zc4;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public final class GsonRequestBodyConverter<T> implements Converter<T, zc4> {
    private static final tc4 MEDIA_TYPE = tc4.c("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ zc4 convert(Object obj) throws IOException {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // retrofit2.Converter
    public zc4 convert(T t) throws IOException {
        nd4 nd4Var = new nd4();
        JsonWriter jsonWriterNewJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(nd4Var.Y(), UTF_8));
        this.adapter.write(jsonWriterNewJsonWriter, t);
        jsonWriterNewJsonWriter.close();
        return zc4.create(MEDIA_TYPE, nd4Var.L());
    }
}
