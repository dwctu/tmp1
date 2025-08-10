package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.internal.producers.SingleDelayedProducer;

/* loaded from: classes5.dex */
public final class OperatorToObservableSortedList<T> implements Observable.Operator<List<T>, T> {
    private static final Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction();
    public final int initialCapacity;
    public final Comparator<? super T> sortFunction;

    public static final class DefaultComparableFunction implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    public OperatorToObservableSortedList(int i) {
        this.sortFunction = DEFAULT_SORT_FUNCTION;
        this.initialCapacity = i;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorToObservableSortedList.2
            public boolean completed;
            public List<T> list;

            {
                this.list = new ArrayList(OperatorToObservableSortedList.this.initialCapacity);
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (this.completed) {
                    return;
                }
                this.completed = true;
                List<T> list = this.list;
                this.list = null;
                try {
                    Collections.sort(list, OperatorToObservableSortedList.this.sortFunction);
                    singleDelayedProducer.setValue(list);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (this.completed) {
                    return;
                }
                this.list.add(t);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(singleDelayedProducer);
        return subscriber2;
    }

    public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> func2, int i) {
        this.initialCapacity = i;
        this.sortFunction = new Comparator<T>() { // from class: rx.internal.operators.OperatorToObservableSortedList.1
            @Override // java.util.Comparator
            public int compare(T t, T t2) {
                return ((Integer) func2.call(t, t2)).intValue();
            }
        };
    }
}
