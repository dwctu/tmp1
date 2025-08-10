package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.hardware.Camera;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;

/* compiled from: CameraConfigImpl.java */
/* renamed from: com.huawei.hms.scankit.p.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0358j {
    private C0326b a;
    public Point b;
    private Point c;

    public final void a(Camera camera, C0326b c0326b) {
        if (camera == null || c0326b == null) {
            throw new IllegalArgumentException("initCameraParameters param is invalid");
        }
        Camera.Parameters parameters = camera.getParameters();
        this.a = c0326b;
        this.b = a(parameters, c0326b.a(), false);
        String str = "initCameraParameters previewCameraSize: " + this.b.toString();
        if (c0326b.c() == 0) {
            this.c = a(parameters, c0326b.a(), true);
            String str2 = "initCameraParameters pictureCameraSize: " + this.c.toString();
        }
        Point point = this.b;
        Point point2 = this.c;
        if (this.a != null) {
            Camera.Parameters parameters2 = camera.getParameters();
            parameters2.setPreviewSize(point.x, point.y);
            if (this.a.c() == 0) {
                parameters2.setPictureSize(point2.x, point2.y);
            }
            C0326b c0326b2 = this.a;
            if (c0326b2 != null) {
                String strF = c0326b2.f();
                if (!strF.equals("off") && !strF.equals("torch")) {
                    strF = "off";
                }
                parameters2.setFlashMode(strF);
            }
            a(parameters2);
            if (parameters2.isZoomSupported()) {
                parameters2.setZoom(1);
            }
            if (this.a.e()) {
                parameters2.setRecordingHint(true);
            }
            camera.setParameters(parameters2);
        }
    }

    private static Point a(Camera.Parameters parameters, Point point, boolean z) {
        List<Camera.Size> supportedPictureSizes;
        if (!z) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPictureSizes != null && !supportedPictureSizes.isEmpty()) {
            return a(supportedPictureSizes, point);
        }
        return new Point(0, 0);
    }

    private static Point a(List<Camera.Size> list, Point point) {
        double d = point.x / point.y;
        int i = 0;
        double dAbs = Double.MAX_VALUE;
        int i2 = 0;
        for (Camera.Size size : list) {
            int i3 = size.width;
            int i4 = size.height;
            if (i3 == point.x && i4 == point.y) {
                return new Point(i3, i4);
            }
            if (i3 * i4 >= 153600.0d) {
                double d2 = (i3 / i4) - d;
                if (Math.abs(d2) < dAbs) {
                    dAbs = Math.abs(d2);
                    i2 = i4;
                    i = i3;
                }
            }
        }
        return new Point(i, i2);
    }

    private static void a(Camera.Parameters parameters) {
        String str;
        String[] strArr = {"continuous-picture", "continuous-video", TtmlNode.TEXT_EMPHASIS_AUTO};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= 3) {
                str = null;
                break;
            }
            str = strArr[i];
            if (supportedFocusModes.contains(str)) {
                break;
            } else {
                i++;
            }
        }
        if (str != null) {
            "setFocusMode: ".concat(String.valueOf(str));
            parameters.setFocusMode(str);
        }
    }
}
