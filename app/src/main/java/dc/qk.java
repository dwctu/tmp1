package dc;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.broadcom.bt.util.io.IOUtils;
import dc.lk;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class qk<Data> implements lk<Integer, Data> {
    public final lk<Uri, Data> a;
    public final Resources b;

    /* compiled from: ResourceLoader.java */
    public static final class a implements mk<Integer, AssetFileDescriptor> {
        public final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // dc.mk
        public lk<Integer, AssetFileDescriptor> b(pk pkVar) {
            return new qk(this.a, pkVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    public static class b implements mk<Integer, ParcelFileDescriptor> {
        public final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // dc.mk
        @NonNull
        public lk<Integer, ParcelFileDescriptor> b(pk pkVar) {
            return new qk(this.a, pkVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    public static class c implements mk<Integer, InputStream> {
        public final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // dc.mk
        @NonNull
        public lk<Integer, InputStream> b(pk pkVar) {
            return new qk(this.a, pkVar.d(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    public static class d implements mk<Integer, Uri> {
        public final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override // dc.mk
        @NonNull
        public lk<Integer, Uri> b(pk pkVar) {
            return new qk(this.a, tk.c());
        }
    }

    public qk(Resources resources, lk<Uri, Data> lkVar) {
        this.b = resources;
        this.a = lkVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull Integer num, int i, int i2, @NonNull ah ahVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.a.b(uriD, i, i2, ahVar);
    }

    @Nullable
    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.b.getResourceTypeName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            String str = "Received invalid resource id: " + num;
            return null;
        }
    }

    @Override // dc.lk
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}
