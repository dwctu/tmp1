package dc;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: DataRewinder.java */
/* loaded from: classes.dex */
public interface jh<T> {

    /* compiled from: DataRewinder.java */
    public interface a<T> {
        @NonNull
        jh<T> a(@NonNull T t);

        @NonNull
        Class<T> getDataClass();
    }

    void a();

    @NonNull
    T b() throws IOException;
}
