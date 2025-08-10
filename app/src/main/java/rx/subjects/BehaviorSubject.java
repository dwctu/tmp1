package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

/* loaded from: classes5.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private final SubjectSubscriptionManager<T> state;

    public BehaviorSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
    }

    public static <T> BehaviorSubject<T> create() {
        return create((Object) null, false);
    }

    public Throwable getThrowable() {
        Object latest = this.state.getLatest();
        if (NotificationLite.isError(latest)) {
            return NotificationLite.getError(latest);
        }
        return null;
    }

    public T getValue() {
        Object latest = this.state.getLatest();
        if (NotificationLite.isNext(latest)) {
            return (T) NotificationLite.getValue(latest);
        }
        return null;
    }

    public T[] getValues(T[] tArr) {
        Object latest = this.state.getLatest();
        if (NotificationLite.isNext(latest)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = NotificationLite.getValue(latest);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public boolean hasCompleted() {
        return NotificationLite.isCompleted(this.state.getLatest());
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.state.getLatest());
    }

    public boolean hasValue() {
        return NotificationLite.isNext(this.state.getLatest());
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.getLatest() == null || this.state.active) {
            Object objCompleted = NotificationLite.completed();
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(objCompleted)) {
                subjectObserver.emitNext(objCompleted);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        if (this.state.getLatest() == null || this.state.active) {
            Object objError = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(objError)) {
                try {
                    subjectObserver.emitNext(objError);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (this.state.getLatest() == null || this.state.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.next(next)) {
                subjectObserver.emitNext(next);
            }
        }
    }

    public int subscriberCount() {
        return this.state.observers().length;
    }

    public static <T> BehaviorSubject<T> create(T t) {
        return create((Object) t, true);
    }

    private static <T> BehaviorSubject<T> create(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.next(t));
        }
        Action1<SubjectSubscriptionManager.SubjectObserver<T>> action1 = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.BehaviorSubject.1
            @Override // rx.functions.Action1
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) throws Throwable {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onAdded = action1;
        subjectSubscriptionManager.onTerminated = action1;
        return new BehaviorSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }
}
