package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {
    public final Observable<TLeft> left;
    public final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
    public final Func2<TLeft, TRight, R> resultSelector;
    public final Observable<TRight> right;
    public final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;

    public final class ResultSink extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Subscriber<? super R> subscriber;
        public final CompositeSubscription group = new CompositeSubscription();
        public final Map<Integer, TRight> rightMap = new HashMap();

        public final class LeftSubscriber extends Subscriber<TLeft> {

            public final class LeftDurationSubscriber extends Subscriber<TLeftDuration> {
                public final int id;
                public boolean once = true;

                public LeftDurationSubscriber(int i) {
                    this.id = i;
                }

                @Override // rx.Observer
                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        LeftSubscriber.this.expire(this.id, this);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    LeftSubscriber.this.onError(th);
                }

                @Override // rx.Observer
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public LeftSubscriber() {
            }

            public void expire(int i, Subscription subscription) {
                boolean z;
                synchronized (ResultSink.this) {
                    z = ResultSink.this.leftMap().remove(Integer.valueOf(i)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone;
                }
                if (!z) {
                    ResultSink.this.group.remove(subscription);
                } else {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    z = true;
                    resultSink.leftDone = true;
                    if (!resultSink.rightDone && !resultSink.leftMap().isEmpty()) {
                        z = false;
                    }
                }
                if (!z) {
                    ResultSink.this.group.remove(this);
                } else {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(TLeft tleft) {
                int i;
                ResultSink resultSink;
                int i2;
                synchronized (ResultSink.this) {
                    ResultSink resultSink2 = ResultSink.this;
                    i = resultSink2.leftId;
                    resultSink2.leftId = i + 1;
                    resultSink2.leftMap().put(Integer.valueOf(i), tleft);
                    resultSink = ResultSink.this;
                    i2 = resultSink.rightId;
                }
                try {
                    Observable<TLeftDuration> observableCall = OnSubscribeJoin.this.leftDurationSelector.call(tleft);
                    LeftDurationSubscriber leftDurationSubscriber = new LeftDurationSubscriber(i);
                    ResultSink.this.group.add(leftDurationSubscriber);
                    observableCall.unsafeSubscribe(leftDurationSubscriber);
                    ArrayList arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(tleft, it.next()));
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        }

        public final class RightSubscriber extends Subscriber<TRight> {

            public final class RightDurationSubscriber extends Subscriber<TRightDuration> {
                public final int id;
                public boolean once = true;

                public RightDurationSubscriber(int i) {
                    this.id = i;
                }

                @Override // rx.Observer
                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        RightSubscriber.this.expire(this.id, this);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    RightSubscriber.this.onError(th);
                }

                @Override // rx.Observer
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public RightSubscriber() {
            }

            public void expire(int i, Subscription subscription) {
                boolean z;
                synchronized (ResultSink.this) {
                    z = ResultSink.this.rightMap.remove(Integer.valueOf(i)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone;
                }
                if (!z) {
                    ResultSink.this.group.remove(subscription);
                } else {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    z = true;
                    resultSink.rightDone = true;
                    if (!resultSink.leftDone && !resultSink.rightMap.isEmpty()) {
                        z = false;
                    }
                }
                if (!z) {
                    ResultSink.this.group.remove(this);
                } else {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(TRight tright) {
                int i;
                int i2;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i = resultSink.rightId;
                    resultSink.rightId = i + 1;
                    resultSink.rightMap.put(Integer.valueOf(i), tright);
                    i2 = ResultSink.this.leftId;
                }
                ResultSink.this.group.add(new SerialSubscription());
                try {
                    Observable<TRightDuration> observableCall = OnSubscribeJoin.this.rightDurationSelector.call(tright);
                    RightDurationSubscriber rightDurationSubscriber = new RightDurationSubscriber(i);
                    ResultSink.this.group.add(rightDurationSubscriber);
                    observableCall.unsafeSubscribe(rightDurationSubscriber);
                    ArrayList arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap().entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(it.next(), tright));
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        }

        public ResultSink(Subscriber<? super R> subscriber) {
            this.subscriber = subscriber;
        }

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            LeftSubscriber leftSubscriber = new LeftSubscriber();
            RightSubscriber rightSubscriber = new RightSubscriber();
            this.group.add(leftSubscriber);
            this.group.add(rightSubscriber);
            OnSubscribeJoin.this.left.unsafeSubscribe(leftSubscriber);
            OnSubscribeJoin.this.right.unsafeSubscribe(rightSubscriber);
        }
    }

    public OnSubscribeJoin(Observable<TLeft> observable, Observable<TRight> observable2, Func1<TLeft, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<TLeft, TRight, R> func2) {
        this.left = observable;
        this.right = observable2;
        this.leftDurationSelector = func1;
        this.rightDurationSelector = func12;
        this.resultSelector = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        new ResultSink(new SerializedSubscriber(subscriber)).run();
    }
}
