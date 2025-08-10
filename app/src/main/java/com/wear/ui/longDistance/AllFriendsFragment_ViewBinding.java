package com.wear.ui.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.LetterView;

/* loaded from: classes3.dex */
public class AllFriendsFragment_ViewBinding implements Unbinder {
    public AllFriendsFragment a;

    @UiThread
    public AllFriendsFragment_ViewBinding(AllFriendsFragment allFriendsFragment, View view) {
        this.a = allFriendsFragment;
        allFriendsFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
        allFriendsFragment.letterView = (LetterView) Utils.findRequiredViewAsType(view, R.id.letter_view, "field 'letterView'", LetterView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AllFriendsFragment allFriendsFragment = this.a;
        if (allFriendsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        allFriendsFragment.rvList = null;
        allFriendsFragment.letterView = null;
    }
}
