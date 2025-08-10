package retrofit2;

import dc.ge4;
import dc.yc4;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    yc4 request();

    ge4 timeout();
}
