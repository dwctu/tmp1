package com.wear.main.longDistance;

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
public class SearchChatAudioActivity_ViewBinding implements Unbinder {
    public SearchChatAudioActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatAudioActivity a;

        public a(SearchChatAudioActivity_ViewBinding searchChatAudioActivity_ViewBinding, SearchChatAudioActivity searchChatAudioActivity) {
            this.a = searchChatAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatAudioActivity a;

        public b(SearchChatAudioActivity_ViewBinding searchChatAudioActivity_ViewBinding, SearchChatAudioActivity searchChatAudioActivity) {
            this.a = searchChatAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SearchChatAudioActivity_ViewBinding(SearchChatAudioActivity searchChatAudioActivity, View view) {
        this.a = searchChatAudioActivity;
        searchChatAudioActivity.et_search = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'et_search'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_delete, "field 'iv_delete' and method 'onClick'");
        searchChatAudioActivity.iv_delete = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_delete, "field 'iv_delete'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, searchChatAudioActivity));
        searchChatAudioActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
        searchChatAudioActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_cancel, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, searchChatAudioActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchChatAudioActivity searchChatAudioActivity = this.a;
        if (searchChatAudioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchChatAudioActivity.et_search = null;
        searchChatAudioActivity.iv_delete = null;
        searchChatAudioActivity.tv_no_result = null;
        searchChatAudioActivity.recyclerView = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
