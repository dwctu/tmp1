package okhttp3.internal.connection;

import dc.cd4;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class RouteDatabase {
    private final Set<cd4> failedRoutes = new LinkedHashSet();

    public synchronized void connected(cd4 cd4Var) {
        this.failedRoutes.remove(cd4Var);
    }

    public synchronized void failed(cd4 cd4Var) {
        this.failedRoutes.add(cd4Var);
    }

    public synchronized boolean shouldPostpone(cd4 cd4Var) {
        return this.failedRoutes.contains(cd4Var);
    }
}
