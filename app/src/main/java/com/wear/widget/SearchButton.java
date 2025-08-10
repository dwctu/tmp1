package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import dc.ue3;
import dc.vi1;

/* loaded from: classes4.dex */
public class SearchButton extends RelativeLayout {
    public boolean a;
    public e b;

    @BindView(R.id.et_search_keywork)
    public EditText etSearchKeywork;

    @BindView(R.id.iv_search)
    public ImageView ivSearch;

    @BindView(R.id.iv_search_clean)
    public ImageView ivSearchClean;

    @BindView(R.id.tv_hint)
    public TextView tvHint;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SearchButton searchButton = SearchButton.this;
            e eVar = searchButton.b;
            if (eVar != null) {
                eVar.p3(searchButton.etSearchKeywork.getText().toString());
            }
            SearchButton.this.ivSearchClean.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchButton.this.etSearchKeywork.setText("");
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchButton searchButton = SearchButton.this;
            searchButton.a = true;
            searchButton.c();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchButton searchButton = SearchButton.this;
            if (searchButton.a) {
                return;
            }
            searchButton.a = true;
            searchButton.c();
        }
    }

    public interface e {
        void p3(String str);
    }

    public SearchButton(Context context, AttributeSet attributeSet) {
        boolean z;
        super(context, attributeSet);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.view_search_button, (ViewGroup) null);
        addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
        ButterKnife.bind(this, this);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.SearchButton);
            viewInflate.setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.group_search_bg));
            z = typedArrayObtainStyledAttributes.getBoolean(1, false);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            z = false;
        }
        this.a = !z;
        if (z) {
            this.tvHint.setVisibility(0);
            this.ivSearch.setVisibility(4);
            this.ivSearchClean.setVisibility(4);
            this.etSearchKeywork.setVisibility(4);
        } else {
            this.tvHint.setVisibility(4);
            this.ivSearch.setVisibility(0);
            this.ivSearchClean.setVisibility(4);
            this.etSearchKeywork.setVisibility(0);
        }
        this.etSearchKeywork.addTextChangedListener(new a());
        this.ivSearchClean.setOnClickListener(new b());
        this.tvHint.setOnClickListener(new c());
        setOnClickListener(new d());
    }

    public void b() {
        ue3.a(this.etSearchKeywork, getContext());
    }

    public final void c() {
        if (!this.a) {
            this.tvHint.setVisibility(0);
            this.ivSearch.setVisibility(4);
            this.ivSearchClean.setVisibility(4);
            this.etSearchKeywork.setVisibility(4);
            return;
        }
        this.tvHint.setVisibility(4);
        this.ivSearch.setVisibility(0);
        this.ivSearchClean.setVisibility(0);
        this.etSearchKeywork.setVisibility(0);
        d();
    }

    public void d() {
        this.etSearchKeywork.setText("");
        ue3.d(this.etSearchKeywork, getContext());
        this.etSearchKeywork.setFocusable(true);
        this.etSearchKeywork.setFocusableInTouchMode(true);
        this.etSearchKeywork.requestFocus();
    }

    public String getKey() {
        return this.etSearchKeywork.getText().toString();
    }

    public void setListener(e eVar) {
        this.b = eVar;
    }
}
