package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import dc.bd4;
import java.io.IOException;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public final class GsonResponseBodyConverter<T> implements Converter<bd4, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    public T convert(bd4 bd4Var) throws IOException {
        JsonReader jsonReaderNewJsonReader = this.gson.newJsonReader(bd4Var.charStream());
        try {
            T t = this.adapter.read2(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return t;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            bd4Var.close();
        }
    }
}
