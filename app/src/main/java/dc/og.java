package dc;

import android.util.Log;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import java.io.File;
import java.io.IOException;

/* compiled from: WebpDrawableEncoder.java */
/* loaded from: classes.dex */
public class og implements dh<WebpDrawable> {
    @Override // dc.dh
    public ug b(ah ahVar) {
        return ug.SOURCE;
    }

    @Override // dc.vg
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(ti<WebpDrawable> tiVar, File file, ah ahVar) throws Throwable {
        try {
            np.e(tiVar.get().c(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("WebpEncoder", 5);
            return false;
        }
    }
}
