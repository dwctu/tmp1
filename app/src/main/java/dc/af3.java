package dc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: LongRangeUtil.java */
/* loaded from: classes4.dex */
public class af3 {
    public static af3 b;
    public final Object a = new Object();

    /* compiled from: LongRangeUtil.java */
    public class a implements vt {
        public final /* synthetic */ Toy a;
        public final /* synthetic */ String b;
        public final /* synthetic */ MyApplication c;
        public final /* synthetic */ String d;

        public a(Toy toy, String str, MyApplication myApplication, String str2) {
            this.a = toy;
            this.b = str;
            this.c = myApplication;
            this.d = str2;
        }

        @Override // dc.vt
        public void a(int i, int i2, int i3) {
            synchronized (af3.this.a) {
                if (i != 0) {
                    this.a.setIsLongRange(2);
                    rp1.r("set Phy error : " + this.b.replace(SignatureImpl.INNER_SEP, "") + " status : " + i);
                } else if (i2 == 3 && i3 == 3) {
                    this.a.setIsLongRange(3);
                    this.c.G().readPhy(this.d);
                    rp1.q(this.b.replace(SignatureImpl.INNER_SEP, ""));
                } else {
                    this.a.setIsLongRange(2);
                }
            }
        }

        @Override // dc.vt
        public void b(int i, int i2, int i3) {
            synchronized (af3.this.a) {
                if (i != 0) {
                    this.a.setIsLongRange(2);
                    rp1.r("read Phy error : " + this.b.replace(SignatureImpl.INNER_SEP, "") + " status : " + i);
                } else if (i2 == 3 && i3 == 3) {
                    this.a.setIsLongRange(1);
                    rp1.p(this.b.replace(SignatureImpl.INNER_SEP, ""));
                } else if (this.a.getIsLongRange() == 0) {
                    this.c.G().setPreferredPhy(this.a.getAddress(), 4, 4, 0);
                } else {
                    this.a.setIsLongRange(2);
                }
            }
        }
    }

    public static af3 c() {
        if (b == null) {
            b = new af3();
        }
        return b;
    }

    public static int d() {
        MyApplication myApplication = WearUtils.x;
        if (myApplication == null) {
            return 0;
        }
        int i = myApplication.c;
        if (i != -1) {
            return i;
        }
        if (Build.VERSION.SDK_INT < 26) {
            myApplication.c = 0;
            return 0;
        }
        BluetoothAdapter adapter = ((BluetoothManager) myApplication.getSystemService("bluetooth")).getAdapter();
        if (adapter != null && adapter.isLe2MPhySupported() && adapter.isLeCodedPhySupported() && adapter.isLeExtendedAdvertisingSupported() && adapter.isLePeriodicAdvertisingSupported()) {
            myApplication.c = 1;
            return 1;
        }
        myApplication.c = 0;
        return 0;
    }

    public synchronized void b(String str, String str2, MyApplication myApplication) {
        if (myApplication.c == -1) {
            d();
        }
        if (myApplication.c == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Toy toyQ = myApplication.G().Q(str);
        if (toyQ != null && toyQ.getIsLongRange() != 1) {
            if (toyQ.isConnected()) {
                myApplication.G().b(str, new a(toyQ, str2, myApplication, str));
                myApplication.G().readPhy(str);
            }
        }
    }
}
