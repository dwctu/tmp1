package dc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import dc.kn;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
public final class mn implements kn {
    public final Context a;
    public final kn.a b;
    public boolean c;
    public boolean d;
    public final BroadcastReceiver e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            mn mnVar = mn.this;
            boolean z = mnVar.c;
            mnVar.c = mnVar.c(context);
            if (z != mn.this.c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    String str = "connectivity changed, isConnected: " + mn.this.c;
                }
                mn mnVar2 = mn.this;
                mnVar2.b.a(mnVar2.c);
            }
        }
    }

    public mn(@NonNull Context context, @NonNull kn.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    @SuppressLint({"MissingPermission"})
    public boolean c(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        vp.d(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    public final void d() {
        if (this.d) {
            return;
        }
        this.c = c(this.a);
        try {
            this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        } catch (SecurityException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
        }
    }

    public final void j() {
        if (this.d) {
            this.a.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    @Override // dc.qn
    public void onDestroy() {
    }

    @Override // dc.qn
    public void onStart() {
        d();
    }

    @Override // dc.qn
    public void onStop() {
        j();
    }
}
