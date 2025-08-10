package io.microshow.rxffmpeg;

/* loaded from: classes4.dex */
public class RxFFmpegProgress {
    public int progress;
    public long progressTime;
    public int state;

    public RxFFmpegProgress(int i, int i2, long j) {
        this.state = 0;
        this.state = i;
        this.progress = i2;
        this.progressTime = j;
    }

    public RxFFmpegProgress(int i) {
        this(i, 0, 0L);
    }
}
