package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.ConnectionsSideBar;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.sticky.StickyHeadContainer;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public abstract class ActivityConnectionsBlockBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final TextView b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final ConnectionsSideBar d;

    @NonNull
    public final StickyHeadContainer e;

    @NonNull
    public final ItemConnectionsLetterBinding f;

    public ActivityConnectionsBlockBinding(Object obj, View view, int i, ImageView imageView, TextView textView, MediumBoldTextView mediumBoldTextView, RecyclerView recyclerView, ConnectionsSideBar connectionsSideBar, StickyHeadContainer stickyHeadContainer, ItemConnectionsLetterBinding itemConnectionsLetterBinding, SkinAutoRelativeLayout skinAutoRelativeLayout) {
        super(obj, view, i);
        this.a = imageView;
        this.b = textView;
        this.c = recyclerView;
        this.d = connectionsSideBar;
        this.e = stickyHeadContainer;
        this.f = itemConnectionsLetterBinding;
    }

    @NonNull
    public static ActivityConnectionsBlockBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityConnectionsBlockBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityConnectionsBlockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_connections_block, null, false, obj);
    }
}
