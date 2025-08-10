package org.jivesoftware.smack;

import java.lang.Exception;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.PlainStreamElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.TopLevelStreamElement;

/* loaded from: classes5.dex */
public class SynchronizationPoint<E extends Exception> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(SynchronizationPoint.class.getName());
    private final Condition condition;
    private final AbstractXMPPConnection connection;
    private final Lock connectionLock;
    private E failureException;
    private State state;

    /* renamed from: org.jivesoftware.smack.SynchronizationPoint$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State = iArr;
            try {
                iArr[State.Failure.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State[State.Initial.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State[State.NoResponse.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State[State.RequestSent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        Initial,
        RequestSent,
        NoResponse,
        Success,
        Failure
    }

    public SynchronizationPoint(AbstractXMPPConnection abstractXMPPConnection) {
        this.connection = abstractXMPPConnection;
        this.connectionLock = abstractXMPPConnection.getConnectionLock();
        this.condition = abstractXMPPConnection.getConnectionLock().newCondition();
        init();
    }

    private void checkForResponse() throws SmackException.NoResponseException {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State[this.state.ordinal()];
        if (i == 2 || i == 3 || i == 4) {
            throw SmackException.NoResponseException.newWith(this.connection);
        }
    }

    private void waitForConditionOrTimeout() throws InterruptedException {
        long nanos = TimeUnit.MILLISECONDS.toNanos(this.connection.getPacketReplyTimeout());
        while (true) {
            State state = this.state;
            if (state != State.RequestSent && state != State.Initial) {
                return;
            }
            if (nanos <= 0) {
                this.state = State.NoResponse;
                return;
            } else {
                try {
                    nanos = this.condition.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.WARNING, "Thread interrupt while waiting for condition or timeout ignored", (Throwable) e);
                }
            }
            LOGGER.log(Level.WARNING, "Thread interrupt while waiting for condition or timeout ignored", (Throwable) e);
        }
    }

    public void checkIfSuccessOrWait() throws SmackException.NoResponseException {
        this.connectionLock.lock();
        try {
            if (this.state == State.Success) {
                return;
            }
            waitForConditionOrTimeout();
            this.connectionLock.unlock();
            checkForResponse();
        } finally {
            this.connectionLock.unlock();
        }
    }

    public void checkIfSuccessOrWaitOrThrow() throws Exception {
        checkIfSuccessOrWait();
        if (this.state == State.Failure) {
            throw this.failureException;
        }
    }

    public void init() {
        this.connectionLock.lock();
        this.state = State.Initial;
        this.failureException = null;
        this.connectionLock.unlock();
    }

    @Deprecated
    public void reportFailure() {
        reportFailure(null);
    }

    public void reportSuccess() {
        this.connectionLock.lock();
        try {
            this.state = State.Success;
            this.condition.signalAll();
        } finally {
            this.connectionLock.unlock();
        }
    }

    public boolean requestSent() {
        this.connectionLock.lock();
        try {
            return this.state == State.RequestSent;
        } finally {
            this.connectionLock.unlock();
        }
    }

    public void sendAndWaitForResponse(TopLevelStreamElement topLevelStreamElement) throws SmackException.NotConnectedException, SmackException.NoResponseException {
        this.connectionLock.lock();
        if (topLevelStreamElement != null) {
            try {
                if (topLevelStreamElement instanceof Stanza) {
                    this.connection.sendStanza((Stanza) topLevelStreamElement);
                } else {
                    if (!(topLevelStreamElement instanceof PlainStreamElement)) {
                        throw new IllegalStateException("Unsupported element type");
                    }
                    this.connection.send((PlainStreamElement) topLevelStreamElement);
                }
                this.state = State.RequestSent;
            } catch (Throwable th) {
                this.connectionLock.unlock();
                throw th;
            }
        }
        waitForConditionOrTimeout();
        this.connectionLock.unlock();
        checkForResponse();
    }

    public void sendAndWaitForResponseOrThrow(PlainStreamElement plainStreamElement) throws Exception {
        E e;
        sendAndWaitForResponse(plainStreamElement);
        if (AnonymousClass1.$SwitchMap$org$jivesoftware$smack$SynchronizationPoint$State[this.state.ordinal()] == 1 && (e = this.failureException) != null) {
            throw e;
        }
    }

    public boolean wasSuccessful() {
        this.connectionLock.lock();
        try {
            return this.state == State.Success;
        } finally {
            this.connectionLock.unlock();
        }
    }

    public void reportFailure(E e) {
        this.connectionLock.lock();
        try {
            this.state = State.Failure;
            this.failureException = e;
            this.condition.signalAll();
        } finally {
            this.connectionLock.unlock();
        }
    }
}
