package dc;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import dc.ih;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class qh<T> implements ih<T> {
    public final Uri a;
    public final ContentResolver b;
    public T c;

    public qh(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
    }

    @Override // dc.ih
    public void a() {
        T t = this.c;
        if (t != null) {
            try {
                b(t);
            } catch (IOException unused) {
            }
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
    public final void d(@NonNull of ofVar, @NonNull ih.a<? super T> aVar) {
        try {
            T tE = e(this.a, this.b);
            this.c = tE;
            aVar.e(tE);
        } catch (FileNotFoundException e) {
            Log.isLoggable("LocalUriFetcher", 3);
            aVar.b(e);
        }
    }

    public abstract T e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
