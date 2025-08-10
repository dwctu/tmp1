package dc;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import dc.jh;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorRewinder.java */
/* loaded from: classes.dex */
public final class rh implements jh<ParcelFileDescriptor> {
    public final b a;

    /* compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    public static final class a implements jh.a<ParcelFileDescriptor> {
        @Override // dc.jh.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public jh<ParcelFileDescriptor> a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new rh(parcelFileDescriptor);
        }

        @Override // dc.jh.a
        @NonNull
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }
    }

    /* compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    public static final class b {
        public final ParcelFileDescriptor a;

        public b(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor a() throws IOException, ErrnoException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    @RequiresApi(21)
    public rh(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new b(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // dc.jh
    public void a() {
    }

    @Override // dc.jh
    @NonNull
    @RequiresApi(21)
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor b() throws IOException {
        return this.a.a();
    }
}
