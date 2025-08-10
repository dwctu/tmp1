package com.hihonor.ads.identifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.hihonor.ads.identifier.AdvertisingIdClient;
import dc.i51;
import dc.j51;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class a implements ServiceConnection {
    public AdvertisingIdClient.Info a;
    public Context b;
    public BinderC0048a c = new BinderC0048a();
    public b d = new b();
    public CountDownLatch e = new CountDownLatch(2);

    /* renamed from: com.hihonor.ads.identifier.a$a, reason: collision with other inner class name */
    public class BinderC0048a extends i51.a {
        public BinderC0048a() {
        }

        @Override // dc.i51
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // dc.i51
        public void a(int i, Bundle bundle) {
            String str = "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle;
            if (i != 0 || bundle == null) {
                String str2 = "OAIDCallBack handleResult error retCode=$ " + i;
            } else if (a.this.a != null) {
                a.this.a.id = bundle.getString("oa_id_flag");
            }
            a.this.e.countDown();
        }
    }

    public class b extends i51.a {
        public b() {
        }

        @Override // dc.i51
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // dc.i51
        public void a(int i, Bundle bundle) {
            StringBuilder sb;
            String str = "OAIDCallBack handleResult retCode=" + i + " retInfo= " + bundle;
            if (i == 0 && bundle != null) {
                if (a.this.a != null) {
                    boolean z = bundle.getBoolean("oa_id_limit_state");
                    a.this.a.isLimit = z;
                    sb = new StringBuilder();
                    sb.append("OAIDLimitCallback handleResult success  isLimit=");
                    sb.append(z);
                }
                a.this.e.countDown();
            }
            sb = new StringBuilder();
            sb.append("OAIDLimitCallback handleResult error retCode= ");
            sb.append(i);
            sb.toString();
            a.this.e.countDown();
        }
    }

    public final void a() {
        try {
            this.b.unbindService(this);
        } catch (Exception e) {
            String str = "OAIDClientImpl#disconnect#Disconnect error::" + e.getMessage();
        }
    }

    public boolean a(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.hihonor.id", 0);
            new Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !r5.queryIntentServices(r2, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        j51 c0189a;
        try {
            this.a = new AdvertisingIdClient.Info();
            int i = j51.a.a;
            if (iBinder == null) {
                c0189a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                c0189a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof j51)) ? new j51.a.C0189a(iBinder) : (j51) iInterfaceQueryLocalInterface;
            }
            c0189a.c(this.c);
            c0189a.b(this.d);
        } catch (Exception e) {
            String str = "onServiceConnected error:" + e.getMessage();
            this.e.countDown();
            this.e.countDown();
            a();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.e.countDown();
        this.e.countDown();
    }
}
