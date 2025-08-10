package dc;

import com.wear.bean.PatternHiddenShowSuccBean;
import com.wear.bean.PatternHiddenShowSuccDataBean;
import com.wear.bean.PatternsHiddenBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: PatternsHiddenInterceptorImpl.java */
/* loaded from: classes3.dex */
public class bn2 {

    /* compiled from: PatternsHiddenInterceptorImpl.java */
    public class a implements yn2<PatternsHiddenBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(bn2 bn2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternsHiddenBean patternsHiddenBean) {
            this.a.a(this.b, patternsHiddenBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.getMessage(), this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: PatternsHiddenInterceptorImpl.java */
    public class b implements yn2<PatternHiddenShowSuccBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public b(bn2 bn2Var, wn2 wn2Var, boolean z, String str) {
            this.a = wn2Var;
            this.b = z;
            this.c = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternHiddenShowSuccBean patternHiddenShowSuccBean) {
            PatternHiddenShowSuccDataBean patternHiddenShowSuccDataBean = new PatternHiddenShowSuccDataBean();
            patternHiddenShowSuccDataBean.setPatternId(this.c);
            patternHiddenShowSuccBean.setData(patternHiddenShowSuccDataBean);
            this.a.a(this.b, patternHiddenShowSuccBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(netException.getMessage(), this.b);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public Subscription a(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).j("/hide-pattern/list", map, new a(this, wn2Var, z));
    }

    public Subscription b(boolean z, Map<String, Object> map, wn2<Object> wn2Var, String str) {
        return tn2.x(WearUtils.x).j("/hide-pattern/delete", map, new b(this, wn2Var, z, str));
    }
}
