package dc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: WebpGlideLibraryModule.java */
/* loaded from: classes.dex */
public class cg extends ao {
    @Override // dc.ao, dc.co
    public void b(Context context, kf kfVar, Registry registry) {
        Resources resources = context.getResources();
        cj cjVarF = kfVar.f();
        zi ziVarE = kfVar.e();
        ng ngVar = new ng(registry.g(), resources.getDisplayMetrics(), cjVarF, ziVarE);
        eg egVar = new eg(ziVarE, cjVarF);
        gg ggVar = new gg(ngVar);
        jg jgVar = new jg(ngVar, ziVarE);
        hg hgVar = new hg(context, ziVarE, cjVarF);
        registry.q("Bitmap", ByteBuffer.class, Bitmap.class, ggVar);
        registry.q("Bitmap", InputStream.class, Bitmap.class, jgVar);
        registry.q("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new fl(resources, ggVar));
        registry.q("BitmapDrawable", InputStream.class, BitmapDrawable.class, new fl(resources, jgVar));
        registry.q("Bitmap", ByteBuffer.class, Bitmap.class, new fg(egVar));
        registry.q("Bitmap", InputStream.class, Bitmap.class, new ig(egVar));
        registry.p(ByteBuffer.class, WebpDrawable.class, hgVar);
        registry.p(InputStream.class, WebpDrawable.class, new kg(hgVar, ziVarE));
        registry.o(WebpDrawable.class, new og());
    }
}
