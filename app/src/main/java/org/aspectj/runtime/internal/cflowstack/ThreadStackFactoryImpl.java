package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;

/* loaded from: classes5.dex */
public class ThreadStackFactoryImpl implements ThreadStackFactory {

    public static class ThreadCounterImpl extends ThreadLocal implements ThreadCounter {

        public static class Counter {
            public int value = 0;
        }

        private ThreadCounterImpl() {
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public void dec() {
            Counter threadCounter = getThreadCounter();
            threadCounter.value--;
        }

        public Counter getThreadCounter() {
            return (Counter) get();
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public void inc() {
            getThreadCounter().value++;
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new Counter();
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public boolean isNotZero() {
            return getThreadCounter().value != 0;
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public void removeThreadCounter() {
            remove();
        }
    }

    public static class ThreadStackImpl extends ThreadLocal implements ThreadStack {
        private ThreadStackImpl() {
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
        public Stack getThreadStack() {
            return (Stack) get();
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new Stack();
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
        public void removeThreadStack() {
            remove();
        }
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStackFactory
    public ThreadCounter getNewThreadCounter() {
        return new ThreadCounterImpl();
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStackFactory
    public ThreadStack getNewThreadStack() {
        return new ThreadStackImpl();
    }
}
