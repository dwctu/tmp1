package okhttp3.internal.connection;

import dc.ac4;
import dc.cd4;
import dc.nc4;
import dc.rc4;
import dc.vb4;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.internal.Util;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes5.dex */
public final class RouteSelector {
    private final vb4 address;
    private final ac4 call;
    private final nc4 eventListener;
    private int nextProxyIndex;
    private final RouteDatabase routeDatabase;
    private List<Proxy> proxies = Collections.emptyList();
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private final List<cd4> postponedRoutes = new ArrayList();

    public static final class Selection {
        private int nextRouteIndex = 0;
        private final List<cd4> routes;

        public Selection(List<cd4> list) {
            this.routes = list;
        }

        public List<cd4> getAll() {
            return new ArrayList(this.routes);
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public cd4 next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<cd4> list = this.routes;
            int i = this.nextRouteIndex;
            this.nextRouteIndex = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(vb4 vb4Var, RouteDatabase routeDatabase, ac4 ac4Var, nc4 nc4Var) {
        this.address = vb4Var;
        this.routeDatabase = routeDatabase;
        this.call = ac4Var;
        this.eventListener = nc4Var;
        resetNextProxy(vb4Var.l(), vb4Var.g());
    }

    public static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.l().n() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String strN;
        int iB;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strN = this.address.l().n();
            iB = this.address.l().B();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strN = getHostString(inetSocketAddress);
            iB = inetSocketAddress.getPort();
        }
        if (iB < 1 || iB > 65535) {
            throw new SocketException("No route to " + strN + SignatureImpl.INNER_SEP + iB + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(strN, iB));
            return;
        }
        this.eventListener.j(this.call, strN);
        List<InetAddress> listLookup = this.address.c().lookup(strN);
        if (listLookup.isEmpty()) {
            throw new UnknownHostException(this.address.c() + " returned no addresses for " + strN);
        }
        this.eventListener.i(this.call, strN, listLookup);
        int size = listLookup.size();
        for (int i = 0; i < size; i++) {
            this.inetSocketAddresses.add(new InetSocketAddress(listLookup.get(i), iB));
        }
    }

    private void resetNextProxy(rc4 rc4Var, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.address.i().select(rc4Var.H());
            this.proxies = (listSelect == null || listSelect.isEmpty()) ? Util.immutableList(Proxy.NO_PROXY) : Util.immutableList(listSelect);
        }
        this.nextProxyIndex = 0;
    }

    public boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public Selection next() throws IOException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (hasNextProxy()) {
            Proxy proxyNextProxy = nextProxy();
            int size = this.inetSocketAddresses.size();
            for (int i = 0; i < size; i++) {
                cd4 cd4Var = new cd4(this.address, proxyNextProxy, this.inetSocketAddresses.get(i));
                if (this.routeDatabase.shouldPostpone(cd4Var)) {
                    this.postponedRoutes.add(cd4Var);
                } else {
                    arrayList.add(cd4Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new Selection(arrayList);
    }
}
