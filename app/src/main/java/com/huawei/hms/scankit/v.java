package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.scankit.drawable.ScanDrawable;
import java.util.Locale;

/* compiled from: IRemoteLocalViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class v extends y {
    private ScanDrawable E;
    private ImageView F;
    private ImageView G;

    public v(Context context, int i, IObjectWrapper iObjectWrapper, boolean z, boolean z2) {
        super(context, i, iObjectWrapper, z, z2);
    }

    @Override // com.huawei.hms.scankit.y, com.huawei.hms.scankit.q
    public ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.e : DynamicModuleInitializer.getContext(), false, false);
    }

    @Override // com.huawei.hms.scankit.y, com.huawei.hms.scankit.q
    public void f() {
        super.f();
        this.F = (ImageView) this.f.findViewById(R.id.ivScan);
        this.G = (ImageView) this.f.findViewById(R.id.back_img_in);
        ImageView imageView = this.F;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (com.huawei.hms.scankit.util.c.a(this.e).x > com.huawei.hms.scankit.util.c.a(this.e, 520)) {
                layoutParams.width = com.huawei.hms.scankit.util.c.a(this.e).x / 2;
            } else {
                layoutParams.width = com.huawei.hms.scankit.util.c.a(this.e).x;
            }
            this.F.setLayoutParams(layoutParams);
            ScanDrawable scanDrawable = new ScanDrawable(this.e.getResources());
            this.E = scanDrawable;
            this.F.setImageDrawable(scanDrawable);
        }
        ImageView imageView2 = this.G;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new u(this));
        }
        if (!com.huawei.hms.scankit.util.b.c((Activity) this.e)) {
            TextView textView = (TextView) this.f.findViewById(R.id.title_scan);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams2.addRule(12);
            textView.setLayoutParams(layoutParams2);
        }
        if (com.huawei.hms.scankit.util.b.d(this.e)) {
            TextView textView2 = (TextView) this.f.findViewById(R.id.title_scan);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            if (com.huawei.hms.scankit.util.b.b((Activity) this.e)) {
                layoutParams3.setMargins(0, com.huawei.hms.scankit.util.c.a(this.e, 48), 0, 0);
                layoutParams3.addRule(10);
            } else {
                layoutParams3.setMargins(0, 0, 0, 0);
                layoutParams3.addRule(12);
            }
            textView2.setLayoutParams(layoutParams3);
            textView2.bringToFront();
        }
        if (com.huawei.hms.scankit.util.b.c((Activity) this.e) || !com.huawei.hms.scankit.util.b.a(this.e)) {
            return;
        }
        if ((Locale.getDefault() == null || !("ar".equals(Locale.getDefault().getLanguage()) || "ur".equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()))) && !"fa".equals(Locale.getDefault().getLanguage())) {
            ImageView imageView3 = this.A;
            if (imageView3 == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageView3.getLayoutParams();
            layoutParams4.setMarginEnd(com.huawei.hms.scankit.util.c.a(this.e, 40));
            this.A.setLayoutParams(layoutParams4);
            return;
        }
        ImageView imageView4 = this.G;
        if (imageView4 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView4.getLayoutParams();
        layoutParams5.setMarginStart(com.huawei.hms.scankit.util.c.a(this.e, 40));
        this.G.setLayoutParams(layoutParams5);
    }

    @Override // com.huawei.hms.scankit.y
    public void j() {
        if ((Locale.getDefault() == null || !("ar".equals(Locale.getDefault().getLanguage()) || "ur".equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()))) && !"fa".equals(Locale.getDefault().getLanguage())) {
            return;
        }
        ImageView imageView = (ImageView) this.f.findViewById(R.id.back_img_in);
        this.G = imageView;
        if (imageView != null) {
            imageView.setRotation(180.0f);
        }
        k();
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        super.onStart();
        ScanDrawable scanDrawable = this.E;
        if (scanDrawable == null || scanDrawable.isRunning()) {
            return;
        }
        this.E.start();
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        super.onStop();
        ScanDrawable scanDrawable = this.E;
        if (scanDrawable != null && scanDrawable.isRunning()) {
            this.E.stop();
        }
    }
}
