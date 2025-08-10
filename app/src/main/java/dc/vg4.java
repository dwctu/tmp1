package dc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.lang.reflect.Method;

/* compiled from: QikuIdmanager.java */
/* loaded from: classes5.dex */
public class vg4 {
    public static int b = 2;
    public static int c = 4;
    public IBinder a;

    public vg4() throws ClassNotFoundException {
        Class<?> cls;
        Method declaredMethod;
        this.a = null;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            if (!((String) cls2.getMethod("get", String.class, String.class).invoke(cls2, "ro.build.uiversion", "")).contains("360UI") || (cls = Class.forName("android.os.ServiceManager")) == null || (declaredMethod = cls.getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.a = (IBinder) declaredMethod.invoke(null, "qikuid");
        } catch (Exception unused) {
        }
    }

    public String a() {
        if (this.a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(c, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public boolean b() {
        if (this.a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.a.transact(b, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readInt() == 1;
            } catch (RemoteException e) {
                e.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }
}
