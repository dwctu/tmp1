package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* compiled from: CameraZoomManager.java */
/* renamed from: com.huawei.hms.scankit.p.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0374n {
    private Camera a;

    public final synchronized void a(Camera camera) {
        this.a = camera;
    }

    public final synchronized boolean b() {
        Camera camera = this.a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public final synchronized C0346g a() {
        return new C0346g(this.a.getParameters().getMaxZoom(), this.a.getParameters().getZoom(), this.a.getParameters().getZoomRatios());
    }

    public final synchronized void a(int i) {
        Camera camera = this.a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(i);
        try {
            this.a.setParameters(parameters);
        } catch (RuntimeException e) {
            String str = "CameraZoomManager::setCameraZoomIndex failed: " + e.getMessage();
        }
    }
}
