package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class um implements dh<GifDrawable> {
    @Override // dc.dh
    @NonNull
    public ug b(@NonNull ah ahVar) {
        return ug.SOURCE;
    }

    @Override // dc.vg
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ti<GifDrawable> tiVar, @NonNull File file, @NonNull ah ahVar) throws Throwable {
        try {
            np.e(tiVar.get().c(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
