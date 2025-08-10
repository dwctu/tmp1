package dc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: INotificationTimerAIDL.java */
/* loaded from: classes3.dex */
public interface bp1 extends IInterface {

    /* compiled from: INotificationTimerAIDL.java */
    public static abstract class a extends Binder implements bp1 {
        public a() {
            attachInterface(this, "com.wear.backgroundservice.INotificationTimerAIDL");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.wear.backgroundservice.INotificationTimerAIDL");
                n();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.wear.backgroundservice.INotificationTimerAIDL");
                o(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.wear.backgroundservice.INotificationTimerAIDL");
                q(parcel.readLong());
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.wear.backgroundservice.INotificationTimerAIDL");
                int pid = getPid();
                parcel2.writeNoException();
                parcel2.writeInt(pid);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.wear.backgroundservice.INotificationTimerAIDL");
                return true;
            }
            parcel.enforceInterface("com.wear.backgroundservice.INotificationTimerAIDL");
            boolean zP = p();
            parcel2.writeNoException();
            parcel2.writeInt(zP ? 1 : 0);
            return true;
        }
    }

    int getPid() throws RemoteException;

    void n() throws RemoteException;

    void o(boolean z) throws RemoteException;

    boolean p() throws RemoteException;

    void q(long j) throws RemoteException;
}
