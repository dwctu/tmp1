package dc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* compiled from: AsusImpl.java */
/* loaded from: classes.dex */
public class zh0 implements wh0 {
    public final Context a;

    /* compiled from: AsusImpl.java */
    public class a implements mi0.a {
        public a(zh0 zh0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (iDidAidlInterfaceAsInterface == null) {
                throw new OAIDException("IDidAidlInterface is null");
            }
            if (iDidAidlInterfaceAsInterface.isSupport()) {
                return iDidAidlInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public zh0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
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
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        mi0.a(this.a, intent, vh0Var, new a(this));
    }
}
