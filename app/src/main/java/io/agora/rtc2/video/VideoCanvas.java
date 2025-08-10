package io.agora.rtc2.video;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes4.dex */
public class VideoCanvas {
    public static final int RENDER_MODE_ADAPTIVE = 3;
    public static final int RENDER_MODE_FIT = 2;
    public static final int RENDER_MODE_HIDDEN = 1;
    public static final int VIEW_SETUP_MODE_ADD = 1;
    public static final int VIEW_SETUP_MODE_REMOVE = 2;
    public static final int VIEW_SETUP_MODE_REPLACE = 0;
    public int mediaPlayerId;
    public int mirrorMode;
    public Rect rect;
    public int renderMode;
    public int setupMode;
    public int sourceType;
    public int uid;
    public View view;

    public VideoCanvas(View view) {
        this.setupMode = 0;
        this.view = view;
        this.renderMode = 1;
    }

    public VideoCanvas(View view, int i, int i2) {
        this.setupMode = 0;
        this.view = view;
        this.renderMode = i;
        this.uid = i2;
    }
}
