package xyz.doikki.videoplayer.render;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.ak4;
import dc.bk4;
import dc.sj4;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class TextureRenderView extends TextureView implements ak4, TextureView.SurfaceTextureListener {
    public final bk4 a;
    public SurfaceTexture b;

    @Nullable
    public sj4 c;
    public Surface d;

    public TextureRenderView(Context context) {
        super(context);
        this.a = new bk4();
        setSurfaceTextureListener(this);
    }

    @Override // dc.ak4
    public void a(@NonNull sj4 sj4Var) {
        this.c = sj4Var;
    }

    @Override // dc.ak4
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int[] iArrA = this.a.a(i, i2);
        setMeasuredDimension(iArrA[0], iArrA[1]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.b;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.b = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.d = surface;
        sj4 sj4Var = this.c;
        if (sj4Var != null) {
            sj4Var.r(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // dc.ak4
    public void release() {
        Surface surface = this.d;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // dc.ak4
    public void setScaleType(int i) {
        this.a.b(i);
        requestLayout();
    }

    @Override // dc.ak4
    public void setVideoRotation(int i) {
        this.a.c(i);
        setRotation(i);
    }

    @Override // dc.ak4
    public void setVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.d(i, i2);
        requestLayout();
    }
}
