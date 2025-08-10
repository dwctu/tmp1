package dc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* compiled from: JsonConverterFactory.java */
/* loaded from: classes3.dex */
public class bo2 extends Converter.Factory {
    public final Gson a;

    public bo2(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        this.a = gson;
    }

    public static bo2 a() {
        return b(new Gson());
    }

    public static bo2 b(Gson gson) {
        return new bo2(gson);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, zc4> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new co2(this.a, this.a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<bd4, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new do2(this.a, this.a.getAdapter(TypeToken.get(type)));
    }
}
