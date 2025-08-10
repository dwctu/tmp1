package dc;

import android.content.Context;
import dc.pj;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class rj extends pj {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    public class a implements pj.a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // dc.pj.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public rj(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public rj(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
