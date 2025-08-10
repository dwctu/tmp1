package dc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.bun.lib.MsaIdInterface;

/* compiled from: MsaImpl.java */
/* loaded from: classes.dex */
public class ji0 implements wh0 {
    public final Context a;

    /* compiled from: MsaImpl.java */
    public class a implements mi0.a {
        public a(ji0 ji0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public ji0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
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
        c();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        mi0.a(this.a, intent, vh0Var, new a(this));
    }

    public final void c() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
            }
        } catch (Exception e) {
            xh0.a(e);
        }
    }
}
