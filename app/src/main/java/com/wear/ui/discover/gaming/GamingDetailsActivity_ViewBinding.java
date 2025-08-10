package com.wear.ui.discover.gaming;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class GamingDetailsActivity_ViewBinding implements Unbinder {
    public GamingDetailsActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GamingDetailsActivity a;

        public a(GamingDetailsActivity_ViewBinding gamingDetailsActivity_ViewBinding, GamingDetailsActivity gamingDetailsActivity) {
            this.a = gamingDetailsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GamingDetailsActivity a;

        public b(GamingDetailsActivity_ViewBinding gamingDetailsActivity_ViewBinding, GamingDetailsActivity gamingDetailsActivity) {
            this.a = gamingDetailsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public GamingDetailsActivity_ViewBinding(GamingDetailsActivity gamingDetailsActivity, View view) {
        this.a = gamingDetailsActivity;
        gamingDetailsActivity.scrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scroll_view, "field 'scrollView'", ScrollView.class);
        gamingDetailsActivity.ivAdBanner = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ad_banner, "field 'ivAdBanner'", ImageView.class);
        gamingDetailsActivity.guideline = (Guideline) Utils.findRequiredViewAsType(view, R.id.guideline, "field 'guideline'", Guideline.class);
        gamingDetailsActivity.viewLine = Utils.findRequiredView(view, R.id.view_line, "field 'viewLine'");
        gamingDetailsActivity.llGamingDetails = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_gaming_details, "field 'llGamingDetails'", LinearLayout.class);
        gamingDetailsActivity.vpGamingDetails = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.vp_gaming_details, "field 'vpGamingDetails'", ViewPager2.class);
        gamingDetailsActivity.placeholder = Utils.findRequiredView(view, R.id.placeholder, "field 'placeholder'");
        gamingDetailsActivity.clTopBar = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_top_bar, "field 'clTopBar'", ConstraintLayout.class);
        gamingDetailsActivity.ivTopIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_top_icon, "field 'ivTopIcon'", ImageView.class);
        gamingDetailsActivity.viewTopBarDivider = Utils.findRequiredView(view, R.id.view_top_bar_divider, "field 'viewTopBarDivider'");
        gamingDetailsActivity.vpGamingDetailsFullScreen = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.vp_gaming_details_full_screen, "field 'vpGamingDetailsFullScreen'", ViewPager2.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_close, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, gamingDetailsActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_play, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, gamingDetailsActivity));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GamingDetailsActivity gamingDetailsActivity = this.a;
        if (gamingDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        gamingDetailsActivity.scrollView = null;
        gamingDetailsActivity.ivAdBanner = null;
        gamingDetailsActivity.guideline = null;
        gamingDetailsActivity.viewLine = null;
        gamingDetailsActivity.llGamingDetails = null;
        gamingDetailsActivity.vpGamingDetails = null;
        gamingDetailsActivity.placeholder = null;
        gamingDetailsActivity.clTopBar = null;
        gamingDetailsActivity.ivTopIcon = null;
        gamingDetailsActivity.viewTopBarDivider = null;
        gamingDetailsActivity.vpGamingDetailsFullScreen = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
