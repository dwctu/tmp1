package org.junit.internal.runners;

import dc.by3;
import dc.cy3;
import dc.dy3;
import dc.ux3;
import dc.wx3;
import dc.yx3;
import dc.zx3;
import java.lang.annotation.Annotation;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

/* loaded from: classes5.dex */
public class JUnit38ClassRunner extends Runner implements Filterable, Sortable {
    private volatile yx3 test;

    public static final class OldTestClassAdaptingListener implements by3 {
        private final RunNotifier notifier;

        private Description asDescription(yx3 yx3Var) {
            return yx3Var instanceof Describable ? ((Describable) yx3Var).getDescription() : Description.createTestDescription(getEffectiveClass(yx3Var), getName(yx3Var));
        }

        private Class<? extends yx3> getEffectiveClass(yx3 yx3Var) {
            return yx3Var.getClass();
        }

        private String getName(yx3 yx3Var) {
            return yx3Var instanceof zx3 ? ((zx3) yx3Var).f() : yx3Var.toString();
        }

        @Override // dc.by3
        public void addError(yx3 yx3Var, Throwable th) {
            this.notifier.fireTestFailure(new Failure(asDescription(yx3Var), th));
        }

        @Override // dc.by3
        public void addFailure(yx3 yx3Var, wx3 wx3Var) {
            addError(yx3Var, wx3Var);
        }

        @Override // dc.by3
        public void endTest(yx3 yx3Var) {
            this.notifier.fireTestFinished(asDescription(yx3Var));
        }

        @Override // dc.by3
        public void startTest(yx3 yx3Var) throws StoppedByUserException {
            this.notifier.fireTestStarted(asDescription(yx3Var));
        }

        private OldTestClassAdaptingListener(RunNotifier runNotifier) {
            this.notifier = runNotifier;
        }
    }

    public JUnit38ClassRunner(Class<?> cls) {
        this(new dy3(cls.asSubclass(zx3.class)));
    }

    private static String createSuiteDescription(dy3 dy3Var) {
        int iA = dy3Var.a();
        return String.format("TestSuite with %s tests%s", Integer.valueOf(iA), iA == 0 ? "" : String.format(" [example: %s]", dy3Var.n(0)));
    }

    private static Annotation[] getAnnotations(zx3 zx3Var) {
        try {
            return zx3Var.getClass().getMethod(zx3Var.f(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private yx3 getTest() {
        return this.test;
    }

    private static Description makeDescription(yx3 yx3Var) {
        if (yx3Var instanceof zx3) {
            zx3 zx3Var = (zx3) yx3Var;
            return Description.createTestDescription(zx3Var.getClass(), zx3Var.f(), getAnnotations(zx3Var));
        }
        if (!(yx3Var instanceof dy3)) {
            return yx3Var instanceof Describable ? ((Describable) yx3Var).getDescription() : yx3Var instanceof ux3 ? makeDescription(((ux3) yx3Var).g()) : Description.createSuiteDescription(yx3Var.getClass());
        }
        dy3 dy3Var = (dy3) yx3Var;
        Description descriptionCreateSuiteDescription = Description.createSuiteDescription(dy3Var.h() == null ? createSuiteDescription(dy3Var) : dy3Var.h(), new Annotation[0]);
        int iO = dy3Var.o();
        for (int i = 0; i < iO; i++) {
            descriptionCreateSuiteDescription.addChild(makeDescription(dy3Var.n(i)));
        }
        return descriptionCreateSuiteDescription;
    }

    private void setTest(yx3 yx3Var) {
        this.test = yx3Var;
    }

    public by3 createAdaptingListener(RunNotifier runNotifier) {
        return new OldTestClassAdaptingListener(runNotifier);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        if (getTest() instanceof Filterable) {
            ((Filterable) getTest()).filter(filter);
            return;
        }
        if (getTest() instanceof dy3) {
            dy3 dy3Var = (dy3) getTest();
            dy3 dy3Var2 = new dy3(dy3Var.h());
            int iO = dy3Var.o();
            for (int i = 0; i < iO; i++) {
                yx3 yx3VarN = dy3Var.n(i);
                if (filter.shouldRun(makeDescription(yx3VarN))) {
                    dy3Var2.c(yx3VarN);
                }
            }
            setTest(dy3Var2);
            if (dy3Var2.o() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return makeDescription(getTest());
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        cy3 cy3Var = new cy3();
        cy3Var.c(createAdaptingListener(runNotifier));
        getTest().b(cy3Var);
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (getTest() instanceof Sortable) {
            ((Sortable) getTest()).sort(sorter);
        }
    }

    public JUnit38ClassRunner(yx3 yx3Var) {
        setTest(yx3Var);
    }
}
