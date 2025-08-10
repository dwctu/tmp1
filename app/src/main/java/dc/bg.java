package dc;

import com.bumptech.glide.integration.webp.WebpFrame;

/* compiled from: WebpFrameInfo.java */
/* loaded from: classes.dex */
public class bg {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;

    public bg(int i, WebpFrame webpFrame) {
        this.a = i;
        this.b = webpFrame.getXOffest();
        this.c = webpFrame.getYOffest();
        this.d = webpFrame.getWidth();
        this.e = webpFrame.getHeight();
        this.f = webpFrame.getDurationMs();
        this.g = webpFrame.isBlendWithPreviousFrame();
        this.h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.a + ", xOffset=" + this.b + ", yOffset=" + this.c + ", width=" + this.d + ", height=" + this.e + ", duration=" + this.f + ", blendPreviousFrame=" + this.g + ", disposeBackgroundColor=" + this.h;
    }
}
