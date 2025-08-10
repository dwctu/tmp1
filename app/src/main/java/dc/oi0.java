package dc;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import dc.mi0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import repeackage.com.heytap.openid.IOpenID;

/* compiled from: OppoImpl.java */
/* loaded from: classes.dex */
public class oi0 implements wh0 {
    public final Context a;
    public String b;

    /* compiled from: OppoImpl.java */
    public class a implements mi0.a {
        public a() {
        }

        @Override // dc.mi0.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return oi0.this.d(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public oi0(Context context) {
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
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
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
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        mi0.a(this.a, intent, vh0Var, new a());
    }

    public String c(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public String d(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.a.getPackageName();
        String str = this.b;
        if (str != null) {
            return c(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return c(iBinder, packageName, string);
    }
}
