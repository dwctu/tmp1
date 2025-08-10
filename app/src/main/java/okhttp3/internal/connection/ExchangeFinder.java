package okhttp3.internal.connection;

import dc.ac4;
import dc.cd4;
import dc.nc4;
import dc.sc4;
import dc.vb4;
import dc.vc4;
import java.io.IOException;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;

/* loaded from: classes5.dex */
public final class ExchangeFinder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final vb4 address;
    private final ac4 call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final nc4 eventListener;
    private boolean hasStreamFailure;
    private cd4 nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    public ExchangeFinder(Transmitter transmitter, RealConnectionPool realConnectionPool, vb4 vb4Var, ac4 ac4Var, nc4 nc4Var) {
        this.transmitter = transmitter;
        this.connectionPool = realConnectionPool;
        this.address = vb4Var;
        this.call = ac4Var;
        this.eventListener = nc4Var;
        this.routeSelector = new RouteSelector(vb4Var, realConnectionPool.routeDatabase, ac4Var, nc4Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private okhttp3.internal.connection.RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i, i2, i3, i4, z);
            synchronized (this.connectionPool) {
                if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                    return realConnectionFindConnection;
                }
                if (realConnectionFindConnection.isHealthy(z2)) {
                    return realConnectionFindConnection;
                }
                realConnectionFindConnection.noNewExchanges();
            }
        }
    }

    private boolean retryCurrentRoute() {
        RealConnection realConnection = this.transmitter.connection;
        return realConnection != null && realConnection.routeFailureCount == 0 && Util.sameConnection(realConnection.route().a().l(), this.address.l());
    }

    public RealConnection connectingConnection() {
        return this.connectingConnection;
    }

    public ExchangeCodec find(vc4 vc4Var, sc4.a aVar, boolean z) {
        try {
            return findHealthyConnection(aVar.connectTimeoutMillis(), aVar.readTimeoutMillis(), aVar.writeTimeoutMillis(), vc4Var.v(), vc4Var.B(), z).newCodec(vc4Var, aVar);
        } catch (IOException e) {
            trackFailure();
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure();
            throw e2;
        }
    }

    public boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            boolean z = true;
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                this.nextRouteToTry = this.transmitter.connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                z = false;
            }
            return z;
        }
    }

    public boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    public void trackFailure() {
        synchronized (this.connectionPool) {
            this.hasStreamFailure = true;
        }
    }
}
