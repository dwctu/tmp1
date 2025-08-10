package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import java.util.Locale;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class y extends q {
    public ImageView A;
    private ImageView B;
    private TextView C;
    private IObjectWrapper D;
    public ViewfinderView z;

    public y(Context context, int i, IObjectWrapper iObjectWrapper, boolean z, boolean z2) {
        super(context, i, null, iObjectWrapper, z, false, z2);
        this.D = iObjectWrapper;
        this.e = context;
        this.d = i;
        this.r = z;
        this.p = new Rect(-1, -1, -1, -1);
        this.u = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setSelected(false);
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(R.string.scankit_light);
        }
    }

    @Override // com.huawei.hms.scankit.q
    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.e : DynamicModuleInitializer.getContext(), false);
    }

    @Override // com.huawei.hms.scankit.q
    public void f() {
        RelativeLayout relativeLayout;
        ProviderRemoteView providerRemoteViewD = d();
        this.f = providerRemoteViewD;
        if (Build.VERSION.SDK_INT >= 19 && (relativeLayout = (RelativeLayout) providerRemoteViewD.findViewById(R.id.scan_title)) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relativeLayout.getLayoutParams().width, relativeLayout.getLayoutParams().height);
            layoutParams.setMargins(0, l(), 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.g = (TextureView) this.f.findViewById(R.id.surfaceView);
        ViewfinderView viewfinderView = (ViewfinderView) this.f.findViewById(R.id.viewfinderView);
        this.z = viewfinderView;
        C0318e c0318e = new C0318e(this.e, this.g, viewfinderView, this.p, this.d, this.D, this.r, "DefaultView", false);
        this.h = c0318e;
        c0318e.b(this.u);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.img_btn);
        this.A = imageView;
        imageView.setOnClickListener(new w(this));
        this.x = (LinearLayout) this.f.findViewById(R.id.flash_light_ll);
        this.B = (ImageView) this.f.findViewById(R.id.ivFlash);
        c();
        this.B.setOnClickListener(new x(this));
        this.C = (TextView) this.f.findViewById(R.id.flash_light_text);
        e();
        j();
        k();
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f);
    }

    public void j() {
        if ((Locale.getDefault() == null || !("ar".equals(Locale.getDefault().getLanguage()) || "ur".equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()))) && !"fa".equals(Locale.getDefault().getLanguage())) {
            return;
        }
        TextView textView = (TextView) this.f.findViewById(R.id.title_scan);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.back_img_in);
        if (imageView != null) {
            imageView.setRotation(180.0f);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(1, R.id.img_btn);
                layoutParams2.rightMargin = 200;
                textView.setLayoutParams(layoutParams);
            }
        }
        k();
    }

    public void k() {
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        Context context = this.e;
        if (context == null || context.getResources() == null || this.e.getResources().getDisplayMetrics() == null || this.e.getResources().getDisplayMetrics().widthPixels <= 1990 || this.e.getResources().getDisplayMetrics().widthPixels >= 2300 || this.e.getResources().getDisplayMetrics().heightPixels <= 2190 || this.e.getResources().getDisplayMetrics().heightPixels >= 2600 || !(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA;
        this.x.setLayoutParams(layoutParams);
    }

    public int l() {
        int identifier;
        Context context = this.e;
        if (context == null || context.getResources() == null || (identifier = this.e.getResources().getIdentifier("status_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE)) <= 0) {
            return 0;
        }
        return this.e.getResources().getDimensionPixelSize(identifier);
    }

    @Override // com.huawei.hms.scankit.q, android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        this.h.e();
        m();
        SensorManager sensorManager = this.j;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        this.k = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.q
    public void c() {
        super.c();
        if (this.l || !this.v) {
            return;
        }
        this.x.setVisibility(0);
    }
}
