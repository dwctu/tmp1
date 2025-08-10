package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* compiled from: CameraExposureManager.java */
/* renamed from: com.huawei.hms.scankit.p.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0362k {
    private Camera a;

    public final synchronized void a(Camera camera) {
        this.a = camera;
    }

    public final synchronized C0330c a() {
        return new C0330c(this.a.getParameters().getMaxExposureCompensation(), this.a.getParameters().getMinExposureCompensation(), this.a.getParameters().getExposureCompensation(), this.a.getParameters().getExposureCompensationStep());
    }

    public final synchronized void a(int i) {
        Camera camera = this.a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setExposureCompensation(i);
            this.a.setParameters(parameters);
        } catch (RuntimeException unused) {
        }
    }
}
