package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.RefCountSubscription;

/* loaded from: classes5.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements Observable.OnSubscribe<R> {
    public final Observable<T1> left;
    public final Func1<? super T1, ? extends Observable<D1>> leftDuration;
    public final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
    public final Observable<T2> right;
    public final Func1<? super T2, ? extends Observable<D2>> rightDuration;

    public final class ResultManager extends HashMap<Integer, Observer<T2>> implements Subscription {
        private static final long serialVersionUID = -3035156013812425335L;
        public final RefCountSubscription cancel;
        public final CompositeSubscription group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final Subscriber<? super R> subscriber;

        public final class LeftDurationObserver extends Subscriber<D1> {
            public final int id;
            public boolean once = true;

            public LeftDurationObserver(int i) {
                this.id = i;
            }

            @Override // rx.Observer
            public void onCompleted() {
                Observer<T2> observerRemove;
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        observerRemove = ResultManager.this.leftMap().remove(Integer.valueOf(this.id));
                    }
                    if (observerRemove != null) {
                        observerRemove.onCompleted();
                    }
                    ResultManager.this.group.remove(this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // rx.Observer
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        public final class LeftObserver extends Subscriber<T1> {
            public LeftObserver() {
            }

            @Override // rx.Observer
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager resultManager = ResultManager.this;
                    resultManager.leftDone = true;
                    if (resultManager.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // rx.Observer
            public void onNext(T1 t1) {
                int i;
                ArrayList arrayList;
                try {
                    PublishSubject publishSubjectCreate = PublishSubject.create();
                    SerializedObserver serializedObserver = new SerializedObserver(publishSubjectCreate);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        resultManager.leftMap().put(Integer.valueOf(i), serializedObserver);
                    }
                    Observable observableUnsafeCreate = Observable.unsafeCreate(new WindowObservableFunc(publishSubjectCreate, ResultManager.this.cancel));
                    Observable<D1> observableCall = OnSubscribeGroupJoin.this.leftDuration.call(t1);
                    LeftDurationObserver leftDurationObserver = ResultManager.this.new LeftDurationObserver(i);
                    ResultManager.this.group.add(leftDurationObserver);
                    observableCall.unsafeSubscribe(leftDurationObserver);
                    R rCall = OnSubscribeGroupJoin.this.resultSelector.call(t1, observableUnsafeCreate);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(rCall);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        serializedObserver.onNext(it.next());
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        }

        public final class RightDurationObserver extends Subscriber<D2> {
            public final int id;
            public boolean once = true;

            public RightDurationObserver(int i) {
                this.id = i;
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.id));
                    }
                    ResultManager.this.group.remove(this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // rx.Observer
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        public final class RightObserver extends Subscriber<T2> {
            public RightObserver() {
            }

            @Override // rx.Observer
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager resultManager = ResultManager.this;
                    resultManager.rightDone = true;
                    if (resultManager.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // rx.Observer
            public void onNext(T2 t2) {
                int i;
                ArrayList arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        resultManager.rightMap.put(Integer.valueOf(i), t2);
                    }
                    Observable<D2> observableCall = OnSubscribeGroupJoin.this.rightDuration.call(t2);
                    RightDurationObserver rightDurationObserver = ResultManager.this.new RightDurationObserver(i);
                    ResultManager.this.group.add(rightDurationObserver);
                    observableCall.unsafeSubscribe(rightDurationObserver);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Observer) it.next()).onNext(t2);
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        }

        public ResultManager(Subscriber<? super R> subscriber) {
            this.subscriber = subscriber;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.group = compositeSubscription;
            this.cancel = new RefCountSubscription(compositeSubscription);
        }

        public void complete(List<Observer<T2>> list) {
            if (list != null) {
                Iterator<Observer<T2>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        public void errorAll(Throwable th) {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Observer) it.next()).onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void errorMain(Throwable th) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            LeftObserver leftObserver = new LeftObserver();
            RightObserver rightObserver = new RightObserver();
            this.group.add(leftObserver);
            this.group.add(rightObserver);
            OnSubscribeGroupJoin.this.left.unsafeSubscribe(leftObserver);
            OnSubscribeGroupJoin.this.right.unsafeSubscribe(rightObserver);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        public Map<Integer, Observer<T2>> leftMap() {
            return this;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    public static final class WindowObservableFunc<T> implements Observable.OnSubscribe<T> {
        public final RefCountSubscription refCount;
        public final Observable<T> underlying;

        public final class WindowSubscriber extends Subscriber<T> {
            private final Subscription ref;
            public final Subscriber<? super T> subscriber;

            public WindowSubscriber(Subscriber<? super T> subscriber, Subscription subscription) {
                super(subscriber);
                this.subscriber = subscriber;
                this.ref = subscription;
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.subscriber.onCompleted();
                this.ref.unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                this.subscriber.onError(th);
                this.ref.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(T t) {
                this.subscriber.onNext(t);
            }
        }

        public WindowObservableFunc(Observable<T> observable, RefCountSubscription refCountSubscription) {
            this.refCount = refCountSubscription;
            this.underlying = observable;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            Subscription subscription = this.refCount.get();
            WindowSubscriber windowSubscriber = new WindowSubscriber(subscriber, subscription);
            windowSubscriber.add(subscription);
            this.underlying.unsafeSubscribe(windowSubscriber);
        }
    }

    public OnSubscribeGroupJoin(Observable<T1> observable, Observable<T2> observable2, Func1<? super T1, ? extends Observable<D1>> func1, Func1<? super T2, ? extends Observable<D2>> func12, Func2<? super T1, ? super Observable<T2>, ? extends R> func2) {
        this.left = observable;
        this.right = observable2;
        this.leftDuration = func1;
        this.rightDuration = func12;
        this.resultSelector = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        ResultManager resultManager = new ResultManager(new SerializedSubscriber(subscriber));
        subscriber.add(resultManager);
        resultManager.init();
    }
}
