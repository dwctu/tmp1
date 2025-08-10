package com.zhy.autolayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes4.dex */
public class AutoLayoutActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View autoFrameLayout = str.equals("FrameLayout") ? new AutoFrameLayout(context, attributeSet) : null;
        if (str.equals("LinearLayout")) {
            autoFrameLayout = new AutoLinearLayout(context, attributeSet);
        }
        if (str.equals("RelativeLayout")) {
            autoFrameLayout = new AutoRelativeLayout(context, attributeSet);
        }
        return autoFrameLayout != null ? autoFrameLayout : super.onCreateView(str, context, attributeSet);
    }
}
