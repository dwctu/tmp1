package dc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import dc.i51;

/* loaded from: classes2.dex */
public interface j51 extends IInterface {

    public static abstract class a extends Binder implements j51 {
        public static final /* synthetic */ int a = 0;

        /* renamed from: dc.j51$a$a, reason: collision with other inner class name */
        public static class C0189a implements j51 {
            public IBinder a;

            public C0189a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // dc.j51
            public void b(i51 i51Var) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(i51Var != null ? (i51.a) i51Var : null);
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = a.a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // dc.j51
            public void c(i51 i51Var) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(i51Var != null ? (i51.a) i51Var : null);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = a.a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    void b(i51 i51Var);

    void c(i51 i51Var);
}
