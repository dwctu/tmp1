package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: DataFetcher.java */
/* loaded from: classes.dex */
public interface ih<T> {

    /* compiled from: DataFetcher.java */
    public interface a<T> {
        void b(@NonNull Exception exc);

        void e(@Nullable T t);
    }

    void a();

    @NonNull
    sg c();

    void cancel();

    void d(@NonNull of ofVar, @NonNull a<? super T> aVar);

    @NonNull
    Class<T> getDataClass();
}
