package okhttp3.internal.connection;

import dc.ac4;
import dc.cc4;
import dc.ge4;
import dc.ld4;
import dc.nc4;
import dc.rc4;
import dc.sc4;
import dc.vb4;
import dc.vc4;
import dc.yc4;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* loaded from: classes5.dex */
public final class Transmitter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ac4 call;
    private Object callStackTrace;
    private boolean canceled;
    private final vc4 client;
    public RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final nc4 eventListener;
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean noMoreExchanges;
    private yc4 request;
    private final ld4 timeout;
    private boolean timeoutEarlyExit;

    public static final class TransmitterReference extends WeakReference<Transmitter> {
        public final Object callStackTrace;

        public TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            this.callStackTrace = obj;
        }
    }

    public Transmitter(vc4 vc4Var, ac4 ac4Var) {
        ld4 ld4Var = new ld4() { // from class: okhttp3.internal.connection.Transmitter.1
            @Override // dc.ld4
            public void timedOut() throws IOException {
                Transmitter.this.cancel();
            }
        };
        this.timeout = ld4Var;
        this.client = vc4Var;
        this.connectionPool = Internal.instance.realConnectionPool(vc4Var.g());
        this.call = ac4Var;
        this.eventListener = vc4Var.m().a(ac4Var);
        ld4Var.timeout(vc4Var.d(), TimeUnit.MILLISECONDS);
    }

    private vb4 createAddress(rc4 rc4Var) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierP;
        cc4 cc4VarE;
        if (rc4Var.o()) {
            SSLSocketFactory sSLSocketFactoryD = this.client.D();
            hostnameVerifierP = this.client.p();
            sSLSocketFactory = sSLSocketFactoryD;
            cc4VarE = this.client.e();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierP = null;
            cc4VarE = null;
        }
        return new vb4(rc4Var.n(), rc4Var.B(), this.client.l(), this.client.C(), sSLSocketFactory, hostnameVerifierP, cc4VarE, this.client.y(), this.client.x(), this.client.w(), this.client.h(), this.client.z());
    }

    private IOException maybeReleaseConnection(IOException iOException, boolean z) throws IOException {
        RealConnection realConnection;
        Socket socketReleaseConnectionNoEvents;
        boolean z2;
        synchronized (this.connectionPool) {
            if (z) {
                if (this.exchange != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            socketReleaseConnectionNoEvents = (realConnection != null && this.exchange == null && (z || this.noMoreExchanges)) ? releaseConnectionNoEvents() : null;
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = this.noMoreExchanges && this.exchange == null;
        }
        Util.closeQuietly(socketReleaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.h(this.call, realConnection);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = timeoutExit(iOException);
            if (z3) {
                this.eventListener.b(this.call, iOException);
            } else {
                this.eventListener.a(this.call);
            }
        }
        return iOException;
    }

    private IOException timeoutExit(IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void acquireConnectionNoEvents(RealConnection realConnection) {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        this.connection = realConnection;
        realConnection.transmitters.add(new TransmitterReference(this, this.callStackTrace));
    }

    public void callStart() {
        this.callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.c(this.call);
    }

    public boolean canRetry() {
        return this.exchangeFinder.hasStreamFailure() && this.exchangeFinder.hasRouteToTry();
    }

    public void cancel() throws IOException {
        Exchange exchange;
        RealConnection realConnectionConnectingConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange = this.exchange;
            ExchangeFinder exchangeFinder = this.exchangeFinder;
            realConnectionConnectingConnection = (exchangeFinder == null || exchangeFinder.connectingConnection() == null) ? this.connection : this.exchangeFinder.connectingConnection();
        }
        if (exchange != null) {
            exchange.cancel();
        } else if (realConnectionConnectingConnection != null) {
            realConnectionConnectingConnection.cancel();
        }
    }

    public void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException();
            }
            this.exchange = null;
        }
    }

    public IOException exchangeMessageDone(Exchange exchange, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        synchronized (this.connectionPool) {
            Exchange exchange2 = this.exchange;
            if (exchange != exchange2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.exchangeRequestDone;
                this.exchangeRequestDone = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.exchangeResponseDone) {
                    z3 = true;
                }
                this.exchangeResponseDone = true;
            }
            if (this.exchangeRequestDone && this.exchangeResponseDone && z3) {
                exchange2.connection().successCount++;
                this.exchange = null;
            } else {
                z4 = false;
            }
            return z4 ? maybeReleaseConnection(iOException, false) : iOException;
        }
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.exchange != null;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public Exchange newExchange(sc4.a aVar, boolean z) {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.exchange != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        Exchange exchange = new Exchange(this, this.call, this.eventListener, this.exchangeFinder, this.exchangeFinder.find(this.client, aVar, z));
        synchronized (this.connectionPool) {
            this.exchange = exchange;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange;
    }

    public IOException noMoreExchanges(IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public void prepareToConnect(yc4 yc4Var) throws IOException {
        yc4 yc4Var2 = this.request;
        if (yc4Var2 != null) {
            if (Util.sameConnection(yc4Var2.j(), yc4Var.j()) && this.exchangeFinder.hasRouteToTry()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            }
            if (this.exchangeFinder != null) {
                maybeReleaseConnection(null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = yc4Var;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(yc4Var.j()), this.call, this.eventListener);
    }

    public Socket releaseConnectionNoEvents() {
        int i = 0;
        int size = this.connection.transmitters.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.connection.transmitters.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        RealConnection realConnection = this.connection;
        realConnection.transmitters.remove(i);
        this.connection = null;
        if (!realConnection.transmitters.isEmpty()) {
            return null;
        }
        realConnection.idleAtNanos = System.nanoTime();
        if (this.connectionPool.connectionBecameIdle(realConnection)) {
            return realConnection.socket();
        }
        return null;
    }

    public ge4 timeout() {
        return this.timeout;
    }

    public void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException();
        }
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }

    public void timeoutEnter() {
        this.timeout.enter();
    }
}
