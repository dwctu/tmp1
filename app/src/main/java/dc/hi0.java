package dc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* compiled from: LenovoImpl.java */
/* loaded from: classes.dex */
public class hi0 implements wh0 {
    public final Context a;

    /* compiled from: LenovoImpl.java */
    public class a implements mi0.a {
        public a(hi0 hi0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface == null) {
                throw new OAIDException("IDeviceidInterface is null");
            }
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public hi0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
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
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        mi0.a(this.a, intent, vh0Var, new a(this));
    }
}
