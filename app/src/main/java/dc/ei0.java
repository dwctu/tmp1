package dc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* compiled from: GmsImpl.java */
/* loaded from: classes.dex */
public class ei0 implements wh0 {
    public final Context a;

    /* compiled from: GmsImpl.java */
    public class a implements mi0.a {
        public a(ei0 ei0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
            if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                xh0.a("User has disabled advertising identifier");
            }
            return iAdvertisingIdServiceAsInterface.getId();
        }
    }

    public ei0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e) {
            xh0.a(e);
            return false;
        }
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) {
        if (this.a == null || vh0Var == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        mi0.a(this.a, intent, vh0Var, new a(this));
    }
}
