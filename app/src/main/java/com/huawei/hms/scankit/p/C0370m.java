package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.hardware.Camera;
import com.huawei.hms.scankit.p.C0342f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraMeteringManager.java */
/* renamed from: com.huawei.hms.scankit.p.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0370m {
    private Camera a;

    public final synchronized void a(Camera camera) {
        this.a = camera;
    }

    public final synchronized C0342f a() {
        RuntimeException e;
        int maxNumMeteringAreas;
        Rect rect;
        try {
            maxNumMeteringAreas = this.a.getParameters().getMaxNumMeteringAreas();
            try {
                rect = this.a.getParameters().getMeteringAreas().get(0).rect;
            } catch (RuntimeException e2) {
                e = e2;
                String str = "CameraMeteringManager::getCameraMeteringData failed: " + e.getMessage();
                rect = null;
                return new C0342f(maxNumMeteringAreas, rect);
            }
        } catch (RuntimeException e3) {
            e = e3;
            maxNumMeteringAreas = 0;
        }
        return new C0342f(maxNumMeteringAreas, rect);
    }

    public final synchronized void a(List<C0342f.a> list) {
        Camera camera = this.a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Camera.Area(list.get(i).a, list.get(i).b));
        }
        parameters.setMeteringAreas(arrayList);
        try {
            this.a.setParameters(parameters);
        } catch (RuntimeException e) {
            String str = "CameraMeteringManager::setCameraMeteringArea failed: " + e.getMessage();
        }
    }
}
