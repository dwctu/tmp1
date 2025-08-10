package dc;

/* compiled from: ArrayPool.java */
/* loaded from: classes.dex */
public interface zi {
    void a(int i);

    void b();

    <T> T c(int i, Class<T> cls);

    <T> T d(int i, Class<T> cls);

    @Deprecated
    <T> void e(T t, Class<T> cls);

    <T> void put(T t);
}
