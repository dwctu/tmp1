package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class hi<DataType, ResourceType, Transcode> {
    public final Class<DataType> a;
    public final List<? extends ch<DataType, ResourceType>> b;
    public final fn<ResourceType, Transcode> c;
    public final Pools.Pool<List<Throwable>> d;
    public final String e;

    /* compiled from: DecodePath.java */
    public interface a<ResourceType> {
        @NonNull
        ti<ResourceType> a(@NonNull ti<ResourceType> tiVar);
    }

    public hi(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ch<DataType, ResourceType>> list, fn<ResourceType, Transcode> fnVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = list;
        this.c = fnVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public ti<Transcode> a(jh<DataType> jhVar, int i, int i2, @NonNull ah ahVar, a<ResourceType> aVar) throws GlideException {
        return this.c.a(aVar.a(b(jhVar, i, i2, ahVar)), ahVar);
    }

    @NonNull
    public final ti<ResourceType> b(jh<DataType> jhVar, int i, int i2, @NonNull ah ahVar) throws GlideException {
        List<Throwable> listAcquire = this.d.acquire();
        vp.d(listAcquire);
        List<Throwable> list = listAcquire;
        try {
            return c(jhVar, i, i2, ahVar, list);
        } finally {
            this.d.release(list);
        }
    }

    @NonNull
    public final ti<ResourceType> c(jh<DataType> jhVar, int i, int i2, @NonNull ah ahVar, List<Throwable> list) throws GlideException {
        int size = this.b.size();
        ti<ResourceType> tiVarB = null;
        for (int i3 = 0; i3 < size; i3++) {
            ch<DataType, ResourceType> chVar = this.b.get(i3);
            try {
                if (chVar.a(jhVar.b(), ahVar)) {
                    tiVarB = chVar.b(jhVar.b(), i, i2, ahVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    String str = "Failed to decode data for " + chVar;
                }
                list.add(e);
            }
            if (tiVarB != null) {
                break;
            }
        }
        if (tiVarB != null) {
            return tiVarB;
        }
        throw new GlideException(this.e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + MessageFormatter.DELIM_STOP;
    }
}
