package com.wear.main.longDistance;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.RainView;

/* loaded from: classes3.dex */
public class TestActivity_ViewBinding implements Unbinder {
    public TestActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TestActivity a;

        public a(TestActivity_ViewBinding testActivity_ViewBinding, TestActivity testActivity) {
            this.a = testActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ TestActivity a;

        public b(TestActivity_ViewBinding testActivity_ViewBinding, TestActivity testActivity) {
            this.a = testActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public TestActivity_ViewBinding(TestActivity testActivity, View view) {
        this.a = testActivity;
        testActivity.testView = (RainView) Utils.findRequiredViewAsType(view, R.id.test_view, "field 'testView'", RainView.class);
        testActivity.v0 = (TextView) Utils.findRequiredViewAsType(view, R.id.v_0, "field 'v0'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_dog, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, testActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_cake, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, testActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TestActivity testActivity = this.a;
        if (testActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        testActivity.testView = null;
        testActivity.v0 = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
