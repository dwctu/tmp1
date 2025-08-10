package com.wear.widget.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class PhotoCameraDialog_ViewBinding implements Unbinder {
    public PhotoCameraDialog a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PhotoCameraDialog a;

        public a(PhotoCameraDialog_ViewBinding photoCameraDialog_ViewBinding, PhotoCameraDialog photoCameraDialog) {
            this.a = photoCameraDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PhotoCameraDialog a;

        public b(PhotoCameraDialog_ViewBinding photoCameraDialog_ViewBinding, PhotoCameraDialog photoCameraDialog) {
            this.a = photoCameraDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ PhotoCameraDialog a;

        public c(PhotoCameraDialog_ViewBinding photoCameraDialog_ViewBinding, PhotoCameraDialog photoCameraDialog) {
            this.a = photoCameraDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public PhotoCameraDialog_ViewBinding(PhotoCameraDialog photoCameraDialog, View view) {
        this.a = photoCameraDialog;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.from_album, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, photoCameraDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.from_camera, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, photoCameraDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cancel_from, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, photoCameraDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
