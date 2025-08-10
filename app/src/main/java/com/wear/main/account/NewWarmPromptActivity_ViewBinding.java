package com.wear.main.account;

import android.view.View;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class NewWarmPromptActivity_ViewBinding implements Unbinder {
    public NewWarmPromptActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ NewWarmPromptActivity a;

        public a(NewWarmPromptActivity_ViewBinding newWarmPromptActivity_ViewBinding, NewWarmPromptActivity newWarmPromptActivity) {
            this.a = newWarmPromptActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ NewWarmPromptActivity a;

        public b(NewWarmPromptActivity_ViewBinding newWarmPromptActivity_ViewBinding, NewWarmPromptActivity newWarmPromptActivity) {
            this.a = newWarmPromptActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public NewWarmPromptActivity_ViewBinding(NewWarmPromptActivity newWarmPromptActivity, View view) {
        this.a = newWarmPromptActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_agree, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, newWarmPromptActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_disagree, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, newWarmPromptActivity));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
