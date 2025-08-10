package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: GifDrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public class en implements fn<GifDrawable, byte[]> {
    @Override // dc.fn
    @Nullable
    public ti<byte[]> a(@NonNull ti<GifDrawable> tiVar, @NonNull ah ahVar) {
        return new jm(np.d(tiVar.get().c()));
    }
}
