package com.wear.widget;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class SearchButton_ViewBinding implements Unbinder {
    public SearchButton a;

    @UiThread
    public SearchButton_ViewBinding(SearchButton searchButton, View view) {
        this.a = searchButton;
        searchButton.ivSearch = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search, "field 'ivSearch'", ImageView.class);
        searchButton.ivSearchClean = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search_clean, "field 'ivSearchClean'", ImageView.class);
        searchButton.etSearchKeywork = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search_keywork, "field 'etSearchKeywork'", EditText.class);
        searchButton.tvHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_hint, "field 'tvHint'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchButton searchButton = this.a;
        if (searchButton == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchButton.ivSearch = null;
        searchButton.ivSearchClean = null;
        searchButton.etSearchKeywork = null;
        searchButton.tvHint = null;
    }
}
