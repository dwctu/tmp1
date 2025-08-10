package dc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;

/* compiled from: OAIDService.java */
/* loaded from: classes.dex */
public class mi0 implements ServiceConnection {
    public final Context a;
    public final vh0 b;
    public final a c;

    /* compiled from: OAIDService.java */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public mi0(Context context, vh0 vh0Var, a aVar) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
        this.b = vh0Var;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, vh0 vh0Var, a aVar) {
        new mi0(context, vh0Var, aVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (!this.a.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            xh0.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.b(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        xh0.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new OAIDException("OAID/AAID acquire failed");
                    }
                    xh0.a("OAID/AAID acquire success: " + strA);
                    this.b.a(strA);
                    this.a.unbindService(this);
                    xh0.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    xh0.a(e);
                    this.b.b(e);
                    this.a.unbindService(this);
                    xh0.a("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Exception e2) {
                xh0.a(e2);
            }
        } catch (Throwable th) {
            try {
                this.a.unbindService(this);
                xh0.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                xh0.a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        xh0.a("Service has been disconnected: " + componentName.getClassName());
    }
}
