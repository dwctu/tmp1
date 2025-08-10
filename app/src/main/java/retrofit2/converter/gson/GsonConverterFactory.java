package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dc.bd4;
import dc.zc4;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final Gson gson;

    private GsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    public static GsonConverterFactory create() {
        return create(new Gson());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, zc4> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<bd4, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }

    public static GsonConverterFactory create(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        return new GsonConverterFactory(gson);
    }
}
