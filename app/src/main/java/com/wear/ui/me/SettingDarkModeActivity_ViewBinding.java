package com.wear.ui.me;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes4.dex */
public class SettingDarkModeActivity_ViewBinding implements Unbinder {
    public SettingDarkModeActivity a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SettingDarkModeActivity a;

        public a(SettingDarkModeActivity_ViewBinding settingDarkModeActivity_ViewBinding, SettingDarkModeActivity settingDarkModeActivity) {
            this.a = settingDarkModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SettingDarkModeActivity a;

        public b(SettingDarkModeActivity_ViewBinding settingDarkModeActivity_ViewBinding, SettingDarkModeActivity settingDarkModeActivity) {
            this.a = settingDarkModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ SettingDarkModeActivity a;

        public c(SettingDarkModeActivity_ViewBinding settingDarkModeActivity_ViewBinding, SettingDarkModeActivity settingDarkModeActivity) {
            this.a = settingDarkModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ SettingDarkModeActivity a;

        public d(SettingDarkModeActivity_ViewBinding settingDarkModeActivity_ViewBinding, SettingDarkModeActivity settingDarkModeActivity) {
            this.a = settingDarkModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SettingDarkModeActivity_ViewBinding(SettingDarkModeActivity settingDarkModeActivity, View view) {
        this.a = settingDarkModeActivity;
        settingDarkModeActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        settingDarkModeActivity.ivSys = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_sys, "field 'ivSys'", ImageView.class);
        settingDarkModeActivity.ivOn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_on, "field 'ivOn'", ImageView.class);
        settingDarkModeActivity.ivOff = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_off, "field 'ivOff'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_sys, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, settingDarkModeActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_open, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, settingDarkModeActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_off, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, settingDarkModeActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_sys, "method 'onClick'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, settingDarkModeActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingDarkModeActivity settingDarkModeActivity = this.a;
        if (settingDarkModeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        settingDarkModeActivity.actionbar = null;
        settingDarkModeActivity.ivSys = null;
        settingDarkModeActivity.ivOn = null;
        settingDarkModeActivity.ivOff = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
    }
}
