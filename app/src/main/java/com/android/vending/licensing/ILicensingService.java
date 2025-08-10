package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import dc.ke;

/* loaded from: classes.dex */
public interface ILicensingService extends IInterface {

    public static abstract class a extends Binder implements ILicensingService {

        /* renamed from: com.android.vending.licensing.ILicensingService$a$a, reason: collision with other inner class name */
        public static class C0011a implements ILicensingService {
            public static ILicensingService b;
            public IBinder a;

            public C0011a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.android.vending.licensing.ILicensingService
            public void a(long j, String str, ke keVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(keVar != null ? keVar.asBinder() : null);
                    if (this.a.transact(1, parcelObtain, null, 1) || a.e() == null) {
                        return;
                    }
                    a.e().a(j, str, keVar);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static ILicensingService d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILicensingService)) ? new C0011a(iBinder) : (ILicensingService) iInterfaceQueryLocalInterface;
        }

        public static ILicensingService e() {
            return C0011a.b;
        }
    }

    void a(long j, String str, ke keVar) throws RemoteException;
}
