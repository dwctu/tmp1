package com.huawei.hms.scankit;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Process;
import android.view.TextureView;

/* compiled from: CaptureHelper.java */
/* renamed from: com.huawei.hms.scankit.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class TextureViewSurfaceTextureListenerC0316c implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ C0318e a;

    public TextureViewSurfaceTextureListenerC0316c(C0318e c0318e) {
        this.a = c0318e;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.a.E = false;
        if (surfaceTexture == null) {
            com.huawei.hms.scankit.util.a.b(C0318e.a, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.a.q) {
            return;
        }
        this.a.q = true;
        if (this.a.g.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
            C0318e c0318e = this.a;
            c0318e.a(c0318e.l);
        } else {
            if (!(this.a.g instanceof Activity) || Build.VERSION.SDK_INT < 23) {
                return;
            }
            this.a.E = true;
            ((Activity) this.a.g).requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.a.q = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
