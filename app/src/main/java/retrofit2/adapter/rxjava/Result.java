package retrofit2.adapter.rxjava;

import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class Result<T> {
    private final Throwable error;
    private final Response<T> response;

    private Result(Response<T> response, Throwable th) {
        this.response = response;
        this.error = th;
    }

    public static <T> Result<T> error(Throwable th) {
        Objects.requireNonNull(th, "error == null");
        return new Result<>(null, th);
    }

    public static <T> Result<T> response(Response<T> response) {
        Objects.requireNonNull(response, "response == null");
        return new Result<>(response, null);
    }

    public boolean isError() {
        return this.error != null;
    }

    public String toString() {
        if (this.error != null) {
            return "Result{isError=true, error=\"" + this.error + "\"}";
        }
        return "Result{isError=false, response=" + this.response + MessageFormatter.DELIM_STOP;
    }

    public Throwable error() {
        return this.error;
    }

    public Response<T> response() {
        return this.response;
    }
}
