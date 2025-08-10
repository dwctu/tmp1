package dc;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: DesignUtil.java */
/* loaded from: classes3.dex */
public class re1 {

    /* compiled from: DesignUtil.java */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ he1 a;

        public a(he1 he1Var) {
            this.a = he1Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            this.a.j(i >= 0, appBarLayout.getTotalScrollRange() + i <= 0);
        }
    }

    public static void a(View view, zd1 zd1Var, he1 he1Var) {
        try {
            if (view instanceof CoordinatorLayout) {
                zd1Var.d().a(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(he1Var));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
