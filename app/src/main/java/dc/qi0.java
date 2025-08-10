package dc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.samsung.android.deviceidservice.IDeviceIdService;

/* compiled from: SamsungImpl.java */
/* loaded from: classes.dex */
public class qi0 implements wh0 {
    public final Context a;

    /* compiled from: SamsungImpl.java */
    public class a implements mi0.a {
        public a(qi0 qi0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (iDeviceIdServiceAsInterface != null) {
                return iDeviceIdServiceAsInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public qi0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
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
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        mi0.a(this.a, intent, vh0Var, new a(this));
    }
}
