package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.C0356ib;
import java.util.Iterator;

/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class q extends IRemoteViewDelegate.Stub implements A, SensorEventListener {
    private static final String a = "q";
    public static boolean b = false;
    public int d;
    public Context e;
    public ProviderRemoteView f;
    public TextureView g;
    public C0318e h;
    public IOnResultCallback i;
    public SensorManager j;
    public View.OnClickListener k;
    public Boolean n;
    public AlertDialog o;
    public Rect p;
    private IObjectWrapper q;
    public boolean r;
    private OrientationEventListener s;
    private boolean t;
    public boolean u;
    public IOnLightCallback w;
    public LinearLayout x;
    private volatile C0356ib c = null;
    public boolean l = false;
    public final Float m = Float.valueOf(40.0f);
    public boolean v = true;
    public boolean y = false;

    public q(Context context, int i, Object obj, IObjectWrapper iObjectWrapper, boolean z, boolean z2, boolean z3) {
        this.d = 0;
        this.r = false;
        this.e = context;
        this.d = i;
        this.q = iObjectWrapper;
        if (obj instanceof Rect) {
            this.p = (Rect) obj;
        } else {
            this.p = null;
        }
        this.r = z;
        this.t = z2;
        this.u = z3;
    }

    public boolean b() {
        try {
            return this.h.a().h().equals("torch");
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "getFlashStatusRuntimeException");
            return false;
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "getFlashStatusException");
            return false;
        }
    }

    public void c() {
        Object systemService = this.e.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.j = sensorManager;
            Iterator<Sensor> it = sensorManager.getSensorList(-1).iterator();
            while (it.hasNext()) {
                if (5 == it.next().getType()) {
                    this.l = true;
                    return;
                }
            }
        }
    }

    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.e : DynamicModuleInitializer.getContext(), true);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle = (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        if (this.c == null) {
            try {
                this.c = new C0356ib(bundle, DetailRect.PHOTO_MODE);
            } catch (RuntimeException unused) {
                com.huawei.hms.scankit.util.a.b(a, "RuntimeException");
            } catch (Exception unused2) {
                com.huawei.hms.scankit.util.a.b(a, "Exception");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    public void e() {
        try {
            if (this.e.getSystemService("window") != null) {
                a(a(this.e));
            }
        } catch (NullPointerException unused) {
            com.huawei.hms.scankit.util.a.d(a, "initSurfaceView: nullpoint");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.d(a, "initSurfaceView: Exception");
        }
    }

    public void f() {
        ProviderRemoteView providerRemoteViewD = d();
        this.f = providerRemoteViewD;
        TextureView textureView = (TextureView) providerRemoteViewD.findViewById(R.id.surfaceView);
        this.g = textureView;
        C0318e c0318e = new C0318e(this.e, textureView, null, this.p, this.d, this.q, this.r, "CustomizedView", true);
        this.h = c0318e;
        c0318e.b(this.u);
        c();
        e();
    }

    public void g() {
        try {
            C0318e c0318e = this.h;
            if (c0318e == null || c0318e.a() == null) {
                return;
            }
            this.h.a().a("off");
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "offFlashRuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "offFlashException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public boolean getLightStatus() throws RemoteException {
        return b();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f);
    }

    public void h() {
        try {
            C0318e c0318e = this.h;
            if (c0318e == null || c0318e.a() == null) {
                return;
            }
            this.h.a().a("torch");
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "openFlashRuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "openFlashException");
        }
    }

    public void i() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.e).create();
        this.o = alertDialogCreate;
        alertDialogCreate.show();
        View viewInflate = LayoutInflater.from(DynamicModuleInitializer.getContext() == null ? this.e : DynamicModuleInitializer.getContext()).inflate(R.layout.scankit_dialog_layout, (ViewGroup) null);
        Window window = this.o.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = 60;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(viewInflate);
        window.setGravity(80);
        viewInflate.findViewById(R.id.dialog_sure_btn).setOnClickListener(new p(this));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        Context context = this.e;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.e).getWindow().setFlags(16777216, 16777216);
        }
        Context context2 = this.e;
        if (context2 != null && context2.getPackageManager() != null) {
            this.v = this.e.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        }
        f();
        this.h.a(this);
        this.f.setOnTouchListener(new n(this));
        IOnResultCallback iOnResultCallback = this.i;
        if (iOnResultCallback != null) {
            this.h.a(iOnResultCallback);
        }
        this.h.a(this.t);
        this.h.b();
        if (Build.VERSION.SDK_INT >= 24) {
            Context context3 = this.e;
            if ((context3 instanceof Activity) && ((Activity) context3).isInMultiWindowMode()) {
                o oVar = new o(this, this.e);
                this.s = oVar;
                if (oVar.canDetectOrientation()) {
                    this.s.enable();
                } else {
                    this.s.disable();
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onDestroy() {
        try {
            this.h.c();
            OrientationEventListener orientationEventListener = this.s;
            if (orientationEventListener == null || !orientationEventListener.canDetectOrientation()) {
                return;
            }
            this.s.disable();
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "onDestroyRuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "onDestroyException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onPause() {
        try {
            this.h.d();
            this.j.unregisterListener(this);
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "onPauseRuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "onPauseException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        try {
            this.h.e();
            SensorManager sensorManager = this.j;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
        } catch (RuntimeException e) {
            com.huawei.hms.scankit.util.a.b(a, "onResumeRuntimeException");
            e.printStackTrace();
        } catch (Exception e2) {
            com.huawei.hms.scankit.util.a.b(a, "onResumeException");
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.l && sensorEvent.sensor.getType() == 5 && this.v) {
            Boolean boolValueOf = Boolean.valueOf(sensorEvent.values[0] > this.m.floatValue());
            this.n = boolValueOf;
            if (!boolValueOf.booleanValue()) {
                LinearLayout linearLayout = this.x;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                IOnLightCallback iOnLightCallback = this.w;
                if (iOnLightCallback != null) {
                    try {
                        iOnLightCallback.onVisibleChanged(true);
                        return;
                    } catch (RemoteException unused) {
                        com.huawei.hms.scankit.util.a.d(a, "onSensorChanged RemoteException");
                        return;
                    }
                }
                return;
            }
            if (sensorEvent.values[0] > 600.0f) {
                if (this.x != null && !b()) {
                    this.x.setVisibility(8);
                }
                IOnLightCallback iOnLightCallback2 = this.w;
                if (iOnLightCallback2 != null) {
                    try {
                        iOnLightCallback2.onVisibleChanged(false);
                    } catch (RemoteException unused2) {
                        com.huawei.hms.scankit.util.a.d(a, "onSensorChanged RemoteException");
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        try {
            this.h.f();
        } catch (RuntimeException e) {
            com.huawei.hms.scankit.util.a.b(a, "onStartRuntimeException");
            e.printStackTrace();
        } catch (Exception e2) {
            com.huawei.hms.scankit.util.a.b(a, "onStartException");
            e2.printStackTrace();
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        try {
            this.h.g();
        } catch (RuntimeException e) {
            com.huawei.hms.scankit.util.a.b(a, "onStopRuntimeException");
            e.printStackTrace();
        } catch (Exception e2) {
            com.huawei.hms.scankit.util.a.b(a, "onStopException");
            e2.printStackTrace();
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void pauseContinuouslyScan() throws RemoteException {
        C0318e c0318e = this.h;
        if (c0318e != null) {
            c0318e.h();
        }
        this.y = true;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void resumeContinuouslyScan() throws RemoteException {
        this.y = false;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.k = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        C0318e c0318e = this.h;
        if (c0318e != null) {
            c0318e.a(iOnErrorCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        this.w = iOnLightCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnResultCallback(IOnResultCallback iOnResultCallback) {
        this.i = iOnResultCallback;
        C0318e c0318e = this.h;
        if (c0318e != null) {
            c0318e.a(iOnResultCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
        g();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        C0318e c0318e = this.h;
        if (c0318e == null || c0318e.a() == null || i == this.h.a().d()) {
            return;
        }
        this.h.a().a(i);
        if (!com.huawei.hms.scankit.util.b.d(this.e) || com.huawei.hms.scankit.util.b.b((Activity) this.e)) {
            e();
            return;
        }
        if (com.huawei.hms.scankit.util.b.c((Activity) this.e)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (int) ((a(this.e).x / 1080.0f) * 1920.0f);
            layoutParams.gravity = 17;
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams2.gravity = 17;
        layoutParams2.height = -1;
        layoutParams2.width = (int) ((a(this.e).x / 1080.0f) * 1920.0f);
        layoutParams2.gravity = 17;
    }

    private static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (com.huawei.hms.scankit.util.b.d(context)) {
            defaultDisplay.getSize(point);
        } else {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    public void a(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        float f = point.x;
        float f2 = point.y;
        if (!com.huawei.hms.scankit.util.b.c((Activity) this.e)) {
            b = true;
            float f3 = f / 1920.0f;
            float f4 = f2 / 1080.0f;
            if (f3 > f4) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f3 * 1080.0f);
                layoutParams.gravity = 17;
                return;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f4 * 1920.0f);
                layoutParams.gravity = 17;
                return;
            }
        }
        b = false;
        int i = 1080;
        int i2 = 1920;
        if ("ceres-c3".equals(Build.DEVICE)) {
            i = 1280;
            i2 = 1280;
        }
        float f5 = i;
        float f6 = f / f5;
        float f7 = i2;
        float f8 = f2 / f7;
        if (f6 > f8) {
            layoutParams.width = -1;
            layoutParams.height = (int) (f7 * f6);
            layoutParams.gravity = 17;
        } else {
            layoutParams.height = -1;
            layoutParams.width = (int) (f5 * f8);
            layoutParams.gravity = 17;
        }
    }

    @Override // com.huawei.hms.scankit.A
    public boolean a(HmsScan[] hmsScanArr) {
        AlertDialog alertDialog;
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (alertDialog = this.o) == null || !alertDialog.isShowing()) {
            return false;
        }
        this.o.dismiss();
        return false;
    }

    @Override // com.huawei.hms.scankit.A
    public boolean a() {
        return this.y;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        int iB;
        if (iObjectWrapper == null) {
            com.huawei.hms.scankit.util.a.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            iB = 0;
        } else {
            iB = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i;
            z = i >= 2;
            if (z) {
                iB = com.huawei.hms.scankit.util.b.b(iB);
            }
        }
        HmsScan[] hmsScanArrB = D.a().b((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), iB, true, this.c);
        if (!z) {
            hmsScanArrB = com.huawei.hms.scankit.util.b.a(hmsScanArrB);
        }
        if (hmsScanArrB.length == 0) {
            i();
        } else if (hmsScanArrB[0] != null && TextUtils.isEmpty(hmsScanArrB[0].originalValue)) {
            i();
        }
        return hmsScanArrB;
    }
}
