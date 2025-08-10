package org.junit.internal.builders;

import dc.zx3;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes5.dex */
public class JUnit3Builder extends RunnerBuilder {
    public boolean isPre4Test(Class<?> cls) {
        return zx3.class.isAssignableFrom(cls);
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        if (isPre4Test(cls)) {
            return new JUnit38ClassRunner(cls);
        }
        return null;
    }
}
