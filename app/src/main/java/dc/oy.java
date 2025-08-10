package dc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* compiled from: JsonConverterFactory.java */
/* loaded from: classes.dex */
public class oy extends Converter.Factory {
    public final Gson a;

    public oy(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        this.a = gson;
    }

    public static oy a(Gson gson) {
        return new oy(gson);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, zc4> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new py(this.a, this.a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<bd4, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new qy(this.a, this.a.getAdapter(TypeToken.get(type)));
    }
}
