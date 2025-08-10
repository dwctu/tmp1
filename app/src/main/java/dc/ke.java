package dc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILicenseResultListener.java */
/* loaded from: classes.dex */
public interface ke extends IInterface {

    /* compiled from: ILicenseResultListener.java */
    public static abstract class a extends Binder implements ke {
        private static final String DESCRIPTOR = "com.android.vending.licensing.ILicenseResultListener";
        public static final int TRANSACTION_verifyLicense = 1;

        /* compiled from: ILicenseResultListener.java */
        /* renamed from: dc.ke$a$a, reason: collision with other inner class name */
        public static class C0195a implements ke {
            public static ke b;
            public IBinder a;

            public C0195a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ke)) ? new C0195a(iBinder) : (ke) iInterfaceQueryLocalInterface;
        }

        public static ke getDefaultImpl() {
            return C0195a.b;
        }

        public static boolean setDefaultImpl(ke keVar) {
            if (C0195a.b != null || keVar == null) {
                return false;
            }
            C0195a.b = keVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                verifyLicense(parcel.readInt(), parcel.readString(), parcel.readString());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void verifyLicense(int i, String str, String str2) throws RemoteException;
}
