package dc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import dc.ug4;

/* compiled from: QikuImpl.java */
/* loaded from: classes.dex */
public class pi0 implements wh0 {
    public final Context a;
    public boolean b = true;

    /* compiled from: QikuImpl.java */
    public class a implements mi0.a {
        public a(pi0 pi0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            ug4 ug4VarD = ug4.a.d(iBinder);
            if (ug4VarD != null) {
                return ug4VarD.getOAID();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public pi0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.qiku.id", 0) != null) {
                return true;
            }
            this.b = false;
            return new vg4().b();
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
        if (this.b) {
            Intent intent = new Intent("qiku.service.action.id");
            intent.setPackage("com.qiku.id");
            mi0.a(this.a, intent, vh0Var, new a(this));
            return;
        }
        try {
            String strA = new vg4().a();
            if (strA == null || strA.length() == 0) {
                throw new OAIDException("OAID/AAID acquire failed");
            }
            vh0Var.a(strA);
        } catch (Exception e) {
            vh0Var.b(e);
        }
    }
}
