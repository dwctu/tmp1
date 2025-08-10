package dc;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* compiled from: RxTimerUtil.java */
/* loaded from: classes4.dex */
public class dg3 {
    public static Disposable a;

    /* compiled from: RxTimerUtil.java */
    public class a implements Observer<Long> {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@NonNull Long l) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.T1(l.longValue());
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(@NonNull Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(@NonNull Disposable disposable) {
            Disposable unused = dg3.a = disposable;
        }
    }

    /* compiled from: RxTimerUtil.java */
    public interface b {
        void T1(long j);
    }

    public static void b() {
        Disposable disposable = a;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        a.dispose();
        a = null;
    }

    public static void c(long j, b bVar) {
        Observable.interval(j, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(bVar));
    }
}
