package retrofit2;

import dc.bd4;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.Converter;

@IgnoreJRERequirement
/* loaded from: classes5.dex */
public final class OptionalConverterFactory extends Converter.Factory {
    public static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    @IgnoreJRERequirement
    public static final class OptionalConverter<T> implements Converter<bd4, Optional<T>> {
        public final Converter<bd4, T> delegate;

        public OptionalConverter(Converter<bd4, T> converter) {
            this.delegate = converter;
        }

        @Override // retrofit2.Converter
        public Optional<T> convert(bd4 bd4Var) throws IOException {
            return Optional.ofNullable(this.delegate.convert(bd4Var));
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<bd4, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
