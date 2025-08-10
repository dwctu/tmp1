package io.agora.rtc2.video;

/* loaded from: classes4.dex */
public class AgoraImage {
    public double alpha;
    public int height;
    public String url;
    public int width;
    public int x;
    public int y;
    public int zOrder;

    public AgoraImage() {
        this.url = null;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.zOrder = 0;
        this.alpha = 1.0d;
    }

    public AgoraImage(String str) {
        this.url = str;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.zOrder = 0;
        this.alpha = 1.0d;
    }
}
