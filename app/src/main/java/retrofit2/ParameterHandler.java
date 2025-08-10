package retrofit2;

import dc.qc4;
import dc.uc4;
import dc.zc4;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, zc4> converter;
        private final Method method;
        private final int p;

        public Body(Method method, int i, Converter<T, zc4> converter) {
            this.method = method;
            this.p = i;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.setBody(this.converter.convert(t));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, e, this.p, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, strConvert, this.encoded);
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        public FieldMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.valueConverter.convert(value);
                if (strConvert == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addFormField(key, strConvert, this.encoded);
            }
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, strConvert);
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        public HeaderMap(Method method, int i, Converter<T, String> converter) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addHeader(key, this.valueConverter.convert(value));
            }
        }
    }

    public static final class Headers extends ParameterHandler<qc4> {
        private final Method method;
        private final int p;

        public Headers(Method method, int i) {
            this.method = method;
            this.p = i;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, qc4 qc4Var) {
            if (qc4Var == null) {
                throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
            }
            requestBuilder.addHeaders(qc4Var);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, zc4> converter;
        private final qc4 headers;
        private final Method method;
        private final int p;

        public Part(Method method, int i, qc4 qc4Var, Converter<T, zc4> converter) {
            this.method = method;
            this.p = i;
            this.headers = qc4Var;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, this.converter.convert(t));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, this.p, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter<T, zc4> valueConverter;

        public PartMap(Method method, int i, Converter<T, zc4> converter, String str) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addPart(qc4.g("Content-Disposition", "form-data; name=\"" + key + "\"", com.broadcom.bt.util.mime4j.field.Field.CONTENT_TRANSFER_ENCODING, this.transferEncoding), this.valueConverter.convert(value));
            }
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;
        private final int p;
        private final Converter<T, String> valueConverter;

        public Path(Method method, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.p = i;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t), this.encoded);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, strConvert, this.encoded);
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        public QueryMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.valueConverter.convert(value);
                if (strConvert == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addQueryParam(key, strConvert, this.encoded);
            }
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.addQueryParam(this.nameConverter.convert(t), null, this.encoded);
        }
    }

    public static final class RawPart extends ParameterHandler<uc4.b> {
        public static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, uc4.b bVar) {
            if (bVar != null) {
                requestBuilder.addPart(bVar);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;
        private final int p;

        public RelativeUrl(Method method, int i) {
            this.method = method;
            this.p = i;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.setRelativeUrl(obj);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        public final Class<T> cls;

        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            requestBuilder.addTag(this.cls, t);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;

    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                }
            }
        };
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.apply(requestBuilder, it.next());
                }
            }
        };
    }
}
