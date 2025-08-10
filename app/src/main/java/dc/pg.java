package dc;

import com.bumptech.glide.integration.webp.decoder.WebpDrawable;

/* compiled from: WebpDrawableResource.java */
/* loaded from: classes.dex */
public class pg extends lm<WebpDrawable> implements pi {
    public pg(WebpDrawable webpDrawable) {
        super(webpDrawable);
    }

    @Override // dc.ti
    public int b() {
        return ((WebpDrawable) this.a).i();
    }

    @Override // dc.ti
    public Class<WebpDrawable> c() {
        return WebpDrawable.class;
    }

    @Override // dc.lm, dc.pi
    public void initialize() {
        ((WebpDrawable) this.a).e().prepareToDraw();
    }

    @Override // dc.ti
    public void recycle() {
        ((WebpDrawable) this.a).stop();
        ((WebpDrawable) this.a).l();
    }
}
