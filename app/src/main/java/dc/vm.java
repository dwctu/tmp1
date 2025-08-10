package dc;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class vm extends lm<GifDrawable> implements pi {
    public vm(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // dc.ti
    public int b() {
        return ((GifDrawable) this.a).i();
    }

    @Override // dc.ti
    @NonNull
    public Class<GifDrawable> c() {
        return GifDrawable.class;
    }

    @Override // dc.lm, dc.pi
    public void initialize() {
        ((GifDrawable) this.a).e().prepareToDraw();
    }

    @Override // dc.ti
    public void recycle() {
        ((GifDrawable) this.a).stop();
        ((GifDrawable) this.a).k();
    }
}
