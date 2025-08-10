package dc;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
@RequiresApi(21)
/* loaded from: classes.dex */
public final class am implements ch<ParcelFileDescriptor, Bitmap> {
    public final rl a;

    public am(rl rlVar) {
        this.a = rlVar;
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.d(parcelFileDescriptor, i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull ah ahVar) {
        return this.a.o(parcelFileDescriptor);
    }
}
