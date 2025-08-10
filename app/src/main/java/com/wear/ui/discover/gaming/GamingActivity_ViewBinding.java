package com.wear.ui.discover.gaming;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.recycler.NoScrollRecyclerView;

/* loaded from: classes3.dex */
public final class GamingActivity_ViewBinding implements Unbinder {
    public GamingActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GamingActivity a;

        public a(GamingActivity_ViewBinding gamingActivity_ViewBinding, GamingActivity gamingActivity) {
            this.a = gamingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GamingActivity a;

        public b(GamingActivity_ViewBinding gamingActivity_ViewBinding, GamingActivity gamingActivity) {
            this.a = gamingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public GamingActivity_ViewBinding(GamingActivity gamingActivity, View view) {
        this.a = gamingActivity;
        gamingActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.cl_ad_banner, "field 'clAdBanner' and method 'onClick'");
        gamingActivity.clAdBanner = (ConstraintLayout) Utils.castView(viewFindRequiredView, R.id.cl_ad_banner, "field 'clAdBanner'", ConstraintLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, gamingActivity));
        gamingActivity.ivAdBanner = (ImageFilterView) Utils.findRequiredViewAsType(view, R.id.iv_ad_banner, "field 'ivAdBanner'", ImageFilterView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_play, "field 'btnPlay' and method 'onClick'");
        gamingActivity.btnPlay = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_play, "field 'btnPlay'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, gamingActivity));
        gamingActivity.llGaming = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_gaming, "field 'llGaming'", LinearLayout.class);
        gamingActivity.rvGaming1 = (NoScrollRecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_gaming1, "field 'rvGaming1'", NoScrollRecyclerView.class);
        gamingActivity.rvGaming2 = (NoScrollRecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_gaming2, "field 'rvGaming2'", NoScrollRecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GamingActivity gamingActivity = this.a;
        if (gamingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        gamingActivity.actionbar = null;
        gamingActivity.clAdBanner = null;
        gamingActivity.ivAdBanner = null;
        gamingActivity.btnPlay = null;
        gamingActivity.llGaming = null;
        gamingActivity.rvGaming1 = null;
        gamingActivity.rvGaming2 = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
