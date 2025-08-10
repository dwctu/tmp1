package dc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import repeackage.com.android.creator.IdsSupplier;

/* compiled from: FreemeImpl.java */
/* loaded from: classes.dex */
public class di0 implements wh0 {
    public final Context a;

    /* compiled from: FreemeImpl.java */
    public class a implements mi0.a {
        public a(di0 di0Var) {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (idsSupplierAsInterface != null) {
                return idsSupplierAsInterface.getOAID();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public di0(Context context) {
        this.a = context;
    }

    @Override // dc.wh0
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
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
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        mi0.a(this.a, intent, vh0Var, new a(this));
    }
}
