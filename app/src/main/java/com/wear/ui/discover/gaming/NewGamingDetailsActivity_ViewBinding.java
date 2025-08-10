package com.wear.ui.discover.gaming;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class NewGamingDetailsActivity_ViewBinding implements Unbinder {
    public NewGamingDetailsActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ NewGamingDetailsActivity a;

        public a(NewGamingDetailsActivity_ViewBinding newGamingDetailsActivity_ViewBinding, NewGamingDetailsActivity newGamingDetailsActivity) {
            this.a = newGamingDetailsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ NewGamingDetailsActivity a;

        public b(NewGamingDetailsActivity_ViewBinding newGamingDetailsActivity_ViewBinding, NewGamingDetailsActivity newGamingDetailsActivity) {
            this.a = newGamingDetailsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public NewGamingDetailsActivity_ViewBinding(NewGamingDetailsActivity newGamingDetailsActivity, View view) {
        this.a = newGamingDetailsActivity;
        newGamingDetailsActivity.scrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scroll_view, "field 'scrollView'", ScrollView.class);
        newGamingDetailsActivity.ivAdBanner = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ad_banner, "field 'ivAdBanner'", ImageView.class);
        newGamingDetailsActivity.guideline = (Guideline) Utils.findRequiredViewAsType(view, R.id.guideline, "field 'guideline'", Guideline.class);
        newGamingDetailsActivity.viewLine = Utils.findRequiredView(view, R.id.view_line, "field 'viewLine'");
        newGamingDetailsActivity.llGamingDetails = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_gaming_details, "field 'llGamingDetails'", LinearLayout.class);
        newGamingDetailsActivity.vpGamingDetails = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.vp_gaming_details, "field 'vpGamingDetails'", RecyclerView.class);
        newGamingDetailsActivity.placeholder = Utils.findRequiredView(view, R.id.placeholder, "field 'placeholder'");
        newGamingDetailsActivity.clTopBar = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_top_bar, "field 'clTopBar'", ConstraintLayout.class);
        newGamingDetailsActivity.ivTopIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_top_icon, "field 'ivTopIcon'", ImageView.class);
        newGamingDetailsActivity.viewTopBarDivider = Utils.findRequiredView(view, R.id.view_top_bar_divider, "field 'viewTopBarDivider'");
        newGamingDetailsActivity.vpGamingDetailsFullScreen = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.vp_gaming_details_full_screen, "field 'vpGamingDetailsFullScreen'", ViewPager2.class);
        newGamingDetailsActivity.gameName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gaming_name, "field 'gameName'", TextView.class);
        newGamingDetailsActivity.gameDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gaming_details, "field 'gameDetails'", TextView.class);
        newGamingDetailsActivity.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon_gaming, "field 'ivIcon'", ImageView.class);
        newGamingDetailsActivity.gameDescription = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gaming_description, "field 'gameDescription'", TextView.class);
        newGamingDetailsActivity.tvAuthor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_author, "field 'tvAuthor'", TextView.class);
        newGamingDetailsActivity.apiRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'apiRecyclerView'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_close, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, newGamingDetailsActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_play, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, newGamingDetailsActivity));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewGamingDetailsActivity newGamingDetailsActivity = this.a;
        if (newGamingDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newGamingDetailsActivity.scrollView = null;
        newGamingDetailsActivity.ivAdBanner = null;
        newGamingDetailsActivity.guideline = null;
        newGamingDetailsActivity.viewLine = null;
        newGamingDetailsActivity.llGamingDetails = null;
        newGamingDetailsActivity.vpGamingDetails = null;
        newGamingDetailsActivity.placeholder = null;
        newGamingDetailsActivity.clTopBar = null;
        newGamingDetailsActivity.ivTopIcon = null;
        newGamingDetailsActivity.viewTopBarDivider = null;
        newGamingDetailsActivity.vpGamingDetailsFullScreen = null;
        newGamingDetailsActivity.gameName = null;
        newGamingDetailsActivity.gameDetails = null;
        newGamingDetailsActivity.ivIcon = null;
        newGamingDetailsActivity.gameDescription = null;
        newGamingDetailsActivity.tvAuthor = null;
        newGamingDetailsActivity.apiRecyclerView = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
