package com.wear.main.longDistance;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class SearchChatHistoryActivity_ViewBinding implements Unbinder {
    public SearchChatHistoryActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatHistoryActivity a;

        public a(SearchChatHistoryActivity_ViewBinding searchChatHistoryActivity_ViewBinding, SearchChatHistoryActivity searchChatHistoryActivity) {
            this.a = searchChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatHistoryActivity a;

        public b(SearchChatHistoryActivity_ViewBinding searchChatHistoryActivity_ViewBinding, SearchChatHistoryActivity searchChatHistoryActivity) {
            this.a = searchChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatHistoryActivity a;

        public c(SearchChatHistoryActivity_ViewBinding searchChatHistoryActivity_ViewBinding, SearchChatHistoryActivity searchChatHistoryActivity) {
            this.a = searchChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatHistoryActivity a;

        public d(SearchChatHistoryActivity_ViewBinding searchChatHistoryActivity_ViewBinding, SearchChatHistoryActivity searchChatHistoryActivity) {
            this.a = searchChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatHistoryActivity a;

        public e(SearchChatHistoryActivity_ViewBinding searchChatHistoryActivity_ViewBinding, SearchChatHistoryActivity searchChatHistoryActivity) {
            this.a = searchChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatHistoryActivity a;

        public f(SearchChatHistoryActivity_ViewBinding searchChatHistoryActivity_ViewBinding, SearchChatHistoryActivity searchChatHistoryActivity) {
            this.a = searchChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SearchChatHistoryActivity_ViewBinding(SearchChatHistoryActivity searchChatHistoryActivity, View view) {
        this.a = searchChatHistoryActivity;
        searchChatHistoryActivity.et_search = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'et_search'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_delete, "field 'iv_delete' and method 'onClick'");
        searchChatHistoryActivity.iv_delete = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_delete, "field 'iv_delete'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, searchChatHistoryActivity));
        searchChatHistoryActivity.ll_search_category = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_search_category, "field 'll_search_category'", LinearLayout.class);
        searchChatHistoryActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        searchChatHistoryActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_cancel, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, searchChatHistoryActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_category_date, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, searchChatHistoryActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_category_audio, "method 'onClick'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, searchChatHistoryActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_category_members, "method 'onClick'");
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, searchChatHistoryActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_category_photo_and_video, "method 'onClick'");
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, searchChatHistoryActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchChatHistoryActivity searchChatHistoryActivity = this.a;
        if (searchChatHistoryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchChatHistoryActivity.et_search = null;
        searchChatHistoryActivity.iv_delete = null;
        searchChatHistoryActivity.ll_search_category = null;
        searchChatHistoryActivity.recyclerView = null;
        searchChatHistoryActivity.tv_no_result = null;
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
