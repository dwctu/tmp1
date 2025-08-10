package dc;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import dc.ih;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class gh<T> implements ih<T> {
    public final String a;
    public final AssetManager b;
    public T c;

    public gh(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    @Override // dc.ih
    public void a() {
        T t = this.c;
        if (t == null) {
            return;
        }
        try {
            b(t);
        } catch (IOException unused) {
        }
    }

    public abstract void b(T t) throws IOException;

    @Override // dc.ih
    @NonNull
    public sg c() {
        return sg.LOCAL;
    }

    @Override // dc.ih
    public void cancel() {
    }

    @Override // dc.ih
    public void d(@NonNull of ofVar, @NonNull ih.a<? super T> aVar) {
        try {
            T tE = e(this.b, this.a);
            this.c = tE;
            aVar.e(tE);
        } catch (IOException e) {
            Log.isLoggable("AssetPathFetcher", 3);
            aVar.b(e);
        }
    }

    public abstract T e(AssetManager assetManager, String str) throws IOException;
}
