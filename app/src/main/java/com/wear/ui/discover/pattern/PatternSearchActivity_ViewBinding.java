package com.wear.ui.discover.pattern;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class PatternSearchActivity_ViewBinding implements Unbinder {
    public PatternSearchActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PatternSearchActivity a;

        public a(PatternSearchActivity_ViewBinding patternSearchActivity_ViewBinding, PatternSearchActivity patternSearchActivity) {
            this.a = patternSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PatternSearchActivity a;

        public b(PatternSearchActivity_ViewBinding patternSearchActivity_ViewBinding, PatternSearchActivity patternSearchActivity) {
            this.a = patternSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public PatternSearchActivity_ViewBinding(PatternSearchActivity patternSearchActivity, View view) {
        this.a = patternSearchActivity;
        patternSearchActivity.et_search = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'et_search'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_delete, "field 'iv_delete' and method 'onClick'");
        patternSearchActivity.iv_delete = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_delete, "field 'iv_delete'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, patternSearchActivity));
        patternSearchActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
        patternSearchActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_cancel, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, patternSearchActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternSearchActivity patternSearchActivity = this.a;
        if (patternSearchActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternSearchActivity.et_search = null;
        patternSearchActivity.iv_delete = null;
        patternSearchActivity.tv_no_result = null;
        patternSearchActivity.recyclerView = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
