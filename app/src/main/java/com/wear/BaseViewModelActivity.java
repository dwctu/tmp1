package com.wear;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.StateWrapLayout;
import dc.vl2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseViewModelActivity.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0014\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/wear/BaseViewModelActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", FirebaseAnalytics.Param.CONTENT, "Landroid/view/View;", "stateWraps", "Landroid/util/SparseArray;", "Lcom/wear/StateWrapLayout;", "viewModel", "Lcom/wear/BaseViewModel;", "getViewModel", "()Lcom/wear/BaseViewModel;", "getContentView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "wrapState", "view", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseViewModelActivity extends BaseActivity<vl2> {
    public View a;

    @NotNull
    public final SparseArray<StateWrapLayout> b = new SparseArray<>();

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        View viewS4 = s4(layoutInflater, null, savedInstanceState);
        this.a = viewS4;
        Unit unit = Unit.INSTANCE;
        setContentView(u4(viewS4));
    }

    @NotNull
    public abstract View s4(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    @Nullable
    public abstract BaseViewModel t4();

    public final StateWrapLayout u4(View view) {
        if (view == null && (view = this.a) == null) {
            Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.CONTENT);
            view = null;
        }
        int iHashCode = view.hashCode();
        if (this.b.get(iHashCode) == null) {
            StateWrapLayout stateWrapLayoutB = StateWrapLayout.a.b(StateWrapLayout.a.a, view, null, 2, null);
            this.b.put(iHashCode, stateWrapLayoutB);
            return stateWrapLayoutB;
        }
        StateWrapLayout stateWrapLayout = this.b.get(iHashCode);
        Intrinsics.checkNotNullExpressionValue(stateWrapLayout, "stateWraps[hashCode]");
        return stateWrapLayout;
    }
}
