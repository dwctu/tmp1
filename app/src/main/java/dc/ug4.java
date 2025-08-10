package dc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IOAIDInterface.java */
/* loaded from: classes5.dex */
public interface ug4 extends IInterface {

    /* compiled from: IOAIDInterface.java */
    public static abstract class a extends Binder implements ug4 {

        /* compiled from: IOAIDInterface.java */
        /* renamed from: dc.ug4$a$a, reason: collision with other inner class name */
        public static class C0223a implements ug4 {
            public static ug4 b;
            public IBinder a;

            public C0223a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // dc.ug4
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qiku.id.IOAIDInterface");
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0) && a.e() != null) {
                        return a.e().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ug4 d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.qiku.id.IOAIDInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ug4)) ? new C0223a(iBinder) : (ug4) iInterfaceQueryLocalInterface;
        }

        public static ug4 e() {
            return C0223a.b;
        }
    }

    String getOAID() throws RemoteException;
}
