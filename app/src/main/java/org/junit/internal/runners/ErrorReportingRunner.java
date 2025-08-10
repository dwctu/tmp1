package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

/* loaded from: classes5.dex */
public class ErrorReportingRunner extends Runner {
    private final List<Throwable> causes;
    private final Class<?> testClass;

    public ErrorReportingRunner(Class<?> cls, Throwable th) {
        Objects.requireNonNull(cls, "Test class cannot be null");
        this.testClass = cls;
        this.causes = getCauses(th);
    }

    private Description describeCause(Throwable th) {
        return Description.createTestDescription(this.testClass, "initializationError");
    }

    private List<Throwable> getCauses(Throwable th) {
        return th instanceof InvocationTargetException ? getCauses(th.getCause()) : th instanceof org.junit.runners.model.InitializationError ? ((org.junit.runners.model.InitializationError) th).getCauses() : th instanceof InitializationError ? ((InitializationError) th).getCauses() : Arrays.asList(th);
    }

    private void runCause(Throwable th, RunNotifier runNotifier) throws StoppedByUserException {
        Description descriptionDescribeCause = describeCause(th);
        runNotifier.fireTestStarted(descriptionDescribeCause);
        runNotifier.fireTestFailure(new Failure(descriptionDescribeCause, th));
        runNotifier.fireTestFinished(descriptionDescribeCause);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description descriptionCreateSuiteDescription = Description.createSuiteDescription(this.testClass);
        Iterator<Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            descriptionCreateSuiteDescription.addChild(describeCause(it.next()));
        }
        return descriptionCreateSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) throws StoppedByUserException {
        Iterator<Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            runCause(it.next(), runNotifier);
        }
    }
}
