package com.wear.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public abstract class ActivityNewToyBinding extends ViewDataBinding {

    @NonNull
    public final MyActionBar a;

    @NonNull
    public final NewtoyBtdisabledLayoutBinding b;

    @NonNull
    public final NewtoyNotoyrlLayoutBinding c;

    @NonNull
    public final NewtoySearchfailedLayoutBinding d;

    @NonNull
    public final NewtoyToycontentLayoutBinding e;

    public ActivityNewToyBinding(Object obj, View view, int i, MyActionBar myActionBar, NewtoyBtdisabledLayoutBinding newtoyBtdisabledLayoutBinding, NewtoyNotoyrlLayoutBinding newtoyNotoyrlLayoutBinding, NewtoySearchfailedLayoutBinding newtoySearchfailedLayoutBinding, NewtoyToycontentLayoutBinding newtoyToycontentLayoutBinding) {
        super(obj, view, i);
        this.a = myActionBar;
        this.b = newtoyBtdisabledLayoutBinding;
        this.c = newtoyNotoyrlLayoutBinding;
        this.d = newtoySearchfailedLayoutBinding;
        this.e = newtoyToycontentLayoutBinding;
    }
}
