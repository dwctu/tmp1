package dc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* compiled from: CoolpadImpl.java */
/* loaded from: classes.dex */
public class ai0 implements wh0 {
    public final Context a;

    /* compiled from: CoolpadImpl.java */
    public class a implements mi0.a {
        public a() {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(ai0.this.a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public ai0(Context context) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
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
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        mi0.a(this.a, intent, vh0Var, new a());
    }
}
