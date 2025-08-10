package dc;

import com.wear.bean.PatternHiddenSuccBean;
import com.wear.bean.PatternSearchBean;
import com.wear.bean.PatternUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.Map;
import rx.Subscription;

/* compiled from: PatternSearchInterceptorImpl.java */
/* loaded from: classes3.dex */
public class zm2 {

    /* compiled from: PatternSearchInterceptorImpl.java */
    public class a implements yn2<PatternUserBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public a(zm2 zm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternUserBean patternUserBean) {
            this.a.a(this.b, patternUserBean);
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

    /* compiled from: PatternSearchInterceptorImpl.java */
    public class b implements yn2<PatternSearchBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public b(zm2 zm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternSearchBean patternSearchBean) {
            this.a.a(this.b, patternSearchBean);
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

    /* compiled from: PatternSearchInterceptorImpl.java */
    public class c implements yn2<PatternSearchBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public c(zm2 zm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternSearchBean patternSearchBean) {
            this.a.a(this.b, patternSearchBean);
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

    /* compiled from: PatternSearchInterceptorImpl.java */
    public class d implements yn2<PatternHiddenSuccBean> {
        public final /* synthetic */ wn2 a;
        public final /* synthetic */ boolean b;

        public d(zm2 zm2Var, wn2 wn2Var, boolean z) {
            this.a = wn2Var;
            this.b = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternHiddenSuccBean patternHiddenSuccBean) {
            this.a.a(this.b, patternHiddenSuccBean);
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
        return tn2.x(WearUtils.x).j("/hide-pattern/save", map, new d(this, wn2Var, z));
    }

    public Subscription b(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).j("/wear/pattern/search_author", map, new a(this, wn2Var, z));
    }

    public Subscription c(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).j("/wear/pattern/author_pattern", map, new c(this, wn2Var, z));
    }

    public Subscription d(boolean z, Map<String, Object> map, wn2<Object> wn2Var) {
        return tn2.x(WearUtils.x).j("/wear/pattern/search_title", map, new b(this, wn2Var, z));
    }
}
