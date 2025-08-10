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
import com.wear.widget.LetterView;

/* loaded from: classes3.dex */
public class SearchChatUserActivity_ViewBinding implements Unbinder {
    public SearchChatUserActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatUserActivity a;

        public a(SearchChatUserActivity_ViewBinding searchChatUserActivity_ViewBinding, SearchChatUserActivity searchChatUserActivity) {
            this.a = searchChatUserActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SearchChatUserActivity a;

        public b(SearchChatUserActivity_ViewBinding searchChatUserActivity_ViewBinding, SearchChatUserActivity searchChatUserActivity) {
            this.a = searchChatUserActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SearchChatUserActivity_ViewBinding(SearchChatUserActivity searchChatUserActivity, View view) {
        this.a = searchChatUserActivity;
        searchChatUserActivity.et_search = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'et_search'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_delete, "field 'iv_delete' and method 'onClick'");
        searchChatUserActivity.iv_delete = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_delete, "field 'iv_delete'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, searchChatUserActivity));
        searchChatUserActivity.rv_contact = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_contact, "field 'rv_contact'", RecyclerView.class);
        searchChatUserActivity.rv_search = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_search, "field 'rv_search'", RecyclerView.class);
        searchChatUserActivity.letter_view = (LetterView) Utils.findRequiredViewAsType(view, R.id.letter_view, "field 'letter_view'", LetterView.class);
        searchChatUserActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_cancel, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, searchChatUserActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchChatUserActivity searchChatUserActivity = this.a;
        if (searchChatUserActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchChatUserActivity.et_search = null;
        searchChatUserActivity.iv_delete = null;
        searchChatUserActivity.rv_contact = null;
        searchChatUserActivity.rv_search = null;
        searchChatUserActivity.letter_view = null;
        searchChatUserActivity.tv_no_result = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
