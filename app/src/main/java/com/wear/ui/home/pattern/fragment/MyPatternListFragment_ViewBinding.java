package com.wear.ui.home.pattern.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.yydcdut.sdlv.SlideAndDragListView;

/* loaded from: classes3.dex */
public class MyPatternListFragment_ViewBinding implements Unbinder {
    public MyPatternListFragment a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternListFragment a;

        public a(MyPatternListFragment_ViewBinding myPatternListFragment_ViewBinding, MyPatternListFragment myPatternListFragment) {
            this.a = myPatternListFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternListFragment a;

        public b(MyPatternListFragment_ViewBinding myPatternListFragment_ViewBinding, MyPatternListFragment myPatternListFragment) {
            this.a = myPatternListFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternListFragment a;

        public c(MyPatternListFragment_ViewBinding myPatternListFragment_ViewBinding, MyPatternListFragment myPatternListFragment) {
            this.a = myPatternListFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MyPatternListFragment_ViewBinding(MyPatternListFragment myPatternListFragment, View view) {
        this.a = myPatternListFragment;
        myPatternListFragment.createTvText = (TextView) Utils.findRequiredViewAsType(view, R.id.create_tv_text, "field 'createTvText'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.create_pattern, "field 'createPattern' and method 'onViewClicked'");
        myPatternListFragment.createPattern = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.create_pattern, "field 'createPattern'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, myPatternListFragment));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.create_pattern_playout, "field 'createPatternPlayout' and method 'onViewClicked'");
        myPatternListFragment.createPatternPlayout = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.create_pattern_playout, "field 'createPatternPlayout'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, myPatternListFragment));
        myPatternListFragment.pattern_list = (SlideAndDragListView) Utils.findRequiredViewAsType(view, R.id.pattern_data_list, "field 'pattern_list'", SlideAndDragListView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.create_pattern_image, "field 'createPatternImage' and method 'onViewClicked'");
        myPatternListFragment.createPatternImage = (ImageView) Utils.castView(viewFindRequiredView3, R.id.create_pattern_image, "field 'createPatternImage'", ImageView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, myPatternListFragment));
        myPatternListFragment.listEmptyNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.list_empty_notice, "field 'listEmptyNotice'", TextView.class);
        myPatternListFragment.patternListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'patternListEmpty'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyPatternListFragment myPatternListFragment = this.a;
        if (myPatternListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        myPatternListFragment.createTvText = null;
        myPatternListFragment.createPattern = null;
        myPatternListFragment.createPatternPlayout = null;
        myPatternListFragment.pattern_list = null;
        myPatternListFragment.createPatternImage = null;
        myPatternListFragment.listEmptyNotice = null;
        myPatternListFragment.patternListEmpty = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
