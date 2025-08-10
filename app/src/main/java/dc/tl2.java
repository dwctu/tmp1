package dc;

import com.wear.network.protocol.exception.NetException;
import dc.ul2;
import java.lang.ref.WeakReference;
import rx.Subscription;

/* compiled from: BasePresenter.java */
/* loaded from: classes3.dex */
public abstract class tl2<V extends ul2, T> implements vl2, wn2<T> {
    public Subscription a;
    public WeakReference<V> b;

    public void a(boolean z, T t) {
    }

    public void b(String str, boolean z) {
        String str2 = "=======Presenter==onError========" + str;
        if (g()) {
            this.b.get().showErrorMsg(str, z);
        }
    }

    @Override // dc.vl2
    public void c(ul2 ul2Var) {
        this.b = new WeakReference<>(ul2Var);
    }

    public void d(NetException netException, boolean z) {
        String str = "=======Presenter==onError========" + netException.getMessage();
        if (g()) {
            this.b.get().showErrorMsg(netException.getMessage(), z);
        }
    }

    public final void e(Subscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return;
        }
        subscription.unsubscribe();
    }

    public V f() {
        WeakReference<V> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean g() {
        WeakReference<V> weakReference = this.b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // dc.vl2
    public void onCreate() {
    }

    @Override // dc.vl2
    public void onDestroy() {
        WeakReference<V> weakReference = this.b;
        if (weakReference != null) {
            weakReference.clear();
            this.b = null;
        }
        e(this.a);
        this.a = null;
    }
}
