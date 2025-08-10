package com.dx.log.logapplication.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;

/* loaded from: classes.dex */
public interface ILogRemoteAidlInterface extends IInterface {

    public static abstract class a extends Binder implements ILogRemoteAidlInterface {

        /* renamed from: com.dx.log.logapplication.service.ILogRemoteAidlInterface$a$a, reason: collision with other inner class name */
        public static class C0013a implements ILogRemoteAidlInterface {
            public IBinder a;

            public C0013a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.dx.log.logapplication.service.ILogRemoteAidlInterface
            public void d(CharSequence charSequence, CharSequence charSequence2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence2 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence2, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.dx.log.logapplication.service.ILogRemoteAidlInterface
            public void hideWindow() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.dx.log.logapplication.service.ILogRemoteAidlInterface
            public void postWsUrl(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.dx.log.logapplication.service.ILogRemoteAidlInterface
            public void println(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence2 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence2, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence3 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence3, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence4 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence4, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.dx.log.logapplication.service.ILogRemoteAidlInterface
            public void printlnTag(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence2 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence2, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence3 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence3, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (charSequence4 != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence4, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.dx.log.logapplication.service.ILogRemoteAidlInterface
            public void showWindow() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ILogRemoteAidlInterface d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.dx.log.logapplication.service.ILogRemoteAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILogRemoteAidlInterface)) ? new C0013a(iBinder) : (ILogRemoteAidlInterface) iInterfaceQueryLocalInterface;
        }
    }

    void d(CharSequence charSequence, CharSequence charSequence2) throws RemoteException;

    void hideWindow() throws RemoteException;

    void postWsUrl(String str, int i, String str2) throws RemoteException;

    void println(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) throws RemoteException;

    void printlnTag(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) throws RemoteException;

    void showWindow() throws RemoteException;
}
