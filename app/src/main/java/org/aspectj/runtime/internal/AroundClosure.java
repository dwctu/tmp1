package org.aspectj.runtime.internal;

import org.aspectj.lang.ProceedingJoinPoint;

/* loaded from: classes5.dex */
public abstract class AroundClosure {
    public int bitflags = 1048576;
    public Object[] preInitializationState;
    public Object[] state;

    public AroundClosure() {
    }

    public int getFlags() {
        return this.bitflags;
    }

    public Object[] getPreInitializationState() {
        return this.preInitializationState;
    }

    public Object[] getState() {
        return this.state;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint() {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) this.state[r0.length - 1];
        proceedingJoinPoint.set$AroundClosure(this);
        return proceedingJoinPoint;
    }

    public abstract Object run(Object[] objArr) throws Throwable;

    public AroundClosure(Object[] objArr) {
        this.state = objArr;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint(int i) {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) this.state[r0.length - 1];
        proceedingJoinPoint.set$AroundClosure(this);
        this.bitflags = i;
        return proceedingJoinPoint;
    }
}
