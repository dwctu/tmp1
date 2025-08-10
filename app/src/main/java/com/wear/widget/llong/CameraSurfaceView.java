package com.wear.widget.llong;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.agora.rtc2.Constants;
import java.io.IOException;

/* loaded from: classes4.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public Camera a;
    public SurfaceHolder b;
    public int c;
    public int d;
    public int e;
    public int f;

    public CameraSurfaceView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.e = 0;
        this.f = 0;
    }

    public final Camera.Size a(int i, int i2) {
        int i3;
        float fMax = Math.max(i, i2) / Math.min(i, i2);
        Camera.Size size = null;
        float f = -1.0f;
        for (Camera.Size size2 : this.a.getParameters().getSupportedPictureSizes()) {
            if (size2.width >= 500 && (i3 = size2.height) >= 500) {
                float fAbs = Math.abs((Math.max(r3, i3) / Math.min(size2.width, size2.height)) - fMax);
                if (f < 0.0f) {
                    size = size2;
                    f = fAbs;
                }
                if (fAbs < f) {
                    size = size2;
                    f = fAbs;
                }
            }
        }
        return size;
    }

    public final Camera.Size b(int i, int i2) {
        float fMax = Math.max(i, i2) / Math.min(i, i2);
        Camera.Size size = null;
        float f = -1.0f;
        for (Camera.Size size2 : this.a.getParameters().getSupportedPreviewSizes()) {
            float fAbs = Math.abs((Math.max(size2.width, size2.height) / Math.min(size2.width, size2.height)) - fMax);
            if (f < 0.0f) {
                size = size2;
                f = fAbs;
            }
            if (fAbs < f) {
                size = size2;
                f = fAbs;
            }
        }
        return size;
    }

    public final int c(int i) {
        int i2 = i * 90;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1) {
            i2 = 90;
        } else if (i == 2) {
            i2 = 180;
        } else if (i == 3) {
            i2 = Constants.VIDEO_ORIENTATION_270;
        }
        int i3 = this.e / 90;
        this.e = i3;
        int i4 = i3 * 90;
        this.e = i4;
        int i5 = i2 + i4;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f, cameraInfo);
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i5) % 360)) % 360 : ((cameraInfo.orientation - i5) + 360) % 360;
    }

    public void setmCameraId(int i) {
        this.f = i;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) throws IOException {
        if (this.b.getSurface() == null) {
            return;
        }
        try {
            this.a.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.a.setPreviewDisplay(this.b);
            this.a.setDisplayOrientation(c(0));
            Camera.Parameters parameters = this.a.getParameters();
            Camera.Size sizeB = b(this.c, this.d);
            parameters.setPreviewSize(sizeB.width, sizeB.height);
            Camera.Size sizeA = a(this.c, this.d);
            if (sizeA != null) {
                parameters.setPictureSize(sizeA.width, sizeA.height);
            }
            if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
            }
            this.a.setParameters(parameters);
            this.a.startPreview();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        try {
            this.a.setPreviewDisplay(this.b);
            this.a.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.e = 0;
        this.f = 0;
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.e = 0;
        this.f = 0;
    }
}
