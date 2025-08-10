package retrofit2;

import dc.bd4;
import dc.zc4;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* loaded from: classes5.dex */
public final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    public static final class BufferingResponseBodyConverter implements Converter<bd4, bd4> {
        public static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        @Override // retrofit2.Converter
        public bd4 convert(bd4 bd4Var) throws IOException {
            try {
                return Utils.buffer(bd4Var);
            } finally {
                bd4Var.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter<zc4, zc4> {
        public static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        @Override // retrofit2.Converter
        public zc4 convert(zc4 zc4Var) {
            return zc4Var;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<bd4, bd4> {
        public static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        @Override // retrofit2.Converter
        public bd4 convert(bd4 bd4Var) {
            return bd4Var;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        public static final ToStringConverter INSTANCE = new ToStringConverter();

        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter<bd4, Unit> {
        public static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        @Override // retrofit2.Converter
        public Unit convert(bd4 bd4Var) {
            bd4Var.close();
            return Unit.INSTANCE;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<bd4, Void> {
        public static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        @Override // retrofit2.Converter
        public Void convert(bd4 bd4Var) {
            bd4Var.close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, zc4> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (zc4.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<bd4, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == bd4.class) {
            return Utils.isAnnotationPresent(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != Unit.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }
}
