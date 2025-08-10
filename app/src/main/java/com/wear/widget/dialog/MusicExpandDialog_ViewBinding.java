package com.wear.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class MusicExpandDialog_ViewBinding implements Unbinder {
    public MusicExpandDialog a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MusicExpandDialog a;

        public a(MusicExpandDialog_ViewBinding musicExpandDialog_ViewBinding, MusicExpandDialog musicExpandDialog) {
            this.a = musicExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MusicExpandDialog a;

        public b(MusicExpandDialog_ViewBinding musicExpandDialog_ViewBinding, MusicExpandDialog musicExpandDialog) {
            this.a = musicExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MusicExpandDialog a;

        public c(MusicExpandDialog_ViewBinding musicExpandDialog_ViewBinding, MusicExpandDialog musicExpandDialog) {
            this.a = musicExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MusicExpandDialog a;

        public d(MusicExpandDialog_ViewBinding musicExpandDialog_ViewBinding, MusicExpandDialog musicExpandDialog) {
            this.a = musicExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MusicExpandDialog a;

        public e(MusicExpandDialog_ViewBinding musicExpandDialog_ViewBinding, MusicExpandDialog musicExpandDialog) {
            this.a = musicExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MusicExpandDialog a;

        public f(MusicExpandDialog_ViewBinding musicExpandDialog_ViewBinding, MusicExpandDialog musicExpandDialog) {
            this.a = musicExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public MusicExpandDialog_ViewBinding(MusicExpandDialog musicExpandDialog, View view) {
        this.a = musicExpandDialog;
        musicExpandDialog.flRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_bg, "field 'ivBg' and method 'onClick'");
        musicExpandDialog.ivBg = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_bg, "field 'ivBg'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, musicExpandDialog));
        musicExpandDialog.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        musicExpandDialog.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvUserName'", TextView.class);
        musicExpandDialog.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_end, "field 'ivEnd' and method 'onClick'");
        musicExpandDialog.ivEnd = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_end, "field 'ivEnd'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, musicExpandDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_expand_bg, "field 'LLExpandBg' and method 'onClick'");
        musicExpandDialog.LLExpandBg = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_expand_bg, "field 'LLExpandBg'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, musicExpandDialog));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_play_or_pause, "field 'ivPlayOrPause' and method 'onClick'");
        musicExpandDialog.ivPlayOrPause = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_play_or_pause, "field 'ivPlayOrPause'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, musicExpandDialog));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_previous, "field 'ivPrevious' and method 'onClick'");
        musicExpandDialog.ivPrevious = (ImageView) Utils.castView(viewFindRequiredView5, R.id.iv_previous, "field 'ivPrevious'", ImageView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, musicExpandDialog));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_next, "field 'ivNext' and method 'onClick'");
        musicExpandDialog.ivNext = (ImageView) Utils.castView(viewFindRequiredView6, R.id.iv_next, "field 'ivNext'", ImageView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, musicExpandDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicExpandDialog musicExpandDialog = this.a;
        if (musicExpandDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicExpandDialog.flRootView = null;
        musicExpandDialog.ivBg = null;
        musicExpandDialog.ivIcon = null;
        musicExpandDialog.tvUserName = null;
        musicExpandDialog.tvTime = null;
        musicExpandDialog.ivEnd = null;
        musicExpandDialog.LLExpandBg = null;
        musicExpandDialog.ivPlayOrPause = null;
        musicExpandDialog.ivPrevious = null;
        musicExpandDialog.ivNext = null;
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
    }
}
