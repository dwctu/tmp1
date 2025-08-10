package dc;

import android.content.Context;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class yg<T> implements eh<T> {
    public final Collection<? extends eh<T>> b;

    @SafeVarargs
    public yg(@NonNull eh<T>... ehVarArr) {
        if (ehVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.b = Arrays.asList(ehVarArr);
    }

    @Override // dc.eh
    @NonNull
    public ti<T> a(@NonNull Context context, @NonNull ti<T> tiVar, int i, int i2) {
        Iterator<? extends eh<T>> it = this.b.iterator();
        ti<T> tiVar2 = tiVar;
        while (it.hasNext()) {
            ti<T> tiVarA = it.next().a(context, tiVar2, i, i2);
            if (tiVar2 != null && !tiVar2.equals(tiVar) && !tiVar2.equals(tiVarA)) {
                tiVar2.recycle();
            }
            tiVar2 = tiVarA;
        }
        return tiVar2;
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        Iterator<? extends eh<T>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(messageDigest);
        }
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (obj instanceof yg) {
            return this.b.equals(((yg) obj).b);
        }
        return false;
    }

    @Override // dc.xg
    public int hashCode() {
        return this.b.hashCode();
    }
}
