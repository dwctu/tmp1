package dc;

import android.app.Activity;
import com.wear.util.WearUtils;
import java.util.ArrayList;

/* compiled from: ControlLinkChatItemMenuAction.java */
/* loaded from: classes4.dex */
public class z73 {
    public ma2 a;

    public z73(Activity activity, ma2 ma2Var, so3 so3Var, ie3 ie3Var) {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.a = ma2Var;
    }

    public boolean a(String str) {
        return (this.a.r() == null || WearUtils.e1(str) || this.a.r().get(str) == null) ? false : true;
    }
}
