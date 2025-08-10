package dc;

/* compiled from: RequestCoordinator.java */
/* loaded from: classes.dex */
public interface no {

    /* compiled from: RequestCoordinator.java */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        a(boolean z) {
            this.isComplete = z;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean a();

    boolean b(mo moVar);

    boolean c(mo moVar);

    void d(mo moVar);

    void f(mo moVar);

    no getRoot();

    boolean i(mo moVar);
}
