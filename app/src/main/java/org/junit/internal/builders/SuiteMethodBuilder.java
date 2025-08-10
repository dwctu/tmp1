package org.junit.internal.builders;

import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes5.dex */
public class SuiteMethodBuilder extends RunnerBuilder {
    public boolean hasSuiteMethod(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            cls.getMethod("suite", new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        if (hasSuiteMethod(cls)) {
            return new SuiteMethod(cls);
        }
        return null;
    }
}
