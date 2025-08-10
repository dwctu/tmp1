package retrofit2.converter.moshi;

import dc.bd4;
import dc.nf1;
import dc.pf1;
import dc.yf1;
import dc.zc4;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class MoshiConverterFactory extends Converter.Factory {
    private final boolean failOnUnknown;
    private final boolean lenient;
    private final yf1 moshi;
    private final boolean serializeNulls;

    private MoshiConverterFactory(yf1 yf1Var, boolean z, boolean z2, boolean z3) {
        this.moshi = yf1Var;
        this.lenient = z;
        this.failOnUnknown = z2;
        this.serializeNulls = z3;
    }

    public static MoshiConverterFactory create() {
        return create(new yf1.a().b());
    }

    private static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(pf1.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : Collections.emptySet();
    }

    public MoshiConverterFactory asLenient() {
        return new MoshiConverterFactory(this.moshi, true, this.failOnUnknown, this.serializeNulls);
    }

    public MoshiConverterFactory failOnUnknown() {
        return new MoshiConverterFactory(this.moshi, this.lenient, true, this.serializeNulls);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, zc4> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        nf1 nf1VarE = this.moshi.e(type, jsonAnnotations(annotationArr));
        if (this.lenient) {
            nf1VarE = nf1VarE.e();
        }
        if (this.failOnUnknown) {
            nf1VarE = nf1VarE.a();
        }
        if (this.serializeNulls) {
            nf1VarE = nf1VarE.g();
        }
        return new MoshiRequestBodyConverter(nf1VarE);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<bd4, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        nf1 nf1VarE = this.moshi.e(type, jsonAnnotations(annotationArr));
        if (this.lenient) {
            nf1VarE = nf1VarE.e();
        }
        if (this.failOnUnknown) {
            nf1VarE = nf1VarE.a();
        }
        if (this.serializeNulls) {
            nf1VarE = nf1VarE.g();
        }
        return new MoshiResponseBodyConverter(nf1VarE);
    }

    public MoshiConverterFactory withNullSerialization() {
        return new MoshiConverterFactory(this.moshi, this.lenient, this.failOnUnknown, true);
    }

    public static MoshiConverterFactory create(yf1 yf1Var) {
        Objects.requireNonNull(yf1Var, "moshi == null");
        return new MoshiConverterFactory(yf1Var, false, false, false);
    }
}
