package retrofit2;

import dc.ad4;
import dc.bd4;
import dc.qc4;
import dc.wc4;
import dc.yc4;
import java.util.Objects;
import retrofit2.OkHttpCall;

/* loaded from: classes5.dex */
public final class Response<T> {
    private final T body;
    private final bd4 errorBody;
    private final ad4 rawResponse;

    private Response(ad4 ad4Var, T t, bd4 bd4Var) {
        this.rawResponse = ad4Var;
        this.body = t;
        this.errorBody = bd4Var;
    }

    public static <T> Response<T> error(int i, bd4 bd4Var) {
        Objects.requireNonNull(bd4Var, "body == null");
        if (i < 400) {
            throw new IllegalArgumentException("code < 400: " + i);
        }
        ad4.a aVar = new ad4.a();
        aVar.b(new OkHttpCall.NoContentResponseBody(bd4Var.contentType(), bd4Var.contentLength()));
        aVar.g(i);
        aVar.l("Response.error()");
        aVar.o(wc4.HTTP_1_1);
        yc4.a aVar2 = new yc4.a();
        aVar2.k("http://localhost/");
        aVar.q(aVar2.b());
        return error(bd4Var, aVar.c());
    }

    public static <T> Response<T> success(T t) {
        ad4.a aVar = new ad4.a();
        aVar.g(200);
        aVar.l("OK");
        aVar.o(wc4.HTTP_1_1);
        yc4.a aVar2 = new yc4.a();
        aVar2.k("http://localhost/");
        aVar.q(aVar2.b());
        return success(t, aVar.c());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.f();
    }

    public bd4 errorBody() {
        return this.errorBody;
    }

    public qc4 headers() {
        return this.rawResponse.q();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.x();
    }

    public ad4 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i, T t) {
        if (i >= 200 && i < 300) {
            ad4.a aVar = new ad4.a();
            aVar.g(i);
            aVar.l("Response.success()");
            aVar.o(wc4.HTTP_1_1);
            yc4.a aVar2 = new yc4.a();
            aVar2.k("http://localhost/");
            aVar.q(aVar2.b());
            return success(t, aVar.c());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i);
    }

    public static <T> Response<T> error(bd4 bd4Var, ad4 ad4Var) {
        Objects.requireNonNull(bd4Var, "body == null");
        Objects.requireNonNull(ad4Var, "rawResponse == null");
        if (!ad4Var.isSuccessful()) {
            return new Response<>(ad4Var, null, bd4Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T t, qc4 qc4Var) {
        Objects.requireNonNull(qc4Var, "headers == null");
        ad4.a aVar = new ad4.a();
        aVar.g(200);
        aVar.l("OK");
        aVar.o(wc4.HTTP_1_1);
        aVar.j(qc4Var);
        yc4.a aVar2 = new yc4.a();
        aVar2.k("http://localhost/");
        aVar.q(aVar2.b());
        return success(t, aVar.c());
    }

    public static <T> Response<T> success(T t, ad4 ad4Var) {
        Objects.requireNonNull(ad4Var, "rawResponse == null");
        if (ad4Var.isSuccessful()) {
            return new Response<>(ad4Var, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
