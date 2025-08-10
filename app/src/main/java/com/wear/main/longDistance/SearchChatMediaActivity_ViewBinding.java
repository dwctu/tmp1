package com.wear.main.longDistance;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.iwatcher.ImageWatcher;

/* loaded from: classes3.dex */
public class SearchChatMediaActivity_ViewBinding implements Unbinder {
    public SearchChatMediaActivity a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatMediaActivity a;

        public a(SearchChatMediaActivity_ViewBinding searchChatMediaActivity_ViewBinding, SearchChatMediaActivity searchChatMediaActivity) {
            this.a = searchChatMediaActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatMediaActivity a;

        public b(SearchChatMediaActivity_ViewBinding searchChatMediaActivity_ViewBinding, SearchChatMediaActivity searchChatMediaActivity) {
            this.a = searchChatMediaActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatMediaActivity a;

        public c(SearchChatMediaActivity_ViewBinding searchChatMediaActivity_ViewBinding, SearchChatMediaActivity searchChatMediaActivity) {
            this.a = searchChatMediaActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatMediaActivity a;

        public d(SearchChatMediaActivity_ViewBinding searchChatMediaActivity_ViewBinding, SearchChatMediaActivity searchChatMediaActivity) {
            this.a = searchChatMediaActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SearchChatMediaActivity_ViewBinding(SearchChatMediaActivity searchChatMediaActivity, View view) {
        this.a = searchChatMediaActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_select, "field 'tv_select' and method 'onClick'");
        searchChatMediaActivity.tv_select = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_select, "field 'tv_select'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, searchChatMediaActivity));
        searchChatMediaActivity.tv_label = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_label, "field 'tv_label'", TextView.class);
        searchChatMediaActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        searchChatMediaActivity.ll_bottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bottom, "field 'll_bottom'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_preview, "field 'tv_preview' and method 'onClick'");
        searchChatMediaActivity.tv_preview = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_preview, "field 'tv_preview'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, searchChatMediaActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_send, "field 'tv_send' and method 'onClick'");
        searchChatMediaActivity.tv_send = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_send, "field 'tv_send'", TextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, searchChatMediaActivity));
        searchChatMediaActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
        searchChatMediaActivity.vImageWatcher = (ImageWatcher) Utils.findRequiredViewAsType(view, R.id.v_image_watcher, "field 'vImageWatcher'", ImageWatcher.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onClick'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, searchChatMediaActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchChatMediaActivity searchChatMediaActivity = this.a;
        if (searchChatMediaActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchChatMediaActivity.tv_select = null;
        searchChatMediaActivity.tv_label = null;
        searchChatMediaActivity.recyclerView = null;
        searchChatMediaActivity.ll_bottom = null;
        searchChatMediaActivity.tv_preview = null;
        searchChatMediaActivity.tv_send = null;
        searchChatMediaActivity.tv_no_result = null;
        searchChatMediaActivity.vImageWatcher = null;
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
