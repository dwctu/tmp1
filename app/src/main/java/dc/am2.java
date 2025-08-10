package dc;

import com.wear.bean.SurveyInfoBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.controlLink.response.ReactivateControlLinkResponse;
import java.lang.ref.WeakReference;

/* compiled from: ControlLinkPresenter.java */
/* loaded from: classes3.dex */
public class am2 extends tl2<xo2, Object> implements wn2<Object> {
    public el2 c;

    public am2(el2 el2Var) {
        this.c = el2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        ReactivateControlLinkResponse reactivateControlLinkResponse;
        WeakReference<V> weakReference;
        BaseResponseBeanNew baseResponseBeanNew;
        WeakReference<V> weakReference2;
        if ((obj instanceof BaseResponseBeanNew) && (baseResponseBeanNew = (BaseResponseBeanNew) obj) != null && baseResponseBeanNew.code == 0 && g() && (weakReference2 = this.b) != 0 && weakReference2.get() != null) {
            ((xo2) this.b.get()).m((SurveyInfoBean) baseResponseBeanNew.data);
        }
        if (!(obj instanceof ReactivateControlLinkResponse) || (reactivateControlLinkResponse = (ReactivateControlLinkResponse) obj) == null || !reactivateControlLinkResponse.getCode().equals(200) || !reactivateControlLinkResponse.getResult().booleanValue() || (weakReference = this.b) == 0 || weakReference.get() == null) {
            return;
        }
        ((xo2) this.b.get()).I0(reactivateControlLinkResponse.getData().getLongTimeControlLinkUrl());
    }

    @Override // dc.tl2, dc.wn2
    public void b(String str, boolean z) {
        super.b(str, z);
        WeakReference<V> weakReference = this.b;
        if (weakReference == 0 || weakReference.get() == null) {
            return;
        }
        ((xo2) this.b.get()).onError(str);
    }

    public void h(String str) {
        this.c.a(str, this);
    }

    public void i(String str) {
        this.c.b(str, this);
    }
}
