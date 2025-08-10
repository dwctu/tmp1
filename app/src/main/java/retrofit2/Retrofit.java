package retrofit2;

import dc.ac4;
import dc.bd4;
import dc.rc4;
import dc.vc4;
import dc.zc4;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public final class Retrofit {
    public final rc4 baseUrl;
    public final List<CallAdapter.Factory> callAdapterFactories;
    public final ac4.a callFactory;
    public final Executor callbackExecutor;
    public final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache = new ConcurrentHashMap();
    public final boolean validateEagerly;

    public Retrofit(ac4.a aVar, rc4 rc4Var, List<Converter.Factory> list, List<CallAdapter.Factory> list2, Executor executor, boolean z) {
        this.callFactory = aVar;
        this.baseUrl = rc4Var;
        this.converterFactories = list;
        this.callAdapterFactories = list2;
        this.callbackExecutor = executor;
        this.validateEagerly = z;
    }

    private void validateServiceInterface(Class<?> cls) throws SecurityException {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.validateEagerly) {
            Platform platform = Platform.get();
            for (Method method : cls.getDeclaredMethods()) {
                if (!platform.isDefaultMethod(method) && !Modifier.isStatic(method.getModifiers())) {
                    loadServiceMethod(method);
                }
            }
        }
    }

    public rc4 baseUrl() {
        return this.baseUrl;
    }

    public CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotationArr) {
        return nextCallAdapter(null, type, annotationArr);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public ac4.a callFactory() {
        return this.callFactory;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> T create(final Class<T> cls) throws SecurityException {
        validateServiceInterface(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1
            private final Platform platform = Platform.get();
            private final Object[] emptyArgs = new Object[0];

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (objArr == null) {
                    objArr = this.emptyArgs;
                }
                return this.platform.isDefaultMethod(method) ? this.platform.invokeDefaultMethod(method, cls, obj, objArr) : Retrofit.this.loadServiceMethod(method).invoke(objArr);
            }
        });
    }

    public ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod<?> annotations;
        ServiceMethod<?> serviceMethod = this.serviceMethodCache.get(method);
        if (serviceMethod != null) {
            return serviceMethod;
        }
        synchronized (this.serviceMethodCache) {
            annotations = this.serviceMethodCache.get(method);
            if (annotations == null) {
                annotations = ServiceMethod.parseAnnotations(this, method);
                this.serviceMethodCache.put(method, annotations);
            }
        }
        return annotations;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CallAdapter<?, ?> nextCallAdapter(CallAdapter.Factory factory, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.callAdapterFactories.indexOf(factory) + 1;
        int size = this.callAdapterFactories.size();
        for (int i = iIndexOf; i < size; i++) {
            CallAdapter<?, ?> callAdapter = this.callAdapterFactories.get(i).get(type, annotationArr, this);
            if (callAdapter != null) {
                return callAdapter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (factory != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.callAdapterFactories.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.callAdapterFactories.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.callAdapterFactories.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> Converter<T, zc4> nextRequestBodyConverter(Converter.Factory factory, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.converterFactories.indexOf(factory) + 1;
        int size = this.converterFactories.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter<T, zc4> converter = (Converter<T, zc4>) this.converterFactories.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (factory != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.converterFactories.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.converterFactories.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> Converter<bd4, T> nextResponseBodyConverter(Converter.Factory factory, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.converterFactories.indexOf(factory) + 1;
        int size = this.converterFactories.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter<bd4, T> converter = (Converter<bd4, T>) this.converterFactories.get(i).responseBodyConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (factory != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.converterFactories.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.converterFactories.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> Converter<T, zc4> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return nextRequestBodyConverter(null, type, annotationArr, annotationArr2);
    }

    public <T> Converter<bd4, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        return nextResponseBodyConverter(null, type, annotationArr);
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.converterFactories.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> converter = (Converter<T, String>) this.converterFactories.get(i).stringConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    public static final class Builder {
        private rc4 baseUrl;
        private final List<CallAdapter.Factory> callAdapterFactories;
        private ac4.a callFactory;
        private Executor callbackExecutor;
        private final List<Converter.Factory> converterFactories;
        private final Platform platform;
        private boolean validateEagerly;

        public Builder(Platform platform) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = platform;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory factory) {
            List<CallAdapter.Factory> list = this.callAdapterFactories;
            Objects.requireNonNull(factory, "factory == null");
            list.add(factory);
            return this;
        }

        public Builder addConverterFactory(Converter.Factory factory) {
            List<Converter.Factory> list = this.converterFactories;
            Objects.requireNonNull(factory, "factory == null");
            list.add(factory);
            return this;
        }

        public Builder baseUrl(URL url) {
            Objects.requireNonNull(url, "baseUrl == null");
            return baseUrl(rc4.m(url.toString()));
        }

        public Retrofit build() {
            if (this.baseUrl == null) {
                throw new IllegalStateException("Base URL required.");
            }
            ac4.a vc4Var = this.callFactory;
            if (vc4Var == null) {
                vc4Var = new vc4();
            }
            ac4.a aVar = vc4Var;
            Executor executorDefaultCallbackExecutor = this.callbackExecutor;
            if (executorDefaultCallbackExecutor == null) {
                executorDefaultCallbackExecutor = this.platform.defaultCallbackExecutor();
            }
            Executor executor = executorDefaultCallbackExecutor;
            ArrayList arrayList = new ArrayList(this.callAdapterFactories);
            arrayList.addAll(this.platform.defaultCallAdapterFactories(executor));
            ArrayList arrayList2 = new ArrayList(this.converterFactories.size() + 1 + this.platform.defaultConverterFactoriesSize());
            arrayList2.add(new BuiltInConverters());
            arrayList2.addAll(this.converterFactories);
            arrayList2.addAll(this.platform.defaultConverterFactories());
            return new Retrofit(aVar, this.baseUrl, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.validateEagerly);
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public Builder callFactory(ac4.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.callFactory = aVar;
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            Objects.requireNonNull(executor, "executor == null");
            this.callbackExecutor = executor;
            return this;
        }

        public Builder client(vc4 vc4Var) {
            Objects.requireNonNull(vc4Var, "client == null");
            return callFactory(vc4Var);
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder validateEagerly(boolean z) {
            this.validateEagerly = z;
            return this;
        }

        public Builder baseUrl(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return baseUrl(rc4.m(str));
        }

        public Builder() {
            this(Platform.get());
        }

        public Builder baseUrl(rc4 rc4Var) {
            Objects.requireNonNull(rc4Var, "baseUrl == null");
            if ("".equals(rc4Var.t().get(r0.size() - 1))) {
                this.baseUrl = rc4Var;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + rc4Var);
        }

        public Builder(Retrofit retrofit) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            Platform platform = Platform.get();
            this.platform = platform;
            this.callFactory = retrofit.callFactory;
            this.baseUrl = retrofit.baseUrl;
            int size = retrofit.converterFactories.size() - platform.defaultConverterFactoriesSize();
            for (int i = 1; i < size; i++) {
                this.converterFactories.add(retrofit.converterFactories.get(i));
            }
            int size2 = retrofit.callAdapterFactories.size() - this.platform.defaultCallAdapterFactoriesSize();
            for (int i2 = 0; i2 < size2; i2++) {
                this.callAdapterFactories.add(retrofit.callAdapterFactories.get(i2));
            }
            this.callbackExecutor = retrofit.callbackExecutor;
            this.validateEagerly = retrofit.validateEagerly;
        }
    }
}
