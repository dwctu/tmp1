package dc;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import dc.hi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class ri<Data, ResourceType, Transcode> {
    public final Pools.Pool<List<Throwable>> a;
    public final List<? extends hi<Data, ResourceType, Transcode>> b;
    public final String c;

    public ri(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<hi<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = pool;
        vp.c(list);
        this.b = list;
        this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public ti<Transcode> a(jh<Data> jhVar, @NonNull ah ahVar, int i, int i2, hi.a<ResourceType> aVar) throws GlideException {
        List<Throwable> listAcquire = this.a.acquire();
        vp.d(listAcquire);
        List<Throwable> list = listAcquire;
        try {
            return b(jhVar, ahVar, i, i2, aVar, list);
        } finally {
            this.a.release(list);
        }
    }

    public final ti<Transcode> b(jh<Data> jhVar, @NonNull ah ahVar, int i, int i2, hi.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.b.size();
        ti<Transcode> tiVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                tiVarA = this.b.get(i3).a(jhVar, i, i2, ahVar, aVar);
            } catch (GlideException e) {
                list.add(e);
            }
            if (tiVarA != null) {
                break;
            }
        }
        if (tiVarA != null) {
            return tiVarA;
        }
        throw new GlideException(this.c, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + MessageFormatter.DELIM_STOP;
    }
}
