package dc;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import dc.kn;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class nn implements ln {
    @Override // dc.ln
    @NonNull
    public kn a(@NonNull Context context, @NonNull kn.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        return z ? new mn(context, aVar) : new rn();
    }
}
