package dc;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import retrofit2.Converter;

/* compiled from: JsonRequestBodyConverter.java */
/* loaded from: classes3.dex */
public final class co2<T> implements Converter<T, zc4> {
    public static final tc4 c = tc4.d("application/json; charset=UTF-8");
    public static final Charset d = Charset.forName("UTF-8");
    public final Gson a;
    public final TypeAdapter<T> b;

    public co2(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zc4 convert(T t) throws IOException {
        nd4 nd4Var = new nd4();
        JsonWriter jsonWriterNewJsonWriter = this.a.newJsonWriter(new OutputStreamWriter(nd4Var.Y(), d));
        this.b.write(jsonWriterNewJsonWriter, t);
        jsonWriterNewJsonWriter.close();
        return zc4.create(c, nd4Var.L());
    }
}
