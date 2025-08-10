package dc;

import android.view.View;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.UserControlLink;
import com.wear.bean.handlerbean.IPeopleInfo;

/* compiled from: ControlLinkControlListener.java */
/* loaded from: classes3.dex */
public interface cv1 extends jv1 {
    void E3(long j);

    void J2(int i, boolean z);

    void V2();

    void X();

    @Override // dc.jv1
    void addViewToActivity(View view);

    void h2();

    void j2(ControlLinkBean controlLinkBean, UserControlLink userControlLink, boolean z, String str, String str2, boolean z2, int i, boolean z3);

    void j3();

    @Override // dc.jv1
    void l(IPeopleInfo iPeopleInfo);

    void r2();

    @Override // dc.jv1
    void y(IPeopleInfo iPeopleInfo);
}
