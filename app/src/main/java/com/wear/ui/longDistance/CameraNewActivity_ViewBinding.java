package com.wear.ui.longDistance;

import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.util.camera.TakeView;
import com.wear.util.camera.record.widget.CameraView;
import com.wear.util.camera.record.widget.FocusImageView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class CameraNewActivity_ViewBinding implements Unbinder {
    public CameraNewActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public a(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public b(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public c(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public d(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public e(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public f(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ CameraNewActivity a;

        public g(CameraNewActivity_ViewBinding cameraNewActivity_ViewBinding, CameraNewActivity cameraNewActivity) {
            this.a = cameraNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public CameraNewActivity_ViewBinding(CameraNewActivity cameraNewActivity, View view) {
        this.a = cameraNewActivity;
        cameraNewActivity.llScreanRootLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ac_camera_root_layout, "field 'llScreanRootLayout'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_camera_iv_burn, "field 'ivBurn' and method 'onClick'");
        cameraNewActivity.ivBurn = (ImageView) Utils.castView(viewFindRequiredView, R.id.ac_camera_iv_burn, "field 'ivBurn'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, cameraNewActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ac_camera_iv_flash, "field 'ivFlash' and method 'onClick'");
        cameraNewActivity.ivFlash = (ImageView) Utils.castView(viewFindRequiredView2, R.id.ac_camera_iv_flash, "field 'ivFlash'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, cameraNewActivity));
        cameraNewActivity.ivPreview = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_camera_preview_photo, "field 'ivPreview'", ImageView.class);
        cameraNewActivity.tvTakeType = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_camera_tv_photo, "field 'tvTakeType'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ac_camera_tv_cancel, "field 'tvCancel' and method 'onClick'");
        cameraNewActivity.tvCancel = (TextView) Utils.castView(viewFindRequiredView3, R.id.ac_camera_tv_cancel, "field 'tvCancel'", TextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, cameraNewActivity));
        cameraNewActivity.takeView = (TakeView) Utils.findRequiredViewAsType(view, R.id.ac_camera_takeview, "field 'takeView'", TakeView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ac_camera_iv_cancle, "field 'ivCancle' and method 'onClick'");
        cameraNewActivity.ivCancle = (ImageView) Utils.castView(viewFindRequiredView4, R.id.ac_camera_iv_cancle, "field 'ivCancle'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, cameraNewActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ac_camera_iv_roate, "field 'ivRoate' and method 'onClick'");
        cameraNewActivity.ivRoate = (ImageView) Utils.castView(viewFindRequiredView5, R.id.ac_camera_iv_roate, "field 'ivRoate'", ImageView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, cameraNewActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ac_camera_tv_send, "field 'tvSend' and method 'onClick'");
        cameraNewActivity.tvSend = (TextView) Utils.castView(viewFindRequiredView6, R.id.ac_camera_tv_send, "field 'tvSend'", TextView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, cameraNewActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_tip, "field 'tvTips' and method 'onClick'");
        cameraNewActivity.tvTips = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_tip, "field 'tvTips'", TextView.class);
        this.h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, cameraNewActivity));
        cameraNewActivity.tvDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_duration, "field 'tvDuration'", TextView.class);
        cameraNewActivity.mCameraView = (CameraView) Utils.findRequiredViewAsType(view, R.id.ac_camera_cameraview, "field 'mCameraView'", CameraView.class);
        cameraNewActivity.mSurfaceView = (SurfaceView) Utils.findRequiredViewAsType(view, R.id.ac_camera_surfaceview, "field 'mSurfaceView'", SurfaceView.class);
        cameraNewActivity.mFocus = (FocusImageView) Utils.findRequiredViewAsType(view, R.id.ac_camera_focusImageView, "field 'mFocus'", FocusImageView.class);
        cameraNewActivity.ll_pb_loading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ac_camera_ll_pb, "field 'll_pb_loading'", LinearLayout.class);
        cameraNewActivity.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.ac_camera_pb, "field 'pb_loading'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CameraNewActivity cameraNewActivity = this.a;
        if (cameraNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        cameraNewActivity.llScreanRootLayout = null;
        cameraNewActivity.ivBurn = null;
        cameraNewActivity.ivFlash = null;
        cameraNewActivity.ivPreview = null;
        cameraNewActivity.tvTakeType = null;
        cameraNewActivity.tvCancel = null;
        cameraNewActivity.takeView = null;
        cameraNewActivity.ivCancle = null;
        cameraNewActivity.ivRoate = null;
        cameraNewActivity.tvSend = null;
        cameraNewActivity.tvTips = null;
        cameraNewActivity.tvDuration = null;
        cameraNewActivity.mCameraView = null;
        cameraNewActivity.mSurfaceView = null;
        cameraNewActivity.mFocus = null;
        cameraNewActivity.ll_pb_loading = null;
        cameraNewActivity.pb_loading = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
    }
}
