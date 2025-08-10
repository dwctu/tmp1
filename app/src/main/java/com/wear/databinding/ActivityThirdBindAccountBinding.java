package com.wear.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.roundwidget.SkinRoundTextView;
import skin.support.widget.SkinAutoFrameLayout;
import skin.support.widget.SkinAutoLinearLayout;

/* loaded from: classes3.dex */
public abstract class ActivityThirdBindAccountBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final SkinRoundTextView b;

    @NonNull
    public final EditText c;

    @NonNull
    public final EditText d;

    public ActivityThirdBindAccountBinding(Object obj, View view, int i, ImageView imageView, MediumBoldTextView mediumBoldTextView, SkinRoundTextView skinRoundTextView, ImageView imageView2, EditText editText, EditText editText2, SkinAutoLinearLayout skinAutoLinearLayout, SkinAutoLinearLayout skinAutoLinearLayout2, SkinAutoLinearLayout skinAutoLinearLayout3, SkinAutoFrameLayout skinAutoFrameLayout, ImageView imageView3) {
        super(obj, view, i);
        this.a = imageView;
        this.b = skinRoundTextView;
        this.c = editText;
        this.d = editText2;
    }
}
