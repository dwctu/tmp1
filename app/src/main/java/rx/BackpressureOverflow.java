package rx;

import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_DEFAULT;
    public static final Strategy ON_OVERFLOW_DROP_LATEST;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST;
    public static final Strategy ON_OVERFLOW_ERROR;

    public static final class DropLatest implements Strategy {
        public static final DropLatest INSTANCE = new DropLatest();

        private DropLatest() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return false;
        }
    }

    public static final class DropOldest implements Strategy {
        public static final DropOldest INSTANCE = new DropOldest();

        private DropOldest() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return true;
        }
    }

    public static final class Error implements Strategy {
        public static final Error INSTANCE = new Error();

        private Error() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    static {
        Error error = Error.INSTANCE;
        ON_OVERFLOW_ERROR = error;
        ON_OVERFLOW_DEFAULT = error;
        ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
        ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }
}
