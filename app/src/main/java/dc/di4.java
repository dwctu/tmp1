package dc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import skin.support.design.widget.SkinMaterialAppBarLayout;
import skin.support.design.widget.SkinMaterialBottomNavigationView;
import skin.support.design.widget.SkinMaterialCollapsingToolbarLayout;
import skin.support.design.widget.SkinMaterialCoordinatorLayout;
import skin.support.design.widget.SkinMaterialFloatingActionButton;
import skin.support.design.widget.SkinMaterialNavigationView;
import skin.support.design.widget.SkinMaterialTabLayout;
import skin.support.design.widget.SkinMaterialTextInputEditText;
import skin.support.design.widget.SkinMaterialTextInputLayout;

/* compiled from: SkinMaterialViewInflater.java */
/* loaded from: classes5.dex */
public class di4 implements ih4 {
    @Override // dc.ih4
    public View b(@NonNull Context context, String str, @NonNull AttributeSet attributeSet) {
        if ("androidx.coordinatorlayout.widget.CoordinatorLayout".equals(str)) {
            return new SkinMaterialCoordinatorLayout(context, attributeSet);
        }
        if (!str.startsWith("com.google.android.material.")) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "com.google.android.material.tabs.TabLayout":
                return new SkinMaterialTabLayout(context, attributeSet);
            case "com.google.android.material.appbar.AppBarLayout":
                return new SkinMaterialAppBarLayout(context, attributeSet);
            case "com.google.android.material.appbar.CollapsingToolbarLayout":
                return new SkinMaterialCollapsingToolbarLayout(context, attributeSet);
            case "com.google.android.material.floatingactionbutton.FloatingActionButton":
                return new SkinMaterialFloatingActionButton(context, attributeSet);
            case "com.google.android.material.navigation.NavigationView":
                return new SkinMaterialNavigationView(context, attributeSet);
            case "com.google.android.material.textfield.TextInputLayout":
                return new SkinMaterialTextInputLayout(context, attributeSet);
            case "com.google.android.material.textfield.TextInputEditText":
                return new SkinMaterialTextInputEditText(context, attributeSet);
            case "com.google.android.material.bottomnavigation.BottomNavigationView":
                return new SkinMaterialBottomNavigationView(context, attributeSet);
            default:
                return null;
        }
    }
}
