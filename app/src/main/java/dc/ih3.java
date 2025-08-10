package dc;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.util.MyApplication;
import java.io.IOException;

/* compiled from: CameraController.java */
/* loaded from: classes4.dex */
public class ih3 {
    public jh3 a;
    public Camera b;
    public Camera.Size c;
    public Camera.Size d;
    public Point e;
    public int f;
    public int g;

    public ih3() {
        jh3 jh3Var = new jh3();
        this.a = jh3Var;
        jh3Var.a = 1.778f;
    }

    public boolean a() {
        Camera camera = this.b;
        if (camera == null) {
            return false;
        }
        camera.stopPreview();
        this.b.release();
        this.b = null;
        return false;
    }

    public final Camera.Size b(int i, int i2) {
        int i3;
        float fMax = Math.max(i, i2) / Math.min(i, i2);
        Camera.Size size = null;
        float f = -1.0f;
        for (Camera.Size size2 : this.b.getParameters().getSupportedPictureSizes()) {
            int i4 = size2.width;
            if (i4 >= 400 && (i3 = size2.height) >= 400 && i4 <= 3000 && i3 <= 3000) {
                float fAbs = Math.abs((Math.max(i4, i3) / Math.min(size2.width, size2.height)) - fMax);
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

    public final Camera.Size c(int i, int i2) {
        int i3;
        float fMax = Math.max(i, i2) / Math.min(i, i2);
        Camera.Size size = null;
        float f = -1.0f;
        for (Camera.Size size2 : this.b.getParameters().getSupportedPreviewSizes()) {
            int i4 = size2.width;
            if (i4 >= 400 && (i3 = size2.height) >= 400 && i4 <= 1900 && i3 <= 1900) {
                float fAbs = Math.abs((Math.max(i4, i3) / Math.min(size2.width, size2.height)) - fMax);
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

    public Point d() {
        return this.e;
    }

    public Camera e() {
        return this.b;
    }

    public void f(Point point, Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.b;
        if (camera == null) {
            return;
        }
        try {
            camera.autoFocus(autoFocusCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(int i) {
        try {
            Camera cameraOpen = Camera.open(i);
            this.b = cameraOpen;
            if (cameraOpen != null) {
                Camera.Parameters parameters = cameraOpen.getParameters();
                float f = this.a.a;
                int i2 = this.f;
                if (i2 > 0) {
                    int i3 = this.g;
                }
                this.c = c(i2, this.g);
                Camera.Size sizeB = b(this.f, this.g);
                this.d = sizeB;
                parameters.setPictureSize(sizeB.width, sizeB.height);
                Camera.Size size = this.c;
                parameters.setPreviewSize(size.width, size.height);
                this.b.setParameters(parameters);
                Camera.Size previewSize = parameters.getPreviewSize();
                Camera.Size pictureSize = parameters.getPictureSize();
                new Point(pictureSize.height, pictureSize.width);
                this.e = new Point(previewSize.height, previewSize.width);
            }
        } catch (Exception e) {
            sg3.l(e.getMessage());
            FirebaseCrashlytics.getInstance().recordException(e);
            MyApplication.H().finish();
        }
    }

    public void h() {
        Camera camera = this.b;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public void i(SurfaceTexture surfaceTexture) throws IOException {
        if (this.b != null) {
            try {
                this.b.setPreviewTexture(surfaceTexture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void j(int i, int i2) {
        this.f = i;
        this.g = i2;
        String str = "setSurfaceWidth: " + i + ",surfaceHeight:" + i2;
    }
}
