package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    public final BiPredicate<? super K, ? super K> comparer;
    public final Function<? super T, K> keySelector;

    public static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        public final BiPredicate<? super K, ? super K> comparer;
        public boolean hasValue;
        public final Function<? super T, K> keySelector;
        public K last;

        public DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.upstream.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.qs.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.keySelector.apply(tPoll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = kApply;
                    return tPoll;
                }
                if (!this.comparer.test(this.last, kApply)) {
                    this.last = kApply;
                    return tPoll;
                }
                this.last = kApply;
                if (this.sourceMode != 1) {
                    this.upstream.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.downstream.tryOnNext(t);
            }
            try {
                K kApply = this.keySelector.apply(t);
                if (this.hasValue) {
                    boolean zTest = this.comparer.test(this.last, kApply);
                    this.last = kApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.hasValue = true;
                    this.last = kApply;
                }
                this.downstream.onNext(t);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        public final BiPredicate<? super K, ? super K> comparer;
        public boolean hasValue;
        public final Function<? super T, K> keySelector;
        public K last;

        public DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.upstream.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.qs.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.keySelector.apply(tPoll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = kApply;
                    return tPoll;
                }
                if (!this.comparer.test(this.last, kApply)) {
                    this.last = kApply;
                    return tPoll;
                }
                this.last = kApply;
                if (this.sourceMode != 1) {
                    this.upstream.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(t);
                return true;
            }
            try {
                K kApply = this.keySelector.apply(t);
                if (this.hasValue) {
                    boolean zTest = this.comparer.test(this.last, kApply);
                    this.last = kApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.hasValue = true;
                    this.last = kApply;
                }
                this.downstream.onNext(t);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.keySelector, this.comparer));
        } else {
            this.source.subscribe((FlowableSubscriber) new DistinctUntilChangedSubscriber(subscriber, this.keySelector, this.comparer));
        }
    }
}
