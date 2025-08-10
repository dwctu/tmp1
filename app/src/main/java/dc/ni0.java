package dc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.oplus.stdid.IStdID;

/* compiled from: OppoExtImpl.java */
/* loaded from: classes.dex */
public class ni0 extends oi0 {
    public final Context c;

    /* compiled from: OppoExtImpl.java */
    public class a implements mi0.a {
        public a() {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return ni0.this.d(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public ni0(Context context) {
        super(context);
        this.c = context;
    }

    @Override // dc.oi0, dc.wh0
    public boolean a() {
        Context context = this.c;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null;
        } catch (Exception e) {
            xh0.a(e);
            return false;
        }
    }

    @Override // dc.oi0, dc.wh0
    public void b(vh0 vh0Var) {
        if (this.c == null || vh0Var == null) {
            return;
        }
        Intent intent = new Intent("action.com.oplus.stdid.ID_SERVICE");
        intent.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
        mi0.a(this.c, intent, vh0Var, new a());
    }

    @Override // dc.oi0
    public String c(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IStdID is null");
    }
}
