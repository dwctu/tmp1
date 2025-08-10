package com.wear.ui.longDistance.video.player;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes4.dex */
public class MyVideoView extends VideoView {
    public MyVideoView(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.doikki.videoplayer.player.BaseVideoView
    public void E(boolean z) {
        this.m = 0L;
        super.E(z);
    }

    @Override // xyz.doikki.videoplayer.player.BaseVideoView, dc.qj4
    public boolean c() {
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.d.setBackgroundColor(i);
    }

    public MyVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
